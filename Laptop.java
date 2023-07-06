package Homework;

import java.util.*;

public class Laptop {
    public String name;
    public Integer memory;
    public Integer hardDisc;
    public String os;
    public String color;
    public Integer cost;

    public Laptop(String name, Integer memory, Integer hardDisc, String os, String color, Integer cost) {
        this.name = name;
        this.memory = memory;
        this.hardDisc = hardDisc;
        this.os = os;
        this.color = color;
        this.cost = cost;
    }

    public Laptop() {
    }

    @Override
    public String toString() {
        return "Ноутбук {" +
                "Название: '" + name + '\'' +
                ", Оперативная память: " + memory +
                ", Жесткий диск: " + hardDisc +
                ", Операционная система: '" + os + '\'' +
                ", Цвет: '" + color + '\'' +
                ", Цена: " + cost +
                '}';
    }

    public Integer getMemory() {
        return memory;
    }

    public Integer getHardDisc() {
        return hardDisc;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    /**
     * @return каталог в формате ArrayList
     * @apiNote создает актуальный каталог ноутбуков
     */
    public static ArrayList<Laptop> createCatalog() {
        Laptop laptop1 = new Laptop("Asus", 16, 512, "Linux", "серебристый", 47000);
        Laptop laptop2 = new Laptop("Haier", 8, 512, "Linux", "серый", 35000);
        Laptop laptop3 = new Laptop("Thunderobot", 8, 256, "Linux", "черный", 65000);
        Laptop laptop4 = new Laptop("MacBook", 8, 256, "MacOS", "серый", 86500);
        Laptop laptop5 = new Laptop("Huawei", 8, 512, "Windows", "серебристый", 50000);
        Laptop laptop6 = new Laptop("Honor", 8, 512, "Windows", "серебристый", 52000);
        Laptop laptop7 = new Laptop("MSI", 16, 512, "Windows", "черный", 110000);
        Laptop laptop8 = new Laptop("Xiaomi", 8, 556, "Windows", "серый", 40000);
        Laptop laptop9 = new Laptop("HP", 4, 1000, "Windows", "черный", 18000);
        List<Laptop> catalog = new ArrayList<>();
        catalog.add(laptop1);
        catalog.add(laptop2);
        catalog.add(laptop3);
        catalog.add(laptop4);
        catalog.add(laptop5);
        catalog.add(laptop6);
        catalog.add(laptop7);
        catalog.add(laptop8);
        catalog.add(laptop9);
        return (ArrayList<Laptop>) catalog;
    }

    /**
     * @param catalog каталог ноутбуков ArrayList
     * @return отфильтрованный каталог ArrayList
     * @apiNote фильтрует товары по минимально введеным требованиям к оперативной памяти
     */
    public static Map<Integer, Laptop> filterLaptopMemory(ArrayList<Laptop> catalog) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Laptop> filterMemory = new HashMap<>();
        System.out.println("Введите желаемый объем памяти: ");
        Integer wantMemory = sc.nextInt();
        for (int i = 0; i < catalog.size(); i++) {
            if (wantMemory <= catalog.get(i).getMemory()) {
                filterMemory.put(i + 1, catalog.get(i));
                System.out.println(catalog.get(i));
            }
        }
        return filterMemory;
    }

    /**
     * @param catalog каталог ноутбуков ArrayList
     * @return отфильтрованный каталог ArrayList
     * @apiNote фильтрует по минимальным требованиям к жесткому диску
     */
    public static Map<Integer, Laptop> filterLaptopHardDisc(ArrayList<Laptop> catalog) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Laptop> filterHardDisc = new HashMap<>();
        System.out.println("Введите желаемый объем жесткого диска: ");
        Integer wantHardDisc = sc.nextInt();
        for (int i = 0; i < catalog.size(); i++) {
            if (wantHardDisc <= catalog.get(i).getHardDisc()) {
                filterHardDisc.put(i + 1, catalog.get(i));
                System.out.println(catalog.get(i));
            }
        }
        return filterHardDisc;
    }

    /**
     * @param catalog catalog каталог ноутбуков ArrayList
     * @return отфильтрованный каталог ArrayList
     * @apiNote фильтрует по желаемой операционной системе
     */
    public static Map<Integer, Laptop> filterLaptopOS(ArrayList<Laptop> catalog) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Laptop> filterOs = new HashMap<>();
        System.out.println("Введите желаемую операционную систему: ");
        String wantOS = sc.nextLine().toLowerCase();
        for (int i = 0; i < catalog.size(); i++) {
            if (wantOS.equals(catalog.get(i).getOs().toLowerCase())) {
                filterOs.put(i + 1, catalog.get(i));
                System.out.println(catalog.get(i));
            }
        }
        return filterOs;
    }

    /**
     * @param catalog catalog каталог ноутбуков ArrayList
     * @return отфильтрованный каталог ArrayList
     * @apiNote фильтрует по желаемому цвету ноутбука
     */
    public static Map<Integer, Laptop> filterLaptopColor(ArrayList<Laptop> catalog) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Laptop> filterColor = new HashMap<>();
        System.out.println("Введите желаемый цвет: ");
        String wantColor = sc.nextLine().toLowerCase();
        for (int i = 0; i < catalog.size(); i++) {
            if (wantColor.equals(catalog.get(i).getColor().toLowerCase())) {
                filterColor.put(i + 1, catalog.get(i));
                System.out.println(catalog.get(i));
            }
        }
        return filterColor;
    }

    /**
     * @param catalog catalog каталог ноутбуков ArrayList
     * @apiNote фильрует сразу по всем характеристикам, выводя промежуточный результат по каждому фильтру
     */
    public static void filterLaptopAll(ArrayList<Laptop> catalog) {
        Map<Integer, Laptop> map1 = new HashMap<>(filterLaptopMemory(catalog));
        Map<Integer, Laptop> map2 = new HashMap<>(filterLaptopHardDisc(catalog));
        Map<Integer, Laptop> map3 = new HashMap<>(filterLaptopOS(catalog));
        Map<Integer, Laptop> map4 = new HashMap<>(filterLaptopColor(catalog));
        Set<Integer> intersection1 = new HashSet<>(map1.keySet());
        Set<Integer> intersection2 = new HashSet<>(map2.keySet());
        Set<Integer> intersection3 = new HashSet<>(map3.keySet());
        Set<Integer> intersection4 = new HashSet<>(map4.keySet());
        intersection1.retainAll(intersection2);
        intersection1.retainAll(intersection3);
        intersection1.retainAll(intersection4);
        System.out.println("Вам ИДЕАЛЬНО подходит: ");
        Map<Integer, Laptop> resultFilter = new HashMap<>();
        for (Integer key : intersection1) {
            resultFilter.put(key, map1.get(key));
            System.out.println(resultFilter.get(key));
        }
    }
}