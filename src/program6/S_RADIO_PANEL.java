package program6;

import javax.swing.*;
import java.awt.*;

public class S_RADIO_PANEL extends JPanel {


    public S_RADIO_PANEL(radioScreenControl rc){
        // Create the information label.
        JLabel label = new JLabel("radio", JLabel.CENTER);
        // Create the login button.
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(rc);
        JPanel loginButtonBuffer = new JPanel();
        loginButtonBuffer.add(loginButton);


        // Arrange the components in a grid.
        JPanel grid = new JPanel(new GridLayout(3, 1, 5, 5));
        grid.add(label);
        grid.add(loginButtonBuffer);
//        grid.add(createButtonBuffer);
        this.add(grid);

    }
}
