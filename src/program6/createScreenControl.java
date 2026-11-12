package program6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createScreenControl implements ActionListener {
    private JPanel container;

    public createScreenControl(JPanel c){
        this.container = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand() + "number for create " + RadioTuner.S_CREATE);
    }
}
