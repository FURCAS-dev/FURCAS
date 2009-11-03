package com.sap.tc.moin.friends;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;

import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;

/**
 * MoinUtil is an interface that provides extended functionality around the Moin
 * repository.
 */
public interface MoinUtil {

    /**
     * Checks if the given String starts with the prefix which is used for
     * {@link RefClassCalculatedMofId calculated MOF ids}. Note: it does NOT
     * check if the given String is a valid MOF id.
     * 
     * @param mofId the MOF id to check if it is a calculated one.
     * @return <code>true</code> if the given String starts with the prefix
     * which is used for {@link RefClassCalculatedMofId calculated MOF ids},
     * <code>false</code> otherwise.
     * @throws NullPointerException thrown if the given String is null.
     */
    public boolean isCalculatedMofId( String mofId );

    /**
     * Retrieves a ClassDescriptor for a given MofClass
     * 
     * @param mofClass the MofClass for which the ClassDescriptor shall be
     * retrieved
     * @return the retrieved ClassDescriptor
     */
    public ClassDescriptor<?, ?> getClassDescriptor( MofClass mofClass );

    /**
     * This method returns the name of the generated JMI interface for the given
     * namespace after applying the JMI mangling rules.
     * <p>
     * Example: Class <code>class_1</code> in package <code>com.sap</code>.
     * <p>
     * The generated JMI interface will be <code>com.sap.Class1</code>.
     * 
     * @param namespace the namespace for which the JMI interface name should be
     * returned
     * @return the JMI interface name
     */
    public String getJmiInterfaceName( Namespace namespace );

    /**
     * This method returns the name of the generated package for the given
     * package after applying the JMI mangling rules.
     * <p>
     * Example: Package <code>PACKage_1</code> in package <code>com.sap</code>.
     * <p>
     * The generated package will be <code>com.sap.package1</code>.
     * 
     * @param mofPackage the package for which the name should be returned
     * @return the generated name of the package
     */
    public String getJmiPackageName( MofPackage mofPackage );
}
