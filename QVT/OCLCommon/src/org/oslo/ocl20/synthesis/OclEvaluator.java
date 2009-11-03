package org.oslo.ocl20.synthesis;

import java.util.Map;

import org.oslo.ocl20.semantics.model.contexts.ContextDeclaration;
import org.oslo.ocl20.standard.lib.OclAny;

import uk.ac.kent.cs.kmf.util.ILog;

/**
 * 
 * @author Octavian Patrascoiu
 *
 */
public interface OclEvaluator {
	/** Evaluate contexts into a specific environment */
	public Map evaluate(ContextDeclaration context, RuntimeEnvironment renv);

	/** Evaluate contexts into a specific environment */
	public Map evaluate(ContextDeclaration context, RuntimeEnvironment renv, ILog log);
    public OclAny evaluateAsOCL(ContextDeclaration decl, RuntimeEnvironment renv, ILog log);

}
