public class Main {
	
	static int iloscKlockow = 10; // Iloœæ ró¿nych klocków, które program wygeneruje
	static int dolnaGranicaKlocka = 0; // Najni¿sza mo¿liwa waga klocka
	static int gornaGranicaKlocka = 3; // Najwy¿sza mo¿liwa waga klocka

	public static void main(String[] args) {
		FabrykaKlockow fabryka = new FabrykaKlockow();
		
		Klocek klocki[] = fabryka.losujWszystkieKlocki();
		for(int i=0; i<iloscKlockow; i++){	
			System.out.println(klocki[i].getWaga());
		}
	}
}
