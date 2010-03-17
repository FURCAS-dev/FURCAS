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

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

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

	private Connection connection;

	public JMIQvtTraceAdapter(Connection connection) {
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

	private ModelPackage mofRefPackage;

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

		ModelPartition resourceSet = this.getResourceSetForTraces();
		Map traceResourceMap = new HashMap();

		for (Iterator iter = traces.iterator(); iter.hasNext();) {
			Trace currentTrace = (Trace) iter.next();
			Relation currentRelation = currentTrace.getRelation();
			String currentTransformationName = currentRelation
					.getTransformation().getName();
			ModelPartition traceResource = ((JMIQvtProcessorImpl) this.qvtProcessor)
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

	// private void saveTracePartitions(Map traceResourceMap, ModelPartition
	// partition) {
	// Set transformationNames = traceResourceMap.keySet();
	//
	// for (Iterator iter = transformationNames.iterator(); iter.hasNext();) {
	// String currentTransformationName = (String) iter.next();
	// ModelPartition currentPartition = (ModelPartition)
	// traceResourceMap.get(currentTransformationName);
	//
	// PRI traceMMFileUri = ((MOFQvtProcessorImpl)
	// this.qvtProcessor).getWorkingLocation
	// ().appendSegment(currentTransformationName).appendFileExtension("ecore");
	// ModelPartition traceMMResource = partition.getResource(traceMMFileUri,
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
			ModelPartition partitionSet, ModelPartition tracePartition) {

		MofClass relationMetaClass = this
				.lookupRelation(((JMIQvtProcessorImpl) this.qvtProcessor)
						.getTraceMMPartition(), relation);
		List bindings = trace.getBindings();

		if (bindings.size() == 0) {
			// There may be transformations with no resulting bindings, so
			// comment next line

			// throw new
			// RuntimeException("Binding are not suppose to be empty");
		}

		RefClass refClassForMofClass = ((JMIQvtProcessorImpl) this.qvtProcessor)
				.getConnection().getJmiHelper().getRefClassForMofClass(
				relationMetaClass);
		if(refClassForMofClass == null) {
			//TODO this is a workaround for not having the trace metamodel available
			return;
		}
		for (Iterator iterator = bindings.iterator(); iterator.hasNext();) {
			Map currentBinding = (Map) iterator.next();
			Set keys = currentBinding.keySet();
			
			RefObject traceModelElement = refClassForMofClass.refCreateInstance();
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
			OclAny bindingValue, MofClass relationMetaClass,
			RefObject bindingModelElement, Relation relation) {
		List listStructuralFeatures = relationMetaClass.getContents();
		Iterator it = listStructuralFeatures.iterator();
		Object obj;
		StructuralFeature currentStructuralFeature = null;
		while (it.hasNext()) {
			obj = it.next();
			if (obj instanceof StructuralFeature) {
				if (((StructuralFeature) obj).getName().equals(bindingVariable))
					currentStructuralFeature = (StructuralFeature) obj;
			}
		}

		// StructuralFeature currentStructuralFeature =
		// relationMetaClass.getEStructuralFeature(bindingVariable);
		Object currentJavaValue = bindingValue.asJavaObject();
		bindingModelElement.refSetValue(currentStructuralFeature,
				currentJavaValue);
		this.setQvtTraceFiles(currentJavaValue, PartitionHelper.getPartition(
				bindingModelElement).getPri());
	}

	protected void setQvtTraceFiles(Object modelElement, PRI traceResourcePRI) {
		// do nothing
	}

	protected void restoreTraceIdentifier(Trace trace, Map binding,
			RefObject bindingModelElement) {
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
	// private ModelPartition getTraceResource(String currentTransformationName,
	// Map traceResourceMap, ModelPartition partitionSet) {
	//
	// if (this.allTracesInOneFile &&
	// this.allTransformations.iterator().hasNext()) {
	// // get the name of the main transformation if allTracesInOneFile is true
	// currentTransformationName = ((Transformation)
	// this.allTransformations.iterator().next()).getName();
	// }
	//
	// ModelPartition tracePartition = (ModelPartition)
	// traceResourceMap.get(currentTransformationName);
	//
	// if (tracePartition != null) {
	// return tracePartition;
	// }
	//
	// PRI traceFilePri = ((MOFQvtProcessorImpl)
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

		ModelPartition partitionSet = this.getResourceSetForTraces();

		for (Iterator transformationsIter = this.allTransformations.iterator(); transformationsIter
				.hasNext();) {
			Transformation currentTransformation = (Transformation) transformationsIter
					.next();
			String currentTransformationName = currentTransformation.getName();

			// PRI traceFilePri = ((MOFQvtProcessorImpl)
			// this.qvtProcessor).getWorkingLocation
			// ().appendSegment(MOFQvtTraceAdapter
			// .TRACE_FILE_NAME).appendFileExtension(currentTransformationName);
			ModelPartition tracePartition = ((JMIQvtProcessorImpl) this.qvtProcessor)
					.getResourceSetForTraces();
			// try {
			// tracePartition = partitionSet.getResource(traceFilePri, true);
			// } catch (Exception exception) {
			// // if (exception instanceof FileNotFoundException ||
			// exception.getCause() instanceof
			// // FileNotFoundException) {
			// // clean up
			// PRI traceMMFileUri = ((MOFQvtProcessorImpl)
			// this.qvtProcessor).getWorkingLocation
			// ().appendSegment(currentTransformationName
			// ).appendFileExtension("ecore");
			// ModelPartition traceMMResource =
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
			Collection tracePartitionContent = tracePartition.getElements();
			// List traceResourceContent = tracePartition...getContents();
			for (Iterator iterTraceResourceContent = tracePartitionContent
					.iterator(); iterTraceResourceContent.hasNext();) {
				RefObject currentBindingObject = (RefObject) iterTraceResourceContent
						.next();
				MofClass currentBindingClass = (MofClass) currentBindingObject.refMetaObject();
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
							.getContents();
					Iterator it = listStructuralFeatures.iterator();
					Object obj;
					StructuralFeature structuralFeature = null;
					while (it.hasNext()) {
						obj = it.next();
						if (obj instanceof StructuralFeature) {
							if (((StructuralFeature) obj).getName().equals(
									currentDomain.getName()))
								structuralFeature = (StructuralFeature) obj;
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
					if (value instanceof RefObject) {
						RefObject evalue = (RefObject) value;
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
							.getContents();
					Iterator it = listStructuralFeatures.iterator();
					Object obj;
					StructuralFeature structuralFeature = null;
					while (it.hasNext()) {
						obj = it.next();
						if (obj instanceof StructuralFeature) {
							if (((StructuralFeature) obj).getName().equals(
									currentVariableDeclaration.getName()))
								structuralFeature = (StructuralFeature) obj;
						}
					}

					// StructuralFeature structuralFeature =
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
							.refGetValue(structuralFeature);
					if (value instanceof RefObject) {
						RefObject evalue = (RefObject) value;
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
		// PRI traceMMFileUri = ((MOFQvtProcessorImpl)
		// this.qvtProcessor).getWorkingLocation
		// ().appendSegment(currentTransformationName
		// ).appendFileExtension("ecore");
		// ModelPartition traceMMResource =
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
			RefObject currentBindingObject, Map binding) {
		// do nothing
	}

	private Transformation lookupTransformation(MofPackage package1) {
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

	private Relation lookupRelation(MofClass relation) {

		Transformation transformation = this
				.lookupTransformation((MofPackage) relation.getContainer());

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

	private MofPackage lookupTransformation(ModelPartition parition,
			Transformation transformation) {
		List rootPackages = (List) parition.getElements();
		for (Iterator iter = rootPackages.iterator(); iter.hasNext();) {
			//TODO check with istanceof
			MofPackage currentPackage = (MofPackage) iter.next();
			if (currentPackage.getName() != null
					&& currentPackage.getName()
							.equals(transformation.getName())) {
				return currentPackage;
			}
		}
		return null;
	}

	private MofClass lookupRelation(ModelPartition partition, Relation relation) {
		// String nsURI = "urn:" + relation.getTransformation().getName() +
		// ".ecore";
		// TODO getPackagebyName
		Iterator it = partition.getElements().iterator();
		Object obj = null;
		MofPackage currentMofTransformation = null;
		while (it.hasNext()) {
			obj = it.next();
			if (obj instanceof MofPackage && ((MofPackage) obj).getName() != null) {
				if (((MofPackage) obj).getName().equals(
						relation.getTransformation().getName())) {
					currentMofTransformation = (MofPackage) obj;
					break;
				}
			}
		}
		// MofPackage currentMofTransformation = (MofPackage)
		// partition.getElements().getPackageRegistry().get(nsURI);
		if (currentMofTransformation == null) {
			throw new RuntimeException();
		}
		List listClassifier = currentMofTransformation.getContents();
		Iterator it2 = listClassifier.iterator();
		Object obj2;
		StructuralFeature structuralFeature = null;
		while (it2.hasNext()) {
			obj2 = it2.next();
			if (obj2 instanceof MofClass) {
				if (((MofClass) obj2).getName().equals(relation.getName()))
					return (MofClass) obj2;
			}
		}
		return null;
	}

	// TODO check how this works in JMI
	private void loadTraceMM() {
		ModelPartition partitionSet = this.getResourceSetForTraces();

		// partitionSet.getResourceFactoryRegistry().getExtensionToFactoryMap().
		// put(Resource.Factory.Registry.DEFAULT_EXTENSION, new
		// XMIResourceFactoryImpl());
//		this.fillPackageRegistry(partitionSet);
//
//		for (Iterator iter = this.allTransformations.iterator(); iter.hasNext();) {
//			Transformation currentTransformation = (Transformation) iter.next();
//			String currentTransformationName = currentTransformation.getName();
//			PRI traceMMFileUri = ((MOFQvtProcessorImpl) this.qvtProcessor)
//					.getWorkingLocation().appendSegment(
//							currentTransformationName).appendFileExtension(
//							"ecore");
//			String nsURI = "urn:" + currentTransformationName + ".ecore";
//			ModelPartition traceMMPartition = null;
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
			ModelPartition traceMMPartition = ((JMIQvtProcessorImpl) this.qvtProcessor)
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
//	protected void fillPackageRegistry(ModelPartition partition) {
//		partition.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(),
//				EcorePackage.eINSTANCE);
//	}

	/**
	 * pre: the target and source resources are in the same resource set
	 * 
	 */
	private void buildTraceMM() {
		// DO increment !!
		ModelPartition partitionSet = this.getResourceSetForTraces();

		//partitionSet.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(
		// ), EcorePackage.eINSTANCE);

		for (Iterator iter = this.allTransformations.iterator(); iter.hasNext();) {
			Transformation currentTransformation = (Transformation) iter.next();
			this.buildTraceMMForTransformation(partitionSet,
					currentTransformation);
		}
	}

	private ModelPartition getResourceSetForTraces() {
		return ((JMIQvtProcessorImpl) this.qvtProcessor)
				.getResourceSetForTraces();
	}

	private void buildTraceMMForTransformation(ModelPartition partition,
			Transformation currentTransformation) {
		String currentTransformationName = currentTransformation.getName();
		// PRI traceMMFileUri = ((MOFQvtProcessorImpl)
		// this.qvtProcessor).getWorkingLocation
		// ().appendSegment(currentTransformationName
		// ).appendFileExtension("ecore");
		ModelPartition traceMMPartition = ((JMIQvtProcessorImpl) this.qvtProcessor)
				.getTraceMMPartition();

		MofPackage currentTransformationPackage = (MofPackage) getMofRefPackage().getMofPackage()
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
			MofClass currentRelationClass = (MofClass) mofRefPackage.getMofClass()
					.refCreateInstance();
			this.setSuperTypes(currentRelationClass);
			currentTransformationPackage.getContents()
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
					Attribute currentAttribute =(Attribute) mofRefPackage.getAttribute().refCreateInstance();
					currentRelationClass.getContents().add(currentAttribute);
					currentAttribute.setName(currentVariableDeclaration
							.getName());
					// TODO currentAttribute.setMultiplicity();
					MultiplicityType mult = JmiHelper.createMultiplicity(0, 1,
							false, false);
					currentAttribute.setMultiplicity(mult);

					if (currentVariableType instanceof Enumeration) {
						currentAttribute.setType((com.sap.tc.moin.repository.mmi.model.Classifier) JmiHelper.getEnumeratorObject());
					} else if (currentVariableType instanceof IntegerType) {
						currentAttribute.setType((com.sap.tc.moin.repository.mmi.model.Classifier) JmiHelper.getIntegerObject());
					} else if (currentVariableType instanceof BooleanType) {
						currentAttribute.setType((com.sap.tc.moin.repository.mmi.model.Classifier) JmiHelper.getBooleanObject());
					} else if (currentVariableType instanceof RealType) {
						currentAttribute.setType((com.sap.tc.moin.repository.mmi.model.Classifier) JmiHelper.getDoubleObject());
					} else if (currentVariableType instanceof StringType) {
						currentAttribute.setType((com.sap.tc.moin.repository.mmi.model.Classifier) JmiHelper.getStringObject());
					} else {
						throw new RuntimeException();
					}
				} else if (currentVariableType instanceof OclModelElementType) {
					// TODO also create Association, AssociationEnd, References
					// and link together
					
					OclModelElementTypeImpl currentOclModelElementType = (OclModelElementTypeImpl) currentVariableType;
					com.sap.tc.moin.repository.mmi.model.Classifier mofType = currentOclModelElementType
							.getImplementation();
					//*************************************
					Association currentAssocation =(Association) mofRefPackage.getAssociation().refCreateInstance();
					AssociationEnd leftAssocationEnd=(AssociationEnd) mofRefPackage.getAssociationEnd().refCreateInstance();
					AssociationEnd rightAssocationEnd=(AssociationEnd) mofRefPackage.getAssociationEnd().refCreateInstance();
					currentAssocation.getContents().add(leftAssocationEnd);
					currentAssocation.getContents().add(rightAssocationEnd);
					
					
					//**************************************	
					Reference currentReference = (Reference) mofRefPackage.getReference().refCreateInstance();
					currentRelationClass.getContents().add(currentReference);
					currentReference.setName(currentVariableDeclaration
							.getName());
					currentReference.setType(mofType);
					
					//********************************
					currentReference.setReferencedEnd(leftAssocationEnd);
					currentReference.setExposedEnd(rightAssocationEnd);
					leftAssocationEnd.setType(mofType);
					rightAssocationEnd.setType(currentRelationClass);
					MultiplicityType mult = JmiHelper.createMultiplicity(0, 1,
							false, false);
					currentReference.setMultiplicity(mult);
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

	private ModelPackage getMofRefPackage() {
		if(mofRefPackage == null) {
			mofRefPackage = connection.getPackage(ModelPackage.PACKAGE_DESCRIPTOR);
		}
		return mofRefPackage;
	}

	protected void setSuperTypes(MofClass currentRelationClass) {
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
	private static String getPathFromProject(String projectName, PRI pri) {
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
//	private static String getPathRelativeToProject(PRI modelPRI, PRI tracePRI) {
//		String projectName = MOFQvtTraceAdapter.getProjectName(modelPRI);
//		String pathFromProject = MOFQvtTraceAdapter.getPathFromProject(
//				projectName, tracePRI);
//		return pathFromProject.substring(projectName.length() + 1);
//	}
//
//	private static String getProjectName(PRI modelPRI) {
//		return modelPRI.trimSegments(1).lastSegment();
//	}

	protected Collection getTraceMetamodelResources() {
		return this.traceMetamodelResources;
	}
}
