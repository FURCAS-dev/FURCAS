package com.sap.tc.moin.repository.test.jmigenerator.tool;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.sap.tc.moin.repository.core.CoreConnection;

/**
 *
 */
public class MoinMetamodelGeneration extends JPanel {

    private static final long serialVersionUID = 8587966081841175395L;

    private GenerationPanel generationPanel;

    public void setConnection( CoreConnection connection ) {

        this.generationPanel.setConnection( connection );

    }

    public void setRootFolder( String rootFolder ) {

        this.generationPanel.setRootFolder( rootFolder );
    }

    public void setMetamodelInfos( String[] containerNames ) {

        MetamodelTableModel metamodelTableModel = new MetamodelTableModel( );
        String[] targetPaths = getTargetPaths( containerNames );
        metamodelTableModel.setMetamodelContainerNames( containerNames, targetPaths );
        this.generationPanel.getTable( ).setModel( metamodelTableModel );
    }

    private String[] getTargetPaths( String[] containerNames ) {

        String[] result = new String[containerNames.length];
        int i = 0;
        for ( String containerName : containerNames ) {
            result[i] = generationPanel.getGenerator( ).getTargetSourcePath( containerName );
            i++;
        }

        return result;
    }

    public MoinMetamodelGeneration( String rootFolder ) {

        super( new GridLayout( 0, 1 ) );
        try {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName( ) );
        } catch ( Exception ex ) {
            throw new RuntimeException( ex );
        }
        this.generationPanel = new GenerationPanel( new MetamodelGeneratorTool( rootFolder ) );
        ToolTipManager.sharedInstance( ).setDismissDelay( 10000 );
        final JTabbedPane tabbedPane = new JTabbedPane( SwingConstants.TOP );
        add( tabbedPane, BorderLayout.CENTER );
        tabbedPane.addTab( "Metamodel Generation", null, generationPanel, "Generate metamodel interfaces, classes, wrappers" );
    }

    public MoinMetamodelGeneration( String[] metamodelContainerNames, String rootFolder ) {

        this( rootFolder );
        if ( metamodelContainerNames != null ) {
            MetamodelTableModel metamodelTableModel = new MetamodelTableModel( );
            metamodelTableModel.setMetamodelContainerNames( metamodelContainerNames, getTargetPaths( metamodelContainerNames ) );
            this.generationPanel.getMetamodelsAreaTable( ).setModel( metamodelTableModel );

        }
    }

    public GenerationPanel getGenerationPanel( ) {

        return this.generationPanel;
    }

    static Thread setup( final MoinMetamodelGeneration metamodelGenerationPanel ) {

        JFrame frame = new JFrame( "Metamodel JMI generation" );
        JComponent contentPane = (JComponent) frame.getContentPane( );
        contentPane.add( metamodelGenerationPanel, BorderLayout.CENTER );
        contentPane.setOpaque( true ); // content panes must be opaque
        contentPane.setBorder( new EmptyBorder( 12, 12, 12, 12 ) );
        metamodelGenerationPanel.setOpaque( true );
        frame.setContentPane( metamodelGenerationPanel );
        frame.addWindowListener( new ExitListener( metamodelGenerationPanel ) );
        frame.pack( );
        frame.setVisible( true );
        return Thread.currentThread( );
    }

    public static Thread runAsync( final MoinMetamodelGeneration metamodelGenerationPanel ) throws InterruptedException, InvocationTargetException {

        MyThreadAwareRunnable runnable = new MyThreadAwareRunnable( metamodelGenerationPanel );
        SwingUtilities.invokeAndWait( runnable );
        return runnable.getThread( );

    }

    public static void run( final MoinMetamodelGeneration metamodelGeneration ) {

        setup( metamodelGeneration );
    }

    private static final class MyThreadAwareRunnable implements Runnable {

        Thread thread;

        MoinMetamodelGeneration generation;

        public MyThreadAwareRunnable( MoinMetamodelGeneration generation ) {

            this.generation = generation;

        }

        public void run( ) {

            thread = setup( this.generation );
        }

        public Thread getThread( ) {

            return thread;
        }

    }

}