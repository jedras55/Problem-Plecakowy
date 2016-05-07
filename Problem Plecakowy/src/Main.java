import java.util.Random;

public class Main {

	static int iloscKlockow = 20; // Iloœæ ró¿nych klocków, które program
									// wygeneruje
	static int dolnaGranicaKlocka = 0; // Najni¿sza mo¿liwa waga klocka
	static int gornaGranicaKlocka = 3; // Najwy¿sza mo¿liwa waga klocka
	static int HMS = 3; // HM Size - iloœæ wektorów (wierszy)

	public static void main(String[] args) {
		Random rand = new Random();
		FabrykaKlockow fabryka = new FabrykaKlockow();
		
		int r1 = rand.nextInt(100)+1;
		int HMCR = rand.nextInt(100)+1; // Wyloswanie parametru pocz¹tkowego HMCR
		
		Klocek HM[][] = new Klocek[iloscKlockow][HMS]; // Tworzê tablicê wektorów(wierszy) HM.
		for(int i=0; i<HMS; i++){
			HM[i] = fabryka.losujWszystkieKlocki(); // Przypisujê wektor do wiersza
		}
		//----- Ca³a wylosowana tablica
		for(int i=0; i<HMS; i++){
			for (int j=0; j<iloscKlockow; j++){
				System.out.print(HM[i][j].getWaga()+ "  ");
			}
			System.out.println();
		}
		//-----------------------------------------------
		if (r1<= HMCR){
			Klocek wektorHMCR[] = new Klocek[iloscKlockow];
			for(int i=0; i<iloscKlockow; i++){
				int losowyElement = -1;
				for (int j=0; j<HMS; j++){
					losowyElement = rand.nextInt(HMS); // Losujê losowy indeks wiersza
				}
				wektorHMCR[i]=HM[losowyElement][i]; // Pierwszy element nowego wektora to losowy element z pierwszej kolumny
			}
			System.out.println("");
			for(int i=0; i<iloscKlockow; i++){
				System.out.print(wektorHMCR[i].getWaga() + "  ");
			}
			// Nastêpnie PAR
		}
		else{
			//tworze wektor ze wzoru
		}
		//dostrojenie tablicy
	}
}
