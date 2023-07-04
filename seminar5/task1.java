package seminar5;

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, 
// что во входной структуре будут повторяющиеся имена с разными телефонами, 
// их необходимо считать, как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phoneBook = GetPhoneBook();
        System.out.println("Исходный книга: ");
        System.out.println(phoneBook);
        PrintPhoneBook(phoneBook);
    }

    public static HashMap<String, ArrayList<String>> GetPhoneBook() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
        System.out.println("Вводите имена и телефоны, чтобы выйти вместо имени введите пустую строку.");
        while (true) {
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            if (name.equals(""))
                break;
            System.out.print("Введите телефон: ");
            String phone = scanner.nextLine();
            ArrayList<String> tmp = new ArrayList<>();
            if (phoneBook.containsKey(name)) {
                tmp = phoneBook.get(name);
            }
            tmp.add(phone);
            phoneBook.put(name, tmp);
        }
        scanner.close();
        return phoneBook;
    }

    public static void PrintPhoneBook(HashMap<String, ArrayList<String>> phoneBook) {
        ArrayList<String> keys = new ArrayList<>();
        phoneBook.keySet().forEach(v -> keys.add(v));
        Collections.sort(keys, (o1, o2) -> phoneBook.get(o2).size() - phoneBook.get(o1).size());
        System.out.println("Фамилия : Телефоны");
        keys.forEach(v -> System.out.println(v + " : " + phoneBook.get(v)));
    }
}