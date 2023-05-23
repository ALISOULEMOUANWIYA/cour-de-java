package Forme;

import java.awt.event.*;
import javax.swing.*;
public class GestionAction implements ActionListener {
 private int n;
 private DessinFormes d;
 private static int modele=0;
 private JFrame j;
 public GestionAction( int n, DessinFormes d, JFrame j) {
	this.n = n;
	this.d = d;
 	this.j = j;
 }
 
 public void actionPerformed(ActionEvent e) {
  switch (n)  {
    case 1 : d.deplacerGaucheScene();
    break;
    case 2 : d.deplacerGaucheFormes();
    break;
   }
 }
 
}