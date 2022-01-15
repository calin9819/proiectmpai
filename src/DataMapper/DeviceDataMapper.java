package DataMapper;

import java.awt.AWTException;
import java.io.IOException;

import Models.Device;

public interface DeviceDataMapper {
	Device getDevice(int id) throws IOException;
	Device[] read() throws IOException;
	void update(Device device) throws IOException, AWTException;
}
