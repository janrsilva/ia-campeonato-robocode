package net.sf.robocode.io;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;













public class FileUtil
{
  private static File cwd;
  
  static
  {
    try
    {
      String wd = System.getProperty("WORKINGDIRECTORY", "");
      
      setCwd(new File(wd));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  




  public static File getCwd()
  {
    return cwd;
  }
  




  public static void setCwd(File cwd)
    throws IOException
  {
    cwd = cwd.getCanonicalFile();
  }
  






  public static String getFileType(File file)
  {
    return getFileType(file.getName());
  }
  






  public static String getFileType(String fileName)
  {
    int lastdot = fileName.lastIndexOf('.');
    
    return lastdot < 0 ? "" : fileName.substring(lastdot);
  }
  






  public static String quoteFileName(String filename)
  {
    if ((filename.startsWith("\"")) && (filename.endsWith("\""))) {
      return filename;
    }
    if ((System.getProperty("os.name").toLowerCase().startsWith("windows")) && (filename.startsWith("file://"))) {
      filename = filename.substring(7);
    }
    if (filename.matches(".*\\s+?.*")) {
      return '"' + filename + '"';
    }
    return filename;
  }
  





  public static void copy(File srcFile, File destFile)
    throws IOException
  {
    if (srcFile.equals(destFile)) {
      throw new IOException("You cannot copy a file onto itself");
    }
    
    byte[] buf = new byte['က'];
    
    FileInputStream in = null;
    FileOutputStream out = null;
    try
    {
      in = new FileInputStream(srcFile);
      out = new FileOutputStream(destFile);
      
      while (in.available() > 0) {
        out.write(buf, 0, in.read(buf, 0, buf.length));
      }
    } finally {
      if (in != null) {
        in.close();
      }
      if (out != null) {
        out.close();
      }
    }
  }
  





  public static boolean deleteDir(File dir)
  {
    if (dir.isDirectory()) {
      for (File file : dir.listFiles()) {
        if (file.isDirectory())
        {
          try
          {
            if (file.getCanonicalFile().getParentFile().equals(dir.getCanonicalFile())) {
              deleteDir(file);
              if ((file.exists()) && (!file.delete())) {
                Logger.logError("Cannot delete: " + file);
              }
            } else {
              Logger.logWarning(file + " may be a symlink. Ignoring.");
            }
          } catch (IOException e) {
            Logger.logWarning("Cannot determine canonical file for " + file + ". Ignoring.");
          }
          
        } else if ((file.exists()) && (!file.delete())) {
          Logger.logError("Cannot delete: " + file);
        }
      }
      
      return dir.delete();
    }
    return false;
  }
  





  public static File createDir(File dir)
  {
    if ((dir != null) && (!dir.exists()) && 
      (!dir.mkdir())) {
      Logger.logError("Cannot create dir: " + dir);
    }
    
    return dir;
  }
  





  public static String getClassName(String fileName)
  {
    int lastdot = fileName.lastIndexOf('.');
    
    if (lastdot < 0) {
      return fileName;
    }
    if (fileName.length() - 1 == lastdot) {
      return fileName.substring(0, fileName.length() - 1);
    }
    return fileName.substring(0, lastdot);
  }
  




  public static File getRobotsDir()
  {
    String robotPath = System.getProperty("ROBOTPATH");
    File file;
    File file;
    if (robotPath != null) {
      file = new File(robotPath);
    } else {
      file = new File(cwd, "/robots");
    }
    return createDir(file);
  }
  




  public static File getRobotDatabaseFile()
  {
    return new File(getRobotsDir(), "/robot.database");
  }
  




  public static File getRobotsDataDir()
  {
    return createDir(new File(getRobotsDir(), "/.data/"));
  }
  




  public static File getBattlesDir()
  {
    return createDir(new File(cwd, "/battles"));
  }
  





  public static File getConfigDir()
  {
    return createDir(new File(cwd, "/config"));
  }
  





  public static File getScreenshotsDir()
  {
    return createDir(new File(cwd, "/screenshots"));
  }
  




  public static File getRobocodeConfigFile()
  {
    return new File(getConfigDir(), "robocode.properties");
  }
  




  public static File getWindowConfigFile()
  {
    return new File(getConfigDir(), "window.properties");
  }
  




  public static File getCompilerConfigFile()
  {
    return new File(getConfigDir(), "compiler.properties");
  }
  




  public static File getEditorConfigFile()
  {
    return new File(getConfigDir(), "editor.properties");
  }
  




  public static File getEditorThemeConfigDir()
  {
    return createDir(new File(cwd, "/theme/editor"));
  }
  




  public static void cleanupStream(Object stream)
  {
    if (stream == null) {
      return;
    }
    if ((stream instanceof Flushable)) {
      try {
        ((Flushable)stream).flush();
      } catch (IOException e) {
        Logger.logError(e);
      }
    }
    if ((stream instanceof Closeable)) {
      try {
        ((Closeable)stream).close();
      } catch (IOException e) {
        Logger.logError(e);
      }
    }
  }
  





  public static boolean isFilenameValid(String file)
  {
    File f = new File(file);
    try {
      f.getCanonicalPath();
      return true;
    } catch (IOException e) {}
    return false;
  }
  
  public FileUtil() {}
}
