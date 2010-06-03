package de.hpi.sam.bp2009.moinmutator;

import java.util.Collection;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public interface IMoinModelProvider {
    
    /**
     * @return the connection that holds the model to mutate
     */
    public abstract Connection getConnection();
    
    /**
     * @param connectionToSet
     *          the connection that holds the model to mutate
     */
    public abstract void setConnection (Connection connectionToSet);
    
    /**
     * Adds the specified <code>instance</code> to the list of objects to exclude from selection for mutation.
     * 
     * @param instance
     *          RefObject to exclude.
     * @param excludeChildren
     *          specifies whether the children of the specified <code>RefObject</code> should be excluded as well.
     */
    public abstract void addToExcludedObjects (RefObject instance, boolean excludeChildren);
    
    /**
     * Adds the specified <code>instances</code> to the list of objects to exclude from selection for mutation.
     * 
     * @param instances
     *            collection of RefObject to exclude.
     * @param excludeChildren
     *            specifies whether the children of the specified <code>instances</code> should be excluded as
     *            well.
     */
    public abstract void addToExcludedObjects (Collection<RefObject> instances, boolean excludeChildren);
    
    /**
     * Returns a random {@link RefObject} that is an instance of a {@link MofClass} of the meta model.
     * 
     * @return a random {@link RefObject}.
     */
    public abstract RefObject getRandomInstance();
    
    /**
     * Returns a random {@link RefObject} of the type <code>MofClass</code>.
     * 
     * @param classToLookFor
     *            type of the searched {@link RefObject}.
     * @return found {@link RefObject} or <code>null</code>.
     */
    public abstract RefObject getRandomInstance(MofClass classToLookFor);
    
    /**
     * Returns a random {@link RefObject}, that contains <code>instanceCount</code> other instances at maximum.
     * 
     * @return a random {@link RefObject}.
     */
    public abstract RefObject getRandomInstanceNotContainingMoreObjectsThan(int instanceCount);
    
    
    /**
     * Returns a random <code>RefObject</code> that has the given <code>StructuralFeature</code>
     * 
     * @param feature
     *          the {@link StructuralFeature} to look for
     * @return a random {@link RefObject}
     */
    public abstract RefObject getRandomInstanceHavingFeature(StructuralFeature feature);
    
    /**
     * @return the number of model elements
     */
    public abstract int getModelSize();
    
    
    /**
     * Returns a random {@link StructuralFeature} of the specified <code>RefObject</code>. Will only return {@link StructuralFeature}s that are
     * changeable, not transient and not derived. Might return <code>null</code> if there is none.
     * 
     * @param instance
     *            to get random feature of.
     * @return random feature.
     */
    public abstract StructuralFeature getRandomFeature(RefObject instance);
    
    /**
     * Returns a random multi-valued feature of the specified <code>RefObject</code>. Furthermore, the
     * features are all not transient and not derived. Might return <code>null</code> if there is none.
     * 
     * @param instance
     *            to get random feature of.
     * @return random feature.
     */
    public abstract StructuralFeature getRandomMultiValuedFeature(RefObject instance);
    
    /**
     * Returns a random single-valued feature of the specified <code>RefObject</code>. Furthermore,
     * the features are all changeable, not transient and not derived. Might return <code>null</code> if there is none.
     * 
     * @param instance
     *            to get random feature of.
     * @return random feature.
     */
    public abstract StructuralFeature getRandomSingleValuedFeature(RefObject instance);
    
    /**
     * Returns the outermost package of the first element of the connection.
     * 
     * @return the {@link MofPackage}
     */
    public abstract MofPackage getPackage();
    
    /**
     * Returns a concrete random class of the package defining the meta classes of the current model instance.
     * 
     * @return a random non-abstract MofClass.
     */
    public abstract MofClass getRandomConcreteClass();
    
    /**
     * Returns all {@link StructuralFeature}s defined in the package defining the meta classes of the current model instance.
     * 
     * @return all {@link StructuralFeature}s.
     */
    public abstract Collection<StructuralFeature> getAllStructuralFeatures();
    
    /**
     * Returns a random feature having the type <code>type</code>. Furthermore, the
     * features is not transient and not derived. Might return <code>null</code> if there is none.
     * 
     * @param type
     *            {@link MofClass} restricting the type of the random feature.
     * @return random feature having <code>type</code> as type.
     */
    public abstract StructuralFeature getRandomFeatureHavingType(MofClass type);
    
    /**
     * Returns a random feature having the type <code>type</code>. Furthermore, the
     * features is not transient and not derived. Might return <code>null</code> if there is none.
     * 
     * @param type
     *            {@link MofClass} restricting the type of the random feature.
     * @param specifies
     *            whether the requested feature has to be a containment feature.
     * @return random feature having <code>eClass</code> as type.
     */
    public abstract StructuralFeature getRandomFeatureHavingType(MofClass type, boolean isContainment);
    
    /**
     * Returns the children {@link RefObject}s of the specified <code>instance</code>.
     * 
     * @param instance
     *            {@link RefObject} to get children from.
     * @return the children of <code>instance</code>.
     */
    public abstract Collection<RefObject> getChildren(RefObject instance);
    
    /**
     * Returns a random value for the specified <code>feature</code>.
     * 
     * Clients may not just blindly set the generated value. They have to handle the difference in multi-valued features and
     * single-valued feature. This method returns just <em>one</em> random value for the specified <code>feature</code>. In case
     * of single-valued features the returned object may just be set, but in case of multi-valued it has to be, e.g., added to the
     * list of values.
     * 
     * If the type of the feature is {@link MofClass}, this method will return a random
     * existing instance of this class (as far as it is available).
     * 
     * If it is {@link EnumerationType} it will return a random label from {@link EnumerationType#getLabels()}.
     * 
     * If it is {@link PrimitiveType} it will generate an appropriate value.
     * 
     * This method also won't regard any constraints on this feature that restricts certain values added to this feature.
     * 
     * @param feature
     *            {@link StructuralFeature} for which the value should be returned.
     * @return a value for the <code>feature</code> or <code>null</code> if no valid value could be found.
     */
    public abstract Object getRandomValue(StructuralFeature feature);
    
    /**
     * Returns a random readable string matching the regEx [a-zA-Z0-9]{0,50}.
     * 
     * @return random string.
     */
    public abstract String getRandomString();
    
}
