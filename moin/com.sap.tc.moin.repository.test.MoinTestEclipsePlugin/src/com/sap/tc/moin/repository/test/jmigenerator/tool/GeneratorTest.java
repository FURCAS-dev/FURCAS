package com.sap.tc.moin.repository.test.jmigenerator.tool;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;

import org.junit.Test;

import com.sap.tc.moin.repository.core.impl.ConnectionImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerator;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorModelElementWrapper;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorPathCodePair;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.test.testcase.MoinTestCase;

public class GeneratorTest extends MoinTestCase {

    private final class Renderer extends DefaultTreeCellRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getTreeCellRendererComponent( JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus ) {

            if ( value instanceof JmiGeneratorModelElementWrapper ) {
                JmiGeneratorModelElementWrapper proxy = (JmiGeneratorModelElementWrapper) value;
                setText( proxy.getMofType( ) + ": " + proxy.getModelElementName( ) );
            } else {
                setText( "JMI Generator node" );
            }
            return this;
        }

    }

    private void writeFile( JmiGeneratorPathCodePair pair ) {

        System.out.println( "Path: \n" + pair.getRelativePath( ) );
        System.out.println( "StringTemplate: \n" + pair.getCode( ).toString( ) );

        if ( null != System.getProperty( "targetPath" ) ) {
            try {
                String targetPath = System.getProperty( "targetPath" );
                File file = new File( targetPath );
                for ( String dir : pair.getRelativePath( ) ) {
                    boolean subdirFound = false;
                    String[] subdirs = file.list( );
                    for ( int i = 0; i < subdirs.length; i++ ) {
                        if ( subdirs[i].equals( dir ) ) {
                            subdirFound = true;
                            file = new File( file.getCanonicalPath( ) + File.separator + dir );
                            break;
                        }
                    }
                    if ( !subdirFound ) {
                        file = new File( file.getCanonicalPath( ) + File.separator + dir );
                        file.mkdir( );
                    }
                }
                File[] progs = file.listFiles( );
                File prog = null;
                for ( File pfile : progs ) {
                    if ( pfile.getName( ).equals( pair.getFileName( ) + ".java" ) ) {
                        prog = pfile;
                        break;
                    }
                }
                if ( prog == null ) {
                    prog = new File( file.getPath( ) + File.separator + pair.getFileName( ) + ".java" );
                }
                FileWriter w = new FileWriter( prog );
                w.write( pair.getCode( ) );
                w.close( );
            } catch ( IOException ioe ) {
                System.err.println( "IOException: " + ioe.getMessage( ) );
                ioe.printStackTrace( );
            }

        }

    }

    private List<String> getPackageNames( ) {

        List<String> result = new ArrayList<String>( );
        try {
            ConnectionImpl conn = (ConnectionImpl) ( (Wrapper) createConnection( ) ).unwrap( );
            RefPackage[] pkgs = conn.getTopLevelPackages( );
            String[] pkgnames = new String[pkgs.length];
            for ( int i = 0; i < pkgs.length; i++ ) {
                String name = (String) pkgs[i].refMetaObject( ).refGetValue( "name" );
                if ( name.equals( "clustered" ) ) {
                    continue;
                }
                result.add( name );
            }
        } catch ( Exception e ) {
            e.printStackTrace( );
        }
        return result;
    }

    @Override
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
    }

    @Test
    public void testGenerator( ) throws Exception {

        Set<MofPackage> mofPackages = new HashSet<MofPackage>( );
        for ( String pkgname : getPackageNames( ) ) {
            mofPackages.add( (MofPackage) this.createConnection( ).getPackage( null, pkgname ).refMetaObject( ) );
        }

        JmiGenerator gen = new JmiGenerator( getTestHelper( ).getCoreConnection( this.createConnection( ) ) );
        final List<JmiGeneratorModelElementWrapper> pkgs = gen.createObjectTree( mofPackages );

        String targetPath = System.getProperty( "targetPath" );
        if ( targetPath == null ) {
            System.out.println( "No target path in System parameter \"targetPath\", writing ouptput to console only" );
        } else {
            System.out.println( "Output is written to target path " + targetPath );

        }
        JDialog frame = new JDialog( );

        frame.setTitle( "JMI Generator Test" );
        frame.setModal( true );

        TreeNode root = new TreeNode( ) {

            Vector<JmiGeneratorModelElementWrapper> tmp = new Vector<JmiGeneratorModelElementWrapper>( );

            public boolean isLeaf( ) {

                return false;
            }

            public TreeNode getParent( ) {

                return null;
            }

            public int getIndex( TreeNode node ) {

                return pkgs.indexOf( node );
            }

            public int getChildCount( ) {

                return pkgs.size( );
            }

            public TreeNode getChildAt( int childIndex ) {

                return pkgs.get( childIndex );
            }

            public boolean getAllowsChildren( ) {

                return true;
            }

            public Enumeration<JmiGeneratorModelElementWrapper> children( ) {

                if ( tmp.isEmpty( ) ) {
                    tmp.addAll( pkgs );
                }
                return tmp.elements( );
            }

        };

        final JTree tree = new JTree( new DefaultTreeModel( root ) );
        tree.setCellRenderer( new Renderer( ) );
        tree.getSelectionModel( ).setSelectionMode( TreeSelectionModel.SINGLE_TREE_SELECTION );

        tree.addMouseListener( new MouseAdapter( ) {

            @Override
            public void mouseClicked( MouseEvent e ) {

                tree.setSelectionRow( tree.getRowForLocation( e.getX( ), e.getY( ) ) );

                try {
                    JmiGeneratorModelElementWrapper node = (JmiGeneratorModelElementWrapper) tree.getSelectionPath( ).getLastPathComponent( );
                    JPopupMenu menu = new JPopupMenu( "Generate JMI" );
                    for ( final JmiGeneratorPathCodePair pair : node.createCode( JmiGenerationKind.values( ) ) ) {
                        JMenuItem item = new JMenuItem( pair.getFileName( ) );
                        item.setActionCommand( pair.getFileName( ) );
                        menu.add( item );
                        item.addActionListener( new ActionListener( ) {

                            public void actionPerformed( ActionEvent e ) {

                                GeneratorTest.this.writeFile( pair );
                            }

                        } );
                    }

                    if ( e.getButton( ) == MouseEvent.BUTTON3 ) {
                        menu.show( tree, e.getX( ), e.getY( ) );
                    }
                } catch ( NullPointerException e1 ) {
                    // $JL-EXC$ ignore here
                }
            }

        } );
        frame.getContentPane( ).add( tree );
        frame.setSize( 300, 500 );

        frame.setVisible( true );

    }
}
