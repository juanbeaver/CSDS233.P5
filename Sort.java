import java.lang.reflect.Method;
import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        //Insertion sort demo
        System.out.println("Here is a random array with ten values");
        int[] insertionArr = randomArray(10, 0, 10);
        for(int x : insertionArr){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("And here it is sorted using insertion sort");
        long start = System.nanoTime();
        insertionSort(insertionArr);
        long end = System.nanoTime();
        for(int x : insertionArr){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("That operation took " + (end - start)/1000.0 + " microseconds");
        System.out.println("------------------------");


        //Quick sort demo
        System.out.println("Here is another random array with ten values");
        int[] quickArr = randomArray(10, 0, 10);
        for(int x : quickArr){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("And here it is sorted using quick sort");
        start = System.nanoTime();
        quickSort(quickArr);
        end = System.nanoTime();
        for(int x : quickArr){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("That operation took " + (end - start)/1000.0 + " microseconds");
        System.out.println("------------------------");

        //Merge sort demo
        System.out.println("And another random array with ten values");
        int[] mergeArr = randomArray(10, 0, 10);
        for(int x : mergeArr){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("And here it is sorted using merge sort");
        start = System.nanoTime();
        mergeSort(mergeArr);
        end = System.nanoTime();
        for(int x : mergeArr){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("That operation took " + (end - start)/1000.0 + " microseconds");
        System.out.println("------------------------");

        //Bubble sort demo
        System.out.println("And finally another random array with ten values");
        int[] bubbleArr = randomArray(10, 0, 10);
        for(int x : bubbleArr){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("And here it is sorted using bubble sort");
        start = System.nanoTime();
        bubbleSort(bubbleArr);
        end = System.nanoTime();
        for(int x : bubbleArr){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("That operation took " + (end - start)/1000.0 + " microseconds");
        System.out.println("------------------------");

        String[] mergeResults = sortTimer("merge");
        String[] insertionResults = sortTimer("insertion");
        String[] quickResults = sortTimer("quick");
        String[] javaResults = sortTimer("java");
        String[] bubbleResults = sortTimer("bubble");

        for(String x : mergeResults){
            System.out.println(x);
        }
        System.out.println("------------------------");
        for(String x : quickResults){
            System.out.println(x);
        }
        System.out.println("------------------------");
        for(String x : insertionResults){
            System.out.println(x);
        }
        System.out.println("------------------------");
        for(String x : javaResults){
            System.out.println(x);
        }
        System.out.println("------------------------");
        for(String x : bubbleResults){
            System.out.println(x);
        }
    }

    static public void insertionSort(int[] arr){
        int newPos;

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



    static public void qSort(int[] arr, int first, int last){
        //If sub-array size is 1, return.
        if(first >= last)   return;

        //Choose the pivot as the last value in the sub-array
        int pivot = arr[last];

        //Partition the array around the pivot
        int newMiddle = partition(arr, first, last, pivot);

        //Sort each side of the array
        qSort(arr, first, newMiddle -1);
        qSort(arr, newMiddle + 1, last);
    }

    private static int partition(int[] arr, int first, int last, int pivot){
        // Initialize the front and back pointers
        int i = first;
        int j = last - 1;
        int temp;

        //While the pointers haven't met
        while(i < j){
            //Find the next item from the left that is bigger than the pivot
            while(arr[i] <= pivot && i < j){
                i++;
            }
            //Find the next item from the right that is smaller than the pivot
            while(arr[j] >= pivot && i < j){
                j--;
            }
            //Swap the two values
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        if(arr[i] > arr[last]) {
            temp = arr[i];
            arr[i] = arr[last];
            arr[last] = temp;
        }
        else{
            i = last;
        }

        return i;
    }

    static public void mergeSort(int[] arr){
        //If the array size is 1 return
        if(arr.length < 2)  return;

        int middle = arr.length/2;

        //Create the two parts of the array
        int[] left = new int[middle];
        int[] right = new int[arr.length - middle];

        //Initialize the left array
        for (int i = 0; i < middle; i++) {
            left[i] = arr[i];
        }

        //Initialize the right array
        for (int i = middle; i < arr.length; i++) {
            right[i - middle] = arr[i];
        }

        //Recursively sort each half
        mergeSort(left);
        mergeSort(right);

        //Merge the two arrays
        merge(arr, left, right);
    }

    static public void merge(int[] arr, int[] left, int[] right){
        int i = 0, j = 0, k = 0; //left, right, and arr pointers.

        //While both arrays have items left do this
        while(i < left.length && j < right.length){

            //If the left arrays current value is smaller, add it to array at k.
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            //else add the right arrays current value at arr[k]
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        //Add the rest of the values in the right array
        while(j < right.length){
            arr[k] = right[j];
            j++;
            k++;
        }
        //Add the rest of the values in the left array
        while(i < left.length){
            arr[k] = left[i];
            k++;
            i++;
        }
    }

    static public void bubbleSort(int[] arr){
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    static public int[] randomArray(int n, int a, int b){
        int[] arr = new int[n];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = a + (int)(Math.random() * ((b - a) + 1));
        }
        return arr;
    }

    static private String[] sortTimer(String sortType){
        int[] sortSize = {10,20,50,100,200,500,1000,2000,5000};
        String[] results = new String[9];
        int i = 0;
        switch (sortType) {
            case "merge":
                for (int x : sortSize) {
                    long start = System.nanoTime();
                    mergeSort(randomArray(x, 0, 5000));
                    long end = System.nanoTime();
                    results[i] = "merge sort finished " + x + " items in " + (end - start)/1000.0 + " microseconds";
                    i++;
                }
                break;
            case "insertion":
                for (int x : sortSize) {
                    long start = System.nanoTime();
                    insertionSort(randomArray(x, 0, 5000));
                    long end = System.nanoTime();
                    results[i] = "Insertion sort finished " + x + " items in " + (end - start)/1000.0 + " microseconds";
                    i++;
                }
                break;
            case "quick":
                for (int x : sortSize) {
                    long start = System.nanoTime();
                    quickSort(randomArray(x, 0, 5000));
                    long end = System.nanoTime();
                    results[i] = "quick sort finished " + x + " items in " + (end - start)/1000.0 + " microseconds";
                    i++;
                }
                break;
            case "java":
                for (int x : sortSize) {
                    long start = System.nanoTime();
                    Arrays.sort(randomArray(x, 0, 5000));
                    long end = System.nanoTime();
                    results[i] = "java sort finished " + x + " items in " + (end - start)/1000.0 + " microseconds";
                    i++;
                }
                break;
            case "bubble":
                for (int x : sortSize) {
                    long start = System.nanoTime();
                    Sort.bubbleSort(randomArray(x, 0, 5000));
                    long end = System.nanoTime();
                    results[i] = "Bubble sort finished " + x + " items in " + (end - start)/1000.0 + " microseconds";
                    i++;
                }
                break;
        }
        return results;
    }
}
