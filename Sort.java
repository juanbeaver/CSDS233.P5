public class Sort {

    public static void main(String[] args) {
        int[] arr = randomArray(10,0,10);

        mergeSort(arr);
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
        int[] temp = new int[arr.length];
        mSort(arr, temp, 0 , arr.length - 1);
    }

    static private void mSort(int[] arr, int[] temp, int start, int end){
        if(start == end){
            return;
        }
        int middle = (start + end)/2;

        mSort(arr, temp, start, middle);
        mSort(arr, temp, middle + 1, end);
        merge(arr, temp, start, middle, middle +1, end);
    }

    static public void merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd){
        int i = leftStart;
        int j = rightStart;
        int k = leftStart;

        while (i <= leftEnd && j <= rightEnd){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[i++];
            }
        }
        while(i <= leftEnd){
            temp[k++] = arr[i++];
        }
        while(j <= rightEnd){
            temp[k++] = arr[j++];
        }

        for(i = leftStart; i <= rightEnd; i++) {
            arr[i] = temp[i];
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
