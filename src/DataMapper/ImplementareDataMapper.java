package DataMapper;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Models.CategorieDevice;
import Models.Device;
import NotificationManager.NotificationManager;

public class ImplementareDataMapper implements DeviceDataMapper {
	private Device[] getDeviceuri() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("resources/Solicitari.csv"));  
		String linie = "";
		String delimitator = ",";
		
		Device[] deviceuri = new Device[10000];
		int i = 0;
		
		while ((linie = reader.readLine()) != null) {
			String[] device = linie.split(delimitator);
			
			Device obiectDevice = new Device();
			obiectDevice.setId(Integer.parseInt(device[0]));
			obiectDevice.setCategorieDevice(CategorieDevice.valueOf(device[1]));
			obiectDevice.setLocalizareDevice(device[2]);
			obiectDevice.setDescriereDevice(device[3]);
			
			deviceuri[i] = obiectDevice;
			i++;
		}
		
		reader.close();
		return deviceuri;
	}
	
	@Override
	public Device getDevice(int id) throws IOException {
		Device[] deviceuri = this.getDeviceuri();
		for (int i = 0; i < deviceuri.length; i++) {
			if (deviceuri[i].getId() == id) {
				return deviceuri[i];
			}
		}
		return null;
	}
	
	@Override
	public Device[] read() throws IOException {
		Device[] deviceuri = this.getDeviceuri();
		return deviceuri;
	}

	@Override
	public void update(Device device) throws IOException, AWTException {
		Device[] deviceuri = this.getDeviceuri();
		for (int i = 0; i < deviceuri.length; i++) {
			if (deviceuri[i].getId() == device.getId()) {
				deviceuri[i].setCategorieDevice(device.getCategorieDevice());
				break;
			}
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("resources/Solicitari.csv", false));
		for (int i = 0; i < deviceuri.length; i++) {
			if (deviceuri[i] != null) {
				String linie = deviceuri[i].getId() + "," + deviceuri[i].getCategorieDevice() + "," + deviceuri[i].getLocalizareDevice() + "," + deviceuri[i].getDescriereDevice() +"\n";
				writer.write(linie);
			}
		}
		writer.close();
		
		NotificationManager notificationManager = new NotificationManager();
		notificationManager.displayMessage("A fost actualizat statusul solicitarii: " + device.getId());
	}
}
