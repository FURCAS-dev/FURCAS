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
 * $Id: EssentialOCLScopeProvider.java,v 1.6 2010/05/21 20:12:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.DefaultScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PreExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SquareBracketExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.util.EssentialOCLCSTSwitch;
import org.eclipse.ocl.examples.xtext.oclstdlib.scoping.OCLstdlibScopeProvider;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class EssentialOCLScopeProvider extends OCLstdlibScopeProvider
{
	static {
		AbstractScopeAdapter.addSwitch(EssentialOCLCSTPackage.eINSTANCE, new EssentialOCLScopeSwitch());
	}
	
	public static class EssentialOCLScopeSwitch
		extends EssentialOCLCSTSwitch<ScopeAdapter>
		implements ScopeAdapter.Switch
	{	
		@Override
		public ScopeAdapter caseBooleanLiteralExpCS(BooleanLiteralExpCS eObject) {
			return new BooleanLiteralExpScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseCollectionLiteralExpCS(CollectionLiteralExpCS eObject) {
			return new CollectionLiteralExpScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseInfixExpCS(InfixExpCS eObject) {
			String op = eObject.getOp();
			if (".".equals(op)) {
				return new DotExpScopeAdapter(eObject);
			}
			else if ("->".equals(op)) {
				return new ArrowExpScopeAdapter(eObject);
			}
			else {
				return new InfixExpScopeAdapter(eObject);
			}
		}

		@Override
		public ScopeAdapter caseInvalidLiteralExpCS(InvalidLiteralExpCS eObject) {
			return new InvalidLiteralExpScopeAdapter(eObject);
		}

		@Override
		public LetExpScopeAdapter caseLetExpCS(LetExpCS eObject) {
			return new LetExpScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseNestedExpCS(NestedExpCS eObject) {
			return new NestedExpScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseNullLiteralExpCS(NullLiteralExpCS eObject) {
			return new NullLiteralExpScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseNumberLiteralExpCS(NumberLiteralExpCS eObject) {
			return new NumberLiteralExpScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter casePathNameExpCS(PathNameExpCS eObject) {
			return new PathNameExpScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter casePreExpCS(PreExpCS eObject) {
			return new PreExpScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseRoundBracketExpCS(RoundBracketExpCS eObject) {
			OperatorExpCS parent = null;
			for (EObject child = eObject, cursor = child.eContainer(); cursor instanceof OperatorExpCS; child = cursor, cursor = cursor.eContainer()) {
				parent = (OperatorExpCS)cursor;
				if (parent.getSource() != child) {
					break;
				}
			}
			if (parent != null) {
				String op = parent.getOp();
				if (".".equals(op)) {
					return new DotOperationCallExpScopeAdapter(eObject);
				}
				else if ("->".equals(op)) {
					return new ArrowOperationCallExpScopeAdapter(eObject);
				}
			}
			return new DotOperationCallExpScopeAdapter(eObject);	// Implicit
		}

		@Override
		public ScopeAdapter caseSelfExpCS(SelfExpCS eObject) {
			return new SelfExpScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseSimpleNameExpCS(SimpleNameExpCS eObject) {
			return new SimpleNameExpScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseSquareBracketExpCS(SquareBracketExpCS eObject) {
			return new SquareBracketExpScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseStringLiteralExpCS(StringLiteralExpCS eObject) {
			return new StringLiteralExpScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseTupleLiteralExpCS(TupleLiteralExpCS eObject) {
			return new TupleLiteralExpScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseTupleTypeCS(TupleTypeCS eObject) {
			return new TupleTypeScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter caseVariableCS(VariableCS eObject) {
			return new VariableScopeAdapter(eObject);
		}

		@Override
		public ScopeAdapter defaultCase(EObject eObject) {
			return new DefaultScopeAdapter(eObject);
		}

		public ScopeAdapter doInPackageSwitch(EObject eObject) {
			return doSwitch(eObject.eClass(), eObject);
		}
	}
}
