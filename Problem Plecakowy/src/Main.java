import java.util.Random;

public class Main {

	static int iloscKlockow = 10; // Ilo�� r�nych klock�w, kt�re program
									// wygeneruje
	static int dolnaGranicaKlocka = 0; // Najni�sza mo�liwa waga klocka
	static int gornaGranicaKlocka = 3; // Najwy�sza mo�liwa waga klocka
	static int HMS = 3; // HM Size - ilo�� wektor�w (wierszy)
	static double pojemnoscPlecaka = 17.0; // Pojemno�� plecaka - ile kg klock�w mo�e pomie�ci�
	static int iloscIteracji = 1000;

	public static void main(String[] args) {
		Random rand = new Random(); // 
		FabrykaKlockow fabryka = new FabrykaKlockow();
		
		int r1 = rand.nextInt(100)+1;
		int HMCR = rand.nextInt(100)+1; // Wyloswanie parametru pocz�tkowego HMCR
		double tablicaSumWag[] = new double[HMS+1]; // Tablica jednowymiarowa, kt�ra przechowuje sumy wag ka�dego wektora w HM i wag� wektora wylosowanego lub poprawionego
		Klocek wektorHMCR[] = new Klocek[iloscKlockow]; // Jest to wektor, kt�rego elementy to wylosowane elementy z odpowiadaj�cych kolumn HM 
		
		
		Klocek HM[][] = new Klocek[iloscKlockow][HMS]; // Tworz� tablic� wektor�w(wierszy) HM.
		for(int i=0; i<HMS; i++){
			HM[i] = fabryka.losujWszystkieKlocki(); // Przypisuj� wektor do wiersza
		}
		for(int n=0; n<iloscIteracji; n++){
			double tablicaSumWagMax = dolnaGranicaKlocka;
			int tablicaSumWagMaxIndeks = 0;
			double tablicaSumWagMin = gornaGranicaKlocka*iloscKlockow;
			int tablicaSumWagMinIndeks = 0;
			//----- Ca�a wylosowana tablica
			for(int i=0; i<HMS; i++){
				double waga = 0; // Deklaruj� wag� jednego wektora
				for (int j=0; j<iloscKlockow; j++){
					System.out.print(HM[i][j].getWaga()+ "  "); // Wypisuj� wag� jednego klocka
					waga += HM[i][j].getWaga(); // Sumuj� wag� wszystkich klock�w w wektorze
				}
				waga = round(waga, 2);
				System.out.println("Wektor wa�y " + waga); // Wypisuj� wag� ca�ego wektora
				tablicaSumWag[i]=waga; // Wpisuj� wag� wektor�w do tablicy
				waga = 0; // Zeruj� wag�
				System.out.println();
			}
			//-----------------------------------------------
			if (r1<= HMCR){
				System.out.println("Wchodz� do HMCR");
				
				double wagaWektora = 0;
				
				
				for(int i=0; i<iloscKlockow; i++){
					int losowyElement = -1;
					for (int j=0; j<HMS; j++){
						losowyElement = rand.nextInt(HMS); // Losuj� losowy indeks wiersza
					}
					wektorHMCR[i]=HM[losowyElement][i]; // Ka�dy element nowego wektora to losowy element z odpowiadaj�cej mu kolumny
					}
				System.out.println("Wylosowa�em nast�puj�cy wektor");
				for(int i=0; i<iloscKlockow; i++){
					System.out.print(wektorHMCR[i].getWaga() + "  "); // Wypisuj� wagi klock�w w nowym wektorze
					wagaWektora += wektorHMCR[i].getWaga();
					tablicaSumWag[tablicaSumWag.length-1] = wagaWektora;
				}
				wagaWektora = round(wagaWektora, 2);
				System.out.println(", kt�ry wa�y " + wagaWektora);
				int PAR = rand.nextInt(100)+1; // Losuj� PAR
				int r3 = rand.nextInt(100)+1; // Losuj� r3
				if(r3 <= PAR){ // 50% szans na wej�cie do �rodka
					System.out.println("Wchodz� do PAR");
					//Dostrojenie wektora
					double najnizszaWaga = gornaGranicaKlocka;
					double najwyzszaWaga  = dolnaGranicaKlocka;
					int indeksNajmniejszegoElementu = 0;
					int indeksNajwiekszegoElementu = 0;
					
					for(int i=0; i<iloscKlockow; i++){
						if(wektorHMCR[i].getWaga()<najnizszaWaga){
							najnizszaWaga = wektorHMCR[i].getWaga(); // Znajduj� najmniejszy element wektora
							indeksNajmniejszegoElementu = i; // Znajduj� jego miejsce w wektorze
						}
						if(wektorHMCR[i].getWaga()>najwyzszaWaga){
							najwyzszaWaga = wektorHMCR[i].getWaga(); // Znajduj� najwiekszy element wektora
							indeksNajwiekszegoElementu = i; // Znajduj� jego miejsce w wektorze
						}
					}
					
					wagaWektora = round(wagaWektora, 2); // Zaokr�glam wag� do 2 miejsc po przecinku
					
					int wspolrzednaX = rand.nextInt(iloscKlockow); // Losuje wspolrzedna x losowego elementu z calej tablicy HM
					int wspolrzednaY = rand.nextInt(HMS); // Losuje wspolrzedna y losowego elementu z calej tablicy HM
					if(wagaWektora < pojemnoscPlecaka){ // Je�li wektor jest mniejszy od oczekiwanej wagi, dostrajamy go zamieniaj�c najmniejszy element z wylosowanym za pomoc� wsp�rz�dnych losowych
						System.out.print("Wektor wa�y za ma�o. Waga ca�ego wektora wynosi " + wagaWektora + ", a waga najmniejszego elementu wynosi " + najnizszaWaga);
						wektorHMCR[indeksNajmniejszegoElementu].setWaga(HM[wspolrzednaY][wspolrzednaX].getWaga()); // Zamiana najmniejszego elementu losowym
					}
					if(wagaWektora > pojemnoscPlecaka){ // Je�li wektor jest wi�kszy od oczekiwanej wagi, dostrajamy go zamieniaj�c najwi�kszy element z wylosowanym za pomoc� wsp�rz�dnych losowych
						System.out.print("Wektor wa�y za du�o. Waga ca�ego wektora wynosi " + wagaWektora + ", a  waga najwi�kszego elementu wynosi " + najwyzszaWaga);
						wektorHMCR[indeksNajwiekszegoElementu].setWaga(HM[wspolrzednaY][wspolrzednaX].getWaga()); // Zamiana najwiekszego elementu losowym
					}
					
					System.out.println(", poprawiam go.");
					for(int i=0; i<iloscKlockow; i++){
						System.out.print(wektorHMCR[i].getWaga() + "  ");
					}
					wagaWektora = 0; // Zeruj� wage wektora �eby obliczy� j� na nowo
	
					for(int i=0; i<iloscKlockow; i++){
						wagaWektora += wektorHMCR[i].getWaga();  // Obliczenie sumy wag wszystkich element�w wektora
					}
					wagaWektora = round(wagaWektora, 2); // Zaokr�glam wag� do 2 miejsc po przecinku
					
					if(wagaWektora < pojemnoscPlecaka){
						System.out.println("Waga ca�ego wektora wynosi " + wagaWektora);
						tablicaSumWag[tablicaSumWag.length-1]  = wagaWektora;
					}
					if(wagaWektora > pojemnoscPlecaka){
						System.out.println("Waga ca�ego wektora wynosi " + wagaWektora);
						tablicaSumWag[tablicaSumWag.length-1]  = wagaWektora;
					}
				}
			}
			else{
				System.out.println("Nie wchodz� do HMCR");
				wektorHMCR = new Klocek[iloscKlockow];
				wektorHMCR = fabryka.losujWszystkieKlocki();
				double wagaLosowegoWektora = 0;
				for (int i=0; i<iloscKlockow; i++){
					wagaLosowegoWektora += wektorHMCR[i].getWaga();
				}
				wagaLosowegoWektora = round(wagaLosowegoWektora, 2);
				System.out.println("Waga nowego wektora " + wagaLosowegoWektora);
				tablicaSumWag[tablicaSumWag.length-1]  = wagaLosowegoWektora;
			}
			for(int i=0;i<HMS+1;i++){
				System.out.println(tablicaSumWag[i]);
			}
			for(int i=0;i<HMS;i++){
				if(tablicaSumWag[i]>tablicaSumWagMax){
					tablicaSumWagMax = tablicaSumWag[i];
					tablicaSumWagMaxIndeks = i;
				}
				if(tablicaSumWag[i]<tablicaSumWagMin){
					tablicaSumWagMin = tablicaSumWag[i];
					tablicaSumWagMinIndeks = i;
				}
			}
			if(tablicaSumWagMax > pojemnoscPlecaka){
				System.out.println("Istniej� elementy wi�kszy ni� waga plecaka");
				if(tablicaSumWag[tablicaSumWag.length-1] > tablicaSumWagMax){
					System.out.println("Wylosowany element jest wiekszy niz najwiekszy, nie zamieniam ich");
				}
				else{
					System.out.println("Wylosowany element jest mniejszy niz najwiekszy, zamieniam je");
					HM[tablicaSumWagMaxIndeks] = wektorHMCR;
				}
			}
			else{
				System.out.println("Nie ma elementow wiekszych niz waga plecaka");
				if(tablicaSumWag[tablicaSumWag.length-1] > tablicaSumWagMin){
					if(tablicaSumWag.length-1 > pojemnoscPlecaka){
						System.out.println("Wylosowany element jest wiekszy niz najmniejszy, ale te� wi�kszy ni� waga plecaka i nie zamieniam ich");
					}
					else{
						System.out.println("Wylosowany element jest wiekszy niz najmniejszy i mniejszy ni� waga plecaka, zamieniam je");
						HM[tablicaSumWagMinIndeks] = wektorHMCR;
					}
				}
				else{
					System.out.println("Wylosowany element jest mniejszy niz najmniejszy, nie zamieniam ich");
				}
			}
			//System.out.println("Najwiekszy element to " + tablicaSumWagMax + " i jest na pozycji " + (tablicaSumWagMaxIndeks+1));
			//System.out.println("Najmniejszy element to " + tablicaSumWagMin + " i jest na pozycji " + (tablicaSumWagMinIndeks+1));
			for(int i=0; i<HMS; i++){
				double waga = 0; // Deklaruj� wag� jednego wektora
				for (int j=0; j<iloscKlockow; j++){
					System.out.print(HM[i][j].getWaga()+ "  "); // Wypisuj� wag� jednego klocka
					waga += HM[i][j].getWaga(); // Sumuj� wag� wszystkich klock�w w wektorze
				}
				waga = round(waga, 2);
				System.out.println("Wektor wa�y " + waga); // Wypisuj� wag� ca�ego wektora
				tablicaSumWag[i]=waga; // Wpisuj� wag� wektor�w do tablicy
				waga = 0; // Zeruj� wag�
				System.out.println("");
			}
			System.out.println("-----------------------------------------------------------------------");
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
