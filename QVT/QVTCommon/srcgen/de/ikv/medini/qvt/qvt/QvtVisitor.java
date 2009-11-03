/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.qvt;

import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.bridge.Tag;
import org.oslo.ocl20.semantics.model.expressions.OperationCallExp;

import de.ikv.medini.qvt.model.qvtbase.Function;
import de.ikv.medini.qvt.model.qvtbase.Pattern;
import de.ikv.medini.qvt.model.qvtbase.Predicate;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;
import de.ikv.medini.qvt.model.qvtrelation.DomainPattern;
import de.ikv.medini.qvt.model.qvtrelation.Key;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationCallExp;
import de.ikv.medini.qvt.model.qvtrelation.RelationDomain;
import de.ikv.medini.qvt.model.qvtrelation.RelationImplementation;
import de.ikv.medini.qvt.model.qvtrelation.RelationalTransformation;
import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Visitor</b></em>'. <!-- end-user-doc -->
 *
 *
 * @see de.ikv.medini.qvt.qvt.QvtPackage#getQvtVisitor()
 * @model abstract="true"
 * @generated
 */
public interface QvtVisitor extends OclVisitor {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object" dataOrdered="false"
	 * @generated
	 */
	Object visit(RelationDomain host, Object data);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object" dataOrdered="false"
	 * @generated
	 */
	Object visit(RelationalTransformation host, Object data);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object" dataOrdered="false"
	 * @generated
	 */
	Object visit(Relation host, Object data);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object" dataOrdered="false"
	 * @generated
	 */
	Object visit(RelationCallExp host, Object data);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object" dataOrdered="false"
	 * @generated
	 */
	Object visit(ObjectTemplateExp host, Object data);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object" dataOrdered="false"
	 * @generated
	 */
	Object visit(PropertyTemplateItem host, Object data);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object" dataOrdered="false"
	 * @generated
	 */
	Object visit(OperationCallExp host, Object data);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object" dataOrdered="false"
	 * @generated
	 */
	Object visit(DomainPattern host, Object data);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object" dataOrdered="false"
	 * @generated
	 */
	Object visit(Key host, Object data);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object" dataOrdered="false"
	 * @generated
	 */
	Object visit(Predicate host, Object data);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object" dataOrdered="false"
	 * @generated
	 */
	Object visit(Pattern host, Object data);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object" dataOrdered="false"
	 * @generated
	 */
	Object visit(RelationImplementation host, Object data);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object" dataOrdered="false"
	 * @generated
	 */
	Object visit(Tag host, Object data);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object" dataOrdered="false"
	 * @generated
	 */
	Object visit(TypedModel host, Object data);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object" dataOrdered="false"
	 * @generated
	 */
	Object visit(Function host, Object data);

} // QvtVisitor
