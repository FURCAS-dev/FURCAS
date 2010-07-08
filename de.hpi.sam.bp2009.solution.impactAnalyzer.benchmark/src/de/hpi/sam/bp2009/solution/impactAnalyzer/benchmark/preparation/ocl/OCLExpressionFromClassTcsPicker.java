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

import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLTestExpressionContainer.OclExpressionWithPackage;

public class OCLExpressionFromClassTcsPicker implements OCLExpressionPicker {

    @Override
    public ArrayList<OCLExpressionWithContext> pickUpExpressions() {
	ArrayList<OCLExpressionWithContext> result = new ArrayList<OCLExpressionWithContext>();

	for (OclExpressionWithPackage expression : OCLTestExpressionContainer.getExpressionList()) {
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
		OCL ocl = OCLWithHiddenOpposites.newInstance();
		ocl = OCLWithHiddenOpposites.newInstance(ocl.getEnvironment().getFactory().createPackageContext(ocl.getEnvironment(), path));
		OCLExpressionWithContext result = null;
		try {
			@SuppressWarnings("rawtypes")
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
