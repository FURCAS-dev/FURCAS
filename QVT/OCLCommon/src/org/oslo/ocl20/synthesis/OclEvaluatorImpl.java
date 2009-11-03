package org.oslo.ocl20.synthesis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.model.contexts.ContextDeclaration;
import org.oslo.ocl20.standard.lib.OclAny;

import uk.ac.kent.cs.kmf.util.ILog;
import uk.ac.kent.cs.kmf.util.OutputStreamLog;

/**
 * 
 * @author Octavian Patrascoiu
 *
 */

public class OclEvaluatorImpl
	implements OclEvaluator 
{
	/** Constructor */
	public OclEvaluatorImpl(OclProcessor processor, OclEvaluatorVisitorImpl evaluator) {
		this.processor = processor;
		this.evaluator = evaluator;
	}

	protected OclProcessor processor;
	protected OclEvaluatorVisitorImpl evaluator;
	
	/** Input semantic tree */
	protected ContextDeclaration decl;
	
	/** Runtime environment */
	protected RuntimeEnvironment renv;
	
	/** Log file */
	protected ILog log;
	
	
	/** Evaluate contexts into the semantic and runtime environment */
	protected Map evaluate() {
		//--- Check evaluation context ---
		if (decl == null) return null;
		if (renv == null) {
			renv = new RuntimeEnvironmentImpl();
		}
		//if (renv.getValue("self") == null) {
		//	renv.setValue("self", processor.getStdLibAdapter().Undefined());
		//}
		
		
		if (log == null) log = new OutputStreamLog(System.out);
		
		//--- Create the context for the evalution --- 
		Map data = new HashMap();
		data.put("env", renv);
		data.put("log", log);

		//--- Evaluate the input ---
		Map result = (Map)decl.accept(evaluator, data);
		Iterator i = result.entrySet().iterator();
		while(i.hasNext()) {
		    Map.Entry me = (Map.Entry)i.next();
		    if (me.getValue() instanceof OclAny)
		        me.setValue( ((OclAny)me.getValue()).asJavaObject() );
		}
		
		//--- Return result ---
		return result;
	}
	
	/** Evaluate contexts into the semantic and runtime environment */
	public Map evaluate(ContextDeclaration decl, RuntimeEnvironment renv) {
		//--- Set local variables ---
		this.decl = decl;
		this.renv = renv;
		this.log = new OutputStreamLog(System.out);
		
		//--- Evaluate ---
		return evaluate();
	}

	/** Evaluate contexts into the semantic and runtime environment */
	public Map evaluate(ContextDeclaration decl) {
		//--- Set local variables ---
		this.decl = decl;
		this.renv = new RuntimeEnvironmentImpl();
		renv.setValue("self", null);
		this.log = new OutputStreamLog(System.out);
		
		//--- Evaluate ---
		return evaluate();
	}

	/** Evaluate contexts into the semantic and runtime environment */
	public Map evaluate(ContextDeclaration decl, RuntimeEnvironment renv, ILog log) {
		//--- Set local variables ---
		this.decl = decl;
		this.renv = renv;
		this.log = log;
		
		//--- Evaluate ---
		return evaluate();
	}
	
    public OclAny evaluateAsOCL(ContextDeclaration decl, RuntimeEnvironment renv, ILog log) {
		//--- Check evaluation context ---
		if (decl == null) return null;
		if (renv == null) {
			renv = new RuntimeEnvironmentImpl();
		}
		//if (renv.getValue("self") == null) {
		//	renv.setValue("self", processor.getStdLibAdapter().Undefined());
		//}
		if (log == null) log = new OutputStreamLog(System.out);
		
		//--- Create the context for the evalution --- 
		Map data = new HashMap();
		data.put("env", renv);
		data.put("log", log);

		//--- Evaluate the input ---
		Map map = (Map)decl.accept(evaluator, data);
		OclAny result = null;
		Iterator i = map.entrySet().iterator();
		if(i.hasNext()) {
		    Map.Entry me = (Map.Entry)i.next();
		    result = (OclAny)me.getValue();
		}
		
		//--- Return result ---
		return result;
	}
}
