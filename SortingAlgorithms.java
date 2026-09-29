public class SortingAlgorithms {

    public static void selectionSort(int[] arr) {

        for (int i = 0;
             i < arr.length - 1;
             i++) {

            int min = i;

            for (int j = i + 1;
                 j < arr.length;
                 j++) {

                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void insertionSort(int[] arr) {

        for (int i = 1;
             i < arr.length;
             i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void displayArray(int[] arr) {

        System.out.print("[");

        for (int i = 0;
             i < arr.length;
             i++) {

            System.out.print(arr[i]);

            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}
