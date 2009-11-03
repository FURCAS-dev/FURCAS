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
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.oslo.ocl20.OclProcessor;

import de.ikv.emf.qvt.EMFQvtProcessorImpl;
import de.ikv.medini.ocl.test.util.Utilities;
import de.ikv.medini.qvt.QVTProcessorConsts;
import de.ikv.medini.qvt.QvtProcessorImpl;
import de.ikv.medini.qvt.util.QvtSemanticTaskDebugInfo;

public class QVTEMFTestAdapter extends de.ikv.medini.ocl.test.OCLEMFTestAdapter implements QVTTestAdapter {

	private Resource targetResource;

	protected String[] metamodelIDs;

	protected List sourceModelList;

	protected List targetModelList = new ArrayList();

	@Override
	protected OclProcessor getProcessor() {
		if (this.processor == null) {
			this.processor = new EMFQvtProcessorImpl(this.log);
		}
		return this.processor;
	}

	@Override
	protected void setupResources() {
		super.setupResources();

		this.sourceModelList = new ArrayList();
		this.sourceModelList.add(this.simpleResource);
		if ("true".equalsIgnoreCase(this.getProperty(QVTTestAdapter.QVTTESTADAPTER_INPLACE))) {
			this.targetResource = this.simpleResource;
		} else {
			URI targetFileUri = URI.createFileURI((new File("test/target.xml")).getAbsolutePath());
			this.targetResource = this.getResourceSet().createResource(targetFileUri);
			this.setIDs(this.targetResource);
		}
		if ("true".equalsIgnoreCase(this.getProperty(QVTTestAdapter.QVTTESTADAPTER_TWOSOURCEMODELS))) {
			URI targetFileUri = URI.createFileURI((new File("test/source2.xml")).getAbsolutePath());
			Resource source2Resource = this.getResourceSet().createResource(targetFileUri);
			this.setIDs(source2Resource);
			this.sourceModelList.add(source2Resource);
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

		URI testDir = URI.createFileURI("./test");
		this.getEMFQvtProcessorImpl().setWorkingLocation(testDir);

		try {
			Utilities.recursiveRemoveDir(new File("./test"));
		} catch (Exception e) {
		}

	}

	public void evaluateQVTBackward(String qvtFile, String transformationName, boolean enforce, String direction) {
		this.evaluateQVT(qvtFile, transformationName, enforce, direction);
	}

	private QvtProcessorImpl getQvtProcessorImpl() {
		return (QvtProcessorImpl) this.processor;
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
				this.getQvtProcessorImpl().setProperty(QVTProcessorConsts.PROP_TRACEADAPTER, "de.ikv.emf.qvt.EMFQvtTraceAdapter");
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
				for (Iterator iter = this.sourceModelList.iterator(); iter.hasNext();) {
					((Resource) iter.next()).save(Collections.EMPTY_MAP);
				}
				this.targetResource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected EMFQvtProcessorImpl getEMFQvtProcessorImpl() {
		return (EMFQvtProcessorImpl) this.getProcessor();
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
		Resource r = this.simpleResource;
		try {
			this.simpleResource = this.targetResource;
			return this.createModelElement(modelElementType);
		} finally {
			this.simpleResource = r;
		}
	}

	@Override
	protected void addMetaModel(EPackageImpl metamodel) {
		this.getEMFQvtProcessorImpl().addMetaModel(metamodel);
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
		Resource r = this.simpleResource;
		try {
			this.simpleResource = (Resource) this.getQvtProcessorImpl().getModels().get(modelIndex);
			return this.createModelElement(modelElementType);
		} finally {
			this.simpleResource = r;
		}
	}

	public boolean supportsRandomMode() {
		return true;
	}
}
