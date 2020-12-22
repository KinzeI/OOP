package lab3;
import java.io.*;
import java.util.Scanner;

public class Menu {
    private static String[] modeIO = {"С консоли","С консоли"};
    public static void setModeIO(String mode, int num, int numOther){
        if(modeIO[numOther].equals(mode) && !(mode.equals("С консоли"))){
            System.out.println("Файл ввода совпадает с файлом вывода, повторите попытку...");
        }
        else {
            if(num==0 && !(mode.equals("С консоли"))) {
                if (checkVoidFile(mode)) System.out.println("Файл пуст, повторите ввод...");
                else modeIO[num] = mode;
            }
            else modeIO[num] = mode;
        }
    }
    public static String getModeIO(int num){return modeIO[num];}
    public static void getModeIO(){
        System.out.println("");
        System.out.println("Ввод: " + modeIO[0] + "\nВывод: " + modeIO[1]);
    }

    private static boolean checkVoidFile(String mode){
        File file = new File("\"D:/Documents/ИРНИТУ/АСУб-19-1/2 курс/ООП/3/Files/\"" + mode);
        if(file.length() == 0) return true;
        else return false;
    }

    public void mainMenu() throws IOException, ClassNotFoundException {
        while(true){
            Scanner in = new Scanner(System.in);
            getModeIO();
            int count = 40;
            String menuString = "|Главное меню/";
            String[] arrayMenuString = "Работа с файлами-Выбор ввода-Выбор вывода-Выбор задания-Выход".split("-");
            frame(menuString,arrayMenuString,count);

            int num = 0;
            try {
                num = Integer.parseInt(in.nextLine());
                if (num < 1 || num >= 6) throw new IllegalArgumentException();
                else {
                    switch (num) {
                        case 1:
                            fileMenu();
                            break;
                        case 2:
                            inputMode();
                            break;
                        case 3:
                            outputMode();
                            break;
                        case 4:
                            taskMenu();
                            break;
                        case 5:
                            break;
                    }
                    if(num==5) break;
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("Некорректный ввод");
            }

        }
    }
    public static void inputMode(){
        while(true){
            Scanner in = new Scanner(System.in);
            getModeIO();
            int count = 40;
            String menuString = "|Главное меню/Выбор ввода/";
            String[] arrayMenuString = "С консоли-С файла-Назад".split("-");
            frame(menuString,arrayMenuString,count);

            int num = 0;
            try {
                num = Integer.parseInt(in.nextLine());
                if (num < 1 || num >= 4) throw new IllegalArgumentException();
                else {
                    switch (num) {
                        case 1:
                            setModeIO("С консоли",0, 1);
                            break;
                        case 2:
                            System.out.println("Выберите файл для ввода");
                            setModeIO(listFiles()[choiceFile()-1],0, 1);

                            break;
                        case 3:
                            break;
                    }
                    if(num==3||num==2||num==1) break;
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("Некорректный ввод");
            }

        }
    }

    public static void outputMode(){
        while(true){
            Scanner in = new Scanner(System.in);
            getModeIO();
            int count = 40;
            String menuString = "|Главное меню/Выбор вывода/";
            String[] arrayMenuString = "С консоли-С файла-Назад".split("-");
            frame(menuString,arrayMenuString,count);

            int num = 0;
            try {
                num = Integer.parseInt(in.nextLine());
                if (num < 1 || num >= 4) throw new IllegalArgumentException();
                else {
                    switch (num) {
                        case 1:
                            setModeIO("С консоли",1,0);
                            break;
                        case 2:
                            System.out.println("Выберите файл для вывода");
                            setModeIO(listFiles()[choiceFile()-1],1,0);
                            break;
                        case 3:
                            break;
                    }
                    if(num==3||num==2||num==1) break;
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("Некорректный ввод");
            }

        }
    }

    public static void taskMenu() throws IOException, ClassNotFoundException {
        getModeIO();
        Arrays arrays = new Arrays();
        Strings strings = new Strings();
        Scanner in = new Scanner(System.in);
        while (true) {
            int count = 40;
            String menuString = "|Главное меню/Выбор задания/";
            String[] arrayMenuString = "Задание а)-Задание б)-Задание в)-Назад".split("-");
            frame(menuString, arrayMenuString, count);

            int num = 0;
            try {
                num = Integer.parseInt(in.nextLine());
                if (num < 1 || num >= 5) throw new IllegalArgumentException();
                else {
                    if (modeIO[0].equals("С консоли")) System.out.println("Введите предложение: ");
                    strings.setInputString();
                }
                switch (num) {
                    case 1:
                        arrays.setArrayString(strings.getInputString());
                        arrays.compareArray(arrays.getArrayString().split(" "), 3);
                        if (modeIO[1].equals("С консоли")) System.out.println(arrays.getArrayString());
                        else editFiles(arrays.getArrayString());
                        break;

                    case 2:
                        if (modeIO[1].equals("С консоли")) System.out.println("Введите предложение: ");
                        String inputString = in.nextLine();
                        if (strings.getInputString().contains(inputString))
                            if (modeIO[1].equals("С консоли")) System.out.println("Найдено");
                            else editFiles("Найдено");
                        else if (modeIO[1].equals("С консоли")) System.out.println("Не найдено");
                        else editFiles("Не найдено");
                        break;

                    case 3:
                        arrays.setArrayString(strings.getInputString());
                        if (modeIO[1].equals("С консоли")) System.out.println(arrays.deleteArray(3));
                        else editFiles(arrays.deleteArray(3));
                        break;
                    case 4:
                        break;
                }
                if (num == 4) break;
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректный ввод");
            }

        }
    }
    public static void fileMenu() {
        Scanner in = new Scanner(System.in);
        while(true){
            getModeIO();
            int count = 40;
            String menuString = "|Главное меню/Работа с файлами:";
            String[] arrayMenuString = "Вывести список файлов-Создать-Удалить-Переименовать-Открыть-Изменить-Назад".split("-");
            frame(menuString,arrayMenuString,count);

            int num = 0;
            try {
                num = Integer.parseInt(in.nextLine());
                if (num < 1 || num >= 8) throw new IllegalArgumentException();
                else {
                    switch (num) {
                        case 1:
                            for(int i=0; i<listFiles().length; i++) {
                                System.out.println(listFiles()[i]);
                            }
                            break;
                        case 2:
                            createFiles();
                            break;
                        case 3:
                            if(listFiles().length!=0)
                                removeFiles();
                            else System.out.println("Файлов не существуют, создайте файл");
                            break;
                        case 4:
                            if(listFiles().length!=0)
                                renameFiles();
                            else System.out.println("Файлов не существуют, создайте файл");
                            break;
                        case 5:
                            if(listFiles().length!=0)
                                openFiles();
                            else System.out.println("Файлов не существуют, создайте файл");
                            break;
                        case 6:
                            if(listFiles().length!=0)
                                editFiles();
                            else System.out.println("Файлов не существуют, создайте файл");
                            break;
                        case 7:
                            break;
                    }
                    if(num==7) break;
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("Некорректный ввод");
            }
        }
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int choiceFile(){
        Scanner in = new Scanner(System.in);
        int indexInput;
        String indexInputString = new String();
        do {
            for (int i = 0; i < listFiles().length; i++) {
                System.out.println("[" + (i + 1) + "]" + listFiles()[i]);
            }
            indexInputString = in.nextLine();

            if (isDigit(indexInputString))
                if(Integer.parseInt(indexInputString)>0 && Integer.parseInt(indexInputString)<listFiles().length)
                    indexInput = Integer.parseInt(indexInputString);
                else {
                    System.out.println("Неверный ввод, повторите попытку...");
                    indexInput = 0;
                }
            else {
                System.out.println("Неверный ввод, повторите попытку...");
                indexInput = 0;
            }
        }while (indexInput>listFiles().length || indexInput<=0);
        return indexInput;
    }


    public static void editFiles(){
        Scanner in = new Scanner(System.in);
        System.out.println("Выберите изменяемый файл");


        try(FileWriter writer = new FileWriter("D:/Documents/ИРНИТУ/АСУб-19-1/2 курс/ООП/3/Files/" + listFiles()[choiceFile()-1], false))
        {
            System.out.println("Введите текст:");
            writer.write(in.nextLine());
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void editFiles(String data){
        try(FileWriter writer = new FileWriter("D:/Documents/ИРНИТУ/АСУб-19-1/2 курс/ООП/3/Files/" + modeIO[1], true))
        {
            writer.write(data + "\r\n");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void openFiles(){
        System.out.println("Выберите файл");
        try(FileReader reader = new FileReader("D:/Documents/ИРНИТУ/АСУб-19-1/2 курс/ООП/3/Files/" + listFiles()[choiceFile()-1]))
        {
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static String openFiles(boolean flag){
        try(FileReader reader = new FileReader("D:/Documents/ИРНИТУ/АСУб-19-1/2 курс/ООП/3/Files/" + modeIO[0]))
        {
            int c;
            StringBuilder sb = new StringBuilder();
            while((c=reader.read())!=-1){
                sb.append((char)c);
            }
            return sb.toString();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static void renameFiles(){
        Scanner in = new Scanner(System.in);
        System.out.println("Выберите переименовываемый файл");
        File file = new File("D:/Documents/ИРНИТУ/АСУб-19-1/2 курс/ООП/3/Files/" + listFiles()[choiceFile()-1]);
        System.out.println("Введите новое имя файла:");
        File file1 = new File("D:/Documents/ИРНИТУ/АСУб-19-1/2 курс/ООП/3/Files/" + in.nextLine() + ".txt");
        try {
            if(file.renameTo(file1))
            {
                System.out.println("Файл переименован...");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void createFiles(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя файла");
        String name = in.nextLine() + ".txt";
        File newFile = new File("D:/Documents/ИРНИТУ/АСУб-19-1/2 курс/ООП/3/Files/" + name);
        try {
            if (!newFile.exists()) {
                boolean created = newFile.createNewFile();
                if (created) System.out.println("Файл создан...");
            }
            else System.out.println("Файл уже существует!");
        }
        catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }

    public static void removeFiles(){
        System.out.println("Выберите удаляемый файл");
        File file = new File("D:/Documents/ИРНИТУ/АСУб-19-1/2 курс/ООП/3/Files/" + listFiles()[choiceFile()-1]);
        try {
            if(file.delete())
            {
                System.out.println("Файл успешно удален...");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static String[] listFiles(){
        try {
            File f = new File("D:/Documents/ИРНИТУ/АСУб-19-1/2 курс/ООП/3/Files");
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File f, String name) {
                    return name.endsWith(".txt");
                }
            };

            File[] files = f.listFiles(filter);
            String[] filesNames = new String[files.length];

            for (int i = 0; i < files.length; i++) {
                filesNames[i] = files[i].getName();
            }
            return filesNames;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }



    public static void frame(String menuString, String[] arrayMenuString, int count){
        System.out.println();
        System.out.println("_".repeat(count));
        System.out.println(menuString = menuString.length()>=count ? menuString.substring(0,count-1)
                + "|" : menuString + " ".repeat(count-1-menuString.length()) + "|");
        for(int j=1; j<=arrayMenuString.length; j++) {
            menuString = ("|" + "[" + j + "] " + arrayMenuString[j-1]);
            System.out.println(menuString = menuString.length()>=count ? menuString.substring(0,count-1)
                    + "|" : menuString + " ".repeat(count-1-menuString.length()) + "|");
        }
        System.out.println("|" + "_".repeat(count-2) + "|");
    }
}
