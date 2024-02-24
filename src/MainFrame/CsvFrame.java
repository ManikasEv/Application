package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class CsvFrame extends JFrame implements ActionListener{
    JLabel directorylabel, imageLabel;
    JTextField directoryText;
    JPanel directoryPanel, buttonPanel, mainPanel,arrowPanel;
    JButton directoryButton, arrowButton;
    ImageIcon imageIcon;

    String username;
    String password;


    public CsvFrame(String username,String password) {

    	this.username = username;
        this.password = password;
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(255, 200, 200));
        add(mainPanel);

        directoryPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        directoryPanel.setBackground(new Color(255, 200, 200));

        directorylabel = new JLabel("Import Directory");
        directorylabel.setFont(new Font("Arial", Font.BOLD, 16));
        directorylabel.setForeground(Color.BLACK);

        directoryText = new JTextField();
        directoryText.setPreferredSize(new Dimension(200, 30));

        directoryPanel.add(directorylabel);
        directoryPanel.add(directoryText);

        directoryPanel.setBorder(new EmptyBorder(50, 0, 0, 0));
        directoryPanel.setBorder(new EmptyBorder(50, 0, 0, 0));



        directoryButton = new JButton("Analyze");
        directoryButton.setFont(new Font("Arial", Font.BOLD, 20));
        directoryButton.setBackground(Color.RED);
        directoryButton.setForeground(Color.BLACK);
        directoryButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        directoryButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        directoryButton.setFocusPainted(false);


        arrowButton = new JButton("Go to HomePage");
        arrowButton.setFont(new Font("Arial", Font.BOLD, 14));
        arrowButton.setFocusPainted(false);
        arrowButton.addActionListener(this);

        arrowPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 140, 80));
        arrowPanel.setBackground(new Color(255, 200, 200));
        arrowPanel.add(arrowButton);
        arrowPanel.setBorder(new EmptyBorder(0, 0, 0, -50));

        directoryPanel.add(directoryButton);
        mainPanel.add(directoryPanel, BorderLayout.NORTH);
        mainPanel.add(arrowPanel, BorderLayout.CENTER);


        // Load and display the image
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/csv.png"));

            // Resize the image
            int desiredWidth = 100;  // Specify the desired width
            int desiredHeight = 100; // Specify the desired height
            BufferedImage resizedImage = new BufferedImage(desiredWidth, desiredHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = resizedImage.createGraphics();
            g2d.drawImage(image, 0, 0, desiredWidth, desiredHeight, null);
            g2d.dispose();

            // Create the ImageIcon with the resized image
            imageLabel = new JLabel(new ImageIcon(resizedImage));
            imageLabel.setBorder(new EmptyBorder(0,120,0,0));
            mainPanel.add(imageLabel, BorderLayout.WEST);
        } catch (IOException e) {
            System.out.println("Failed to load image: " + e.getMessage());
        }

        setTitle("Csv");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == arrowButton) {
    		new HomePage(username,password);
    		setVisible(false);
    	}
	}


}
