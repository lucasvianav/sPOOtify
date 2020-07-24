package model;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class AlbumTableModel extends AbstractTableModel {

    private List<Album> data = new ArrayList<>();
    private final int COLUMN_COUNT = 5;

    @Override
    public String getColumnName(int column) { return ""; }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // return the element cover
        int trueIndex = (rowIndex * COLUMN_COUNT) + columnIndex;
        if(trueIndex < data.size())
            return new ImageIcon(data.get(trueIndex).getCover());
        return null;
    }

    public Album getAlbumAt(int rowIndex, int columnIndex) {
        // return the element itself
        int trueIndex = (rowIndex * COLUMN_COUNT) + columnIndex;
        if(trueIndex < data.size())
            return data.get(trueIndex);
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Icon.class;
    }

    public void addAudio(Album newAlbum) {
        data.add(newAlbum);
        this.fireTableDataChanged();
    }
}
