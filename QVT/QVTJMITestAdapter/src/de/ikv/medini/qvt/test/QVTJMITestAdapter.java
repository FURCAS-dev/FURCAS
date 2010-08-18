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

package de.ikv.medini.qvt.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.oslo.ocl20.OclProcessor;

import qvtjmi.JMIQvtProcessorImpl;
import de.ikv.medini.ocl.test.util.Utilities;
import de.ikv.medini.qvt.QVTProcessorConsts;
import de.ikv.medini.qvt.QvtProcessorImpl;
import de.ikv.medini.qvt.util.QvtSemanticTaskDebugInfo;

public class QVTJMITestAdapter extends de.ikv.medini.ocl.test.OCLJMITestAdapter implements QVTTestAdapter {

	private Resource targetResource;

	protected String[] metamodelIDs;

	protected List sourceModelList;

	protected List targetModelList = new ArrayList();

	@Override
	protected OclProcessor getProcessor() {
		if (this.processor == null) {
			this.processor = new JMIQvtProcessorImpl(this.log, getConnection());
		}
		return this.processor;
	}

	@Override
	protected void setupResources() {
		super.setupResources();

		this.sourceModelList = new ArrayList();
		this.sourceModelList.add(this.simplePartition);
		if ("true".equalsIgnoreCase(this.getProperty(QVTTestAdapter.QVTTESTADAPTER_INPLACE))) {
			this.targetResource = this.simplePartition;
		} else {
			//URI targetFileUri = URI.createFileURI((new File("test/target.xml")).getAbsolutePath());
			this.targetResource = connection.getOrCreateTransientPartition("target");
			//this.setIDs(this.targetResource);
		}
		if ("true".equalsIgnoreCase(this.getProperty(QVTTestAdapter.QVTTESTADAPTER_TWOSOURCEMODELS))) {
			//URI targetFileUri = URI.createFileURI((new File("test/source2.xml")).getAbsolutePath());
			Resource source2Partition = connection.getOrCreateTransientPartition("target2");
			//this.setIDs(source2Resource);
			this.sourceModelList.add(source2Partition);
		}

		List models = new ArrayList();
		models.add(this.sourceModelList);
		if ("true".equalsIgnoreCase(this.getProperty(QVTTestAdapter.QVTTESTADAPTER_THREEDOMAINS))) {
			models.add(this.sourceModelList);
		}
		models.add(this.targetResource);
		this.getProcessor().setModels(models);

		// getEMFQvtProcessorImpl().setTargetResource(targetResource);
		// addSourceResources(targetResource);

//		PRI testDir = PRI.createFileURI("./test");
//		this.getJMIQvtProcessorImpl().setWorkingLocation(testDir);

		try {
			Utilities.recursiveRemoveDir(new File("./test"));
		} catch (Exception e) {
		}

	}

	public void evaluateQVTBackward(String qvtFile, String transformationName, boolean enforce, String direction) {
		this.evaluateQVT(qvtFile, transformationName, enforce, direction);
	}

	private QvtProcessorImpl getQvtProcessorImpl() {
		return (QvtProcessorImpl) getProcessor();
	}

	public void setQvtProperty(String name, String value) {
		this.getQvtProcessorImpl().setProperty(name, value);
	}

	public void evaluateQVT(String qvtFile, String transformationName, boolean enforce, String direction) {
		System.out.println("Start transformation in direction " + direction);

		Collection models = new ArrayList();
		models.add(this.sourceModelList);
		if ("true".equalsIgnoreCase(this.getProperty(QVTTestAdapter.QVTTESTADAPTER_THREEDOMAINS))) {
			models.add(this.sourceModelList);
		}
		models.add(this.targetResource);
		this.getProcessor().setModels(models);

		try {
			try {
				InputStreamReader reader = new InputStreamReader(new FileInputStream(qvtFile));
				this.getQvtProcessorImpl().setProperty(QVTProcessorConsts.PROP_IMPORT_PATH, new File(qvtFile).getParent() + File.separator);
				this.getQvtProcessorImpl().setProperty(QVTProcessorConsts.PROP_TRACEADAPTER, "qvtjmi.JMIQvtTraceAdapter");
				this.getQvtProcessorImpl().setProperty(QVTProcessorConsts.PROP_DEBUG, "true");
				this.getQvtProcessorImpl().setProperty(QVTProcessorConsts.PROP_DEBUG_TASKS, "true");

				this.getQvtProcessorImpl().evaluateQVT(reader, transformationName, enforce, direction, null, null, this.log);
				// oldTraces = getQvtProcessorImpl().evaluateQVT(reader, transformationName, enforce, direction, null,
				// oldTraces, log);
			} catch (RuntimeException e) {
				if (this.getProcessor().getLog().hasErrors()) {
					String message = new String(this.byteArrayOutputStream.toByteArray());
					message = message.trim();
					this.log.reset();
					this.byteArrayOutputStream.reset();
					throw new RuntimeException(message);
				} else {
					throw e;
				}

			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			}
		} finally {
			try {
//				for (Iterator iter = this.sourceModelList.iterator(); iter.hasNext();) {
//					((ModelPartition) iter.next()).save(Collections.EMPTY_MAP);
//				}
//				this.targetResource.save(Collections.EMPTY_MAP);
				if(!getConnection().getNullPartition().isDirty()) {
					connection.save();
				} else {
					log.reportError("Couldn't save changes as there are still the following elements in the transient partition:" + getConnection().getNullPartition().getElements());
				}
			} catch (NullPartitionNotEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ReferencedTransientElementsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PartitionsNotSavedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected JMIQvtProcessorImpl getJMIQvtProcessorImpl() {
		return (JMIQvtProcessorImpl) this.getProcessor();
	}

	@Override
	public List evaluate(String oclExpression) {
		Collection models = new ArrayList();
		models.add(this.sourceModelList);
		models.add(this.targetResource);
		this.getProcessor().setModels(models);
		return super.evaluate(oclExpression);
	}

	public List evaluateOnSource(String oclExpression) {
		Collection models = new ArrayList();
		models.add(this.sourceModelList);
		this.getProcessor().setModels(models);
		return super.evaluate(oclExpression);
	}

	public List evaluateOnTarget(String oclExpression) {
		Collection models = new ArrayList();
		models.add(this.targetResource);
		this.getProcessor().setModels(models);
		return super.evaluate(oclExpression);
	}

	public Object createModelElementInTarget(String modelElementType) {
		Resource r = this.simplePartition;
		try {
			this.simplePartition = this.targetResource;
			return this.createModelElement(modelElementType);
		} finally {
			this.simplePartition = r;
		}
	}

	@Override
	protected void addMetaModel(EPackage metamodel) {
		this.getJMIQvtProcessorImpl().addMetaModel(metamodel);
	}

	public Object getCreateOclAnyModelElementCount() {
		return QvtSemanticTaskDebugInfo.createOclAnyModelElementCount;
	}

	public boolean supportsMetaModels(String[] metamodelIDs) {
		for (String metaModelID : metamodelIDs) {
			if (!(metaModelID.equals("EUML") || metaModelID.equals("AmedatoModeling") || metaModelID.equals("EARepository") || metaModelID.equals("uml"))) {
				return false;
			}
		}
		this.metamodelIDs = metamodelIDs;
		return true;
	}

	public Object getQvtProcessor() {
		return this.getQvtProcessorImpl();
	}

	public Object createModelElementInModel(String modelElementType, int modelIndex) {
		Resource r = this.simplePartition;
		try {
			this.simplePartition = (Resource) this.getQvtProcessorImpl().getModels().get(modelIndex);
			return this.createModelElement(modelElementType);
		} finally {
			this.simplePartition = r;
		}
	}

	public boolean supportsRandomMode() {
		return true;
	}

	@Override
	public void addValueForFeature(Object modelElement, String property,
			Object value) {
		// TODO Auto-generated method stub
		
	}
}
