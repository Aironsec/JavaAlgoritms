package lesson2.sorts;


import java.util.Arrays;
import java.util.Random;

public class ArrayControl implements ArrControl {
    private int size;
    private int[] arr;
    private int pos = 0;
    private Throwable IndexOutOfBoundsException;

    public ArrayControl(int size) {
        this.arr = new int[size];
        this.size = size;
    }

    @Override
    public void replaceIndex(int value, int index) throws Throwable {
        if (index >= size) throw IndexOutOfBoundsException;
        else
            this.arr[index] = value;
    }

    @Override
    public void add(int value) {
        arrcopy(size + 1);
        arr[size - 1] = value;
    }

    @Override
    public boolean drop(int value) {
        if (find(value)) {
            for (int i = pos; i < size - 1; i++){
                arr[i] = arr[i + 1];
            }
            arrcopy(size - 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean find(int value) {
        sortBubble();
        int max = size - 1, min = 0, mid;
        while (min <= max) {
            mid = (min + max) / 2;
            if (this.arr[mid] == value) {
                pos = mid;
                return true;
            }
            else
                if (value > this.arr[mid]) min = mid + 1;
                else max = mid - 1;
        }
        return false;
    }

    @Override
    public void random() {
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt(size);
        }
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size - 1; j++) {
                if (arr[i] > arr[j + 1])
                    replaceInt(i, j + 1);
            }
        }
    }

    @Override
    public void sortBubbleDeleteDuplicate() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size - 1; j++) {
                if (arr[i] > arr[j + 1])
                    replaceInt(i, j + 1);
            }
            if (i > 0 && arr[i - 1] == arr[i]) {
                int tmp = arr[size - 1];
                arr[size - 1] = arr[i];
                arr[i] = tmp;
                i--;
                size--;
            }
        }
        arrcopy(size);
    }

    @Override
    public void sortSelect() {
        int i, j, mark;
        for(i=0; i < size; i++){
            mark = i;
            for(j = i+1; j < size; j++){
                if (arr[j] < arr[mark]){
                    mark = j;
                }
            }

            replaceInt(i, mark);
        }

    }

    @Override
    public void sortInsert() {
        int i, j;
        for(i = 1; i < size; i++){
            int temp = arr[i];
            j = i;
            while(j > 0 && arr[j-1] >=temp){
                arr[j] = arr[j-1];
                --j;
            }
            arr[j] = temp;
        }

    }

    private void replaceInt(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private void arrcopy(int size){
        int[] arr2 = this.arr;
        int tmp = arr2.length;
        this.arr = new int[size];
        for (int i = 0; i < size; i++) {
            if ((i < tmp)) this.arr[i] = arr2[i];
        }
        this.size = size;
    }

    public static void main(String[] args) throws Throwable {
        ArrayControl arr = new ArrayControl(10);
        arr.random();
        System.out.println(Arrays.toString(arr.arr));
        arr.replaceIndex(2, 2);
        arr.sortBubble();
        System.out.println(Arrays.toString(arr.arr));
        System.out.println(arr.drop(2));
        arr.add(100);
        System.out.println(Arrays.toString(arr.arr));
        ArrayControl arr1 = new ArrayControl(10000);
        arr1.random();
        ArrayControl arr2 = new ArrayControl(10000);
        arr2.random();
        ArrayControl arr3 = new ArrayControl(10000);
        arr3.random();
        ArrayControl arr4 = new ArrayControl(100000);
        arr4.random();

        System.out.println("Пузырькова сортировка " + arr1.size + " элементов.");
        long t = System.currentTimeMillis();
        arr1.sortBubble();
        System.out.println("Время выполнения: " + (System.currentTimeMillis() - t) + " мс.");

        System.out.println("Пузырькова сортировка с удалением дубликатов " + arr2.size + " элементов.");
        t = System.currentTimeMillis();
        arr2.sortBubbleDeleteDuplicate();
        System.out.println("Время выполнения: " + (System.currentTimeMillis() - t) + " мс.");

        System.out.println("Сортировка выбором " + arr3.size + " элементов.");
        t = System.currentTimeMillis();
        arr3.sortSelect();
        System.out.println("Время выполнения: " + (System.currentTimeMillis() - t) + " мс.");

        System.out.println("Сортировка вставкой " + arr4.size + " элементов.");
        t = System.currentTimeMillis();
        arr4.sortInsert();
        System.out.println("Время выполнения: " + (System.currentTimeMillis() - t) + " мс.");
    }
}
