package program6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createScreenControl implements ActionListener {
    private JPanel container;

    public createScreenControl(JPanel c){
        this.container = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        if(event.equals(S_CREATE_PANEL.CREATE_SUBMIT_BUTTON)){
            System.out.println("createButton");



            if(VerifyCreateAccount()){
                System.out.println("create account check passed");
            }
        }else if(event.equals((S_CREATE_PANEL.CREATE_CANCEL_BUTTON))){
            CardLayout cardL = (java.awt.CardLayout) container.getLayout();
            cardL.show(container,String.valueOf(RadioTuner.S_START));
        }
    }


    /*
If the user selects a username that has already been used by another account,
display an error message “Username has already been selected:

If the user does not enter a username or password with at least 6 characters, display an appropriate error message.

If the user does not re-enter the password correctly display an appropriate error message.

If the user does properly enter a new username/password correctly and presses “Submit”,
the users.txt file must be updated to contain the new username/password combination.
 A JPanel is next shown displaying all the AM Stations in a JScrollPane as described in the RadioTuner section.

     */
    private boolean VerifyCreateAccount() {
        String[] pssWrds = S_CREATE_PANEL.getPasswords();
        String user = S_CREATE_PANEL.getUsername();

        if(!(pssWrds[0].equals(pssWrds[1]))){
            System.out.println("");
            return false;
        }





        return false;
    }
}
