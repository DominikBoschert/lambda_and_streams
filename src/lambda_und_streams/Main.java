package lambda_und_streams;



public class Main {


	public static void main(String[] args) {

		Aufgaben aufgaben = new Aufgaben();

		//.Init wird für Aufgaben 1-3 benötigt!
		aufgaben.Init(20, 0, 10);
		if(aufgaben.isInitialized()) {
			aufgaben.Aufgabe_1();
			aufgaben.Aufgabe_2();
			aufgaben.Aufgabe_3();
		} else {
			System.out.println("Aufgaben 1-3 übersprungen da die benötigten Variablen nicht initialisiert wurden!\n"
					+ "Bitte aufgaben.Init(anzahlZahlen, min, max) ausführen bevor die Funktionen der Aufgaben aufgerufen werden.");
		}

		// InitBuLi wird für Aufgabe 4 benötigt!
		aufgaben.InitBuLi();
		if(aufgaben.isBuLiInitialized()) {
			aufgaben.Aufgabe_4();
		} else {
			System.out.println("Aufgaben 4 übersprungen da die benötigten Variablen nicht initialisiert wurden!\n"
					+ "Bitte aufgaben.InitBuLi() ausführen bevor die Funktionen der Aufgabe aufgerufen werden.");
		}

	}

}
