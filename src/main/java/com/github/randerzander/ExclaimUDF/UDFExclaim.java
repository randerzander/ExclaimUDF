package com.github.randerzander.CurveUDFs;
 
import org.apache.hadoop.hive.ql.exec.UDF;

public final class UDFExclaim extends UDF {
  public String evaluate(String x) {
    return x + "!";
  }
}
