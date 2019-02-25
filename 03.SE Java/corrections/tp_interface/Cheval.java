
public class Cheval implements Animal{
	
	@Override
	public void dormir() {
		System.out.println("Cheval : Zzzzz");
	}
	
	@Override
	public void communiquer() {
		System.out.println("Cheval : Hiiiihihihiiii");
	}
	
	public void galoper() {
		System.out.println("Cheval : Cataclop, cataclop");
	}

	@Override
	public void manger() {
		System.out.println("Cheval : Miam");
		
	}


}
