package UserInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class FormulaireCV extends JFrame{
	
	//les attributs
	
	// Les dimensions du panel

	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 500;
	
    private JFrame frame;
    private JButton submit;
     private JTextField Nom;
     private JTextField Prenom;
     private JTextField id;
     private JTextField Nomcv;
     private JTextArea 	CompetencesProf1;
     private JTextArea  CompetencesProf2;
     private JTextArea  CompetencesProf3;
     private JTextArea Experiences1;
     private JTextArea Experiences2;
     private JTextArea Experiences3;
     private JTextArea loisirs1;
     private JTextArea loisirs2;
     private JTextArea loisirs3;
    // private JComboBox Langues;
     //private JComboBox NiveauxLn;
     private JComboBox nivC1;
     private JComboBox nivC2;
     private JComboBox nivC3;
     private JComboBox D1;
     private JComboBox D2;
     private JComboBox D3;
     private JTextArea Langue1;
     private JTextArea Langue2;
     private JTextArea Langue3;
     private JComboBox nivl1;
     private JComboBox nivl2;
     private JComboBox nivl3;

     
     
     
	//les Commandes
     
     public FormulaireCV() {
         createView();
         placeComponents();
         CreateController();
         
     }
     private void CreateController() {
		// TODO Auto-generated method stub
    	 submit.addActionListener(new ActionListener() {
    		 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String cv;
				 try {
					 String Ident = id.getText();
					 String ncv = Nomcv.getText();
					 String nom = Nom.getText();
					 String prenom = Prenom.getText();
					 String loi1 =loisirs1.getText();
					 String loi2 =loisirs2.getText();
					 String lan1 = Langue1.getText();
					 String lan2 = Langue2.getText();
					 String lan3 = Langue3.getText();
					 String com1 = CompetencesProf1.getText();
					 String com2 = CompetencesProf2.getText();
					 String com3 = CompetencesProf3.getText();
					 String exp1 = Experiences1.getText();
					 String exp2 = Experiences2.getText();
					 String  exp3 = Experiences3.getText();
					 String nivla1 = nivl1.getSelectedItem().toString();
					 String nivla2 = nivl2.getSelectedItem().toString();
					 String nivla3 = nivl3.getSelectedItem().toString();
					 String nivCom1 = nivC1.getSelectedItem().toString();
					 String nivCom2 = nivC2.getSelectedItem().toString();
					 String nivCom3 = nivC3.getSelectedItem().toString();
					 String d1 = D1.getSelectedItem().toString();
					 String d2 = D2.getSelectedItem().toString();
					 String d3 = D3.getSelectedItem().toString();
					 
					 //String langues = (String) Langues.getSelectedItem();
					 
					// String Competences = CompetencesProf1.getSelectedText();
					 String ID = id.getText();
					 String myurl = new String("http://wadecvxml.wadendo.cloudbees.net/rest/Resume/"+Ident+"/"+ncv+"/"+prenom+"/"+nom+"/Experiences/"+exp1+"/"+d1+"/"+exp2+"/"+d2+"/"+exp3+"/"+d3+"/Langues/"+lan1+"/"+nivla1+"/"+lan2+"/"+nivla3+"/"+lan3+"/"+nivla3+"/Competences/"+com1+"/"+nivCom1+"/"+com2+"/"+nivCom2+"/"+com3+"/"+nivCom3+"/Loisirs/"+loi1+"/"+loi2 );
						cv = windows.get(myurl);
						System.out.println(cv);
						} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		
	}
	public void display() {
         frame.pack();
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
     }
	

	private void createView() {
		// TODO Auto-generated method stub
		 frame = new JFrame("FormulaireCV");
		 frame.setPreferredSize(
	                new Dimension(FRAME_WIDTH, FRAME_HEIGHT)
	        );
		 
		 Nom = new JTextField(5);
		 Prenom = new JTextField(5);
		 id = new JTextField(5);
		 Nomcv = new JTextField(5);
		 submit = new JButton("Add");
		// NiveauxLn = new JComboBox();
		 //NiveauxLn.addItem("moyen");
		 //NiveauxLn.addItem("haut");
		 //NiveauxLn.addItem("faible");
		 nivC1 = new JComboBox();
		 nivC1.addItem("debutant");
		 nivC1.addItem("moyen");
		 nivC1.addItem("expert");
		 nivC2 = new JComboBox();
		 nivC2.addItem("debutant");
		 nivC2.addItem("moyen");
		 nivC2.addItem("expert");
		 nivC3 = new JComboBox();
		 nivC3.addItem("debutant");
		 nivC3.addItem("moyen");
		 nivC3.addItem("expert");
		 
		 nivl1 = new JComboBox();
		 nivl1.addItem("A");
		 nivl1.addItem("B");
		 nivl1.addItem("C");
		 nivl2 = new JComboBox();
		 nivl2.addItem("A");
		 nivl2.addItem("B");
		 nivl2.addItem("C");
		 nivl3 = new JComboBox();
		 nivl3.addItem("A");
		 nivl3.addItem("B");
		 nivl3.addItem("C");
		 
		 D1 = new JComboBox();
		 D1.addItem("1");
		 D1.addItem("1et5");
		 D1.addItem(">5S");
		 //D1 = new JComboBox();
		 //D1.addItem("moyen");
		 //D1.addItem("haut");
		 //D1.addItem("faible");
		 D2 = new JComboBox();
		 D2.addItem("1");
		 D2.addItem("1et5");
		 D2.addItem(">5");
		 D3 = new JComboBox();
		 D3.addItem("1");
		 D3.addItem("1et5");
		 D3.addItem(">5");
		
		 CompetencesProf1 = new JTextArea();
	     CompetencesProf1.setPreferredSize(new Dimension(150,15));
	     CompetencesProf1.setEditable(true);
	     CompetencesProf2 = new JTextArea();
	     CompetencesProf2.setPreferredSize(new Dimension(150,15));
	     CompetencesProf2.setEditable(true);
	     CompetencesProf3 = new JTextArea();
	     CompetencesProf3.setPreferredSize(new Dimension(150,15));
	     CompetencesProf3.setEditable(true);
	     Experiences1 = new JTextArea();
	     Experiences1.setPreferredSize(new Dimension(150,15));
	     Experiences1.setEditable(true);
	     Experiences2 = new JTextArea();
	     Experiences2.setPreferredSize(new Dimension(150,15));
	     Experiences2.setEditable(true);
	     Experiences3 = new JTextArea();
	     Experiences3.setPreferredSize(new Dimension(150,15));
	     Experiences3.setEditable(true);
	     
	     Langue1 = new JTextArea();
	     Langue1.setPreferredSize(new Dimension(150,15));
	     Langue1.setEditable(true);
	     Langue2 = new JTextArea();
	     Langue2.setPreferredSize(new Dimension(150,15));
	     Langue2.setEditable(true);
	     Langue3 = new JTextArea();
	     Langue3.setPreferredSize(new Dimension(150,15));
	     Langue3.setEditable(true);
	    
	     loisirs1 = new JTextArea();
	     loisirs1.setPreferredSize(new Dimension(150,15));
	     loisirs1.setEditable(true);	
	     loisirs2 = new JTextArea();
	     loisirs2.setPreferredSize(new Dimension(150,15));
	     loisirs2.setEditable(true);	
	     loisirs3 = new JTextArea();
	     loisirs3.setPreferredSize(new Dimension(150,15));
	     loisirs3.setEditable(true);	
	     //Langues = new JComboBox();
		 //Langues.addItem("Francais");
		 //Langues.addItem("Englais");
		 //Langues.addItem("Arab");
	    
	     
	}
	private void placeComponents() {
		// TODO Auto-generated method stub
		JPanel Grid = new JPanel(new GridLayout(0,1));{
			JPanel f = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
			f.add(new JLabel("NOMCV :"));
			f.add(Nomcv);
			}
			Grid.add(f);
			JPanel N = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
			N.add(new JLabel("NOM :"));
			N.add(Nom);
			}
			Grid.add(N);
			JPanel P = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
			P.add(new JLabel("Prenom :"));
			P.add(Prenom);
			}
			Grid.add(P);
			JPanel I = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
			I.add(new JLabel("ID :"));
			I.add(id);
			}
			Grid.add(I);
			}
		JPanel Grid1 = new JPanel(new GridLayout(0,1));{
			JPanel f = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
				
				JScrollPane sp = new JScrollPane(CompetencesProf1);
		    	sp.setBorder(BorderFactory.createTitledBorder("CompetencesProf1"));
		    	f.add(sp);
		    	f.add(nivC1);
		    	JScrollPane sp1 = new JScrollPane(CompetencesProf2);
		    	sp1.setBorder(BorderFactory.createTitledBorder("CompetencesProf2"));
		    	f.add(sp1);
		    	f.add(nivC2);
		    	JScrollPane sp2 = new JScrollPane(CompetencesProf3);
		    	sp2.setBorder(BorderFactory.createTitledBorder("CompetencesProf3"));
		    	f.add(sp2);
		    	f.add(nivC3);
		    	
			}
			Grid1.add(f);
			
	    	JPanel k = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
	    	JScrollPane sp2 = new JScrollPane(loisirs1);
	    	sp2.setBorder(BorderFactory.createTitledBorder("Loisirs1"));
	    	
	    	JScrollPane sp3 = new JScrollPane(loisirs2);
	    	sp3.setBorder(BorderFactory.createTitledBorder("Loisirs2"));
	    	
	    	JScrollPane sp4 = new JScrollPane(loisirs3);
	    	sp4.setBorder(BorderFactory.createTitledBorder("Loisirs2"));
	    	k.add(sp2);
	    	k.add(sp3);
	    	k.add(sp4);
	    	}
	    	
	    	Grid1.add(k);
	    	JPanel E = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
	    	JScrollPane sp1 = new JScrollPane(Experiences1);
	    	sp1.setBorder(BorderFactory.createTitledBorder("Experiences"));
	    	E.add(sp1);
	    	E.add(D1);
	    	
	    	JScrollPane spE = new JScrollPane(Experiences2);
	    	spE.setBorder(BorderFactory.createTitledBorder("Experiences1"));
	    	E.add(spE);
	    	E.add(D2);
	    	JScrollPane spE1 = new JScrollPane(Experiences3);
	    	spE1.setBorder(BorderFactory.createTitledBorder("Experiences2"));
	    	E.add(spE1);
	    	E.add(D3);
	    	
	    	}
	    	
	    	Grid1.add(E);
	    	JPanel h = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
	    		JScrollPane sp1 = new JScrollPane(Langue1);
		    	sp1.setBorder(BorderFactory.createTitledBorder("LANGUE1"));
		    	E.add(sp1);
		    	E.add(nivl1);
		    	
		    	JScrollPane spE = new JScrollPane(Langue2);
		    	spE.setBorder(BorderFactory.createTitledBorder("LANGUE2"));
		    	E.add(spE);
		    	E.add(nivl2);
		    	JScrollPane spE1 = new JScrollPane(Langue3);
		    	spE1.setBorder(BorderFactory.createTitledBorder("LANGUE3"));
		    	E.add(spE1);
		    	E.add(nivl3);
	    	}
	    	Grid1.add(h);
	    	}
	    	
	
	    
		
		

		JPanel b = new JPanel(new FlowLayout(FlowLayout.CENTER));{
			b.add(submit);
			
		}
		
		frame.add(Grid,BorderLayout.WEST);
		frame.add(Grid1,BorderLayout.CENTER);
		frame.add(b,BorderLayout.SOUTH);
	}



	
	 public static String get(String url) throws IOException {
		 String source ="";	
		URL oracle = new URL(url);
		URLConnection yc = oracle.openConnection();
		BufferedReader in = new BufferedReader(
		new InputStreamReader(
		yc.getInputStream()));
		String inputLine;
		 
		while ((inputLine = in.readLine()) != null)
		source +=inputLine;
		in.close();
		return source;
}
	 
	 
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormulaireCV().display();
            }
        });
}
}
