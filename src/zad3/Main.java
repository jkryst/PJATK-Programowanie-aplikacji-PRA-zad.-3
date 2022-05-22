/**
 *
 *  @author Kryst Jakub PD3724
 *
 */

package zad3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class Main extends JFrame {
	
	
	KsiazkiTabModel tbm = new KsiazkiTabModel();
	JTable tb = new JTable(tbm);
	
	JButton wczytajksiazki = new JButton("Wczytaj książki z pliku");
	JButton grafika = new JButton("Wybierz okładkę");
	JButton dodksiazke = new JButton("Dodaj książkę");
	JButton usunzaznaczone = new JButton("Usuń zaznaczoną książkę");
	
	JPanel noweksiazki = new JPanel();
	JPanel polaksiazek = new JPanel();
	
	String imgname;
	
	String tyt;
	JTextField tytul = new JTextField(10);
	
	String aut;
	JTextField autor = new JTextField(10);
	
	String cen;
	JTextField cena = new JTextField(10);

	JFileChooser fc = new JFileChooser(new File("."));
	File f;
	

    
	public Main() {
		
		setTitle("Książki");
		
		setLayout(new BorderLayout(0, 10));
	     
		 tb.setRowHeight(100);
		 tb.getColumn("Okładka").setMaxWidth(70);
		 
		 tb.getColumn("Tytuł").setCellRenderer(new WordWrapRenderer());
		 tb.getColumn("Autor").setCellRenderer(new WordWrapRenderer());
		 tb.getColumn("Cena").setCellRenderer(new WordWrapRenderer());
		 
		
	     JScrollPane sp = new JScrollPane(tb);
	   
		 add(sp, BorderLayout.NORTH);
		 
		 
		 add(wczytajksiazki, BorderLayout.CENTER);
		 wczytajksiazki.addActionListener(wczytksiazki);
	
		 
		 add(noweksiazki, BorderLayout.SOUTH);
		 
		      noweksiazki.setLayout(new BorderLayout(0, 5));
		      noweksiazki.setBorder(BorderFactory.createTitledBorder("edytuj książki"));		 
		      noweksiazki.add(polaksiazek, BorderLayout.NORTH);
		 
		
		 
		      polaksiazek.setLayout(new GridLayout(4, 2));
		      polaksiazek.add(new JLabel("Okładka"));
		      polaksiazek.add(grafika); 
		      grafika.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e)   {
	            	int returnVal = fc.showOpenDialog(null);
	                if(returnVal == JFileChooser.APPROVE_OPTION) {	              
	             	imgname = fc.getSelectedFile().getAbsolutePath(); 
	             	grafika.setText(imgname);
	                }
	            }});
		      
		 
		 
		 polaksiazek.add(new JLabel("Tytuł"));
		 polaksiazek.add(tytul); 
		 
		 polaksiazek.add(new JLabel("Autor"));
		 polaksiazek.add(autor); 
		 
		 polaksiazek.add(new JLabel("Cena"));
		 polaksiazek.add(cena); 


		 
		 noweksiazki.add(dodksiazke, BorderLayout.CENTER);
		 dodksiazke.addActionListener(dodajksiazke);
		 
		 noweksiazki.add(usunzaznaczone, BorderLayout.SOUTH);
		 usunzaznaczone.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e)   {
	            	tbm.removeRow(tb.getSelectedRow());
	                }
	            });
		 
		 
		 

		 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        
        
        setResizable(false);
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
	  
	  
	  

	  
	  void dodajKsiazke() {
		  
		  ImageIcon img = new ImageIcon(imgname);
		  
		  Image image = (img).getImage().getScaledInstance(70, 100, Image.SCALE_SMOOTH);
		  ImageIcon okladka =  new ImageIcon(image);

		  tbm.addRow(new Object[] {okladka, tyt, aut, cen});
	  }
	  
	  
	  

	  
	  private ActionListener dodajksiazke = new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(tytul.getText().equals("") || autor.getText().equals("") || imgname == null ) {
					
				} else {
					
					tyt = tytul.getText();
					aut = autor.getText();
					cen = cena.getText();
					
					dodajKsiazke();	
					
					tytul.setText("");
				    autor.setText("");
				    cena.setText("");
				    imgname=null;
					
				}

			}	
	  };
	  


	  
	  private ActionListener wczytksiazki = new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int returnVal = fc.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {	              
             	f = fc.getSelectedFile();
             	 
             	
             	
				try {
					FileReader fr = new FileReader(f);
					BufferedReader br = new BufferedReader(fr);
					
					String line;
					while ((line = br.readLine()) != null) {
						
						String[] tab = line.split(",");
						
						
						
						imgname = f.getParent()+"\\"+tab[0];
						
						tyt = tab[1];
						aut = tab[2];
						cen = tab[3];
						
						dodajKsiazke();
						
					}
					
					br.close();

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ArrayIndexOutOfBoundsException e1) {
				    
				} 

                }

			}	
	  };

}