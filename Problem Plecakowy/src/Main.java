import java.util.Random;

public class Main {
	
	static int iloscKlockow = 20; // Iloœæ ró¿nych klocków, które program wygeneruje
	static int dolnaGranicaKlocka = 0; // Najni¿sza mo¿liwa waga klocka
	static int gornaGranicaKlocka = 3; // Najwy¿sza mo¿liwa waga klocka
	static int HMS = 10; // HM Size - iloœæ wektorów (wierszy)

	public static void main(String[] args) {
		Random rand = new Random();
		FabrykaKlockow fabryka = new FabrykaKlockow();
		
		int r1 = rand.nextInt(100)+1;
		int HMCR = rand.nextInt(100)+1; // Wyloswanie parametru pocz¹tkowego HMCR
		
		Klocek HM[][] = new Klocek[iloscKlockow][HMS]; // Tworzê tablicê wektorów(wierszy) HM.
		for(int i=0; i<HMS; i++){
			HM[i] = fabryka.losujWszystkieKlocki(); // Przypisujê wektor do wiersza
		}
		//----- Testowy fragment do zaprezentowania dzia³ania
		Klocek klocki[] = fabryka.losujWszystkieKlocki();
		for(int i=0; i<iloscKlockow; i++){	
			System.out.println("Klocek numer " + (i+1) + " wa¿y " + klocki[i].getWaga() + " kg.");
		}
		//----
		if (r1<= HMCR){
			//losowanie wektoru z tablicy i ewentualne dostrojenie liczby
		}
		else{
			//tworze wektor ze wzoru
		}
		//dostrojenie tablicy
	}
}
