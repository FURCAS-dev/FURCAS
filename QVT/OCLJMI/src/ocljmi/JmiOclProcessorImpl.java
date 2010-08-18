package ocljmi;


import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.OclProcessorImpl;
import org.oslo.ocl20.semantics.analyser.OclSemanticAnalyser;
import org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserImpl;
import org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl;
import org.oslo.ocl20.semantics.bridge.Environment;
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
import org.oslo.ocl20.synthesis.OclEvaluatorVisitorImpl;
import org.oslo.ocl20.synthesis.RuntimeEnvironment;

import uk.ac.kent.cs.kmf.util.ILog;



/**
 * @author dha
 * 
 */
public class JmiOclProcessorImpl extends OclProcessorImpl implements OclProcessor {
	JmiBridgeFactory bridgeFactory;
	
	private ResourceSet connection;

	private static List list_ = new ArrayList();

	private static List visit_list_ = new ArrayList();

	List sourceResources = new ArrayList();

	public void addSourceResources(Resource resource) {
		this.sourceResources.add(resource);
	}

	public List getSourceResources() {
		return this.sourceResources;
	}

	public org.oslo.ocl20.semantics.factories.BridgeFactory getBridgeFactory() {
		return this.bridgeFactory;
	}

	TypeFactory typeFactory;

	public TypeFactory getTypeFactory() {
		return this.typeFactory;
	}

	ModelEvaluationAdapter modelImplAdapter = new JmiEvaluationAdapter(this);

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

	OclSemanticAnalyser analyser = new OclSemanticAnalyserImpl(this, new OclSemanticAnalyserVisitorImpl(this), null, null);

	public OclSemanticAnalyser getAnalyser() {
		return this.analyser;
	}

	OclEvaluatorImpl evaluator = new OclEvaluatorImpl(this, new OclEvaluatorVisitorImpl(this));

	public OclEvaluator getEvaluator() {
		return this.evaluator;
	}

	// public OclCodeGeneratorImpl generator = new OclCodeGeneratorImpl( this, new
	// OclCodeGeneratorVisitorImpl(null,this) );
	public OclCodeGenerator getGenerator() {
		return null;// generator;
	}

	protected Object validateModel(Object mdl) {
		if (!(mdl instanceof EObject)) {
			this.getLog().reportError("Models must be of type ModelPartition for an JMI OCL Processor.");
			return null;
		}
		return mdl;
	}

	public void addMetaModel(Object metamodel) {
		if (metamodel instanceof EPackage) {
			EPackage pkg = (EPackage) metamodel;
			this.metaModels.add(pkg);
		} else {
			this.getLog().reportError("Metamodels added to the namespace must be of type MofPackage for an JMI OclProcessor.");
		}
	}

	public JmiOclProcessorImpl(ILog log, ResourceSet conn) {
		super(log);
		this.connection = conn;
		bridgeFactory = new JmiBridgeFactory(this, conn);
		typeFactory = new TypeFactoryImpl(this);
	}

	public List evaluate_2(String str, Environment env, RuntimeEnvironment renv, ILog log) {
		String context;

		int p = str.indexOf("inv:");
		context = str.substring(8, p);
		context = context.replaceAll(" ", "");

		EObject mofobject = (EObject) renv.getValue("self");
		JmiOclProcessorImpl.list_.clear();
		JmiOclProcessorImpl.visit_list_.clear();

		JmiOclProcessorImpl.findInstances(context, mofobject);

		List wholelist = new ArrayList();

		for (int i = 0; i < JmiOclProcessorImpl.list_.size(); i++) {
			RuntimeEnvironment renv_ = this.runtimeEnvironment("self", JmiOclProcessorImpl.list_.get(i));
			List list = this.evaluate(str, env, renv_, log);
			if (list != null) {
				wholelist.addAll(list);
			}
		}
		return wholelist;
	}

	private static void findInstances(String InstanceName, EObject object) {
		if (((EClass)object.refMetaObject()).getName().toString().equals(InstanceName)) {
			if (!JmiOclProcessorImpl.list_.contains(object)) {
				JmiOclProcessorImpl.list_.add(object);

				// System.out.println(list_.size()+":"+eo);
			}

		}
		//*********************************
		List moflist = new ArrayList();
		Iterator itx=((EClass)object.refMetaObject()).eAllContents();
		Object objx;
		while (itx.hasNext()){
			objx=itx.next();
			if (objx instanceof EStructuralFeature){
			moflist.add(objx);}
		}

		for (int l = 0; l < moflist.size(); l++) {
			EStructuralFeature sf = (EStructuralFeature) moflist.get(l);

			if (((EClass)sf.refMetaObject()).getName() == "Reference") {

				// System.out.println(sf);
				if (sf != null) {
					//******************************
					Object obj = object.refGetValue(sf);

					if (obj instanceof List) {
						List li_ = (List) obj;
						for (int a = 0; a < li_.size(); a++) {
							EObject mofo = (EObject) li_.get(a);

							if (((EClass)mofo.refMetaObject()).getName().toString().equals(InstanceName)) {
								// System.out.println(eo);
								if (!JmiOclProcessorImpl.list_.contains(mofo)) {
									JmiOclProcessorImpl.list_.add(mofo);

									// System.out.println(list_.size()+":"+eo);
								}

							}

							if (!JmiOclProcessorImpl.visit_list_.contains(mofo)) {
								JmiOclProcessorImpl.visit_list_.add(mofo);
								JmiOclProcessorImpl.findInstances(InstanceName, mofo);
							}
						}
					}

					if (obj instanceof EObject) {
						EObject mofo = (EObject) obj;

						if (mofo != null) {

							if (((EClass)mofo.refMetaObject()).getName().toString().equals(InstanceName)) {
								// System.out.println(eo);
								if (!JmiOclProcessorImpl.list_.contains(mofo)) {
									JmiOclProcessorImpl.list_.add(mofo);
									// System.out.println(list_.size()+":"+eo);
								}
							}

							if (!JmiOclProcessorImpl.visit_list_.contains(mofo)) {
								// System.out.println(eo);
								JmiOclProcessorImpl.visit_list_.add(mofo);
								JmiOclProcessorImpl.findInstances(InstanceName, mofo);
								// visit_list_.add(eo);
							}

						}

						JmiOclProcessorImpl.visit_list_.add(mofo);
					}
				}
			}

		}

	}

	public void generate(Reader input, PrintWriter output, String pkgName, String className, ILog log) {
		// TODO Auto-generated method stub

	}

	Set metaModels = new HashSet();

	public Collection getMetaModels() {
		return this.metaModels;
	}

	public ResourceSet getConnection() {
		return connection;
	}

}
