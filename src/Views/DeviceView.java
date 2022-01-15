package Views;

import Models.Device;

public class DeviceView {
	public void displayDetaliiDevice(Device device) {
		System.out.println("Informatii despre device-ul nr. " + device.getId());
		System.out.println("Categorie device: " + device.getCategorieDevice()); 
		System.out.println("Localizare device: " + device.getLocalizareDevice());
		System.out.println("Descriere device: " + device.getDescriereDevice());
	}
	
	public void displayListaDevice(Device listaDevice[]) {
		System.out.println("Lista deviceuri:");
		for (int i = 0; i < listaDevice.length; i++) {
			if (listaDevice[i] != null) {
				System.out.println((i + 1) + ": Device nr. " + listaDevice[i].getId());
			}
		}
	}
	
	public void MeniuSelectareDevice() {
		System.out.println("Selectati categorie: ");
		System.out.println("1. Becuri");
		System.out.println("2. Boxe");
		System.out.println("3. Camere supraveghere");
	}
}
