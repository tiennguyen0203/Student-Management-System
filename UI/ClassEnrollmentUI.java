import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClassEnrollmentUI extends JFrame {
    private JTextField searchField;
    private JTable classTable;
    private JPanel filterPanel;

    public ClassEnrollmentUI() {
        setTitle("Class Enrollment - Fall 2022");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        
        // main container 
        Container container = getContentPane();
        container.setLayout(new BorderLayout(10, 10));

        // top navigation 
        JPanel navPanel = createNavigationPanel();
        container.add(navPanel, BorderLayout.NORTH);

        // search 
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchField = new JTextField(30);
        searchField.putClientProperty("JTextField.placeholderText", "Search");
        searchPanel.add(searchField);
        
        // filter buttons
        filterPanel = createFilterPanel();
        
        // search and filters
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(searchPanel, BorderLayout.NORTH);
        topPanel.add(filterPanel, BorderLayout.CENTER);
        container.add(topPanel, BorderLayout.CENTER);

        // table
        createClassTable();
        JScrollPane scrollPane = new JScrollPane(classTable);
        container.add(scrollPane, BorderLayout.SOUTH);

        setTheme();
    }

    private JPanel createNavigationPanel() {
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] navItems = {"Hust", "TimeTable", "Enroll Class", "Graduation", "Course",
                "Personal Information", "Services", "Name", "Student/Foreign Student"};
        
        for (String item : navItems) {
            JButton button = new JButton(item);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
            navPanel.add(button);
        }
        
        return navPanel;
    }

    private JPanel createFilterPanel() {
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] filters = {"Architecture", "Art History", "Asian American Studies", 
                          "Asian Studies", "Astronomy", "Business Administration"};
        
        for (String filter : filters) {
            JButton filterBtn = new JButton(filter);
            filterBtn.setBackground(new Color(240, 240, 240));
            filterBtn.setBorderPainted(false);
            filterPanel.add(filterBtn);
        }
        
        return filterPanel;
    }

    private void createClassTable() {
        String[] columnNames = {"Class", "Title", "Instructor", "Days", "Time", 
                              "Location", "Units"};
        
        Object[][] data = {
            {"BIOLOGY 1A", "General Biology Lecture", "Lecturer 1", "MWF", "9-10am", 
             "Valley Life Sciences Building, 2050", "3.0"},
            {"BIOLOGY 1AL", "General Biology Lab", "Lab GS1", "Tu", "2-5pm", 
             "Valley Life Sciences Building, 2050", "1.0"},
            {"BIOLOGY 1B", "General Biology Lecture", "Lecturer 2", "MWF", "9-10am", 
             "Valley Life Sciences Building, 2050", "3.0"},
            {"BIOLOGY 1BL", "General Biology Lab", "Lab GS1", "Tu", "2-5pm", 
             "Valley Life Sciences Building, 2050", "1.0"},
            {"BIOLOGY 1C", "General Biology Lecture", "Lecturer 3", "MWF", "9-10am", 
             "Valley Life Sciences Building, 2050", "3.0"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        classTable = new JTable(model);
        classTable.setRowHeight(40);
        classTable.getTableHeader().setBackground(new Color(245, 245, 245));
    }

    private void setTheme() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClassEnrollmentUI ui = new ClassEnrollmentUI();
            ui.setVisible(true);
        });
    }
}