package ed.lab;

public class Main {
    private static final ArrayGenerator<Integer> sortedArrayGenerator = (int length) -> {
        Integer[] arreglo = new Integer[length];
        // Agrega valores en orden ascendente
        for (int i = 0; i < length; i++) {
            arreglo[i] = i;
        }
        return arreglo;
    }; // Reemplazado por funcion lambda

    private static final ArrayGenerator<Integer> invertedArrayGenerator = (int length) -> {
        Integer[] arreglo = new Integer[length];
        // Agrega valores en orden descendente
        for (int i = 0; i < length; i++) {
            arreglo[i] = length - i - 1;
        }
        return arreglo;
    }; // Reemplazado por funcion lambda
    private static final ArrayGenerator<Integer> randomArrayGenerator = (int length) -> {
        Integer[] arreglo = new Integer[length];
        // Agrega valores aleatoriamente en el rango de length
        for (int i = 0; i < length; i++) {
            arreglo[i] = (int) (Math.random() * length);
        }
        return arreglo;
    }; // Reemplazado por funcion lambda

    private static final QuickSort<Integer> highPivotQuickSort = SortingAlgorithms::highPivotQuickSort; // Reemplazado por una referencia a un método

    private static final QuickSort<Integer> lowPivotQuickSort = SortingAlgorithms::lowPivotQuickSort; //Reemplazado por una referencia a un método

    private static final QuickSort<Integer> randomPivotQuickSort = SortingAlgorithms::randomPivotQuickSort; // Reemplazado por una referencia a un método

    public static QuickSort<Integer> getHighPivotQuickSort() {
        return highPivotQuickSort;
    }

    public static QuickSort<Integer> getLowPivotQuickSort() {
        return lowPivotQuickSort;
    }

    public static QuickSort<Integer> getRandomPivotQuickSort() {
        return randomPivotQuickSort;
    }

    public static ArrayGenerator<Integer> getSortedArrayGenerator() {
        return sortedArrayGenerator;
    }

    public static ArrayGenerator<Integer> getInvertedArrayGenerator() {
        return invertedArrayGenerator;
    }

    public static ArrayGenerator<Integer> getRandomArrayGenerator() {
        return randomArrayGenerator;
    }

    public static void main(String[] args) {
        final SortingTester<Integer> tester = new SortingTester<>();

        System.out.println("Ordenando un arreglo ordenado:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");
    }
}