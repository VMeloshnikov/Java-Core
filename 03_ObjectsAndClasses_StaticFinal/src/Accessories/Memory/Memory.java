package Accessories.Memory;

public class Memory {

    private final int memoryVolume;
    private final int memoryWeight;
    private final MemoryType memory;


    public Memory(int volumeMemory, int weightMemory, MemoryType memory) {
        this.memoryVolume = volumeMemory;
        this.memoryWeight = weightMemory;
        this.memory = memory;
    }

    public int getMemoryVolume() {
        return memoryVolume;
    }

    public int getMemoryWeight() {
        return memoryWeight;
    }

    public MemoryType getMemory() {
        return memory;
    }

    @Override
    public String toString() {
        return "Объем памяти: " + memoryVolume +
                ", Тип памяти: " + memory +
                ", Вес памяти: " + memoryWeight + " гр.";
    }

}
