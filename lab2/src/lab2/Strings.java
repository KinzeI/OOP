package lab2;
import java.util.Scanner;
public class Strings {

    private String inputString;
    public Strings(){
        this.inputString = "рааааал";
    }
    public Strings(String arg1){
        this.inputString = arg1;
    }
    public Strings(Strings object){
        this.inputString = object.getInputString();
    }

    public String getInputString(){
        return inputString;
    }

    public void setInputString(){
        Scanner in = new Scanner(System.in);
        inputString = in.nextLine();
    }

    public static char searchChar(String elemArrayString, int n){
        return elemArrayString.length() >= n ?
                elemArrayString.charAt(n-1) :
                elemArrayString.charAt(elemArrayString.length() - 1);
    }
}
