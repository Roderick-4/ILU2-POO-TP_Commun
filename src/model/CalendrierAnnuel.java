package model;

public class CalendrierAnnuel {
	private Mois [] calendrier;
	
	public CalendrierAnnuel() {
		calendrier = new Mois[12];
		int[] nbJour = {31,28,31,30,31,30,31,31,30,31,30,31};
		String[]nomMois = {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juiller","Aout","Septembre","Octobre","Novembre","Decembre"};
		for(int i=0;i<12;i++) {
			calendrier[i] = new Mois(nomMois[i],nbJour[i]);
		}
	}
	
	public boolean estLibre(int jour, int mois) {
		return calendrier[mois-1].estLibre(jour-1);
	}
	
	public boolean reserver(int jour, int mois) {
		try {
			calendrier[mois-1].reserver(jour-1);
		} catch (IllegalStateException e) {
			return false;
		}
		return true;
	}
	
	private static class Mois {
		private String nom;
		private boolean [] jours;
		
		private Mois (String nom, int nbJours) {
			this.nom = nom;
			jours = new boolean[nbJours];
			for(int i=0; i<nbJours;i++) {
				jours[i] = false;
			}
		}
		
		private boolean estLibre(int jour) {
			return !jours[jour];
		}
		
		private void reserver(int jour) {
			if (!estLibre(jour)) {
				throw new IllegalStateException();
			} else {
				jours[jour] = true;
			}
		}
	}

}
