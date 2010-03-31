package com.sap.tc.moin.repository.test.jmigenerator.tool;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ExitListener extends WindowAdapter implements WindowListener {

    private final MoinMetamodelGeneration generationPanel;

    public ExitListener( MoinMetamodelGeneration generationPanel ) {

        this.generationPanel = generationPanel;
    }

    public void windowClosing( WindowEvent event ) {

        //generationPanel.shutDown();
        System.exit( 0 );
    }
}
