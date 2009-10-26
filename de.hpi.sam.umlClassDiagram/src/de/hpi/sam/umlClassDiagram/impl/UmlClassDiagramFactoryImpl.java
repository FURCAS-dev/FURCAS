/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.umlClassDiagram.impl;

import de.hpi.sam.umlClassDiagram.Aggregation;
import de.hpi.sam.umlClassDiagram.Attribute;
import de.hpi.sam.umlClassDiagram.Composition;
import de.hpi.sam.umlClassDiagram.Inheritance;
import de.hpi.sam.umlClassDiagram.Method;
import de.hpi.sam.umlClassDiagram.Relation;
import de.hpi.sam.umlClassDiagram.UmlClassDiagram;
import de.hpi.sam.umlClassDiagram.UmlClassDiagramFactory;
import de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlClassDiagramFactoryImpl extends EFactoryImpl implements UmlClassDiagramFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UmlClassDiagramFactory init() {
		try {
			UmlClassDiagramFactory theUmlClassDiagramFactory = (UmlClassDiagramFactory)EPackage.Registry.INSTANCE.getEFactory("http://umlClassDiagram/1.0"); 
			if (theUmlClassDiagramFactory != null) {
				return theUmlClassDiagramFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UmlClassDiagramFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlClassDiagramFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UmlClassDiagramPackage.UML_CLASS_DIAGRAM: return createUmlClassDiagram();
			case UmlClassDiagramPackage.CLASS: return createClass();
			case UmlClassDiagramPackage.ATTRIBUTE: return createAttribute();
			case UmlClassDiagramPackage.METHOD: return createMethod();
			case UmlClassDiagramPackage.COMPOSITION: return createComposition();
			case UmlClassDiagramPackage.AGGREGATION: return createAggregation();
			case UmlClassDiagramPackage.RELATION: return createRelation();
			case UmlClassDiagramPackage.INHERITANCE: return createInheritance();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlClassDiagram createUmlClassDiagram() {
		UmlClassDiagramImpl umlClassDiagram = new UmlClassDiagramImpl();
		return umlClassDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.hpi.sam.umlClassDiagram.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method createMethod() {
		MethodImpl method = new MethodImpl();
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Composition createComposition() {
		CompositionImpl composition = new CompositionImpl();
		return composition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aggregation createAggregation() {
		AggregationImpl aggregation = new AggregationImpl();
		return aggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation createRelation() {
		RelationImpl relation = new RelationImpl();
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inheritance createInheritance() {
		InheritanceImpl inheritance = new InheritanceImpl();
		return inheritance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlClassDiagramPackage getUmlClassDiagramPackage() {
		return (UmlClassDiagramPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UmlClassDiagramPackage getPackage() {
		return UmlClassDiagramPackage.eINSTANCE;
	}

} //UmlClassDiagramFactoryImpl
