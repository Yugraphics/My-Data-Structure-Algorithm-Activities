import java.util.Scanner;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        // Input the elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Sorting the array (binary search works on sorted arrays)
        Arrays.sort(array);

        // Input the element to search for
        System.out.print("Enter the element to search for: ");
        int target = scanner.nextInt();

        // Call the binary search method
        int result = binarySearch(array, target);

        // Display the result
        if (result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }

    // Binary search method
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is at mid
            if (array[mid] == target) {
                return mid;
            }

            // If target is greater, ignore the left half
            if (array[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }

        // If target is not present in the array
        return -1;
    }
}