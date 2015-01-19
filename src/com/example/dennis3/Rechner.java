package com.example.dennis3;
public class Rechner {
	
	// Klasse um Netzmaske, Netzadresse, Broadcastadresse, Anzahl der möglichen
	// Hosts und die kleinste und grösste ip für Hosts auszurechnen

	// Deklarierung der benötigten Variablen
	int ipadresse1, ipadresse2, ipadresse3, ipadresse4;
	int netzmaske1, netzmaske2, netzmaske3, netzmaske4;
	int netzadresse1, netzadresse2, netzadresse3, netzadresse4;
	int geraeteteil1, geraeteteil2, geraeteteil3, geraeteteil4;
	int broadcast1, broadcast2, broadcast3, broadcast4;
	int moeglicheHosts;
	int ip_von;

	// Constructor in dem bei der Instanzierung der Klasse
	// die 4 Oktette der Ipadresse übergeben weren müssen
	public Rechner(int ipadresse1, int ipadresse2, int ipadresse3,
			int ipadresse4) {
		super();
		this.ipadresse1 = ipadresse1;
		this.ipadresse2 = ipadresse2;
		this.ipadresse3 = ipadresse3;
		this.ipadresse4 = ipadresse4;

		// getter und setter Methoden
	}

	public int getIp_von() {
		return ip_von;
	}

	public void setIp_von(int ip_von) {
		this.ip_von = ip_von;
	}

	public int getMoeglicheHosts() {
		return moeglicheHosts;
	}

	public void setMoeglicheHosts(int moeglicheHosts) {
		this.moeglicheHosts = moeglicheHosts;
	}

	public int getIpadresse1() {
		return ipadresse1;
	}

	public void setIpadresse1(int ipadresse1) {
		this.ipadresse1 = ipadresse1;
	}

	public int getIpadresse2() {
		return ipadresse2;
	}

	public void setIpadresse2(int ipadresse2) {
		this.ipadresse2 = ipadresse2;
	}

	public int getIpadresse3() {
		return ipadresse3;
	}

	public void setIpadresse3(int ipadresse3) {
		this.ipadresse3 = ipadresse3;
	}

	public int getIpadresse4() {
		return ipadresse4;
	}

	public void setIpadresse4(int ipadresse4) {
		this.ipadresse4 = ipadresse4;
	}

	public int getNetzmaske1() {
		return netzmaske1;
	}

	public void setNetzmaske1(int netzmaske1) {
		this.netzmaske1 = netzmaske1;
	}

	public int getNetzmaske2() {
		return netzmaske2;
	}

	public void setNetzmaske2(int netzmaske2) {
		this.netzmaske2 = netzmaske2;
	}

	public int getNetzmaske3() {
		return netzmaske3;
	}

	public void setNetzmaske3(int netzmaske3) {
		this.netzmaske3 = netzmaske3;
	}

	public int getNetzmaske4() {
		return netzmaske4;
	}

	public void setNetzmaske4(int netzmaske4) {
		this.netzmaske4 = netzmaske4;
	}
	
	// Methode um die Netzmasken abzuholen. es wird ein Objekt der Klasse
	// Cidre erstellt und die Methode CidreBestimmen() aufgerufen
	// dann werden die 4 Oktette der Netzmasken durch die getNetzmaske()
	// abgeholt und in die Instanzvariablen( this.netzmaske1 )der Klasse 
	// Rechner gespeichert
	// 

	public String holeNetzmasken(int cidre) {
		Cidre c2 = new Cidre(cidre);
		c2.CidreBestimmen();
		this.netzmaske1 = c2.getNetzmaske1();
		this.netzmaske2 = c2.getNetzmaske2();
		this.netzmaske3 = c2.getNetzmaske3();
		this.netzmaske4 = c2.getNetzmaske4();
		
		return this.netzmaske1+"."+this.netzmaske2+"."
		+this.netzmaske3+"."+this.netzmaske4;

	}

	// Methode um die möglichen Hosts für die übergebene cidre zu erhalten
	// es wird ein Objekt der Klasse Cidre erstellt und die Methode
	// CidreBestimmen aufgerufen, dann speichern wir den Wert in die Instanvariable
	// this.moeglicheHosts
	public void bestimmeMoeglicheHosts(int cidre) {
		Cidre c3 = new Cidre(cidre);
		c3.CidreBestimmen();
		this.moeglicheHosts = c3.getMoeglicheHosts();

	}

	// Methode vom Typ Stringum Netzadresse zu berechnen, es werden dei jeweilgen Oktette
	// der Ipadresse mit denen der Netzmaske verundet
	// das ergebnis ist die Netzadresse
	// am Ende bauen wir und einen String und fügen die Netzadresse zusammen
	public String berechneNetzadresse() {

		this.netzadresse1 = this.ipadresse1 & this.netzmaske1;
		this.netzadresse2 = this.ipadresse2 & this.netzmaske2;
		this.netzadresse3 = this.ipadresse3 & this.netzmaske3;
		this.netzadresse4 = this.ipadresse4 & this.netzmaske4;

		return "" + this.netzadresse1 + "."
				+ this.netzadresse2 + "." + this.netzadresse3 + "."
				+ this.netzadresse4;
	}

	public String berechneGeraeteteil() {

		this.geraeteteil1 = this.ipadresse1 & ~this.netzmaske1;
		this.geraeteteil2 = this.ipadresse2 & ~this.netzmaske2;
		this.geraeteteil3 = this.ipadresse3 & ~this.netzmaske3;
		this.geraeteteil4 = this.ipadresse4 & ~this.netzmaske4;

		return "" + this.geraeteteil1 + "."
				+ this.geraeteteil2 + "." + this.geraeteteil3 + "."
				+ this.geraeteteil4;
	}

	// Metode vom Typ String um die Broadcastadresse zu berechnen. 
	// wir verodern ( | ) die jeweiligen Oktette der Ipadresse mit denen
	// der Netzmaske und dann verodern wir noch die Netzmaske mit 255 allerdings 
	// mit einem exklusivem XOr ( ^ ) 
	// wir speichern die ergebnisse in die variablen der broadcast.
	// am ende bauen wir und einen String und fügen die Broadcasteadresse zusammen
	public String berechneBroadcast() {

		this.broadcast1 = this.ipadresse1 | (this.netzmaske1 ^ 255);
		this.broadcast2 = this.ipadresse2 | (this.netzmaske2 ^ 255);
		this.broadcast3 = this.ipadresse3 | (this.netzmaske3 ^ 255);
		this.broadcast4 = this.ipadresse4 | (this.netzmaske4 ^ 255);

		return ""+ this.broadcast1 + "." + this.broadcast2
				+ "." + (this.broadcast3) + "." + this.broadcast4;

	}
	
	// Methode vom Typ String um die grösste Ip für Hosts im Netz zu ermitteln
	// wir bauen uns einfach einen String mit den 4 oktetten der Broadcastadresse,
	// und ziehen vom letzden Oketett 1 ab
	
	public String berechneGroessteIp() {
		return "" + this.broadcast1 + "." + this.broadcast2
				+ "." + (this.broadcast3) + "." + (this.broadcast4 - 1);

	}
	
	// Methode vom Typ String um die kleinste Ip für hosts zu ermitteln
	// wir bauen uns einfach einen String mit den 4 oktetten der Netzadresse
	// und rechnen im letzden Oketett 1 dazu

	public String berechneKleinsteIp() {
		return "" + this.netzadresse1 + "."
				+ this.netzadresse2 + "." + this.netzadresse3 + "."
				+ (this.netzadresse4 + 1);

	}

}