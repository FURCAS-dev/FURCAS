package com.sap.emf.ocl.hiddenopposites;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.SyntaxException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.parser.OCLAnalyzer;
import org.eclipse.ocl.parser.backtracking.OCLBacktrackingLexer;
import org.eclipse.ocl.parser.backtracking.OCLBacktrackingParser;
import org.eclipse.ocl.util.OCLUtil;

import com.sap.emf.oppositeendfinder.OppositeEndFinder;

public class OCLWithHiddenOpposites extends OCL {

    @Override
    public void validate(OCLExpression<EClassifier> expression) throws SemanticException {
	// clear out old diagnostics
	ProblemHandler ph = OCLUtil.getAdapter(getEnvironment(),
		ProblemHandler.class);
	if (ph != null) {
		ph.beginValidation();
	}

	expression.accept(ValidationVisitorWithHiddenOpposite.getInstance(getEnvironment()));

	if (ph != null) {
		ph.endValidation();

		try {
			OCLUtil.checkForErrors(ph);
		} catch (SyntaxException e) {
			// shouldn't actually be able to get this from validation
			throw new SemanticException(e.getDiagnostic());
		}
	}
    }

    @Override
    public void validate(Constraint constraint) throws SemanticException {
	// clear out old diagnostics
	ProblemHandler ph = OCLUtil.getAdapter(getEnvironment(),
		ProblemHandler.class);
	if (ph != null) {
		ph.beginValidation();
	}

	ValidationVisitorWithHiddenOpposite.getInstance(getEnvironment()).visitConstraint(
		constraint);

	if (ph != null) {
		ph.endValidation();

		try {
			OCLUtil.checkForErrors(ph);
		} catch (SyntaxException e) {
			// shouldn't actually be able to get this from validation
			throw new SemanticException(e.getDiagnostic());
		}
	}
    }

    protected OCLWithHiddenOpposites(
	    Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
	super(env);
    }

    protected OCLWithHiddenOpposites(EcoreEnvironmentFactoryWithHiddenOpposites envFactory, Resource resource) {
	super(envFactory, resource);
    }

    protected OCLWithHiddenOpposites(EcoreEnvironmentFactoryWithHiddenOpposites envFactory) {
	super(envFactory);
    }

    @Override
    public Helper createOCLHelper() {
	return new OCLHelperWithOppositesImpl(super.createOCLHelper());
    }

    /**
     * Creates a new <code>OCL</code> using the shared Ecore environment factory instance.
     * 
     * @return the new <code>OCL</code>
     */
    public static OCL newInstance() {
	return new OCLWithHiddenOpposites(EcoreEnvironmentFactoryWithHiddenOpposites.INSTANCE);
    }

    /**
     * Creates a new <code>OCL</code> creating a new Ecore environment factory instance that uses the
     * <code>oppositeEndFinder</code> specified.
     * 
     * @return the new <code>OCL</code>
     * @since 3.0
     */
    public static OCL newInstance(OppositeEndFinder oppositeEndFinder) {
	return new OCLWithHiddenOpposites(new EcoreEnvironmentFactoryWithHiddenOpposites(oppositeEndFinder));
    }

    /**
     * Creates a new <code>OCL</code> using the specified Ecore environment factory.
     * 
     * @param envFactory
     *            an environment factory for Ecore
     * @return the new <code>OCL</code>
     */
    public static OCL newInstance(EcoreEnvironmentFactoryWithHiddenOpposites envFactory) {

	return new OCLWithHiddenOpposites(envFactory);
    }

    /**
     * Creates a new <code>OCL</code> using the specified initial Ecore environment.
     * 
     * @param env
     *            an environment for Ecore
     * @return the new <code>OCL</code>
     */
    public static OCL newInstance(Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
	return new OCLWithHiddenOpposites(env);
    }

    /**
     * Creates a new <code>OCL</code> using the specified Ecore environment factory and a resource from which to load
     * the initial environment.
     * 
     * @param envFactory
     *            an environment factory for Ecore
     * @param resource
     *            the resource containing a persistent environment (which may be empty for an initially empty
     *            environment)
     * @return the new <code>OCL</code>
     */
    public static OCL newInstance(EcoreEnvironmentFactoryWithHiddenOpposites envFactory, Resource resource) {
	return new OCLWithHiddenOpposites(envFactory, resource);
    }

    @Override
    public OCLAnalyzer<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createAnalyzer(
	    String input) {
	OCLAnalyzerWithHiddenOpposites analyzer;
	if (getParserRepairCount() != 0) {
		OCLBacktrackingLexer lexer = new OCLBacktrackingLexer(
			getEnvironment(), input.toCharArray());
		OCLBacktrackingParser parser = new OCLBacktrackingParser(lexer);
		parser.setDefaultRepairCount(getParserRepairCount());
		lexer.lexer(parser.getIPrsStream());
		analyzer = new OCLAnalyzerWithHiddenOpposites(parser);
	} else {
		analyzer = new OCLAnalyzerWithHiddenOpposites(getEnvironment(), input);
	}
	return analyzer;
    }
}
