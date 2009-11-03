/* 
 * Copyright (c) 2007 IKV++ Technologies AG
 * All rights reserved.
 */

package org.oslo.ocl20.syntax.parser;

import java.util.Stack;

import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;
import java_cup.runtime.lr_parser;

import org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl;


public class YyparseWithSourceTracking extends Yyparse {

	public YyparseWithSourceTracking(Yylex yylex) {
		super(yylex);
		OclSemanticAnalyserVisitorImpl.clearSymbolMap();
	}
	
	public YyparseWithSourceTracking(Yylex yylex, SymbolFactory factory) {
		super(yylex,factory);
		OclSemanticAnalyserVisitorImpl.clearSymbolMap();
	}

	public Symbol do_action(int act_num, lr_parser parser, Stack stack, int top) throws Exception {
		Symbol result = super.do_action(act_num, parser, stack, top);
		OclSemanticAnalyserVisitorImpl.putSymbol(result);
		return result;
	}

}
