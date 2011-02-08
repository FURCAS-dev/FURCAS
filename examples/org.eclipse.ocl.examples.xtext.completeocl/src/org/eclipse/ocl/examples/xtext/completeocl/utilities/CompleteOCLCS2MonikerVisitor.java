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
 * $Id: CompleteOCLCS2MonikerVisitor.java,v 1.3 2011/02/08 17:53:05 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.utilities;

import java.util.List;

import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2Moniker;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.util.AbstractExtendingDelegatingCompleteOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCS2MonikerVisitor;

public class CompleteOCLCS2MonikerVisitor
	extends AbstractExtendingDelegatingCompleteOCLCSVisitor<Object, CS2Moniker, EssentialOCLCSVisitor<Object, CS2Moniker>>
	implements PivotConstants
{	
	private static final class Factory implements CS2Moniker.Factory
	{
		private Factory() {
			EssentialOCLCS2MonikerVisitor.FACTORY.getClass();
			CS2Moniker.addFactory(CompleteOCLCSTPackage.eINSTANCE, this);
//			roleNames.put(CompleteOCLCSTPackage.Literals.LIB_CONSTRAINT_CS__OWNED_EXPRESSION, "z");
		}
		
		public BaseCSVisitor<?, ?> create(CS2Moniker context) {
			return new CompleteOCLCS2MonikerVisitor(context);
		}
	}

	public static CS2Moniker.Factory FACTORY = new Factory();
		
	@SuppressWarnings("unchecked")
	public CompleteOCLCS2MonikerVisitor(CS2Moniker context) {
		super((EssentialOCLCSVisitor<Object, CS2Moniker>) context.getVisitor(EssentialOCLCSTPackage.eINSTANCE), context);
	}

	@Override
	public Object visitClassifierContextDeclCS(ClassifierContextDeclCS object) {
		context.append(object.getClassifier().getMoniker());
		Object container = object.eContainer().eGet(object.eContainingFeature());
		if (container instanceof List<?>) {
			int index = 0;
			for (Object element : (List<?>)container) {
				if (element == object) {
					break;
				}
				if (element instanceof ClassifierContextDeclCS) {
					if (((ClassifierContextDeclCS)element).getClassifier() == object.getClassifier()) {
						index++;
					}
				}				
			}
			context.append(MONIKER_OPERATOR_SEPARATOR);
			context.append(index);
		}
		return true;
	}

	@Override
	public Object visitCompleteOCLDocumentCS(CompleteOCLDocumentCS object) {
		// TODO Auto-generated method stub
		return super.visitCompleteOCLDocumentCS(object);
	}

	@Override
	public Object visitContextConstraintCS(ContextConstraintCS object) {
		context.appendElement(object.getContextDecl().getPivot());
		context.append(MONIKER_SCOPE_SEPARATOR);
		context.appendConstraintCS(object);
		return true;
	}

	@Override
	public Object visitOperationContextDeclCS(OperationContextDeclCS object) {
		context.append(object.getOperation().getMoniker());
		Object container = object.eContainer().eGet(object.eContainingFeature());
		if (container instanceof List<?>) {
			int index = 0;
			for (Object element : (List<?>)container) {
				if (element == object) {
					break;
				}
				if (element instanceof OperationContextDeclCS) {
					if (((OperationContextDeclCS)element).getOperation() == object.getOperation()) {
						index++;
					}
				}				
			}
			context.append(MONIKER_OPERATOR_SEPARATOR);
			context.append(index);
		}
		return true;
	}

	@Override
	public Object visitPackageDeclarationCS(PackageDeclarationCS object) {
		context.append(object.getPackage().getMoniker());
		Object container = object.eContainer().eGet(object.eContainingFeature());
		if (container instanceof List<?>) {
			int index = 0;
			for (Object element : (List<?>)container) {
				if (element == object) {
					break;
				}
				if (element instanceof PackageDeclarationCS) {
					if (((PackageDeclarationCS)element).getPackage() == object.getPackage()) {
						index++;
					}
				}				
			}
			context.append(MONIKER_OPERATOR_SEPARATOR);
			context.append(index);
		}
		return true;
	}

	@Override
	public Object visitPropertyContextDeclCS(PropertyContextDeclCS object) {
		context.append(object.getProperty().getMoniker());
		Object container = object.eContainer().eGet(object.eContainingFeature());
		if (container instanceof List<?>) {
			int index = 0;
			for (Object element : (List<?>)container) {
				if (element == object) {
					break;
				}
				if (element instanceof PropertyContextDeclCS) {
					if (((PropertyContextDeclCS)element).getProperty() == object.getProperty()) {
						index++;
					}
				}				
			}
			context.append(MONIKER_OPERATOR_SEPARATOR);
			context.append(index);
		}
		return true;
	}
}
