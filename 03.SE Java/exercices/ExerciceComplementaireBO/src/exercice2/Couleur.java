package exercice2;


public class Couleur {
public static String donneCouleur(int rouge,int vert,int bleu)
{
	String couleur="couleur ne faisant pas partie des couleurs predefinies";
if ((rouge==0) && (vert==0) && (bleu==0)) {
	return "noir";
}
if ((rouge==255) && (vert==0) && (bleu==0)) {
	return "rouge";
}
if ((rouge==0) && (vert==255) && (bleu==0)) {
	return "vert";
}
if ((rouge==0) && (vert==0) && (bleu==255)) {
	return "bleu";
}
if ((rouge==255) && (vert==255) && (bleu==0)) {
	return "jaune";
}
if ((rouge==255) && (vert==0) && (bleu==255)) {
	return "magenta";
}
if ((rouge==0) && (vert==255) && (bleu==255)) {
	return "cyan";
}
if ((rouge==255) && (vert==255) && (bleu==255)) {
	return "blanc";
}
if ((rouge==192) && (vert==192) && (bleu==192)) {
	return "gris clair";
}
if ((rouge==128) && (vert==128) && (bleu==128)) {
	return "gris";
}
if ((rouge==64) && (vert==64) && (bleu==64)) {
	return "gris foncé";
}
if ((rouge==255) && (vert==200) && (bleu==0)) {
	return "orange";
}
if ((rouge==255) && (vert==175) && (bleu==175)) {
	return "rose";
}
return couleur;

}
}
