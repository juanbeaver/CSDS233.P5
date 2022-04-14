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
        assertTrue(Arrays.equals(assertArr, arrToSort));

        //Test correct handling of empty array

        //Test correct handling of array with single element

        //Test correct handling of array with values without a lot of variance


    }

    @Test
    public void testQuick(){

        int[] arrToSort = Sort.randomArray(1000, 0, 1000);
        int[] assertArr = arrToSort.clone();
        Arrays.sort(assertArr);
        Sort.quickSort(arrToSort);

        // Make sure array was sorted correctly
        assertTrue(Arrays.equals(assertArr, arrToSort));

        //Test correct handling of empty array

        //Test correct handling of array with single element

        //Test correct handling of array with values without a lot of variance
    }

    @Test
    public void testMerge(){

        int[] arrToSort = Sort.randomArray(1000, 0, 1000);
        int[] assertArr = arrToSort.clone();
        Arrays.sort(assertArr);
        Sort.mergeSort(arrToSort);

        // Make sure array was sorted correctly
        assertTrue(Arrays.equals(assertArr, arrToSort));

        //Test correct handling of empty array

        //Test correct handling of array with single element

        //Test correct handling of array with values without a lot of variance

    }

    @Test
    public void testRandArr(){



    }


}
