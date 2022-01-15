package CasaInteligenta;

import java.awt.AWTException;
import java.io.IOException;

import Presenters.MeniuPresenter;

public class main {
static MeniuPresenter presenter = new MeniuPresenter();
	
	public static void main(String[] args) throws IOException, AWTException {
		presenter.startAplicatie();
	}
}
