package classes;

public class Customer {
	private int id;
	

	private String City;
	
	public Customer() {
		System.out.println("Müşteri nesnesi başlatıldı");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
}
