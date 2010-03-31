// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: TRT_Iterator.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Vector;

import com.sap.tc.moin.repository.test.jmitck.javatest.TestResultTable.TreeIterator;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.Debug;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.DynamicArray;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

// Referenced classes of package com.sun.javatest:
// TestResult, TestFilter, TestResultTable, TestDescription,
// Status

@SuppressWarnings( "nls" )
class TRT_Iterator implements TreeIterator<TestResult> {

    private static class PseudoFrame {

        int nextIndex( ) {

            if ( ++currIndex < node.getChildCount( ) ) {
                return currIndex;
            } else {
                return -1;
            }
        }

        TestResultTable.TreeNode getNode( ) {

            return node;
        }

        private int currIndex;

        private TestResultTable.TreeNode node;

        PseudoFrame( TestResultTable.TreeNode treenode ) {

            node = treenode;
            currIndex = -1;
        }
    }

    protected TRT_Iterator( ) {

        outQueueLock = new Object( );
        finished = false;
        debug = Debug.getBoolean( TRT_Iterator.class );
        outQueue = new LinkedList<TestResult>( );
        resultStats = new int[4];
        nodeIndex = -1;
        currFrame = null;
    }

    TRT_Iterator( TestResultTable.TreeNode treenode ) {

        this( );
        nodes = new TestResultTable.TreeNode[1];
        nodes[0] = treenode;
        init( nodes );
        if ( debug ) {
            Debug.println( "Created TreeIterator without filters, one initial node." );
        }
    }

    TRT_Iterator( TestResultTable.TreeNode treenode, TestFilter atestfilter[] ) {

        this( );
        filters = atestfilter;
        nodes = new TestResultTable.TreeNode[1];
        nodes[0] = treenode;
        init( nodes );
        if ( debug ) {
            Debug.println( "Created TreeIterator with filters and one initial node." );
        }
    }

    TRT_Iterator( TestResultTable.TreeNode atreenode[], TestFilter atestfilter[] ) {

        this( );
        filters = atestfilter;
        if ( atreenode != null ) {
            nodes = new TestResultTable.TreeNode[atreenode.length];
            System.arraycopy( atreenode, 0, nodes, 0, atreenode.length );
        }
        init( nodes );
        if ( debug ) {
            Debug.println( "Created TreeIterator with filters and initial nodes." );
        }
    }

    TRT_Iterator( TestResultTable.TreeNode atreenode[], TestResult atestresult[], TestFilter atestfilter[] ) {

        this( );
        filters = atestfilter;
        if ( atestresult != null && atestresult.length != 0 ) {
            for ( int i = 0; i < atestresult.length; i++ ) {
                outQueue.addLast( atestresult[i] );
            }

            try {
                Vector<String> vector = new Vector<String>( );
                for ( int j = 0; j < atestresult.length; j++ ) {
                    vector.add( atestresult[j].getDescription( ).getRootRelativeURL( ) );
                }

                initialTests = new String[vector.size( )];
                vector.copyInto( initialTests );
            } catch ( TestResult.Fault fault ) {
            }
        }
        if ( atreenode != null ) {
            nodes = new TestResultTable.TreeNode[atreenode.length];
            System.arraycopy( atreenode, 0, nodes, 0, atreenode.length );
        }
        init( nodes );
        if ( debug ) {
            Debug.println( "Created TreeIterator with filters, nodes and initial TR set." );
        }
    }

    public boolean hasMoreElements( ) {

        return !finished;
    }

    public TestResult nextElement( ) {

        if ( hasMoreElements( ) ) {
            TestResult testresult;
            synchronized ( outQueueLock ) {
                testresult = outQueue.removeFirst( );
            }
            findNext( );
            resultStats[testresult.getStatus( ).getType( )]++;
            return testresult;
        } else {
            throw new NoSuchElementException( i18n.getString( "trt.noElements" ) );
        }
    }

    public boolean hasNext( ) {

        return hasMoreElements( );
    }

    public TestResult next( ) {

        return nextElement( );
    }

    public void remove( ) {

        throw new UnsupportedOperationException( "Cannot remove from TestResultTable thhrough interator.  Do not call this method." );
    }

    public int[] getResultStats( ) {

        int ai[] = new int[resultStats.length];
        System.arraycopy( resultStats, 0, ai, 0, resultStats.length );
        return ai;
    }

    public TestResult[][] getFilterStats( ) {

        if ( filteredTRs == null ) {
            return null;
        }
        TestResult atestresult[][] = new TestResult[filters.length][0];
        for ( int i = 0; i < filters.length; i++ ) {
            if ( filteredTRs[i].length != 0 ) {
                TestResult atestresult1[] = new TestResult[filteredTRs[i].length];
                System.arraycopy( filteredTRs[i], 0, atestresult1, 0, filteredTRs[i].length );
                atestresult[i] = atestresult1;
            }
        }

        return atestresult;
    }

    public TestFilter[] getFilters( ) {

        if ( filters == null || filters.length == 0 ) {
            return null;
        } else {
            TestFilter atestfilter[] = new TestFilter[filters.length];
            System.arraycopy( filters, 0, atestfilter, 0, filters.length );
            return atestfilter;
        }
    }

    public String[] getInitialURLs( ) {

        String as[] = null;
        Vector<String> vector = new Vector<String>( );
        if ( nodes != null ) {
            for ( int i = 0; i < nodes.length; i++ ) {
                vector.addElement( TestResultTable.getRootRelativePath( nodes[i] ) );
            }

        }
        if ( initialTests != null ) {
            for ( int j = 0; j < initialTests.length; j++ ) {
                vector.add( initialTests[j] );
            }

        }
        if ( vector.size( ) > 0 ) {
            as = new String[vector.size( )];
            vector.copyInto( as );
        }
        return as;
    }

    private void init( TestResultTable.TreeNode atreenode[] ) {

        if ( atreenode != null && atreenode.length == 0 ) {
            nodes = null;
        } else {
            nodes = atreenode;
        }
        boolean flag = nextNode( );
        if ( flag ) {
            findNext( );
        } else if ( outQueue.size( ) == 0 ) {
            finished = true;
        }
    }

    private synchronized void findNext( ) {

        boolean flag = false;
        if ( finished ) {
            return;
        }
        while ( !flag ) {
            if ( currFrame == null ) {
                synchronized ( outQueueLock ) {
                    if ( outQueue.size( ) == 0 ) {
                        finished = true;
                    }
                }
                return;
            }
            int i = currFrame.nextIndex( );
            if ( i == -1 ) {
                nextFrame( );
                continue;
            }
            Object obj1 = currFrame.getNode( ).getChild( i );
            if ( obj1 == null ) {
                nextFrame( );
                continue;
            }
            if ( obj1 instanceof TestResultTable.TreeNode ) {
                TestResultTable.TreeNode treenode = (TestResultTable.TreeNode) obj1;
                push( currFrame );
                currFrame = new PseudoFrame( treenode );
                continue;
            }
            TestResult testresult = (TestResult) obj1;
            try {
                int j = wouldAccept( testresult );
                if ( j >= 0 ) {
                    registerReject( testresult, j );
                    continue;
                }
            } catch ( TestResult.Fault fault ) {
                if ( debug ) {
                    fault.printStackTrace( Debug.getWriter( ) );
                }
                continue;
            } catch ( TestFilter.Fault fault1 ) {
                if ( debug ) {
                    fault1.printStackTrace( Debug.getWriter( ) );
                }
                continue;
            }
            synchronized ( outQueueLock ) {
                outQueue.addLast( testresult );
            }
            flag = true;
        }
    }

    private boolean nextNode( ) {

        stack = new Stack<PseudoFrame>( );
        currFrame = null;
        if ( nodes != null && ++nodeIndex < nodes.length ) {
            TestResultTable.TreeNode treenode = nodes[nodeIndex];
            currFrame = new PseudoFrame( treenode );
            return true;
        } else {
            return false;
        }
    }

    private void push( PseudoFrame pseudoframe ) {

        stack.push( pseudoframe );
    }

    private PseudoFrame pop( ) {

        if ( !stack.empty( ) ) {
            return stack.pop( );
        } else {
            return null;
        }
    }

    private void nextFrame( ) {

        currFrame = pop( );
        if ( currFrame == null ) {
            nextNode( );
        }
    }

    private int wouldAccept( TestResult testresult ) throws TestFilter.Fault, TestResult.Fault {

        if ( filters == null || filters.length == 0 ) {
            return -1;
        }
        if ( debug ) {
            Debug.println( "Enum checking filter for: " + testresult.getWorkRelativePath( ) );
        }
        for ( int i = 0; i < filters.length; i++ ) {
            if ( !filters[i].accepts( testresult.getDescription( ) ) ) {
                if ( debug ) {
                    Debug.println( "   -> Rejected by: " + filters[i] );
                    Debug.println( "   -> Test Status: " + testresult.getStatus( ).getType( ) );
                }
                return i;
            }
        }

        return -1;
    }

    private void registerReject( TestResult testresult, int i ) {

        if ( filteredTRs == null ) {
            filteredTRs = new TestResult[filters.length][0];
        }
        filteredTRs[i] = (TestResult[]) DynamicArray.append( filteredTRs[i], testresult );
    }

    private String initialTests[];

    private Object outQueueLock;

    private LinkedList<TestResult> outQueue;

    private TestResultTable.TreeNode nodes[];

    private int nodeIndex;

    private TestFilter filters[];

    private int resultStats[];

    private TestResult filteredTRs[][];

    private Stack<PseudoFrame> stack;

    private PseudoFrame currFrame;

    private boolean finished;

    private static I18NResourceBundle i18n;

    protected boolean debug;

    static {
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.javatest.TRT_Iterator.class );
    }
}
