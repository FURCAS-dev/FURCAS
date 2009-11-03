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

package de.ikv.emf.qvt;

import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.oslo.ocl20.bridge4emf.EmfBridgeFactory;
import org.oslo.ocl20.semantics.analyser.OclSemanticAnalyser;
import org.oslo.ocl20.semantics.factories.TypeFactory;
import org.oslo.ocl20.standard.lib.StdLibAdapter;
import org.oslo.ocl20.standard.lib.StdLibAdapterImpl;
import org.oslo.ocl20.standard.types.TypeFactoryImpl;
import org.oslo.ocl20.syntax.parser.OclParser;
import org.oslo.ocl20.syntax.parser.OclParserImpl;
import org.oslo.ocl20.synthesis.ModelEvaluationAdapter;
import org.oslo.ocl20.synthesis.ModelGenerationAdapter;
import org.oslo.ocl20.synthesis.OclCodeGenerator;
import org.oslo.ocl20.synthesis.OclEvaluator;
import org.oslo.ocl20.synthesis.OclEvaluatorImpl;
import org.oslo.ocl20.synthesis.RuntimeEnvironment;

import uk.ac.kent.cs.kmf.util.ILog;
import de.ikv.medini.qvt.QVTProcessorConsts;
import de.ikv.medini.qvt.QvtEvaluatorImpl;
import de.ikv.medini.qvt.QvtEvaluatorVisitorImpl;
import de.ikv.medini.qvt.QvtModelManipulationAdapter;
import de.ikv.medini.qvt.QvtProcessorImpl;
import de.ikv.medini.qvt.QvtSemanticAnalyserImpl;
import de.ikv.medini.qvt.QvtSemanticAnalyserVisitorImpl;
import de.ikv.medini.qvt.QvtTraceAdapter;
import de.ikv.medini.qvt.model.qvtbase.Transformation;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;

public class EMFQvtProcessorImpl extends QvtProcessorImpl {

	public EMFQvtProcessorImpl(ILog log) {
		super(log);
	}

	public Collection transactionalEvaluate(final Transformation transformation, final List contextDeclarations,
	        final boolean enforce, final Collection oldTraces, final ILog log, final Date dateBeforeAnalysis) {

		boolean hasCreatedTransactionalEditingDomain;

		// set of TransactionalEditingDomain instances associated to the model resources
		Set editingDomains = new HashSet();

		for (java.util.Iterator iter = this.getModels().iterator(); iter.hasNext();) {
			Resource resource = (Resource) iter.next();
			TransactionalEditingDomain transactionalEditingdomain = TransactionUtil.getEditingDomain(resource);
			if (transactionalEditingdomain != null) {
				editingDomains.add(transactionalEditingdomain);
			}
		}

		TransactionalEditingDomain transactionalEditingdomain;
		if (editingDomains.isEmpty()) {
			ResourceSet rset = this.getFirstResourceSet();
			transactionalEditingdomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rset);
			editingDomains.add(transactionalEditingdomain);
			hasCreatedTransactionalEditingDomain = true;
		} else {
			transactionalEditingdomain = (TransactionalEditingDomain) editingDomains.iterator().next();
			hasCreatedTransactionalEditingDomain = false;
		}
		final List<Collection> result = new ArrayList();
		final List<RuntimeException> collectRuntimeException = new ArrayList<RuntimeException>();

		try {

			Command command = new RecordingCommand(transactionalEditingdomain, "QVT transformation") {
				@Override
				protected void doExecute() {
					try {
						result.add(EMFQvtProcessorImpl.this.evaluateInSuperclass(transformation, contextDeclarations,
						    enforce, oldTraces, log, dateBeforeAnalysis));
					} catch (RuntimeException e) {
						collectRuntimeException.add(e);
						throw e;
					}
				}

			};
			try {
				transactionalEditingdomain.getCommandStack().execute(command);
			} catch (Exception e) {
				// catch exception which is thrown at rollback silently
			}
			for (RuntimeException e : collectRuntimeException) {
				throw e;
			}
			return result.get(0);
		} finally {
			if (hasCreatedTransactionalEditingDomain) {
				transactionalEditingdomain.dispose();
			}
		}
	}

	/**
	 * Tries to call {@link transactionalEvaluateQVT(EMFQvtProcessorImpl, Transformation, boolean,
	 * TypedModel, RuntimeEnvironment, Collection, ILog)}. If it fails because the EMF Transaction
	 * classes cannot be found or because they can be found but an initialization error occured
	 * (when not in an Eclipse environment), calls
	 * {@link QvtProcessorImpl#evaluateQVT(Reader, String, boolean, String, Object[], Collection, ILog)}
	 */
	@Override
	protected Collection evaluate(Transformation transformation, List contextDeclarations, boolean enforce,
	        Collection oldTraces, ILog log, Date dateBeforeAnalysis) {
		if (this.isPropertySet(QVTProcessorConsts.PROP_DISABLE_TRANSACTIONAL_MODE)) {
			return super.evaluate(transformation, contextDeclarations, enforce, oldTraces, log, dateBeforeAnalysis);
		}
		try {
			return this.transactionalEvaluate(transformation, contextDeclarations, enforce, oldTraces, log,
			    dateBeforeAnalysis);
		} catch (NoClassDefFoundError e) {
			if (log != null) {
				log.reportWarning("Transactional domain will not be used because of a NoClassDefFoundError");
			}
			return super.evaluate(transformation, contextDeclarations, enforce, oldTraces, log, dateBeforeAnalysis);
		} catch (ExceptionInInitializerError e) {
			if (log != null) {
				log.reportWarning("Transactional domain will not be used because of a ExceptionInInitializerError");
			}
			return super.evaluate(transformation, contextDeclarations, enforce, oldTraces, log, dateBeforeAnalysis);
		}

	}

	protected Collection evaluateQVTinSuperclass(Transformation transformation, boolean enforce,
	        TypedModel targetTypedModel, RuntimeEnvironment environment, Collection oldTraces, ILog log) {
		return super.evaluateQVT(transformation, enforce, targetTypedModel, environment, oldTraces, log);
	}

	protected Collection evaluateInSuperclass(Transformation transformation, List contextDeclarations, boolean enforce,
	        Collection oldTraces, ILog log, Date dateBeforeAnalysis) {
		return super.evaluate(transformation, contextDeclarations, enforce, oldTraces, log, dateBeforeAnalysis);
	}

	EmfBridgeFactory bridgeFactory = new EmfBridgeFactory(this);

	private static List list_ = new ArrayList();

	private static List visit_list_ = new ArrayList();

	public org.oslo.ocl20.semantics.factories.BridgeFactory getBridgeFactory() {
		return this.bridgeFactory;
	}

	TypeFactory typeFactory = new TypeFactoryImpl(this);

	public TypeFactory getTypeFactory() {
		return this.typeFactory;
	}

	ModelEvaluationAdapter modelImplAdapter = new EMFQvtEvaluationAdapter(this);

	// new EmfEvaluationAdapter(this);
	public ModelEvaluationAdapter getModelEvaluationAdapter() {
		return this.modelImplAdapter;
	}

	ModelGenerationAdapter modelGenAdapter = null;// = new EmfGenerationAdapter(this);

	public ModelGenerationAdapter getModelGenerationAdapter() {
		return this.modelGenAdapter;
	}

	StdLibAdapterImpl stdLibAdapter = new StdLibAdapterImpl(this);

	public StdLibAdapter getStdLibAdapter() {
		return this.stdLibAdapter;
	}

	StdLibAdapter stdLibGenerationAdapter = null;// = new StdLibGenerationAdapterImpl(this);

	public StdLibAdapter getStdLibGenerationAdapter() {
		return this.stdLibGenerationAdapter;
	}

	public String getStdLibAdapterName() {
		return "Ocl4Emf.processor.getStdLibAdapter()";
	}

	public String getModelImplAdapterName() {
		return "Ocl4Emf.processor.getModelImplAdapter()";
	}

	OclParser parser = new OclParserImpl();

	public OclParser getParser() {
		return this.parser;
	}

	OclSemanticAnalyser analyser = new QvtSemanticAnalyserImpl(this, new QvtSemanticAnalyserVisitorImpl(this), null,
	    null);

	// analyser = new OclSemanticAnalyserImpl(this, new OclSemanticAnalyserVisitorImpl(this), new
	// OclDebugVisitorImpl(),
	// null);
	public OclSemanticAnalyser getAnalyser() {
		return this.analyser;
	}

	OclEvaluatorImpl evaluator = new QvtEvaluatorImpl(this, new QvtEvaluatorVisitorImpl(this));

	// evaluator = new OclEvaluatorImpl(this, new OclEvaluatorVisitorImpl(this));
	public OclEvaluator getEvaluator() {
		return this.evaluator;
	}

	// public OclCodeGeneratorImpl generator = new OclCodeGeneratorImpl( this, new
	// OclCodeGeneratorVisitorImpl(null,this) );
	public OclCodeGenerator getGenerator() {
		return null;// generator;
	}

	@Override
	protected Object validateModel(Object mdl) {
		if (!(mdl instanceof Resource)) {
			throw new RuntimeException("Model is not of type org.eclipse.emf.ecore.resource.Resource: " + mdl);
		}
		return mdl;
	}

	QvtModelManipulationAdapter qvtModelManipulationAdaper = new EMFQvtModelManipulationAdapterImpl(this);

	@Override
	public QvtModelManipulationAdapter getQvtModelManipulationAdaper() {
		return this.qvtModelManipulationAdaper;
	}

	public void generate(Reader input, PrintWriter output, String pkgName, String className, ILog log) {
		// do nothing
	}

	@Override
	public QvtTraceAdapter getQvtTraceAdapter() {
		if (this.isPropertySet(QVTProcessorConsts.PROP_DISABLE_TRACES)) {
			return null;
		}
		QvtTraceAdapter qvtTraceAdapter = super.getQvtTraceAdapter();
		if (qvtTraceAdapter == null) {
			this.setProperty(QVTProcessorConsts.PROP_TRACEADAPTER, "de.ikv.emf.qvt.EMFQvtTraceAdapter");
			qvtTraceAdapter = super.getQvtTraceAdapter();
		}
		return qvtTraceAdapter;
	}

	private URI workingLocation = URI.createFileURI(".");

	public URI getWorkingLocation() {
		return this.workingLocation;
	}

	public void setWorkingLocation(URI workingLoactaion) {
		this.workingLocation = workingLoactaion;
	}

	/**
	 * @param workingLoactaion
	 * @deprecated use {@link #setWorkingLocation(URI)} instead
	 */
	@Deprecated
	public void setWorkingLoactaion(URI workingLoactaion) {
		this.setWorkingLocation(workingLoactaion);
	}

	/**
	 * @return
	 * @deprecated use {@link #getWorkingLocation()} instead
	 */
	@Deprecated
	public URI getWorkingLoactaion() {
		return this.getWorkingLocation();
	}

	public Collection getMetaModels() {
		return this.metaModels;
	}

	Set metaModels = new HashSet();

	public void addMetaModel(Object metamodel) {
		if (metamodel instanceof EPackage) {
			EPackage pkg = (EPackage) metamodel;
			this.metaModels.add(pkg);
		} else {
			this.getLog().reportError(
			    "Metamodels added to the namespace must be of type EPackage for an EMF QVT Processor.");
		}
	}

	public Resource getTargetResource() {
		return (Resource) this.getTargetModel();
	}

	private ResourceSet resourceSetForTraces;

	public ResourceSet getResourceSetForTraces() {
		if (this.resourceSetForTraces != null) {
			return this.resourceSetForTraces;
		}
		return this.getFirstResourceSet();
	}

	public void setResourceSetForTraces(ResourceSet resourceSetForTraces) {
		this.resourceSetForTraces = resourceSetForTraces;
	}

	public ResourceSet getFirstResourceSet() {
		for (java.util.Iterator iter = this.getModels().iterator(); iter.hasNext();) {
			Resource resource = (Resource) iter.next();
			if (resource.getResourceSet() != null) {
				return resource.getResourceSet();
			}
		}
		throw new RuntimeException("To return a resource set, at least one model must be specified!");
	}

}
