package org.example.lab_05.task_2_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable {
    private static int CURRENT_CAPACITY = 16;
    private final boolean useAlder32;
    private final String name;
    List<LinkedList<Object>> table;
    int capacity = 0;

    @Override
    public String toString() {
        StringBuilder bucketsStr = new StringBuilder();
        int index = 0;
        //проходимось бо бакетам та виводимо результат
        for (LinkedList<Object> buckets: table) {
            bucketsStr.append("\n").append("bucket = ").append(index).append("[");
            for (Object obj: buckets) {
                bucketsStr.append(obj).append(", ");
            }
            bucketsStr.append("]");
            index++;
        }
        return "MyHashTable:" + " useAlder32=" + useAlder32 + " {" +
                "buckets = {" + bucketsStr + " }\n";


    }

    public HashTable(boolean useAlder32,String name) {

        this.useAlder32 = useAlder32;
        this.name = name;
        //створуємо хеш таблицю
        table = new ArrayList<>(CURRENT_CAPACITY);
        for (int i = 0; i < CURRENT_CAPACITY; i++) {
            table.add(new LinkedList<>());
        }
    }

    public int index(Object obj){
        if(useAlder32){
            return (adler32hash(obj) % CURRENT_CAPACITY);
        }
        return (divisionHash(obj) % CURRENT_CAPACITY);
    }
    private int adler32hash(Object obj) {
        int a = 1;  // Початкове значення першого суматора
        int b = 0;  // Початкове значення другого суматора
        // Константа, що визначає залишок в операції модуля для Adler-32
        final int MOD_ADLER = 65521;
        byte[] data = obj.toString().getBytes();

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
    public int divisionHash(Object obj){
        //отримуємо хеш код обьекту
        int hash = obj.hashCode();
        //якщо хеш відємний робимо його додатнім
        if(hash<0)
            hash = -hash;

        //вертаємо індексу бакету в таблиці через остачу ділення хешу на розмір масиву (метод ділення)
        return hash;
    }

    public String getName() {
        return name;
    }

    public void add(Object obj){
        //отримуємо індекс масиву
        int index = index(obj);
        int hash = useAlder32 ? adler32hash(obj) : divisionHash(obj);
        //перевіряємо щоб не було елементу під таким індексом
        if(contains(index,obj)) {
            table.get(index).add(hash);
            capacity++;
            //якщо ємність таблиці перевищила 75% - збільшуємо її
            if ((capacity * 100) / CURRENT_CAPACITY >= 75) {
                expandTable();
            }
        }
    }


    //перевірка на те чи існує елемент в таблиці
    public boolean contains(int index,Object obj){
        int hash = useAlder32 ? adler32hash(obj) : divisionHash(obj);
        return !table.get(index).contains(hash);
    }
    private void expandTable() {
        CURRENT_CAPACITY = table.size() * 2; // Збільшуємо ємність таблиці у двічі
        List<LinkedList<Object>> newTable = new ArrayList<>(CURRENT_CAPACITY);

        for (int i = 0; i < CURRENT_CAPACITY; i++) {
            newTable.add(new LinkedList<>());
        }

        // Копіювання элементів зі старої таблиці в нову
        for (LinkedList<Object> buckets : table) {
            for (Object obj : buckets) {
                int indexObj = index(obj);
                newTable.get(indexObj).add(obj);
            }
        }
        table = newTable;
        checkCapacity();
    }

    //перевірка ємності таблиці
    public void checkCapacity(){
        capacity = 0;
        table.forEach(buckets->{
            if(!buckets.isEmpty())
                capacity++;
        });

    }
    //пошук
    public boolean search(Object obj){
        //отримуємо індекс в таблиці
        int index = index(obj);
        //отримуємо хеш объекта
        int hash = useAlder32 ? adler32hash(obj) : divisionHash(obj);
        return table.get(index).contains(hash);
    }

}
