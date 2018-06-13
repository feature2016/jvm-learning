#echo off

rem  default
rem java -Dcom.sun.btrace.probeDescPath=. -Dcom.sun.btrace.dumpClasses=false -Dcom.sun.btrace.debug=false -Dcom.sun.btrace.unsafe=false -cp "%BTRACE_HOME%/build/btrace-client.jar;%JAVA_HOME%/lib/tools.jar" com.sun.btrace.client.Main %*java -Dcom.sun.btrace.probeDescPath=. -Dcom.sun.btrace.dumpClasses=false -Dcom.sun.btrace.debug=false -Dcom.sun.btrace.unsafe=false -cp "%BTRACE_HOME%/build/btrace-client.jar;%JAVA_HOME%/lib/tools.jar" com.sun.btrace.client.Main %*

rem agent
rem java -javaagent:btrace-agent.jar=script=<pre-compiled-btrace-script1>[,<pre-compiled-btrace-script1>]* <MainClass> <AppArguments>

rem personal
java -Dcom.sun.btrace.unsafe=true -cp "%BTRACE_HOME%/build/btrace-client.jar;%JAVA_HOME%/lib/tools.jar;%cd%/target/classes" com.sun.btrace.client.Main %*
