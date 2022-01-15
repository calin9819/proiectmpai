package Views;

public class MeniuView {
	public void MeniuPrincipal() {
		System.out.println("Bun venit! Alegeti optiunea:");
		System.out.println("1. Vedeti toate device-urile");
		System.out.println("2. Filtrati solicitarile dupa categorie");
		System.out.println("3. Iesiti");
	}
	
	public void MeniuListaDevice() {
		System.out.println("1. Selectati device");
		System.out.println("2. Inapoi");
	}
	
	public void MeniuCategorieSelectata() {
		System.out.println("1. Editati categorie device");
		System.out.println("2. Inapoi");
	}
	
	public void MeniuSelectareCategorie() {
		System.out.println("Selectati categorie: ");
		System.out.println("1. Becuri");
		System.out.println("2. Boxe");
		System.out.println("3. Camere de supraveghere");
	}
}
