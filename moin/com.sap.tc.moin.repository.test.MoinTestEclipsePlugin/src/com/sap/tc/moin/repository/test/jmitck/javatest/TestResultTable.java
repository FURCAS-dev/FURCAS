// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: TestResultTable.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.Vector;

import com.sap.tc.moin.repository.test.jmitck.javatest.httpd.JThttpProvider;
import com.sap.tc.moin.repository.test.jmitck.javatest.httpd.RootRegistry;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.Debug;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.DynamicArray;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

// Referenced classes of package com.sun.javatest:
// TRT_TreeNode, TestResultCache, JavaTestError, TRT_Iterator,
// TestFilter, TestResult, WorkDirectory, TestSuite,
// Status, TestDescription, TestFinder

@SuppressWarnings( "nls" )
public class TestResultTable {

    public class PathRecord {

        void setTestResult( TestResult testresult ) {

            tr = testresult;
        }

        void addNode( TreeNode treenode ) {

            if ( tr != null ) {
                throw new JavaTestError( TestResultTable.i18n, "trt.invalidPath" );
            } else {
                nodes = (TreeNode[]) DynamicArray.append( nodes, treenode );
                return;
            }
        }

        public TreeNode[] getNodes( ) {

            if ( nodes == null ) {
                nodes = generateNodes( tr );
            }
            return nodes;
        }

        public TreeNode[] generateNodes( TestResult testresult ) {

            if ( testresult == null ) {
                return null;
            }
            TreeNode atreenode[] = null;
            for ( TreeNode treenode = testresult.getParent( ); treenode != null; treenode = treenode.getParent( ) ) {
                atreenode = (TreeNode[]) DynamicArray.insert( atreenode, treenode, 0 );
            }

            return atreenode;
        }

        private TreeNode nodes[];

        private TestResult tr;

        PathRecord( ) {

        }

        PathRecord( TestResult testresult ) {

            tr = testresult;
        }

        PathRecord( TreeNode atreenode[], TestResult testresult ) {

            tr = testresult;
            nodes = atreenode;
        }

    }

    class Updater implements TestResultCache.Observer {

        public void newEntry( TestResult testresult ) {

            if ( TestResultTable.debug ) {
                Debug.println( "TRT - New TR from cache: " + testresult.getWorkRelativePath( ) );
            }
            if ( testsInUpdate.contains( testresult ) ) {
                if ( TestResultTable.debug ) {
                    Debug.println( "   -> ignoring" );
                }
                return;
            }
            if ( testresult != null ) {
                insert( testresult );
            }
        }

        public void resetCache( ) {

            waitUntilReady( );
            isUpdateInProgress = true;
            if ( TestResultTable.debug ) {
                Debug.println( "TRT(" + TestResultTable.this + ") - Received cache reset message." );
            }
            Thread thread = new Thread( ) {

                @Override
                public void run( ) {

                    SortedSet<TestResult> sortedset;
                    try {
                        sortedset = trCache.getEntries( );
                    } catch ( TestResultCache.Fault fault ) {
                        if ( TestResultTable.debug ) {
                            fault.printStackTrace( );
                        }
                        throw new JavaTestError( TestResultTable.i18n, "trt.noEntries", fault );
                    }
                    update( sortedset );
                    isUpdateInProgress = false;
                }

                @Override
                protected void finalize( ) throws Throwable {

                    isUpdateInProgress = false;
                }

                {
                    setName( "TRT Background Cache Reset" );
                }
            };
            thread.setPriority( 2 );
            thread.start( );
        }

        Updater( ) {

        }
    }

    public static interface TreeIterator<T> extends Enumeration<T>, Iterator<T> {

        public abstract boolean hasMoreElements( );

        public abstract T nextElement( );

        public abstract boolean hasNext( );

        public abstract T next( );

        public abstract void remove( );

        public abstract int[] getResultStats( );

        public abstract TestFilter[] getFilters( );

        public abstract String[] getInitialURLs( );
    }

    private static class NullEnum extends TRT_Iterator {

        @Override
        public boolean hasNext( ) {

            return hasMoreElements( );
        }

        @Override
        public TestResult next( ) {

            return nextElement( );
        }

        @Override
        public void remove( ) {

            throw new UnsupportedOperationException( "Cannot remove from TestResultTable thhrough interator.  Do not call this method." );
        }

        @Override
        public boolean hasMoreElements( ) {

            return false;
        }

        @Override
        public TestResult nextElement( ) {

            throw new NoSuchElementException( TestResultTable.i18n.getString( "trt.noElements" ) );
        }

        public static NullEnum getInstance( ) {

            if ( instance == null ) {
                instance = new NullEnum( );
            }
            return instance;
        }

        private static NullEnum instance;

        private NullEnum( ) {

        }
    }

    public static interface TreeNode {

        public abstract void addObserver( TreeNodeObserver treenodeobserver );

        public abstract void removeObserver( TreeNodeObserver treenodeobserver );

        public abstract int getSize( );

        public abstract TreeNode getParent( );

        public abstract boolean isRoot( );

        public abstract TestResultTable getEnclosingTable( );

        public abstract boolean isUpToDate( );

        public abstract int getChildCount( );

        public abstract Object getChild( int i );

        public abstract TestResult[] getTestResults( );

        public abstract TreeNode[] getTreeNodes( );

        public abstract String getName( );

        public abstract boolean isLeaf( int i );

        public abstract int[] getChildStatus( );

        public abstract int getIndex( Object obj );

        public abstract TestResult matchTest( String s );
    }

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

    public static interface TreeNodeObserver {

        public abstract void insertedBranch( TreeNode treenode, TreeNode treenode1, int i );

        public abstract void insertedResult( TreeNode treenode, TestResult testresult, int i );

        public abstract void replacedResult( TreeNode treenode, TestResult testresult, TestResult testresult1, int i );

        public abstract void removedBranch( TreeNode treenode, int i );

        public abstract void removedResult( TreeNode treenode, TestResult testresult, int i );

        public abstract void countersInvalidated( TreeNode treenode );
    }

    public static interface TreeObserver {

        public abstract void nodeInserted( TreeNode atreenode[], Object obj, int i );

        public abstract void nodeChanged( TreeNode atreenode[], Object obj, int i, Object obj1 );

        public abstract void nodeRemoved( TreeNode atreenode[], Object obj, int i );
    }

    public static interface Observer {

        public abstract void update( TestResult testresult, TestResult testresult1 );

        public abstract void updated( TestResult testresult );
    }

    @SuppressWarnings( "unchecked" )
    public TestResultTable( ) {

        observers = new Observer[0];
        treeObservers = new TreeObserver[0];
        updater = new Updater( );
        testsInUpdate = new Vector<TestResult>( );
        statusTables = new Hashtable[4];
        for ( int i = 0; i < statusTables.length; i++ ) {
            statusTables[i] = new Hashtable( );
        }

        root = new TRT_TreeNode( this, null );
    }

    public TestResultTable( WorkDirectory workdirectory ) {

        this( workdirectory, workdirectory.getTestSuite( ).getTestFinder( ) );
    }

    public TestResultTable( WorkDirectory workdirectory, TestFinder testfinder ) {

        this( );
        workDir = workdirectory;
        finder = testfinder;
        initFinder( );
        if ( debug ) {
            Debug.println( "TRT(tf) workdir=" + workdirectory.getPath( ) );
        }
        try {
            trCache = new TestResultCache( workdirectory );
            trCache.setObserver( updater );
        } catch ( TestResultCache.Fault fault ) {
            if ( debug ) {
                fault.printStackTrace( Debug.getWriter( ) );
            }
            throw new JavaTestError( i18n, "trt.trcCreate", fault );
        }
    }

    public void setTestFinder( TestFinder testfinder ) {

        if ( finder != null ) {
            throw new IllegalStateException( i18n.getString( "trt.alreadyFinder" ) );
        }
        finder = testfinder;
        if ( trCache == null ) {
            initFinder( );
        }
    }

    public WorkDirectory getWorkDir( ) {

        return workDir;
    }

    public int getCurrentTestCount( ) {

        return root.getCurrentSize( );
    }

    void starting( ) {

    }

    void finished( ) {

        try {
            if ( trCache != null ) {
                if ( debug ) {
                    Debug.print( "TRT.finished(), attempting cache compress..." );
                }
                trCache.compress( );
            }
        } catch ( TestResultCache.Fault fault ) {
            if ( debug ) {
                if ( fault.getOriginalFault( ) != null ) {
                    fault.getOriginalFault( ).printStackTrace( Debug.getWriter( ) );
                } else {
                    fault.printStackTrace( Debug.getWriter( ) );
                }
            }
            throw new JavaTestError( i18n, "trt.trcCreate", fault );
        } catch ( IOException ioexception ) {
            if ( debug ) {
                ioexception.printStackTrace( Debug.getWriter( ) );
            }
            throw new JavaTestError( i18n, "trt.trcCreate", ioexception );
        }
    }

    public void update( TestResult testresult ) {

        TestResult testresult1 = insert( testresult );
        if ( testresult != testresult1 ) {
            testresult.shareStatus( statusTables );
            for ( int i = 0; i < observers.length; i++ ) {
                observers[i].update( testresult1, testresult );
            }

        } else {
            for ( int j = 0; j < observers.length; j++ ) {
                observers[j].updated( testresult );
            }

        }
        try {
            testsInUpdate.add( testresult );
            if ( trCache != null && testresult.getStatus( ).getType( ) != 3 ) {
                trCache.add( testresult );
            }
            testsInUpdate.remove( testresult );
        } catch ( TestResultCache.Fault fault ) {
            if ( debug ) {
                fault.printStackTrace( Debug.getWriter( ) );
            }
            throw new JavaTestError( i18n, "trt.trcFault", fault );
        }
    }

    public synchronized void waitUntilReady( ) {

        while ( isUpdateInProgress ) {
            try {
                wait( 3000L );
            } catch ( InterruptedException interruptedexception ) {
                if ( debug ) {
                    interruptedexception.printStackTrace( Debug.getWriter( ) );
                }
            }
        }
    }

    public synchronized boolean isReady( ) {

        return !isUpdateInProgress;
    }

    public TestResult lookup( TestDescription testdescription ) {

        return lookup( TestResult.getWorkRelativePath( testdescription.getRootRelativeURL( ) ) );
    }

    public TestResult lookup( String s ) {

        if ( root == null ) {
            return null;
        } else {
            return findTest( root, s, s );
        }
    }

    public boolean validatePath( String s ) {

        if ( s == null ) {
            return false;
        }
        Object aobj[] = lookupInitURL( root, s );
        return aobj != null && aobj.length > 0;
    }

    public static TreeNode[] getObjectPath( TestResult testresult ) {

        if ( testresult == null ) {
            return null;
        }
        Vector<TreeNode> vector = new Vector<TreeNode>( );
        for ( TreeNode treenode = testresult.getParent( ); treenode != null; treenode = treenode.getParent( ) ) {
            vector.insertElementAt( treenode, 0 );
        }

        TreeNode atreenode[] = new TreeNode[vector.size( )];
        vector.copyInto( atreenode );
        if ( debug ) {
            Debug.println( "TRT - getObjectPath() results:" );
            Debug.println( "   -> target: " + testresult.getTestName( ) );
            Debug.println( "   -> resulting path length: " + atreenode.length );
        }
        if ( atreenode.length == 0 ) {
            return null;
        } else {
            return atreenode;
        }
    }

    public static TreeNode[] getObjectPath( TreeNode treenode ) {

        if ( treenode == null ) {
            return null;
        }
        Vector<TreeNode> vector = new Vector<TreeNode>( );
        for ( TreeNode treenode1 = treenode; treenode1 != null; treenode1 = treenode1.getParent( ) ) {
            vector.insertElementAt( treenode1, 0 );
        }

        TreeNode atreenode[] = new TreeNode[vector.size( )];
        vector.copyInto( atreenode );
        if ( debug ) {
            Debug.println( "TRT - getObjectPath() results:" );
            Debug.println( "   -> target RRP: " + getRootRelativePath( treenode ) );
            Debug.println( "   -> resulting path length: " + atreenode.length );
        }
        return atreenode;
    }

    public TreeIterator<TestResult> getIterator( ) {

        if ( root == null ) {
            return NullEnum.getInstance( );
        } else {
            return getIterator( root );
        }
    }

    public Enumeration<TestResult> elements( ) {

        return getIterator( );
    }

    public TreeIterator<TestResult> getIterator( TestFilter atestfilter[] ) {

        if ( root == null ) {
            return NullEnum.getInstance( );
        } else {
            return getIterator( root, atestfilter );
        }
    }

    public Enumeration<TestResult> elements( TestFilter atestfilter[] ) {

        return getIterator( atestfilter );
    }

    public static TreeIterator<TestResult> getIterator( TreeNode treenode ) {

        if ( treenode == null ) {
            return NullEnum.getInstance( );
        } else {
            return new TRT_Iterator( treenode );
        }
    }

    public static Enumeration<TestResult> elements( TreeNode treenode ) {

        return getIterator( treenode );
    }

    public static TreeIterator<TestResult> getIterator( TreeNode treenode, TestFilter testfilter ) {

        if ( treenode == null ) {
            return NullEnum.getInstance( );
        } else {
            TestFilter atestfilter[] = { testfilter };
            return new TRT_Iterator( treenode, atestfilter );
        }
    }

    public static Enumeration<TestResult> elements( TreeNode treenode, TestFilter testfilter ) {

        return getIterator( treenode, testfilter );
    }

    public static TreeIterator<TestResult> getIterator( TreeNode treenode, TestFilter atestfilter[] ) {

        if ( treenode == null ) {
            return NullEnum.getInstance( );
        } else {
            return new TRT_Iterator( treenode, atestfilter );
        }
    }

    public static Enumeration<TestResult> elements( TreeNode treenode, TestFilter atestfilter[] ) {

        return getIterator( treenode, atestfilter );
    }

    public Enumeration<TestResult> elements( String s, TestFilter atestfilter[] ) {

        if ( s == null ) {
            return NullEnum.getInstance( );
        } else {
            String as[] = { s };
            return elements( as, atestfilter );
        }
    }

    public TreeIterator<TestResult> getIterator( File afile[], TestFilter atestfilter[] ) throws Fault {

        String as[] = preProcessInitFiles( afile );
        if ( as != null && as.length > 0 ) {
            return getIterator( as, atestfilter );
        } else {
            return getIterator( atestfilter );
        }
    }

    public Enumeration<TestResult> elements( File afile[], TestFilter atestfilter[] ) throws Fault {

        return getIterator( afile, atestfilter );
    }

    public TreeIterator<TestResult> getIterator( String as[], TestFilter atestfilter[] ) {

        TreeNode atreenode[] = new TreeNode[0];
        TestResult atestresult[] = new TestResult[0];
        for ( int i = 0; i < as.length; i++ ) {
            Object aobj[] = lookupInitURL( root, as[i] );
            if ( debug ) {
                Debug.println( "TRT.lookupInitURL gave back " + aobj );
            }
            if ( aobj != null ) {
                if ( aobj instanceof TreeNode[] ) {
                    atreenode = (TreeNode[]) DynamicArray.append( atreenode, aobj[0] );
                } else if ( aobj instanceof TestResult[] ) {
                    TestResult atestresult1[] = new TestResult[aobj.length + atestresult.length];
                    System.arraycopy( atestresult, 0, atestresult1, 0, atestresult.length );
                    System.arraycopy( aobj, 0, atestresult1, atestresult.length, aobj.length );
                    atestresult = atestresult1;
                } else {
                    throw new IllegalArgumentException( i18n.getString( "trt.invalidIURL", as[i] ) );
                }
            }
        }

        if ( atreenode.length == 0 && atestresult.length == 0 ) {
            if ( debug ) {
                Debug.println( "None of the initial URLs could be looked up." );
            }
            return NullEnum.getInstance( );
        }
        if ( atestresult.length > 0 ) {
            if ( debug ) {
                Debug.println( "Using combo TreeIterator, " + atestresult.length + " tests, " + atreenode.length + " nodes." );
            }
            return new TRT_Iterator( atreenode, atestresult, atestfilter );
        } else {
            return new TRT_Iterator( atreenode, atestfilter );
        }
    }

    public Enumeration<TestResult> elements( String as[], TestFilter atestfilter[] ) {

        return getIterator( as, atestfilter );
    }

    public int size( ) {

        if ( root == null ) {
            return 0;
        } else {
            return root.getSize( );
        }
    }

    TestResult insert( TestResult testresult ) {

        if ( testresult == null ) {
            return null;
        } else {
            String s = testresult.getWorkRelativePath( );
            TRT_TreeNode atrt_treenode[] = new TRT_TreeNode[0];
            return insert( root, s, testresult, atrt_treenode );
        }
    }

    public TreeNode getRoot( ) {

        return root;
    }

    public File getTestSuiteRoot( ) {

        return suiteRoot;
    }

    public TestFinder getTestFinder( ) {

        return finder;
    }

    public static String getRootRelativePath( TreeNode treenode ) {

        if ( treenode.isRoot( ) ) {
            return "";
        }
        StringBuffer stringbuffer = new StringBuffer( treenode.getName( ) );
        for ( treenode = treenode.getParent( ); treenode != null && !treenode.isRoot( ); treenode = treenode.getParent( ) ) {
            stringbuffer.insert( 0, '/' );
            stringbuffer.insert( 0, treenode.getName( ) );
        }

        return stringbuffer.toString( );
    }

    public static TreeNode findNode( TreeNode treenode, String s ) {

        if ( treenode == null ) {
            throw new IllegalArgumentException( i18n.getString( "trt.nodeNull" ) );
        }
        if ( s == null ) {
            throw new IllegalArgumentException( i18n.getString( "trt.pathNull" ) );
        }
        String s1 = getDirName( s );
        Object obj = null;
        if ( debug ) {
            Debug.println( "TRT.findNode() looking for " + s + " in " + treenode.getName( ) );
        }
        if ( s1 == s ) {
            obj = ( (TRT_TreeNode) treenode ).getTreeNode( s );
        } else {
            TRT_TreeNode trt_treenode = ( (TRT_TreeNode) treenode ).getTreeNode( s1 );
            if ( trt_treenode != null ) {
                obj = findNode( trt_treenode, behead( s ) );
            }
        }
        return ( (TreeNode) ( obj ) );
    }

    public void addObserver( Observer observer ) {

        observers = (Observer[]) DynamicArray.append( observers, observer );
    }

    public void removeObserver( Observer observer ) {

        observers = (Observer[]) DynamicArray.remove( observers, observer );
    }

    public void addObserver( TreeObserver treeobserver ) {

        treeObservers = (TreeObserver[]) DynamicArray.append( treeObservers, treeobserver );
    }

    public void removeObserver( TreeObserver treeobserver ) {

        if ( observers == null ) {
            return;
        } else {
            treeObservers = (TreeObserver[]) DynamicArray.remove( treeObservers, treeobserver );
            return;
        }
    }

    private synchronized void update( Set<TestResult> set ) {

        TestResult testresult;
        for ( Iterator<TestResult> iterator = set.iterator( ); iterator.hasNext( ); update( testresult ) ) {
            testresult = iterator.next( );
        }

    }

    synchronized TestResult insert( TRT_TreeNode trt_treenode, String s, TestResult testresult, TRT_TreeNode atrt_treenode[] ) {

        if ( debug ) {
            Debug.println( "TRT Beginning insert " + s );
        }
        String s1 = behead( s );
        if ( s == s1 ) {
            TestResult testresult1 = trt_treenode.addChild( testresult );
            atrt_treenode = (TRT_TreeNode[]) DynamicArray.append( atrt_treenode, trt_treenode );
            if ( testresult1 == null ) {
                if ( debug ) {
                    Debug.println( "   => Inserted TR: " + testresult.getTestName( ) );
                    Debug.println( "   => Test Ref: " + testresult );
                    Debug.println( "   => Status is: " + Status.typeToString( testresult.getStatus( ).getType( ) ) );
                    Debug.println( "   => TRT: " + this );
                    Debug.println( "   => Node Ref: " + trt_treenode );
                    Debug.println( "   => Node path: " + getRootRelativePath( trt_treenode ) );
                    Debug.println( "   => Index in node: " + trt_treenode.getIndex( testresult ) );
                }
                notifyNewLeaf( atrt_treenode, testresult, trt_treenode.getIndex( testresult ) );
            } else {
                int i = trt_treenode.getIndex( testresult );
                if ( debug ) {
                    Debug.println( "   => Updated TR: " + testresult.getTestName( ) );
                    Debug.println( "   => Test Ref: " + testresult );
                    Debug.println( "   => Status is: " + Status.typeToString( testresult.getStatus( ).getType( ) ) );
                    Debug.println( "   => TRT: " + this );
                    Debug.println( "   => Node Ref: " + trt_treenode );
                    Debug.println( "   => Node path: " + getRootRelativePath( trt_treenode ) );
                    Debug.println( "   => Index in node: " + i );
                }
                if ( i != -1 ) {
                    if ( testresult1 != testresult ) {
                        notifyRemoveLeaf( atrt_treenode, testresult1, i );
                        notifyNewLeaf( atrt_treenode, testresult, i );
                    } else {
                        notifyChangeLeaf( atrt_treenode, testresult, i, testresult1 );
                    }
                }
            }
            return testresult1;
        }
        String s2 = getDirName( s );
        TRT_TreeNode trt_treenode1 = trt_treenode.getTreeNode( s2 );
        if ( trt_treenode1 == null ) {
            TRT_TreeNode trt_treenode2 = new TRT_TreeNode( this, trt_treenode );
            trt_treenode2.setName( getDirName( s2 ) );
            trt_treenode.addChild( trt_treenode2 );
            atrt_treenode = (TRT_TreeNode[]) DynamicArray.append( atrt_treenode, trt_treenode2 );
            notifyNewBranch( atrt_treenode, trt_treenode2, trt_treenode.getIndex( trt_treenode2 ) );
            return insert( trt_treenode2, s1, testresult, atrt_treenode );
        } else {
            atrt_treenode = (TRT_TreeNode[]) DynamicArray.append( atrt_treenode, trt_treenode );
            return insert( trt_treenode1, s1, testresult, atrt_treenode );
        }
    }

    public synchronized TestResult resetTest( TestResult testresult ) {

        TestResult testresult1 = null;
        workDir.log( i18n, "trt.rstTest", testresult.getTestName( ) );
        TreeNode atreenode[] = getObjectPath( testresult );
        if ( atreenode == null ) {
            testresult1 = lookup( testresult.getWorkRelativePath( ) );
            if ( debug ) {
                Debug.println( "Recovered test by replacement (1). " + testresult1 );
            }
        } else {
            TRT_TreeNode trt_treenode = (TRT_TreeNode) atreenode[atreenode.length - 1];
            int i = trt_treenode.getIndex( testresult );
            if ( i >= 0 ) {
                testresult1 = trt_treenode.resetTest( i, testresult );
                if ( testresult1 == null && debug ) {
                    Debug.println( "reset of test " + testresult.getTestName( ) + " failed." );
                } else {
                    try {
                        if ( trCache != null ) {
                            testsInUpdate.add( testresult1 );
                            trCache.add( testresult1 );
                            testsInUpdate.remove( testresult1 );
                            notifyRemoveLeaf( atreenode, testresult, i );
                            notifyNewLeaf( atreenode, testresult, i );
                        }
                    } catch ( TestResultCache.Fault fault ) {
                        if ( debug ) {
                            fault.printStackTrace( Debug.getWriter( ) );
                        }
                        throw new JavaTestError( i18n, "trt.trcFault", fault );
                    }
                }
            } else {
                testresult1 = lookup( testresult.getWorkRelativePath( ) );
                if ( debug ) {
                    Debug.println( "Recovered test by replacement (2). " + testresult1 );
                }
            }
        }
        return testresult1;
    }

    public synchronized TestResult resetTest( String s ) {

        TestResult testresult = findTest( root, s, s );
        if ( testresult == null ) {
            return null;
        } else {
            return resetTest( testresult );
        }
    }

    private void notifyNewBranch( TreeNode atreenode[], TreeNode treenode, int i ) {

        if ( treeObservers == null ) {
            return;
        }
        for ( int j = 0; j < treeObservers.length; j++ ) {
            treeObservers[j].nodeInserted( atreenode, treenode, i );
        }

    }

    private void notifyNewLeaf( TreeNode atreenode[], TestResult testresult, int i ) {

        if ( treeObservers == null ) {
            return;
        }
        for ( int j = 0; j < treeObservers.length; j++ ) {
            treeObservers[j].nodeInserted( atreenode, testresult, i );
        }

    }

    private void notifyChangeLeaf( TreeNode atreenode[], TestResult testresult, int i, TestResult testresult1 ) {

        if ( treeObservers == null ) {
            return;
        }
        for ( int j = 0; j < treeObservers.length; j++ ) {
            treeObservers[j].nodeChanged( atreenode, testresult, i, testresult1 );
        }

    }

    private void notifyRemoveLeaf( TreeNode atreenode[], TestResult testresult, int i ) {

        if ( treeObservers == null ) {
            return;
        }
        for ( int j = 0; j < treeObservers.length; j++ ) {
            treeObservers[j].nodeRemoved( atreenode, testresult, i );
        }

    }

    private String[] preProcessInitFiles( File afile[] ) throws Fault {

        if ( afile == null || afile.length == 0 ) {
            if ( debug ) {
                Debug.println( "Initial files set empty." );
            }
            return null;
        }
        if ( debug ) {
            Debug.println( "Initial files: " );
            for ( int i = 0; i < afile.length; i++ ) {
                Debug.println( "  + " + afile[i].getPath( ) );
            }

        }
        String as[] = new String[afile.length];
        int j = as.length;
        int k = getWorkDir( ) != null ? finder.getRootDir( ).getAbsolutePath( ).length( ) + 1 : 0;
        for ( int l = 0; l < afile.length; l++ ) {
            if ( debug ) {
                Debug.println( " *** init url resolve begin ***" );
            }
            if ( finder.getRootDir( ).equals( afile[l] ) ) {
                j--;
                if ( debug ) {
                    Debug.println( "An initial URL equals testsuite root, ignoring it." );
                }
            } else {
                String s;
                if ( afile[l].isAbsolute( ) ) {
                    String s1 = getRootRelativePath( getRoot( ) );
                    if ( debug ) {
                        Debug.println( "  -> Initial URL is absolute, stripping from " + afile[l].getPath( ) );
                        Debug.println( "  -> Stripping: " + finder.getRootDir( ) );
                        Debug.println( "  -> removing rrp: " + s1 );
                    }
                    String s2 = afile[l].getPath( );
                    if ( !s2.startsWith( finder.getRootDir( ).getPath( ) ) ) {
                        throw new Fault( i18n, "trt.badInitFile", s2 );
                    }
                    k += s1 != null && s1.length( ) != 0 ? s1.length( ) + 1 : 0;
                    String s3 = s2.substring( k );
                    s = s3.replace( File.separatorChar, '/' );
                } else {
                    s = afile[l].getPath( ).replace( File.separatorChar, '/' );
                }
                as[l] = s;
            }
        }

        if ( j != afile.length ) {
            String as1[] = new String[j];
            System.arraycopy( as, 0, as1, 0, j );
            as = as1;
        }
        if ( debug ) {
            Debug.println( "*** finished preprocessing of init urls ***" );
        }
        return as;
    }

    private static TestResult findTest( TRT_TreeNode trt_treenode, String s, String s1 ) {

        trt_treenode.scanIfNeeded( );
        if ( debug ) {
            Debug.println( "TRT looking for " + s1 + " IN " + trt_treenode.getName( ) );
        }
        String s2 = getDirName( s1 );
        TestResult testresult = null;
        if ( s2 == s1 ) {
            if ( debug ) {
                Debug.println( "    -> Looking for TR in this node." );
            }
            int i = trt_treenode.getResultIndex( s );
            if ( i != -1 ) {
                testresult = (TestResult) trt_treenode.getChild( i );
                if ( debug ) {
                    Debug.println( "    -> TRT.findTest() located " + testresult );
                    Debug.println( "" );
                }
            } else if ( debug ) {
                Debug.println( "    -> TRT.findTest(): unable to find node " + s );
                Debug.println( "" );
            }
        } else {
            if ( debug ) {
                Debug.println( "    -> Looking for branch name: " + s2 );
            }
            TRT_TreeNode trt_treenode1 = trt_treenode.getTreeNode( s2 );
            if ( trt_treenode1 != null ) {
                testresult = findTest( trt_treenode1, s, behead( s1 ) );
            } else if ( debug ) {
                Debug.println( "TRT.findTest(): unable to find node " + s );
            }
        }
        return testresult;
    }

    private static Object[] lookupInitURL( TreeNode treenode, String s ) {

        if ( treenode == null || s == null ) {
            throw new IllegalArgumentException( "Starting node or URL may not be null!" );
        }
        TreeNode treenode1 = findNode( treenode, s );
        if ( treenode1 != null ) {
            TreeNode atreenode[] = new TreeNode[1];
            atreenode[0] = treenode1;
            return atreenode;
        }
        String s1 = TestResult.getWorkRelativePath( s );
        TestResult testresult = findTest( (TRT_TreeNode) treenode, s1, s1 );
        if ( testresult != null ) {
            TestResult atestresult[] = new TestResult[1];
            atestresult[0] = testresult;
            return atestresult;
        }
        if ( debug ) {
            Debug.println( "TRT looking for tests beginning with " + s + " IN " + treenode.getName( ) );
            Debug.println( "   -> retrieving possible TRs from " + betail( s ) );
        }
        treenode1 = findNode( treenode, betail( s ) );
        if ( treenode1 == null ) {
            if ( debug ) {
                Debug.println( "   -> No parent node found!" );
            }
            return null;
        }
        TestResult atestresult1[] = treenode1.getTestResults( );
        if ( atestresult1 == null || atestresult1.length == 0 ) {
            return null;
        }
        Vector<TestResult> vector = new Vector<TestResult>( );
        try {
            for ( int i = 0; i < atestresult1.length; i++ ) {
                if ( atestresult1[i].getDescription( ).getRootRelativeURL( ).startsWith( s ) ) {
                    vector.addElement( atestresult1[i] );
                }
            }

        } catch ( TestResult.Fault fault ) {
            throw new JavaTestError( i18n, "trt.trNoTd", fault );
        }
        if ( vector.size( ) > 0 ) {
            atestresult1 = new TestResult[vector.size( )];
            vector.copyInto( atestresult1 );
        } else {
            atestresult1 = null;
        }
        return atestresult1;
    }

    private void initFinder( ) {

        if ( debug ) {
            Debug.println( "TF=" + finder );
        }
        suiteRoot = finder.getRoot( );
        if ( debug ) {
            Debug.println( "TRT(tf) root file =" + suiteRoot.getPath( ) );
        }
    }

    @Override
    protected void finalize( ) throws Throwable {

        super.finalize( );
        RootRegistry.getInstance( ).removeHandler( httpHandle );
        RootRegistry.unassociateObject( this, httpHandle );
        httpHandle = null;
    }

    static String behead( String s ) {

        int i = s.indexOf( "/" );
        if ( i == -1 ) {
            return s;
        } else {
            return s.substring( i + 1 );
        }
    }

    static String getDirName( String s ) {

        int i = s.indexOf( '/' );
        if ( i == -1 ) {
            return s;
        } else {
            return s.substring( 0, i );
        }
    }

    static String betail( String s ) {

        int i = s.lastIndexOf( '/' );
        if ( i == -1 ) {
            return s;
        } else {
            return s.substring( 0, i );
        }
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    private Hashtable<String, Status> statusTables[];

    private WorkDirectory workDir;

    private TestFinder finder;

    private Observer observers[];

    private JThttpProvider httpHandle;

    private TreeObserver treeObservers[];

    private TestResultCache trCache;

    private Updater updater;

    private volatile boolean isUpdateInProgress;

    private Vector<TestResult> testsInUpdate;

    private TRT_TreeNode root;

    private File suiteRoot;

    private static I18NResourceBundle i18n;

    static final Status notYetRun = Status.notRun( "test is awaiting execution" );

    private static boolean debug;

    static {
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.javatest.TestResultTable.class );
        debug = Debug.getBoolean( com.sap.tc.moin.repository.test.jmitck.javatest.TestResultTable.class );
    }

}
