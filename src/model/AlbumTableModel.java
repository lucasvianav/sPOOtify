package model;

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
        return data.get((rowIndex * COLUMN_COUNT) + columnIndex).getCover();
    }

    public Album getAlbumAt(int rowIndex, int columnIndex) {
        // return the element itself
        return data.get((rowIndex * COLUMN_COUNT) + columnIndex);
    }

    public void addAudio(Album newAlbum) {
        data.add(newAlbum);
        this.fireTableDataChanged();
    }
}
