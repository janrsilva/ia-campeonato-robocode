package robocode;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import net.sf.robocode.core.ContainerBase;
import net.sf.robocode.security.IThreadManagerBase;
import robocode.exception.RobotException;



























public class RobocodeFileOutputStream
  extends OutputStream
{
  private final FileOutputStream out;
  private final String fileName;
  
  public RobocodeFileOutputStream(File file)
    throws IOException
  {
    this(file.getPath());
  }
  






  public RobocodeFileOutputStream(FileDescriptor fdObj)
  {
    throw new RobotException("Creating a RobocodeFileOutputStream with a FileDescriptor is not supported.");
  }
  





  public RobocodeFileOutputStream(String fileName)
    throws IOException
  {
    this(fileName, false);
  }
  





  public RobocodeFileOutputStream(String fileName, boolean append)
    throws IOException
  {
    this.fileName = fileName;
    
    IThreadManagerBase threadManager = (IThreadManagerBase)ContainerBase.getComponent(IThreadManagerBase.class);
    
    if (threadManager == null) {
      throw new RobotException("ThreadManager cannot be null!");
    }
    
    out = threadManager.createRobotFileStream(fileName, append);
  }
  





  public final void close()
    throws IOException
  {
    out.close();
  }
  





  public final void flush()
    throws IOException
  {
    out.flush();
  }
  




  public final String getName()
  {
    return fileName;
  }
  






  public final void write(byte[] b)
    throws IOException
  {
    out.write(b);
  }
  






  public final void write(byte[] b, int off, int len)
    throws IOException
  {
    out.write(b, off, len);
  }
  






  public final void write(int b)
    throws IOException
  {
    out.write(b);
  }
}
