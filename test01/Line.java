package test01;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Line {
    private List<Customer> customers = new ArrayList<>();
    private List<Customer> finished = new ArrayList<>();
    private boolean closed = false;

    public synchronized void add(Customer customer) {
        customers.add(customer);
        System.out.println("Cliente " + customer.getId() + " chegou. Total de clientes: " + customers.size());
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
        System.out.println("  Total processado: " + total + " clientes");
        System.out.println("  Tempo total: " + String.format("%.2f", duration / 60000.0) + " min");
        System.out.println("  Taxa: " + String.format("%.2f", rate) + " clientes/min");
    }

    private void printResponseTimes() {
        double[] waits = finished.stream()
                .mapToDouble(c -> c.getStartService() - c.getArriveTime())
                .toArray();

        double minWait = Arrays.stream(waits).min().orElse(0);
        double maxWait = Arrays.stream(waits).max().orElse(0);
        double avgWait = Arrays.stream(waits).average().orElse(0);

        double[] services = finished.stream()
                .mapToDouble(c -> c.getEndService() - c.getStartService())
                .toArray();

        double minService = Arrays.stream(services).min().orElse(0);
        double maxService = Arrays.stream(services).max().orElse(0);
        double avgService = Arrays.stream(services).average().orElse(0);

        System.out.println("Tempos de resposta");
        System.out.println("  Espera em fila:");
        System.out.println("    Min: " + String.format("%.3f", minWait / 1000) + "s | Max: " + String.format("%.3f", maxWait / 1000) + "s | Média: " + String.format("%.3f", avgWait / 1000) + "s");
        System.out.println("  Atendimento:");
        System.out.println("    Min: " + String.format("%.3f", minService / 1000) + "s | Max: " + String.format("%.3f", maxService / 1000) + "s | Média: " + String.format("%.3f", avgService / 1000) + "s");
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
                .filter(c -> (c.getStartService() - c.getArriveTime()) <= 12000)
                .count();
        double percent = (within * 100.0) / finished.size();
        double avgWait = finished.stream()
                .mapToDouble(c -> c.getStartService() - c.getArriveTime())
                .average()
                .orElse(0);

        System.out.println("Nível de serviço");
        System.out.println("  Tempo médio de espera: " + String.format("%.3f", avgWait / 1000) + "s");
        System.out.println("  Atendidos dentro da meta: " + within + "/" + finished.size() + " (" + String.format("%.1f", percent) + "%)");
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
