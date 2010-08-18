package qvtjmi;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ocljmi.OclModelElementTypeImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.Enumeration;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.semantics.bridge.Primitive;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.types.BooleanType;
import org.oslo.ocl20.semantics.model.types.IntegerType;
import org.oslo.ocl20.semantics.model.types.RealType;
import org.oslo.ocl20.semantics.model.types.StringType;
import org.oslo.ocl20.standard.lib.OclAny;

import de.ikv.medini.qvt.QvtProcessorImpl;
import de.ikv.medini.qvt.QvtTraceAdapter;
import de.ikv.medini.qvt.Trace;
import de.ikv.medini.qvt.execution.QvtSemanticAnalyserThreadPool;
import de.ikv.medini.qvt.model.qvtbase.Domain;
import de.ikv.medini.qvt.model.qvtbase.Transformation;
import de.ikv.medini.qvt.model.qvtrelation.Relation;

/**
 * The standard trace adapter for MOF models. This trace adapter derives the
 * trace metamodel from
 * 
 * @author Thomas Goldschmidt
 * 
 */
public class JMIQvtTraceAdapter implements QvtTraceAdapter {

	private ResourceSet connection;

	public JMIQvtTraceAdapter(ResourceSet connection) {
		super();
		this.connection = connection;
	}
	
	public JMIQvtTraceAdapter() {
	}

	/**
	 * The QVT processor.
	 */
	protected QvtProcessorImpl qvtProcessor;

	/**
	 * The name of the trace file without its extension.
	 */
	public static final String TRACE_FILE_NAME = "trace";

	/**
	 * All transformations that have been executed. The fisrt transformation is
	 * the top level transformation and all other are imported transformations.
	 */
	protected Collection allTransformations;

	/**
	 * @deprecated use allTransformations.
	 */
	protected Transformation transformation;

	/**
	 * Flag to indicate is all traces should be stored in one file.
	 */
	protected boolean allTracesInOneFile = true;

	protected Collection traceMetamodelResources = new HashSet();

	private EPackage mofRefPackage;

	/**
	 * Sets the QVT processor for this trace adapter.
	 * 
	 * @param qvtProcessor
	 *            the QVT processor.
	 */
	public void setQvtProcessor(QvtProcessorImpl qvtProcessor) {
		this.qvtProcessor = qvtProcessor;
		this.connection = ((JMIQvtProcessorImpl)qvtProcessor).connection;
	}

	/**
	 * @deprecated use {@link #setAllTransormations(Collection)}.
	 * @param
	 */
	public void setTransormation(Transformation transformation) {
		this.transformation = transformation;
	}

	/**
	 * Sets the transformations whose traces are to be handled by this adapter.
	 * 
	 * @param allTransformations
	 *            the transformations. The first transformation in the
	 *            collection must be the top level one, all others must be
	 *            imported transformations.
	 */
	public void setAllTransormations(Collection allTransformations) {
		this.allTransformations = allTransformations;
	}

	/**
	 * Stores the given traces. First the
	 * 
	 * @param traces
	 *            the traces to store.
	 */
	public void storeTraces(Collection traces) {
		Date x = new Date();
		if (this.qvtProcessor.isDebugMode()) {
			QvtSemanticAnalyserThreadPool.getLogger().println(
					"Begin storing traces");
		}
		this.buildTraceMM();

		Resource resourceSet = this.getResourceSetForTraces();
		Map traceResourceMap = new HashMap();

		for (Iterator iter = traces.iterator(); iter.hasNext();) {
			Trace currentTrace = (Trace) iter.next();
			Relation currentRelation = currentTrace.getRelation();
			String currentTransformationName = currentRelation
					.getTransformation().getName();
			Resource traceResource = ((JMIQvtProcessorImpl) this.qvtProcessor)
					.getResourceSetForTraces();
			this.storeTrace(currentTrace, currentRelation, resourceSet,
					traceResource);
		}
		if (this.qvtProcessor.isDebugMode()) {
			QvtSemanticAnalyserThreadPool.getLogger().println(
					"Saving traces to disk");
		}
		// this.saveTracePartitions(traceResourceMap, resourceSet);
		try {
			if(!connection.getNullPartition().isDirty()) {
				connection.save();
			} else {
				qvtProcessor
						.getLog()
						.reportError(
								"Couldn't save changes as there are still the following elements in the transient partition:"
										+ connection.getNullPartition()
												.getElements());
			}
		} catch (NullPartitionNotEmptyException e) {
			throw new RuntimeException("Error saving traces", e);
		} catch (ReferencedTransientElementsException e) {
			throw new RuntimeException("Error saving traces", e);
		} catch (PartitionsNotSavedException e) {
			throw new RuntimeException("Error saving traces", e);
		}
		if (this.qvtProcessor.isDebugMode()) {
			QvtSemanticAnalyserThreadPool.getLogger().println(
					"Stopped saving traces to disk");
		}
		Date y = new Date();

		if (this.qvtProcessor.isDebugMode()) {
			QvtSemanticAnalyserThreadPool.getLogger().println(
					"(Storing traces done in in " + (y.getTime() - x.getTime())
							+ " ms )");
		}
	}

	// private void saveTracePartitions(Map traceResourceMap, Resource
	// partition) {
	// Set transformationNames = traceResourceMap.keySet();
	//
	// for (Iterator iter = transformationNames.iterator(); iter.hasNext();) {
	// String currentTransformationName = (String) iter.next();
	// Resource currentPartition = (Resource)
	// traceResourceMap.get(currentTransformationName);
	//
	// URI traceMMFileUri = ((MOFQvtProcessorImpl)
	// this.qvtProcessor).getWorkingLocation
	// ().appendSegment(currentTransformationName).appendFileExtension("ecore");
	// Resource traceMMResource = partition.getResource(traceMMFileUri,
	// false);
	//
	// String nsURI = "urn:" + currentTransformationName + ".ecore";
	// partition.getPackageRegistry().remove(nsURI);
	//
	// try {
	// currentPartition.save(Collections.EMPTY_MAP);
	// } catch (IOException e) {
	// throw new RuntimeException(e);
	// } finally {
	// traceMMResource.unload();
	// currentPartition.unload();
	// partition.getResources().remove(currentPartition);
	// partition.getResources().remove(traceMMResource);
	// }
	// }
	// }

	private void storeTrace(Trace trace, Relation relation,
			Resource partitionSet, Resource tracePartition) {

		EClass relationMetaClass = this
				.lookupRelation(((JMIQvtProcessorImpl) this.qvtProcessor)
						.getTraceMMPartition(), relation);
		List bindings = trace.getBindings();

		if (bindings.size() == 0) {
			// There may be transformations with no resulting bindings, so
			// comment next line

			// throw new
			// RuntimeException("Binding are not suppose to be empty");
		}

		EClass refClassForMofClass = ((JMIQvtProcessorImpl) this.qvtProcessor)
				.getConnection().getJmiHelper().getRefClassForMofClass(
				relationMetaClass);
		if(refClassForMofClass == null) {
			//TODO this is a workaround for not having the trace metamodel available
			return;
		}
		for (Iterator iterator = bindings.iterator(); iterator.hasNext();) {
			Map currentBinding = (Map) iterator.next();
			Set keys = currentBinding.keySet();
			
			EObject traceModelElement = refClassForMofClass.refCreateInstance();
			this.restoreTraceIdentifier(trace, currentBinding,
					traceModelElement);
			tracePartition.assignElement(traceModelElement);

			for (Iterator iterator1 = keys.iterator(); iterator1.hasNext();) {
				String currentKey = (String) iterator1.next();
				OclAny currentOclValue = (OclAny) currentBinding
						.get(currentKey);
				this.storeBindingVariable(currentKey, currentOclValue,
						relationMetaClass, traceModelElement, relation);
			}
		}
	}

	private void storeBindingVariable(String bindingVariable,
			OclAny bindingValue, EClass relationMetaClass,
			EObject bindingModelElement, Relation relation) {
		List listStructuralFeatures = relationMetaClass.eContents();
		Iterator it = listStructuralFeatures.iterator();
		Object obj;
		EStructuralFeature currentStructuralFeature = null;
		while (it.hasNext()) {
			obj = it.next();
			if (obj instanceof EStructuralFeature) {
				if (((EStructuralFeature) obj).getName().equals(bindingVariable))
					currentStructuralFeature = (EStructuralFeature) obj;
			}
		}

		// EStructuralFeature currentStructuralFeature =
		// relationMetaClass.getEStructuralFeature(bindingVariable);
		Object currentJavaValue = bindingValue.asJavaObject();
		bindingModelElement.eSet(currentStructuralFeature,
				currentJavaValue);
		this.setQvtTraceFiles(currentJavaValue, PartitionHelper.getPartition(
				bindingModelElement).getPri());
	}

	protected void setQvtTraceFiles(Object modelElement, URI traceResourcePRI) {
		// do nothing
	}

	protected void restoreTraceIdentifier(Trace trace, Map binding,
			EObject bindingModelElement) {
		// do nothing
	}

	// /**
	// * Returns the trace resource for the given transformation. If the given
	// trace resource map already contains one, it is returned. Otherwise an new
	// resource is created in the
	// * given resource set, stored in the map and returned.
	// *
	// * @param currentTransformationName
	// * the transformation name
	// * @param traceResourceMap
	// * the trace resource map to look for an existing resource or store a new
	// one.
	// * @param resourceSet
	// * the resource set for creating a new resource.
	// * @return the trace resource for the given transformation.
	// */
	// private Resource getTraceResource(String currentTransformationName,
	// Map traceResourceMap, Resource partitionSet) {
	//
	// if (this.allTracesInOneFile &&
	// this.allTransformations.iterator().hasNext()) {
	// // get the name of the main transformation if allTracesInOneFile is true
	// currentTransformationName = ((Transformation)
	// this.allTransformations.iterator().next()).getName();
	// }
	//
	// Resource tracePartition = (Resource)
	// traceResourceMap.get(currentTransformationName);
	//
	// if (tracePartition != null) {
	// return tracePartition;
	// }
	//
	// URI traceFilePri = ((MOFQvtProcessorImpl)
	// this.qvtProcessor).getWorkingLocation
	// ().appendSegment(MOFQvtTraceAdapter.TRACE_FILE_NAME
	// ).appendFileExtension(currentTransformationName);
	//
	// try {
	// tracePartition = partitionSet.getResource(traceFilePri, false);
	// } catch (Exception exception) {
	// // this occurs when no traces exist.
	// }
	//
	// if (tracePartition == null) {
	// tracePartition = partitionSet.createResource(traceFilePri);
	// } else {
	// // If the resource set already has the trace resource caused by some
	// other action such as editing outside,
	// // the QVT engine, its contents must be cleared.
	// tracePartition.deleteElements();
	// }
	//
	// traceResourceMap.put(currentTransformationName, tracePartition);
	// return tracePartition;
	// }

	/**
	 * Determines whether the given <code>variable</code> is a domain variable.
	 * 
	 * @param variable
	 *            the variable to check.
	 * @param domains
	 *            the domains.
	 * @return true, if the name of at one domain is equal to the given
	 *         variable. False otherwise.
	 */
	private boolean isDomainVariable(String variable, Collection domains) {
		for (Iterator iter = domains.iterator(); iter.hasNext();) {
			Domain currentDomain = (Domain) iter.next();
			if (variable.equals(currentDomain.getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the name of the transformation that import the given
	 * transformation. The name of the first transformation in the
	 * <code>allTransformations</code> is always returned because it is the
	 * importing transformation of all transformations. Therefore if the given
	 * transformation name is the importing tranformation, it will be returned.
	 * 
	 * @param transformationName
	 *            the name of the imported transformation.
	 * @return the transformation importing the given transformation.
	 */
	private String getImportingTransformationName(String transformationName) {
		return ((Transformation) this.allTransformations.iterator().next())
				.getName();
	}

	public Collection loadTraces() {
		this.loadTraceMM();
		Set traces = new HashSet();

		Resource partitionSet = this.getResourceSetForTraces();

		for (Iterator transformationsIter = this.allTransformations.iterator(); transformationsIter
				.hasNext();) {
			Transformation currentTransformation = (Transformation) transformationsIter
					.next();
			String currentTransformationName = currentTransformation.getName();

			// URI traceFilePri = ((MOFQvtProcessorImpl)
			// this.qvtProcessor).getWorkingLocation
			// ().appendSegment(MOFQvtTraceAdapter
			// .TRACE_FILE_NAME).appendFileExtension(currentTransformationName);
			Resource tracePartition = ((JMIQvtProcessorImpl) this.qvtProcessor)
					.getResourceSetForTraces();
			// try {
			// tracePartition = partitionSet.getResource(traceFilePri, true);
			// } catch (Exception exception) {
			// // if (exception instanceof FileNotFoundException ||
			// exception.getCause() instanceof
			// // FileNotFoundException) {
			// // clean up
			// URI traceMMFileUri = ((MOFQvtProcessorImpl)
			// this.qvtProcessor).getWorkingLocation
			// ().appendSegment(currentTransformationName
			// ).appendFileExtension("ecore");
			// Resource traceMMResource =
			// partitionSet.getResource(traceMMFileUri, false);
			//
			// String nsURI = "urn:" + currentTransformationName + ".ecore";
			// partitionSet.getPackageRegistry().remove(nsURI);
			//
			// traceMMResource.unload();
			// if (tracePartition != null) {
			// tracePartition.unload();
			// }
			// if (tracePartition != null) {
			// partitionSet.getResources().remove(tracePartition);
			// }
			// partitionSet.getResources().remove(traceMMResource);
			//
			// if (tracePartition != null) {
			// partitionSet.getResources().remove(tracePartition);
			// }
			// if (this.allTracesInOneFile) {
			// break;
			// }
			// continue;// return new HashSet();
			// // }
			// // throw new RuntimeException(exception);
			// }
			// TODO getElement
			Collection tracePartitionContent = tracePartition.getContents();
			// List traceResourceContent = tracePartition...getContents();
			for (Iterator iterTraceResourceContent = tracePartitionContent
					.iterator(); iterTraceResourceContent.hasNext();) {
				EObject currentBindingObject = (EObject) iterTraceResourceContent
						.next();
				EClass currentBindingClass = (EClass) currentBindingObject.refMetaObject();
				// TODO traces constraint check !!
				Relation relation = this.lookupRelation(currentBindingClass);
				if (relation == null) {
					continue;
				}
				List args = new ArrayList(relation.getDomain().size());
				List domains = relation.getDomain();
				boolean isValidTrace = true;
				for (Iterator iter = domains.iterator(); iter.hasNext();) {
					Domain currentDomain = (Domain) iter.next();
					// TODO optimize
					List listStructuralFeatures = currentBindingClass
							.eContents();
					Iterator it = listStructuralFeatures.iterator();
					Object obj;
					EStructuralFeature structuralFeature = null;
					while (it.hasNext()) {
						obj = it.next();
						if (obj instanceof EStructuralFeature) {
							if (((EStructuralFeature) obj).getName().equals(
									currentDomain.getName()))
								structuralFeature = (EStructuralFeature) obj;
						}
					}
					if (structuralFeature == null) {
						/**
						 * Invalidate the trace when some domain variable cannot
						 * be found
						 */
						isValidTrace = false;
						break;
					}
					Object value = currentBindingObject
							.refGetValue(structuralFeature);
					if (value instanceof EObject) {
						EObject evalue = (EObject) value;
						if (PartitionHelper.getPartition(evalue) == null) {
							value = null;
						}
					}
					args
							.add(this.qvtProcessor.getStdLibAdapter().OclAny(
									value));
				}
				if (!isValidTrace) {
					continue;
				}

				// TODO use search with direction !!!
				Trace trace = new Trace(relation, args);
				if (traces.contains(trace)) {
					for (Iterator tracesIiter = traces.iterator(); tracesIiter
							.hasNext();) {
						Trace currentTrace = (Trace) tracesIiter.next();
						if (currentTrace.equals(trace)) {
							trace = currentTrace;
							break;
						}
					}
				} else {
					try {
						traces.add(trace);
					} catch (IllegalArgumentException illegalArgumentException) {
						// this can happen with older traces without a medini
						// identifier.
					}
				}

				// TODO add binding !!
				// check for null !!! remove
				boolean isValidBinding = true;
				Map binding = new HashMap();
				for (Iterator iter = relation.getVariable().iterator(); iter
						.hasNext();) {
					VariableDeclaration currentVariableDeclaration = (VariableDeclaration) iter
							.next();
					List listStructuralFeatures = currentBindingClass
							.eContents();
					Iterator it = listStructuralFeatures.iterator();
					Object obj;
					EStructuralFeature structuralFeature = null;
					while (it.hasNext()) {
						obj = it.next();
						if (obj instanceof EStructuralFeature) {
							if (((EStructuralFeature) obj).getName().equals(
									currentVariableDeclaration.getName()))
								structuralFeature = (EStructuralFeature) obj;
						}
					}

					// EStructuralFeature structuralFeature =
					// currentBindingClass.
					// getEStructuralFeature(currentVariableDeclaration
					// .getName());
					if (structuralFeature == null) {
						/**
						 * Should not be null for template variables! Fix for
						 * Bugzilla Bug 1805
						 */
						continue;
					}
					Object value = currentBindingObject
							.eGet(structuralFeature);
					if (value instanceof EObject) {
						EObject evalue = (EObject) value;
						if (PartitionHelper.getPartition(evalue) == null) {
							value = null;
							// isValidBinding=false;
							// break;
						}
					}
					binding.put(currentVariableDeclaration.getName(),
							this.qvtProcessor.getStdLibAdapter().OclAny(value));
				}
				if (isValidBinding) {
					trace.addBinding(binding);
					this.postAddBindingHook(trace, currentBindingObject,
							binding);
				}
			}

			// clean up

			// String nsURI = "urn:" + currentTransformationName + ".ecore";
			// partitionSet.getPackageRegistry().remove(nsURI);
			//
			// tracePartition.unload();
			// partitionSet.getResources().remove(tracePartition);

			if (this.allTracesInOneFile) {
				break;
			}

		}

		// for (Iterator transformationsIter =
		// this.allTransformations.iterator(); transformationsIter.hasNext();) {
		// Transformation currentTransformation = (Transformation)
		// transformationsIter.next();
		// String currentTransformationName = currentTransformation.getName();
		//
		// // clean up
		//
		// URI traceMMFileUri = ((MOFQvtProcessorImpl)
		// this.qvtProcessor).getWorkingLocation
		// ().appendSegment(currentTransformationName
		// ).appendFileExtension("ecore");
		// Resource traceMMResource =
		// partitionSet.getResource(traceMMFileUri, false);
		//
		// if (traceMMResource != null) {
		// traceMMResource.unload();
		// partitionSet.getResources().remove(traceMMResource);
		// }
		//
		// }

		return traces;
	}

	protected void postAddBindingHook(Trace trace,
			EObject currentBindingObject, Map binding) {
		// do nothing
	}

	private Transformation lookupTransformation(EPackage package1) {
		for (Iterator iter = this.allTransformations.iterator(); iter.hasNext();) {
			Transformation currenTransformation = (Transformation) iter.next();
			if (package1.getName() != null
					&& package1.getName()
							.equals(currenTransformation.getName())) {
				return currenTransformation;
			}
		}
		return null;
	}

	private Relation lookupRelation(EClass relation) {

		Transformation transformation = this
				.lookupTransformation((EPackage) relation.eContainer());

		// Transformation transformation =
		// this.lookupTransformation(relataion.getEPackage());
		if (transformation == null) {
			return null;
		}
		List relations = transformation.getRule();
		for (Iterator relationsIter = relations.iterator(); relationsIter
				.hasNext();) {
			Relation currentRelation = (Relation) relationsIter.next();
			if (currentRelation.getName() != null
					&& currentRelation.getName().equals(relation.getName())) {
				return currentRelation;
			}
		}
		return null;
	}

	private EPackage lookupTransformation(Resource parition,
			Transformation transformation) {
		List rootPackages = (List) parition.getContents();
		for (Iterator iter = rootPackages.iterator(); iter.hasNext();) {
			//TODO check with istanceof
			EPackage currentPackage = (EPackage) iter.next();
			if (currentPackage.getName() != null
					&& currentPackage.getName()
							.equals(transformation.getName())) {
				return currentPackage;
			}
		}
		return null;
	}

	private EClass lookupRelation(Resource partition, Relation relation) {
		// String nsURI = "urn:" + relation.getTransformation().getName() +
		// ".ecore";
		// TODO getPackagebyName
		Iterator it = partition.getAllContents();
		Object obj = null;
		EPackage currentMofTransformation = null;
		while (it.hasNext()) {
			obj = it.next();
			if (obj instanceof EPackage && ((EPackage) obj).getName() != null) {
				if (((EPackage) obj).getName().equals(
						relation.getTransformation().getName())) {
					currentMofTransformation = (EPackage) obj;
					break;
				}
			}
		}
		// EPackage currentMofTransformation = (EPackage)
		// partition.getElements().getPackageRegistry().get(nsURI);
		if (currentMofTransformation == null) {
			throw new RuntimeException();
		}
		List listClassifier = currentMofTransformation.eContents();
		Iterator it2 = listClassifier.iterator();
		Object obj2;
		EStructuralFeature structuralFeature = null;
		while (it2.hasNext()) {
			obj2 = it2.next();
			if (obj2 instanceof EClass) {
				if (((EClass) obj2).getName().equals(relation.getName()))
					return (EClass) obj2;
			}
		}
		return null;
	}

	// TODO check how this works in JMI
	private void loadTraceMM() {
		Resource partitionSet = this.getResourceSetForTraces();

		// partitionSet.getResourceFactoryRegistry().getExtensionToFactoryMap().
		// put(Resource.Factory.Registry.DEFAULT_EXTENSION, new
		// XMIResourceFactoryImpl());
//		this.fillPackageRegistry(partitionSet);
//
//		for (Iterator iter = this.allTransformations.iterator(); iter.hasNext();) {
//			Transformation currentTransformation = (Transformation) iter.next();
//			String currentTransformationName = currentTransformation.getName();
//			URI traceMMFileUri = ((MOFQvtProcessorImpl) this.qvtProcessor)
//					.getWorkingLocation().appendSegment(
//							currentTransformationName).appendFileExtension(
//							"ecore");
//			String nsURI = "urn:" + currentTransformationName + ".ecore";
//			Resource traceMMPartition = null;
//			try {
//				traceMMPartition = partitionSet.getResource(traceMMFileUri,
//						true);
//				this.traceMetamodelResources.add(traceMMPartition);
//				partitionSet.getPackageRegistry().put(nsURI,
//						traceMMPartition.getContents().get(0));
//			} catch (Exception exception) {
//				// if (exception instanceof FileNotFoundException ||
//				// exception.getCause() instanceof
//				// FileNotFoundException) {
//				if (traceMMPartition != null) {
//					partitionSet.getResources().remove(traceMMPartition);
//				}
//
//				this.buildTraceMMForTransformation(partitionSet,
//						currentTransformation);
//				// } else {
//				// throw new RuntimeException(exception);
//				// }
//			}
//		}

		for (Iterator iter = this.allTransformations.iterator(); iter.hasNext();) {
			Transformation currentTransformation = (Transformation) iter.next();
			Resource traceMMPartition = ((JMIQvtProcessorImpl) this.qvtProcessor)
					.getTraceMMPartition();

			if (traceMMPartition != null) {
				this.traceMetamodelResources.add(traceMMPartition);
			} else {

				this.buildTraceMMForTransformation(partitionSet,
						currentTransformation);
			}
		}

	}

//	// TODO check how this works in JMI
//	protected void fillPackageRegistry(Resource partition) {
//		partition.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(),
//				EcorePackage.eINSTANCE);
//	}

	/**
	 * pre: the target and source resources are in the same resource set
	 * 
	 */
	private void buildTraceMM() {
		// DO increment !!
		Resource partitionSet = this.getResourceSetForTraces();

		//partitionSet.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(
		// ), EcorePackage.eINSTANCE);

		for (Iterator iter = this.allTransformations.iterator(); iter.hasNext();) {
			Transformation currentTransformation = (Transformation) iter.next();
			this.buildTraceMMForTransformation(partitionSet,
					currentTransformation);
		}
	}

	private Resource getResourceSetForTraces() {
		return ((JMIQvtProcessorImpl) this.qvtProcessor)
				.getResourceSetForTraces();
	}

	private void buildTraceMMForTransformation(Resource partition,
			Transformation currentTransformation) {
		String currentTransformationName = currentTransformation.getName();
		// URI traceMMFileUri = ((MOFQvtProcessorImpl)
		// this.qvtProcessor).getWorkingLocation
		// ().appendSegment(currentTransformationName
		// ).appendFileExtension("ecore");
		Resource traceMMPartition = ((JMIQvtProcessorImpl) this.qvtProcessor)
				.getTraceMMPartition();

		EPackage currentTransformationPackage = (EPackage) getMofRefPackage().getMofPackage()
				.refCreateInstance();
		// currentTransformationPackage.setNsPrefix(currentTransformationName);
		// String nsURI = "urn:" + currentTransformationName + ".ecore";
		// currentTransformationPackage.setNsURI("urn:" +
		// currentTransformationName + ".ecore");
		// partition.getPackageRegistry().put(nsURI,
		// currentTransformationPackage);
		//TODO ???
		traceMMPartition.assignElement(currentTransformationPackage);
		currentTransformationPackage.setName(currentTransformation.getName());
		List relationList = currentTransformation.getRule();
		for (Iterator iterator = relationList.iterator(); iterator.hasNext();) {
			Relation currentRelation = (Relation) iterator.next();
			EClass currentRelationClass = (EClass) mofRefPackage.eClass().refCreateInstance();
			this.setSuperTypes(currentRelationClass);
			currentTransformationPackage.eContents()
					.add(currentRelationClass);
			currentRelationClass.setName(currentRelation.getName());
			List currentRelataionVariables = currentRelation.getVariable();
			for (Iterator iterator2 = currentRelataionVariables.iterator(); iterator2
					.hasNext();) {
				VariableDeclaration currentVariableDeclaration = (VariableDeclaration) iterator2
						.next();
				Classifier currentVariableType = currentVariableDeclaration
						.getType();
				if (currentVariableType instanceof Primitive
						|| currentVariableType instanceof Enumeration) {
					EAttribute currentAttribute =(EAttribute) mofRefPackage.getAttribute().refCreateInstance();
					currentRelationClass.eContents().add(currentAttribute);
					currentAttribute.setName(currentVariableDeclaration
							.getName());
					// TODO currentAttribute.setMultiplicity();
					EReference mult = JmiHelper.createMultiplicity(0, 1,
							false, false);
					currentAttribute.setUpperBound(mult.getUpperBound());
					currentAttribute.setLowerBound(mult.getLowerBound());
					

					if (currentVariableType instanceof Enumeration) {
						currentAttribute.setEType((EClassifier) JmiHelper.getEnumeratorObject());
					} else if (currentVariableType instanceof IntegerType) {
						currentAttribute.setEType((EClassifier) JmiHelper.getIntegerObject());
					} else if (currentVariableType instanceof BooleanType) {
						currentAttribute.setEType((EClassifier) JmiHelper.getBooleanObject());
					} else if (currentVariableType instanceof RealType) {
						currentAttribute.setEType((EClassifier) JmiHelper.getDoubleObject());
					} else if (currentVariableType instanceof StringType) {
						currentAttribute.setEType((EClassifier) JmiHelper.getStringObject());
					} else {
						throw new RuntimeException();
					}
				} else if (currentVariableType instanceof OclModelElementType) {
					// TODO also create EReference, EReference, References
					// and link together
					
					OclModelElementTypeImpl currentOclModelElementType = (OclModelElementTypeImpl) currentVariableType;
					EClassifier mofType = currentOclModelElementType
							.getImplementation();
					//*************************************
					EReference currentAssocation =(EReference) mofRefPackage.getAssociation().refCreateInstance();
					EReference leftAssocationEnd=(EReference) mofRefPackage.getAssociationEnd().refCreateInstance();
					EReference rightAssocationEnd=(EReference) mofRefPackage.getAssociationEnd().refCreateInstance();
					currentAssocation.eContents().add(leftAssocationEnd);
					currentAssocation.eContents().add(rightAssocationEnd);
					
					
					//**************************************	
					EReference currentReference = (EReference) mofRefPackage.getReference().refCreateInstance();
					currentRelationClass.eContents().add(currentReference);
					currentReference.setName(currentVariableDeclaration
							.getName());
					currentReference.setEType(mofType);
					
					//********************************
					currentReference.setReferencedEnd(leftAssocationEnd);
					currentReference.setExposedEnd(rightAssocationEnd);
					leftAssocationEnd.setEType(mofType);
					rightAssocationEnd.setEType(currentRelationClass);
					EReference mult = JmiHelper.createMultiplicity(0, 1,
							false, false);
					
					currentReference.setUpperBound(mult.getUpperBound());
					currentReference.setLowerBound(mult.getLowerBound());
					
				}
			}
		}

		this.traceMetamodelResources.add(traceMMPartition);
		try {
			// TODO
			if(!connection.getTransientPartitions().contains(traceMMPartition)) {
				connection.save();
			}
			//traceMMPartition.save(Collections.EMPTY_MAP);
			// TODO unload !!
		} catch (NullPartitionNotEmptyException e) {
			throw new RuntimeException(e);
		} catch (ReferencedTransientElementsException e) {
			throw new RuntimeException(e);
		} catch (PartitionsNotSavedException e) {
			throw new RuntimeException(e);
		}
	}

	private EPackage getMofRefPackage() {
		if(mofRefPackage == null) {
			mofRefPackage = connection.getPackage(EPackage.PACKAGE_DESCRIPTOR);
		}
		return mofRefPackage;
	}

	protected void setSuperTypes(EClass currentRelationClass) {
		// do nothing
	}

	/**
	 * Returns the part of the given <code>uri</code> from the project name.
	 * 
	 * @param uri
	 *            the URI
	 * @param left
	 *            <code>true</code> for the left project, false for the right
	 *            project.
	 * @return the part of the given <code>uri</code> from the project name.
	 * @see #getPathRelativeToProject(URI, boolean)
	 */
	private static String getPathFromProject(String projectName, URI pri) {
		String priString = pri.toString();
		int projectIndex = priString.indexOf(projectName);
		return priString.substring(projectIndex);
	}

//	/**
//	 * Returns the part of the given <code>uri</code> relative to the project
//	 * name.
//	 * 
//	 * @param uri
//	 *            the URI
//	 * @param left
//	 *            <code>true</code> for the left project, false for the right
//	 *            project.
//	 * @return the part of the given <code>uri</code> relative to the project
//	 *         name.
//	 */
//	private static String getPathRelativeToProject(URI modelPRI, URI tracePRI) {
//		String projectName = MOFQvtTraceAdapter.getProjectName(modelPRI);
//		String pathFromProject = MOFQvtTraceAdapter.getPathFromProject(
//				projectName, tracePRI);
//		return pathFromProject.substring(projectName.length() + 1);
//	}
//
//	private static String getProjectName(URI modelPRI) {
//		return modelPRI.trimSegments(1).lastSegment();
//	}

	protected Collection getTraceMetamodelResources() {
		return this.traceMetamodelResources;
	}
}
