import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    
    public LoginUI() {
        setTitle("Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        // main panel 
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(164, 128, 128));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        
        // Title
        JLabel titleLabel = new JLabel("Student management System");
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        titleLabel.setForeground(Color.BLACK);
        
        // Username 
        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.Y_AXIS));
        usernamePanel.setBackground(new Color(164, 128, 128));
        usernamePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        usernameField = new JTextField();
        usernameField.setMaximumSize(new Dimension(300, 25));
        usernameField.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        usernamePanel.add(usernameLabel);
        usernamePanel.add(Box.createVerticalStrut(5));
        usernamePanel.add(usernameField);
        
        // Password 
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.Y_AXIS));
        passwordPanel.setBackground(new Color(164, 128, 128));
        passwordPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(300, 25));
        passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        passwordPanel.add(passwordLabel);
        passwordPanel.add(Box.createVerticalStrut(5));
        passwordPanel.add(passwordField);
        
        // Buttons 
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setBackground(new Color(164, 128, 128));
        buttonsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JButton forgotPasswordButton = new JButton("Forgot password ?");
        forgotPasswordButton.setFocusPainted(false);
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.setContentAreaFilled(false);
        
        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 25));
        
        buttonsPanel.add(forgotPasswordButton);
        buttonsPanel.add(loginButton);
        
        // components
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(usernamePanel);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(passwordPanel);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(buttonsPanel);
        
        // action listeners
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                System.out.println("Login attempt with username: " + username);
            }
        });
        
        forgotPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Forgot password clicked");
            }
        });
        
        add(mainPanel);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginUI();
            }
        });
    }
}