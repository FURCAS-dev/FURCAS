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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import ocljmi.JmiOclProcessorImpl;

import org.oslo.ocl20.OclProcessor;

import uk.ac.kent.cs.kmf.util.ILog;
import uk.ac.kent.cs.kmf.util.OutputStreamLog;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import de.ikv.medini.ocl.test.util.Utilities;

abstract public class OCLJMITestAdapter implements OCLTestAdapter {
	
	protected Connection connection;

	public Object getIdentityObject(Object obj) {
		// EcoreUtil.getID((EObject)obj);
		Object result = this.getValueForFeature(obj, "mediniIdentifier");
		if (result == null) {
			return obj;
		}
		return result;
	}

	private ModelPartition partition;

	protected OclProcessor processor;

	protected ModelPartition simplePartition;

	protected ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

	protected ILog log = new OutputStreamLog(this.byteArrayOutputStream);

	private Properties properties;

	protected static final String SOURCE_MODEL_FILE_NAME = "PF.LocalDevelopment:DCs/demo.sap.com/qvt/_comp/moin/source.xmi";

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
	
	protected void addMetaModel(MofPackage metamodel) {
		this.getJmiOclProcessorImpl().addMetaModel(metamodel);
	}

	public void initRepository() {
		//TODO load metamodels
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

	
	static public StructuralFeature getFeature(RefObject ro, String name) {
		try {
			return (StructuralFeature) ((MofClass)ro.refMetaObject()).lookupElementExtended(name);
		} catch (JmiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void addValueForFeature(Object modelElement, String property, Object value) {
		RefObject source = (RefObject) modelElement;
		StructuralFeature feature = OCLJMITestAdapter.getFeature(source, property);
		if (feature.getMultiplicity().getUpper() == 1 || feature.getMultiplicity().getUpper() == 0) {
			throw new RuntimeException("For property " + property + " is isMany=false");
		}
		Collection list = (Collection) source.refGetValue(feature);
		list.add(value);
	}

	public void setValueForFeature(Object modelElement, String property, Object value) {
		RefObject source = (RefObject) modelElement;
		StructuralFeature feature = OCLJMITestAdapter.getFeature(source, property);
		if (feature == null) {
			property = Utilities.capitalize(property);
			feature = OCLJMITestAdapter.getFeature(source, property);
		}
		if (value != null && value.getClass().isArray()) {
			value = Utilities.asArrayList(value);
		}
		if (feature.getMultiplicity().getUpper() > 1 || feature.getMultiplicity().getUpper() == JmiHelper.MULTIPLICITY_BOUND_INFINITE) {
			List list = (List) source.refGetValue(feature);
			if (value instanceof List) {
				list.clear();
				if(feature instanceof Attribute ||
						(feature instanceof Reference &&
								((Reference)feature).getExposedEnd().getAggregation().equals(AggregationKindEnum.COMPOSITE))) {
					//composed elements have to be removed from their composite parent before they are moved
					for (Object object : (List)value) {
						if(object instanceof RefObject) {
							RefObject child = (RefObject) object;
							RefObject parent = (RefObject) child.refImmediateComposite();
							if(parent != null) {
								Collection<Association> compositeAssociations = getConnection()
										.getJmiHelper().getCompositeAssociations(
												(MofClass) parent.refMetaObject(),
												(MofClass) child.refMetaObject());
								for (Association association : compositeAssociations) {
									AssociationEnd compositeAssociationEnd = getConnection()
											.getJmiHelper()
											.getCompositeAssociationEnd(association);
									Object composedElement = parent
											.refGetValue(compositeAssociationEnd.otherEnd());
									RefAssociation refAssoc = getConnection().getJmiHelper().getRefAssociationForAssociation(association);
									if (composedElement != null && (composedElement.equals(child)
											|| (composedElement instanceof Collection && ((Collection) composedElement).contains(child)))) {
										if(getConnection().getJmiHelper().isFirstAssociationEnd(association, compositeAssociationEnd)) {
											refAssoc.refRemoveLink(parent, child);
										} else {
											refAssoc.refRemoveLink(child, parent);
										}
									}
								}
							}
//						} else if(object instanceof RefEnum) {
//						    list.add(object);
						}
					}
				}
				list.addAll((List) value);
			} else {
				list.add(value);
			}
		} else {
			Object oldValue = source.refGetValue(feature);
//			ModelPartition oldResource = null;
//			if (oldValue instanceof RefObject) {
//				oldResource = PartitionHelper
//						.getPartition((RefObject) oldValue);
//			}
			source.refSetValue(feature, value);

		}
//		if (source.eContainer() != null) {
//			source.eResource().getContents().remove(source);
//		} else {
//			source.eResource().getContents().add(source);
//		}
	}

	public Object getValueForFeature(Object modelElement, String property) {
		RefObject source = (RefObject) modelElement;
		StructuralFeature feature = OCLJMITestAdapter.getFeature(source, property);
		if (feature == null) {
			property = Utilities.capitalize(property);
			feature = OCLJMITestAdapter.getFeature(source, property);
		}
		Object value = source.refGetValue(feature);
		if (value != null && value.getClass().isArray()) {
			value = Utilities.asArrayList(value);
		}
		return value;
	}

	public Object getEnumLiteral(String modelElementType) {
		modelElementType = modelElementType.replaceAll(OCLTestAdapter.NAMESPACE_SEPARATOR, "::");
		int betweenClassAndLiteral = modelElementType.lastIndexOf("::");
		String literalName = modelElementType.substring(betweenClassAndLiteral + 2);

		modelElementType = modelElementType.substring(0, betweenClassAndLiteral);
		int betweenPackageAndClass = modelElementType.lastIndexOf("::");
		String enumName = modelElementType.substring(betweenPackageAndClass + 2);
		String nsPrefix = modelElementType.substring(0, betweenPackageAndClass);

		for (Object metamodel : this.getProcessor().getMetaModels()) {
			MofPackage mmPack = (MofPackage)metamodel;
			MofPackage innerPack = (MofPackage) connection.getJmiHelper().findElementByQualifiedName(
					Arrays.asList(nsPrefix.split("::")), mmPack);
			RefPackage innerPackRef = connection.getJmiHelper().getRefPackageForMofPackage(innerPack);
			
			try {
				return innerPackRef.refGetEnum(enumName, literalName);
			} catch (InvalidCallException e) {
				// do nothing
			}
		}
		throw new RuntimeException("No enumeration literal found for " + modelElementType);

	}

	public Object createModelElement(String modelElementType) {
		modelElementType = modelElementType.replaceAll(OCLTestAdapter.NAMESPACE_SEPARATOR, "::");
		int betweenPackageAndClass = modelElementType.lastIndexOf("::");
		String className = modelElementType.substring(betweenPackageAndClass + 2);
		String nsPrefix = betweenPackageAndClass == -1 ? "" : modelElementType.substring(0, betweenPackageAndClass);
		for (Object metamodel : this.getProcessor().getMetaModels()) {
			MofPackage mmPack = (MofPackage)metamodel;
			MofPackage innerPack = (MofPackage) connection.getJmiHelper().findElementByQualifiedName(
					Arrays.asList(nsPrefix.split("::")), mmPack);
			if (innerPack != null) {
				RefPackage innerPackRef = connection.getJmiHelper()
						.getRefPackageForMofPackage(innerPack);

				if (innerPackRef != null) {
					try {
						RefClass refClass = innerPackRef.refClass(className);
						RefObject instance = refClass.refCreateInstance();
						simplePartition.assignElement(instance);
						return instance;
					} catch (InvalidCallException e) {
						// do nothing
					}
				}
			}
		}
		throw new RuntimeException("No meta class found for " + modelElementType);
	}

	public Object createModelElement(String modelElementType, boolean addToModel) {
		modelElementType = modelElementType.replaceAll(OCLTestAdapter.NAMESPACE_SEPARATOR, "::");
		int betweenPackageAndClass = modelElementType.lastIndexOf("::");
		String className = modelElementType.substring(betweenPackageAndClass + 1);
		String nsPrefix = betweenPackageAndClass == -1 ? "" : modelElementType.substring(0, betweenPackageAndClass);
		for (Object metamodel : this.getProcessor().getMetaModels()) {
			RefPackage mmPack = (RefPackage)metamodel;
			RefPackage innerPack = connection.getJmiHelper().findRefPackageByQualifiedName(
					Arrays.asList(nsPrefix.split("::")), mmPack);
			if(innerPack != null){
				try {
					RefClass refClass = innerPack.refClass(className);
					RefObject instance = refClass.refCreateInstance();
					if (addToModel) {
						simplePartition.assignElement(instance);
					} else {
						// leave as root element
					}
					return instance;
				} catch (InvalidCallException e) {
					// do nothing
				}
			}
		}
		throw new RuntimeException("No meta class found for " + modelElementType);
	}

	public void delete(Object modelElement) {
		((RefObject)modelElement).refDelete();
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

	public JmiOclProcessorImpl getJmiOclProcessorImpl() {
		return (JmiOclProcessorImpl) this.getProcessor();
	}

	public ModelPartition getMetamodelPartitions() {
		if (this.partition == null) {
			//TODO init metamodels
		}
		return this.partition;
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
			this.processor = new JmiOclProcessorImpl(this.log, connection);
		}
		return this.processor;
	}

//	protected EPackageImpl buildMetaModelFromEcoreFile(String path) {
//		URI simpleMMFileUri = URI.createFileURI((new File(path)).getAbsolutePath());
//		Resource simpleMMResource = this.getMetamodelPartitions().getResource(simpleMMFileUri, true);
//		Object o = simpleMMResource.getContents().get(0);
//		EPackageImpl companyPackage = (EPackageImpl) o;
//		this.getMetamodelPartitions().getPackageRegistry().put(companyPackage.getNsURI(), companyPackage);
//		simpleMMResource.getContents().add(companyPackage);
//		return companyPackage;
//	}

	public boolean supportsTuple() {
		return true;
	}

	protected void setupResources() {
		//PRI simplePRI = connection.getSession().getMoin().createPri(OCLJMITestAdapter.SOURCE_MODEL_FILE_NAME);

//		String source = this.getProperty("source");
//		if (source != null && !"".equals(source)) {
//			//this.makeCopy(source, OCLJMITestAdapter.SOURCE_MODEL_FILE_NAME);
//			//this.simplePartition = connection.getPartition(simplePRI);
//		} else {
//			//this.simplePartition = connection.createPartition(simplePRI);
//		}
		this.simplePartition = connection.getOrCreateTransientPartition("source");

		List models = new ArrayList();
		models.add(this.simplePartition);
		this.getProcessor().setModels(models);
	}

	/**
	 * This implementation of {@link OCLTestAdapter#isOfType(Object, String, boolean)} ignores the <code>considerSuperType</code> parameter. Thus, for supertypes, false is
	 * returned.
	 */
	public boolean isOfType(Object modelElement, String modelElementType, boolean considerSuperTypes) {

		if (!(modelElement instanceof RefObject)) {
			return false;
		}

		int betweenPackageAndClass = modelElementType.lastIndexOf(OCLTestAdapter.NAMESPACE_SEPARATOR);
		String className = modelElementType.substring(betweenPackageAndClass + OCLTestAdapter.NAMESPACE_SEPARATOR.length());
		String nsPrefix = modelElementType.substring(0, betweenPackageAndClass);

		Classifier mofClassifier = null;
		for (Object metamodel : this.getProcessor().getMetaModels()) {
			RefPackage mmPack = connection.getJmiHelper().getRefPackageForMofPackage((MofPackage)metamodel);
			RefPackage innerPack = connection.getJmiHelper().findRefPackageByQualifiedName(
					Arrays.asList(nsPrefix.split("::")), mmPack);
			if(innerPack != null){
				try {
					RefClass refClass = innerPack.refClass(className);
					mofClassifier = (Classifier) refClass.refMetaObject();
				} catch (InvalidCallException e) {
					// do nothing
				}
			}
		}

		if (((RefObject) modelElement).refMetaObject().equals(mofClassifier)) {
			return true;
		}

		// TODO Omar: implement consider supertypes
		return false;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}


}
