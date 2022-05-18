/**
 *
 *  @author Kryst Jakub PD3724
 *
 */

package zad1;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Main extends JFrame {
	
	
    JList l = new JList(new TempModel());
    
    
	public Main() {
		
		setTitle("Temperatura");
	
        add(l);
        
        JScrollPane sp = new JScrollPane(l);
		add(sp);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
     
        setResizable(false);
		setSize(250,500);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	

	
	  public static void main(String[] a) {
		    SwingUtilities.invokeLater(new Runnable() {

		      public void run() {
		        new Main();
		      }
		    });
		  }

}