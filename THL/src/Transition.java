import java.util.Scanner;

public class Transition {
 Etat[][] Automate;
 int n,m,etatInit=-1;
 
 public Transition(Alphabet A, ListeEtat etatMat) {
     Scanner scan = new Scanner(System.in);
     this.n = etatMat.etat.length;
     this.m = A.A.length;
     this.Automate = new Etat[n][m];
     
     for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
        	 System.out.println("y'a t-il une transition de q" + i + " avec la lettre " + A.A[j] + "? (oui/non)");
        	 String trans = scan.next();
        	 if(trans.equals("oui")) {
             System.out.println("Donnez l'indice de la transition de q" + i + " avec la lettre " + A.A[j] + ":");
             int e = scan.nextInt();
             
             if (e >= 0 && e < n) {
                 this.Automate[i][j] = new Etat(e);
                 this.Automate[i][j].etat = e;
                 this.Automate[i][j].init = etatMat.etat[e].init;
                 
                 if(etatMat.etat[e].init) this.etatInit=etatMat.etat[e].etat; 
                 
                 this.Automate[i][j].finale = etatMat.etat[e].finale;
             } else {
                 System.out.println("Indice de transition invalide.");
                 j--; 
             }}
        	 else {
        		 this.Automate[i][j] = new Etat(0);
        		 this.Automate[i][j] = null;
        	 }
         }
     }System.out.println("etatinit: "+etatInit);
     
	 }

 public void affichage(Alphabet A) {
	    A.affichage();  
	    System.out.println();

	    for (int i = 0; i < n; i++){
	        System.out.print("q" + i + "|");
	        for (int j = 0; j < m; j++) {
	            if (this.Automate[i][j] != null) {
	                System.out.print("\tq" + this.Automate[i][j].etat);
	            } else {
	                System.out.print("\tNULL");
	            }
	        }
	        System.out.println();
	    }
	}

	}