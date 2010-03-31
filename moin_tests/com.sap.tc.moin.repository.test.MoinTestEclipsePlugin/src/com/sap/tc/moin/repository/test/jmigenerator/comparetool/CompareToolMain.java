package com.sap.tc.moin.repository.test.jmigenerator.comparetool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

public class CompareToolMain extends JDialog implements ActionListener {

    public final Properties myProperties = new Properties( );

    public final static String PROP_OLDPATH = "OldPath";

    public final static String PROP_PKGNAME = "PackageName";

    public final static String PROP_NEWPATH = "NewPath";

    public final static String PROP_GENINTERFACE = "Interface";

    public final static String PROP_GENIMPL = "Impl";

    public final static String PROP_GENWRAPPER = "Wrapper";

    public final static String PROP_CLEANUP = "Cleanup";

    private static final long serialVersionUID = 1L;

    private JPanel mainPanel = null;

    private JPanel generationKindPanel = null;

    private JCheckBox genKindInterface = null;

    private JCheckBox genKindImpl = null;

    private JCheckBox genKindWrapper = null;

    private JPanel pathPanel = null;

    private JTextField oldGeneratorPath = null;

    private JLabel oldGeneratorLabel = null;

    private JLabel newGeneratorLabel = null;

    private JTextField newGeneratorPath = null;

    private JButton selectOldPathButton = null;

    private JButton selecNewPathButton = null;

    final JFileChooser filechooserOld = new JFileChooser( );

    final JFileChooser filechooserNew = new JFileChooser( );

    private JPanel buttonRowPanel = null;

    private JButton generateButton = null;

    private JButton savePrefsButton = null;

    private JPanel packagePanel = null;

    private JComboBox packageName = null;

    private JLabel packageLabel = null;

    private JCheckBox cleanupTarget = null;

    private JPanel importPanel = null;

    private JComboBox metamodelName = null;

    private JLabel mmNameLabel = null;

    private JButton importButton = null;

    private GeneratorCompareTool tool = null;

    private JPanel preferencesPanel = null;

    private JButton compareButton = null;

    private JButton generateAllButton = null;

    /**
     * This method initializes
     */
    public CompareToolMain( GeneratorCompareTool tool ) {

        super( );
        this.tool = tool;
        initialize( );
    }

    /**
     * This method initializes this
     */
    private void initialize( ) {

        this.setTitle( "JMI Generator Compare Tool" );

        String[] pkgNames = this.tool.getPackageNames( );
        for ( int i = 0; i < pkgNames.length; i++ ) {
            getPackageName( ).addItem( pkgNames[i] );
        }
        for ( int i = 0; i < GeneratorCompareTool.MMNAMES.length; i++ ) {
            getMetamodelName( ).addItem( GeneratorCompareTool.MMNAMES[i] );
        }

        this.setPreferredSize( new Dimension( 500, 600 ) );
        this.setContentPane( getMainPanel( ) );
        this.filechooserOld.addActionListener( this );
        this.filechooserOld.setAcceptAllFileFilterUsed( false );
        this.filechooserOld.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
        this.filechooserOld.setDialogTitle( "Select a source directory for the old generator" );
        this.filechooserNew.addActionListener( this );
        this.filechooserNew.setAcceptAllFileFilterUsed( false );
        this.filechooserNew.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
        this.filechooserNew.setDialogTitle( "Select a source directory for the new generator" );

        String pathname = System.getProperty( "user.home" );

        try {
            File file = new File( pathname + File.separator + "JmiGeneratorPrefs.properties" );
            if ( file.exists( ) ) {
                FileInputStream i = new FileInputStream( file );
                Properties props = new Properties( );
                props.load( i );
                String oldPath = props.getProperty( PROP_OLDPATH );
                String newPath = props.getProperty( PROP_NEWPATH );
                getOldGeneratorPath( ).setText( oldPath );
                getNewGeneratorPath( ).setText( newPath );
                filechooserOld.setSelectedFile( new File( oldPath ) );
                filechooserNew.setSelectedFile( new File( newPath ) );
                getGenKindInterface( ).setSelected( Boolean.valueOf( props.getProperty( PROP_GENINTERFACE ) ) );
                getGenKindImpl( ).setSelected( Boolean.valueOf( props.getProperty( PROP_GENIMPL ) ) );
                getGenKindWrapper( ).setSelected( Boolean.valueOf( props.getProperty( PROP_GENWRAPPER ) ) );
                getPackageName( ).setSelectedItem( props.getProperty( PROP_PKGNAME ) );
                getCleanupTarget( ).setSelected( Boolean.valueOf( props.getProperty( PROP_CLEANUP ) ) );
            }
        } catch ( IOException e1 ) {
            // TODO Auto-generated catch block
            e1.printStackTrace( );
        }
    }

    /**
     * This method initializes mainPanel
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getMainPanel( ) {

        if ( mainPanel == null ) {
            FlowLayout flowLayout = new FlowLayout( );
            flowLayout.setAlignment( java.awt.FlowLayout.LEFT );
            mainPanel = new JPanel( );
            mainPanel.setLayout( flowLayout );
            mainPanel.add( getImportPanel( ), null );
            mainPanel.add( getPreferencesPanel( ), null );
            mainPanel.add( getPackagePanel( ), null );
            mainPanel.add( getButtonRowPanel( ), null );
        }
        return mainPanel;
    }

    /**
     * This method initializes generationKindPanel
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getGenerationKindPanel( ) {

        if ( generationKindPanel == null ) {
            GridBagConstraints gridBagConstraints13 = new GridBagConstraints( );
            gridBagConstraints13.gridx = -1;
            gridBagConstraints13.gridy = -1;
            GridBagConstraints gridBagConstraints21 = new GridBagConstraints( );
            gridBagConstraints21.anchor = GridBagConstraints.WEST;
            gridBagConstraints21.fill = GridBagConstraints.HORIZONTAL;
            GridBagConstraints gridBagConstraints1 = new GridBagConstraints( );
            gridBagConstraints1.gridx = 0;
            gridBagConstraints1.anchor = GridBagConstraints.WEST;
            gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints1.gridy = 2;
            GridBagConstraints gridBagConstraints = new GridBagConstraints( );
            gridBagConstraints.gridx = 0;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridy = 1;
            generationKindPanel = new JPanel( );
            generationKindPanel.setLayout( new GridBagLayout( ) );
            generationKindPanel.setBorder( BorderFactory.createTitledBorder( null, "Select generation kind", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font( "Dialog", Font.BOLD, 12 ), new Color( 51, 51, 51 ) ) );
            generationKindPanel.add( getGenKindInterface( ), gridBagConstraints21 );
            generationKindPanel.add( getGenKindImpl( ), gridBagConstraints );
            generationKindPanel.add( getGenKindWrapper( ), gridBagConstraints1 );
        }
        return generationKindPanel;
    }

    /**
     * This method initializes genKindInterface
     * 
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getGenKindInterface( ) {

        if ( genKindInterface == null ) {
            genKindInterface = new JCheckBox( );
            genKindInterface.setText( "Generate Interfaces" );
        }
        return genKindInterface;
    }

    /**
     * This method initializes genKindImpl
     * 
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getGenKindImpl( ) {

        if ( genKindImpl == null ) {
            genKindImpl = new JCheckBox( );
            genKindImpl.setText( "Generate Implementations" );
        }
        return genKindImpl;
    }

    /**
     * This method initializes genKindWrapper
     * 
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getGenKindWrapper( ) {

        if ( genKindWrapper == null ) {
            genKindWrapper = new JCheckBox( );
            genKindWrapper.setText( "Generate Wrappers" );
        }
        return genKindWrapper;
    }

    /**
     * This method initializes pathPanel
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getPathPanel( ) {

        if ( pathPanel == null ) {
            GridBagConstraints gridBagConstraints9 = new GridBagConstraints( );
            gridBagConstraints9.anchor = GridBagConstraints.WEST;
            GridBagConstraints gridBagConstraints8 = new GridBagConstraints( );
            gridBagConstraints8.gridx = 0;
            gridBagConstraints8.anchor = GridBagConstraints.WEST;
            gridBagConstraints8.gridy = 5;
            GridBagConstraints gridBagConstraints7 = new GridBagConstraints( );
            gridBagConstraints7.gridx = 0;
            gridBagConstraints7.anchor = GridBagConstraints.WEST;
            gridBagConstraints7.gridy = 2;
            GridBagConstraints gridBagConstraints4 = new GridBagConstraints( );
            gridBagConstraints4.fill = GridBagConstraints.BOTH;
            gridBagConstraints4.gridy = 4;
            gridBagConstraints4.weightx = 1.0;
            gridBagConstraints4.anchor = GridBagConstraints.WEST;
            gridBagConstraints4.gridx = 0;
            GridBagConstraints gridBagConstraints3 = new GridBagConstraints( );
            gridBagConstraints3.gridx = 0;
            gridBagConstraints3.anchor = GridBagConstraints.WEST;
            gridBagConstraints3.gridy = 3;
            newGeneratorLabel = new JLabel( );
            newGeneratorLabel.setText( "Source path for new generator" );
            oldGeneratorLabel = new JLabel( );
            oldGeneratorLabel.setText( "Source path for old generator" );
            GridBagConstraints gridBagConstraints2 = new GridBagConstraints( );
            gridBagConstraints2.fill = GridBagConstraints.BOTH;
            gridBagConstraints2.gridx = 0;
            gridBagConstraints2.gridy = 1;
            gridBagConstraints2.anchor = GridBagConstraints.WEST;
            gridBagConstraints2.weightx = 1.0;
            pathPanel = new JPanel( );
            pathPanel.setLayout( new GridBagLayout( ) );
            pathPanel.setBorder( BorderFactory.createTitledBorder( null, "Select paths", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font( "Dialog", Font.BOLD, 12 ), new Color( 51, 51, 51 ) ) );
            pathPanel.add( oldGeneratorLabel, gridBagConstraints9 );
            pathPanel.add( getOldGeneratorPath( ), gridBagConstraints2 );
            pathPanel.add( newGeneratorLabel, gridBagConstraints3 );
            pathPanel.add( getNewGeneratorPath( ), gridBagConstraints4 );
            pathPanel.add( getSelectOldPathButton( ), gridBagConstraints7 );
            pathPanel.add( getSelecNewPathButton( ), gridBagConstraints8 );
        }
        return pathPanel;
    }

    /**
     * This method initializes oldGeneratorPath
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getOldGeneratorPath( ) {

        if ( oldGeneratorPath == null ) {
            oldGeneratorPath = new JTextField( );
            oldGeneratorPath.setPreferredSize( new Dimension( 400, 20 ) );
        }
        return oldGeneratorPath;
    }

    /**
     * This method initializes newGeneratorPath
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getNewGeneratorPath( ) {

        if ( newGeneratorPath == null ) {
            newGeneratorPath = new JTextField( );
            newGeneratorPath.setPreferredSize( new Dimension( 250, 20 ) );
        }
        return newGeneratorPath;
    }

    /**
     * This method initializes selectOldPathButton
     * 
     * @return javax.swing.JButton
     */
    private JButton getSelectOldPathButton( ) {

        if ( selectOldPathButton == null ) {
            selectOldPathButton = new JButton( );
            selectOldPathButton.setText( "Select..." );
            selectOldPathButton.addActionListener( new ActionListener( ) {

                public void actionPerformed( ActionEvent e ) {

                    // TODO Auto-generated method stub
                    CompareToolMain.this.filechooserOld.showOpenDialog( selectOldPathButton );
                }

            } );
        }
        return selectOldPathButton;
    }

    /**
     * This method initializes selecNewPathButton
     * 
     * @return javax.swing.JButton
     */
    private JButton getSelecNewPathButton( ) {

        if ( selecNewPathButton == null ) {
            selecNewPathButton = new JButton( );
            selecNewPathButton.setText( "Select..." );

            selecNewPathButton.addActionListener( new ActionListener( ) {

                public void actionPerformed( ActionEvent e ) {

                    CompareToolMain.this.filechooserNew.showOpenDialog( selecNewPathButton );

                }

            } );
        }
        return selecNewPathButton;
    }

    public void actionPerformed( ActionEvent e ) {

        if ( e.getActionCommand( ).equals( "ApproveSelection" ) ) {
            try {
                if ( e.getSource( ) == filechooserOld ) {
                    this.getOldGeneratorPath( ).setText( filechooserOld.getSelectedFile( ).getCanonicalPath( ) );
                }
                if ( e.getSource( ) == filechooserNew ) {
                    this.getNewGeneratorPath( ).setText( filechooserNew.getSelectedFile( ).getCanonicalPath( ) );
                }
            } catch ( IOException e1 ) {
                // TODO Auto-generated catch block
                e1.printStackTrace( );
            }

        }
        if ( e.getActionCommand( ).equals( "Save" ) ) {

            String pathname = System.getProperty( "user.home" );
            String filename = pathname + File.separator + "JmiGeneratorPrefs.properties";
            System.out.println( "Saving Preferences at " + filename + "..." );

            try {
                File file = new File( filename );
                if ( !file.exists( ) ) {
                    file.createNewFile( );
                }
                FileOutputStream w = new FileOutputStream( file );
                Properties props = new Properties( );
                fillProps( props );
                props.store( w, "Jmi Generator" );
                w.close( );
            } catch ( IOException e1 ) {
                // TODO Auto-generated catch block
                e1.printStackTrace( );
            }

        }
        if ( e.getActionCommand( ).equals( "Generate" ) ) {
            myProperties.clear( );
            fillProps( myProperties );
            try {
                CompareToolMain.this.tool.generate( false );
            } catch ( Exception e1 ) {
                e1.printStackTrace( );
            }
        }

        if ( e.getActionCommand( ).equals( "GenerateAll" ) ) {
            myProperties.clear( );
            fillProps( myProperties );
            try {
                CompareToolMain.this.tool.generate( true );
            } catch ( Exception e1 ) {
                e1.printStackTrace( );
            }
        }
        if ( e.getActionCommand( ).equals( "Compare" ) ) {
            myProperties.clear( );
            fillProps( myProperties );
            try {
                CompareToolMain.this.tool.compareFiles( );
            } catch ( Exception e1 ) {
                e1.printStackTrace( );
            }
        }

    }

    /**
     * This method initializes buttonRowPanel
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getButtonRowPanel( ) {

        if ( buttonRowPanel == null ) {
            GridBagConstraints gridBagConstraints19 = new GridBagConstraints( );
            gridBagConstraints19.anchor = GridBagConstraints.EAST;
            gridBagConstraints19.gridy = 0;
            gridBagConstraints19.gridx = 0;
            buttonRowPanel = new JPanel( );
            buttonRowPanel.setLayout( new GridBagLayout( ) );
            buttonRowPanel.setBorder( BorderFactory.createTitledBorder( null, "Compare Class Files (bin folder)", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font( "Dialog", Font.BOLD, 12 ), new Color( 51, 51, 51 ) ) );
            buttonRowPanel.setPreferredSize( new Dimension( 200, 52 ) );
            buttonRowPanel.add( getCompareButton( ), gridBagConstraints19 );
        }
        return buttonRowPanel;
    }

    /**
     * This method initializes generateButton
     * 
     * @return javax.swing.JButton
     */
    private JButton getGenerateButton( ) {

        if ( generateButton == null ) {
            generateButton = new JButton( );
            generateButton.setText( "Generate" );
            generateButton.setActionCommand( "Generate" );
            generateButton.addActionListener( this );
        }
        return generateButton;
    }

    /**
     * This method initializes savePrefsButton
     * 
     * @return javax.swing.JButton
     */
    private JButton getSavePrefsButton( ) {

        if ( savePrefsButton == null ) {
            savePrefsButton = new JButton( );
            savePrefsButton.setText( "Save preferences" );
            savePrefsButton.setActionCommand( "Save" );
            savePrefsButton.addActionListener( this );
        }
        return savePrefsButton;
    }

    private void fillProps( Properties props ) {

        props.setProperty( PROP_OLDPATH, getOldGeneratorPath( ).getText( ) );
        props.setProperty( PROP_NEWPATH, getNewGeneratorPath( ).getText( ) );
        props.setProperty( PROP_GENINTERFACE, Boolean.toString( getGenKindInterface( ).isSelected( ) ) );
        props.setProperty( PROP_GENIMPL, Boolean.toString( getGenKindImpl( ).isSelected( ) ) );
        props.setProperty( PROP_GENWRAPPER, Boolean.toString( getGenKindWrapper( ).isSelected( ) ) );
        props.setProperty( PROP_PKGNAME, (String) getPackageName( ).getSelectedItem( ) );
        props.setProperty( PROP_CLEANUP, Boolean.toString( getCleanupTarget( ).isSelected( ) ) );
    }

    /**
     * This method initializes packagePanel
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getPackagePanel( ) {

        if ( packagePanel == null ) {
            GridBagConstraints gridBagConstraints20 = new GridBagConstraints( );
            gridBagConstraints20.gridx = 1;
            gridBagConstraints20.gridy = 2;
            GridBagConstraints gridBagConstraints11 = new GridBagConstraints( );
            gridBagConstraints11.gridx = 0;
            gridBagConstraints11.anchor = GridBagConstraints.WEST;
            gridBagConstraints11.gridy = -1;
            GridBagConstraints gridBagConstraints10 = new GridBagConstraints( );
            gridBagConstraints10.gridx = 0;
            gridBagConstraints10.anchor = GridBagConstraints.WEST;
            gridBagConstraints10.gridwidth = 2;
            gridBagConstraints10.gridy = 1;
            GridBagConstraints gridBagConstraints6 = new GridBagConstraints( );
            gridBagConstraints6.gridx = 0;
            gridBagConstraints6.gridy = 0;
            packageLabel = new JLabel( );
            packageLabel.setText( "Partition of Package" );
            packageLabel.setToolTipText( "Select a root package, all content of the partition in which this package is contained will be generated" );
            GridBagConstraints gridBagConstraints5 = new GridBagConstraints( );
            gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints5.gridx = 1;
            gridBagConstraints5.anchor = GridBagConstraints.NORTH;
            gridBagConstraints5.weightx = 1.0;
            packagePanel = new JPanel( );
            packagePanel.setLayout( new GridBagLayout( ) );
            packagePanel.setBorder( BorderFactory.createTitledBorder( null, "Generate Java Files (src folder)", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font( "Dialog", Font.BOLD, 12 ), new Color( 51, 51, 51 ) ) );
            packagePanel.add( getPackageName( ), gridBagConstraints5 );
            packagePanel.add( packageLabel, gridBagConstraints6 );
            packagePanel.add( getCleanupTarget( ), gridBagConstraints10 );
            packagePanel.add( getGenerateButton( ), gridBagConstraints11 );
            packagePanel.add( getGenerateAllButton( ), gridBagConstraints20 );
        }
        return packagePanel;
    }

    /**
     * This method initializes packageName
     * 
     * @return javax.swing.JComboBox
     */
    private JComboBox getPackageName( ) {

        if ( packageName == null ) {
            packageName = new JComboBox( );
            packageName.setPreferredSize( new Dimension( 200, 25 ) );
        }
        return packageName;
    }

    /**
     * This method initializes cleanupTarget
     * 
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getCleanupTarget( ) {

        if ( cleanupTarget == null ) {
            cleanupTarget = new JCheckBox( );
            cleanupTarget.setText( "Cleanup target folders" );
            cleanupTarget.setToolTipText( "This will delete all source folders under the source path before generation" );
        }
        return cleanupTarget;
    }

    /**
     * This method initializes importPanel
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getImportPanel( ) {

        if ( importPanel == null ) {
            GridBagConstraints gridBagConstraints16 = new GridBagConstraints( );
            gridBagConstraints16.gridx = 0;
            gridBagConstraints16.anchor = GridBagConstraints.WEST;
            gridBagConstraints16.gridy = 1;
            GridBagConstraints gridBagConstraints15 = new GridBagConstraints( );
            gridBagConstraints15.gridx = 0;
            gridBagConstraints15.gridy = 0;
            mmNameLabel = new JLabel( );
            mmNameLabel.setText( "Metamodel Name" );
            GridBagConstraints gridBagConstraints14 = new GridBagConstraints( );
            gridBagConstraints14.fill = GridBagConstraints.VERTICAL;
            gridBagConstraints14.gridx = 1;
            gridBagConstraints14.weightx = 1.0;
            importPanel = new JPanel( );
            importPanel.setLayout( new GridBagLayout( ) );
            importPanel.setBorder( BorderFactory.createTitledBorder( null, "Import Test metamodel", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font( "Dialog", Font.BOLD, 12 ), new Color( 51, 51, 51 ) ) );
            importPanel.add( getMetamodelName( ), gridBagConstraints14 );
            importPanel.add( mmNameLabel, gridBagConstraints15 );
            importPanel.add( getImportButton( ), gridBagConstraints16 );
        }
        return importPanel;
    }

    /**
     * This method initializes metamodelName
     * 
     * @return javax.swing.JComboBox
     */
    private JComboBox getMetamodelName( ) {

        if ( metamodelName == null ) {
            metamodelName = new JComboBox( );
            metamodelName.setPreferredSize( new Dimension( 200, 25 ) );
        }
        return metamodelName;
    }

    /**
     * This method initializes importButton
     * 
     * @return javax.swing.JButton
     */
    private JButton getImportButton( ) {

        if ( importButton == null ) {
            importButton = new JButton( );
            importButton.setText( "Import" );
            importButton.addActionListener( new java.awt.event.ActionListener( ) {

                public void actionPerformed( java.awt.event.ActionEvent e ) {

                    getPackageName( ).removeAll( );
                    String[] pkgNames = CompareToolMain.this.tool.getPackageNames( );
                    for ( int i = 0; i < pkgNames.length; i++ ) {
                        getPackageName( ).addItem( pkgNames[i] );
                    }
                }
            } );
        }
        return importButton;
    }

    /**
     * This method initializes preferencesPanel
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getPreferencesPanel( ) {

        if ( preferencesPanel == null ) {
            GridBagConstraints gridBagConstraints12 = new GridBagConstraints( );
            gridBagConstraints12.gridx = 0;
            gridBagConstraints12.anchor = GridBagConstraints.WEST;
            gridBagConstraints12.gridy = -1;
            GridBagConstraints gridBagConstraints18 = new GridBagConstraints( );
            gridBagConstraints18.fill = GridBagConstraints.NONE;
            gridBagConstraints18.anchor = GridBagConstraints.WEST;
            GridBagConstraints gridBagConstraints17 = new GridBagConstraints( );
            gridBagConstraints17.gridx = 0;
            preferencesPanel = new JPanel( );
            preferencesPanel.setLayout( new GridBagLayout( ) );
            preferencesPanel.add( getGenerationKindPanel( ), gridBagConstraints18 );
            preferencesPanel.add( getPathPanel( ), gridBagConstraints17 );
            preferencesPanel.add( getSavePrefsButton( ), gridBagConstraints12 );
        }
        return preferencesPanel;
    }

    /**
     * This method initializes compareButton
     * 
     * @return javax.swing.JButton
     */
    private JButton getCompareButton( ) {

        if ( compareButton == null ) {
            compareButton = new JButton( );
            compareButton.setText( "Compare" );
            compareButton.setActionCommand( "Compare" );
            compareButton.addActionListener( this );
        }
        return compareButton;
    }

    /**
     * This method initializes generateAllButton
     * 
     * @return javax.swing.JButton
     */
    private JButton getGenerateAllButton( ) {

        if ( generateAllButton == null ) {
            generateAllButton = new JButton( );
            generateAllButton.setText( "Generate All Deployed" );
            generateAllButton.setActionCommand( "GenerateAll" );
            generateAllButton.addActionListener( this );
        }
        return generateAllButton;
    }

}
