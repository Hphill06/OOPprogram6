package program6;

import javax.swing.*;
import java.awt.*;

public class S_CREATE_PANEL extends JPanel{

    public S_CREATE_PANEL(createScreenControl cc){
        // Create the information label.
        JLabel label = new JLabel("CREATE SCREEN", JLabel.CENTER);

        // Create the create account button.
        JButton createButton = new JButton("Create");
        createButton.addActionListener(cc);
        JPanel createButtonBuffer = new JPanel();
        createButtonBuffer.add(createButton);

        // Arrange the components in a grid.
        JPanel grid = new JPanel(new GridLayout(3, 1, 5, 5));
        grid.add(label);
        //grid.add(loginButtonBuffer);
        grid.add(createButtonBuffer);
        this.add(grid);
    }
}
