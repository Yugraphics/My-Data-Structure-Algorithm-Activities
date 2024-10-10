import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user for the number of elements
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        // Initialize the array and prompt for elements
        int[] array = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt(); // Store user input in the array
        }

        // Prompt user to choose a sorting algorithm
        int choice;
        do {
            System.out.println("Choose a sorting algorithm:");
            System.out.println("1. Insertion Sort\n2. Selection Sort\n3. Merge Sort\n4. Quick Sort");
            choice = sc.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice < 1 || choice > 4);

        // Create a copy of the original array for sorting
        int[] sortedArray = Arrays.copyOf(array, array.length);

        // Perform sorting based on user's choice
        switch (choice) {
            case 1:
                insertionSort(sortedArray);
                break;
            case 2:
                selectionSort(sortedArray);
                break;
            case 3:
                mergeSort(sortedArray, 0, sortedArray.length - 1);
                break;
            case 4:
                quickSort(sortedArray, 0, sortedArray.length - 1);
                break;
        }

        // Output the sorted array
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));

        // Close the scanner
        sc.close();
    }

    // Insertion Sort algorithm
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i]; // Current element to be compared
            int j = i - 1; // Index for the sorted portion
            // Shift elements to the right to find correct position for key
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key; // Insert key at the correct position
        }
    }

    // Selection Sort algorithm
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i; // Assume the minimum is the first element
            for (int j = i + 1; j < array.length; j++) {
                // Update minIndex if a smaller element is found
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // Merge Sort algorithm
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Find the mid point
            mergeSort(array, left, mid); // Sort the first half
            mergeSort(array, mid + 1, right); // Sort the second half
            merge(array, left, mid, right); // Merge the sorted halves
        }
    }

    // Helper method for merging two sorted halves
    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1; // Size of left subarray
        int n2 = right - mid; // Size of right subarray

        int[] L = new int[n1]; // Left subarray
        int[] R = new int[n2]; // Right subarray

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[mid + 1 + j];
        }

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0, k = left; // Initial indexes
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i]; // Take from left
                i++;
            } else {
                array[k] = R[j]; // Take from right
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[], if any
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[], if any
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Quick Sort algorithm
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high); // Partition the array
            quickSort(array, low, pi - 1); // Recursively sort elements before partition
            quickSort(array, pi + 1, high); // Recursively sort elements after partition
        }
    }

    // Helper method for partitioning
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Choose the last element as pivot
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++; // Increment index of smaller element
                // Swap
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap the pivot element to the correct position
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Return the partitioning index
    }
}
