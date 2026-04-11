package personnages;

public class Ronin extends Humain { 

    private int honneur = 1; 

 
    public Ronin(String nom, String boissonFavorite, int argent) {
        super(nom, boissonFavorite, argent);
    }

    public void donner(Commercant beneficiaire) { 
      
        int don = getArgent() / 10; 
        
        perdreArgent(don);
        
        parler(beneficiaire.getNom() + " prend ces " + don + " sous."); 
        
        beneficiaire.recevoir(don);
    }
    
    public void provoquer(Yakuza adversaire) { 
     
        parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
        int force = 2 * honneur;  
       
        if (force >= adversaire.getReputation()) { 
            parler("Je t'ai eu petit yakusa!"); 
            int argentGagne = adversaire.perdre(); 
            gagnerArgent(argentGagne); 
            honneur++; 
        } 
        else { 
            int argentPerdu = getArgent();
            perdreArgent(argentPerdu);
            honneur--; 
            parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup."); 
            adversaire.gagner(argentPerdu); 
        }
    }
}
