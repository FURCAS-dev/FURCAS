/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: BaseDeclarationVisitor.java,v 1.4 2011/01/30 11:12:40 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.pivot2cs;

import org.apache.log4j.Logger;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTFactory;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;

public class BaseDeclarationVisitor extends AbstractExtendingVisitor<ElementCS, Pivot2CSConversion>
{
	public static final Logger logger = Logger.getLogger(BaseDeclarationVisitor.class);

	public BaseDeclarationVisitor(Pivot2CSConversion context) {
		super(context);		// NB this class is stateless since separate instances exist per CS package
	}

	protected void handleConstraint(Constraint object, ConstraintCS csElement) {
		csElement.setStereotype(object.getStereotype());
		ValueSpecification specification = object.getSpecification();
		if (specification instanceof OpaqueExpression) {
			String body = PivotUtil.getBody((OpaqueExpression)specification);
			csElement.setExprString(body);
		}
	}

	@Override
	public ElementCS visitAnnotation(org.eclipse.ocl.examples.pivot.Annotation object) {
		AnnotationCS csElement = context.refreshNamedElement(AnnotationCS.class, BaseCSTPackage.Literals.ANNOTATION_CS, object);
		context.refreshList(csElement.getOwnedContent(), context.visitDeclarations(ModelElementCS.class, object.getOwnedContents(), null));
		context.refreshList(csElement.getOwnedDetail(), context.visitDeclarations(DetailCS.class, object.getOwnedDetails(), null));
		return csElement;
	}

	@Override
	public ElementCS visitClass(org.eclipse.ocl.examples.pivot.Class object) {
		org.eclipse.ocl.examples.pivot.Class savedScope = context.setScope(object);
		ClassCS csElement = context.refreshClassifier(ClassCS.class, BaseCSTPackage.Literals.CLASS_CS, object);
		context.refreshList(csElement.getOwnedProperty(), context.visitDeclarations(StructuralFeatureCS.class, object.getOwnedAttributes(),
			new Pivot2CS.Predicate<Property>()
			{
				public boolean filter(Property element) {
					return !element.isImplicit();
				}
			}));
		context.refreshList(csElement.getOwnedOperation(), context.visitDeclarations(OperationCS.class, object.getOwnedOperations(), null));
		context.refreshList(csElement.getOwnedSuperType(), context.visitReferences(TypedRefCS.class, object.getSuperClasses()));
		context.refreshQualifiers(csElement.getQualifier(), "abstract", object.isAbstract());
		context.refreshQualifiers(csElement.getQualifier(), "interface", object.isInterface());
		context.setScope(savedScope);
		return csElement;
	}

//	@Override
//	public ElementCS visitComment(Comment object) {
//		ParameterCS pivotElement = context.refreshNamedElement(ParameterCS.class, BaseCSTPackage.Literals.COMMENT_CS, object);
//		return null;
//	}

	@Override
	public ElementCS visitConstraint(Constraint object) {
		ConstraintCS csElement = context.refreshNamedElement(ConstraintCS.class, BaseCSTPackage.Literals.CONSTRAINT_CS, object);
		handleConstraint(object, csElement);
		return csElement;
	}

	@Override
	public ElementCS visitDataType(DataType object) {
		DataTypeCS csElement = context.refreshClassifier(DataTypeCS.class, BaseCSTPackage.Literals.DATA_TYPE_CS, object);
		context.refreshQualifiers(csElement.getQualifier(), "serializable", object.isSerializable());
		return csElement;
	}

	@Override
	public ElementCS visitDetail(Detail object) {
		DetailCS csElement = context.refreshNamedElement(DetailCS.class, BaseCSTPackage.Literals.DETAIL_CS, object);
		csElement.getValue().clear();
		csElement.getValue().addAll(object.getValues());
		return csElement;
	}

	@Override
	public ElementCS visitEnumeration(org.eclipse.ocl.examples.pivot.Enumeration object) {
		EnumerationCS csElement = context.refreshClassifier(EnumerationCS.class, BaseCSTPackage.Literals.ENUMERATION_CS, object);
		context.refreshList(csElement.getOwnedLiterals(), context.visitDeclarations(EnumerationLiteralCS.class, object.getOwnedLiterals(), null));
		context.refreshQualifiers(csElement.getQualifier(), "serializable", object.isSerializable());
		return csElement;
	}

	@Override
	public ElementCS visitEnumerationLiteral(EnumerationLiteral object) {
		EnumerationLiteralCS csElement = context.refreshNamedElement(EnumerationLiteralCS.class,
			BaseCSTPackage.Literals.ENUMERATION_LITERAL_CS, object);
		if (object.eIsSet(PivotPackage.Literals.ENUMERATION_LITERAL__VALUE)) {
			csElement.setValue(object.getValue().intValue());
		}
		else {
			csElement.eUnset(BaseCSTPackage.Literals.ENUMERATION_LITERAL_CS__VALUE);
		}
		return csElement;
	}

	@Override
	public ElementCS visitOperation(Operation object) {
		OperationCS csElement = context.refreshTypedMultiplicityElement(OperationCS.class, BaseCSTPackage.Literals.OPERATION_CS, object);
		TemplateSignature ownedTemplateSignature = object.getOwnedTemplateSignature();
		if (ownedTemplateSignature != null) {
			csElement.setOwnedTemplateSignature(context.visitDeclaration(TemplateSignatureCS.class, ownedTemplateSignature));
		}
		context.refreshList(csElement.getOwnedParameter(), context.visitDeclarations(ParameterCS.class, object.getOwnedParameters(), null));
		context.refreshList(csElement.getOwnedException(), context.visitReferences(TypedRefCS.class, object.getRaisedExceptions()));
		return csElement;
	}

	@Override
	public PackageCS visitPackage(org.eclipse.ocl.examples.pivot.Package object) {
		PackageCS csElement;
		if (object.eContainer() == null) {
			csElement = context.refreshNamedElement(RootPackageCS.class, BaseCSTPackage.Literals.ROOT_PACKAGE_CS, object);
		}
		else {
			PackageCS csPackage = context.refreshNamedElement(PackageCS.class, BaseCSTPackage.Literals.PACKAGE_CS, object);
			context.refreshList(csPackage.getOwnedType(), context.visitDeclarations(ClassifierCS.class, object.getOwnedTypes(), null));
			csElement = csPackage;
		}
		csElement.setNsPrefix(object.getNsPrefix());
		csElement.setNsURI(object.getNsURI());
		context.refreshList(csElement.getOwnedNestedPackage(), context.visitDeclarations(PackageCS.class, object.getNestedPackages(), null));
		return csElement;
	}

	@Override
	public ElementCS visitParameter(Parameter object) {
		ParameterCS csElement = context.refreshTypedMultiplicityElement(ParameterCS.class, BaseCSTPackage.Literals.PARAMETER_CS, object);
		return csElement;
	}

	@Override
	public ElementCS visitProperty(Property object) {
		Type type = object.getType();
		if (type instanceof DataType) {
			AttributeCS csElement = context.refreshStructuralFeature(AttributeCS.class, BaseCSTPackage.Literals.ATTRIBUTE_CS, object);
			context.refreshQualifiers(csElement.getQualifier(), "id", object.isID());
			return csElement;
		}
		else {
			ReferenceCS csElement = context.refreshStructuralFeature(ReferenceCS.class, BaseCSTPackage.Literals.REFERENCE_CS, object);
			context.refreshQualifiers(csElement.getQualifier(), "composes", object.isComposite());
			context.refreshQualifiers(csElement.getQualifier(), "resolve", object.isResolveProxies());
			Property opposite = object.getOpposite();
			if (opposite != null) {
				if (!opposite.isImplicit()) {
					ReferenceCSRef referenceRef = BaseCSTFactory.eINSTANCE.createReferenceCSRef();
					referenceRef.setRef(opposite);
					csElement.setOpposite(referenceRef);
				}
				else {
					// FIXME
				}
			}
			return csElement;
		}
	}

	@Override
	public ElementCS visitTemplateSignature(TemplateSignature object) {
		TemplateSignatureCS csElement = context.refreshMonikeredElement(TemplateSignatureCS.class, BaseCSTPackage.Literals.TEMPLATE_SIGNATURE_CS, object);
		context.refreshList(csElement.getOwnedTemplateParameter(), context.visitDeclarations(TemplateParameterCS.class, object.getOwnedParameters(), null));
		return csElement;
	}

	@Override
	public ElementCS visitTypeTemplateParameter(TypeTemplateParameter object) {
		ParameterableElement parameteredElement = object.getParameteredElement();
		TypeParameterCS csElement = context.refreshMonikeredElement(TypeParameterCS.class, BaseCSTPackage.Literals.TYPE_PARAMETER_CS, parameteredElement);
		csElement.setName(((NamedElement) parameteredElement).getName());
		return csElement;
	}

	public ElementCS visiting(Visitable visitable) {
		logger.error("Unsupported " + visitable.eClass().getName() + " for " + getClass().getName());
		return null;
	}
}