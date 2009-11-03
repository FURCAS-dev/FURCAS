// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: TestResult.java

package com.sap.tc.moin.repository.test.jmitck.javatest;

import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.LINE_SEPARATOR;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import com.sap.tc.moin.repository.test.jmitck.javatest.TestEnvironment.Element;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.BackupPolicy;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.DynamicArray;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.Properties;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.PropertyArray;
import com.sap.tc.moin.repository.test.jmitck.javatest.util.StringArray;

// Referenced classes of package com.sun.javatest:
// JavaTestError, TestDescription, Status, WorkDirectory,
// TestEnvironment, TestResultTable

@SuppressWarnings( "nls" )
public class TestResult {

    private static interface OutputBuffer {

        public abstract String getName( );

        public abstract String getOutput( );

        public abstract PrintWriter getPrintWriter( );
    }

    public class Section {

        private class WritableOutputBuffer extends Writer implements OutputBuffer {

            public String getName( ) {

                return name;
            }

            public String getOutput( ) {

                return new String( output );
            }

            public PrintWriter getPrintWriter( ) {

                return pw;
            }

            @Override
            public void write( char ac[], int i, int j ) throws IOException {

                if ( output == null ) {
                    throw new IOException( "stream has been closed" );
                }
                int k = output.length( );
                output.append( ac, i, j );
                notifyUpdatedOutput( Section.this, name, k, k, ac, i, j );
                if ( output.length( ) > TestResult.maxOutputSize ) {
                    int l = ( TestResult.maxOutputSize * 2 ) / 3;
                    if ( overflowed ) {
                        String s = output.toString( );
                        output = new StringBuffer( s.substring( 0, overflowStart ) + s.substring( l ) );
                        notifyUpdatedOutput( Section.this, name, overflowStart, l, "" );
                    } else {
                        String s1 = "\n\n...\nOutput overflow:\nJavaTest has limited the test output to the text to that\nat the beginning and the end, so that you can see how the\ntest began, and how it completed.\n\nIf you need to see more of the output from the test,\nset the system property javatest.maxOutputSize to a higher\nvalue. The current value is "
                                    + TestResult.maxOutputSize + "\n...\n\n";
                        overflowStart = TestResult.maxOutputSize / 3;
                        String s2 = output.toString( );
                        output = new StringBuffer( s2.substring( 0, overflowStart ) + s1 + s2.substring( l ) );
                        notifyUpdatedOutput( Section.this, name, overflowStart, l, s1 );
                        overflowStart += s1.length( );
                        overflowed = true;
                    }
                }
            }

            @Override
            public void flush( ) {

            }

            @Override
            public void close( ) {

                makeOutputImmutable( this, name, new String( output ) );
                notifyCompletedOutput( Section.this, name );
            }

            private boolean overflowed;

            private int overflowStart;

            private final String name;

            private StringBuffer output;

            private final PrintWriter pw;

            WritableOutputBuffer( String s ) {

                if ( s == null ) {
                    throw new NullPointerException( );
                } else {
                    name = s;
                    output = new StringBuffer( );
                    pw = new PrintWriter( this );
                    return;
                }
            }
        }

        private class FixedOutputBuffer implements OutputBuffer {

            public String getName( ) {

                return name;
            }

            public String getOutput( ) {

                return output;
            }

            public PrintWriter getPrintWriter( ) {

                throw new IllegalStateException( "This section is immutable" );
            }

            private final String name;

            private final String output;

            FixedOutputBuffer( String s, String s1 ) {

                if ( s == null || s1 == null ) {
                    throw new NullPointerException( );
                } else {
                    name = s;
                    output = s1;
                    return;
                }
            }

            FixedOutputBuffer( String s, BufferedReader bufferedreader ) throws Fault {

                String s1 = extractSlice( s, "----------".length( ), null, ":" );
                if ( s1 == null ) {
                    throw new Fault( TestResult.i18n, "rslt.noOutputTitle" );
                }
                if ( s1.equals( "messages" ) ) {
                    s1 = "messages";
                }
                try {
                    int j;
                    boolean flag;
                    try {
                        int k = "----------".length( );
                        j = Integer.parseInt( extractSlice( s, k, "/", ")" ) );
                        int l = s.indexOf( ")", k );
                        if ( l >= 0 && l < s.length( ) - 2 ) {
                            flag = s.charAt( l + 1 ) == '*';
                        } else {
                            flag = false;
                        }
                    } catch ( NumberFormatException numberformatexception ) {
                        throw new Fault( TestResult.i18n, "rslt.badHeaderVersion", numberformatexception );
                    }
                    StringBuffer stringbuffer = new StringBuffer( j );
                    if ( flag ) {
                        for ( int i1 = 0; i1 < j; i1++ ) {
                            int k1 = bufferedreader.read( );
                            if ( k1 == -1 ) {
                                throw new Fault( TestResult.i18n, "rslt.badEOF" );
                            }
                            if ( k1 == 92 ) {
                                k1 = bufferedreader.read( );
                                i1++;
                                if ( k1 == 117 ) {
                                    k1 = Character.digit( (char) bufferedreader.read( ), 16 ) << 12;
                                    k1 += Character.digit( (char) bufferedreader.read( ), 16 ) << 8;
                                    k1 += Character.digit( (char) bufferedreader.read( ), 16 ) << 4;
                                    k1 += Character.digit( (char) bufferedreader.read( ), 16 );
                                    i1 += 4;
                                }
                            }
                            stringbuffer.append( (char) k1 );
                        }

                    } else {
                        char ac[] = new char[Math.min( 4096, j )];
                        int i2;
                        for ( int l1 = 0; l1 < j; l1 += i2 ) {
                            i2 = bufferedreader.read( ac, 0, Math.min( ac.length, j - l1 ) );
                            stringbuffer.append( ac, 0, i2 );
                        }

                    }
                    name = s1;
                    output = stringbuffer.toString( );
                    if ( stringbuffer.length( ) > 0 && stringbuffer.charAt( stringbuffer.length( ) - 1 ) != '\n' ) {
                        int j1 = bufferedreader.read( );
                        if ( j1 == 13 ) {
                            j1 = bufferedreader.read( );
                        }
                        if ( j1 != 10 ) {
                            throw new Fault( TestResult.i18n, "rslt.badChars", name );
                        }
                    }
                } catch ( IOException ioexception ) {
                    throw new Fault( TestResult.i18n, "rslt.badFile", ioexception );
                }
            }
        }

        public synchronized boolean isMutable( ) {

            return TestResult.this.isMutable( ) && result == TestResult.inProgress;
        }

        public synchronized Status getStatus( ) {

            return result;
        }

        public synchronized void setStatus( Status status ) {

            checkMutable( );
            for ( int i = 0; i < buffers.length; i++ ) {
                OutputBuffer outputbuffer = buffers[i];
                if ( outputbuffer instanceof WritableOutputBuffer ) {
                    WritableOutputBuffer writableoutputbuffer = (WritableOutputBuffer) outputbuffer;
                    writableoutputbuffer.getPrintWriter( ).close( );
                }
            }

            if ( env == null ) {
                env = TestResult.emptyStringArray;
            }
            result = status;
            if ( env == null ) {
                env = TestResult.emptyStringArray;
            }
            notifyCompletedSection( this );
        }

        public synchronized String getTitle( ) {

            return title;
        }

        public PrintWriter getMessageWriter( ) {

            checkMutable( );
            return buffers[0].getPrintWriter( );
        }

        public synchronized int getOutputCount( ) {

            return buffers.length;
        }

        public synchronized PrintWriter createOutput( String s ) {

            if ( s == null ) {
                throw new NullPointerException( );
            } else {
                checkMutable( );
                WritableOutputBuffer writableoutputbuffer = new WritableOutputBuffer( s );
                buffers = (OutputBuffer[]) DynamicArray.append( buffers, writableoutputbuffer );
                notifyCreatedOutput( this, s );
                return writableoutputbuffer.getPrintWriter( );
            }
        }

        public synchronized String getOutput( String s ) {

            if ( s == null ) {
                throw new NullPointerException( );
            } else {
                OutputBuffer outputbuffer = findOutputBuffer( s );
                return outputbuffer != null ? outputbuffer.getOutput( ) : null;
            }
        }

        public synchronized String[] getOutputNames( ) {

            String as[] = new String[buffers.length];
            for ( int i = 0; i < buffers.length; i++ ) {
                as[i] = buffers[i].getName( );
                if ( as[i] == null ) {
                    throw new IllegalStateException( "BUFFER IS BROKEN" );
                }
            }

            return as;
        }

        void save( Writer writer ) throws IOException {

            writer.write( "#section:" + getTitle( ) );
            writer.write( TestResult.lineSeparator );
            for ( int i = 0; i < buffers.length; i++ ) {
                String s = buffers[i].getOutput( );
                int j = 0;
                int k = 0;
                int l = 0;
                boolean flag = false;
                for ( int i1 = 0; i1 < s.length( ); i1++ ) {
                    char c = s.charAt( i1 );
                    if ( c < ' ' ) {
                        if ( c == '\n' ) {
                            j++;
                        } else if ( c != '\t' && c != '\r' ) {
                            l++;
                        }
                    } else if ( c < '\177' ) {
                        if ( c == '\\' ) {
                            k++;
                        }
                    } else {
                        l++;
                    }
                }

                boolean flag1 = k > 0 || l > 0;
                if ( s.length( ) != 0 && !s.endsWith( "\n" ) ) {
                    flag = true;
                    j++;
                }
                writer.write( "----------" );
                writer.write( buffers[i].getName( ) );
                writer.write( ":" );
                writer.write( 40 );
                writer.write( String.valueOf( j ) );
                writer.write( 47 );
                if ( flag1 ) {
                    writer.write( String.valueOf( s.length( ) + k + 5 * l ) );
                } else {
                    writer.write( String.valueOf( s.length( ) ) );
                }
                writer.write( 41 );
                if ( flag1 ) {
                    writer.write( 42 );
                }
                writer.write( "----------" );
                writer.write( TestResult.lineSeparator );
                if ( flag1 ) {
                    for ( int j1 = 0; j1 < s.length( ); j1++ ) {
                        char c1 = s.charAt( j1 );
                        if ( ' ' <= c1 && c1 < '\177' && c1 != '\\' ) {
                            writer.write( c1 );
                        } else {
                            switch ( c1 ) {
                                case 9: // '\t'
                                case 10: // '\n'
                                case 13: // '\r'
                                    writer.write( c1 );
                                    break;

                                case 92: // '\\'
                                    writer.write( "\\\\" );
                                    break;

                                default:
                                    writer.write( "\\u" );
                                    writer.write( Character.forDigit( c1 >> 12 & 0xf, 16 ) );
                                    writer.write( Character.forDigit( c1 >> 8 & 0xf, 16 ) );
                                    writer.write( Character.forDigit( c1 >> 4 & 0xf, 16 ) );
                                    writer.write( Character.forDigit( c1 >> 0 & 0xf, 16 ) );
                                    break;
                            }
                        }
                    }

                } else {
                    writer.write( s );
                }
                if ( flag ) {
                    writer.write( TestResult.lineSeparator );
                }
            }

            if ( getTitle( ) != "script_messages" ) {
                writer.write( "result: " + result.toString( ) );
                writer.write( TestResult.lineSeparator );
            }
            writer.write( TestResult.lineSeparator );
        }

        synchronized void reloadOutput( String s, String s1 ) {

            if ( s.equals( "messages" ) ) {
                s = "messages";
            }
            FixedOutputBuffer fixedoutputbuffer = new FixedOutputBuffer( s, s1 );
            buffers = (OutputBuffer[]) DynamicArray.append( buffers, fixedoutputbuffer );
        }

        synchronized void reloadStatus( Status status ) {

            result = status;
        }

        private void checkMutable( ) {

            if ( !isMutable( ) ) {
                throw new IllegalStateException( "This section of the test result is now immutable." );
            } else {
                return;
            }
        }

        private synchronized void makeOutputImmutable( OutputBuffer outputbuffer, String s, String s1 ) {

            for ( int i = 0; i < buffers.length; i++ ) {
                if ( buffers[i] == outputbuffer ) {
                    buffers[i] = new FixedOutputBuffer( s, s1 );
                    return;
                }
            }

        }

        private synchronized OutputBuffer findOutputBuffer( String s ) {

            for ( int i = buffers.length - 1; i >= 0; i-- ) {
                if ( s.equals( buffers[i].getName( ) ) ) {
                    return buffers[i];
                }
            }

            return null;
        }

        private OutputBuffer buffers[];

        private String title;

        private Status result;

        Section( String s ) {

            buffers = new OutputBuffer[0];
            if ( s == null ) {
                throw new NullPointerException( );
            }
            if ( s.indexOf( ' ' ) != -1 ) {
                throw new IllegalArgumentException( "space invalid in section title" );
            } else {
                title = s;
                result = TestResult.inProgress;
                return;
            }
        }

        Section( BufferedReader bufferedreader ) throws IOException, Fault {

            buffers = new OutputBuffer[0];
            for ( String s = bufferedreader.readLine( ); s != null; ) {
                if ( s.startsWith( "#section:" ) ) {
                    title = extractSlice( s, 0, ":", null );
                    s = null;
                } else {
                    s = bufferedreader.readLine( );
                }
            }

            if ( title.equals( "script_messages" ) ) {
                title = "script_messages";
            }
            if ( title == null ) {
                throw new Fault( TestResult.i18n, "rslt.noSectionTitle" );
            }
            String s1;
            while ( ( s1 = bufferedreader.readLine( ) ).startsWith( "----------" ) ) {
                FixedOutputBuffer fixedoutputbuffer = new FixedOutputBuffer( s1, bufferedreader );
                buffers = (OutputBuffer[]) DynamicArray.append( buffers, fixedoutputbuffer );
            }
            if ( title != "script_messages" ) {
                if ( s1.startsWith( "result: " ) ) {
                    result = Status.parse( s1.substring( "result: ".length( ) ) );
                } else {
                    throw new Fault( TestResult.i18n, "rslt.badLine", new Integer( s1 ) );
                }
                if ( result == null ) {
                    throw new Fault( TestResult.i18n, "rslt.noSectionResult" );
                }
            }
        }
    }

    public static interface Observer {

        public abstract void createdSection( TestResult testresult, Section section );

        public abstract void completedSection( TestResult testresult, Section section );

        public abstract void createdOutput( TestResult testresult, Section section, String s );

        public abstract void completedOutput( TestResult testresult, Section section, String s );

        public abstract void updatedOutput( TestResult testresult, Section section, String s, int i, int j, String s1 );

        public abstract void updatedProperty( TestResult testresult, String s, String s1 );

        public abstract void completed( TestResult testresult );
    }

    public static class ReloadFault extends Fault {

        private static final long serialVersionUID = 1L;

        ReloadFault( I18NResourceBundle i18nresourcebundle, String s ) {

            super( i18nresourcebundle, s );
        }

        ReloadFault( I18NResourceBundle i18nresourcebundle, String s, Object obj ) {

            super( i18nresourcebundle, s, obj );
        }

        ReloadFault( I18NResourceBundle i18nresourcebundle, String s, Object aobj[] ) {

            super( i18nresourcebundle, s, aobj );
        }
    }

    public static class ResultFileNotFoundFault extends Fault {

        private static final long serialVersionUID = 1L;

        ResultFileNotFoundFault( I18NResourceBundle i18nresourcebundle, String s ) {

            super( i18nresourcebundle, s );
        }

        ResultFileNotFoundFault( I18NResourceBundle i18nresourcebundle, String s, Object obj ) {

            super( i18nresourcebundle, s, obj );
        }

        ResultFileNotFoundFault( I18NResourceBundle i18nresourcebundle, String s, Object aobj[] ) {

            super( i18nresourcebundle, s, aobj );
        }
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

    public TestResult( TestDescription testdescription ) {

        desc = testdescription;
        execStatus = inProgress;
        testURL = desc.getRootRelativeURL( );
        createSection( "script_messages" );
        props = emptyStringArray;
    }

    public TestResult( TestDescription testdescription, WorkDirectory workdirectory ) throws Fault {

        desc = testdescription;
        testURL = desc.getRootRelativeURL( );
        execStatus = inProgress;
        reloadFromWorkDir( workdirectory );
    }

    public TestResult( File file ) throws Fault {

        resultsFile = file;
        reload( );
        testURL = desc.getRootRelativeURL( );
        execStatus = Status.parse( PropertyArray.get( props, "execStatus" ) );
    }

    public TestResult( WorkDirectory workdirectory, String s ) throws Fault {

        resultsFile = workdirectory.getFile( s );
        reload( );
        testURL = desc.getRootRelativeURL( );
        execStatus = Status.parse( PropertyArray.get( props, "execStatus" ) );
    }

    public TestResult( TestDescription testdescription, Status status ) {

        desc = testdescription;
        testURL = desc.getRootRelativeURL( );
        resultsFile = null;
        execStatus = status;
        props = emptyStringArray;
    }

    public static TestResult notRun( TestDescription testdescription ) {

        return new TestResult( testdescription, notRunStatus );
    }

    public synchronized Section createSection( String s ) {

        if ( !isMutable( ) ) {
            throw new IllegalStateException( "This TestResult is no longer mutable!" );
        } else {
            Section section = new Section( s );
            sections = (Section[]) DynamicArray.append( sections, section );
            notifyCreatedSection( section );
            section.createOutput( "messages" );
            return section;
        }
    }

    public synchronized void setEnvironment( TestEnvironment testenvironment ) {

        if ( !isMutable( ) ) {
            throw new IllegalStateException( "This TestResult is no longer mutable!" );
        }
        for ( Iterator<Element> iterator = testenvironment.elementsUsed( ).iterator( ); iterator.hasNext( ); ) {
            TestEnvironment.Element element = iterator.next( );
            env = PropertyArray.put( env, element.getKey( ), element.getValue( ) );
        }

    }

    public synchronized void setStatus( Status status ) {

        if ( !isMutable( ) ) {
            throw new IllegalStateException( "This TestResult is no longer mutable!" );
        }
        if ( status == null ) {
            throw new IllegalArgumentException( "TestResult status cannot be set to null!" );
        }
        sections[0].setStatus( null );
        execStatus = status;
        if ( execStatus == inProgress ) {
            execStatus = interrupted;
        }
        for ( int i = 0; i < sections.length; i++ ) {
            if ( sections[i].isMutable( ) ) {
                sections[i].setStatus( incomplete );
            }
        }

        props = PropertyArray.put( props, "sections", StringArray.join( getSectionTitles( ) ) );
        props = PropertyArray.put( props, "execStatus", execStatus.toString( ) );
        notifyCompleted( );
    }

    public synchronized void putProperty( String s, String s1 ) {

        if ( !isMutable( ) ) {
            throw new IllegalStateException( "Cannot put property, the TestResult is no longer mutable!" );
        } else {
            props = PropertyArray.put( props, s, s1 );
            notifyUpdatedProperty( s, s1 );
            return;
        }
    }

    public void reloadFromWorkDir( WorkDirectory workdirectory ) throws Fault {

        if ( !isMutable( ) ) {
            throw new IllegalStateException( "Cannot reload results, the TestResult is no longer mutable!" );
        }
        try {
            resultsFile = workdirectory.getFile( getWorkRelativePath( ) );
            props = null;
            sections = null;
            execStatus = null;
            reload( new FileReader( resultsFile ) );
            execStatus = Status.parse( PropertyArray.get( props, "execStatus" ) );
        } catch ( FileNotFoundException filenotfoundexception ) {
            props = emptyStringArray;
            env = emptyStringArray;
            sections = emptySectionArray;
            execStatus = Status.notRun( "no test result file found" );
        } catch ( IOException ioexception ) {
            props = emptyStringArray;
            env = emptyStringArray;
            sections = emptySectionArray;
            execStatus = Status.error( "error opening result file: " + ioexception );
            throw new Fault( i18n, "rslt.badFile", ioexception.toString( ) );
        } catch ( Fault fault ) {
            props = emptyStringArray;
            env = emptyStringArray;
            sections = emptySectionArray;
            execStatus = Status.error( fault.getMessage( ) );
            throw fault;
        }
    }

    public byte getChecksumState( ) {

        return checksumState;
    }

    public PrintWriter getTestCommentWriter( ) {

        return sections[0].getMessageWriter( );
    }

    public String getTestName( ) {

        return testURL;
    }

    public boolean isReloadable( ) {

        return resultsFile != null && resultsFile.canRead( );
    }

    public boolean isShrunk( ) {

        return !isMutable( ) && ( desc == null || props == null || env == null || sections == null && execStatus != inProgress );
    }

    public synchronized TestDescription getDescription( ) throws Fault {

        if ( desc == null ) {
            reload( );
        }
        return desc;
    }

    public String getWorkRelativePath( ) {

        return getWorkRelativePath( testURL );
    }

    public File getFile( ) {

        return resultsFile;
    }

    public static String getWorkRelativePath( TestDescription testdescription ) {

        String s = testdescription.getRootRelativePath( );
        String s1 = testdescription.getParameter( "id" );
        return getWorkRelativePath( s, s1 );
    }

    public static String getWorkRelativePath( String s ) {

        int i = s.lastIndexOf( "#" );
        if ( i == -1 ) {
            return getWorkRelativePath( s, null );
        } else {
            return getWorkRelativePath( s.substring( 0, i ), s.substring( i + 1 ) );
        }
    }

    public static String getWorkRelativePath( String s, String s1 ) {

        StringBuffer stringbuffer = new StringBuffer( s );
        for ( int i = stringbuffer.length( ) - 1; i >= 0; i-- ) {
            switch ( stringbuffer.charAt( i ) ) {
                case 46: // '.'
                    stringbuffer.setLength( i );
                    i = -1;
                    break;

                case 47: // '/'
                    i = -1;
                    break;
            }
        }

        if ( s1 != null ) {
            stringbuffer.append( '_' );
            stringbuffer.append( s1 );
        }
        stringbuffer.append( ".jtr" );
        return stringbuffer.toString( );
    }

    public synchronized Enumeration<String> getPropertyNames( ) {

        return PropertyArray.enumerate( props );
    }

    public synchronized String getProperty( String s ) throws Fault {

        if ( props == null ) {
            reload( );
        }
        return PropertyArray.get( props, s );
    }

    public synchronized Map<String, String> getEnvironment( ) throws Fault {

        if ( env == null ) {
            reload( );
        }
        return PropertyArray.getProperties( env );
    }

    public TestResultTable.TreeNode getParent( ) {

        return parent;
    }

    void setParent( TestResultTable.TreeNode treenode ) {

        parent = treenode;
    }

    public synchronized boolean isMutable( ) {

        return execStatus == inProgress;
    }

    public synchronized Status getStatus( ) {

        return execStatus;
    }

    public synchronized int getSectionCount( ) {

        if ( sections != null ) {
            return sections.length;
        }
        if ( PropertyArray.get( props, "sections" ) != null ) {
            return StringArray.split( PropertyArray.get( props, "sections" ) ).length;
        } else {
            return 0;
        }
    }

    public synchronized Section getSection( int i ) throws ReloadFault {

        if ( sections == null && execStatus != inProgress ) {
            try {
                reload( );
            } catch ( ReloadFault reloadfault ) {
                throw reloadfault;
            } catch ( Fault fault ) {
                throw new ReloadFault( i18n, "rslt.badFile", fault.getMessage( ) );
            }
        }
        Section section;
        if ( i >= sections.length ) {
            section = null;
        } else {
            section = sections[i];
        }
        return section;
    }

    public synchronized String[] getSectionTitles( ) {

        if ( props == null ) {
            try {
                reload( );
            } catch ( Fault fault ) {
                return null;
            }
        }
        String s = PropertyArray.get( props, "sections" );
        if ( s != null ) {
            return StringArray.split( s );
        }
        if ( sections != null ) {
            int i = getSectionCount( );
            String as[] = new String[i];
            for ( int j = 0; j < i; j++ ) {
                as[j] = sections[j].getTitle( );
            }

            return as;
        } else {
            return null;
        }
    }

    public static boolean isResultFile( File file ) {

        String s = file.getPath( );
        return s.endsWith( ".jtr" );
    }

    public String getResults( ) {

        String result;
        try {
            StringWriter sw = new StringWriter( );
            props = PropertyArray.put( props, "execStatus", execStatus.toString( ) );
            sw.append( lineSeparator );
            sw.append( lineSeparator );
            sw.append( "#Test Results (version 2)" );
            sw.append( lineSeparator );
            sw.append( "#" + ( new Date( ) ).toString( ) );
            sw.append( lineSeparator );
            sw.append( lineSeparator );

            sw.append( "#-----testdescription-----" );
            sw.append( lineSeparator );
            Properties properties = new Properties( );
            desc.save( properties );
            PropertyArray.save( PropertyArray.getArray( properties ), sw );
            sw.append( lineSeparator );

            sw.append( "#-----testresult-----" );
            sw.append( lineSeparator );
            PropertyArray.save( props, sw );
            sw.append( lineSeparator );
            if ( sections == null ) {
                throw new JavaTestError( "Cannot write test result - it contains no sections." );
            }

            for ( int j = 0; j < sections.length; j++ ) {
                sections[j].save( sw );
            }

            result = sw.toString( );
            sw.close( );
        } catch ( IOException e ) {
            execStatus = Status.error( "Problem writing results" );
            return emptyString;
        }
        return result;
    }

    public synchronized void writeResults( WorkDirectory workdirectory, BackupPolicy backuppolicy ) throws IOException {

        if ( isMutable( ) ) {
            throw new IllegalStateException( "This TestResult is still mutable - set the status!" );
        }
        if ( props == null ) {
            props = emptyStringArray;
        }
        String s = getWorkRelativePath( desc ).replace( '/', File.separatorChar );
        resultsFile = workdirectory.getFile( s );
        File file = new File( resultsFile.getParent( ) );
        File file1 = File.createTempFile( Long.toString( System.currentTimeMillis( ) ), ".tmp", file );
        FileWriter filewriter = null;
        try {
            filewriter = new FileWriter( file1 );
        } catch ( IOException ioexception ) {
            execStatus = Status.error( "Problem writing result file for test: " + getTestName( ) );
            resultsFile = null;
            throw ioexception;
        }
        try {
            props = PropertyArray.put( props, "execStatus", execStatus.toString( ) );
            filewriter.write( "#Test Results (version 2)" );
            filewriter.write( lineSeparator );
            filewriter.write( "#" + ( new Date( ) ).toString( ) );
            filewriter.write( lineSeparator );
            filewriter.write( "#checksum:" );
            filewriter.write( Long.toHexString( computeChecksum( ) ) );
            filewriter.write( lineSeparator );
            if ( debug ) {
                filewriter.write( "# debug: test desc checksum: " );
                filewriter.write( Long.toHexString( computeChecksum( desc ) ) );
                filewriter.write( lineSeparator );
                for ( Iterator<String> iterator = desc.getParameterKeys( ); iterator.hasNext( ); filewriter.write( lineSeparator ) ) {
                    String s1 = iterator.next( );
                    filewriter.write( "# debug: test desc checksum key " + s1 + ": " );
                    filewriter.write( Long.toHexString( computeChecksum( s1 ) * computeChecksum( desc.getParameter( s1 ) ) ) );
                }

                filewriter.write( "# debug: test env checksum: " );
                if ( env == null ) {
                    filewriter.write( "null" );
                } else {
                    filewriter.write( Long.toHexString( computeChecksum( env ) ) );
                }
                filewriter.write( lineSeparator );
                filewriter.write( "# debug: test props checksum: " );
                filewriter.write( Long.toHexString( computeChecksum( props ) ) );
                filewriter.write( lineSeparator );
                filewriter.write( "# debug: test sections checksum: " );
                filewriter.write( Long.toHexString( computeChecksum( sections ) ) );
                filewriter.write( lineSeparator );
                for ( int i = 0; i < sections.length; i++ ) {
                    filewriter.write( "# debug: test section[" + i + "] checksum: " );
                    filewriter.write( Long.toHexString( computeChecksum( sections[i] ) ) );
                    filewriter.write( lineSeparator );
                    String as[] = sections[i].getOutputNames( );
                    for ( int k = 0; k < as.length; k++ ) {
                        filewriter.write( "# debug: test section[" + i + "] name=" + as[k] + " checksum: " );
                        filewriter.write( Long.toHexString( computeChecksum( as[k] ) ) );
                        filewriter.write( lineSeparator );
                        filewriter.write( "# debug: test section[" + i + "] name=" + as[k] + " output checksum: " );
                        filewriter.write( Long.toHexString( computeChecksum( sections[i].getOutput( as[k] ) ) ) );
                        filewriter.write( lineSeparator );
                    }

                }

            }
            filewriter.write( "#-----testdescription-----" );
            filewriter.write( lineSeparator );
            Properties properties = new Properties( );
            desc.save( properties );
            PropertyArray.save( PropertyArray.getArray( properties ), filewriter );
            filewriter.write( lineSeparator );
            if ( env != null ) {
                filewriter.write( "#-----environment-----" );
                filewriter.write( lineSeparator );
                PropertyArray.save( env, filewriter );
                filewriter.write( lineSeparator );
            }
            filewriter.write( "#-----testresult-----" );
            filewriter.write( lineSeparator );
            PropertyArray.save( props, filewriter );
            filewriter.write( lineSeparator );
            if ( sections == null ) {
                throw new JavaTestError( "Cannot write test result - it contains no sections." );
            }
            for ( int j = 0; j < sections.length; j++ ) {
                sections[j].save( filewriter );
            }

            filewriter.write( lineSeparator );
            filewriter.write( "test result: " );
            filewriter.write( execStatus.toString( ) );
            filewriter.write( lineSeparator );
            filewriter.close( );
        } catch ( IOException ioexception1 ) {
            execStatus = Status.error( "Write to temp. JTR file failed (old JTR intact): " + file1.getPath( ) );
            resultsFile = null;
            throw ioexception1;
        }
        try {
            backuppolicy.backupAndRename( file1, resultsFile );
            addToShrinkQueue( );
        } catch ( IOException ioexception2 ) {
            execStatus = Status.error( "Problem writing result file: " + resultsFile.getPath( ) );
            resultsFile = null;
            throw ioexception2;
        } finally {
            if ( file1.exists( ) ) {
                file1.delete( );
            }
        }
    }

    public synchronized void addObserver( Observer observer ) {

        if ( isMutable( ) ) {
            Observer aobserver[] = observersTable.get( this );
            if ( aobserver == null ) {
                aobserver = new Observer[0];
            }
            aobserver = (Observer[]) DynamicArray.append( aobserver, observer );
            observersTable.put( this, aobserver );
        }
    }

    public synchronized void removeObserver( Observer observer ) {

        Observer aobserver[] = observersTable.get( this );
        if ( aobserver == null ) {
            return;
        }
        aobserver = (Observer[]) DynamicArray.remove( aobserver, observer );
        if ( aobserver == null ) {
            observersTable.remove( this );
        } else {
            observersTable.put( this, aobserver );
        }
    }

    TestResult( String s, WorkDirectory workdirectory, Status status ) {

        if ( s == null ) {
            throw new JavaTestError( i18n, "rslt.badTestUrl" );
        }
        if ( workdirectory == null ) {
            throw new JavaTestError( i18n, "rslt.badWorkdir" );
        }
        if ( status == null ) {
            throw new JavaTestError( i18n, "rslt.badStatus" );
        } else {
            testURL = s;
            resultsFile = workdirectory.getFile( getWorkRelativePath( ) );
            execStatus = status;
            return;
        }
    }

    void shareStatus( Hashtable<String, Status> ahashtable[] ) {

        execStatus = shareStatus( ahashtable, execStatus );
    }

    String[] getTags( ) {

        if ( sections == null ) {
            return null;
        }
        Vector<String> vector = new Vector<String>( sections.length * 2 );
        for ( int i = 0; i < sections.length; i++ ) {
            String as[] = sections[i].getOutputNames( );
            for ( int j = 0; j < as.length; j++ ) {
                vector.addElement( as[j] );
            }

        }

        String as1[] = new String[vector.size( )];
        vector.copyInto( as1 );
        return as1;
    }

    private long computeChecksum( ) {

        long l = 0L;
        l = l * 37L + computeChecksum( desc );
        String s = PropertyArray.get( props, "javatestVersion" );
        if ( env != null && ( s == null || !s.equals( "JT_2.1.1a" ) ) ) {
            l = l * 37L + computeChecksum( env );
        }
        l = l * 37L + computeChecksum( props );
        l = l * 37L + computeChecksum( sections );
        l = l * 37L + execStatus.getType( ) + computeChecksum( execStatus.getReason( ) );
        return Math.abs( l );
    }

    private static long computeChecksum( TestDescription testdescription ) {

        long l = 0L;
        for ( Iterator<String> iterator = testdescription.getParameterKeys( ); iterator.hasNext( ); ) {
            String s = iterator.next( );
            l += computeChecksum( s ) * computeChecksum( testdescription.getParameter( s ) );
        }

        return l;
    }

    private static long computeChecksum( Section asection[] ) {

        long l = asection.length;
        for ( int i = 0; i < asection.length; i++ ) {
            l = l * 37L + computeChecksum( asection[i] );
        }

        return l;
    }

    private static long computeChecksum( Section section ) {

        long l = computeChecksum( section.getTitle( ) );
        String as[] = section.getOutputNames( );
        for ( int i = 0; i < as.length; i++ ) {
            l = l * 37L + computeChecksum( as[i] );
            l = l * 37L + computeChecksum( section.getOutput( as[i] ) );
        }

        return l;
    }

    private static long computeChecksum( String as[] ) {

        long l = as.length;
        for ( int i = 0; i < as.length; i++ ) {
            l = l * 37L + computeChecksum( as[i] );
        }

        return l;
    }

    private static long computeChecksum( String s ) {

        long l = 0L;
        for ( int i = 0; i < s.length( ); i++ ) {
            int j = s.charAt( i );
            l = l * 37L + j;
        }

        return l;
    }

    private synchronized void reload( ) throws Fault {

        if ( resultsFile == null ) {
            throw new ReloadFault( i18n, "rslt.noResultFile" );
        }
        if ( isMutable( ) ) {
            throw new IllegalStateException( "Cannot do a reload of this object." );
        }
        try {
            reload( new FileReader( resultsFile ) );
            addToShrinkQueue( );
        } catch ( FileNotFoundException filenotfoundexception ) {
            throw new ResultFileNotFoundFault( i18n, "rslt.fileNotFound", resultsFile );
        } catch ( IOException ioexception ) {
            throw new ReloadFault( i18n, "rslt.badFile", ioexception );
        }
    }

    private void reload( Reader reader ) throws Fault, IOException {

        try {
            BufferedReader bufferedreader = new BufferedReader( reader );
            String s = bufferedreader.readLine( );
            if ( s == null ) {
                throw new ReloadFault( i18n, "rslt.empty", resultsFile );
            }
            if ( s.equals( "#Test Results (version 2)" ) ) {
                reloadVersion2( bufferedreader );
            } else if ( s.equals( "#Test Results" ) ) {
                reloadVersion1( bufferedreader );
            } else {
                throw new ReloadFault( i18n, "rslt.badHeader", resultsFile );
            }
        } finally {
            reader.close( );
        }
    }

    private void reloadVersion1( BufferedReader bufferedreader ) throws Fault, IOException {

        StringBuffer stringbuffer = new StringBuffer( );
        for ( String s = bufferedreader.readLine( ); s != null && s.length( ) != 0; s = bufferedreader.readLine( ) ) {
            stringbuffer.append( s );
            stringbuffer.append( lineSeparator );
        }

        Properties properties = new Properties( );
        if ( props == null || desc == null ) {
            StringReader stringreader = new StringReader( stringbuffer.toString( ) );
            stringbuffer = null;
            properties = new Properties( );
            properties.load( stringreader );
        }
        if ( props == null ) {
            props = PropertyArray.getArray( properties );
        }
        properties = null;
        if ( desc == null ) {
            File file = new File( PropertyArray.get( props, "testsuite" ) );
            if ( !file.isDirectory( ) ) {
                file = new File( file.getParent( ) );
            }
            File file1 = new File( PropertyArray.get( props, "file" ) );
            uniquifyStrings( props );
            desc = new TestDescription( file, file1, PropertyArray.getProperties( props ) );
        }
        stringbuffer = new StringBuffer( );
        for ( String s1 = bufferedreader.readLine( ); s1 != null; s1 = bufferedreader.readLine( ) ) {
            if ( s1.startsWith( "command: " ) ) {
                Section section = processOldSection( s1, bufferedreader );
                if ( section != null ) {
                    sections = (Section[]) DynamicArray.append( sections, section );
                }
                continue;
            }
            if ( s1.startsWith( "test result:" ) ) {
                s1 = extractSlice( s1, "test result:".length( ), " ", null );
                execStatus = Status.parse( s1 );
                break;
            }
            stringbuffer.append( s1 );
            stringbuffer.append( lineSeparator );
        }

        Section section1 = new Section( "script_messages" );
        section1.reloadOutput( "messages", stringbuffer.toString( ) );
        Section asection[] = new Section[sections.length + 1];
        asection[0] = section1;
        System.arraycopy( sections, 0, asection, 1, sections.length );
        sections = asection;
    }

    private Section processOldSection( String s, BufferedReader bufferedreader ) throws IOException, Fault {

        StringBuffer stringbuffer = new StringBuffer( );
        Section section = null;
        for ( String s1 = s; s1 != null; s1 = bufferedreader.readLine( ) ) {
            if ( s1.startsWith( "----------" ) ) {
                String s2 = null;
                String s3 = null;
                StringBuffer stringbuffer1 = new StringBuffer( );
                try {
                    s2 = extractSlice( s1, 10, null, ":" );
                    s3 = extractSlice( s1, 10, ":", "(" );
                    int i = Integer.parseInt( extractSlice( s1, 10, "(", "/" ) );
                    for ( int k = 0; k < i; k++ ) {
                        stringbuffer1.append( bufferedreader.readLine( ) );
                    }

                } catch ( NumberFormatException numberformatexception ) {
                    throw new Fault( i18n, "rslt.badFile", numberformatexception );
                }
                if ( section == null ) {
                    section = new Section( s3 );
                }
                section.reloadOutput( s2, stringbuffer1.toString( ) );
                continue;
            }
            if ( s1.startsWith( "command result:" ) ) {
                if ( section == null ) {
                    section = new Section( "" );
                }
                s1 = extractSlice( s1, "command result:".length( ), " ", null );
                if ( s1 == null ) {
                    throw new Fault( i18n, "rslt.noSectionResult" );
                }
                section.reloadStatus( Status.parse( s1 ) );
                break;
            }
            stringbuffer.append( s1 );
            stringbuffer.append( lineSeparator );
        }

        section.reloadOutput( "messages", stringbuffer.toString( ) );
        return section;
    }

    private void reloadVersion2( BufferedReader bufferedreader ) throws Fault, IOException {

        String s = null;
        String s1;
        while ( ( s1 = bufferedreader.readLine( ) ) != null ) {
            if ( s1.equals( "#-----testdescription-----" ) ) {
                break;
            }
            if ( s1.startsWith( "#checksum:" ) ) {
                s = s1.substring( "#checksum:".length( ) );
            } else if ( !s1.startsWith( "#" ) ) {
                throw new ReloadFault( i18n, "rslt.badLine", s1 );
            }
        }
        String as[] = PropertyArray.load( bufferedreader );
        if ( desc == null ) {
            uniquifyStrings( as );
            desc = TestDescription.load( as );
        }
        as = null;
        while ( ( s1 = bufferedreader.readLine( ) ) != null ) {
            if ( s1.startsWith( "#-----testresult-----" ) ) {
                break;
            }
            if ( s1.startsWith( "#-----environment-----" ) ) {
                env = PropertyArray.load( bufferedreader );
                uniquifyStrings( env );
            } else if ( !s1.startsWith( "#" ) ) {
                throw new ReloadFault( i18n, "rslt.badLine", s1 );
            }
        }
        if ( env == null ) {
            env = new String[0];
        }
        if ( s1 == null ) {
            throw new ReloadFault( i18n, "rslt.badFormat" );
        }
        String as1[] = PropertyArray.load( bufferedreader );
        if ( props == null ) {
            uniquifyStrings( as1 );
            props = as1;
        }
        as1 = null;
        int i = getSectionCount( );
        sections = new Section[i];
        for ( int j = 0; j < getSectionCount( ); j++ ) {
            sections[j] = new Section( bufferedreader );
        }

        while ( ( s1 = bufferedreader.readLine( ) ) != null ) {
            if ( s1.startsWith( "test result: " ) ) {
                execStatus = Status.parse( s1.substring( "test result: ".length( ) ) );
                break;
            }
        }
        if ( execStatus == null ) {
            execStatus = Status.error( "NO STATUS RECORDED IN FILE" );
        }
        if ( s == null ) {
            checksumState = 0;
        } else {
            try {
                long l = Long.parseLong( s, 16 );
                if ( l == computeChecksum( ) ) {
                    checksumState = 2;
                } else {
                    checksumState = 1;
                }
            } catch ( RuntimeException runtimeexception ) {
                checksumState = 1;
            }
        }
    }

    void uniquifyStrings( String as[] ) {

        for ( int i = 0; i < as.length; i++ ) {
            as[i] = as[i].intern( );
        }

    }

    String extractSlice( String s, int i, String s1, String s2 ) {

        int j;
        if ( s1 == null ) {
            j = i;
        } else {
            j = s.indexOf( s1, i ) + s1.length( );
        }
        int k;
        if ( s2 == null ) {
            k = s.length( );
        } else {
            k = s.indexOf( s2, j );
        }
        if ( k == -1 ) {
            return null;
        }
        try {
            return s.substring( j, k );
        } catch ( StringIndexOutOfBoundsException stringindexoutofboundsexception ) {
            return null;
        }
    }

    private static Status shareStatus( Hashtable<String, Status> ahashtable[], Status status ) {

        int i = status.getType( );
        String s = status.getReason( );
        Status status1 = ahashtable[i].get( s );
        if ( status1 == null ) {
            ahashtable[i].put( s, status );
            status1 = status;
        }
        return status1;
    }

    private synchronized void notifyCreatedSection( Section section ) {

        Observer aobserver[] = observersTable.get( this );
        if ( aobserver != null ) {
            for ( int i = 0; i < aobserver.length; i++ ) {
                aobserver[i].createdSection( this, section );
            }

        }
    }

    private synchronized void notifyCompletedSection( Section section ) {

        Observer aobserver[] = observersTable.get( this );
        if ( aobserver != null ) {
            for ( int i = 0; i < aobserver.length; i++ ) {
                aobserver[i].completedSection( this, section );
            }

        }
    }

    private synchronized void notifyCreatedOutput( Section section, String s ) {

        Observer aobserver[] = observersTable.get( this );
        if ( aobserver != null ) {
            for ( int i = 0; i < aobserver.length; i++ ) {
                aobserver[i].createdOutput( this, section, s );
            }

        }
    }

    private synchronized void notifyCompletedOutput( Section section, String s ) {

        Observer aobserver[] = observersTable.get( this );
        if ( aobserver != null ) {
            for ( int i = 0; i < aobserver.length; i++ ) {
                aobserver[i].completedOutput( this, section, s );
            }

        }
    }

    private synchronized void notifyUpdatedOutput( Section section, String s, int i, int j, String s1 ) {

        Observer aobserver[] = observersTable.get( this );
        if ( aobserver != null ) {
            for ( int k = 0; k < aobserver.length; k++ ) {
                aobserver[k].updatedOutput( this, section, s, i, j, s1 );
            }

        }
    }

    private synchronized void notifyUpdatedOutput( Section section, String s, int i, int j, char ac[], int k, int l ) {

        Observer aobserver[] = observersTable.get( this );
        if ( aobserver != null ) {
            String s1 = new String( ac, k, l );
            for ( int i1 = 0; i1 < aobserver.length; i1++ ) {
                aobserver[i1].updatedOutput( this, section, s, i, j, s1 );
            }

        }
    }

    private synchronized void notifyUpdatedProperty( String s, String s1 ) {

        Observer aobserver[] = observersTable.get( this );
        if ( aobserver != null ) {
            for ( int i = 0; i < aobserver.length; i++ ) {
                aobserver[i].updatedProperty( this, s, s1 );
            }

        }
    }

    private synchronized void notifyCompleted( ) {

        Observer aobserver[] = observersTable.remove( this );
        if ( aobserver != null ) {
            for ( int i = 0; i < aobserver.length; i++ ) {
                aobserver[i].completed( this );
            }

            observersTable.remove( this );
        }
    }

    private void addToShrinkQueue( ) {

        shrinkQueue.removeElement( this );
        if ( shrinkQueue.size( ) == maxShrinkQueueSize ) {
            TestResult testresult = shrinkQueue.elementAt( 0 );
            shrinkQueue.removeElementAt( 0 );
            testresult.shrink( );
        }
        shrinkQueue.addElement( this );
    }

    private synchronized void shrink( ) {

        if ( isMutable( ) ) {
            throw new IllegalStateException( "Can't shrink a mutable test result!" );
        } else {
            sections = null;
            return;
        }
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    public static final int NO_CHECKSUM = 0;

    public static final int BAD_CHECKSUM = 1;

    public static final int GOOD_CHECKSUM = 2;

    public static final int NUM_CHECKSUM_STATES = 3;

    private File resultsFile;

    private Status execStatus;

    private String testURL;

    private byte checksumState;

    private TestDescription desc;

    private String props[];

    private String env[];

    private Section sections[];

    private TestResultTable.TreeNode parent;

    private static Hashtable<TestResult, Observer[]> observersTable = new Hashtable<TestResult, Observer[]>( 16 );

    public static final String MESSAGE_OUTPUT_NAME = "messages";

    public static final String MSG_SECTION_NAME = "script_messages";

    public static final String DESCRIPTION = "description";

    public static final String END = "end";

    public static final String ENVIRONMENT = "environment";

    public static final String EXEC_STATUS = "execStatus";

    public static final String JAVATEST_OS = "javatestOS";

    public static final String SCRIPT = "script";

    public static final String SECTIONS = "sections";

    public static final String START = "start";

    public static final String TEST = "test";

    public static final String VERSION = "javatestVersion";

    public static final String WORK = "work";

    static final String EXTN = ".jtr";

    private static final Status interrupted = Status.failed( "interrupted" );

    private static final Status inProgress = Status.notRun( "Test running..." );

    private static final Status incomplete = Status.notRun( "Section not closed, may be incomplete" );

    private static final Status notRunStatus = Status.notRun( "" );

    private static final String emptyString = new String( );

    private static final String emptyStringArray[] = new String[0];

    private static final Section emptySectionArray[] = new Section[0];

    private static final String lineSeparator = System.getProperty( LINE_SEPARATOR );

    private static final int maxShrinkQueueSize;

    private static Vector<TestResult> shrinkQueue;

    private static final int maxOutputSize = Integer.getInteger( "javatest.maxOutputSize", 0x186a0 ).intValue( );

    private static I18NResourceBundle i18n;

    private static boolean debug;

    static {
        maxShrinkQueueSize = Integer.getInteger( "javatest.numCachedResults", 128 ).intValue( );
        shrinkQueue = new Vector<TestResult>( maxShrinkQueueSize );
        i18n = I18NResourceBundle.getBundleForClass( com.sap.tc.moin.repository.test.jmitck.javatest.TestResult.class );
        debug = Boolean.getBoolean( "debug." + ( com.sap.tc.moin.repository.test.jmitck.javatest.TestResult.class ).getName( ) );
    }

}
