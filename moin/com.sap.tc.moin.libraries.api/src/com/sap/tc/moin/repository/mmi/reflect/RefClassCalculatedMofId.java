package com.sap.tc.moin.repository.mmi.reflect;


import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;


/**
 * Any class proxy can be casted into this interface in order to make use of
 * additional functions of class proxies to work with calculated MOF ids. These
 * additional methods allow the creation of model elements with MOF-ids which
 * are derived from a logical key.
 * <p>
 * <b>Important Note:</b> As the usage of calculated MOF-IDs can lead to
 * multiple repository and semantic inconsistencies, we <b>strongly discourage
 * its use</b>.
 * <p>
 * For further details, please refer to the "Modeling Infrastructure Developer
 * Guide > Model Access and Manipulation > Working with Model Elements >
 * Extended Java Metadata Interface > Calculated MOF Ids", available in the
 * Eclipse Help.
 * </p>
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface RefClassCalculatedMofId {

    /**
     * {@link #refCreateInstance(String[])}
     * 
     * @param partition the partition that the element is assigned to. If
     * <code>null</code> the element is created within the
     * {@link Connection#getNullPartition()}.
     * @param logicalKey the logical key which is used in order to calculate the
     * logical key hash for the MOF id
     * @return the model element created
     */
    public RefObject refCreateInstanceInPartition( ModelPartition partition, String... logicalKey );

    /**
     * {@link #refCreateInstance(String[])}
     * 
     * @param partition the partition that the element is assigned to. If
     * <code>null</code> the element is created within the
     * {@link Connection#getNullPartition()}..
     * @param superClassDescriptor The descriptor of the super-class that shall
     * be used to be mixed into the calculated mof-id. If <code>null</code>, the
     * method behaves like
     * {@link #refCreateInstanceInPartition(ModelPartition, String...)}.
     * @param logicalKey the logical key which is used in order to calculate the
     * logical key hash for the MOF id
     * @return the model element created
     */
    public RefObject refCreateInstanceInPartition( ModelPartition partition, ClassDescriptor<?, ?> superClassDescriptor, String... logicalKey );

    /**
     * Calculates the mof-id that would be assigned to the element if
     * {@link #refCreateInstance(String[])} would be called.
     * 
     * @param logicalKey the logical key which is used in order to calculate the
     * logical key hash for the MOF id
     * @return The calculated mof-id
     */
    public String calculateMofId( String... logicalKey );

    /**
     * Calculates the mof-id that would be assigned to the element if
     * {@link #refCreateInstance(String[])} would be called.
     * 
     * @param superClassDescriptor The descriptor of the super-class that shall
     * be used to be mixed into the calculated mof-id. If <code>null</code>, the
     * method behaves like {@link #calculateMofId(String...)}.
     * @param logicalKey the logical key which is used in order to calculate the
     * logical key hash for the MOF id
     * @return The calculated mof-id
     */
    public String calculateMofId( ClassDescriptor<?, ?> superClassDescriptor, String... logicalKey );
}
