package ListesDesFormesGeometrique_ArrayList;

import java.io.IOException;
import java.util.ArrayList;

public class ListesDesForme {
	
	private ArrayList<Formes> listesFormes;
	
	// le constructeur par defaut
	public ListesDesForme() {
		listesFormes = new ArrayList<Formes>();
	}
	
	
	// la methode ajouter des formes geometriques
	public void ajouterUneFormes(char type) {
		if(type =='C') {
			listesFormes.add(new Cercle());
		}else if(type =='T') {
			listesFormes.add(new Triangle());
		}else {
			if(type =='R') {
				listesFormes.add(new Rectangle());
			} else if(type =='K') {
				listesFormes.add(new Carre());
			}else {
				if(type =='E') {
					//listesFormes.add(new Elipse());
				} else if(type =='F') {
					//listesFormes.add(new CourbeDuneFonctionUsuelle());
				}else {
					if(type =='B') {
						//listesFormes.add(new CourbeTrigonometrique());
					}else if(type =='S') {
						//listesFormes.add(new CourbeStatistique());
					}else {
						if(type =='D') {
							//listesFormes.add(new Diagramme());
						}else if(type =='P') {
							//listesFormes.add(new Poligonne());
						}else {
							if(type =='Z') {
								//listesFormes.add(new Trapeze());
							}else if(type =='L') {
								//listesFormes.add(new Cylindre());
							}else {
								if(type =='Q') {
									//listesFormes.add(new Quelconque());
								}
							}
						}
					}
				}
			}
		} 
	}
	
  // la methode afficher les formes
	public void afficherLesFormes() {
		int nbFormes = listesFormes.size();
		if(nbFormes > 0) {
			for(Formes tmp : listesFormes) {
				tmp.afficher();
			}
		}else {
			System.out.println(" Il n'y a pas de formes dans cette listes ");
		}
	}
	
  // la methode enrigistrer les formes
	public void enrigistrerLesFormes(Fichier fich) throws IOException{
		int nbFormes = listesFormes.size();
		if(nbFormes > 0) {
			String chaine = "";
			for(Formes tmp : listesFormes) {
				tmp.afficher();
				chaine = tmp.getInfo();
				if(chaine != null) {
					fich.ecrire(chaine);
				}
			}
		}else {
			System.out.println(" Il n'y a rien dans la liste pour enregistrer ");
		}
	}
	
  // la methode de lecture (lire le fichier des listes des formes )
	public void lireListeFormes(Fichier fich) throws IOException {
		String chaine;
		String [] mots = {"","","","","","","","","","","",""};
		char tt;
		int cc, xx0, yy0, xx1, yy1, xx2, yy2, xx3, yy3, ll, hh, rr;
		do {
			mots = fich.lire();
			//System.out.println(mots+"\n\n");
			if(mots != null) {
				tt = mots[0].charAt(0);
				//System.out.println(tt+"\n\n");
				if(tt == 'C') {
					cc = Integer.parseInt(mots[1]);
					xx0 = Integer.parseInt(mots[2]);
					yy0 = Integer.parseInt(mots[3]);
					rr = Integer.parseInt(mots[4]);
					listesFormes.add(new Cercle(xx0, yy0, rr, rr));
				}else if(tt == 'T') {
					
					cc = Integer.parseInt(mots[1]);
					xx0 = Integer.parseInt(mots[2]);
					yy0 = Integer.parseInt(mots[3]);
					xx1 = Integer.parseInt(mots[4]);
					yy1 = Integer.parseInt(mots[5]);
					xx2 = Integer.parseInt(mots[6]);
					yy2 = Integer.parseInt(mots[7]);
					//System.out.println(cc+", "+xx0+", "+yy0+", "+xx1+", "+yy1+", "+xx2+", "+yy2);
					listesFormes.add(new Triangle(xx0, yy0, xx1, yy1, xx2, yy2, cc));
				}else if(tt == 'R') {
					cc = Integer.parseInt(mots[1]);
					xx0 = Integer.parseInt(mots[2]);
					yy0 = Integer.parseInt(mots[3]);
					xx1 = Integer.parseInt(mots[4]);
					yy1 = Integer.parseInt(mots[5]);
					xx2 = Integer.parseInt(mots[6]);
					yy2 = Integer.parseInt(mots[7]);
					xx3 = Integer.parseInt(mots[8]);
					yy3 = Integer.parseInt(mots[9]);
					ll = Integer.parseInt(mots[10]);
					hh = Integer.parseInt(mots[11]);
					listesFormes.add(new Rectangle(xx0, yy0, xx1, yy1, xx2, yy2, xx3, yy3, ll, hh, cc));
				}else if(tt == 'K') {
					cc = Integer.parseInt(mots[1]);
					xx0 = Integer.parseInt(mots[2]);
					yy0 = Integer.parseInt(mots[3]);
					xx1 = Integer.parseInt(mots[4]);
					yy1 = Integer.parseInt(mots[5]);
					xx2 = Integer.parseInt(mots[6]);
					yy2 = Integer.parseInt(mots[7]);
					xx3 = Integer.parseInt(mots[8]);
					yy3 = Integer.parseInt(mots[9]);
					ll = Integer.parseInt(mots[10]);
					hh = Integer.parseInt(mots[11]);
					listesFormes.add(new Carre(xx0, yy0, xx1, yy1, xx2, yy2, xx3, yy3, ll, hh, cc));
				}
			}
		}while(mots != null);
	}
}
