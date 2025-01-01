import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class StudentInformationSystem extends JFrame {
    private JButton[] navButtons;

    public StudentInformationSystem() {
        setTitle("Hust - Student Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel navPanel = createNavigationPanel();
        mainPanel.add(navPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        JPanel infoPanel = createStudentInfoPanel();
        contentPanel.add(infoPanel);

        add(mainPanel);
        setLocationRelativeTo(null);
    }

    private JPanel createNavigationPanel() {
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        navPanel.setBorder(new EmptyBorder(0, 0, 20, 0));

        String[] navItems = {"Hust", "TimeTable", "Enroll Class", "Graduation", "Course",
                "Personal Information", "Services", "Name", "Student/Foreign Student"};

        navButtons = new JButton[navItems.length];

        for (int i = 0; i < navItems.length; i++) {
            boolean isSpecial = navItems[i].equals("Name");
            navButtons[i] = createStyledButton(navItems[i], isSpecial);
            navPanel.add(navButtons[i]);
        }

        return navPanel;
    }

    private JButton createStyledButton(String text, boolean isSpecial) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setFont(button.getFont().deriveFont(Font.BOLD));
        button.setForeground(Color.BLACK);

        if (isSpecial) {
            button.setBackground(new Color(0, 122, 255));
            button.setForeground(Color.BLACK);
            button.setOpaque(true);
            button.setBorderPainted(true);
        } else {
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
        }

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                if (!isSpecial) {
                    button.setContentAreaFilled(true);
                    button.setBackground(new Color(245, 245, 245));
                }
            }

            public void mouseExited(MouseEvent evt) {
                if (!isSpecial && !button.getModel().isPressed()) {
                    button.setContentAreaFilled(false);
                    button.setBorderPainted(false);
                }
            }

            public void mousePressed(MouseEvent evt) {
                if (!isSpecial) {
                    button.setBorderPainted(true);
                    button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
            }

            public void mouseReleased(MouseEvent evt) {
                if (!isSpecial) {
                    button.setBorderPainted(false);
                }
            }
        });

        return button;
    }

    private JPanel createStudentInfoPanel() {
        JPanel infoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel headerLabel = new JLabel("Student Information");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(0, 0, 30, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        infoPanel.add(headerLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        addInfoPair(infoPanel, gbc, "Name", "Nguyen Duc Hoang", 1, 0);
        addInfoPair(infoPanel, gbc, "Major", "ICT", 2, 0);
        addInfoPair(infoPanel, gbc, "Email", "abcxyz@gmail.com", 3, 0);

        addInfoPair(infoPanel, gbc, "ID", "123456", 1, 2);
        addInfoPair(infoPanel, gbc, "GPA", "3.5", 2, 2);
        addInfoPair(infoPanel, gbc, "Phone", "123456789", 3, 2);

        return infoPanel;
    }

    private void addInfoPair(JPanel panel, GridBagConstraints gbc,
                             String labelText, String valueText, int row, int col) {
        // Label
        JLabel label = new JLabel(labelText + ":");
        label.setForeground(Color.GRAY);
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.insets = new Insets(10, 20, 10, 10);
        panel.add(label, gbc);

        // Value
        JLabel value = new JLabel(valueText);
        gbc.gridx = col + 1;
        gbc.insets = new Insets(10, 0, 10, 40);
        panel.add(value, gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            StudentInformationSystem frame = new StudentInformationSystem();
            frame.setVisible(true);
        });
    }
}