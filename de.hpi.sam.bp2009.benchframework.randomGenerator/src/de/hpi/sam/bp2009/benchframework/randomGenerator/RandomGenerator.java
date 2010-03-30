package de.hpi.sam.bp2009.benchframework.randomGenerator;


import de.hpi.sam.bp2009.benchframework.Operator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This random generator generates a random instance of a given meta model. The meta model to instantiate has to be given in the respective RandomGeneratorOptionObject alon with some parameters the model instance has to match.
 * <!-- end-model-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage#getRandomGenerator()
 * @model
 * @generated
 */
public interface RandomGenerator extends Operator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void generateRandomModel(Integer number, Resource resource, EPackage pkg);

} // RandomGenerator