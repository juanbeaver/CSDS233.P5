public class Sort {

    public static void main(String[] args) {
        int[] arr = randomArray(10,0,10);

        quickSort(arr);
    }

    static public void insertionSort(int[] arr){
        int newPos = 0;

        if(arr.length > 0) {
            // Loop through the array until you find an element out of place
            for (int i = 1; i < arr.length; i++) {
                //Check previous item
                if(arr[i] < arr[i-1]){
                    newPos = i-1;
                    //Find the final position of the current element at i
                    for (int j = i-1; j >= 0; j--) {
                        if(arr[i] < arr[j]){
                            newPos = j;
                        }
                        else{
                            break;
                        }
                    }
                    //Insert element at i at newPos
                    int moved = arr[i];
                    for (int j = i; j > newPos; j--) {
                        arr[j] = arr[j -1];
                    }
                    arr[newPos] = moved;
                }
            }
        }
    }

    static public void quickSort(int[] arr){
        qSort(arr, 0, arr.length - 1);
    }

    static public void qSort(int[] arr, int a, int b){

        if(arr.length == 1) return;
        int newLast = partition(arr, a, b);

        qSort(arr, a, newLast);
        qSort(arr, newLast +1, b);
    }

    static private int partition(int[] arr, int first, int last){
        int pivot = 0;

        pivot = arr[last];

        int i = first;
        int j = last - 1;
        int temp = 0;

        return 0;
    }


    static public void mergeSort(int[] arr){
        if(arr.length < 2)  return;

        int middle = arr.length/2;

        int[] left = new int[middle];
        int[] right = new int[arr.length - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = arr[i];
        }

        for (int i = middle; i < arr.length; i++) {
            right[i - middle] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    static public void merge(int[] arr, int[] left, int[] right){
        int i = 0, j = 0, k = 0; //left, right, and arr trackers.

        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(j < right.length){
            arr[k] = right[j];
            j++;
            k++;
        }
        while(i < left.length){
            arr[k] = left[i];
            k++;
            i++;
        }
    }



    static public int[] randomArray(int n, int a, int b){
        int[] arr = new int[n];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = a + (int)(Math.random() * ((b - a) + 1));
        }
        return arr;
    }

}
