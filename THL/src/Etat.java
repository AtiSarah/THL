
public class Etat {

	int etat,etatInit;
	boolean init=false,finale=false;
	
	public Etat() {}
	public Etat(int E) {
		this.etat = E;
		this.etatInit= -1;
	}
	void initial() {
		this.init=true;
	}
	void finale() {
		this.finale=true;
	}
	
	
	}

