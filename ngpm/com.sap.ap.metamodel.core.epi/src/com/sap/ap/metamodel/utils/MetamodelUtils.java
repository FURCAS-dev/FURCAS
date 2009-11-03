package com.sap.ap.metamodel.utils;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.FunctionSignature;
import data.classes.FunctionSignatureTypeDefinition;
import data.classes.MethodSignature;
import data.classes.SapClass;
import dataaccess.expressions.FunctionCallExpression;
import dataaccess.expressions.SignatureCallExpression;
import dataaccess.expressions.fp.AnonymousFunctionExpr;

/**
 * Some utility / helper methods for the AP/NGPM/Runlet metamodel
 * 
 * @author Axel Uhl D043530
 *
 */
public class MetamodelUtils {
    public static ClassTypeDefinition createClassTypeDefinition(Connection conn, SapClass c1, int lower, int upper,
	    boolean ordered, boolean unique) {
	ClassTypeDefinition c1TD = (ClassTypeDefinition) conn.getClass(ClassTypeDefinition.CLASS_DESCRIPTOR).refCreateInstance();
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
    public static ClassTypeDefinition createClassTypeDefinition(Connection conn, SapClass c1, int lower, int upper) {
	return createClassTypeDefinition(conn, c1, lower, upper, /* ordered */ false, /* unique */ false);
    }

    public static ClassTypeDefinition createClassTypeDefinitionExactlyOne(
	    Connection conn, SapClass theClass) {
	return createClassTypeDefinition(conn, theClass, 1, 1);
    }

    public static Association createAssociation(Connection conn, SapClass end1Class, String end1Name, int end1Lower,
	    int end1Upper, boolean end1Navigability, boolean end1Composite, boolean end1Ordered,
	    boolean end1Unique, SapClass end2Class, String end2Name, int end2Lower, int end2Upper,
	    boolean end2Navigable, boolean end2Composite, boolean end2Ordered, boolean end2Unique) {
	Association assoc = (Association) conn.getClass(Association.CLASS_DESCRIPTOR).refCreateInstance();
	AssociationEnd end1 = (AssociationEnd) conn.getClass(AssociationEnd.CLASS_DESCRIPTOR)
		.refCreateInstance();
	end1.setName(end1Name);
	end1.setNavigable(end1Navigability);
	end1.setComposite(end1Composite);
	AssociationEnd end2 = (AssociationEnd) conn.getClass(AssociationEnd.CLASS_DESCRIPTOR)
		.refCreateInstance();
	end2.setName(end2Name);
	end2.setNavigable(end2Navigable);
	end2.setComposite(end2Composite);
	assoc.getEnds().add(end1);
	assoc.getEnds().add(end2);
	ClassTypeDefinition end1TD = MetamodelUtils.createClassTypeDefinition(conn, end1Class, end1Lower, end1Upper, end1Ordered, end1Unique);
	end1.setType(end1TD);
	ClassTypeDefinition end2TD = MetamodelUtils.createClassTypeDefinition(conn, end2Class, end2Lower, end2Upper, end2Ordered, end2Unique);
	end2.setType(end2TD);
	return assoc;
    }

    public static Association createAssociation(Connection conn, SapClass end1Class, int end1Lower, int end1Upper,
	    boolean end1Navigability, SapClass end2Class, int end2Lower, int end2Upper, boolean end2Navigable) {
	Association assoc = (Association) conn.getClass(Association.CLASS_DESCRIPTOR).refCreateInstance();
	AssociationEnd end1 = (AssociationEnd) conn.getClass(AssociationEnd.CLASS_DESCRIPTOR)
		.refCreateInstance();
	end1.setNavigable(end1Navigability);
	AssociationEnd end2 = (AssociationEnd) conn.getClass(AssociationEnd.CLASS_DESCRIPTOR)
		.refCreateInstance();
	end2.setNavigable(end2Navigable);
	assoc.getEnds().add(end1);
	assoc.getEnds().add(end2);
	ClassTypeDefinition end1TD = MetamodelUtils.createClassTypeDefinition(conn, end1Class, end1Lower, end1Upper);
	end1.setType(end1TD);
	ClassTypeDefinition end2TD = MetamodelUtils.createClassTypeDefinition(conn, end2Class, end2Lower, end2Upper);
	end2.setType(end2TD);
	return assoc;
    }

    public static MethodSignature findMethod(Connection conn, String classname, String methodname) {
	MQLProcessor mql = conn.getMQLProcessor();
	MQLResultSet methodSignatureQueryResult = mql
		.execute(
	    "select s from data::classes::MethodSignature as s, "+
	    "data::classes::SapClass as c where s.owner = c where s.name='"+methodname+"' "+
	    "where c.name='"+classname+"'",
	    mql.getQueryScopeProvider(/* scopeInclusive */false, /* partitionScope */
		    null, (String[]) null));
	MethodSignature methodSignature = null;
	RefObject[] array = methodSignatureQueryResult.getRefObjects("s");
	if (array.length > 0) {
	    methodSignature = (MethodSignature) array[0];
	}
	return methodSignature;
    }

    public static SapClass findClass(Connection conn, String classname) {
	MQLProcessor mql = conn.getMQLProcessor();
	MQLResultSet queryResult = mql
		.execute(
	    "select c from data::classes::SapClass as c where for c(name='"+classname+"')",
	    mql.getQueryScopeProvider(/* scopeInclusive */false, /* partitionScope */
		    null, (String[]) null));
	SapClass clazz = (SapClass) queryResult.getRefObjects("c")[0];
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
	    Connection conn, FunctionSignature funcSig) {
	FunctionCallExpression fce = conn.createElement(FunctionCallExpression.CLASS_DESCRIPTOR);
	FunctionSignatureTypeDefinition fstd = conn.createElement(FunctionSignatureTypeDefinition.CLASS_DESCRIPTOR);
	fstd.setLowerMultiplicity(1);
	fstd.setUpperMultiplicity(1);
	fstd.setSignature(funcSig);
	AnonymousFunctionExpr afe = conn.createElement(AnonymousFunctionExpr.CLASS_DESCRIPTOR);
	afe.setOwnedTypeDefinition(fstd);
	fce.setCalledBlock(afe);
	return fce;
    }

}
