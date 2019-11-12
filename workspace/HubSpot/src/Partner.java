import java.util.List;

public class Partner {
	
	@Override
	public String toString() {
		return "Partner [firstname=" + firstName + ", lastname=" + lastName + ", email=" + email + ", country="
				+ country + ", availableDates=" + availableDates + "]";
	}

	private String firstName;
	private String lastName;
	private String email;
	private String country;
	private List<String> availableDates;
	
	public Partner(String firstname, String lastname, String email, String country, List<String> availableDates) {
		super();
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.country = country;
		this.availableDates = availableDates;
	}

	public String getFirstname() {
		return firstName;
	}

	private void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public String getLastname() {
		return lastName;
	}

	private void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	private void setCountry(String country) {
		this.country = country;
	}

	public List<String> getAvailableDates() {
		return availableDates;
	}

	private void setAvailableDates(List<String> availableDates) {
		this.availableDates = availableDates;
	}
}
