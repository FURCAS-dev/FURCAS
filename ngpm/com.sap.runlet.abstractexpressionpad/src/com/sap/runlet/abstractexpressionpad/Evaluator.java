package com.sap.runlet.abstractexpressionpad;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.sap.furcas.runtime.common.implementation.ResolvedModelElementProxy;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.impl.DelayedReference;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.impl.context.ContextManager;
import com.sap.runlet.abstractinterpreter.AbstractRunletInterpreter;
import com.sap.runlet.abstractinterpreter.StackFrame;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.Repository;


/**
 * Takes an ExpressionType or a StatementType in a concrete textual syntax and parses it 
 * into a transient set of model elements. If parsing went through correctly, the resulting 
 * ExpressionType or StatementType is handed to the {@link AbstractRunletInterpreter interpreter} 
 * for evaluation. 
 * <p>
 * 
 * For statement execution, an instance of this class maintains a
 * stack frame of type StackFrameType to which variables can be added. 
 * 
 * @author Axel Uhl (D043530)
 * @author Jan Karstens (D046040)
 */
public abstract class Evaluator<MetaClass extends EObject, 
		       TypeUsage extends EObject, 
		       ClassUsage extends TypeUsage, 
		       LinkMetaObject extends EObject, 
		       LinkEndMetaObject extends EObject, 
		       StatementType extends EObject, 
		       ExpressionType extends EObject, 
		       SignatureImplementationType extends EObject, 
		       StackFrameType extends StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType>, 
		       NativeType extends SignatureImplementationType, 
		       InterpreterType extends AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>,
		       Block extends SignatureImplementationType> {

    private Logger log = Logger.getLogger(Evaluator.class.getName());

    private ResourceSet conn;

    /**
     * The stack frame corresponding to the {@link #contextBlock} for statement
     * execution. Holds the variable declarations made during statement
     * execution.
     */
    private StackFrameType stackFrame;

    /**
     * For statement sequence execution we need a {@link Block} as context for
     * variable declarations. We'll set this on the parser using
     * {@link ObservableInjectingParser#addContext(com.sap.mi.textual.common.interfaces.IModelElementProxy, String...)}
     * .
     */
    private Block contextBlock;

    /**
     * Helper variable to save the parser state between subsequent statement
     * evaluations
     */
    private ContextManager contextManager = null;

    /**
     * Helper variable to save the parser state between subsequent statement
     * evaluations
     */
    private Stack<IModelElementProxy> currentContextStack = null;

    /**
     * Maintains state such as a {@link RunletLinkContainer} maintaining links
     * of associations, across invocations of {@link #execute(String...)} and
     * {@link #evaluate(String...)}.
     */
    private AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> interpreter;

    public static class ExecuteResult<LinkEndMetaObject, TypeUsage, ClassUsage extends TypeUsage> {
	private RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>[] result;
	private String[] errors;

	public ExecuteResult(RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>[] result, String[] errors) {
	    this.setResult(result);
	    this.setErrors(errors);
	}

	public void setResult(RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>[] result) {
	    this.result = result;
	}

	public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>[] getResult() {
	    return result;
	}

	public void setErrors(String[] errors) {
	    this.errors = errors;
	}

	public String[] getErrors() {
	    return errors;
	}
    }

    public static class ParseResult<ExpressionType extends EObject> {
	private List<String> errors;
	private DiagnosticChain constraintViolations;
	private ExpressionType expression;

	public ParseResult(List<String> errors, DiagnosticChain constraintViolations, ExpressionType expression) {
	    super();
	    this.errors = errors;
	    this.constraintViolations = constraintViolations;
	    this.expression = expression;
	}

	public List<String> getErrors() {
	    return errors;
	}

	public DiagnosticChain getConstraintViolations() {
	    return constraintViolations;
	}

	public ExpressionType getExpression() {
	    return expression;
	}
    }

    private void init(String projectName, Repository<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> repository) {
	init(getResourceSet(projectName), repository);
    }

    private void init(ResourceSet connection,
	    Repository<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> repository) {
	this.conn = connection;
	initLocalFields(connection, repository);
	if (stackFrame == null || contextBlock == null || interpreter == null) {
	    throw new RuntimeException("Evaluator is not correctly initialized.");
	}
    }
    
    /**
     * Implement and initialize the following fields:
     * * stackFrame
     * * contextBlock
     * * interpreter
     * * closeConnectionUponFinalize (optional, default false)
     * @param connection
     */
    protected abstract void initLocalFields(ResourceSet connection, Repository<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> repository);

    /**
     * Initializes the {@link #getInterpreter() interpreter} with a connection
     * that is obtained from the project named <tt>projectName</tt>. A new empty
     * {@link Repository} is created for the interpreter.
     */
    public Evaluator(String projectName) {
	init(projectName, createRepository());
    }

    /**
     * Implement to return a new instance of a Repository.
     * @return
     */
    abstract protected Repository<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> createRepository();

    /**
     * Initializes the {@link #getInterpreter() interpreter} with a connection
     * that is obtained from the project named <tt>projectName</tt>. The
     * interpreter uses the <tt>repository</tt> passed to load and store
     * persistent objects.
     */
    public Evaluator(String projectName, Repository<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> repository) {
	init(projectName, repository);
    }

    public Evaluator(ResourceSet resourceSet,
	    Repository<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> repository) {
	init(resourceSet, repository);
    }

    public Repository<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getRepository() {
	return getInterpreter().getRepository();
    }

    public static ResourceSet getResourceSet(String projectName) {
	return new ResourceSetImpl();
    }

    @SuppressWarnings("unchecked")
    public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>[] evaluate(String... expressions) throws RecognitionException,
	    SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	List<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> result = new LinkedList<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>();
	for (String expressionString : expressions) {
	    ExpressionType expression = parse(expressionString).getExpression();
	    if (expression != null) {
		result.add(interpreter.evaluate(expression));
	    } else {
		result.add(null);
	    }
	}
	return (RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>[]) result.toArray(new RunletObject<?, ?, ?>[0]);
    }

    public ParseResult<ExpressionType> parse(String expressionString) throws RecognitionException {
	ObservableInjectingParser parser = createParser(expressionString);
	BitSet follows = new BitSet();
	follows.add(1); // EndOfRule, for top-level rule meaning EOF
	parser.pushFollow(follows);
	ExpressionType e = parseExpression(parser);
	parser.popFollow();

	List<String> errors = new LinkedList<String>();
	if (parser.input.LA(1) != -1) {
	    // not matched up to EOF
	    errors.add("Not parsed up to EOF. Unparsed text:\n" + parser.input.toString(parser.input.index(), parser.input.size() - 1));
	}
	// append unresolved references to result (for display on console)
	if (!parser.setDelayedReferencesAfterParsing()) {
	    for (DelayedReference ref : parser.getUnresolvedReferences()) {
		log.warning("Unresolved reference: " + ref);
		errors.add("Unresolved reference: " + ref.toString());
	    }
	}
	for (ParsingError err : parser.getInjector().getErrorList()) {
	    errors.add(err.getMessage());
	}

        BasicDiagnostic diagnostics = null;
	if (e != null) {
	    EValidator v = EValidator.Registry.INSTANCE.getEValidator(e.eClass().getEPackage());
	    v.validate(e, diagnostics, new HashMap<Object, Object>());
	    // append constraint violations to result (for display on console)
            diagnostics = new BasicDiagnostic();
	    logAndCollectErrors(diagnostics, errors);
	}
	return new ParseResult<ExpressionType>(errors, diagnostics, e);
    }
    
    private void logAndCollectErrors(Diagnostic constraintViolations, List<String> errors) {
        if (constraintViolations.getSeverity() == Diagnostic.ERROR) {
            log.severe("Constraint violation: " + constraintViolations.getMessage() + " on element "
                    + constraintViolations.getMessage());
            errors.add("Constraint violation: " + constraintViolations.getMessage() + " on element "
                    + constraintViolations.getMessage());
        }
        for (Diagnostic child : constraintViolations.getChildren()) {
            logAndCollectErrors(child, errors);
        }
    }

    /**
     * Implement
     * @param parser
     * @return
     */
    protected abstract ExpressionType parseExpression(ObservableInjectingParser parser) throws RecognitionException;

    @SuppressWarnings("unchecked")
    public ExecuteResult<LinkEndMetaObject, TypeUsage, ClassUsage> execute(String... statements) throws Exception {
	List<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> result = new LinkedList<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>();
	List<String> errors = new LinkedList<String>();
	Collection<Exception> constraintViolations = null;

	for (String statementString : statements) {
	    ObservableInjectingParser parser = createParser(statementString);
	    restoreParserState(parser);

	    // parse statement, pretending it is the main rule, requiring EOF at
	    // end of stream
	    BitSet follows = new BitSet();
	    follows.add(1); // EndOfRule, for top-level rule meaning EOF
	    follows.add(getStatementSeperatorBit()); // permit end-of-statement-token
	    parser.pushFollow(follows);
	    StatementType statement = parseStatement(parser);
	    parser.popFollow();
	    if (parser.input.LA(1) != -1) {
		// not matched up to EOF
		errors.add("Not parsed up to EOF. Unparsed text:\n" + parser.input.toString(parser.input.index(), parser.input.size() - 1));
	    }
	    if (statement != null) {
		// adding to block needs to happen before checking for unresolved references
		// because, e.g., variables are found via the block's declarations
		addToBlock(statement, contextBlock);
	    }
	    // append unresolved references to result (for display on console)
	    if (!parser.setDelayedReferencesAfterParsing()) {
		for (DelayedReference ref : parser.getUnresolvedReferences()) {
		    if (!ref.isOptional()) {
			log.warning("Unresolved reference: " + ref.toString());
			errors.add("Unresolved reference: " + ref.toString());
		    }
		}
	    }
	    for (ParsingError err : parser.getInjector().getErrorList()) {
		errors.add(err.getMessage());
	    }

            if (statement != null) {
                EValidator v = EValidator.Registry.INSTANCE.getEValidator(statement.eClass().getEPackage());
                BasicDiagnostic diagnostics = new BasicDiagnostic();
                v.validate(statement, diagnostics, new HashMap<Object, Object>());
                // append constraint violations to result (for display on console)
                logAndCollectErrors(diagnostics, errors);
                saveParserState(parser);
		interpreter.push(stackFrame);
		try {
		    result.add(interpreter.evaluateStatement(statement));
		} catch (Throwable t) {
		    if (errors.size() + (constraintViolations == null ? 0 : constraintViolations.size()) > 0) {
			// Parser already had errors, so runtime failure was to
			// be expected; simply log
			log.info("Exception during execution: " + t.getMessage());
			errors.add(t.getMessage());
		    } else {
			// probably an internal error
			log.severe("Error during execution although parser didn't find any errors: " + t.getMessage());
			throw new RuntimeException(t);
		    }
		} finally {
		    if (interpreter.getCallstack().size() > 0) {
			interpreter.pop();
		    }
		}
	    } else {
		result.add(null);
	    }
	    // append constraint violations to result (for display on console)
	    if (constraintViolations != null) {
		for (Exception constraintViolation : constraintViolations) {
		    log.severe("Constraint violation: " + constraintViolation.getMessage() + " on element "
			    + constraintViolation.getMessage());
		    errors.add("Constraint violation: " + constraintViolation.getMessage() + " on element "
			    + constraintViolation.getMessage());
		}
	    }
	}
	return new ExecuteResult<LinkEndMetaObject, TypeUsage, ClassUsage>((RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>[]) result
		.toArray(new RunletObject<?, ?, ?>[0]), errors.toArray(new String[0]));
    }

    /**
     * Implementors should add the <code>statement</code> at the end of the <code>contextBlock</code>
     * @param statement
     * @param contextBlock
     */
    abstract protected void addToBlock(StatementType statement, Block contextBlock);

    /**
     * Parse a single statement. Implement this method by calling the correct method on your concrete
     * {@link ObservableInjectingParser} to parse a single statement.
     * @param parser
     * @return
     */
    protected abstract StatementType parseStatement(ObservableInjectingParser parser) throws RecognitionException;

    /**
     * Return the bit as <code>int</code> that separates statements according to the syntax of the
     * concrete parser. 
     * You will find this bit declaration on the Parser class inheriting from {@link ObservableInjectingParser}.
     * (e.g. the constant SEMICOLON).
     * @return
     */
    protected abstract int getStatementSeperatorBit();

    /**
     * Factory method for creating a parser object from a statement string.
     * 
     * @param statementString
     * @return
     */
    protected abstract ObservableInjectingParser createParser(String statementString);

    /**
     * Helper method to save the internal parser state for correct parsing of
     * further statements.
     * 
     * @param parser
     */
    private void saveParserState(ObservableInjectingParser parser) {
	contextManager = parser.getContextManager();
	currentContextStack = parser.getCurrentContextStack();
    }

    /**
     * Helper method to restore the internal parser state for correct parsing of
     * subsequent statements.
     * 
     * @param parser
     */
    private void restoreParserState(ObservableInjectingParser parser) {
	if (contextManager != null) {
	    parser.initParser(contextManager, currentContextStack);
	} else {
	    parser.addContext(new ResolvedModelElementProxy(contextBlock), "block");
	}
    }

    /**
     * Getter method for external inspection of the runtime context. Must be
     * public but not intended for public usage.
     * 
     * @return
     */
    public Block getContextBlock() {
	return contextBlock;
    }

    @SuppressWarnings("unchecked")
    public Block getInterpreterOutermostBlockWrapper() {
	return (Block)currentContextStack.peek();
    }

    /**
     * Getter method for external inspection of the runtime stack. Must be
     * public but not inteded for public usage.
     * 
     * @return
     */
    public StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType> getStackFrame() {
	return stackFrame;
    }

    public AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> getInterpreter() {
	return interpreter;
    }

    public ResourceSet getConnection() {
	return conn;
    }

    protected void setStackFrame(StackFrameType stackFrame) {
        this.stackFrame = stackFrame;
    }

    protected void setContextBlock(Block contextBlock) {
        this.contextBlock = contextBlock;
    }

    protected void setInterpreter(
    	AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> interpreter) {
        this.interpreter = interpreter;
    }

}
