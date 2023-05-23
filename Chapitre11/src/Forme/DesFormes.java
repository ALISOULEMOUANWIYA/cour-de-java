package Forme;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;


public class DesFormes {
	
	private ArrayList<lesFormes> listeFormes;
	
	
	// le constructeur par defaut
		public DesFormes() {
			listeFormes = new ArrayList<lesFormes>();
		}
	
	// la methode ajouter une forme
		public void ajouterForme(char type) {
			if(type == 'C') {
				listeFormes.add(new Cercle());
			}else if(type == 'T') {
				listeFormes.add(new Triangle());
			}else {
				if(type == 'R') {
					listeFormes.add(new Rectangle());
				}else if(type == 'K') {
					listeFormes.add(new Carre());
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
	
		public void dessinerLesFormes() {
		 	JFrame F = new JFrame("Dessiner à partir de Formes.txt");
			F.setSize(lesFormes.longueurEcran ,  lesFormes.largeurEcran);
			DessinFormes page = new DessinFormes(new ArrayList<lesFormes>());
			F.setBounds(10, 10, lesFormes.longueurEcran , lesFormes.largeurEcran );   
			F.setBackground(Color.darkGray);
			F.addWindowListener(new GestionFenetre());
		    F.getContentPane().add(page, "Center"); 
			F.getContentPane().add(new DesBoutons(page, F), "South"); 
				
			F.setVisible(true);
		 
		 }
		
	// la methode afficher une figure
		public void afficher() {
			int nbFormes = listeFormes.size();
			if(nbFormes > 0) {
				for(lesFormes tmp : listeFormes) {
					tmp.afficher();
				}
			}else {
				System.out.println(" Il n'y aucun personne dans la liste ");
			}
		}
		
	// la methode enrigistrer 
		public void enrigistrer(fichier fiche) throws IOException{
			int nbFormes = listeFormes.size();
			if(nbFormes > 0) {
				String chaine = "";
				for(lesFormes tmp : listeFormes) {
					tmp.afficher();
					chaine = tmp.getInfo();
					if(chaine != null) {
						fiche.ecrire(chaine);
					}
				}
			}else {
				System.out.println(" Il n'y a rien dans la liste pour enregistrer ");
			}
		}
	
	// la methode lire les formes
	   public void lireLIsteFormes(fichier fiche) throws IOException{
		   String chaine;
		   char tt;
		   String [] mot = {"","","","","","","",""};
		   int cc,xx0, xx1, xx2, yy0, yy1, yy2, ll, hh, rr;
		   do {
			   mot = fiche.lire();
			   if(mot != null) 
			   {
				   tt = mot[0].charAt(0);
				   if(tt == 'C') {
					    cc = Integer.parseInt(mot[1]);
					   xx0 = Integer.parseInt(mot[2]);
					   yy0 = Integer.parseInt(mot[3]);
					    rr = Integer.parseInt(mot[4]);
					    listeFormes.add(new Cercle(cc, xx0, yy0, rr));
				   }else if(tt == 'T'){
					    cc = Integer.parseInt(mot[1]);
					   xx0 = Integer.parseInt(mot[2]);
					   yy0 = Integer.parseInt(mot[3]);
					   xx1 = Integer.parseInt(mot[4]);
					   yy1 = Integer.parseInt(mot[5]);
					   xx2 = Integer.parseInt(mot[6]);
					   yy2 = Integer.parseInt(mot[7]);
					   listeFormes.add(new Triangle(cc, xx0, yy0, xx1, yy1, xx2, yy2));
				   }else {
					   if(tt == 'R'){
						    cc = Integer.parseInt(mot[1]);
						   xx0 = Integer.parseInt(mot[2]);
						   yy0 = Integer.parseInt(mot[3]);
						   ll = Integer.parseInt(mot[4]);
						   hh = Integer.parseInt(mot[5]);
						   listeFormes.add(new Rectangle(cc, xx0, yy0, ll, hh));
					   }else if(tt == 'K'){
						    cc = Integer.parseInt(mot[1]);
						   xx0 = Integer.parseInt(mot[2]);
						   yy0 = Integer.parseInt(mot[3]);
						   ll = Integer.parseInt(mot[4]);
						   listeFormes.add(new Carre(cc, xx0, yy0, ll));
					   }
					   
				   }
			 }else {
				 System.out.println(" La liste ne contient rien");
			 }
		   }while(mot != null);
	   }
}
