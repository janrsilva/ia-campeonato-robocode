package robocode.robocodeGL;

import gl4java.GLFont;
import gl4java.GLFunc;














public abstract class RenderElement
{
  public static void init(GLFont glf) {}
  
  public RenderElement() {}
  
  public synchronized void addLabel(LabelGL l) {}
  
  public synchronized void removeLabel(LabelGL l) {}
  
  public synchronized void remove() {}
  
  public synchronized boolean isRemoved()
  {
    return false;
  }
  
  public synchronized void drawStrings(GLFunc gl) {}
  
  public abstract void draw(GLFunc paramGLFunc);
  
  public float getStringX() {
    return 0.0F;
  }
  
  public float getStringY() {
    return 0.0F;
  }
}
