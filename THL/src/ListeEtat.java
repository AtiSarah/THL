import java.util.Scanner;
public class ListeEtat {
     Etat[] etat;
     int n;
    public ListeEtat() {
    	Scanner scan = new Scanner(System.in);
        System.out.println("\nVeuillez saisir le nombre d'états :");
        n = scan.nextInt();
    	this.etat = new Etat[n]; 
    	for(int i=0;i<n;i++) {etat[i] =new Etat(-1); }
    	fillEtat();
    	}
    void fillEtat() {
        Scanner scan = new Scanner(System.in);
        int m=0;
        for (int i = 0; i < n; i++) {
            this.etat[i].etat =i ;
            System.out.println("l'etat q"+this.etat[i].etat+": ");
            if (m == 0) {
                System.out.println("Est-ce un état initial ? (oui/non) :");
                if (scan.next().equalsIgnoreCase("oui")) {
                    this.etat[i].initial(); m++;
                }
            }

            System.out.println("Est-ce un état final ? (oui/non) :");
            if (scan.next().equalsIgnoreCase("oui")) {
                this.etat[i].finale();
            }
        }
        
    }
    
   
    void affichage() {
    	
    	for(int i=0;i<etat.length;i++) {
    		System.out.print(" "+etat[i].etat+" "+etat[i].init+" "+etat[i].finale);
    	}
    }
}

