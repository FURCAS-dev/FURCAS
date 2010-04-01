/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.helper.ConstraintKind;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EAnnotation OCL Parser</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclToAst.impl.EAnnotationOCLParserImpl#getSOURCE <em>SOURCE</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclToAst.impl.EAnnotationOCLParserImpl#getKIND <em>KIND</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclToAst.impl.EAnnotationOCLParserImpl#getEXPRESSION <em>EXPRESSION</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclToAst.impl.EAnnotationOCLParserImpl#getNAME <em>NAME</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EAnnotationOCLParserImpl extends EObjectImpl implements EAnnotationOCLParser {
	/**
	 * The default value of the '{@link #getSOURCE() <em>SOURCE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSOURCE()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = "http://de.hpi.sam.bp2009.OCL";
	/**
	 * The cached value of the '{@link #getSOURCE() <em>SOURCE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSOURCE()
	 * @generated
	 * @ordered
	 */
	protected String source = SOURCE_EDEFAULT;
	/**
	 * This is true if the SOURCE attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean sourceESet;

	/**
	 * The default value of the '{@link #getKIND() <em>KIND</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKIND()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_EDEFAULT = "OCL.Kind";
	/**
	 * The cached value of the '{@link #getKIND() <em>KIND</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKIND()
	 * @generated
	 * @ordered
	 */
	protected String kind = KIND_EDEFAULT;
	/**
	 * This is true if the KIND attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean kindESet;
	/**
	 * The default value of the '{@link #getEXPRESSION() <em>EXPRESSION</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEXPRESSION()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = "OCL.Expression";
	/**
	 * The cached value of the '{@link #getEXPRESSION() <em>EXPRESSION</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEXPRESSION()
	 * @generated
	 * @ordered
	 */
	protected String expression = EXPRESSION_EDEFAULT;
	/**
	 * This is true if the EXPRESSION attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean expressionESet;
	/**
	 * The default value of the '{@link #getNAME() <em>NAME</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNAME()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "OCL.Name";
	/**
	 * The cached value of the '{@link #getNAME() <em>NAME</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNAME()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * This is true if the NAME attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean nameESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EAnnotationOCLParserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OclToAstPackage.Literals.EANNOTATION_OCL_PARSER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSOURCE() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSOURCE() {
		return sourceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKIND() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetKIND() {
		return kindESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEXPRESSION() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEXPRESSION() {
		return expressionESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNAME() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNAME() {
		return nameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void convertOclAnnotation(EModelElement modelElement) {
		EAnnotation a = modelElement.getEAnnotation(getSOURCE());
		if(a==null)
			return;
		String e = a.getDetails().get(getEXPRESSION());
		if(e ==null)
			return;
		String k = a.getDetails().get(getKIND());
		OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();
		Helper helper = ocl.createOCLHelper();
		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env = ocl.getEnvironment();
		
		switch (modelElement.eClass().getClassifierID()){
			case EcorePackage.ECLASSIFIER:
				env=env.getFactory().createClassifierContext(env, (EClassifier)modelElement);
			case EcorePackage.EATTRIBUTE:
				env=env.getFactory().createAttributeContext(env, (EAttribute)modelElement);
			case EcorePackage.EOPERATION:
				env=env.getFactory().createOperationContext(env, (EOperation)modelElement);
			case EcorePackage.EPACKAGE:{
				List<String> list = new ArrayList<String>();
				list.add(((EPackage)modelElement).getNsURI().toString());
				env=env.getFactory().createPackageContext(env, list);
				}
			default:
				env=env.getFactory().createInstanceContext(env, modelElement);
		}
		Constraint c=null;
		try {
			 c= helper.createConstraint(ConstraintKind.valueOf(k), e);
		} catch (ParserException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(c==null)
			return;
		
		a.getContents().add(c.getSpecification().getBodyExpression());

	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OclToAstPackage.EANNOTATION_OCL_PARSER__SOURCE:
				return getSOURCE();
			case OclToAstPackage.EANNOTATION_OCL_PARSER__KIND:
				return getKIND();
			case OclToAstPackage.EANNOTATION_OCL_PARSER__EXPRESSION:
				return getEXPRESSION();
			case OclToAstPackage.EANNOTATION_OCL_PARSER__NAME:
				return getNAME();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OclToAstPackage.EANNOTATION_OCL_PARSER__SOURCE:
				return isSetSOURCE();
			case OclToAstPackage.EANNOTATION_OCL_PARSER__KIND:
				return isSetKIND();
			case OclToAstPackage.EANNOTATION_OCL_PARSER__EXPRESSION:
				return isSetEXPRESSION();
			case OclToAstPackage.EANNOTATION_OCL_PARSER__NAME:
				return isSetNAME();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (SOURCE: ");
		if (sourceESet) result.append(source); else result.append("<unset>");
		result.append(", KIND: ");
		if (kindESet) result.append(kind); else result.append("<unset>");
		result.append(", EXPRESSION: ");
		if (expressionESet) result.append(expression); else result.append("<unset>");
		result.append(", NAME: ");
		if (nameESet) result.append(name); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EAnnotationOCLParserImpl
