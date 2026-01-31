import org.code.theater.*;
import org.code.media.*;

public class LastYear extends Scene {
  private String backgroundImage;
  private String[] images;

  public LastYear(String backgroundImage, String[] images){
    this.backgroundImage =  backgroundImage;
    this.images = images;
    
  }

  public void  drawScene() {
    drawImage(backgroundImage, 0, 0, 400, 400, 0);
    drawCaptionBox(50, 300, 300, 50);
    drawStack();
  }

  /**
   * Draws a white box with a shadow to display text
   */
  public void drawCaptionBox(int xPos, int yPos, int width, int height) {
    // shadow box, 5px offset
    setFillColor("black");
    drawRectangle(xPos + 5, yPos + 5, width, height);
    
    // front box
    setFillColor("white");
    drawRectangle(xPos, yPos, width, height);

    // text style (adjust to fit style/size)
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("black");
    int fontSize = 24;
    setTextHeight(fontSize);

    // drawing text (adjust offsets)
    int xLinePos = xPos + 10;
    int yLinePos = yPos + fontSize;
    drawText("Friends", xLinePos, yLinePos);
  }

  /**
   * Creates a "stacking" animations with random angle rotations
   * of the image.
   */
  public void drawStack() {
    int centerX = 200;  // center of the stack
    int centerY = 150;  // center of the stack
    int size = 200;
    
    for (String image : images) {
      // choose a random degree to rotate (0-45)
      int angle = (int) (Math.random() * 46);
      // if odd angle, rotate other direction
      if (angle % 2 == 1) {
        angle = (-1) * angle;
      }
      double dAngle = (double) angle;
      
      // calculate position for center-based rotation
      // standard 2D rotation: 
      // newX = x * cos(angle) - y * sin(angle)
      // newY = x * sin(angle) + y * cos(angle)
      double radians = Math.toRadians(dAngle);
      double halfSize = size / 2.0;
      int adjustedX = (int)(centerX - (halfSize * Math.cos(radians) - halfSize * Math.sin(radians)));
      int adjustedY = (int)(centerY - (halfSize * Math.sin(radians) + halfSize * Math.cos(radians)));
      
      // image on top of black boarder (if drawn)
      drawImage(image, adjustedX, adjustedY, size, dAngle);
      pause(1);
    }
  }


  
}