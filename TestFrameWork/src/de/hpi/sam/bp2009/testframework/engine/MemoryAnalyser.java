/**
 * 
 */
package de.hpi.sam.bp2009.testframework.engine;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author tobias.hoppe
 *
 */
public class MemoryAnalyser extends Thread {

	TestEngine engine;
	LinkedHashMap<Long, Long>results= new LinkedHashMap<Long, Long>();
	public MemoryAnalyser(TestEngine e){
		engine = e;
	}

	public void run(){
		
		do {
			System.gc();
			System.gc();
			System.gc();
			System.gc();
			System.gc();
			System.gc();
			System.gc();
			System.gc();
			System.gc();
			System.gc();
			System.gc();
			System.gc();
			System.gc();
			System.gc();
			System.gc();
			System.gc();
			long time = System.nanoTime();
			long mem0 = Runtime.getRuntime().totalMemory()
					- Runtime.getRuntime().freeMemory();
			results.put(time, mem0);
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
		
	}

	public LinkedHashMap<Long, Long> getResults() {
		return this.results;
	}
}
