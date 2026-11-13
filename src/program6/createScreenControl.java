package program6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class createScreenControl implements ActionListener {
    private JPanel container;

    public createScreenControl(JPanel c){
        this.container = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        if(event.equals(S_CREATE_PANEL.CREATE_SUBMIT_BUTTON)){
            if(VerifyCreateAccount()){
                try{
                    addUserAccount(S_CREATE_PANEL.getUsername(),S_CREATE_PANEL.getPasswords()[0]);
                    //user acc created move to radio
                    CardLayout cardL = (java.awt.CardLayout) container.getLayout();
                    cardL.show(container,String.valueOf(RadioTuner.S_RADIO));

                } catch (IOException ex) {
                    S_CREATE_PANEL.setError("Unknown error!" + ex.getLocalizedMessage());

                    throw new RuntimeException(ex);
                }
            }
        }else if(event.equals((S_CREATE_PANEL.CREATE_CANCEL_BUTTON))){
            CardLayout cardL = (java.awt.CardLayout) container.getLayout();
            cardL.show(container,String.valueOf(RadioTuner.S_START));
        }
    }

    private void addUserAccount(String username, String password) throws IOException {
        String str1 = username + "^" + password;
        FileWriter fw = new FileWriter(RadioTuner.USERS_FILE,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(str1);
        bw.newLine();
        bw.close();
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

        if(pssWrds[0] != null && pssWrds[1] != null && user != null && !(user.equals(""))){
            if(!(pssWrds[0].equals(pssWrds[1])) && (!pssWrds[0].isEmpty())){ //if not equal break
                S_CREATE_PANEL.setError("Passwords to not match");

                return false;
            }
            if(UsernameExists(user)) { // if user exists show error and dont add
                S_CREATE_PANEL.setError("Username has already been selected: "  + user);
                return false;
            }
            if(pssWrds[0].length() <= 5){
                S_CREATE_PANEL.setError("Password too short, needs to be 6 chars long ");

                return false;
            }
        }





        return true;
    }

    private boolean UsernameExists(String user) {
        FileReader fr;

//        System.out.println("USERNAME EXSTS FUNCTION : " + user);
        try{
            fr = new FileReader("C:\\Users\\hudso\\IdeaProjects\\OOPprogram6\\src\\program6\\users.txt");
            BufferedReader br = new BufferedReader(fr);
            while(true){
                try{
                    String str = br.readLine();
                    if(str == null){
                        break;
                    }
                    String[] userPass = str.split("\\^");
//                    System.out.println(userPass[0] + " " + user);
                    if(userPass[0].equals(user)){
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
