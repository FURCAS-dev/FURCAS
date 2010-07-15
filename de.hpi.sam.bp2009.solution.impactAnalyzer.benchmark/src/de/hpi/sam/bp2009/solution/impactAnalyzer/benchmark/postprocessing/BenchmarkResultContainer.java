package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.postprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

public class BenchmarkResultContainer implements ResultContainer{
    private final ArrayList<BenchmarkResult> benchmarkResultList = new ArrayList<BenchmarkResult>();

    private final ArrayList<Double> sumList = new ArrayList<Double>();

    @Override
    public void addResult(BenchmarkResult benchResult){
	benchmarkResultList.add(benchResult);
    }

    @Override
    public int size(){
	return benchmarkResultList.size();
    }

    @Override
    public void printCsv(File f){
	createFileIfNeeded(f);

	try {
	    FileWriter fw = new FileWriter(f);

	    double sumList[] = null;
	    String csvString = "";
	    for(BenchmarkResult result : benchmarkResultList){
		csvString = result.toCsvString();
		fw.append(csvString + "; \n");

		sumList = addValuesToSum(sumList, csvString);

		fw.flush();
	    }

	     writeSumLine(fw, sumList, csvString);

	     fw.close();

	    System.out.println("CSV result was written to " + f.getAbsolutePath());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
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


    private double[] addValuesToSum(double[] sumList, String csvString) {
	String[] fieldList = csvString.split(";");
	for(int i = 0; i < fieldList.length; i++){
	    if(sumList == null) {
		sumList = new double[fieldList.length];
	    }
	    try{
		sumList[i] = sumList[i] + Double.parseDouble(fieldList[i]);
	    }catch(NumberFormatException e){
		// Ignore field
	    }
	}
	return sumList;
    }

    private void writeSumLine(FileWriter fw, double[] sumList, String csvString) throws IOException {
	String[] fieldList = csvString.split(";");

	StringBuffer buff = new StringBuffer();

	for(int i = 0; i < sumList.length; i++){
	    if(sumList[i] != 0){
		buff.append(sumList[i]);
	    }else{
		buff.append(fieldList[i]);
	    }
	    buff.append(";");
	}
	fw.append("Sum;\n" + buff.toString() + ";\n");

	System.out.println(buff.toString());

	for(String splt : buff.toString().split(";\\|\\|\\|;")){
	    try{
		fw.append(Double.parseDouble(splt) + ";\n");
	    }catch(NumberFormatException e){
		// Ignore field
		System.out.println("Cant parse " + splt);
	    }
	}


	fw.flush();
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
