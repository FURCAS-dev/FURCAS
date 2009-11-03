/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.bridge.BridgePackage;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.bridge.Parameter;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.semantics.bridge.Signal;
import org.oslo.ocl20.semantics.factories.TypeFactory;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Classifier</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.ClassifierImpl#getOperations <em>Operations</em>}
 * </li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.ClassifierImpl#getProcessor <em>Processor</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.ClassifierImpl#getProperties <em>Properties</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ClassifierImpl extends NamespaceImpl implements Classifier {
	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList operations;

	/**
	 * The default value of the '{@link #getProcessor() <em>Processor</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProcessor()
	 * @generated
	 * @ordered
	 */
	protected static final OclProcessor PROCESSOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProcessor() <em>Processor</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProcessor()
	 * @generated
	 * @ordered
	 */
	protected OclProcessor processor = ClassifierImpl.PROCESSOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList properties;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return BridgePackage.Literals.CLASSIFIER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList getOperations() {
		if (this.operations == null) {
			this.operations = new EDataTypeUniqueEList(Object.class, this, BridgePackage.CLASSIFIER__OPERATIONS);
		}
		return this.operations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OclProcessor getProcessor() {
		return this.processor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProcessor(OclProcessor newProcessor) {
		OclProcessor oldProcessor = this.processor;
		this.processor = newProcessor;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, BridgePackage.CLASSIFIER__PROCESSOR,
			    oldProcessor, this.processor));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList getProperties() {
		if (this.properties == null) {
			this.properties = new EObjectResolvingEList(Property.class, this, BridgePackage.CLASSIFIER__PROPERTIES);
		}
		return this.properties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Property lookupProperty(String name) {
		Property pr = this.localLookupProperty(name);
		if (pr != null) {
			return pr;
		}
		// if still not found, look in super types
		java.util.Iterator i = this.getAllSuperTypes().iterator();
		while (i.hasNext()) {
			Classifier c = (Classifier) i.next();
			Property p = c.localLookupProperty(name);
			if (p != null) {
				return p;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Operation lookupOperation(String name, List types) {
		Operation op = this.lookupCachedOp(name, types);
		return op;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Signal lookupSignal(String name, List types) {
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Boolean conformsTo(Classifier c) {
		if (this.equals(c)) {
			return Boolean.TRUE;
		}
		if (c.getClass() == org.oslo.ocl20.semantics.model.types.OclAnyType.class
		        && !(this instanceof org.oslo.ocl20.semantics.model.types.CollectionType)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object getDelegate() {
		return java.lang.Class.class;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Class getImplClass() {
		return org.oslo.ocl20.standard.lib.OclType.class;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Property localLookupProperty(String name) {
		java.util.Iterator i = this.getProperties().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getAllSuperTypes() {
		List result = new java.util.Vector();
		List x = this.getSuperTypes();
		result.addAll(x);
		java.util.Iterator i = x.iterator();
		while (i.hasNext()) {
			Classifier c = (Classifier) i.next();
			java.util.Iterator j = c.getAllSuperTypes().iterator();
			while (j.hasNext()) {
				Classifier st = (Classifier) j.next();
				if (!result.contains(st)) {
					result.add(st);
				}
			}
		}
		return result;

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createOperations(TypeFactory typeFactory) {
		// no exception
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void addProperty(Property prop) {
		this.getProperties().add(prop);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void addOperation(Operation operation) {
		this.getOperations().add(operation);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElement lookupOwnedElement(String name) {
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Operation lookupCachedOp(String name, List types) {

		java.util.Iterator i = this.getOperations().iterator();
		while (i.hasNext()) {
			Operation op = (Operation) i.next();
			String opName = op.getName();
			if (opName.equals(name)) {
				List parameters = op.getOwnedParameter();
				List parameterTypes = new ArrayList(parameters.size());
				for (Iterator iter = parameters.iterator(); iter.hasNext();) {
					Parameter parameter = (Parameter) iter.next();
					parameterTypes.add(parameter.getType());
				}
				if (this.typesConform(parameterTypes, types)) {
					return op;
				}
			}
		}
		// if still not found, look in super types
		i = this.getSuperTypes().iterator();
		while (i.hasNext()) {
			Classifier c = (Classifier) i.next();
			Operation p = c.lookupOperation(name, types);
			if (p != null) {
				return p;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getSuperTypes() {
		return new java.util.Vector();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean typesConform(List paramTypes, List argTypes) {
		if (paramTypes == null) {
			paramTypes = new java.util.Vector();
		}
		if (argTypes == null) {
			argTypes = new java.util.Vector();
		}
		if (paramTypes.size() != argTypes.size()) {
			return false;
		}
		for (int i = 0; i < paramTypes.size(); i++) {
			Classifier paramType = (Classifier) paramTypes.get(i);
			Classifier argType = (Classifier) argTypes.get(i);
			if (argType == null) {
				return false;
			}
			if (argType.conformsTo(paramType) == Boolean.FALSE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Environment getEnvironmentWithoutParents() {
		Environment env = this.getProcessor().getBridgeFactory().buildEnvironment();
		Environment result = env.addNamespace(this);
		result.setParent(null);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Environment getEnvironmentWithParents() {
		if (this.getNamespace() == null) {
			return null;
		} else {
			Environment result = this.getEnvironmentWithoutParents();
			result.setParent(this.getNamespace().getEnvironmentWithParents());
			return result;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object accept(OclVisitor visitor, Object data) {
		return (visitor).visit(this, data);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BridgePackage.CLASSIFIER__OPERATIONS:
				return this.getOperations();
			case BridgePackage.CLASSIFIER__PROCESSOR:
				return this.getProcessor();
			case BridgePackage.CLASSIFIER__PROPERTIES:
				return this.getProperties();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BridgePackage.CLASSIFIER__OPERATIONS:
				this.getOperations().clear();
				this.getOperations().addAll((Collection) newValue);
				return;
			case BridgePackage.CLASSIFIER__PROCESSOR:
				this.setProcessor((OclProcessor) newValue);
				return;
			case BridgePackage.CLASSIFIER__PROPERTIES:
				this.getProperties().clear();
				this.getProperties().addAll((Collection) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case BridgePackage.CLASSIFIER__OPERATIONS:
				this.getOperations().clear();
				return;
			case BridgePackage.CLASSIFIER__PROCESSOR:
				this.setProcessor(ClassifierImpl.PROCESSOR_EDEFAULT);
				return;
			case BridgePackage.CLASSIFIER__PROPERTIES:
				this.getProperties().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BridgePackage.CLASSIFIER__OPERATIONS:
				return this.operations != null && !this.operations.isEmpty();
			case BridgePackage.CLASSIFIER__PROCESSOR:
				return ClassifierImpl.PROCESSOR_EDEFAULT == null ? this.processor != null
				        : !ClassifierImpl.PROCESSOR_EDEFAULT.equals(this.processor);
			case BridgePackage.CLASSIFIER__PROPERTIES:
				return this.properties != null && !this.properties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (this.eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (operations: ");
		result.append(this.operations);
		result.append(", processor: ");
		result.append(this.processor);
		result.append(')');
		return result.toString();
	}

} // ClassifierImpl
