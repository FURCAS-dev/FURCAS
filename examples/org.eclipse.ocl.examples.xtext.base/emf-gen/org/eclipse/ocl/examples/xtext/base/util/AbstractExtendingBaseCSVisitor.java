/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: /org.eclipse.ocl.examples.xtext.base/model/BaseCST.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id: AbstractExtendingBaseCSVisitor.java,v 1.2 2011/01/24 20:59:32 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.base.util;

/**
 * An AbstractExtendingBaseCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingBaseCSVisitor<R, C>
	extends AbstractBaseCSVisitor<R, C>
	implements BaseCSVisitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingBaseCSVisitor(C context) {
	    super(context);
	}	

	public R visitAnnotationCS(org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS object) {
		return visitAnnotationElementCS(object);
	}

	public R visitAnnotationElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS object) {
		return visitNamedElementCS(object);
	}

	public R visitAttributeCS(org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS object) {
		return visitStructuralFeatureCS(object);
	}

	public R visitAttributeCSRef(org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCSRef object) {
		return visitElementCS(object);
	}

	public R visitBoundDocumentCS(org.eclipse.ocl.examples.xtext.base.baseCST.BoundDocumentCS object) {
		return visitPackageCS(object);
	}

	public R visitClassCS(org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS object) {
		return visitClassifierCS(object);
	}

	public R visitClassCSRef(org.eclipse.ocl.examples.xtext.base.baseCST.ClassCSRef object) {
		return visitElementCS(object);
	}

	public R visitClassifierCS(org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS object) {
		return visitNamedElementCS(object);
	}

	public R visitClassifierRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierRefCS object) {
		return visitModelElementCS(object);
	}

	public R visitCollectionTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.CollectionTypeRefCS object) {
		return visitTypedTypeRefCS(object);
	}

	public R visitConstraintCS(org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS object) {
		return visitNamedElementCS(object);
	}

	public R visitDataTypeCS(org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS object) {
		return visitClassifierCS(object);
	}

	public R visitDetailCS(org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS object) {
		return visitNamedElementCS(object);
	}

	public R visitDocumentationCS(org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS object) {
		return visitAnnotationElementCS(object);
	}

	public R visitElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS object) {
		return visiting(object);
	}

	public R visitEnumerationCS(org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS object) {
		return visitClassifierCS(object);
	}

	public R visitEnumerationLiteralCS(org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS object) {
		return visitNamedElementCS(object);
	}

	public R visitImportCS(org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS object) {
		return visitNamedElementCS(object);
	}

	public R visitLibraryCS(org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS object) {
		return visitNamedElementCS(object);
	}

	public R visitModelElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS object) {
		return visitElementCS(object);
	}

	public R visitModelElementCSRef(org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef object) {
		return visitElementCS(object);
	}

	public R visitMonikeredElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS object) {
		return visitModelElementCS(object);
	}

	public R visitNamedElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS object) {
		return visitMonikeredElementCS(object);
	}

	public R visitOperationCS(org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS object) {
		return visitTypedElementCS(object);
	}

	public R visitOperationRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.OperationRefCS object) {
		return visitModelElementCS(object);
	}

	public R visitPackageCS(org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS object) {
		return visitNamedElementCS(object);
	}

	public R visitPackageRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.PackageRefCS object) {
		return visitMonikeredElementCS(object);
	}

	public R visitParameterCS(org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS object) {
		return visitTypedElementCS(object);
	}

	public R visitParameterizedTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS object) {
		return visitTypedRefCS(object);
	}

	public R visitPrimitiveTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS object) {
		return visitTypedRefCS(object);
	}

	public R visitQualifiedClassifierRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedClassifierRefCS object) {
		return visitClassifierRefCS(object);
	}

	public R visitQualifiedOperationRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedOperationRefCS object) {
		return visitOperationRefCS(object);
	}

	public R visitQualifiedPackageRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedPackageRefCS object) {
		return visitPackageRefCS(object);
	}

	public R visitQualifiedStructuralFeatureRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedStructuralFeatureRefCS object) {
		return visitStructuralFeatureRefCS(object);
	}

	public R visitQualifiedTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedTypeRefCS object) {
		return visitParameterizedTypeRefCS(object);
	}

	public R visitReferenceCS(org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS object) {
		return visitStructuralFeatureCS(object);
	}

	public R visitReferenceCSRef(org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef object) {
		return visitElementCS(object);
	}

	public R visitRootPackageCS(org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS object) {
		return visitPackageCS(object);
	}

	public R visitSimpleClassifierRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.SimpleClassifierRefCS object) {
		return visitClassifierRefCS(object);
	}

	public R visitSimpleOperationRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.SimpleOperationRefCS object) {
		return visitOperationRefCS(object);
	}

	public R visitSimplePackageRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.SimplePackageRefCS object) {
		return visitPackageRefCS(object);
	}

	public R visitSimpleStructuralFeatureRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.SimpleStructuralFeatureRefCS object) {
		return visitStructuralFeatureRefCS(object);
	}

	public R visitStructuralFeatureCS(org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS object) {
		return visitTypedElementCS(object);
	}

	public R visitStructuralFeatureRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureRefCS object) {
		return visitModelElementCS(object);
	}

	public R visitTemplateBindingCS(org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS object) {
		return visitModelElementCS(object);
	}

	public R visitTemplateParameterCS(org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS object) {
		return visitNamedElementCS(object);
	}

	public R visitTemplateParameterSubstitutionCS(org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS object) {
		return visitModelElementCS(object);
	}

	public R visitTemplateSignatureCS(org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS object) {
		return visitMonikeredElementCS(object);
	}

	public R visitTuplePartCS(org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS object) {
		return visitTypedElementCS(object);
	}

	public R visitTupleTypeCS(org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS object) {
		return visitNamedElementCS(object);
	}

	public R visitTypeParameterCS(org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS object) {
		return visitTemplateParameterCS(object);
	}

	public R visitTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS object) {
		return visitMonikeredElementCS(object);
	}

	public R visitTypedElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS object) {
		return visitNamedElementCS(object);
	}

	public R visitTypedRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS object) {
		return visitTypeRefCS(object);
	}

	public R visitTypedTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS object) {
		return visitParameterizedTypeRefCS(object);
	}

	public R visitWildcardTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS object) {
		return visitTypeRefCS(object);
	}
}
