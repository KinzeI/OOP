package Controllers;

import Minerals.*;
import Windows.MainFrame;
import Windows.SelectWindow;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Controller {
    private MainFrame view;

    private void executeSelect(SelectWindow select) {
        select.button.addActionListener(e -> {
            String type = view.selectWindow.getTypeChoice();

            Mineral mineral = null;
            switch(type) {
                case "Сыпучий минерал" -> mineral = new Loose();
                case "Самоцвет" -> mineral = new Gem();
                case "Камень" -> mineral = new Stone();
                case "Случайный" -> mineral = Storage.randomMineral();
            }

            Storage.addMineral(mineral);
            view.tableMode.update();
            select.dispose();
        });
    }

    public void execute(MainFrame frame) {
        view = frame;
        executeSelect(view.selectWindow);


        view.addMenuItem.addActionListener(e -> {
            view.selectWindow.setVisible(true);
        });

        view.observeMenuItem.addActionListener(e ->{
            try{
                Mineral mineral = Storage.mineralList.get(view.table.getSelectedRow());
                if (mineral instanceof Loose) {
                    view.showError("Рассыпалось");
                }
                mineral.observe();
            }
            catch (IndexOutOfBoundsException err) {
                if (Storage.mineralList.size() == 0) return;
                Storage.mineralList.get(Storage.mineralList.size() - 1).observe();
            }
            view.tableMode.update();
        });

        view.deleteMenuItem.addActionListener(e -> {
            try {
                Storage.removeMineral(view.table.getSelectedRow());
            } catch (IndexOutOfBoundsException err) {
                if (Storage.mineralList.size() == 0) return;
                Storage.removeMineral(Storage.mineralList.size() - 1);
            }
            view.tableMode.update();
        });

        view.saveFile.addActionListener(e ->{
            File file = view.showDialog(true);
            if(file == null) return;
            String data = constructor(Storage.mineralList);
            try(FileWriter writer = new FileWriter(file)){
                writer.write(data);
            } catch (IOException ioException) {
                view.showError("При записи файла произошла ошибка!");
            }
        });

        view.openFile.addActionListener(e ->{
            File file = view.showDialog(false);
            if(file == null) return;
            try {
                Storage.mineralList =  destructor(Files.readString(Path.of(String.valueOf(file))));
            } catch (IOException ioException) {
                view.showError("Ошибка в чтении файла");
            }
            catch (IndexOutOfBoundsException | IllegalArgumentException err){
                view.showError("Неверный формат файла");
            }
            view.tableMode.update();
        });
    }

    private String constructor(ArrayList<Mineral> mineralList){
        StringBuilder sb = new StringBuilder();
        for(Mineral mineral : mineralList){
            sb.append(mineral.nameMineral).append(";").append(mineral.description).
                    append(";").append(mineral.isObserved).append(";").append(mineral.type).
                    append("\r\n");
        }
        return sb.toString();
    }

    private ArrayList<Mineral> destructor(String line) throws IndexOutOfBoundsException,IllegalArgumentException{
        ArrayList<Mineral> arrayList = new ArrayList<>();
        String[] stringArray = line.split("\r\n");
        for(String mineralString : stringArray){
            String[] stringArrayLine = mineralString.split(";");
            String name = stringArrayLine[0];
            String description = stringArrayLine[1];
            boolean isObserve = Boolean.parseBoolean(stringArrayLine[2]);
            String type = stringArrayLine[3];
            Mineral mineral = switch (type){
                case "Gem"-> new Gem(name,description,type,isObserve);
                case "Loose"-> new Loose(name,description,type,isObserve);
                case "Stone"-> new Stone(name,description,type,isObserve);
                default -> throw new IllegalArgumentException("Неверный тип в файле");
            };
            arrayList.add(mineral);
        }
        return arrayList;
    }
}
