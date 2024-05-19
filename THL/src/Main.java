import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		
		// Input number of states and states
		  
	        System.out.println("_________________________________________________________________________________________________________________________________________________________________________________________________");
	        ListeEtat etat = new ListeEtat();
	        etat.affichage();
	        System.out.println("\n____________________________________________________________________________________________________________________________________________________________________________________________");
	     // Input Alphabet   
		Alphabet A = new Alphabet();
        String S = A.inputAlphabet();
        A = new Alphabet(S);
        A.affichage();
        System.out.println("\n_____________________________________________________________________________________________________________________________________________________________________________________________________");
        
        // Input transitions
        System.out.println();
        Transition T= new Transition(A, etat);
        System.out.println("\n_____________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("AUTOMATE:\n");
        T.affichage(A);
        // Verify if a word is part of the language
        boolean verify=true;
        while(verify) {
        	System.out.println("\n_____________________________________________________________________________________________________________________________________________________________________________________________________");
        Mot mot=new Mot(A);
        mot.verifie(T);
        System.out.println("Voulez-vous vérifier si un autre mot appartient à ce langage ? (oui/non)");
        String v=scan.next();
        if(! v.equals("oui")) verify=false; }
        System.out.println("\nFin.\n");
       

	}

}
