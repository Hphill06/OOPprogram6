package program6;



import java.io.FileInputStream;
import java.net.URL;
import java.io.*;

import javazoom.jl.player.Player;

public class JavaStreaming
{
  protected String url;
  protected Player player;

  public JavaStreaming()
  {
    // TODO Auto-generated constructor stub
  }

  public void setURL(String url)
  {
    this.url = url;
  }

  public void play()
  {
    try {
      // Replace with your streaming audio URL
      String streamUrl = this.url;

      URL url = new URL(streamUrl);
      InputStream inputStream = url.openStream();

      // Create a Player instance with the InputStream
      player = new Player(inputStream);

      // Start playing the stream in a new thread
      new Thread(() -> {
        try {
          player.play();


        } catch (Exception e) {
          e.printStackTrace();
        }
      }).start();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void close()
  {
    player.close();
  }


/**
 * @param args
 */


}

