import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MyApplication{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        // Create a JFrame object
        JFrame frame = new JFrame("My Application");

        // Set the size of the frame
        frame.setSize(800, 600);

        // Set the layout of the frame
        frame.setLayout(new BorderLayout());

        // Create a JPanel for the header
        JPanel headerPanel = createHeaderPanel();
        frame.add(headerPanel, BorderLayout.NORTH);

        // Create a JPanel for the body
        JPanel bodyPanel = createBodyPanel();
        frame.add(bodyPanel, BorderLayout.CENTER);

        // Set the frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // center the frame on the screen
        frame.setVisible(true);
    }

    private static JPanel createHeaderPanel() {
        // Create a JPanel for the header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // add some padding

        // Create a JLabel for the image
        ImageIcon imageIcon = new ImageIcon(getImageUrl());
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBorder(BorderFactory.createEtchedBorder());
        headerPanel.add(imageLabel, BorderLayout.WEST);

        // Create a JLabel for the title
        JLabel titleLabel = new JLabel("My Application");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        return headerPanel;
    }

    private static JPanel createBodyPanel() {
        // Create a JPanel for the body
        JPanel bodyPanel = new JPanel(new GridLayout(0, 1));
        bodyPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // add some padding

        // Create a JLabel for the instructions
        JLabel instructionsLabel = new JLabel("Enter your name:");
        bodyPanel.add(instructionsLabel);

        // Create a JTextField for the user input
        JTextField nameTextField = new JTextField();
        bodyPanel.add(nameTextField);

        // Create a JButton for the submit action
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                JOptionPane.showMessageDialog(null, "Hello, " + name + "!");
            }
        });
        bodyPanel.add(submitButton);

        return bodyPanel;
    }

    // This method returns the URL of an image file
    private static URL getImageUrl() {
        return MyApplication.class.getResource("العائلة الطبية2.jpg"); // replace with your image file name
    }
}