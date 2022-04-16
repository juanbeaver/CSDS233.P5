import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortTester {

    @Test
    public void testInsertion(){

        int[] arrToSort = Sort.randomArray(1000, 0, 1000);
        int[] assertArr = arrToSort.clone();
        Arrays.sort(assertArr);
        Sort.insertionSort(arrToSort);

        // Make sure array was sorted correctly
        assertArrayEquals(assertArr, arrToSort);

        //Test correct handling of empty array
        int[]arrToSort2 = new int[10];
        int[]assertArr2 = arrToSort2.clone();
        Arrays.sort(assertArr2);
        Sort.insertionSort(arrToSort2);

        assertArrayEquals(assertArr2, arrToSort2);

        //Test correct handling of array with single element
        int[]arrToSort3 = {5};
        int[]assertArr3 = arrToSort3.clone();
        Arrays.sort(assertArr3);
        Sort.insertionSort(arrToSort3);

        assertArrayEquals(assertArr3, arrToSort3);
    }

    @Test
    public void testQuick(){

        int[] arrToSort = Sort.randomArray(1000, 0, 1000);
        int[] assertArr = arrToSort.clone();
        Arrays.sort(assertArr);
        Sort.quickSort(arrToSort);

        // Make sure array was sorted correctly
        assertArrayEquals(assertArr, arrToSort);

        //Test correct handling of empty array
        int[]arrToSort2 = new int[10];
        int[]assertArr2 = arrToSort2.clone();
        Arrays.sort(assertArr2);
        Sort.quickSort(arrToSort2);

        assertArrayEquals(assertArr2, arrToSort2);

        //Test correct handling of array with single element
        int[]arrToSort3 = {5};
        int[]assertArr3 = arrToSort3.clone();
        Arrays.sort(assertArr3);
        Sort.quickSort(arrToSort3);

        assertArrayEquals(assertArr3, arrToSort3);
    }

    @Test
    public void testMerge(){

        int[] arrToSort = Sort.randomArray(1000, 0, 1000);
        int[] assertArr = arrToSort.clone();
        Arrays.sort(assertArr);
        Sort.mergeSort(arrToSort);

        // Make sure array was sorted correctly
        assertArrayEquals(assertArr, arrToSort);

        //Test correct handling of empty array
        int[]arrToSort2 = new int[10];
        int[]assertArr2 = arrToSort2.clone();
        Arrays.sort(assertArr2);
        Sort.mergeSort(arrToSort2);

        assertArrayEquals(assertArr2, arrToSort2);

        //Test correct handling of array with single element
        int[]arrToSort3 = {5};
        int[]assertArr3 = arrToSort3.clone();
        Arrays.sort(assertArr3);
        Sort.mergeSort(arrToSort3);

        assertArrayEquals(assertArr3, arrToSort3);

    }
}
