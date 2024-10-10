public class BubbleSort {
    // Method to perform bubble sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        // Traverse through all elements in the array
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Last i elements are already sorted, no need to check them
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the current element is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped, break the loop as the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Method to print an array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Original array:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}