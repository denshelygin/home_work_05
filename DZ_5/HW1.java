//1.Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

package DZ5.DZ_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Map<String, List<String>> phonBook = new HashMap<>();
        phonBook.put("Egor", List.of("8-977-254-34-32", "8-985-328-64-77"));
        phonBook.put("Tommy", List.of("8-800-555-35-35", "8-952-770-00-22"));
        phonBook.put("Nikolay", List.of("8-906-777-77-77", "8-495-863-21-98"));
        phonBook.put("Magamed", List.of("8-902-686-49-75", "8-908-929-08-09"));
        phonBook.put("Bill", List.of("8-963-498-21-56", "8-495-513-45-28"));

        menu(phonBook);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }

    public static void find(Map<String, List<String>> phonBook) {
        System.out.println("Введите имя контакта: ");
        String name = scanner();
        System.out.println(phonBook.get(name));
    }

    public static void allBook(Map<String, List<String>> phonBook) {
        System.out.println(phonBook);

    }

    public static Map<String, List<String>> add(Map<String, List<String>> phonBook) {
        System.out.println("Что бы перестать вводить номера введите 'stop'");
        System.out.println("Введите имя контакта: ");
        String name = scanner();
        List<String> number = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер контакта: ");
            String phon = scanner();
            if (phon.equals("stop")) {
                break;
            } else {
                number.add(phon);
            }
        }
        phonBook.put(name, number);

        return phonBook;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> phonBook) {
        System.out.println(
                "Введите команду из списка:" + "\n" + "find - Поиск контакта" + "\n" + "add - Добавление контакта"
                        + "\n" + "all - Показать всю телефонную книгу" + "\n" + "exit - Выход");
        while (true) {
            String comands = scanner();
            if (comands.equals("exit")) {
                break;
            } else {
                switch (comands) {
                    case "find":
                        find(phonBook);
                        break;
                    case "add":
                        add(phonBook);
                        break;
                    case "all":
                        allBook(phonBook);
                        break;
                    default:
                        break;
                }
            }
        }
        return phonBook;
    }
}
