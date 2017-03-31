package net.sf.robocode.util;










public class UrlUtil
{
  public UrlUtil() {}
  









  public static String removeFileExtension(String fileName)
  {
    if (fileName != null) {
      int index = fileName.lastIndexOf('.');
      if ((index > 0) && (index < fileName.length() - 1)) {
        return fileName.substring(0, index);
      }
    }
    return fileName;
  }
}
