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

package de.ikv.medini.ocl.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.oslo.ocl20.OclProcessor;
import org.oslo.ocl20.bridge4emf.EmfOclProcessorImpl;

import uk.ac.kent.cs.kmf.util.ILog;
import uk.ac.kent.cs.kmf.util.OutputStreamLog;
import de.ikv.medini.ocl.test.util.Utilities;

abstract public class OCLEMFTestAdapter implements OCLTestAdapter {

	public Object getIdentityObject(Object obj) {
		// EcoreUtil.getID((EObject)obj);
		Object result = this.getValueForFeature(obj, "mediniIdentifier");
		if (result == null) {
			return obj;
		}
		return result;
	}

	private ResourceSetImpl resourceSet;

	protected OclProcessor processor;

	protected Resource simpleResource;

	protected ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

	protected ILog log = new OutputStreamLog(this.byteArrayOutputStream);

	private Properties properties;

	protected static final String SOURCE_MODEL_FILE_NAME = "test/source.xml";

	public void makeCopy(String source, String target) {
		int BUFSIZE = 65536;
		try {
			File dir = new java.io.File("test");
			dir.mkdir();
			FileInputStream fin = new FileInputStream(source);
			FileOutputStream fout = new FileOutputStream(target);
			byte[] buf = new byte[BUFSIZE];
			int c;
			while ((c = fin.read(buf)) != -1) {
				fout.write(buf, 0, c);
			}
			fin.close();
			fin = null;
			fout.close();
			fout = null;
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void registerMetaModel(Iterator iter) {
		for (; iter.hasNext();) {
			Object o = iter.next();
			if (o instanceof EPackageImpl) {
				this.registerMetaModel((EPackageImpl) o);
			}
		}

	}

	public void registerMetaModel(EPackageImpl metamodel) {
		this.getResourceSet().getPackageRegistry().put(metamodel.getNsURI(), metamodel);
		this.addMetaModel(metamodel);
	}

	protected void addMetaModel(EPackageImpl metamodel) {
		this.getEmfOclProcessorImpl().addMetaModel(metamodel);
	}

	public void initRepository() {
		EcoreUtil.resolveAll(this.getResourceSet());
		this.registerMetaModel(EcoreUtil.getAllContents(this.getResourceSet(), true));
	}

	protected String getProperty(String key) {
		if (this.properties != null) {
			String result = this.properties.getProperty(key);
			if (result != null) {
				return result;
			}
		}
		return System.getProperty(key);
	}

	public void setUp(Properties properties) {
		this.properties = properties;
		this.initRepository();
		this.setupResources();
	}

	public void tearDown() {
	}

	protected void setIDs(Resource umlResource) {
		Iterator allContentsIter = umlResource.getAllContents();
		while (allContentsIter.hasNext()) {
			EObject object = (EObject) allContentsIter.next();
			if (EcoreUtil.getID(object) == null) {
				EcoreUtil.setID(object, EcoreUtil.generateUUID());
			}
		}
	}

	static public EStructuralFeature getFeature(EObject eo, String name) {
		for (Object f : eo.eClass().getEAllStructuralFeatures()) {
			if (name.equals(((EStructuralFeature) f).getName())) {
				return (EStructuralFeature) f;
			}
		}
		return null;
	}

	public void addValueForFeature(Object modelElement, String property, Object value) {
		EObject source = (EObject) modelElement;
		EStructuralFeature feature = OCLEMFTestAdapter.getFeature(source, property);
		if (!feature.isMany()) {
			throw new RuntimeException("For property " + property + " is isMany=false");
		}
		List list = (List) source.eGet(feature);
		list.add(value);
	}

	public void setValueForFeature(Object modelElement, String property, Object value) {
		EObject source = (EObject) modelElement;
		EStructuralFeature feature = OCLEMFTestAdapter.getFeature(source, property);
		if (feature == null) {
			property = Utilities.capitalize(property);
			feature = OCLEMFTestAdapter.getFeature(source, property);
		}
		if (value != null && value.getClass().isArray()) {
			value = Utilities.asArrayList(value);
		}
		source.eSet(feature, value);
		if (source.eContainer() != null) {
			source.eResource().getContents().remove(source);
		} else {
			source.eResource().getContents().add(source);
		}
	}

	public Object getValueForFeature(Object modelElement, String property) {
		EObject source = (EObject) modelElement;
		EStructuralFeature feature = OCLEMFTestAdapter.getFeature(source, property);
		if (feature == null) {
			property = Utilities.capitalize(property);
			feature = OCLEMFTestAdapter.getFeature(source, property);
		}
		Object value = source.eGet(feature);
		if (value != null && value.getClass().isArray()) {
			value = Utilities.asArrayList(value);
		}
		return value;
	}

	public Object getEnumLiteral(String modelElementType) {
		modelElementType = modelElementType.replaceAll(OCLTestAdapter.NAMESPACE_SEPARATOR, ".");
		int betweenClassAndLiteral = modelElementType.lastIndexOf('.');
		String literalName = modelElementType.substring(betweenClassAndLiteral + 1);

		modelElementType = modelElementType.substring(0, betweenClassAndLiteral);
		int betweenPackageAndClass = modelElementType.lastIndexOf('.');
		String className = modelElementType.substring(betweenPackageAndClass + 1);
		String nsPrefix = modelElementType.substring(0, betweenPackageAndClass);

		for (Iterator iter = EcoreUtil.getAllContents(this.getProcessor().getMetaModels()); iter.hasNext();) {
			EObject eo = (EObject) iter.next();

			if (eo instanceof EEnumLiteral) {
				EEnumLiteral el = (EEnumLiteral) eo;
				if (el.getName().equals(literalName)) {
					if (nsPrefix.equals(el.getEEnum().getEPackage().getNsPrefix())) {
						Object newInstance = el.getEEnum().getEPackage().getEFactoryInstance().createFromString(el.getEEnum(), literalName);
						return newInstance;
					}
				}
			}
		}
		throw new RuntimeException("No enumeration literal found for " + modelElementType);

	}

	public Object createModelElement(String modelElementType) {
		modelElementType = modelElementType.replaceAll(OCLTestAdapter.NAMESPACE_SEPARATOR, ".");
		int betweenPackageAndClass = modelElementType.lastIndexOf('.');
		String className = modelElementType.substring(betweenPackageAndClass + 1);
		String nsPrefix = betweenPackageAndClass == -1 ? "" : modelElementType.substring(0, betweenPackageAndClass);
		for (Iterator iter = EcoreUtil.getAllContents(this.getProcessor().getMetaModels()); iter.hasNext();) {
			Object o = iter.next();
			if (o instanceof EClass) {
				EClass ec = (EClass) o;
				if (ec.getName().equals(className) && (nsPrefix.equals("") || nsPrefix.equals(ec.getEPackage().getNsPrefix()))) {
					EObject newInstance = ec.getEPackage().getEFactoryInstance().create(ec);
					this.simpleResource.getContents().add(newInstance);
					try {
						EcoreUtil.setID(newInstance, EcoreUtil.generateUUID());
					} catch (Exception e) {

					}
					return newInstance;

				}
			}
		}
		throw new RuntimeException("No meta class found for " + modelElementType);
	}

	public Object createModelElement(String modelElementType, boolean addToModel) {
		modelElementType = modelElementType.replaceAll(OCLTestAdapter.NAMESPACE_SEPARATOR, ".");
		int betweenPackageAndClass = modelElementType.lastIndexOf('.');
		String className = modelElementType.substring(betweenPackageAndClass + 1);
		String nsPrefix = betweenPackageAndClass == -1 ? "" : modelElementType.substring(0, betweenPackageAndClass);
		for (Iterator iter = EcoreUtil.getAllContents(this.getProcessor().getMetaModels()); iter.hasNext();) {
			Object o = iter.next();
			if (o instanceof EClass) {
				EClass ec = (EClass) o;
				if (ec.getName().equals(className) && (nsPrefix.equals("") || nsPrefix.equals(ec.getEPackage().getNsPrefix()))) {
					EObject newInstance = ec.getEPackage().getEFactoryInstance().create(ec);
					if (addToModel) {
						this.simpleResource.getContents().add(newInstance);
					}
					try {
						EcoreUtil.setID(newInstance, EcoreUtil.generateUUID());
					} catch (Exception e) {
						// do nothing
					}
					return newInstance;

				}
			}
		}
		throw new RuntimeException("No meta class found for " + modelElementType);
	}

	public void delete(Object modelElement) {
		Resource resource = ((EObject) modelElement).eResource();
		EObject objectToRemove = (EObject) modelElement;
		EcoreUtil.remove(objectToRemove);
		Object javaObject = modelElement;
		if (javaObject instanceof EObject && resource != null) {
			List allObjects = new ArrayList();
			Iterator all = resource.getAllContents();
			while (all.hasNext()) {
				allObjects.add(all.next());
			}
			all = allObjects.iterator();
			while (all.hasNext()) {
				EObject currentObject = (EObject) all.next();
				List allStructuralFeatures = currentObject.eClass().getEAllStructuralFeatures();
				for (Iterator allStructuralFeaturesIter = allStructuralFeatures.iterator(); allStructuralFeaturesIter.hasNext();) {
					EStructuralFeature currentStructuralFeature = (EStructuralFeature) allStructuralFeaturesIter.next();
					OCLEMFTestAdapter.remove(currentObject, currentStructuralFeature, javaObject);
				}
			}
		}
	}

	/**
	 * See EMFQvtModelManipulationAdaperImpl.remove
	 * 
	 * @param eObject
	 * @param eStructuralFeature
	 * @param value
	 */
	public static void remove(EObject eObject, EStructuralFeature eStructuralFeature, Object value) {
		if (eStructuralFeature.isMany()) {
			((List) eObject.eGet(eStructuralFeature)).remove(value);
		} else {
			if (eObject.eGet(eStructuralFeature) != null && eObject.eGet(eStructuralFeature).equals(value)) {
				eObject.eUnset(eStructuralFeature);
			}
		}
	}

	public List evaluate(String oclExpression) {
		List result = this.getProcessor().evaluate(oclExpression);
		if (this.getProcessor().getLog().hasErrors() || result == null) {
			String message = new String(this.byteArrayOutputStream.toByteArray());
			this.log.reset();
			this.byteArrayOutputStream.reset();
			throw new RuntimeException(message);
		}
		return result;
	}

	public List evaluate(String oclExpression, Object self) {
		List result = this.getProcessor().evaluate(oclExpression, self);
		if (this.getProcessor().getLog().hasErrors() || result == null) {
			String message = new String(this.byteArrayOutputStream.toByteArray());
			this.log.reset();
			this.byteArrayOutputStream.reset();
			throw new RuntimeException(message);
		}
		return result;
	}

	public Number getNumber(int i) {
		return new Integer(i);
	}

	public void setValueForStaticFeature(String className, String property, Object value) {
		// do nothing
	}

	public boolean supportStaticFeatures() {
		return false;
	}

	public EmfOclProcessorImpl getEmfOclProcessorImpl() {
		return (EmfOclProcessorImpl) this.getProcessor();
	}

	public ResourceSetImpl getResourceSet() {
		if (this.resourceSet == null) {
			this.resourceSet = new ResourceSetImpl();

			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
			// Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml", new XMLResourceFactoryImpl());
			// resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMLResourceFactoryImpl());
			// resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
			this.resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl() {

				@Override
				public Resource createResource(URI uri) {
					super.createResource(uri);
					return new XMIResourceImpl(uri) {

						@Override
						protected boolean useUUIDs() {
							return true;
						}
					};
				}
			});

		}
		return this.resourceSet;
	}

	public String getLiteralLabel(Object enumLiteral) {
		return enumLiteral.toString();
	}

	public String getLiteralLabelFromQualifiedName(String qualifiedName) {
		return this.getLiteralLabel(this.getEnumLiteral(qualifiedName));
	}

	/*
	 * 
	 * protected void registerMetaModel(EPackageImpl companyPackage) {
	 * 
	 * getResourceSet().getPackageRegistry().put(companyPackage.getNsURI(), companyPackage); getProcessor().addModel(companyPackage);
	 * 
	 * Collection c = new ArrayList(); c.add(companyPackage); for (Iterator iter = EcoreUtil.getAllContents(c); iter.hasNext();) { EObject eo = (EObject) iter.next();
	 * 
	 * if (eo instanceof EPackageImpl) { EPackageImpl p = (EPackageImpl) eo; getResourceSet().getPackageRegistry().put(p.getNsURI(), p); getProcessor().addModel(p); } } }
	 */

	protected OclProcessor getProcessor() {
		if (this.processor == null) {
			this.processor = new EmfOclProcessorImpl(this.log);
		}
		return this.processor;
	}

	protected EPackageImpl buildMetaModelFromEcoreFile(String path) {
		URI simpleMMFileUri = URI.createFileURI((new File(path)).getAbsolutePath());
		Resource simpleMMResource = this.getResourceSet().getResource(simpleMMFileUri, true);
		Object o = simpleMMResource.getContents().get(0);
		EPackageImpl companyPackage = (EPackageImpl) o;
		this.getResourceSet().getPackageRegistry().put(companyPackage.getNsURI(), companyPackage);
		simpleMMResource.getContents().add(companyPackage);
		return companyPackage;
	}

	public boolean supportsTuple() {
		return true;
	}

	protected void setupResources() {

		URI simpleFileUri = URI.createFileURI((new File(OCLEMFTestAdapter.SOURCE_MODEL_FILE_NAME)).getAbsolutePath());

		String source = this.getProperty("source");
		if (source != null && !"".equals(source)) {
			this.makeCopy(source, OCLEMFTestAdapter.SOURCE_MODEL_FILE_NAME);
			this.simpleResource = this.getResourceSet().getResource(simpleFileUri, true);
		} else {
			this.simpleResource = this.getResourceSet().createResource(simpleFileUri);
		}

		this.setIDs(this.simpleResource);
		List models = new ArrayList();
		models.add(this.simpleResource);
		this.getProcessor().setModels(models);
	}

	/**
	 * This implementation of {@link OCLTestAdapter#isOfType(Object, String, boolean)} ignores the <code>considerSuperType</code> parameter. Thus, for supertypes, false is
	 * returned.
	 */
	public boolean isOfType(Object modelElement, String modelElementType, boolean considerSuperTypes) {

		if (!(modelElement instanceof EObject)) {
			return false;
		}

		int betweenPackageAndClass = modelElementType.lastIndexOf(OCLTestAdapter.NAMESPACE_SEPARATOR);
		String className = modelElementType.substring(betweenPackageAndClass + OCLTestAdapter.NAMESPACE_SEPARATOR.length());

		EClassifier eClassifier = null;

		for (Iterator iter = EcoreUtil.getAllContents(this.getProcessor().getMetaModels()); iter.hasNext();) {
			Object currentElement = iter.next();

			if (currentElement instanceof EPackage) {
				eClassifier = ((EPackage) currentElement).getEClassifier(className);
				if (eClassifier != null) {
					break;
				}
			} else if (currentElement instanceof EClass) {
				EClass ec = (EClass) currentElement;
				eClassifier = ec.getEPackage().getEClassifier(className);

				if (eClassifier != null) {
					break;
				}
			}
		}

		if (((EObject) modelElement).eClass().equals(eClassifier)) {
			return true;
		}

		// TODO Omar: implement consider supertypes
		return false;
	}
}
