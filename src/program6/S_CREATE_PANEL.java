package program6;

import javax.swing.*;
import java.awt.*;

public class S_CREATE_PANEL extends JPanel{
    // Private data fields for the important GUI components.
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JPasswordField passwordConfirmField;
    private static JPasswordField passwordAgainField;
    private static JLabel errorLabel;
    public static final String CREATE_SUBMIT_BUTTON = "Submit";
    public static final String CREATE_CANCEL_BUTTON = "Cancel";
    // Getter for the text in the username field.
    public static String getUsername()
    {
        return usernameField.getText();
    }

    /**
     * returns the password and then the "retype password" field's text
     * @return string arr of both passwords entered by user
     */
    public static String[] getPasswords()
    {
        return new String[]{passwordField.getText(),passwordAgainField.getText()};
    }

    // Setter for the error text.
    public static void setError(String error)
    {
        errorLabel.setText(error);
    }


    public S_CREATE_PANEL(createScreenControl cc){



        // Create a panel for the labels at the top of the GUI.
        JPanel labelPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        errorLabel = new JLabel("", JLabel.CENTER);
        errorLabel.setForeground(Color.RED);
        JLabel instructionLabel = new JLabel("Enter your username and password to create an account.", JLabel.CENTER);
        JLabel instructionLabel2 = new JLabel("Your password must be at least 6 characters", JLabel.CENTER);
        labelPanel.add(errorLabel);
        labelPanel.add(instructionLabel);
        labelPanel.add(instructionLabel2);

        // Create a panel for the login information form.
        JPanel loginPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JLabel usernameLabel = new JLabel("Username:", JLabel.RIGHT);
        usernameField = new JTextField(10);
        JLabel passwordLabel = new JLabel("Password:", JLabel.RIGHT);
        JLabel passwordConfirmLabel = new JLabel("Verify Password:", JLabel.RIGHT);
        passwordField = new JPasswordField(10);
        passwordConfirmField = new JPasswordField(10);
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(passwordConfirmLabel);
        loginPanel.add(passwordConfirmField);

        // Create a panel for the buttons.
        JPanel buttonPanel = new JPanel();
        JButton submitButton = new JButton(CREATE_SUBMIT_BUTTON);
        submitButton.addActionListener(cc);
        JButton cancelButton = new JButton(CREATE_CANCEL_BUTTON);
        cancelButton.addActionListener(cc);
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        // Arrange the three panels in a grid.
        JPanel grid = new JPanel(new GridLayout(3, 1, 0, 10));
        grid.add(labelPanel);
        grid.add(loginPanel);
        grid.add(buttonPanel);
        this.add(grid);
    }
}
