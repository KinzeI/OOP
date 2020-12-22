package ASUb_19_1;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static Loose mineralLoose  = new Loose();
    private static Gem mineralGem = new Gem();
    private static Stone mineralStone = new Stone();

    public static void main(String[] args){
        mainMenu();
    }

    public static void mainMenu() {
        while (true){

            int numSelectMainMenu = -1;

            System.out.println("           Склад            ");
            System.out.println("----------------------------");
            System.out.println("|1 - Положить минерал      |");
            System.out.println("|2 - Выкинуть минерал      |");
            System.out.println("|3 - Осмотреть склад       |");
            System.out.println("|4 - Показать всё сыпучее  |");
            System.out.println("|5 - Показать все самоцветы|");
            System.out.println("|6 - Показать все камни    |");
            System.out.println("|0 - Выход                 |");
            System.out.println("----------------------------");

            try {
                numSelectMainMenu = Integer.parseInt(in.nextLine());
                if (numSelectMainMenu < 0 || numSelectMainMenu >= 7) throw new IllegalArgumentException();
            }
            catch (IllegalArgumentException e) {
                System.out.println("Некорректный ввод");
            }

            switch (numSelectMainMenu){
                case 1:
                    menuGetNewMineral();
                    break;
                case 2:
                    Storage.readAllNameMineral(true);
                    break;
                case 3:
                    Storage.readAllNameMineral(false);
                    break;
                case 4:
                    Storage.printAllLooses();
                    break;
                case 5:
                    Storage.printAllGems();
                    break;
                case 6:
                    Storage.printAllStones();
                    break;
                case 0:
                    break;
            }
            if(numSelectMainMenu==0) break;
        }
    }



    public static void menuGetNewMineral(){
        int numSelectMainMenu = -1;
        while(true) {
            System.out.println("         Положить           ");
            System.out.println("----------------------------");
            System.out.println("|1 - Сыпучий минерал       |");
            System.out.println("|2 - Самоцвет              |");
            System.out.println("|3 - Камень                |");
            System.out.println("|4 - Случайный             |");
            System.out.println("|0 - Назад                 |");
            System.out.println("----------------------------");

            try {
                numSelectMainMenu = Integer.parseInt(in.nextLine());
                if (numSelectMainMenu < 0 || numSelectMainMenu > 4) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректный ввод");
            }

            switch (numSelectMainMenu) {
                case 1:
                    Storage.addMineral(mineralLoose.getNewMineral());
                    break;
                case 2:
                    Storage.addMineral(mineralGem.getNewMineral());
                    break;
                case 3:
                    Storage.addMineral(mineralStone.getNewMineral());
                    break;
                case 4:
                    Storage.addMineral(randomMineral());
                    break;
                case 0:
                    break;
            }
            if (numSelectMainMenu>=0 && numSelectMainMenu<=4){
                if(numSelectMainMenu!=0)System.out.println("Минерал положил...");
                break;
            }
        }
    }

    public static Mineral randomMineral(){
        return switch ((int) (Math.random() * 3)) {
            case 0 -> mineralLoose.getNewMineral();
            case 1 -> mineralGem.getNewMineral();
            case 2 -> mineralStone.getNewMineral();
            default -> null;
        };
    }
}