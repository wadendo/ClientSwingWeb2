package UserInterface;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;


public class ParsDOM {
	
	public static Node ConvertStringToNode(String Str)
    {
        Node result=null;

        Document document;

        try
        {
            // création d'une fabrique de documents
            DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
            // création d'un constructeur de documents
            DocumentBuilder constructeur = fabrique.newDocumentBuilder();
            // lecture du contenu d'un fichier XML avec DOM

            StringBuffer Buffer = new StringBuffer(Str);

            ByteArrayInputStream Bis1 = new ByteArrayInputStream(Buffer.toString().getBytes("UTF-8"));

            document = constructeur.parse(Bis1);

            Element racine =  document.getDocumentElement();

            result= racine.getParentNode();

        }
        catch(ParserConfigurationException pce)
        {
            System.out.println("\n-> Utilities.java/ConvertStringToNode");
            System.out.println("Erreur de configuration du parseur DOM");
            System.out.println("lors de l'appel à fabrique.newDocumentBuilder();");
            pce.printStackTrace();
            System.exit(0);
        }
        catch(SAXException se)
        {
            System.out.println("\n-> Utilities.java/ConvertStringToNode");
            System.out.println("Erreur lors du parsing du document");
            System.out.println("lors de l'appel à construteur.parse(xml)");
            System.out.println("Les DTD sont elles presentent dans le repertoire ?");
            se.printStackTrace();
            System.exit(0);
        }
        catch(IOException ioe)
        {
            System.out.println("\n-> Utilities.java/ConvertStringToNode");
            System.out.println("Erreur d'entrée/sortie");
            System.out.println("lors de l'appel à construteur.parse(xml)");
            ioe.printStackTrace();
            System.exit(0);
        }


        return result;

    }
	   public static void Idrecup (Node node,  List<String> Ids, String nodeName)
	    {

	        if(node.getNodeName().equals(nodeName))
	        {
	            Ids.add(node.getTextContent());

	        }
	        // valeur de l'attribut ou texte d'un élément texte ou ..
	        if (node.hasChildNodes())  {
	            // comme les Tree-s JAVA .....
	            Node nextFils = node.getFirstChild();
	            while (nextFils != null) {
	                Idrecup(nextFils, Ids, nodeName);
	                nextFils = nextFils.getNextSibling();
	            }
	        }
	    }

}
