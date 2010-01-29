/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import de.hpi.sam.bp2009.benchframework.impl.OperatorImpl;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGenerator;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorFactory;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Random Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RandomGeneratorImpl extends OperatorImpl implements RandomGenerator {
	private ArrayList<EClass> metaClasses;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RandomGeneratorImpl() {
		super();
		this.setOption(RandomGeneratorFactory.eINSTANCE.createRandomGeneratorOptionObject());
		this.setName("Random Generator");
		this.setDescription("Instantiates a random instance of the model and adds all needed references to it.");
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
		Resource result = resultRS.createResource(URI.createURI("http://de.hpi.sam.bp2009.benchframework.randomGenerator/generatedInstance1"));
		RandomGeneratorOptionObject options = (RandomGeneratorOptionObject) getOption();
		EPackage metaModel = options.getMetaModel();
		metaClasses = new ArrayList<EClass>();
		
		//get all classes in the meta model
		for(EClassifier cls:metaModel.getEClassifiers()){
			if (cls instanceof EClass ){
				EClass c = (EClass) cls;
				if(c.isAbstract())
					continue;
				metaClasses.add(c);
			}
		}

		//instantiate the meta model
		instantiate(metaClasses.get(new Random().nextInt(metaClasses.size())), result);
		this.getTestRun().setModel(resultRS);
	}
	
	/**Create an instance of the given meta class and add it to the resource
	 * @param cls the meta class to instantiate
	 * @param res the resource to instantiate the meta class in
	 * @return the instance of the meta class
	 */
	private EObject instantiate(EClass cls, Resource res){
		if(cls.isAbstract())
			return instantiate(getImplementationForAbstractClass(cls), res);
		EObject current = cls.getEPackage().getEFactoryInstance().create(cls);
		res.getContents().add(current);
		
		//get all references of the meta class and link the instance accordingly
		for (EReference ref:cls.getEAllReferences()){
			if( ExtendedMetaData.INSTANCE.getAffiliation(cls, ref)==null)
				//TODO don't know how to handle this stuff
				continue;
			//link to already existing classes
			int lowerBound = ref.getLowerBound();
			for (EObject resContent:res.getContents()){
				if (resContent instanceof EClass && (EClass)resContent.eClass() == ref.getEReferenceType()){
					if (lowerBound == 0){
						break;
					}
					cls.eSet(ref, resContent);
					lowerBound--;
				}
			}
			
			//create remaining needed classes and link them
			for (int i = 0; i < lowerBound; i++){
				EObject nextCls = instantiate(ref.getEReferenceType(), res);
				cls.eSet(ref, nextCls);
			}
		}
		return current;
	}

	private EClass getImplementationForAbstractClass(EClass abstractCls) {
		if(!abstractCls.isAbstract())
			return abstractCls;
		
		for(EClass cls:metaClasses){
			if(cls.getESuperTypes().contains(abstractCls)){
				return getImplementationForAbstractClass(cls);
			}
				
		}
		return null;
	}

} //RandomGeneratorImpl
