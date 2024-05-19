import java.util.Scanner;

public class Determiniser {

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
        
        
        
        
        //start transitions
        
        
        
        class AutomateNonD{
        	ListeEtat[][] AutomateND; int n,m;
        	AutomateNonD(ListeEtat etatMat,Alphabet A){
        		this.n = etatMat.etat.length;
        	     this.m = A.A.length;
        	     this.AutomateND = new ListeEtat[n][m];
        	     for(int x=0;x<n;x++) {for(int y=0;y<m;y++) {this.AutomateND[x][y]=null;
        	     
        	     for(x=0;x<n;x++) {
        	    	 for(y=0;y<m;y++) {
        	    		 A.affichage(); 
        	    		 System.out.println();
        	    		 for (int i = 0; i < n; i++){
        	    			 System.out.print("q" + i + "|");
        	    			 for (int j = 0; j < m; j++) {
        	    				 if (this.AutomateND[i][j] != null) {
        	    					 System.out.print("\tq" + this.AutomateND[i][j].etat);
        	    				 } else {
        	    					 if(i==x & j==y) System.out.print("\t-");
        	    					 else System.out.print("\t");
        	    				 }
        	    			 }
        	    			 System.out.println();
        	    		 }
        	    		 System.out.println("donnez le nombre d'etats de cette transition:");
        	    		 int taille=scan.nextInt();
        	    		 for(int z=0;z<taille;z++) {
        	    			 System.out.println("entrer l'indice");
        	    			 this.AutomateND[x][y].etat[z].etat=scan.nextInt();
        	    			 System.out.println("entrer f s'il est final, sinon n");
        	    			 if(scan.next()=="f") this.AutomateND[x][y].etat[z].finale();
        	    		 }
        		
        	    	 }
        	     }
        	     
        	}
        	
        }

        AutomateNonD N = new AutomateNonD(etat, A);
        
        
        
        
        
        
        
        
        
        
        
        
	}

}}}
