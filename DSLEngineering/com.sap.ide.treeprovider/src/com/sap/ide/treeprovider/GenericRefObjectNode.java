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
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ui.views.properties.IPropertySource;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sap.ide.treeprovider.internal.Activator;



public class GenericRefObjectNode extends TreeNodeRefObject<EObject> implements INodeExplorer, ITreeNodeTransferHandler, IModelTransferPreparer {
    
    private static MOINModelBrowserPropertySourceManager propManager = new MOINModelBrowserPropertySourceManager();

    /**
     * This inner class combines an object with an optional role name that is to
     * be displayed in front of the object's label in the tree. If the
     * {@link #roleName} is <tt>null</tt>, only the object will be shown.
     * <p>
     * 
     * If the object is a {@link EObject}, a class in this package named
     * <tt>NodeX</tt> with <tt>X</tt> being replaced by the unqualified name of
     * the {@link EObject}'s class will be looked up (example:
     * <tt>NodeSapClass</tt> for class <tt>data.classes.SapClass</tt>). If
     * found, a two-argument constructor is called, using the parent object and
     * the {@link EObject} as arguments. Note, that the tree node class must
     * implement the {@link INodeExplorer} interface. If no such class is found,
     * the class {@link GenericRefObjectNode} is used to show the
     * {@link EObject} in the tree.
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

	public EObject getTreeNode(EObject parent) {
	    EObject node = null;
	    if (getObject() instanceof EObject) {
		node = getTreeNodeForRefObject(parent, node);
	    }
	    return node;
	}

	private EObject getTreeNodeForRefObject(EObject parent, EObject node) {
	    try {
		Class<?> nodeClass = Class.forName("com.sap.ide.treeprovider.internal.explorer.nodes.Node"
			+ ((EClass) ((EObject) getObject()).refMetaObject()).getName());
		for (Constructor<?> c : nodeClass.getDeclaredConstructors()) {
		    if (c.getParameterTypes().length == 2 && c.getParameterTypes()[0].isAssignableFrom(parent.getClass())
			    && c.getParameterTypes()[1].isAssignableFrom(getObject().getClass())) {
			node = (EObject) c.newInstance(parent, getObject());
			break;
		    }
		}
		if (node == null) {
		    node = (EObject) new GenericRefObjectNode(parent, ((EObject) getObject()), getRoleName());
		}
	    } catch (ClassNotFoundException cnfe) {
		// in this case, use this generic node type
		node = (EObject) new GenericRefObjectNode(parent, ((EObject) getObject()), getRoleName());
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

    public GenericRefObjectNode(EObject parent, EObject modelElement) {
	super(parent, modelElement);
    }

    public GenericRefObjectNode(EObject parent, EObject modelElement, String roleName) {
	this(parent, modelElement);
	this.roleName = roleName;
    }

    protected Collection<RoleNameAndObject> getChildRefObjects() {
	JmiHelper jmiHelper = getValue().get___Connection().getJmiHelper();
	List<RoleNameAndObject> kids = new ArrayList<RoleNameAndObject>();
	for (EReference ae : jmiHelper.getAssociationEnds((EClass) getValue().refMetaObject(), /* includeSupertypes */
	true)) {
	    EReference a = (EReference) ae.eContainer();
	    if (ae.getAggregation() == EEnum.COMPOSITE) {
		EReference refAssoc = jmiHelper.getRefAssociationForAssociation(a);
		boolean isSingle = ae.getEOpposite().getUpperBound() == 1;
		String roleName = isSingle ? ae.getEOpposite().getName() : null;
		Collection<EObject> localKids = refAssoc.refQuery(ae, getValue());
		for (EObject localKid : localKids) {
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
    public static Map<EReference, Set<EClass>> getConcreteCompositeChildClasses(EClass of) {
	Map<EReference, Set<EClass>> result = new LinkedHashMap<EReference, Set<EClass>>();
	JmiHelper jmiHelper = of.get___Connection().getJmiHelper();
	for (EReference ae : jmiHelper.getAssociationEnds(of, /* includeSupertypes */true)) {
	    Set<EClass> resultsForEnd = new LinkedHashSet<EClass>();
	    if (ae.getAggregation().equals(EEnum.COMPOSITE)) {
		EClass opposite = (EClass) ae.getEOpposite().getEType();
		if (!opposite.isAbstract()) {
		    resultsForEnd.add(opposite);
		}
		for (EClass ge : jmiHelper.getAllSubtypes(opposite)) {
		    EClass mc = (EClass) ge;
		    if (!mc.isAbstract()) {
			resultsForEnd.add(mc);
		    }
		}
		result.put(ae.getEOpposite(), resultsForEnd);
	    }
	}
	return result;
    }

    
    public EObject[] getChildren() {
	List<EObject> nodes = new ArrayList<EObject>();
	Collection<RoleNameAndObject> kids = getChildRefObjects();
	for (RoleNameAndObject o : kids) {
	    EObject node = o.getTreeNode(this);
	    nodes.add(node);
	}
	return nodes.toArray();
    }

    
    public boolean hasChildren() {
	return getChildRefObjects().size() > 0;
    }

    /**
     * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    @Override
    public EObject getAdapter(EClass adapter) {
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
	ResourceSet co = getConnection();
	JmiHelper helper = co.getJmiHelper();
	
	EObject[] objects =  transfer.getRefBaseObjects(co);
	EObject actualTarget = (EObject) getAdapter(EObject.class);
	
	// Save all editors with unsaved changes to prevent locking errors
	IStatus status = ModelManagerUI.getCommandManager().prepareExecution(
		co, getAffectedPartitionsForDND(actualTarget, objects));
	if (status == Status.CANCEL_STATUS) {
		return false; // user has canceled
	}
	
	CommandStack stk = co.getCommandStack();
	stk.openGroup("Handle DND Transfer");	
	
	// Remove existing links to old composite parents
	for (EObject obj : objects) {
		if (obj instanceof EObject) {
			EObject source = (EObject) obj;
			EObject parent = (EObject) source.refImmediateComposite();
			
			for (EReference assoc : helper.getCompositeAssociations((EClass)
					parent.refMetaObject(), (EClass) source.refMetaObject())) {
				
				EReference refAssoc = helper.getRefAssociationForAssociation(assoc);
				EReference compAssocEnd = co.getJmiHelper().getCompositeAssociationEnd(assoc);
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
	EObject[] objects =  transfer.getRefBaseObjects(getConnection());
	DefaultModelTransferTarget dmth = new DefaultModelTransferTarget();
	EObject actualTarget = (EObject) getAdapter(EObject.class);
	return dmth.isTransferAllowed(actualTarget, objects);
    }	
	
    private Collection<EOperation> getAffectedPartitionsForDND(EObject target, EObject[] objects) {
	Collection<EOperation> partitions = new HashSet<EOperation>();
	partitions.add(new EOperation(EOperation.EDIT, target.get___Partition().getPri()));
		
	for (EObject obj : objects) {
		partitions.add(new EOperation(EOperation.EDIT, obj.get___Partition().getPri()));
		if (obj instanceof EObject) {
			EObject source = (EObject) obj;
			EObject parent = source.refImmediateComposite();
			// TODO only add partitions with storage
			partitions.add(new EOperation(EOperation.EDIT, parent.get___Partition().getPri()));
		}
	}
	return partitions;
    }

	@Override
	public void handlePostCopy(ResourceSet targetConnection, EObject[] srcObjects, DeepCopyResultSet copyResult) {
		enableEventListeners(targetConnection);
	}

	
	public void handlePreCopy(ResourceSet targetConnection, EObject[] srcObjects) {
		disableEventListeners(targetConnection);
	}
	
	/**
	 * Deactivate event listeners on the given connection for save,
	 * uninterrupted copying
	 *
	 * @param co
	 */
	private void disableEventListeners(ResourceSet co) {
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
	private void enableEventListeners(ResourceSet co) {
		BundleContext context = Activator.getDefault().getBundle().getBundleContext();
		ServiceReference ref = context.getServiceReference(GlobalEventListenerRegistry.class.getName());
		GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context.getService(ref);
		registry.registerFilters(co.getSession());
	}
	
}
