/**
 * Kent Modelling Framework
 * Copyright (C) 2002 University of Kent at Canterbury, UK 
 * Visit www.cs.ukc.ac.uk/kmf
 *
 */

package org.oslo.ocl20.semantics.analyser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java_cup.runtime.Symbol;

import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.semantics.SemanticsVisitable;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.syntax.ast.Visitor;
import org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS;
import org.oslo.ocl20.syntax.parser.ErrorManager;

import uk.ac.kent.cs.kmf.util.ILog;
import uk.ac.kent.cs.kmf.util.OutputStreamLog;

public class OclSemanticAnalyserImpl implements OclSemanticAnalyser {
	public OclSemanticAnalyserImpl(OclProcessor proc, Visitor semanticAnalyzerVisitor, SemanticsVisitor debugVisitor, ILog log) {
		this.processor = proc;
		this.semanticAnalyzerVisitor = semanticAnalyzerVisitor;
		this.debugVisitor = debugVisitor;
		this.log = log;
	}

	protected OclProcessor processor;

	protected Visitor semanticAnalyzerVisitor;

	protected SemanticsVisitor debugVisitor = null;

	protected ILog log;

	public List analyse(PackageDeclarationAS decl) {
		Environment env = this.processor.getBridgeFactory().buildEnvironment();
		ILog log = new OutputStreamLog(System.out);
		return this.analyse(decl, env);
	}

	public List analyse(PackageDeclarationAS decl, Environment env) {
		ILog log = new OutputStreamLog(System.out);
		return this.analyse(decl, env, log);
	}

	public List analyse(PackageDeclarationAS decl, Environment env, ILog log) {
		return this.analyse(decl, env, log, false);
	}

	public List analyse(PackageDeclarationAS decl, Environment env, ILog log, boolean debugFlag) {
		((OclSemanticAnalyserVisitorImpl) this.semanticAnalyzerVisitor).clearAstMap();
		// --- Store the no of errors ---
		int errNo = log.getErrors();

		Map context = new HashMap();
		context.put("env", env);
		context.put("log", log);
		List l = (List) decl.accept(this.semanticAnalyzerVisitor, context);

		// --- Set hasErrors flag --
		this.hasErrors = log.getErrors() > errNo && !log.tooManyViolations();

		return l;
	}

	protected boolean hasErrors;

	public boolean hasErrors() {
		return this.hasErrors;
	}

	public String getMessage(String message, SemanticsVisitable ast) {
		return new String(ErrorManager.getMessage(message, ((OclSemanticAnalyserVisitorImpl) this.semanticAnalyzerVisitor).getSymbol(ast)));
	}

	public int getBeginColumn(SemanticsVisitable host) {
		return ((OclSemanticAnalyserVisitorImpl) this.semanticAnalyzerVisitor).getBeginColumn(host);
	}

	public int getBeginLine(SemanticsVisitable host) {
		return ((OclSemanticAnalyserVisitorImpl) this.semanticAnalyzerVisitor).getBeginLine(host);
	}

	public int getEndColumn(SemanticsVisitable host) {
		return ((OclSemanticAnalyserVisitorImpl) this.semanticAnalyzerVisitor).getEndColumn(host);
	}

	public int getEndLine(SemanticsVisitable host) {
		return ((OclSemanticAnalyserVisitorImpl) this.semanticAnalyzerVisitor).getEndLine(host);
	}

	public Symbol getSymbol(SemanticsVisitable object) {
		return ((OclSemanticAnalyserVisitorImpl) this.semanticAnalyzerVisitor).getSymbol(object);
	}

	public Map getAstMap() {
		return ((OclSemanticAnalyserVisitorImpl) this.semanticAnalyzerVisitor).getAstMap();
	}

	public void setAstMap(Map value) {
		((OclSemanticAnalyserVisitorImpl) this.semanticAnalyzerVisitor).setAstMap(value);
	}
}
