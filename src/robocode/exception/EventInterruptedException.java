package robocode.exception;






public class EventInterruptedException
  extends Error
{
  private static final long serialVersionUID = 1L;
  




  private int priority = Integer.MIN_VALUE;
  
  public EventInterruptedException(int priority) {
    this.priority = priority;
  }
  
  public int getPriority() {
    return priority;
  }
}
