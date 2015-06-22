A very simple example Hive UDF project.

```
mvn clean package
```

```
[randy@dev ExclaimUDF]$ hive
15/06/22 14:24:33 WARN conf.HiveConf: HiveConf of name hive.server2.enable.impersonation does not exist

Logging initialized using configuration in file:/etc/hive/conf/hive-log4j.properties
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/usr/hdp/2.2.4.0-2633/hadoop/lib/slf4j-log4j12-1.7.5.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/usr/hdp/2.2.4.0-2633/hive/lib/hive-jdbc-0.14.0.2.2.4.0-2633-standalone.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.slf4j.impl.Log4jLoggerFactory]
hive> add jar /home/randy/curveudfs/target/CurveUDFs-0.1.0-SNAPSHOT.jar;                                                  
Added [/home/randy/ExclaimUDF/target/ExclaimUDF-0.1.0-SNAPSHOT.jar] to class path
Added resources: [/home/randy/ExclaimUDF/target/ExclaimUDF-0.1.0-SNAPSHOT.jar]
hive> create temporary function exclaim as 'com.github.randerzander.ExclaimUDF.UDFExclaim';                                
OK
Time taken: 1.806 seconds
hive> describe cdr;
OK
session_id          string                                  
sim_card_id        string                                  
phone_number        string                                  
record_opening_time string                                  
duration            string                                  
cell_id            string                                  
network_type        string                                  
drop_reason        string                                  
Time taken: 0.449 seconds, Fetched: 8 row(s)
hive> select * from cdr limit 1;
OK
rnd-f7bea1a8-a514-4c59-8d61-c3983429a76b SIM-00010 PHONE-00001 15/05/2015 06:41:20 15461 cell E 1 REASON 3
Time taken: 1.108 seconds, Fetched: 1 row(s)
hive> select exclaim(sim_card_id) from cdr limit 1;
OK
SIM-00010!
Time taken: 0.47 seconds, Fetched: 1 row(s)
hive>
```
