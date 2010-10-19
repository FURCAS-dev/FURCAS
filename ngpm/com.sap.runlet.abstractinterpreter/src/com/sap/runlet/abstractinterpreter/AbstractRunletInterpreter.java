package com.sap.runlet.abstractinterpreter;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.runlet.abstractinterpreter.objects.AbstractValueObject;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.EntityObject;
import com.sap.runlet.abstractinterpreter.objects.Link;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.EntityCreation;
import com.sap.runlet.abstractinterpreter.repository.EntityDeletion;
import com.sap.runlet.abstractinterpreter.repository.FixedSnapshot;
import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.runlet.abstractinterpreter.repository.RepositoryObject;
import com.sap.runlet.abstractinterpreter.repository.Snapshot;
import com.sap.runlet.abstractinterpreter.repository.SnapshotIdentifier;
import com.sap.runlet.abstractinterpreter.util.Bag;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;
import com.sap.runlet.abstractinterpreter.util.Tuple.Pair;

/**
 * 
 */
abstract public class AbstractRunletInterpreter<MetaClass extends EObject,
						TypeUsage extends EObject,
						ClassUsage extends TypeUsage,
						LinkMetaObject extends EObject,
						LinkEndMetaObject extends EObject,
						StatementType extends EObject,
						ExpressionType extends EObject,
						SignatureImplementationType extends EObject,
						StackFrameType extends StackFrame<LinkEndMetaObject, TypeUsage, ClassUsage, SignatureImplementationType>,
						NativeType extends SignatureImplementationType,
						InterpreterType extends AbstractRunletInterpreter<MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>> {

    private final EClassInterpreterFactory<ExpressionType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> expressionInterpreterFactory;
    private final EClassInterpreterFactory<StatementType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> statementInterpreterFactory;
    private final EClassInterpreterFactory<SignatureImplementationType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> signatureImplementationInterpreterFactory;
    
    private final LinkContainer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> linkContainer;

    /**
     * This is where interpreter clients may register interpreters that can
     * handle all natively-implemented operations of a class. Keys are the names
     * of the class whose native method implementations are handled by the
     * respective value (the interpreter).
     */
    private final InterpreterFactory<MetaClass, NativeType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> nativeInterpreterFactory;

    /**
     * The stack of {@link StackFrame}s. Always valid, but possibly empty when currently no call is active in this interpreter.
     * The element obtained by {@link Stack#peek()} is the currently valid frame. Frames that are
     * {@link StackFrame#getScopeParent() scope parent} of another frame are also contained on this stack. This means that the
     * stack is a superset of frames corresponding to the call hierarchy. It moreover reflects block nesting.
     */
    private Stack<StackFrameType> callstack;

    /**
     * It is useful for an interpreter to know the interpreter that spawned it.
     * Whenever the child will start executing, it can enter itself into the
     * parent interpreter's {@link #runningChildren} so that a parent always
     * knows which of its children is currently executing. This is particularly
     * useful for a debug view.
     */
    private final InterpreterType parent;

    /**
     * An interpreter can {@link #spawn() spawn} children, usually meaning an
     * own thread of execution. Each interpreter resultin from {@link #spawn()}
     * is added to this set.
     */
    private final Set<InterpreterType> runningChildren;

    /**
     * Tells if a call of one of {@link #evaluate(ExpressionType)},
     * {@link #evaluate(SignatureImplementation)} or
     * {@link #evaluate(StatementType)} is currently running. Iff <tt>true</tt>,
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

    private final TransactionBuffer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> transactionBuffer;
    private final Repository<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> repository;
    private final ResourceSet resourceSet;
    private final ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter;

    public AbstractRunletInterpreter(
	    ResourceSet conn,
	    Repository<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> repository,
	    ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter,
	    InterpreterFactory<MetaClass, NativeType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> nativeInterpreterFactory,
	    LinkContainer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> linkContainer) {
	parent = null;
	this.linkContainer = linkContainer;
	this.resourceSet = conn;
	this.repository = repository;
	this.modelAdapter = modelAdapter;
	expressionInterpreterFactory = new EClassInterpreterFactory<ExpressionType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>();
	statementInterpreterFactory = new EClassInterpreterFactory<StatementType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>();
	signatureImplementationInterpreterFactory = new EClassInterpreterFactory<SignatureImplementationType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>();
	this.nativeInterpreterFactory = nativeInterpreterFactory;
	runningChildren = new HashSet<InterpreterType>();
	transactionBuffer = new TransactionBuffer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
		modelAdapter);
	setCallstack(new Stack<StackFrameType>());
	initInterpreterFactories(conn);
	setDefaultSnapshot(repository.getTrunkIdentifier());
    }
    
    public AbstractRunletInterpreter(InterpreterType parent) {
	this.parent = parent;
	this.linkContainer = parent.getLinkContainer();
	this.resourceSet = parent.getResourceSet();
	this.repository = parent.getRepository();
	this.modelAdapter = parent.getModelAdapter();
	defaultSnapshot = parent.getDefaultSnapshot();
	expressionInterpreterFactory = parent.getExpressionInterpreterFactory();
	statementInterpreterFactory = parent.getStatementInterpreterFactory();
	signatureImplementationInterpreterFactory = parent.getSignatureImplementationInterpreterFactory();
	this.nativeInterpreterFactory = parent.getNativeInterpreterFactory();
	runningChildren = new HashSet<InterpreterType>();
	transactionBuffer = parent.getTransactionBuffer();
	setCallstack(new Stack<StackFrameType>());
	if (parent.getCallstack().size() > 0) {
	    getCallstack().push(parent.getCallstack().peek());
	}
	setDebugSession(parent.getDebugSession());
    }
    
    private void initInterpreterFactories(ResourceSet conn) {
	initExpressionInterpreterFactory(conn);
	initStatementInterpreterFactory(conn);
	initSignatureImplementationInterpreterFactory(conn);
	initNativeInterpreterFactory(conn);
    }

    protected abstract void initExpressionInterpreterFactory(ResourceSet conn);
    protected abstract void initStatementInterpreterFactory(ResourceSet conn);
    protected abstract void initSignatureImplementationInterpreterFactory(ResourceSet conn);
    protected abstract void initNativeInterpreterFactory(ResourceSet conn);
    
    public ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getModelAdapter() {
        return modelAdapter;
    }

    @SuppressWarnings("unchecked")
    InterpreterType getThis() {
	return (InterpreterType) this;
    }

    protected LinkContainer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> getLinkContainer() {
	return linkContainer;
    }

    public void registerExpressionInterpreter(Class<Interpreter<ExpressionType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>> interpreter, EClass... classes) {
	getExpressionInterpreterFactory().registerInterpreter(interpreter, classes);
    }

    public void registerStatementInterpreter(Class<Interpreter<StatementType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>> interpreter, EClass... classes) {
	getStatementInterpreterFactory().registerInterpreter(interpreter, classes);
    }

    public void registerSignatureImplementationInterpreter(Class<Interpreter<SignatureImplementationType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>> interpreter, EClass... classes) {
	getSignatureImplementationInterpreterFactory().registerInterpreter(interpreter, classes);
    }
    
    public void registerNativeImplementationInterpreter(Class<? extends Interpreter<? extends NativeType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType>> interpreter,
	    MetaClass... classes) {
	getNativeInterpreterFactory().registerInterpreter(interpreter, classes);
    }

    protected EClassInterpreterFactory<ExpressionType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> getExpressionInterpreterFactory() {
	return expressionInterpreterFactory;
    }

    protected EClassInterpreterFactory<StatementType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> getStatementInterpreterFactory() {
	return statementInterpreterFactory;
    }

    protected EClassInterpreterFactory<SignatureImplementationType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> getSignatureImplementationInterpreterFactory() {
	return signatureImplementationInterpreterFactory;
    }

    private InterpreterFactory<MetaClass, NativeType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> getNativeInterpreterFactory() {
	return nativeInterpreterFactory;
    }

    /**
     * Returns the extension interpreter for natively-implemented methods of
     * class <tt>classname</tt> or <tt>null</tt> if no such interpreter is
     * currently registered.
     * 
     * @see #registerNativeImplementation(String, Interpreter)
     */
    public Interpreter<? extends NativeType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> getNativeInterpreterFor(
	    NativeType nativeImpl) throws IllegalArgumentException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	return getNativeInterpreterFactory().getInterpreterFor(nativeImpl);
    }

    /**
     * Tells this interpreter that a child interpreter obtained from
     * {@link #spawn()} started executing something. It will be added to the
     * {@link #runningChildren} set.
     */
    public void addRunningChild(InterpreterType child) {
	runningChildren.add(child);
    }

    /**
     * Tells this interpreter that a child interpreter obtained from
     * {@link #spawn()} finished executing and therefore is no longer active. It
     * will be removed from the {@link #runningChildren} set.
     */
    public void removeRunningChild(InterpreterType child) {
	runningChildren.remove(child);
    }

    /**
     * The set of currently executing immediate child interpreters that were
     * obtained by calling {@link #spawn()} on this interpreter.
     */
    @SuppressWarnings("unchecked")
    public InterpreterType[] getRunningChildren() {
	InterpreterType[] result =
	      (InterpreterType[]) runningChildren.toArray(new AbstractRunletInterpreter<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>[0]);
	return result;
    }

    private void setCallstack(Stack<StackFrameType> callstack) {
	this.callstack = callstack;
    }

    /**
     * Obtains the callstack, reflecting block nesting <em>and</em> call
     * structure
     */
    public Stack<StackFrameType> getCallstack() {
	return callstack;
    }

    public void push(StackFrameType stackFrame) {
	getCallstack().push(stackFrame);
    }

    public void pop() {
	getCallstack().pop();
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
    @SuppressWarnings("unchecked")
    public StackFrameType oneUp(StackFrameType frame) {
	StackFrameType result = null;
	StackFrameType current = frame;
	while (current.getScopeParent() != null) {
	    // this cast is safe if only stack frames of equal type are used as parents
	    current = (StackFrameType) current.getScopeParent();
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
    public StackFrameType oneDown(StackFrameType frame) {
	int i = getCallstack().indexOf(frame) + 1;
	StackFrameType result = null;
	if (i < getCallstack().size()) {
	    result = getCallstack().get(i);
	    while (i < getCallstack().size() - 1 && getCallstack().get(i + 1).getScopeParent() != null) {
		i++;
		result = getCallstack().get(i);
	    }
	}
	return result;
    }

    /**
     * Creates a link between the two objects <tt>left</tt> and <tt>right</tt>
     * on behalf of the respective association and adds it to this
     * {@link RunletLinkContainer}.
     */
    @SuppressWarnings("unchecked")
    public void addLink(ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> left,
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> right, LinkMetaObject association, Integer at) {
	getLinkContainer().addLinkFromObjectsForEnds(left, right, association, at, /* snapshotContext */getTransactionBuffer(),
		(InterpreterType) this);
    }

    /**
     * Removes a link between the two objects <tt>left</tt> and <tt>right</tt>
     * on behalf of the respective association from this {@link RunletLinkContainer}.
     * If multiple such links exist (non-unique association end), one of them is
     * picked arbitrarily.
     */
    public void removeLink(ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> left,
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> right,
	    LinkMetaObject association, Integer at) {
	getLinkContainer().removeLink(left, right, association, at, getTransactionBuffer(), getDefaultSnapshot(), this);
    }

    public void deleteEntity(EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> toDelete) {
	assert toDelete.isPersistent();
	ObjectAndRemoteAssociationEnd<LinkMetaObject, LinkEndMetaObject, TypeUsage, ClassUsage, MetaClass> parentAndChildEnd =
	    getLinkContainer().getCompositeParentObjectAndChildAssociationEnd(toDelete);
	if (parentAndChildEnd != null) {
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> left;
	    ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> right;
	    if (getModelAdapter().getSideOfEnd(parentAndChildEnd.getRemoteAssociationEnd()).equals(Side.LEFT)) {
		left = toDelete;
		right = parentAndChildEnd.getObject();
	    } else {
		left = parentAndChildEnd.getObject();
		right = toDelete;
	    }
	    removeLink(left, right, getModelAdapter().getAssociation(parentAndChildEnd.getRemoteAssociationEnd()),
		    /* should be only one such link, so position doesn't matter */ null);
	}
	Bag<RepositoryObject> expandedComposition = getLinkContainer().getCompositionTree(toDelete);
	deleteRepositoryObjects(expandedComposition);
    }

    /**
     * Records the deletions of all objects in <tt>expandedComposition</tt> in
     * the {@link #getTransactionBuffer()}. For links of ordered associations the
     * ordering of links of the same association attached to the same object
     * with their unordered end needs to be determined so that during recording
     * deletion in the transaction buffer indexes are not messed up.
     */
    @SuppressWarnings("unchecked")
    private void deleteRepositoryObjects(Bag<RepositoryObject> expandedComposition) {
	Map<Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>, TreeMap<Integer, Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> links =
	    new HashMap<Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>, TreeMap<Integer, Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>();
	List<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> entityDeletions = new LinkedList<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
	for (RepositoryObject ro : expandedComposition) {
	    if (ro instanceof EntityObject) {
		entityDeletions.add((EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) ro);
	    } else {
		Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link = (Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) ro;
		if (link.isOrdered()) {
		    Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>> key = new Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>(link.getAssociation(), link
			    .getAtOppositeOfOrderedEnd());
		    TreeMap<Integer, Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> tm = links.get(key);
		    if (tm == null) {
			tm = new TreeMap<Integer, Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
			links.put(key, tm);
		    }
		    tm.put(getLinkContainer().getLinkPosition(link), link);
		} else {
		    getTransactionBuffer().linkDeleted(link, null);
		}
	    }
	}
	for (Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>> key : links.keySet()) {
	    TreeMap<Integer, Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> tm = links.get(key);
	    int offset = 0;
	    for (Integer at : tm.keySet()) {
		getTransactionBuffer().linkDeleted(tm.get(at), at-offset);
		offset++; // deletion moves links that are behind deleted link towards lower indexes
	    }
	}
	// Delete entities last to avoid intermediate dangling links where possible
	for (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> eo : entityDeletions) {
	    getTransactionBuffer().entityDeleted(eo);
	}
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
    public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> navigate(ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> from, Side fromSide, LinkMetaObject over) {
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
    public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> navigate(ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage> from, LinkEndMetaObject to) {
	return navigate(from, getModelAdapter().getSideOfEnd(to).otherEnd(),
		getModelAdapter().getAssociation(to));
    }

    public ResourceSet getResourceSet() {
	return resourceSet;
    }

    protected InterpreterType getParent() {
	return parent;
    }

    //FIXME: remove this method!!!
    public TransactionBuffer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getTransactionBuffer() {
	return transactionBuffer;
    }

    public Repository<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getRepository() {
	return repository;
    }

    /**
     * Selects all instances of <tt>ofClass</tt> from all snapshots known by the
     * {@link #repository}.
     * 
     */
    public Iterable<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> all(MetaClass ofClass) {
	Set<Snapshot> snapshots = getRepository().getAllSnapshots();
	Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> result = new HashSet<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
	for (Snapshot si : snapshots) {
	    result.addAll(all(ofClass, new FixedSnapshot(si)));
	}
	return result;
    }

    public Iterable<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> all(MetaClass ofClass, Date fromLastConcurrentSnapshotsBefore) {
	Set<SnapshotIdentifier> snapshots = getRepository().getLastSnapshotsBeforeOrAt(fromLastConcurrentSnapshotsBefore);
	Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> result = new HashSet<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
	for (SnapshotIdentifier si : snapshots) {
	    result.addAll(all(ofClass, si));
	}
	return result;
    }
    
    /**
     * Returns an {@link Iterable} of all {@link EntityObject}s that were
     * changed. The {@link EntityObject}s are linked to the {@link Snapshot}
     * they have been changed in.
     * 
     * @param ofClass
     *            Specifies the {@link MetaClass} of the {@link EntityObject}s to
     *            retrieve
     * @return {@link Iterable} of all {@link EntityObject}s that changed
     */
    public Iterable<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> allChanged(MetaClass ofClass) {
	Set<Snapshot> snapshots = getRepository().getAllSnapshots();
	Map<Snapshot, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> entitiesPerSnapshot =
	    new HashMap<Snapshot, Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>();

	for (Snapshot si : snapshots) {
	    Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> set = new HashSet<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
	    set.addAll(all(ofClass, new FixedSnapshot(si)));
	    entitiesPerSnapshot.put(si, set);
	}

	return getLinkContainer().removeUnchangedEntities(entitiesPerSnapshot);
    }

    /**
     * Mix the contents of the {@link #getTransactionBuffer()} with the contents of
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
    public Collection<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> all(MetaClass ofClass, SnapshotIdentifier fromSnapshot) {
	Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> result =
	    new HashSet<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>(getRepository().all(ofClass, fromSnapshot));
	if (transactionBufferUpdates(fromSnapshot)) {
	    for (Iterator<EntityCreation<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> i=getTransactionBuffer().getEntityCreations(); i.hasNext(); ) {
		EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> createdObject = i.next().getObject();
		if (getModelAdapter().getClazz(createdObject.getType()).equals(ofClass)) {
		    result.add(createdObject);
		}
	    }
	    for (Iterator<EntityDeletion<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> i=getTransactionBuffer().getEntityDeletions(); i.hasNext(); ) {
		EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> deletedObject = i.next().getObject();
		if (getModelAdapter().getClazz(deletedObject.getType()).equals(ofClass)) {
		    result.remove(deletedObject);
		}
	    }
	}
	return result;
    }

    /**
     * @return <tt>true</tt> if the {@link #getTransactionBuffer()}, when
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
	SnapshotIdentifier updating = getTransactionBuffer().getUpdatingTag();
	if (updating != null) {
	    result = updating.equals(fromSnapshot);
	} else {
	    result = false;
	}
	return result;
    }

    public void storeEntity(EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> toStore) {
	Bag<RepositoryObject> expandedComposition = getLinkContainer().getTransientCompositionTree(toStore);
	createRepositoryObjects(expandedComposition);
    }

    /**
     * Records the creation of all objects in <tt>expandedComposition</tt> in
     * the {@link #getTransactionBuffer()}. For links of ordered associations the
     * ordering of links of the same association attached to the same object
     * with their unordered end needs to be determined so that during insertion
     * into the transaction buffer indexes are not messed up.
     */
    @SuppressWarnings("unchecked")
    private void createRepositoryObjects(Bag<RepositoryObject> expandedComposition) {
	// collect all links; record entity creations first so that link creations
	// are recorded only after their related entity creations have been recorded
	Map<Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>,
	TreeMap<Integer, Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>> links =
	    new HashMap<Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>,
	    TreeMap<Integer, Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>>();
	List<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> unorderedLinks = new LinkedList<Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
	for (RepositoryObject ro : expandedComposition) {
	    if (ro instanceof EntityObject) {
		getTransactionBuffer().entityCreated((EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) ro);
	    } else {
		Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link = (Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) ro;
		if (link.isOrdered()) {
		    Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>> key =
			new Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>(link.getAssociation(), link
			    .getAtOppositeOfOrderedEnd());
		    TreeMap<Integer, Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> tm = links.get(key);
		    if (tm == null) {
			tm = new TreeMap<Integer, Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>>();
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
	for (Pair<LinkMetaObject, ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>> key : links.keySet()) {
	    TreeMap<Integer, Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> tm = links.get(key);
	    for (Integer at : tm.keySet()) {
		getTransactionBuffer().linkCreated(tm.get(at), at);
	    }
	}
	for (Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> unorderedLink : unorderedLinks) {
	    getTransactionBuffer().linkCreated(unorderedLink, null);
	}
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
    private boolean enterEvaluate(EObject element) {
	boolean result = running;
	if (!result) {
	    if (getParent() != null) {
		getParent().addRunningChild(getThis());
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
		getParent().removeRunningChild(getThis());
	    }
	    if (getDebugSession() != null) {
		getDebugSession().terminated(this);
	    }
	}
	running = oldRunning;
    }

    public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> evaluate(ExpressionType e) throws SecurityException,
	    IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	boolean oldRunning = enterEvaluate(e);
	if (e == null) {
	    throw new RuntimeException("Don't know how to evaluate a null expression");
	}
	Interpreter<? extends ExpressionType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> interpreter = getExpressionInterpreterFactory().getInterpreterFor(e);
	if (interpreter == null) {
	    throw new RuntimeException("No interpreter for expression of type "
		    + ((EClass) e.eClass()).getEPackage().getName()+"."+((EClass) e.eClass()).getName());
	}
	RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> result = interpreter.evaluate(getThis());
	exitEvaluate(oldRunning);
	return result;
    }

    /**
     * Returns either <tt>null</tt> or a {@link ReturnInterpreter.ReturnResult}
     * which wraps the real result expected to correspond with the signature's
     * output specification, such as the return value explicitly returned by a
     * block; or a regular {@link RunletObject} that is not a
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
    public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> evaluateSignatureImplementation(
	    SignatureImplementationType implementation) throws SecurityException, IllegalArgumentException,
	    NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
	boolean oldRunning = enterEvaluate(implementation);
	if (getDebugSession() != null) {
	    getCallstack().peek().setCurrentlyExecutingImplementation(implementation);
	}
	Interpreter<? extends SignatureImplementationType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> interpreter = getSignatureImplementationInterpreterFactory().getInterpreterFor(implementation);
	RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> result = interpreter.evaluate(getThis());
	if (getDebugSession() != null) {
	    getCallstack().peek().setCurrentlyExecutingImplementation(null);
	}
	exitEvaluate(oldRunning);
	return result;
    }

    public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> evaluateStatement(StatementType statement) throws SecurityException, IllegalArgumentException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	boolean oldRunning = enterEvaluate(statement);
	Interpreter<? extends StatementType, MetaClass, TypeUsage, ClassUsage, LinkMetaObject, LinkEndMetaObject, StatementType, ExpressionType, SignatureImplementationType, StackFrameType, NativeType, InterpreterType> interpreter =
	    getStatementInterpreterFactory().getInterpreterFor(statement);
	RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> result = interpreter.evaluate(getThis());
	exitEvaluate(oldRunning);
	return result;
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

    public Snapshot commit() {
	return getTransactionBuffer().commit(getRepository());
    }

    public void rollback() {
	getTransactionBuffer().rollback();
    }

    /**
     * Tells if this interpreter is currently executing or evaluating anything.
     * 
     * @see #running
     * @see #enterEvaluate(EObject)
     * @see #exitEvaluate(boolean)
     */
    public boolean isRunning() {
	return !terminated && running;
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

    public void terminate() {
	terminated = true;
    }

    public boolean isTerminated() {
	return terminated;
    }
    
    /**
     * Creates a new entity object in this interpreter's
     * {@link #getDefaultSnapshot() default snapshot} and tells the
     * {@link #linkContainer} that there are no links for this object yet, and
     * that the link container does not need to look up any such links in the
     * persistence {@link #repository}.
     */
    public EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> createEntityObject(ClassUsage type) {
	assert !getModelAdapter().isValueType(getModelAdapter().getClazz(type));
	EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> result =
	    new EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>(
		type, getUpdatingTag(), getModelAdapter(), this);
	getLinkContainer().newEntity(result);
	return result;
    }

    protected SnapshotIdentifier getUpdatingTag() {
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
    public AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> createValueObject(
	    ClassUsage type, Map<LinkEndMetaObject, Collection<ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>> propertyValues) {
	assert getModelAdapter().isValueType(getModelAdapter().getClazz(type));
	AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> result =
	    createValueObjectWithoutEqualityRelevantLinks(type, propertyValues);
	loadEqualityRelevantLinksOfValue(result);
	return result;
    }

    /**
     * Assembles a value object in this interpreter's {@link #getDefaultSnapshot() default snapshot} but does not load the
     * equality-relevant links for this object yet.
     */
    protected abstract AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> createValueObjectWithoutEqualityRelevantLinks(
	    ClassUsage type, Map<LinkEndMetaObject, Collection<ClassTypedObject<LinkEndMetaObject, TypeUsage, ClassUsage>>> propertyValues);
    
    public static <LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage extends TypeUsage, T extends RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>
    RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> getRunletObjectFromIterable(
	    TypeUsage typeDefinition, final Iterable<T> iterable,
	    ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter, boolean ordered, boolean unique) {
	return new MultiValuedObject<LinkEndMetaObject, TypeUsage, ClassUsage>(
		typeDefinition, new Iterable<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>() {
	    @Override
	    public Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>> iterator() {
		final Iterator<T> innerIterator = iterable.iterator();
		return new Iterator<RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage>>() {
		    @Override
		    public boolean hasNext() {
			return innerIterator.hasNext();
		    }

		    @Override
		    public RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> next() {
			return innerIterator.next();
		    }

		    @Override
		    public void remove() {
			innerIterator.remove();
		    }
		};
	    }
	}, ordered, unique);
    }

    public void loadEqualityRelevantLinksOfValue(AbstractValueObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> valueObject) {
	getLinkContainer().loadEqualityRelevantLinksOfValue(valueObject);
    }

    /**
     * Spawns a new interpreter for parallel execution. This interpreter re-uses
     * the registries for subinterpreters for expressions, statements etc., the
     * {@link #resourceSet} as well as the shared state consisting of the
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
    public abstract InterpreterType spawn();

}
