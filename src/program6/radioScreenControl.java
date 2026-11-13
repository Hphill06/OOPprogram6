package program6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class radioScreenControl implements ActionListener {
    private JPanel container;
    private static JavaStreaming stream;

    public radioScreenControl(JPanel c){
            this.container = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("button pressed : " + e.getActionCommand());
        String event = e.getActionCommand();


        if(event.equals(S_RADIO_PANEL.curType)){
            S_RADIO_PANEL.changeTypeButton();
            S_RADIO_PANEL.updateStationList();
        }else if(event.startsWith("STATION_")){
            //get the call letters off the end of the command
            String station = event.substring("STATION_".length());

            //stop the station that is currently playing
            if(stream != null && stream.player != null){
                stream.close();
            }

            //start playing the new station
            stream = new JavaStreaming();
            stream.setURL(S_RADIO_PANEL.getFullLink(station.toUpperCase(), S_RADIO_PANEL.curType));
            stream.play();

            //show the station under the scroll pane
            S_RADIO_PANEL.changeStationSelection("Now Playing: " + station);
        }else if(event.equals("Configuration")){
            CardLayout cardL = (java.awt.CardLayout) container.getLayout();
            cardL.show(container,String.valueOf(RadioTuner.S_CONFIG));
        }

    }
}
