package activityD;

import java.util.Arrays;

public class Activity4 {

    public static void main(String[] args) {
        // Initialize array with random numbers
        int[] arr = {9, 3, 5, 1, 4, 8, 2};

        // Display array before sorting
        System.out.println("Array before sorting:");
        System.out.println(Arrays.toString(arr));

        // Insertion Sort Logic (Ascending Order)
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place key in correct position
            arr[j + 1] = key;
        }

        // Display array after sorting
        System.out.println("Array after sorting:");
        System.out.println(Arrays.toString(arr));
    }
}