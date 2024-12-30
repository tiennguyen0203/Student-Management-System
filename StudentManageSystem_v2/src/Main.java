import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
	public static ArrayList<Subject> creditSubjects = new ArrayList<Subject>();
	public static ArrayList<Subject> fixedSubjects = new ArrayList<Subject>();
    public static void main(String[] args) {
        // Tạo danh sách người dùng mẫu
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("U001", "john.doe@example.com", "password123", "Tien", "Admin", true, "1990-01-15"));
        users.add(new User("U002", "jane.smith@example.com", "abc123", "Nguyen",  "Manager", true, "1995-03-22"));

        // Gọi phương thức hiển thị giao diện đăng nhập
        showLoginScreen(users);
    }

    // Hàm hiển thị giao diện đăng nhập
    private static void showLoginScreen(ArrayList<User> users) {
        // Tạo JFrame cho màn hình đăng nhập
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(400, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new GridLayout(3, 2, 10, 10));

        // Tạo các thành phần giao diện
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);

        // Thêm các thành phần vào JFrame
        loginFrame.add(emailLabel);
        loginFrame.add(emailField);
        loginFrame.add(passwordLabel);
        loginFrame.add(passwordField);
        loginFrame.add(loginButton);
        loginFrame.add(messageLabel);

        // Thiết lập hành động khi nhấn nút "Login"
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                User user = findUserByEmail(users, email);
                if (user != null && user.authenticate(password)) {
                    JOptionPane.showMessageDialog(loginFrame, "Đăng nhập thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loginFrame.dispose(); // Đóng màn hình đăng nhập
                    showMainScreen();    // Hiển thị màn hình chính
                } else {
                    messageLabel.setText("Sai email hoặc mật khẩu!");
                    messageLabel.setForeground(Color.RED);
                }
            }
        });

        // Hiển thị JFrame
        loginFrame.setVisible(true);
    }

    // Hàm hiển thị màn hình chính
    private static void showMainScreen() {
        // Tạo JFrame cho màn hình chính
        JFrame mainFrame = new JFrame("Main Screen");
        mainFrame.setSize(400, 200);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        // Thêm nhãn "Coming soon..." vào màn hình chính
        JLabel comingSoonLabel = new JLabel("Coming soon...", SwingConstants.CENTER);
        comingSoonLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainFrame.add(comingSoonLabel, BorderLayout.CENTER);

        // Hiển thị JFrame
        mainFrame.setVisible(true);
    }

    // Hàm tìm người dùng theo email
    private static User findUserByEmail(ArrayList<User> users, String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }
}
