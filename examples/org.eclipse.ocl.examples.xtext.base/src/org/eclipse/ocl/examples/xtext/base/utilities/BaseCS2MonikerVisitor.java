/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: BaseCS2MonikerVisitor.java,v 1.9 2011/05/11 19:32:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.Pivot2MonikerVisitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.LambdaTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SpecificationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.util.AbstractExtendingBaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;

public class BaseCS2MonikerVisitor extends AbstractExtendingBaseCSVisitor<Boolean, CS2Moniker> implements PivotConstants
{			
	private static final class Factory implements CS2Moniker.Factory
	{
		private Factory() {
			CS2Moniker.addFactory(BaseCSTPackage.eINSTANCE, this);
			Pivot2MonikerVisitor.initialize();
		}
		
		public BaseCSVisitor<?, ?> create(CS2Moniker context) {
			return new BaseCS2MonikerVisitor(context);
		}
	}

	public static CS2Moniker.Factory FACTORY = new Factory();
			
	public BaseCS2MonikerVisitor(CS2Moniker context) {
		super(context);
	}

	@Override
	public String toString() {
		return context.toString();
	}

	public Boolean visiting(VisitableCS visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for CS Moniker");
	}	

	@Override
	public Boolean visitAnnotationCS(AnnotationCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.append(ANNOTATION_QUOTE);
		context.append(String.valueOf(object.getName()));
		context.append(ANNOTATION_QUOTE);
		Object container = object.eContainer().eGet(object.eContainingFeature());
		if (container instanceof List<?>) {
			int index = 0;
			for (Object element : (List<?>)container) {
				if (element == object) {
					break;
				}
				if ((element instanceof AnnotationCS) && (((AnnotationCS)element).getName().equals(object.getName()))) {
					index++;
				}
			}
			if (index > 0) {
				context.append(index);
			}
		}
		return true;
	}

	@Override
	public Boolean visitAttributeCS(AttributeCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Boolean visitClassCSRef(ClassCSRef object) {
		context.appendElementCS(object.getRef());
		return true;
	}

	@Override
	public Boolean visitClassifierCS(ClassifierCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		context.appendTemplateParametersCS(object);
		return true;
	}

	@Override
	public Boolean visitConstraintCS(ConstraintCS csConstraint) {
		context.appendParentCS(csConstraint, MONIKER_SCOPE_SEPARATOR);
		context.append(csConstraint.getStereotype());
		context.appendConstraintCSDisambiguator(csConstraint);
		return true;
	}

	@Override
	public Boolean visitDetailCS(DetailCS object) {
		context.appendParentCS(object, BINDINGS_PREFIX);
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Boolean visitDocumentationCS(DocumentationCS object) {
		context.appendParentCS(object, "@");
		context.append(hashCode());
		return true;
	}

	@Override
	public Boolean visitEnumerationLiteralCS(EnumerationLiteralCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Boolean visitImportCS(ImportCS object) {
		context.appendNameCS(object);
		context.append(" : '");
		context.append(object.getUri());
		context.append("'");
		return true;
	}

	@Override
	public Boolean visitLambdaTypeCS(LambdaTypeCS object) {
		context.appendNameCS(object);
		context.appendTemplateParametersCS(object);
		context.append(MONIKER_OPERATOR_SEPARATOR);
		TypeRefCS contextType = object.getOwnedContextType();
		if (contextType != null) {
			context.appendElementCS(contextType);
		}
		context.append(PARAMETER_PREFIX);
		String prefix = ""; //$NON-NLS-1$
		for (TypedRefCS csParameterType : object.getOwnedParameterType()) {
			context.append(prefix);
			context.appendElementCS(csParameterType);
			prefix = PARAMETER_SEPARATOR;
		}
		context.append(PARAMETER_SUFFIX);
		TypeRefCS resultType = object.getOwnedResultType();
		if (resultType != null) {
			context.appendElementCS(resultType);
		}
		return true;
	}

	@Override
	public Boolean visitNamedElementCS(NamedElementCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Boolean visitOperationCS(OperationCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		context.appendTemplateParametersCS(object);
		context.appendParametersCS(null, null, object.getOwnedParameter());
		return true;
	}

	@Override
	public Boolean visitPackageCS(PackageCS object) {
		MonikeredElement pivot = PivotUtil.getPivot(MonikeredElement.class, object);
		assert pivot != null;
		context.append(pivot.getMoniker());
		return true;
	}

	@Override
	public Boolean visitParameterCS(ParameterCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Boolean visitPrimitiveTypeRefCS(PrimitiveTypeRefCS object) {
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Boolean visitReferenceCS(ReferenceCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		return true;
	}

	
	@Override
	public Boolean visitSpecificationCS(SpecificationCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.append(PivotPackage.Literals.CONSTRAINT__SPECIFICATION.getName());
		return true;
	}

	@Override
	public Boolean visitTemplateBindingCS(TemplateBindingCS object) {
		context.appendElementCS(object.getOwningTemplateBindableElement());
		context.append(BINDINGS_PREFIX);
		return true;
	}

	@Override
	public Boolean visitTemplateParameterCS(TemplateParameterCS object) {
//		if (!context.hasEmittedCS(object)) {
			TemplateableElementCS owningTemplateElement = object.getOwningTemplateSignature().getOwningTemplateElement();
			context.appendElementCS(owningTemplateElement);
			context.append(TEMPLATE_PARAMETER_PREFIX);
//		}
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Boolean visitTemplateParameterSubstitutionCS(TemplateParameterSubstitutionCS object) {
		context.appendElementCS(object.getOwningTemplateBinding());
		TemplateParameter formalTemplateParameter = ElementUtil.getFormalTemplateParameter(object);	
		context.append(formalTemplateParameter.getParameteredElement().getMoniker());
		return true;
	}

	@Override
	public Boolean visitTemplateSignatureCS(TemplateSignatureCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		return true;
	}

	@Override
	public Boolean visitTuplePartCS(TuplePartCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Boolean visitTupleTypeCS(TupleTypeCS object) {
		context.appendNameCS(object);
		List<TuplePartCS> parts = new ArrayList<TuplePartCS>(object.getOwnedParts());
		Collections.sort(parts, new Comparator<TuplePartCS>()
		{
			public int compare(TuplePartCS o1, TuplePartCS o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		context.append(TUPLE_SIGNATURE_PREFIX);
		String prefix = "";
		for (TuplePartCS part : parts) {
			context.append(prefix);
			context.appendNameCS(part);
			context.append(TUPLE_SIGNATURE_TYPE_SEPARATOR);
			TypeRefCS type = part.getOwnedType();
			if (type != null) {
				context.appendElementCS(type);
			}
			prefix = TUPLE_SIGNATURE_PART_SEPARATOR;
		}
		context.append(TUPLE_SIGNATURE_SUFFIX);
		return true;
	}

	@Override
	public Boolean visitTypedTypeRefCS(TypedTypeRefCS object) {
		try {
			// Operation template parameters are not resolvable until resolved
			//  so monikers involving templates are use referencing rather than resolved name. 
			String text = ElementUtil.getText(object, BaseCSTPackage.Literals.TYPED_TYPE_REF_CS__TYPE);
			TemplateParameterCS csTemplateParameter = context.getTemplateParameterCS(text);
			if (csTemplateParameter != null) { 
				if (!context.hasEmittedCS(csTemplateParameter)) {
					context.appendElementCS(csTemplateParameter);
				}
				else {
					context.appendNameCS(csTemplateParameter);
				}
			}
			else {
				Type type = object.getType();
				TemplateParameter owningTemplateParameter = type.getOwningTemplateParameter();
				if (owningTemplateParameter != null) {
					context.appendElement(type);
				}
				else {
					if (!(type instanceof PrimitiveType)) {
						context.appendParent(type, MONIKER_SCOPE_SEPARATOR);
					}
					context.appendName(type);
				}
				context.appendTemplateBindingsCS(object);
			}
		} catch (Exception e) {
			context.append(e.getMessage());
		}
		return true;
	}

	@Override
	public Boolean visitWildcardTypeRefCS(WildcardTypeRefCS object) {
		TemplateParameterSubstitutionCS csTemplateParameterSubstitution = (TemplateParameterSubstitutionCS)object.eContainer();
		TemplateBindingCS csTemplateBinding = csTemplateParameterSubstitution.getOwningTemplateBinding();
		int index = csTemplateBinding.getOwnedParameterSubstitution().indexOf(csTemplateParameterSubstitution);
		TypedTypeRefCS csTemplateBindableElement = csTemplateBinding.getOwningTemplateBindableElement();
		Type type = csTemplateBindableElement.getType();
		context.appendElement(type);
		if (!type.eIsProxy()) {
			context.append(BINDINGS_PREFIX);
			TemplateSignature ownedTemplateSignature = type.getOwnedTemplateSignature();
			if (ownedTemplateSignature != null) {
				List<TemplateParameter> templateParameters = ownedTemplateSignature.getParameters();
				if (index < templateParameters.size()) {
					TemplateParameter templateParameter = templateParameters.get(index);
					context.appendName(templateParameter.getParameteredElement());
					context.append(MONIKER_SCOPE_SEPARATOR);
				}
			}
			context.append(WILDCARD_INDICATOR + index);
		}
		return true;
	}
}
