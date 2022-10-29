/* Задание 4.
 * Разработайте программу, которая выбросит Exception,
 * когда пользователь вводит пустую строку. Пользователю
 * должно показаться сообщение, что пустые строки вводить нельзя.
 */

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) throws Exception{
        String usrInput = "";
        var sc = new Scanner(usrInput);

        System.out.println("Enter not empty string:");
        if(!sc.hasNext())
            throw new Exception("Empty string provided.");
    }
}