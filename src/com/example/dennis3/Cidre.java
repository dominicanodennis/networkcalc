package com.example.dennis3;
public class Cidre {

	// Klasse für die ermittlung der Netzmasken für die jeweile Cidr
	// bei Instanzierung muss eine cidre als int übergeben werden ( constructor)
	// die Werte der jeweiligen Submasken werden zurückgegeben
	// submasken sind in 4 Oktette aufgeteilt netzmaske1 ... u.s.w
	int netzmaske1, netzmaske2, netzmaske3, netzmaske4;
	int cidre;
	int moeglicheHosts;

	public Cidre(int cidre) {
		super();
		this.cidre = cidre;
	}

	public int getMoeglicheHosts() {
		return moeglicheHosts;
	}

	public void setMoeglicheHosts(int moeglicheHosts) {
		this.moeglicheHosts = moeglicheHosts;
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

	public int getCidre() {
		return cidre;
	}

	public void setCidre(int cidre) {
		this.cidre = cidre;
	}

	// Methode um moegliche Hosts und Werte der Sumasken zurückzugeben
	// besteht aus einem switch case wobei der this.cidre als parameter 
	// übergeben werden muss
	public void CidreBestimmen() {

		switch (this.cidre) {
		case 1:
			this.netzmaske1 = 128;
			this.netzmaske2 = 0;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = (int) 2147483646L;
			break;
		case 2:
			this.netzmaske1 = 192;
			this.netzmaske2 = 0;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = (int) 1073741822L;
			break;
		case 3:
			this.netzmaske1 = 224;
			this.netzmaske2 = 0;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 536870910;
			break;
		case 4:
			this.netzmaske1 = 240;
			this.netzmaske2 = 0;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 268435454;
			break;
		case 5:
			this.netzmaske1 = 248;
			this.netzmaske2 = 0;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 134217726;
			break;
		case 6:
			this.netzmaske1 = 252;
			this.netzmaske2 = 0;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 67108862;
			break;
		case 7:
			this.netzmaske1 = 254;
			this.netzmaske2 = 0;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 33554430;
			break;
		case 8:
			this.netzmaske1 = 255;
			this.netzmaske2 = 0;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 16777214;
			break;
		case 9:
			this.netzmaske1 = 255;
			this.netzmaske2 = 128;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 8388606;
			break;
		case 10:
			this.netzmaske1 = 255;
			this.netzmaske2 = 192;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 4194302;
			break;
		case 11:
			this.netzmaske1 = 255;
			this.netzmaske2 = 224;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 2097150;
			break;
		case 12:
			this.netzmaske1 = 255;
			this.netzmaske2 = 240;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 1048574;
			break;
		case 13:
			this.netzmaske1 = 255;
			this.netzmaske2 = 248;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 524286;
			break;
		case 14:
			this.netzmaske1 = 255;
			this.netzmaske2 = 252;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 262142;
			break;
		case 15:
			this.netzmaske1 = 255;
			this.netzmaske2 = 254;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 131070;
			break;
		case 16:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 0;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 65534;
			break;
		case 17:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 128;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 32766;
			break;
		case 18:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 192;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 16382;
			break;
		case 19:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 224;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 8190;
			break;
		case 20:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 240;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 4094;
			break;
		case 21:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 248;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 2046;
			break;
		case 22:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 252;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 1022;
			break;
		case 23:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 254;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 510;
			break;
		case 24:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 255;
			this.netzmaske4 = 0;
			this.moeglicheHosts = 254;
			break;
		case 25:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 255;
			this.netzmaske4 = 128;
			this.moeglicheHosts = 126;
			break;
		case 26:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 255;
			this.netzmaske4 = 192;
			this.moeglicheHosts = 62;
			break;
		case 27:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 255;
			this.netzmaske4 = 224;
			this.moeglicheHosts = 30;
			break;
		case 28:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 255;
			this.netzmaske4 = 240;
			this.moeglicheHosts = 14;
			break;
		case 29:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 255;
			this.netzmaske4 = 248;
			this.moeglicheHosts = 6;
			break;
		case 30:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 255;
			this.netzmaske4 = 252;
			this.moeglicheHosts = 2;
			break;
		case 31:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 255;
			this.netzmaske4 = 254;
			this.moeglicheHosts = 0;
			break;
		case 32:
			this.netzmaske1 = 255;
			this.netzmaske2 = 255;
			this.netzmaske3 = 255;
			this.netzmaske4 = 255;
			this.moeglicheHosts = 0;
			break;
		default:
			System.out.println("falsche Cidre");

		}
		
	}

}
