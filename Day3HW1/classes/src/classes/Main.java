package classes;

public class Main {

	public static void main(String[] args) {

		CreditManager creditManager = new CreditManager();
		creditManager.calculate();
		creditManager.calculate();

		Customer customer = new Customer();
		customer.setId(1);
		customer.setCity("Ankara");
		
		CustomerManager customerManager = new CustomerManager(customer);
		customerManager.save();
		customerManager.delete();

		Company company = new Company();
		company.setTaxNumber("1000");
		company.setId(2);
		company.setCompanyName("Arçelik");
		
		CustomerManager customerManager2=new CustomerManager(company);
		
		
		Person person = new Person();
		person.setNationalIdentity("12345678909");
		
		creditManager.save(customer);

	}

}
