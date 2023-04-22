import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupForm extends JFrame implements ActionListener {

    private WhiteLabel nameLabel, emailLabel, passwordLabel, confirmPasswordLabel;
    private WhiteTextField nameField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private GreenButton submitButton;
    private WhiteLabel messageLabel;

    public SignupForm() {

        // Set up form elements
        nameLabel = new WhiteLabel("Name:");
        emailLabel = new WhiteLabel("Email:");
        passwordLabel = new WhiteLabel("Password:");
        confirmPasswordLabel = new WhiteLabel("Confirm Password:");

        nameField = new WhiteTextField(20);
        emailField = new WhiteTextField(20);
        passwordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);
        passwordField.setEchoChar('*');
        confirmPasswordField.setEchoChar('*');

        submitButton = new GreenButton("Submit");
        submitButton.addActionListener(this);

        messageLabel = new WhiteLabel("");

        // Set up layout
        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.setBackground(new Color(0x302E2E));

        formPanel.add(nameLabel);
        formPanel.add(nameField);

        formPanel.add(emailLabel);
        formPanel.add(emailField);

        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        passwordField.setBackground(new Color(0xD9D9D9));

        formPanel.add(confirmPasswordLabel);
        confirmPasswordField.setBackground(new Color(0xD9D9D9));
        formPanel.add(confirmPasswordField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);

        JPanel messagePanel = new JPanel();
        messagePanel.setBackground(new Color(0x302E2E));
        messagePanel.add(messageLabel);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(0x302E2E));
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(messagePanel, BorderLayout.NORTH);

        // Set up frame
        setContentPane(mainPanel);
        setTitle("Signup Form");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle form submission
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        // Validate form data
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            messageLabel.setText("Please fill in all fields.");
            return;
        }
        if (!email.matches("\\S+@\\S+\\.\\S+")) {
            messageLabel.setText("Please enter a valid email address.");
            return;
        }
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!?@#$%^&+=])(?=\\S+$).{8,}$")) {
            messageLabel.setText("Password must be at least 8 characters long and contain at least one digit, one lowercase letter, one uppercase letter, and one special character.");
            return;
        }
        if (!password.equals(confirmPassword)) {
            messageLabel.setText("Password confirmation does not match.");
            return;
        }

        // Save user data to database or file
        // ...

        // Show success message
        messageLabel.setText("Thank you for signing up!");
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
    }

    public static void main(String[] args) {
        SignupForm form = new SignupForm();
        form.setVisible(true);
    }
}
