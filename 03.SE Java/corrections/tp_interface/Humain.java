
public class Humain implements Animal, Siffleur {
	@Override
	public void dormir() {
		System.out.println("Humain : Zzzzz");
	}
	
	@Override
	public void communiquer() {
		System.out.println("Humain : Bonjour");
	}
	
	@Override
	public void siffler () {
		System.out.println("Humain : Pfiouiou");
	}

	@Override
	public void manger() {
		// TODO Auto-generated method stub
		
	}

}
