import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Manager extends User {

	private String managerId;

	private List<Student> students;

	public static List<ClassSection> classSections;
	
	

	public Manager(String userId, String email, String password,String fullName, String role, boolean status, String dob,
			String managerId) {
		super(userId, email, password,fullName, role, status, dob);
		this.managerId = managerId;
		this.students = new ArrayList<Student>();
		Manager.classSections = new ArrayList<ClassSection>();
	}

	public void viewListStudent() {
		students.sort(Comparator.comparing(Student::getFullName));
        System.out.printf("%-5s %-20s %-15s %-20s %-10s\n", "STT", "Tên sinh viên", "Mã SV", "Chuyên ngành", "Trạng thái");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.printf("%-5d %-20s %-15s %-20s %-10s\n", i + 1, student.getFullName(), student.studentId,
                    student.major, student.isStatus() ? "Active" : "Inactive");
        }
	}

	@SuppressWarnings("resource")
	public void addClassSection() {
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter Class Section ID: ");
	        String classSectionId = scanner.nextLine();
	        System.out.print("Enter Subject Name: ");
	        String subjectName = scanner.nextLine();
	        
	        Subject subject = Main.creditSubjects.stream()
	                .filter(s -> s.subjectName.equalsIgnoreCase(subjectName))
	                .findFirst()
	                .orElseGet(() -> Main.fixedSubjects.stream()
	                        .filter(s -> s.subjectName.equalsIgnoreCase(subjectName))
	                        .findFirst()
	                        .orElse(null));

	        if (subject == null) {
	            System.out.println("Subject not found in the available lists. Please try again.");
	            return;
	        }

	        System.out.print("Enter Semester: ");
	        String semester = scanner.nextLine();
	        System.out.print("Enter Lecturer: ");
	        String lecturer = scanner.nextLine();
	        System.out.print("Enter Max Students: ");
	        int maxStudents = Integer.parseInt(scanner.nextLine());

	        List<Schedule> schedules = new ArrayList<>();
	        System.out.println("Enter Schedule details:");
	        while (true) {
	            System.out.print("Start Time (HH:mm): ");
	            String startTime = scanner.nextLine();
	            System.out.print("End Time (HH:mm): ");
	            String endTime = scanner.nextLine();
	            System.out.print("Day of Week: ");
	            String dayOfWeek = scanner.nextLine();
	            System.out.print("Address: ");
	            String address = scanner.nextLine();

	            schedules.add(new Schedule(startTime, endTime, dayOfWeek, address));

	            System.out.print("Add another schedule? (yes/no): ");
	            if (!scanner.nextLine().equalsIgnoreCase("yes")) break;
	        }

	        boolean duplicate = classSections.stream()
	                .anyMatch(cs -> cs.getClassSectionId().equalsIgnoreCase(classSectionId));

	        if (duplicate) {
	            System.out.println("Class Section ID already exists. Please try again.");
	        } else {
	            ClassSection newClassSection = new ClassSection(classSectionId, subject, semester, lecturer, maxStudents, schedules);
	            classSections.add(newClassSection);
	            System.out.println("Class Section added successfully.");
	        }
	        
	        scanner.close();
	}
	
	public void syncWithExcel() {
        // Placeholder for ExcelUtil integration
        System.out.println("Syncing with Excel...");
        // Read/write logic using ExcelUtil
    }
	
	

	
	//Getters and Setters

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}


class ManagerPanel extends JFrame {

private static final long serialVersionUID = 1L;
	private JTable studentTable;

    public ManagerPanel(Manager manager) {
        setTitle("Manager Panel");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Tab 1: View Students
        JPanel studentPanel = new JPanel(new BorderLayout());
        studentTable = new JTable();
        refreshStudentTable(manager.getStudents());
        studentPanel.add(new JScrollPane(studentTable), BorderLayout.CENTER);
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshStudentTable(manager.getStudents()));
        studentPanel.add(refreshButton, BorderLayout.SOUTH);

        tabbedPane.addTab("View Students", studentPanel);

        // Tab 2: Add Class Section
        addClassSectionPanel();
    }
    
    private void addClassSectionPanel() {
        JFrame frame = new JFrame("Add Class Section");
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 2));

        JLabel idLabel = new JLabel("Class Section ID:");
        JTextField idField = new JTextField();
        JLabel subjectLabel = new JLabel("Subject:");
        JComboBox<String> subjectComboBox = new JComboBox<>();
        JLabel semesterLabel = new JLabel("Semester:");
        JTextField semesterField = new JTextField();
        JLabel lecturerLabel = new JLabel("Lecturer:");
        JTextField lecturerField = new JTextField();
        JLabel maxStudentsLabel = new JLabel("Max Students:");
        JTextField maxStudentsField = new JTextField();

        JLabel scheduleLabel = new JLabel("Schedule:");
        JButton addScheduleButton = new JButton("Add Schedule");
        JTextArea scheduleArea = new JTextArea(5, 20);
        scheduleArea.setEditable(false);
        List<Schedule> schedules = new ArrayList<>();

        // Populate subjectComboBox with available subjects
        for (Subject subject : getAvailableSubjects()) {
            subjectComboBox.addItem(subject.subjectName);
        }

        // Add Schedule Button Action
        addScheduleButton.addActionListener(e -> {
            // Create a new JFrame for adding a schedule
            JFrame scheduleFrame = new JFrame("Add Schedule");
            scheduleFrame.setSize(400, 300);
            scheduleFrame.setLayout(new GridLayout(0, 2));

            JLabel dayOfWeekLabel = new JLabel("Day of Week:");
            JTextField dayOfWeekField = new JTextField();
            JLabel startTimeLabel = new JLabel("Start Time (HH:mm):");
            JTextField startTimeField = new JTextField();
            JLabel endTimeLabel = new JLabel("End Time (HH:mm):");
            JTextField endTimeField = new JTextField();
            JLabel addressLabel = new JLabel("Address:");
            JTextField addressField = new JTextField();

            JButton saveScheduleButton = new JButton("Save Schedule");

            saveScheduleButton.addActionListener(event -> {
                String dayOfWeek = dayOfWeekField.getText();
                String startTime = startTimeField.getText();
                String endTime = endTimeField.getText();
                String address = addressField.getText();

                // Validate input (basic validation)
                if (dayOfWeek.isEmpty() || startTime.isEmpty() || endTime.isEmpty() || address.isEmpty()) {
                    JOptionPane.showMessageDialog(scheduleFrame, "All fields are required!");
                    return;
                }

                // Add the schedule to the list
                Schedule schedule = new Schedule(startTime, endTime, dayOfWeek, address);
                schedules.add(schedule);
                scheduleArea.append(schedule.toString() + "\n");

                // Close the schedule frame
                scheduleFrame.dispose();
            });

            scheduleFrame.add(dayOfWeekLabel);
            scheduleFrame.add(dayOfWeekField);
            scheduleFrame.add(startTimeLabel);
            scheduleFrame.add(startTimeField);
            scheduleFrame.add(endTimeLabel);
            scheduleFrame.add(endTimeField);
            scheduleFrame.add(addressLabel);
            scheduleFrame.add(addressField);
            scheduleFrame.add(new JLabel());
            scheduleFrame.add(saveScheduleButton);

            scheduleFrame.setVisible(true);
        });

        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(e -> {
            String classSectionId = idField.getText();
            String subjectName = (String) subjectComboBox.getSelectedItem();
            String semester = semesterField.getText();
            String lecturer = lecturerField.getText();
            int maxStudents = Integer.parseInt(maxStudentsField.getText());

            Subject selectedSubject = findSubjectByName(subjectName);
            if (selectedSubject == null) {
                JOptionPane.showMessageDialog(frame, "Invalid Subject Name!");
                return;
            }

            boolean duplicate = Manager.classSections.stream()
                .anyMatch(cs -> cs.getClassSectionId().equalsIgnoreCase(classSectionId));

            if (duplicate) {
                JOptionPane.showMessageDialog(frame, "Class Section ID already exists!");
            } else {
                ClassSection newClassSection = new ClassSection(
                    classSectionId, selectedSubject, semester, lecturer, maxStudents, schedules
                );
                Manager.classSections.add(newClassSection);
                JOptionPane.showMessageDialog(frame, "Class Section added successfully!");
                frame.dispose();
            }
        });

        frame.add(idLabel);
        frame.add(idField);
        frame.add(subjectLabel);
        frame.add(subjectComboBox);
        frame.add(semesterLabel);
        frame.add(semesterField);
        frame.add(lecturerLabel);
        frame.add(lecturerField);
        frame.add(maxStudentsLabel);
        frame.add(maxStudentsField);
        frame.add(scheduleLabel);
        frame.add(addScheduleButton);
        frame.add(new JScrollPane(scheduleArea));
        frame.add(submitButton);

        frame.setVisible(true);
    }

    
 // Refresh Student Table
    private void refreshStudentTable(List<Student> students) {
        DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
        model.setRowCount(0); // Clear existing data

        int count = 1; // Serial number
        for (Student student : students) {
            model.addRow(new Object[]{
                count++,
                student.getFullName(),
                student.studentId,
                student.major,
                student.isStatus() ? "Active" : "Inactive"
            });
        }
    }
    
    public List<Subject> getAvailableSubjects() {
        List<Subject> availableSubjects = new ArrayList<>();
        availableSubjects.addAll(Main.creditSubjects);
        availableSubjects.addAll(Main.fixedSubjects);
        return availableSubjects;
    }
    
    public Subject findSubjectByName(String subjectName) {
        return Main.creditSubjects.stream()
                .filter(s -> s.subjectName.equalsIgnoreCase(subjectName))
                .findFirst()
                .orElseGet(() -> Main.fixedSubjects.stream()
                        .filter(s -> s.subjectName.equalsIgnoreCase(subjectName))
                        .findFirst()
                        .orElse(null));
    }


}

