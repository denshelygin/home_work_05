//Пусть дан список сотрудников:
// Иван Иванов,Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов,
//Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, 
// Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов
//Написать программу, которая найдет и выведет повторяющиеся имена с 
// количеством повторений. Отсортировать по убыванию популярности.

package DZ5.DZ_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HW2 {
    public static void main(String[] args) {
        String[] emploees = new String[] { "Иван Иванов", "Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов",
                "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова",
                "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов" };

        ArrayList<String> emploeesName = new ArrayList<>();
        for (String item : emploees) {
            emploeesName.add(item.split(" ")[0]);
        }

        Map<String, Integer> name = new HashMap<>();
        for (int i = 0; i < emploeesName.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < emploeesName.size(); j++) {
                if (emploeesName.get(i).equals(emploeesName.get(j))) {
                    count++;
                }
            }
            if (name.containsKey(emploeesName.get(i)) == false) {
                name.put(emploeesName.get(i), count);
            }
        }

        ArrayList<Integer> listCount = new ArrayList<>();
        for (var item : name.entrySet()) {
            if (listCount.contains(item.getValue()) == false)
                listCount.add(item.getValue());
        }
        System.out.println("Сортированный список повторяющихся имён: ");
        listCount.sort(null);
        for (int i = listCount.size() - 1; i >= 0; i--) {
            for (var item : name.entrySet()) {
                if (listCount.get(i) == item.getValue()) {
                    System.out.println(item.getKey() + " - " + item.getValue());
                }
            }
        }
    }
}
