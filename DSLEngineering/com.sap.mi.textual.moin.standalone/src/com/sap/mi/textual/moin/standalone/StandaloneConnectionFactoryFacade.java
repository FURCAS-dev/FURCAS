/**
 * 
 */
package com.sap.mi.textual.moin.standalone;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Moin;

/**
 * provides public point of access and parameter validation / completion for the connection factory.
 */
public class StandaloneConnectionFactoryFacade {

    /**
     * util method providing dummy values for dcname and sourcepath, 
     * as these do not seem to be required for using connections without saving.
     * @param jarpath
     * @return
     */
    public static Connection getMetaModelConnection(String jarpath) {
        return getMetaModelConnection(new String[]{jarpath});
    }
    
    /**
     * util method providing dummy values for dcname and sourcepath, 
     * as these do not seem to be required for using connections without saving.
     * @param jarpath
     * @return
     */
    public static Connection getMetaModelConnection(String[] jarpaths) {
        StandaloneArgumentsBean optionsBean = new StandaloneArgumentsBean();
        optionsBean.setDcName("helloWorld");
        optionsBean.setSourcePath("helloWorld2");
        
        optionsBean.setMetamodelJars(jarpaths);
        checkBean(optionsBean);
        return StandaloneConnectionFactory.getConnection(optionsBean );
    }
    
    public static Connection getConnection(StandaloneArgumentsBean optionsBean) {
        checkBean(optionsBean);
        return StandaloneConnectionFactory.getConnection(optionsBean );
    }

    /**
     * @param optionsBean
     */
    private static void checkBean(StandaloneArgumentsBean optionsBean) {
        if (optionsBean == null) {
            throw new IllegalArgumentException("Options bean must not be null");
        }
        if (optionsBean.getDcName() == null) {
            throw new IllegalArgumentException("DCName must not be null");
        }
//        if (optionsBean.getSourcePath() == null) {
//            throw new IllegalArgumentException();
//        }
//        if (optionsBean == null) {
//            throw new IllegalArgumentException();
//        }
//        if (optionsBean == null) {
//            throw new IllegalArgumentException();
//        }
    }

    /**
     * @param jarpath
     */
    public static Moin getMoin(String jarpath) {
        return getMoin(new String[]{jarpath});
    }
    
    /**
     * @param jarpath
     */
    public static Moin getMoin(String[] jarpaths) {
        StandaloneArgumentsBean optionsBean = new StandaloneArgumentsBean();
        optionsBean.setDcName("helloWorld");
        optionsBean.setSourcePath("helloWorld2");
        
        optionsBean.setMetamodelJars(jarpaths);
        checkBean(optionsBean);
        return StandaloneConnectionFactory.getMoinInstance( optionsBean);
    }
    
//    /**
//     * Access to MOIN connection passing command line arguments 
//     * @param args
//     * @return
//     * @deprecated use method with bean parameter instead
//     */
//    @Deprecated
//    public static Connection getConnection(String[] args) {
//        // this method only exists for historic reasons
//        StandaloneArgumentsBean optionsBean = new StandaloneArgumentsBean();
//        optionsBean.setDcName(getDcName(args));
//        optionsBean.setMetamodelJars(getMetaModelJars(args));
//        optionsBean.setSourcePath(getSourcePath(args));
//        
//        return getConnection(optionsBean);
//    }
    

    
    
//    protected static String[] getMetaModelJars( String[] args ) {
//        String argumentValue = MoinArgumentsToolkit.getArgumentValue( "-metaModelJars", args, "-metaModelJars argument has to provide a semicolon separated list of meta-model pathes.", false );
//        return argumentValue == null ? null : argumentValue.split( ";" );
//    }
    
//    protected static String getDcName(String[] args) {
//        
//                try {
//            File propertiesFile = getPropertiesFile(args);
//            
//            String dcName = findDcNameInPropertiesFile(propertiesFile);
//            return dcName;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    
//    protected static String getSourcePath(String[] args) {
//        String projectPath = getProject(args);
//        String metamodelProject;
//        try {
//            metamodelProject = getMetamodelProject(projectPath);
//            return metamodelProject;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
////        return MoinArgumentsToolkit.getArgumentValue("-sourcePath", args, "-sourcePath has to provide the path to the source of the model component.");
//    }
    
//    private static String getProject(String[] args) {
//        String projectPath = MoinArgumentsToolkit
//                .getArgumentValue(
//                        "-project",
//                        args,
//                        "-project tells the absolute path to the Eclipse metamodel plugin project. Use ${resource_loc} to make it portable.");
//        return projectPath;
//    }
    
//    private static String getMetamodelProject(String projectPath) throws IOException {
//        return "C:\\japro\\moin_dev\\local\\moin.test\\CoreDev_stream\\src\\_com.sap.demo.tcsmeta.mm.eclipse";
//        File subprojectSrcDir = new File(projectPath).getParentFile();
//        if (subprojectSrcDir == null || ! subprojectSrcDir.exists()) {
//            throw new RuntimeException("SubProjectDir at " + projectPath + " does not exist.");
//        }
//        File importList = new File(new File(subprojectSrcDir, "cfg"),
//                "import.lst");
//        String metamodelProject = null;
//        if (importList.exists()) {
//            String subprojectName = null;
//            BufferedReader r = new BufferedReader(new FileReader(importList));
//            String line = r.readLine();
//            while (line != null) {
//                if (line.lastIndexOf(':') >= 0) {
//                    subprojectName = line.substring(line.lastIndexOf(':') + 2);
//                }
//                line = r.readLine();
//            }
//            r.close();
//            if (subprojectName != null) {
//                metamodelProject = new File(subprojectSrcDir.getParentFile(),
//                        subprojectName).getPath();
//            }
//        } else {
//            throw new RuntimeException("Import.lst does not exist.");
//        }
//        
//        if (metamodelProject == null && projectPath.endsWith(".epi")) {
//            // try to guess metamodel project name by removing ".epi" suffix
//            metamodelProject = projectPath.substring(0, projectPath.length()
//                    - ".epi".length());
//        }
//        return metamodelProject;
//    }

}
