import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ViewStudentUI extends JFrame {
    private JTable studentTable;
    
    public ViewStudentUI() {
        setTitle("View List Students");
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
        contentPanel.setLayout(new BorderLayout(20, 20));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Title
        JLabel titleLabel = new JLabel("View List Students");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        contentPanel.add(titleLabel, BorderLayout.NORTH);
        
        // table
        createStudentTable();
        JScrollPane scrollPane = new JScrollPane(studentTable);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        
        return contentPanel;
    }
    
    private void createStudentTable() {
        String[] columnNames = {"ID", "Name", "Email", "Phone", "Address"};
        
        Object[][] data = {
            {"123456", "Nguyen Duc Hoang", "hoang.nguyen@gmail.com", "0123456789", "123 Nguyen Hue"},
            {"123457", "Tran Van Nam", "nam.tran@gmail.com", "0123456788", "456 Le Loi"},
            {"123458", "Le Thi Hong", "hong.le@gmail.com", "0123456787", "789 Dong Khoi"},
            {"123459", "Pham Minh Tuan", "tuan.pham@gmail.com", "0123456786", "321 Hai Ba Trung"},
            {"123460", "Vo Thi Lan", "lan.vo@gmail.com", "0123456785", "654 Nguyen Du"}
        };
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only
            }
        };
        
        studentTable = new JTable(model);
        studentTable.setRowHeight(35);
        studentTable.setShowGrid(true);
        studentTable.setGridColor(Color.LIGHT_GRAY);
        
        JTableHeader header = studentTable.getTableHeader();
        header.setBackground(new Color(240, 240, 240));
        header.setFont(new Font("Arial", Font.BOLD, 12));
        
        studentTable.getColumnModel().getColumn(0).setPreferredWidth(70);  // ID
        studentTable.getColumnModel().getColumn(1).setPreferredWidth(150); // Name
        studentTable.getColumnModel().getColumn(2).setPreferredWidth(150); // Email
        studentTable.getColumnModel().getColumn(3).setPreferredWidth(100); // Phone
        studentTable.getColumnModel().getColumn(4).setPreferredWidth(200); // Address
        
        studentTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = studentTable.getSelectedRow();
                if (selectedRow != -1) {
                    System.out.println("Selected student: " + 
                                     studentTable.getValueAt(selectedRow, 1));
                }
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Set system look and feel
                    UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new ViewStudentUI();
            }
        });
    }
}

