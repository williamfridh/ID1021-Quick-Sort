class ArrayQuickSort {

    /**
     * Sort array between indices.
     * 
     * @param array of int to sort
     * @param i1 First index
     * @param i2 Second index
     */
    static void sort(int[] arr, int i1, int i2) {
        for (int i = i1 ; i < i2 - 1; i++) {
            int t = i;
            for (int j = t + 1; j < arr.length; j++)
                if (arr[t] > arr[j])
                    t = j;
            if (i != t)
                swap(arr, i, t);
        }
    }



    /**
     * Partition the array into a larger and smaller half. Then send these to sort().
     * @param arr
     */
    static void partition(int[] arr) {
        partition(arr, 0, arr.length - 1);
    }
    static void partition(int[] arr, int i1, int i2) {

        int pivot = i2;
        int newPivot = pivot;

        int i = i1-1;
        int j = i1;
        while (arr[j] != arr[pivot] && i != j) {
            while (arr[j] > arr[pivot]) {
                j++;
                newPivot--;
            }
            if (i != j)
                i++;
            if (arr[i] > arr[j] && i != j)
                swap(arr, i, j);
        }

        sort(arr, 0, newPivot);
        sort(arr, newPivot + 1, arr.length);
    }



    /**
     * Swap values.
     * 
     * @param arr
     * @param i index of first element.
     * @param j index of second element.
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

