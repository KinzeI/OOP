package ASUb_19_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static Scanner in = new Scanner(System.in);
    public static ArrayList<Mineral> mineralList = new ArrayList<>();

    public static void addMineral(Mineral mineral){
        mineralList.add(mineral);
    }

    public static void removeMineral(Mineral mineral){
        mineralList.remove(mineral);
    }

    private static void printNameMineral(ArrayList<Mineral> mineralList){
        for (int i = 0; i < mineralList.size(); i++) {
            System.out.println("[" + (i + 1) + "]\t" + mineralList.get(i).nameMineral);
            System.out.println("\tОписание: " + mineralList.get(i).description);
        }
    }

    public static void printAllGems(){
        ArrayList<Mineral> filterGems = new ArrayList<>();
        for(Mineral mineral: mineralList){
            if(mineral instanceof Gem) filterGems.add(mineral);
        }
        printNameMineral(filterGems);
    }

    public static void printAllStones(){
        ArrayList<Mineral> filterGems = new ArrayList<>();
        for(Mineral mineral: mineralList){
            if(mineral instanceof Stone) filterGems.add(mineral);
        }
        printNameMineral(filterGems);
    }

    public static void printAllLooses(){
        ArrayList<Mineral> filterGems = new ArrayList<>();
        for(Mineral mineral: mineralList){
            if(mineral instanceof Loose) filterGems.add(mineral);
        }
        printNameMineral(filterGems);
    }

    public static void readAllNameMineral(boolean flag) {
        int numSelectMenu = -1;
        while(true){
            printNameMineral(mineralList);
            System.out.println("[0]\tНазад");
            System.out.println("Выбрать: ");
            try {
                numSelectMenu = Integer.parseInt(in.nextLine());
                if (numSelectMenu < 0 || numSelectMenu > mineralList.size()) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректный ввод");
            }
            if(numSelectMenu>=0 && numSelectMenu <= mineralList.size()) break;
        }
        if(numSelectMenu != 0){
            if(flag){
                removeMineral(mineralList.get(numSelectMenu-1));
                System.out.println("Выкинул...");
            }
            else{
                mineralList.get(numSelectMenu-1).observe();
            }
        }
    }
}
