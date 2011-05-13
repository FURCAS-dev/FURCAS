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
 * $Id: EssentialOCLCS2Pivot.java,v 1.9 2011/05/13 18:48:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.ClassifierType;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BaseCS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
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
			String argumentText = null;
			ExpCS navigationArgument = null;
			if (context.eContainer() instanceof NavigatingExpCS) {
				NavigatingExpCS eContainer = (NavigatingExpCS)context.eContainer();
				navigationArgument = eContainer;
				List<NavigatingArgCS> arguments = eContainer.getArgument();
				if (arguments.size() <= 0) {
					messageTemplate = OCLMessages.UnresolvedOperation_ERROR_;
				}
				else {
					StringBuffer s = new StringBuffer();
					for (NavigatingArgCS csArgument : arguments) {
						TypedElement pivot = PivotUtil.getPivot(TypedElement.class, csArgument);
						if ((pivot != null) && !pivot.eIsProxy()) {
							Type type = pivot.getType();
							if (pivot instanceof TypedMultiplicityElement) {
								TypedMultiplicityElement typedMultiplicityElement = (TypedMultiplicityElement)pivot;
								if (typedMultiplicityElement.isOrdered()) {
									if (typedMultiplicityElement.isUnique()) {
										s.append("OrderedSet<");
									}
									else {
										s.append("Sequence<");
									}
								}
								else {
									if (typedMultiplicityElement.isUnique()) {
										s.append("Set<");
									}
									else {
										s.append("Bag<");
									}
								}
								s.append(String.valueOf(type));
								s.append(">");
								BigInteger lower = typedMultiplicityElement.getLower();
								BigInteger upper = typedMultiplicityElement.getUpper();
								PivotUtil.appendMultiplicity(s, lower.intValue(), upper.intValue());
							}
							else {
								s.append(String.valueOf(type));
							}
						}
						else {
							s.append(csArgument.toString());
						}
					}
					argumentText = s.toString();
					messageTemplate = OCLMessages.UnresolvedOperationCall_ERROR_;
				}
			}
			else if (context instanceof ExpCS) {
				navigationArgument = (ExpCS)context;
				messageTemplate = OCLMessages.UnresolvedProperty_ERROR_;
			}
			else {
				messageTemplate = "Unknown unresolved context";
			}
			String typeText = PivotConstants.UNKNOWN_TYPE_TEXT;
			ExpCS csSource = navigationArgument;
			while (csSource != null) {
				OperatorCS csOperator = csSource.getParent();
				if ((csOperator != null) && (csOperator.getSource() != csSource)) {
					csSource = csOperator.getSource();
					break;
				}
				EObject eContainer = csSource.eContainer();
				if (eContainer instanceof NavigatingArgCS) {
					csSource = ((NavigatingArgCS)eContainer).getNavigatingExp();
				}
				else {
					break;
				}
			}
			if ((csSource != null) && (csSource != navigationArgument)) {
				OclExpression source = PivotUtil.getPivot(OclExpression.class, csSource);
				if (source != null) {
					Type sourceType = source.getType();
					if (sourceType instanceof ClassifierType) {
						sourceType = ((ClassifierType)sourceType).getInstanceType();
						if (sourceType != null) {
							typeText = sourceType.toString() + " type";
						}
					}
					else {
						if (sourceType != null) {
							typeText = sourceType.toString() + " value";
						}
					}
				}
			}
			if (argumentText == null) {
				return NLS.bind(messageTemplate, linkText, typeText);
			}
			else {
				return NLS.bind(messageTemplate, new Object[]{linkText, typeText, argumentText});
			}
		}
	}
		
	public EssentialOCLCS2Pivot(Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, TypeManager typeManager) {
		super(cs2pivotResourceMap, typeManager);
	}
}