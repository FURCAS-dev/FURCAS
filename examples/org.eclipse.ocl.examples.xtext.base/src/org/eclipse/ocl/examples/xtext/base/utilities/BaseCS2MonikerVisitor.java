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
 * $Id: BaseCS2MonikerVisitor.java,v 1.5 2011/02/15 10:36:55 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.AliasAdapter;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.LambdaTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
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
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedTypeRefCSImpl;
import org.eclipse.ocl.examples.xtext.base.scope.RootCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.util.AbstractExtendingBaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;

public class BaseCS2MonikerVisitor extends AbstractExtendingBaseCSVisitor<Object, CS2Moniker> implements PivotConstants
{			
	private static final Logger logger = Logger.getLogger(BaseCS2MonikerVisitor.class);

	private static final class Factory implements CS2Moniker.Factory
	{
		private Factory() {
			CS2Moniker.addFactory(BaseCSTPackage.eINSTANCE, this);
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

	public Object visiting(VisitableCS visitable) {
		logger.error("Unsupported " + visitable.eClass().getName() + " for " + getClass().getName());
		return null;
	}	

	@Override
	public Object visitAnnotationCS(AnnotationCS object) {
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
	public Object visitAttributeCS(AttributeCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Object visitAttributeCSRef(AttributeCSRef object) {
		context.appendElementCS(object.getRef());
		return true;
	}

	@Override
	public Object visitClassCSRef(ClassCSRef object) {
		context.appendElementCS(object.getRef());
		return true;
	}

	@Override
	public Object visitClassifierCS(ClassifierCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		context.appendTemplateParametersCS(object);
		return true;
	}

	@Override
	public Object visitConstraintCS(ConstraintCS csConstraint) {
		context.appendParentCS(csConstraint, MONIKER_SCOPE_SEPARATOR);
		context.appendConstraintCS(csConstraint);
		return true;
	}

	@Override
	public Object visitDetailCS(DetailCS object) {
		context.appendParentCS(object, BINDINGS_PREFIX);
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Object visitDocumentationCS(DocumentationCS object) {
		context.appendParentCS(object, "@");
		context.append(hashCode());
		return true;
	}

	@Override
	public Object visitEnumerationLiteralCS(EnumerationLiteralCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Object visitImportCS(ImportCS object) {
		context.appendNameCS(object);
		context.append(" : '");
		context.append(object.getUri());
		context.append("'");
		return true;
	}

	@Override
	public Object visitLambdaTypeCS(LambdaTypeCS object) {
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
	public Object visitModelElementCSRef(ModelElementCSRef object) {
		context.appendElementCS(object.getRef());
		return true;
	}

	@Override
	public Object visitNamedElementCS(NamedElementCS object) {
		context.appendParentCS(object, MONIKER_OPERATOR_SEPARATOR);
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Object visitOperationCS(OperationCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		context.appendTemplateParametersCS(object);
		context.appendParametersCS(null, null, object.getOwnedParameter());
		return true;
	}

	@Override
	public Object visitPackageCS(PackageCS object) {
		String alias = AliasAdapter.getAlias(object);
		if (alias != null) {
			return alias;
		}
		ScopeCSAdapter scopeAdapter = ElementUtil.getScopeCSAdapter(object);
		RootCSScopeAdapter documentScopeAdapter = scopeAdapter.getRootScopeAdapter();
		if (documentScopeAdapter != null) {
			alias = documentScopeAdapter.getAlias(object);
			if (alias != null) {
				context.append(alias);
				return true;
			}
		}
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Object visitParameterCS(ParameterCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Object visitPrimitiveTypeRefCS(PrimitiveTypeRefCS object) {
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Object visitReferenceCS(ReferenceCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Object visitReferenceCSRef(ReferenceCSRef object) {
		context.appendElement(object.getRef());
		return true;
	}

	@Override
	public Object visitRootPackageCS(RootPackageCS object) {
		String alias = AliasAdapter.getAlias(object);
		if (alias != null) {
			return alias;
		}
		ScopeCSAdapter scopeAdapter = ElementUtil.getScopeCSAdapter(object);
		RootCSScopeAdapter documentScopeAdapter = scopeAdapter.getRootScopeAdapter();
		if (documentScopeAdapter != null) {
			alias = documentScopeAdapter.getAlias(object);
			if (alias != null) {
				context.append(alias);
				return true;
			}
		}
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Object visitTemplateBindingCS(TemplateBindingCS object) {
		context.appendElementCS(object.getOwningTemplateBindableElement());
		context.append(BINDINGS_PREFIX);
		return true;
	}

	@Override
	public Object visitTemplateParameterCS(TemplateParameterCS object) {
//		if (!context.hasEmittedCS(object)) {
			TemplateableElementCS owningTemplateElement = object.getOwningTemplateSignature().getOwningTemplateElement();
			context.appendElementCS(owningTemplateElement);
			context.append(TEMPLATE_PARAMETER_PREFIX);
//		}
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Object visitTemplateParameterSubstitutionCS(TemplateParameterSubstitutionCS object) {
		context.appendElementCS(object.getOwningTemplateBinding());
		TemplateParameter formalTemplateParameter = ElementUtil.getFormalTemplateParameter(object);	
		context.append(formalTemplateParameter.getParameteredElement().getMoniker());
		return true;
	}

	@Override
	public Object visitTemplateSignatureCS(TemplateSignatureCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		return true;
	}

	@Override
	public Object visitTuplePartCS(TuplePartCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		return true;
	}

	@Override
	public Object visitTupleTypeCS(TupleTypeCS object) {
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
	public Object visitTypedTypeRefCS(TypedTypeRefCS object) {
//		assert object != context.getTarget();	// Should only be invoked for child objects
//		int oldBindings = context.pushBindings(object);
		try {
			TemplateParameterCS csTemplateParameter = null;
			Type type = ((TypedTypeRefCSImpl)object).basicGetType();
			if (type.eIsProxy()) {	// Operation Template Parameters are cyclically unresolveable
				String text = getTemplateParameterName(object);
				csTemplateParameter = context.getTemplateParameterCS(text);
				if (csTemplateParameter == null) {
					type = object.getType();
//					if (type.eIsProxy()) {	// FIXME Just testing
//						type = object.getType();
//					}
				}
			}
			TemplateParameter owningTemplateParameter = type.getOwningTemplateParameter();
			if (csTemplateParameter == null) {
//				type = object.getType();
//				if (type.eIsProxy()) {	// FIXME Just testing
//					type = object.getType();
//				}
				if (!type.hasMoniker() && (owningTemplateParameter != null)) {
					String text = getTemplateParameterName(object);
					csTemplateParameter = context.getTemplateParameterCS(text);
				}
			}
			if (csTemplateParameter != null) {
				if (!context.hasEmittedCS(csTemplateParameter)) {
					context.appendElementCS(csTemplateParameter);
				}
				else {
					context.appendNameCS(csTemplateParameter);
				}
			}
			else if (owningTemplateParameter != null) {
				context.appendElement(type);
			}
			else {
				if (!(type instanceof PrimitiveType)) {
					context.appendParent(type, MONIKER_SCOPE_SEPARATOR);
				}
				context.appendName(type);
			}
			context.appendTemplateBindingsCS(object);
/*			if (object.getOwnedTemplateBinding() != null) {
				
			}
			type = object.getType();
//			if (type.eIsProxy()) {	// FIXME Just testing
//				type = object.getType();
//			}
			if (!type.hasMoniker() && (type.eContainer() instanceof TemplateParameter)) {
				String text = ElementCSScopeAdapter.getText(object);
				TemplateParameterCS csTemplateParameter = context.getTemplateParameter(text);
				if (csTemplateParameter != null) {
//					context.appendElement(csTemplateParameter);
					context.appendName(csTemplateParameter);
					return true;
				}
			}
//			if (object.getOwnedTemplateBinding() == null) {
				context.append(type.getMoniker());
//			}
//			else {
//				context.append(((MonikeredElement) type.eContainer()).getMoniker());
//				context.append(SCOPE_SEPARATOR);
//				context.append(type.getName());
//				context.appendTemplateBindings(object);
//			} */
		} catch (Exception e) {
			context.append(e.getMessage());
		} finally {
//			context.popBindings(oldBindings);
		}
		return true;
	}

	protected String getTemplateParameterName(TypedTypeRefCS csElement) {
		String text = ElementUtil.getText(csElement);
		TemplateBindingCS csTemplateBinding = csElement.getOwnedTemplateBinding();
		if (csTemplateBinding != null) {
			String text2 = ElementUtil.getText(csTemplateBinding);
			int index = text.indexOf(text2);
			if (index >= 0) {
				text = text.substring(0, index);
			}
		}
		return text;
	}

	@Override
	public Object visitWildcardTypeRefCS(WildcardTypeRefCS object) {
		TemplateParameterSubstitutionCS csTemplateParameterSubstitution = (TemplateParameterSubstitutionCS)object.eContainer();
		TemplateBindingCS csTemplateBinding = csTemplateParameterSubstitution.getOwningTemplateBinding();
		int index = csTemplateBinding.getOwnedParameterSubstitution().indexOf(csTemplateParameterSubstitution);
		TypedTypeRefCS csTemplateBindableElement = csTemplateBinding.getOwningTemplateBindableElement();
		Type type = csTemplateBindableElement.getType();
		TemplateSignature ownedTemplateSignature = type.getOwnedTemplateSignature();
		context.appendElement(type);
		context.append(BINDINGS_PREFIX);
		List<TemplateParameter> templateParameters = ownedTemplateSignature.getParameters();
		if (index < templateParameters.size()) {
			TemplateParameter templateParameter = templateParameters.get(index);
			context.appendName(templateParameter.getParameteredElement());
			context.append(MONIKER_SCOPE_SEPARATOR);
		}
		context.append(WILDCARD_INDICATOR + index);
		return true;
	}
}
