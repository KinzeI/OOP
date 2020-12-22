package lab1;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String inputString = null;
        Arrays Array = new Arrays();

        while(true) {
            System.out.println("Выбор задания:\n \t[1] Задание а)\n \t[2] Задание б)\n \t[3] Задание в)\n \t[4] Выход");
            int n = Integer.parseInt(in.nextLine());

            if(n<4 && n>0) {
                System.out.println("Введите предложение: ");
                inputString = in.nextLine();
            }

            switch (n) {


                case 1:
                {
                    String[] arrayString;
                    arrayString = Array.createArray(inputString);

                    for(int i=0; i<arrayString.length-1; i++){
                        for(int j=i+1;j<arrayString.length;j++) {

                            char a = arrayString[i].length() >= 3 ?
                                    arrayString[i].charAt(2) :
                                    arrayString[i].charAt(arrayString[i].length() - 1);

                            char b = arrayString[j].length() >= 3 ?
                                    arrayString[j].charAt(2) :
                                    arrayString[j].charAt(arrayString[j].length() - 1);

                            if (a > b){
                                String temp = arrayString[i];
                                arrayString[i]=arrayString[j];
                                arrayString[j]=temp;
                            }
                        }
                    }
                    StringBuilder builder = new StringBuilder();

                    for (String word : arrayString) {
                        builder.append(word + ' ');
                    }
                    System.out.println(builder.toString());
                }
                break;


                case 2:
                {
                    System.out.println("Введите предложение: ");
                    String word = in.nextLine();
                    if (inputString.contains(word))
                        System.out.println("Найдено");
                    else
                        System.out.println("Не найдено");
                }
                break;


                case 3:
                {
                    StringBuilder builder = new StringBuilder();
                    String[] arrayString;
                    arrayString = inputString.split(" ");
                    for (int i=0; i< arrayString.length; i++){
                        if ((i+1)%3!=0){
                            builder.append(arrayString[i] + " ");
                        }
                    }
                    System.out.println(builder.toString());
                }
                break;


                case 4:
                    return;
                default:
                    System.out.println("Неверный ввод, повторите попытку...");
                    break;
            }
        }
    }
}

