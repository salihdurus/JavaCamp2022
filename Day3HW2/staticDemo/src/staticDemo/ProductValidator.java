package staticDemo;

public class ProductValidator {
	
	static {
		System.out.println("Static yapıcı blok çalıştı");
	}
	
	public static boolean isValid(Product product) {
		if(product.price>0 && !product.name.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void bisey() {
		
	}
	
//	public static class BaskaBirClass{ //Inner class
//		public static void sil() {
//			
//		}
//	}
}
