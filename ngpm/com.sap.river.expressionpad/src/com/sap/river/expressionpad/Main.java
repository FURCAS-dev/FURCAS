package com.sap.river.expressionpad;

import generated.ClassLexer;
import generated.ClassParser;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenRewriteStream;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.omg.ocl.expressions.VariableDeclaration;

import behavioral.actions.Block;
import behavioral.actions.Statement;
import behavioral.actions.__impl.BlockWrapper;

import com.sap.ap.cts.monet.parser.ClassParserFactory;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.textual.common.implementation.ResolvedModelElementProxy;
import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.grammar.impl.ParsingError;
import com.sap.mi.textual.grammar.impl.context.ContextManager;
import com.sap.river.interpreter.LinkContainer;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.StackFrame;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.repository.Repository;
import com.sap.river.interpreter.repository.simpleimpl.InMemoryRepository;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import dataaccess.expressions.Expression;

/**
 * Takes an expression or a statement in a concrete textual syntax as specified by Expressions.tcs
 * and parses it into a transient set of model elements. If parsing went through correctly, the
 * resulting {@link Expression} or {@link Statement} is handed to the
 * {@link RiverInterpreter interpreter} for evaluation. The results are then displayed.
 * <p>
 * 
 * For statement execution, an instance of this class maintains a {@link StackFrame} to which
 * variables can be added, e.g., by a {@link VariableDeclaration} statement.
 * 
 * @author Axel Uhl (D043530)
 */
public class Main {
    private Logger log = Logger.getLogger(Main.class.getName());

    private Connection conn;

    /**
     * The stack frame corresponding to the {@link #contextBlock} for statement execution. Holds the
     * variable declarations made during statement execution.
     */
    private StackFrame stackFrame;

    /**
     * For statement sequence execution we need a {@link Block} as context for variable
     * declarations. We'll set this on the parser using
     * {@link ObservableInjectingParser#addContext(com.sap.mi.textual.common.interfaces.IModelElementProxy, String...)}.
     */
    private Block contextBlock;

    /**
     * Helper variable to save the parser state between subsequent statement evaluations
     */
    private ContextManager contextManager = null;

    /**
     * Helper variable to save the parser state between subsequent statement evaluations
     */
    private Stack<IModelElementProxy> currentContextStack = null;

    /**
     * Maintains state such as a {@link LinkContainer} maintaining links of associations,
     * across invocations of {@link #execute(String...)} and {@link #evaluate(String...)}.
     */
    private RiverInterpreter interpreter;

    /**
     * Tells if the {@link #conn connection} should be closed when this object is finalized
     */
    private boolean closeConnectionUponFinalize;

    public static class ExecuteResult {
	private RiverObject[] result;
	private String[] errors;
	
	public ExecuteResult(RiverObject[] result, String[] errors) {
	    this.setResult(result);
	    this.setErrors(errors);
	}

	public void setResult(RiverObject[] result) {
	    this.result = result;
	}

	public RiverObject[] getResult() {
	    return result;
	}

	public void setErrors(String[] errors) {
	    this.errors = errors;
	}

	public String[] getErrors() {
	    return errors;
	}
    }
    
    public static class ParseResult {
	private List<String> errors;
	private Collection<JmiException> constraintViolations;
	private Expression expression;
	public ParseResult(List<String> errors, Collection<JmiException> constraintViolations,
		Expression expression) {
	    super();
	    this.errors = errors;
	    this.constraintViolations = constraintViolations;
	    this.expression = expression;
	}
	public List<String> getErrors() {
	    return errors;
	}
	public Collection<JmiException> getConstraintViolations() {
	    return constraintViolations;
	}
	public Expression getExpression() {
	    return expression;
	}
    }
    
    /**
     * @param args
     *                args[0] names the project that is to be used as the context for the MOIN
     *                connection; each other argument is interpreted as an expression; results are
     *                output in the respective order.
     */
    public static void main(String[] args) {
	try {
	    Main thiz = new Main(args[0]);
	    String[] expressions = new String[args.length - 1];
	    System.arraycopy(args, 1, expressions, 0, args.length - 1);
	    RiverObject[] results = thiz.evaluate(expressions);
	    for (RiverObject result : results) {
		System.out.println(result);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    private void init(String projectName, Repository repository) {
	closeConnectionUponFinalize = true;
	init(getConnection(projectName), repository);
    }
    
    private void init(Connection connection, Repository repository) {
	stackFrame = new StackFrame();
	closeConnectionUponFinalize = false;
	conn = connection;
	contextBlock = conn.createElement(Block.CLASS_DESCRIPTOR);
	contextBlock.assign___PartitionIncludingChildren(conn.getOrCreateTransientPartition(
		"RunletConsoleObjects"));
	interpreter = new RiverInterpreter(conn, repository);
    }
    
    /**
     * Initializes the {@link #getInterpreter() interpreter} with a connection that is
     * obtained from the project named <tt>projectName</tt>. A new empty {@link Repository}
     * is created for the interpreter.
     */
    public Main(String projectName) {
	init(projectName, new InMemoryRepository());
    }
    
    /**
     * Initializes the {@link #getInterpreter() interpreter} with a connection that is
     * obtained from the project named <tt>projectName</tt>. The interpreter uses the
     * <tt>repository</tt> passed to load and store persistent objects.
     */
    public Main(String projectName, Repository repository) {
	init(projectName, repository);
    }
    
    public Main(Connection connection, Repository repository) {
	init(connection, repository);
    }

    @Override
    public void finalize() {
	if (closeConnectionUponFinalize) {
	    conn.close();
	}
    }
    
    public Repository getRepository() {
	return getInterpreter().getRepository();
    }

    public static Connection getConnection(String projectName) {
	final IProject project = ResourcesPlugin.getWorkspace().getRoot()
		.getProject(projectName);
	final Connection[] conn = new Connection[1];
	IRunnableWithProgress operation = new IRunnableWithProgress() {
	    public void run(IProgressMonitor monitor) {
		// non UI thread
		try {
		    project.open(/* progress monitor */null);
		} catch (CoreException e) {
		    throw new RuntimeException(e);
		}
		conn[0] = ConnectionManager.getInstance()
			.getOrCreateDefaultConnection(project);
	    }
	};
	IProgressService ps = PlatformUI.getWorkbench().getProgressService();
	try {
	    if (Thread.currentThread() == Display.getDefault().getThread()) {
		ps.busyCursorWhile(operation);
	    } else {
		operation.run(null);
	    }
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
	return conn[0];
    }

    public RiverObject[] evaluate(String... expressions) throws RecognitionException,
	    SecurityException, IllegalArgumentException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	List<RiverObject> result = new LinkedList<RiverObject>();
	for (String expressionString : expressions) {
	    Expression expression = parse(expressionString).getExpression();
	    if (expression != null) {
		result.add(interpreter.evaluate(expression));
	    } else {
		result.add(null);
	    }
	}
	return result.toArray(new RiverObject[0]);
    }

    public ParseResult parse(String expressionString) throws RecognitionException {
	ClassParserFactory factory = new ClassParserFactory();
	ClassLexer lexer = factory.createLexer(new ANTLRStringStream(expressionString));
	generated.ClassParser parser = factory.createParser(new TokenRewriteStream(lexer), conn);
	BitSet follows = new BitSet();
	follows.add(1); // EndOfRule, for top-level rule meaning EOF
	parser.pushFollow(follows);
	Expression e = (Expression) parser.dataaccess_expressions_expression();
	parser.popFollow();

	List<String> errors = new LinkedList<String>();
	if (parser.input.LA(1) != -1) {
	    // not matched up to EOF
	    errors.add("Not parsed up to EOF. Unparsed text:\n"
		    + parser.input.toString(parser.input.index(), parser.input.size() - 1));
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

	Collection<JmiException> constraintViolations = null;
	if (e != null) {
	    constraintViolations  = e.refVerifyConstraints(/* deepVerify */true);
	}
	// append constraint violations to result (for display on console)
	if (constraintViolations != null) {
	    for (JmiException constraintViolation : constraintViolations) {
		log.severe("Constraint violation: " + constraintViolation.getMessage()
			+ " on element " + constraintViolation.getObjectInError());
		errors.add("Constraint violation: " + constraintViolation.getMessage()
			+ " on element " + constraintViolation.getObjectInError());
	    }
	}
	return new ParseResult(errors, constraintViolations, e);
    }

    public ExecuteResult execute(String... statements) throws RecognitionException,
	    SecurityException, IllegalArgumentException {
	List<RiverObject> result = new LinkedList<RiverObject>();
	List<String> errors = new LinkedList<String>();
	Collection<JmiException> constraintViolations = null;

	for (String statementString : statements) {
	    generated.ClassParser parser = createParser(statementString);
	    restoreParserState(parser);

	    // parse statement, pretending it is the main rule, requiring EOF at end of stream
	    BitSet follows = new BitSet();
	    follows.add(1); // EndOfRule, for top-level rule meaning EOF
	    follows.add(ClassParser.SEMICOLON); // permit ";"-token as (unnecessary) end of statement
            parser.pushFollow(follows);
	    Statement statement = (Statement) parser.behavioral_actions_statement();
	    parser.popFollow();
	    if (parser.input.LA(1) != -1) {
		// not matched up to EOF
		errors.add("Not parsed up to EOF. Unparsed text:\n"+
			parser.input.toString(parser.input.index(), parser.input.size()-1));
	    }
	    // append unresolved references to result (for display on console)
	    if (!parser.setDelayedReferencesAfterParsing()) {
		for (DelayedReference ref : parser.getUnresolvedReferences()) {
			if(!ref.isOptional()) {
				log.warning("Unresolved reference: " + ref.toString());
				errors.add("Unresolved reference: " + ref.toString());
			}
		}
	    }
	    for (ParsingError err:parser.getInjector().getErrorList()) {
		errors.add(err.getMessage());
	    }

	    if (statement != null) {
		statement.setBlock(contextBlock);
		constraintViolations = contextBlock.refVerifyConstraints(/* deepVerify */true);
		saveParserState(parser);
		interpreter.push(stackFrame);
		try {
		    result.add(interpreter.evaluate(statement));
		} catch (Throwable t) {
		    if (errors.size() + (constraintViolations == null ? 0 : constraintViolations.size()) > 0) {
			// Parser already had errors, so runtime failure was to be expected; simply log
			log.info("Exception during execution: "+t.getMessage());
			errors.add(t.getMessage());
		    } else {
			// probably an internal error
			log.severe("Error during execution although parser didn't find any errors: "+
				t.getMessage());
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
		for (JmiException constraintViolation : constraintViolations) {
		    log.severe("Constraint violation: " + constraintViolation.getMessage()
			    + " on element " + constraintViolation.getObjectInError());
		    errors.add("Constraint violation: "
			    + constraintViolation.getMessage() + " on element "
			    + constraintViolation.getObjectInError());
		}
	    }
	}
	return new ExecuteResult(result.toArray(new RiverObject[0]), errors.toArray(new String[0]));
    }

    /**
     * Factory method for creating a parser object from a statement string.
     * 
     * @param statementString
     * @return
     */
    private ClassParser createParser(String statementString) {
	ClassParserFactory factory = new ClassParserFactory();
	ClassLexer lexer = factory.createLexer(new ANTLRStringStream(statementString));
	return factory.createParser(new TokenRewriteStream(lexer), conn);
    }

    /**
     * Helper method to save the internal parser state for correct parsing of further statements.
     * 
     * @param parser
     */
    private void saveParserState(generated.ClassParser parser) {
	contextManager = parser.getContextManager();
	currentContextStack = parser.getCurrentContextStack();
    }

    /**
     * Helper method to restore the internal parser state for correct parsing of subsequent
     * statements.
     * 
     * @param parser
     */
    private void restoreParserState(generated.ClassParser parser) {
	if (contextManager != null) {
	    parser.initParser(contextManager, currentContextStack);
	} else {
	    parser.addContext(new ResolvedModelElementProxy(contextBlock), "block");
	}
    }

    /**
     * Getter method for external inspection of the runtime context. Must be public but not intended
     * for public usage.
     * 
     * @return
     */
    public Block getContextBlock() {
	return contextBlock;
    }

    public BlockWrapper getInterpreterOutermostBlockWrapper() {
	return ((BlockWrapper) currentContextStack.peek().getRealObject());
    }

    /**
     * Getter method for external inspection of the runtime stack. Must be public but not inteded
     * for public usage.
     * 
     * @return
     */
    public StackFrame getStackFrame() {
	return stackFrame;
    }

    public RiverInterpreter getInterpreter() {
	return interpreter;
    }

    public Connection getConnection() {
	return conn;
    }

}
