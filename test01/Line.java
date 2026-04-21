package test01;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Line {
    private List<Customer> customers = new ArrayList<>();
    private List<Customer> finished = new ArrayList<>();
    private boolean closed = false;
    private static final int GOAL = 120000;

    public synchronized void add(Customer customer) {
        customers.add(customer);
        System.out.println("[Fila] Cliente #" + customer.getId() + " chegou | Tamanho: " + customers.size());
        notifyAll();
    }

    public synchronized Customer pick() {
        while (customers.isEmpty() && !closed) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }

        if (customers.isEmpty() && closed) {
            return null;
        }

        return customers.removeFirst();
    }

    public synchronized void finish(Customer customer) {
        finished.add(customer);
    }

    public synchronized void close() {
        closed = true;
        notifyAll();
    }

    public synchronized void printResults() {
        if (finished.isEmpty()) {
            System.out.println("Sem clientes para análise.");
            return;
        }

        System.out.println();
        printThroughput();
        System.out.println();
        printResponseTimes();
        System.out.println();
        printLeadTime();
        System.out.println();
        printServiceLevel();
    }

    private void printThroughput() {
        long duration = getOperationTime();
        int total = finished.size();
        double rate;

        if (duration > 0) {
            rate = (total * 60000.0) / duration;
        } else {
            rate = 0;
        }

        System.out.println("Throughput");
        System.out.println("  Clientes processados: " + total);
        System.out.println("  Tempo total: " + (duration / 60000.0));
        System.out.println("  Taxa: " + rate);
    }

    private void printResponseTimes() {
        double[] waits = finished.stream()
                .mapToDouble(c -> c.getStartService() - c.getArriveTime())
                .toArray();

        double minWait = Arrays.stream(waits).min().orElse(0);
        double maxWait = Arrays.stream(waits).max().orElse(0);

        double[] services = finished.stream()
                .mapToDouble(c -> c.getEndService() - c.getStartService())
                .toArray();

        double minService = Arrays.stream(services).min().orElse(0);
        double maxService = Arrays.stream(services).max().orElse(0);

        System.out.println("Tempos de resposta");
        System.out.println("  Espera em fila - Min: " + minWait / 1000 + "Max: " + maxWait / 1000);
        System.out.println("  Atendimento - Min: " + minService / 1000 + "Max: " + maxService / 1000);
    }

    private void printLeadTime() {
        double avg = finished.stream()
                .mapToDouble(c -> c.getEndService() - c.getArriveTime())
                .average()
                .orElse(0);

        System.out.println("Lead time: " + avg / 1000);
    }

    private void printServiceLevel() {
        int within = (int) finished.stream()
                .filter(c -> (c.getStartService() - c.getArriveTime()) <= GOAL)
                .count();
        double percent = (within * 100.0) / finished.size();
        double avgWait = finished.stream()
                .mapToDouble(c -> c.getStartService() - c.getArriveTime())
                .average()
                .orElse(0);

        System.out.println("Nível de serviço");
        System.out.println("  Tempo médio espera: " + (avgWait / 1000));
        System.out.println("  Atendidos dentro da meta: " + within + "/" + finished.size() + " (" + percent + "%)");
        if (percent >= 80) {
            System.out.println("  Meta atingida");
        } else {
            System.out.println("  Meta não atingida");
        }
    }

    private long getOperationTime() {
        if (finished.isEmpty())
            return 0;
        double start = finished.get(0).getArriveTime();
        double end = finished.get(finished.size() - 1).getEndService();
        return (long) (end - start);
    }
}
