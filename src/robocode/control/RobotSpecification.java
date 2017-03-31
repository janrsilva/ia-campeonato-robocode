package robocode.control;

import java.io.File;
import java.io.Serializable;
import net.sf.robocode.security.IHiddenSpecificationHelper;
















public class RobotSpecification
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final Object fileSpecification;
  private final String name;
  private final String author;
  private final String webpage;
  private final String version;
  private final String robocodeVersion;
  private final String jarFile;
  private final String fullClassName;
  private final String description;
  private String teamId;
  
  private RobotSpecification(Object fileSpecification, String name, String author, String webpage, String version, String robocodeVersion, String jarFile, String fullClassName, String description)
  {
    this.fileSpecification = fileSpecification;
    this.name = name;
    this.author = author;
    this.webpage = webpage;
    this.version = version;
    this.robocodeVersion = robocodeVersion;
    this.jarFile = jarFile;
    this.fullClassName = fullClassName;
    this.description = description;
  }
  






  public String getName()
  {
    return name;
  }
  






  public String getVersion()
  {
    return version;
  }
  







  public String getNameAndVersion()
  {
    String nameAndVersion = getName();
    String version = getVersion();
    
    if ((version != null) && (version.trim().length() > 0)) {
      nameAndVersion = nameAndVersion + ' ' + version.trim();
    }
    return nameAndVersion;
  }
  




  public String getClassName()
  {
    return fullClassName;
  }
  






  public File getJarFile()
  {
    return new File(jarFile);
  }
  




  public String getDescription()
  {
    return description;
  }
  




  public String getRobocodeVersion()
  {
    return robocodeVersion;
  }
  




  public String getWebpage()
  {
    return webpage;
  }
  




  public String getAuthorName()
  {
    return author;
  }
  




  public String getTeamId()
  {
    return teamId != null ? teamId : getNameAndVersion();
  }
  
  static IHiddenSpecificationHelper createHiddenHelper() {
    return new HiddenHelper(null);
  }
  
  private static class HiddenHelper implements IHiddenSpecificationHelper {
    private HiddenHelper() {}
    
    public RobotSpecification createSpecification(Object fileSpecification, String name, String author, String webpage, String version, String robocodeVersion, String jarFile, String fullClassName, String description) { return new RobotSpecification(fileSpecification, name, author, webpage, version, robocodeVersion, jarFile, fullClassName, description, null); }
    

    public Object getFileSpecification(RobotSpecification specification)
    {
      return fileSpecification;
    }
    
    public void setTeamName(RobotSpecification specification, String teamName) {
      teamId = teamName;
    }
    
    public String getTeamName(RobotSpecification specification) {
      return teamId;
    }
  }
}
