package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.PrintWriter;
import java.util.HashMap;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.OutputOptions;

public class ExceptionDumpWriter extends Writer {

    public ExceptionDumpWriter() {
    	super(OutputOptions.getExceptionDumpFilePath());
    }

    public void writeDump(HashMap<String, Throwable> dumpList){
	for(String key : dumpList.keySet()){
	    System.out.println(key);
	    PrintWriter printWriter = new PrintWriter(writer);
	    dumpList.get(key).printStackTrace(printWriter);
	    printWriter.flush();
	}
    }
}
