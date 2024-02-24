package Validations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import MainFrame.HomePage;

public class LoginValidation {


	public LoginValidation(String username,String password) {
		try {
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/officed1","root","MAVERIK27");
    		String sql = "Select * from users where username=? and password=?";
    		PreparedStatement pst = con.prepareStatement(sql);
    		pst.setString(1, username);
    		pst.setString(2, password);
    		ResultSet rs =pst.executeQuery();
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
