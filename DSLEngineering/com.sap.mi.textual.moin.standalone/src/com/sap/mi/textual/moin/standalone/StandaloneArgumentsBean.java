/**
 * 
 */
package com.sap.mi.textual.moin.standalone;

import java.util.Arrays;

/**
 *
 */
public class StandaloneArgumentsBean {

    private String[] metamodelJars;
    private String dcName;
    private String sourcePath;
    
    
    /**
     * should be the DC name, but tests work with any non-null String, really.
     * @param dcName the dcName to set
     */
    public void setDcName(String dcName) {
        this.dcName = dcName;
    }

    /**
     * a jar as built using the MOF Editor. Right click on Metamodel project, select build, find jar in
     *  &lt;EclipesWorkspaceName&gt;.jdi\LocalDevelopment\DCs\demo.sap.com\foo\_comp\gen\default\public\def_assmbl\lib\moin
     *  (can also be built by JaPro)
     * @param metamodelJars the metamodelJars to set
     */
    public void setMetamodelJars(String[] metamodelJars) {
        this.metamodelJars = metamodelJars;
    }

    /**
     * e.g.C:\\japro\\moin_dev\\local\\moin.test\\CoreDev_stream\\src\\_com.sap.demo.tcsmeta.mm.eclipse
     * @param sourcePath the sourcePath to set
     */
    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }
    
    
    /**
     * @return the dcName
     */
    public String getDcName() {
        return dcName;
    }

    /**
     * @return the metamodelJars
     */
    public String[] getMetamodelJars() {
        return metamodelJars;
    }

    /**
     * @return the sourcePath
     */
    public String getSourcePath() {
        return sourcePath;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DCName: '" + getDcName() + "', sourcePath: '"+getSourcePath()+"' + metamodeljars: " + Arrays.toString(getMetamodelJars());
    }

    
    
}
