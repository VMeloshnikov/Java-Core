import Accessories.Cpu.CPU_NAME;
import Accessories.Cpu.Cpu;
import Accessories.HardDrive.HardDrive;
import Accessories.HardDrive.HardDriveType;
import Accessories.Keyboard.Keyboard;
import Accessories.Keyboard.KeyboardBackLight;
import Accessories.Keyboard.KeyboardType;
import Accessories.Memory.Memory;
import Accessories.Memory.MemoryType;
import Accessories.Monitor.Monitor;
import Accessories.Monitor.MonitorType;

public class ObjectsAndClasses_StaticFinal {
    public static void main(String[] args) {

        Computer secondComputer = new Computer(new Cpu(2.4, 8, 120, CPU_NAME.INTEL)
                , new Memory(2*256, 200, MemoryType.DDR_III)
                , new HardDrive(512, 600, HardDriveType.SSD)
                , new Monitor(27, 2400, MonitorType.IPS)
                , new Keyboard(200, KeyboardType.BLUETOOTH, KeyboardBackLight.YES)
                , "HP"
                , "Office");



        Computer first = new Computer(new Cpu(3.2, 32, 60, CPU_NAME.ЭЛЬБРУС)
                , new Memory(4*1024, 200, MemoryType.DDR_III)
                , new HardDrive(512, 600, HardDriveType.SSD)
                , new Monitor(27, 2400, MonitorType.IPS)
                , new Keyboard(200, KeyboardType.BLUETOOTH, KeyboardBackLight.YES)
                , "Lenovo"
                , "Home");

        System.out.println(secondComputer + "Вес компьютера: " + Computer.getWeight(secondComputer) + "-гр.\n");
        System.out.println(first + "Вес компьютера: " + Computer.getWeight(first) + "-гр.\n");

    }

}
