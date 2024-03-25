package org.example.lab_05.task_2_3;
import java.util.Random;

public class StartProgram {
    public static void main(String[] args) {
        createLine("");
        // Створення екземплярів классу HashTable
        HashTable hashTableWithDivisionHashFunction = new HashTable(false,"з функцією ділення");
        HashTable hashTableWithAlder32HashFunction = new HashTable(true,"з функцією Alder32");

        String myPassword = "qwerty12345";
        // Додавання 10 рандомних паролів до хеш-таблиці
        for (int i = 0; i < 10; i++) {
            String password = generateRandomPassword();
            System.out.println("До таблиці" +" \"" + hashTableWithDivisionHashFunction.getName() + "\" "+ " додається пароль: " + password);
            hashTableWithDivisionHashFunction.add(password);
            System.out.println("До таблиці" +" \"" + hashTableWithAlder32HashFunction.getName() + "\" "+ " додається пароль: " + password);
            hashTableWithAlder32HashFunction.add(password);
        }

        System.out.println("До таблиці" +" \"" + hashTableWithDivisionHashFunction.getName() + "\" "+ " додається пароль: " + myPassword);
        //додаємо новий пароль
        hashTableWithDivisionHashFunction.add(myPassword);
        System.out.println("До таблиці" +" \"" + hashTableWithAlder32HashFunction.getName() + "\" "+ " додається пароль: " + myPassword);
        hashTableWithAlder32HashFunction.add(myPassword);
        createLine("");

        // Виведення змісту хеш-таблиці
        System.out.println(hashTableWithDivisionHashFunction);
        //шукаємо наш пароль
        System.out.print("Шукаємо пароль " + "\""+myPassword +"\"" + " ...Результат пошуку:" );
        System.out.println(hashTableWithDivisionHashFunction.search(myPassword));

        createLine("");
        // Виведення змісту хеш-таблиці
        System.out.println(hashTableWithAlder32HashFunction);
        //шукаємо наш пароль
        System.out.print("Шукаємо пароль " + "\""+myPassword +"\"" + " ...Результат пошуку:" );
        System.out.println(hashTableWithAlder32HashFunction.search(myPassword));
        createLine("");

    }

    // Метод для генерації рандомного рядка
    private static String generateRandomPassword() {
        // Стрічка символів, з яких буде генеруватися рядок
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Створення об'єкту StringBuilder для зберігання рандомного рядка
        StringBuilder password = new StringBuilder();

        // Створення об'єкту Random для вибору символів
        Random random = new Random();

        // Генерація рандомного рядка довжиною 8 символів
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        // Повернення сгенерованого рандомного рядка
        return password.toString();
    }
    public static void createLine(String str){
        System.out.println("<-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->");
        System.out.println(str);
    }
}
