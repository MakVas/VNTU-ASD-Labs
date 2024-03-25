package org.example.lab_05.task_1;

public class Adler32Checksum {

    // Константа, що визначає залишок в операції модуля для Adler-32
    private static final int MOD_ADLER = 65521;

    // Метод для обчислення контрольної суми Adler-32 для масиву байтів
    public static int calculateAdler32Checksum(byte[] data) {
        int a = 1;  // Початкове значення першого суматора
        int b = 0;  // Початкове значення другого суматора

        // Ітеруємося по кожному байту вхідних даних
        for (byte byteValue : data) {
            // Оновлюємо значення першого суматора
            a = (a + (byteValue & 0xFF)) % MOD_ADLER;

            // Оновлюємо значення другого суматора
            b = (b + a) % MOD_ADLER;
        }

        // Об'єднуємо значення двох суматорів для утворення 32-бітної контрольної суми Adler-32
        return (b << 16) | a;
    }


    public static void main(String[] args) {
        // Приклад використання функції обчислення Adler-32 контрольної суми
        String inputString = "Hello, Adler-32!";
        byte[] inputData = inputString.getBytes();

        // Обчислюємо контрольну суму Adler-32
        int checksum = calculateAdler32Checksum(inputData);
        System.out.printf("%-30s|%30s","Your input data","Adler32 hash data\n");
        System.out.printf("%-30s|%22s\n",inputString,checksum);

    }
}
