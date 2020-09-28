/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package edu.uha.miage;

/**
 * �crire une classe capable de donner les premiers nombres premiers.
 *
 * L'objectif de cet exercice est de montrer l'int�r�t des blocs
 * d�initialisation statique.
 *
 * @author yvan
 */
public class Premier {

    // L'attribut EST_PREMIER est un tableau de booleens
    private static final boolean[] EST_PREMIER = new boolean[Short.MAX_VALUE];

    /* 
    EST_PREMIER sera utilis� pour savoir si un nombre est premier. Le bool�en � l�indice p dans
     est_premier est vrai si et seulement si p est premier. Par exemple est_premier[12] devra �tre false
     alors que est_premier[97] devra �tre true.
    */
    // 
    // Voici un morceau de code pour remplir EST_PREMIER selon Eratosth�ne
    /*for (int i = 2; i < EST_PREMIER.length; ++i) {
            EST_PREMIER[i] = true;
    }
    int i = 2;
    while (i * i < EST_PREMIER.length) {
        for (int j = i * i; j < EST_PREMIER.length; j += i) {
            EST_PREMIER[j] = false;
        }
        i++;
    }*/
    // TODO 1.01 � vous de trouver o� placer le morceau de code pr�c�dent (ailleurs que dans un constructeur)
    static {
	    for (int i = 2; i < EST_PREMIER.length; ++i) {
	            EST_PREMIER[i] = true;
	    }
	    int i = 2;
	    while (i * i < EST_PREMIER.length) {
	        for (int j = i * i; j < EST_PREMIER.length; j += i) {
	            EST_PREMIER[j] = false;
	        }
	        i++;
    }
    // 
    // L'attribut PREMIER est un tableau de short.
    /*
    Il est cens� contenir les premiers nombres premiers inf�rieurs � Short.MAX_VALUE
    */
    private static final short[] PREMIER = { 2, 3, 5, 7 };

    /* 
    J'ai commenc� � remplir le tableau PREMIER � la main, mais je me suis arr�t� � 7. 
    Il y a trop de valeurs en v�rit�.
    */
    // TODO 1.02 � vous de trouver une autre solution pour remplir autrement PREMIER.
    // 
    public Premier() {
    	for(int i=7; i<EST_PREMIER.length; ++i) {
    		if(EST_PREMIER[i]) ;
    	}
    }
    // 
    public static boolean estPremier(short p) {
        if (p < 0) {
            return false;
        }
        return EST_PREMIER[p];
    }

    public static int premier(short p) {
        return PREMIER[p];
    }

    public static int nbPremiers() {
        return PREMIER.length;
    }
}
