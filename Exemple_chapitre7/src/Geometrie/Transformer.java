package Geometrie;

public class Transformer {

	public static void main(String[] args) {
		 String phrase = "Qui dort ";
		 String verbe = "dine";
		 String p1 = "", p2 = "", p3 = "", p4 = "";
		 int nbcar;
		 
		 System.out.println("1 : "+phrase);
		 System.out.println("2 : "+verbe);
		 
		 p1 = phrase.toUpperCase();
		 System.out.println("En majiscule : "+p1);
		 
		 p2 = phrase.toLowerCase();
		 System.out.println("En maniscule : "+p2);
		 
		 p3 = phrase.concat(verbe);
		 nbcar = p3.length();
		 
		 System.out.println("Apres concat() : ");
		 System.out.println(p3+", possede : "+nbcar+" caracteres");
		 
		 p4 = p3.replace('i', 'a');
		 System.out.println("Apres replace() : "+p3+", devient : "+p4);
		 
	}
}
