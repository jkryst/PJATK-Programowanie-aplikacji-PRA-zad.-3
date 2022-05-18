package zad1;

import javax.swing.AbstractListModel;

public class TempModel extends AbstractListModel {

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 131;
	}

	@Override
	public Object getElementAt(int i) {
		// TODO Auto-generated method stub
		int j = i -70;
		return j+" stopni C  =  "+(j*9/5+32)+" stopni F";
	}
	
	

}
