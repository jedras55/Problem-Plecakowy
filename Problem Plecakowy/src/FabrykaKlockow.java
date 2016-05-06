import java.util.Random;

public class FabrykaKlockow {

	private Klocek losujKlocek(double dolnaGranicaKlocka, double gornaGranicaKlocka){
		Random rand = new Random();
		double  wagaKlocka = round(dolnaGranicaKlocka + (gornaGranicaKlocka - dolnaGranicaKlocka) * rand.nextDouble(),2);
		Klocek klocek = new Klocek(wagaKlocka);
		return klocek;
		// Tworz� klocek z wag� z podanego zakresu i zwracam go.
	}
	public Klocek[] losujWszystkieKlocki(){
		Klocek klocki[] = new Klocek[Main.iloscKlockow]; // Tworz� pust� tablic� klock�w.
		for (int i=0; i<Main.iloscKlockow; i++){
				Klocek temp = losujKlocek(Main.dolnaGranicaKlocka, Main.gornaGranicaKlocka); // Losuj� klocek i zapisuje jako tymczasowy
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
	} // Metoda zaokr�glaj�ca z internetu
}
