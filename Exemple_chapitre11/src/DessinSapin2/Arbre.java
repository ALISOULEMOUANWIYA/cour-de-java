package DessinSapin2;

import java.awt.Color;
import java.awt.Graphics;

public class Arbre {
	private int [][] sapin;
	private Color decoration;
	
	public Arbre(int nl,Color c) {
		int nc = 2*nl - 1;
		decoration = c;
		sapin = new int[nl][nc];
		int milieu = sapin[0].length/2;
		//System.out.println(milieu+"\n");
		for(int i = 0 ; i < nl; i++) {
			System.out.println("i = "+i+"\n");
			for(int j = -i; j <= i; j++) {
				System.out.println("j = "+j+"\n"); 
				sapin[i][milieu+j] = (int) (5*Math.random() + 1);
				//System.out.println((int) (5*Math.random() + 1)+"\n");
				//System.out.println(sapin[i][milieu+j]+"\n");
			}
		}
		
		for(int i = 0 ; i < sapin.length; i++) {
			for(int j = 0; j <sapin.length; j++) {
				System.out.print(" "+sapin[i][j]);
			}
			System.out.println("\n");
		}
		
	}
	
	 
   public void dessine(Graphics g) {
	   Color vert = Color.green;
	   for(int i = 0 ; i < sapin.length; i++) {
			for(int j = 0; j < sapin[0].length; j++) {
				switch(sapin[i][j]) {
					case 1: 
						new triangle(i, j, g, decoration);
						break;
					case 2:
						vert = vert.brighter();
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
					
				}
			}
		}  
   }
}
