package kodlamaioWithLayeredArchitecture.core.logging;

public class MailLogger implements ILogger{

	@Override
	public void log(String data) {
		System.out.println("Emaile Loglandı : "+data);
		
	}

}
