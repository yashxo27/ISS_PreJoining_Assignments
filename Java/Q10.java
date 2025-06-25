import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Q10{
	public static void main(String[] args){
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("Q10_Pant.xml"));
			doc.getDocumentElement().normalize();
			
			Element wallet = (Element) doc.getElementsByTagName("Wallet").item(0); 
			Element phone = (Element) doc.getElementsByTagName("Phone").item(0);

			String cash = wallet.getElementsByTagName("Cash").item(0).getTextContent();
            		String phoneBrand = phone.getElementsByTagName("Brand").item(0).getTextContent();
            		System.out.println("Cash in wallet: Rs." + cash);
            		System.out.println("Phone brand: " + phoneBrand);

			int updatedCash = Integer.parseInt(cash) + 800;
           		wallet.getElementsByTagName("Cash").item(0).setTextContent(String.valueOf(updatedCash));

			Element cards = (Element) wallet.getElementsByTagName("Cards").item(0);
            		Element newCard = doc.createElement("Card");
            		newCard.setTextContent("HDFC Credit Card");
            		cards.appendChild(newCard);

			Node firstCard = cards.getElementsByTagName("Card").item(0);
            		cards.removeChild(firstCard);

            		phone.getElementsByTagName("Price").item(0).setTextContent("119999");

            		Transformer transformer = TransformerFactory.newInstance().newTransformer();
            		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            		transformer.transform(new DOMSource(doc), new StreamResult(new File("Q10_PantModified.xml")));

            		System.out.println("New File Created");

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}