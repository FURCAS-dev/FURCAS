package com.sap.runlet.interpreter;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;

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

import com.sap.runlet.abstractinterpreter.AbstractRunletInterpreter;
import com.sap.runlet.abstractinterpreter.DebugSession;
import com.sap.runlet.abstractinterpreter.objects.AbstractValueObject;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.runlet.interpreter.expressions.AllInterpreter;
import com.sap.runlet.interpreter.expressions.AnonymousFunctionExpressionInterpreter;
import com.sap.runlet.interpreter.expressions.AsListInterpreter;
import com.sap.runlet.interpreter.expressions.AssociationEndNavigationInterpreter;
import com.sap.runlet.interpreter.expressions.BinaryLiteralInterpreter;
import com.sap.runlet.interpreter.expressions.BooleanLiteralInterpreter;
import com.sap.runlet.interpreter.expressions.ContentEqualsInterpreter;
import com.sap.runlet.interpreter.expressions.DimensionExpressionInterpreter;
import com.sap.runlet.interpreter.expressions.EqualsInterpreter;
import com.sap.runlet.interpreter.expressions.ExcludingAtInterpreter;
import com.sap.runlet.interpreter.expressions.ExcludingInterpreter;
import com.sap.runlet.interpreter.expressions.FunctionFromMethodExpressionInterpreter;
import com.sap.runlet.interpreter.expressions.GroupByInterpreter;
import com.sap.runlet.interpreter.expressions.HeadInterpreter;
import com.sap.runlet.interpreter.expressions.IncludingAtInterpreter;
import com.sap.runlet.interpreter.expressions.IncludingInterpreter;
import com.sap.runlet.interpreter.expressions.IterateInterpreter;
import com.sap.runlet.interpreter.expressions.MapInterpreter;
import com.sap.runlet.interpreter.expressions.MethodCallInterpreter;
import com.sap.runlet.interpreter.expressions.NumberLiteralInterpreter;
import com.sap.runlet.interpreter.expressions.ObjectCountInterpreter;
import com.sap.runlet.interpreter.expressions.ObjectCreationInterpreter;
import com.sap.runlet.interpreter.expressions.ObjectLiteralInterpreter;
import com.sap.runlet.interpreter.expressions.OqlQueryInterpreter;
import com.sap.runlet.interpreter.expressions.ReplaceInterpreter;
import com.sap.runlet.interpreter.expressions.SelectionInterpreter;
import com.sap.runlet.interpreter.expressions.SignatureCallInterpreter;
import com.sap.runlet.interpreter.expressions.SnapshotInterpreter;
import com.sap.runlet.interpreter.expressions.StringLiteralInterpreter;
import com.sap.runlet.interpreter.expressions.TailInterpreter;
import com.sap.runlet.interpreter.expressions.TernaryInterpreter;
import com.sap.runlet.interpreter.expressions.ThisInterpreter;
import com.sap.runlet.interpreter.expressions.TimePointLiteralInterpreter;
import com.sap.runlet.interpreter.expressions.VariableExpressionInterpreter;
import com.sap.runlet.interpreter.nativestdlib.BinaryInterpreter;
import com.sap.runlet.interpreter.nativestdlib.BooleanInterpreter;
import com.sap.runlet.interpreter.nativestdlib.CalendarInterpreter;
import com.sap.runlet.interpreter.nativestdlib.NumberInterpreter;
import com.sap.runlet.interpreter.nativestdlib.StringInterpreter;
import com.sap.runlet.interpreter.nativestdlib.TimepointInterpreter;
import com.sap.runlet.interpreter.objects.ConvertedMultiObject;
import com.sap.runlet.interpreter.objects.FunctionFromMethodObject;
import com.sap.runlet.interpreter.objects.FunctionObject;
import com.sap.runlet.interpreter.objects.ValueObject;
import com.sap.runlet.interpreter.signatureimplementations.BlockInterpreter;
import com.sap.runlet.interpreter.signatureimplementations.CellSetInterpreter;
import com.sap.runlet.interpreter.signatureimplementations.LinkAdditionInterpreter;
import com.sap.runlet.interpreter.signatureimplementations.LinkRemovalInterpreter;
import com.sap.runlet.interpreter.signatureimplementations.LinkSettingInterpreter;
import com.sap.runlet.interpreter.signatureimplementations.LinkTraversalInterpreter;
import com.sap.runlet.interpreter.signatureimplementations.StringTemplateInterpreter;
import com.sap.runlet.interpreter.statements.AddLinkInterpreter;
import com.sap.runlet.interpreter.statements.AssignmentInterpreter;
import com.sap.runlet.interpreter.statements.CommitInterpreter;
import com.sap.runlet.interpreter.statements.DeleteInterpreter;
import com.sap.runlet.interpreter.statements.ExpressionStatementInterpreter;
import com.sap.runlet.interpreter.statements.ForeachInterpreter;
import com.sap.runlet.interpreter.statements.IfInterpreter;
import com.sap.runlet.interpreter.statements.NamedValueDeclarationInterpreter;
import com.sap.runlet.interpreter.statements.RemoveLinkInterpreter;
import com.sap.runlet.interpreter.statements.ReturnInterpreter;
import com.sap.runlet.interpreter.statements.RollbackInterpreter;
import com.sap.runlet.interpreter.statements.StoreInterpreter;
import com.sap.runlet.interpreter.statements.WhileInterpreter;


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
import dataaccess.analytics.GroupBy;
import dataaccess.expressions.AssociationEndNavigationExpression;
import dataaccess.expressions.ContentEquals;
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
public class RunletInterpreter extends
	AbstractRunletInterpreter<SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd,
	                          Statement, Expression, SignatureImplementation,
	                          RunletStackFrame,
	                          NativeImpl, RunletInterpreter> {
    /**
     * Used for polymorphic method resolution.
     */
    private final MethodCallResolver methodCallResolver;
    
    /**
     * Registers the sub-interpreters for various parts of the language. It
     * registers those sub-interpreters (e.g., for expressions and statements)
     * that it knows. Clients may use the respective <tt>register...</tt>
     * methods to register more or other interpreters.
     * 
     * @param repository
     *            used to load/store objects durably / persistently
     */
    public RunletInterpreter(ResourceSet conn,
	    Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> repository) {
	super(conn, repository, Activator.getDefault().getModelAdapter(),
		new NativeInterpreterFactory(),
		new RunletLinkContainer(repository,
			Activator.getDefault().getModelAdapter()));
	methodCallResolver = Activator.getDefault().getMethodCallResolver();
    }

    /**
     * Like {@link RunletInterpreter#RiverInterpreter(ResourceSet, Repository)},
     * only that also a {@link #debugSession debug session} can be set.
     */
    public RunletInterpreter(ResourceSet conn,
	    Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> repository,
	    DebugSession debugSession) {
	this(conn, repository);
	setDebugSession(debugSession);
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
    private RunletInterpreter(RunletInterpreter parent) {
	super(parent);
	methodCallResolver = parent.getMethodCallResolver();
    }

    @Override
    protected void initExpressionInterpreterFactory(ResourceSet conn) {
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
	getExpressionInterpreterFactory().registerInterpreter(ContentEqualsInterpreter.class,
		conn.getClass(ContentEquals.CLASS_DESCRIPTOR).refMetaObject());
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
	getExpressionInterpreterFactory().registerInterpreter(OqlQueryInterpreter.class,
		conn.getClass(dataaccess.query.OqlQuery.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(MapInterpreter.class,
		conn.getClass(dataaccess.expressions.Map.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(GroupByInterpreter.class,
		conn.getClass(GroupBy.CLASS_DESCRIPTOR).refMetaObject());
    }

    @Override
    protected void initStatementInterpreterFactory(ResourceSet conn) {
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

    @Override
    protected void initSignatureImplementationInterpreterFactory(ResourceSet conn) {
	// signature implementations
	getSignatureImplementationInterpreterFactory().registerInterpreter(RunletNativeInterpreter.class,
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

    @Override
    protected void initNativeInterpreterFactory(ResourceSet conn) {
	final String NUMBER_CLASS_NAME = "Number";
	final String STRING_CLASS_NAME = "String";
	final String BOOLEAN_CLASS_NAME = "Boolean";
	final String BINARY_CLASS_NAME = "Binary";
	final String TIMEPOINT_CLASS_NAME = "TimePoint";
	final String SNAPSHOT_CLASS_NAME = "Snapshot";
	final String CALENDAR_CLASS_NAME = "Calendar";
	registerNativeImplementationInterpreter(NumberInterpreter.class, MetamodelUtils.findClass(conn, NUMBER_CLASS_NAME));
	registerNativeImplementationInterpreter(StringInterpreter.class, MetamodelUtils.findClass(conn, STRING_CLASS_NAME));
	registerNativeImplementationInterpreter(BooleanInterpreter.class, MetamodelUtils.findClass(conn, BOOLEAN_CLASS_NAME));
	registerNativeImplementationInterpreter(BinaryInterpreter.class, MetamodelUtils.findClass(conn, BINARY_CLASS_NAME));
	registerNativeImplementationInterpreter(TimepointInterpreter.class, MetamodelUtils.findClass(conn, TIMEPOINT_CLASS_NAME));
	registerNativeImplementationInterpreter(com.sap.runlet.interpreter.nativestdlib.SnapshotInterpreter.class, MetamodelUtils.findClass(conn, SNAPSHOT_CLASS_NAME));
	registerNativeImplementationInterpreter(CalendarInterpreter.class, MetamodelUtils.findClass(conn, CALENDAR_CLASS_NAME));
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
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> convert(
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> ro, TypeDefinition targetType) {
	// TODO refactor such that this becomes a method on RiverObject that can be used polymorphically
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = ro;
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
	    if (ro instanceof MultiValuedObject<?, ?, ?> && innermost instanceof ClassTypeDefinition
		&& ((ClassTypeDefinition) innermost).getClazz().isValueType()) {
		return new ConvertedMultiObject((MultiValuedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) ro,
			targetType, this, targetType.isOrdered(), targetType.isUnique());
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
	List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> voParameterValues = vo.getActualObjectParameters();
	List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> targetParameterValues =
	    new LinkedList<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>();
	for (ActualObjectParameter aop : targetType.getObjectParameters()) {
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> targetParameterValue = evaluate(aop.getValue());
	    targetParameterValues.add(targetParameterValue);
	}
	if (targetParameterValues.size() < targetType.getClazz().getFormalObjectParameters().size()) {
	    for (int i = targetParameterValues.size(); i < targetType.getClazz().getFormalObjectParameters().size(); i++) {
		RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> defaultParameterValue =
		    evaluate(targetType.getClazz().getFormalObjectParameters().get(i).getDefaultValue());
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
	    RunletStackFrame newStackFrame =
		pushArgumentsToStackFrame(targetParameterValues, ffmo);
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
     * Before passing, each argument is submitted to {@link #convert(RunletObject, TypeDefinition)}
     * to ensure that any assignment conversion required will be performed. This particularly
     * includes the implicit conversions defined for object-parameterized types where the object's
     * converter will be invoked if the target type has different actual object parameters than
     * the parameter object.
     * 
     * @return a new stack frame in which for each formal parameter as defined
     *         in <tt>evaluator</tt>'s implementation's signature a
     *         {@link RunletObject} has been registered from <tt>values</tt>
     */
    public RunletStackFrame pushArgumentsToStackFrame(List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> values, FunctionObject evaluator) {
	RunletStackFrame result =
	    new RunletStackFrame(); // constructs a new stack frame
					      						 // with no scope parent
	Iterator<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> v = values.iterator();
	for (Parameter parameter : evaluator.getImplementation().getImplementedSignature().getInput()) {
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> paramValue = v.next();
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> convertedParamValue = convert(paramValue, parameter.getType());
	    result.enterValue(parameter, convertedParamValue);
	}
	return result;
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
    public SignatureImplementation resolveMethodCallToImplementation(MethodSignature calledSignature,
	    ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> thiz) {
	return getMethodCallResolver().getImplementation(calledSignature, thiz.getType().getClazz(), getConnection());
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
    @Override
    public RunletInterpreter spawn() {
	RunletInterpreter result = new RunletInterpreter(this);
	return result;
    }

    /**
     * Assembles a value object in this interpreter's {@link #getDefaultSnapshot() default snapshot} but does not load the
     * equality-relevant links for this object yet.
     */
    @Override
    protected AbstractValueObject<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> createValueObjectWithoutEqualityRelevantLinks(
	    ClassTypeDefinition type,
	    Map<AssociationEnd, Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> propertyValues) {
	assert type.getClazz().isValueType();
	ValueObject result = new ValueObject(type, propertyValues, getUpdatingTag(), this);
	loadEqualityRelevantLinksOfValue(result);
	return result;
    }

    @Override
    public ValueObject createValueObject(
	    ClassTypeDefinition type,
	    Map<AssociationEnd, Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> propertyValues) {
	return (ValueObject) super.createValueObject(type, propertyValues);
    }
	
    @Override
    public RunletInterpreter[] getRunningChildren() {
	return super.getRunningChildren();
    }

}
