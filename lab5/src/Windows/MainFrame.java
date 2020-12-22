package Windows;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainFrame extends JFrame{
    public JMenuItem addMenuItem;
    public JMenuItem deleteMenuItem;
    public JMenuItem observeMenuItem;
    public JMenuItem openFile;
    public JMenuItem saveFile;
    public TableMode tableMode;
    public JTable table;
    public SelectWindow selectWindow = new SelectWindow();
    private JFileChooser chooser = new JFileChooser();


    public MainFrame(String nameFrame){
        super(nameFrame);
        setSize(700,400);
        setLayout(new GridLayout());

        JMenuBar menuBar            = new JMenuBar();
        JMenu menuFile              = new JMenu("Файл");
        JMenu menu                  = new JMenu("Инструметы");


        addMenuItem       = new JMenuItem("Положить");
        deleteMenuItem    = new JMenuItem("Выкинуть");
        observeMenuItem   = new JMenuItem("Осмотреть");
        openFile          = new JMenuItem("Открыть");
        saveFile          = new JMenuItem("Сохранить");

        menuFile.add(openFile);
        menuFile.add(saveFile);
        menu.add(addMenuItem);
        menu.add(deleteMenuItem);
        menu.add(observeMenuItem);


        menuBar.add(menuFile);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        tableMode = new TableMode();
        table = new JTable(tableMode);
        JScrollPane pan = new JScrollPane(table);
        add(pan);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public File showDialog(boolean isSave) {
        int option = isSave ? chooser.showSaveDialog(this) : chooser.showOpenDialog(this);
        if(option == JFileChooser.APPROVE_OPTION){
            return chooser.getSelectedFile();
        }
        return null;
    }

    public void showError(String message){
        JOptionPane.showMessageDialog(null, message);
    }
}
