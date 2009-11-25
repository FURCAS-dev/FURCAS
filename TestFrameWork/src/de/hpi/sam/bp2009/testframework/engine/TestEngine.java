/**
 * 
 */
package de.hpi.sam.bp2009.testframework.engine;


import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

import org.eclipse.emf.ecore.resource.Resource;

import de.hpi.sam.bp2009.testframework.generator.dynamicemf.Generator;
import de.hpi.sam.bp2009.testframework.operator.Operator;
import de.hpi.sam.bp2009.testframework.result.Result;
import de.hpi.sam.bp2009.testframework.OptionObject;

public class TestEngine {

	public static String usage(){
		return "";
	}


	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		new TestEngine().runTest();
	}


	private void runTest() throws InstantiationException,
	IllegalAccessException, ClassNotFoundException,
	InvocationTargetException, NoSuchMethodException {
		String genName ="de.hpi.sam.bp2009.testframework.generator.dynamicemf.ModelGenerator";
		String opName = "de.hpi.sam.bp2009.testframework.operator.OclOperator";
		String resultName = "de.hpi.sam.bp2009.testframework.result.ConsolPrint";
		int runs=20;

		System.out.println(usage());

		Generator gen = (Generator)Class.forName(genName).newInstance();
		Operator op = (Operator)Class.forName(opName).newInstance();
		Result result = (Result)Class.forName(resultName).newInstance();

		Object optObjGen=gen.getOptionObjectClass().getDeclaredMethod("defaultValue").invoke(null);
		Resource resource = gen.generate(optObjGen);
		Object optObjOp=op.getOptionObjectClass().getDeclaredMethod("defaultValue").invoke(null);

		for(int i=0;i<runs;i++){
			MemoryAnalyser memA=new MemoryAnalyser(this);
			memA.start();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long timeBegin = System.nanoTime();

			Resource resourceAfterExec=null;
			try {
				resourceAfterExec= op.execute(resource, optObjOp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long timeEnd = System.nanoTime();

			memA.stop();
			LinkedHashMap<Long, Long> memoryUsage = memA.getResults();

			result.add(resourceAfterExec, optObjGen, optObjOp, timeEnd-timeBegin, memoryUsage);
		}
		result.show();
	}


}
