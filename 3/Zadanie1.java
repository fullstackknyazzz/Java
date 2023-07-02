import java.util.ArrayList;
import java.util.Collections;

public class Zadanie1 {

    public static void PrintArray(ArrayList<Integer> arr) {
        for (int element : arr) {
            System.out.printf("%d, ", element);
        }
        System.out.println();
    }
    
    public static ArrayList<Integer> FillRandomArray(int n) {  //заполнение списка случайными целыми числами
        ArrayList <Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add((int)(Math.random()*100));
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array = FillRandomArray(10);
        PrintArray(array);
        MinValue(array);
        MaxValue(array);
        AverageValue(array);
        DeleteEvenNumber(array);
        PrintArray(array);
    }
    
    public static void DeleteEvenNumber(ArrayList<Integer> list) {
        int i = 0;
        while (i < list.size()) {
            if (list.get(i) % 2 == 0)
                list.remove(i);
            else
                i++;
        }
    }
    
    public static void MinValue(ArrayList<Integer> list) {
        int minValue = Collections.min(list);
        System.out.println("Минимальное значение: " + minValue);
    }

    public static void MaxValue(ArrayList<Integer> list) {
        int minValue = Collections.max(list);
        System.out.println("Максимальное значение: " + minValue);
    }

    public static void AverageValue(ArrayList<Integer> list) {
        double sum = 0;
        for (int number : list) {
            sum += number;
        }
        
        double average = sum / list.size();
        System.out.println("Среднее значение: " + average);
    }
}