import java.util.Random;

public class Main {

	static int iloscKlockow = 10; // Iloœæ ró¿nych klocków, które program
									// wygeneruje
	static int dolnaGranicaKlocka = 0; // Najni¿sza mo¿liwa waga klocka
	static int gornaGranicaKlocka = 3; // Najwy¿sza mo¿liwa waga klocka
	static int HMS = 5; // HM Size - iloœæ wektorów (wierszy)
	static double pojemnoscPlecaka = 17.0; // Pojemnoœæ plecaka - ile kg klocków mo¿e pomieœciæ

	public static void main(String[] args) {
		Random rand = new Random(); // 
		FabrykaKlockow fabryka = new FabrykaKlockow();
		
		int r1 = rand.nextInt(100)+1;
		int HMCR = rand.nextInt(100)+1; // Wyloswanie parametru pocz¹tkowego HMCR
		double tablicaSumWag[] = new double[HMS+1]; // Tablica jednowymiarowa, która przechowuje sumy wag ka¿dego wektora w HM i wagê wektora wylosowanego lub poprawionego
		
		Klocek HM[][] = new Klocek[iloscKlockow][HMS]; // Tworzê tablicê wektorów(wierszy) HM.
		for(int i=0; i<HMS; i++){
			HM[i] = fabryka.losujWszystkieKlocki(); // Przypisujê wektor do wiersza
		}
		//----- Ca³a wylosowana tablica
		for(int i=0; i<HMS; i++){
			double waga = 0; // Deklarujê wagê jednego wektora
			for (int j=0; j<iloscKlockow; j++){
				System.out.print(HM[i][j].getWaga()+ "  "); // Wypisujê wagê jednego klocka
				waga += HM[i][j].getWaga(); // Sumujê wagê wszystkich klocków w wektorze
			}
			waga = round(waga, 2);
			System.out.println("Wektor wa¿y " + waga); // Wypisujê wagê ca³ego wektora
			tablicaSumWag[i]=waga; // Wpisujê wagê wektorów do tablicy
			waga = 0; // Zerujê wagê
			System.out.println();
		}
		//-----------------------------------------------
		if (r1<= HMCR){
			System.out.println("Wchodzê do HMCR");
			
			double wagaWektora = 0;
			
			Klocek wektorHMCR[] = new Klocek[iloscKlockow]; // Jest to wektor, którego elementy to wylosowane elementy z odpowiadaj¹cych kolumn HM 
			for(int i=0; i<iloscKlockow; i++){
				int losowyElement = -1;
				for (int j=0; j<HMS; j++){
					losowyElement = rand.nextInt(HMS); // Losujê losowy indeks wiersza
				}
				wektorHMCR[i]=HM[losowyElement][i]; // Ka¿dy element nowego wektora to losowy element z odpowiadaj¹cej mu kolumny
				}
			System.out.println("Wylosowa³em nastêpuj¹cy wektor");
			for(int i=0; i<iloscKlockow; i++){
				System.out.print(wektorHMCR[i].getWaga() + "  "); // Wypisujê wagi klocków w nowym wektorze
				wagaWektora += wektorHMCR[i].getWaga();
				tablicaSumWag[tablicaSumWag.length-1] = wagaWektora;
			}
			wagaWektora = round(wagaWektora, 2);
			System.out.println(", który wa¿y " + wagaWektora);
			int PAR = rand.nextInt(100)+1; // Losujê PAR
			int r3 = rand.nextInt(100)+1; // Losujê r3
			if(r3 <= PAR){ // 50% szans na wejœcie do œrodka
				System.out.println("Wchodzê do PAR");
				//Dostrojenie wektora
				double najnizszaWaga = gornaGranicaKlocka;
				double najwyzszaWaga  = dolnaGranicaKlocka;
				int indeksNajmniejszegoElementu = 0;
				int indeksNajwiekszegoElementu = 0;
				
				for(int i=0; i<iloscKlockow; i++){
					if(wektorHMCR[i].getWaga()<najnizszaWaga){
						najnizszaWaga = wektorHMCR[i].getWaga(); // Znajdujê najmniejszy element wektora
						indeksNajmniejszegoElementu = i; // Znajdujê jego miejsce w wektorze
					}
					if(wektorHMCR[i].getWaga()>najwyzszaWaga){
						najwyzszaWaga = wektorHMCR[i].getWaga(); // Znajdujê najwiekszy element wektora
						indeksNajwiekszegoElementu = i; // Znajdujê jego miejsce w wektorze
					}
				}
				
				wagaWektora = round(wagaWektora, 2); // Zaokr¹glam wagê do 2 miejsc po przecinku
				
				int wspolrzednaX = rand.nextInt(iloscKlockow); // Losuje wspolrzedna x losowego elementu z calej tablicy HM
				int wspolrzednaY = rand.nextInt(HMS); // Losuje wspolrzedna y losowego elementu z calej tablicy HM
				if(wagaWektora < pojemnoscPlecaka){ // Jeœli wektor jest mniejszy od oczekiwanej wagi, dostrajamy go zamieniaj¹c najmniejszy element z wylosowanym za pomoc¹ wspó³rzêdnych losowych
					System.out.println("Wektor wa¿y za ma³o. Waga ca³ego wektora wynosi " + wagaWektora + ", a waga najmniejszego elementu wynosi " + najnizszaWaga);
					wektorHMCR[indeksNajmniejszegoElementu].setWaga(HM[wspolrzednaY][wspolrzednaX].getWaga()); // Zamiana najmniejszego elementu losowym
				}
				if(wagaWektora > pojemnoscPlecaka){ // Jeœli wektor jest wiêkszy od oczekiwanej wagi, dostrajamy go zamieniaj¹c najwiêkszy element z wylosowanym za pomoc¹ wspó³rzêdnych losowych
					System.out.println("Wektor wa¿y za du¿o. Waga ca³ego wektora wynosi " + wagaWektora + ", a  waga najwiêkszego elementu wynosi " + najwyzszaWaga);
					wektorHMCR[indeksNajwiekszegoElementu].setWaga(HM[wspolrzednaY][wspolrzednaX].getWaga()); // Zamiana najwiekszego elementu losowym
				}
				
				System.out.println("");
				for(int i=0; i<iloscKlockow; i++){
					System.out.print(wektorHMCR[i].getWaga() + "  ");
				}
				wagaWektora = 0; // Zerujê wage wektora ¿eby obliczyæ j¹ na nowo

				for(int i=0; i<iloscKlockow; i++){
					wagaWektora += wektorHMCR[i].getWaga();  // Obliczenie sumy wag wszystkich elementów wektora
				}
				wagaWektora = round(wagaWektora, 2); // Zaokr¹glam wagê do 2 miejsc po przecinku
				
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
			System.out.println("Nie wchodzê do HMCR");
			Klocek[] losowyWektor = new Klocek[iloscKlockow];
			losowyWektor = fabryka.losujWszystkieKlocki();
			double wagaLosowegoWektora = 0;
			for (int i=0; i<iloscKlockow; i++){
				wagaLosowegoWektora += losowyWektor[i].getWaga();
			}
			wagaLosowegoWektora = round(wagaLosowegoWektora, 2);
			System.out.println("Waga nowego wektora " + wagaLosowegoWektora);
			tablicaSumWag[tablicaSumWag.length-1]  = wagaLosowegoWektora;
		}
		for(int i=0;i<HMS+1;i++){
			System.out.println(tablicaSumWag[i]);
		}
		
	}
	
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
