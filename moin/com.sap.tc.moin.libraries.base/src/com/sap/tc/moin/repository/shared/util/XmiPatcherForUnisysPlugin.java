package com.sap.tc.moin.repository.shared.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class patches XMI files written by the Unisys Add-Ins 1.3.2 and 1.3.3 to
 * be MOF/JMI compliant. In addition, a main method is provided that takes a
 * folder name and patches all *.xml files found in that folder. Note that the
 * input XMI files are overwritten without warning!
 */
public class XmiPatcherForUnisysPlugin {

    private static XmiPatcherForUnisysPlugin theInstance = null;

    private final static String XMI_IDREF = "xmi.idref = "; //$NON-NLS-1$

    private final static String JAVAX_JMI_PACKAGEPREFIX = "javax.jmi.packagePrefix"; //$NON-NLS-1$

    private final static String JAVAX_JMI_SUBSTITUTENAME = "javax.jmi.substituteName"; //$NON-NLS-1$

    private final static String PATCHED = "patched"; //$NON-NLS-1$

    private XmiPatcherForUnisysPlugin( ) {

        // singleton
    }

    /**
     * @return the singleton
     */
    public static XmiPatcherForUnisysPlugin getInstance( ) {

        if ( theInstance == null ) {
            XmiPatcherForUnisysPlugin.theInstance = new XmiPatcherForUnisysPlugin( );
        }
        return theInstance;
    }

    /**
     * @param fileName
     * @return the patched content
     * @throws IOException
     */
    public String patchXMIFile( String fileName ) throws IOException {

        return this.getPatchedXmiContent( fileName ).getPatchedContent( );
    }

    /**
     * @param fileName
     * @return the patched content
     * @throws IOException
     */
    public PatchResult getPatchedXmiContent( String fileName ) throws IOException {

        InputStream in = new FileInputStream( fileName );
        byte buffer[] = new byte[in.available( )];
        String name = new String( buffer, 0, in.read( buffer, 0, in.available( ) ), "UTF-8" ); //$NON-NLS-1$
        in.close( );

        int GlobalStartPosition;
        int GlobalMatchPosition;
        int noOfPatches = 0;
        Matcher regexMatcher = null;
        Matcher matchedRegEx = null;
        HashSet<Pattern> regExSet = new HashSet<Pattern>( );
        StringBuilder result = new StringBuilder( name );

        Pattern annotation = Pattern.compile( "<[\\w]+:[\\w]+\\.annotation*.*?</[\\w]+:[\\w]+\\.annotation>", Pattern.CANON_EQ | Pattern.DOTALL ); //$NON-NLS-1$
        regExSet.add( annotation );

        Pattern selfRefApostrophes = Pattern.compile( "(xml:link\\s?=\\s?'simple'\\s?href\\s?=\\s?\\'([\\w]+\\.xml)\\|([\\w]+)\\')/>", Pattern.CANON_EQ | Pattern.DOTALL ); //$NON-NLS-1$
        regExSet.add( selfRefApostrophes );

        Pattern selfRefQuotes = Pattern.compile( "(xml:link\\s?=\\s?\"simple\"\\s?href\\s?=\\s?\\\"([\\w]+\\.xml)\\|([\\w]+)\\\")/>", Pattern.CANON_EQ | Pattern.DOTALL ); //$NON-NLS-1$
        regExSet.add( selfRefQuotes );

        Pattern com_urep_jcr_java_prefixInComment = Pattern.compile( "<!--(?:(?!-->).)*\\.(com\\.urep\\.jcr\\.java_prefix)=*.*?-->", //$NON-NLS-1$
                                                                     // "<!--([^-]|[^-]>)*\\.(com\\.urep\\.jcr\\.java_prefix)=*.*?->",
                                                                     Pattern.CANON_EQ | Pattern.DOTALL );
        regExSet.add( com_urep_jcr_java_prefixInComment );

        Pattern com_urep_jcr_java_prefixApostrophes = Pattern.compile( "name\\s*=\\s*'(com\\.urep\\.jcr\\.java_prefix)=.*?tagId\\s*=\\s*'(com\\.urep\\.jcr\\.java_prefix)'", Pattern.CANON_EQ | Pattern.DOTALL ); //$NON-NLS-1$
        regExSet.add( com_urep_jcr_java_prefixApostrophes );

        Pattern com_urep_jcr_java_prefixQuotes = Pattern.compile( "name\\s*=\\s*\"(com\\.urep\\.jcr\\.java_prefix)=.*?tagId\\s*=\\s*\"(com\\.urep\\.jcr\\.java_prefix)\"", Pattern.CANON_EQ | Pattern.DOTALL ); //$NON-NLS-1$
        regExSet.add( com_urep_jcr_java_prefixQuotes );

        Pattern com_urep_jcr_java_substitute_nameInComment = Pattern.compile( "<!--(?:(?!-->).)*\\.(com\\.urep\\.jcr\\.java_substitute_name)=*.*?-->", Pattern.CANON_EQ | Pattern.DOTALL ); //$NON-NLS-1$
        regExSet.add( com_urep_jcr_java_substitute_nameInComment );

        Pattern com_urep_jcr_java_substitute_nameApostrophes = Pattern.compile( "name\\s*=\\s*'(com\\.urep\\.jcr\\.java_substitute_name)=.*?tagId\\s*=\\s*'(com\\.urep\\.jcr\\.java_substitute_name)'", Pattern.CANON_EQ | Pattern.DOTALL ); //$NON-NLS-1$
        regExSet.add( com_urep_jcr_java_substitute_nameApostrophes );

        Pattern com_urep_jcr_java_substitute_nameQuotes = Pattern.compile( "name\\s*=\\s*\"(com\\.urep\\.jcr\\.java_substitute_name)=.*?tagId\\s*=\\s*\"(com\\.urep\\.jcr\\.java_substitute_name)\"", Pattern.CANON_EQ | Pattern.DOTALL ); //$NON-NLS-1$
        regExSet.add( com_urep_jcr_java_substitute_nameQuotes );

        Pattern org_omg_sap2mof_DerivationCodeJavaInComment = Pattern.compile( "<!--(?:(?!-->).)*\\.org\\.omg\\.sap2mof\\.DerivationCodeJava=(.*?)\\[Tag\\](?:.*?)-->", Pattern.CANON_EQ | Pattern.DOTALL ); //$NON-NLS-1$
        regExSet.add( org_omg_sap2mof_DerivationCodeJavaInComment );

        //        Pattern wrongImport = Pattern
        //            .compile(
        //                "<Model:Import xmi\\.id = '\\S*'\\s*name = '(\\w*)'\\s*annotation = '\\w*'\\s*visibility = '\\w*'\\s*isClustered = '\\w*'\\s*(importedNamespace = '(\\S*)' />)",
        //                Pattern.CANON_EQ);
        //        regExSet.add(wrongImport);

        GlobalStartPosition = 0;
        noOfPatches = 0;
        //
        // do searching (algorithmic alternation)
        //
        while ( GlobalStartPosition < result.length( ) ) {
            GlobalMatchPosition = result.length( );
            matchedRegEx = null;
            try {
                for ( Iterator iter = regExSet.iterator( ); iter.hasNext( ); ) {
                    Pattern currPattern = (Pattern) iter.next( );
                    regexMatcher = currPattern.matcher( result );
                    if ( regexMatcher.find( GlobalStartPosition ) ) {
                        if ( ( regexMatcher.end( ) < GlobalMatchPosition ) ) {
                            matchedRegEx = regexMatcher;
                            GlobalMatchPosition = regexMatcher.end( );
                        }
                    }
                }
            } catch ( Exception e ) {
                e.printStackTrace( );
            }
            //
            // do patching
            //
            if ( matchedRegEx != null ) {
                //                if (matchedRegEx.pattern().equals(wrongImport)) {
                //                    String group_1 = matchedRegEx.group(1);
                //                    String group_3 = matchedRegEx.group(3);
                //                    result.replace(matchedRegEx.start(2), matchedRegEx.end(2),
                //                        "><Model:Import.importedNamespace><Model:Namespace xml:link = 'simple' href = '" + group_1
                //                            + ".xml|" + group_3 + "'/></Model:Import.importedNamespace></Model:Import>");
                //                    noOfPatches = noOfPatches + 1;
                //                } else 
                if ( matchedRegEx.pattern( ).equals( selfRefApostrophes ) ) {
                    if ( matchedRegEx.group( 2 ).equalsIgnoreCase( name ) ) {
                        result.replace( matchedRegEx.start( 1 ), matchedRegEx.end( 1 ), XmiPatcherForUnisysPlugin.XMI_IDREF + "'" + matchedRegEx.group( 3 ) + "'" ); //$NON-NLS-1$ //$NON-NLS-2$
                        noOfPatches = noOfPatches + 1;
                    }
                } else if ( matchedRegEx.pattern( ).equals( selfRefQuotes ) ) {
                    if ( matchedRegEx.group( 2 ).equalsIgnoreCase( name ) ) {
                        result.replace( matchedRegEx.start( 1 ), matchedRegEx.end( 1 ), XmiPatcherForUnisysPlugin.XMI_IDREF + "\"" + matchedRegEx.group( 3 ) + "\"" ); //$NON-NLS-1$ //$NON-NLS-2$
                        noOfPatches = noOfPatches + 1;
                    }
                } else if ( matchedRegEx.pattern( ).equals( com_urep_jcr_java_prefixInComment ) ) {
                    result.replace( matchedRegEx.start( 1 ), matchedRegEx.end( 1 ), XmiPatcherForUnisysPlugin.JAVAX_JMI_PACKAGEPREFIX );
                    noOfPatches = noOfPatches + 1;
                } else if ( ( matchedRegEx.pattern( ).equals( com_urep_jcr_java_prefixApostrophes ) ) || ( matchedRegEx.pattern( ).equals( com_urep_jcr_java_prefixQuotes ) ) ) {
                    int offset = XmiPatcherForUnisysPlugin.JAVAX_JMI_PACKAGEPREFIX.length( ) - matchedRegEx.group( 1 ).length( );

                    result.replace( matchedRegEx.start( 1 ), matchedRegEx.end( 1 ), XmiPatcherForUnisysPlugin.JAVAX_JMI_PACKAGEPREFIX );

                    result.replace( matchedRegEx.start( 2 ) + offset, matchedRegEx.end( 2 ) + offset, XmiPatcherForUnisysPlugin.JAVAX_JMI_PACKAGEPREFIX );
                    noOfPatches = noOfPatches + 2;
                } else if ( matchedRegEx.pattern( ).equals( com_urep_jcr_java_substitute_nameInComment ) ) {
                    result.replace( matchedRegEx.start( 1 ), matchedRegEx.end( 1 ), XmiPatcherForUnisysPlugin.JAVAX_JMI_SUBSTITUTENAME );
                    noOfPatches = noOfPatches + 1;
                } else if ( ( matchedRegEx.pattern( ).equals( com_urep_jcr_java_substitute_nameApostrophes ) ) || ( matchedRegEx.pattern( ).equals( com_urep_jcr_java_substitute_nameQuotes ) ) ) {
                    int offset = XmiPatcherForUnisysPlugin.JAVAX_JMI_SUBSTITUTENAME.length( ) - matchedRegEx.group( 1 ).length( );
                    result.replace( matchedRegEx.start( 1 ), matchedRegEx.end( 1 ), XmiPatcherForUnisysPlugin.JAVAX_JMI_SUBSTITUTENAME );
                    result.replace( matchedRegEx.start( 2 ) + offset, matchedRegEx.end( 2 ) + offset, XmiPatcherForUnisysPlugin.JAVAX_JMI_SUBSTITUTENAME );
                    noOfPatches = noOfPatches + 2;
                }
            }
            GlobalStartPosition = GlobalMatchPosition;
        }// while
        //
        // stamp as patched and increment patch counter
        //
        if ( noOfPatches > 0 ) {
            Pattern findXMI_header = Pattern.compile( "<XMI.header>\\s*(<XMI.documentation>)(.*?)</XMI.documentation>*.*?</XMI.header>", Pattern.CANON_EQ | Pattern.DOTALL ); //$NON-NLS-1$
            try {
                regexMatcher = findXMI_header.matcher( result );
                if ( regexMatcher.find( ) ) {
                    String group_1 = regexMatcher.group( 1 );
                    String newGroup_1 = group_1 + "[#" + XmiPatcherForUnisysPlugin.PATCHED + " " + ( noOfPatches + 1 ) + " times on " + new java.util.Date( ) + "#]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                    //
                    result.replace( regexMatcher.start( 1 ), regexMatcher.end( 1 ), newGroup_1 );
                    noOfPatches = noOfPatches + 1;
                    //
                }
            } catch ( Exception e ) {
                e.printStackTrace( );
            }
        }
        return new PatchResult( result.toString( ), noOfPatches );
    }

    /**
     * The patch result
     */
    public static final class PatchResult {

        PatchResult( String content, int noOfPatches ) {

            this.patchedContent = content;
            this.patchCount = noOfPatches;
        }

        private String patchedContent;

        private int patchCount;

        /**
         * @return the patch count
         */
        public int getPatchCount( ) {

            return this.patchCount;
        }

        /**
         * @return the content
         */
        public String getPatchedContent( ) {

            return this.patchedContent;
        }

    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main( String[] args ) throws Exception {

        String folder = args[0];
        String[] xmlFiles = new File( folder ).list( new FilenameFilter( ) {

            public boolean accept( File dir, String name ) {

                return name.endsWith( ".xml" ); //$NON-NLS-1$
            }
        } );
        for ( int i = 0; i < xmlFiles.length; i++ ) {
            String fileName = folder + File.separatorChar + xmlFiles[i];
            String newContent = getInstance( ).patchXMIFile( fileName );
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream( fileName );
            } catch ( FileNotFoundException ex ) {
                continue;
            }
            fos.write( newContent.getBytes( "UTF-8" ) ); //$NON-NLS-1$
            fos.close( );
        }
    }
}