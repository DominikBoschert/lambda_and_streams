package BuLi;

public class Spiel {
	private int spiel_ID, spieltag, toreHeim, toreGast;
	private String heim, gast, datum, uhrzeit;
	
	
	public Spiel(int spiel_ID, int spieltag, String heim, String gast, int toreHeim, int toreGast, String datum, String uhrzeit) {
		this.spiel_ID = spiel_ID;
		this.spieltag = spieltag;
		this.heim = heim;
		this.gast = gast;
		this.toreHeim = toreHeim;
		this.toreGast = toreGast;
		this.datum = datum;
		this.uhrzeit = uhrzeit;
	}
	
	public String getSieger() {
		return toreHeim > toreGast ? heim : toreHeim == toreGast ? "Unentschieden" : gast;
	}

	public String getVerlierer() {
		return toreHeim > toreGast ? gast : toreHeim == toreGast ? "Unentschieden" : heim;
	}
	
	public int getSpiel_ID() {
		return spiel_ID;
	}

	public int getSpieltag() {
		return spieltag;
	}

	public int getToreHeim() {
		return toreHeim;
	}

	public int getToreGast() {
		return toreGast;
	}

	public String getHeim() {
		return heim;
	}

	public String getGast() {
		return gast;
	}

	public String getDatum() {
		return datum;
	}

	public String getUhrzeit() {
		return uhrzeit;
	}
	
	
}
