//Решение задания 2.

public class Task2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        someMethod(arr, 3, 10);
    }

    static void someMethod(int[] intArray, double d, int index){
            if(d == 0){
                System.out.println("ArithmeticException");
                return;
            }
            if(index < 0 || index >= intArray.length){
                System.out.println("ArrayIndexOutOfBounds");
                return;
            }
            double catchedRes1 = intArray[index] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
    }
}
