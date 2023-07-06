package Homework;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Laptop> newCatalog = Laptop.createCatalog();
        Laptop.filterLaptopMemory(newCatalog);
        Laptop.filterLaptopHardDisc(newCatalog);
        Laptop.filterLaptopOS(newCatalog);
        Laptop.filterLaptopColor(newCatalog);
        Laptop.filterLaptopAll(newCatalog);
    }
}