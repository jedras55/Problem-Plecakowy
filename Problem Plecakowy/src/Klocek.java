public class Klocek {

	private double waga; 
	
	public double getWaga() {
		return waga;
	} // Tworzê tylko getter, ¿eby mo¿na by³o w trakcie programu pobieraæ wagê klocka,
	  // ale zmieniaæ tylko przy tworzeniu obiektu poprzez konstruktor.

	public Klocek(double waga){
		this.waga = waga;
	}
}
