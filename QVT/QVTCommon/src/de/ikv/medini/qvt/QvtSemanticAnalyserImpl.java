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

package de.ikv.medini.qvt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserImpl;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.syntax.ast.Visitor;
import org.oslo.ocl20.syntax.ast.qvt.TopLevelAS;

import uk.ac.kent.cs.kmf.util.ILog;
import uk.ac.kent.cs.kmf.util.OutputStreamLog;

/**
 * The QVT semantic analyser builds an AST from the CST produced by the parser.
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */
public class QvtSemanticAnalyserImpl extends OclSemanticAnalyserImpl {
	// TODO TODOMWA create interface !! implements QvtSemanticAnalyser

	public QvtSemanticAnalyserImpl(QvtProcessorImpl proc, Visitor semanticAnalyzerVisitor, SemanticsVisitor debugVisitor, ILog log) {
		super(proc, semanticAnalyzerVisitor, debugVisitor, log);
		this.processor = proc;
	}

	protected QvtProcessorImpl processor;

	public List analyseQvt(TopLevelAS decl) {
		Environment env = this.processor.getBridgeFactory().buildEnvironment();
		return this.analyseQvt(decl, env);
	}

	public List analyseQvt(TopLevelAS decl, Environment env) {
		ILog log = new OutputStreamLog(System.out);
		return this.analyseQvt(decl, env, log);
	}

	public List analyseQvt(TopLevelAS decl, Environment env, ILog log) {
		return this.analyseQvt(decl, env, log, false);
	}

	public List analyseQvt(TopLevelAS decl, Environment env, ILog log, boolean debugFlag) {
		((QvtSemanticAnalyserVisitorImpl) this.semanticAnalyzerVisitor).clearAstMap();
		// --- Store the no of errors ---
		int errNo = log.getErrors();

		Map context = new HashMap();
		context.put("env", env);
		context.put("log", log);
		context.put("templateToDomainMap", new HashMap());
		context.put("resolvableMap", new HashMap()); // per relation

		List l = (List) decl.accept(this.semanticAnalyzerVisitor, context);

		// --- Set hasErrors flag --
		this.hasErrors = log.getErrors() > errNo && !log.tooManyViolations();
		return l;
	}
}
