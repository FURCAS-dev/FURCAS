/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.OclProcessor;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.factories.TypeFactory;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Classifier</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.Classifier#getOperations <em>Operations</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.Classifier#getProcessor <em>Processor</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.Classifier#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getClassifier()
 * @model
 * @generated
 */
public interface Classifier extends Namespace {
	/**
	 * Returns the value of the '<em><b>Operations</b></em>' attribute list. The list contents are
	 * of type {@link java.lang.Object}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' attribute list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Operations</em>' attribute list.
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getClassifier_Operations()
	 * @model dataType="org.oslo.ocl20.semantics.Object" transient="true"
	 * @generated
	 */
	EList getOperations();

	/**
	 * Returns the value of the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processor</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Processor</em>' attribute.
	 * @see #setProcessor(OclProcessor)
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getClassifier_Processor()
	 * @model dataType="org.oslo.ocl20.semantics.OclProcessor" required="true" transient="true"
	 * @generated
	 */
	OclProcessor getProcessor();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.semantics.bridge.Classifier#getProcessor
	 * <em>Processor</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Processor</em>' attribute.
	 * @see #getProcessor()
	 * @generated
	 */
	void setProcessor(OclProcessor value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' reference list. The list contents are
	 * of type {@link org.oslo.ocl20.semantics.bridge.Property}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Properties</em>' reference list.
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getClassifier_Properties()
	 * @model type="org.oslo.ocl20.semantics.bridge.Property"
	 * @generated
	 */
	EList getProperties();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='Property pr = localLookupProperty(name);\nif (pr!= null) return pr;\n//if still not found, look in super types\njava.util.Iterator i = this.getAllSuperTypes().iterator();\nwhile (i.hasNext()) {\n\tClassifier c = (Classifier) i.next();\n\tProperty p = c.localLookupProperty(name);\n\tif (p!=null)\n\t\treturn p;\n}\nreturn null;'"
	 * @generated
	 */
	Property lookupProperty(String name);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model typesDataType="org.oslo.ocl20.semantics.List" typesMany="false" annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tOperation op = lookupCachedOp(name, types);\n\t\treturn op;'"
	 * @generated
	 */
	Operation lookupOperation(String name, List types);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model typesDataType="org.oslo.ocl20.semantics.List" typesMany="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;'"
	 * @generated
	 */
	Signal lookupSignal(String name, List types);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Boolean" annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this.equals(c))\n\treturn Boolean.TRUE;\nif (c.getClass() == org.oslo.ocl20.semantics.model.types.OclAnyType.class && !(this instanceof org.oslo.ocl20.semantics.model.types.CollectionType))\n\treturn Boolean.TRUE;\nreturn Boolean.FALSE;'"
	 * @generated
	 */
	Boolean conformsTo(Classifier c);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" dataType="org.oslo.ocl20.semantics.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return java.lang.Class.class;'"
	 * @generated
	 */
	Object getDelegate();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" dataType="org.oslo.ocl20.semantics.Class" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return org.oslo.ocl20.standard.lib.OclType.class;'"
	 * @generated
	 */
	Class getImplClass();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='java.util.Iterator i = getProperties().iterator();\nwhile (i.hasNext()) {\n\tProperty p = (Property) i.next();\n\tif (p.getName().equals(name))\n\t\treturn p;\n}\nreturn null;'"
	 * @generated
	 */
	Property localLookupProperty(String name);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" dataType="org.oslo.ocl20.semantics.List" many="false" annotation="http://www.eclipse.org/emf/2002/GenModel body='List result = new java.util.Vector();\nList x = this.getSuperTypes();\nresult.addAll(x);\njava.util.Iterator i = x.iterator();\nwhile (i.hasNext()) {\n\tClassifier c = (Classifier)i.next();\n\tjava.util.Iterator j = c.getAllSuperTypes().iterator();\n\twhile (j.hasNext()) {\n\t\tClassifier st = (Classifier)j.next();\n\t\tif (!result.contains(st)) {\n\t\t\tresult.add(st);\n\t\t}\n\t}\n}\nreturn result;\n'"
	 * @generated
	 */
	List getAllSuperTypes();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model typeFactoryDataType="org.oslo.ocl20.semantics.TypeFactory"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='// no exception'"
	 * @generated
	 */
	void createOperations(TypeFactory typeFactory);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model 
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='getProperties().add(prop);'"
	 * @generated
	 */
	void addProperty(Property prop);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model 
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='getOperations().add(operation);'"
	 * @generated
	 */
	void addOperation(Operation operation);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;'"
	 * @generated
	 */
	ModelElement lookupOwnedElement(String name);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model typesDataType="org.oslo.ocl20.semantics.List" typesMany="false" annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\tjava.util.Iterator i = getOperations().iterator();\r\n\t\twhile (i.hasNext()) {\r\n\t\t\tOperation op = (Operation) i.next();\r\n\t\t\tString opName = op.getName();\r\n\t\t\tif (opName.equals(name)) {\r\n\t\t\t\tList parameters = op.getOwnedParameter();\r\n\t\t\t\tList parameterTypes = new ArrayList(parameters.size());\r\n\t\t\t\tfor (Iterator iter = parameters.iterator(); iter.hasNext();) {\r\n\t\t\t\t\tParameter parameter = (Parameter) iter.next();\r\n\t\t\t\t\tparameterTypes.add(parameter.getParamType());\r\n\t\t\t\t}\r\n\t\t\t\tif (typesConform(parameterTypes, types))\r\n\t\t\t\t\treturn op;\r\n\t\t\t}\r\n\t\t}\r\n\t\t// if still not found, look in super types\r\n\t\ti = this.getSuperTypes().iterator();\r\n\t\twhile (i.hasNext()) {\r\n\t\t\tClassifier c = (Classifier) i.next();\r\n\t\t\tOperation p = c.lookupOperation(name, types);\r\n\t\t\tif (p != null)\r\n\t\t\t\treturn p;\r\n\t\t}\r\n\t\treturn null;'"
	 * @generated
	 */
	Operation lookupCachedOp(String name, List types);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" dataType="org.oslo.ocl20.semantics.List" many="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new java.util.Vector();'"
	 * @generated
	 */
	List getSuperTypes();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model paramTypesDataType="org.oslo.ocl20.semantics.List" paramTypesMany="false"
	 *        argTypesDataType="org.oslo.ocl20.semantics.List" argTypesMany="false" annotation="http://www.eclipse.org/emf/2002/GenModel body='if (paramTypes==null) paramTypes=new java.util.Vector();\nif (argTypes==null) argTypes = new java.util.Vector();\nif (paramTypes.size() != argTypes.size())\n\treturn false;\nfor (int i = 0; i < paramTypes.size(); i++) {\n\tClassifier paramType = (Classifier) paramTypes.get(i);\n\tClassifier argType = (Classifier) argTypes.get(i);\n\tif (argType == null)\n\t\treturn false;\n\tif (argType.conformsTo(paramType) == Boolean.FALSE)\n\t\treturn false;\n}\nreturn true;'"
	 * @generated
	 */
	boolean typesConform(List paramTypes, List argTypes);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\t\t\tEnvironment env = this.getProcessor().getBridgeFactory().buildEnvironment();\n\t\t\t\tEnvironment result = env.addNamespace(this);\n\t\t\t\tresult.setParent(null);\n\t\t\t\treturn result;'"
	 * @generated
	 */
	Environment getEnvironmentWithoutParents();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\t\t\tif (this.getNamespace() == null) {\n\t\t\t\t\treturn null;\n\t\t\t\t} else {\n\t\t\t\t\tEnvironment result = getEnvironmentWithoutParents();\n\t\t\t\t\tresult.setParent(this.getNamespace().getEnvironmentWithParents());\n\t\t\t\t\treturn result;\n\t\t\t\t}'"
	 * @generated
	 */
	Environment getEnvironmentWithParents();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // Classifier
