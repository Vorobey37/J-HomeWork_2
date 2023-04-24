import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Lesson_2_2 {
    public static void main(String[] args) {
        /*
         * Реализуйте алгоритм сортировки пузырьком числового массива, 
         * результат после каждой итерации запишите в лог-файл.
         */
    
        System.out.println("Введите количество элементов массива: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        int []array = new int[n];
        Random randomElements = new Random();
        for (int i=0; i<n; i++) {
            array[i] = randomElements.nextInt(20);
        }
        System.out.println(Arrays.toString(array));
        try {
            Logger logArray = Logger.getLogger(Lesson_2_2.class.getName());
            FileHandler fh = new FileHandler("logger.log");
            logArray.addHandler(fh);
            SimpleFormatter textFormat = new SimpleFormatter();
            fh.setFormatter(textFormat);
            logArray.setUseParentHandlers(false);
            logArray.log(Level.INFO, "Начало логирования: ");
            logArray.log(Level.INFO, "Начальный массив: " + Arrays.toString(array));
            int bufNumber;
            int count = 1;
            for (int i = 0; i < array.length; i++) {
                for (int j = i+1; j < array.length; j++) {
                    if (array[i]>array[j]) {
                        bufNumber = array[j];
                        array[j] = array[i];
                        array[i] = bufNumber;
                    }
                    logArray.log(Level.INFO, "Действие " + count + ": " + Arrays.toString(array));
                    count++;
                }
            }
            logArray.log(Level.INFO, "Конечный массив: " + Arrays.toString(array));
        
            System.out.println(Arrays.toString(array));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
}
