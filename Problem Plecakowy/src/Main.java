import java.util.Random;

public class Main {

	static int iloscKlockow = 10; // Iloœæ ró¿nych klocków, które program
									// wygeneruje
	static int dolnaGranicaKlocka = 0; // Najni¿sza mo¿liwa waga klocka
	static int gornaGranicaKlocka = 3; // Najwy¿sza mo¿liwa waga klocka
	static int HMS = 5; // HM Size - iloœæ wektorów (wierszy)
	static double pojemnoscPlecaka = 17.0; // Pojemnoœæ plecaka - ile kg klocków mo¿e pomieœciæ

	public static void main(String[] args) {
		Random rand = new Random();
		FabrykaKlockow fabryka = new FabrykaKlockow();
		
		int r1 = rand.nextInt(100)+1;
		int HMCR = rand.nextInt(100)+1; // Wyloswanie parametru pocz¹tkowego HMCR
		double tablicaSumWag[] = new double[HMS+1];
		
		Klocek HM[][] = new Klocek[iloscKlockow][HMS]; // Tworzê tablicê wektorów(wierszy) HM.
		for(int i=0; i<HMS; i++){
			HM[i] = fabryka.losujWszystkieKlocki(); // Przypisujê wektor do wiersza
		}
		//----- Ca³a wylosowana tablica
		for(int i=0; i<HMS; i++){
			double waga = 0;
			for (int j=0; j<iloscKlockow; j++){
				System.out.print(HM[i][j].getWaga()+ "  ");
				waga += HM[i][j].getWaga();
			}
			System.out.println(waga);
			tablicaSumWag[i]=waga;
			waga = 0;
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
			int PAR = rand.nextInt(100)+1;
			int r3 = rand.nextInt(100)+1;
			if(r3 != PAR){
				//dostrojenie wektoru
				double wagaWektora = 0;
				double najnizszaWaga = gornaGranicaKlocka;
				double najwyzszaWaga  = dolnaGranicaKlocka;
				int indeksNajmniejszegoElementu = 0;
				int indeksNajwiekszegoElementu = 0;
				for(int i=0; i<iloscKlockow; i++){
					wagaWektora += wektorHMCR[i].getWaga();  // Obliczenie sumy wag wszystkich elementów wektoru
					if(wektorHMCR[i].getWaga()<najnizszaWaga){
						najnizszaWaga = wektorHMCR[i].getWaga(); // Znajduje najmniejszy element wektoru
						indeksNajmniejszegoElementu = i;
					}
					if(wektorHMCR[i].getWaga()>najwyzszaWaga){
						najwyzszaWaga = wektorHMCR[i].getWaga(); // Znajduje najwiekszy element wektoru
						indeksNajwiekszegoElementu = i;
					}
				}
				int wspolrzednaX = rand.nextInt(iloscKlockow);
				int wspolrzednaY = rand.nextInt(HMS);
				if(wagaWektora < pojemnoscPlecaka){
					wektorHMCR[indeksNajmniejszegoElementu].setWaga(HM[wspolrzednaY][wspolrzednaX].getWaga());
					System.out.println("Waga ca³ego wektora wynosi" + wagaWektora + ", a najmniejszy wynosi " + najnizszaWaga);
				}
				if(wagaWektora > pojemnoscPlecaka){
					wektorHMCR[indeksNajwiekszegoElementu].setWaga(HM[wspolrzednaY][wspolrzednaX].getWaga());
					System.out.println("Waga ca³ego wektora wynosi " + wagaWektora + ", a najwiekszy wynosi " + najwyzszaWaga);
				}
				
				System.out.println("");
				for(int i=0; i<iloscKlockow; i++){
					System.out.print(wektorHMCR[i].getWaga() + "  ");
				}
				wagaWektora = 0;
				for(int i=0; i<iloscKlockow; i++){
					wagaWektora += wektorHMCR[i].getWaga();  // Obliczenie sumy wag wszystkich elementów wektoru
					if(wektorHMCR[i].getWaga()<najnizszaWaga){
						najnizszaWaga = wektorHMCR[i].getWaga(); // Znajduje najmniejszy element wektoru
						indeksNajmniejszegoElementu = i;
					}
					if(wektorHMCR[i].getWaga()>najwyzszaWaga){
						najwyzszaWaga = wektorHMCR[i].getWaga(); // Znajduje najwiekszy element wektoru
						indeksNajwiekszegoElementu = i;
					}
				}
				if(wagaWektora < pojemnoscPlecaka){
					System.out.println("Waga ca³ego wektora wynosi " + wagaWektora);
					tablicaSumWag[tablicaSumWag.length-1]  = wagaWektora;
				}
				if(wagaWektora > pojemnoscPlecaka){
					System.out.println("Waga ca³ego wektora wynosi " + wagaWektora);
					tablicaSumWag[tablicaSumWag.length-1]  = wagaWektora;
				}
			}
		}
		else{
			Klocek[] losowyWektor = new Klocek[iloscKlockow];
			losowyWektor = fabryka.losujWszystkieKlocki();
			double wagaLosowegoWektora = 0;
			for (int i=0; i<iloscKlockow; i++){
				wagaLosowegoWektora += losowyWektor[i].getWaga();
			}
			System.out.println("Waga nowego wektora" + wagaLosowegoWektora);
			tablicaSumWag[tablicaSumWag.length-1]  = wagaLosowegoWektora;
		}
		for(int i=0;i<HMS+1;i++){
			System.out.println(tablicaSumWag[i]);
		}
		
	}
}
