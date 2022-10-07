package interfaces;

public class TeacherCreditManager extends BaseCreditManager implements CreditManager{

	@Override
	public void calculate() {
		System.out.println("Öğretmen kredisi hesaplandı");
		
	}
	
	@Override
	public void save() {
		super.save();
		System.out.println("Başka işlem");
	}

}
