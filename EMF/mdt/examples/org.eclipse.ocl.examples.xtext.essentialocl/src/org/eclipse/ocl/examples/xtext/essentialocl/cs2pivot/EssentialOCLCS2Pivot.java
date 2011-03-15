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
 * $Id: EssentialOCLCS2Pivot.java,v 1.4 2011/03/08 15:14:56 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BaseCS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS;
import org.eclipse.osgi.util.NLS;

public class EssentialOCLCS2Pivot extends BaseCS2Pivot
{	
	private static final class Factory implements CS2Pivot.Factory
	{
		private Factory() {
			BaseCS2Pivot.FACTORY.getClass();
			addFactory(this);
			addUnresolvedProxyMessageProvider(new NameExpCSUnresolvedProxyMessageProvider());			
		}

		public EssentialOCLLeft2RightVisitor createLeft2RightVisitor(CS2PivotConversion converter) {
			return new EssentialOCLLeft2RightVisitor(converter);
		}

		public EssentialOCLPostOrderVisitor createPostOrderVisitor(CS2PivotConversion converter) {
			return new EssentialOCLPostOrderVisitor(converter);
		}

		public EssentialOCLPreOrderVisitor createPreOrderVisitor(CS2PivotConversion converter) {
			return new EssentialOCLPreOrderVisitor(converter);
		}

		public BaseCSVisitor<ScopeCSAdapter, TypeManager> createScopeVisitor(TypeManager typeManager) {
			return new EssentialOCLScopeVisitor(typeManager);
		}

		public EPackage getEPackage() {
			return EssentialOCLCSTPackage.eINSTANCE;
		}
	}

	public static CS2Pivot.Factory FACTORY = new Factory();
	
	private static final class NameExpCSUnresolvedProxyMessageProvider extends UnresolvedProxyMessageProvider
	{		
		private NameExpCSUnresolvedProxyMessageProvider() {
			super(EssentialOCLCSTPackage.Literals.NAME_EXP_CS__ELEMENT);
		}
		
		@Override
		public String getMessage(EObject context, String linkText) {
			String messageTemplate;
			ExpCS navigationArgument = null;
			if (context.eContainer() instanceof NavigatingExpCS) {
				navigationArgument = (NavigatingExpCS)context.eContainer();
				messageTemplate = OCLMessages.UnresolvedOperation_ERROR_;
			}
			else if (context instanceof ExpCS) {
				navigationArgument = (ExpCS)context;
				messageTemplate = OCLMessages.UnresolvedProperty_ERROR_;
			}
			else {
				messageTemplate = "Unknown unresolved context";
			}
			String typeText = "Unknown type";
			OperatorCS csOperator = navigationArgument != null ? navigationArgument.getParent() : null;
			if ((csOperator != null) && (csOperator.getSource() != navigationArgument)) {
//				NavigationOperatorCS csNavigationOperator = (NavigationOperatorCS)csOperator;
				OclExpression source = PivotUtil.getPivot(OclExpression.class, csOperator.getSource());
				if (source != null) {
					Type sourceType;
					if (source instanceof TypeExp) {			// FIXME regularize this
						sourceType = ((TypeExp)source).getReferredType();
					}
					else {
						sourceType = source.getType();
					}
					if (sourceType != null) {
						typeText = sourceType.toString();
					}
				}
			}
			return NLS.bind(messageTemplate, linkText, typeText);
		}
	}
		
	public EssentialOCLCS2Pivot(Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, TypeManager typeManager) {
		super(cs2pivotResourceMap, typeManager);
	}
}