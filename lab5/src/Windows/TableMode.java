package Windows;


import Minerals.Storage;

import javax.swing.table.AbstractTableModel;

public class TableMode extends AbstractTableModel {
    public void update() {
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return Storage.mineralList.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> rowIndex + 1;
            case 1 -> Storage.mineralList.get(rowIndex).nameMineral;
            case 2 -> Storage.mineralList.get(rowIndex).description;
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
    }

    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "№";
            case 1 -> "Название";
            case 2 -> "Описание";
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
    }
}
