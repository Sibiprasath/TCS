import java.util.Scanner;

public class BeautifulArray {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int ascendingSwaps = countSwapsForAscending(arr.clone());
        int descendingSwaps = countSwapsForDescending(arr.clone());
        System.out.println(Math.min(ascendingSwaps, descendingSwaps));
    }
    private static int countSwapsForAscending(int[] arr) {
        int swapCount = 0;
        boolean swapped;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapCount++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return swapCount;
    }
    private static int countSwapsForDescending(int[] arr) {
        int swapCount = 0;
        boolean swapped;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapCount++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return swapCount;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
