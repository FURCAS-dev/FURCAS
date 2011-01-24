/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: BaseScopeVisitor.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import org.apache.log4j.Logger;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedOperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedPackageRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedStructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleOperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimplePackageRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleStructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.ClassCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.ConstraintCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.DataTypeCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.EmptyCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.EnumCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.ImportScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.OperationCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.PackageCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.QualifiedRefCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.ReferenceCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.RootPackageCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.TemplateBindingCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.TemplateParameterSubstitutionCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.TemplateSignatureCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.TupleTypeCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.TypedTypeRefCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.util.AbstractExtendingBaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;

public class BaseScopeVisitor extends AbstractExtendingBaseCSVisitor<ScopeCSAdapter, TypeManager>
{
	private static final Logger logger = Logger.getLogger(BaseScopeVisitor.class);

	public BaseScopeVisitor(TypeManager context) {
		super(context);
		assert context != null;
	}
	
	@Override
	public ScopeCSAdapter visitAnnotationCS(AnnotationCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitAttributeCS(AttributeCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitClassCS(ClassCS eObject) {
		return new ClassCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitConstraintCS(ConstraintCS eObject) {
		return new ConstraintCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitDataTypeCS(DataTypeCS eObject) {
		return new DataTypeCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitEnumerationCS(EnumerationCS eObject) {
		return new EnumCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitImportCS(ImportCS eObject) {
		return new ImportScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitOperationCS(OperationCS eObject) {
		return new OperationCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitPackageCS(PackageCS eObject) {
		return new PackageCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitParameterCS(ParameterCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitQualifiedClassifierRefCS(QualifiedClassifierRefCS eObject) {
		return new QualifiedRefCSScopeAdapter<QualifiedClassifierRefCS, Type>(context, eObject, Type.class);
	}

	@Override
	public ScopeCSAdapter visitQualifiedOperationRefCS(QualifiedOperationRefCS eObject) {
		return new QualifiedRefCSScopeAdapter<QualifiedOperationRefCS, Operation>(context, eObject, Operation.class);
	}

	@Override
	public ScopeCSAdapter visitQualifiedPackageRefCS(QualifiedPackageRefCS eObject) {
		return new QualifiedRefCSScopeAdapter<QualifiedPackageRefCS, org.eclipse.ocl.examples.pivot.Package>(context, eObject, org.eclipse.ocl.examples.pivot.Package.class);
	}

	@Override
	public ScopeCSAdapter visitQualifiedStructuralFeatureRefCS(QualifiedStructuralFeatureRefCS eObject) {
		return new QualifiedRefCSScopeAdapter<QualifiedStructuralFeatureRefCS, Property>(context, eObject, Property.class);
	}

	@Override
	public ScopeCSAdapter visitQualifiedTypeRefCS(QualifiedTypeRefCS eObject) {
		return new QualifiedRefCSScopeAdapter<QualifiedTypeRefCS, Type>(context, eObject, Type.class);
	}

	@Override
	public ScopeCSAdapter visitReferenceCS(ReferenceCS eObject) {
		return new ReferenceCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitReferenceCSRef(ReferenceCSRef eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitRootPackageCS(RootPackageCS eObject) {
		return new RootPackageCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitSimpleClassifierRefCS(SimpleClassifierRefCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitSimpleOperationRefCS(SimpleOperationRefCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitSimplePackageRefCS(SimplePackageRefCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitSimpleStructuralFeatureRefCS(SimpleStructuralFeatureRefCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitTemplateBindingCS(TemplateBindingCS eObject) {
		return new TemplateBindingCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitTemplateParameterSubstitutionCS(TemplateParameterSubstitutionCS eObject) {
		return new TemplateParameterSubstitutionCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitTemplateSignatureCS(TemplateSignatureCS eObject) {
		return new TemplateSignatureCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitTuplePartCS(TuplePartCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitTupleTypeCS(TupleTypeCS eObject) {
		return new TupleTypeCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitTypeParameterCS(TypeParameterCS eObject) {
		return new EmptyCSScopeAdapter(context, eObject);
	}

	@Override
	public ScopeCSAdapter visitTypedTypeRefCS(TypedTypeRefCS eObject) {
		return new TypedTypeRefCSScopeAdapter(context, eObject);
	}

	public ScopeCSAdapter visiting(VisitableCS visitable) {
		logger.error("Unsupported " + visitable.eClass().getName() + " for " + getClass().getName());
		return null;
	}
}