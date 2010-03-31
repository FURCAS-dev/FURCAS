package com.sap.tc.moin.repository.test.jmitck.vendorwrapper;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.modelsem.Util;

/**
 * General capabilities that might be useful to anyone implementing the
 * Generator Interface.
 */
@SuppressWarnings( "nls" )
public class GeneratorHelper {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, GeneratorHelper.class );

    protected Properties properties;

    protected File rootDir;

    public GeneratorHelper( Properties p, File rootDir ) {

        this.properties = p;
        this.rootDir = rootDir;
    }

    public File getMetamodelXmiFile( String metamodel ) {

        String path = "metamodels/" + metamodel.replace( '.', '/' ) + ".xml";
        return new File( rootDir, path );
    }

    public MofPackage getMetamodelPackage( RefPackage modelPkg, String metamodel ) {

        String mofPackageName = Util.simpleNameOf( metamodel );
        log.trace( MoinSeverity.DEBUG, "RI-specific: looking for MofPackage instance named " + mofPackageName + " which defines the metamodel " + metamodel );
        MofPackage mp = null;

        RefClass rc = modelPkg.refClass( "Model.Package" );
        Collection<RefObject> instances = rc.refAllOfClass( );
        for ( Iterator<RefObject> i = instances.iterator( ); i.hasNext( ); ) {
            MofPackage mpkg = (MofPackage) i.next( );
            if ( mpkg.getName( ).equals( mofPackageName ) ) {
                mp = mpkg;
                break;
            }
        }
        return mp;
    }

    //    public MofPackage getMetamodelPackage(RefPackage modelPkg, String metamodel) {
    //       log.debug("RI-specific: looking for MofPackage instance named " 
    //              + metamodel + " which defines the metamodel");
    //       MofPackage mp = null;
    //       String segment = null;
    //       List nameSegments = new ArrayList();
    //       StringTokenizer st = new StringTokenizer(metamodel, ".");
    //       while (st.hasMoreTokens()) {
    //       nameSegments.add(st.nextToken());
    //       }

    //       segment = (String) nameSegments.get(0);

    //       RefClass rc = modelPkg.refClass("Model.Package");
    //       boolean segmentMatch = true;
    //       Collection instances = rc.refAllOfClass();
    //       for (Iterator i = instances.iterator(); i.hasNext();) {
    //       MofPackage mpkg = (MofPackage) i.next();
    //       if ( mpkg.getName().equals(segment)) {
    //          mp = mpkg;
    //          break;
    //       }
    //       }
    //       if ((mp != null) && (nameSegments.size() > 1)) {
    //       for (int i = 1; i < nameSegments.size(); i++) {
    //          segment = (String) nameSegments.get(i);
    //          try {
    //             mp = (MofPackage) mp.lookupElementExtended(segment);
    //          } catch (NameNotFoundException nnfe) {
    //             log.error("", nnfe);
    //             throw new TestErrorException("Could not find MofPackage " +
    //                                          metamodel + " from XMI import; " +
    //                                          "name segment number " + i+1 +
    //                                          " \"" + segment +
    //                                          " could not be located");
    //          } catch (ClassCastException cce) {
    //             log.error("", cce);
    //             throw new TestErrorException("Element named " + segment + 
    //                                          " in MofPackage " +
    //                                          Util.dotNotation(mp.getQualifiedName()) +
    //                                          " was not a MofPackage instance; " +
    //                                          "when looking for " + metamodel);
    //          }
    //       }
    //       }
    //       return mp;
    //    }
}
