/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package com.sap.tc.emf.test.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.sap.tc.emf.test.query.setup.TestClient;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.EnumTp;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelFactory;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.StructInStructTp;
import org.eclipse.emf.query2.test.mm.generatedmetamodel.StructTp;

@SuppressWarnings("nls")
public class ModelDataInstantiator {

	private static final String PART_PREFIX = "generatedMM_instances";

	// by definition the 5th attribute has an emptyString value
	private static final int EMPTY_STRING_ATTR_NUM = 5;

	static public String partitionNameAppendix = ".xmi";

	private TestClient testClient;

	private int mmSize = 10;

	private int attrSize = 10;

	private int instSize = 10;

	private int partSize = 10;

	private boolean withSave = true;

	private boolean createObjValAttrs = true;

	public ModelDataInstantiator(TestClient testClient) {

		this.testClient = testClient;
	}

	public ModelDataInstantiator(TestClient testClient, boolean withSave, int mmSize, int attributeSize, int instanceSize,
			int partitionSize, boolean createObjValAttrs) {

		this.testClient = testClient;
		this.withSave = withSave;
		this.mmSize = mmSize;
		this.attrSize = attributeSize;
		this.instSize = instanceSize;
		this.partSize = partitionSize;
		this.createObjValAttrs = createObjValAttrs;
	}

	public boolean createData() throws Exception {

		if (this.mmSize < 3) {
			this.mmSize = 3;
		}
		if (this.attrSize < 3) {
			this.attrSize = 3;
		}
		if (this.instSize < 3) {
			this.instSize = 3;
		}

		// delete partitions (only if we save the new ones)
		if (this.withSave) {
			this.removeData();
		}

		// instantiate data
		this.instantiate();

		// if we have to save partitions and clean up
		if (this.withSave) {
			this.saveData();
		}

		return true;
	}

	public Collection<URI> loadData() throws Exception {

		return this.getAllPartitions();
	}

	public int removeData() throws Exception {

		// actually delete partitions
		int dp = this.delete_inst_partitions();

		// save partitions
		this.testClient.saveAll();

		return dp;
	}

	private void instantiate() throws Exception {

		URI[] instPart = new URI[this.partSize];
		GeneratedmetamodelFactory gpackage1 = null;

		for (int i = 0; i < this.partSize; i++) {
			instPart[i] = this.testClient.getOrCreateResourceStable(getInstPartName(i)).getURI();
		}

		gpackage1 = GeneratedmetamodelFactory.eINSTANCE;

		EClass tmpClass = null;
		EClass tmpSubClass = null;
		EClass tmpObjValClass = null;
		Object[][][] tmpObjValAttribute = new Object[this.mmSize][this.instSize][Math.min(this.mmSize, this.attrSize)];
		Object[][] tmpElements = new Object[this.mmSize][this.instSize];
		Object[][] tmpSubElements = new Object[this.mmSize][this.instSize];

		// arrays for the reflective 'invoke' methods; these are used
		// repeatedly,
		// instead of initializing a new Object every time

		Class[] intClass = new Class[] { int.class };
		Class[] doubleClass = new Class[] { double.class };
		Class[] stringClass = new Class[] { String.class };

		int intAttr;
		double dblAttr;
		String className;
		String stringAttr;
		StructTp structAttr;
		StructInStructTp structAttrInStructAttr;
		Object enumAttr;
		Collection stringAttrMV;

		for (int testClassNr = 0; testClassNr < this.mmSize; testClassNr++) {
			for (int instNr = 0; instNr < this.instSize; instNr++) {

				/*
				 * create TestClass and TestSubClass objects via JMI reflection
				 * (which itself is invoked by Java Reflection)
				 */

				tmpClass = (EClass) GeneratedmetamodelPackage.eINSTANCE.getEClassifier("TestClass" + testClassNr);
				tmpElements[testClassNr][instNr] = GeneratedmetamodelFactory.eINSTANCE.create(tmpClass);
				className = calculateClassName(testClassNr, instNr, false);
				((EObject) tmpElements[testClassNr][instNr]).eSet(tmpClass.getEStructuralFeature("name"), className);

				tmpSubClass = (EClass) GeneratedmetamodelPackage.eINSTANCE.getEClassifier("TestSubClass" + testClassNr);
				tmpSubElements[testClassNr][instNr] = GeneratedmetamodelFactory.eINSTANCE.create(tmpSubClass);
				className = calculateClassName(testClassNr, instNr, true);
				((EObject) tmpSubElements[testClassNr][instNr]).eSet(tmpSubClass.getEStructuralFeature("name"), className);

				/*
				 * set attribute values
				 */

				for (int attrNr = 0; attrNr < this.attrSize; attrNr++) {

					intAttr = calculateIntAttr(testClassNr, instNr, attrNr);
					dblAttr = calculateDoubleAttr(testClassNr, instNr, attrNr);
					stringAttr = calculateStringAttr(testClassNr, instNr, attrNr, false);

					tmpElements[testClassNr][instNr].getClass().getMethod("setAttrInt" + attrNr, intClass).invoke(
							tmpElements[testClassNr][instNr], intAttr);
					tmpElements[testClassNr][instNr].getClass().getMethod("setAttrDouble" + attrNr, doubleClass).invoke(
							tmpElements[testClassNr][instNr], dblAttr);
					tmpElements[testClassNr][instNr].getClass().getMethod("setAttrString" + attrNr, stringClass).invoke(
							tmpElements[testClassNr][instNr], stringAttr);

					stringAttrMV = (Collection) tmpElements[testClassNr][instNr].getClass().getMethod("getAttrStringMultiValued" + attrNr,
							(Class[]) null).invoke(tmpElements[testClassNr][instNr], (Object[]) null);

					/*
					 * set multi-valued String attributes
					 */
					for (int in = 0; in < 10; in++) {
						String st = calculateMultiValuedStringAttr(testClassNr, instNr, attrNr, in, false);
						stringAttrMV.add(st);
					}

					/*
					 * set attributes for subclasses
					 */

					stringAttr = calculateStringAttr(testClassNr, instNr, attrNr, true);

					tmpSubElements[testClassNr][instNr].getClass().getMethod("setAttrInt" + attrNr, intClass).invoke(
							tmpSubElements[testClassNr][instNr], intAttr);
					tmpSubElements[testClassNr][instNr].getClass().getMethod("setAttrDouble" + attrNr, doubleClass).invoke(
							tmpSubElements[testClassNr][instNr], dblAttr);
					tmpSubElements[testClassNr][instNr].getClass().getMethod("setAttrString" + attrNr, stringClass).invoke(
							tmpSubElements[testClassNr][instNr], stringAttr);
				}

				/*
				 * set structure type attribute
				 */

				Object[] structFields = new Object[2];
				structFields[0] = testClassNr;
				structFields[1] = "TestClass" + testClassNr + "Inst" + instNr + "structValueField3structValue";

				structAttrInStructAttr = gpackage1.createStructInStructTp();
				structAttrInStructAttr.setField1((Integer) structFields[0]);
				structAttrInStructAttr.setField2((String) structFields[1]);

				structFields = new Object[3];

				structFields[0] = testClassNr;
				structFields[1] = "TestClass" + testClassNr + "Inst" + instNr + "structValue";
				structFields[2] = structAttrInStructAttr;

				structAttr = gpackage1.createStructTp();
				structAttr.setField1((Integer) structFields[0]);
				structAttr.setField2((String) structFields[1]);
				structAttr.setField3((StructInStructTp) structFields[2]);

				tmpElements[testClassNr][instNr].getClass().getMethod("setAttrStruct", new Class[] { StructTp.class }).invoke(
						tmpElements[testClassNr][instNr], structAttr);

				/*
				 * set Enum type attribute
				 */

				enumAttr = EnumTp.LABEL1;

				tmpElements[testClassNr][instNr].getClass().getMethod("setAttrEnum", new Class[] { EnumTp.class }).invoke(
						tmpElements[testClassNr][instNr], enumAttr);

				/*
				 * create object-valued attributes
				 */
				if (this.createObjValAttrs) {
					// we put all object values as instances of TestClass0
					int ovaNr = 0;

					tmpObjValClass = (EClass) GeneratedmetamodelPackage.eINSTANCE.getEClassifier("TestClass" + ovaNr);
					// create object value
					tmpObjValAttribute[testClassNr][instNr][ovaNr] = gpackage1.create(tmpObjValClass);
					// calculate object valued attribute name for current class
					className = calculateObjectValuedAttrName(testClassNr, instNr, ovaNr, false);
					// assign object value to attribute
					((EObject) tmpObjValAttribute[testClassNr][instNr][ovaNr])
							.eSet(tmpObjValClass.getEStructuralFeature("name"), className);

					/*
					 * create attribute values object-valued attributes
					 */

					for (int attrNr = 0; attrNr < this.attrSize; attrNr++) {
						intAttr = calculateIntAttr(testClassNr, instNr, attrNr);
						dblAttr = calculateDoubleAttr(testClassNr, instNr, attrNr);
						stringAttr = className + "strValue" + attrNr;

						tmpObjValAttribute[testClassNr][instNr][ovaNr].getClass().getMethod("setAttrInt" + attrNr, intClass).invoke(
								tmpObjValAttribute[testClassNr][instNr][ovaNr], intAttr);
						tmpObjValAttribute[testClassNr][instNr][ovaNr].getClass().getMethod("setAttrDouble" + attrNr, doubleClass).invoke(
								tmpObjValAttribute[testClassNr][instNr][ovaNr], dblAttr);
						tmpObjValAttribute[testClassNr][instNr][ovaNr].getClass().getMethod("setAttrString" + attrNr, stringClass).invoke(
								tmpObjValAttribute[testClassNr][instNr][ovaNr], stringAttr);

						stringAttrMV = (Collection) tmpObjValAttribute[testClassNr][instNr][ovaNr].getClass().getMethod(
								"getAttrStringMultiValued" + attrNr, (Class[]) null).invoke(tmpObjValAttribute[testClassNr][instNr][ovaNr],
								(Object[]) null);

						/*
						 * set multi-valued String attributes
						 */

						for (int in = 0; in < 10; in++) {
							stringAttrMV.add(className + "strMultiValued" + attrNr + "Value" + in);
						}
					}

					tmpElements[testClassNr][instNr].getClass().getInterfaces()[0].getMethod("setAttrObjectValued" + (ovaNr),
							tmpObjValAttribute[testClassNr][instNr][ovaNr].getClass().getInterfaces()[0]).invoke(
							tmpElements[testClassNr][instNr], tmpObjValAttribute[testClassNr][instNr][ovaNr]);
				}
			}
		}

		// add links between instances

		Object testAssoc;
		Class[] addTypes = new Class[2];
		Object[] addElements = new Object[2];

		for (int testClassNrA = 0; testClassNrA < this.mmSize; testClassNrA++) {
			for (int testClassNrB = testClassNrA + 1; testClassNrB < this.mmSize; testClassNrB++) {
				if (!(testClassNrA == testClassNrB)) {

					//                    testAssoc = gpackage1.getClass( ).getMethod( "getAssoc" + testClassNrA + "x" + testClassNrB, (Class[]) null ).invoke( gpackage1, (Object[]) null );
					for (int instNr = 0; instNr < this.instSize; instNr++) {
						//                        addTypes[0] = tmpElements[testClassNrA][instNr].getClass( ).getInterfaces( )[0];
						//                        addTypes[1] = tmpElements[testClassNrB][instNr].getClass( ).getInterfaces( )[0];
						//                        addElements[0] = tmpElements[testClassNrA][instNr];
						//                        addElements[1] = tmpElements[testClassNrB][instNr];
						//                        testAssoc.getClass( ).getMethod( "add", addTypes ).invoke( testAssoc, addElements );
						//                        addElements[0] = tmpElements[testClassNrA][instNr];
						//                        addElements[1] = tmpSubElements[testClassNrB][instNr];
						//                        testAssoc.getClass( ).getMethod( "add", addTypes ).invoke( testAssoc, addElements );

						EObject o1 = (EObject) tmpElements[testClassNrA][instNr];
						EObject o2 = (EObject) tmpElements[testClassNrB][instNr];

						String featureName = "reference" + testClassNrA + "x" + testClassNrB;
						EList feature = (EList) o1.eGet(o1.eClass().getEStructuralFeature(featureName));
						feature.add(tmpElements[testClassNrB][instNr]);
						feature.add(tmpSubElements[testClassNrB][instNr]);
					}

				}
			}

			//testAssoc = gpackage1.getClass( ).getMethod( "getAssoc" + testClassNrA + "xRefElement", (Class[]) null ).invoke( gpackage1, (Object[]) null );
			for (int instNr = 0; instNr < this.instSize; instNr++) {
				//                addTypes[0] = tmpElements[testClassNrA][0].getClass( ).getInterfaces( )[0];
				//                addTypes[1] = EObject.class;
				//                addElements[0] = tmpElements[testClassNrA][0];
				//                addElements[1] = tmpElements[testClassNrA][instNr];
				//                testAssoc.getClass( ).getMethod( "add", addTypes ).invoke( testAssoc, addElements );

				EObject o1 = (EObject) tmpElements[testClassNrA][0];
				EObject o2 = (EObject) tmpElements[testClassNrA][instNr];

				String featureName = "reference" + testClassNrA + "xRefElement";
				EList feature = (EList) o1.eGet(o1.eClass().getEStructuralFeature(featureName));
				feature.add(o2);

			}

		}

		// persist class objects
		// objects are distributed to partitions "instPart0" ..
		// "instPart<partSize-1>"

		for (int i = 0; i < this.mmSize; i++) {
			for (int k = 0; k < this.instSize; k++) {

				int assignNr = calculatePartitionForClassNr(i, this.partSize);

				Resource resource = this.testClient.getResource(instPart[assignNr]);

				resource.getContents().add((EObject) tmpElements[i][k]);
				resource.getContents().add((EObject) tmpSubElements[i][k]);

				if (this.createObjValAttrs) {
					resource.getContents().add((EObject) tmpObjValAttribute[i][k][0]);
				}

			}
		}

		tmpClass = null;
		tmpSubClass = null;

	}

	public void saveData() throws Exception {

		this.testClient.saveAll();
	}

	private int delete_inst_partitions() throws Exception {

		int deletedPartitions = 0;

		for (int i = 0; i < this.partSize; i++) {
			if (this.testClient.deleteResourceStable(getInstPartName(i))) {
				deletedPartitions++;
			}
		}

		return deletedPartitions;
	}

	/*
	 * Static helper functions for the calculation of attribute values; these
	 * can be used by the instantiation method and the queries (to calculate the
	 * intended result set)
	 */

	static public String calculateClassName(int testClassNr, int instNr, boolean subClass) {

		return "Test" + (subClass ? "Sub" : "") + "Class" + testClassNr + "Inst" + instNr;
	}

	static public int calculateIntAttr(int testClassNr, int instNr, int attrNr) {

		return testClassNr * 1000000 + attrNr * 1000 + instNr;
	}

	static public double calculateDoubleAttr(int testClassNr, int instNr, int attrNr) {

		return testClassNr * 1000000 + attrNr * 1000 + instNr;
	}

	static public String calculateStringAttr(int testClassNr, int instNr, int attrNr, boolean subClass) {

		if (attrNr == EMPTY_STRING_ATTR_NUM) {
			return "";
		}
		return "Test" + (subClass ? "Sub" : "") + "Class" + testClassNr + "Inst" + instNr + "strValue" + attrNr;
	}

	static public String calculateMultiValuedStringAttr(int testClassNr, int instNr, int attrNr, int valueNr, boolean subClass) {

		return "Test" + (subClass ? "Sub" : "") + "Class" + testClassNr + "Inst" + instNr + "strMultiValued" + attrNr + "Value" + valueNr;
	}

	static public String calculateObjectValuedAttrName(int testClassNr, int instNr, int attrNr, boolean subClass) {

		return "Test" + (subClass ? "Sub" : "") + "Class" + testClassNr + "Inst" + instNr + "attrObjValued" + attrNr;
	}

	static public int calculatePartitionForClassNr(int testClassNr, int _partSize) {

		return testClassNr % _partSize;
	}

	static public String getInstPartName(int partNr) {

		return PART_PREFIX + partNr + partitionNameAppendix;
	}

	public Collection<URI> getAllPartitions() throws Exception {

		EList<Resource> resources = this.testClient.getResourceSet().getResources();

		Collection<URI> ret = new ArrayList<URI>(resources.size());

		for (Resource res : resources) {
			ret.add(res.getURI());
		}

		Collection<URI> allMaxRelevantPartitions = ret;
		// Clone list, because returned list is unmodifiable
		allMaxRelevantPartitions = new ArrayList<URI>(allMaxRelevantPartitions);
		for (Iterator<URI> iter = allMaxRelevantPartitions.iterator(); iter.hasNext();) {
			URI pri = iter.next();
			String partitionName = pri.toString();
			if (!partitionName.contains(PART_PREFIX)) {
				iter.remove();
			}
		}

		return allMaxRelevantPartitions;
	}

	public void shutdown() {

		if (this.testClient != null) {
			this.testClient.clear();
		}
		this.testClient = null;
	}
}
