package NotificationManager;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.Toolkit;

public class NotificationManager {
	private SystemTray tray;

	public NotificationManager() {
		this.tray = SystemTray.getSystemTray();
	}

	public void displayMessage(String message) throws AWTException {
		Image img = Toolkit.getDefaultToolkit().createImage("info.png");
		TrayIcon icon = new TrayIcon(img, "Mesaj notificare");
		icon.setImageAutoSize(true);
		this.tray.add(icon);
		icon.displayMessage("Notification Manager", message, MessageType.INFO);
	}
}
