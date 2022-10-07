package interfaces;

public class CustomerManager {
	
	private CreditManager creditManager;
	
	public CustomerManager(CreditManager creditManager) {
		this.creditManager=creditManager;
	}
	
	
	public void GiveCredit() {
		creditManager.calculate();
		System.out.println("Kredi verildi.");
		creditManager.save();
	}
}
