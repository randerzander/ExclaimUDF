package com.github.randerzander.ExclaimUDF;
 
import org.apache.hadoop.hive.ql.exec.UDF;

public final class UDFExclaim extends UDF {
  public String evaluate(String x) {
    return x + "!";
  }
}
