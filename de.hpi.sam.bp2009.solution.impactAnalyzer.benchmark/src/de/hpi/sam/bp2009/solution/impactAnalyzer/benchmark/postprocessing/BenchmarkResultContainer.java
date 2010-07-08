package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

public class BenchmarkResultContainer {
    private ArrayList<BenchmarkResult> benchmarkResultList = new ArrayList<BenchmarkResult>();
    
    public void addResult(BenchmarkResult benchResult){
	benchmarkResultList.add(benchResult);
    }
    
    public int size(){
	return benchmarkResultList.size();
    }
    
    public void printCsv(File f){
	if(!f.exists()){
	    try {
		f.getParentFile().mkdirs();
	    	f.createNewFile();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	
	try {
	    FileWriter fw = new FileWriter(f);
	    for(BenchmarkResult result : benchmarkResultList){
		fw.append(result.toCsvString() + "; \n");
		fw.flush();
		System.out.println("written");
	    }
	    fw.close();
	    
	    System.out.println("Results were written to " + f.getAbsolutePath());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	    
    }

	public void printXml(File file) {
		XStream xstream = new XStream();
		FileOutputStream fstream;
		
		try {	
			file.createNewFile();
			fstream = new FileOutputStream(file);
			xstream.toXML(this, fstream);
			fstream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println("Results were written to " + file.getAbsolutePath());
	}
    
    
}
