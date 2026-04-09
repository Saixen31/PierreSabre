package personnages;

public class Humain {
	private String nom;
	private int argent;
	private String boisson_favorite;
	
	public Humain(String nom, String boisson_favorite, int argent) {
		this.nom = nom;
		this.boisson_favorite = boisson_favorite;
		this.argent = argent;
	}
	private void parler(String texte) {
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
}
