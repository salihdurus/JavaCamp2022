package sayiBulma;

public class Main {

	public static void main(String[] args) {
		int[] sayilar = new int[] { 1, 2, 5, 7, 9, 0 };
		int aranacak = 20;
		boolean isThere=false;
		
		for(int sayi:sayilar) {
			if(aranacak==sayi) {
				isThere=true;
				break;
			}
		}
		if(isThere) System.out.println("Dizide bu sayı var.");
		else System.out.println("Bu Sayı Dizide yok.");
		

	}

}
