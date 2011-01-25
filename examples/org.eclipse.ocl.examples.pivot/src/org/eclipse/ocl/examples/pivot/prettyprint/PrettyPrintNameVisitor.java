/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PrettyPrintNameVisitor.java,v 1.2 2011/01/24 20:47:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.prettyprint;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;

/**
 */
public class PrettyPrintNameVisitor extends AbstractExtendingVisitor<Object,Namespace>
{	
	public static Namespace getNamespace(EObject element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Class) {
				return (Namespace) eObject;
			}
			if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
				return (Namespace) eObject;
			}
		}
		return null;
	}

	public static String prettyPrint(Visitable element, Namespace scope) {
		PrettyPrintNameVisitor visitor = new PrettyPrintNameVisitor(scope);
		try {
			visitor.safeVisit(element);
			return visitor.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
			return visitor.toString() + " ... " + e.getClass().getName() + " - " + e.getLocalizedMessage();
		}
	}

	public static class Printer
	{
		public Printer() {}
		
		public String prettyPrint(Visitable element, Namespace scope) {
			PrettyPrintNameVisitor visitor = new PrettyPrintNameVisitor(scope);
			try {
				visitor.safeVisit(element);
				return visitor.toString();
			}
			catch (Exception e) {
				e.printStackTrace();
				return visitor.toString() + " ... " + e.getClass().getName() + " - " + e.getLocalizedMessage();
			}
		}
	}
	
	protected final PrettyPrintTypeVisitor delegate;
	protected final TypeManager typeManager;
	
	/**
	 * Initializes me.
	 */
	public PrettyPrintNameVisitor(Namespace scope) {
		super(scope);
		delegate = new PrettyPrintTypeVisitor(scope);
		Resource resource = scope != null ? scope.eResource() : null;
		ResourceSet resourceSet = resource !=  null ? resource.getResourceSet() : null;
		typeManager = TypeManager.getAdapter(resourceSet);
	}

	@Override
	public String toString() {
		return delegate.toString();
	}

	@Override
	public Object visitClass(Class object) {
		TemplateParameter owningTemplateParameter = object.getOwningTemplateParameter();
		if (owningTemplateParameter != null) {
			return owningTemplateParameter.accept(this);
		}
		return super.visitClass(object);
	}

	@Override
	public String visitNamedElement(NamedElement object) {
		delegate.appendParent(null, object, "::");
		delegate.appendName(object);
		return null;
	}

	@Override
	public Object visitOperation(Operation object) {
		delegate.appendParent(null, object, "::");
		delegate.appendName(object);
		delegate.appendTemplateParameters(object);
		delegate.appendTemplateBindings(object);
		delegate.appendParameters(object);
		Type type = object.getType();
		if (type != null) {
			delegate.append(" : ");
			delegate.appendElement(type);
		}
		return null;
	}

	@Override
	public Object visitTemplateParameter(TemplateParameter object) {
		delegate.appendParent(null, object.getSignature(), "::");
		delegate.appendName((NamedElement) object.getParameteredElement());
		return null;
	}

	@Override
	public Object visitTupleType(TupleType object) {
		delegate.appendParent(object.eContainer(), object, "::");
		delegate.appendName(object);
		delegate.append("(");
		List<Property> tupleParts = object.getOwnedAttributes();
		if (!tupleParts.isEmpty()) {
			String prefix = ""; //$NON-NLS-1$
			for (Property tuplePart : tupleParts) {
				delegate.append(prefix);
				delegate.appendElement(tuplePart);
				prefix = ",";
			}
		}
		delegate.append(")");
		return null;
	}

	@Override
	public Object visitType(Type object) {
		delegate.appendParent(null, object, "::");
		delegate.appendName(object);
		delegate.appendTemplateParameters(object);
		delegate.appendTemplateBindings(object);
		return null;
	}

	@Override
	public Object visitTypedElement(TypedElement object) {
		delegate.appendParent(null, object, "::");
		delegate.appendName(object);
		delegate.append(" : ");
		delegate.appendElement(object.getType());
		return null;
	}

	public String visiting(Visitable visitable) {
		delegate.visiting(visitable);
		return null;
	}
}
