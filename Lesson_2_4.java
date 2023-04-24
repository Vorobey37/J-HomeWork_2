import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Lesson_2_4 {
    public static void main(String[] args) {
         /*
          * К калькулятору из предыдущего дз добавить логирование.
          */

        try {
            Logger logCalculator = Logger.getLogger(Lesson_2_4.class.getName());
            FileHandler fh = new FileHandler("loggerCalculator.log");
            logCalculator.addHandler(fh);
            SimpleFormatter textFormat = new SimpleFormatter();
            fh.setFormatter(textFormat);
            logCalculator.setUseParentHandlers(false);
            logCalculator.log(Level.INFO, "Начало логирования");

            char operation = ' ';
            Scanner input = new Scanner(System.in);
            while(operation != 'b')
            {
                System.out.println("Введите два числа: ");
                double a = input.nextInt();
                double b = input.nextInt();
                System.out.println("Введите действие (+, -, *, /, b): ");
                operation = input.next().charAt(0);
        
                if (operation == 'b')
                {
                    System.out.println("Конец программы!");
                    logCalculator.log(Level.INFO, "Конец программы!");

                    break;
                }
                if (operation == '+')
                {
                    System.out.println(a+b);
                    logCalculator.log(Level.INFO, a + " " + "+" + " " + b + " " + "=" + " " + (a+b));
                }
                if (operation == '-')
                {
                    System.out.println(a-b);
                    logCalculator.log(Level.INFO, a + " " + "-" + " " + b + " " + "=" + " " + (a-b));
                }
                if (operation == '*')
                {
                    System.out.println(a*b);
                    logCalculator.log(Level.INFO, a + " " + "*" + " " + b + " " + "=" + " " + (a*b));
                }
                if (operation == '/')
                {
                    if (b==0)
                    {
                        System.out.println("На ноль делить нельзя!");
                        logCalculator.log(Level.WARNING, "На ноль делить нельзя!");
                    }    
                    else
                    {
                        System.out.println(a/b);
                        logCalculator.log(Level.INFO, a + " " + "/" + " " + b + " " + "=" + " " + (a/b));
                    }
                }
            }
            input.close();

        } catch (IOException ex) {
                ex.printStackTrace();
        }
    }
}
