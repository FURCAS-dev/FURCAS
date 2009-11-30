/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;

import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.impl.GeneratorImpl;

import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGenerator;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Random Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RandomGeneratorImpl extends GeneratorImpl implements RandomGenerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomGeneratorImpl() {
		super();
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
@Override
public Resource execute(OptionObject option) {
	// TODO Auto-generated method stub
	System.out.println("Hallo");
	return null;
}
} //RandomGeneratorImpl
