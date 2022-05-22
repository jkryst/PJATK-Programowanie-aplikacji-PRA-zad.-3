package zad3;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class KsiazkiTabModel extends DefaultTableModel {
	
	
	
	
	
	static String[] columnNames = { "Okładka", "Tytuł",
            "Autor", "Cena"};

	
	public int getColumnCount() {
		return 4;
	}
	
	
	public String getColumnName(int i) {
		    return columnNames[i];
    }
	
	public Class<?> getColumnClass(int i) {
		
		
		return getValueAt(0, i).getClass();
		
	}
	
	public boolean isCellEditable(int i, int j) {
		
		if (j == 3) {  
		      return true;
		} else {
		return false;
		}   
		
		
	}

}
