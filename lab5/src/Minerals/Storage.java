package Minerals;

import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static Scanner in = new Scanner(System.in);
    public static ArrayList<Mineral> mineralList = new ArrayList<>();

    public static void addMineral(Mineral mineral){
        mineralList.add(mineral);
    }

    public static void removeMineral(Mineral mineral) throws IndexOutOfBoundsException  {
        mineralList.remove(mineral);
    }

    public static void removeMineral(int ind) throws IndexOutOfBoundsException {
        mineralList.remove(ind);
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
                mineralList.get(numSelectMenu-1).changeDescription();
            }
        }
    }

    public static Mineral randomMineral(){
        return switch ((int) (Math.random() * 3)) {
            case 0 -> new Loose();
            case 1 -> new Gem();
            case 2 -> new Stone();
            default -> null;
        };
    }


}
