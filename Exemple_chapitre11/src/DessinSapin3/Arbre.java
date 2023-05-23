package DessinSapin3;

import java.awt.Color;
import java.awt.Graphics;

public class Arbre {
	private int [][] sapin;
	private Color decoration;
	
	public Arbre(int nlongueur, Color col) {
		
		int nlargeur = 2*nlongueur - 1 ;
		decoration = col;
		
		sapin = new int[nlongueur][nlargeur];
		int milieu = sapin[0].length/2;
		System.out.println(milieu*2+"\n");
		for(int i = 0; i < nlongueur; i++) {
			for(int j = -i; j < i; j++) {
				sapin[i][milieu + j] = (int) (5*Math.random() + 1);
				System.out.println("Croissance = "+milieu+" + "+j+" = "+(milieu+j) +"\n");
			}
		}
		System.out.println(sapin.length+"\n");
	}
	
	public void dessine(Graphics g) {
		Color vert = Color.cyan;
		
		for(int i = 0; i < sapin.length; i++) {
			for(int j = 0; j < sapin[0].length; j++) {
				
				switch(sapin[i][j]) {
					case 1:
						new triangle(i, j, g, decoration);
					break;
					case 2:
						vert = vert.darker();
						new triangle(i, j, g, vert);
					break;
					case 3:
						vert = vert.darker();
						new triangle(i, j, g, vert);
					break;
					case 4:
						vert = vert.brighter();
						new triangle(i, j, g, vert);
					break;
					case 5:
						vert = vert.darker();
						new triangle(i, j, g, vert);
					break;
					case 6:
						vert = vert.brighter();
						new triangle(i, j, g, vert);
					break;
					case 7:
						vert = vert.cyan;
						new triangle(i, j, g, vert);
					break;
				}
			}
		}
	}
}
