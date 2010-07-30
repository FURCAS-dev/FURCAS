package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public abstract class Writer {
    protected java.io.Writer writer;

    protected static final String BREAK = System.getProperty("line.separator");


    public Writer(String path, boolean append) {
    	File f = new File(path);
    	createFileIfNeeded(f);
    	OutputStream os = null;

    	try {
    		os = new FileOutputStream(f, append);
    		writer = new BufferedWriter(new OutputStreamWriter(os), 1000000);
    	} catch (FileNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

    protected void createFileIfNeeded(File f) {
    	if(!f.exists()){
    	    try {
    		f.getParentFile().mkdirs();
    	    	f.createNewFile();
    	    } catch (IOException e) {
    		e.printStackTrace();
    	    }
    	}
   }

	public synchronized void close(){
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
