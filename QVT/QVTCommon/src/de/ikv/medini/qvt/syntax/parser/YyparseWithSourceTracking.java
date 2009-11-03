/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.qvt.syntax.parser;

import java.util.Stack;

import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;
import java_cup.runtime.lr_parser;

import org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl;
import org.oslo.ocl20.syntax.ast.qvt.RelationAS;

public class YyparseWithSourceTracking extends Yyparse {

	public YyparseWithSourceTracking(Yylex yylex) {
		super(yylex);
		OclSemanticAnalyserVisitorImpl.clearSymbolMap();
	}

	public YyparseWithSourceTracking(Yylex yylex, SymbolFactory factory) {
		super(yylex, factory);
		OclSemanticAnalyserVisitorImpl.clearSymbolMap();
	}

	public Symbol do_action(int act_num, lr_parser parser, Stack stack, int top) throws Exception {
		Symbol result = super.do_action(act_num, parser, stack, top);
		if (result.value instanceof RelationAS) {
			RelationAS RESULT = (RelationAS) result.value;
			/**
			 * stack.elementAt(top-9) is the "top" keyword. stack.elementAt(top-8) is the "relation" keyword. If "top" is not set, take "relation" to be the start for the relation.
			 */
			if (!RESULT.getIsTopLevel().booleanValue()) {
				result = parser.getSymbolFactory().newSymbol("relation", result.sym, ((java_cup.runtime.Symbol) stack.elementAt(top - 8)), ((java_cup.runtime.Symbol) stack.peek()), RESULT);
			}
		}

		OclSemanticAnalyserVisitorImpl.putSymbol(result);
		return result;
	}

}
