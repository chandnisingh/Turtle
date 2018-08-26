/**
 * Copyright (c) 2015 DataTorrent, Inc.
 * All rights reserved.
 */
package com.turtle.debug;

import com.datatorrent.lib.appdata.gpo.GPOUtils;
import com.datatorrent.lib.io.fs.AbstractFileOutputOperator;

public class Writer extends AbstractFileOutputOperator<Double>
{
  private String fileName;

  public Writer()
  {
    fileName = "nazgul";
  }
  @Override
  protected String getFileName(Double aDouble)
  {
    return fileName;
  }

  @Override
  protected byte[] getBytesForTuple(Double aDouble)
  {
    return GPOUtils.serializeDouble(aDouble);
  }

  public String getFileName()
  {
    return fileName;
  }

  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }
}
