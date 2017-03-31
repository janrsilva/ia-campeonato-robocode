package net.sf.robocode.repository;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;












public final class CodeSizeCalculator
{
  public CodeSizeCalculator() {}
  
  public static Integer getDirectoryCodeSize(File dir)
  {
    return getCodeSize("processDirectory", dir);
  }
  
  public static Integer getJarFileCodeSize(File jarFile) {
    return getCodeSize("processZipFile", jarFile);
  }
  
  private static Integer getCodeSize(String invokeMethod, File jarFile)
  {
    Integer codesize;
    try {
      Class<?> classType = Class.forName("codesize.Codesize");
      
      Method method = classType.getMethod(invokeMethod, new Class[] { File.class });
      Object item = method.invoke(null, new Object[] { jarFile });
      

      method = item.getClass().getMethod("getCodeSize", (Class[])null);
      codesize = (Integer)method.invoke(item, (Object[])null);
    }
    catch (IllegalAccessException e) {
      codesize = null;
    } catch (InvocationTargetException e) {
      codesize = null;
    } catch (NoSuchMethodException e) {
      codesize = null;
    } catch (ClassNotFoundException e) {
      codesize = null;
    }
    return codesize;
  }
}
