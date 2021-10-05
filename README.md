# Puissance4
Puissance 4 en JAVA

## Description du jeu

#### Une plateau de jeu avec 42 emplacements
21 jetons X

21 jetons O

2 joueurs
#### Règles du jeu
Le joueur qui commence met un jeton dans la colonne de son choix. Le jeton tombe au bas de la colonne.

Son adversaire insère à son tour un jeton.

Le but étant d'arriver à former une rangée de 4 jetons identiques à l'horizontale, à la verticale ou en diagonale tout en empêchant l'adversaire de faire de même.

Le joueur qui arrive à aligner 4 pions est le gagnant. La partie est nulle si aucun des deux n’y est arrivé et que la grille est remplie.

## Description de l'implémentation du jeu

#### 1 Gestion du prénom des joueurs.

Question pour savoir si les joueurs veulent renseigner leurs prénoms. Gestion des erreurs sur réponse.

Si oui  : insertion prénoms, Si non : Prénoms prédéfinis "Joueur 1" et "Joueur 2"

#### 2 Affichage plateau

A l'initiation du jeu, affichage du plateau avec remplissage des cases avec un point = tableau vide.

Sinon affichage du plateau stocké dans variable.


#### 3 Insertion des jetons

Récupération de la colonne indiquée par le joueur en écartant les chiffres/nombres plus petits que 1 et plus grand que 7 ( le nombre de colonnes jouables).

Et stockage dans le tableau de tableau.

#### 4 Vérification de l'alignement des jetons

On teste 5 possibilités : les 4 jetons alignés 
1. horizontalement , 
2. verticalement, 
3. en diagonale partant de gauche a droite en direction du haut,
4. en diagonale partant de gauche a droite et en direction du bas,
5. le cas du plateau rempli : le match nul.

#### 5 Gestion du résultat

En fonction du test de vérification du résultat précédemment effectué,

on gère ici l'affichage du résultat ou le changement du prénom et de la case du prochain joueur qui joue.

#### 6 Recommencer une partie

En cas d'une fin de partie on demande si les joueurs veulent rejouer une partie.

## Notice d'utilisation

- Les joueurs souhaitent renseigner ou non leurs prénoms pour jouer au jeu. 

    Si oui, taper Y ou y et taper sur Entrée. 
    
    Si non taper sur N ou n puis taper sur Entrée ou taper directement sur Entrée.
    
- Le premier joueur peut commencer à jouer et entre un chiffre entre 1 et 7 correspondant à la colonne dans laquelle il souahaite insérer son jeton X .
- Après le premier joueur, le deuxième joueur en fait de même avec son jeton O.

    Et ainsi de suite jusqu'à ce qu'un joueur aligne 4 jetons horizontalement, verticalement ou en diagonale.

- A la fin du jeu, après qu'un joueur ait gagné ou dans le cas d'un match nul, les joueurs renseignent leur souhait de poursuivre la partie ou non.

    Taper Y ou y puis sur Entrée pour recommencer une partie 

    Taper N ou n puis taper sur Entrée ou taper directement sur Entrée pour refuser la nouvelle partie.
    
   ## Exemples d'utilisation
   
   Renseigner ou non le prénom des joueurs:

 	![Intro Noms des joueurs](https://github.com/thomascardon35/puissance4/blob/main/img/introNomsJoueurs.jpg) 
    
    Sans Prénoms:
    
 	![Intro Noms des joueurs](https://github.com/thomascardon35/puissance4/blob/main/img/introPasDeNomsJoueurs.jpg) 
    
    Erreur Réponse Prénoms des joueurs:
    
 	![Intro Noms des joueurs](https://github.com/thomascardon35/puissance4/blob/main/img/erreurR%C3%A9ponsePr%C3%A9nom.jpg) 
    
    Erreur de la colonne renseignée :
    
 	![Intro Noms des joueurs](https://github.com/thomascardon35/puissance4/blob/main/img/gestionErreurColonne.jpg) 
    
    Gain du jeu : alignement des jetons :
    
    Diagonale :
    
 	![Intro Noms des joueurs](https://github.com/thomascardon35/puissance4/blob/main/img/gainJeuDiagonale1.jpg) 
    Diagonale : 
    
 	![Intro Noms des joueurs](https://github.com/thomascardon35/puissance4/blob/main/img/gainJeuDiagonale2.jpg) 
    
    Horizontale :
    
 	![Intro Noms des joueurs](https://github.com/thomascardon35/puissance4/blob/main/img/gainJeuHorizontale.jpg) 
    Verticale :
    
 	![Intro Noms des joueurs](https://github.com/thomascardon35/puissance4/blob/main/img/gainJeuVerticale.jpg) 
    
    Le cas du Match nul : 
    
 	![Intro Noms des joueurs](https://github.com/thomascardon35/puissance4/blob/main/img/matchNul.jpg) 
    
    Acceptation d'une nouvelle partie : 
    
 	![Intro Noms des joueurs](https://github.com/thomascardon35/puissance4/blob/main/img/nouvellePartieOui.jpg) 
    
    Refus d'une nouvelle partie : 
    
 	![Intro Noms des joueurs](https://github.com/thomascardon35/puissance4/blob/main/img/nouvellePartieOui.jpg) 
    
    Erreur dans la réponse renseignée à la question sur la nouvelle partie : 
    
 	![Intro Noms des joueurs](https://github.com/thomascardon35/puissance4/blob/main/img/nouvellePartieOui.jpg) 
