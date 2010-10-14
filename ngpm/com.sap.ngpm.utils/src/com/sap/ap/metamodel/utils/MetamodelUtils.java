package com.sap.ap.metamodel.utils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;

import com.sap.ocl.oppositefinder.query2.DefaultQueryContextProvider;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.ClassesFactory;
import data.classes.ClassesPackage;
import data.classes.FunctionSignature;
import data.classes.FunctionSignatureTypeDefinition;
import data.classes.MethodSignature;
import data.classes.SapClass;
import dataaccess.expressions.ExpressionsFactory;
import dataaccess.expressions.FunctionCallExpression;
import dataaccess.expressions.SignatureCallExpression;
import dataaccess.expressions.fp.AnonymousFunctionExpr;
import dataaccess.expressions.fp.FpFactory;
import dataaccess.expressions.literals.LiteralsFactory;
import dataaccess.expressions.literals.NumberLiteral;
import dataaccess.expressions.literals.StringLiteral;

/**
 * Some utility / helper methods for the AP/NGPM/Runlet metamodel
 * 
 * @author Axel Uhl D043530
 *
 */
public class MetamodelUtils {
    public static NumberLiteral createNumberLiteral(ResourceSet resourceSet, String numberAsString) {
	NumberLiteral result = LiteralsFactory.eINSTANCE.createNumberLiteral();
	result.setLiteral(numberAsString);
	SapClass numberClass = MetamodelUtils.findClass(resourceSet, "Number");
	ClassTypeDefinition ctd = MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, numberClass);
	result.setOwnedTypeDefinition(ctd);
	return result;
    }
    
    public static StringLiteral createStringLiteral(ResourceSet resourceSet, String string) {
	StringLiteral result = LiteralsFactory.eINSTANCE.createStringLiteral();
	result.setLiteral(string);
	SapClass stringClass = MetamodelUtils.findClass(resourceSet, "String");
	ClassTypeDefinition ctd = MetamodelUtils.createClassTypeDefinitionExactlyOne(resourceSet, stringClass);
	result.setOwnedTypeDefinition(ctd);
	return result;
    }
    
    public static ClassTypeDefinition createClassTypeDefinition(ResourceSet resourceSet, SapClass c1, int lower, int upper,
	    boolean ordered, boolean unique) {
	ClassTypeDefinition c1TD = ClassesFactory.eINSTANCE.createClassTypeDefinition();
	c1TD.setClazz(c1);
	c1TD.setLowerMultiplicity(lower);
	c1TD.setUpperMultiplicity(upper);
	c1TD.setOrdered(ordered);
	c1TD.setUnique(unique);
	return c1TD;
    }

    /**
     * orderedness and uniqueness are left at their initial values, which means both are <tt>false</tt>
     */
    public static ClassTypeDefinition createClassTypeDefinition(ResourceSet resourceSet, SapClass c1, int lower, int upper) {
	return createClassTypeDefinition(resourceSet, c1, lower, upper, /* ordered */ false, /* unique */ false);
    }

    public static ClassTypeDefinition createClassTypeDefinitionExactlyOne(
	    ResourceSet resourceSet, SapClass theClass) {
	return createClassTypeDefinition(resourceSet, theClass, 1, 1);
    }

    public static Association createAssociation(ResourceSet resourceSet, SapClass end1Class, String end1Name, int end1Lower,
	    int end1Upper, boolean end1Navigability, boolean end1Composite, boolean end1Ordered,
	    boolean end1Unique, SapClass end2Class, String end2Name, int end2Lower, int end2Upper,
	    boolean end2Navigable, boolean end2Composite, boolean end2Ordered, boolean end2Unique) {
	Association assoc = ClassesFactory.eINSTANCE.createAssociation();
	AssociationEnd end1 = ClassesFactory.eINSTANCE.createAssociationEnd();
	end1.setName(end1Name);
	end1.setNavigable(end1Navigability);
	end1.setComposite(end1Composite);
	AssociationEnd end2 = ClassesFactory.eINSTANCE.createAssociationEnd();
	end2.setName(end2Name);
	end2.setNavigable(end2Navigable);
	end2.setComposite(end2Composite);
	assoc.getEnds().add(end1);
	assoc.getEnds().add(end2);
	ClassTypeDefinition end1TD = MetamodelUtils.createClassTypeDefinition(resourceSet, end1Class, end1Lower, end1Upper, end1Ordered, end1Unique);
	end1.setType(end1TD);
	ClassTypeDefinition end2TD = MetamodelUtils.createClassTypeDefinition(resourceSet, end2Class, end2Lower, end2Upper, end2Ordered, end2Unique);
	end2.setType(end2TD);
	return assoc;
    }

    public static Association createAssociation(ResourceSet resourceSet, SapClass end1Class, int end1Lower, int end1Upper,
	    boolean end1Navigability, SapClass end2Class, int end2Lower, int end2Upper, boolean end2Navigable) {
	Association assoc = ClassesFactory.eINSTANCE.createAssociation();
	AssociationEnd end1 = ClassesFactory.eINSTANCE.createAssociationEnd();
	end1.setNavigable(end1Navigability);
	AssociationEnd end2 = ClassesFactory.eINSTANCE.createAssociationEnd();
	end2.setNavigable(end2Navigable);
	assoc.getEnds().add(end1);
	assoc.getEnds().add(end2);
	ClassTypeDefinition end1TD = MetamodelUtils.createClassTypeDefinition(resourceSet, end1Class, end1Lower, end1Upper);
	end1.setType(end1TD);
	ClassTypeDefinition end2TD = MetamodelUtils.createClassTypeDefinition(resourceSet, end2Class, end2Lower, end2Upper);
	end2.setType(end2TD);
	return assoc;
    }

    // TODO may need a combination of ResourceSet and scope as argument
    public static MethodSignature findMethod(ResourceSet resourceSet, String classname, String methodname) {
        QueryProcessor mql = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
	ResultSet methodSignatureQueryResult = mql.execute(
                "select s from [" + EcoreUtil.getURI(ClassesPackage.eINSTANCE.getMethodSignature()) + "] as s, ["
                        + EcoreUtil.getURI(ClassesPackage.eINSTANCE.getSapClass()) + "] as c where s.owner = c where s.name='"
                        + methodname + "' " + "where c.name='" + classname + "'",
                        new DefaultQueryContextProvider().getForwardScopeQueryContext(resourceSet));
	MethodSignature methodSignature = null;
	URI[] array = methodSignatureQueryResult.getUris("s");
	if (array.length > 0) {
	    methodSignature = (MethodSignature) resourceSet.getEObject(array[0], /* loadOnDemand */ true);
	}
	return methodSignature;
    }

    // TODO may need a combination of ResourceSet and scope as argument
    public static SapClass findClass(ResourceSet resourceSet, String classname) {
        QueryProcessor mql = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
	ResultSet queryResult = mql.execute(
	    "select c from [" + EcoreUtil.getURI(ClassesPackage.eINSTANCE.getSapClass()) + "] as c where c.name='"+classname+"'",
            new DefaultQueryContextProvider().getForwardScopeQueryContext(resourceSet));
	SapClass clazz = (SapClass) resourceSet.getEObject(queryResult.getUris("c")[0], /* loadOnDemand */ true);
	return clazz;
    }

    /**
     * Creates a {@link FunctionCallExpression} for the <tt>funcSig</tt> signature.
     * For this purpose, this method creates a {@link FunctionSignatureTypeDefinition}
     * that it initializes as required, and an {@link AnonymousFunctionExpr} which computes
     * as its value the implementation of <tt>funcSig</tt>. This anonymous function expression
     * is then used as the {@link FunctionCallExpression#setCalledBlock(dataaccess.expressions.Expression)}
     * feature.<p>
     * 
     * The caller will have to set parameters for the call using
     * {@link SignatureCallExpression#getParameters()}.
     */
    public static FunctionCallExpression createFunctionCallExpression(
	    ResourceSet resourceSet, FunctionSignature funcSig) {
	FunctionCallExpression fce = ExpressionsFactory.eINSTANCE.createFunctionCallExpression();
	FunctionSignatureTypeDefinition fstd = ClassesFactory.eINSTANCE.createFunctionSignatureTypeDefinition();
	fstd.setLowerMultiplicity(1);
	fstd.setUpperMultiplicity(1);
	fstd.setSignature(funcSig);
	AnonymousFunctionExpr afe = FpFactory.eINSTANCE.createAnonymousFunctionExpr();
	afe.setOwnedTypeDefinition(fstd);
	fce.setCalledBlock(afe);
	return fce;
    }

}
