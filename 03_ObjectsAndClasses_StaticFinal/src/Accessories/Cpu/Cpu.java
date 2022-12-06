package Accessories.Cpu;

public class Cpu {

    private final double coreSpeedCpu;
    private final int numberCore;
    private final int weightCpu;
    private final CPU_NAME cpuName;

    public Cpu(double coreSpeedCpu, int numberCore, int weightCpu, CPU_NAME cpuName) {

        this.coreSpeedCpu = coreSpeedCpu;
        this.numberCore = numberCore;
        this.weightCpu = weightCpu;
        this.cpuName = cpuName;
    }

    public double getCoreSpeedCpu() {
        return coreSpeedCpu;
    }

    public int getNumberCore() {
        return numberCore;
    }

    public int getWeightCpu() {
        return weightCpu;
    }

    public CPU_NAME getCpuName() {
        return cpuName;
    }

    @Override
    public String toString() {
        return  "Частота процесора: " + coreSpeedCpu +
                ", Количество ядер: " + numberCore +
                ", Вес процессора: " + weightCpu + " гр." +
                ", Производитель: " + cpuName;
    }
}

