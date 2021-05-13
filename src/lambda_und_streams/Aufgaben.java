package lambda_und_streams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import BuLi.Spiel;
import BuLi.Verein;

class Aufgaben {
	private boolean initialized = false;
	private boolean buLiInitialized = false;
	private ArrayList<Integer> numbers = new ArrayList<Integer>();
	private ArrayList<Long> multiplyNumbers = new ArrayList<Long>();
	private ArrayList<Spiel> spiele = new ArrayList<Spiel>();
	private HashMap<Integer, Verein> vereine = new HashMap<Integer, Verein>();

	void Init(int anzahlZahlen, int min, int max) {
		for(int i = 0; i < anzahlZahlen; i++) {
			int rnd = (int) (Math.random() * (max + 1 - min));
			numbers.add(rnd);
			if(i < 10) {
				multiplyNumbers.add((long) rnd + 1);
			}
		}
		initialized = true;
	}

	void InitBuLi() {
		Scanner s = new Scanner(Aufgaben.class.getResourceAsStream("/BuLi/bundesliga_Verein.csv"), "ISO-8859-1");
		String[] line;
		s.nextLine();
		while(s.hasNextLine()) {
			line = s.nextLine().split(";");
			vereine.put(Integer.parseInt(line[0]), new Verein(Integer.parseInt(line[0]), line[1]));
		}

		s.close();

		s = new Scanner(Aufgaben.class.getResourceAsStream("/BuLi/bundesliga_Spiel.csv"), "ISO-8859-1");
		s.nextLine();
		while(s.hasNextLine()) {
			line = s.nextLine().split(";");
			spiele.add(new Spiel(Integer.parseInt(line[0]), Integer.parseInt(line[1]),
					vereine.get(Integer.parseInt(line[4])).getName(),
					vereine.get(Integer.parseInt(line[5])).getName(),
					Integer.parseInt(line[6]), Integer.parseInt(line[7]), line[2], line[3]));
		}
		s.close();
		buLiInitialized = true;
	}

	void Aufgabe_1() {
		/*
		 *Aufgabe 1 
		 * 
		 * Geben Sie alle Einträge der Arraylist numbers mit Hilfe einer Lambda expression aus.
		 * 
		 */
		
		System.out.println("Aufgabe 1:");
		numbers.forEach(x -> {System.out.println(x);});

		//Output Padding
		System.out.println();
	}

	void Aufgabe_2() {
		/*
		 *Aufgabe 2 
		 * 2.1:
		 * Geben Sie alle gerade Zahlen der Arraylist numbers mit Hilfe 
		 * einer Lambda expression ineiner Zeile aus.
		 * 
		 * 2.2:
		 * Geben Sie alle ungerade Zahlen der Arraylist numbers mit Hilfe
		 * einer Lambda expression in einer Zeile aus.
		 * 
		 */

		/* Lösung 2.1 
		 * Modulo 2 == 0 beduetet alle geraden Zahlen
		 */
		System.out.println("Aufgabe 2.1:");
		numbers.forEach(x -> {if(x % 2 == 0) {
			System.out.print(x + ", ");}
		});


		//Output Padding
		System.out.println();
		System.out.println();

		/* Lösung 2.2
		 * Modulo 2 == 0 beduetet alle ungeraden Zahlen 
		 */
		System.out.println("Aufgabe 2.2:");
		numbers.forEach(x -> {if(x % 2 == 1) {
			System.out.print(x + ", ");}
		});

		//Output Padding
		System.out.println();
		System.out.println();
	}

	void Aufgabe_3() {
		/*
		 *Aufgabe 3 
		 * 
		 * 3.1
		 * Berechnen Sie die Summe aller Zahlen der Arraylist numbers und
		 * geben Sie das Ergebnis aus. Sie sollten dabei einen Stream nutzen.
		 * 
		 * 3.2
		 * Verdoppeln Sie mit Hilfe eines Streams alle Zahlen der Arraylist
		 * numbers und geben Sie die Ergebnise in einer Zeile aus.
		 * 
		 * 3.3
		 * Geben Sie zuerst alle Zahlen der Arraylist multiplyNumbers in
		 * einer Zeile aus. Danach multiplizieren Sie alle Zahlen und geben
		 * das Ergebnis in derselben Zeile aus. Nutzen hierfür nur einen Stream!
		 * 
		 */

		/*Lösung 3.1 
		 * .reduce() gibt nur einen wert am ende zurück. 0 ist der Anfangswert,
		 * danach wird immer die nächste zahl dazu addiert (x + y)
		 */
		System.out.println("Aufgabe 3.1:");
		System.out.println(numbers.stream().reduce(0,(x, y) -> x + y));

		//Output Padding
		System.out.println();

		/* Lösung 3.2
		 * .map() gibt einen neuen Stream zurück nachdem die Funktion auf jedes der Elemente angewandt wurde.
		 * Die Funktion entspricht hier dem verdoppeln jeder Zahl (x * 2)
		 */
		System.out.println("Aufgabe 3.2:");
		numbers.stream().map(x -> x *2).forEach(x -> System.out.print(x + ", "));

		//Output padding
		System.out.println();
		System.out.println();

		/* Lösung 3.3 
		 * .peek() ist eine intermediate operation und erlaubt es stream objekte zu nutzen ohen sie zu "verbrauchen"
		 * Hier casten wir bei .reduce() zur Sicherheit zu dem Datentyp long um einen Overflow zu vermeiden.
		 * Math::multiplyExact macht quasi das selbe wie (x, y) -> x * y. Es hat aber den vorteil das es eine OverflowException
		 * werfen würde. Bei der normalen Lambda Expression würde einfach der Wert 0 zurück gegeben werden.
		 */
		System.out.println("Aufgabe 3.3:");
		System.out.println(multiplyNumbers.stream().peek(x -> System.out.print(x + ", ")).reduce((long) 1, Math::multiplyExact));

		//Output Padding
		System.out.println();
	}

	void Aufgabe_4() {
		/*
		 *Aufgabe 4
		 * 
		 * 4.1
		 * Geben Sie die Gesamtanzahl aller geschossenen Tore getrennt nach Heim- und Gasttoren aus.
		 * 
		 * 4.2
		 *  Geben Sie eine Liste aller Spiele eines Vereines aus.
		 *  Die Liste sollte nach Spieltag sortiert sein und folgende
		 *  Daten enthalten: Datum, Spieltag, Heim Mannschaft, Gast
		 *  Mannschaft, Tore der Heim Mannschaft, Tore der Gast Mannschaft.
		 * 
		 * 4.3
		 * Geben Sie die Anzahl der geschossenen Tore und der Gegentore
		 * eines Vereins aus
		 * 
		 * 4.4
		 * Geben Sie die Tordifferenz eines Vereines aus.
		 * 
		 */

		String mannschaft = "RB Leipzig";

		/* Lösung Aufgabe 4.1
		 * .map() gibt einen neuen Stream zurück nachdem die Lambda Funktion ausgeführt wurde.
		 * Dies muss hier gemacht werden da .reduce() den Typen erwartet welcher dem Aufrufenden Stream zu Grunde liegt.
		 * Würde man hier also keinen neuen Stream erstellen würde reduce ein Ergebnis des Typ "Spiel" erwarten
		 */
		System.out.println("Aufgabe 4.1:");
		System.out.println("Heimtore: " + spiele.stream().map(x -> x.getToreHeim()).reduce(0, (x, y) -> x + y) +
				" - Gasttore: " + spiele.stream().map(x -> x.getToreGast()).reduce(0, (x, y) -> x + y));

		//Output Padding
		System.out.println();

		/* Lösung Aufgabe 4.2
		 * Beide beispiele funktionieren.
		 * Bei dem ersten wird der komplette Datensatz durchgereicht bis zu dem forEach und erst dort per if() gefiltert
		 * Bei dem zweiten filtert man am Anfang um die Datenmenge zu reduzieren
		 * 
		 * Bei beiden wurde zusätzlich nach Spieltag sortiert.
		 */
		System.out.println("Aufgabe 4.2 (Lösung 1):");
		spiele.stream().sorted((x, y) -> Integer.compare(x.getSpieltag(), y.getSpieltag())).
		forEach(x -> {if(x.getHeim().equals(mannschaft) || x.getGast().equals(mannschaft) ) {
			System.out.println(x.getDatum() + "\tSpieltag: " + x.getSpieltag() + ",\t" + 
					x.getToreHeim() + ":" + x.getToreGast() + "\t" + x.getHeim() + " - " + x.getGast() );}
		});

		//Output Padding
		System.out.println();

		System.out.println("Aufgabe 4.2 (Lösung 2):");
		spiele.stream().filter(x -> x.getHeim().equals(mannschaft) || x.getGast().equals(mannschaft)).
		sorted((x, y) -> Integer.compare(x.getSpieltag(), y.getSpieltag())).
		forEach(x -> {System.out.println(x.getDatum() + "\tSpieltag: " + x.getSpieltag() + ",\t" + 
				x.getToreHeim() + ":" + x.getToreGast() + "\t" + x.getHeim() + " - " + x.getGast() );
		});

		//Output Padding
		System.out.println();
		/*
		 * Lösung Aufgabe 4.3
		 * Hier verwenden wir ein ternary if in der .map() abhängig davon ob die ausgwählte Mannschaft das Heim oder Gastteam ist
		 * um die Tore zu ermitteln.
		 * Ansonsten funktioniert es Analog zu 4.1
		 */			
		System.out.println("Aufgabe 4.3:");
		System.out.println("Tore: " + spiele.stream().filter(x -> x.getHeim().equals(mannschaft) || x.getGast().equals(mannschaft)).
				map((x) -> x.getHeim().equals(mannschaft) ? x.getToreHeim() : x.getToreGast()).reduce(0, (x, y) -> x + y) +
				" - Gegentore: " + spiele.stream().filter(x -> x.getHeim().equals(mannschaft) || x.getGast().equals(mannschaft)).
				map((x) -> x.getHeim().equals(mannschaft) ? x.getToreGast() : x.getToreHeim()).reduce(0, (x, y) -> x + y));

		//Output Padding
		System.out.println();

		/* Lösung Aufgabe 4.4
		 * Die Berechnung funktioniert Analog zu Aufgabe 4.3 mit dem zusatz das wir bereits in der .map() 
		 * die gegentore von den erzielten Toren abziehen
		 */
		System.out.println("Aufgabe 4.4:");
		System.out.println(spiele.stream().filter(x -> x.getHeim().equals(mannschaft) || x.getGast().equals(mannschaft)).
				map((x) -> x.getHeim().equals(mannschaft) ? x.getToreHeim() - x.getToreGast() : x.getToreGast() - x.getToreHeim()).
				reduce(0, (x, y) -> x + y));

		//Output Padding
		System.out.println();
	}

	public boolean isInitialized() {
		return initialized;
	}

	public boolean isBuLiInitialized() {
		return buLiInitialized;
	}


}
