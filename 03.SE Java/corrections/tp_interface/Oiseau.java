
public class Oiseau implements Siffleur, Animal{
	@Override
	public void siffler () {
		System.out.println("Oiseau : Triliiiliiiiouuu");
	}

	@Override
	public void manger() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void communiquer() {
		siffler();
		
	}

	@Override
	public void dormir() {
		System.out.println("Oiseu : Zzzzz");
		
	}

}
