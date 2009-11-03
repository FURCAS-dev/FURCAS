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

import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.oslo.ocl20.OclProcessorImpl;
import org.oslo.ocl20.semantics.SemanticsVisitable;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.semantics.model.contexts.ContextDeclaration;
import org.oslo.ocl20.semantics.model.expressions.OperationCallExp;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.types.CollectionType;
import org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.TopLevelAS;
import org.oslo.ocl20.syntax.ast.qvt.TransformationAS;
import org.oslo.ocl20.syntax.parser.ErrorManager;
import org.oslo.ocl20.synthesis.RuntimeEnvironment;

import uk.ac.kent.cs.kmf.util.ILog;
import de.ikv.medini.qvt.execution.Query;
import de.ikv.medini.qvt.execution.QueryImpl;
import de.ikv.medini.qvt.execution.QvtSemanticAnalyserThreadPool;
import de.ikv.medini.qvt.execution.debug.DebugAdapterImpl;
import de.ikv.medini.qvt.execution.debug.IDebugAdapter;
import de.ikv.medini.qvt.execution.debug.QVTExitDebugSessionException;
import de.ikv.medini.qvt.model.qvtbase.Rule;
import de.ikv.medini.qvt.model.qvtbase.Transformation;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationCallExp;
import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem;
import de.ikv.medini.qvt.syntax.parser.QvtParser;
import de.ikv.medini.qvt.syntax.parser.QvtParserImpl;
import de.ikv.medini.qvt.util.QvtSemanticTaskDebugInfo;

/**
 * An abstract QVT processor for parsing, analysing and evaluating QVT scripts. It can be configured with a set of properties using the {@link #setProperties(Properties)} and
 * {@link #setProperty(String, String)} methods. The possible properties and their values are specified in {@link QVTProcessorConsts}.
 * <p>
 * The processor uses a {@link QvtParser} for parsing qvt scripts, a {@link QvtSemanticAnalyserImpl} for analysing the CST created by the parser and a {@link QvtEvaluatorImpl} for
 * evaluating the AST created by the analyser. For manipulating models, a {@link QvtModelManipulationAdapter} is used. Traces are handled by a {@link QvtTraceAdapter}.
 * <p>
 * Note that the processor's analyse() and evaluate() methods can always throw a {@link RuntimeException}, although this is not usually explicitly declared.
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */
public abstract class QvtProcessorImpl extends OclProcessorImpl {

	/**
	 * Maps a {@link Transformation} instance to its full source file path
	 */
	private Map transformationToPath;

	/**
	 * Requires that where clauses binding variables must evaluate to true, otherwise the evalutation stops
	 */
	private static final boolean requireBindingWhereClausesToBeTrue = true;

	/**
	 * The QVT parser used for parsing QVT scripts.
	 */
	private QvtParser qvtParser;

	/**
	 * The properties used to configure the processor..
	 */
	private Properties properties = new Properties();

	/**
	 * The index of the target model. This value must be non-negative.
	 */
	private int targetModelIndex = -1;

	/**
	 * Flag determining whether the processor is running in debug mode or not.
	 */
	private boolean debugMode = false;

	/**
	 * Flag determining whether the QVT transformation is debugged from outside.
	 */
	// private boolean debugTransformation = false;
	/**
	 * Maps relations to a list of 'when' domain statements.
	 */
	private Map relationToOrderedWhenClausesMap;

	/**
	 * Maps relations to a list of 'where' domain statements.
	 */
	private Map relationToOrderedWhereClausesMap;

	/**
	 * Maps a calling relation to a collection of all relation called by it.
	 */
	private Map callerToCalled;

	/**
	 * List of <code>Relation</code> instances which are called from other relations
	 */
	private Set allCalledRelations;

	/**
	 * List of <code>Relation</code> instances which are called from other relations in a NOT expression
	 */
	private Set allCalledRelationsByNot;

	/**
	 * All RelationCallExp instances of the transformation
	 */
	private Set allRelationCalls;

	/**
	 * The execution direction of a transformation. This value is expected to be set throught a call to
	 * {@link #evaluateQVT(Reader, String, boolean, String, Object[], Collection, ILog)}.
	 */
	private String direction;

	private QvtTraceAdapter qvtTraceAdapter;

	/**
	 * Maps a clause to a list of <code>VariableDeclaration</code> instances which it binds or to <code>null</code> if it binds no variables at all.
	 */
	private HashMap bindingClauses;

	/**
	 * Maps a <code>VariableDeclaration</code> to the clause it binds.
	 */
	private HashMap bindingClausesReverse;

	private IDebugAdapter debugAdapter;

	/**
	 * The transformation direction
	 */
	private TypedModel targetTypedModel;

	/**
	 * List of {@link ContextDeclaration} instances
	 */
	private List contextDeclarations;

	private boolean randomMode;

	private int randomSize;

	private boolean parsingMode;

	/**
	 * Tells whether target domain variables shall be visible in when clauses (if not bound by a relation call)
	 */
	private boolean cleanMode;

	/**
	 * Evaluation of separate OCL expressions can have a transformation context set, so that the OCL expression may refer to relations/queries of this transformation.
	 */
	private Transformation transformationContext;

	/**
	 * Evaluation of separate OCL expressions can have a transformation context set, so that the OCL expression may refer to relations/queries of this transformation using this
	 * transformation direction.
	 */
	private TypedModel directionContext;

	/**
	 * Creates a QVT processor which uses the given <code>log</code> for output.
	 * 
	 * @param log
	 *            the processor's log.
	 */
	public QvtProcessorImpl(ILog log) {
		super(log);
	}

	/**
	 * This method simply calls <code>parseQvt(qvtScript, getLog(), false)</code>.
	 * 
	 * @param qvtScript
	 *            the QVT script to parse.
	 * @see #parseQvt(Reader, ILog)
	 */
	public TopLevelAS parseQvt(String qvtScript) {
		return this.parseQvt(qvtScript, this.getLog(), false);
	}

	/**
	 * This method simply calls <code>parseQvt(qvtScript, log, false)</code>.
	 * 
	 * @param qvtScript
	 *            the QVT script to parse.
	 * @param log
	 *            the log for sending output.
	 * @return the value returned by the delegated method.
	 * @see #parseQvt(String, ILog, boolean)
	 */
	public TopLevelAS parseQvt(String qvtScript, ILog log) {
		return this.parseQvt(qvtScript, log, false);
	}

	/**
	 * Parses the given <code>qvtCode</code> and returns the corresponding AST. Output goes to the given log. It is equivalent to <code>parseQvt(qvtCode, log, false)</code>.
	 * 
	 * @param qvtScript
	 *            the QVT code to parse.
	 * @param log
	 *            the log for sending output.
	 * @param debug
	 *            <code>true</code> to log out debug information, <code>false</code> otherwise.
	 * @return the CST of the QVT script or <code>null</code> if an error occured.
	 * @see #analyseQvt(String, ILog)
	 * @see #analyseQvt(TopLevelAS)
	 */
	public TopLevelAS parseQvt(String qvtScript, ILog log, boolean debug) {
		log.resetErrors();
		TopLevelAS pd = this.getQvtParser().parse(new StringReader(qvtScript), log, debug);
		if (log.hasErrors()) {
			return null;
		}
		return pd;
	}

	/**
	 * This method simply calls <code>parseQvt(qvtScriptReader, getLog())</code>.
	 * 
	 * @param qvtScriptReader
	 *            the qvt script reader
	 * @return the value returned by the delegated method.
	 * @see #parseQvt(Reader, ILog)
	 */
	public TopLevelAS parseQvt(Reader qvtScriptReader) {
		return this.parseQvt(qvtScriptReader, this.getLog());
	}

	/**
	 * Parses the qvt script obtained from the given <code>qvtScriptReader</code> and returns the corresponding AST. Output goes to the given log.
	 * 
	 * @param qvtScriptReader
	 *            the QVT code to parse.
	 * @param log
	 *            the log for sending output.
	 * @return the CST of the QVT script or <code>null</code> if an error occured.
	 * @see #analyseQvt(Reader, ILog)
	 */
	public TopLevelAS parseQvt(Reader qvtScriptReader, ILog log) {
		TopLevelAS pd = this.getQvtParser().parse(qvtScriptReader, log, this.getDebug().booleanValue());
		return pd;
	}

	/**
	 * Returns the {@link QvtParser} used by this processor.
	 * 
	 * @return the {@link QvtParser} used by this processor.
	 */
	public QvtParser getQvtParser() {
		if (this.qvtParser == null) {
			this.qvtParser = new QvtParserImpl();
		}
		return this.qvtParser;
	}

	public List analyseQvt(TopLevelAS topLevelAS) {
		return this.analyseQvt(topLevelAS, this.getLog());
	}

	/**
	 * This method simply calls <code>analyseQvt(topLevelAS, this.environment(),log)</code>.
	 * 
	 * @param topLevelAS
	 *            the AST to be analysed.
	 * @param log
	 *            the log to use for output.
	 * @return a list of {@link ContextDeclaration}s.
	 */
	public List analyseQvt(TopLevelAS topLevelAS, ILog log) {
		Environment env = this.environment();
		return this.analyseQvt(topLevelAS, env, log);
	}

	/**
	 * Performs semantic analysis of the passed AST with the given <code>environment</code>. Output goes to the given <code>log</code>.
	 * 
	 * @param topLevelAS
	 *            the AST to be analysed. <code>null</code> is not allowed.
	 * @param environment
	 *            the environment for the analysis. If <code>null</code> is passed, a new environment is created.
	 * @param log
	 *            the log to use for output.
	 * 
	 * @return a list of {@link ContextDeclaration}s. The list is empty if <code>topLevelAS</code> is <code>null</code>.
	 * @see QvtSemanticAnalyserImpl#analyseQvt(TopLevelAS, Environment, ILog, boolean)
	 */
	public List analyseQvt(TopLevelAS topLevelAS, Environment environment, ILog log) {
		if (topLevelAS == null) {
			ErrorManager.reportInfo(log, null, "Cannot perform semantic analysis before syntax errors are resolved");
			return new ArrayList();
		}
		if (environment == null) {
			environment = this.environment();
		}
		this.callerToCalled = new HashMap();
		this.allCalledRelations = new HashSet();
		this.allCalledRelationsByNot = new HashSet();
		this.allRelationCalls = new HashSet();
		List contextDecls = this.getAnalyserQvT().analyseQvt(topLevelAS, environment, log, this.getDebug().booleanValue());
		for (Iterator iter = this.allRelationCalls.iterator(); iter.hasNext();) {
			RelationCallExp relationCall = (RelationCallExp) iter.next();
			if (relationCall.eContainer() instanceof OperationCallExp && "not".equals(((OperationCallExp) relationCall.eContainer()).getName())) {
				this.allCalledRelationsByNot.add(relationCall.getReferredRelation());
			}
		}
		Transformation mainTransformation = null;
		for (Iterator iter = contextDecls.iterator(); iter.hasNext();) {
			Transformation transformation = (Transformation) iter.next();
			if (mainTransformation == null) {
				mainTransformation = transformation;
			}
			for (Iterator iterator = transformation.getRule().iterator(); iterator.hasNext();) {
				Relation relation = (Relation) iterator.next();
				if (!relation.isIsTopLevel() && !this.allCalledRelations.contains(relation) && mainTransformation.getRule().contains(relation)) {
					ErrorManager.reportWarning(log, this.getAnalyserQvT().getSymbol(relation), "Relation '" + relation.getName() + "' is never called.");
				}
			}
		}
		return contextDecls;
	}

	/**
	 * Returns the QVT semantic analyser used by the processor.
	 * 
	 * @return the QVT semantic analyser.
	 */
	public QvtSemanticAnalyserImpl getAnalyserQvT() {
		return (QvtSemanticAnalyserImpl) this.getAnalyser();
	}

	/**
	 * This method simply calls <code>analyseQvt(qvtScript, getLog())</code>.
	 * 
	 * @param qvtScript
	 *            the qvt script to analyse.
	 * @return a list of {@link ContextDeclaration}s of the AST. The list is empty if the qvt script cannot be parsed.
	 */
	public List analyseQvt(String qvtScript) {
		return this.analyseQvt(qvtScript, this.getLog());
	}

	/**
	 * Parses and performs semantic analysis of the given <code>qvtScript</code> with output going to the given <code>log</code>.
	 * 
	 * @param qvtScript
	 *            the qvt script to be analysed. <code>null</code> is not allowed.
	 * @param log
	 *            the log to use for output.
	 * 
	 * @return a list of {@link ContextDeclaration}s of the AST. The list is empty if the qvt script cannot be parsed.
	 * @see #parseQvt(String, ILog)
	 * @see #analyseQvt(TopLevelAS, ILog)
	 */
	public List analyseQvt(String qvtScript, ILog log) {
		// --- Parse the input ---
		TopLevelAS topLevelAS = this.parseQvt(qvtScript, log);
		return this.analyseQvt(topLevelAS, log);
	}

	/**
	 * This method simply calls <code>analyseQvt(qvtScriptReader, getLog())</code>
	 * 
	 * @param qvtScriptReader
	 *            the reader to obtain the qvt script from. <code>null</code> is not allowed.
	 * @return a list of {@link ContextDeclaration}s of the AST. The list is empty if the qvt script cannot be parsed.
	 * @see #analyseQvt(Reader, ILog)
	 */
	public List analyseQvt(Reader qvtScriptReader) {
		return this.analyseQvt(qvtScriptReader, this.getLog());
	}

	/**
	 * Parses and performs semantic analysis of the qvt script obtained from the given <code>qvtScriptReader</code> with output going to the given <code>log</code>. It is
	 * equivalent to <code>analyseQvt(parseQvt(qvtScriptReader, log), log)</code>.
	 * 
	 * @param qvtScriptReader
	 *            the reader to obtain the qvt script from. <code>null</code> is not allowed.
	 * @param log
	 *            the log to use for output.
	 * 
	 * @return a list of {@link ContextDeclaration}s of the AST. The list is empty if the qvt script cannot be parsed.
	 * @see #parseQvt(Reader, ILog)
	 * @see #analyseQvt(TopLevelAS, ILog)
	 */
	public List analyseQvt(Reader qvtScriptReader, ILog log) {
		// --- Parse the input ---
		TopLevelAS topLevelAS = this.parseQvt(qvtScriptReader, log);
		if (this.debugMode) {
			QvtSemanticAnalyserThreadPool.getLogger().println("QVT script Signature:" + QvtProcessorImpl.analyzeQVTInputAndOutputList(topLevelAS));
		}
		return this.analyseQvt(topLevelAS, log);
	}

	/**
	 * Parses and performs semantic analysis of the given <code>qvtScript</code> using the given <code>environment</code>. Output goes to the given <code>log</code>. It is
	 * equivalent to <code>analyseQvt(parseQvt(qvtScript, log), environment, log)</code>.
	 * 
	 * @param qvtScript
	 *            the qvt script to analyse. <code>null</code> is not allowed.
	 * @param environment
	 *            the environment to use for analysis.
	 * @param log
	 *            the log to use for output.
	 * 
	 * @return a list of {@link ContextDeclaration}s of the AST. The list is empty if the qvt script cannot be parsed.
	 * @see #parseQvt(Sring, ILog)
	 * @see #analyseQvt(TopLevelAS, Environment, ILog)
	 */
	public List analyseQvt(String qvtScript, Environment environment, ILog log) {
		TopLevelAS topLevelAS = this.parseQvt(qvtScript, log);
		return this.analyseQvt(topLevelAS, environment, log);
	}

	/**
	 * Parses and performs semantic analysis of the qvt script obtained from the given <code>qvtScriptReader</code> using the given <code>environment</code>. Output goes to
	 * the given <code>log</code>. It is equivalent to <code>analyseQvt(parseQvt(qvtScriptReader, log), environment, log)</code>.
	 * 
	 * @param qvtScriptReader
	 *            the reader to obtain the qvt script from. <code>null</code> is not allowed.
	 * @param environment
	 *            the environment to use for analysis.
	 * @param log
	 *            the log to use for output.
	 * 
	 * @return a list of {@link ContextDeclaration}s of the AST. The list is empty if the qvt script cannot be parsed.
	 * @see #parseQvt(Reader, ILog)
	 * @see #analyseQvt(TopLevelAS, ILog)
	 */
	public List analyseQvt(Reader qvtScriptReader, Environment environment, ILog log) {
		TopLevelAS topLevelAS = this.parseQvt(qvtScriptReader, log);
		return this.analyseQvt(topLevelAS, environment, log);
	}

	/**
	 * Evaluates the transformation with the given <code>transformationName</code> and returns a collection of {@link Trace}s. The qvt script is parsed, semantically analysed
	 * and interpreted if no error occurs. If an error occurs, it is output to the log and a {@link RuntimeException} is thrown.
	 * 
	 * @param qvtScriptReader
	 *            the reader from which to obtain the qvt script.
	 * @param transformationName
	 *            the name of the transformation.
	 * @param enforce
	 *            flag to indicate whether to run in enforcement or check mode. <code>true</code> for enforcement <code>false</code> for checking only.
	 * @param direction
	 *            the direction of execution. This must be the name of a typed model in the qvt script.
	 * @param models
	 *            the models to use for the transformation. They must be in the order specified by the parameters of the transformation.
	 * @param oldTraces
	 *            the traces of the previous run of this transformation needed to identify previous bindings.
	 * @param log
	 *            the log to use for output.
	 * @return a collection of {@link Trace}s.
	 */
	public Collection evaluateQVT(Reader qvtScriptReader, String transformationName, boolean enforce, String direction, Object[] models, Collection oldTraces, ILog log) {

		this.transformationToPath = new HashMap();

		this.debugMode = Boolean.parseBoolean(this.properties.getProperty(QVTProcessorConsts.PROP_DEBUG, "false"));

		if (this.getDebugAdapter() != null) {
			this.getDebugAdapter().startTransformation();
		}
		try {
			try {

				Date dateBeforeAnalysis = null;

				if (this.debugMode) {
					QvtSemanticAnalyserThreadPool.getLogger().println("(Start QVT transformation)");
					dateBeforeAnalysis = new Date();
				}

				// Store direction in order to retrieve it from anywhere.
				this.setDirection(direction);
				this.contextDeclarations = this.analyseQvt(qvtScriptReader, log);

				if (this.debugMode) {
					QvtSemanticAnalyserThreadPool.getLogger().println("(QVT parsing and analysing done in " + (new Date().getTime() - dateBeforeAnalysis.getTime()) + " ms )");
				}

				if (this.contextDeclarations == null || log.hasErrors()) {
					throw new RuntimeException("Could not analyse QVT script. Aborting evaluation!");
				}

				Iterator contextDeclarationsIterator = this.contextDeclarations.iterator();

				while (contextDeclarationsIterator.hasNext()) {
					Transformation transformation = (Transformation) contextDeclarationsIterator.next();

					if (transformationName == null) {
						transformationName = transformation.getName();
					}

					if (transformation.getName().equals(transformationName)) {
						return this.evaluate(transformation, this.contextDeclarations, enforce, oldTraces, log, dateBeforeAnalysis);
					}
				}

				throw new RuntimeException("No transformation with name '" + transformationName + "' found.");
			} finally {
				if (this.getDebugAdapter() != null) {
					this.getDebugAdapter().stopTransformation();
				}
				this.tearDown();
			}
		} catch (QVTExitDebugSessionException e) {
			// nothing to do
			return new ArrayList();
		}

	}

	/**
	 * TODO kiegeland: Unfinished JavaDoc
	 * 
	 */
	private void tearDown() {
//		this.allCalledRelations = null;
//		this.allCalledRelationsByNot = null;
//		this.allRelationCalls = null;
//		this.bindingClauses = null;
//		this.bindingClausesReverse = null;
//		this.callerToCalled = null;
//		this.contextDeclarations = null;
//		this.debugAdapter = null;
//		this.directionContext = null;
//		this.models = new ArrayList();
//		this.modelSet = new ArrayList();
//		this.properties = this.properties = new Properties();
//		this.qvtParser = null;
//		this.qvtTraceAdapter = null;
//		this.relationToOrderedWhenClausesMap = null;
//		this.relationToOrderedWhereClausesMap = null;
//		this.renv_ = null;
//		this.targetTypedModel = null;
//		this.transformationContext = null;
//		this.transformationToPath = null;
	}

	/**
	 * Evaluates the given transformation and returns a collection of {@link Trace}s. If a {@link QvtTraceAdapter} was installed, it is used to load previous traces and store the
	 * resulting traces.
	 * 
	 * @param transformation
	 *            the transformation to evaluate.
	 * @param contextDeclarations
	 *            the context declarations of the <code>transformation</code>.
	 * @param enforce
	 *            flag to indicate whether to run in enforcement or check mode. <code>true</code> for enforcement <code>false</code> for checking only.
	 * @param oldTraces
	 *            the traces of the previous run of this transformation needed to identify previous bindings.
	 * @param log
	 *            the log to use for output.
	 * @param dateBeforeAnalysis
	 *            the date recorded before semantic analysis. Only needed in debug mode.
	 * @return a collection of {@link Trace}s.
	 */
	protected Collection evaluate(Transformation transformation, List contextDeclarations, boolean enforce, Collection oldTraces, ILog log, Date dateBeforeAnalysis) {

		QvtTraceAdapter localQvtTraceAdapter = this.getQvtTraceAdapter();

		oldTraces = new ArrayList();
		if (localQvtTraceAdapter != null) {

			Date dateBeforeEvaluation = null;
			if (this.debugMode) {
				dateBeforeEvaluation = new Date();
			}

			localQvtTraceAdapter.setQvtProcessor(this);
			localQvtTraceAdapter.setTransormation(transformation);
			localQvtTraceAdapter.setAllTransormations(contextDeclarations);

			if (!this.getProperty(QVTProcessorConsts.PROP_CLEAR_TRACES, "False").equalsIgnoreCase("True")) {
				oldTraces = localQvtTraceAdapter.loadTraces();
			}

			if (this.debugMode) {
				QvtSemanticAnalyserThreadPool.getLogger().println("(QVT loading traces done in " + (new Date().getTime() - dateBeforeEvaluation.getTime()) + " ms )");
			}
		}

		this.computeDirectionAndOrderWhenAndWhereClauses(transformation, contextDeclarations, this.direction, log);
		if (log.hasErrors()) {
			throw new RuntimeException("Could not directional analyse QVT script. Aborting evaluation!");
		}

		Collection result = this.evaluateQVT(transformation, enforce, this.targetTypedModel, this.runtimeEnvironment(), oldTraces, log);
		if (this.debugMode) {
			QvtSemanticAnalyserThreadPool.getLogger().println("(QVT evaluateQVT() terminated after " + (new Date().getTime() - dateBeforeAnalysis.getTime()) + " ms )");
		}

		if (localQvtTraceAdapter != null) {

			if (this.debugMode) {
				QvtSemanticAnalyserThreadPool.getLogger().println("Allocate IDs");
			}

			Trace.allocateMediniIdentifiers(oldTraces, result, this.targetTypedModel, false);
			localQvtTraceAdapter.storeTraces(result);
		}

		if (this.debugMode) {
			QvtSemanticAnalyserThreadPool.getLogger().println("(QVT transformation done in " + (new Date().getTime() - dateBeforeAnalysis.getTime()) + " ms )");
			QvtSemanticAnalyserThreadPool.getLogger().println();
		}

		return result;
	}

	protected Collection evaluateQVT(Transformation transformation, boolean enforce, TypedModel targetTypedModel, RuntimeEnvironment environment, Collection oldTraces, ILog log) {
		if (this.isPropertySet(QVTProcessorConsts.PROP_INPLACE)) {
			do {
				oldTraces = this.getQvtEvaluator().evaluateQvt(transformation, enforce, targetTypedModel, this.runtimeEnvironment(), oldTraces, log);
			} while (QvtSemanticTaskDebugInfo.createOclAnyModelElementCount >= 1 || QvtSemanticTaskDebugInfo.setOrAddValueForFeautureCount >= 1);
			return oldTraces;
		}
		return this.getQvtEvaluator().evaluateQvt(transformation, enforce, targetTypedModel, this.runtimeEnvironment(), oldTraces, log);
	}

	/**
	 * Returns the total number of modifications by the previous transformation, consisting of number of created elements and number of set features
	 * 
	 * @return
	 */
	public int getTotalModificationCount() {
		return QvtSemanticTaskDebugInfo.getTotalModificationCount();
	}

	/**
	 * Saves the target typed model in {@link #targetTypedModel} and orders the when and where clauses of relations of the given <code>transformation</code>. The target typed
	 * model is the one whose name is equal to the execution <code>direction</code>. When this method returns, the {@link #relationToOrderedWhenClausesMap} and
	 * {@link #relationToOrderedWhereClausesMap} maps are filled with entries mapping each relation in the given transformation to a list of 'when' and 'where' domain statements in
	 * the order of evaluation. The 'when' domain of a relation comprises of both the source domain and when-clause, meanwhile the 'where' domain constitutes the target domain and
	 * where-clause.
	 * 
	 * @param transformation
	 *            the transformation whose target typed model is to be determined.
	 * @param allTransformations
	 *            a list of all the transformations in the qvt script
	 * @param direction
	 *            the execution direction of the transformation
	 * @param log
	 *            the log to use for output.
	 */
	public void computeDirectionAndOrderWhenAndWhereClauses(Transformation transformation, List allTransformations, String direction, ILog log) {
		this.parsingMode = this.isPropertySet(QVTProcessorConsts.PROP_PARSE);
		this.cleanMode = this.isPropertySet(QVTProcessorConsts.PROP_CLEAN) || this.parsingMode;
		this.randomSize = Integer.parseInt(this.getProperty(QVTProcessorConsts.PROP_RANDOMIZE, "0"));
		this.randomMode = this.randomSize >= 1;

		this.relationToOrderedWhenClausesMap = new HashMap();
		this.relationToOrderedWhereClausesMap = new HashMap();
		this.bindingClauses = new HashMap();
		this.bindingClausesReverse = new HashMap();

		if (direction == null) {
			new RuntimeException("Internal error: The execution direction cannot be null");
		}

		List modelParameter = transformation.getModelParameter();

		if (modelParameter.size() != this.models.size()) {
			new RuntimeException("Error: " + this.models.size() + " models are passed, but the transformation " + transformation.getFullName("::") + " requires " + modelParameter.size() + " models!");
		}

		this.targetTypedModel = this.getTargetTypedModel(transformation, direction);

		if (this.targetTypedModel == null) {
			throw new RuntimeException("Internal error: Direction not found! '" + direction + "' is not a parameter of the transformation '" + transformation.getFullName("::") + "'.");
		}

		for (Iterator allTransformationsIterator = allTransformations.iterator(); allTransformationsIterator.hasNext();) {
			Transformation currentTransformation = (Transformation) allTransformationsIterator.next();
			this.orderWhenAndWhereClauses(currentTransformation, this.targetTypedModel, log);
		}
	}

	/**
	 * Orders the 'when' and 'where' domains of the relations of the given transformation excuted in the direction of the given <code>targetTypedModel</code>.
	 * 
	 * @param transformation
	 *            the transformation whose relations' 'when' and 'where' domains are to be ordered.
	 * @param targetTypedModel
	 *            the target typed model.
	 * @param log
	 *            the log for output.
	 */
	private void orderWhenAndWhereClauses(Transformation transformation, TypedModel targetTypedModel, ILog log) {
		List rules = transformation.getRule();

		for (Iterator iter = rules.iterator(); iter.hasNext();) {
			Rule rule = (Rule) iter.next();

			if (rule instanceof Relation) {
				Relation relation = (Relation) rule;
				this.orderWhenAndWhereClauses(relation, targetTypedModel, log);
			}
		}
	}

	/**
	 * Orders the 'when' and 'where' domains of the given relation excuted in the direction of the given <code>targetTypedModel</code>.
	 * 
	 * @param relation
	 *            the relation whose 'when' and 'where' domains are to be ordered.
	 * @param targetTypedModel
	 *            the target typed model.
	 * @param log
	 *            the log for output.
	 */
	public void orderWhenAndWhereClauses(Relation relation, TypedModel targetTypedModel, ILog log) {
		List currentlyResolvedVariables = new ArrayList();
		List whenClauses = new ArrayList();
		this.setCleanMode(true);
		List orderedWhenClauses = QVTDirectedValidation.computeOrderedWhenClauses(relation, targetTypedModel, currentlyResolvedVariables, new HashMap(), this, log, whenClauses);
		if (!whenClauses.isEmpty()) {
			// Now try in non-clean-mode
			this.setCleanMode(false);
			currentlyResolvedVariables = new ArrayList();
			whenClauses = new ArrayList();
			orderedWhenClauses = QVTDirectedValidation.computeOrderedWhenClauses(relation, targetTypedModel, currentlyResolvedVariables, new HashMap(), this, log, whenClauses);
		}
		for (Iterator iter = whenClauses.iterator(); iter.hasNext();) {
			SemanticsVisitable clause = (SemanticsVisitable) iter.next();
			String unresolvedVar = QVTDirectedValidation.getUnresolvedVar(clause, currentlyResolvedVariables, new HashMap(), this);
			ErrorManager.reportError(log, this.getAnalyser().getSymbol(clause), "when clause of relation '" + relation.getName() + "' could not be resolved" + unresolvedVar + "!");
		}
		this.relationToOrderedWhenClausesMap.put(relation, orderedWhenClauses);
		List orderedWhereClauses = QVTDirectedValidation.computeOrderedWhereClauses(relation, targetTypedModel, currentlyResolvedVariables, new HashMap(), this, log);
		this.relationToOrderedWhereClausesMap.put(relation, orderedWhereClauses);
	}

	/**
	 * Returns the target typed model of the given transformation executed in the given direction.
	 * 
	 * @param transformation
	 *            the transformation whose target typed model is to be determined.
	 * @param direction
	 *            the execution direction.
	 * @return the target typed model which has the same name as the <code>direction</code> or <code>null</code> if not found.
	 */
	private TypedModel getTargetTypedModel(Transformation transformation, String direction) {

		List modelParameter = transformation.getModelParameter();
		int localTargetModelIndex = 0;
		for (Iterator iter = modelParameter.iterator(); iter.hasNext();) {
			TypedModel currentTypedModel = (TypedModel) iter.next();
			if (direction.equals(currentTypedModel.getName())) {
				this.setTargetModelIndex(localTargetModelIndex);
				return currentTypedModel;
			}
			localTargetModelIndex++;
		}
		this.setTargetModelIndex(-1);

		return null;
	}

	/**
	 * Retrieve the model associated with the passed direction of the passed transformation
	 * 
	 * @param transformation
	 * @param direction
	 * @return
	 */
	public Collection getModelsForDirection(Transformation transformation, TypedModel direction) {

		List modelParameter = transformation.getModelParameter();
		int localTargetModelIndex = 0;

		for (Iterator iter = modelParameter.iterator(); iter.hasNext();) {
			TypedModel currentTypedModel = (TypedModel) iter.next();
			if (direction.equals(currentTypedModel)) {
				return (Collection) this.models.get(localTargetModelIndex);
			}
			localTargetModelIndex++;
		}

		return null;
	}

	/**
	 * Returns the {@link QvtTraceAdapter} used by this processor. If the {@link QVTProcessorConsts#PROP_TRACEADAPTER} is not set, the <code>null</code> is returned. Otherwise
	 * the class specified by this property is instantiated and returned. Subclasses may override to instantiate specific adapters, however
	 * {@link #setQvtTraceAdapater(QvtTraceAdapter)} should be called to cache the adapter.
	 * 
	 * @return the trace adapter to use for handling traces or <code>null</code> if no adapter class is specified.
	 */
	public QvtTraceAdapter getQvtTraceAdapter() {
		if (this.qvtTraceAdapter != null) {
			return this.qvtTraceAdapter;
		}
		if (this.isPropertySet(QVTProcessorConsts.PROP_DISABLE_TRACES)) {
			return null;
		}
		try {
			if (this.getProperty(QVTProcessorConsts.PROP_TRACEADAPTER) == null) {
				return null;
			}

			Class traceAdapterClass = Class.forName(this.getProperty(QVTProcessorConsts.PROP_TRACEADAPTER));
			this.qvtTraceAdapter = (QvtTraceAdapter) traceAdapterClass.getConstructor(new Class[0]).newInstance(new Object[0]);
			this.qvtTraceAdapter.setQvtProcessor(this);
			return this.qvtTraceAdapter;
		} catch (ClassNotFoundException e) {
			// do nothing
		} catch (IllegalArgumentException e) {
			// do nothing
		} catch (SecurityException e) {
			// do nothing
		} catch (InstantiationException e) {
			// do nothing
		} catch (IllegalAccessException e) {
			// do nothing
		} catch (InvocationTargetException e) {
			// do nothing
		} catch (NoSuchMethodException e) {
			// do nothing
		}
		return null;
	}

	protected void setQvtTraceAdapater(QvtTraceAdapter qvtTraceAdapter) {
		this.qvtTraceAdapter = qvtTraceAdapter;
	}

	/**
	 * Returns the QVT evaluator used for evaluating qvt scripts.
	 * 
	 * @return the QVT evaluator used for evaluating qvt scripts.
	 */
	public QvtEvaluatorImpl getQvtEvaluator() {
		return (QvtEvaluatorImpl) this.getEvaluator();
	}

	/**
	 * Returns the {@link QvtModelManipulationAdapter}. Subclasses must override.
	 * 
	 * @return the {@link QvtModelManipulationAdapter}
	 */
	public abstract QvtModelManipulationAdapter getQvtModelManipulationAdaper();

	/**
	 * Sets the given property to the given <code>value</code>.
	 * 
	 * @param name
	 *            the property's name.
	 * @param value
	 *            the property's value.
	 */
	public void setProperty(String name, String value) {
		this.properties.put(name, value);
	}

	/**
	 * Unsets the given property.
	 * 
	 * @param name
	 *            the property's name.
	 */
	public void resetProperty(String name) {
		this.properties.remove(name);
	}

	/**
	 * Returns the value of the given property.
	 * 
	 * @param name
	 *            the property's name.
	 * @return the value of the given property.
	 */
	public String getProperty(String name) {
		return (String) this.properties.get(name);
	}

	/**
	 * Returns the value of the given property.
	 * 
	 * @param name
	 *            the property's name.
	 * @param defaultValue
	 *            a default value.
	 * @return the value of the given property.
	 */
	public String getProperty(String name, String defaultValue) {
		return this.properties.getProperty(name, defaultValue);
	}

	/**
	 * Determines whether the value of the given property is set to <code>true</code>.
	 * 
	 * @param name
	 *            the property's name.
	 * @return <code>true</code> if the value is set to true, <code>false</code> otherwise.
	 */
	public boolean isPropertySet(String name) {
		return Boolean.parseBoolean(this.properties.getProperty(name, "false"));
	}

	/**
	 * Sets the processor's properties.
	 * 
	 * @param properties
	 *            the properties to set.
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * Returns the target model.
	 * 
	 * @return the target model.
	 * @throws RuntimeException
	 *             if the target model index is negative.
	 * @see #setTargetModelIndex(int)
	 */
	public Object getTargetModel() throws RuntimeException {
		if (this.getTargetModelIndex() <= -1) {
			throw new RuntimeException("getTargetModel() was called without a target model being set!");
		}
		return ((Collection) this.models.get(this.getTargetModelIndex())).iterator().next();
	}

	/**
	 * Sets the index of the target model in the list of models.
	 * 
	 * @param targetModelIndex
	 *            the target model's index.
	 */
	public void setTargetModelIndex(int targetModelIndex) {
		this.targetModelIndex = targetModelIndex;
	}

	/**
	 * Returns the target model's index. A negative value is invalid.
	 * 
	 * @return the target model's index.
	 */
	private int getTargetModelIndex() {
		return this.targetModelIndex;
	}

	/**
	 * Returns the execution direction.
	 * 
	 * @return the execution direction.
	 */
	public String getDirection() {
		return this.direction;
	}

	/**
	 * Sets the execution direction.
	 * 
	 * @param direction
	 *            the execution direction.
	 */
	protected final void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * Returns the ordered when clauses for the given <code>relation</code>.
	 * 
	 * @param relation
	 *            the relation.
	 * @return the ordered when clauses for the given <code>relation</code>.
	 */
	public List getWhenClausesFor(Relation relation) {
		return (List) this.relationToOrderedWhenClausesMap.get(relation);
	}

	/**
	 * Returns the ordered where clauses for the given <code>relation</code>.
	 * 
	 * @param relation
	 *            the relation.
	 * @return the ordered where clauses for the given <code>relation</code>.
	 */
	public List getWhereClausesFor(Relation relation) {
		return (List) this.relationToOrderedWhereClausesMap.get(relation);
	}

	public boolean isDebugMode() {
		return this.debugMode;
	}

	public void reportRelationCall(Relation callerRelation, Relation calledRelation, RelationCallExp relationCall) {
		if (this.callerToCalled == null) {
			return;
		}
		Collection calledRelations = (Collection) this.callerToCalled.get(callerRelation);
		if (calledRelations == null) {
			calledRelations = new HashSet();
			this.callerToCalled.put(callerRelation, calledRelations);
		}
		calledRelations.add(calledRelation);
		this.allCalledRelations.add(calledRelation);
		this.allRelationCalls.add(relationCall);
	}

	public boolean isRelationCalled(Relation relation) {
		return this.allCalledRelations != null && this.allCalledRelations.contains(relation);
	}

	public boolean isRelationCalledByNot(Relation relation) {
		return this.allCalledRelationsByNot != null && this.allCalledRelationsByNot.contains(relation);
	}

	/**
	 * Returns the signature of a QVT script (see {@link #analyzeQVTInputAndOutputList(TopLevelAS)})
	 * 
	 * @param topLevelAS
	 * @return instead of nested lists, nested array are returned
	 */
	public static Object[] analyzeQVTInputAndOutput(TopLevelAS topLevelAS) {
		return QvtProcessorImpl.recursiveListToArray(QvtProcessorImpl.analyzeQVTInputAndOutputList(topLevelAS));
	}

	/**
	 * Converts a list to an array recursively
	 * 
	 * @param list
	 *            list with nested lists
	 * @return array with nested array
	 */
	private static Object[] recursiveListToArray(List list) {
		Object[] result = list.toArray(new Object[list.size()]);
		for (int i = 0; i < result.length; i++) {
			if (result[i] instanceof List) {
				result[i] = QvtProcessorImpl.recursiveListToArray((List) result[i]);
			}
		}
		return result;
	}

	/**
	 * Returns the signature of a QVT script
	 * 
	 * @param topLevelAS
	 *            the syntax tree of the QVT script
	 * @return Nested lists of form:: ( TransformationName:String , ( DirectionName:String , MetaModelName* )* )*. Example (brace expressions are lists): [[MyTransformationName,
	 *         [[source, [EUML]], [target, [EUML]]]]].
	 */
	public static List analyzeQVTInputAndOutputList(TopLevelAS topLevelAS) {
		List transformations = new ArrayList();
		for (Iterator transformationIter = topLevelAS.getTransformations().iterator(); transformationIter.hasNext();) {
			TransformationAS transformation = (TransformationAS) transformationIter.next();
			List directions = new ArrayList();
			for (Iterator modelDeclarations = transformation.getModelDeclarations().iterator(); modelDeclarations.hasNext();) {
				ModelDeclarationAS modelDeclarationAS = (ModelDeclarationAS) modelDeclarations.next();
				String direction = modelDeclarationAS.getModelId();
				List metaModelIDs = new ArrayList();
				for (Iterator metaModels = modelDeclarationAS.getMetaModelIds().iterator(); metaModels.hasNext();) {
					metaModelIDs.add(metaModels.next());
				}

				List level4 = new ArrayList();
				level4.add(direction);
				level4.add(metaModelIDs);
				directions.add(level4);
			}
			List level2 = new ArrayList();
			level2.add(transformation.getName());
			level2.add(directions);
			transformations.add(level2);
		}
		return transformations;
	}

	public boolean isBindingClause(SemanticsVisitable clause) {
		return this.bindingClauses.get(clause) != null && !((Collection) this.bindingClauses.get(clause)).isEmpty();
	}

	public SemanticsVisitable getBindingClause(VariableDeclaration varDecl) {
		return (SemanticsVisitable) this.bindingClausesReverse.get(varDecl);
	}

	/**
	 * 
	 * @param clause
	 *            when or where clause
	 * @return a list of <code>VariableDeclaration</code> instances bound by the given clause
	 */
	public List getBoundVariablesByClause(SemanticsVisitable clause) {
		List result = (List) this.bindingClauses.get(clause);
		if (result != null) {
			return result;
		}
		return new ArrayList();
	}

	/**
	 * 
	 * @param clause
	 * @param varDecls
	 *            a list of <code>VariableDeclarationy</code> instances
	 */
	public void markAsBindingClause(SemanticsVisitable clause, List varDecls) {
		this.bindingClauses.put(clause, varDecls);
		for (Iterator iter = varDecls.iterator(); iter.hasNext();) {
			VariableDeclaration varDecl = (VariableDeclaration) iter.next();
			this.bindingClausesReverse.put(varDecl, clause);
		}
	}

	public void markAsBindingClause(SemanticsVisitable clause, VariableDeclaration varDecl) {
		List varDecls = new ArrayList();
		varDecls.add(varDecl);
		this.bindingClauses.put(clause, varDecls);
		this.bindingClausesReverse.put(varDecl, clause);
	}

	public boolean logTasks() {
		return this.isDebugMode() && this.isPropertySet(QVTProcessorConsts.PROP_DEBUG_TASKS);
	}

	public boolean requireAssertWhereClause(SemanticsVisitable clause) {
		return QvtProcessorImpl.requireBindingWhereClausesToBeTrue && (this.isBindingClause(clause) || !(clause instanceof RelationCallExp));
	}

	public synchronized IDebugAdapter getDebugAdapter() {
		if (this.isPropertySet(QVTProcessorConsts.PROP_ECLIPSE_DEBUG)) {
			if (this.debugAdapter == null) {
				try {
					Class debugAdapterClass = Class.forName(this.getProperty(QVTProcessorConsts.PROP_DEBUGADAPTER, DebugAdapterImpl.class.getName()));
					this.debugAdapter = (IDebugAdapter) debugAdapterClass.getConstructor(new Class[0]).newInstance(new Object[0]);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				this.debugAdapter.setQvtProcessor(this);
				if (this.getProperty(QVTProcessorConsts.PROP_TRANSFORMATION_PATH) == null) {
					throw new RuntimeException("The QVT engine property '" + QVTProcessorConsts.PROP_TRANSFORMATION_PATH + "' must be set when using the QVT debugger!");
				}
			}
			return this.debugAdapter;
		}
		return null;
	}

	/**
	 * Gets the pseudo code for "where" clause <code>whereClause</code>
	 * 
	 * @param whereClause
	 * @return
	 */
	public String getPseudoCodeForWhereClause(SemanticsVisitable whereClause) {
		String s = "";
		List varDecls = this.getBoundVariablesByClause(whereClause);
		if (whereClause instanceof ObjectTemplateExp) {
			ObjectTemplateExp template = (ObjectTemplateExp) whereClause;
			VariableDeclaration var = template.getBindsTo();
			String bindBy = "TRACE";
			for (Iterator iter = QVTDirectedValidation.findSuitableKeys(template, this).iterator(); iter.hasNext();) {
				bindBy = bindBy + " OR KEY(";
				QVTSuitableKey key = (QVTSuitableKey) iter.next();
				if (key.getUseOppositeProperty()) {
					PropertyTemplateItem propertyTemplateItem = (PropertyTemplateItem) template.eContainer();
					VariableDeclaration parentVar = propertyTemplateItem.getObjContainer().getBindsTo();
					bindBy = bindBy + "KeyCandidateSet=" + parentVar.getName() + "." + propertyTemplateItem.getReferredProperty().getName() + ",";
				}
				boolean firstProperty = true;
				for (Iterator propIter = key.getKey().getPart().iterator(); propIter.hasNext();) {
					if (!firstProperty) {
						bindBy += ",";
					}
					Property prop = (Property) propIter.next();
					PropertyTemplateItem propertyTemplateItem = QVTDirectedValidation.getPropertyTemplateItemFor(template, prop);
					bindBy += prop.getName() + "=";
					if (propertyTemplateItem.getValue() instanceof ObjectTemplateExp) {
						ObjectTemplateExp nestedTemplate = (ObjectTemplateExp) propertyTemplateItem.getValue();
						bindBy += nestedTemplate.getName();
					} else {
						bindBy += QvtSerializingVisitorImpl.getStringRepresentation(propertyTemplateItem.getValue());
					}
					firstProperty = false;
				}
				bindBy = bindBy + ")";
			}
			Relation relation = QVTDirectedValidation.getRelationOf(template);
			if (relation != null && !relation.isIsTopLevel() && !(template.eContainer() instanceof PropertyTemplateItem)) {
				bindBy = "TUPLE OR " + bindBy;
			}
			s += QvtSerializingVisitorImpl.getVarName(var, varDecls) + " := BIND BY " + bindBy + " OR CREATE " + var.getType().getName();

		} else if (whereClause instanceof PropertyTemplateItem) {
			PropertyTemplateItem propTemplate = (PropertyTemplateItem) whereClause;
			Property prop = propTemplate.getReferredProperty();
			if (prop != null) {
				String LHS = propTemplate.getObjContainer().getBindsTo().getName() + "." + prop.getName();
				if (!varDecls.isEmpty()) {
					s += LHS + " := " + QvtSerializingVisitorImpl.getStringRepresentation(propTemplate.getValue(), varDecls);
				} else if (propTemplate.getValue() instanceof ObjectTemplateExp) {
					ObjectTemplateExp valueTemplate = (ObjectTemplateExp) propTemplate.getValue();
					if (prop.getType() instanceof CollectionType) {
						s += LHS + " += " + valueTemplate.getBindsTo().getName();
					} else {
						s += LHS + " := " + valueTemplate.getBindsTo().getName();
					}
				} else {
					s += LHS + " := " + QvtSerializingVisitorImpl.getStringRepresentation(propTemplate.getValue(), varDecls);
				}
			}
		} else {
			if (this.requireAssertWhereClause(whereClause)) {
				s += "ASSERT " + QvtSerializingVisitorImpl.getStringRepresentation(whereClause, varDecls);
			} else {
				s += QvtSerializingVisitorImpl.getStringRepresentation(whereClause, varDecls);
			}
		}
		return s;
	}

	/**
	 * Gets the pseudo code for "when" clause <code>whenClause</code>
	 * 
	 * @param whenClause
	 * @return
	 */
	public String getPseudoCodeForWhenClause(SemanticsVisitable whenClause) {
		String s = "";
		List varDecls = this.getBoundVariablesByClause(whenClause);
		if (whenClause instanceof ObjectTemplateExp) {
			ObjectTemplateExp template = (ObjectTemplateExp) whenClause;
			s += QvtSerializingVisitorImpl.getVarName(template.getBindsTo(), varDecls) + " := BIND BY TUPLE";
		} else if (whenClause instanceof PropertyTemplateItem) {
			PropertyTemplateItem propTemplate = (PropertyTemplateItem) whenClause;
			Property prop = propTemplate.getReferredProperty();
			if (prop != null) {
				String LHS = propTemplate.getObjContainer().getBindsTo().getName() + "." + prop.getName();
				if (!varDecls.isEmpty()) {
					s += LHS + " = " + QvtSerializingVisitorImpl.getStringRepresentation(propTemplate.getValue(), varDecls);
				} else if (propTemplate.getValue() instanceof ObjectTemplateExp) {
					ObjectTemplateExp valueTemplate = (ObjectTemplateExp) propTemplate.getValue();
					if (prop.getType() instanceof CollectionType) {
						s += valueTemplate.getBindsTo().getName() + " " + (char) 8712 + " " + LHS;
					} else {
						s += LHS + " = " + valueTemplate.getBindsTo().getName();
					}
				} else {
					s += LHS + " = " + QvtSerializingVisitorImpl.getStringRepresentation(propTemplate.getValue(), varDecls);
				}
			}
		} else {
			s += QvtSerializingVisitorImpl.getStringRepresentation(whenClause, varDecls);
		}
		return s;
	}

	/**
	 * 
	 * @param transformation
	 * @return the path or <code>null</code> if cannot be determined
	 */
	public String getTransformationPath(Transformation transformation) {
		return (String) this.transformationToPath.get(transformation);
	}

	public void recordTransformationPath(Transformation transformation, String pathOfTransformation) {
		if (this.transformationToPath != null) {
			this.transformationToPath.put(transformation, pathOfTransformation);
		}
	}

	/**
	 * Saves state information which must be done before parsing or evaluating OCL queries with this processor instance after a QVT script has been parsed
	 * 
	 * @return
	 */
	public Object saveSemanticStateInformation() {
		return this.getAnalyserQvT().getAstMap();
	}

	/**
	 * Restores saved state information, see {@link #saveSemanticStateInformation()}
	 * 
	 * @param stateInfo
	 */
	public void restoreSemanticStateInformation(Object stateInfo) {
		this.getAnalyserQvT().setAstMap((Map) stateInfo);
	}

	/**
	 * Returns the computed transformation direction
	 * 
	 * @return
	 */
	public TypedModel getTargetTypedModel() {
		return this.targetTypedModel;
	}

	/**
	 * Returns from relation <code>relation</code> the clause at line <code>line</code>
	 * 
	 * @param line
	 * @param relation
	 *            may be <code>null</code>
	 * @return the clause or <code>null</code> otherwise
	 */
	public SemanticsVisitable getClauseAt(int line, Relation relation) {
		if (relation == null) {
			return null;
		}
		List breakpointableNodes = new ArrayList();
		breakpointableNodes.addAll(this.getWhenClausesFor(relation));
		breakpointableNodes.addAll(this.getWhereClausesFor(relation));
		breakpointableNodes.addAll(QVTDirectedValidation.collectAllDomainsExcludingDirection(relation, this.getTargetTypedModel()));
		for (Iterator iter = breakpointableNodes.iterator(); iter.hasNext();) {
			SemanticsVisitable clause = (SemanticsVisitable) iter.next();
			if (this.getAnalyser().getBeginLine(clause) == line) {
				return clause;
			}
		}
		return null;
	}

	/**
	 * When evaluating QVT, returns the parsed ASTs, since they are not accessible otherwise
	 * 
	 * @return
	 */
	public List getContextDeclarations() {
		return this.contextDeclarations;
	}

	/**
	 * Creates a query instance for the body of the given OCL constraint
	 * 
	 * @param body
	 * @return
	 */
	public Query createQuery(String body, String contextClass) {
		this.setLineDelta(-1);
		try {
			Environment env = this.environment();
			List result = this.analyse("context " + contextClass + " inv:\n" + body, this.getLog());
			if (result != null && !result.isEmpty() && result.get(0) instanceof ContextDeclaration) {
				return new QueryImpl(env, (ContextDeclaration) result.get(0), null, this);
			}
			return null;
		} finally {
			this.setLineDelta(0);
		}
	}

	/**
	 * Returns true iff transformation is run in random mode, i.e. relations are executed randomly
	 * 
	 * @return
	 */
	public boolean isRandomMode() {
		return this.randomMode;
	}

	/**
	 * Returns true iff random elements may still be created.
	 * 
	 */
	public boolean hasRandomResidual() {
		return this.randomSize > QvtSemanticTaskDebugInfo.createOclAnyModelElementCount;
	}

	public boolean isParsingMode() {
		return this.parsingMode;
	}

	public boolean isCleanMode() {
		return this.cleanMode;
	}

	public void setCleanMode(boolean cleanMode) {
		this.cleanMode = cleanMode;
	}

	/**
	 * Tells whether to diffentiate between check-only and enforce domains.
	 * 
	 * @return
	 */
	static public boolean respectCheckOnlyFlag() {
		return false;
	}

	/**
	 * @return the transformationContext
	 */
	public Transformation getTransformationContext() {
		return this.transformationContext;
	}

	/**
	 * @param transformationContext
	 *            the transformationContext to set
	 */
	public void setTransformationContext(Transformation transformationContext) {
		this.transformationContext = transformationContext;
	}

	/**
	 * @return the directionContext
	 */
	public TypedModel getDirectionContext() {
		return this.directionContext;
	}

	/**
	 * @param directionContext
	 *            the directionContext to set
	 */
	public void setDirectionContext(TypedModel directionContext) {
		this.directionContext = directionContext;
	}

}
