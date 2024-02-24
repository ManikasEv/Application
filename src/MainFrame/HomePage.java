package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class HomePage extends JFrame implements ActionListener {

    String username;
    String password;
    JButton buttonlogout, buttonexcel, buttoncsv, buttonword, editingbutton;

    public HomePage(String username, String password) {
        this.username = username;
        this.password = password;

        // create the main panel with BorderLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));

        // create a panel for the buttons with FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 30));
        buttonPanel.setBackground(Color.WHITE);

        buttonexcel = new JButton("Excel");
        buttonexcel.setBackground(Color.decode("#66bb6a"));
        buttonexcel.setForeground(Color.WHITE);
        buttonexcel.setFont(new Font("Arial", Font.BOLD, 16));
        buttonexcel.setPreferredSize(new Dimension(120, 40));
        buttonexcel.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonexcel.addActionListener(this);

        buttoncsv = new JButton("Csv");
        buttoncsv.setBackground(Color.decode("#f57c00"));
        buttoncsv.setForeground(Color.WHITE);
        buttoncsv.setFont(new Font("Arial", Font.BOLD, 16));
        buttoncsv.setPreferredSize(new Dimension(120, 40));
        buttoncsv.setBorder(BorderFactory.createRaisedBevelBorder());
        buttoncsv.addActionListener(this);

        buttonword = new JButton("Word");
        buttonword.setBackground(Color.decode("#42a5f5"));
        buttonword.setForeground(Color.WHITE);
        buttonword.setFont(new Font("Arial", Font.BOLD, 16));
        buttonword.setPreferredSize(new Dimension(120, 40));
        buttonword.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonword.addActionListener(this);

        buttonPanel.add(buttonexcel);
        buttonPanel.add(buttoncsv);
        buttonPanel.add(buttonword);

        // add the button panel to the center of the main panel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // create a panel for the logout and edit buttons with FlowLayout
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(600, 70));
        bottomPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));

        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 30));
        buttonlogout = new JButton("Logout");
        buttonlogout.setFont(new Font("Arial", Font.PLAIN, 16));
        buttonlogout.setForeground(Color.GREEN);
        buttonlogout.setBackground(Color.BLACK);
        buttonlogout.setFocusPainted(false);
        buttonlogout.addActionListener(this);
        logoutPanel.add(buttonlogout);

        JPanel editPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 30));
        editingbutton = new JButton("Edit");
        editingbutton.setFont(new Font("Arial", Font.PLAIN, 16));
        editingbutton.setForeground(Color.RED);
        editingbutton.setBackground(Color.BLACK);
        editingbutton.setFocusPainted(false);
        editPanel.add(editingbutton);

        bottomPanel.add(logoutPanel, BorderLayout.EAST);
        bottomPanel.add(editPanel, BorderLayout.WEST);

        // add the logout panel to the bottom of the main panel
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        
        setTitle("Hello " + username);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 200);
        setResizable(false); // disable the resizing of the frame
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonlogout) {
            new LoginPage();
            setVisible(false);
        } else if (e.getSource() == buttonexcel) {
            new ExcelFrame(username,password);
            setVisible(false);
        } else if (e.getSource() == buttoncsv) {
            new CsvFrame(username,password);
            setVisible(false);
        } else if (e.getSource() == buttonword) {  
            new WordFrame(username,password);
            setVisible(false);
        }
    }
}
