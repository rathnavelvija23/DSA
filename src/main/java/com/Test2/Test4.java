//public class MergeSortExample {
//    public static void main(String[] args) {
//        int[] array = {64, 34, 25, 12, 22, 11, 90};
//
//        mergeSort(array, 0, array.length - 1);
//
//        // Print the sorted array
//        System.out.println("Merge Sort Result: " + Arrays.toString(array));
//    }
//
//    private static void mergeSort(int[] array, int left, int right) {
//        if (left < right) {
//            int mid = left + (right - left) / 2;
//
//            // Sort the first and second halves
//            mergeSort(array, left, mid);
//            mergeSort(array, mid + 1, right);
//
//            // Merge the sorted halves
//            merge(array, left, mid, right);
//        }
//    }
//
//    private static void merge(int[] array, int left, int mid, int right) {
//        int n1 = mid - left + 1;
//        int n2 = right - mid;
//
//        int[] leftArray = new int[n1];
//        int[] rightArray = new int[n2];
//
//        // Copy data to temporary arrays
//        for (int i = 0; i < n1; ++i)
//            leftArray[i] = array[left + i];
//        for (int j = 0; j < n2; ++j)
//            rightArray[j] = array[mid + 1 + j];
//
//        // Merge the temporary arrays
//        int i = 0, j = 0, k = left;
//        while (i < n1 && j < n2) {
//            if (leftArray[i] <= rightArray[j]) {
//                array[k] = leftArray[i];
//                i++;
//            } else {
//                array[k] = rightArray[j];
//                j++;
//            }
//            k++;
//        }
//
//        // Copy remaining elements of leftArray[] if any
//        while (i < n1) {
//            array[k] = leftArray[i];
//            i++;
//            k++;
//        }
//
//        // Copy remaining elements of rightArray[] if any
//        while (j < n2) {
//            array[k] = rightArray[j];
//            j++;
//            k++;
//        }
//    }
//}