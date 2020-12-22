package lab2;
import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner in = new Scanner(System.in);
        Arrays arrays = new Arrays();
        Strings strings = new Strings();

        while (true) {
            System.out.println("Выбор задания:\n \t[0] Проверка конструкторов\n \t[1] Задание а)\n \t[2] Задание б)\n \t[3] Задание в)\n \t[4] Выход");
            int n = Integer.parseInt(in.nextLine());

            if (n < 4 && n > 0) {
                System.out.println("Введите предложение: ");
                strings.setInputString();
            }
            switch (n){
                case 0:
                    System.out.println("Проверка работы сериализации объекта, сравнение с дефолтным объектом:");
                    Arrays arrays1 = new Arrays();
                    Arrays arrays2 = Arrays.copyOfSerialization(arrays1);
                    arrays1.setArrayString("Сомы грамм и нету драмм");
                    System.out.println("arrays1.num="+arrays1.getArrayString());
                    System.out.println("arrays2.num="+arrays2.getArrayString());
                    System.out.println("Проверка работы копирования объекта:");
                    Strings strings1 = new Strings("Состояние в норме...");
                    Strings strings2 = new Strings(strings1);
                    strings1.setInputString();
                    System.out.println("string1.inputString="+strings1.getInputString());
                    System.out.println("string2.inputString="+strings2.getInputString());
                    System.out.println("Проверка работы копирования по умолчанию");
                    Strings strings3 = new Strings();
                    Strings strings4 = new Strings();
                    strings4.setInputString();
                    System.out.println("string3.inputString="+strings3.getInputString());
                    System.out.println("string4.inputString="+strings4.getInputString());
                    break;

                case 1:
                    arrays.setArrayString(strings.getInputString());
                    arrays.compareArray(arrays.getArrayString().split(" "), 3);
                    System.out.println(arrays.getArrayString());
                    break;

                case 2:
                    System.out.println("Введите предложение: ");
                    String inputString = in.nextLine();
                    if (strings.getInputString().contains(inputString))
                        System.out.println("Найдено");
                    else
                        System.out.println("Не найдено");
                    break;

                case 3:
                    arrays.setArrayString(strings.getInputString());
                    System.out.println(arrays.deleteArray(3));
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
