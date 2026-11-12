package program6;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class intScreenControl implements ActionListener {
    private JPanel container;

    public intScreenControl(JPanel c){
        this.container = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand() + "number for create " + RadioTuner.S_CREATE);
    }
}
