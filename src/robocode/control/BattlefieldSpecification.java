package robocode.control;

import java.io.Serializable;



















public class BattlefieldSpecification
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final int width;
  private final int height;
  
  public BattlefieldSpecification()
  {
    this(800, 600);
  }
  






  public BattlefieldSpecification(int width, int height)
  {
    if ((width < 400) || (width > 5000)) {
      throw new IllegalArgumentException("width must be: 400 <= width <= 5000");
    }
    if ((height < 400) || (height > 5000)) {
      throw new IllegalArgumentException("height must be: 400 <= height <= 5000");
    }
    
    this.width = width;
    this.height = height;
  }
  




  public int getWidth()
  {
    return width;
  }
  




  public int getHeight()
  {
    return height;
  }
}
