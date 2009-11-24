/**
 * 
 */
package com.sap.mi.textual.moin.standalone;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.sap.tc.moin.facility.primary.build.BuildPrimaryFacilityImpl;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationAdaptorFactoryImpl;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider.Scenario;
import com.sap.tc.moin.facility.primary.ipi.diservice.build.IpiBuildDiService;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.runtimehost.build.MoinFactory;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;


/**
 * Util class to get a moin connection without MOIN in Eclipse.
 */
public class StandaloneConnectionFactory {

    private static final String DEFAULT_DATA_AREA_NAME = "DefaultDataArea";
    private static final String DEFAULT_VENDOR_NAME = "sap.com";
    private static final String DEFAULT_PARTITION_NAME ="PF";
    
    private static Moin moinInstance; 

   static Connection getConnection(StandaloneArgumentsBean optionsBean) {
       
       Moin moin = getMoinInstance(optionsBean);
       
       Facility facility = moin.getFacilityById( DEFAULT_PARTITION_NAME );
       IpiBuildDiService nwdiService = ( (BuildPrimaryFacilityImpl) facility ).getBuildDiService( );

       
       IpiDiConfigurationProvider configurationProvider = StandaloneConnectionFactory.getDiConfigurationProvider( optionsBean );
       
       ClientSpec clientSpec = nwdiService.getClientSpec( configurationProvider );

       CompoundClientSpec compoundClientSpec = null;
       
       try {
           compoundClientSpec = ( (SpiCompoundDataAreaManager) moin.getCompoundDataAreaManager( ) ).getDefaultCompoundClientSpec( clientSpec );
       } catch ( Exception ex ) {
           throw new RuntimeException( "Could not create Client Spec: ", ex );
       }
       
       Connection conn = moin.createSession(compoundClientSpec).createConnection();
       return conn;
   }
    
    /**
     * @param optionsBean
     * @return
     */
   private static IpiDiConfigurationProvider getDiConfigurationProvider(StandaloneArgumentsBean optionsBean) {
        String dcName = optionsBean.getDcName();

        return getDiProvider( new File( optionsBean.getSourcePath() ), optionsBean.getMetamodelJars(), DEFAULT_VENDOR_NAME, dcName );
    }

 

    
    private static IpiDiConfigurationProvider getDiProvider(File sourcePath, String[] modelsRequiredPath, String vendor,
            String dc) {
            IpiDiDcDefinitionProvider dcDefinitionProvider = null;

            if (sourcePath == null) {
                throw new RuntimeException("Source path has not been specified.");
            }

            IpiDiConfigurationAdaptorFactoryImpl diAdaptorFactory = new IpiDiConfigurationAdaptorFactoryImpl();

            dcDefinitionProvider = diAdaptorFactory.getMetaModelDiDcDefinitionAdaptor(vendor, dc, sourcePath.getAbsolutePath());

            List<IpiDiDcDefinitionProvider> definitionProviders = new LinkedList<IpiDiDcDefinitionProvider>();

            definitionProviders.add(dcDefinitionProvider);

            ZipFile zip = null;

            try {
                if (modelsRequiredPath != null) {
                    for (String path : modelsRequiredPath) {
                        zip = new ZipFile(path);
                        if (isMetamodelArchive(zip)) {
                            _DcDataRecord dr = readDcDataRecord(zip);

                            dcDefinitionProvider = diAdaptorFactory.getMetaModelDiDcDefinitionAdaptor(dr.dcVendor,
                                dr.dcName, Collections.singletonList(path));

                            definitionProviders.add(dcDefinitionProvider);
                        }
                        zip.close();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (zip != null) {
                    try {
                        zip.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            IpiDiConfigurationProvider diConfigurationProvider = diAdaptorFactory.getMetaModelDiConfigurationAdaptor(
                Scenario.BUILD_SCENARIO, DEFAULT_DATA_AREA_NAME, definitionProviders);

            return diConfigurationProvider;

        }
    
    private static boolean isMetamodelArchive(ZipFile archive) {
        Enumeration<? extends ZipEntry> entries = archive.entries();
        if (entries == null) {
            return false;
        }
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            if (entry.getName().equals("moin/meta/")) {
                return true;
            }
        }
        return false;
    }
    
    private static _DcDataRecord readDcDataRecord( ZipFile zip ) {

        _DcDataRecord ret = new _DcDataRecord( );

        try {
            ZipEntry entry = zip.getEntry( "metamodel.properties" );

            if ( entry == null ) {
                throw new RuntimeException( "metamodel.properties has not been found in " + zip.getName( ) + "." );
            }

            InputStream is = zip.getInputStream( entry );
            Properties props = new Properties( );
            props.load( is );

            ret.dcName = props.getProperty( "metamodelId" );

            if ( ret.dcName == null ) {
                throw new RuntimeException( "Meta-model id has not been defined in " + zip.getName( ) );
            }

            ret.dcVendor = props.getProperty( "vendor" );

            if ( ret.dcVendor == null ) {
                throw new RuntimeException( "Meta-model vendor has not been defined in " + zip.getName( ) );
            }

            return ret;
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }

    private static class _DcDataRecord {

        public String dcName;

        public String dcVendor;
    }

    /**
     * @param optionsBean
     * @return
     */
     static Moin getMoinInstance(StandaloneArgumentsBean optionsBean) {
         if (moinInstance == null) {
             try {
                 Moin moin = MoinFactory.getMoinInstance( optionsBean.getMetamodelJars());    
                 moinInstance = moin;
             } catch (RuntimeException e) { // would get swallowed else in Unit Tests
                 e.printStackTrace();
                 System.err.println("Exceptions here are likely to be caused by inconsistent versions of metamodel / metamodel jar in the standalone project");
                 throw e;
             }
             
         }
         return moinInstance;
    }
    

    

    
//  /**
//   * From the given .properties file determines the DC name from the first entry that
//   * holds a model partition to be imported (one with "true" at the end of the line). If
//   * no such line is found in the properties file, <tt>null</tt> is returned.
//   */
//  private static String findDcNameInPropertiesFile(File propertiesFile)
//          throws FileNotFoundException, IOException {
//      String result = null;
//      Pattern p = Pattern
//              .compile(".*\\.xml *= *(.*):DCs/sap.com/(.*)/_comp/.* *, *true$");
//      BufferedReader r = new BufferedReader(
//              new FileReader(propertiesFile));
//      String line = r.readLine();
//      while (line != null && result == null) {
//          Matcher matcher = p.matcher(line);
//          if (matcher.matches()) {
//              result = matcher.group(2);
//          }
//          line = r.readLine();
//      }
//      r.close();
//      return result;
//  }
  
//private static File getPropertiesFile(String[] args) throws IOException {
//File propertiesFile = null;
//String metamodelProject = getMetamodelProject(getProject(args));
//if (metamodelProject != null) {
//    File mmrMeta = new File(metamodelProject, "mmr/meta");
//    File[] propertyFiles = mmrMeta.listFiles(new FileFilter() {
//        public boolean accept(File pathname) {
//            return pathname.getName().endsWith(".properties");
//        }
//    });
//    if (propertyFiles != null && propertyFiles.length > 0) {
//        propertiesFile = propertyFiles[0];
//    } else {
//        throw new RuntimeException("Properties File not found for project " + metamodelProject);
//    }
//    return propertiesFile;
//} else {
//    throw new RuntimeException("Could not find metamodel project.");
//}    
//}   
    
}
