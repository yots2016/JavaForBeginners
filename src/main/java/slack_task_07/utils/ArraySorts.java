package slack_task_07.utils;

public interface ArraySorts {
    // метод для сортування вибором
    static void choiceSort(int[] unsortedArray) {
        long start = System.nanoTime();

        int indexMin;

        for (int index = 0; index < unsortedArray.length - 1; index++) {
            indexMin = index;

            for (int indexToScan = index; indexToScan < unsortedArray.length; indexToScan++) {
                if (unsortedArray[indexMin] > unsortedArray[indexToScan]) {
                    indexMin = indexToScan;
                }
            }

            int temp = unsortedArray[index];
            unsortedArray[index] = unsortedArray[indexMin];
            unsortedArray[indexMin] = temp;
        }

        long stop = System.nanoTime();
        System.out.println("Sort time by choice sort = " + (stop - start));
    }

    //метод для сортування бульбашкою
    static void bubbleSort(int[] unsortedArray) {
        long start = System.nanoTime();

        int stepCounter;

        do {
            stepCounter = 0;

            for (int index = 0; index < unsortedArray.length - 1; index++) {
                if (unsortedArray[index] > unsortedArray[index + 1]) {
                    int temp = unsortedArray[index];
                    unsortedArray[index] = unsortedArray[index + 1];
                    unsortedArray[index + 1] = temp;

                    stepCounter++;
                }
            }
        } while (stepCounter > 0);

        long stop = System.nanoTime();
        System.out.println("Sort time by bubble sort = " + (stop - start));
    }

    //метод для сортування вставкою
    static void insertSort(int[] unsortedArray) {
        long start = System.nanoTime();

        int element;
        int indexToInsert;

        for (int index = 0; index < unsortedArray.length; index++) {
            element = unsortedArray[index];

            indexToInsert = index;

            while (indexToInsert > 0 && unsortedArray[indexToInsert - 1] > element) {
                unsortedArray[indexToInsert] = unsortedArray[indexToInsert - 1];
                indexToInsert--;
                unsortedArray[indexToInsert] = element;
            }
        }

        long stop = System.nanoTime();
        System.out.println("Sort time by insert sort= " + (stop - start));
    }
}
