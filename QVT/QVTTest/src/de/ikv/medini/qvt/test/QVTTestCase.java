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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import junit.framework.Assert;
import de.ikv.medini.ocl.test.util.Utilities;

/**
 * Abstract test case for all QVT test cases
 * 
 */
public abstract class QVTTestCase extends MediniTestCase {

	public static final String PROP_RANDOMIZE = "randomize";

	public static final String PROP_INPLACE = "inPlace";

	public static final String PROP_PARSE = "parse";

	public static final String PROP_INPLACE_IN_ONE_TRANSFORMATION = "inPlaceInOneTransformation";

	public static final String PROP_DISABLE_TRACES = "traces";

	public static final String PROP_DEBUG_TASKS = "debugTasks";

	protected String[] metamodelIDs = new String[] { "EUML", "EUML" };

	public final String META_UMLUseCase = "EUML::Generic::UseCases::UMLUseCase";

	public final String META_UMLPackage = "EUML::Generic::Kernel::UMLPackage";

	public final String META_UMLNamedElement = "EUML::Generic::Kernel::UMLNamedElement";

	public String META_UMLNamedElement_name = "name";

	public final String META_UMLNamedElement_alias = "alias";

	public final String META_UMLElement = "EUML::Generic::Kernel::UMLElement";

	public final String META_UMLElement_the_owner = "the_owner";

	public final String META_UMLNamedElement_theNamespace = "theNamespace";

	public final String META_UMLElement_the_owned_elements = "the_owned_elements";

	public final String META_UMLActivity = "EUML::Generic::Activities::UMLActivity";

	public final String META_UMLInitialNode = "EUML::Generic::Activities::UMLInitialNode";

	public final String META_UMLFinalNode = "EUML::Generic::Activities::UMLFinalNode";

	public final String META_UMLDecisionMergeNode = "EUML::Generic::Activities::UMLDecisionMergeNode";

	public final String META_UMLComponent = "EUML::Generic::Components::UMLComponent";

	public final String META_UMLProperty = "EUML::Generic::Kernel::UMLProperty";

	public final String META_UMLOperation = "EUML::Generic::Kernel::UMLOperation";

	public final String META_UMLParameter = "EUML::Generic::Kernel::UMLParameter";

	public final String META_UMLInterface = "EUML::Generic::Kernel::UMLInterface";

	public final String META_UMLClass = "EUML::Generic::Kernel::UMLClass";

	public final String META_UMLClassifier = "EUML::Generic::Kernel::UMLClassifier";

	public final String META_UMLBehavior = "EUML::Generic::CommonBehaviors::UMLBehavior";

	public final String META_UMLStructuredClassifier = "EUML::Generic::CompositeStructures::UMLStructuredClassifier";

	public final String META_UMLClassifier_isAbstract = "isAbstract";

	public final String META_UMLCollaboration = "EUML::Generic::CompositeStructures::UMLCollaboration";

	public final String META_UMLDirectedRelationship = "EUML::Generic::Relationships::UMLDirectedRelationship";

	public final String META_UMLDirectedRelationship_the_target_element = "the_target_element";

	public final String META_UMLDirectedRelationship_the_source_element = "the_source_element";

	public final String META_UMLOutputPin = "EUML::Generic::Activities::UMLOutputPin";

	public final String META_DesignPhase = "AmedatoModeling::Project::DesignPhase";

	public final String META_DesignPhase_kind = "kind";

	public final String META_ToyScreenFlowDefinition = "AmedatoModeling::ToySpecific::ToyConceptualScreenFlowDesign::ToyScreenFlowDefinition";

	public final String META_ToySpecificUseCase = "AmedatoModeling::ToySpecific::ToyUseCaseDesign::ToySpecificUseCase";

	public final String META_ToyScreen = "AmedatoModeling::ToySpecific::ToyConceptualScreenFlowDesign::ToyScreen";

	public final String META_ToyScreenInvocation = "AmedatoModeling::ToySpecific::ToyDetailedScreenFlowDesign::ToyScreenInvocation";

	public final String META_ToyScreenDefinition = "AmedatoModeling::ToySpecific::ToyScreenDesign::ToyScreenDefinition";

	public final String META_ToyScreenTransition = "AmedatoModeling::ToySpecific::ToyConceptualScreenFlowDesign::ToyScreenTransition";

	public final String META_ToyDetailedScreenTransition = "AmedatoModeling::ToySpecific::ToyDetailedScreenFlowDesign::ToyDetailedScreenTransition";

	public final String META_EAPackage = "EARepository::EAPackage";

	public QVTTestAdapter adapter;

	private boolean supported;

	/**
	 * Returns the contents of the given file as string
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public String readFile(String fileName) throws IOException {
		String result = "";
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String str;
		while ((str = in.readLine()) != null) {
			result += str;
		}
		in.close();
		return result;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Class adapterClass = Class.forName(this.getProperty("adapter"));
		this.adapter = (QVTTestAdapter) adapterClass.getConstructor(new Class[0]).newInstance(new Object[0]);
		this.supported = true;
		HashSet<String> usedMetaModelIDs = new HashSet<String>();

		for (String metamodelID : this.metamodelIDs) {
			usedMetaModelIDs.add(metamodelID);
		}
		String[] usedMetaModelIDsSet = new String[usedMetaModelIDs.size()];

		int i = 0;
		for (String metamodelID : usedMetaModelIDs) {
			usedMetaModelIDsSet[i] = metamodelID;
			i++;
		}

		this.supported = this.adapter.supportsMetaModels(usedMetaModelIDsSet);
		if (!this.metaModelSupported()) {
			return;
		}

		if (this.metamodelIDs.length == 3) {
			System.setProperty(QVTTestAdapter.QVTTESTADAPTER_THREEDOMAINS, "true");
		} else {
			System.setProperty(QVTTestAdapter.QVTTESTADAPTER_THREEDOMAINS, "false");
		}
		this.adapter.setUp(this.getProperties());
	}

	protected boolean metaModelSupported() {
		return this.supported;
	}

	@Override
	protected void tearDown() throws Exception {
		this.metamodelIDs = new String[] { "EUML", "EUML" };
		System.setProperty(QVTTestAdapter.QVTTESTADAPTER_TWOSOURCEMODELS, "false");
		System.setProperty(QVTTestAdapter.QVTTESTADAPTER_INPLACE, "false");
		System.setProperty(QVTTestAdapter.PROP_DISABLE_TRACES, "false");
		this.adapter.tearDown();
		this.adapter = null;
		super.tearDown();
	}

	/**
	 * Checks whether two forward transformations plus one backward transformation behaves as expected forward transformation
	 */
	protected void checkTraces(String qvtFile, String transformationName, String direction, String backwardDirection, int expectedMediniInstances) throws FileNotFoundException {

		Collection firstSourceIDs = this.getSourceIDs(false);

		System.out.println("Start first transformation in direction " + direction);
		this.adapter.evaluateQVT(this.fullPath(qvtFile), transformationName, true, direction);

		Collection firstTargetIDs = this.getSourceIDs(true);

		if (expectedMediniInstances != -1) {
			Assert.assertEquals(expectedMediniInstances, firstTargetIDs.size());
		}

		if ("true".equalsIgnoreCase(this.getProperty(QVTTestAdapter.PROP_DISABLE_TRACES))) {
			return;
		}

		System.out.println("Start second transformation in direction " + direction);

		this.adapter.evaluateQVT(this.fullPath(qvtFile), transformationName, true, direction);

		Assert.assertEquals(0, this.adapter.getCreateOclAnyModelElementCount());

		Collection secondTargetIDs = this.getSourceIDs(true);

		Assert.assertTrue("Second forward transformation must not create/modify target elements (" + firstTargetIDs.size() + "<>" + secondTargetIDs.size() + ")", Utilities.areCollectionsEqual(
		        firstTargetIDs, secondTargetIDs));

		System.out.println("Start backward transformation in direction " + backwardDirection);

		this.adapter.evaluateQVTBackward(this.fullPath(qvtFile), transformationName, true, backwardDirection);

		Assert.assertEquals(0, this.adapter.getCreateOclAnyModelElementCount());

		Collection secondSourceIDs = this.getSourceIDs(false);

		if ("true".equalsIgnoreCase(this.getProperty(QVTTestAdapter.QVTTESTADAPTER_INPLACE))) {
			firstSourceIDs = new ArrayList(firstTargetIDs);
		}

		List _firstSourceIDs = new ArrayList(firstSourceIDs);

		_firstSourceIDs.removeAll(secondSourceIDs);

		secondSourceIDs.removeAll(firstSourceIDs);

		if (!secondSourceIDs.isEmpty()) {
			Assert.assertTrue("ID of illegaly new element:" + secondSourceIDs.iterator().next() + " (totally new elements:" + this.adapter.getCreateOclAnyModelElementCount() + ")", false);
		}

		if (!_firstSourceIDs.isEmpty()) {
			Assert.assertTrue("ID of illegaly deleted element:" + _firstSourceIDs.get(0), false);
		}

	}

	protected String fullPath(String qvtFile) {
		return this.getProperty("qvt.dir") + qvtFile;
	}

	/**
	 * Get IDs of all model elements
	 * 
	 * @param onTarget
	 *            if true, IDs of the target model are collected
	 * @return
	 */
	protected Collection getSourceIDs(boolean onTarget) {

		List result = !onTarget ? this.adapter.evaluateOnSource("Generic::Kernel::UMLTypedElement.allInstances()") : this.adapter.evaluateOnTarget("Generic::Kernel::UMLTypedElement.allInstances()");
		Assert.assertEquals(1, result.size());
		Assert.assertEquals(true, result.get(0) instanceof Collection);
		Collection ids1 = new HashSet(Utilities.getIdentities((Collection) result.get(0), this.adapter));

		result = !onTarget ? this.adapter.evaluateOnSource("Generic::Kernel::UMLNamespace.allInstances()") : this.adapter.evaluateOnTarget("Generic::Kernel::UMLNamespace.allInstances()");
		Assert.assertEquals(1, result.size());
		Assert.assertEquals(true, result.get(0) instanceof Collection);
		ids1.addAll(Utilities.getIdentities((Collection) result.get(0), this.adapter));

		result = !onTarget ? this.adapter.evaluateOnSource("Generic::Relationships::UMLDirectedRelationship.allInstances()") : this.adapter
		        .evaluateOnTarget("Generic::Relationships::UMLDirectedRelationship.allInstances()");
		Assert.assertEquals(1, result.size());
		Assert.assertEquals(true, result.get(0) instanceof Collection);
		ids1.addAll(Utilities.getIdentities((Collection) result.get(0), this.adapter));

		try {

			result = !onTarget ? this.adapter.evaluateOnSource("Transformation::TransformationInstance.allInstances()") : this.adapter
			        .evaluateOnTarget("Transformation::TransformationInstance.allInstances()");

			Assert.assertEquals(1, result.size());
			Assert.assertEquals(true, result.get(0) instanceof Collection);
			ids1.removeAll(Utilities.getIdentities((Collection) result.get(0), this.adapter));
		} catch (Exception e) {

		}

		return new ArrayList(ids1);
	}

	/**
	 * Finds an UMLNamedElement by given name in the source or target model
	 * 
	 * @param name
	 * @param onTarget
	 * @return
	 */
	protected Object findByName(String name, boolean onTarget, String qualifiedName) {
		Collection elements = this.findElementsWithName(name, onTarget, qualifiedName);
		Assert.assertEquals(1, elements.size());
		return elements.iterator().next();
	}

	protected Object findByName(String name, boolean onTarget) {
		return this.findByName(name, onTarget, this.META_UMLNamedElement);
	}

	/**
	 * Asserts to no find an UMLNamedElement by given name in the source or target model
	 * 
	 * @param name
	 * @param onTarget
	 * @return
	 */
	protected void notFindByName(String name, boolean onTarget) {
		Collection elements = this.findElementsWithName(name, onTarget);
		Assert.assertEquals(0, elements.size());
	}

	protected void notFindByName(String name, boolean onTarget, String qualifiedName) {
		Collection elements = this.findElementsWithName(name, onTarget, qualifiedName);
		Assert.assertEquals(0, elements.size());
	}

	protected Collection findElementsWithName(String name, boolean onTarget) {
		return this.findElementsWithName(name, onTarget, this.META_UMLNamedElement);
	}

	protected Collection findElementsWithName(String name, boolean onTarget, String qualifiedName) {
		String query = this.withoutTopPackage(qualifiedName) + ".allInstances()->select(x | x." + this.META_UMLNamedElement_name + "='" + name + "')";
		List result = onTarget ? this.adapter.evaluateOnTarget(query) : this.adapter.evaluateOnSource(query);
		Assert.assertEquals(1, result.size());
		return (Collection) result.get(0);
	}

	protected Collection findElementsByType(boolean onTarget, String qualifiedName) {
		String query = this.withoutTopPackage(qualifiedName) + ".allInstances()";
		List result = onTarget ? this.adapter.evaluateOnTarget(query) : this.adapter.evaluateOnSource(query);
		Assert.assertEquals(1, result.size());
		return (Collection) result.get(0);
	}

	protected Object createModelElementWithNamespace(String modelElementType, Object owner) {
		if (owner != null) {
			Object result = this.createModelElement(modelElementType);
			this.adapter.setValueForFeature(result, this.META_UMLNamedElement_theNamespace, owner);
			return result;
		} else {
			return this.createModelElement(modelElementType);
		}
	}

	protected Object createModelElementWithOwner(String modelElementType, Object owner) {
		if (owner != null) {
			Object result = this.createModelElement(modelElementType);
			try {
				this.adapter.setValueForFeature(result, this.META_UMLElement_the_owner, owner);
			} catch (Exception e) {
				// JMI jumps here
			}
			return result;
		} else {
			return this.createModelElement(modelElementType);
		}
	}

	protected Object createModelElement(String modelElementType) {
		return this.adapter.createModelElement(this.metamodelIDs[0] + "::" + this.withoutTopPackage(modelElementType));
	}

	protected Object createModelElementInModel(String modelElementType, int modelIndex) {
		return this.adapter.createModelElementInModel(this.metamodelIDs[0] + "::" + this.withoutTopPackage(modelElementType), modelIndex);
	}

	protected Object createModelElementInTargetWithOwner(String modelElementType, Object owner) {
		if (owner != null) {
			Object result = this.createModelElementInTarget(modelElementType);
			this.adapter.setValueForFeature(result, this.META_UMLElement_the_owner, owner);
			return result;
		} else {
			return this.createModelElementInTarget(modelElementType);
		}
	}

	protected Object createModelElementInTarget(String modelElementType) {
		return this.adapter.createModelElementInTarget(this.metamodelIDs[1] + "::" + this.withoutTopPackage(modelElementType));
	}

	private String withoutTopPackage(String qualifiedName) {
		return qualifiedName.substring(qualifiedName.indexOf("::") + 2);
	}
}
