package miniProjeAsalSayi;

public class Main {

	public static void main(String[] args) {
		int number = 97;
//		int remainder = number % 2;
		if (number < 2) {
			System.out.println("Sayı Asal Değildir.");
		} else if (number == 2) {
			System.out.println("Sayı Asaldır.");
		} else {
			for (int i = 2; i < number; i++) {
				if (number % i == 0) {
					System.out.println("Sayı Asal Değildir.");
					break;
				} else if (i == number - 1) {
					System.out.println("Sayı Asaldır.");
				}
			}
		}

	}

}
