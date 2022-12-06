package Accessories.Monitor;

public class Monitor {

    private final double diagonal;
    private final int monitorWeight;
    private final MonitorType monitor;

    public Monitor(double diagonal, int monitorWeight, MonitorType monitor) {
        this.diagonal = diagonal;
        this.monitorWeight = monitorWeight;
        this.monitor = monitor;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public int getMonitorWeight() {
        return monitorWeight;
    }

    public MonitorType getMonitor() {
        return monitor;
    }

    @Override
    public String toString() {
        return  "Диагональ: " + diagonal +
                ", Тип матрицы: " + monitor +
                ", Вес монитора: " + monitorWeight + " гр.";
    }
}
