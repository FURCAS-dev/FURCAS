// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: TRT_TreeNode.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import java.io.File;
import java.util.Hashtable;

import com.sap.tc.moin.repository.test.jmitck.javatest.TestResultTable.TreeNodeObserver;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.Debug;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.DynamicArray;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

// Referenced classes of package com.sun.javatest:
// TestResult, JavaTestError, TestDescription, TestResultTable,
// TestFinder, Status

@SuppressWarnings( "nls" )
class TRT_TreeNode implements TestResultTable.TreeNode {

    public static class Fault extends Exception {

        private static final long serialVersionUID = 1L;

        Fault( I18NResourceBundle i18nresourcebundle, String s ) {

            super( i18nresourcebundle.getString( s ) );
        }

        Fault( I18NResourceBundle i18nresourcebundle, String s, Object obj ) {

            super( i18nresourcebundle.getString( s, obj ) );
        }

        Fault( I18NResourceBundle i18nresourcebundle, String s, Object aobj[] ) {

            super( i18nresourcebundle.getString( s, aobj ) );
        }
    }

    public synchronized void addObserver( TreeNodeObserver treenodeobserver ) {

        TreeNodeObserver[] atreenodeobserver = observerTable.get( this );
        if ( atreenodeobserver == null ) {
            atreenodeobserver = new TreeNodeObserver[0];
        }
        atreenodeobserver = (TreeNodeObserver[]) DynamicArray.append( atreenodeobserver, treenodeobserver );
        observerTable.put( this, atreenodeobserver );
    }

    public synchronized void removeObserver( TreeNodeObserver treenodeobserver ) {

        TreeNodeObserver atreenodeobserver[] = observerTable.get( this );
        if ( atreenodeobserver == null ) {
            return;
        }
        atreenodeobserver = (TreeNodeObserver[]) DynamicArray.remove( atreenodeobserver, treenodeobserver );
        if ( atreenodeobserver == null ) {
            observerTable.remove( this );
        } else {
            observerTable.put( this, atreenodeobserver );
        }
    }

    public int getSize( ) {

        scanSubtree( this );
        return counter;
    }

    public TestResultTable.TreeNode getParent( ) {

        return parent;
    }

    public boolean isRoot( ) {

        return parent == null;
    }

    public TestResultTable getEnclosingTable( ) {

        return table;
    }

    public boolean isUpToDate( ) {

        return lastScanDate != 0L;
    }

    public int getChildCount( ) {

        scanIfNeeded( );
        if ( childs == null ) {
            return 0;
        } else {
            return childs.length;
        }
    }

    public Object getChild( int i ) {

        scanIfNeeded( );
        if ( childs == null || i >= childs.length ) {
            return null;
        } else {
            return childs[i];
        }
    }

    public TestResult[] getTestResults( ) {

        scanIfNeeded( );
        TestResult atestresult[] = null;
        for ( int i = 0; i < childs.length; i++ ) {
            if ( childs[i] instanceof TestResult ) {
                atestresult = (TestResult[]) DynamicArray.append( atestresult, childs[i] );
            }
        }

        return atestresult;
    }

    public TestResultTable.TreeNode[] getTreeNodes( ) {

        scanIfNeeded( );
        TestResultTable.TreeNode atreenode[] = null;
        for ( int i = 0; i < childs.length; i++ ) {
            if ( childs[i] instanceof TestResultTable.TreeNode ) {
                atreenode = (TestResultTable.TreeNode[]) DynamicArray.append( atreenode, childs[i] );
            }
        }

        return atreenode;
    }

    public String getName( ) {

        return name;
    }

    public boolean isLeaf( int i ) {

        scanIfNeeded( );
        if ( i < 0 || i >= childs.length ) {
            return false;
        }
        if ( childs[i] instanceof TestResult ) {
            return true;
        }
        if ( childs[i] instanceof TRT_TreeNode ) {
            return childs == null || childs.length == 0;
        } else {
            return false;
        }
    }

    public int[] getChildStatus( ) {

        scanSubtree( this );
        if ( childStats == null ) {
            refreshChildStats( this );
        }
        return childStats;
    }

    public int getIndex( Object obj ) {

        scanIfNeeded( );
        if ( obj == null ) {
            return -2;
        }
        for ( int i = 0; i < childs.length; i++ ) {
            if ( childs[i] == obj ) {
                return i;
            }
        }

        return -1;
    }

    public TestResult matchTest( String s ) {

        scanIfNeeded( );
        if ( debug > 1 ) {
            Debug.println( "Matching Test URL: " + name + " in " + this );
        }
        TestResult testresult = null;
        if ( childs == null || childs.length == 0 ) {
            return null;
        }
        for ( int i = 0; i < childs.length; i++ ) {
            if ( childs[i] instanceof TestResult ) {
                TestResult testresult1 = (TestResult) childs[i];
                try {
                    testresult1.getDescription( ).getRootRelativeURL( );
                } catch ( TestResult.Fault fault ) {
                    throw new JavaTestError( i18n, "trttn.noTd", fault );
                }
                if ( debug > 1 ) {
                    Debug.println( "   -> trying to match against " + name );
                }
                if ( name.equals( s ) ) {
                    testresult = (TestResult) childs[i];
                    i = childs.length;
                } else {
                    testresult = null;
                }
            }
        }

        return testresult;
    }

    TRT_TreeNode( TestResultTable testresulttable, TestResultTable.TreeNode treenode ) {

        childs = null;
        counter = 0;
        name = null;
        table = testresulttable;
        parent = (TRT_TreeNode) treenode;
    }

    int getCurrentSize( ) {

        return counter;
    }

    @Deprecated
    /*
     * @deprecated Method incChildStat is deprecated
     */
    void incChildStat( int i ) {

        childStats[i]++;
    }

    @Deprecated
    /*
     * @deprecated Method decChildStat is deprecated
     */
    void decChildStat( int i ) {

        childStats[i]--;
    }

    void invalidateChildStats( ) {

        childStats = null;
        notifyCounterChange( );
        TRT_TreeNode trt_treenode = (TRT_TreeNode) getParent( );
        if ( trt_treenode != null ) {
            trt_treenode.invalidateChildStats( );
        }
    }

    boolean isChildStatsValid( ) {

        return childStats == null;
    }

    /**
     * @deprecated Method bubbleUpChildStat is deprecated
     */

    @Deprecated
    static void bubbleUpChildStat( TRT_TreeNode trt_treenode, int i ) {

        trt_treenode.childStats[i]++;
        TRT_TreeNode trt_treenode1 = (TRT_TreeNode) trt_treenode.getParent( );
        if ( trt_treenode1 != null ) {
            bubbleUpChildStat( trt_treenode1, i );
        }
    }

    static void swapChildStat( TRT_TreeNode trt_treenode, int i, int j ) {

        trt_treenode.childStats[i]--;
        trt_treenode.childStats[j]++;
        TRT_TreeNode trt_treenode1 = (TRT_TreeNode) trt_treenode.getParent( );
        if ( trt_treenode1 != null ) {
            swapChildStat( trt_treenode1, i, j );
        }
    }

    @Deprecated
    /*
     * @deprecated Method incNodeCounter is deprecated
     */
    void incNodeCounter( ) {

        counter++;
    }

    TestResult getTestResult( String s ) {

        int i = getTestIndex( s );
        if ( i != -1 ) {
            try {
                return (TestResult) getChild( i );
            } catch ( ClassCastException classcastexception ) {
                throw new JavaTestError( i18n, "trttn.badCast" );
            }
        } else {
            return null;
        }
    }

    TRT_TreeNode getTreeNode( String s ) {

        int i = getNodeIndex( s );
        if ( i != -1 ) {
            try {
                return (TRT_TreeNode) getChild( i );
            } catch ( ClassCastException classcastexception ) {
                throw new JavaTestError( i18n, "trttn.badCast" );
            }
        } else {
            return null;
        }
    }

    int getTestIndex( String s ) {

        if ( s == null ) {
            throw new JavaTestError( i18n, "trttn.nullSearch" );
        } else {
            int i = getResultIndex( TestResult.getWorkRelativePath( s ) );
            return i;
        }
    }

    synchronized int getResultIndex( String s ) {

        if ( s == null ) {
            throw new JavaTestError( i18n, "trttn.nullSearch" );
        }
        scanIfNeeded( );
        int i = -1;
        if ( childs != null && childs.length != 0 ) {
            for ( int j = 0; j < childs.length; j++ ) {
                if ( !( childs[j] instanceof TestResult ) ) {
                    continue;
                }
                TestResult testresult = (TestResult) childs[j];
                if ( !testresult.getWorkRelativePath( ).equals( s ) ) {
                    continue;
                }
                i = j;
                break;
            }

        }
        return i;
    }

    int getTestIndex( TestResult testresult ) {

        if ( testresult == null ) {
            throw new JavaTestError( i18n, "trttn.nullSearch" );
        } else {
            int i = getResultIndex( testresult.getWorkRelativePath( ) );
            return i;
        }
    }

    synchronized int getNodeIndex( String s ) {

        scanIfNeeded( );
        int i = -1;
        if ( s == null ) {
            throw new JavaTestError( i18n, "trttn.nullSearch" );
        }
        if ( childs == null || childs.length == 0 ) {
            i = -1;
        } else {
            for ( int j = 0; j < childs.length; j++ ) {
                if ( !( childs[j] instanceof TRT_TreeNode ) ) {
                    continue;
                }
                TRT_TreeNode trt_treenode = (TRT_TreeNode) childs[j];
                if ( !trt_treenode.getName( ).equals( s ) ) {
                    continue;
                }
                i = j;
                break;
            }

        }
        return i;
    }

    synchronized void scanIfNeeded( ) {

        if ( childs != null || table.getTestFinder( ) == null ) {
            return;
        }
        if ( debug > 0 ) {
            Debug.println( "starting scanIfNeeded() on node " + getName( ) );
        }
        childs = new Object[0];
        File file = new File( table.getTestSuiteRoot( ).getAbsolutePath( ) + File.separator + TestResultTable.getRootRelativePath( this ) );
        if ( isRoot( ) && filesToScan == null ) {
            file = table.getTestSuiteRoot( );
            processFile( file );
            if ( filesToScan == null ) {
                filesToScan = new String[0];
            }
        }
        lastScanDate = file.lastModified( );
        file = null;
        if ( filesToScan != null ) {
            for ( int i = 0; i < filesToScan.length; i++ ) {
                if ( filesToScan[i] == name ) {
                    processFile( new File( getTestSuiteRootPathPrefix( ) + File.separator + TestResultTable.getRootRelativePath( this ) ) );
                } else {
                    processFile( new File( getTestSuiteRootPathPrefix( ) + File.separator + TestResultTable.getRootRelativePath( this ), filesToScan[i] ) );
                }
            }

        } else if ( debug > 0 ) {
            Debug.println( "nothing to scan in " + getName( ) );
        }
    }

    synchronized TestResult resetTest( int i, TestResult testresult ) {

        if ( childs[i] != testresult ) {
            return null;
        }
        File file = testresult.getFile( );
        file.delete( );
        String s = testresult.getTestName( );
        String s1 = null;
        int j = s.lastIndexOf( '/' );
        int k = s.lastIndexOf( '#' );
        if ( k > j ) {
            s1 = s.substring( 0, k );
        } else {
            s1 = s;
        }
        Object obj = null;
        synchronized ( finderLock ) {
            table.getTestFinder( ).read( new File( getTestSuiteRootPathPrefix( ) + File.separator + s1 ) );
            TestDescription atestdescription[] = table.getTestFinder( ).getTests( );
            for ( int l = 0; l < atestdescription.length; l++ ) {
                if ( !atestdescription[l].getRootRelativeURL( ).equals( s ) ) {
                    continue;
                }
                obj = TestResult.notRun( atestdescription[l] );
                ( (TestResult) ( obj ) ).setParent( this );
                break;
            }

        }
        if ( obj != null ) {
            childs[i] = obj;
            notifyReplacedResult( testresult, ( (TestResult) ( obj ) ), i );
            testresult.setParent( null );
            return ( (TestResult) ( obj ) );
        } else {
            return null;
        }
    }

    private void processFile( File file ) {

        if ( debug > 0 ) {
            Debug.println( "--- Entering processFile() ---" );
            Debug.println( "Full name is: " + TestResultTable.getRootRelativePath( this ) );
            Debug.println( "Processing file: " + file.getPath( ) );
        }
        TestDescription atestdescription[] = null;
        File afile[] = null;
        synchronized ( finderLock ) {
            table.getTestFinder( ).read( file );
            TestDescription atestdescription1[] = table.getTestFinder( ).getTests( );
            File afile1[] = table.getTestFinder( ).getFiles( );
            if ( atestdescription1 != null && atestdescription1.length != 0 ) {
                atestdescription = new TestDescription[atestdescription1.length];
                System.arraycopy( atestdescription1, 0, atestdescription, 0, atestdescription1.length );
            } else {
                atestdescription = new TestDescription[0];
            }
            if ( afile1 != null && afile1.length != 0 ) {
                afile = new File[afile1.length];
                System.arraycopy( afile1, 0, afile, 0, afile1.length );
            } else {
                afile = new File[0];
            }
            if ( debug > 0 ) {
                Debug.println( "Read " + atestdescription.length + " tests, and " + afile.length + " files." );
            }
        }
        for ( int i = 0; i < atestdescription.length; i++ ) {
            TestResult testresult = TestResult.notRun( atestdescription[i] );
            addChild( testresult );
        }

        insertFinderFiles( this, afile );
        if ( debug > 0 ) {
            Debug.println( "--- Exiting processFile() ---" );
        }
    }

    private synchronized void insertFinderFiles( TRT_TreeNode trt_treenode, File afile[] ) {

        for ( int i = 0; i < afile.length; i++ ) {
            if ( debug > 1 ) {
                Debug.println( "**" );
                Debug.println( "original file is: " + afile[i].getPath( ) );
            }
            String s = makeNodeRelative( afile[i] );
            if ( debug > 1 ) {
                Debug.println( "stripped file is: " + s );
            }
            if ( s.charAt( s.length( ) - 1 ) == '/' ) {
                s = s.substring( 0, s.length( ) - 1 );
            }
            if ( s.indexOf( '/' ) == -1 ) {
                if ( afile[i].isDirectory( ) ) {
                    if ( debug > 1 ) {
                        Debug.println( "   => directory, creating node" );
                    }
                    try {
                        TRT_TreeNode trt_treenode1 = createDirNode( trt_treenode, s );
                        addToScanList( trt_treenode1, trt_treenode1.name, afile[i] );
                    } catch ( Fault fault ) {
                        throw new JavaTestError( i18n, "trttn.nameClash", fault );
                    }
                } else {
                    if ( debug > 1 ) {
                        Debug.println( "   => file, adding to scan list" );
                    }
                    addToScanList( this, s, afile[i] );
                }
            } else {
                recursiveFinderInsert( this, afile[i], s );
            }
            if ( debug > 1 ) {
                Debug.println( "**" );
            }
        }

    }

    private synchronized void recursiveFinderInsert( TRT_TreeNode trt_treenode, File file, String s ) {

        if ( debug > 0 ) {
            Debug.println( "Recursive insert: " + s + " into " + trt_treenode.getName( ) );
        }
        String s1 = TestResultTable.behead( s );
        if ( s == s1 ) {
            if ( file.isDirectory( ) ) {
                if ( debug > 0 ) {
                    Debug.println( "Creating empty node and leaving." );
                }
                TRT_TreeNode trt_treenode1 = new TRT_TreeNode( table, trt_treenode );
                trt_treenode1.setName( s1 );
                trt_treenode.addChild( trt_treenode1 );
            } else {
                addToScanList( trt_treenode, s, file );
            }
        } else {
            String s2 = TestResultTable.getDirName( s );
            try {
                TRT_TreeNode trt_treenode2 = createDirNode( trt_treenode, s2 );
                recursiveFinderInsert( trt_treenode2, file, s1 );
            } catch ( Fault fault ) {
                throw new JavaTestError( i18n, "trttn.nameClash", fault );
            }
        }
    }

    private TRT_TreeNode createDirNode( TRT_TreeNode trt_treenode, String s ) throws Fault {

        if ( debug > 1 ) {
            Debug.println( "   => Trying to create dir node for: " + s );
        }
        int i = trt_treenode.getResultIndex( s );
        if ( i != -1 ) {
            throw new Fault( i18n, "trttn.alreadyExists", s );
        }
        int j = trt_treenode.getNodeIndex( s );
        TRT_TreeNode trt_treenode1 = null;
        if ( j == -1 ) {
            if ( debug > 1 ) {
                Debug.println( "   => Creating " + s );
                Debug.println( "   => Node is : " + trt_treenode );
            }
            trt_treenode1 = new TRT_TreeNode( table, trt_treenode );
            trt_treenode1.setName( s );
            trt_treenode.addChild( trt_treenode1 );
        } else {
            if ( debug > 1 ) {
                Debug.println( "   => Node exists, delegating." );
                Debug.println( "   => index " + j + " in node " + trt_treenode.getName( ) );
            }
            try {
                trt_treenode1 = (TRT_TreeNode) trt_treenode.getChild( j );
                if ( debug > 1 ) {
                    Debug.println( "   => " + trt_treenode1 );
                }
            } catch ( ClassCastException classcastexception ) {
                throw new JavaTestError( i18n, "trttn.unexpecCast", classcastexception );
            }
        }
        return trt_treenode1;
    }

    void scanSubtree( TRT_TreeNode trt_treenode ) {

        if ( table.getTestFinder( ) == null ) {
            return;
        }
        trt_treenode.scanIfNeeded( );
        TRT_TreeNode atrt_treenode[] = (TRT_TreeNode[]) trt_treenode.getTreeNodes( );
        if ( atrt_treenode != null && atrt_treenode.length != 0 ) {
            for ( int i = 0; i < atrt_treenode.length; i++ ) {
                scanSubtree( atrt_treenode[i] );
            }

        }
    }

    private String makeNodeRelative( File file ) {

        if ( debug > 1 ) {
            Debug.println( "relativising: " + file.getPath( ) );
        }
        if ( file.isAbsolute( ) ) {
            int i = getTestSuitePathLen( );
            if ( debug > 1 ) {
                Debug.println( "  -> URL is absolute (" + file.getPath( ).length( ) + " chars), stripping." );
                Debug.println( "  -> Stripping " + i + " characters." );
            }
            String s1 = TestResultTable.getRootRelativePath( this );
            if ( debug > 1 ) {
                Debug.println( "  -> removing rrp: " + s1 );
            }
            i += s1 != null && s1.length( ) != 0 ? s1.length( ) + 1 : 0;
            String s3 = file.getPath( ).substring( i );
            if ( debug > 1 ) {
                Debug.println( "  -> final node path: " + s3 );
            }
            return s3.replace( File.separatorChar, '/' );
        }
        String s = TestResultTable.getRootRelativePath( this );
        String s2 = file.getPath( ).replace( File.separatorChar, '/' );
        if ( debug > 1 ) {
            Debug.println( "  -> check for RRP against: " + s );
        }
        if ( s != null && s.length( ) != 0 && s2.startsWith( s ) ) {
            if ( debug > 1 ) {
                Debug.println( "  -> URL is root relative, stripping" );
            }
            int j = s.length( );
            String s4 = s2.substring( j + 1 );
            return s4;
        }
        if ( debug > 1 ) {
            Debug.println( "  -> relative, continue" );
        }
        return s2;
    }

    private void addToScanList( TRT_TreeNode trt_treenode, String s, File file ) {

        if ( debug > 1 ) {
            Debug.println( "   => Adding " + s + " to scan list and leaving." );
            Debug.println( "   => Node is : " + trt_treenode );
        }
        int i = 0;
        if ( trt_treenode.filesToScan != null ) {
            for ( i = 0; i < trt_treenode.filesToScan.length; i++ ) {
                if ( trt_treenode.filesToScan[i].equals( s ) ) {
                    break;
                }
            }
        }

        if ( trt_treenode.filesToScan == null || i >= trt_treenode.filesToScan.length ) {
            trt_treenode.filesToScan = (String[]) DynamicArray.append( trt_treenode.filesToScan, s );
        } else if ( debug > 1 ) {
            Debug.println( i18n.getString( "trttn.multRef", file.getPath( ) ) );
        }
    }

    synchronized TestResult addChild( TestResult testresult ) {

        scanIfNeeded( );
        if ( testresult == null ) {
            throw new JavaTestError( i18n, "trttn.nullNode" );
        }
        if ( debug > 1 ) {
            Debug.println( "Adding test " + testresult.getTestName( ) );
            Debug.println( "   -> " + testresult.getStatus( ).toString( ) );
            Debug.println( "   -> node ref: " + this );
            Debug.println( "   -> node name: " + getName( ) );
        }
        int i = getTestIndex( testresult );
        TestResult testresult1 = null;
        if ( i == -1 ) {
            if ( debug > 1 ) {
                Debug.println( "no old entry for " + testresult );
            }
            try {
                childs = DynamicArray.append( childs, testresult, Class.forName( "java.lang.Object" ) );
                testresult.setParent( this );
                bubbleUpCounterInc( );
                notifyInsResult( testresult, childs.length - 1 );
            } catch ( ClassNotFoundException classnotfoundexception ) {
                throw new JavaTestError( i18n, "trttn.noObject", classnotfoundexception );
            }
        } else if ( shouldReplaceTest( i, testresult ) ) {
            testresult1 = (TestResult) childs[i];
            childs[i] = testresult;
            if ( debug > 1 ) {
                Debug.println( "   -> ** replacing existing TR with " + testresult );
                Debug.println( "   -> " + testresult.getTestName( ) );
                Debug.println( "   -> " + testresult.getStatus( ).toString( ) );
                Debug.println( "   -> node: " + this );
            }
            testresult1.setParent( null );
            testresult.setParent( this );
            notifyReplacedResult( testresult1, testresult, i );
        } else {
            if ( debug > 1 ) {
                Debug.println( "   -> ** TRT selectively ignoring insert of " + testresult );
                Debug.println( "   -> old status: " + ( (TestResult) childs[i] ).getStatus( ).toString( ) );
                Debug.println( "   -> curr. ref in TRT: " + childs[i] );
                Debug.println( "   -> ignored new ref.: " + testresult );
            }
            return testresult;
        }
        invalidateChildStats( );
        return testresult1;
    }

    synchronized void addChild( TRT_TreeNode trt_treenode ) {

        if ( trt_treenode == null ) {
            throw new JavaTestError( i18n, "trttn.nullNode" );
        }
        scanIfNeeded( );
        try {
            childs = DynamicArray.append( childs, trt_treenode, Class.forName( "java.lang.Object" ) );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new JavaTestError( i18n, "trttn.noObject", classnotfoundexception );
        }
    }

    void setName( String s ) {

        name = s;
    }

    private boolean shouldReplaceTest( int i, TestResult testresult ) {

        if ( !( childs[i] instanceof TestResult ) || testresult == null || i < 0 || i >= childs.length ) {
            return false;
        }
        TestResult testresult1 = (TestResult) childs[i];
        if ( !testresult1.getTestName( ).equals( testresult.getTestName( ) ) ) {
            return false;
        }
        if ( testresult1.getStatus( ).getType( ) != testresult.getStatus( ).getType( ) ) {
            return true;
        }
        if ( !testresult1.getStatus( ).getReason( ).equals( testresult.getStatus( ).getReason( ) ) ) {
            return true;
        }
        boolean flag = testresult1.isShrunk( );
        boolean flag1 = testresult.isShrunk( );
        if ( flag && !flag1 ) {
            return true;
        }
        return !flag && !flag1;
    }

    private static void refreshChildStats( TRT_TreeNode trt_treenode ) {

        if ( trt_treenode.childStats != null ) {
            return;
        }
        trt_treenode.childStats = new int[4];
        for ( int i = 0; i < trt_treenode.childs.length; i++ ) {
            if ( trt_treenode.childs[i] instanceof TRT_TreeNode ) {
                TRT_TreeNode trt_treenode1 = (TRT_TreeNode) trt_treenode.childs[i];
                int ai[] = trt_treenode1.getChildStatus( );
                for ( int j = 0; j < ai.length; j++ ) {
                    trt_treenode.childStats[j] += ai[j];
                }

            } else {
                TestResult testresult = (TestResult) trt_treenode.childs[i];
                trt_treenode.childStats[testresult.getStatus( ).getType( )]++;
            }
        }

    }

    void bubbleUpCounterInc( ) {

        counter++;
        notifyCounterChange( );
        TRT_TreeNode trt_treenode = (TRT_TreeNode) getParent( );
        if ( trt_treenode != null ) {
            trt_treenode.bubbleUpCounterInc( );
        }
    }

    private int getTestSuitePathLen( ) {

        if ( table.getTestSuiteRoot( ).isFile( ) ) {
            return table.getTestSuiteRoot( ).getParent( ).length( ) + 1;
        } else {
            return table.getTestSuiteRoot( ).getAbsolutePath( ).length( ) + 1;
        }
    }

    private String getTestSuiteRootPathPrefix( ) {

        File file = table.getTestSuiteRoot( );
        if ( file.isFile( ) ) {
            return file.getParent( );
        } else {
            return file.getPath( );
        }
    }

    private void notifyInsResult( TestResult testresult, int i ) {

        TestResultTable.TreeNodeObserver atreenodeobserver[] = observerTable.get( this );
        if ( atreenodeobserver != null ) {
            for ( int j = 0; j < atreenodeobserver.length; j++ ) {
                atreenodeobserver[j].insertedResult( this, testresult, i );
            }

        }
    }

    private void notifyReplacedResult( TestResult testresult, TestResult testresult1, int i ) {

        TestResultTable.TreeNodeObserver atreenodeobserver[] = observerTable.get( this );
        if ( atreenodeobserver != null ) {
            for ( int j = 0; j < atreenodeobserver.length; j++ ) {
                atreenodeobserver[j].replacedResult( this, testresult, testresult1, i );
            }

        }
    }

    private void notifyCounterChange( ) {

        TestResultTable.TreeNodeObserver atreenodeobserver[] = observerTable.get( this );
        if ( atreenodeobserver != null ) {
            for ( int i = 0; i < atreenodeobserver.length; i++ ) {
                atreenodeobserver[i].countersInvalidated( this );
            }

        }
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    private Object childs[];

    private TRT_TreeNode parent;

    private TestResultTable table;

    private int counter;

    private int childStats[];

    private String name;

    private long lastScanDate;

    private static Hashtable<TRT_TreeNode, TreeNodeObserver[]> observerTable = new Hashtable<TRT_TreeNode, TreeNodeObserver[]>( 16 );

    private static final Object finderLock = new Object( );

    private String filesToScan[];

    protected static int debug;

    private static I18NResourceBundle i18n;

    static {
        debug = Debug.getInt( com.sap.tc.moin.repository.test.jmitck.javatest.TRT_TreeNode.class );
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.javatest.TRT_TreeNode.class );
    }
}
