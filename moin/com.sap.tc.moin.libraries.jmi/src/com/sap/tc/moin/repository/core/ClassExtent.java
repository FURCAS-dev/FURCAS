package com.sap.tc.moin.repository.core;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;

public interface ClassExtent extends Extent {

    /**
     * Returns the cached list of structural features of this class.
     */
    public List<StructuralFeature> get___StructuralFeatures( );

    /**
     * Sets the cached list of structural features of this class.
     */
    public void set___StructuralFeatures( List<StructuralFeature> structuralFeatures );

    /**
     * Returns the cached list of structural features of this class including
     * those of supertypes.
     */
    public List<StructuralFeature> get___AllStructuralFeatures( );

    /**
     * Sets the cached list of structural features of this class including those
     * of supertypes.
     */
    public void set___AllStructuralFeatures( List<StructuralFeature> attributes );

    /**
     * Returns the cached list of attributes of this class.
     */
    public List<Attribute> get___Attributes( );

    /**
     * Sets the cached list of attributes of this class.
     */
    public void set___Attributes( List<Attribute> attributes );

    /**
     * Returns the cached list of attributes of this class including those of
     * supertypes.
     */
    public List<Attribute> get___AllAttributes( );

    /**
     * Returns the cached list of translatable text attributes of this class
     * including those of supertypes.
     */
    public List<Attribute> get___AllTranslatableTextAttributes( );

    /**
     * Returns the cached list of StructureType-typed attributes of this class
     * including those of supertypes.
     */
    public List<Attribute> get___AllStructureTypedAttributes( );

    /**
     * Returns the cached list of object-valued attributes of this class
     * including those of supertypes.
     */
    public List<Attribute> get___AllObjectValuedAttributes( );

    /**
     * Sets the cached list of attributes of this class including those of
     * supertypes.
     */
    public void set___AllAttributes( List<Attribute> attributes );

    /**
     * Sets the cached list of translatable text attributes of this class
     * including those of supertypes.
     */
    public void set___AllTranslatableTextAttributes( List<Attribute> attributes );

    /**
     * Sets the cached list of StructureType-typed attributes of this class
     * including those of supertypes.
     */
    public void set___AllStructureTypedAttributes( List<Attribute> attributes );

    /**
     * Sets the cached list of object-valued attributes of this class including
     * those of supertypes.
     */
    public void set___AllObjectValuedAttributes( List<Attribute> attributes );

    /**
     * Returns the cached list of references of this class.
     */
    public List<Reference> get___References( );

    /**
     * Sets the cached list of references of this class.
     */
    public void set___References( List<Reference> attributes );

    /**
     * Returns the cached list of references of this class including those of
     * supertypes.
     */
    public List<Reference> get___AllReferences( );

    /**
     * Sets the cached list of references of this class including those of
     * supertypes.
     */
    public void set___AllReferences( List<Reference> attributes );

    /**
     * Returns the cached list of all supertypes of this class.
     */
    public List<GeneralizableElement> get___AllSupertypes( );

    /**
     * Sets the cached list of all supertypes of this class.
     */
    public void set___AllSupertypes( List<GeneralizableElement> types );
}