/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.oslo.ocl20.OclProcessor;

import org.oslo.ocl20.semantics.factories.BridgeFactory;

import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Environment</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.Environment#getBridgeFactory <em>Bridge Factory</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.Environment#getNamedElementEntrys <em>Named Element
 * Entrys</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.Environment#getNamespaces <em>Namespaces</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.Environment#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getEnvironment()
 * @model annotation="see see=''"
 * @generated
 */
public interface Environment extends EObject {
	/**
	 * Returns the value of the '<em><b>Bridge Factory</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bridge Factory</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Bridge Factory</em>' attribute.
	 * @see #setBridgeFactory(BridgeFactory)
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getEnvironment_BridgeFactory()
	 * @model dataType="org.oslo.ocl20.semantics.BridgeFactory" required="true" transient="true"
	 * @generated
	 */
	BridgeFactory getBridgeFactory();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.semantics.bridge.Environment#getBridgeFactory
	 * <em>Bridge Factory</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Bridge Factory</em>' attribute.
	 * @see #getBridgeFactory()
	 * @generated
	 */
	void setBridgeFactory(BridgeFactory value);

	/**
	 * Returns the value of the '<em><b>Named Element Entrys</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Element Entrys</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Named Element Entrys</em>' attribute.
	 * @see #setNamedElementEntrys(Map)
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getEnvironment_NamedElementEntrys()
	 * @model dataType="org.oslo.ocl20.semantics.Map" required="true" transient="true"
	 * @generated
	 */
	Map getNamedElementEntrys();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.bridge.Environment#getNamedElementEntrys
	 * <em>Named Element Entrys</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Named Element Entrys</em>' attribute.
	 * @see #getNamedElementEntrys()
	 * @generated
	 */
	void setNamedElementEntrys(Map value);

	/**
	 * Returns the value of the '<em><b>Namespaces</b></em>' reference list. The list contents are
	 * of type {@link org.oslo.ocl20.semantics.bridge.Namespace}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespaces</em>' reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Namespaces</em>' reference list.
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getEnvironment_Namespaces()
	 * @model type="org.oslo.ocl20.semantics.bridge.Namespace"
	 * @generated
	 */
	EList getNamespaces();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Environment)
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getEnvironment_Parent()
	 * @model required="true"
	 * @generated
	 */
	Environment getParent();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.semantics.bridge.Environment#getParent
	 * <em>Parent</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Environment value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='NamedElement nel = (NamedElement) getNamedElementEntrys().get(name);\nif (nel == null) {\n\tjava.util.Iterator i = this.getNamespaces().iterator();\n\twhile (i.hasNext() && nel == null) {\n\t\tNamespace ns = (Namespace) i.next();\n\t\tModelElement me = ns.lookupOwnedElement(name);\n\t\tif (me != null) {\n\t\t\tnel = bridgeFactory.buildNamedElement(name, me, Boolean.FALSE);\n\t\t\tif (nel != null) getNamedElementEntrys().put(name, nel);\n\t\t}\n\t}\n}\nreturn nel;\n'"
	 * @generated
	 */
	NamedElement lookupLocal(String name);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tNamedElement ne = lookupLocal(name);\n\t\tif (ne != null) {\n\t\t\treturn ne.getReferredElement();\n\t\t} else {\n\t\t\tif (getParent() != null ) {\n\t\t\t   return getParent().lookup(name);\n\t\t\t} else {\n\t\t\t\treturn null;\n\t\t\t}\n\t\t}'"
	 * @generated
	 */
	ModelElement lookup(String name);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model namesDataType="org.oslo.ocl20.semantics.List" namesMany="false" annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tif (names.size() == 1)\n\t\t\treturn lookup((String) names.get(0));\n\t\telse {\n\t\t\tNamedElement nel = lookupLocal((String) names.get(0));\n\t\t\t//if (nel == null) return null;\n\t\t\tif (nel!=null && nel.getReferredElement() instanceof Namespace) {\n\t\t\t\t// indicates a sub namespace of the namespace in which self is present\n\t\t\t\treturn nestedEnvironment().addNamespace((Namespace) nel.getReferredElement()).lookupPathName(names.subList(1, names.size()));\n\t\t\t} else {\n\t\t\t\t// search in surrounding namespace\n\t\t\t\tif (getParent() != null ) {\n\t\t\t\t\treturn getParent().lookupPathName(names);\n\t\t\t\t} else {\n\t\t\t\t\treturn null;\n\t\t\t\t}\n\t\t\t}\n\t\t}'"
	 * @generated
	 */
	ModelElement lookupPathName(List names);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model impDataType="org.oslo.ocl20.semantics.Boolean" annotation="http://www.eclipse.org/emf/2002/GenModel body='if (name == null) return this;\n// the name must not clash with names already existing in this environment\nif (getNamedElementEntrys().get(name) != null) {\n\treturn this;\n}\nEnvironmentImpl result;\n\tresult = (EnvironmentImpl) this.clone();\nresult.getNamedElementEntrys().put(name, org.oslo.ocl20.synthesis.CreationHelper.createNamedElement(name, elem, imp));\nreturn result;\n\n'"
	 * @generated
	 */
	Environment addElement(String name, ModelElement elem, Boolean imp);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='// the names must not clash with names already existing in this environment\njava.util.Iterator i = ((EnvironmentImpl) env).getNamedElementEntrys().keySet().iterator();\nwhile (i.hasNext()) {\n\tString s = (String) i.next();\n\tif (this.getNamedElementEntrys().containsKey(s)) {\n\t\tthrow new RuntimeException(\"In Environment.addEnvironment: Name already exists in environemnt - \" + s);\n\t}\n}\n\nEnvironmentImpl result = (EnvironmentImpl) this.clone();\n\nresult.getNamespaces().addAll(((EnvironmentImpl) env).getNamespaces());\nresult.getNamedElementEntrys().putAll(((EnvironmentImpl) env).getNamedElementEntrys());\nreturn result;'"
	 * @generated
	 */
	Environment addEnvironment(Environment env);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tEnvironmentImpl result;\n\t\tresult = (EnvironmentImpl) this.clone();\n\t\tresult.namespaces.add(ns);\n\t\treturn result.addElement(ns.getName(), ns, Boolean.FALSE);'"
	 * @generated
	 */
	Environment addNamespace(Namespace ns);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='NamedElement entry = lookupImplicitSourceForProperty(name);\nif (entry != null) {\n\torg.oslo.ocl20.semantics.bridge.ModelElement source = entry.getReferredElement();\n\tif (source != null && source instanceof org.oslo.ocl20.semantics.model.expressions.VariableDeclaration) {\n\t\tsource = ((org.oslo.ocl20.semantics.model.expressions.VariableDeclaration)source).getType();\n\t}\n\tif (source != null && source instanceof org.oslo.ocl20.semantics.bridge.Classifier) {\n\t\tProperty result = ((org.oslo.ocl20.semantics.bridge.Classifier)source).lookupProperty(name);\n\t\treturn result;\n\t}\n}\nreturn null;'"
	 * @generated
	 */
	Property lookupImplicitProperty(String name);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='// For each element\nNamedElement foundElement = null;\njava.util.Iterator i = getNamedElements().iterator();\nwhile (i.hasNext()) {\n\tNamedElement entry = (NamedElement)i.next();\n\t// Implicit element\n\tif (entry != null && entry.getMayBeImplicit() != null && entry.getMayBeImplicit().booleanValue()) {\n\t\t// foundElement = entry.getType().lookupAttribute(name)\n\t\torg.oslo.ocl20.semantics.bridge.Classifier type = entry.getType();\n\t\tif (type != null) {\n\t\t\tProperty foundProperty = type.lookupProperty(name);\n\t\t\tif (foundProperty != null)\n\t\t\t\tfoundElement = entry;\n\t\t}\n\t}\n}\n// Search up\nif (foundElement == null) {\n\tEnvironment parent = getParent();\n\tif (parent != null) return parent.lookupImplicitSourceForProperty(name);\n\treturn null;\n} else {\n\treturn foundElement;\n}'"
	 * @generated
	 */
	NamedElement lookupImplicitSourceForProperty(String name);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model typesDataType="org.oslo.ocl20.semantics.List" typesMany="false" annotation="http://www.eclipse.org/emf/2002/GenModel body='NamedElement ne = lookupImplicitSourceForOperation(name, types);\nif (ne== null) {\n    bridgeFactory.buildClassifier(this);\n    //ErrorManager.reportError(null,\"Environment, Can\'t Find \"+name+params);\n} else {\n    org.oslo.ocl20.semantics.bridge.ModelElement source = ne.getReferredElement();\n\tif (source instanceof org.oslo.ocl20.semantics.model.expressions.VariableDeclaration) {\n\t\tsource = ((org.oslo.ocl20.semantics.model.expressions.VariableDeclaration)source).getType();\n\t}\n\tif (source instanceof org.oslo.ocl20.semantics.bridge.Classifier) {\n\t\torg.oslo.ocl20.semantics.bridge.Operation result = ((org.oslo.ocl20.semantics.bridge.Classifier)source).lookupOperation(name, types);\n\t\treturn result;\n\t}\n}\nreturn null;'"
	 * @generated
	 */
	Operation lookupImplicitOperation(String name, List types);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tEnvironment result = new EnvironmentImpl();\n\t\tresult.setBridgeFactory(bridgeFactory);\n\t\tresult.setParent(this);\n\t\treturn result;'"
	 * @generated
	 */
	Environment nestedEnvironment();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model namesDataType="org.oslo.ocl20.semantics.List" namesMany="false"
	 *        typesDataType="org.oslo.ocl20.semantics.List" typesMany="false" annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tif (names.size() == 2) {\n\t\t\tClassifier cl = (Classifier) lookup((String) names.get(0));\n\t\t\tString op_name = (String) names.get(1);\n\t\t\treturn cl.lookupOperation(op_name, types);\n\t\t} else {\n\t\t\tModelElement firstNamespace = lookupLocal((String) names.get(0)).getReferredElement();\n\t\t\tif (firstNamespace instanceof Namespace) {\n\t\t\t\t// indicates a sub namespace of the namespace in which self is present\n\t\t\t\treturn nestedEnvironment().addNamespace((Namespace) firstNamespace).lookupPathName(names.subList(1, names.size()), types);\n\t\t\t} else {\n\t\t\t\t// search in surrounding namespace\n\t\t\t\treturn getParent().lookupPathName(names, types);\n\t\t\t}\n\t\t}'"
	 * @generated
	 */
	Operation lookupPathName(List names, List types);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model typesDataType="org.oslo.ocl20.semantics.List" typesMany="false" annotation="http://www.eclipse.org/emf/2002/GenModel body='// For each element\nNamedElement foundElement = null;\njava.util.Iterator i = getNamedElements().iterator();\nwhile (i.hasNext()) {\n\tNamedElement entry = (NamedElement)i.next();\n\t// Implicit element\n\tif (entry.getMayBeImplicit().booleanValue()) {\n\t\t// foundElement = entry.getType().lookupOperation(name, params)\n\t\torg.oslo.ocl20.semantics.bridge.Operation foundOperation = entry.getType().lookupOperation(name, types);\n\t\tif (foundOperation != null)\n\t\t\tfoundElement = entry;\n\t}\n}\n// Search up\nif (foundElement == null) {\n\tEnvironment parent = getParent();\n\tif (parent != null) return parent.lookupImplicitSourceForOperation(name, types);\n\telse return null;\n// Return the found element\n} else {\n\treturn foundElement;\n}'"
	 * @generated
	 */
	NamedElement lookupImplicitSourceForOperation(String name, List types);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model clashDataType="org.oslo.ocl20.semantics.Boolean" annotation="http://www.eclipse.org/emf/2002/GenModel body='if (name == null) return this;\nif (type == null) return this;\n// the name must not clash with names already existing in this environment\nif (getNamedElementEntrys().get(name) != null) return this;\norg.oslo.ocl20.semantics.model.expressions.VariableDeclaration vd = org.oslo.ocl20.synthesis.CreationHelper.createVariableDeclaration(name);\nvd.setType(type);\nEnvironmentImpl result;\nresult = (EnvironmentImpl) this.clone();\nresult.getNamedElementEntrys().put(name, org.oslo.ocl20.synthesis.CreationHelper.createNamedElement(name, vd, clash));\nreturn result;\n\n'"
	 * @generated
	 */
	Environment addVariableDeclaration(String name, Classifier type, Boolean clash);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object" annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tEnvironmentImpl copy = new EnvironmentImpl();\n\t\tcopy.setBridgeFactory(bridgeFactory);\n\t\tcopy.getNamedElementEntrys().putAll(getNamedElementEntrys());\n\t\tcopy.getNamespaces().addAll(getNamespaces());\n\t\tcopy.parent = parent;\n\t\treturn copy;\n'"
	 * @generated
	 */
	Object clone();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" dataType="org.oslo.ocl20.semantics.OclProcessor" annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.factories.BridgeFactory)bridgeFactory).getProcessor();'"
	 * @generated
	 */
	OclProcessor getProcessor();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tEnvironmentImpl newEnvironment = new EnvironmentImpl(); \n\t\tnewEnvironment.setBridgeFactory(bridgeFactory);\n\t\treturn newEnvironment;'"
	 * @generated
	 */
	Environment getEMPTY_ENV();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" dataType="org.oslo.ocl20.semantics.Set" annotation="http://www.eclipse.org/emf/2002/GenModel body='return new java.util.LinkedHashSet(getNamedElementEntrys().values());'"
	 * @generated
	 */
	Set getNamedElements();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model namedElementsDataType="org.oslo.ocl20.semantics.Set" annotation="http://www.eclipse.org/emf/2002/GenModel body='getNamedElementEntrys().clear();\njava.util.Iterator i = namedElements.iterator();\nwhile (i.hasNext()) {\n\tNamedElement ne = (NamedElement)i.next();\n\tthis.getNamedElementEntrys().put(ne.getName(), ne);\n}'"
	 * @generated
	 */
	void setNamedElements(Set namedElements);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model clashDataType="org.oslo.ocl20.semantics.Boolean" annotation="http://www.eclipse.org/emf/2002/GenModel body='if (variableDeclaration == null) return this;\nif (variableDeclaration.getName() == null) return this;\n// the name must not clash with names already existing in this environment\nif (getNamedElementEntrys().get(variableDeclaration.getName()) != null) return this;\nEnvironmentImpl result;\nresult = (EnvironmentImpl) this.clone();\nresult.getNamedElementEntrys().put(variableDeclaration.getName(), org.oslo.ocl20.synthesis.CreationHelper.createNamedElement(variableDeclaration.getName(), variableDeclaration, clash));\nreturn result;'"
	 * @generated
	 */
	Environment addVariableDeclaration(VariableDeclaration variableDeclaration, Boolean clash);

} // Environment
