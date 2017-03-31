package robocode.robotinterfaces;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public abstract interface IInteractiveEvents
{
  public abstract void onKeyPressed(KeyEvent paramKeyEvent);
  
  public abstract void onKeyReleased(KeyEvent paramKeyEvent);
  
  public abstract void onKeyTyped(KeyEvent paramKeyEvent);
  
  public abstract void onMouseClicked(MouseEvent paramMouseEvent);
  
  public abstract void onMouseEntered(MouseEvent paramMouseEvent);
  
  public abstract void onMouseExited(MouseEvent paramMouseEvent);
  
  public abstract void onMousePressed(MouseEvent paramMouseEvent);
  
  public abstract void onMouseReleased(MouseEvent paramMouseEvent);
  
  public abstract void onMouseMoved(MouseEvent paramMouseEvent);
  
  public abstract void onMouseDragged(MouseEvent paramMouseEvent);
  
  public abstract void onMouseWheelMoved(MouseWheelEvent paramMouseWheelEvent);
}
