public class Klocek {

	private double waga; 
	
	public double getWaga() {
		return waga;
	} // Tworz� tylko getter, �eby mo�na by�o w trakcie programu pobiera� wag� klocka,
	  // ale zmienia� tylko przy tworzeniu obiektu poprzez konstruktor.

	public Klocek(double waga){
		this.waga = waga;
	}
}
