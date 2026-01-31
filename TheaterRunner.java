import org.code.theater.*;

public class TheaterRunner {
  public static void main(String[] args) {
    
    String[] images = FileReader.toStringArray("imageStack.txt");
    String backgroundImage = "Screenshot-2026-01-16-132957.png";
    
      LastYear lastYear = new LastYear(backgroundImage, images);
    
    lastYear.drawScene();

    Theater.playScenes(lastYear);
  }
}