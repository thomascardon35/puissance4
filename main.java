package Puissance4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner 	scanner 	= new Scanner(System.in);
		Puissance4 	jeu 		= new Puissance4() ;
		String 		casePlayed	= jeu.casePlayedJ1;
		int 		result 		= 0;
		
		jeu.enterName();
		String player = jeu.player1;
		jeu.newGame	= "y";
		String newGame = jeu.newGame;
		
		while(newGame.equals("y") || newGame.equals("Y")) {
			while(result == 0) {
				
				jeu.afficherPlateau(jeu.tableau);
				
				System.out.println(player + ", Saisissez la colonne");
				int colonne = scanner.nextInt();
				
				if(colonne < 1 || colonne > 7) {  
					System.out.println(" \u26A0 le chiffre doit être compris entre 1 et 7 \u26A0");
				}else {
					jeu.insertionJeton(jeu.tableau,colonne,casePlayed);
	

					result = jeu.verifAlignement(colonne, casePlayed);

					String [] playerTab = jeu.result(player, casePlayed);
					player 		= playerTab[0];
					casePlayed 	= playerTab[1];

				}	

				if(result !=0) {
					jeu.restart();
					result = jeu.result;
					newGame = jeu.newGame;
				}
			}
		}
		scanner.close();
	}
}
