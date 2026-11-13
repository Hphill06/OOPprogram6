package program6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class loginScreenControl implements ActionListener {
    private JPanel container;

    public loginScreenControl(JPanel c){
        this.container = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();


        if(event.equals(S_LOGIN_PANEL.LOGIN_SUBMIT_BUTTON)){
            if(!isPassInTextFile()){
                S_LOGIN_PANEL.setError("The username and password are incorrect.");
            }else{
                //if its a valid password, move to next screen.
                CardLayout cardL = (java.awt.CardLayout) container.getLayout();
                cardL.show(container,String.valueOf(RadioTuner.S_RADIO));
            }
        }else if(event.equals((S_LOGIN_PANEL.LOGIN_CANCEL_BUTTON))){
            CardLayout cardL = (java.awt.CardLayout) container.getLayout();
            cardL.show(container,String.valueOf(RadioTuner.S_START));
        }
    }
    public static boolean isPassInTextFile(){
        String user = S_LOGIN_PANEL.getUsername();
        String pass = S_LOGIN_PANEL.getPassword();
        FileReader fr;
        try{
            fr = new FileReader(RadioTuner.USERS_FILE);
            BufferedReader br = new BufferedReader(fr);
            while(true){
                try{
                    String str = br.readLine();
                    if(str == null){
                        break;
                    }
                    //check if str is a validpassword+usercombo
                    String[] userPass = str.split("\\^");
                    if(userPass[0].equals(user) && userPass[1].equals(pass)){
                        return true;
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        return  false;
    }
}
