package Accessories.HardDrive;

public class HardDrive {

    private final int HardDriveVolume;
    private final int HardDriveWeight;
    private final HardDriveType hardDrive;

    public HardDrive(int volumeHardDrive, int weightHardDrive, HardDriveType hardDrive) {
        this.HardDriveVolume = volumeHardDrive;
        this.HardDriveWeight = weightHardDrive;
        this.hardDrive = hardDrive;
    }

    public int getHardDriveVolume() {
        return HardDriveVolume;
    }

    public int getHardDriveWeight() {
        return HardDriveWeight;
    }

    public HardDriveType getHardDrive() {
        return hardDrive;
    }

    @Override
    public String toString() {
        return  " Объем диска: " + HardDriveVolume +
                ", Тип диска: " + hardDrive +
                ", Вес диска: " + HardDriveWeight + " гр.";
    }
}
