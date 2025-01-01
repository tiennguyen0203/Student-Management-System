import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddClassSectionUI extends JFrame {
    private JTextField nameField, idField, maxCapacityField, lectureField, timeField;
    
    public AddClassSectionUI() {
        setTitle("Add Class Section");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // main container
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        
        // navigation panel
        JPanel navPanel = createNavigationPanel();
        container.add(navPanel, BorderLayout.NORTH);
        
        // form panel
        JPanel formPanel = createFormPanel();
        container.add(formPanel, BorderLayout.CENTER);
        
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
    
    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); 
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Title
        JLabel titleLabel = new JLabel("Add Class Section");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(20, 20, 300, 30);
        formPanel.add(titleLabel);
        
        // Form fields
        createFormField(formPanel, "Name", "Nguyen Duc Hoang", 100);
        createFormField(formPanel, "ID", "123456", 160);
        createFormField(formPanel, "Max Capacity", "1000", 220);
        createFormField(formPanel, "Lecture", "FAM1", 280);
        createFormField(formPanel, "Time", "00:00 AM Mon", 340);
        
        // Add button
        JButton addButton = new JButton("Add");
        addButton.setBounds(20, 400, 80, 30);
        addButton.setBackground(new Color(240, 240, 240));
        formPanel.add(addButton);
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add button clicked");
            }
        });
        
        return formPanel;
    }
    
    private void createFormField(JPanel panel, String labelText, String defaultValue, int yPosition) {
        // Label
        JLabel label = new JLabel(labelText);
        label.setBounds(20, yPosition, 100, 25);
        panel.add(label);
        
        // Text field
        JTextField field = new JTextField(defaultValue);
        field.setBounds(150, yPosition, 200, 25);
        panel.add(field);
        
        // Store field reference 
        switch(labelText) {
            case "Name": nameField = field; break;
            case "ID": idField = field; break;
            case "Max Capacity": maxCapacityField = field; break;
            case "Lecture": lectureField = field; break;
            case "Time": timeField = field; break;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddClassSectionUI();
            }
        });
    }
}