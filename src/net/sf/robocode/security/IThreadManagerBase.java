package net.sf.robocode.security;

import java.io.FileOutputStream;
import java.io.IOException;

public abstract interface IThreadManagerBase
{
  public abstract boolean isSafeThread();
  
  public abstract FileOutputStream createRobotFileStream(String paramString, boolean paramBoolean)
    throws IOException;
}
