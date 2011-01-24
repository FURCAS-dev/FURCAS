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
 * $Id: BasePostOrderVisitor.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.util.AbstractExtendingBaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;

public class BasePostOrderVisitor extends AbstractExtendingBaseCSVisitor<Continuation<?>, CS2PivotConversion>
{
	public static final Logger logger = Logger.getLogger(BasePostOrderVisitor.class);
	
	public BasePostOrderVisitor(CS2PivotConversion context) {
		super(context);		// NB this class is stateless since separate instances exist per CS package
	}

	protected TemplateableElementCS getTemplateableElementContainer(ElementCS csElement) {
		for (EObject eObject = csElement; eObject != null; eObject = eObject.eContainer())
			if (eObject instanceof TemplateableElementCS) {
				return (TemplateableElementCS) eObject;
			}
		return null;
	}

	protected <CST extends ModelElementCS, P extends NamedElement> BasicContinuation<?> refreshList(NamedElement pivotParent, EStructuralFeature pivotFeature,
		final Class<P> pivotClass, final List<P> pivotElements, List<CST> csElements) {
		if (csElements.isEmpty()) {
			context.refreshPivotList(pivotClass, pivotElements, csElements);
			return null;
		}
		else {
			return new MultipleContinuation<CST>(context, pivotParent, pivotFeature, csElements, new PivotDependencies(csElements)) 
			{
				@Override
				public BasicContinuation<?> execute() {
					context.refreshPivotList(pivotClass, pivotElements, csElement);
					return null;
				}			
			};
		}
	}

	public Continuation<?> visiting(VisitableCS visitable) {
		logger.error("Unsupported " + visitable.eClass().getName() + " for " + getClass().getName());
		return null;
	}

	@Override
	public Continuation<?> visitAnnotationCS(AnnotationCS csAnnotation) {
		Annotation pivotElement = context.refreshNamedElement(Annotation.class,
			PivotPackage.Literals.ANNOTATION, csAnnotation);
		context.handleVisitNamedElement(csAnnotation, pivotElement);
		context.refreshPivotList(Detail.class, pivotElement.getOwnedDetails(), csAnnotation.getOwnedDetail());
		context.refreshPivotList(Element.class, pivotElement.getOwnedContents(), csAnnotation.getOwnedContent());
		List<ModelElementCSRef> csReferences = csAnnotation.getReference();
		if (csReferences.size() > 0) {		// FIXME this seems highly suspect, why a CS rather than pivot ref
			List<ModelElementCS> csElements = new ArrayList<ModelElementCS>(csReferences.size());
			for (ModelElementCSRef csReference : csReferences) {
				csElements.add(csReference.getRef());
			}
			context.refreshPivotList(Element.class, pivotElement.getReferences(), csElements);
		}
		return null;
	}

	@Override
	public Continuation<?> visitAnnotationElementCS(AnnotationElementCS csAnnotationElement) {
		return null;
	}

	@Override
	public Continuation<?> visitClassifierCS(ClassifierCS csClassifier) {
		Type pivotElement = PivotUtil.getPivot(Type.class, csClassifier);
		context.handleVisitNamedElement(csClassifier, pivotElement);
		context.refreshPivotList(Constraint.class, pivotElement.getOwnedRules(), csClassifier.getOwnedConstraint());
		return null;
	}

	@Override
	public Continuation<?> visitConstraintCS(ConstraintCS csConstraint) {
		@SuppressWarnings("unused")
		Constraint pivotElement = context.refreshNamedElement(Constraint.class, PivotPackage.Literals.CONSTRAINT, csConstraint);
		return null;
	}

	@Override
	public Continuation<?> visitDetailCS(DetailCS csDetail) {
		Detail pivotElement = context.refreshNamedElement(Detail.class,
			PivotPackage.Literals.DETAIL, csDetail);
		context.handleVisitNamedElement(csDetail, pivotElement);
//			refreshPivotList(Detail.class, pivotElement.getOwnedDetails(), csDocumentation.getOwnedDetail());
		List<String> newValues = csDetail.getValue();
		List<String> pivotValues = pivotElement.getValues();
		pivotValues.clear();
		pivotValues.addAll(newValues);
		return null;
	}

	@Override
	public Continuation<?> visitDocumentationCS(DocumentationCS csDocumentation) {
		Annotation pivotElement = context.refreshNamedElement(Annotation.class,
			PivotPackage.Literals.ANNOTATION, csDocumentation);
		context.handleVisitNamedElement(csDocumentation, pivotElement);
		context.refreshPivotList(Detail.class, pivotElement.getOwnedDetails(), csDocumentation.getOwnedDetail());
		return null;
	}

	@Override
	public Continuation<?> visitElementCS(ElementCS csElement) {
		return visiting(csElement);
	}

	@Override
	public Continuation<?> visitImportCS(ImportCS object) {
		return null;
	}

	@Override
	public Continuation<?> visitModelElementCS(ModelElementCS csModelElement) {
		return null;
	}

	@Override
	public Continuation<?> visitMonikeredElementCS(MonikeredElementCS csMonikeredElement) {
		return null;
	}

	@Override
	public Continuation<?> visitNamedElementCS(NamedElementCS csNamedElement) {
		NamedElement pivotElement = PivotUtil.getPivot(NamedElement.class, csNamedElement);
		context.handleVisitNamedElement(csNamedElement, pivotElement);
		return null;
	}

	@Override
	public Continuation<?> visitPackageCS(PackageCS csPackage) {
		org.eclipse.ocl.examples.pivot.Package pivotElement = PivotUtil.getPivot(org.eclipse.ocl.examples.pivot.Package.class, csPackage);
		context.handleVisitNamedElement(csPackage, pivotElement);
		return null;
	}

	@Override
	public Continuation<?> visitParameterizedTypeRefCS(ParameterizedTypeRefCS csParameterizedTypeRef) {
		return null;
	}

	@Override
	public Continuation<?> visitPrimitiveTypeRefCS(PrimitiveTypeRefCS csPrimitiveTypeRef) {
		return null;
	}

	@Override
	public Continuation<?> visitReferenceCS(ReferenceCS csReference) {
		Property pivotElement = PivotUtil.getPivot(Property.class, csReference);
		ReferenceCSRef pivotOppositeRef = csReference.getOpposite();
		Property pivotOpposite = pivotOppositeRef != null ? pivotOppositeRef.getRef() : null;
		pivotElement.setOpposite(pivotOpposite);
		return visitTypedElementCS(csReference);
	}

	@Override
	public Continuation<?> visitReferenceCSRef(ReferenceCSRef object) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateBindingCS(TemplateBindingCS csTemplateBinding) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateParameterCS(TemplateParameterCS csTemplateParameter) {
		return null;
	}

	@Override
	public Continuation<?> visitTemplateParameterSubstitutionCS(TemplateParameterSubstitutionCS csTemplateParameterSubstitution) {
		return null;
	}
	
	@Override
	public Continuation<?> visitTemplateSignatureCS(TemplateSignatureCS csTemplateSignature) {
		return null;
	}

	@Override
	public BasicContinuation<?> visitTypedElementCS(TypedElementCS csTypedElement) {
		TypedElement pivotElement = PivotUtil.getPivot(TypedElement.class, csTypedElement);
		context.handleVisitNamedElement(csTypedElement, pivotElement);
		TypedRefCS ownedType = csTypedElement.getOwnedType();
		Type pivotType = ownedType != null ? PivotUtil.getPivot(Type.class, ownedType) : null;
		context.setType(pivotElement, pivotType);
		context.refreshPivotList(Constraint.class, pivotElement.getOwnedRules(), csTypedElement.getOwnedConstraint());
		return null;
	}
}