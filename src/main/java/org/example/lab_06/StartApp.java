package org.example.lab_06;


import org.example.lab_05.task_2_3.HashTable;
import org.example.lab_06.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StartApp {
    public static void main(String[] args) {
        BinarySearchTree<User> tree = new BinarySearchTree<>();
        HashTable myHashTable = new HashTable(false,"");
        // Генеруємо випадковий список користувачів.
        List<User> userList = generateRandomList(1000000);

        // Вставляємо користувачів в дерева.
        for (User someUser : userList) {
            tree.insert(someUser);
            myHashTable.add(someUser);
        }



        // Проводимо експерименти з пошуком за ключовим та неключовим полем та вимірюємо час.
        User randomUser = new User(1231239246,"Blinovskay Irina Sergeivna",1992);
        tree.insert(randomUser);
        myHashTable.add(randomUser);

        long startTime = System.nanoTime();
        boolean treeSearchResult = tree.search(randomUser);
        long searchTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        boolean searchResultInOrder = tree.searchInOrder(randomUser);
        long searchTimeInOrder = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        boolean hashtable = myHashTable.search(randomUser);
        long searchTimeHashTable = System.nanoTime() - startTime;


        System.out.println("Пошук за ключовим значенням: " + treeSearchResult);
        System.out.println("Час пошуку за ключовим значенням (наносекунди): " + searchTime);

        System.out.println("Пошук за не ключовим значенням: " + searchResultInOrder);
        System.out.println("Час пошуку за не ключовим значенням (наносекунди): " + searchTimeInOrder);

        System.out.println("Пошук в хеш-таблиці: " + hashtable);
        System.out.println("Час пошуку в хештаблиці(наносекунди): " + searchTimeHashTable);


    }

    public static List<User> generateRandomList(int size) {
        List<User> someUsers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            User someUser = generateRandomUser();
            someUsers.add(someUser);
        }

        return someUsers;
    }

    // Метод для генерації випадкового користувача
    public static User generateRandomUser() {
        Random random = new Random();

        int randomTaxNumber = 100000000 + random.nextInt(900000000);  // Генерація числа від 100,000,000 до 999,999,999
        String randomFullName = "User" + random.nextInt(1000);        // Генерація імені з префіксом "User" та випадковим числом
        int randomBirthYear = 1980 + random.nextInt(41);              // Генерація року народження від 1980 до 2020

        return new User(randomTaxNumber, randomFullName, randomBirthYear);
    }
}
