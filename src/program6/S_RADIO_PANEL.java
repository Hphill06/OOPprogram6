package program6;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class S_RADIO_PANEL extends JPanel {
    public String STATION_TXT = "No Station Selected.";
    private static JLabel label2;
    public static String curType = "AM";
    public static JButton swapTypeButton;
    public static JPanel stationList;
    private static radioScreenControl stationListener;

    public S_RADIO_PANEL(radioScreenControl rc){
        this.setLayout(new BorderLayout(0, 8));
        this.setBorder(BorderFactory.createEmptyBorder(8, 60, 8, 60));

        // ---- top: title + AM/FM toggle ----
        JLabel title = new JLabel("Select A Station", JLabel.CENTER);
        swapTypeButton = new JButton(curType);
        swapTypeButton.addActionListener(rc);
        swapTypeButton.setPreferredSize(new Dimension(100, 30));
        JPanel swapWrapper = new JPanel();
        swapWrapper.add(swapTypeButton);

        JPanel top = new JPanel(new BorderLayout());
        top.add(title, BorderLayout.NORTH);
        top.add(swapWrapper, BorderLayout.CENTER);

        stationList = new JPanel();
        stationList.setLayout(new BoxLayout(stationList, BoxLayout.Y_AXIS));
        stationList.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        stationListener = rc;

        // fill the list with the buttons for the current band
        updateStationList();

        JScrollPane scrl = new JScrollPane(stationList);
        scrl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        scrl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrl.getVerticalScrollBar().setUnitIncrement(16);

        // ---- bottom: selected station label + Configuration button ----
        label2 = new JLabel(STATION_TXT, JLabel.CENTER);
        JButton configButton = new JButton("Configuration");
        configButton.addActionListener(rc);
        JPanel configWrapper = new JPanel();
        configWrapper.add(configButton);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(label2, BorderLayout.NORTH);
        bottom.add(configWrapper, BorderLayout.CENTER);

        // ---- assemble everything into one grid ----
        // GridBagLayout so the scroll pane row can grow; a plain GridLayout
        // would force every row to the same height and squash the list.
        JPanel grid = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;

        c.gridy = 0; c.weighty = 0; grid.add(top, c);
        c.gridy = 1; c.weighty = 1; c.insets = new Insets(8, 0, 8, 0); grid.add(scrl, c);
        c.gridy = 2; c.weighty = 0; c.insets = new Insets(0, 0, 0, 0); grid.add(bottom, c);

        this.add(grid, BorderLayout.CENTER);
    }

    public static String getFullLink(String st, String type){
        return "http://playerservices.streamtheworld.com/api/livestream-redirect/" + st + type + ".mp3";
    }

    public static void changeStationSelection(String str){
        label2.setText(str);
    }
    public static void changeTypeButton(){
        if(curType.equals("AM")){
            curType = "FM";
        }else{
            curType = "AM";
        }

        swapTypeButton.setText(curType);
    }
    public static void updateStationList(){
        //clear out the old buttons
        stationList.removeAll();

        //add a button for each station in the current band
        Dimension stationSize = new Dimension(100, 32);
        for (String station : getStationList()) {
            stationList.add(Box.createRigidArea(new Dimension(0, 20)));

            JButton stationButton = new JButton(station);
            stationButton.setActionCommand("STATION_" + station);
            stationButton.addActionListener(stationListener);
            stationButton.setPreferredSize(stationSize);
            stationButton.setMaximumSize(stationSize);
            stationButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            stationList.add(stationButton);
        }

        //redraw the list with the new buttons
        stationList.revalidate();
        stationList.repaint();
    }
    public static String[] getStationList(){
        ArrayList<String> stationNames = new ArrayList<>();
        FileReader fr;
        try{
            fr = new FileReader(RadioTuner.STATIONS_FILE);
            BufferedReader br = new BufferedReader(fr);
            while(true){
                try{
                    String str = br.readLine();
                    if(str == null){
                        break;
                    }
                    //only keep stations that match the current band
                    String[] station = str.split("\\^");
                    if(station.length >= 2 && station[0].equals(curType)){
                        stationNames.add(station[1]);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        return stationNames.toArray(new String[0]);
    }
}
