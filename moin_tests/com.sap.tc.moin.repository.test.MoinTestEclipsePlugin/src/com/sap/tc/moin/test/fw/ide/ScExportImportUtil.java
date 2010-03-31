package com.sap.tc.moin.test.fw.ide;

import java.io.File;
import java.util.Set;

import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;
import com.sap.ide.dii05.model.api.ISoftwareComponent;


@SuppressWarnings( "nls" )
public interface ScExportImportUtil {

    boolean executeExportOfScWithArchivesOnly( ISoftwareComponent sc, File destinationFolder ) throws Exception;

    Set<ISoftwareComponent> executeImportOfSc( File scaFile, IDevelopmentConfiguration destinationDevConfig ) throws Exception;

}
