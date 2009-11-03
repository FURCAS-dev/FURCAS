/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.bridge.BridgePackage;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.NamedElement;
import org.oslo.ocl20.semantics.bridge.Namespace;
import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.semantics.factories.BridgeFactory;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Environment</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.EnvironmentImpl#getBridgeFactory <em>Bridge
 * Factory</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.EnvironmentImpl#getNamedElementEntrys <em>Named
 * Element Entrys</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.EnvironmentImpl#getNamespaces <em>Namespaces
 * </em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.impl.EnvironmentImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EnvironmentImpl extends EObjectImpl implements Environment {

	public static final String COMPOUND_PACKAGE_SEPARATOR = ".";

	/**
	 * The default value of the '{@link #getBridgeFactory() <em>Bridge Factory</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBridgeFactory()
	 * @generated
	 * @ordered
	 */
	protected static final BridgeFactory BRIDGE_FACTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBridgeFactory() <em>Bridge Factory</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBridgeFactory()
	 * @generated
	 * @ordered
	 */
	protected BridgeFactory bridgeFactory = EnvironmentImpl.BRIDGE_FACTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getNamedElementEntrys() <em>Named Element Entrys</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNamedElementEntrys()
	 * @generated
	 * @ordered
	 */
	protected static final Map NAMED_ELEMENT_ENTRYS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamedElementEntrys() <em>Named Element Entrys</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNamedElementEntrys()
	 * @generated
	 * @ordered
	 */
	protected Map namedElementEntrys = new HashMap();

	/**
	 * The cached value of the '{@link #getNamespaces() <em>Namespaces</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNamespaces()
	 * @generated
	 * @ordered
	 */
	protected EList namespaces;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected Environment parent;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EnvironmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return BridgePackage.Literals.ENVIRONMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BridgeFactory getBridgeFactory() {
		return this.bridgeFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBridgeFactory(BridgeFactory newBridgeFactory) {
		BridgeFactory oldBridgeFactory = this.bridgeFactory;
		this.bridgeFactory = newBridgeFactory;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, BridgePackage.ENVIRONMENT__BRIDGE_FACTORY,
			    oldBridgeFactory, this.bridgeFactory));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map getNamedElementEntrys() {
		return this.namedElementEntrys;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNamedElementEntrys(Map newNamedElementEntrys) {
		Map oldNamedElementEntrys = this.namedElementEntrys;
		this.namedElementEntrys = newNamedElementEntrys;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, BridgePackage.ENVIRONMENT__NAMED_ELEMENT_ENTRYS,
			    oldNamedElementEntrys, this.namedElementEntrys));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList getNamespaces() {
		if (this.namespaces == null) {
			this.namespaces = new EObjectResolvingEList(Namespace.class, this, BridgePackage.ENVIRONMENT__NAMESPACES);
		}
		return this.namespaces;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Environment getParent() {
		if (this.parent != null && this.parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject) this.parent;
			this.parent = (Environment) this.eResolveProxy(oldParent);
			if (this.parent != oldParent) {
				if (this.eNotificationRequired()) {
					this.eNotify(new ENotificationImpl(this, Notification.RESOLVE, BridgePackage.ENVIRONMENT__PARENT,
					    oldParent, this.parent));
				}
			}
		}
		return this.parent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Environment basicGetParent() {
		return this.parent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParent(Environment newParent) {
		Environment oldParent = this.parent;
		this.parent = newParent;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, BridgePackage.ENVIRONMENT__PARENT, oldParent,
			    this.parent));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement lookupLocal(String name) {
		NamedElement nel = (NamedElement) this.getNamedElementEntrys().get(name);
		if (nel == null) {
			java.util.Iterator i = this.getNamespaces().iterator();
			while (i.hasNext() && nel == null) {
				Namespace ns = (Namespace) i.next();
				ModelElement me = null;
				try {
					me = ns.lookupOwnedElement(name);
				} catch (RuntimeException e) {
				}
				if (me != null) {
					nel = this.bridgeFactory.buildNamedElement(name, me, Boolean.FALSE);
					if (nel != null) {
						this.getNamedElementEntrys().put(name, nel);
					}
				}
			}
		}
		return nel;

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElement lookup(String name) {
		NamedElement ne = this.lookupLocal(name);
		if (ne != null) {
			return ne.getReferredElement();
		} else {
			if (this.getParent() != null) {
				return this.getParent().lookup(name);
			} else {
				return null;
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElement lookupPathName(List names) {
		if (names.size() == 1) {
			return this.lookup((String) names.get(0));
		} else {
			String compoundName = (String) names.get(0);
			for (int addedPart = 0; addedPart < names.size(); addedPart++) {
				if (addedPart != 0) {
					compoundName = compoundName + EnvironmentImpl.COMPOUND_PACKAGE_SEPARATOR
					        + (String) names.get(addedPart);
				}
				NamedElement nel = this.lookupLocal(compoundName);
				// if (nel == null) return null;
				if (nel != null && nel.getReferredElement() instanceof Namespace) {
					// indicates a sub namespace of the namespace in which self is present
					return this.nestedEnvironment().addNamespace((Namespace) nel.getReferredElement()).lookupPathName(
					    names.subList(addedPart + 1, names.size()));
				} else {
					// search in surrounding namespace
					if (this.getParent() != null) {
						ModelElement result = this.getParent().lookupPathName(names);
						if (result != null) {
							return result;
						}
					}
				}
			}
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Environment addElement(String name, ModelElement elem, Boolean imp) {
		if (name == null) {
			return this;
		}
		// the name must not clash with names already existing in this environment
		if (this.getNamedElementEntrys().get(name) != null) {
			return this;
		}
		EnvironmentImpl result;
		result = (EnvironmentImpl) this.clone();
		result.getNamedElementEntrys().put(name,
		    org.oslo.ocl20.synthesis.CreationHelper.createNamedElement(name, elem, imp));
		return result;

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Environment addEnvironment(Environment env) {
		// the names must not clash with names already existing in this environment
		java.util.Iterator i = ((EnvironmentImpl) env).getNamedElementEntrys().keySet().iterator();
		while (i.hasNext()) {
			String s = (String) i.next();
			if (this.getNamedElementEntrys().containsKey(s)) {
				throw new RuntimeException("In Environment.addEnvironment: Name already exists in environemnt - " + s);
			}
		}

		EnvironmentImpl result = (EnvironmentImpl) this.clone();

		result.getNamespaces().addAll(((EnvironmentImpl) env).getNamespaces());
		result.getNamedElementEntrys().putAll(((EnvironmentImpl) env).getNamedElementEntrys());
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Environment addNamespace(Namespace ns) {
		EnvironmentImpl result;
		result = (EnvironmentImpl) this.clone();
		result.namespaces.add(ns);
		return result.addElement(ns.getName(), ns, Boolean.FALSE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Property lookupImplicitProperty(String name) {
		NamedElement entry = this.lookupImplicitSourceForProperty(name);
		if (entry != null) {
			org.oslo.ocl20.semantics.bridge.ModelElement source = entry.getReferredElement();
			if (source != null && source instanceof org.oslo.ocl20.semantics.model.expressions.VariableDeclaration) {
				source = ((org.oslo.ocl20.semantics.model.expressions.VariableDeclaration) source).getType();
			}
			if (source != null && source instanceof org.oslo.ocl20.semantics.bridge.Classifier) {
				Property result = ((org.oslo.ocl20.semantics.bridge.Classifier) source).lookupProperty(name);
				return result;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement lookupImplicitSourceForProperty(String name) {
		// For each element
		NamedElement foundElement = null;
		java.util.Iterator i = this.getNamedElements().iterator();
		while (i.hasNext()) {
			NamedElement entry = (NamedElement) i.next();
			// Implicit element
			if (entry != null && entry.getMayBeImplicit() != null && entry.getMayBeImplicit().booleanValue()) {
				// foundElement = entry.getType().lookupAttribute(name)
				org.oslo.ocl20.semantics.bridge.Classifier type = entry.getType();
				if (type != null) {
					Property foundProperty = type.lookupProperty(name);
					if (foundProperty != null) {
						foundElement = entry;
					}
				}
			}
		}
		// Search up
		if (foundElement == null) {
			Environment parent = this.getParent();
			if (parent != null) {
				return parent.lookupImplicitSourceForProperty(name);
			}
			return null;
		} else {
			return foundElement;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Operation lookupImplicitOperation(String name, List types) {
		NamedElement ne = this.lookupImplicitSourceForOperation(name, types);
		if (ne == null) {
			this.bridgeFactory.buildClassifier(this);
			// ErrorManager.reportError(null,"Environment, Can't Find "+name+params);
		} else {
			org.oslo.ocl20.semantics.bridge.ModelElement source = ne.getReferredElement();
			if (source instanceof org.oslo.ocl20.semantics.model.expressions.VariableDeclaration) {
				source = ((org.oslo.ocl20.semantics.model.expressions.VariableDeclaration) source).getType();
			}
			if (source instanceof org.oslo.ocl20.semantics.bridge.Classifier) {
				org.oslo.ocl20.semantics.bridge.Operation result = ((org.oslo.ocl20.semantics.bridge.Classifier) source)
				        .lookupOperation(name, types);
				return result;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Environment nestedEnvironment() {
		Environment result = new EnvironmentImpl();
		result.setBridgeFactory(this.bridgeFactory);
		result.setParent(this);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Operation lookupPathName(List names, List types) {
		if (names.size() == 2) {
			Classifier cl = (Classifier) this.lookup((String) names.get(0));
			String op_name = (String) names.get(1);
			return cl.lookupOperation(op_name, types);
		} else {
			ModelElement firstNamespace = this.lookupLocal((String) names.get(0)).getReferredElement();
			if (firstNamespace instanceof Namespace) {
				// indicates a sub namespace of the namespace in which self is present
				return this.nestedEnvironment().addNamespace((Namespace) firstNamespace).lookupPathName(
				    names.subList(1, names.size()), types);
			} else {
				// search in surrounding namespace
				return this.getParent().lookupPathName(names, types);
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement lookupImplicitSourceForOperation(String name, List types) {
		// For each element
		NamedElement foundElement = null;
		java.util.Iterator i = this.getNamedElements().iterator();
		while (i.hasNext()) {
			NamedElement entry = (NamedElement) i.next();
			// Implicit element
			if (entry.getMayBeImplicit().booleanValue()) {
				// foundElement = entry.getType().lookupOperation(name, params)
				org.oslo.ocl20.semantics.bridge.Operation foundOperation = entry.getType().lookupOperation(name, types);
				if (foundOperation != null) {
					foundElement = entry;
				}
			}
		}
		// Search up
		if (foundElement == null) {
			Environment parent = this.getParent();
			if (parent != null) {
				return parent.lookupImplicitSourceForOperation(name, types);
			} else {
				return null;
				// Return the found element
			}
		} else {
			return foundElement;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Environment addVariableDeclaration(String name, Classifier type, Boolean clash) {
		if (name == null) {
			return this;
		}
		if (type == null) {
			return this;
		}
		// the name must not clash with names already existing in this environment
		if (this.getNamedElementEntrys().get(name) != null) {
			return this;
		}
		org.oslo.ocl20.semantics.model.expressions.VariableDeclaration vd = org.oslo.ocl20.synthesis.CreationHelper
		        .createVariableDeclaration(name);
		vd.setType(type);
		EnvironmentImpl result;
		result = (EnvironmentImpl) this.clone();
		result.getNamedElementEntrys().put(name,
		    org.oslo.ocl20.synthesis.CreationHelper.createNamedElement(name, vd, clash));
		return result;

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object clone() {
		EnvironmentImpl copy = new EnvironmentImpl();
		copy.setBridgeFactory(this.bridgeFactory);
		copy.getNamedElementEntrys().putAll(this.getNamedElementEntrys());
		copy.getNamespaces().addAll(this.getNamespaces());
		copy.parent = this.parent;
		return copy;

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OclProcessor getProcessor() {
		return (this.bridgeFactory).getProcessor();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Environment getEMPTY_ENV() {
		EnvironmentImpl newEnvironment = new EnvironmentImpl();
		newEnvironment.setBridgeFactory(this.bridgeFactory);
		return newEnvironment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Set getNamedElements() {
		return new java.util.LinkedHashSet(this.getNamedElementEntrys().values());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNamedElements(Set namedElements) {
		this.getNamedElementEntrys().clear();
		java.util.Iterator i = namedElements.iterator();
		while (i.hasNext()) {
			NamedElement ne = (NamedElement) i.next();
			this.getNamedElementEntrys().put(ne.getName(), ne);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Environment addVariableDeclaration(VariableDeclaration variableDeclaration, Boolean clash) {
		if (variableDeclaration == null) {
			return this;
		}
		if (variableDeclaration.getName() == null) {
			return this;
		}
		// the name must not clash with names already existing in this environment
		if (this.getNamedElementEntrys().get(variableDeclaration.getName()) != null) {
			return this;
		}
		EnvironmentImpl result;
		result = (EnvironmentImpl) this.clone();
		result.getNamedElementEntrys().put(
		    variableDeclaration.getName(),
		    org.oslo.ocl20.synthesis.CreationHelper.createNamedElement(variableDeclaration.getName(),
		        variableDeclaration, clash));
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BridgePackage.ENVIRONMENT__BRIDGE_FACTORY:
				return this.getBridgeFactory();
			case BridgePackage.ENVIRONMENT__NAMED_ELEMENT_ENTRYS:
				return this.getNamedElementEntrys();
			case BridgePackage.ENVIRONMENT__NAMESPACES:
				return this.getNamespaces();
			case BridgePackage.ENVIRONMENT__PARENT:
				if (resolve) {
					return this.getParent();
				}
				return this.basicGetParent();
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
			case BridgePackage.ENVIRONMENT__BRIDGE_FACTORY:
				this.setBridgeFactory((BridgeFactory) newValue);
				return;
			case BridgePackage.ENVIRONMENT__NAMED_ELEMENT_ENTRYS:
				this.setNamedElementEntrys((Map) newValue);
				return;
			case BridgePackage.ENVIRONMENT__NAMESPACES:
				this.getNamespaces().clear();
				this.getNamespaces().addAll((Collection) newValue);
				return;
			case BridgePackage.ENVIRONMENT__PARENT:
				this.setParent((Environment) newValue);
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
			case BridgePackage.ENVIRONMENT__BRIDGE_FACTORY:
				this.setBridgeFactory(EnvironmentImpl.BRIDGE_FACTORY_EDEFAULT);
				return;
			case BridgePackage.ENVIRONMENT__NAMED_ELEMENT_ENTRYS:
				this.setNamedElementEntrys(EnvironmentImpl.NAMED_ELEMENT_ENTRYS_EDEFAULT);
				return;
			case BridgePackage.ENVIRONMENT__NAMESPACES:
				this.getNamespaces().clear();
				return;
			case BridgePackage.ENVIRONMENT__PARENT:
				this.setParent((Environment) null);
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
			case BridgePackage.ENVIRONMENT__BRIDGE_FACTORY:
				return EnvironmentImpl.BRIDGE_FACTORY_EDEFAULT == null ? this.bridgeFactory != null
				        : !EnvironmentImpl.BRIDGE_FACTORY_EDEFAULT.equals(this.bridgeFactory);
			case BridgePackage.ENVIRONMENT__NAMED_ELEMENT_ENTRYS:
				return EnvironmentImpl.NAMED_ELEMENT_ENTRYS_EDEFAULT == null ? this.namedElementEntrys != null
				        : !EnvironmentImpl.NAMED_ELEMENT_ENTRYS_EDEFAULT.equals(this.namedElementEntrys);
			case BridgePackage.ENVIRONMENT__NAMESPACES:
				return this.namespaces != null && !this.namespaces.isEmpty();
			case BridgePackage.ENVIRONMENT__PARENT:
				return this.parent != null;
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
		result.append(" (bridgeFactory: ");
		result.append(this.bridgeFactory);
		result.append(", namedElementEntrys: ");
		result.append(this.namedElementEntrys);
		result.append(')');
		return result.toString();
	}

} // EnvironmentImpl
