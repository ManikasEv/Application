package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Validations.LoginValidation;




    public class LoginPage extends JFrame implements ActionListener {
        JLabel userLabel, passwordLabel;
        JTextField userField;
        JPasswordField passwordField;
        JButton loginButton, registerButton;
        JPanel  usernamePanel,passwordPanel,buttonPanel,mainPanel;
        Font labelFont,buttonFont;

        public LoginPage() {
            setTitle("Office Application");

            // Create main panel
            Color frameColor = new Color(47, 109, 156);
            
            JPanel mainPanel = new JPanel(new BorderLayout());
            

            // Create panels for username, password, and button sections
            JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

            // Setting font styles
            Font labelFont = new Font("Arial", Font.BOLD, 14);
            Font buttonFont = new Font("Arial", Font.BOLD, 12); // Change button font style

            userLabel = new JLabel("Username:");
            passwordLabel = new JLabel("Password: ");
            userLabel.setFont(labelFont);
            passwordLabel.setFont(labelFont);

            userField = new JTextField(15); // Adjust the width as needed
            passwordField = new JPasswordField(15);
            
            loginButton = new JButton("Log in");
            registerButton = new JButton("Register");
            loginButton.setFont(buttonFont);
            registerButton.setFont(buttonFont);

            // Apply styling to buttons
            loginButton.setBackground(new Color(51, 153, 255));
            loginButton.setForeground(Color.BLACK);
            loginButton.setFocusPainted(false);
            loginButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

            registerButton.setBackground(new Color(255, 102, 102));
            registerButton.setForeground(Color.BLACK);
            registerButton.setFocusPainted(false);
            registerButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

            // Add components to the username panel
            usernamePanel.setBorder(new EmptyBorder(20,0,0,0));
            usernamePanel.setBackground(frameColor);
            usernamePanel.add(userLabel);
            usernamePanel.add(userField);

            // Add components to the password panel
            passwordPanel.setBorder(new EmptyBorder(20,0,0,0));
            passwordPanel.setBackground(frameColor);
            passwordPanel.add(passwordLabel);
            passwordPanel.add(passwordField);

            // Add components to the button panel
            buttonPanel.setBackground(frameColor);
            buttonPanel.setBorder(new EmptyBorder(0,10,10,-50));
            buttonPanel.add(loginButton);
            buttonPanel.add(registerButton);

            // Add panels to the main panel
            mainPanel.add(usernamePanel, BorderLayout.NORTH);
            mainPanel.add(passwordPanel, BorderLayout.CENTER);
            mainPanel.add(buttonPanel, BorderLayout.SOUTH);
            mainPanel.setBackground(frameColor);

            add(mainPanel);

            loginButton.addActionListener(this);
            registerButton.addActionListener(this);

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setResizable(false);
            setSize(300, 200);
            setLocationRelativeTo(null);
            setVisible(true);
        }
        
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == loginButton) {
	            String username = userField.getText();
	            String password = new String(passwordField.getPassword());
	            // do your login validation here
	        	 new LoginValidation(username,password);
	        	 setVisible(false);

	        } else if (e.getSource() == registerButton) {
	            new RegisterForm();
	            setVisible(false);
	        }
	    }
	}
