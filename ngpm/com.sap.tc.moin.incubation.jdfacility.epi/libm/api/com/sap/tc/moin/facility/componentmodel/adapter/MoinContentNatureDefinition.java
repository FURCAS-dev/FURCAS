/**
 * 
 */
package com.sap.tc.moin.facility.componentmodel.adapter;

import java.util.Collections;
import java.util.Set;

public class MoinContentNatureDefinition {

    public MoinContentNatureDefinition( String natureName, String eclipseNature, Set<CMFSFolder> folderDef, Set<String> dependantPlugins ) {

        this.natureName = natureName;
        this.eclipseNature = eclipseNature;
        this.folderDef = folderDef != null ? folderDef : Collections.<CMFSFolder> emptySet( );
        this.dependantPluginIDs = dependantPlugins != null ? dependantPlugins : Collections.<String> emptySet( );
    }

    public final String natureName;

    public final String eclipseNature;

    public final Set<CMFSFolder> folderDef;

    public final Set<String> dependantPluginIDs;
}