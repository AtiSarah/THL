import java.util.Scanner;

public class Mot {
 String[] mot; Integer[] M;
 
 public Mot(Alphabet A) {
	 Scanner scan= new Scanner(System.in);

	 System.out.println("entrer un mot avec un espace entre chaque lettre:");
	 String mot=scan.nextLine();
	 this.mot= new String[mot.length()];
	 this.mot = mot.split("\\s+");
	 
	 int n=A.A.length;
	 int m=this.mot.length;
	 this.M=new Integer[m];
	 
	 
	 for(int i=0;i<n;i++) {
		 for(int j=0;j<m;j++) {
			 if(A.A[i].equals(this.mot[j])) {
				 this.M[j]=i; 
			 }
		 } 
	 }
	 }

 
 void verifie(Transition T) {//try {
	 boolean b=true; //let's us stop right away when the word doesn't belong to the language
	 ///1st we check if the letters of the word exist in the alphabet
	 int p=this.M.length;
	 int i=0;
	 while(i<p & b) {if(this.M[i]!=null) i++; else b=false;}
	 if(i<p) {
		 b=false;
		 System.out.println("\nERREUR >> les lettres du mot ne font pas partie du langage.\n");
	 } 
	 ///2nd we must check if the word starts with the letter in etatInit
	 if(b) {
		 if(T.etatInit<0) {b=false; System.out.println("\nErreur >> pas d'etat initial dans les transitions.\n");}
		 else {
			if(T.Automate[T.etatInit][this.M[0]] == null) {
				b=false;
				System.out.println("\nBlockage >> le mot ne commence pas par l'etat initial.\n");
			}
		 }
 }
	 ///3rd we check transitions 
	 if(b) {
		 
		 int j=0; Etat etatAct = new Etat();
		 etatAct.etat=T.etatInit; 
		 while(j<M.length & etatAct!=null) {
			 etatAct=T.Automate[etatAct.etat][M[j]];
			 j++;
		 }
		 if(j==M.length) {
			 if(etatAct!=null) {
			 if(etatAct.finale) System.out.println("\nLe mot appartient au langage.\n");
			 else System.out.println("\nBlockage >> le mot se termine par un etat qui n'est pas final.\n");
		 }else System.out.println("\nBlockage >> la transition n'existe pas\n");
	 }}else System.out.println("\nBlockage >> le mot se termine par un etat qui n'est pas final.\n");
	 
 //}catch (Exception e) {
	//System.out.println(e.toString());
//}
 }
 
}
 
 
 
 
 
 
 
 
 
 
 
 
 	 
 /*void appartient(Alphabet A,Transition T) {
	 
	 ///comparing 
	 int x=M.length, n=T.n, m=T.m, i=0, j=0,k=0;
	 boolean b=true;
	 while(i<n & j<m & k<x & b) {
		 if(k!=x-1) {
		 if(M[k]==T.Automate[i][j].etat) {
			 k++;
			 i=T.Automate[i][j].etat;
			 j=M[k];
		 }
		 else b=false;
	 }
		 else {
			 if(M[k]==T.Automate[i][j].etat && T.Automate[i][j].init) System.out.println("Le mot appartient au langage");
			 else b=false;
		 }
	 }
	 if(!b || k<x) System.out.println("here we have to put the errors!!");
 }
	 */
 

