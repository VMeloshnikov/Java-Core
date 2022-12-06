import Accessories.Cpu.Cpu;
import Accessories.HardDrive.HardDrive;
import Accessories.Keyboard.Keyboard;
import Accessories.Memory.Memory;
import Accessories.Monitor.Monitor;

public class Computer {

    private final Cpu processor;
    private final Memory memory;
    private final HardDrive hardDrive;
    private final Monitor monitor;
    private final Keyboard keyboard;
    private final String vendor;
    private final String computerName;

    public Computer(Cpu processor, Memory memory,
                    HardDrive hardDrive, Monitor monitor,
                    Keyboard keyboard, String vendor,
                    String computerName) {
        this.processor = processor;
        this.memory = memory;
        this.hardDrive = hardDrive;
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.vendor = vendor;
        this.computerName = computerName;
    }

    public Cpu getProcessor() {
        return processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public String getVendor() {
        return vendor;
    }

    public String getComputerName() {
        return computerName;
    }

    public static int getWeight(Computer computer){

        return computer.getKeyboard().getWeightKeyboard()
                + computer.getHardDrive().getHardDriveWeight()
                + computer.getMonitor().getMonitorWeight()
                + computer.getMemory().getMemoryWeight()
                + computer.getProcessor().getWeightCpu();
    }

    @Override
    public String toString() {
        return "Компьютер: " + getVendor() + "  Модель: " + getComputerName() +
                "\nПроцессор: " + getProcessor() +
                "\nОперативная память: " + getMemory() +
                "\nЖесткий диск: " + getHardDrive() +
                "\nМонитор: " + getMonitor() +
                "\nКлавиатура: " + getKeyboard() + "\n";

    }

}
