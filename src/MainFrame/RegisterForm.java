package MainFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Validations.ValidationClass;

public class RegisterForm extends JFrame {
    private JLabel nameLabel, emailLabel, passwordLabel, addressLabel, telephoneLabel;
    private JTextField nameTextField, emailTextField, telephoneTextField, addressTextField;
    private JPasswordField passwordField;
    private JButton registerButton,loginButton;

    public RegisterForm() {
        setTitle("Registration Form");
        setLayout(new GridLayout(6, 2,10,10));

        // Set font styles
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 12);
        Font buttonFont = new Font("Arial", Font.BOLD, 10);

        nameLabel = new JLabel("Username:");
        nameLabel.setFont(labelFont);
        nameTextField = new JTextField();
        nameTextField.setFont(textFieldFont);

        telephoneLabel = new JLabel("Telephone:");
        telephoneLabel.setFont(labelFont);
        telephoneTextField = new JTextField();
        telephoneTextField.setFont(textFieldFont);

        addressLabel = new JLabel("Address:");
        addressLabel.setFont(labelFont);
        addressTextField = new JTextField();
        addressTextField.setFont(textFieldFont);

        emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        emailTextField = new JTextField();
        emailTextField.setFont(textFieldFont);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        passwordField = new JPasswordField();
        passwordField.setFont(textFieldFont);

        registerButton = new JButton("Register");
        registerButton.setFont(buttonFont);

        // Apply additional styles
        registerButton.setBackground(new Color(178, 153, 255));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
                String username = nameTextField.getText();
                String telephone = telephoneTextField.getText();
                String adress = addressTextField.getText();
                String email = emailTextField.getText();
                String password = new String(passwordField.getPassword());

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/officed1","root","MAVERIK27");

                String sql = ("INSERT INTO users (username,password,email,telephone,address) VALUES(?,?,?,?,?)");
                PreparedStatement pst = con.prepareStatement(sql);

                boolean flag1 = new ValidationClass().UsernameReturner(username);
                boolean flag2 = new ValidationClass().PasswordReturner(password);
                boolean flag3 = new ValidationClass().EmailReturner(email);
                boolean flag4 = new ValidationClass().TelephoneReturner(telephone);
                boolean flag5 = new ValidationClass().AddressReturner(adress);


                	if(flag1) {
                		pst.setString(1,username);
                	}else {
                		con.close();
                		setVisible(false);
                		JOptionPane.showMessageDialog(null, "Username is empty or already exists");
                	}
                	if(flag2) {
                		pst.setString(2, password);
                	}else {
                		con.close();
                		setVisible(false);
                		JOptionPane.showMessageDialog(null, "Password is unavailable");
                	}
                	if(flag3) {
                		pst.setString(3, email);
                	}else {
                		con.close();
                		setVisible(false);
                		JOptionPane.showMessageDialog(null, "Email is wrong or already exists");
                	}
                	if(flag4) {
                		pst.setString(4, telephone);
                	}else {
                		con.close();
                		setVisible(false);
                		JOptionPane.showMessageDialog(null, "Telephone is wrong or already existis");
                	}
                	if(flag5) {
                		pst.setString(5, adress);
                	}else {
                		con.close();
                		setVisible(false);
                		JOptionPane.showMessageDialog(null, "adress is wrong or already existis");
                	}


                	int k = pst.executeUpdate();
                	if(k==1) {
                		JOptionPane.showMessageDialog(null, "Registration Complete");
                		new LoginPage();
                	} else {
                		JOptionPane.showMessageDialog(null, "");
                	}

            } catch (Exception e1) {
        		JOptionPane.showMessageDialog(null, "Try Again");
        		new RegisterForm();
        		}
            }
        });
        loginButton = new JButton("Login");
        loginButton.setFont(buttonFont);

        // Apply additional styles
        loginButton.setBackground(new Color(51, 153, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		new LoginPage();
            		setVisible(false);
            	}
            });


        add(nameLabel);
        add(nameTextField);
        add(telephoneLabel);
        add(telephoneTextField);
        add(addressLabel);
        add(addressTextField);
        add(emailLabel);
        add(emailTextField);
        add(passwordLabel);
        add(passwordField);
        add(registerButton);
        add(loginButton);
        
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
