package personnages;

public class Humain {
	private String nom;
	private int argent;
	private String boisson_favorite;
	protected int nbConnaissance= 0;
	private int MEMOIRE_MAX = 3;
	protected Humain[] memoire  = new Humain[MEMOIRE_MAX];
	
	public Humain(String nom, String boisson_favorite, int argent) {
		this.nom = nom;
		this.boisson_favorite = boisson_favorite;
		this.argent = argent;
	}
	protected void parler(String texte) {
		System.out.println(("(" +nom + ")-" + texte ));
	}
	
	public String getNom() {
		return nom;
	}
	public int getArgent() {
		return argent;
	}
	
	public void direBonjour() {
		parler("Bonjour je m'appelle "+ nom +" et j'aime boire du " + boisson_favorite);
	}
	

	public void boire() {
		parler("Mmmm, un bon verre de " + boisson_favorite + "! GLOUPS !");
	}
	
	protected void gagnerArgent(int gain) {
		argent += gain;
	}
	
	protected void perdreArgent(int perte) {
		argent -= perte;
	}
	
	public void acheter(String bien, int prix) {
		if(argent >= prix) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
			perdreArgent(prix);
		}
		else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous." );
		}
	}
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	private void memoriser(Humain humain) {
		if(nbConnaissance < MEMOIRE_MAX) {
			memoire[nbConnaissance] = humain;
			nbConnaissance++;
		}
		else {
			for(int i = 0; i < MEMOIRE_MAX-1; i++) {
				memoire[i] = memoire[i+1];
			}
			memoire[MEMOIRE_MAX-1] = humain;
		}
	}
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
		
	}
	
	public void listerConnaissance() {
		String texte = "Je connais beaucoup de monde dont : ";
	
		for (int i = 0; i < nbConnaissance; i++) {
			texte += memoire[i].getNom();
			if(i< nbConnaissance-1) {
				texte +=", ";
			}
		}
		parler(texte);
	}
	
}
