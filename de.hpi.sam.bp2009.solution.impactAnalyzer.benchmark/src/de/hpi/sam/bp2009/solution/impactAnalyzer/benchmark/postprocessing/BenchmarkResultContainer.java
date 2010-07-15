package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class BenchmarkResultContainer implements ResultContainer{
    private final ArrayList<BenchmarkResult> benchmarkResultList = new ArrayList<BenchmarkResult>();

    @Override
    public void addResult(BenchmarkResult benchResult){
	benchmarkResultList.add(benchResult);
    }

    @Override
    public int size(){
	return benchmarkResultList.size();
    }

    public void printDataSet(File f){
	createFileIfNeeded(f);

	try{
	    OutputStream os = new FileOutputStream(f);

	    boolean firstResult = true;
	    int lineOffset = 1;
	    for(BenchmarkResult result : benchmarkResultList){
		lineOffset = result.writeDataSet(os, firstResult, lineOffset);
		firstResult = false;
		os.flush();
	    }
	    os.close();

	}catch(IOException e){
	    System.out.println("Can't write Data Set");
	    e.printStackTrace();
	}
    }

    private void createFileIfNeeded(File f) {
	if(!f.exists()){
	    try {
		f.getParentFile().mkdirs();
	    	f.createNewFile();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }

}
