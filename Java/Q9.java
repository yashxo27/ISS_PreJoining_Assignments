import org.json.JSONArray;
import org.json.JSONObject;

public class Q9 {
	public static void main(String[] args) {
		JSONArray cardList = new JSONArray();
        	cardList.put("ICICI Debit Card");
        	cardList.put("Axis Credit Card");

        
		JSONObject wallet = new JSONObject();
        	wallet.put("Brand", "Allen Solly");
        	wallet.put("Cash", 1200);
        	wallet.put("Cards", cardList);

 		JSONObject phone = new JSONObject();
        	phone.put("Brand", "Apple");
        	phone.put("Model", "Iphone 16 Pro");
        	phone.put("Price", 125600);

        	JSONObject pant = new JSONObject();
        	pant.put("Wallet", wallet);
        	pant.put("Phone", phone);

         	System.out.println("Original Pant contents:");
        	System.out.println(pant.toString(4));

		System.out.println("\nAccessing values:");
        	JSONObject walletFromPant = pant.getJSONObject("Wallet");
        	int cashInWallet = walletFromPant.getInt("Cash");
        	System.out.println("Cash in wallet: Rs." + cashInWallet);
		JSONArray cards = walletFromPant.getJSONArray("Cards");
        	System.out.println("First card: " + cards.getString(0));
		JSONObject phoneFromPant = pant.getJSONObject("Phone");
        	String phoneBrand = phoneFromPant.getString("Brand");
        	System.out.println("Phone brand: " + phoneBrand);

		walletFromPant.put("Cash", cashInWallet + 800);
		cards.put("HDFC Credit Card");
		cards.remove(0);
		phoneFromPant.put("Price", 119999);
		
		System.out.println("\nModified Pant contents:");
        	System.out.println(pant.toString(4));
	}
}
