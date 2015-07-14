/**
 * Put your copyright and license info here.
 */
package com.turtle.debug;

import org.apache.hadoop.conf.Configuration;

import com.datatorrent.api.annotation.ApplicationAnnotation;
import com.datatorrent.api.StreamingApplication;
import com.datatorrent.api.DAG;
import com.datatorrent.api.DAG.Locality;
import com.datatorrent.lib.io.ConsoleOutputOperator;

@ApplicationAnnotation(name="Lease")
public class Application implements StreamingApplication
{

  @Override
  public void populateDAG(DAG dag, Configuration conf)
  {
    RandomNumberGenerator randomGenerator = dag.addOperator("RandomGenerator", RandomNumberGenerator.class);
    randomGenerator.setNumTuples(500);

    Writer writer = dag.addOperator("Writer", new Writer());

    dag.addStream("randomData", randomGenerator.out, writer.input);
  }
}
