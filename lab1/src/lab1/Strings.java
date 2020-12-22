package lab1;
import java.util.Scanner;

public class Strings {

    Scanner in = new Scanner(System.in);
    public void z1(String mes){

        String[] mes2;
        mes2 = mes.split(" ");

        for(int i=0; i<mes2.length-1; i++){
            for(int j=i+1;j<mes2.length;j++) {

                char a = mes2[i].length() >= 3 ?
                        mes2[i].charAt(2) :
                        mes2[i].charAt(mes2[i].length() - 1);

                char b = mes2[j].length() >= 3 ?
                        mes2[j].charAt(2) :
                        mes2[j].charAt(mes2[j].length() - 1);

                if (a > b){
                    String temp = mes2[i];
                    mes2[i]=mes2[j];
                    mes2[j]=temp;
                }
            }
        }
        StringBuilder builder = new StringBuilder();

        for (String word : mes2) {
            builder.append(word + ' ');
        }
        System.out.println(builder.toString());
    }
    public void z2(String mes){

        System.out.println("Введите предложение: ");
        String word = in.nextLine();
        if (mes.contains(word))
            System.out.println("Найдено");
        else
            System.out.println("Не найдено");
    }
    public void z3(String mes){
        StringBuilder builder = new StringBuilder();
        String[] mes2;
        mes2 = mes.split(" ");
        for (int i=0; i< mes2.length; i++){
            if ((i+1)%3!=0){
                builder.append(mes2[i] + " ");
            }
        }
        System.out.println(builder.toString());
    }
}
