package org.modelversioning.ecoremutator;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

public interface IModelProvider {

	/**
	 * @return the modelResource
	 */
	public abstract Resource getModelResource();

	/**
	 * @param modelResource
	 *            the modelResource to set
	 */
	public abstract void setModelResource(Resource modelResource);

	/**
	 * Adds the specified <code>eObject</code> to the list of objects to exclude
	 * from selection for mutation.
	 * 
	 * @param eObject
	 *            to exclude.
	 * @param excludeChildren
	 *            specifies whether the children of the specified
	 *            <code>eObject</code> should be excluded as well.
	 */
	public abstract void addToExcludedObjects(EObject eObject,
			boolean excludeChildren);

	/**
	 * Adds the specified <code>listOfEObject</code> to the list of objects to
	 * exclude from selection for mutation.
	 * 
	 * @param listOfEObject
	 *            to exclude.
	 * @param excludeChildren
	 *            specifies whether the children of the objects in the specified
	 *            <code>listOfEObject</code> should be excluded as well.
	 */
	public abstract void addToExcludedObjects(
			Collection<EObject> listOfEObject, boolean excludeChildren);

	/**
	 * Returns a random {@link EObject}. Only returns {@link EModelElement}s.
	 * 
	 * @return a random {@link EObject}.
	 */
	public abstract EObject getRandomEObject();

	/**
	 * Returns a random {@link EObject} of the type <code>metaClass</code>.
	 * 
	 * @param metaClass
	 *            type of the searched {@link EObject}.
	 * @return found {@link EObject} or <code>null</code>.
	 */
	public abstract EObject getRandomEObject(EClass metaClass);

	/**
	 * Returns a random leave {@link EObject}, i.e., an object without any
	 * children.
	 * 
	 * @return a random leave {@link EObject}.
	 */
	public abstract EObject getRandomEObjectNotContainingMoreObjectsThan(
			int objectCount);

	/**
	 * Returns a random object having the specified <code>feature</code>.
	 * 
	 * @param feature
	 *            feature.
	 */
	public abstract EObject getRandomEObjectHavingFeature(
			EStructuralFeature feature);

	/**
	 * Returns the size of model elements in the model.
	 * 
	 * @return the size of model elements in the model.
	 */
	public abstract int getModelSize();

	/**
	 * Returns a random feature of the specified <code>eObject</code>. Will only
	 * return {@link EStructuralFeature}s that are changeable, not transient and
	 * not derived. Might return <code>null</code> if there is none.
	 * 
	 * @param eObject
	 *            to get random feature of.
	 * @return random feature.
	 */
	public abstract EStructuralFeature getRandomFeature(EObject eObject);

	/**
	 * Returns a random multi-valued (isMany is <code>true</code>) feature of
	 * the specified <code>eObject</code>. Furthermore, the features are all not
	 * transient and not derived. Might return <code>null</code> if there is
	 * none.
	 * 
	 * @param eObject
	 *            to get random feature of.
	 * @return random feature.
	 */
	public abstract EStructuralFeature getRandomMultiValuedFeature(
			EObject eObject);

	/**
	 * Returns a random single-valued (isMany is <code>false</code>) feature of
	 * the specified <code>eObject</code>. Furthermore, the features are all
	 * changeable, not transient and not derived. Might return <code>null</code>
	 * if there is none.
	 * 
	 * @param eObject
	 *            to get random feature of.
	 * @return random feature.
	 */
	public abstract EStructuralFeature getRandomSingleValuedFeature(
			EObject eObject);

	/**
	 * Returns the meta package of the instance contained by the model resource.
	 * 
	 * @return the meta {@link EPackage}
	 */
	public abstract EPackage getPackage();

	/**
	 * Returns a concrete random class of the package defining the meta classes
	 * of the current model instance.
	 * 
	 * @return a random concrete classifier.
	 */
	public abstract EClass getRandomConcreteClass();

	/**
	 * Returns all {@link EStructuralFeature}s defined in the package defining
	 * the meta classes of the current model instance.
	 * 
	 * @return all {@link EStructuralFeature}s.
	 */
	public abstract EList<EStructuralFeature> getAllStructuralFeatures();

	/**
	 * Returns a random feature having the type (
	 * {@link EStructuralFeature#getEType()}) <code>eClass</code>. Furthermore,
	 * the features is not transient and not derived. Might return
	 * <code>null</code> if there is none.
	 * 
	 * @param eClass
	 *            restricting the type of the random feature.
	 * @return random feature having <code>eClass</code> as type.
	 */
	public abstract EStructuralFeature getRandomFeatureHavingType(EClass eClass);

	/**
	 * Returns a random feature having the type (
	 * {@link EStructuralFeature#getEType()}) <code>eClass</code>. Furthermore,
	 * the features is not transient and not derived. Might return
	 * <code>null</code> if there is none.
	 * 
	 * @param eClass
	 *            restricting the type of the random feature.
	 * @param specifies
	 *            whether the requested feature has to be a containment feature.
	 * @return random feature having <code>eClass</code> as type.
	 */
	public abstract EStructuralFeature getRandomFeatureHavingType(
			EClass eClass, boolean isContainment);

	/**
	 * Returns the children {@link EModelElement}s of the specified
	 * <code>eObject</code>.
	 * 
	 * @param eObject
	 *            to get children from.
	 * @return the children of <code>eObject</code>.
	 */
	public abstract EList<EObject> getChildren(EObject eObject);

	/**
	 * Returns a random value for the specified <code>feature</code>.
	 * 
	 * Clients may not just blindly set the generated value. They have to handle
	 * the difference in multi-valued features and single-valued feature. This
	 * method returns just <em>one</em> random value for the specified
	 * <code>feature</code>. In case of single-valued features the returned
	 * object may just be set, but in case of multi-valued it has to be, e.g.,
	 * added to the list of values.
	 * 
	 * If the type ({@link EStructuralFeature#getEType()}) of the feature is
	 * {@link EClass}, this method will return a random existing instance of
	 * this class (as far as it is available).
	 * 
	 * If it is {@link EEnum} it will return a random {@link EEnumLiteral} from
	 * {@link EEnum#getELiterals()}.
	 * 
	 * If it is {@link EDataType} it will generate an appropriate value.
	 * 
	 * This method also won't regard any constraints on this feature that
	 * restricts certain values added to this feature.
	 * 
	 * @param feature
	 *            feature for which the value to be returned.
	 * @return a value for the <code>feature</code> or <code>null</code> if no
	 *         valid value could be found.
	 */
	public abstract Object getRandomValue(EStructuralFeature feature);

	/**
	 * Returns a random string.
	 * 
	 * @return random string.
	 */
	public abstract String getRandomString();

}