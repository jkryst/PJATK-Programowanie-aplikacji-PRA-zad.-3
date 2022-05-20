package zad3;

import javax.swing.table.AbstractTableModel;

public class KsiazkiTabModel extends AbstractTableModel {
	
	
	static String[] columnNames = { "Okładka", "Tytuł",
            "Autor", "Cena"};

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getColumnName(int i) {
		    return columnNames[i];
    }
	
	public boolean isCellEditable(int i, int j) {
		
		if (j == 0 || j == 1  || j == 2) {  
		      return false;
		    } else {
		      return true;
		    }	
		
		
	}
	  
	  
	  
	  

}
