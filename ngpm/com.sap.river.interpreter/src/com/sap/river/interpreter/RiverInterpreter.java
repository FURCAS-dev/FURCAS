package com.sap.river.interpreter;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import persistence.actions.Delete;
import persistence.actions.Rollback;
import persistence.actions.Store;
import persistence.expressions.All;
import persistence.expressions.Commit;
import ui.templates.StringTemplate;
import behavioral.actions.AddLink;
import behavioral.actions.Assignment;
import behavioral.actions.Block;
import behavioral.actions.ExpressionStatement;
import behavioral.actions.Foreach;
import behavioral.actions.IfElse;
import behavioral.actions.NamedValueDeclaration;
import behavioral.actions.RemoveLink;
import behavioral.actions.Return;
import behavioral.actions.Statement;
import behavioral.actions.WhileLoop;

import com.sap.ap.metamodel.formatter.StringFormatter;
import com.sap.river.interpreter.LinkContainer.ObjectAndRemoteAssociationEnd;
import com.sap.river.interpreter.expressions.AllInterpreter;
import com.sap.river.interpreter.expressions.AnonymousFunctionExpressionInterpreter;
import com.sap.river.interpreter.expressions.AsListInterpreter;
import com.sap.river.interpreter.expressions.AssociationEndNavigationInterpreter;
import com.sap.river.interpreter.expressions.BinaryLiteralInterpreter;
import com.sap.river.interpreter.expressions.BooleanLiteralInterpreter;
import com.sap.river.interpreter.expressions.DimensionExpressionInterpreter;
import com.sap.river.interpreter.expressions.EqualsInterpreter;
import com.sap.river.interpreter.expressions.ExcludingAtInterpreter;
import com.sap.river.interpreter.expressions.ExcludingInterpreter;
import com.sap.river.interpreter.expressions.FunctionFromMethodExpressionInterpreter;
import com.sap.river.interpreter.expressions.HeadInterpreter;
import com.sap.river.interpreter.expressions.IncludingAtInterpreter;
import com.sap.river.interpreter.expressions.IncludingInterpreter;
import com.sap.river.interpreter.expressions.IterateInterpreter;
import com.sap.river.interpreter.expressions.MethodCallInterpreter;
import com.sap.river.interpreter.expressions.NumberLiteralInterpreter;
import com.sap.river.interpreter.expressions.ObjectCountInterpreter;
import com.sap.river.interpreter.expressions.ObjectCreationInterpreter;
import com.sap.river.interpreter.expressions.ObjectLiteralInterpreter;
import com.sap.river.interpreter.expressions.ReplaceInterpreter;
import com.sap.river.interpreter.expressions.SelectionInterpreter;
import com.sap.river.interpreter.expressions.SignatureCallInterpreter;
import com.sap.river.interpreter.expressions.SnapshotInterpreter;
import com.sap.river.interpreter.expressions.StringLiteralInterpreter;
import com.sap.river.interpreter.expressions.TailInterpreter;
import com.sap.river.interpreter.expressions.TernaryInterpreter;
import com.sap.river.interpreter.expressions.ThisInterpreter;
import com.sap.river.interpreter.expressions.TimePointLiteralInterpreter;
import com.sap.river.interpreter.expressions.VariableExpressionInterpreter;
import com.sap.river.interpreter.nativestdlib.BinaryInterpreter;
import com.sap.river.interpreter.nativestdlib.BooleanInterpreter;
import com.sap.river.interpreter.nativestdlib.CalendarInterpreter;
import com.sap.river.interpreter.nativestdlib.NumberInterpreter;
import com.sap.river.interpreter.nativestdlib.StringInterpreter;
import com.sap.river.interpreter.nativestdlib.TimepointInterpreter;
import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.ConvertedMultiObject;
import com.sap.river.interpreter.objects.EntityObject;
import com.sap.river.interpreter.objects.FunctionFromMethodObject;
import com.sap.river.interpreter.objects.FunctionObject;
import com.sap.river.interpreter.objects.Link;
import com.sap.river.interpreter.objects.MultiValuedObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.objects.ValueObject;
import com.sap.river.interpreter.repository.EntityCreation;
import com.sap.river.interpreter.repository.EntityDeletion;
import com.sap.river.interpreter.repository.Repository;
import com.sap.river.interpreter.repository.RepositoryObject;
import com.sap.river.interpreter.repository.Snapshot;
import com.sap.river.interpreter.repository.SnapshotIdentifier;
import com.sap.river.interpreter.repository.simpleimpl.FixedSnapshot;
import com.sap.river.interpreter.signatureimplementations.BlockInterpreter;
import com.sap.river.interpreter.signatureimplementations.CellSetInterpreter;
import com.sap.river.interpreter.signatureimplementations.LinkAdditionInterpreter;
import com.sap.river.interpreter.signatureimplementations.LinkRemovalInterpreter;
import com.sap.river.interpreter.signatureimplementations.LinkSettingInterpreter;
import com.sap.river.interpreter.signatureimplementations.LinkTraversalInterpreter;
import com.sap.river.interpreter.signatureimplementations.StringTemplateInterpreter;
import com.sap.river.interpreter.statements.AddLinkInterpreter;
import com.sap.river.interpreter.statements.AssignmentInterpreter;
import com.sap.river.interpreter.statements.CommitInterpreter;
import com.sap.river.interpreter.statements.DeleteInterpreter;
import com.sap.river.interpreter.statements.ExpressionStatementInterpreter;
import com.sap.river.interpreter.statements.ForeachInterpreter;
import com.sap.river.interpreter.statements.IfInterpreter;
import com.sap.river.interpreter.statements.NamedValueDeclarationInterpreter;
import com.sap.river.interpreter.statements.RemoveLinkInterpreter;
import com.sap.river.interpreter.statements.ReturnInterpreter;
import com.sap.river.interpreter.statements.RollbackInterpreter;
import com.sap.river.interpreter.statements.StoreInterpreter;
import com.sap.river.interpreter.statements.WhileInterpreter;
import com.sap.river.interpreter.util.Bag;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

import data.classes.ActualObjectParameter;
import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.ConverterBetweenParametrizations;
import data.classes.LinkAddition;
import data.classes.LinkRemoval;
import data.classes.LinkSetting;
import data.classes.LinkTraversal;
import data.classes.MethodSignature;
import data.classes.NativeImpl;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.analytics.CellSet;
import dataaccess.analytics.DimensionExpression;
import dataaccess.expressions.AssociationEndNavigationExpression;
import dataaccess.expressions.Equals;
import dataaccess.expressions.Expression;
import dataaccess.expressions.FunctionCallExpression;
import dataaccess.expressions.MethodCallExpression;
import dataaccess.expressions.ObjectCount;
import dataaccess.expressions.ObjectCreationExpression;
import dataaccess.expressions.Replace;
import dataaccess.expressions.This;
import dataaccess.expressions.VariableExpression;
import dataaccess.expressions.collectionexpressions.Excluding;
import dataaccess.expressions.collectionexpressions.ExcludingAt;
import dataaccess.expressions.collectionexpressions.Including;
import dataaccess.expressions.collectionexpressions.IncludingAt;
import dataaccess.expressions.collectionexpressions.Iterate;
import dataaccess.expressions.fp.AnonymousFunctionExpr;
import dataaccess.expressions.fp.FunctionFromMethodExpr;
import dataaccess.expressions.literals.BinaryLiteral;
import dataaccess.expressions.literals.BooleanLiteral;
import dataaccess.expressions.literals.NumberLiteral;
import dataaccess.expressions.literals.ObjectLiteral;
import dataaccess.expressions.literals.StringLiteral;
import dataaccess.expressions.literals.TimePointLiteral;

/**
 * An interpreter for River models. The entry point is an {@link Expression}
 * that will be evaluated or a {@link SignatureImplementation} or a
 * {@link Statement} that will be executed.
 * <p>
 * 
 * An interpreter is intended to be used to handle a single request at a time.
 * When serialized, multiple calls can come in from different threads. In other
 * words, the interpreter does not pertain to a single particular thread.
 * However, if multiple requests are to be handled in parallel, use
 * {@link #spawn()} to get an interpreter that shares the state of this
 * interpreter except for having a new, separate call stack.
 * <p>
 * 
 * The class is <tt>synchronized</tt> because only one Java thread should be
 * using it at a time. An interpreter should be {@link #spawn() spawned} in
 * order to use it in a different rhread.
 * <p>
 * 
 * TODO how do the contents of the transactionBuffer blend into the contents of
 * the linkContainer? When an instance is created (ObjectCreationExpression), it
 * has no links attached. The object will have a <tt>null</tt> snapshot. The
 * link container can know that if it doesn't contain any links for it, it won't
 * find any in the repository either because without a snapshot an entity won't
 * be stored in the repository.
 * <p>
 * 
 * @author Axel Uhl (D043530)
 */
public class RiverInterpreter {
    /**
     * The stack of {@link StackFrame}s. Always valid, but possibly empty when
     * currently no call is active in this interpreter. The element obtained by
     * {@link Stack#peek()} is the currently valid frame. Frames that are
     * {@link StackFrame#getScopeParent() scope parent} of another frame are
     * also contained on this stack. This means that the stack is a superset of
     * frames corresponding to the call hierarchy. It moreover reflects block
     * nesting.
     */
    private Stack<StackFrame> callstack;
    private MofClassInterpreterFactory<Expression> expressionInterpreterFactory;
    private MofClassInterpreterFactory<Statement> statementInterpreterFactory;
    private MofClassInterpreterFactory<SignatureImplementation> signatureImplementationInterpreterFactory;

    /**
     * This is where interpreter clients may register interpreters that can
     * handle all natively-implemented operations of a class. Keys are the names
     * of the class whose native method implementations are handled by the
     * respective value (the interpreter).
     */
    private NativeInterpreterFactory nativeInterpreterFactory;
    private LinkContainer linkContainer;
    private TransactionBuffer transactionBuffer;
    private Repository repository;

    /**
     * Tells if a call of one of {@link #evaluate(Expression)},
     * {@link #evaluate(SignatureImplementation)} or
     * {@link #evaluate(Statement)} is currently running. Iff <tt>true</tt>,
     * this interpreter will show up in its {@link #parent}'s
     * {@link #runningChildren}, if it has a parent.
     */
    private boolean running;

    /**
     * Tells if this interpreter has been explicitly terminated by a call to
     * {@link #terminate}. This may be particularly useful for an interpreter
     * used for debugging when a launch has finally terminated.
     */
    private boolean terminated;

    /**
     * It is useful for an interpreter to know the interpreter that spawned it.
     * Whenever the child will start executing, it can enter itself into the
     * parent interpreter's {@link #runningChildren} so that a parent always
     * knows which of its children is currently executing. This is particularly
     * useful for a debug view.
     */
    private RiverInterpreter parent;

    /**
     * An interpreter can {@link #spawn() spawn} children, usually meaning an
     * own thread of execution. Each interpreter resultin from {@link #spawn()}
     * is added to this set.
     */
    private Set<RiverInterpreter> runningChildren;

    /**
     * If <tt>null</tt>, the interpreter operates in "run" mode; otherwise, it
     * operates in "debug" mode and will negotiate with the debug session when
     * to stop, suspend and resume execution.
     */
    private DebugSession debugSession;

    /**
     * The snapshot to be used when reading from the repository without a
     * specified snapshot. May be <tt>null</tt> which means that the next
     * repository interaction is free to set this to what then is considered to
     * be the "current" snapshot.
     */
    private SnapshotIdentifier defaultSnapshot;

    private Connection connection;
    
    /**
     * Used for polymorphic method resolution.
     */
    private MethodCallResolver methodCallResolver;

    /**
     * Registers the sub-interpreters for various parts of the language. It
     * registers those sub-interpreters (e.g., for expressions and statements)
     * that it knows. Clients may use the respective <tt>register...</tt>
     * methods to register more or other interpreters.
     * 
     * @param repository
     *            used to load/store objects durably / persistently
     */
    public RiverInterpreter(Connection conn, Repository repository) {
	this.connection = conn;
	methodCallResolver = Activator.getDefault().getMethodCallResolver();
	setCallstack(new Stack<StackFrame>());
	nativeInterpreterFactory = new NativeInterpreterFactory();
	expressionInterpreterFactory = new MofClassInterpreterFactory<Expression>();
	statementInterpreterFactory = new MofClassInterpreterFactory<Statement>();
	signatureImplementationInterpreterFactory = new MofClassInterpreterFactory<SignatureImplementation>();
	runningChildren = new HashSet<RiverInterpreter>();
	this.repository = repository;
	linkContainer = new LinkContainer(getRepository());
	transactionBuffer = new TransactionBuffer();
	setDefaultSnapshot(repository.getTrunkIdentifier());
	initInterpreterFactories(conn);
    }

    /**
     * Like {@link RiverInterpreter#RiverInterpreter(Connection, Repository)},
     * only that also a {@link #debugSession debug session} can be set.
     */
    public RiverInterpreter(Connection conn, Repository repository, DebugSession debugSession) {
	this(conn, repository);
	setDebugSession(debugSession);
    }

    private void initInterpreterFactories(Connection conn) {
	initExpressionInterpreterFactory(conn);
	initStatementInterpreterFactory(conn);
	initSignatureImplementationInterpreterFactory(conn);
	initNativeInterpreterFactory(conn);
    }

    private void initExpressionInterpreterFactory(Connection conn) {
	// expressions
	getExpressionInterpreterFactory().registerInterpreter(StringLiteralInterpreter.class,
		conn.getClass(StringLiteral.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(NumberLiteralInterpreter.class,
		conn.getClass(NumberLiteral.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(TimePointLiteralInterpreter.class,
		conn.getClass(TimePointLiteral.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(BooleanLiteralInterpreter.class,
		conn.getClass(BooleanLiteral.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(BinaryLiteralInterpreter.class,
		conn.getClass(BinaryLiteral.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(ObjectLiteralInterpreter.class,
		conn.getClass(ObjectLiteral.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(MethodCallInterpreter.class,
		conn.getClass(MethodCallExpression.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(SignatureCallInterpreter.class,
		conn.getClass(FunctionCallExpression.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(VariableExpressionInterpreter.class,
		conn.getClass(VariableExpression.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(ThisInterpreter.class,
		conn.getClass(This.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(EqualsInterpreter.class,
		conn.getClass(Equals.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(ObjectCreationInterpreter.class,
		conn.getClass(ObjectCreationExpression.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(FunctionFromMethodExpressionInterpreter.class,
		conn.getClass(FunctionFromMethodExpr.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(AnonymousFunctionExpressionInterpreter.class,
		conn.getClass(AnonymousFunctionExpr.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(AssociationEndNavigationInterpreter.class,
		conn.getClass(AssociationEndNavigationExpression.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(IterateInterpreter.class,
		conn.getClass(Iterate.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(DimensionExpressionInterpreter.class,
		conn.getClass(DimensionExpression.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(IncludingInterpreter.class,
		conn.getClass(Including.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(ExcludingInterpreter.class,
		conn.getClass(Excluding.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(IncludingAtInterpreter.class,
		conn.getClass(IncludingAt.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(ExcludingAtInterpreter.class,
		conn.getClass(ExcludingAt.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(ObjectCountInterpreter.class,
		conn.getClass(ObjectCount.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(AllInterpreter.class,
		conn.getClass(All.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(CommitInterpreter.class,
		conn.getClass(Commit.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(ReplaceInterpreter.class,
		conn.getClass(Replace.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(SnapshotInterpreter.class,
		conn.getClass(persistence.expressions.Snapshot.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(AsListInterpreter.class,
		conn.getClass(dataaccess.expressions.AsList.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(HeadInterpreter.class,
		conn.getClass(dataaccess.expressions.Head.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(TailInterpreter.class,
		conn.getClass(dataaccess.expressions.Tail.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(TernaryInterpreter.class,
		conn.getClass(dataaccess.expressions.Ternary.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(SelectionInterpreter.class,
		conn.getClass(dataaccess.query.Selection.CLASS_DESCRIPTOR).refMetaObject());
    }

    private void initStatementInterpreterFactory(Connection conn) {
	// statements
	getStatementInterpreterFactory().registerInterpreter(ReturnInterpreter.class,
		conn.getClass(Return.CLASS_DESCRIPTOR).refMetaObject());
	getStatementInterpreterFactory().registerInterpreter(NamedValueDeclarationInterpreter.class,
		conn.getClass(NamedValueDeclaration.CLASS_DESCRIPTOR).refMetaObject());
	getStatementInterpreterFactory().registerInterpreter(IfInterpreter.class,
		conn.getClass(IfElse.CLASS_DESCRIPTOR).refMetaObject());
	getStatementInterpreterFactory().registerInterpreter(WhileInterpreter.class,
		conn.getClass(WhileLoop.CLASS_DESCRIPTOR).refMetaObject());
	getStatementInterpreterFactory().registerInterpreter(ForeachInterpreter.class,
		conn.getClass(Foreach.CLASS_DESCRIPTOR).refMetaObject());
	getStatementInterpreterFactory().registerInterpreter(AssignmentInterpreter.class,
		conn.getClass(Assignment.CLASS_DESCRIPTOR).refMetaObject());
	getStatementInterpreterFactory().registerInterpreter(ExpressionStatementInterpreter.class,
		conn.getClass(ExpressionStatement.CLASS_DESCRIPTOR).refMetaObject());
	getStatementInterpreterFactory().registerInterpreter(AddLinkInterpreter.class,
		conn.getClass(AddLink.CLASS_DESCRIPTOR).refMetaObject());
	getStatementInterpreterFactory().registerInterpreter(RemoveLinkInterpreter.class,
		conn.getClass(RemoveLink.CLASS_DESCRIPTOR).refMetaObject());
	getStatementInterpreterFactory().registerInterpreter(StoreInterpreter.class,
		conn.getClass(Store.CLASS_DESCRIPTOR).refMetaObject());
	getStatementInterpreterFactory().registerInterpreter(DeleteInterpreter.class,
		conn.getClass(Delete.CLASS_DESCRIPTOR).refMetaObject());
	getStatementInterpreterFactory().registerInterpreter(RollbackInterpreter.class,
		conn.getClass(Rollback.CLASS_DESCRIPTOR).refMetaObject());
    }

    private void initSignatureImplementationInterpreterFactory(Connection conn) {
	// signature implementations
	getSignatureImplementationInterpreterFactory().registerInterpreter(NativeInterpreter.class,
		conn.getClass(NativeImpl.CLASS_DESCRIPTOR).refMetaObject());
	getSignatureImplementationInterpreterFactory().registerInterpreter(BlockInterpreter.class,
		conn.getClass(Block.CLASS_DESCRIPTOR).refMetaObject());
	getSignatureImplementationInterpreterFactory().registerInterpreter(LinkTraversalInterpreter.class,
		conn.getClass(LinkTraversal.CLASS_DESCRIPTOR).refMetaObject());
	getSignatureImplementationInterpreterFactory().registerInterpreter(LinkAdditionInterpreter.class,
		conn.getClass(LinkAddition.CLASS_DESCRIPTOR).refMetaObject());
	getSignatureImplementationInterpreterFactory().registerInterpreter(LinkRemovalInterpreter.class,
		conn.getClass(LinkRemoval.CLASS_DESCRIPTOR).refMetaObject());
	getSignatureImplementationInterpreterFactory().registerInterpreter(LinkSettingInterpreter.class,
		conn.getClass(LinkSetting.CLASS_DESCRIPTOR).refMetaObject());
	getSignatureImplementationInterpreterFactory().registerInterpreter(StringTemplateInterpreter.class,
		conn.getClass(StringTemplate.CLASS_DESCRIPTOR).refMetaObject());
	getSignatureImplementationInterpreterFactory().registerInterpreter(CellSetInterpreter.class,
		conn.getClass(CellSet.CLASS_DESCRIPTOR).refMetaObject());
    }

    private void initNativeInterpreterFactory(Connection conn) {
	final String NUMBER_CLASS_NAME = "Number";
	final String STRING_CLASS_NAME = "String";
	final String BOOLEAN_CLASS_NAME = "Boolean";
	final String BINARY_CLASS_NAME = "Binary";
	final String TIMEPOINT_CLASS_NAME = "TimePoint";
	final String SNAPSHOT_CLASS_NAME = "Snapshot";
	final String CALENDAR_CLASS_NAME = "Calendar";
	registerNativeImplementationInterpreter(NumberInterpreter.class, findClass(NUMBER_CLASS_NAME));
	registerNativeImplementationInterpreter(StringInterpreter.class, findClass(STRING_CLASS_NAME));
	registerNativeImplementationInterpreter(BooleanInterpreter.class, findClass(BOOLEAN_CLASS_NAME));
	registerNativeImplementationInterpreter(BinaryInterpreter.class, findClass(BINARY_CLASS_NAME));
	registerNativeImplementationInterpreter(TimepointInterpreter.class, findClass(TIMEPOINT_CLASS_NAME));
	registerNativeImplementationInterpreter(com.sap.river.interpreter.nativestdlib.SnapshotInterpreter.class, findClass(SNAPSHOT_CLASS_NAME));
	registerNativeImplementationInterpreter(CalendarInterpreter.class, findClass(CALENDAR_CLASS_NAME));
    }

    /**
     * Spawns a new interpreter for parallel execution. This interpreter re-uses
     * the registries for subinterpreters for expressions, statements etc., the
     * MOIN {@link #connection}, the {@link #debugSession} as well as the shared
     * state consisting of the {@link #linkContainer}. The spawned interpreter
     * has a new {@link #callstack call stack} that is initialized with the
     * <tt>parent</tt> interpreter's top stack frame.
     * <p>
     * 
     * This means that a spawned interpreter may not have all of the first stack
     * frame's scope parent frames on its own stack. If this first frame happens
     * to have a scope parent, this is referenced by a regular Java reference.
     * <p>
     * 
     * The spawned interpreter created here will start out with an empty set of
     * {@link #runningChildren} child interpreters. It starts out in non-
     * {@link #running running} mode.
     * <p>
     */
    private RiverInterpreter(RiverInterpreter parent) {
	this.parent = parent;
	methodCallResolver = parent.getMethodCallResolver();
	expressionInterpreterFactory = parent.getExpressionInterpreterFactory();
	statementInterpreterFactory = parent.getStatementInterpreterFactory();
	signatureImplementationInterpreterFactory = parent.getSignatureImplementationInterpreterFactory();
	linkContainer = parent.getLinkContainer();
	repository = parent.getRepository();
	transactionBuffer = parent.transactionBuffer;
	nativeInterpreterFactory = parent.getNativeInterpreterFactory();
	connection = parent.getConnection();
	defaultSnapshot = parent.getDefaultSnapshot();
	runningChildren = new HashSet<RiverInterpreter>();
	setCallstack(new Stack<StackFrame>());
	if (parent.getCallstack().size() > 0) {
	    getCallstack().push(parent.getCallstack().peek());
	}
	setDebugSession(parent.getDebugSession());
    }

    public void registerExpressionInterpreter(Class<Interpreter<Expression>> interpreter, MofClass... classes) {
	getExpressionInterpreterFactory().registerInterpreter(interpreter, classes);
    }

    public void registerStatementInterpreter(Class<Interpreter<Statement>> interpreter, MofClass... classes) {
	getStatementInterpreterFactory().registerInterpreter(interpreter, classes);
    }

    public void registerSignatureImplementationInterpreter(Class<Interpreter<SignatureImplementation>> interpreter, MofClass... classes) {
	getSignatureImplementationInterpreterFactory().registerInterpreter(interpreter, classes);
    }
    
    public void registerNativeImplementationInterpreter(Class<? extends Interpreter<? extends NativeImpl>> interpreter,
	    SapClass... classes) {
	getNativeInterpreterFactory().registerInterpreter(interpreter, classes);
    }

    /**
     * Obtains the callstack, reflecting block nesting <em>and</em> call
     * structure
     */
    public Stack<StackFrame> getCallstack() {
	return callstack;
    }

    /**
     * Retrieves the stack frame that is one up in the call hierarchy, skipping
     * scope parents. In other words, if <tt>frame</tt> is the stack frame for a
     * method, the frame resulting from this call will be the frame of the
     * caller.
     * <p>
     * 
     * If <tt>frame</tt> is already at the top of the call hierarchy,
     * representing the entry or "main" call into this interpreter, this method
     * returns <tt>null</tt>.
     */
    public StackFrame oneUp(StackFrame frame) {
	StackFrame result = null;
	StackFrame current = frame;
	while (current.getScopeParent() != null) {
	    current = current.getScopeParent();
	}
	int i = getCallstack().indexOf(current) - 1;
	if (i >= 0) {
	    result = getCallstack().get(i);
	}
	return result;
    }

    /**
     * Retrieves the stack frame that is one down in the call hierarchy,
     * skipping scope parents. In other words, if <tt>frame</tt> is the stack
     * frame for a method currently at a method call, the frame resulting from
     * this call will be the frame of the called method.
     * <p>
     * 
     * If <tt>frame</tt> is already at the bottom of the call hierarchy, this
     * method returns <tt>null</tt>.
     */
    public StackFrame oneDown(StackFrame frame) {
	int i = getCallstack().indexOf(frame) + 1;
	StackFrame result = null;
	if (i < getCallstack().size()) {
	    result = getCallstack().get(i);
	    while (i < getCallstack().size() - 1 && getCallstack().get(i + 1).getScopeParent() != null) {
		i++;
		result = getCallstack().get(i);
	    }
	}
	return result;
    }

    private void setCallstack(Stack<StackFrame> callstack) {
	this.callstack = callstack;
    }

    private MofClassInterpreterFactory<Expression> getExpressionInterpreterFactory() {
	return expressionInterpreterFactory;
    }

    private MofClassInterpreterFactory<Statement> getStatementInterpreterFactory() {
	return statementInterpreterFactory;
    }

    private MofClassInterpreterFactory<SignatureImplementation> getSignatureImplementationInterpreterFactory() {
	return signatureImplementationInterpreterFactory;
    }

    public Repository getRepository() {
	return repository;
    }

    /**
     * Mix the contents of the {@link #transactionBuffer} with the contents of
     * the repository for the current default snapshot
     * 
     * @param ofClass
     *            fetch the instances of the class identified by
     *            <tt>ofClass</tt>
     * @param fromSnapshot
     *            a non-<tt>null</tt> object; read from the snapshot specified
     *            or {@link #resolve(SnapshotIdentifier) resolve} in case the
     *            {@link SnapshotIdentifier#getSnapshot()} returns <tt>null</tt>
     *            , then read from that snapshot
     */
    public Collection<EntityObject> all(SapClass ofClass, SnapshotIdentifier fromSnapshot) {
	Set<EntityObject> result = new HashSet<EntityObject>(getRepository().all(ofClass, fromSnapshot));
	if (transactionBufferUpdates(fromSnapshot)) {
	    for (Iterator<EntityCreation> i=transactionBuffer.getEntityCreations(); i.hasNext(); ) {
		EntityObject createdObject = i.next().getObject();
		if (createdObject.getType().getClazz().equals(ofClass)) {
		    result.add(createdObject);
		}
	    }
	    for (Iterator<EntityDeletion> i=transactionBuffer.getEntityDeletions(); i.hasNext(); ) {
		EntityObject deletedObject = i.next().getObject();
		if (deletedObject.getType().getClazz().equals(ofClass)) {
		    result.remove(deletedObject);
		}
	    }
	}
	return result;
    }

    /**
     * @return <tt>true</tt> if the {@link #transactionBuffer}, when
     *         {@link TransactionBuffer#commit(Repository) committed} to the
     *         {@link #repository}, creates a snapshot whose predecessor will be
     *         the one currently identified by <tt>fromSnapshot</tt>.
     */
    private boolean transactionBufferUpdates(SnapshotIdentifier fromSnapshot) {
	boolean result;
	// if the transaction buffer has not yet been assigned a snapshot
	// identifier,
	// it doesn't contain anything yet and its empty "contents" can safely
	// be
	// ignored.
	SnapshotIdentifier updating = transactionBuffer.getUpdatingTag();
	if (updating != null) {
	    result = updating.equals(fromSnapshot);
	} else {
	    result = false;
	}
	return result;
    }

    public Iterable<EntityObject> all(SapClass ofClass, Date fromLastConcurrentSnapshotsBefore) {
	Set<SnapshotIdentifier> snapshots = getRepository().getLastSnapshotsBeforeOrAt(fromLastConcurrentSnapshotsBefore);
	Set<EntityObject> result = new HashSet<EntityObject>();
	for (SnapshotIdentifier si : snapshots) {
	    result.addAll(all(ofClass, si));
	}
	return result;
    }

    /**
     * Selects all instances of <tt>ofClass</tt> from all snapshots known by the
     * {@link #repository}.
     * 
     */
    public Iterable<EntityObject> all(SapClass ofClass) {
	Set<Snapshot> snapshots = getRepository().getAllSnapshots();
	Set<EntityObject> result = new HashSet<EntityObject>();
	for (Snapshot si : snapshots) {
	    result.addAll(all(ofClass, new FixedSnapshot(si)));
	}
	return result;
    }

    /**
     * Returns an {@link Iterable} of all {@link EntityObject}s that were
     * changed. The {@link EntityObject}s are linked to the {@link Snapshot}
     * they have been changed in.
     * 
     * @param ofClass
     *            Specifies the {@link SapClass} of the {@link EntityObject}s to
     *            retrieve
     * @return {@link Iterable} of all {@link EntityObject}s that changed
     */
    public Iterable<EntityObject> allChanged(SapClass ofClass) {
	Set<Snapshot> snapshots = getRepository().getAllSnapshots();
	Map<Snapshot, Set<EntityObject>> entitiesPerSnapshot = new HashMap<Snapshot, Set<EntityObject>>();

	for (Snapshot si : snapshots) {
	    Set<EntityObject> set = new HashSet<EntityObject>();
	    set.addAll(all(ofClass, new FixedSnapshot(si)));
	    entitiesPerSnapshot.put(si, set);
	}

	return linkContainer.removeUnchangedEntities(entitiesPerSnapshot);
    }

    public void storeEntity(EntityObject toStore) {
	Bag<RepositoryObject> expandedComposition = getLinkContainer().getTransientCompositionTree(toStore);
	createRepositoryObjects(expandedComposition);
    }

    /**
     * Records the creation of all objects in <tt>expandedComposition</tt> in
     * the {@link #transactionBuffer}. For links of ordered associations the
     * ordering of links of the same association attached to the same object
     * with their unordered end needs to be determined so that during insertion
     * into the transaction buffer indexes are not messed up.
     */
    private void createRepositoryObjects(Bag<RepositoryObject> expandedComposition) {
	// collect all links; record entity creations first so that link creations
	// are recorded only after their related entity creations have been recorded
	Map<Pair<Association, ClassTypedObject>, TreeMap<Integer, Link>> links =
	    new HashMap<Pair<Association, ClassTypedObject>, TreeMap<Integer, Link>>();
	List<Link> unorderedLinks = new LinkedList<Link>();
	for (RepositoryObject ro : expandedComposition) {
	    if (ro instanceof EntityObject) {
		transactionBuffer.entityCreated((EntityObject) ro);
	    } else {
		Link link = (Link) ro;
		if (link.isOrdered()) {
		    Pair<Association, ClassTypedObject> key = new Pair<Association, ClassTypedObject>(link.getAssociation(), link
			    .getAtOppositeOfOrderedEnd());
		    TreeMap<Integer, Link> tm = links.get(key);
		    if (tm == null) {
			tm = new TreeMap<Integer, Link>();
			links.put(key, tm);
		    }
		    // won't overwrite an existing key because link positions
		    // for same assoc/entity on unordered end are unique
		    tm.put(getLinkContainer().getLinkPosition(link), link);
		} else {
		    unorderedLinks.add(link);
		}
	    }
	}
	for (Pair<Association, ClassTypedObject> key : links.keySet()) {
	    TreeMap<Integer, Link> tm = links.get(key);
	    for (Integer at : tm.keySet()) {
		transactionBuffer.linkCreated(tm.get(at), at);
	    }
	}
	for (Link unorderedLink : unorderedLinks) {
	    transactionBuffer.linkCreated(unorderedLink, null);
	}
    }

    public void deleteEntity(EntityObject toDelete) {
	assert toDelete.isPersistent();
	ObjectAndRemoteAssociationEnd parentAndChildEnd = getLinkContainer().getCompositeParentObjectAndChildAssociationEnd(toDelete);
	if (parentAndChildEnd != null) {
	    ClassTypedObject left;
	    ClassTypedObject right;
	    if (LinkContainer.getSideOfEnd(parentAndChildEnd.getRemoteAssociationEnd()).equals(Side.LEFT)) {
		left = toDelete;
		right = parentAndChildEnd.getObject();
	    } else {
		left = parentAndChildEnd.getObject();
		right = toDelete;
	    }
	    removeLink(left, right, parentAndChildEnd.getRemoteAssociationEnd().getAssociation(),
		    /* should be only one such link, so position doesn't matter */ null);
	}
	Bag<RepositoryObject> expandedComposition = getLinkContainer().getCompositionTree(toDelete);
	deleteRepositoryObjects(expandedComposition);
    }

    /**
     * Records the deletions of all objects in <tt>expandedComposition</tt> in
     * the {@link #transactionBuffer}. For links of ordered associations the
     * ordering of links of the same association attached to the same object
     * with their unordered end needs to be determined so that during recording
     * deletion in the transaction buffer indexes are not messed up.
     */
    private void deleteRepositoryObjects(Bag<RepositoryObject> expandedComposition) {
	Map<Pair<Association, ClassTypedObject>, TreeMap<Integer, Link>> links =
	    new HashMap<Pair<Association, ClassTypedObject>, TreeMap<Integer, Link>>();
	List<EntityObject> entityDeletions = new LinkedList<EntityObject>();
	for (RepositoryObject ro : expandedComposition) {
	    if (ro instanceof EntityObject) {
		entityDeletions.add((EntityObject) ro);
	    } else {
		Link link = (Link) ro;
		if (link.isOrdered()) {
		    Pair<Association, ClassTypedObject> key = new Pair<Association, ClassTypedObject>(link.getAssociation(), link
			    .getAtOppositeOfOrderedEnd());
		    TreeMap<Integer, Link> tm = links.get(key);
		    if (tm == null) {
			tm = new TreeMap<Integer, Link>();
			links.put(key, tm);
		    }
		    tm.put(getLinkContainer().getLinkPosition(link), link);
		} else {
		    transactionBuffer.linkDeleted(link, null);
		}
	    }
	}
	for (Pair<Association, ClassTypedObject> key : links.keySet()) {
	    TreeMap<Integer, Link> tm = links.get(key);
	    int offset = 0;
	    for (Integer at : tm.keySet()) {
		transactionBuffer.linkDeleted(tm.get(at), at-offset);
		offset++; // deletion moves links that are behind deleted link towards lower indexes
	    }
	}
	// Delete entities last to avoid intermediate dangling links where possible
	for (EntityObject eo : entityDeletions) {
	    transactionBuffer.entityDeleted(eo);
	}
    }

    public Snapshot commit() {
	return transactionBuffer.commit(getRepository());
    }

    public void rollback() {
	transactionBuffer.rollback();
    }

    public void push(StackFrame stackFrame) {
	getCallstack().push(stackFrame);
    }

    public void pop() {
	getCallstack().pop();
    }

    /**
     * Tells this interpreter that a child interpreter obtained from
     * {@link #spawn()} started executing something. It will be added to the
     * {@link #runningChildren} set.
     */
    private void addRunningChild(RiverInterpreter child) {
	runningChildren.add(child);
    }

    /**
     * Tells this interpreter that a child interpreter obtained from
     * {@link #spawn()} finished executing and therefore is no longer active. It
     * will be removed from the {@link #runningChildren} set.
     */
    private void removeRunningChild(RiverInterpreter child) {
	runningChildren.remove(child);
    }

    /**
     * The set of currently executing immediate child interpreters that were
     * obtained by calling {@link #spawn()} on this interpreter.
     */
    public Set<RiverInterpreter> getRunningChildren() {
	return Collections.unmodifiableSet(runningChildren);
    }

    /**
     * To be called by every <tt>evaluate</tt> operation that "executes"
     * something. This is to notify the interpreter that something is being
     * executed which may transition the interpreter from the non-running into
     * the running state. If this state transition happens, and the interpreter
     * has a {@link #parent}, it will register as an active child with the
     * parent.
     * <p>
     * 
     * At the end of the <tt>evaluate</tt> operation, {@link #exitEvaluate} must
     * be called with the result returned by this operation.
     * 
     * @param element
     *            TODO
     * 
     * @return the old value of the {@link #running} flag
     */
    private boolean enterEvaluate(RefObject element) {
	boolean result = running;
	if (!result) {
	    if (getParent() != null) {
		getParent().addRunningChild(this);
	    }
	}
	if (getDebugSession() != null) {
	    getDebugSession().aboutToEvaluate(this, element);
	}
	running = true;
	return result;
    }

    /**
     * Sets the {@link #running} flag to <tt>oldRunning</tt>. If the interpreter
     * in in state <tt>running==true</tt> when this method is invoked, and the
     * interpreter has a {@link #parent}, it deregisters this interpreter from
     * its parent because it now is no longer active.
     */
    private void exitEvaluate(boolean oldRunning) {
	if (running && !oldRunning) {
	    if (getParent() != null) {
		getParent().removeRunningChild(this);
	    }
	    if (getDebugSession() != null) {
		getDebugSession().terminated(this);
	    }
	}
	running = oldRunning;
    }

    /**
     * Tells if this interpreter is currently executing or evaluating anything.
     * 
     * @see #running
     * @see #enterEvaluate(RefObject)
     * @see #exitEvaluate(boolean)
     */
    public boolean isRunning() {
	return !terminated && running;
    }

    public RiverObject evaluate(Expression e) throws SecurityException, IllegalArgumentException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	boolean oldRunning = enterEvaluate(e);
	if (e == null) {
	    throw new RuntimeException("Don't know how to evaluate a null expression");
	}
	Interpreter<? extends Expression> interpreter = getExpressionInterpreterFactory().getInterpreterFor(e);
	if (interpreter == null) {
	    throw new RuntimeException("No interpreter for expression of type " + ((MofClass) e.refMetaObject()).getQualifiedName());
	}
	RiverObject result = interpreter.evaluate(this);
	exitEvaluate(oldRunning);
	return result;
    }

    /**
     * If necessary, applies implicit conversion to <tt>ro</tt> into an object
     * that conforms to <tt>targetType</tt>. In particular, if <tt>ro</tt> is a
     * value object that is instance of an object-parameterized class, and the
     * target type definition is of the same class but with different object
     * parameters, the conversion method will be applied. If the <tt>ro</tt>'s
     * actual object parameters already match those of <tt>targetType</tt> or
     * more generally, if <tt>ro</tt> already conforms to <tt>targetType</tt>,
     * no conversion is applied, and <tt>ro</tt> is returned.
     * <p>
     * 
     * If <tt>ro</tt> is a {@link MultiValuedObject} with a
     * {@link ClassTypeDefinition} as its type that has as its <tt>clazz</tt> a
     * {@link SapClass#isValueType() value type} class, a "copy on write"
     * strategy is applied: if recursively any object contained is the
     * multi-object requires conversion, the multi-object is cloned and the
     * contained value(s) requiring conversion is replaced in the clone.
     */
    public RiverObject convert(RiverObject ro, TypeDefinition targetType) {
	// TODO refactor such that this becomes a method on RiverObject that can be used polymorphically
	RiverObject result = ro;
	if (ro instanceof ValueObject) {
	    if (!(targetType.getInnermost() instanceof ClassTypeDefinition)) {
		throw new RuntimeException("Cannot convert a value object into the non class-like type "
			+ StringFormatter.toString(targetType));
	    }
	    try {
		result = convert((ValueObject) ro, (ClassTypeDefinition) targetType.getInnermost());
	    } catch (Exception e) {
		throw new RuntimeException(e);
	    }
	} else {
	    TypeDefinition innermost = ro.getType().getInnermost();
	    if (ro instanceof MultiValuedObject && innermost instanceof ClassTypeDefinition
		&& ((ClassTypeDefinition) innermost).getClazz().isValueType()) {
		return new ConvertedMultiObject((MultiValuedObject) ro, targetType, this);
	    }
	}
	return result;
    }

    /**
     * When a value is used where an object of an object-parameterized value
     * type is expected, a conversion may be necessary in case the actual object
     * parameters of the object's type do not match the target type's actual
     * object parameters. For example, if a <tt>Number|3|</tt> object is used
     * where a <tt>Number|1|</tt> is expected, the precision must be reduced by
     * applying a rounding conversion.
     * 
     * @param vo
     *            the object to convert
     * @param targetType
     *            the type into which to convert <tt>vo</tt>; it is assumed that
     *            <tt>vo.getType().conformsTo(targetType)</tt> holds.
     * @return <tt>vo</tt> in case no conversion is necessary, or the converted
     *         object as computed by the conversion routine on
     *         <tt>vo.getType()</tt>
     * @throws RuntimeException
     *             in case a conversion would be necessary but <tt>vo</tt>'s
     *             type does not offer a conversion routine
     * @see {@link SapClass#getConverterBetweenParametrizations()}
     */
    public ValueObject convert(ValueObject vo, ClassTypeDefinition targetType) throws SecurityException, IllegalArgumentException,
	    JmiException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
	List<RiverObject> voParameterValues = vo.getActualObjectParameters();
	List<RiverObject> targetParameterValues = new LinkedList<RiverObject>();
	for (ActualObjectParameter aop : targetType.getObjectParameters()) {
	    RiverObject targetParameterValue = evaluate(aop.getValue());
	    targetParameterValues.add(targetParameterValue);
	}
	if (targetParameterValues.size() < targetType.getClazz().getFormalObjectParameters().size()) {
	    for (int i = targetParameterValues.size(); i < targetType.getClazz().getFormalObjectParameters().size(); i++) {
		RiverObject defaultParameterValue = evaluate(targetType.getClazz().getFormalObjectParameters().get(i).getDefaultValue());
		targetParameterValues.add(defaultParameterValue);
	    }
	}
	ValueObject result;
	// TODO should this use logicallyEquals? What about an entity object
	// used as parameter for a value class?
	if (!voParameterValues.equals(targetParameterValues)) {
	    // conversion necessary; find conversion method and invoke on vo
	    // with targetType's
	    // actual parameters as arguments:
	    ConverterBetweenParametrizations converter = vo.getType().getClazz().getConverterBetweenParametrizations();
	    if (converter == null) {
		throw new RuntimeException("No implicit conversion between " + vo.getType().getClazz().getName() + " and "
			+ targetType.getClazz().getName());
	    }
	    MethodSignature converterSig = converter.getConversionMethod();
	    FunctionFromMethodObject ffmo = new FunctionFromMethodObject(/* type */null, converterSig.getImplementation(), vo);
	    StackFrame newStackFrame = pushArgumentsToStackFrame(targetParameterValues, ffmo);
	    push(newStackFrame);
	    try {
		result = (ValueObject) ffmo.evaluate(this);
	    } finally {
		pop();
	    }
	} else {
	    result = vo;
	}
	return result;
    }

    /**
     * The formal parameters are taken from <tt>evaluator</tt>'s
     * implementation's signature. They may be distinct from the parameters in
     * the signature to which the call was statically bound and may only
     * <em>conform</tt> but not be the same. The <tt>values</tt> are bound
     * positionally which makes it important that <tt>values</tt> is a {@link List} and not just
     * a {@link Collection}.<p>
     * 
     * Before passing, each argument is submitted to {@link #convert(RiverObject, TypeDefinition)}
     * to ensure that any assignment conversion required will be performed. This particularly
     * includes the implicit conversions defined for object-parameterized types where the object's
     * converter will be invoked if the target type has different actual object parameters than
     * the parameter object.
     * 
     * @return a new stack frame in which for each formal parameter as defined
     *         in <tt>evaluator</tt>'s implementation's signature a
     *         {@link RiverObject} has been registered from <tt>values</tt>
     */
    public StackFrame pushArgumentsToStackFrame(List<RiverObject> values, FunctionObject evaluator) {
	StackFrame result = new StackFrame(); // constructs a new stack frame
					      // with no scope parent
	Iterator<RiverObject> v = values.iterator();
	for (Parameter parameter : evaluator.getImplementation().getImplementedSignature().getInput()) {
	    RiverObject paramValue = v.next();
	    RiverObject convertedParamValue = convert(paramValue, parameter.getType());
	    result.enterValue(parameter, convertedParamValue);
	}
	return result;
    }

    /**
     * Returns either <tt>null</tt> or a {@link ReturnInterpreter.ReturnResult}
     * which wraps the real result expected to correspond with the signature's
     * output specification, such as the return value explicitly returned by a
     * block; or a regular {@link RiverObject} that is not a
     * {@link ReturnInterpreter.ReturnResult} which indicates the last value
     * computed inside the signature implementation. Such an object does not
     * indicate a return value for the signature but rather a value that may be
     * used during debugging or for display, e.g., in a console.
     * <p>
     * 
     * The reason for using wrapped return results for explicit returns is that
     * nested blocks may either terminate normally (such as, e.g., in a
     * <tt>foreach</tt> loop or a <tt>while</tt> loop) or by a <tt>return</tt>
     * statement. In the latter case, the surrounding blocks are all expected to
     * terminate as well, passing on the return result up to the signature to
     * which this is really the implementation (a <tt>foreach</tt> block is not
     * an implementation of a signature, although type-wise it still inherits
     * from {@link SignatureImplementation}). The interpreter of the signature
     * call will remove the {@link ReturnInterpreter.ReturnResult} wrapper and
     * simply return the inner object.
     */
    public RiverObject evaluate(SignatureImplementation implementation) throws SecurityException, IllegalArgumentException,
	    NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
	boolean oldRunning = enterEvaluate(implementation);
	if (getDebugSession() != null) {
	    getCallstack().peek().setCurrentlyExecutingImplementationOf(implementation.getImplementedSignature());
	}
	Interpreter<? extends SignatureImplementation> interpreter = getSignatureImplementationInterpreterFactory().getInterpreterFor(implementation);
	RiverObject result = interpreter.evaluate(this);
	if (getDebugSession() != null) {
	    getCallstack().peek().setCurrentlyExecutingImplementationOf(null);
	}
	exitEvaluate(oldRunning);
	return result;
    }

    public RiverObject evaluate(Statement statement) throws SecurityException, IllegalArgumentException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	boolean oldRunning = enterEvaluate(statement);
	Interpreter<? extends Statement> interpreter = getStatementInterpreterFactory().getInterpreterFor(statement);
	RiverObject result = interpreter.evaluate(this);
	exitEvaluate(oldRunning);
	return result;
    }

    public Connection getConnection() {
	return connection;
    }

    private NativeInterpreterFactory getNativeInterpreterFactory() {
	return nativeInterpreterFactory;
    }

    /**
     * Returns the extension interpreter for natively-implemented methods of
     * class <tt>classname</tt> or <tt>null</tt> if no such interpreter is
     * currently registered.
     * 
     * @see #registerNativeImplementation(String, Interpreter)
     */
    Interpreter<? extends NativeImpl> getNativeInterpreterFor(NativeImpl nativeImpl) throws IllegalArgumentException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	return getNativeInterpreterFactory().getInterpreterFor(nativeImpl);
    }

    /**
     * Implements the polymorphism strategy. When a method is to be invoked on
     * an object, the object's runtime type needs to be considered in order to
     * determine the right implementation for the method signature invoked.
     * <p>
     * 
     * The algorithm checks if there is a signature on the runtime type of the
     * <tt>thiz</tt> object that conforms to <tt>calledSignature</tt>. If one is
     * found, it is returned. If none is found, the set of adapters known for
     * <tt>thiz</tt>'s runtime class are transitively checked for matching
     * implementations. If none is found, this means there is a conformance
     * problem where <tt>thiz</tt> does not conform to the class by which
     * <tt>calledSignature</tt> is defined which points to a problem in the
     * design-time's type checks. A {@link RuntimeException} is thrown in this
     * case. Otherwise, the signature implementation found in an adapter will be
     * returned.
     */
    public SignatureImplementation resolveMethodCallToImplementation(MethodSignature calledSignature, ClassTypedObject thiz) {
	return getMethodCallResolver().getImplementation(calledSignature, thiz.getType().getClazz(), getConnection());
    }
    
    public SapClass findClass(String classname) {
	MQLProcessor mql = getConnection().getMQLProcessor();
	MQLResultSet queryResult;
	// TODO generally clarify what guarantees MOIN gives w.r.t. thread safety
	synchronized (mql) {
	    queryResult = mql.execute("select c from data::classes::SapClass as c where for c(name='" + classname + "')", mql
		    .getQueryScopeProvider(/* scopeInclusive */false, /* partitionScope */
		    null, (String[]) null));
	}
	SapClass clazz = (SapClass) queryResult.getRefObjects("c")[0];
	return clazz;
    }

    /**
     * Creates a link between the two objects <tt>left</tt> and <tt>right</tt>
     * on behalf of the respective association and adds it to this
     * {@link LinkContainer}.
     * @param at TODO
     */
    public void addLink(ClassTypedObject left, ClassTypedObject right, Association association, Integer at) {
	getLinkContainer().addLink(left, right, association, at, /* snapshotContext */transactionBuffer, this);
    }

    /**
     * Removes a link between the two objects <tt>left</tt> and <tt>right</tt>
     * on behalf of the respective association from this {@link LinkContainer}.
     * If multiple such links exist (non-unique association end), one of them is
     * picked arbitrarily.
     * @param at TODO
     */
    public void removeLink(ClassTypedObject left, ClassTypedObject right, Association association, Integer at) {
	getLinkContainer().removeLink(left, right, association, at, transactionBuffer, getDefaultSnapshot(), this);
    }

    /**
     * Returns a (possible multi-valued, possibly <tt>null</tt>) object
     * resulting from navigating the association <tt>over</tt> from
     * <tt>from</tt> on <tt>fromSide</tt> of that association to the other end.
     * The collection will be empty if no links exist that match these criteria.
     * The collection's type corresponds with the other association end's (the
     * "to" end's) uniqueness and orderedness settings.
     * <p>
     * 
     * If <tt>from</tt> is <tt>null</tt>, <tt>null</tt> will result.
     */
    public RiverObject navigate(ClassTypedObject from, Side fromSide, Association over) {
	return getLinkContainer().navigate(from, fromSide, over);
    }

    /**
     * Navigates from <tt>from</tt> to the <tt>to</tt>. For example, if
     * <tt>from</tt> denotes a sales order object and the <tt>to</tt> denotes
     * the <em>items</tt> end of an association between <tt>SalesOrder</tt> and
     * <tt>SalesOrderItem</tt>, then the call will return the sales order items associated
     * with the sales order passed as <tt>from</tt>.
     * 
     * @see #navigate(ClassTypedObject, Side, Association)
     */
    public RiverObject navigate(ClassTypedObject from, AssociationEnd to) {
	return navigate(from, LinkContainer.getSideOfEnd(to).otherEnd(), to.getAssociation());
    }

    private LinkContainer getLinkContainer() {
	return linkContainer;
    }

    /**
     * For an upper multiplicity specification checks if it means "more than 1."
     * This includes the case of "unlimited" which is encoded as -1.
     */
    public static boolean isMultiple(int upperMultiplicity) {
	return upperMultiplicity > 1 || upperMultiplicity == -1;
    }

    /**
     * Tells if this type definition allows for more than one object, meaning it
     * has an upper multiplicity of greater than one or unlimited.
     */
    public static boolean isMultiple(TypeDefinition type) {
	return isMultiple(type.getUpperMultiplicity());
    }

    private MethodCallResolver getMethodCallResolver() {
        return methodCallResolver;
    }

    /**
     * Spawns a new interpreter for parallel execution. This interpreter re-uses
     * the registries for subinterpreters for expressions, statements etc., the
     * MOIN {@link #connection} as well as the shared state consisting of the
     * {@link #linkContainer}. The spawned interpreter has a new
     * {@link #callstack call stack} that is initialized with this interpreter's
     * top stack frame.
     * <p>
     * 
     * This means that a spawned interpreter may not have all of the first stack
     * frame's scope parent frames on its own stack. If this first frame happens
     * to have a scope parent, this is referenced by a regular Java reference.
     * <p>
     */
    public RiverInterpreter spawn() {
	RiverInterpreter result = new RiverInterpreter(this);
	return result;
    }

    public static <T> boolean equals(Iterable<T> i1, Iterable<T> i2) {
	Iterator<T> it1 = i1.iterator();
	Iterator<T> it2 = i2.iterator();
	while (it1.hasNext()) {
	    if (!it2.hasNext() || !it1.next().equals(it2.next())) {
		return false;
	    }
	}
	if (it2.hasNext()) {
	    return false;
	}
	return true;
    }

    /**
     * The "current default" snapshot that this interpreter will use if the
     * application has requested data from the repository without specifying a
     * particular snapshot. <tt>null</tt> as long as no interaction with the
     * repository has taken place. Will be initialized to the
     * {@link Repository#getCurrent()} snapshot upon the first interaction with
     * the {@link #repository}.
     */
    public SnapshotIdentifier getDefaultSnapshot() {
	return defaultSnapshot;
    }

    /**
     * Sets the "current default" snapshot for this interpreter. This is the one
     * that will be used for {@link #repository} queries in case no snapshot is
     * explicitly provided by the application or the {@link RepositoryObject
     * objects} participating in the repository interaction.
     */
    public void setDefaultSnapshot(SnapshotIdentifier snapshot) {
	defaultSnapshot = snapshot;
    }

    /**
     * Creates a new entity object in this interpreter's
     * {@link #getDefaultSnapshot() default snapshot} and tells the
     * {@link #linkContainer} that there are no links for this object yet, and
     * that the link container does not need to look up any such links in the
     * persistence {@link #repository}.
     */
    public EntityObject createEntityObject(ClassTypeDefinition type) {
	assert !type.getClazz().isValueType();
	EntityObject result = new EntityObject(type, getUpdatingTag());
	getLinkContainer().newEntity(result);
	return result;
    }

    private SnapshotIdentifier getUpdatingTag() {
	SnapshotIdentifier result = getTransactionBuffer().getUpdatingTag();
	if (result == null) {
	    result = getDefaultSnapshot();
	    getTransactionBuffer().setUpdatingTag(result);
	}
	return result;
    }

    /**
     * Assembles a value object in this interpreter's
     * {@link #getDefaultSnapshot() default snapshot} and tells the
     * {@link #linkContainer} equality-relevant links for this object.
     */
    public ValueObject createValueObject(ClassTypeDefinition type, Map<AssociationEnd, Collection<ClassTypedObject>> propertyValues) {
	assert type.getClazz().isValueType();
	ValueObject result = new ValueObject(type, propertyValues, getUpdatingTag(), this);
	loadEqualityRelevantLinksOfValue(result);
	return result;
    }

    public static <T extends RiverObject> RiverObject getRiverObjectFromIterable(TypeDefinition typeDefinition, final Iterable<T> iterable) {
	return new MultiValuedObject(typeDefinition, new Iterable<RiverObject>() {
	    @Override
	    public Iterator<RiverObject> iterator() {
		final Iterator<T> innerIterator = iterable.iterator();
		return new Iterator<RiverObject>() {
		    @Override
		    public boolean hasNext() {
			return innerIterator.hasNext();
		    }

		    @Override
		    public RiverObject next() {
			return innerIterator.next();
		    }

		    @Override
		    public void remove() {
			innerIterator.remove();
		    }
		};
	    }
	});
    }

    public void loadEqualityRelevantLinksOfValue(ValueObject valueObject) {
	getLinkContainer().loadEqualityRelevantLinksOfValue(valueObject);
    }

    private DebugSession getDebugSession() {
	return debugSession;
    }

    /**
     * By setting a non-<tt>null</tt> debug session, the interpreter is put in
     * debug mode.
     */
    public void setDebugSession(DebugSession debugSession) {
	this.debugSession = debugSession;
    }

    private RiverInterpreter getParent() {
	return parent;
    }

    public void terminate() {
	terminated = true;
    }

    public boolean isTerminated() {
	return terminated;
    }
    
    //FIXME: remove this method!!!
    public TransactionBuffer getTransactionBuffer() {
	return transactionBuffer;
    }

}
