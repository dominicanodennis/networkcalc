package com.example.dennis3;

//import de.androidbuch.rechner.R;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener {

	// Deklarierung aller erforderlichen Variablen
	private int itemCidre;
	private Button clear;
	private int ipadresse1, ipadresse2, ipadresse3, ipadresse4;

	private String[] Cidr = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31",
			"32" };
	Spinner spinner1;
	EditText netzmaske, netzwerkadresse, broadcastadresse, moeglicheHost,
			kleinsteIp, groessteIp, ip1, ip2, ip3, ip4;
	Toast toast1, toast2;

	// onCreate Methode , wir weisen unseren EditTextfeldern die
	// jeweiligen Elemente auf der View zu
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		System.out.println(Cidr.length);

		spinner1 = (Spinner) findViewById(R.id.spinner);

		netzwerkadresse = (EditText) findViewById(R.id.netzwerk);
		netzwerkadresse.setEnabled(false);

		broadcastadresse = (EditText) findViewById(R.id.broadcast);
		broadcastadresse.setEnabled(false);

		netzmaske = (EditText) findViewById(R.id.netzwerkmaske);
		netzmaske.setEnabled(false);

		kleinsteIp = (EditText) findViewById(R.id.hostvon);
		kleinsteIp.setEnabled(false);

		groessteIp = (EditText) findViewById(R.id.hostbis);
		groessteIp.setEnabled(false);

		moeglicheHost = (EditText) findViewById(R.id.hosts);
		moeglicheHost.setEnabled(false);

		// implementierung der Klasse MaxLengthWatcher um maximale
		// caracteranzahl in den EditTextfeldern der ipadresse festzulegen
		// TextchangedListener wird benötigt um nach Änderung im EditText
		// Methode berechnen() sofort aufzurufen
		ip1 = (EditText) findViewById(R.id.ip_adresse1);
		ip1.setText("192");
		ip1.addTextChangedListener(new MaxLengthWatcher(3, ip1));
		ip1.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				berechnen();

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		ip2 = (EditText) findViewById(R.id.ip_adresse2);
		ip2.setText("168");
		ip2.addTextChangedListener(new MaxLengthWatcher(3, ip2));
		ip2.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				berechnen();

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});

		ip3 = (EditText) findViewById(R.id.ip_adresse3);
		ip3.setText("132");
		ip3.addTextChangedListener(new MaxLengthWatcher(3, ip3));
		ip3.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				berechnen();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});

		ip4 = (EditText) findViewById(R.id.ip_adresse4);
		ip4.setText("1");
		ip4.addTextChangedListener(new MaxLengthWatcher(3, ip4));
		ip4.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				berechnen();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});

		// / Möglichkeit Methode zu rufen wenn man EditTextfeld verlässt (
		// onFocus )
		// ip4.setOnFocusChangeListener(new OnFocusChangeListener() {
		//
		// public void onFocusChange(View v, boolean hasFocus) {
		// if (!hasFocus)
		// berechnen();
		// }
		// });

		// ______________________________________________________________________________

		// adapter um dem Spinner die Elemente aus dem Array Cidr zuzuordnen

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, Cidr);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter);
		// hier selektieren wir eine Defaultitemposition ( cidr )
		spinner1.setSelection(24 - 1);
		spinner1.setOnItemSelectedListener(this);

		// button um die Methode clear() aufzurufen
		// darunter der OnClicklistener
		clear = (Button) findViewById(R.id.clear);
		clear.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				clear();
			}
		});

	}

	// Methode clear() alle Textfelder sollen leergemacht werden
	// indem wir Leerstrings reinschreiben
	public void clear() {

		ip1.setText("192");
		ip2.setText("168");
		ip3.setText("132");
		ip4.setText("1");

		// netzwerkadresse = (EditText) findViewById(R.id.netzwerk);
		// netzwerkadresse.setText("");
		//
		// broadcastadresse = (EditText) findViewById(R.id.broadcast);
		// broadcastadresse.setText("");
		//
		// kleinsteIp = (EditText) findViewById(R.id.hostvon);
		// kleinsteIp.setText("");
		//
		// groessteIp = (EditText) findViewById(R.id.hostbis);
		// groessteIp.setText("");
		//
		// moeglicheHost = (EditText) findViewById(R.id.hosts);
		// moeglicheHost.setText("");

	}

	// Methode die alle Metoden aus der Klasse Rechner implementiert
	// und die richtigen Werte übergibt
	public void berechnen() {

		// eingegebene Werte aus den 4 Oktettfeldern der Ipadresse
		// werden in die EditTextvariablen geschrieben
		// setEnabled(true) bedeutet dass man in die Felder reinschreiben kann
		ip1 = (EditText) findViewById(R.id.ip_adresse1);
		ip1.setEnabled(true);

		ip2 = (EditText) findViewById(R.id.ip_adresse2);
		ip2.setEnabled(true);

		ip3 = (EditText) findViewById(R.id.ip_adresse3);
		ip3.setEnabled(true);

		ip4 = (EditText) findViewById(R.id.ip_adresse4);
		ip4.setEnabled(true);

		// toast um Fehlermeldugen ausgeben zu können
		toast1 = Toast.makeText(MainActivity.this,
				"Bitte Zahlen zwischen 0-255 in die "
						+ "letzten 3 Oktettfelder der IP_Adresse eingeben!",
				+Toast.LENGTH_SHORT);
		toast1.setGravity(Gravity.CENTER, 0, 75);

		toast2 = Toast.makeText(MainActivity.this,
				"Bitte Zahlen zwischen 1-255 in das "
						+ "1. Oktettfeld der IP_Adresse eingeben!",
				+Toast.LENGTH_SHORT);
		toast2.setGravity(Gravity.CENTER, 0, 75);

		// falls EditText der ip leer sind Fehlermeldung ausgeben
		// mit toast.show()
		if (ip1.getText().toString().length() == 0) {
			toast2.show();
			return;
		}
		if (ip2.getText().toString().length() == 0) {
			toast1.show();
			return;
		}
		if (ip3.getText().toString().length() == 0) {
			toast1.show();
			return;
		}
		if (ip4.getText().toString().length() == 0) {
			toast1.show();
			return;
		}

		// wir parsen die editTextfelder nach Integer und speichern die Werte
		// in int variablen ( ipadresse1) u.s.w
		ipadresse1 = Integer.parseInt(ip1.getText().toString());
		ipadresse2 = Integer.parseInt(ip2.getText().toString());
		ipadresse3 = Integer.parseInt(ip3.getText().toString());
		ipadresse4 = Integer.parseInt(ip4.getText().toString());

		// wenn Werte nicht zwischen 0 und 255 sind returnen und Fehlermeldung
		// mit toast
		if (!(ipadresse2 <= 255) || !(ipadresse2 >= 0) || !(ipadresse3 <= 255)
				|| !(ipadresse3 >= 0) || !(ipadresse4 <= 255)
				|| !(ipadresse4 >= 0)) {

			toast1.show();

			return;

			// wenn ipadresse1 (oktett1) 1 kleiner ist als 1 dann
			// returnen und Fehlermeldung
		} else if (!(ipadresse1 <= 255) || !(ipadresse1 >= 1)
				|| !(ipadresse2 <= 255) || !(ipadresse2 >= 0)
				|| !(ipadresse3 <= 255) || !(ipadresse3 >= 0)
				|| !(ipadresse4 <= 255) || !(ipadresse4 >= 0)) {
			toast2.show();
			return;

		} else {
			// ansonsten Objekt der Klasse Rechner bauen und Metoden aufrufen
			// holeNetzmasken(), bestimmeMoeglicheHosts
			// die zurückgegebenen Werte in die entsprechenden Variablen
			// speichern
			// und anschliessend die Ergebnisse mit setText in die
			// edittextfelder
			// auf der View setzen

			Rechner r = new Rechner(this.ipadresse1, this.ipadresse2,
					this.ipadresse3, this.ipadresse4);
			r.holeNetzmasken(this.itemCidre);
			r.bestimmeMoeglicheHosts(this.itemCidre);

			String netzadresse = r.berechneNetzadresse();
			netzwerkadresse = (EditText) findViewById(R.id.netzwerk);
			netzwerkadresse.setText(String.valueOf(netzadresse));

			String broadcast = r.berechneBroadcast();
			broadcastadresse = (EditText) findViewById(R.id.broadcast);
			broadcastadresse.setText(String.valueOf(broadcast));

			String kleinIp = r.berechneKleinsteIp();
			kleinsteIp = (EditText) findViewById(R.id.hostvon);
			kleinsteIp.setText(String.valueOf(kleinIp));

			String grossIp = r.berechneGroessteIp();
			groessteIp = (EditText) findViewById(R.id.hostbis);
			groessteIp.setText(String.valueOf(grossIp));

			int hosts = r.getMoeglicheHosts();
			moeglicheHost = (EditText) findViewById(R.id.hosts);
			moeglicheHost.setText(String.valueOf(hosts));

		}
	}

	// Methode um selektiertes item zu ermitteln
	// selektiertes item in die Stringvariable item geschrieben und
	// dann nach Integer geparst und in die Klassenvariable itemCidre
	// geschrieben
	// über die variable itemCidre bekommen auch die Objekte in der Methode
	// berechnen den richtigen cidrwert übermittelt
	// ausserdem wird ein Rechner objekt instanziert und dann die
	// Methode holeNetzmasken aufgerufen
	// anschliessend setzen wir den zurückgegebenen String mit den Netzmasken
	// in das entsprechende EditTextfeld netzmaske(netzwrkmaske).
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		spinner1.setSelection(position);
		String item = (String) spinner1.getSelectedItem();
		this.itemCidre = Integer.parseInt(item);

		Rechner rechner = new Rechner(this.ipadresse1, this.ipadresse2,
				this.ipadresse3, this.ipadresse4);

		String submask = rechner.holeNetzmasken(this.itemCidre);
		netzmaske.setText(String.valueOf(submask));
		netzmaske.setEnabled(false);

		berechnen();

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

}