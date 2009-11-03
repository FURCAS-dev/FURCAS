package com.sap.ide.treeprovider;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.views.properties.IPropertySource;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sap.ide.treeprovider.internal.Activator;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.fwk.ui.dnd.DefaultModelTransferTarget;
import com.sap.mi.fwk.ui.dnd.IModelTransferPreparer;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransfer;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;
import com.sap.mi.tools.cockpit.editor.model.properties.MOINModelBrowserPropertySourceManager;
import com.sap.tc.moin.globalmodellistener.GlobalEventListenerRegistry;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DeepCopyResultSet;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class GenericRefObjectNode extends TreeNodeRefObject<RefObject> implements INodeExplorer, ITreeNodeTransferHandler, IModelTransferPreparer {
    
    private static MOINModelBrowserPropertySourceManager propManager = new MOINModelBrowserPropertySourceManager();

    /**
     * This inner class combines an object with an optional role name that is to
     * be displayed in front of the object's label in the tree. If the
     * {@link #roleName} is <tt>null</tt>, only the object will be shown.
     * <p>
     * 
     * If the object is a {@link RefObject}, a class in this package named
     * <tt>NodeX</tt> with <tt>X</tt> being replaced by the unqualified name of
     * the {@link RefObject}'s class will be looked up (example:
     * <tt>NodeSapClass</tt> for class <tt>data.classes.SapClass</tt>). If
     * found, a two-argument constructor is called, using the parent object and
     * the {@link RefObject} as arguments. Note, that the tree node class must
     * implement the {@link INodeExplorer} interface. If no such class is found,
     * the class {@link GenericRefObjectNode} is used to show the
     * {@link RefObject} in the tree.
     * <p>
     * 
     * @author Axel Uhl D043530
     * 
     */
    public static class RoleNameAndObject {

	private final String roleName;
	private final Object theObject;

	public RoleNameAndObject(String roleName, Object refObject) {
	    this.roleName = roleName;
	    this.theObject = refObject;
	}

	public String getRoleName() {
	    return roleName;
	}

	public Object getObject() {
	    return theObject;
	}

	public Object getTreeNode(Object parent) {
	    Object node = null;
	    if (getObject() instanceof RefObject) {
		node = getTreeNodeForRefObject(parent, node);
	    }
	    return node;
	}

	private Object getTreeNodeForRefObject(Object parent, Object node) {
	    try {
		Class<?> nodeClass = Class.forName("com.sap.ide.treeprovider.internal.explorer.nodes.Node"
			+ ((MofClass) ((RefObject) getObject()).refMetaObject()).getName());
		for (Constructor<?> c : nodeClass.getDeclaredConstructors()) {
		    if (c.getParameterTypes().length == 2 && c.getParameterTypes()[0].isAssignableFrom(parent.getClass())
			    && c.getParameterTypes()[1].isAssignableFrom(getObject().getClass())) {
			node = c.newInstance(parent, getObject());
			break;
		    }
		}
		if (node == null) {
		    node = new GenericRefObjectNode(parent, ((RefObject) getObject()), getRoleName());
		}
	    } catch (ClassNotFoundException cnfe) {
		// in this case, use this generic node type
		node = new GenericRefObjectNode(parent, ((RefObject) getObject()), getRoleName());
	    } catch (Exception e) {
		throw new RuntimeException(e);
	    }
	    return node;
	}
    }

    /**
     * If non-<tt>null</tt>, specifies a name to be used as a prefix in the
     * label displaying this node in the tree; would typically identify an
     * attribute/reference/feature/association end name for the value
     * represented by this node.
     */
    private String roleName;

    public String getRoleName() {
	return roleName;
    }

    public GenericRefObjectNode(Object parent, RefObject modelElement) {
	super(parent, modelElement);
    }

    public GenericRefObjectNode(Object parent, RefObject modelElement, String roleName) {
	this(parent, modelElement);
	this.roleName = roleName;
    }

    protected Collection<RoleNameAndObject> getChildRefObjects() {
	JmiHelper jmiHelper = getValue().get___Connection().getJmiHelper();
	List<RoleNameAndObject> kids = new ArrayList<RoleNameAndObject>();
	for (AssociationEnd ae : jmiHelper.getAssociationEnds((MofClass) getValue().refMetaObject(), /* includeSupertypes */
	true)) {
	    Association a = (Association) ae.getContainer();
	    if (ae.getAggregation() == AggregationKindEnum.COMPOSITE) {
		RefAssociation refAssoc = jmiHelper.getRefAssociationForAssociation(a);
		boolean isSingle = ae.otherEnd().getMultiplicity().getUpper() == 1;
		String roleName = isSingle ? ae.otherEnd().getName() : null;
		Collection<RefObject> localKids = refAssoc.refQuery(ae, getValue());
		for (RefObject localKid : localKids) {
		    kids.add(new RoleNameAndObject(roleName, localKid));
		}
	    }
	}
	return kids;
    }

    /**
     * For a given class <tt>of</tt>, finds all associations where instances of
     * <tt>of</tt> can act as composite parent. For the respective opposite end,
     * finds all concrete classes whose instances can act as composite children
     * on that opposite end. Those classes are returned.
     */
    public static Map<AssociationEnd, Set<MofClass>> getConcreteCompositeChildClasses(MofClass of) {
	Map<AssociationEnd, Set<MofClass>> result = new LinkedHashMap<AssociationEnd, Set<MofClass>>();
	JmiHelper jmiHelper = of.get___Connection().getJmiHelper();
	for (AssociationEnd ae : jmiHelper.getAssociationEnds(of, /* includeSupertypes */true)) {
	    Set<MofClass> resultsForEnd = new LinkedHashSet<MofClass>();
	    if (ae.getAggregation().equals(AggregationKindEnum.COMPOSITE)) {
		MofClass opposite = (MofClass) ae.otherEnd().getType();
		if (!opposite.isAbstract()) {
		    resultsForEnd.add(opposite);
		}
		for (GeneralizableElement ge : jmiHelper.getAllSubtypes(opposite)) {
		    MofClass mc = (MofClass) ge;
		    if (!mc.isAbstract()) {
			resultsForEnd.add(mc);
		    }
		}
		result.put(ae.otherEnd(), resultsForEnd);
	    }
	}
	return result;
    }

    @Override
    public Object[] getChildren() {
	List<Object> nodes = new ArrayList<Object>();
	Collection<RoleNameAndObject> kids = getChildRefObjects();
	for (RoleNameAndObject o : kids) {
	    Object node = o.getTreeNode(this);
	    nodes.add(node);
	}
	return nodes.toArray();
    }

    @Override
    public boolean hasChildren() {
	return getChildRefObjects().size() > 0;
    }

    /**
     * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object getAdapter(Class adapter) {
	if (adapter == IPropertySource.class) {
	    return propManager.getPropertySource(this.getValue());
	}
	return super.getAdapter(adapter);
    }

    /**
     * This method is invoked when the user either releases the mouse (drops)
     * some objects or when the user presses ctrl + v.
     * 
     * It requests all affected editors with unsaved changes to be saved.
     * If this was successful then the composite parent of all dragged elements
     * are replaced with the drag target.
     * 
     * If there are more then one possible new composite parent associations, then the
     * user is asked to select one.
     * 
     * @param target
     *            The object where the selection has been dropped or where ctrl +
     *            v has been pressed
     * @param transfer
     *            All selected objects
     * @return True, if transfer was successful
     * @see TransferOperationEnum
     */
    @Override
    public boolean handleTransfer(Object target, ITreeNodeTransfer transfer) {
	assert target == this;
	Connection co = getConnection();
	JmiHelper helper = co.getJmiHelper();
	
	RefBaseObject[] objects =  transfer.getRefBaseObjects(co);
	RefObject actualTarget = (RefObject) getAdapter(RefObject.class);
	
	// Save all editors with unsaved changes to prevent locking errors
	IStatus status = ModelManagerUI.getCommandManager().prepareExecution(
		co, getAffectedPartitionsForDND(actualTarget, objects));
	if (status == Status.CANCEL_STATUS) {
		return false; // user has canceled
	}
	
	CommandStack stk = co.getCommandStack();
	stk.openGroup("Handle DND Transfer");	
	
	// Remove existing links to old composite parents
	for (RefBaseObject obj : objects) {
		if (obj instanceof RefObject) {
			RefObject source = (RefObject) obj;
			RefObject parent = (RefObject) source.refImmediateComposite();
			
			for (Association assoc : helper.getCompositeAssociations((MofClass)
					parent.refMetaObject(), (MofClass) source.refMetaObject())) {
				
				RefAssociation refAssoc = helper.getRefAssociationForAssociation(assoc);
				AssociationEnd compAssocEnd = co.getJmiHelper().getCompositeAssociationEnd(assoc);
				if (helper.isFirstAssociationEnd(assoc, compAssocEnd) &&
						refAssoc.refLinkExists(parent, source)) {
					refAssoc.refRemoveLink(parent, source);
				} else if (helper.isFirstAssociationEnd(assoc, compAssocEnd.otherEnd()) &&
						refAssoc.refLinkExists(source, parent)) {
					refAssoc.refRemoveLink(source, parent);
				}	
			}
		}
	}
	
	// Link to new root
	DefaultModelTransferTarget dmth = new DefaultModelTransferTarget();
	dmth.handleTransfer(actualTarget, objects, null);
	
	stk.closeGroup();
	try {
		co.save();
	} catch(Exception e) {
		Activator.logError(e, true);
		return false;
	}
	return true;
    }
	
	@Override
    public boolean isTransferAllowed(Object target, ITreeNodeTransfer transfer) {
	assert target == this;
	RefBaseObject[] objects =  transfer.getRefBaseObjects(getConnection());
	DefaultModelTransferTarget dmth = new DefaultModelTransferTarget();
	RefObject actualTarget = (RefObject) getAdapter(RefObject.class);
	return dmth.isTransferAllowed(actualTarget, objects);
    }	
	
    private Collection<PartitionOperation> getAffectedPartitionsForDND(RefObject target, RefBaseObject[] objects) {
	Collection<PartitionOperation> partitions = new HashSet<PartitionOperation>();
	partitions.add(new PartitionOperation(Operation.EDIT, target.get___Partition().getPri()));
		
	for (RefBaseObject obj : objects) {
		partitions.add(new PartitionOperation(Operation.EDIT, obj.get___Partition().getPri()));
		if (obj instanceof RefObject) {
			RefObject source = (RefObject) obj;
			RefBaseObject parent = source.refImmediateComposite();
			// TODO only add partitions with storage
			partitions.add(new PartitionOperation(Operation.EDIT, parent.get___Partition().getPri()));
		}
	}
	return partitions;
    }

	@Override
	public void handlePostCopy(Connection targetConnection, RefObject[] srcObjects, DeepCopyResultSet copyResult) {
		enableEventListeners(targetConnection);
	}

	@Override
	public void handlePreCopy(Connection targetConnection, RefObject[] srcObjects) {
		disableEventListeners(targetConnection);
	}
	
	/**
	 * Deactivate event listeners on the given connection for save,
	 * uninterrupted copying
	 *
	 * @param co
	 */
	private void disableEventListeners(Connection co) {
		BundleContext context = Activator.getDefault().getBundle().getBundleContext();
		ServiceReference ref = context.getServiceReference(GlobalEventListenerRegistry.class.getName());
		GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context.getService(ref);
		registry.deregisterFilters(co.getSession());
	}
	
	/**
	 * Restore deactivated event listeners on the given connection
	 *
	 * @param co
	 */
	private void enableEventListeners(Connection co) {
		BundleContext context = Activator.getDefault().getBundle().getBundleContext();
		ServiceReference ref = context.getServiceReference(GlobalEventListenerRegistry.class.getName());
		GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context.getService(ref);
		registry.registerFilters(co.getSession());
	}
	
}
