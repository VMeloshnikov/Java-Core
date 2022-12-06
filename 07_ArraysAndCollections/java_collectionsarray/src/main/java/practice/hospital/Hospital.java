package practice.hospital;

import java.util.Locale;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] patientsTemperatures = new float[patientsCount];
        for (int i = 0; i < patientsTemperatures.length; i++) {
            patientsTemperatures[i] = (float) (Math.random() * 8) + 32;
        }
        return patientsTemperatures;
    }
//    float[] array;
//    array = new float[30];
//        for (int i = 0; i < array.length; i++) {
//        array[i] = ((float)( Math.random() * (40-32)) + 32);
//        System.out.println( array[i]);
//        var a = array[i];
//    }
//
//
//        return array;
//     array[i] = (float)(Math.round(array[i] * 10.0)/10.0);


    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
            Округлите среднюю температуру с помощью Math.round до 2 знаков после запятой,
            а температуры каждого пациента до 1 знака после запятой
        */
        int healthyPatients = 0;
        float temperaturesSum = 0;
        String patientsTemperatures = "";

        for (float element : temperatureData) {
            patientsTemperatures += String.format(Locale.US, "%.1f", element) + " ";
            temperaturesSum += element;
            if (element >= 36.2F && element <= 36.9F)
                healthyPatients++;
        }
        String report =
                "Температуры пациентов: " + patientsTemperatures.trim() +
                        "\nСредняя температура: " + String.format(Locale.US, "%.2f",
                        (temperaturesSum / temperatureData.length)) +
                        "\nКоличество здоровых: " + healthyPatients;

        return report;
    }

}
