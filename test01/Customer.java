package test01;

public class Customer {
    private int id;
    private Status status;
    private double arriveTime;
    private double startService;
    private double endService;

    public Customer(int id) {
        this.id = id;
        this.status = Status.WAITING;
        this.arriveTime = System.currentTimeMillis();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(double arriveTime) {
        this.arriveTime = arriveTime;
    }

    public double getStartService() {
        return startService;
    }

    public void setStartService(double startService) {
        this.startService = startService;
    }

    public double getEndService() {
        return endService;
    }

    public void setEndService(double endService) {
        this.endService = endService;
    }

    @Override
    public String toString() {
        return "Cliente: " + id + 
        "\nStatus: " + status + 
        "\nTempo de chegada: " + arriveTime;
    }

}
