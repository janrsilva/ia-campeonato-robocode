package robocode;

import java.io.PrintStream;





































public abstract class Condition
{
  public int priority = 80;
  



  public String name;
  




  public Condition() {}
  




  public Condition(String name)
  {
    this.name = name;
  }
  







  public Condition(String name, int priority)
  {
    this.name = name;
    if (priority < 0) {
      System.out.println("SYSTEM: Priority must be between 0 and 99.");
      System.out.println("SYSTEM: Priority for condition " + name + " will be 0.");
      priority = 0;
    } else if (priority > 99) {
      System.out.println("SYSTEM: Priority must be between 0 and 99.");
      System.out.println("SYSTEM: Priority for condition " + name + " will be 99.");
      priority = 99;
    }
    this.priority = priority;
  }
  




  public String getName()
  {
    return name != null ? name : getClass().getName();
  }
  






  public final int getPriority()
  {
    return priority;
  }
  




  public void setName(String newName)
  {
    name = newName;
  }
  






  public void setPriority(int newPriority)
  {
    priority = newPriority;
  }
  
  public abstract boolean test();
  
  public void cleanup() {}
}
