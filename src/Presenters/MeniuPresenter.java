package Presenters;
import java.awt.AWTException;
import java.io.IOException;
import java.util.Scanner;

import Views.MeniuView;

public class MeniuPresenter {
	private DevicePresenter presenterDeviceuri = new DevicePresenter();
	private MeniuView meniuView = new MeniuView();
	
	public void startAplicatie() throws IOException, AWTException {
		this.displayMeniuPrincipal();
	}
	
	public void displayMeniuPrincipal() throws IOException, AWTException {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			this.meniuView.MeniuPrincipal();
			int optiune = Integer.parseInt(scanner.nextLine());
			switch (optiune) {
				case 1: 
					presenterDeviceuri.displayListaDeviceuri();
					this.displayMeniuListaDeviceuri(scanner);
					break;
				case 2:
					this.meniuView.MeniuSelectareCategorie();
					int categorie = Integer.parseInt(scanner.nextLine());
					presenterDeviceuri.filtrareDeviceuri(categorie-1);
					this.displayMeniuListaDeviceuri(scanner);
					break;
				case 3:
					scanner.close();
					return;
				default:
					throw new IllegalArgumentException("Valoare invalida: " + optiune);
			}
		}
	}
	
	public void displayMeniuListaDeviceuri(Scanner scanner) throws IOException, AWTException {
		this.meniuView.MeniuListaDevice();
		
		int optiune = Integer.parseInt(scanner.nextLine());
		
		switch (optiune) {
			case 1:
				presenterDeviceuri.selectDevice(scanner);
				presenterDeviceuri.displayDetaliiDevice();
				this.meniuView.MeniuCategorieSelectata();
				
				optiune = Integer.parseInt(scanner.nextLine());
				switch (optiune) {
					case 1:
						presenterDeviceuri.updateDevice(scanner);
						break;
					case 2:
						break;
					default:
						throw new IllegalArgumentException("Valoare invalida: " + optiune);
				}
				break;
			case 2:
				return;
			default:
				throw new IllegalArgumentException("Valoare invalida: " + optiune);
		}
	}
}
