package abstractDemo;

public class CustomerManager {

	public BaseDatabaseManager databaseManager;
	
	public void getCustomers() {
		databaseManager.getData();
	}
}
