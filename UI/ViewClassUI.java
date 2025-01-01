import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ViewClassUI extends JFrame {
    
    public ViewClassUI() {
        setTitle("View Class");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // main container
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        
        // navigation panel
        JPanel navPanel = createNavigationPanel();
        container.add(navPanel, BorderLayout.NORTH);
        
        // content panel
        JPanel contentPanel = createContentPanel();
        container.add(contentPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    private JPanel createNavigationPanel() {
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        navPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        String[] navItems = {"TimeTable", "Add Class Section", "View List Students", 
                           "Course", "Personal Information", "View Class"};
        
        for (String item : navItems) {
            JButton button = new JButton(item);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
            navPanel.add(button);
        }
        
        // right buttons
        navPanel.add(Box.createHorizontalGlue());
        
        JButton naButton = new JButton("Na...");
        naButton.setBackground(new Color(0, 122, 255));
        naButton.setForeground(Color.WHITE);
        
        JButton teacherButton = new JButton("Teacher");
        teacherButton.setBackground(new Color(240, 240, 240));
        
        navPanel.add(naButton);
        navPanel.add(teacherButton);
        
        return navPanel;
    }
    
    private JPanel createContentPanel() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null); 
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Title
        JLabel titleLabel = new JLabel("View Class");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(20, 20, 300, 30);
        contentPanel.add(titleLabel);
        
        // Class information
        createInfoField(contentPanel, "Name", "OOP", 100);
        createInfoField(contentPanel, "ID", "123456", 140);
        createInfoField(contentPanel, "Max Capacity", "1000", 180);
        createInfoField(contentPanel, "Lecture", "FAM1", 220);
        createInfoField(contentPanel, "Time", "00:00 AM Mon", 260);
        
        // students section
        JLabel studentListLabel = new JLabel("List of Student:");
        studentListLabel.setFont(new Font("Arial", Font.BOLD, 16));
        studentListLabel.setBounds(20, 320, 300, 25);
        contentPanel.add(studentListLabel);
        
        // Student list
        JPanel studentListPanel = new JPanel();
        studentListPanel.setLayout(new BoxLayout(studentListPanel, BoxLayout.Y_AXIS));
        studentListPanel.setBounds(20, 355, 300, 200);
        
        for (int i = 0; i < 2; i++) {
            JLabel studentLabel = new JLabel("Nguyen Duc Hoang");
            studentLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
            studentListPanel.add(studentLabel);
        }
        
        contentPanel.add(studentListPanel);
        
        return contentPanel;
    }
    
    private void createInfoField(JPanel panel, String labelText, String value, int yPosition) {
        // Label
        JLabel label = new JLabel(labelText);
        label.setForeground(new Color(100, 100, 100));
        label.setBounds(20, yPosition, 100, 25);
        panel.add(label);
        
        // Value
        JLabel valueLabel = new JLabel(value);
        valueLabel.setBounds(150, yPosition, 200, 25);
        panel.add(valueLabel);
        
        // separator line
        JSeparator separator = new JSeparator();
        separator.setBounds(20, yPosition + 30, 330, 1);
        panel.add(separator);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewClassUI();
            }
        });
    }
}