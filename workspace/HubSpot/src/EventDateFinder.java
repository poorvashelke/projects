import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

import org.json.JSONException;

public class EventDateFinder {
//	storing data using country to get all partners for each country
	public Map<String, List<Partner>> getCountryWisePartners() throws IOException, JSONException{
		List<Partner> allPartners = PartnerParser.parse();
		Map<String, List<Partner>> countryWisePartners = new HashMap<String, List<Partner>>();
		for(Partner each: allPartners) {
			countryWisePartners.putIfAbsent(each.getCountry(), new ArrayList<Partner>());
			countryWisePartners.get(each.getCountry()).add(each);
		}
		return countryWisePartners;
	}
	
//	finding event date which most of the parners can able to attend
	public void dateFinderForEachCountry() throws IOException, JSONException, ParseException{
		Map<String, List<Partner>> countryWisePartners = getCountryWisePartners();
		Map<String, List<Partner>> countryWiseAttendies = new HashMap<String, List<Partner>>();
		Map<String, String> countryWiseEventDates = new HashMap<>();

		for(Map.Entry<String, List<Partner>> entry : countryWisePartners.entrySet()) {
			List<Partner> allPartnersInCountry = entry.getValue();
			for(Partner partner: allPartnersInCountry) {
				Map<String, List<Partner>> dateWisePartners = new HashMap<>();
				int maxAvail = 0;
				String eventDate = null;
				List<String> dates = partner.getAvailableDates();
				for(int i = 0; i < dates.size() - 1; i++) {
					String date1 = dates.get(i);
					String date2 = dates.get(i + 1);
				// getting all the parners by the preferable date of two day period
					if(isConsecuteDate(date1, date2)) {
						dateWisePartners.putIfAbsent(date1, new ArrayList<>());
						dateWisePartners.get(date1).add(partner);
					}
					if(dateWisePartners.containsKey(date1) && dateWisePartners.get(date1).size() > maxAvail) {
						maxAvail = dateWisePartners.get(date1).size();
						eventDate = date1;
					}

				}
				countryWiseEventDates.put(entry.getKey(), eventDate);
				countryWiseAttendies.put(entry.getKey(), dateWisePartners.getOrDefault(eventDate, new ArrayList<>()));
				for (Map.Entry<String,String> ent : countryWiseEventDates.entrySet())  
		            System.out.println("Country: " + ent.getKey() + 
		                             "| Date: " + ent.getValue()); 
			}
		}
	}

//	sorting by date, date of two day period
	private boolean isConsecuteDate(String date1, String date2) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");  
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(formatter.parse(date1));
		calendar.setTime(formatter.parse(date2));
		return calendar.getTime().equals(formatter.parse(date2));
		
	}
	public static void main(String[] arg) throws IOException, JSONException, ParseException {
//		Map<String, List<Partner>> countryWisePartner = getCountryWisePartners();
//		for (List<Partner> value : countryWisePartner.values()) {
//			System.out.println(value);
//		}
		EventDateFinder edf = new EventDateFinder();
		edf.dateFinderForEachCountry();
	}
}
