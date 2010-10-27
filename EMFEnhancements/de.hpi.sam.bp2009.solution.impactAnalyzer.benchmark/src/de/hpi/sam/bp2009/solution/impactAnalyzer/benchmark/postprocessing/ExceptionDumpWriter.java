package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.PathOptions;

public class ExceptionDumpWriter extends Writer {

    public ExceptionDumpWriter() throws IOException {
    	super(PathOptions.getExceptionDumpFilePath(), false);
    }

    public void writeDump(HashMap<String, Throwable> dumpList){
	for(String key : dumpList.keySet()){
	    try {
		writer.write(key + BREAK);
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    PrintWriter printWriter = new PrintWriter(writer);
	    dumpList.get(key).printStackTrace(printWriter);
	    printWriter.flush();
	}
    }
}
