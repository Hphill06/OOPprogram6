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


        String event = e.getActionCommand();


        if(event.equals(S_START_PANEL.CREATE_ACC_BUTTON)){
            System.out.println();
            CardLayout cardLayout = (java.awt.CardLayout) container.getLayout();
            cardLayout.show(container,String.valueOf(RadioTuner.S_CREATE));
        }

        if(event.equals(S_START_PANEL.LOGIN_ACC_BUTTON)){
            System.out.println();
            CardLayout cardLayout = (java.awt.CardLayout) container.getLayout();
            cardLayout.show(container,String.valueOf(RadioTuner.S_LOGIN));
        }


    }
}
