package Puissance4;

import java.util.Scanner;

public class Puissance4 {
	Scanner scanner 	= new Scanner(System.in);
	String 	tableau[][] = new String[7][7];
	String 	player1 ; 
	String 	player2 ; 
	String 	casePlayedJ1 = "X" ; 
	String 	casePlayedJ2 = "O" ; 
	String 	casePoint = ".";
	int 	result;
	int 	completedBoard = 0;
	String newGame;
	
	
	public Puissance4() {
		this("Joueur 1","Joueur 2");
	}
	
	public Puissance4(String name1, String name2) {
		this.player1 = name1 ;
		this.player2 = name2 ;
	}
	

	public void enterName() {
		// on initialise answerName à une valeur "autre" pour entrer dans la boucle while.
		String answerName = "a";
		// la boucle while permet de gérer l'erreur de l'utilisateur en cas de frappe non attendue
		System.out.println("Renseigner des noms de joueurs? Oui(Y) Non(N)");
		
		while(!answerName.equals("N") && !answerName.equals("n")
				&& !answerName.isEmpty() && !answerName.equals("Y") 
				&& !answerName.equals("y")) {

			answerName = scanner.nextLine();
			
			if(!answerName.equals("N") && !answerName.equals("n")
			&& !answerName.isEmpty() && !answerName.equals("Y") 
			&& !answerName.equals("y")){
		
				System.out.println("Veuillez taper sur Y, N ou Entrée!");
			}
			
		}
		if(answerName.equals("Y") || answerName.equals("y")){
			System.out.println("Saisissez prénom Joueur 1? Ou tapez Entrer");
			player1 = scanner.next();
	
			System.out.println("Joueur 2? Ou tapez Entrer");
			player2 = scanner.next();
		}
	}

	public void afficherPlateau(String tableau[][]) {
		// Ici, on gère l'affichage console si celui ci n'est pas vide
		for(int i = 0 ; i<tableau.length ; i++) {			
			for(int index = 0 ; index<tableau[i].length ; index++) {
				// Si une case est vide on la remplace par un point (initialisation début de partie)
				if(tableau[i][index] == null) {
					tableau[i][index] = casePoint;
				}
				// la dernière ligne comportera les N° de colonnes
				if(i == tableau.length-1) {
					tableau[i][index]= Integer.toString(index + 1);
				}
			}
			// Affichage du tableau dans la console
			String joinArray = String.join(" | ",tableau[i]);
			System.out.println(" | " + joinArray + " | ");
		}
		
	}

	public void insertionJeton(String tableau[][], int colonne, String casePlayed) {

		for(int i = 0 ; i < tableau.length ; i++) {
			// si la case ciblée a déja une case "jouée" et si la case au dessus est vide
			if (tableau[i][colonne -1] != casePoint 
				&& tableau[i-1][colonne -1] == casePoint) {	
			// Alors on joue la case au dessus : "jeu.tableau[i-1]"
				tableau[i-1][colonne -1] = casePlayed;					
			}														
		}

		// Et si toutes les cases de la ligne jouée sont "vides"(avec un point)
		if(tableau[tableau.length -1][colonne -1] == casePoint) {	
			// Alors la case "jouée" est celle du bas : 
			tableau[tableau.length-1][colonne-1] = casePlayed;		
		}
		
	}

	public int verifAlignement(int colonne, String casePlayed) {
		
		// Dans cette boucle, on va tester si plusieurs elements sont alignés.
		for(int i = 0 ; i < tableau.length ; i++) {		
			//Si l'index est plus grand que la longueur du tableau -3
			//Alors on sort du tableau donc on n'effectue pas cette partie du code.
			if(i < tableau.length-3){ 
				
				// On teste la verticale
				if(tableau[i][colonne-1]   == casePlayed 
				&& tableau[i+1][colonne-1] == casePlayed 
				&& tableau[i+2][colonne-1] == casePlayed 
				&& tableau[i+3][colonne-1] == casePlayed) {
					
					result += 1;
				}
			}
	
			// On teste l'horizontale
			for(int index = 0 ; index < tableau.length-3 ; index++) {
				if(index < tableau[i].length-3){ 
					if(tableau[i][index] 	== casePlayed 
					&& tableau[i][index +1] == casePlayed 
					&& tableau[i][index +2] == casePlayed 
					&& tableau[i][index +3] == casePlayed) {
						
						result += 1;
					}
				}
				
				// on teste la diagonale de gauche à droite et de haut en bas 
				if(i < tableau.length-3 && index < tableau[i].length-3){
					if(tableau[i][index] 	 == casePlayed 
					&& tableau[i+1][index+1] == casePlayed 
					&& tableau[i+2][index+2] == casePlayed 
					&& tableau[i+3][index+3] == casePlayed) {
						result += 1;
					}
				}
				
				// on teste la diagonale de gauche à droite et de bas en haut 
				if(i-3 > 0 && index < tableau[i].length-3){
					if(tableau[i][index] == casePlayed 
					&& tableau[i-1][index+1] == casePlayed 
					&& tableau[i-2][index+2] == casePlayed 
					&& tableau[i-3][index+3] == casePlayed) {
						
						result += 1;
					}
				}

			}
		}
		
		// Ici on vérifie le cas du match nul on parcourt la premiere ligne 
		// et on vérifie si toutes les cases sont remplies.
		for( int i=0 ; i< tableau[0].length ; i++) {
			if(tableau[0][i] != casePoint) {
				completedBoard ++;
				if (completedBoard == tableau[0].length) {
					result = -1;
				}	
			}
		}
		completedBoard = 0;
		
		return result; 
		
	}
	
	
	public String[] result(String player, String casePlayed) {

		
		if(result > 0) {
			afficherPlateau(tableau);
			System.out.println("Bravo " + player + ", c'est gagné");
		}else if(result < 0) {
			afficherPlateau(tableau);
			System.out.println("Match Nul");
		}else if(player ==  player1 ) {
			player 		= player2;
			casePlayed 	= casePlayedJ2;
		}else {
			player 		= player1;
			casePlayed 	= casePlayedJ1;
		}
		
		return new String[] {player , casePlayed};
		
	}
	
	public void restart() {
		// on initialise newGame à une valeur "autre" pour entrer dans la boucle while.
		newGame = "a";
		// la boucle while permet de gérer l'erreur de l'utilisateur en cas de frappe non attendue
		while(!newGame.equals("N") && !newGame.equals("n")
				&& !newGame.equals("Y") && !newGame.equals("y")) {
			
			System.out.println("Souhaitez- vous rejouer une partie ? Oui(Y) Non(N)");
			newGame = scanner.next();
			
			if(!newGame.equals("N") && !newGame.equals("n")
			&& !newGame.equals("Y") && !newGame.equals("y")){
		
				System.out.println("Veuillez taper sur Y, N ou Entrée!");
			}
		}
		
		if(newGame.equals("N") || newGame.equals("n")){
			System.out.println("Pas de nouvelle partie, à bientot");
		}else if (newGame.equals("Y") || newGame.equals("y")){
			result = 0;
			tableau = new String[tableau.length][tableau[0].length];
		}
	}
	
}
