package com.poo.javagestoreeventi;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Evento {
	
	String titolo;
	int postiTotali, postiPrenotati;
	LocalDate data;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ITALY);
	
	
	public Evento(String titolo, int postiTotali,LocalDate data) {
		super();
		this.titolo = titolo;
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
		this.data = data;
	}
	
	public int prenota() throws Exception {
		
		
			if(data.isBefore(LocalDate.now()) && postiTotali > postiPrenotati) {
				postiPrenotati++;
				System.out.println("Evento prenotato con sucesso!");
			}else {
				
				throw new Exception("Data errata o posti non disponibili");
			}
			
		
		return postiPrenotati;
	}
	
	public int disdici() throws Exception{
		
		if(data.isBefore(LocalDate.now()) && postiPrenotati > 0) {
			postiPrenotati--;
			System.out.println("Evento prenotato con sucesso!");
			
		}else {
			
			throw new Exception("Non si può disdire ad una prenotazione già passata");
		}
			
		return postiPrenotati;
	}
	

	@Override
	public String toString() {
		return "\nTitolo: " + titolo 
				+ "\nPosti Totali: " + postiTotali
				+ "\nPosti Prenotati: " + postiPrenotati
				+ "\nData: " + data.format(dtf);
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getPostiTotali() {
		return postiTotali;
	}


	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
