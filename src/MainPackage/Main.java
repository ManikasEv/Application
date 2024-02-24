package MainPackage;

import Connection.JBDCConnection;
import MainFrame.LoginPage;

public class Main {
	public static void main(String[] args) {
		new JBDCConnection();
		new LoginPage();
	}
}
