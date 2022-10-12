package com.poo.javagestoreeventi;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String titolo;
		int postiTotali = 10; int postiPrenotati;
		
		
		System.out.println("Inserimento di un evento");
		System.out.print("Titolo: ");
		titolo = sc.nextLine();
		
		Evento eventi;
		try {
			System.out.print("Anno: ");
			int anno = sc.nextInt();
			sc.nextLine();
			System.out.print("mese: ");
			int mese = sc.nextInt();
			System.out.print("Giorno: ");
			int giorno = sc.nextInt();
			
			LocalDate localDate = LocalDate.of(anno, mese, giorno);
			eventi = new Evento(titolo,postiTotali,localDate);
			
			 
			try {
				System.out.print("Quante prenotazioni si voglione fare: ");
				postiPrenotati = sc.nextInt();
				eventi.prenota(postiPrenotati);
				System.out.println("Evento prenotato con sucesso!");
				System.out.println(eventi.toString());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		} catch (Exception e1) {
			System.out.println("Data sbagliata!");
		}
	
		sc.close();
	}

}
