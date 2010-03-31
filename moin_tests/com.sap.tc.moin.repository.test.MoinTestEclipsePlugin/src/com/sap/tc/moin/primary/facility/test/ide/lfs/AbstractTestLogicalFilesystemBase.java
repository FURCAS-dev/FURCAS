package com.sap.tc.moin.primary.facility.test.ide.lfs;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;

import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFsFactory;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * An abstract base class for logical file system tests.
 * <p>
 * The class takes care of the creation of a temporary directory before each
 * test. Derived classes can access this directory via the attribute
 * {@link temporaryDirectory}.<br>
 * In addition this class provides constants which can be reused by different
 * kinds of file system test cases.
 * 
 * @author d047015
 */
public abstract class AbstractTestLogicalFilesystemBase extends MoinTestCase {

    private static final String ILLEGAL_CHARACTERS_RESOURCE_NAME = "resource_<a>b|c\nd*e\rf_illegal";

    protected static final String LEGAL_FILE_NAMES[] = new String[] { "createdfile", "createdfile.file", ".createdfile.ext", ".createdfile", ".ext", "fi_ _le" };

    protected static final String LEGAL_FOLDER_NAMES[] = new String[] { "createdfolder", "createdfolder.descr", ".createdfolder.descr", ".createdfolder", "fo_ _lder" };

    protected static final String ILLEGAL_FILE_NAMES[] = new String[] { ILLEGAL_CHARACTERS_RESOURCE_NAME, " " };

    protected static final String ILLEGAL_FOLDER_NAMES[] = new String[] { ILLEGAL_CHARACTERS_RESOURCE_NAME, " " };

    private static final String RELATIVE_FILE_PATHS[] = new String[] { "subfolder\\createdfile", "../createdfile" };

    protected File temporaryDirectory = null;

    /**
     * Returns a new logical file system factory under test.<br>
     * Concrete test cases have to return an instance of their factory
     * implementation here.
     */
    abstract protected IpiLogicalFsFactory createLogicalFsFactoryTestInstance( );

    /**
     * Requests the cleanup of the temporary test project by the test helper.
     */
    @AfterClass
    static public void afterClassMethod( ) {

        // cleanup of temporary test project managed by the test helper
        ( (IdeRuntimeTestHelper) getTestHelper( ) ).cleanupTemporaryTestProject( );
    }

    /**
     * Requests a temporary directory.
     */
    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        // request temporary directory from the test helper
        this.temporaryDirectory = ( (IdeRuntimeTestHelper) getTestHelper( ) ).getTemporaryTestDirectory( );
    }

    /**
     * Wipes and releases the used temporary directory.
     */
    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );

        // cleanup temporary directory
        wipeDirectoryRecursively( this.temporaryDirectory );
        this.temporaryDirectory = null;
    }


    /**
     * Recursively deletes the children of a given file and the file itself.
     */
    private boolean wipeDirectoryRecursively( File file ) {

        boolean successAllChilds = true;

        if ( file.isDirectory( ) ) {
            String[] children = file.list( );
            for ( int i = 0; i < children.length; i++ ) {
                boolean successChild = wipeDirectoryRecursively( new File( file, children[i] ) );
                if ( successAllChilds && !successChild ) {
                    successAllChilds = false;
                }
            }
        }

        // empty directory or file
        boolean success = false;
        if ( successAllChilds ) {
            try {
                success = file.delete( );
            } catch ( Exception e ) {
                // nothing we can do about it
                // we want to delete as much as we can -> so we return false and go on
                success = false;
            }
        }

        return success;
    }

    /**
     * Returns a path representation to the used temporary directory that
     * depends on the {@link IpiLogicalFsFactory} implementation under test.<br>
     * This method is needed because implementations expect different types of
     * paths (e.g. absolute vs. relative path to a specific root directory).
     */
    protected abstract String getTransformedTemporaryDirectoryPath( );

    /**
     * Returns an absolute path to the used temporary directory.<br>
     * This path can be used to access the directory via <code>Java.io</code>
     * means.
     */
    protected String getAbsoluteTemporaryDirectoryPath( ) {

        return this.temporaryDirectory.getAbsolutePath( );
    }

    /**
     * Refreshes the used logical file system if the implementation uses such a
     * concept (as an eclipse based implementation does).
     */
    protected void refreshFileSystem( ) {

        // NOP by default
    }

}
