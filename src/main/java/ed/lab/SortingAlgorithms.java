package ed.lab;

public class SortingAlgorithms {
    public static<T extends Comparable> void highPivotQuickSort(T[] array){
        quickSortHigh(array, 0, array.length - 1);

    }
    public static<T extends Comparable> void lowPivotQuickSort(T[] array){
        quickSortLow(array, 0, array.length - 1);
    }
    public static<T extends Comparable> void randomPivotQuickSort(T[] array){
        quickSortRandom(array, 0, array.length - 1);
    }

    //Metodos para highPivotQuickSort
    private static<T extends Comparable> int partitionHigh(T[] arr, int start, int end){
        T pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++){
            if (arr[j].compareTo(pivot) <= 0){
                i++;

                T x = arr[i];
                arr[i] = arr[j];
                arr[j] = x;
            }
        }
        T x = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = x;

        return i + 1;
    }

    public static<T extends Comparable> void quickSortHigh(T[] arr, int start, int end){
        if(start < end){
            int pivot = partitionHigh(arr, start, end);

            quickSortHigh(arr, start, pivot - 1);
            quickSortHigh(arr, pivot + 1, end);
        }
    }

    // Metodos para lowPivotQuickSort
    private static <T extends Comparable<T>> int partitionLow(T[] arr, int start, int end) {
        T pivot = arr[start];
        int i = start + 1;

        for (int j = start + 1; j <= end; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        T temp = arr[start];
        arr[start] = arr[i - 1];
        arr[i - 1] = temp;

        return i - 1;
    }

    private static <T extends Comparable<T>> void quickSortLow(T[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partitionLow(arr, start, end);
            quickSortLow(arr, start, pivotIndex - 1);
            quickSortLow(arr, pivotIndex + 1, end);
        }
    }
    // Metodos para randomPivotQuickSort
    private static <T extends Comparable<T>> int partitionRandom(T[] arr, int start, int end) {
        int randomIndex = start + (int) (Math.random() * (end - start + 1)); // Selecciona un pivote aleatorio
        T pivot = arr[randomIndex];
        T temp = arr[randomIndex];
        arr[randomIndex] = arr[end];
        arr[end] = temp;

        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                T temp2 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp2;
            }
        }
        T temp3 = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp3;

        return i + 1;
    }

    private static <T extends Comparable<T>> void quickSortRandom(T[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partitionRandom(arr, start, end);
            quickSortRandom(arr, start, pivotIndex - 1);
            quickSortRandom(arr, pivotIndex + 1, end);
        }
    }
}
