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
 * $Id: BaseCSVisitor.java,v 1.4 2011/02/11 20:59:26 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.base.util;

/**
 */
public interface BaseCSVisitor<R, C>
{
	/**
	 * Returns an object which is an instance of the given class
	 * associated with this object. Returns <code>null</code> if
	 * no such object can be found.
	 *
	 * @param adapter the adapter class to look up
	 * @return an object of the given class, 
	 *    or <code>null</code> if this object does not
	 *    have an adapter for the given class
	 */
	<A> A getAdapter(Class<A> adapter);

	/**
     * Return the result of visiting a visitable for which no more specific pivot type method
     * is available.
     */
	R visiting(org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable);
	
	R visitAnnotationCS(org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS object);
	R visitAnnotationElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS object);
	R visitAttributeCS(org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS object);
	R visitAttributeCSRef(org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCSRef object);
	R visitBoundDocumentCS(org.eclipse.ocl.examples.xtext.base.baseCST.BoundDocumentCS object);
	R visitClassCS(org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS object);
	R visitClassCSRef(org.eclipse.ocl.examples.xtext.base.baseCST.ClassCSRef object);
	R visitClassifierCS(org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS object);
	R visitCollectionTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.CollectionTypeRefCS object);
	R visitConstraintCS(org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS object);
	R visitDataTypeCS(org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS object);
	R visitDetailCS(org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS object);
	R visitDocumentationCS(org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS object);
	R visitElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS object);
	R visitEnumerationCS(org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS object);
	R visitEnumerationLiteralCS(org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS object);
	R visitImportCS(org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS object);
	R visitLibraryCS(org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS object);
	R visitModelElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS object);
	R visitModelElementCSRef(org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef object);
	R visitMonikeredElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS object);
	R visitNamedElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS object);
	R visitOperationCS(org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS object);
	R visitPackageCS(org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS object);
	R visitParameterCS(org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS object);
	R visitParameterizedTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS object);
	R visitPrimitiveTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS object);
	R visitQualifiedTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedTypeRefCS object);
	R visitReferenceCS(org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS object);
	R visitReferenceCSRef(org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef object);
	R visitRootPackageCS(org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS object);
	R visitStructuralFeatureCS(org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS object);
	R visitTemplateBindingCS(org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS object);
	R visitTemplateParameterCS(org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS object);
	R visitTemplateParameterSubstitutionCS(org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS object);
	R visitTemplateSignatureCS(org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS object);
	R visitTuplePartCS(org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS object);
	R visitTupleTypeCS(org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS object);
	R visitTypeParameterCS(org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS object);
	R visitTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS object);
	R visitTypedElementCS(org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS object);
	R visitTypedRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS object);
	R visitTypedTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS object);
	R visitWildcardTypeRefCS(org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS object);
}
