import java.util.Arrays;

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

        LinkedList list = new LinkedList();
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);

        System.out.println(list.toString());
        list.quickSort();
        System.out.println(list.toString());
    }
    
}

