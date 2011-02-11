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
 * $Id: AbstractDelegatingBaseCSVisitor.java,v 1.4 2011/02/11 20:59:26 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.base.util;

/**
 * An AbstractDelegatingBaseCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingBaseCSVisitor<R, C, D extends BaseCSVisitor<R, C>>
	extends AbstractBaseCSVisitor<R, C>
	implements BaseCSVisitor<R, C>
{
    protected final D delegate;
    
    protected AbstractDelegatingBaseCSVisitor(D delegate, C context) {
    	super(context);
        assert delegate != null : "cannot decorate a null visitor"; //$NON-NLS-1$        
        this.delegate = delegate;        
//        delegate.setUndecoratedVisitor(this);
    }

    /**
     * Delegates to my decorated visitor.
     */
//	public DecorableBaseCSVisitor<R, C> createNestedVisitor() {
//        return delegate.createNestedVisitor();
//	}
  
    /**
     * Obtains the visitor that I decorate.
     * 
     * @return my decorated visitor
     */
    protected final D getDelegate() {
        return delegate;
    }

	public R visiting(org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public R visitAnnotationCS(org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS object) {
		return delegate.visitAnnotationCS(object);
	}

	public R visitAnnotationElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS object) {
		return delegate.visitAnnotationElementCS(object);
	}

	public R visitAttributeCS(org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS object) {
		return delegate.visitAttributeCS(object);
	}

	public R visitAttributeCSRef(org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCSRef object) {
		return delegate.visitAttributeCSRef(object);
	}

	public R visitBoundDocumentCS(org.eclipse.ocl.examples.xtext.base.baseCST.BoundDocumentCS object) {
		return delegate.visitBoundDocumentCS(object);
	}

	public R visitClassCS(org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS object) {
		return delegate.visitClassCS(object);
	}

	public R visitClassCSRef(org.eclipse.ocl.examples.xtext.base.baseCST.ClassCSRef object) {
		return delegate.visitClassCSRef(object);
	}

	public R visitClassifierCS(org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS object) {
		return delegate.visitClassifierCS(object);
	}

	public R visitCollectionTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.CollectionTypeRefCS object) {
		return delegate.visitCollectionTypeRefCS(object);
	}

	public R visitConstraintCS(org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS object) {
		return delegate.visitConstraintCS(object);
	}

	public R visitDataTypeCS(org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS object) {
		return delegate.visitDataTypeCS(object);
	}

	public R visitDetailCS(org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS object) {
		return delegate.visitDetailCS(object);
	}

	public R visitDocumentationCS(org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS object) {
		return delegate.visitDocumentationCS(object);
	}

	public R visitElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS object) {
		return delegate.visitElementCS(object);
	}

	public R visitEnumerationCS(org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS object) {
		return delegate.visitEnumerationCS(object);
	}

	public R visitEnumerationLiteralCS(org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS object) {
		return delegate.visitEnumerationLiteralCS(object);
	}

	public R visitImportCS(org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS object) {
		return delegate.visitImportCS(object);
	}

	public R visitLibraryCS(org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS object) {
		return delegate.visitLibraryCS(object);
	}

	public R visitModelElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS object) {
		return delegate.visitModelElementCS(object);
	}

	public R visitModelElementCSRef(org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef object) {
		return delegate.visitModelElementCSRef(object);
	}

	public R visitMonikeredElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS object) {
		return delegate.visitMonikeredElementCS(object);
	}

	public R visitNamedElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS object) {
		return delegate.visitNamedElementCS(object);
	}

	public R visitOperationCS(org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS object) {
		return delegate.visitOperationCS(object);
	}

	public R visitPackageCS(org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS object) {
		return delegate.visitPackageCS(object);
	}

	public R visitParameterCS(org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS object) {
		return delegate.visitParameterCS(object);
	}

	public R visitParameterizedTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS object) {
		return delegate.visitParameterizedTypeRefCS(object);
	}

	public R visitPrimitiveTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS object) {
		return delegate.visitPrimitiveTypeRefCS(object);
	}

	public R visitQualifiedTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedTypeRefCS object) {
		return delegate.visitQualifiedTypeRefCS(object);
	}

	public R visitReferenceCS(org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS object) {
		return delegate.visitReferenceCS(object);
	}

	public R visitReferenceCSRef(org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef object) {
		return delegate.visitReferenceCSRef(object);
	}

	public R visitRootPackageCS(org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS object) {
		return delegate.visitRootPackageCS(object);
	}

	public R visitStructuralFeatureCS(org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS object) {
		return delegate.visitStructuralFeatureCS(object);
	}

	public R visitTemplateBindingCS(org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS object) {
		return delegate.visitTemplateBindingCS(object);
	}

	public R visitTemplateParameterCS(org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS object) {
		return delegate.visitTemplateParameterCS(object);
	}

	public R visitTemplateParameterSubstitutionCS(org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS object) {
		return delegate.visitTemplateParameterSubstitutionCS(object);
	}

	public R visitTemplateSignatureCS(org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS object) {
		return delegate.visitTemplateSignatureCS(object);
	}

	public R visitTuplePartCS(org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS object) {
		return delegate.visitTuplePartCS(object);
	}

	public R visitTupleTypeCS(org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS object) {
		return delegate.visitTupleTypeCS(object);
	}

	public R visitTypeParameterCS(org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS object) {
		return delegate.visitTypeParameterCS(object);
	}

	public R visitTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS object) {
		return delegate.visitTypeRefCS(object);
	}

	public R visitTypedElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS object) {
		return delegate.visitTypedElementCS(object);
	}

	public R visitTypedRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS object) {
		return delegate.visitTypedRefCS(object);
	}

	public R visitTypedTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS object) {
		return delegate.visitTypedTypeRefCS(object);
	}

	public R visitWildcardTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS object) {
		return delegate.visitWildcardTypeRefCS(object);
	}
}
