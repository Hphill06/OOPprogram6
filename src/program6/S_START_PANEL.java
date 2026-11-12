package program6;

import javax.swing.*;
import java.awt.*;

public class S_START_PANEL extends JPanel{
    public static final String CREATE_ACC_BUTTON = "Create";
    public static final String LOGIN_ACC_BUTTON = "login";
    public S_START_PANEL(intScreenControl ic){
        // Create the information label.
        JLabel label = new JLabel("Account Information", JLabel.CENTER);
        // Create the login button.
        JButton loginButton = new JButton(LOGIN_ACC_BUTTON);
        loginButton.addActionListener(ic);
        JPanel loginButtonBuffer = new JPanel();
        loginButtonBuffer.add(loginButton);

        // Create the create account button.
        JButton createButton = new JButton(CREATE_ACC_BUTTON);
        createButton.addActionListener(ic);
        JPanel createButtonBuffer = new JPanel();
        createButtonBuffer.add(createButton);

        // Arrange the components in a grid.
        JPanel grid = new JPanel(new GridLayout(3, 1, 5, 5));
        grid.add(label);
        grid.add(loginButtonBuffer);
        grid.add(createButtonBuffer);
        this.add(grid);
    }
}
