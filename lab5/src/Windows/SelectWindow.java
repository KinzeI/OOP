package Windows;

import javax.swing.*;
import java.awt.*;

public class SelectWindow extends JDialog {

    public JButton button;
    private String[] types = new String[]{"Сыпучий минерал","Самоцвет","Камень","Случайный"};
    private JComboBox comboBox;

    public SelectWindow(){
        super();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2,2,2));
        comboBox = new JComboBox(types);
        button = new JButton("Положить");

        panel.add(comboBox);
        panel.add(button);
        add(panel);
        pack();
        setSize(200, 100);
    }

    public String getTypeChoice() {
        return comboBox.getSelectedItem().toString();
    }
}
