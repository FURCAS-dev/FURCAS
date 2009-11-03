package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;
import java.util.Map;

/**
 * The Class implementation template
 */
public interface JmiGeneratorClassImplTemplate extends JmiGeneratorImplTemplate {

    /**
     * @return the attribute declarations
     */
    public List<JmiGeneratorAttributeDeclaration> getAttributeDeclarations( );

    /**
     * @return the attribute initializations
     */
    public List<JmiGeneratorTypedElementInitialization> getAttributeInitializations( );

    /**
     * @return the attributes
     */
    public List<JmiGeneratorClassOperation> getAttributeOperations( );

    /**
     * @return the references
     */
    public List<JmiGeneratorClassOperation> getReferenceOperations( );

    /**
     * @return the operations
     */
    public List<JmiGeneratorClassOperation> getOperations( );

    /**
     * @return the features
     */
    public List<JmiGeneratorFeature> getFeatures( );

    /**
     * @return the feature IDs
     */
    public List<String> getFeatureIds( );

    /**
     * @return the operation IDs
     */
    public List<String> getOperationIds( );

    /**
     * @return the capacity for the feature map (calculated from the number of
     * features)
     */
    public int getFeatureIdsMapCapacity( );

    /**
     * @return the features for which to generate internal setters
     */
    public List<JmiGeneratorFeature> getInternalSetterFeatures( );

    /**
     * @return the internal modeled operations
     */
    public List<JmiGeneratorClassOperation> getInternalModeledOperations( );

    /**
     * @return <code>true</code> if the class is abstract
     */
    public Boolean isAbstract( );

    /**
     * @return the wrapper template
     */
    public JmiGeneratorBaseTemplate getWrapper( );

    /**
     * @return whether the implementation class should be generated with the
     * "final" modifier (which is the regular case, but there are two
     * exceptions: com.sap.tc.moin.repository.mmi.model.__impl.AssociationImpl and
     * com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl)
     */
    public Boolean isNeedsNonFinal( );

    /**
     * @return the names of variables of type EndStorageLink containing links to
     * multiplicity-1 association ends, keyed by the association ends' MOF-IDs
     */
    public Map<String, String> getMultiplicityOneLinkVariables( );

    /**
     * @return the names of variables of type Collection<EndStorageLink>
     * containing links to multiplicity-n association ends, keyed by the
     * association ends' MOF-IDs
     */
    public Map<String, String> getMultiplicityManyLinkVariables( );

    /**
     * @return the names of variables of type EndStorageLink containing
     * multiplicity-1 attribute links
     */
    public Map<String, String> getMultiplicityOneAttributeLinkVariables( );

    /**
     * @return the names of variables of type Collection<EndStorageLink>
     * containing multiplicity-n attribute links
     */
    public Map<String, String> getMultiplicityManyAttributeLinkVariables( );

    public boolean isHasLinkVariables( );
}