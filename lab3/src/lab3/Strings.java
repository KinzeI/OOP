package lab3;

import java.util.Scanner;
public class Strings {

    private String inputString;

    public String getInputString(){
        return inputString;
    }

    public void setInputString(){
        Scanner in = new Scanner(System.in);
        Menu menu = new Menu();
        if(menu.getModeIO(0).equals("С консоли")) inputString = in.nextLine();
        else inputString = Menu.openFiles(true);
    }

    public static char searchChar(String elemArrayString, int n){
        return elemArrayString.length() >= n ?
                elemArrayString.charAt(n-1) :
                elemArrayString.charAt(elemArrayString.length() - 1);
    }
}
