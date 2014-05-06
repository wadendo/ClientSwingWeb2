package UserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import org.w3c.dom.Node;


public class windows {
	
	// ATTRIBUTS
    // Les dimensions du panel
    private static final int FRAME_WIDTH = 900;
    private static final int FRAME_HEIGHT = 500;
    // l'adresse du fichier a analyser
 
 	private javax.swing.JTree Tree ;
 	private DefaultMutableTreeNode root;
	private TreeModel treemodel;
	private List<String> ID;
    // le bouton parcourir
    private JButton  RemplirCV;
    private JScrollPane scrollpane;
    // le bouton reset
    private JButton reset;
    // le bouton pour lancer l'algo
    private JButton launch;
    // Affichage du text
    private JTextArea text;
    // La fenetre principale de l'application
    private JFrame frame;
    // Le modele
   
    private static final int FIELD_SIZE = 25;


    
    // CONSTRUCTEURS
    public windows() {
    	
        createView();
        placeComponents();
        createController();
    }

    
    // COMMANDES
    /**
     * Rend l'application visible au centre de l'ï¿½cran.
     */
    public void display() {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // OUTILS
    private void createView() {
    	 
        frame = new JFrame("Projet Web");
        frame.setPreferredSize(
                new Dimension(FRAME_WIDTH, FRAME_HEIGHT)
        );
        
        RemplirCV = new JButton("AddResume");
        launch = new JButton(" RetrieveAll");
        launch.setEnabled(true);
        text = new JTextArea();
        text.setEditable(true);
        Tree = new JTree(treemodel);
		//Tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

	    //Le modele pour insérer les element de l'arbre d'une maniere dynamique
		root =  new DefaultMutableTreeNode("Resumes");
	    DefaultTreeModel treeModel = new DefaultTreeModel(root);
	    
	    Tree = new javax.swing.JTree(treeModel);
	    Tree.setShowsRootHandles(true);
		
		scrollpane = new javax.swing.JScrollPane();  
	    scrollpane.setViewportView(Tree);  
		scrollpane.setPreferredSize(new Dimension(150,700));
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    private void placeComponents() {
    	// Au nord, le fichier a analyser
    	JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER)); {
    		p.add(new JLabel(" Remplir Formulaire"));
    		
    		p.add(RemplirCV);
    		
    	}
    	
    	frame.add(p, BorderLayout.NORTH);
    	
    	// les elements a l'ouest
    	p = new JPanel(new GridLayout(2, 1)); {
        	// option d'analyse
    		JPanel s = new JPanel(new BorderLayout()); {
    			JPanel q = new JPanel(new GridLayout(1, 1)); {
        			JPanel r = new JPanel(new FlowLayout(FlowLayout.RIGHT)); {
        				r.add(new JLabel("ListeCV :"));
        				q.add(r);
        			}
        			r = new JPanel(new FlowLayout(FlowLayout.LEFT)); {
        				r.add(launch);
        				q.add(r);
        			}
        		}
        		s.add(q, BorderLayout.CENTER);
    		}
    		
    		p.add(s);
    		
    		// bouton qui lance l'analyse
    		s = new JPanel(new BorderLayout()); {
    			JPanel q = new JPanel(new FlowLayout(FlowLayout.CENTER)); {
        			
        		}
        		s.add(q, BorderLayout.NORTH);
    		}
    		p.add(s);
    	}
    	frame.add(p, BorderLayout.WEST);
    	frame.add(scrollpane,BorderLayout.EAST);
    	
    	// la phrase au sud
    	p = new JPanel(new FlowLayout(FlowLayout.LEFT)); {
    		JLabel copyright = new JLabel("Wade Ndongo");
    		copyright.setForeground(Color.blue);
    		p.add(copyright);
    	}
    	p.setBorder(BorderFactory.createLineBorder(Color.lightGray));
    	frame.add(p, BorderLayout.SOUTH);

    	// au centre, le resultat de l'analyse
    	JScrollPane sp = new JScrollPane(text);
    	sp.setBorder(BorderFactory.createTitledBorder("Resultat"));
    	frame.add(sp, BorderLayout.CENTER);
    	String listCVString;
	 	ID = new LinkedList<String>();
		try {
			listCVString = windows.get("http://wadecvxml.wadendo.cloudbees.net/rest/Resume?list");
			//System.out.println(listCVString); 
			Node myNode = ParsDOM.ConvertStringToNode(listCVString);
			System.out.println(myNode.getNodeName());
				ParsDOM.Idrecup(myNode, ID, "id");
				 for(int i = 0; i<ID.size();i++){
			            System.out.println(ID.get(i));
			         }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        try {
			fillTree(ID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
    public javax.swing.JTree getjTreeFile() {
		return Tree;
		}
	 
	 public void fillTree(List<String> ID) throws IOException{
		 for(String row:ID){
			 
			 DefaultMutableTreeNode node=new DefaultMutableTreeNode(row);
			 
			 root.add(node);
		 }
		 
	
    }

    private void createController() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        launch.addActionListener(new ActionListener() {
			
			@Override
			
			public void actionPerformed(ActionEvent arg0)  {
				// TODO Auto-generated method stub
				String Nl = System.getProperty("line.separator");
				String message = "La liste des CV se trouve sur le liste ˆ gauche"+Nl+"Cliquer sur un identifiant pour afficher le contenu d'un CV";
				String result; 
				
					 try {
						 
						result = windows.get("http://wadecvxml.wadendo.cloudbees.net/rest/Resume?list");
						text.setText(message);
						} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
			
			});
		 RemplirCV.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					openFrame();    	
				}
			});
		 Tree.addTreeSelectionListener(new TreeSelectionListener() {
		
				public void valueChanged(TreeSelectionEvent e) {
					DefaultMutableTreeNode node1 = (DefaultMutableTreeNode) Tree.getLastSelectedPathComponent();
					if (node1 == null) {
						return;
					}
					Object nodeInfo;
				
					if (node1.isLeaf())
					{
						/*int  identifiant = node1.getIndex(node1.getNextLeaf());
						System.out.println(identifiant);*/
						String leafts  = e.getNewLeadSelectionPath().getLastPathComponent().toString();
						System.out.println();
						try {
						
							 List<String> myList = new LinkedList<String>();
							 String result;
							result = windows.get("http://wadecvxml.wadendo.cloudbees.net/rest/Resume/" + leafts);
							Node myNode = ParsDOM.ConvertStringToNode(result);
							ParsDOM.Idrecup(myNode, myList, "nom");
							  String nom = myList.get(0);
							  myList.clear();
							  ParsDOM.Idrecup(myNode, myList, "prenom");
							  String prenom = myList.get(0);myList.clear();
							  ParsDOM.Idrecup(myNode, myList, "experience");

							  String exp1 = myList.get(0);
							  String exp2 = myList.get(1);
							 // String exp3 = myList.get(2);
							  myList.clear();
							  
							  ParsDOM.Idrecup(myNode, myList, "competences");
							  
								 
							  String com1 = myList.get(0);
							  String com2 = myList.get(1);
							  //String com3 = myList.get(2);
							  myList.clear();
							  
							  ParsDOM.Idrecup(myNode, myList, "langue");
							  
								 
							  String lan1 = myList.get(0);
							  String lan2 = myList.get(1);
							//  String lan3 = myList.get(2);
							  myList.clear();
							  
							  
							  ParsDOM.Idrecup(myNode, myList, "loisir");
							  
								 
							  String loisir1 = myList.get(0);
							  String loisir2 = myList.get(1);
							 // String loisir3 = myList.get(2);
							  myList.clear();
							  String CVdom = new String();
							  String NewLigne = System.getProperty("line.separator");
							  CVdom = "Nom :"+ nom + NewLigne + "Prenom :" + prenom +  NewLigne + "Experiences :" + NewLigne + exp1 + NewLigne+ exp2 + NewLigne + "Competences :" + NewLigne + com1 + NewLigne+ com2 + NewLigne  +"Langues :" + NewLigne + lan1 + NewLigne+ lan2 + NewLigne + "Loisirs :" + NewLigne + loisir1 + NewLigne+ loisir2   ;
							  
							  text.setText(CVdom);
						  
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 
						  
						  
						 
						  
						  
					}	
					
					}
			});
        
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
	 private void openFrame() {                                  
		    FormulaireCV t = new FormulaireCV();
		    t.display();
		  }
	
    
   
	
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new windows().display();
            }
        });
    }
}
