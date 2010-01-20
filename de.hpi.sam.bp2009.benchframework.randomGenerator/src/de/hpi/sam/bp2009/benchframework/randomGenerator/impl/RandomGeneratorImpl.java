/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import de.hpi.sam.bp2009.benchframework.impl.OperatorImpl;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGenerator;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorFactory;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Random Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated NOT
 */
public class RandomGeneratorImpl extends OperatorImpl implements RandomGenerator {
	private ArrayList<EClass> metaClasses;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RandomGeneratorImpl() {
		super();
		RandomGeneratorOptionObject options = RandomGeneratorFactory.eINSTANCE.createRandomGeneratorOptionObject();
		this.setOption(options);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RandomGeneratorPackage.Literals.RANDOM_GENERATOR;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * The strategy to generate the model instance is to choose a class of the meta model at random and generate the minimum number of required referenced/containing classes.
	 * Therefore not all classes of the meta model have to be in the generated instance if they're referenced with a lower bound of 0. 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void execute() {
		ResourceSetImpl resultRS = new ResourceSetImpl();
		resultRS.createResource(URI.createURI("http://de.hpi.sam.bp2009.benchframework.randomGenerator/generatedInstance1"));
		RandomGeneratorOptionObject options = (RandomGeneratorOptionObject) getOption();
		ResourceSet metaModel = options.getMetaModel();
		metaClasses = new ArrayList<EClass>();
		
		//get all classes in the meta model
		for (String name:metaModel.getPackageRegistry().keySet()){
			if (metaModel.getPackageRegistry().getEPackage(name) == null){
				continue;
			}
			for(EClassifier cls:metaModel.getPackageRegistry().getEPackage(name).getEClassifiers()){
				if (cls instanceof EClass){
					metaClasses.add((EClass) cls);
				}
			}
		}
		//instantiate the meta model
		
		
	}
} //RandomGeneratorImpl
