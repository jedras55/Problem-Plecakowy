import java.util.Random;

public class Main {
	
	static int iloscKlockow = 20; // Iloœæ ró¿nych klocków, które program wygeneruje
	static int dolnaGranicaKlocka = 0; // Najni¿sza mo¿liwa waga klocka
	static int gornaGranicaKlocka = 7; // Najwy¿sza mo¿liwa waga klocka
	static int HMS = 10; // HM Size - iloœæ wektorów (kolumn)

	public static void main(String[] args) {
		Random rand = new Random();
		FabrykaKlockow fabryka = new FabrykaKlockow();
		
		int r1 = rand.nextInt(100)+1;
		int HMCR = rand.nextInt(100)+1; // Wyloswanie parametru pocz¹tkowego HMCR
		Klocek klocki[] = fabryka.losujWszystkieKlocki();
		for(int i=0; i<iloscKlockow; i++){	
			System.out.println("Klocek numer " + (i+1) + " wa¿y " + klocki[i].getWaga() + " kg.");
		}
		if (r1<= HMCR){
			//losowanie wektoru z tablicy i ewentualne dostrojenie liczby
		}
		else{
			//tworze wektor ze wzoru
		}
		//dostrojenie tablicy
	}
}
