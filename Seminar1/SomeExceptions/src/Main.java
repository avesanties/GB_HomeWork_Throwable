/*
* 27.10.2022
* Шлепенков Алексей
* Telegram: @avesanties
* Discord: Alexey Sh.#3490
* e-mail: schlepenkow@gmail.com
*/


import java.io.BufferedReader;;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

    }

   /*
   * Задание 1.
   * Реализуйте 3 метода, чтобы в каждом из них получить разные исключения Посмотрите на код,
   * и подумайте сколько разных типов исключений вы тут сможете получить?
   */

    /**
     * Метод первый. Выбрасывает проверяемое исключение ввода/вывода.
     * @param fileName
     * @return
     * @throws IOException
     */
    static String readFile(String fileName) throws IOException {
        var bf = new BufferedReader(new FileReader(fileName));
        var sb = new StringBuilder();

        while (bf.ready()){
            sb.append(bf.readLine());
        }

        return sb.toString();
    }

    /**
     * Метод второй. Выбрасывает непроверяемое исключение преобразования типа.
     * @param words
     * @return
     */
    static String concat(Object[] words){
        var sb = new StringBuilder();

        for(Object word : words){
            if(!(word instanceof String))
                throw new ClassCastException("element is not a string!");

            sb.append((String)word);
        }

        return sb.toString();
    }

    /**
     * Метод третий. Выыбрасывает кастомное исключение переполнения типа int.
     * @param num
     * @return
     * @throws OverFlowException
     */
    static int inc(int num) throws OverFlowException{
        if(num == Integer.MAX_VALUE){
            throw new OverFlowException(num + " cannot be increased anymore");
        }

        return num++;
    }

    /* Задание 2.
     * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
     * и возвращающий новый массив, каждый элемент которого равен разности элементов
     * двух входящих массивов в той же ячейке. Если длины массивов не равны,
     * необходимо как-то оповестить пользователя.
     */

    /**
     * Выбрасывает непроверяемое исключение, если длины массивов не совпадают.
     * @param arr1
     * @param arr2
     * @return
     */
    static int[] sumArr(int[] arr1, int[] arr2){
        var logger = Logger.getAnonymousLogger();

        if(arr1.length != arr2.length){
            logger.log(Level.SEVERE, "arrays lengths do not match");
            throw new RuntimeException();
        }

        int[] result = new int[arr1.length];
        for(int m = 0; m < arr1.length; m++)
            result[m] = arr1[m] + arr2[m];

        return result;
    }

    /* Задание 3.
     * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
     * и возвращающий новый массив, каждый элемент которого равен частному элементов двух
     * входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то
     * оповестить пользователя. Важно: При выполнении метода единственное исключение, которое пользователь
     * может увидеть - RuntimeException, т.е. ваше.
     */

    /**
     * Выюрасывет непроверяемые исключения, если длины массивов не совпадают или элемент массива-делителя равен нулю.
     * @param arr1
     * @param arr2
     * @return
     */
    static int[] divArr(int[] arr1, int[] arr2){
        var logger = Logger.getAnonymousLogger();

        if (arr1.length != arr2.length){
            logger.log(Level.SEVERE, "arrays lengths do not match");
            throw new RuntimeException();
        }

        int[] result = new int[arr1.length];
        for(int m = 0; m < arr1.length; m++){
            if(arr2[m] == 0)
                throw new ArithmeticException("division by zero");

            result[m] = arr1[m] / arr2[m];
        }

        return result;
    }
}

class OverFlowException extends Exception{
    public OverFlowException(){}

    public OverFlowException(String message){
        super(message);
    }
}