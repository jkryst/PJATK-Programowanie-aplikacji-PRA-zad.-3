/**
 *
 *  @author Kryst Jakub PD3724
 *
 */

package zad2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class Main extends JFrame {
	
	
	DefaultListModel lm = new DefaultListModel();
	JList list = new JList(lm);
	
    JTextField tf = new JTextField();
    
    
	public Main() {
		
		setTitle("Lista");
	    
		setLayout(new BorderLayout(0, 5));
      
		tf.addActionListener(nowytekst);
		add(tf, BorderLayout.NORTH);
		
		list.addMouseListener(usuwanie);
        JScrollPane sp = new JScrollPane(list);
		add(sp, BorderLayout.CENTER);
		
	
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
    
        
		setSize(250, 400);
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
	  
	  
	  private ActionListener nowytekst = new ActionListener() {
			@Override
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					
				String r = tf.getText();
				lm.addElement(r);
				tf.setText("");
				
				
			}
	  };
  
	  
	  
	   private MouseListener usuwanie = new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int i = list.getSelectedIndex();
			
			if (e.isAltDown() == true) {
				lm.remove(i);
			}
		}

	  };

}