package Validations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import MainFrame.HomePage;

public class LoginValidation {
//Extend your connection class for hadling connection 
//TODO create an Interface to hadle validation then implement ValidationClass

	public LoginValidation(String username,String password) {
		try {
		//Call Validation interface
		// Repository repo= new Repository();
		//example ValidationUser() validation= new ValidationUserImpl(repo.getAllUsers());
		//Connection con = getConn();
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/officed1","root","MAVERIK27");
		//Boolean flag=validation.validateUser(username,password);
    		String sql = "Select * from users where username=? and password=?";
    		PreparedStatement pst = con.prepareStatement(sql);
    		pst.setString(1, username);
    		pst.setString(2, password);
    		ResultSet rs =pst.executeQuery();
		//if(flag).....else......
    		if(rs.next()) {
    			JOptionPane.showMessageDialog(null, "Username and Password Matched");
    			new HomePage(username,password);

    		}else {
    			JOptionPane.showMessageDialog(null, "Username and Password didn't Matched");
    		} con.close();

    	} catch(Exception e1) {
    		JOptionPane.showMessageDialog(null, e1);
    	}
	}

}
