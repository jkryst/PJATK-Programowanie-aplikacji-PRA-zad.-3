/**
 *
 *  @author Kryst Jakub PD3724
 *
 */

package zad3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Main extends JFrame {
	
	
	
	JTable tb = new JTable(new KsiazkiTabModel());
	
	JButton wczytajksiazke = new JButton("Wczytaj książki z pliku");
	
	JPanel dodksiazek = new JPanel();
	JPanel polaksiazek = new JPanel();
   
    
    
	public Main() {
		
		setTitle("Książki");
		setLayout(new BorderLayout(0, 10));
		
		
	     
	     JScrollPane sp = new JScrollPane(tb);
		 add(sp, BorderLayout.NORTH);
		 
		 add(wczytajksiazke, BorderLayout.CENTER);
		 
		 
		 
		 
		 add(dodksiazek, BorderLayout.SOUTH);
		 
		 dodksiazek.setLayout(new BorderLayout());
		 
		 dodksiazek.setBorder(BorderFactory.createTitledBorder("lub dodaj nową książkę"));
		 
		 dodksiazek.add(polaksiazek, BorderLayout.CENTER);
		 
		 polaksiazek.add(new JButton("Wybierz obraz"));
		 addLabAndTxtFld("Tytuł");
		 addLabAndTxtFld("Autor");
		 addLabAndTxtFld("Cena");
		 
		 dodksiazek.add(new JButton("Dodaj książkę"), BorderLayout.SOUTH);
		 
		 
		 
		 
		 
		 
		 
		 
		 
		
		
      
		
		
		
		
       
		
		
	
		
		
		 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        
        
        setResizable(true);
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
	  
	  
	  
	  void addLabAndTxtFld(String txt) {
		    JLabel l = new JLabel(txt);
		    l.setHorizontalAlignment(JLabel.RIGHT);
		    JTextField tf = new JTextField(10);
		    l.setLabelFor(tf);
		    
		    polaksiazek.add(l);
		    polaksiazek.add(tf);
		  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  private ActionListener nowytekst = new ActionListener() {
			@Override
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					
				
				
				
			}
	  };
  
	  
	  
	   private MouseListener usuwanie = new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
		
		}

	  };

}