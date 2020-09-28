/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package edu.uha.miage;

/**
 * �crire une classe AutoCompteur dont l�instance affiche � sa construction le
 * nombre d�instances de AutoCompteur cr��es.
 *
 * Chaque instance de cette classe doit �tre identifi�e par le num�ro d'ordre
 * de sa cr�ation. L'identifiant de la premi�re cr��e est 1, la deuxi�me est 2,
 * la ni�me est n.
 *
 * Cette classe devra poss�der deux m�thodes :
 *
 *   1. getNbInstances() qui donne le nombre d'instances de cette classe d�j� cr��es.
 *   2. getId() qui donne l'identifiant de l'instance sur laquelle elle s'applique.
 *
 * @author yvan
 */
public class AutoCompteur {
    // TODO 1. D�clarer le ou les attributs n�cessaires.
	private static int nb_instances;
	private int id;
    /* TODO 2.
		�crire un constructeur par d�faut de sorte qu'il affiche le nombre 
		d'instances de AutoCompteur cr��es � chaque nouvelle instance 
		de AutoCompteur cr��e
	*/
	public AutoCompteur()
	{
		nb_instances++;
		System.out.print("Il y a "+nb_instances+" instances");
		id=nb_instances;
	}
    /* TODO 3.
		�crire une m�thode getNbInstances() avec 
		une signature et des modificateurs adapt�s
		afin qu'elle retourne le nombre d'instances de AutoCompteur d�j� cr��e
	*/
    public static int getNbInstances()
    {
    	return nb_instances;
    }
    /* TODO 4.
		�crire une m�thode getId() avec 
		une signature et des modificateurs adapt�s
		afin qu'elle retourne l'identifiant de cette instance
	*/
    public int getId()
    {
    	return id;
    }
}
