package robocode;







public abstract class MouseEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  





  private final java.awt.event.MouseEvent source;
  






  public MouseEvent(java.awt.event.MouseEvent source)
  {
    this.source = source;
  }
  







  public java.awt.event.MouseEvent getSourceEvent()
  {
    return source;
  }
}
