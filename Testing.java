import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

class Testing {

    public static void main(String[] args) {
        /*
        int[] arr = {95, 71, 60, 78, 75, 57, 80, 76, 67, 51, 74};
        //int[] arr = {5,7,2,4,9,1,3,8,6};
        //int[] arr = {};
        System.out.println(Arrays.toString(arr));
        
        ArrayQuickSort.partition(arr);
        System.out.println(Arrays.toString(arr));*/
        
        //ArrayQuickSort.partition(arr, 0, 4);
        //ArrayQuickSort.partition(arr, 5, arr.length - 1);
        //System.out.println(Arrays.toString(arr));

        /*

        LinkedList list = new LinkedList();
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);

        System.out.println(list.toString());
        list.quickSort();
        System.out.println(list.toString());

        */

        int[] sizes = {2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384};
        //int[] sizes = {2,4,8,16,32,64};
        int tries = 10000;
        benchmarkOne(sizes, tries);
    }
    

 
    static void benchmarkOne(int[] sizes, int tries) {

        System.out.println("Size\t\tArray\t\tArray(diff.)\tArr./Size\tLinkedList\tLinkedList(diff.)\tLinkedLi./Size\t\tCalculated\t\tCalculated(diff.)");

        double array_prev_best = 1;
        double linked_list_prev_best = 1;
        double calculated_prev = 1;

        for (int size : sizes) {

            double array_best = Double.MAX_VALUE;
            double linked_list_best = Double.MAX_VALUE;

            double n0, n1, n;
            int[] arr_original;
            int[] arr_clone;

            arr_original = generateArr(size);

            System.gc();

            for (int i = 0; i < tries; i++) {

                shuffleArr(arr_original); 

                // Warm up.
                arr_clone = Arrays.copyOf(arr_original, arr_original.length);
                ArrayQuickSort.partition(arr_clone);
                arr_clone = Arrays.copyOf(arr_original, arr_original.length);
                LinkedList list = new LinkedList();
                for (int item : arr_clone)
                    list.add(item);
                list.quickSort();

                // Array.
                arr_clone = Arrays.copyOf(arr_original, arr_original.length);
                n0 = System.nanoTime();
                ArrayQuickSort.partition(arr_clone);
                n1 = System.nanoTime();
                n = n1 - n0;
                if (n < array_best)
                    array_best = n;

                // Linked list.
                arr_clone = Arrays.copyOf(arr_original, arr_original.length);
                list = new LinkedList();
                for (int item : arr_clone)
                    list.add(item);
                n0 = System.nanoTime();
                list.quickSort();
                n1 = System.nanoTime();
                n = n1 - n0;
                if (n < linked_list_best)
                    linked_list_best = n;
                
            }

            System.out.printf("%d\t&\t%.0f\t&\t%.2f\t&\t%.0f\t&\t%.0f\t&\t%.2f\t&\t\t%.0f\t&\t\t%d\t&\t\t%.2f\n", size, array_best, array_best/array_prev_best, array_best/size, linked_list_best, linked_list_best/linked_list_prev_best, linked_list_best/size, size * log2(size), (double)(size * log2(size)) / calculated_prev);

            array_prev_best = array_best;
            linked_list_prev_best = linked_list_best;
            calculated_prev = (double)size * log2(size);

        }

    }



    
    public static int log2(int N)
    {
 
        // calculate log2 N indirectly
        // using log() method
        int result = (int)(Math.log(N) / Math.log(2));
 
        return result;
    }


    static Integer[] generateArr2(int size) {
        Random rn = new Random();
        int last_ins = 0;
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            last_ins += rn.nextInt(4) + 1;
            arr[i] = last_ins;
        }
        return arr;
    }


    static int[] generateArr(int size) {
        int[] arr = new int[size];
        arr[size - 1] = size / 2;
        int i = 0;
        int j = 0;
        while (i < size - 1) {
            if (i == size / 2)
                j++;
            arr[i++] = j++;
        }

        return arr;
    }

    static void shuffleArr(int[] arr) {
        Random rn = new Random();
        for (int i = arr.length - 2; i > 0; i--) {
            int t = arr[i];
            int rn_int = rn.nextInt(arr.length - 2);
            arr[i] = arr[rn_int];
            arr[rn_int] = t;
        }
    }
    
}

