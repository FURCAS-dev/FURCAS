/*
 * Created on 02.02.2006
 */
package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.spi.core.serialization.SpiPartitionReader;

/**
 * The ExtentManager provides information to create extents
 * <p>
 * This interface is not intended to be implemented by service providers. The
 * implementation will be provided by the MOIN Core.
 * 
 * @author d024227
 */
public interface ExtentManager {

    /**
     * 
     */
    public RefPackage[] getTopLevelPackageExtents( );

    /**
     * Searches for MOF packages with the specified qualified name and returns
     * the according default package extents for it.
     * 
     * @param qualifiedName The qualified name of the to be searched MOF package
     * @return The found default package extents or an empty array, if nothing
     * has been found
     */
    public RefPackage[] selectRefPackages( String[] qualifiedName );

    /**
     * Searches for MOF packages with the specified qualified name and returns
     * the according default package extents for it. Only those MOF packages are
     * considered, which are hosted in either of the specified model containers.
     * The model containers are specified by their names.<br>
     * The modelContainerNames String array either null or empty means that no
     * model container restriction is applied.
     * 
     * @param qualifiedName The qualified name of the to be searched MOF package
     * @param modelContainerNames The names of the model containers, in one of
     * which the MOF packages are searched
     * @return The found default package extents or an empty array, if nothing
     * has been found
     */
    public RefPackage[] selectRefPackages( String[] qualifiedName, String[] modelContainerNames );

    /**
     * Searches for MOF metamodel elements with the specified qualified name and
     * returns the according default MOF extents for it.
     * 
     * @param qualifiedName The qualified name of the to be searched MOF
     * metamodel element
     * @return The found default MOF extent or an empty array, if nothing has
     * been found
     */
    public Extent[] selectExtents( String[] qualifiedName );

    /**
     * Searches for MOF metamodel elements with the specified qualified name.
     * <br>
     * 
     * @param qualifiedName The qualified name of the to be searched MOF
     * metamodel elements
     * @return The found ModelElements or null, if nothing has been found
     */
    public ModelElement[] selectModelElements( CoreSession session, String[] qualifiedName );

    /**
     * Searches for MOF metamodel elements with the specified qualified name.
     * Only those MOF metamodel elements are considered, which are hosted in
     * either of the specified model containers. The model containers are
     * specified by their names.<br>
     * The modelContainerNames String array either null or empty means that no
     * model container restriction is applied.
     * 
     * @param qualifiedName The qualified name of the to be searched MOF
     * metamodel elements
     * @param modelContainerNames The names of the model containers, in one of
     * which the MOF metamodel elements are searched
     * @return The found ModelElements or null, if nothing has been found
     */
    public ModelElement[] selectModelElements( CoreSession session, String[] qualifiedName, String[] modelContainerNames );

    /**
     * This method may be called by the {@link SpiPartitionReader} only!!!
     * <p>
     * For efficiency reasons, the qualified name is not given as a string
     * array, but as a dot-separated string, as it is found in the partition
     * file. This string is only split if no extent can be found for the given
     * MOF-ID.
     * <p>
     * The {@link SpiPartitionReader} never requests package extents. Therefore,
     * no call to
     * {@link #replaceProxyWithRealElement(CoreConnection, Extent)} is ever
     * made for performance reasons (which would be required for package
     * extents).
     */
    public Extent selectExtentForPartitionReader( String mofIdOfMetaObject, String dotSeparatedQualifiedName, String modelContainerName );

    public Extent selectExtent( String mofIdOfMetaObject, String[] qualifiedName, String modelContainerName );

    /**
     * 
     */
    public RefBaseObject getDefaultExtentForMetaObject( GeneralizableElement metaObject );

    /**
     * @param metaObjectMofId
     * @return mofId of extent
     */
    public String convertToExtentMofId( String metaObjectMofId );

    /**
     * @param extentMofId
     * @return mofId of metamodel-modelelement
     */
    public String convertToMetamodelElementMofId( String extentMofId );

    /**
     * Adds an extent to the Map of extents which are keyed by their metaObjects
     * MOF id. If this Extent already exists a RuntimeException is thrown,
     * because it has previously to be checked, if such an Extent already exists
     * and if so, it has to be reused
     */
    public void addExtent( Extent extent );



    public Extent getExtent( MRI mriOfExtentsMetaObject );

    public boolean isExtentMofId( String mofId );

    public Extent createExtent( RefPackage myRefPackage, RefObject refMetaObject );
}
