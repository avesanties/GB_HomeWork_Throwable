/* Задание 1.
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа
 * (типа float), и возвращает введенное значение. Ввод текста вместо числа
 * не должно приводить к падению приложения, вместо этого, необходимо повторно
 * запросить у пользователя ввод данных.
 */

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        askFloat();
    }


    /**
     * Решение задания 1.
     * P.s. инетересно, что реализация hasNexFloat() не распознает литерал float вида 9.9f.
     * @return
     */
    static float askFloat(){
        var sc = new Scanner(System.in);

        while(true){
            System.out.println("Provide float input:");
            if(sc.hasNextFloat()){
                return sc.nextFloat();
            }else {
                sc.next();
            }
        }
    }
}