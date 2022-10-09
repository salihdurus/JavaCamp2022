package kodlamaioWithLayeredArchitecture.core.logging;

public class SmsLogger implements ILogger{

	@Override
	public void log(String data) {
		System.out.println("Sms Gönderildi : "+data);
		
	}
	
}
