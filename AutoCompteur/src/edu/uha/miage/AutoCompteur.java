/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package edu.uha.miage;

/**
 * Écrire une classe AutoCompteur dont l’instance affiche à sa construction le
 * nombre d’instances de AutoCompteur créées.
 *
 * Chaque instance de cette classe doit être identifiée par le numéro d'ordre
 * de sa création. L'identifiant de la première créée est 1, la deuxième est 2,
 * la nième est n.
 *
 * Cette classe devra possèder deux méthodes :
 *
 *   1. getNbInstances() qui donne le nombre d'instances de cette classe déjà créées.
 *   2. getId() qui donne l'identifiant de l'instance sur laquelle elle s'applique.
 *
 * @author yvan
 */
public class AutoCompteur {
    // TODO 1. Déclarer le ou les attributs nécessaires.
	private static int nb_instances;
	private int id;
    /* TODO 2.
		Écrire un constructeur par défaut de sorte qu'il affiche le nombre 
		d'instances de AutoCompteur créées à chaque nouvelle instance 
		de AutoCompteur créée
	*/
	public AutoCompteur()
	{
		nb_instances++;
		System.out.print("Il y a "+nb_instances+" instances");
		id=nb_instances;
	}
    /* TODO 3.
		Écrire une méthode getNbInstances() avec 
		une signature et des modificateurs adaptés
		afin qu'elle retourne le nombre d'instances de AutoCompteur déjà créée
	*/
    public static int getNbInstances()
    {
    	return nb_instances;
    }
    /* TODO 4.
		Écrire une méthode getId() avec 
		une signature et des modificateurs adaptés
		afin qu'elle retourne l'identifiant de cette instance
	*/
    public int getId()
    {
    	return id;
    }
}
