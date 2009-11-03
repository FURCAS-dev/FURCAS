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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.oslo.ocl20.bridge4emf.OclModelElementTypeImpl;
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
 * The standard trace adapter for EMF models. This trace adapter derives the trace metamodel from
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author ekine Jörg Kiegeland
 * 
 */
public class EMFQvtTraceAdapter implements QvtTraceAdapter {

	/**
	 * The QVT processor.
	 */
	protected QvtProcessorImpl qvtProcessor;

	/**
	 * The name of the trace file without its extension.
	 */
	public static final String TRACE_FILE_NAME = "trace";

	/**
	 * All transformations that have been executed. The fisrt transformation is the top level transformation and all other are imported transformations.
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

	/**
	 * Sets the QVT processor for this trace adapter.
	 * 
	 * @param qvtProcessor
	 *            the QVT processor.
	 */
	public void setQvtProcessor(QvtProcessorImpl qvtProcessor) {
		this.qvtProcessor = qvtProcessor;
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
	 *            the transformations. The first transformation in the collection must be the top level one, all others must be imported transformations.
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
			QvtSemanticAnalyserThreadPool.getLogger().println("Begin storing traces");
		}
		this.buildTraceMM();

		ResourceSet resourceSet = this.getResourceSetForTraces();
		Map traceResourceMap = new HashMap();

		for (Iterator iter = traces.iterator(); iter.hasNext();) {
			Trace currentTrace = (Trace) iter.next();
			Relation currentRelation = currentTrace.getRelation();
			String currentTransformationName = currentRelation.getTransformation().getName();
			Resource traceResource = this.getTraceResource(currentTransformationName, traceResourceMap, resourceSet);
			this.storeTrace(currentTrace, currentRelation, resourceSet, traceResource);
		}
		if (this.qvtProcessor.isDebugMode()) {
			QvtSemanticAnalyserThreadPool.getLogger().println("Saving traces to disk");
		}
		this.saveTraceResources(traceResourceMap, resourceSet);
		if (this.qvtProcessor.isDebugMode()) {
			QvtSemanticAnalyserThreadPool.getLogger().println("Stopped saving traces to disk");
		}
		Date y = new Date();

		if (this.qvtProcessor.isDebugMode()) {
			QvtSemanticAnalyserThreadPool.getLogger().println("(Storing traces done in in " + (y.getTime() - x.getTime()) + " ms )");
		}
	}

	private void saveTraceResources(Map traceResourceMap, ResourceSet resourceSet) {
		Set transformationNames = traceResourceMap.keySet();

		for (Iterator iter = transformationNames.iterator(); iter.hasNext();) {
			String currentTransformationName = (String) iter.next();
			Resource currentResource = (Resource) traceResourceMap.get(currentTransformationName);

			URI traceMMFileUri = ((EMFQvtProcessorImpl) this.qvtProcessor).getWorkingLocation().appendSegment(currentTransformationName).appendFileExtension("ecore");
			Resource traceMMResource = resourceSet.getResource(traceMMFileUri, false);

			String nsURI = "urn:" + currentTransformationName + ".ecore";
			resourceSet.getPackageRegistry().remove(nsURI);

			try {
				currentResource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				traceMMResource.unload();
				currentResource.unload();
				resourceSet.getResources().remove(currentResource);
				resourceSet.getResources().remove(traceMMResource);
			}
		}
	}

	private void storeTrace(Trace trace, Relation relation, ResourceSet resourceSet, Resource traceResource) {

		EClass relationMetaClass = this.lookupRelation(resourceSet, relation);
		List bindings = trace.getBindings();

		if (bindings.size() == 0) {
			// There may be transformations with no resulting bindings, so comment next line

			// throw new RuntimeException("Binding are not suppose to be empty");
		}

		for (Iterator iterator = bindings.iterator(); iterator.hasNext();) {
			Map currentBinding = (Map) iterator.next();
			Set keys = currentBinding.keySet();
			EObject traceModelElement = relationMetaClass.getEPackage().getEFactoryInstance().create(relationMetaClass);
			this.restoreTraceIdentifier(trace, currentBinding, traceModelElement);
			traceResource.getContents().add(traceModelElement);

			for (Iterator iterator1 = keys.iterator(); iterator1.hasNext();) {
				String currentKey = (String) iterator1.next();
				OclAny currentOclValue = (OclAny) currentBinding.get(currentKey);
				this.storeBindingVariable(currentKey, currentOclValue, relationMetaClass, traceModelElement, relation);
			}
		}
	}

	private void storeBindingVariable(String bindingVariable, OclAny bindingValue, EClass relationMetaClass, EObject bindingModelElement, Relation relation) {

		EStructuralFeature currentStructuralFeature = relationMetaClass.getEStructuralFeature(bindingVariable);
		Object currentJavaValue = bindingValue.asJavaObject();
		bindingModelElement.eSet(currentStructuralFeature, currentJavaValue);
		this.setQvtTraceFiles(currentJavaValue, bindingModelElement.eResource().getURI());
	}

	protected void setQvtTraceFiles(Object modelElement, URI traceResourceURI) {
		// do nothing
	}

	protected void restoreTraceIdentifier(Trace trace, Map binding, EObject bindingModelElement) {
		// do nothing
	}

	/**
	 * Returns the trace resource for the given transformation. If the given trace resource map already contains one, it is returned. Otherwise an new resource is created in the
	 * given resource set, stored in the map and returned.
	 * 
	 * @param currentTransformationName
	 *            the transformation name
	 * @param traceResourceMap
	 *            the trace resource map to look for an existing resource or store a new one.
	 * @param resourceSet
	 *            the resource set for creating a new resource.
	 * @return the trace resource for the given transformation.
	 */
	private Resource getTraceResource(String currentTransformationName, Map traceResourceMap, ResourceSet resourceSet) {

		if (this.allTracesInOneFile && this.allTransformations.iterator().hasNext()) {
			// get the name of the main transformation if allTracesInOneFile is true
			currentTransformationName = ((Transformation) this.allTransformations.iterator().next()).getName();
		}

		Resource traceResource = (Resource) traceResourceMap.get(currentTransformationName);

		if (traceResource != null) {
			return traceResource;
		}

		if (traceResource != null) {
			return traceResource;
		}

		URI traceFileUri = ((EMFQvtProcessorImpl) this.qvtProcessor).getWorkingLocation().appendSegment(EMFQvtTraceAdapter.TRACE_FILE_NAME).appendFileExtension(currentTransformationName);

		try {
			traceResource = resourceSet.getResource(traceFileUri, false);
		} catch (Exception exception) {
			// this occurs when no traces exist.
		}

		if (traceResource == null) {
			traceResource = resourceSet.createResource(traceFileUri);
		} else {
			// If the resource set already has the trace resource caused by some other action such as editing outside,
			// the QVT engine, its contents must be cleared.
			traceResource.getContents().clear();
		}

		traceResourceMap.put(currentTransformationName, traceResource);
		return traceResource;
	}

	/**
	 * Determines whether the given <code>variable</code> is a domain variable.
	 * 
	 * @param variable
	 *            the variable to check.
	 * @param domains
	 *            the domains.
	 * @return true, if the name of at one domain is equal to the given variable. False otherwise.
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
	 * Returns the name of the transformation that import the given transformation. The name of the first transformation in the <code>allTransformations</code> is always returned
	 * because it is the importing transformation of all transformations. Therefore if the given transformation name is the importing tranformation, it will be returned.
	 * 
	 * @param transformationName
	 *            the name of the imported transformation.
	 * @return the transformation importing the given transformation.
	 */
	private String getImportingTransformationName(String transformationName) {
		return ((Transformation) this.allTransformations.iterator().next()).getName();
	}

	public Collection loadTraces() {
		this.loadTraceMM();
		Set traces = new HashSet();

		ResourceSet resourceSet = this.getResourceSetForTraces();

		for (Iterator transformationsIter = this.allTransformations.iterator(); transformationsIter.hasNext();) {
			Transformation currentTransformation = (Transformation) transformationsIter.next();
			String currentTransformationName = currentTransformation.getName();

			URI traceFileUri = ((EMFQvtProcessorImpl) this.qvtProcessor).getWorkingLocation().appendSegment(EMFQvtTraceAdapter.TRACE_FILE_NAME).appendFileExtension(currentTransformationName);
			Resource traceResource = null;
			try {
				traceResource = resourceSet.getResource(traceFileUri, true);
			} catch (Exception exception) {
				// if (exception instanceof FileNotFoundException || exception.getCause() instanceof
				// FileNotFoundException) {
				// clean up
				URI traceMMFileUri = ((EMFQvtProcessorImpl) this.qvtProcessor).getWorkingLocation().appendSegment(currentTransformationName).appendFileExtension("ecore");
				Resource traceMMResource = resourceSet.getResource(traceMMFileUri, false);

				String nsURI = "urn:" + currentTransformationName + ".ecore";
				resourceSet.getPackageRegistry().remove(nsURI);

				traceMMResource.unload();
				if (traceResource != null) {
					traceResource.unload();
				}
				if (traceResource != null) {
					resourceSet.getResources().remove(traceResource);
				}
				resourceSet.getResources().remove(traceMMResource);

				if (traceResource != null) {
					resourceSet.getResources().remove(traceResource);
				}
				if (this.allTracesInOneFile) {
					break;
				}
				continue;// return new HashSet();
				// }
				// throw new RuntimeException(exception);
			}

			List traceResourceContent = traceResource.getContents();
			for (Iterator iterTraceResourceContent = traceResourceContent.iterator(); iterTraceResourceContent.hasNext();) {
				EObject currentBindingObject = (EObject) iterTraceResourceContent.next();
				EClass currentBindingClass = currentBindingObject.eClass();
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
					EStructuralFeature structuralFeature = currentBindingClass.getEStructuralFeature(currentDomain.getName());
					if (structuralFeature == null) {
						/**
						 * Invalidate the trace when some domain variable cannot be found
						 */
						isValidTrace = false;
						break;
					}
					Object value = currentBindingObject.eGet(structuralFeature);
					if (value instanceof EObject) {
						EObject evalue = (EObject) value;
						if (evalue.eResource() == null) {
							value = null;
						}
					}
					args.add(this.qvtProcessor.getStdLibAdapter().OclAny(value));
				}
				if (!isValidTrace) {
					continue;
				}

				// TODO use search with direction !!!
				Trace trace = new Trace(relation, args);
				if (traces.contains(trace)) {
					for (Iterator tracesIiter = traces.iterator(); tracesIiter.hasNext();) {
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
						// this can happen with older traces without a medini identifier.
					}
				}

				// TODO add binding !!
				// check for null !!! remove
				boolean isValidBinding = true;
				Map binding = new HashMap();
				for (Iterator iter = relation.getVariable().iterator(); iter.hasNext();) {
					VariableDeclaration currentVariableDeclaration = (VariableDeclaration) iter.next();
					EStructuralFeature structuralFeature = currentBindingClass.getEStructuralFeature(currentVariableDeclaration.getName());
					if (structuralFeature == null) {
						/**
						 * Should not be null for template variables! Fix for Bugzilla Bug 1805
						 */
						continue;
					}
					Object value = currentBindingObject.eGet(structuralFeature);
					if (value instanceof EObject) {
						EObject evalue = (EObject) value;
						if (evalue.eResource() == null) {
							value = null;
							// isValidBinding=false;
							// break;
						}
					}
					binding.put(currentVariableDeclaration.getName(), this.qvtProcessor.getStdLibAdapter().OclAny(value));
				}
				if (isValidBinding) {
					trace.addBinding(binding);
					this.postAddBindingHook(trace, currentBindingObject, binding);
				}
			}

			// clean up

			String nsURI = "urn:" + currentTransformationName + ".ecore";
			resourceSet.getPackageRegistry().remove(nsURI);

			traceResource.unload();
			resourceSet.getResources().remove(traceResource);

			if (this.allTracesInOneFile) {
				break;
			}

		}

		for (Iterator transformationsIter = this.allTransformations.iterator(); transformationsIter.hasNext();) {
			Transformation currentTransformation = (Transformation) transformationsIter.next();
			String currentTransformationName = currentTransformation.getName();

			// clean up

			URI traceMMFileUri = ((EMFQvtProcessorImpl) this.qvtProcessor).getWorkingLocation().appendSegment(currentTransformationName).appendFileExtension("ecore");
			Resource traceMMResource = resourceSet.getResource(traceMMFileUri, false);

			if (traceMMResource != null) {
				traceMMResource.unload();
				resourceSet.getResources().remove(traceMMResource);
			}

		}

		return traces;
	}

	protected void postAddBindingHook(Trace trace, EObject currentBindingObject, Map binding) {
		// do nothing
	}

	private Transformation lookupTransformation(EPackage package1) {
		for (Iterator iter = this.allTransformations.iterator(); iter.hasNext();) {
			Transformation currenTransformation = (Transformation) iter.next();
			if (package1.getName() != null && package1.getName().equals(currenTransformation.getName())) {
				return currenTransformation;
			}
		}
		return null;
	}

	private Relation lookupRelation(EClass relataion) {
		Transformation transformation = this.lookupTransformation(relataion.getEPackage());
		if (transformation == null) {
			return null;
		}
		List relations = transformation.getRule();
		for (Iterator relationsIter = relations.iterator(); relationsIter.hasNext();) {
			Relation currentRelation = (Relation) relationsIter.next();
			if (currentRelation.getName() != null && currentRelation.getName().equals(relataion.getName())) {
				return currentRelation;
			}
		}
		return null;
	}

	private EPackage lookupTransformation(Resource resource, Transformation transformation) {
		List rootPackages = resource.getContents();
		for (Iterator iter = rootPackages.iterator(); iter.hasNext();) {
			EPackage currentPackage = (EPackage) iter.next();
			if (currentPackage.getName() != null && currentPackage.getName().equals(transformation.getName())) {
				return currentPackage;
			}
		}
		return null;
	}

	private EClass lookupRelation(ResourceSet resourceSet, Relation relataion) {
		String nsURI = "urn:" + relataion.getTransformation().getName() + ".ecore";
		EPackage currentETransformation = (EPackage) resourceSet.getPackageRegistry().get(nsURI);
		if (currentETransformation == null) {
			throw new RuntimeException();
		}
		return (EClass) currentETransformation.getEClassifier(relataion.getName());
	}

	private void loadTraceMM() {
		ResourceSet resourceSet = this.getResourceSetForTraces();

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		this.fillPackageRegistry(resourceSet);

		for (Iterator iter = this.allTransformations.iterator(); iter.hasNext();) {
			Transformation currentTransformation = (Transformation) iter.next();
			String currentTransformationName = currentTransformation.getName();
			URI traceMMFileUri = ((EMFQvtProcessorImpl) this.qvtProcessor).getWorkingLocation().appendSegment(currentTransformationName).appendFileExtension("ecore");
			String nsURI = "urn:" + currentTransformationName + ".ecore";
			Resource traceMMResource = null;
			try {
				traceMMResource = resourceSet.getResource(traceMMFileUri, true);
				this.traceMetamodelResources.add(traceMMResource);
				resourceSet.getPackageRegistry().put(nsURI, traceMMResource.getContents().get(0));
			} catch (Exception exception) {
				// if (exception instanceof FileNotFoundException || exception.getCause() instanceof
				// FileNotFoundException) {
				if (traceMMResource != null) {
					resourceSet.getResources().remove(traceMMResource);
				}

				this.buildTraceMMForTransformation(resourceSet, currentTransformation);
				// } else {
				// throw new RuntimeException(exception);
				// }
			}
		}
	}

	protected void fillPackageRegistry(ResourceSet resourceSet) {
		resourceSet.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
	}

	/**
	 * pre: the target and source resources are in the same resource set
	 * 
	 */
	private void buildTraceMM() {
		// DO increment !!
		ResourceSet resourceSet = this.getResourceSetForTraces();

		resourceSet.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);

		for (Iterator iter = this.allTransformations.iterator(); iter.hasNext();) {
			Transformation currentTransformation = (Transformation) iter.next();
			this.buildTraceMMForTransformation(resourceSet, currentTransformation);
		}
	}

	private ResourceSet getResourceSetForTraces() {
		return ((EMFQvtProcessorImpl) this.qvtProcessor).getResourceSetForTraces();
	}

	private void buildTraceMMForTransformation(ResourceSet resourceSet, Transformation currentTransformation) {
		String currentTransformationName = currentTransformation.getName();
		URI traceMMFileUri = ((EMFQvtProcessorImpl) this.qvtProcessor).getWorkingLocation().appendSegment(currentTransformationName).appendFileExtension("ecore");
		Resource traceMMResource = resourceSet.createResource(traceMMFileUri);

		EPackage currentTransformationPackage = EcoreFactory.eINSTANCE.createEPackage();
		currentTransformationPackage.setNsPrefix(currentTransformationName);
		String nsURI = "urn:" + currentTransformationName + ".ecore";
		currentTransformationPackage.setNsURI("urn:" + currentTransformationName + ".ecore");
		resourceSet.getPackageRegistry().put(nsURI, currentTransformationPackage);
		traceMMResource.getContents().add(currentTransformationPackage);
		currentTransformationPackage.setName(currentTransformation.getName());
		List relationList = currentTransformation.getRule();
		for (Iterator iterator = relationList.iterator(); iterator.hasNext();) {
			Relation currentRelation = (Relation) iterator.next();
			EClass currentRelationClass = EcoreFactory.eINSTANCE.createEClass();
			this.setSuperTypes(currentRelationClass);
			currentTransformationPackage.getEClassifiers().add(currentRelationClass);
			currentRelationClass.setName(currentRelation.getName());
			List currentRelataionVariables = currentRelation.getVariable();
			for (Iterator iterator2 = currentRelataionVariables.iterator(); iterator2.hasNext();) {
				VariableDeclaration currentVariableDeclaration = (VariableDeclaration) iterator2.next();
				Classifier currentVariableType = currentVariableDeclaration.getType();
				if (currentVariableType instanceof Primitive || currentVariableType instanceof Enumeration) {
					EAttribute currentAttribute = EcoreFactory.eINSTANCE.createEAttribute();
					currentRelationClass.getEStructuralFeatures().add(currentAttribute);
					currentAttribute.setName(currentVariableDeclaration.getName());
					currentAttribute.setLowerBound(0);
					currentAttribute.setUpperBound(1);

					if (currentVariableType instanceof Enumeration) {
						currentAttribute.setEType(EcorePackage.eINSTANCE.getEEnumerator());
					} else if (currentVariableType instanceof IntegerType) {
						currentAttribute.setEType(EcorePackage.eINSTANCE.getEIntegerObject());
					} else if (currentVariableType instanceof BooleanType) {
						currentAttribute.setEType(EcorePackage.eINSTANCE.getEBooleanObject());
					} else if (currentVariableType instanceof RealType) {
						currentAttribute.setEType(EcorePackage.eINSTANCE.getEDoubleObject());
					} else if (currentVariableType instanceof StringType) {
						currentAttribute.setEType(EcorePackage.eINSTANCE.getEString());
					} else {
						throw new RuntimeException();
					}
				} else if (currentVariableType instanceof OclModelElementType) {
					OclModelElementTypeImpl currentOclModelElementType = (OclModelElementTypeImpl) currentVariableType;
					EClassifier eType = currentOclModelElementType.getImplementation();
					EReference currentReference = EcoreFactory.eINSTANCE.createEReference();
					currentRelationClass.getEStructuralFeatures().add(currentReference);
					currentReference.setName(currentVariableDeclaration.getName());
					currentReference.setEType(eType);
					currentReference.setLowerBound(0);
					currentReference.setUpperBound(1);
				}
			}
		}

		this.traceMetamodelResources.add(traceMMResource);
		try {
			traceMMResource.save(Collections.EMPTY_MAP);
			// TODO unload !!
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
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
	 *            <code>true</code> for the left project, false for the right project.
	 * @return the part of the given <code>uri</code> from the project name.
	 * @see #getPathRelativeToProject(URI, boolean)
	 */
	private static String getPathFromProject(String projectName, URI uri) {
		String uriString = uri.toString();
		int projectIndex = uriString.indexOf(projectName);
		return uriString.substring(projectIndex);
	}

	/**
	 * Returns the part of the given <code>uri</code> relative to the project name.
	 * 
	 * @param uri
	 *            the URI
	 * @param left
	 *            <code>true</code> for the left project, false for the right project.
	 * @return the part of the given <code>uri</code> relative to the project name.
	 */
	private static String getPathRelativeToProject(URI modelURI, URI traceURI) {
		String projectName = EMFQvtTraceAdapter.getProjectName(modelURI);
		String pathFromProject = EMFQvtTraceAdapter.getPathFromProject(projectName, traceURI);
		return pathFromProject.substring(projectName.length() + 1);
	}

	private static String getProjectName(URI modelURI) {
		return modelURI.trimSegments(1).lastSegment();
	}

	protected Collection getTraceMetamodelResources() {
		return this.traceMetamodelResources;
	}
}
