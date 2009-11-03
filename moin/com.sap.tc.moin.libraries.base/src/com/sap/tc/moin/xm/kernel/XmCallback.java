package com.sap.tc.moin.xm.kernel;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mmi.reflect.RefClassCalculatedMofId;


/**
 * Call-back used by the XM Parser/Serializer for creating and accessing MOIN
 * model elements.
 * 
 * @param <TMofClass> either RefClass in the case of Import/Export integration
 * strategy or SpiClass in the case of CPS integration strategy
 * @param <TElement> either a RefObject representing a MOF class instance in the
 * case of Import/Export integration strategy or a SpiElement in the case of CPS
 * integration strategy
 * @param <TMofAssociation> either a RefAssociation in the case of Import/Export
 * integration strategy or a SpiAssociation in the case of CPS integration
 * strategy
 */
public interface XmCallback<TElement extends Object, TMofClass extends Object, TMofAssociation extends Object> {

    /**
     * Returns the {@link PRI} of the currently parsed/serialized partition.
     * 
     * @return the {@link PRI} of the currently parsed/serialized partition
     */
    PRI getPri( );

    /**
     * Calculates a MOFID for an instance of the given MOF class from the
     * specified logical key.
     * 
     * @param mofClass representing the {@link MofClass} used for MOF ID
     * calculation
     * @param logicalKey see
     * {@link RefClassCalculatedMofId#calculateMofId(String...)} for details on
     * this parameter
     * @return a calculated MOF ID
     * @throws IllegalArgumentException if the type parameter does not represent
     * a {@link MofClass}
     */
    String calculateElementMofId( TMofClass mofClass, String[] logicalKey );



    /** Returns the MOFID of a class instance. */
    String getInstanceMofId( TElement classInstance );



    /**
     * Returns an instance of a MOF class given by the metamodel container name
     * and the dot-separated qualified name. If the class cannot be resolved,
     * <code>null</code> is returned.
     * 
     * @param metamodelContainer the name of the metamodel container of the MOF
     * class
     * @param dotSeparatedQualifiedName the dot-separated qualified name of the
     * MOF class
     * @return an instance representing a {@link MofClass}, or <code>null</code>
     * @throws IllegalArgumentException if a parameter is <code>null</code>
     */
    TMofClass getClass( String metamodelContainer, String dotSeparatedQualifiedName );

    /**
     * Returns an instance representing the {@link RefAssociation} given by the
     * metamodel container name and the dot-separated qualified name. If the
     * association cannot be resolved, <code>null</code> is returned.
     * 
     * @param metamodelContainer the name of the metamodel container of the
     * requested association
     * @param dotSeparatedQualifiedName the dot-separated qualified name of the
     * requested association
     * @return an association instance representing, or <code>null</code> in the
     * serializer CP/S case when no link of the association is part of the
     * model-partition
     * @throws IllegalArgumentException if a parameter is <code>null</code>
     */
    TMofAssociation getAssociation( String metamodelContainer, String dotSeparatedQualifiedName );


//    /**
//     * Returns the meta-model container name of a MOF class.
//     * 
//     * @param clazz MOF class object
//     * @return container name of the meta-object
//     * @throws NullPointerException if <tt>clazz</tt> is <code>null</code>
//     */
//    String getMetamodelContainerName( TMofClass clazz );
}
