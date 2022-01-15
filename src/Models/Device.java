package Models;

public class Device {
	private int id;
	private CategorieDevice categorieDevice;
	private String numeDevice;
	private String localizareDevice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CategorieDevice getCategorieDevice() {
		return categorieDevice;
	}
	public void setCategorieDevice(Models.CategorieDevice categorieDevice) {
		this.categorieDevice = categorieDevice;
	}
	public String getLocalizareDevice() {
		return numeDevice;
	}
	public void setLocalizareDevice(String localizareDevice) {
		this.numeDevice = localizareDevice;
	}
	public String getDescriereDevice() {
		return localizareDevice;
	}
	public void setDescriereDevice(String descriereDevice) {
		this.localizareDevice = descriereDevice;
	}
	
	
}
