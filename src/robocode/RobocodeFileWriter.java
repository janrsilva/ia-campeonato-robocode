package robocode;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStreamWriter;































public class RobocodeFileWriter
  extends OutputStreamWriter
{
  public RobocodeFileWriter(File file)
    throws IOException
  {
    super(new RobocodeFileOutputStream(file));
  }
  







  public RobocodeFileWriter(FileDescriptor fd)
  {
    super(new RobocodeFileOutputStream(fd));
  }
  







  public RobocodeFileWriter(String fileName)
    throws IOException
  {
    super(new RobocodeFileOutputStream(fileName));
  }
  








  public RobocodeFileWriter(String fileName, boolean append)
    throws IOException
  {
    super(new RobocodeFileOutputStream(fileName, append));
  }
}
