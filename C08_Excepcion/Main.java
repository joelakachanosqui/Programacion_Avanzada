package C08_Excepcion;

public class Main {
	public static void main(String[] args) {
		int a = 2, b = 0;
		try {
			System.out.println(a/b);
			
		} catch (NullPointerException exception) {
			System.out.println("Null Pointer Exception");
		
		} catch (Exception exception) {
			System.out.println("Exception");
		
		} finally {
			System.out.println("Pasó por el finally");
		}
	}
}
