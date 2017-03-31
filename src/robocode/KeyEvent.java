package robocode;







public abstract class KeyEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  





  private final java.awt.event.KeyEvent source;
  






  public KeyEvent(java.awt.event.KeyEvent source)
  {
    this.source = source;
  }
  







  public java.awt.event.KeyEvent getSourceEvent()
  {
    return source;
  }
}
