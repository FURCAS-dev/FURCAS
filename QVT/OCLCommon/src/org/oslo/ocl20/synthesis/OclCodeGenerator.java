package org.oslo.ocl20.synthesis;

import java.util.List;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.model.contexts.Constraint;
import org.oslo.ocl20.semantics.model.contexts.ContextDeclaration;
import org.oslo.ocl20.semantics.model.expressions.OclExpression;
import org.oslo.ocl20.standard.lib.OclAny;


/**
 * 
 * @author Octavian Patrascoiu
 *
 */

public interface OclCodeGenerator {
	/** 
	 *  Generate code for an Ocl Expression and returns a Pair containing: 
	 *   1. the name of the variable that holds the result or a constant expression
	 *   2. the generated code
	 *  
	 **/
	public OclAny generate(OclExpression con, String indent, OclProcessor processor);

	/** 
	 *  Generate code for an Ocl Constraint and returns a Pair containing: 
	 *   1. the name of the variable that holds the result or a constant expression
	 *   2. the generated code
	 *  
	 **/
	public OclAny generate(Constraint con, String indent, OclProcessor processor);

	/** 
	 *  Generate code for an Ocl Constraint and returns a List of Pairs containing: 
	 *   1. the name of the variable that holds the result or a constant expression
	 *   2. the generated code
	 *  
	 **/
	public List generate(ContextDeclaration decl, String indent, OclProcessor processor);
}
