package program6;

import javax.swing.*;
import java.awt.*;

public class RadioTuner extends JFrame {
    public static int S_START = 0;
    public static int S_LOGIN = 1;
    public static int S_CREATE = 2;
    public static int S_RADIO = 3;
    private static int DEFAULT_W = 550;
    private static int DEFAULT_H = 350;


    public RadioTuner(){

        this("",DEFAULT_W,DEFAULT_H);

    }
    /**
     * constructor
     * @param title name of screen
     * @param width w of screen
     * @param height h of screen
     */
    public RadioTuner(String title, int width, int height){

        // Set the title and default close operation.
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the card layout container.
        CardLayout cardLayout = new CardLayout();
        JPanel container = CreateContainer(cardLayout);


        cardLayout.show(container, String.valueOf(S_START));

        // Add the card layout container to the JFrame.
        this.add(container, BorderLayout.CENTER);

        // Show the JFrame.
        this.setSize(width, height);
        this.setVisible(true);
    }

    private JPanel CreateContainer(CardLayout cardLayout) {
        JPanel container = new JPanel(cardLayout);
        //create controllers
        intScreenControl ic = new intScreenControl(container);
        loginScreenControl lc = new loginScreenControl(container);
        createScreenControl cc = new createScreenControl(container);
        radioScreenControl rc = new radioScreenControl(container);
        //setup the panels for view
        JPanel startView = new S_START_PANEL(ic);
        JPanel createView= new S_CREATE_PANEL(cc);
        JPanel loginView = new S_LOGIN_PANEL(lc);
        JPanel radioView = new S_RADIO_PANEL(rc);
        //add to container (card layout)
        container.add(startView,String.valueOf(S_START));
        container.add(createView,String.valueOf(S_CREATE));
        container.add(loginView,String.valueOf(S_LOGIN));
        container.add(radioView,String.valueOf(S_RADIO));

        return container;
    }


    public static void main(String[] args){
        new RadioTuner ();
    }
}
