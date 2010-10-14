package com.sap.emf.ocl.hiddenopposites;

import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.ObjectUtil;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.ExpressionInOCL;

public class OCLHelperWithOppositesImpl implements OCL.Helper {
    static final String EMPTY = ""; //$NON-NLS-1$
    static final int NONE = -1;
    static final String OCL_COMMENT = "--"; //$NON-NLS-1$
    /**
     * In stand-alone use, whether all tracing is turned on. This is compatible with the usage of 1.2 and earlier.
     */
    private static boolean traceAll = Boolean.getBoolean("org.eclipse.ocl.debug"); //$NON-NLS-1$;
    public static final String DEBUG = Activator.PLUGIN_ID + "/debug"; //$NON-NLS-1$
    public static final String EXCEPTIONS_CATCHING = DEBUG + "/exceptions/catching"; //$NON-NLS-1$
    public static final String EXCEPTIONS_THROWING = DEBUG + "/exceptions/throwing"; //$NON-NLS-1$
    private static final String SEPARATOR_SPACE = " "; //$NON-NLS-1$
    private static final String PARENTHESIS_OPEN = "("; //$NON-NLS-1$
    private static final String PARENTHESIS_CLOSE = ")"; //$NON-NLS-1$
    private static final String SEPARATOR_METHOD = "#"; //$NON-NLS-1$
    private static final String PREFIX_THROWING = "THROWN "; //$NON-NLS-1$
    private static final String PREFIX_CATCHING = "CAUGHT "; //$NON-NLS-1$

    private final OCL.Helper delegate;
    private SyntaxHelperWithHiddenOpposites syntaxHelper;
    private Diagnostic problems;

    public OCLHelperWithOppositesImpl(OCL.Helper standardOCLHelper) {
	this.delegate = standardOCLHelper;
    }

    public OCL getOCL() {
	return (OCL) delegate.getOCL();
    }

    public EcoreEnvironmentWithHiddenOpposites getEnvironment() {
	return (EcoreEnvironmentWithHiddenOpposites) delegate.getEnvironment();
    }

    public Constraint createConstraint(ConstraintKind kind, String expression) throws ParserException {
	switch (kind) {
	case PRECONDITION:
	    return createPrecondition(expression);
	case BODYCONDITION:
	    return createBodyCondition(expression);
	case POSTCONDITION:
	    return createPostcondition(expression);
	case INITIAL:
	    return createInitialValueExpression(expression);
	case DERIVATION:
	    return createDerivedValueExpression(expression);
	case DEFINITION:
	    return parseDefExpression(expression, isValidating(), getOCL().isParseTracingEnabled());
	default:
	    return createInvariant(expression);
	}
    }

    public Constraint createBodyCondition(String expression) throws ParserException {
	if (removeOCLComments(expression).length() > 0) {
	    // be sure to pass the original expression along to get the right
	    // position information when parse fails
	    try {
		return parseBodyCondition(expression, isValidating(), getOCL().isParseTracingEnabled());
	    } catch (RuntimeException e) {
		propagate(e, "createBodyCondition"); //$NON-NLS-1$
	    }
	}

	return createNullCondition(getEnvironment().getOCLStandardLibrary().getOclVoid());
    }

    public Constraint createDerivedValueExpression(String expression) throws ParserException {
	if (removeOCLComments(expression).length() > 0) {
	    // be sure to pass the original expression along to get the right
	    // position information when parse fails
	    try {
		return parseDerivedValueExpression(expression, isValidating(), getOCL().isParseTracingEnabled());
	    } catch (RuntimeException e) {
		propagate(e, "createDerivedValueExpression"); //$NON-NLS-1$
	    }
	}

	return createNullCondition(getEnvironment().getOCLStandardLibrary().getOclVoid());
    }

    
    public Constraint createInitialValueExpression(String expression) throws ParserException {
	if (removeOCLComments(expression).length() > 0) {
	    // be sure to pass the original expression along to get the right
	    // position information when parse fails
	    try {
		return parseInitialValueExpression(expression, isValidating(), getOCL().isParseTracingEnabled());
	    } catch (RuntimeException e) {
		propagate(e, "createInitialValueExpression"); //$NON-NLS-1$
	    }
	}

	return createNullCondition(getEnvironment().getOCLStandardLibrary().getOclVoid());
    }

    
    public Constraint createInvariant(String expression) throws ParserException {
	if (removeOCLComments(expression).length() > 0) {
	    // be sure to pass the original expression along to get the right
	    // position information when parse fails
	    try {
		return parseInvariant(expression, isValidating(), getOCL().isParseTracingEnabled());
	    } catch (RuntimeException e) {
		propagate(e, "createInvariant"); //$NON-NLS-1$
	    }
	}

	return createNullCondition(getEnvironment().getOCLStandardLibrary().getBoolean());
    }

    
    public Constraint createPostcondition(String expression) throws ParserException {
	if (removeOCLComments(expression).length() > 0) {
	    // be sure to pass the original expression along to get the right
	    // position information when parse fails
	    try {
		return parsePostcondition(expression, isValidating(), getOCL().isParseTracingEnabled());
	    } catch (RuntimeException e) {
		propagate(e, "createPostcondition"); //$NON-NLS-1$
	    }
	}

	return createNullCondition(getEnvironment().getOCLStandardLibrary().getBoolean());
    }

    
    public Constraint createPrecondition(String expression) throws ParserException {
	if (removeOCLComments(expression).length() > 0) {
	    // be sure to pass the original expression along to get the right
	    // position information when parse fails
	    try {
		return parsePrecondition(expression, isValidating(), getOCL().isParseTracingEnabled());
	    } catch (RuntimeException e) {
		propagate(e, "createPrecondition"); //$NON-NLS-1$
	    }
	}

	return createNullCondition(getEnvironment().getOCLStandardLibrary().getBoolean());
    }

    
    public org.eclipse.ocl.ecore.OCLExpression createQuery(String expression) throws ParserException {
	if (removeOCLComments(expression).length() > 0) {
	    // be sure to pass the original expression along to get the right
	    // position information when parse fails
	    try {
		return parseQuery(expression, isValidating(), getOCL().isParseTracingEnabled());
	    } catch (RuntimeException e) {
		propagate(e, "createQuery"); //$NON-NLS-1$
	    }
	}
	// may as well create a boolean-valued expression if none was supplied
	return (org.eclipse.ocl.ecore.OCLExpression) getEnvironment().getUMLReflection()
	        .getSpecification(createNullCondition(getEnvironment().getOCLStandardLibrary().getBoolean()))
	        .getBodyExpression();
    }

    void setProblems(Diagnostic problems) {
	this.problems = problems;
    }

    void checkForErrors() throws ParserException {
	try {
	    setProblems(OCLUtil.checkForErrors(getEnvironment()));
	} catch (ParserException e) {
	    setProblems(e.getDiagnostic());
	    throw e;
	}
    }

    private org.eclipse.ocl.ecore.OCLExpression parseQuery(String expression, boolean validate, boolean trace)
	    throws ParserException {

	EcoreEnvironmentWithHiddenOpposites env = getEnvironment();

	OCLAnalyzerWithHiddenOpposites analyzer = createAnalyzer(env, "inv:", expression, trace); //$NON-NLS-1$

	Constraint constraint = analyzer.parseInvOrDefCS();
	checkForErrors();

	ExpressionInOCL<EClassifier, EParameter> spec = env.getUMLReflection().getSpecification(constraint);
	OCLExpression<EClassifier> result = spec.getBodyExpression();

	// this is not a constraint
	env.getUMLReflection().setSpecification(constraint, null);
	spec.setBodyExpression(null);
	if (validate) {
	    validate(env, result);
	}
	finishAnalyzing();

	// re-persist the "self" variable that we temporarily stole away from
	// the environment, in the ExpressionInOCL. In a query expression,
	// there won't be other variables (result, parameters) to worry about
	persist(env, spec.getContextVariable());
	// persist the expression
	persist(env, result);

	// dispose the remainder of the constraint
	ObjectUtil.dispose(constraint);

	return (org.eclipse.ocl.ecore.OCLExpression) result;
    }

    private Constraint parseInvariant(String expression, boolean validate, boolean trace) throws ParserException {
	EcoreEnvironmentWithHiddenOpposites env = getEnvironment();
	OCLAnalyzerWithHiddenOpposites analyzer = createAnalyzer(env, "inv:", expression, trace); //$NON-NLS-1$
	Constraint result = analyzer.parseInvOrDefCS();
	checkForErrors();
	if (validate) {
	    validate(env, result);
	}
	finishAnalyzing();
	persist(result);
	return result;
    }

    private Constraint parsePrecondition(String expression, boolean validate, boolean trace) throws ParserException {
	EcoreEnvironmentWithHiddenOpposites env = getEnvironment();
	OCLAnalyzerWithHiddenOpposites analyzer = createAnalyzer(env, "pre:", expression, trace); //$NON-NLS-1$

	Constraint result = analyzer.parsePrePostOrBodyDeclCS();
	checkForErrors();

	if (validate) {
	    validate(env, result);
	}

	finishAnalyzing();

	persist(result);

	return result;
    }

    private Constraint parsePostcondition(String expression, boolean validate, boolean trace) throws ParserException {

	EcoreEnvironmentWithHiddenOpposites env = getEnvironment();

	OCLAnalyzerWithHiddenOpposites analyzer = createAnalyzer(env, "post:", expression, trace); //$NON-NLS-1$

	Constraint result = analyzer.parsePrePostOrBodyDeclCS();
	checkForErrors();

	if (validate) {
	    validate(env, result);
	}

	finishAnalyzing();

	persist(result);

	return result;
    }

    private Constraint parseBodyCondition(String expression, boolean validate, boolean trace) throws ParserException {

	EcoreEnvironmentWithHiddenOpposites env = getEnvironment();

	OCLAnalyzerWithHiddenOpposites analyzer = createAnalyzer(env, "body:", expression, trace); //$NON-NLS-1$

	Constraint result = analyzer.parsePrePostOrBodyDeclCS();
	checkForErrors();

	if (validate) {
	    validate(env, result);
	}

	finishAnalyzing();

	persist(result);

	return result;
    }

    private Constraint parseInitialValueExpression(String expression, boolean validate, boolean trace)
	    throws ParserException {

	EcoreEnvironmentWithHiddenOpposites env = getEnvironment();

	OCLAnalyzerWithHiddenOpposites analyzer = createAnalyzer(env, "init:", expression, trace); //$NON-NLS-1$

	Constraint result = analyzer.parseInitOrDerValueCS();
	checkForErrors();

	if (validate) {
	    validate(env, result);
	}

	finishAnalyzing();

	persist(result);

	return result;
    }

    private Constraint parseDerivedValueExpression(String expression, boolean validate, boolean trace)
	    throws ParserException {

	EcoreEnvironmentWithHiddenOpposites env = getEnvironment();

	OCLAnalyzerWithHiddenOpposites analyzer = createAnalyzer(env, "derive:", expression, trace); //$NON-NLS-1$

	Constraint result = analyzer.parseInitOrDerValueCS();
	checkForErrors();

	if (validate) {
	    validate(env, result);
	}

	finishAnalyzing();

	persist(result);

	return result;
    }

    private Constraint parseDefExpression(String defExpression, boolean validate, boolean trace) throws ParserException {

	EcoreEnvironmentWithHiddenOpposites env = getEnvironment();

	OCLAnalyzerWithHiddenOpposites analyzer = createAnalyzer(env, "def:", defExpression, trace); //$NON-NLS-1$

	// we want to make the defined feature available. This is OK, since
	// the constraint will be discarded anyway
	analyzer.getEnvironment().setOption(ParsingOptions.DEFINITION_CONSTRAINS_FEATURE, true);

	Constraint result = analyzer.parseInvOrDefCS();
	checkForErrors();

	if (validate) {
	    validate(env, result);
	}

	finishAnalyzing();

	persist(result);

	return result;
    }

    
    public EStructuralFeature defineAttribute(String defExpression) throws ParserException {
	// TODO use own analyzer
	return delegate.defineAttribute(defExpression);
    }

    
    public EOperation defineOperation(String defExpression) throws ParserException {
	// TODO use own analyzer
	return delegate.defineOperation(defExpression);
    }

    
    public EStructuralFeature getContextAttribute() {
	return delegate.getContextAttribute();
    }

    
    public EClassifier getContextClassifier() {
	return delegate.getContextClassifier();
    }

    
    public EOperation getContextOperation() {
	return delegate.getContextOperation();
    }

    
    public List<Choice> getSyntaxHelp(ConstraintKind constraintType, String txt) {
	return new SyntaxHelperWithHiddenOpposites(getEnvironment()).getSyntaxHelp(constraintType, txt);
    }

    /**
     * returns the ocl syntax helper object
     * 
     * @return OCLSyntaxHelper
     */
    protected SyntaxHelperWithHiddenOpposites createSyntaxHelper() {
	if (syntaxHelper == null) {
	    syntaxHelper = new SyntaxHelperWithHiddenOpposites(getEnvironment());
	}
	return syntaxHelper;
    }

    public boolean isValidating() {
	return delegate.isValidating();
    }

    public void setContext(EClassifier context) {
	delegate.setContext(context);
    }

    public void setAttributeContext(EClassifier context, EStructuralFeature property) {
	delegate.setAttributeContext(context, property);
    }

    public void setOperationContext(EClassifier context, EOperation operation) {
	delegate.setOperationContext(context, operation);
    }

    public void setInstanceContext(Object instance) {
	delegate.setInstanceContext(instance);
    }

    public void setInstanceOperationContext(Object instance, EOperation operation) {
	delegate.setInstanceOperationContext(instance, operation);
    }

    public void setInstanceAttributeContext(Object instance, EStructuralFeature property) {
	delegate.setInstanceAttributeContext(instance, property);
    }

    public void setValidating(boolean validating) {
	delegate.setValidating(validating);
    }

    /**
     * Initializes an analyzer on the specified <code>text</code> and environment factory.
     * 
     * @param prefix
     *            the constraint prefix (e.g., <code>"inv:"</code> or <code>"pre:"</code>). The prefix must not contain
     *            newlines
     * @param environmentFactory
     *            the analyzer's environment factory
     * @param text
     *            the OCL constraint text
     * @param trace
     *            whether to trace the parsing
     * 
     * @return the analyzer
     */
    private OCLAnalyzerWithHiddenOpposites createAnalyzer(EcoreEnvironmentWithHiddenOpposites env, String prefix,
	    String text, boolean trace) {
	// we prefix the constraint with "inv:", "pre:", "def:", etc. which the
	// user cannot see, so we want error reporting to be relative
	// to line 0, not line 1. Also, clear any old diagnostics
	ProblemHandler ph = OCLUtilWithHiddenOpposites.getAdapter(env, ProblemHandler.class);
	if (ph != null) {
	    ph.setErrorReportLineOffset(-1);
	    ph.beginParse();
	}
	OCLAnalyzerWithHiddenOpposites result = new OCLAnalyzerWithHiddenOpposites(env, (prefix + '\n' + text));
	// offset the character position by the length of the extra text
	result.setCharacterOffset(-(prefix.length() + 1)); // one for the newline
	result.setTraceFlag(trace);
	return result;
    }

    /**
     * Strips any leading, trailing, or embedded comments from the specified OCL expression text.
     * 
     * @param txt
     *            an OCL expression
     * @return the same, but without any comments. Note that the result may be an empty String if <code>txt</code> has
     *         only comments
     */
    private String removeOCLComments(String txt) {
	try {
	    return getLogicalLine(txt);
	} catch (Exception ex) {
	    catchException(ex, getClass(), "removeOCLComments");//$NON-NLS-1$
	}
	return EMPTY;
    }

    /**
     * combines several physical non-commented lines into one logical line by removing white spaces and embedded
     * comments
     * 
     * @param txt
     *            the string we got from client that contains the ocl expression
     * @return String the non-commented lines of the input concatenated as one
     * @throws Exception
     *             if while traversing the string something went wrong mainly to account for (IOException)
     */
    private String getLogicalLine(String txt) throws Exception {
	LineNumberReader reader = new LineNumberReader(new StringReader(txt.trim()));
	String logicalLine = EMPTY;
	int embeddedCommnetIndex = NONE;
	String line = reader.readLine();
	while (line != null) {
	    line = line.trim();
	    if (line.startsWith(OCL_COMMENT) == false) {
		// safe to search for index of "--" which consists of BMP code points
		embeddedCommnetIndex = line.indexOf(OCL_COMMENT);
		if (embeddedCommnetIndex != NONE) {
		    line = line.substring(0, embeddedCommnetIndex);
		    line = line.trim();
		}
		logicalLine = logicalLine + line + ' ';
	    }
	    line = reader.readLine();
	}
	return logicalLine;
    }

    /**
     * convenience method for serviceability support tracing exceptions caught
     * 
     * @param exception
     *            the exception to be caught
     * @param clazz
     *            the metaclass of the java object that owns the method
     * @param methodName
     *            the method that caught the exception
     */
    private void catchException(Exception exception, Class<?> clazz, String methodName) {
	catching(clazz, methodName, exception);
    }

    /**
     * Traces the catching of the specified throwable in the specified method of the specified class.
     * 
     * @param clazz
     *            The class in which the throwable is being caught.
     * @param methodName
     *            The name of the method in which the throwable is being caught.
     * @param throwable
     *            The throwable that is being caught.
     * 
     */
    private void catching(Class<?> clazz, String methodName, Throwable throwable) {
	if (shouldTrace(EXCEPTIONS_CATCHING)) {
	    System.out.println(PREFIX_CATCHING + throwable.getMessage() + SEPARATOR_SPACE + PARENTHESIS_OPEN
		    + clazz.getName() + SEPARATOR_METHOD + methodName + PARENTHESIS_CLOSE);
	    throwable.printStackTrace(System.err);
	}
    }

    private void throwing(Class<?> clazz, String methodName, Throwable throwable) {
	if (shouldTrace(EXCEPTIONS_THROWING)) {
	    System.out.println(PREFIX_THROWING + throwable.getMessage() + SEPARATOR_SPACE + PARENTHESIS_OPEN
		    + clazz.getName() + SEPARATOR_METHOD + methodName + PARENTHESIS_CLOSE);
	    throwable.printStackTrace(System.err);
	}
    }

    private boolean shouldTrace(String option) {
	if (Activator.getDefault() != null) {
	    if (Activator.getDefault().isDebugging()) {
		return Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(option));
	    }
	    return false;
	}
	return traceAll || Boolean.getBoolean(option);
    }

    /**
     * Propagates the specified exception as a parsing exception, with the requisite tracing.
     * 
     * @param e
     *            the exception to propagate
     * @param method
     *            the name of the method that caught the exception
     * 
     * @throws the
     *             exception wrapped in an {@link ParserException}
     */
    private void propagate(Exception e, String method) throws ParserException {
	catching(getClass(), method, e);
	ParserException ope = new ParserException(e.getLocalizedMessage(), e);
	throwing(getClass(), method, ope);
	throw ope;
    }

    /**
     * Creates a null condition of the specified <code>type</code>.
     * 
     * @param type
     *            the condition type
     * 
     * @return an expression whose value is <code>false</code> for boolean type or <code>null</code> for anything else
     */
    private Constraint createNullCondition(EClassifier type) {
	OCLExpression<EClassifier> condition;

	OCLStandardLibrary<EClassifier> stdlib = getEnvironment().getOCLStandardLibrary();

	if (type == stdlib.getBoolean()) {
	    BooleanLiteralExp<EClassifier> literal = getEnvironment().getOCLFactory().createBooleanLiteralExp();
	    condition = literal;
	    getEnvironment().getUMLReflection().setType(literal, getEnvironment().getOCLStandardLibrary().getBoolean());
	    literal.setBooleanSymbol(Boolean.FALSE);
	} else {
	    UnspecifiedValueExp<EClassifier> unspec = getEnvironment().getOCLFactory().createUnspecifiedValueExp();
	    condition = unspec;

	    if (type == null) {
		type = getEnvironment().getOCLStandardLibrary().getOclVoid();
	    }

	    getEnvironment().getUMLReflection().setType(unspec, type);
	}

	Constraint result = getEnvironment().getUMLReflection().createConstraint();

	ExpressionInOCL<EClassifier, EParameter> spec = getEnvironment().getUMLReflection().createExpressionInOCL();
	spec.setBodyExpression(condition);
	spec.setContextVariable(getEnvironment().getSelfVariable());

	getEnvironment().getUMLReflection().setSpecification(result, spec);
	return result;
    }

    
    public Diagnostic getProblems() {
	return problems;
    }

    private void validate(EcoreEnvironmentWithHiddenOpposites env, OCLExpression<EClassifier> expression)
	    throws ParserException {
	expression.accept(ValidationVisitorWithHiddenOpposite.getInstance(env));
    }

    private void validate(EcoreEnvironmentWithHiddenOpposites env, Constraint constraint) throws ParserException {
	ValidationVisitorWithHiddenOpposite.getInstance(env).visitConstraint(constraint);
    }

    /**
     * Completes an environment's parsing session.
     * 
     * @param helper
     *            the helper implementation
     */
    private void finishAnalyzing() throws ParserException {
	ProblemHandler ph = OCLUtil.getAdapter(getEnvironment(), ProblemHandler.class);
	if (ph != null) {
	    ph.endParse();
	}
	checkForErrors();
    }

    private void persist(Constraint constraint) {
	EObject constraintEObject = (EObject) constraint;
	if (constraintEObject.eResource() == null) {
	    getEnvironment().getTypeResolver().getResource().getContents().add(constraintEObject);
	}
	getOCL().getConstraints().add(constraint);
    }

    private void persist(EcoreEnvironmentWithHiddenOpposites env, ASTNode astNode) {
	if (astNode.eResource() == null) {
	    env.getTypeResolver().getResource().getContents().add(astNode);
	}
    }
}
