/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ExpressionsPackageImpl.java,v 1.9 2008/03/28 20:33:33 cdamus Exp $
 */
package org.eclipse.ocl.expressions.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CallExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionLiteralPart;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.LiteralExp;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NavigationCallExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.NumericLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PrimitiveLiteralExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.types.impl.TypesPackageImpl;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.impl.UtilitiesPackageImpl;





/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionsPackageImpl extends EPackageImpl implements ExpressionsPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass associationClassCallExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass booleanLiteralExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass callExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass collectionItemEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass collectionLiteralExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass collectionLiteralPartEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass collectionRangeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass enumLiteralExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass featureCallExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass ifExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass integerLiteralExpEClass = null;

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass unlimitedNaturalLiteralExpEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass invalidLiteralExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass iterateExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass iteratorExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass letExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass literalExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass loopExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass messageExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass navigationCallExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass nullLiteralExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass numericLiteralExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass oclExpressionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass operationCallExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass primitiveLiteralExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass propertyCallExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass realLiteralExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass stateExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass stringLiteralExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass tupleLiteralExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass tupleLiteralPartEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass typeExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass unspecifiedValueExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass variableEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass variableExpEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum collectionKindEEnum = null;

	/**
	 * Root package of the OCL Ecore model, which we have to "fake out"
	 * because EMF will not generate it.
	 */
	public static final EPackage OCL_ROOT_PACKAGE;
	
	static {
        class OCLPackageImpl extends EPackageImpl {
			@Override
            protected Resource createResource(String uri) {
				return super.createResource(uri);
			}
		}
        
        OCLPackageImpl oclPackage = new OCLPackageImpl();
        oclPackage.setName("ocl"); //$NON-NLS-1$
        oclPackage.setNsPrefix("ocl"); //$NON-NLS-1$
        oclPackage.setNsURI(Environment.OCL_NAMESPACE_URI);
		oclPackage.createResource(oclPackage.getNsURI());
		
        OCL_ROOT_PACKAGE = oclPackage;
		EPackage.Registry.INSTANCE.put(OCL_ROOT_PACKAGE.getNsURI(), OCL_ROOT_PACKAGE);
	}

	/**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private ExpressionsPackageImpl() {
        super(eNS_URI, ExpressionsFactory.eINSTANCE);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static boolean isInited = false;

	/**
     * Creates, registers, and initializes the <b>Package</b> for this
     * model, and for any others upon which it depends.  Simple
     * dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else.  This method drives
     * initialization for interdependent packages directly, in parallel
     * with this package, itself.
     * <p>Of this package and its interdependencies, all packages which
     * have not yet been registered by their URI values are first created
     * and registered.  The packages are then initialized in two steps:
     * meta-model objects for all of the packages are created before any
     * are initialized, since one package's meta-model objects may refer to
     * those of another.
     * <p>Invocation of this method will not affect any packages that have
     * already been initialized.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static ExpressionsPackage init() {
        if (isInited) return (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

        // Obtain or create and register package
        ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ExpressionsPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
        UtilitiesPackageImpl theUtilitiesPackage = (UtilitiesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI) instanceof UtilitiesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI) : UtilitiesPackage.eINSTANCE);

        // Create package meta-data objects
        theExpressionsPackage.createPackageContents();
        theTypesPackage.createPackageContents();
        theUtilitiesPackage.createPackageContents();

        // Initialize created meta-data
        theExpressionsPackage.initializePackageContents();
        theTypesPackage.initializePackageContents();
        theUtilitiesPackage.initializePackageContents();

        // Register package validator
        EValidator.Registry.INSTANCE.put
            (theExpressionsPackage, 
             new EValidator.Descriptor() {
                 public EValidator getEValidator() {
                     return ExpressionsValidator.INSTANCE;
                 }
             });

        // Mark meta-data to indicate it can't be changed
        theExpressionsPackage.freeze();

        return theExpressionsPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAssociationClassCallExp() {
        return associationClassCallExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAssociationClassCallExp_ReferredAssociationClass() {
        return (EReference)associationClassCallExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getBooleanLiteralExp() {
        return booleanLiteralExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getBooleanLiteralExp_BooleanSymbol() {
        return (EAttribute)booleanLiteralExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCallExp() {
        return callExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCallExp_Source() {
        return (EReference)callExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCollectionItem() {
        return collectionItemEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCollectionItem_Item() {
        return (EReference)collectionItemEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCollectionLiteralExp() {
        return collectionLiteralExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCollectionLiteralExp_Kind() {
        return (EAttribute)collectionLiteralExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCollectionLiteralExp_Part() {
        return (EReference)collectionLiteralExpEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCollectionLiteralExp_SimpleRange() {
        return (EAttribute)collectionLiteralExpEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCollectionLiteralPart() {
        return collectionLiteralPartEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCollectionRange() {
        return collectionRangeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCollectionRange_First() {
        return (EReference)collectionRangeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCollectionRange_Last() {
        return (EReference)collectionRangeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getEnumLiteralExp() {
        return enumLiteralExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getEnumLiteralExp_ReferredEnumLiteral() {
        return (EReference)enumLiteralExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFeatureCallExp() {
        return featureCallExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getFeatureCallExp_MarkedPre() {
        return (EAttribute)featureCallExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getIfExp() {
        return ifExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getIfExp_Condition() {
        return (EReference)ifExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getIfExp_ThenExpression() {
        return (EReference)ifExpEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getIfExp_ElseExpression() {
        return (EReference)ifExpEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getIntegerLiteralExp() {
        return integerLiteralExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getIntegerLiteralExp_IntegerSymbol() {
        return (EAttribute)integerLiteralExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUnlimitedNaturalLiteralExp() {
        return unlimitedNaturalLiteralExpEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUnlimitedNaturalLiteralExp_IntegerSymbol() {
        return (EAttribute)unlimitedNaturalLiteralExpEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUnlimitedNaturalLiteralExp_Unlimited() {
        return (EAttribute)unlimitedNaturalLiteralExpEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getInvalidLiteralExp() {
        return invalidLiteralExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getIterateExp() {
        return iterateExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getIterateExp_Result() {
        return (EReference)iterateExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getIteratorExp() {
        return iteratorExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLetExp() {
        return letExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getLetExp_In() {
        return (EReference)letExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getLetExp_Variable() {
        return (EReference)letExpEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLiteralExp() {
        return literalExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLoopExp() {
        return loopExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getLoopExp_Body() {
        return (EReference)loopExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getLoopExp_Iterator() {
        return (EReference)loopExpEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMessageExp() {
        return messageExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMessageExp_Target() {
        return (EReference)messageExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMessageExp_Argument() {
        return (EReference)messageExpEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMessageExp_CalledOperation() {
        return (EReference)messageExpEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMessageExp_SentSignal() {
        return (EReference)messageExpEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNavigationCallExp() {
        return navigationCallExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNavigationCallExp_Qualifier() {
        return (EReference)navigationCallExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNavigationCallExp_NavigationSource() {
        return (EReference)navigationCallExpEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNullLiteralExp() {
        return nullLiteralExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNumericLiteralExp() {
        return numericLiteralExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOCLExpression() {
        return oclExpressionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getOperationCallExp() {
        return operationCallExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getOperationCallExp_Argument() {
        return (EReference)operationCallExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getOperationCallExp_ReferredOperation() {
        return (EReference)operationCallExpEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getOperationCallExp_OperationCode() {
        return (EAttribute)operationCallExpEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPrimitiveLiteralExp() {
        return primitiveLiteralExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPropertyCallExp() {
        return propertyCallExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getPropertyCallExp_ReferredProperty() {
        return (EReference)propertyCallExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getRealLiteralExp() {
        return realLiteralExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getRealLiteralExp_RealSymbol() {
        return (EAttribute)realLiteralExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getStateExp() {
        return stateExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getStateExp_ReferredState() {
        return (EReference)stateExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getStringLiteralExp() {
        return stringLiteralExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getStringLiteralExp_StringSymbol() {
        return (EAttribute)stringLiteralExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTupleLiteralExp() {
        return tupleLiteralExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTupleLiteralExp_Part() {
        return (EReference)tupleLiteralExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTupleLiteralPart() {
        return tupleLiteralPartEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTupleLiteralPart_Value() {
        return (EReference)tupleLiteralPartEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTupleLiteralPart_Attribute() {
        return (EReference)tupleLiteralPartEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTypeExp() {
        return typeExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTypeExp_ReferredType() {
        return (EReference)typeExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getUnspecifiedValueExp() {
        return unspecifiedValueExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getVariable() {
        return variableEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getVariable_InitExpression() {
        return (EReference)variableEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getVariable_RepresentedParameter() {
        return (EReference)variableEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getVariableExp() {
        return variableExpEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getVariableExp_ReferredVariable() {
        return (EReference)variableExpEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getCollectionKind() {
        return collectionKindEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExpressionsFactory getExpressionsFactory() {
        return (ExpressionsFactory)getEFactoryInstance();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isCreated = false;

	/**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        associationClassCallExpEClass = createEClass(ASSOCIATION_CLASS_CALL_EXP);
        createEReference(associationClassCallExpEClass, ASSOCIATION_CLASS_CALL_EXP__REFERRED_ASSOCIATION_CLASS);

        navigationCallExpEClass = createEClass(NAVIGATION_CALL_EXP);
        createEReference(navigationCallExpEClass, NAVIGATION_CALL_EXP__QUALIFIER);
        createEReference(navigationCallExpEClass, NAVIGATION_CALL_EXP__NAVIGATION_SOURCE);

        featureCallExpEClass = createEClass(FEATURE_CALL_EXP);
        createEAttribute(featureCallExpEClass, FEATURE_CALL_EXP__MARKED_PRE);

        callExpEClass = createEClass(CALL_EXP);
        createEReference(callExpEClass, CALL_EXP__SOURCE);

        oclExpressionEClass = createEClass(OCL_EXPRESSION);

        booleanLiteralExpEClass = createEClass(BOOLEAN_LITERAL_EXP);
        createEAttribute(booleanLiteralExpEClass, BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL);

        primitiveLiteralExpEClass = createEClass(PRIMITIVE_LITERAL_EXP);

        literalExpEClass = createEClass(LITERAL_EXP);

        collectionItemEClass = createEClass(COLLECTION_ITEM);
        createEReference(collectionItemEClass, COLLECTION_ITEM__ITEM);

        collectionLiteralPartEClass = createEClass(COLLECTION_LITERAL_PART);

        collectionLiteralExpEClass = createEClass(COLLECTION_LITERAL_EXP);
        createEAttribute(collectionLiteralExpEClass, COLLECTION_LITERAL_EXP__KIND);
        createEReference(collectionLiteralExpEClass, COLLECTION_LITERAL_EXP__PART);
        createEAttribute(collectionLiteralExpEClass, COLLECTION_LITERAL_EXP__SIMPLE_RANGE);

        collectionRangeEClass = createEClass(COLLECTION_RANGE);
        createEReference(collectionRangeEClass, COLLECTION_RANGE__FIRST);
        createEReference(collectionRangeEClass, COLLECTION_RANGE__LAST);

        enumLiteralExpEClass = createEClass(ENUM_LITERAL_EXP);
        createEReference(enumLiteralExpEClass, ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL);

        ifExpEClass = createEClass(IF_EXP);
        createEReference(ifExpEClass, IF_EXP__CONDITION);
        createEReference(ifExpEClass, IF_EXP__THEN_EXPRESSION);
        createEReference(ifExpEClass, IF_EXP__ELSE_EXPRESSION);

        integerLiteralExpEClass = createEClass(INTEGER_LITERAL_EXP);
        createEAttribute(integerLiteralExpEClass, INTEGER_LITERAL_EXP__INTEGER_SYMBOL);

        numericLiteralExpEClass = createEClass(NUMERIC_LITERAL_EXP);

        unlimitedNaturalLiteralExpEClass = createEClass(UNLIMITED_NATURAL_LITERAL_EXP);
        createEAttribute(unlimitedNaturalLiteralExpEClass, UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL);
        createEAttribute(unlimitedNaturalLiteralExpEClass, UNLIMITED_NATURAL_LITERAL_EXP__UNLIMITED);

        invalidLiteralExpEClass = createEClass(INVALID_LITERAL_EXP);

        iterateExpEClass = createEClass(ITERATE_EXP);
        createEReference(iterateExpEClass, ITERATE_EXP__RESULT);

        loopExpEClass = createEClass(LOOP_EXP);
        createEReference(loopExpEClass, LOOP_EXP__BODY);
        createEReference(loopExpEClass, LOOP_EXP__ITERATOR);

        variableEClass = createEClass(VARIABLE);
        createEReference(variableEClass, VARIABLE__INIT_EXPRESSION);
        createEReference(variableEClass, VARIABLE__REPRESENTED_PARAMETER);

        iteratorExpEClass = createEClass(ITERATOR_EXP);

        letExpEClass = createEClass(LET_EXP);
        createEReference(letExpEClass, LET_EXP__IN);
        createEReference(letExpEClass, LET_EXP__VARIABLE);

        messageExpEClass = createEClass(MESSAGE_EXP);
        createEReference(messageExpEClass, MESSAGE_EXP__TARGET);
        createEReference(messageExpEClass, MESSAGE_EXP__ARGUMENT);
        createEReference(messageExpEClass, MESSAGE_EXP__CALLED_OPERATION);
        createEReference(messageExpEClass, MESSAGE_EXP__SENT_SIGNAL);

        nullLiteralExpEClass = createEClass(NULL_LITERAL_EXP);

        operationCallExpEClass = createEClass(OPERATION_CALL_EXP);
        createEReference(operationCallExpEClass, OPERATION_CALL_EXP__ARGUMENT);
        createEReference(operationCallExpEClass, OPERATION_CALL_EXP__REFERRED_OPERATION);
        createEAttribute(operationCallExpEClass, OPERATION_CALL_EXP__OPERATION_CODE);

        propertyCallExpEClass = createEClass(PROPERTY_CALL_EXP);
        createEReference(propertyCallExpEClass, PROPERTY_CALL_EXP__REFERRED_PROPERTY);

        realLiteralExpEClass = createEClass(REAL_LITERAL_EXP);
        createEAttribute(realLiteralExpEClass, REAL_LITERAL_EXP__REAL_SYMBOL);

        stateExpEClass = createEClass(STATE_EXP);
        createEReference(stateExpEClass, STATE_EXP__REFERRED_STATE);

        stringLiteralExpEClass = createEClass(STRING_LITERAL_EXP);
        createEAttribute(stringLiteralExpEClass, STRING_LITERAL_EXP__STRING_SYMBOL);

        tupleLiteralExpEClass = createEClass(TUPLE_LITERAL_EXP);
        createEReference(tupleLiteralExpEClass, TUPLE_LITERAL_EXP__PART);

        tupleLiteralPartEClass = createEClass(TUPLE_LITERAL_PART);
        createEReference(tupleLiteralPartEClass, TUPLE_LITERAL_PART__VALUE);
        createEReference(tupleLiteralPartEClass, TUPLE_LITERAL_PART__ATTRIBUTE);

        typeExpEClass = createEClass(TYPE_EXP);
        createEReference(typeExpEClass, TYPE_EXP__REFERRED_TYPE);

        unspecifiedValueExpEClass = createEClass(UNSPECIFIED_VALUE_EXP);

        variableExpEClass = createEClass(VARIABLE_EXP);
        createEReference(variableExpEClass, VARIABLE_EXP__REFERRED_VARIABLE);

        // Create enums
        collectionKindEEnum = createEEnum(COLLECTION_KIND);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <p>
     * The generated implementation is extended by adding me as a child of
     * the empty root <tt>OCL</tt> package.
     * </p>
     */
    public void initializePackageContents() {
        if (!isInitialized) {
            // create my own resource first, before adding me to my parent
            // package.  Otherwise, I will already be in a resource when
            // createResource() is called, and it will not create a new one
            initializePackageContentsGen();
            
            OCL_ROOT_PACKAGE.getESubpackages().add(this);
        }
    }
    
    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContentsGen() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        UtilitiesPackage theUtilitiesPackage = (UtilitiesPackage)EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI);

        // Create type parameters
        ETypeParameter associationClassCallExpEClass_C = addETypeParameter(associationClassCallExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter associationClassCallExpEClass_P = addETypeParameter(associationClassCallExpEClass, "P"); //$NON-NLS-1$
        ETypeParameter navigationCallExpEClass_C = addETypeParameter(navigationCallExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter navigationCallExpEClass_P = addETypeParameter(navigationCallExpEClass, "P"); //$NON-NLS-1$
        ETypeParameter featureCallExpEClass_C = addETypeParameter(featureCallExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter callExpEClass_C = addETypeParameter(callExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter oclExpressionEClass_C = addETypeParameter(oclExpressionEClass, "C"); //$NON-NLS-1$
        ETypeParameter booleanLiteralExpEClass_C = addETypeParameter(booleanLiteralExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter primitiveLiteralExpEClass_C = addETypeParameter(primitiveLiteralExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter literalExpEClass_C = addETypeParameter(literalExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter collectionItemEClass_C = addETypeParameter(collectionItemEClass, "C"); //$NON-NLS-1$
        ETypeParameter collectionLiteralPartEClass_C = addETypeParameter(collectionLiteralPartEClass, "C"); //$NON-NLS-1$
        ETypeParameter collectionLiteralExpEClass_C = addETypeParameter(collectionLiteralExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter collectionRangeEClass_C = addETypeParameter(collectionRangeEClass, "C"); //$NON-NLS-1$
        ETypeParameter enumLiteralExpEClass_C = addETypeParameter(enumLiteralExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter enumLiteralExpEClass_EL = addETypeParameter(enumLiteralExpEClass, "EL"); //$NON-NLS-1$
        ETypeParameter ifExpEClass_C = addETypeParameter(ifExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter integerLiteralExpEClass_C = addETypeParameter(integerLiteralExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter numericLiteralExpEClass_C = addETypeParameter(numericLiteralExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter unlimitedNaturalLiteralExpEClass_C = addETypeParameter(unlimitedNaturalLiteralExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter invalidLiteralExpEClass_C = addETypeParameter(invalidLiteralExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter iterateExpEClass_C = addETypeParameter(iterateExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter iterateExpEClass_PM = addETypeParameter(iterateExpEClass, "PM"); //$NON-NLS-1$
        ETypeParameter loopExpEClass_C = addETypeParameter(loopExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter loopExpEClass_PM = addETypeParameter(loopExpEClass, "PM"); //$NON-NLS-1$
        ETypeParameter variableEClass_C = addETypeParameter(variableEClass, "C"); //$NON-NLS-1$
        ETypeParameter variableEClass_PM = addETypeParameter(variableEClass, "PM"); //$NON-NLS-1$
        ETypeParameter iteratorExpEClass_C = addETypeParameter(iteratorExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter iteratorExpEClass_PM = addETypeParameter(iteratorExpEClass, "PM"); //$NON-NLS-1$
        ETypeParameter letExpEClass_C = addETypeParameter(letExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter letExpEClass_PM = addETypeParameter(letExpEClass, "PM"); //$NON-NLS-1$
        ETypeParameter messageExpEClass_C = addETypeParameter(messageExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter messageExpEClass_COA = addETypeParameter(messageExpEClass, "COA"); //$NON-NLS-1$
        ETypeParameter messageExpEClass_SSA = addETypeParameter(messageExpEClass, "SSA"); //$NON-NLS-1$
        ETypeParameter nullLiteralExpEClass_C = addETypeParameter(nullLiteralExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter operationCallExpEClass_C = addETypeParameter(operationCallExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter operationCallExpEClass_O = addETypeParameter(operationCallExpEClass, "O"); //$NON-NLS-1$
        ETypeParameter propertyCallExpEClass_C = addETypeParameter(propertyCallExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter propertyCallExpEClass_P = addETypeParameter(propertyCallExpEClass, "P"); //$NON-NLS-1$
        ETypeParameter realLiteralExpEClass_C = addETypeParameter(realLiteralExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter stateExpEClass_C = addETypeParameter(stateExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter stateExpEClass_S = addETypeParameter(stateExpEClass, "S"); //$NON-NLS-1$
        ETypeParameter stringLiteralExpEClass_C = addETypeParameter(stringLiteralExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter tupleLiteralExpEClass_C = addETypeParameter(tupleLiteralExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter tupleLiteralExpEClass_P = addETypeParameter(tupleLiteralExpEClass, "P"); //$NON-NLS-1$
        ETypeParameter tupleLiteralPartEClass_C = addETypeParameter(tupleLiteralPartEClass, "C"); //$NON-NLS-1$
        ETypeParameter tupleLiteralPartEClass_P = addETypeParameter(tupleLiteralPartEClass, "P"); //$NON-NLS-1$
        ETypeParameter typeExpEClass_C = addETypeParameter(typeExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter unspecifiedValueExpEClass_C = addETypeParameter(unspecifiedValueExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter variableExpEClass_C = addETypeParameter(variableExpEClass, "C"); //$NON-NLS-1$
        ETypeParameter variableExpEClass_PM = addETypeParameter(variableExpEClass, "PM"); //$NON-NLS-1$

        // Set bounds for type parameters

        // Add supertypes to classes
        EGenericType g1 = createEGenericType(this.getNavigationCallExp());
        EGenericType g2 = createEGenericType(associationClassCallExpEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(associationClassCallExpEClass_P);
        g1.getETypeArguments().add(g2);
        associationClassCallExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getFeatureCallExp());
        g2 = createEGenericType(navigationCallExpEClass_C);
        g1.getETypeArguments().add(g2);
        navigationCallExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCallExp());
        g2 = createEGenericType(featureCallExpEClass_C);
        g1.getETypeArguments().add(g2);
        featureCallExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(callExpEClass_C);
        g1.getETypeArguments().add(g2);
        callExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getCallingASTNode());
        callExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getTypedElement());
        g2 = createEGenericType(oclExpressionEClass_C);
        g1.getETypeArguments().add(g2);
        oclExpressionEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getVisitable());
        oclExpressionEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getASTNode());
        oclExpressionEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getPrimitiveLiteralExp());
        g2 = createEGenericType(booleanLiteralExpEClass_C);
        g1.getETypeArguments().add(g2);
        booleanLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getLiteralExp());
        g2 = createEGenericType(primitiveLiteralExpEClass_C);
        g1.getETypeArguments().add(g2);
        primitiveLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(literalExpEClass_C);
        g1.getETypeArguments().add(g2);
        literalExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionLiteralPart());
        g2 = createEGenericType(collectionItemEClass_C);
        g1.getETypeArguments().add(g2);
        collectionItemEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getTypedElement());
        g2 = createEGenericType(collectionLiteralPartEClass_C);
        g1.getETypeArguments().add(g2);
        collectionLiteralPartEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getVisitable());
        collectionLiteralPartEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getLiteralExp());
        g2 = createEGenericType(collectionLiteralExpEClass_C);
        g1.getETypeArguments().add(g2);
        collectionLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCollectionLiteralPart());
        g2 = createEGenericType(collectionRangeEClass_C);
        g1.getETypeArguments().add(g2);
        collectionRangeEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getLiteralExp());
        g2 = createEGenericType(enumLiteralExpEClass_C);
        g1.getETypeArguments().add(g2);
        enumLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(ifExpEClass_C);
        g1.getETypeArguments().add(g2);
        ifExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getNumericLiteralExp());
        g2 = createEGenericType(integerLiteralExpEClass_C);
        g1.getETypeArguments().add(g2);
        integerLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getPrimitiveLiteralExp());
        g2 = createEGenericType(numericLiteralExpEClass_C);
        g1.getETypeArguments().add(g2);
        numericLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getNumericLiteralExp());
        g2 = createEGenericType(unlimitedNaturalLiteralExpEClass_C);
        g1.getETypeArguments().add(g2);
        unlimitedNaturalLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getLiteralExp());
        g2 = createEGenericType(invalidLiteralExpEClass_C);
        g1.getETypeArguments().add(g2);
        invalidLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getLoopExp());
        g2 = createEGenericType(iterateExpEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(iterateExpEClass_PM);
        g1.getETypeArguments().add(g2);
        iterateExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCallExp());
        g2 = createEGenericType(loopExpEClass_C);
        g1.getETypeArguments().add(g2);
        loopExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getTypedElement());
        g2 = createEGenericType(variableEClass_C);
        g1.getETypeArguments().add(g2);
        variableEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getVisitable());
        variableEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getTypedASTNode());
        variableEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getLoopExp());
        g2 = createEGenericType(iteratorExpEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(iteratorExpEClass_PM);
        g1.getETypeArguments().add(g2);
        iteratorExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(letExpEClass_C);
        g1.getETypeArguments().add(g2);
        letExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(messageExpEClass_C);
        g1.getETypeArguments().add(g2);
        messageExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getCallingASTNode());
        messageExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getLiteralExp());
        g2 = createEGenericType(nullLiteralExpEClass_C);
        g1.getETypeArguments().add(g2);
        nullLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getFeatureCallExp());
        g2 = createEGenericType(operationCallExpEClass_C);
        g1.getETypeArguments().add(g2);
        operationCallExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getNavigationCallExp());
        g2 = createEGenericType(propertyCallExpEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(propertyCallExpEClass_P);
        g1.getETypeArguments().add(g2);
        propertyCallExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getNumericLiteralExp());
        g2 = createEGenericType(realLiteralExpEClass_C);
        g1.getETypeArguments().add(g2);
        realLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(stateExpEClass_C);
        g1.getETypeArguments().add(g2);
        stateExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getPrimitiveLiteralExp());
        g2 = createEGenericType(stringLiteralExpEClass_C);
        g1.getETypeArguments().add(g2);
        stringLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getLiteralExp());
        g2 = createEGenericType(tupleLiteralExpEClass_C);
        g1.getETypeArguments().add(g2);
        tupleLiteralExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getTypedElement());
        g2 = createEGenericType(tupleLiteralPartEClass_C);
        g1.getETypeArguments().add(g2);
        tupleLiteralPartEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getVisitable());
        tupleLiteralPartEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getTypedASTNode());
        tupleLiteralPartEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(typeExpEClass_C);
        g1.getETypeArguments().add(g2);
        typeExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(unspecifiedValueExpEClass_C);
        g1.getETypeArguments().add(g2);
        unspecifiedValueExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theUtilitiesPackage.getTypedASTNode());
        unspecifiedValueExpEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(variableExpEClass_C);
        g1.getETypeArguments().add(g2);
        variableExpEClass.getEGenericSuperTypes().add(g1);

        // Initialize classes and features; add operations and parameters
        initEClass(associationClassCallExpEClass, AssociationClassCallExp.class, "AssociationClassCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(associationClassCallExpEClass_C);
        initEReference(getAssociationClassCallExp_ReferredAssociationClass(), g1, null, "referredAssociationClass", null, 0, 1, AssociationClassCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(navigationCallExpEClass, NavigationCallExp.class, "NavigationCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(navigationCallExpEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getNavigationCallExp_Qualifier(), g1, null, "qualifier", null, 0, -1, NavigationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(navigationCallExpEClass_P);
        initEReference(getNavigationCallExp_NavigationSource(), g1, null, "navigationSource", null, 0, 1, NavigationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(featureCallExpEClass, FeatureCallExp.class, "FeatureCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getFeatureCallExp_MarkedPre(), ecorePackage.getEBoolean(), "markedPre", null, 0, 1, FeatureCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(callExpEClass, CallExp.class, "CallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(callExpEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getCallExp_Source(), g1, null, "source", null, 0, 1, CallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(oclExpressionEClass, OCLExpression.class, "OCLExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(booleanLiteralExpEClass, BooleanLiteralExp.class, "BooleanLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getBooleanLiteralExp_BooleanSymbol(), ecorePackage.getEBooleanObject(), "booleanSymbol", null, 0, 1, BooleanLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        EOperation op = addEOperation(booleanLiteralExpEClass, ecorePackage.getEBoolean(), "checkBooleanType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(primitiveLiteralExpEClass, PrimitiveLiteralExp.class, "PrimitiveLiteralExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(literalExpEClass, LiteralExp.class, "LiteralExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(collectionItemEClass, CollectionItem.class, "CollectionItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(collectionItemEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getCollectionItem_Item(), g1, null, "item", null, 1, 1, CollectionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(collectionItemEClass, ecorePackage.getEBoolean(), "checkItemType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(collectionLiteralPartEClass, CollectionLiteralPart.class, "CollectionLiteralPart", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(collectionLiteralExpEClass, CollectionLiteralExp.class, "CollectionLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getCollectionLiteralExp_Kind(), this.getCollectionKind(), "kind", null, 0, 1, CollectionLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(this.getCollectionLiteralPart());
        g2 = createEGenericType(collectionLiteralExpEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getCollectionLiteralExp_Part(), g1, null, "part", null, 0, -1, CollectionLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getCollectionLiteralExp_SimpleRange(), ecorePackage.getEBoolean(), "simpleRange", null, 0, 1, CollectionLiteralExp.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(collectionLiteralExpEClass, ecorePackage.getEBoolean(), "checkNoCollectionInstances", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(collectionLiteralExpEClass, ecorePackage.getEBoolean(), "checkSetKind", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(collectionLiteralExpEClass, ecorePackage.getEBoolean(), "checkSequenceKind", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(collectionLiteralExpEClass, ecorePackage.getEBoolean(), "checkBagKind", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(collectionLiteralExpEClass, ecorePackage.getEBoolean(), "checkElementType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(collectionRangeEClass, CollectionRange.class, "CollectionRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(collectionRangeEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getCollectionRange_First(), g1, null, "first", null, 1, 1, CollectionRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(collectionRangeEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getCollectionRange_Last(), g1, null, "last", null, 1, 1, CollectionRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(collectionRangeEClass, ecorePackage.getEBoolean(), "checkRangeType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(enumLiteralExpEClass, EnumLiteralExp.class, "EnumLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(enumLiteralExpEClass_EL);
        initEReference(getEnumLiteralExp_ReferredEnumLiteral(), g1, null, "referredEnumLiteral", null, 0, 1, EnumLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(enumLiteralExpEClass, ecorePackage.getEBoolean(), "checkEnumType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(ifExpEClass, IfExp.class, "IfExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(ifExpEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getIfExp_Condition(), g1, null, "condition", null, 0, 1, IfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(ifExpEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getIfExp_ThenExpression(), g1, null, "thenExpression", null, 0, 1, IfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(ifExpEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getIfExp_ElseExpression(), g1, null, "elseExpression", null, 0, 1, IfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(ifExpEClass, ecorePackage.getEBoolean(), "checkBooleanCondition", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(ifExpEClass, ecorePackage.getEBoolean(), "checkIfType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(integerLiteralExpEClass, IntegerLiteralExp.class, "IntegerLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getIntegerLiteralExp_IntegerSymbol(), ecorePackage.getEIntegerObject(), "integerSymbol", null, 0, 1, IntegerLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(integerLiteralExpEClass, ecorePackage.getEBoolean(), "checkIntegerType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(numericLiteralExpEClass, NumericLiteralExp.class, "NumericLiteralExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(unlimitedNaturalLiteralExpEClass, UnlimitedNaturalLiteralExp.class, "UnlimitedNaturalLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getUnlimitedNaturalLiteralExp_IntegerSymbol(), ecorePackage.getEIntegerObject(), "integerSymbol", null, 0, 1, UnlimitedNaturalLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getUnlimitedNaturalLiteralExp_Unlimited(), ecorePackage.getEBoolean(), "unlimited", null, 1, 1, UnlimitedNaturalLiteralExp.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(unlimitedNaturalLiteralExpEClass, ecorePackage.getEBoolean(), "checkNaturalType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(invalidLiteralExpEClass, InvalidLiteralExp.class, "InvalidLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(iterateExpEClass, IterateExp.class, "IterateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(this.getVariable());
        g2 = createEGenericType(iterateExpEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(iterateExpEClass_PM);
        g1.getETypeArguments().add(g2);
        initEReference(getIterateExp_Result(), g1, null, "result", null, 0, 1, IterateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(iterateExpEClass, ecorePackage.getEBoolean(), "checkIterateType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(iterateExpEClass, ecorePackage.getEBoolean(), "checkBodyType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(iterateExpEClass, ecorePackage.getEBoolean(), "checkResultInit", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(loopExpEClass, LoopExp.class, "LoopExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(loopExpEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getLoopExp_Body(), g1, null, "body", null, 0, 1, LoopExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(this.getVariable());
        g2 = createEGenericType(loopExpEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(loopExpEClass_PM);
        g1.getETypeArguments().add(g2);
        initEReference(getLoopExp_Iterator(), g1, null, "iterator", null, 0, -1, LoopExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(loopExpEClass, ecorePackage.getEBoolean(), "checkSourceCollection", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(loopExpEClass, ecorePackage.getEBoolean(), "checkLoopVariableInit", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(loopExpEClass, ecorePackage.getEBoolean(), "checkLoopVariableType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(variableEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getVariable_InitExpression(), g1, null, "initExpression", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(variableEClass_PM);
        initEReference(getVariable_RepresentedParameter(), g1, null, "representedParameter", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(variableEClass, ecorePackage.getEBoolean(), "checkInitType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(iteratorExpEClass, IteratorExp.class, "IteratorExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        op = addEOperation(iteratorExpEClass, ecorePackage.getEBoolean(), "checkBooleanType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(iteratorExpEClass, ecorePackage.getEBoolean(), "checkCollectType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(iteratorExpEClass, ecorePackage.getEBoolean(), "checkSelectRejectType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(iteratorExpEClass, ecorePackage.getEBoolean(), "checkBooleanBodyType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(letExpEClass, LetExp.class, "LetExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(letExpEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getLetExp_In(), g1, null, "in", null, 0, 1, LetExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(this.getVariable());
        g2 = createEGenericType(letExpEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(letExpEClass_PM);
        g1.getETypeArguments().add(g2);
        initEReference(getLetExp_Variable(), g1, null, "variable", null, 0, 1, LetExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(letExpEClass, ecorePackage.getEBoolean(), "checkLetType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(messageExpEClass, MessageExp.class, "MessageExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(messageExpEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getMessageExp_Target(), g1, null, "target", null, 0, 1, MessageExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(messageExpEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getMessageExp_Argument(), g1, null, "argument", null, 0, -1, MessageExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(messageExpEClass_COA);
        initEReference(getMessageExp_CalledOperation(), g1, null, "calledOperation", null, 0, 1, MessageExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(messageExpEClass_SSA);
        initEReference(getMessageExp_SentSignal(), g1, null, "sentSignal", null, 0, 1, MessageExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(messageExpEClass, ecorePackage.getEBoolean(), "checkOperationArguments", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(messageExpEClass, ecorePackage.getEBoolean(), "checkSignalArguments", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(messageExpEClass, ecorePackage.getEBoolean(), "checkTargetDefinesOperation", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(messageExpEClass, ecorePackage.getEBoolean(), "checkHasOperationOrSignal", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(messageExpEClass, ecorePackage.getEBoolean(), "checkTargetNotCollection", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(nullLiteralExpEClass, NullLiteralExp.class, "NullLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(operationCallExpEClass, OperationCallExp.class, "OperationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(operationCallExpEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getOperationCallExp_Argument(), g1, null, "argument", null, 0, -1, OperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(operationCallExpEClass_O);
        initEReference(getOperationCallExp_ReferredOperation(), g1, null, "referredOperation", null, 0, 1, OperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        initEAttribute(getOperationCallExp_OperationCode(), ecorePackage.getEInt(), "operationCode", null, 0, 1, OperationCallExp.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(operationCallExpEClass, ecorePackage.getEBoolean(), "checkArgumentsConform", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(operationCallExpEClass, ecorePackage.getEBoolean(), "checkArgumentCount", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(propertyCallExpEClass, PropertyCallExp.class, "PropertyCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(propertyCallExpEClass_P);
        initEReference(getPropertyCallExp_ReferredProperty(), g1, null, "referredProperty", null, 0, 1, PropertyCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(propertyCallExpEClass, ecorePackage.getEBoolean(), "checkPropertyType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(realLiteralExpEClass, RealLiteralExp.class, "RealLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getRealLiteralExp_RealSymbol(), ecorePackage.getEDoubleObject(), "realSymbol", null, 0, 1, RealLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(realLiteralExpEClass, ecorePackage.getEBoolean(), "checkRealType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(stateExpEClass, StateExp.class, "StateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(stateExpEClass_S);
        initEReference(getStateExp_ReferredState(), g1, null, "referredState", null, 0, 1, StateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(stringLiteralExpEClass, StringLiteralExp.class, "StringLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        initEAttribute(getStringLiteralExp_StringSymbol(), ecorePackage.getEString(), "stringSymbol", null, 0, 1, StringLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(stringLiteralExpEClass, ecorePackage.getEBoolean(), "checkStringType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(tupleLiteralExpEClass, TupleLiteralExp.class, "TupleLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(this.getTupleLiteralPart());
        g2 = createEGenericType(tupleLiteralExpEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(tupleLiteralExpEClass_P);
        g1.getETypeArguments().add(g2);
        initEReference(getTupleLiteralExp_Part(), g1, null, "part", null, 0, -1, TupleLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(tupleLiteralExpEClass, ecorePackage.getEBoolean(), "checkTupleType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(tupleLiteralExpEClass, ecorePackage.getEBoolean(), "checkPartsUnique", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(tupleLiteralPartEClass, TupleLiteralPart.class, "TupleLiteralPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(this.getOCLExpression());
        g2 = createEGenericType(tupleLiteralPartEClass_C);
        g1.getETypeArguments().add(g2);
        initEReference(getTupleLiteralPart_Value(), g1, null, "value", null, 0, 1, TupleLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(tupleLiteralPartEClass_P);
        initEReference(getTupleLiteralPart_Attribute(), g1, null, "attribute", null, 0, 1, TupleLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(tupleLiteralPartEClass, ecorePackage.getEBoolean(), "checkValueType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        initEClass(typeExpEClass, TypeExp.class, "TypeExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(typeExpEClass_C);
        initEReference(getTypeExp_ReferredType(), g1, null, "referredType", null, 0, 1, TypeExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        initEClass(unspecifiedValueExpEClass, UnspecifiedValueExp.class, "UnspecifiedValueExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

        initEClass(variableExpEClass, VariableExp.class, "VariableExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
        g1 = createEGenericType(this.getVariable());
        g2 = createEGenericType(variableExpEClass_C);
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(variableExpEClass_PM);
        g1.getETypeArguments().add(g2);
        initEReference(getVariableExp_ReferredVariable(), g1, null, "referredVariable", null, 0, 1, VariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

        op = addEOperation(variableExpEClass, ecorePackage.getEBoolean(), "checkVarType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(ecorePackage.getEJavaObject());
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum(collectionKindEEnum, CollectionKind.class, "CollectionKind"); //$NON-NLS-1$
        addEEnumLiteral(collectionKindEEnum, CollectionKind.SET_LITERAL);
        addEEnumLiteral(collectionKindEEnum, CollectionKind.ORDERED_SET_LITERAL);
        addEEnumLiteral(collectionKindEEnum, CollectionKind.BAG_LITERAL);
        addEEnumLiteral(collectionKindEEnum, CollectionKind.SEQUENCE_LITERAL);
        addEEnumLiteral(collectionKindEEnum, CollectionKind.COLLECTION_LITERAL);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations();
    }

	/**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void createExtendedMetaDataAnnotations() {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$		
        addAnnotation
          (oclExpressionEClass, 
           source, 
           new String[] {
             "name", "OclExpression" //$NON-NLS-1$ //$NON-NLS-2$
           });																																																																																																																					
    }

} //ExpressionsPackageImpl
