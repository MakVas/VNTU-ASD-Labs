package org.example.lab_06;



public class BinarySearchTree<T extends Comparable<T>> {
    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    private Node<T> root;

    // Конструктор ініціалізації дерева.
    public BinarySearchTree() {
        root = null;
    }

    // Функція для вставки елемента в дерево.
    public void insert(T data) {
        root = insertRec(root, data);
    }

    // Рекурсивна функція для вставки.
    private Node<T> insertRec(Node<T> root, T data) {
        if (root == null) {
            root = new Node<>(data);
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Функція для пошуку елемента.
    public boolean search(T data) {
        return searchRec(root, data);
    }

    // Рекурсивна функція для пошуку.
    private boolean searchRec(Node<T> root, T data) {
        //якщо корінь пусти вертаємо false
        if (root == null) {
            return false;
        }
        //якщо елементи однакові вертаємо true
        if (root.data.equals(data)) {
            return true;
        }
        //якщо шуканий елемент менший то ідемо в ліву під-дерево якщо більше то вправо
        if (data.compareTo(root.data) < 0) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }
    public boolean searchInOrder(T element) {
        return searchInOrder(root, element);
    }

    private boolean searchInOrder(Node<T> node, T element) {
        if (node == null) {
            return false; // Відсутній вузол, пошук завершено, не знайдено.
        }

        // Спершу перевірте ліве піддерево (менше значення).
        boolean leftResult = searchInOrder(node.left, element);
        if (leftResult) {
            return true; // Знайдено в лівому піддереві, повертаємо true.
        }

        // Потім перевірте поточний вузол.
        if (node.data.equals(element)) {
            return true; // Знайдено поточний вузол, повертаємо true.
        }

        // Нарешті, перевірте праве піддерево (більше значення).
        return searchInOrder(node.right, element);
    }


}
