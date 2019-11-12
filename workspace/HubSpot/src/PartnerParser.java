
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;;

public class PartnerParser {
//	API key
	private static final String HUBSPOT_KEY = "94da40af84a41bb27d2921ae9f29";

	private static String getData(Reader reader) throws IOException{
		StringBuilder sBuilder = new StringBuilder();
		int current;
		while  ((current = reader.read()) != -1) {
			sBuilder.append((char)current); 
		}
		return sBuilder.toString();
	}
	
//	getting data from the link using API and storing all the data in to Partner 
	public static List<Partner> parse() throws IOException, JSONException{
		List<Partner> allParters = new ArrayList<Partner>();
//		opening link
		String url = "https://candidate.hubteam.com/candidateTest/v3/problem/dataset?userKey="+HUBSPOT_KEY;
		InputStream iStream = new URL(url).openStream();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(iStream, Charset.forName("UTF-8")));
			String jsonText = getData(reader);
			JSONObject json = new JSONObject(jsonText);
			JSONArray allPartners = json.getJSONArray("partners");
//			iterate through json data for each partner
			for (int i = 0; i < allPartners.length(); i++) {
				JSONObject current = allPartners.getJSONObject(i);
				String firstName = current.getString("firstName");
				String lastName = current.getString("lastName");
				String country = current.getString("country");
				String email = current.getString("email");
				JSONArray dates = current.getJSONArray("availableDates");
				List<String> availableDates = new ArrayList<>();
//				storing all the available dates
				for (int j =0; j < dates.length(); j++) {
					String date = dates.getString(j); 
					availableDates.add(date);
				}
				Partner partner = new Partner(firstName, lastName, email, country, availableDates);
				allParters.add(partner);
			}
			return allParters;
		}finally {
			iStream.close();
		}	
	}
}
