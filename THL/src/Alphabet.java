
import java.util.Scanner;

public class Alphabet {
    String[] A;

    public Alphabet() {
    }

    public Alphabet(String A) {
        this.A = A.split("\\s+");
    }

    String inputAlphabet() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nInsérer l'alphabet avec un espace entre chaque lettre.");
        String s = scan.nextLine();
        return s;
    }

    void affichage() {
        System.out.print("\t");
        for (int i = 0; i < this.A.length; i++) {
            System.out.print(this.A[i] + "\t");
        }
    }
}

