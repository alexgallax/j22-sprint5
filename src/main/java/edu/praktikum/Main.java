package edu.praktikum;

import edu.praktikum.models.Proton;
import edu.praktikum.models.Soyuz;
import edu.praktikum.models.SpaceShip;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ships();
        lists();
        sets();
        sorting();
        maps();

        String word = "gorilla";
        System.out.println(countLettersVer1(word));
        System.out.println(countLettersVer2(word));
        System.out.println(countLettersVer3(word));
    }

    /**
     * Коллекция из классов, реализующих один интерфейс
     */
    private static void ships() {
        SpaceShip soyuz = new Soyuz(2);
        SpaceShip proton = new Proton(3);

        List<SpaceShip> ships = new ArrayList<>();
        ships.add(soyuz);
        ships.add(proton);

        System.out.println(ships);
    }

    /**
     * Списки (List)
      */
    private static void lists() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("zxy");
        arrayList.add("abc");

        System.out.println(arrayList);

        /*
        Внутри ArrayList массив, размер которого увеличивается при необходимости

        [    ] -> [       ] -> [             ]
        [ "a",  "zxy", "abc" ]
        [ "a",  "b", "zxy", "abc" ]

        Pros: быстрое чтение элементов, так как к ним можно получить доступ по индексу
        Cons: долгое добавление и удаление элементов, так как необходимо каждый раз сдвигать все последующие элементы
         */

        List<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("zxy");
        linkedList.add("abc");

        System.out.println(linkedList);

        /*
        Внутри LinkedList ноды, каждая хранит значение элемента и ссылки на предыдущую и следующую ноду

        ("a")-> <-("zxy")-> <-("abc")
        ("a")-> <-("b")-> <-("zxy")-> <-("abc")

        Pros: быстрое добавление и удаление элементов, так как нужно только добавить ноду
        и изменить ссылки у соседних нод
        Cons: долгое чтение элементов, так как каждый раз вычитывание происходит с начала списка,
        пока по ссылкам не дойдет до нужного элемента
         */
    }

    /**
     * Set и получение списка только с уникальными значениями элементов
     */
    private static void sets() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("a");
        arrayList.add("zxy");
        arrayList.add("abc");

        System.out.println(arrayList);

        Set<String> set = new HashSet<>(arrayList);
        Set<String> linkedHashSet = new LinkedHashSet<>(arrayList);
        Set<String> treeSet = new TreeSet<>(arrayList);

        System.out.println(set);
        System.out.println(linkedHashSet);
        System.out.println(treeSet);
    }

    /**
     * Сортировка объектов (Comparable)
     */
    private static void sorting() {
        List<SpaceShip> arrayList = new ArrayList<>();
        arrayList.add(new Soyuz(10));
        arrayList.add(new Proton(2));
        arrayList.add(new Soyuz(2));

        System.out.println(arrayList);

        Collections.sort(arrayList);

        System.out.println(arrayList);
    }

    /**
     * Map
     */
    private static void maps() {
        Soyuz soyuz01 = new Soyuz(2);
        Soyuz soyuz02 = new Soyuz(2);

        System.out.println(Objects.equals(soyuz01, soyuz02));

        Map<SpaceShip, String> mapEqualKeys = new HashMap<>();
        mapEqualKeys.put(soyuz01, "Souyz");
        mapEqualKeys.put(soyuz02, "Souyz 2");

        System.out.println(mapEqualKeys);


        Soyuz soyuz11 = new Soyuz(2);
        Soyuz soyuz12 = new Soyuz(3);

        System.out.println(Objects.equals(soyuz11, soyuz12));

        Map<SpaceShip, String> mapNotEqualKeys = new HashMap<>();
        mapNotEqualKeys.put(soyuz11, "Souyz");
        mapNotEqualKeys.put(soyuz12, "Souyz 2");

        System.out.println(mapNotEqualKeys);
    }

    /**
     * Подсчет количества каждого символа в слове
     * @param word - слово для подсчета символов
     * @return Map, в качестве ключей - символы, в качестве значений - общее количество соответствующего символа в слове
     */
    private static Map<Character, Integer> countLettersVer1(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int count = map.getOrDefault(letter, 0);
            map.put(letter, count + 1);
        }
        return map;
    }

    /**
     * Подсчет количества каждого символа в слове
     * @param word - слово для подсчета символов
     * @return Map, в качестве ключей - символы, в качестве значений - общее количество соответствующего символа в слове
     */
    private static Map<Character, Integer> countLettersVer2(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (map.get(letter) == null) {
                map.put(letter, 1);
            } else {
                map.put(letter, map.get(letter) + 1);
            }
        }
        return map;
    }

    /**
     * Подсчет количества каждого символа в слове
     * @param word - слово для подсчета символов
     * @return Map, в качестве ключей - символы, в качестве значений - общее количество соответствующего символа в слове
     */
    private static Map<Character, Integer> countLettersVer3(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            map.merge(letter, 1, Integer::sum);
        }
        return map;
    }
}
