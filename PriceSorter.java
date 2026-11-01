import java.util.Arrays;
import java.util.Scanner;

public class PriceSorter {

    // Merge Sort Implementation
    public static void mergeSort(double[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(double[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] leftArr = new double[n1];
        double[] rightArr = new double[n2];

        for (int i = 0; i < n1; ++i) leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; ++j) rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    // Quick Sort Implementation
    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(double[] arr, int low, int high) {
        double pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== E-Commerce Product Price Sorter ===");
        System.out.print("Enter number of products: ");
        int n = scanner.nextInt();
        double[] prices = new double[n];

        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextDouble();
        }

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Sort using Merge Sort");
            System.out.println("2. Sort using Quick Sort");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();

            // Create a copy so original input remains intact for subsequent selections
            double[] tempPrices = Arrays.copyOf(prices, prices.length);

            if (choice == 1) {
                mergeSort(tempPrices, 0, tempPrices.length - 1);
                System.out.println("Sorted Prices (Merge Sort): " + Arrays.toString(tempPrices));
            } else if (choice == 2) {
                quickSort(tempPrices, 0, tempPrices.length - 1);
                System.out.println("Sorted Prices (Quick Sort): " + Arrays.toString(tempPrices));
            } else if (choice == 3) {
                System.out.println("Exiting program. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice! Please enter a valid option between 1 and 3.");
            }
        }
        scanner.close();
    }
}
