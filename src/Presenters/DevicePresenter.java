package Presenters;
import java.awt.AWTException;
import java.io.IOException;
import java.util.Scanner;

import DataMapper.ImplementareDataMapper;
import Models.Device;
import Models.CategorieDevice;
import Views.MeniuView;
import Views.DeviceView;

public class DevicePresenter {
	private Device deviceModel;
	private DeviceView deviceView;
	private ImplementareDataMapper dataMapper;
	
	public DevicePresenter() {
		this.deviceView = new DeviceView();
		this.dataMapper = new ImplementareDataMapper();
	}
	
	public Device selectDevice(Scanner scanner) throws IOException {
		System.out.print("Selectati device dupa id: ");
		int numar = Integer.parseInt(scanner.nextLine());
		
		Device device = this.dataMapper.getDevice(numar);
		if (device != null) {
			this.deviceModel = device;
			return device;
		} else {
			System.out.println("Invalid");
			return null;
		}
	}
	
	public void displayListaDeviceuri() throws IOException {
		Device[] deviceuri = this.dataMapper.read();
		this.deviceView.displayListaDevice(deviceuri);
	}
	
	public void displayDetaliiDevice() throws IOException {
		this.deviceView.displayDetaliiDevice(this.deviceModel);
	}
	
	public void updateDevice(Scanner scanner) throws IOException, AWTException {
		this.deviceView.MeniuSelectareDevice();
		int device = Integer.parseInt(scanner.nextLine());
		
		Device deviceUpdated = new Device();
		deviceUpdated.setId(this.deviceModel.getId());
		deviceUpdated.setCategorieDevice(CategorieDevice.values()[device-1]);
		
		this.dataMapper.update(deviceUpdated);
	}
	
	public void filtrareDeviceuri(int status) throws IOException {
		Device[] deviceuri = this.dataMapper.read();
		Device[] deviceuriFiltrate = new Device[10000];
		int j = 0;
		for (int i = 0; i < deviceuri.length; i++) {
			if (deviceuri[i] != null && deviceuri[i].getCategorieDevice() == CategorieDevice.values()[status]) {
				deviceuriFiltrate[j] = deviceuri[i];
				j++;
			}
		}
		
		this.deviceView.displayListaDevice(deviceuriFiltrate);
	}
}
