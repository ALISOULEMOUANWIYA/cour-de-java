package DessinSapin4;

import java.awt.Color;
import java.awt.Graphics;

public class Arbre {
	
	private int[][] sapin;
	private Color decoration;
	
	public Arbre(int nlargeur, Color c) {
		
		int nlongueur = 2 * nlargeur - 1;
		sapin = new int [nlargeur][nlongueur] ;
		int milieu = sapin[0].length / 2;
		
		for(int i = 0; i < nlargeur; i++) {
			for(int j = -i; j <= i; j++) {
				sapin[i][milieu + j] = (int) (5 * Math.random() + 1);
			}
		}
		
		for(int i = 0; i < sapin.length; i++) {
			for(int j = 0; j < sapin[0].length; j++) {
				System.out.print(sapin[i][j]);
			}
			System.out.println("\n");
		}
	}
	
	public void dessine(Graphics g) {
		System.out.println("\ntraitement des données \n");
		Color vert = Color.green;
		for(int i = 0; i < sapin.length; i++) {
			for(int j = 0; j <sapin[0].length; j++) {
				switch(sapin[i][j]) {
					case 1:
						new triangle(i, j, g, decoration);
					break;
					case 2:
						vert = vert.darker();
						new triangle(i, j, g, vert);
					break;
					case 3:
						vert = vert.brighter();
						new triangle(i, j, g, vert);
					break;
					case 4:
						vert = vert.darker();
						new triangle(i, j, g, vert);
					break;
					case 5:
						vert = vert.brighter();
						new triangle(i, j, g, vert);
					break;
					case 6:
						vert = vert.darker();
						new triangle(i, j, g, vert);
					break;
				}
			}
		}
		
	}
}
