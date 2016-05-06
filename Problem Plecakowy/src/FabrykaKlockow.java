import java.util.Random;

public class FabrykaKlockow {

	private Klocek losujKlocek(double dolnaGranicaKlocka, double gornaGranicaKlocka){
		Random rand = new Random();
		double  wagaKlocka = round(dolnaGranicaKlocka + (gornaGranicaKlocka - dolnaGranicaKlocka) * rand.nextDouble(),2);
		Klocek klocek = new Klocek(wagaKlocka);
		return klocek;
		// Tworzê klocek z wag¹ z podanego zakresu i zwracam go.
	}
	public Klocek[] losujWszystkieKlocki(){
		Klocek klocki[] = new Klocek[Main.iloscKlockow]; // Tworzê pust¹ tablicê klocków.
		for (int i=0; i<Main.iloscKlockow; i++){
				Klocek temp = losujKlocek(Main.dolnaGranicaKlocka, Main.gornaGranicaKlocka); // Losujê klocek i zapisuje jako tymczasowy
				klocki[i] = temp;
		}
		return klocki;
	}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	} // Metoda zaokr¹glaj¹ca z internetu
}
