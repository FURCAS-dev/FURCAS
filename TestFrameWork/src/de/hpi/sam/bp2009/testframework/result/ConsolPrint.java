package de.hpi.sam.bp2009.testframework.result;


import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.resource.Resource;

public class ConsolPrint implements Result {

	@Override
	public boolean add(Resource resource, Object generatorOptions,
			Object operatorOptions, long time,
			LinkedHashMap<Long, Long> memoryUsage) {
		
		System.out.println("executiontime: " +time);
		for(Entry<Long, Long>entry: memoryUsage.entrySet()){
			System.out.println("time: " + entry.getKey() +" memory: " + entry.getValue());
		}
		return false;
	}

	@Override
	public void show() {
		System.out.println("Finished!!!");

	}

}
