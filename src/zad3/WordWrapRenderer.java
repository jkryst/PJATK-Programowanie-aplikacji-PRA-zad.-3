package zad3;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class WordWrapRenderer extends JTextArea implements TableCellRenderer
{
    WordWrapRenderer()
    {
        setLineWrap(true);
        setWrapStyleWord(true);
        setFocusable(true);
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        setText( (value == null) ? "" : value.toString() );
        setSize(table.getColumnModel().getColumn(column).getWidth(), table.getRowHeight(row));
        
        
        Color bc = new Color(255, 255, 255);
       
          setBackground(isSelected ? new Color(165,191,221) : bc);
          


        int preferredHeight = 100;

        if (table.getRowHeight(row) != preferredHeight)
        {
            table.setRowHeight(row, preferredHeight);
        }

        return this;
    }
}