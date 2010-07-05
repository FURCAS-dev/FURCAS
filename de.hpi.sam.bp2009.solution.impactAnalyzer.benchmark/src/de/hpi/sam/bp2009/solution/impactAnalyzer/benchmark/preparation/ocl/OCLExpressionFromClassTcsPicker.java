package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.utilities.ExpressionInOCL;

import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.OclTestExpressionContainer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.OclTestExpressionContainer.OclExpressionWithPackage;

public class OCLExpressionFromClassTcsPicker implements OCLExpressionPicker {

    public ArrayList<OCLExpressionWithContext> pickUpExpressions() {
	ArrayList<OCLExpressionWithContext> result = new ArrayList<OCLExpressionWithContext>();

	for (OclExpressionWithPackage expression : OclTestExpressionContainer.getExpressionList()) {
	    result.add(parse(expression.getOcl(), expression.getPackage()));
	}

	return result;
    }

    /**
     * @param expression
     *            to parse
     * @return a list of {@link Constraint}s parsed from given expression
     */
    protected OCLExpressionWithContext parse(String expression, EPackage basePackage) {
	OCLInput exp = new OCLInput(expression);
	String nsPrefix = basePackage.getNsPrefix();
	EPackage.Registry.INSTANCE.put(nsPrefix, basePackage);
	ArrayList<String> path = new ArrayList<String>();
	path.add(nsPrefix);
	OCL ocl = OCL.newInstance();
	ocl = OCL.newInstance(ocl.getEnvironment().getFactory().createPackageContext(ocl.getEnvironment(), path));
	OCLExpressionWithContext result = null;
	try {
	    ExpressionInOCL specification = ocl.parse(exp).iterator().next().getSpecification();
	    OCLExpression expr = (OCLExpression) specification.getBodyExpression();

	    result = new OCLExpressionWithContext(expr, (EClass) specification.getContextVariable().getType());

	} catch (ParserException e) {
	    System.err.println("Error while parsing Expression:" + exp);
	    e.printStackTrace();
	    System.exit(0);
	}
	return result;
    }

}
