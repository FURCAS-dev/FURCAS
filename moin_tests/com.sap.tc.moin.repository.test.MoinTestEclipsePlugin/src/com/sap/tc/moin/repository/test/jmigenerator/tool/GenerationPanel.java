package com.sap.tc.moin.repository.test.jmigenerator.tool;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sun.security.action.GetPropertyAction;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.test.fw.TestMetaModels;

public class GenerationPanel extends JPanel {

    private static final long serialVersionUID = 2385759951886405639L;

    private static String CODE_LINE = System.getProperty( "com.sap.tc.moin.codeline" );

    private static final String KEY_MOIN_PERFORCE_ROOT = "perforceRoot";

    private static final String KEY_TARGET_PLATFORM = "targetPlatform";

    private static final String WEB_DYNPRO_CONTAINER_NAME = "sap.com/tc/moin/webdynpro/webdynpro";

    JFileChooser directoryChooser = new JFileChooser( );

    File moinPerforceRoot;

    File targetPlatform;

    MetamodelGeneratorTool generator;

    CoreConnection connection;

    String rootFolder;

    JTable table;

    private JCheckBox interfacesSwitch;

    private JCheckBox classesSwitch;

    private JCheckBox wrapperSwitch;

    private static File tmpdir;

    private static String generatorPreferencesFile = "moinGenerator.pref";

    private static String relativePathToMofApi = "moin" + File.separator + "moin.api" + File.separator + CODE_LINE + File.separator + "src" + File.separator + "_tc~moin~repository~api" + File.separator + "libm" + File.separator + "api";

    private static String relativePathToMofImpl = "moin" + File.separator + "moin.jmicore" + File.separator + CODE_LINE + File.separator + "src" + File.separator + "_tc~moin~repository~jmi~impl" + File.separator + "libm" + File.separator + "api";

    static {
        GetPropertyAction a = new GetPropertyAction( "java.io.tmpdir" );
        String path = (String) AccessController.doPrivileged( a );
        tmpdir = new File( path );
    }

    public GenerationPanel( MetamodelGeneratorTool generator ) {

        super( new GridBagLayout( ) );
        this.generator = generator;
        directoryChooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
        setupUI( );

    }

    public void setRootFolder( String rootFolder ) {

        this.rootFolder = rootFolder;
    }

    public String getRootFolder( ) {

        return this.rootFolder;
    }

    private void setupUI( ) {

        GridBagConstraints c = new GridBagConstraints( );

        JComponent generationKindArea = createGenerationKindArea( );
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 0.0;
        add( generationKindArea, c );

        JComponent metamodelsArea = createMetamodelsArea( );
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add( metamodelsArea, c );

        JComponent buttonArea = createButtonArea( );
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0.0;
        c.weighty = 0.0;
        add( buttonArea, c );
    }

    private JComponent createGenerationKindArea( ) {

        JPanel generationKindPanel = new JPanel( new GridBagLayout( ) );
        generationKindPanel.setBorder( BorderFactory.createTitledBorder( "Choose Generation kind" ) );
        GridBagConstraints c = new GridBagConstraints( );
        {
            interfacesSwitch = new JCheckBox( "Interfaces" );
            interfacesSwitch.setToolTipText( "Generates the interfaces for the metamodels" );
            interfacesSwitch.setSelected( true );
            c.gridx = 0;
            c.gridy = 0;
            c.weightx = 1.0;
            generationKindPanel.add( interfacesSwitch, c );
        }
        {
            classesSwitch = new JCheckBox( "Classes" );
            classesSwitch.setToolTipText( "Generates the implementation classes for the metamodels" );
            classesSwitch.setSelected( true );
            c.gridx = 2;
            c.gridy = 0;
            c.weightx = 1.0;
            generationKindPanel.add( classesSwitch, c );
            generationKindPanel.add( classesSwitch, c );
        }
        {
            wrapperSwitch = new JCheckBox( "Wrappers" );
            wrapperSwitch.setToolTipText( "Generates the wrappers for the metamodels" );
            wrapperSwitch.setSelected( true );
            c.gridx = 3;
            c.gridy = 0;
            c.weightx = 1.0;
            generationKindPanel.add( wrapperSwitch, c );
            generationKindPanel.add( wrapperSwitch, c );
        }

        return generationKindPanel;
    }

    private JComponent createMetamodelsArea( ) {

        final MetamodelTableModel tableModel = new MetamodelTableModel( );
        table = new JTable( tableModel );
        table.getTableHeader( ).setReorderingAllowed( false );

        table.addMouseListener( new MouseAdapter( ) {

            @Override
            public void mouseClicked( MouseEvent e ) {

                if ( e.getClickCount( ) == 2 ) {
                    Point p = e.getPoint( );
                    int row = table.rowAtPoint( p );
                    int column = table.columnAtPoint( p );
                    if ( column == tableModel.getGenerationPathColumn( ) ) {
                        String path = (String) table.getValueAt( row, column );
                        try {
                            Runtime.getRuntime( ).exec( "explorer.exe " + path );
                        } catch ( IOException e1 ) {
                            JOptionPane.showMessageDialog( GenerationPanel.this, e1 );
                        }
                    }

                }
            }
        } );

        table.setPreferredScrollableViewportSize( new Dimension( 800, 400 ) );
        // table.getColumnModel().getColumn(0).setWidth(5);
        //        table.getColumnModel().getColumn(5).setMaxWidth(50);
        table.setCellSelectionEnabled( true );
        JScrollPane scrollPane = new JScrollPane( table );
        scrollPane.setBorder( BorderFactory.createTitledBorder( "Metamodels" ) );
        return scrollPane;
    }

    private JComponent createButtonArea( ) {

        JPanel buttons = new JPanel( new FlowLayout( ) );

        JButton selectAll = new JButton( "Select all" );
        selectAll.addActionListener( new ActionListener( ) {

            public void actionPerformed( ActionEvent e ) {

                MetamodelTableModel mmTable = (MetamodelTableModel) table.getModel( );
                mmTable.selectAll( );
            }
        } );
        buttons.add( selectAll );

        JButton deselectAll = new JButton( "Deselect all" );
        deselectAll.addActionListener( new ActionListener( ) {

            public void actionPerformed( ActionEvent e ) {

                MetamodelTableModel mmTable = (MetamodelTableModel) table.getModel( );
                mmTable.deselectAll( );
            }
        } );
        buttons.add( deselectAll );

        JButton selectAllMoinMetamodels = new JButton( "Select MOIN mm" );
        selectAllMoinMetamodels.addActionListener( new ActionListener( ) {

            public void actionPerformed( ActionEvent e ) {

                MetamodelTableModel mmTable = (MetamodelTableModel) table.getModel( );
                mmTable.deselectAll( );
                String[] metamodelContainerNames = mmTable.getMetamodelContainerNames( );

                ArrayList<String> moinMetammodelContainerNames = new ArrayList<String>( );
                for ( String containerName : metamodelContainerNames ) {
                    if ( containerName.indexOf( "moin" ) != -1 ) {
                        if ( containerName.equals( WEB_DYNPRO_CONTAINER_NAME ) ) {
                            continue;
                        }
                        moinMetammodelContainerNames.add( containerName );
                    }
                }
                mmTable.selectMetammodelContainerName( moinMetammodelContainerNames.toArray( new String[moinMetammodelContainerNames.size( )] ) );
            }
        } );
        buttons.add( selectAllMoinMetamodels );

        JButton selectCustomerMetamodels = new JButton( "Select Customer mm" );
        selectCustomerMetamodels.addActionListener( new ActionListener( ) {

            public void actionPerformed( ActionEvent e ) {

                MetamodelTableModel mmTable = (MetamodelTableModel) table.getModel( );
                mmTable.deselectAll( );
                String[] metamodelContainerNames = mmTable.getMetamodelContainerNames( );

                ArrayList<String> customerMetamodelContainerNames = new ArrayList<String>( );
                for ( String containerName : metamodelContainerNames ) {

                    if ( containerName.equals( WEB_DYNPRO_CONTAINER_NAME ) ) {
                        customerMetamodelContainerNames.add( containerName );
                        continue;
                    }

                    if ( containerName.indexOf( "moin" ) == -1 ) {
                        customerMetamodelContainerNames.add( containerName );
                    }
                }
                mmTable.selectMetammodelContainerName( customerMetamodelContainerNames.toArray( new String[customerMetamodelContainerNames.size( )] ) );
            }
        } );
        buttons.add( selectCustomerMetamodels );

        JButton generateJmiButton = new JButton( "Generate JMIs" );
        generateJmiButton.addActionListener( new ActionListener( ) {

            public void actionPerformed( ActionEvent e ) {

                MetamodelTableModel mmTable = (MetamodelTableModel) table.getModel( );
                mmTable.getSelectedMetamodelContainerName( );
                try {
                    if ( rootFolder != null && connection != null ) {
                        JmiGenerationKind[] jmiGenerationKind = getJmiGenerationKind( );
                        if ( jmiGenerationKind.length != 0 ) {
                            generator.generateJmi( mmTable.getSelectedMetamodelContainerName( ), connection, jmiGenerationKind );
                        } else {
                            JOptionPane.showMessageDialog( GenerationPanel.this, "You have to choose at least one generation kind" );
                        }
                    }
                } catch ( Exception e1 ) {
                    JOptionPane.showMessageDialog( GenerationPanel.this, e1 );
                }
            }
        } );
        buttons.add( generateJmiButton );

        JButton generateMofRomButton = new JButton( "Generate MofRom" );
        generateMofRomButton.addActionListener( new ActionListener( ) {

            public void actionPerformed( ActionEvent e ) {

                String targetPath = generator.getRootFolder( ) + File.separator + "mofrom";
                File outputFolder = new File( targetPath );

                if ( moinPerforceRoot == null ) {
                    moinPerforceRoot = getPersistedMoinPerforceRoot( );
                    if ( moinPerforceRoot == null ) {
                        chooseAndPersistMoinPerforceRoot( );
                        if ( moinPerforceRoot == null ) {
                            return;
                        }
                    }
                }

                File folderWithMofXmis = new File( moinPerforceRoot.getAbsolutePath( ) + File.separator + "moin\\moin.metamodels\\" + CODE_LINE + "\\src\\_tc~moin~mof_1.4\\moin\\meta" );

                String message = "MofRom xmi files will be taken from " + folderWithMofXmis.getAbsolutePath( ) + "\n\nMofRom will be generated to " + outputFolder.getAbsolutePath( );
                JOptionPane.showOptionDialog( GenerationPanel.this, message, "Generate MofRom", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null );

                generator.generateMofRom( folderWithMofXmis, outputFolder, connection );
            }
        } );
        buttons.add( generateMofRomButton );

        JButton copyMofButton = new JButton( "Copy MOF JMIs" );
        copyMofButton.addActionListener( new ActionListener( ) {

            public void actionPerformed( ActionEvent e ) {

                moinPerforceRoot = getPersistedMoinPerforceRoot( );
                if ( moinPerforceRoot == null ) {
                    chooseAndPersistMoinPerforceRoot( );
                    if ( moinPerforceRoot == null ) {
                        return;
                    }
                }
                doCopyMof( );
            }

            private void doCopyMof( ) {

                if ( moinPerforceRoot != null ) {
                    String mof14ContainerName = generator.getMofContainerName( );
                    File interfaceFile = getMofInterfacesTargetDir( moinPerforceRoot );
                    File implementationFile = getMofImplementationTargetDir( moinPerforceRoot );
                    File wrapperFile = getMofWrapperTargetDir( moinPerforceRoot );
                    int choice = JOptionPane.showOptionDialog( GenerationPanel.this, "MOF implementation files will be copied to\n" + implementationFile.getAbsolutePath( ) + "\n\nMOF interfaces will be copied to\n" + interfaceFile.getAbsolutePath( ) + "\n\nMOF wrapper will be copied to\n"
                                                                                     + wrapperFile.getAbsolutePath( ), "Copy MOF", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null );

                    if ( choice == JOptionPane.OK_OPTION ) {
                        try {
                            copyMof( moinPerforceRoot, new File( generator.getTargetSourcePath( mof14ContainerName, JmiGenerationKind.INTERFACE ) ), new File( generator.getTargetSourcePath( mof14ContainerName, JmiGenerationKind.CLASS ) ), new File( generator
                                .getTargetSourcePath( mof14ContainerName, JmiGenerationKind.WRAPPER ) ) );
                        } catch ( FileNotFoundException fnf ) {
                            JOptionPane.showMessageDialog( GenerationPanel.this, fnf );
                        } catch ( IOException e1 ) {
                            JOptionPane.showMessageDialog( GenerationPanel.this, e1 );
                        }
                    } else if ( choice == JOptionPane.NO_OPTION ) {
                        chooseAndPersistMoinPerforceRoot( );
                        doCopyMof( );
                    }

                }
            }
        } );
        buttons.add( copyMofButton );

        JButton copyXmiJarsButton = new JButton( "Copy XMI Jars" );
        copyXmiJarsButton.addActionListener( new ActionListener( ) {

            public void actionPerformed( ActionEvent e ) {

                if ( moinPerforceRoot == null ) {
                    moinPerforceRoot = getPersistedMoinPerforceRoot( );
                    if ( moinPerforceRoot == null ) {
                        chooseAndPersistMoinPerforceRoot( );
                        if ( moinPerforceRoot == null ) {
                            return;
                        }
                    }
                }
                targetPlatform = getPersistedTargetPlatform( );
                if ( targetPlatform == null ) {
                    chooseAndPersistTargetPlatform( );
                }
                copyXmiJars( );

            }

            private void copyXmiJars( ) {

                if ( targetPlatform != null ) {
                    String[] selectedMetamodelContainerNames = ( (MetamodelTableModel) table.getModel( ) ).getSelectedMetamodelContainerName( );
                    if ( selectedMetamodelContainerNames == null || selectedMetamodelContainerNames.length == 0 ) {
                        JOptionPane.showMessageDialog( GenerationPanel.this, "You have to choose a metamodel" );
                    } else {
                        List<XmiJarSrcDest> pathMappingForXmiJars = getMappingForXmiJars( selectedMetamodelContainerNames );

                        if ( pathMappingForXmiJars == null || pathMappingForXmiJars.isEmpty( ) ) {
                            String message = "";
                            for ( String containerName : selectedMetamodelContainerNames ) {
                                message = message + containerName + "\n";
                            }
                            JOptionPane.showMessageDialog( GenerationPanel.this, "Sorry, no mapping defined for \n\n" + message );

                        } else {
                            String message = "Xmi Jars will be copied from target platform " + targetPlatform.getAbsolutePath( ) + "\n Affected metamodel containers are:\n\n";
                            for ( XmiJarSrcDest xmiJarSrcDest : pathMappingForXmiJars ) {
                                message = message + xmiJarSrcDest.containerName + "\n";
                            }
                            message = message + "\n";

                            int choice = JOptionPane.showOptionDialog( GenerationPanel.this, message, "Copy Xmi jars", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null );

                            if ( choice == JOptionPane.OK_OPTION ) {
                                try {
                                    for ( XmiJarSrcDest xmiJarSrcDest : pathMappingForXmiJars ) {
                                        copyFile( xmiJarSrcDest.srcXmiJar, xmiJarSrcDest.destinationXmiJar );
                                    }
                                } catch ( FileNotFoundException fnf ) {
                                    JOptionPane.showMessageDialog( GenerationPanel.this, fnf );
                                } catch ( IOException e1 ) {
                                    JOptionPane.showMessageDialog( GenerationPanel.this, e1 );
                                }
                            } else if ( choice == JOptionPane.NO_OPTION ) {
                                chooseAndPersistTargetPlatform( );
                                copyXmiJars( );
                            }
                        }
                    }
                }
            }
        } );
        buttons.add( copyXmiJarsButton );

        return buttons;
    }

    private List<XmiJarSrcDest> getMappingForXmiJars( String[] metamodelContainerNames ) {

        String perforceRootPath = moinPerforceRoot.getAbsolutePath( );
        List<XmiJarSrcDest> result = new ArrayList<XmiJarSrcDest>( );
        for ( String containerName : metamodelContainerNames ) {
            ProjectAndPluginId projectAndPluginId = containerName2ProjectAndPluginId.get( containerName );
            if ( projectAndPluginId != null ) {
                File projectPath = new File( perforceRootPath + File.separator + projectAndPluginId.relativeProjectPath + File.separator + "lib" );
                File pluginLibPath = getPluginLibPathOfLatestPlugin( projectAndPluginId.pluginId );
                if ( pluginLibPath != null ) {
                    projectPath.mkdirs( );
                    String[] filesInPlugin = pluginLibPath.list( );
                    File xmiJar = null;
                    if ( filesInPlugin != null ) {
                        for ( int i = 0; i < filesInPlugin.length; i++ ) {
                            if ( filesInPlugin[i].endsWith( "_xmi.jar" ) ) {
                                xmiJar = new File( pluginLibPath.getAbsolutePath( ) + File.separator + filesInPlugin[i] );
                                break;
                            }
                        }
                        if ( xmiJar != null ) {
                            result.add( new XmiJarSrcDest( new File( projectPath.getAbsolutePath( ) + File.separator + xmiJar.getName( ) ), xmiJar, containerName ) );
                        }
                    }
                }
            }
        }

        return result;
    }

    private File getPluginLibPathOfLatestPlugin( final String pluginId ) {

        String targetPlatformPath = this.targetPlatform.getAbsolutePath( );
        File pluginsDir = new File( targetPlatformPath + File.separator + "plugins" );
        FilenameFilter filter = new FilenameFilter( ) {

            public boolean accept( File dir, String name ) {

                if ( name.startsWith( pluginId ) ) {
                    return true;
                }

                return false;
            }

        };

        File[] pluginsForId = pluginsDir.listFiles( filter );

        File theLatestPlugin = getLatestPlugin( pluginsForId );
        if ( theLatestPlugin != null ) {
            return new File( theLatestPlugin.getAbsolutePath( ) + File.separator + "lib" );
        }

        return null;

    }

    private File getLatestPlugin( File[] pluginsForId ) {

        if ( pluginsForId != null ) {

            if ( pluginsForId.length == 1 ) {
                return pluginsForId[0];
            } else {
                ArrayList<IndexAndVersion> indexAndVersion = new ArrayList<IndexAndVersion>( );
                for ( int i = 0; i < pluginsForId.length; i++ ) {
                    File file = pluginsForId[i];
                    String name = file.getName( );
                    int versionIndex = name.lastIndexOf( '_' );
                    if ( versionIndex != -1 ) {
                        indexAndVersion.add( new IndexAndVersion( i, name.substring( versionIndex ) ) );
                    } else {
                        //no version, always use that one
                        return pluginsForId[i];
                    }
                }

            }
        }

        return null;
    }

    private static final class IndexAndVersion implements Comparable<IndexAndVersion> {

        public int index;

        public String version;

        public IndexAndVersion( int index, String version ) {

            super( );
            this.index = index;
            this.version = version;
        }

        public int compareTo( IndexAndVersion o ) {

            return this.version.compareTo( o.version );
        }

    }

    private static File getPersistedMoinPerforceRoot( ) {

        return getPersistedFileFromPreferenceProperties( KEY_MOIN_PERFORCE_ROOT );

    }

    private static File getPersistedTargetPlatform( ) {

        return getPersistedFileFromPreferenceProperties( KEY_TARGET_PLATFORM );
    }

    private static File getPersistedFileFromPreferenceProperties( String key ) {

        Properties properties = null;
        try {
            properties = getPreferenceProperties( );
        } catch ( IOException e1 ) {
            throw new RuntimeException( e1 );
        }

        String path = properties.getProperty( key );
        if ( path == null ) {
            return null;
        }

        File perforceRootFile = new File( path );
        if ( perforceRootFile.exists( ) ) {
            return perforceRootFile;
        }

        return null;
    }

    private static File getPreferenceFile( ) {

        File preferences = new File( tmpdir.getAbsolutePath( ) + File.separator + generatorPreferencesFile );
        try {
            preferences.createNewFile( );
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
        return preferences;
    }

    private static Properties getPreferenceProperties( ) throws IOException {

        Properties properties = new Properties( );
        FileInputStream fileInputStream = null;
        fileInputStream = new FileInputStream( getPreferenceFile( ) );
        try {
            properties.load( fileInputStream );
        } catch ( IOException e ) {
            if ( fileInputStream != null ) {
                fileInputStream.close( );
            }
        }
        return properties;
    }

    private static void storePreferenceProperties( Properties properties ) throws IOException {

        File file = getPreferenceFile( );
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream( file );
            properties.store( outputStream, "" );
            outputStream.close( );
        } catch ( IOException e ) {
            if ( outputStream != null ) {
                outputStream.close( );
            }
            throw e;
        }
    }

    private static void setPersistedMoinPerforceRoot( String perforceRoot ) {

        setPersistedProperty( KEY_MOIN_PERFORCE_ROOT, perforceRoot );
    }

    private static void setPersistedProperty( Object key, String value ) {

        try {
            Properties properties = getPreferenceProperties( );
            properties.put( key, value );
            storePreferenceProperties( properties );
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }

    private static void setPersistedTargetPlatform( String targetPlatform ) {

        setPersistedProperty( KEY_TARGET_PLATFORM, targetPlatform );
    }

    public static void copyMof( File moinPerforceRoot, File srcDirMofInterfaces, File srcDirMofImpl, File srcDirMofWrapper ) throws IOException {

        File targetMofInterfaces = getMofInterfacesTargetDir( moinPerforceRoot );
        File targetMofImpl = getMofImplementationTargetDir( moinPerforceRoot );
        File targetMofWrapper = getMofWrapperTargetDir( moinPerforceRoot );
        copyDirectory( srcDirMofInterfaces, targetMofInterfaces );
        copyDirectory( srcDirMofImpl, targetMofImpl );
        copyDirectory( srcDirMofWrapper, targetMofWrapper );
    }

    static File getMofImplementationTargetDir( File moinPerforceRoot ) {

        File targetMofImpl = new File( moinPerforceRoot.getAbsolutePath( ) + File.separator + relativePathToMofImpl );
        return targetMofImpl;
    }

    static File getMofInterfacesTargetDir( File moinPerforceRoot ) {

        File targetMofInterfaces = new File( moinPerforceRoot.getAbsolutePath( ) + File.separator + relativePathToMofApi );
        return targetMofInterfaces;
    }

    static File getMofWrapperTargetDir( File moinPerforceRoot ) {

        return getMofImplementationTargetDir( moinPerforceRoot );
    }

    private static void copyDirectory( File srcDir, File dstDir ) throws IOException {

        if ( srcDir.isDirectory( ) ) {
            if ( !dstDir.exists( ) ) {
                dstDir.mkdirs( );
            }

            String[] children = srcDir.list( );
            for ( int i = 0; i < children.length; i++ ) {
                copyDirectory( new File( srcDir, children[i] ), new File( dstDir, children[i] ) );
            }
        } else {

            copyFile( srcDir, dstDir );
        }
    }

    private static void copyFile( File src, File dst ) throws IOException {

        InputStream in = new FileInputStream( src );
        OutputStream out = new FileOutputStream( dst );

        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ( ( len = in.read( buf ) ) > 0 ) {
            out.write( buf, 0, len );
        }
        in.close( );
        out.close( );
    }

    public JTable getMetamodelsAreaTable( ) {

        return this.table;
    }

    public MetamodelGeneratorTool getGenerator( ) {

        return generator;
    }

    public void setGenerator( MetamodelGeneratorTool generator ) {

        this.generator = generator;
    }

    public CoreConnection getConnection( ) {

        return connection;
    }

    public void setConnection( CoreConnection connection ) {

        this.connection = connection;
    }

    public JTable getTable( ) {

        return table;
    }

    public void setTable( JTable table ) {

        this.table = table;
    }

    public JmiGenerationKind[] getJmiGenerationKind( ) {

        ArrayList<JmiGenerationKind> kinds = new java.util.ArrayList<JmiGenerationKind>( );
        if ( this.classesSwitch.isSelected( ) ) {
            kinds.add( JmiGenerationKind.CLASS );
        }

        if ( ( this.interfacesSwitch.isSelected( ) ) ) {
            kinds.add( JmiGenerationKind.INTERFACE );
        }

        if ( this.wrapperSwitch.isSelected( ) ) {
            kinds.add( JmiGenerationKind.WRAPPER );
        }

        return kinds.toArray( new JmiGenerationKind[0] );
    }

    void chooseAndPersistMoinPerforceRoot( ) {

        JOptionPane.showMessageDialog( this, "You have to choose your perforce root folder, e.g. C:\\perforce" );

        while ( true ) {

            int returnVal = directoryChooser.showOpenDialog( GenerationPanel.this );
            if ( returnVal == JFileChooser.APPROVE_OPTION ) {
                File selectedFile = directoryChooser.getSelectedFile( );
                if ( isMoinPerforceRoot( selectedFile ) ) {
                    moinPerforceRoot = selectedFile;
                    setPersistedMoinPerforceRoot( moinPerforceRoot.getAbsolutePath( ) );
                    break;
                } else {
                    JOptionPane.showMessageDialog( this, "Looks like you chose the wrong folder, e.g. C:\\perforce\\moin instead of just C:\\perforce" );
                }

            } else {
                break;
            }
        }
    }

    void chooseAndPersistTargetPlatform( ) {

        JOptionPane.showMessageDialog( this, "You have to choose your target platform, e.g. C:\\ide\\eclipse" );

        while ( true ) {
            int returnVal = directoryChooser.showOpenDialog( GenerationPanel.this );
            if ( returnVal == JFileChooser.APPROVE_OPTION ) {
                File selectedFile = directoryChooser.getSelectedFile( );
                if ( isTargetPlatform( selectedFile ) ) {
                    targetPlatform = selectedFile;
                    setPersistedTargetPlatform( targetPlatform.getAbsolutePath( ) );
                    break;
                } else {
                    JOptionPane.showMessageDialog( this, "Looks like you chose the wrong folder, must be something like C:\\ide\\eclipse" );
                }

            } else {
                break;
            }
        }
    }

    private boolean isTargetPlatform( File file ) {

        if ( !file.isDirectory( ) ) {
            return false;
        }

        if ( "eclipse".equals( file.getName( ) ) ) {

            return true;
        }

        return false;
    }

    private boolean isMoinPerforceRoot( File file ) {

        if ( !file.isDirectory( ) ) {
            return false;
        }

        String[] children = file.list( );
        for ( String fileName : children ) {
            if ( fileName.equals( "moin" ) ) {
                return true;
            }
        }

        return false;
    }

    public static final String[][] mmContainerProjectPluginMapping = new String[][] {
        { TestMetaModels.JMI_TCK_CN, "moin\\moin.test\\" + CODE_LINE + "\\src\\_com.sap.tc.moin.metamodel.jmitck.epi\\ecp", "com.sap.tc.moin.metamodel.jmitck" },
        { TestMetaModels.COMPANY_CN, "moin\\moin.test\\" + CODE_LINE + "\\src\\_com.sap.tc.moin.metamodel.company.epi\\ecp", "com.sap.tc.moin.metamodel.company" },
        { TestMetaModels.SERVICE_INTERACTIONS_CN, "moin\\moin.test\\" + CODE_LINE + "\\src\\_com.sap.tc.moin.metamodel.serviceinteractions.epi\\ecp", "com.sap.tc.moin.metamodel.serviceinteractions" },
        { TestMetaModels.TESTCASES_CN, "moin\\moin.test\\" + CODE_LINE + "\\src\\_com.sap.tc.moin.metamodel.testcases.epi\\ecp", "com.sap.tc.moin.metamodel.testcases" },
        { TestMetaModels.TESTCASES_FOUNDATION_CN, "moin\\moin.test\\" + CODE_LINE + "\\src\\_com.sap.tc.moin.metamodel.testcases.foundation.epi\\ecp", "com.sap.tc.moin.metamodel.testcases.foundation" },

        { TestMetaModels.GFW_CN, "moin\\moin.test\\" + CODE_LINE + "\\src\\_com.sap.tc.moin.metamodel.gfw.epi\\ecp", "com.sap.tc.moin.metamodel.gfw" },

        { WEB_DYNPRO_CONTAINER_NAME, "moin-ide\\mi.metamodels\\" + CODE_LINE + "\\src\\_com.sap.tc.webdynpro.metamodel.eclipse\\ecp", "com.sap.tc.webdynpro.metamodel.eclipse" }

    };

    static Map<String, ProjectAndPluginId> containerName2ProjectAndPluginId = new TreeMap<String, ProjectAndPluginId>( );

    static {
        for ( int i = 0; i < mmContainerProjectPluginMapping.length; i++ ) {
            String[] mapping = mmContainerProjectPluginMapping[i];
            containerName2ProjectAndPluginId.put( mapping[0], new ProjectAndPluginId( mapping[1], mapping[2] ) );
        }
    }

    private static final class ProjectAndPluginId {

        String relativeProjectPath;

        String pluginId;

        public ProjectAndPluginId( String relativeProjectPath, String pluginId ) {

            super( );
            this.relativeProjectPath = relativeProjectPath;
            this.pluginId = pluginId;
        }
    }

    private static final class XmiJarSrcDest {

        File destinationXmiJar;

        File srcXmiJar;

        String containerName;

        public XmiJarSrcDest( File dest, File src, String containerName ) {

            super( );
            this.destinationXmiJar = dest;
            this.srcXmiJar = src;
            this.containerName = containerName;
        }
    }

}
