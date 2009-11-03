package com.sap.tc.moin.repository.ide.metamodels;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.osgi.framework.Bundle;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.metamodels.MetaModelInfo;
import com.sap.tc.moin.repository.metamodels.MetaModelVersion;

/**
 * @author d029324
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface MmDeploymentInfo extends MetaModelInfo {

    /**
     * Returns the descriptive name of MOIN metamodel.
     * <p>
     * The metamodel description is defined in metamodel definition (see MOIN
     * metamodel Eclipse plug-in definition).
     * 
     * @return descriptive name of the MOIN metamodel.
     */
    public String getLabel( );

    /**
     * Return the name of configured MOIN facility.
     * <p>
     * The metamodel facility name is defined in MOIN metamodel description file
     * (see MOIN metamodel.properties file which is included into Eclipse
     * plug-in definition).
     * 
     * @return the name of configured MOIN facility.
     */
    public String getFacilityName( );

    /**
     * Returns the version of currently available MOIN metamodel.
     * <p>
     * The MOIN metamodel version is provided in MOIN metamodel description file
     * (see MOIN metamodel.properties file which is included into Eclipse
     * plug-in definition).
     * 
     * @return the version of currently available MOIN metamodel.
     */
    public MetaModelVersion getMetaModelPluginVersion( );

    /**
     * Returns the MOIN metamodel's bundle - the Eclipse plug-in that contains
     * the MOIN metamodel.
     * 
     * @return the MOIN metamodel's bundle.
     */
    public Bundle getBundle( );

    /**
     * Returns the bundle ID where the MOIN metamodel is located.
     * 
     * @return the bundle ID where the MOIN metamodel is located.
     * @see #getBundleName()
     */
    public String getBundleId( );

    /**
     * Returns the descriptive name of the MOIN metamodel's bundle (the Eclipse
     * plug-in that contains the MOIN metamodel).
     * 
     * @return the descriptive name of the MOIN metamodel's bundle.
     * @see #getBundleId()
     */
    public String getBundleName( );

    /**
     * Returns the path to archive containing the main XMI file.
     * <p>
     * Is <code>null</code> in case both XMI and properties file are not
     * packaged in an archive.
     * 
     * @return the path to archive containing the main XMI file.
     * @deprecated The {@link #getXmiArchivePath()} was used for deployment of
     * the "old" (not more supported) MOIN metamodels.
     */
    @Deprecated
    public String getXmiArchivePath( );

    /**
     * Returns the status of MOIN metamodel.
     * <p>
     * The supported status are defined by MmDeploymentStatus class:
     * <p>
     * - DEPLOYED, - NOT_DEPLOYED, - VERSION_DIFFER, - ERROR_NOT_DEPLOYABLE, -
     * UNKNOWN.
     * 
     * @return the status of MOIN metamodel.
     */
    public MmDeploymentStatus getStatus( );

    /**
     * Returns the last reported error message, if problem with metamodel
     * detected. Otherwise returns null.
     * 
     * @return the last reported error message.
     */
    public String getLastReportedErrorMessage( );

    /**
     * Returns collection of partitions that are defined in the MOIN metamodel.
     * 
     * @return Collection of partitions.
     * @throws IOException thrown if the some partition is not available.
     */
    public Collection<PRI> getPRIs( ) throws IOException;

    /**
     * Returns a stream to the particular MOIN metamodel partition.
     * 
     * @param pri partition identifier.
     * @return stream to the particular MOIN metamodel partition.
     * @throws IOException thrown if the partition is not available.
     * @deprecated
     */
    @Deprecated
    public InputStream getPartitionStream( PRI pri ) throws IOException;

    /**
     * Returns the last exception.
     * 
     * @return
     */
    public Exception getLastReportedException( );

    /**
     * Returns the list and the content of the registration files.
     * 
     * @return
     */
    public Collection<String> getDeployedRegistrationFiles( );

    /**
     * Returns the content of a registration file as string.
     * 
     * @param resourceName
     * @return
     * @throws IOException
     */
    public String getRegistrationFileContent( String resourceName ) throws IOException;

}
