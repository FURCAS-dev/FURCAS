package com.sap.tc.moin.repository.core.generator.jmi;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.generator.jmi.javamodel.JavaSource;
import com.sap.tc.moin.repository.mmi.model.AliasType;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.AttachesTo;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.CollectionType;
import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.Feature;
import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.Wrapper;

@SuppressWarnings( { "unchecked", "nls" } )
public class Generator {

    private static Connection connection;

    private static final String NON_SIG_CHARS = " _-\n\r\t";

    /**
     * The constant indicates whether a JMI interface, a JMI class
     * (implementation) or a MOIN wrapper should be generated.
     */
    public static final class GenerationKind {

        /**
         * <code>INTERFACE</code> indicates the generation of JMI interfaces.
         */
        public static final int INTERFACE = 0;

        /**
         * <code>CLASS</code> indicates the generation of JMI classes
         * (implementation)
         */
        public static final int CLASS = 1;

        /**
         * <code>WRAPPER</code> indicates the generation of MOIN wrapper.
         */
        public static final int WRAPPER = 2;
    }

    /**
     * The constant indicates whether the classes and interfaces for a client
     * API or the implementations should be generated.
     */
    public static final class GenerationMode {

        /**
         * <code>API</code> indicates the generation of the classes and
         * interfaces for a client API.
         */
        public static final int API = 0;

        /**
         * <code>IMPLEMENTATION</code> indicates the generation of the
         * implementations.
         */
        public static final int IMPLEMENTATION = 1;

        /**
         * <code>ALL</code> indicates the generation of the client API and the
         * implementations.
         */
        public static final int ALL = -1;
    }

    public final static String MOIN_EVENTS_PACKAGE = "com.sap.tc.moin.repository.events.type";

    public final static String MOIN_REPOSITORY_PACKAGE = "com.sap.tc.moin.repository";

    public final static String MOIN_PACKAGE = "com.sap.tc.moin";

    public final static String MOIN_JMI_UTIL_PACKAGE = "com.sap.tc.moin.repository.core.jmi.util";

    public final static String JMI_IMPL_PACKAGE_REFLECT = "com.sap.tc.moin.repository.core.jmi.reflect";

    public final static String JMI_TAG_PACKAGE_PREFIX = "javax.jmi.packagePrefix"; //$NON-NLS-1$

    public final static String JMI_TAG_SUBSTITUTE_NAME = "javax.jmi.substituteName"; //$NON-NLS-1$

    public final static String JMI_TAG_LIFECYCLE = "javax.jmi.ignoreLifecycle"; //$NON-NLS-1$

    public final static String EXTENSION_PACKAGE = "Package"; //$NON-NLS-1$

    public final static String PACKAGE_IMPLEMENTATION = "__impl"; //$NON-NLS-1$

    public final static String EXTENSION_IMPLEMENTATION = "Impl"; //$NON-NLS-1$

    public final static String EXTENSION_CLASS = "Class"; //$NON-NLS-1$

    public final static String EXTENSION_ENUM = "Enum"; //$NON-NLS-1$

    public final static String EXTENSION_EXCEPTION = "Exception"; //$NON-NLS-1$

    public final static String BOOLEAN = "BOOLEAN"; //$NON-NLS-1$

    public final static String VARIABLE_PREFIX = "__"; //$NON-NLS-1$

    private static GeneratorPackage generatorPackage = null;

    private static GeneratorClass generatorClass = null;

    private static GeneratorException generatorException = null;

    private static GeneratorInstance generatorInstance = null;

    private static GeneratorAssociation generatorAssociation = null;

    private static GeneratorDataType generatorDataType = null;

    private static GeneratorEnumerationType generatorEnumerationType = null;

    private static GeneratorStructureType generatorStructureType = null;

    private static GeneratorConstantTemplate generatorConstantTemplate = null;

    private static GeneratorAttributeTemplate generatorAttributeTemplate = null;

    private static GeneratorReferenceTemplate generatorReferenceTemplate = null;

    private static GeneratorOperationTemplate generatorOperationTemplate = null;

    private static GeneratorStructureFieldTemplate generatorStructureFieldTemplate = null;

    private static GeneratorMetamodelInformationProvider generatorMetamodelInformationProvider = null;

    private static GeneratorMetamodelDeploymentExtension generatorMetamodelDeploymentExtension = null;

    public final static String PREFIX_MOF = "Mof";

    private final static String tableKeywordsJava[] = { "abstract", //$NON-NLS-1$
        "default", //$NON-NLS-1$
        "if", //$NON-NLS-1$
        "private", //$NON-NLS-1$
        "this", //$NON-NLS-1$
        "boolean", //$NON-NLS-1$
        "do", //$NON-NLS-1$
        "implements", //$NON-NLS-1$
        "protected", //$NON-NLS-1$
        "throw", //$NON-NLS-1$
        "break", //$NON-NLS-1$
        "double", //$NON-NLS-1$
        "import", //$NON-NLS-1$
        "public", //$NON-NLS-1$
        "throws", //$NON-NLS-1$
        "byte", //$NON-NLS-1$
        "else", //$NON-NLS-1$
        "instanceof", //$NON-NLS-1$
        "return", //$NON-NLS-1$
        "transient", //$NON-NLS-1$
        "case", //$NON-NLS-1$
        "extends", //$NON-NLS-1$
        "int", //$NON-NLS-1$
        "short", //$NON-NLS-1$
        "try", //$NON-NLS-1$
        "catch", //$NON-NLS-1$
        "final", //$NON-NLS-1$
        "interface", //$NON-NLS-1$
        "static", //$NON-NLS-1$
        "void", //$NON-NLS-1$
        "char", //$NON-NLS-1$
        "finally", //$NON-NLS-1$
        "long", //$NON-NLS-1$
        "strictfp", //$NON-NLS-1$
        "volatile", //$NON-NLS-1$
        "class", //$NON-NLS-1$
        "float", //$NON-NLS-1$
        "native", //$NON-NLS-1$
        "super", //$NON-NLS-1$
        "while", //$NON-NLS-1$
        "const", //$NON-NLS-1$
        "for", //$NON-NLS-1$
        "new", //$NON-NLS-1$
        "switch", //$NON-NLS-1$
        "continue", //$NON-NLS-1$
        "goto", //$NON-NLS-1$
        "package", //$NON-NLS-1$
        "synchronized" }; //$NON-NLS-1$

    private static Set keywordsJava = null;

    private final static String tableKeywordsJavaForClass[] = { "package", //$NON-NLS-1$
        "class", "exception", "interface" //$NON-NLS-1$
    };

    private static Set keywordsJavaForClass = null;

    /**
     * Maps MOF primitive typenames to their Java counterparts. Even indices are
     * the MOF type names (0, 2, ...), index <em>i+1</em> contains the Java type
     * name for the MOF type name at index <em>i</em>.
     */
    private final static String tableDataTypeMappings[] = { "any", //$NON-NLS-1$
        "java.lang.Object", //$NON-NLS-1$
        "boolean", //$NON-NLS-1$
        "boolean", //$NON-NLS-1$
        "float", //$NON-NLS-1$
        "float", //$NON-NLS-1$
        "double", //$NON-NLS-1$
        "double", //$NON-NLS-1$
        "integer", //$NON-NLS-1$
        "int", //$NON-NLS-1$
        "short", //$NON-NLS-1$
        "short", //$NON-NLS-1$
        "long", //$NON-NLS-1$
        "long", //$NON-NLS-1$
        "character", //$NON-NLS-1$
        "char", //$NON-NLS-1$
        "string", //$NON-NLS-1$
        "java.lang.String", //$NON-NLS-1$
        "java.lang.string", //$NON-NLS-1$
        "java.lang.String", //$NON-NLS-1$
        "name", //$NON-NLS-1$
        "java.lang.String", //$NON-NLS-1$
        "time", //$NON-NLS-1$
        "java.lang.String", //$NON-NLS-1$
        "unlimitedinteger", //$NON-NLS-1$
        "int" }; //$NON-NLS-1$

    /**
     * The "mappified" version of {@link #tableDataTypeMappings}. Keys are MOF
     * primitive typenames, values are Java primitive typenames.
     */
    private static Map dataTypeMappings = null;

    /**
     * Constructor for the Generator object
     */
    public Generator( Connection connection ) {

        super( );
        this.connection = connection;
        initialize( );
    }

    private static void initialize( ) {

        if ( keywordsJava == null ) {
            keywordsJava = new HashSet( tableKeywordsJava.length );
            for ( int i = 0; i < tableKeywordsJava.length; i++ ) {
                keywordsJava.add( tableKeywordsJava[i] );
            }
        }
        if ( keywordsJavaForClass == null ) {
            keywordsJavaForClass = new HashSet( tableKeywordsJavaForClass.length );
            for ( int i = 0; i < tableKeywordsJavaForClass.length; i++ ) {
                keywordsJavaForClass.add( tableKeywordsJavaForClass[i] );
            }
        }
        if ( dataTypeMappings == null ) {
            dataTypeMappings = new HashMap( tableDataTypeMappings.length );
            for ( int i = 0; i < tableDataTypeMappings.length; i += 2 ) {
                dataTypeMappings.put( tableDataTypeMappings[i], tableDataTypeMappings[i + 1] );
            }
        }
    }

    public static boolean getIgnoreLifeCycle( ModelElement me ) {

        boolean ignoreLifeCycle = false;
        // search the package this operation is contained in
        MofPackage p = null;
        Namespace ns = me.getContainer( );
        while ( ns != null && p == null ) {
            if ( ns instanceof MofPackage ) {
                p = (MofPackage) ns;
            }
            ns = ns.getContainer( );
        }
        if ( p != null ) {
            // search the tag
            Tag tag = getTag( p, JMI_TAG_LIFECYCLE );
            if ( tag != null ) {
                String value = (String) ( tag.getValues( ).get( 0 ) ) + GeneratorConstants.PACKAGE_DELIMITER;
                if ( value.compareToIgnoreCase( "true" ) == 0 ) { //$NON-NLS-1$
                    ignoreLifeCycle = true;
                } else if ( value.compareToIgnoreCase( "false" ) == 0 ) { //$NON-NLS-1$
                    ignoreLifeCycle = false;
                }
            }
        }
        return ignoreLifeCycle;
    }

    public static String getSubstituteIdentifier( ModelElement me ) {

        String ident = null;
        // search the tag
        Tag tag = getTag( me, JMI_TAG_SUBSTITUTE_NAME );
        if ( tag != null ) {
            ident = (String) ( tag.getValues( ).get( 0 ) );
        }
        return ident;
    }

    public static Tag getTag( ModelElement tagged, String tagId ) {

        Tag tag = null;
        AttachesTo attachesTo = ( (ModelPackage) tagged.refImmediatePackage( ) ).getAttachesTo( );
        Collection c = attachesTo.getTag( tagged );
        if ( c != null ) {
            Iterator iter = c.iterator( );
            while ( iter.hasNext( ) && tag == null ) {
                ModelElement me = (ModelElement) iter.next( );
                if ( me instanceof Tag ) {
                    Tag t = (Tag) me;
                    if ( t.getTagId( ).compareTo( tagId ) == 0 ) {
                        tag = t;
                    }
                }
            }
        }
        return tag;
    }

    public static String getJMIPathOfModelElement( String directory, ModelElement modelElement, boolean forInterface, boolean forClassProxy ) {

        String pathSources = directory.replace( '\\', '/' );
        String fname = null;
        if ( modelElement instanceof MofClass ) {
            if ( forClassProxy ) {
                if ( forInterface ) {
                    fname = GeneratorClass.getJavaInterfaceNameQualified( ( (MofClass) modelElement ) );
                } else {
                    fname = GeneratorClass.getJavaClassNameQualified( ( (MofClass) modelElement ) );
                }
            } else {
                if ( forInterface ) {
                    fname = GeneratorInstance.getJavaInterfaceNameQualified( ( (MofClass) modelElement ) );
                } else {
                    fname = GeneratorInstance.getJavaClassNameQualified( ( (MofClass) modelElement ) );
                }
            }
        } else if ( modelElement instanceof MofPackage ) {
            if ( forInterface ) {
                fname = GeneratorPackage.getJavaInterfaceNameQualified( ( (MofPackage) modelElement ) );
            } else {
                fname = GeneratorPackage.getJavaClassNameQualified( ( (MofPackage) modelElement ) );
            }
        } else if ( modelElement instanceof Association ) {
            if ( forInterface ) {
                fname = GeneratorAssociation.getJavaInterfaceNameQualified( ( (Association) modelElement ) );
            } else {
                fname = GeneratorAssociation.getJavaClassNameQualified( ( (Association) modelElement ) );
            }
        }
        if ( fname == null ) {
            return null;
        } else {
            fname = fname.replace( '.', '/' ) + ".java"; //$NON-NLS-1$
            return pathSources + fname;
        }
    }

    public void generateDeploymentExtension( String metamodelName, String directory, Collection modelElements, int generationMode, OutputStream errorLog ) {

        if ( modelElements == null || modelElements.size( ) < 1 ) {
            return;
        }
        // generate metamodel information provider & deployment extension classes
        switch ( generationMode ) {
            case Generator.GenerationMode.API:
            case Generator.GenerationMode.ALL:
                JavaSourceWriter.writeToDirectory( directory, getGeneratorMetamodelInformationProvider( ).generateTemplate( metamodelName, modelElements ) );
                JavaSourceWriter.writeToDirectory( directory, getGeneratorMetamodelDeploymentExtension( ).generateTemplate( metamodelName ) );
                JavaSourceWriter.writeToDirectory( directory, getGeneratorMetamodelDeploymentExtension( ).generatePropertiesHelperFile( metamodelName ) );
        }
    }

    public void generateJmi( String directory, Collection modelElements, boolean noJavaDocs, int generationMode, OutputStream errorLog ) {

        if ( modelElements == null || modelElements.size( ) < 1 ) {
            return;
        }
        // filter
        Iterator iter = modelElements.iterator( );
        while ( iter.hasNext( ) ) {
            Partitionable partitionable = (Partitionable) iter.next( );
            if ( !( partitionable instanceof ModelElement ) ) {
                iter.remove( );
                continue;
            }
            ModelElement modelElement = (ModelElement) partitionable;
            MofPackage immediatePackage = (MofPackage) modelElement.refImmediatePackage( ).refMetaObject( );
            if ( !immediatePackage.getQualifiedName( ).get( 0 ).equals( GeneratorConstants.NAME_MODEL_PACKAGE ) ) {
                // exclude instances that are not instances of the MOF meta-metamodel, e.g. instances of OCL
                iter.remove( );
                continue;
            }
            if ( ( modelElement instanceof MofPackage ) && ( GeneratorConstants.JMI_IDENTIFIER_OF_PACKAGES_TO_EXCLUDE_FROM_GENERATION.contains( getJMIIdentifierQualified( (Namespace) modelElement ) ) ) ) {
                iter.remove( );
                continue;
            } else if ( ( modelElement instanceof MofClass ) && ( GeneratorConstants.JMI_IDENTIFIER_OF_CLASSES_TO_EXCLUDE_FROM_GENERATION.contains( getJMIIdentifierQualified( (Namespace) modelElement ) ) ) ) {
                iter.remove( );
                continue;
            }
        }
        iter = modelElements.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            try {
                Collection sources = null;
                switch ( generationMode ) {
                    case Generator.GenerationMode.API:
                        sources = generateAPI( directory, me, noJavaDocs );
                        break;
                    case Generator.GenerationMode.IMPLEMENTATION:
                        sources = generateImplementation( directory, me, noJavaDocs );
                        break;
                    case Generator.GenerationMode.ALL:
                        sources = generateAPI( directory, me, noJavaDocs );
                        sources.addAll( generateImplementation( directory, me, noJavaDocs ) );
                }
                // write the sources to the filesystem
                Iterator iterSources = sources.iterator( );
                while ( iterSources.hasNext( ) ) {
                    JavaSource source = (JavaSource) iterSources.next( );
                    if ( source != null && source.getQualifiedName( ) != null && source.getCode( ) != null ) {
                        JavaSourceWriter.writeToDirectory( directory, source );
                    }
                }
            } catch ( RuntimeException runtimeEx ) {
                PrintStream ps = new PrintStream( errorLog );
                ps.println( "Error during the generation of model element " + me.getName( ) + " (" + me + "): " + runtimeEx );
                throw runtimeEx;
            }
        }
    }

    private Collection generateAPI( String directory, ModelElement modelElement, boolean noJavaDocs ) {

        Collection sources = new LinkedList( );
        JavaSource source = null;
        if ( modelElement instanceof MofPackage ) {
            if ( ( source = getGeneratorPackage( ).generateTemplate( (MofPackage) modelElement, noJavaDocs, GenerationKind.INTERFACE ) ) != null ) {
                sources.add( source );
            }
        } else if ( modelElement instanceof MofClass ) {
            if ( ( source = getGeneratorClass( ).generateTemplate( (MofClass) modelElement, noJavaDocs, GenerationKind.INTERFACE ) ) != null ) {
                sources.add( source );
            }
            if ( ( source = getGeneratorInstance( ).generateTemplate( (MofClass) modelElement, noJavaDocs, GenerationKind.INTERFACE ) ) != null ) {
                sources.add( source );
            }
        } else if ( modelElement instanceof Association ) {
            if ( ( source = getGeneratorAssociation( ).generateTemplate( (Association) modelElement, noJavaDocs, GenerationKind.INTERFACE ) ) != null ) {
                sources.add( source );
            }
        } else if ( modelElement instanceof MofException ) {
            if ( ( source = getGeneratorException( ).generateTemplate( (MofException) modelElement, noJavaDocs, GenerationKind.CLASS ) ) != null ) {
                sources.add( source );
            }
        } else if ( modelElement instanceof DataType ) {
            if ( modelElement instanceof EnumerationType ) {
                if ( !( isJavaType( ( (EnumerationType) modelElement ).getName( ) ) ) ) {
                    if ( ( source = getGeneratorEnumerationType( ).generateTemplate( (EnumerationType) modelElement, noJavaDocs, GenerationKind.INTERFACE ) ) != null ) {
                        sources.add( source );
                    }
                    if ( ( source = getGeneratorEnumerationType( ).generateTemplate( (EnumerationType) modelElement, noJavaDocs, GenerationKind.CLASS ) ) != null ) {
                        sources.add( source );
                    }
                }
            } else if ( modelElement instanceof StructureType ) {
                if ( !( isJavaType( ( (StructureType) modelElement ).getName( ) ) ) ) {
                    if ( ( source = getGeneratorStructureType( ).generateTemplate( (StructureType) modelElement, noJavaDocs, GenerationKind.INTERFACE ) ) != null ) {
                        sources.add( source );
                    }
                }
            } else {
                if ( !( isJavaType( ( (DataType) modelElement ).getName( ) ) ) ) {
                    if ( ( source = getGeneratorDataType( ).generateTemplate( (DataType) modelElement, noJavaDocs, GenerationKind.INTERFACE ) ) != null ) {
                        sources.add( source );
                    }
                }
            }
        }
        return sources;
    }

    private Collection generateImplementation( String directory, ModelElement modelElement, boolean noJavaDocs ) {

        Collection sources = new LinkedList( );
        JavaSource source = null;
        if ( modelElement instanceof MofPackage ) {
            if ( ( source = getGeneratorPackage( ).generateTemplate( (MofPackage) modelElement, noJavaDocs, GenerationKind.CLASS ) ) != null ) {
                sources.add( source );
            }
        } else if ( modelElement instanceof MofClass ) {
            if ( ( source = getGeneratorClass( ).generateTemplate( (MofClass) modelElement, noJavaDocs, GenerationKind.CLASS ) ) != null ) {
                sources.add( source );
            }
            if ( ( source = getGeneratorInstance( ).generateTemplate( (MofClass) modelElement, noJavaDocs, GenerationKind.CLASS ) ) != null ) {
                sources.add( source );
            }
        } else if ( modelElement instanceof Association ) {
            if ( ( source = getGeneratorAssociation( ).generateTemplate( (Association) modelElement, noJavaDocs, GenerationKind.CLASS ) ) != null ) {
                sources.add( source );
            }
        } else if ( modelElement instanceof MofException ) {
        } else if ( modelElement instanceof DataType ) {
            if ( modelElement instanceof EnumerationType ) {
            } else if ( modelElement instanceof StructureType ) {
                if ( !( isJavaType( ( (StructureType) modelElement ).getName( ) ) ) ) {
                    if ( ( source = getGeneratorStructureType( ).generateTemplate( (StructureType) modelElement, noJavaDocs, GenerationKind.CLASS ) ) != null ) {
                        sources.add( source );
                    }
                }
            } else {
                if ( !( isJavaType( ( (DataType) modelElement ).getName( ) ) ) ) {
                    if ( ( source = getGeneratorDataType( ).generateTemplate( (DataType) modelElement, noJavaDocs, GenerationKind.CLASS ) ) != null ) {
                        sources.add( source );
                    }
                }
            }
        }
        return sources;
    }

    public static void generatePreamble( StringBuffer code ) {

//    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.ENGLISH);
        code.append( "/**" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( " * This file is generated by the SAP MOIN JMI generator" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( " * Generator version " + GeneratorConstants.GENERATOR_VERSION + Utilities.SystemLineSeparator ); //$NON-NLS-1$
//    code.append(" * Generated on " + df.format(new Date(System.currentTimeMillis())) + Utilities.SystemLineSeparator); //$NON-NLS-1$
        code.append( " **/" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    public static void generateAnnotationTemplate( StringBuffer code, ModelElement modelElement ) {

        String annot = modelElement.getAnnotation( );
        if ( annot != null && annot.length( ) > 4 ) {
            String prefix = annot.substring( 0, 3 );
            // JavaDoc style
            if ( prefix.compareTo( "/**" ) == 0 ) { //$NON-NLS-1$
                code.append( Utilities.SystemLineSeparator );
                code.append( annot );
                code.append( Utilities.SystemLineSeparator );
            } else { // others
                generateComment( code, annot );
            }
        }
    }

    public static void generateComment( StringBuffer code, String str ) {

        if ( str == null || str.length( ) < 1 ) {
            return;
        } // split the annotation into lines
        List lines = splitText( str );
        // start the JavaDoc comment
        code.append( "/**" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // append the lines
        Iterator iter = lines.iterator( );
        while ( iter.hasNext( ) ) {
            String line = (String) iter.next( );
            code.append( " * " + line + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        } // append the end
        code.append( " */" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    private static void generateJavaAnnotationTemplate( StringBuffer code, Set accessors, Set mutators ) {

        // Java annotation
//        code.append( "@JmiInterfaceMetadata(" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
//        code.append( "  accessors = {" ); //$NON-NLS-1$
//        Iterator iter = accessors.iterator( );
//        while ( iter.hasNext( ) ) {
//            code.append( "\"" + (String) iter.next( ) + "\"" );
//            if ( iter.hasNext( ) ) {
//                code.append( ", " );
//            }
//        }
//        code.append( "}," + Utilities.SystemLineSeparator ); //$NON-NLS-1$
//        code.append( "  mutators = {" ); //$NON-NLS-1$
//        iter = mutators.iterator( );
//        while ( iter.hasNext( ) ) {
//            code.append( "\"" + (String) iter.next( ) + "\"" );
//            if ( iter.hasNext( ) ) {
//                code.append( ", " );
//            }
//        }
//        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
//        code.append( ")" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    public static void generateJavaAnnotationTemplateAssociation( StringBuffer code, Association association ) {

        Set accessors = new HashSet( );
        Set mutators = new HashSet( );
        List<AssociationEnd> associationEnds = new ArrayList<AssociationEnd>( );
        Iterator iter = association.getContents( ).iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement modelElement = (ModelElement) iter.next( );
            if ( modelElement instanceof AssociationEnd ) {
                associationEnds.add( (AssociationEnd) modelElement );
            }
        }
        // exists
        accessors.add( "exists" );
        // association end accessors
        if ( associationEnds.get( 0 ).isNavigable( ) ) {
            accessors.add( getAccessorNameForModelElement( associationEnds.get( 0 ) ) );
        }
        if ( associationEnds.get( 1 ).isNavigable( ) ) {
            accessors.add( getAccessorNameForModelElement( associationEnds.get( 1 ) ) );
        }
        // link add
        if ( associationEnds.get( 0 ).isChangeable( ) && associationEnds.get( 1 ).isChangeable( ) ) {
            mutators.add( "add" );
        }
        // link remove
        if ( associationEnds.get( 0 ).isChangeable( ) && associationEnds.get( 1 ).isChangeable( ) ) {
            mutators.add( "remove" );
        }
        // Java annotation
        generateJavaAnnotationTemplate( code, accessors, mutators );
    }

    public static void generateJavaAnnotationTemplateClass( StringBuffer code, MofClass mofClass ) {

        Set accessors = new HashSet( );
        Set mutators = new HashSet( );
        // instance creators
        if ( !mofClass.isAbstract( ) ) {
            mutators.add( getCreatorNameForInstance( mofClass ) );
        }
        Iterator iter = mofClass.getContents( ).iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement modelElement = (ModelElement) iter.next( );
            // structure creators
            if ( modelElement instanceof StructureType ) {
                StructureType structure = (StructureType) modelElement;
                if ( VisibilityKindEnum.PUBLIC_VIS.equals( structure.getVisibility( ) ) ) {
                    mutators.add( getCreatorNameForStructure( structure ) );
                }
            }
            // attribute accessors and mutators
            if ( modelElement instanceof Attribute ) {
                Attribute attribute = (Attribute) modelElement;
                if ( VisibilityKindEnum.PUBLIC_VIS.equals( attribute.getVisibility( ) ) && ScopeKindEnum.CLASSIFIER_LEVEL.equals( attribute.getScope( ) ) ) {
                    accessors.add( Generator.getAccessorNameForTypedElement( attribute ) );
                    if ( attribute.isChangeable( ) && attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                        mutators.add( Generator.getMutatorNameForTypedElement( attribute ) );
                    }
                }
            }
        }
        // Java annotation
        generateJavaAnnotationTemplate( code, accessors, mutators );
    }

    public static void generateJavaAnnotationTemplateInstance( StringBuffer code, MofClass mofClass ) {

        Set accessors = new HashSet( );
        Set mutators = new HashSet( );
        Iterator iter = mofClass.getContents( ).iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement modelElement = (ModelElement) iter.next( );
            // attribute accessors and mutators
            if ( modelElement instanceof Attribute ) {
                Attribute attribute = (Attribute) modelElement;
                if ( VisibilityKindEnum.PUBLIC_VIS.equals( attribute.getVisibility( ) ) && ScopeKindEnum.INSTANCE_LEVEL.equals( attribute.getScope( ) ) ) {
                    accessors.add( Generator.getAccessorNameForTypedElement( attribute ) );
                    if ( attribute.isChangeable( ) && attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                        mutators.add( Generator.getMutatorNameForTypedElement( attribute ) );
                    }
                }
            }
            // reference accessors and mutators
            if ( modelElement instanceof Reference ) {
                Reference reference = (Reference) modelElement;
                if ( VisibilityKindEnum.PUBLIC_VIS.equals( reference.getVisibility( ) ) && ScopeKindEnum.INSTANCE_LEVEL.equals( reference.getScope( ) ) ) {
                    if ( reference.getReferencedEnd( ).isNavigable( ) ) {
                        accessors.add( Generator.getAccessorNameForTypedElement( reference ) );
                        if ( reference.isChangeable( ) && reference.getMultiplicity( ).getUpper( ) == 1 ) {
                            mutators.add( Generator.getMutatorNameForTypedElement( reference ) );
                        }
                    }
                }
            }
        }
        // Java annotation
        generateJavaAnnotationTemplate( code, accessors, mutators );
    }

    public static void generateJavaAnnotationTemplatePackage( StringBuffer code, MofPackage mofPackage ) {

        Set accessors = new HashSet( );
        Set mutators = new HashSet( );
        Iterator iter = mofPackage.getContents( ).iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement modelElement = (ModelElement) iter.next( );
            // clustered packages (imports)
            if ( modelElement instanceof Import ) {
                Import mofImport = (Import) modelElement;
                Namespace importedNamespace = mofImport.getImportedNamespace( );
                if ( mofImport.isClustered( ) && VisibilityKindEnum.PUBLIC_VIS.equals( mofImport.getVisibility( ) ) && VisibilityKindEnum.PUBLIC_VIS.equals( ( (MofPackage) importedNamespace ).getVisibility( ) ) ) {
                    accessors.add( getAccessorNameForModelElement( mofImport ) );
                }
            }
            // nested packages
            if ( modelElement instanceof MofPackage ) {
                MofPackage nestedMofPackage = (MofPackage) modelElement;
                if ( VisibilityKindEnum.PUBLIC_VIS.equals( nestedMofPackage.getVisibility( ) ) ) {
                    accessors.add( getAccessorNameForModelElement( nestedMofPackage ) );
                }
            }
            // classes
            if ( modelElement instanceof MofClass ) {
                MofClass mofClass = (MofClass) modelElement;
                if ( VisibilityKindEnum.PUBLIC_VIS.equals( mofClass.getVisibility( ) ) ) {
                    accessors.add( getAccessorNameForModelElement( mofClass ) );
                }
            }
            // associations
            if ( modelElement instanceof Association ) {
                Association association = (Association) modelElement;
                if ( VisibilityKindEnum.PUBLIC_VIS.equals( association.getVisibility( ) ) ) {
                    accessors.add( getAccessorNameForModelElement( association ) );
                }
            }
            // structure creators
            if ( modelElement instanceof StructureType ) {
                StructureType structure = (StructureType) modelElement;
                if ( VisibilityKindEnum.PUBLIC_VIS.equals( structure.getVisibility( ) ) ) {
                    mutators.add( getCreatorNameForStructure( structure ) );
                }
            }
        }
        // Java annotation
        generateJavaAnnotationTemplate( code, accessors, mutators );
    }

    private static List splitText( String text ) {

        final int LINE_SIZE = 70;
        List list = new ArrayList( 100 );
        int len = text.length( );
        StringBuffer b = new StringBuffer( len );
        // replace \r, keep \n only
        int n = 0;
        for ( int i = 0; i < len; i++ ) {
            char c = text.charAt( i );
            if ( c == '.' ) { // replace the . in i.e. or e.g. by "&#46;"
                // JavaDoc takes the first sentence - everthing up to the
                // first . . But this may be one of the i.e. etc.
                if ( i > 0 && i < ( len - 1 ) && text.charAt( i - 1 ) == 'i' && text.charAt( i + 1 ) == 'e' ) {
                    b.append( "&#46;e&#46;" ); //$NON-NLS-1$
                    i += 2;
                    n += 11;
                } else if ( i > 0 && i < ( len - 1 ) && text.charAt( i - 1 ) == 'e' && text.charAt( i + 1 ) == 'g' ) {
                    b.append( "&#46;g&#46;" ); //$NON-NLS-1$
                    i += 2;
                    n += 11;
                } else {
                    b.append( '.' );
                }
            } else if ( c != '\r' ) {
                b.append( c );
            }
            if ( n > LINE_SIZE && c == ' ' ) {
                b.append( '\n' );
                n = 0;
            }
            n++;
        } // split the lines
        int j = 0;
        for ( int i = 0; i < b.length( ); i++ ) {
            char c = b.charAt( i );
            if ( c == '\n' ) {
                list.add( b.substring( j, i ) );
                j = i + 1;
            } else if ( c == '*' ) {
                list.add( b.substring( j, i ) );
                j = i;
            }
        }
        if ( j < b.length( ) ) {
            list.add( b.substring( j ) );
        }
        return list;
    }

    public static String correctQualifiedName( java.util.List qualifiedName ) {

        StringBuffer b = new StringBuffer( 1024 );
        // package names must be all lower case
        // all beside the last must be packages
        for ( int i = 0; i < qualifiedName.size( ) - 1; i++ ) {
            String s = correctName( (String) qualifiedName.get( i ) );
            b.append( s.toLowerCase( Locale.ENGLISH ) );
            b.append( GeneratorConstants.PACKAGE_DELIMITER );
        }
        b.append( convertFirstCharToUpper( correctName( (String) ( qualifiedName.get( qualifiedName.size( ) - 1 ) ) ) ) );
        return b.toString( );
    }

    public static String correctQualifiedName( String name ) {

        if ( name == null ) {
            return null;
        } else if ( name.length( ) < 3 ) {
            return name;
        }
        return correctQualifiedName( Utilities.getUtilities( ).decodeQualifiedName( name ) );
    }

    private static String correctName( String name ) {

        return correctNameInternal( name, false );
    }

    public static String correctConstant( String name ) {

        return correctNameInternal( name, true ).toUpperCase( Locale.ENGLISH );
    }

    private static String correctNameInternal( String name, boolean forConstant ) {

        if ( name == null ) {
            return null;
        }
        // JMI specification 4.7.1 and 4.7.2 (page 53ff)
        // remove non-sig ::= {'_' | '-' | white-space }
        StringBuilder sb = null;
        StringTokenizer st = new StringTokenizer( name, NON_SIG_CHARS );
        while ( st.hasMoreTokens( ) ) {
            StringBuilder s = correctWord( st.nextToken( ), forConstant );
            if ( s.charAt( 0 ) == '_' ) {
                s = (StringBuilder) s.subSequence( 1, s.length( ) - 1 );
            }
            if ( s.charAt( s.length( ) - 1 ) == '_' ) {
                s = (StringBuilder) s.subSequence( 0, s.length( ) - 1 );
            }
            if ( sb == null ) {
                sb = new StringBuilder( );
            }
            sb.append( s );
            if ( forConstant && st.hasMoreTokens( ) ) {
                sb.append( '_' );
            }
        }
        return sb.toString( );
    }

    private static StringBuilder correctWord( String word, boolean forConstant ) {

        StringBuilder b = new StringBuilder( word.length( ) );
        //s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        // first char must be upper
        // Specification says: All others must be lower
        // Conflict: The word may already contain a 'SmallTalk'-like name with
        // upper/lower
        char cLast = ' ';
        for ( int i = 0; i < word.length( ); i++ ) {
            final char c = word.charAt( i );
            if ( i == 0 ) {
                b.append( Character.toUpperCase( c ) );
            } else {
                if ( Character.isUpperCase( c ) ) {
                    if ( Character.isUpperCase( cLast ) ) {
                        b.append( Character.toLowerCase( c ) );
                    } else {
                        if ( forConstant ) {
                            b.append( '_' );
                        }
                        b.append( c );
                    }
                } else {
                    b.append( c );
                }
            }
            cLast = c;
        }
        return b;
    }

    public static String correctType( String type, boolean isVariable ) {

        String type_ = mapPrimitiveType( type );
        if ( type_.compareTo( type ) == 0 ) {
            type_ = checkName( type, isVariable );
        }
        return type_;
    }

    public static String getType( Classifier classifier ) {

        String type = "java.lang.String"; //$NON-NLS-1$
        if ( classifier instanceof PrimitiveType ) {
            type = mapPrimitiveType( classifier );
        } else if ( classifier instanceof AliasType ) {
            Classifier c = connection.getJmiHelper( ).getNonAliasType( classifier );
            if ( c == null ) {
                type = classifier.getName( );
            } else if ( classifier.equals( c ) ) {
                // UDI -> Alias points to itself !
                type = mapPrimitiveType( classifier );
            } else {
                type = getType( c );
            }
            type = mapPrimitiveType( type );
        } else if ( classifier instanceof EnumerationType ) {
            type = GeneratorEnumerationType.getJavaInterfaceNameQualified( (EnumerationType) classifier );
        } else if ( classifier instanceof CollectionType ) {
            if ( ( (CollectionType) classifier ).getMultiplicity( ).isOrdered( ) ) {
                type = "java.util.List";
            } else {
                type = "java.util.Collection";
            }
        } else {
            type = getJMIIdentifierQualified( classifier );
        }
        return type;
    }

    public static void generateStructureTypeTemplate( StringBuffer code, StructureType structureType, int generationKind ) {

        if ( structureType.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) || generationKind != GenerationKind.INTERFACE ) {
            // structure fields
            Iterator iter = getAllContent( structureType ).iterator( );
            ArrayList fields = new ArrayList( );
            while ( iter.hasNext( ) ) {
                ModelElement me = (ModelElement) iter.next( );
                if ( me instanceof StructureField ) {
                    fields.add( me );
                }
            }
            String creatorName = getCreatorNameForStructure( structureType );
            StringBuffer argumentList = new StringBuffer( );
            iter = fields.iterator( );
            while ( iter.hasNext( ) ) {
                StructureField field = (StructureField) iter.next( );
                argumentList.append( getType( field.getType( ) ) + " " + Generator.getJMIIdentifier( field ) );
                if ( iter.hasNext( ) ) {
                    argumentList.append( ", " ); //$NON-NLS-1$
                }
            }
            code.append( "public " + getJMIIdentifierQualified( structureType ) + " " + creatorName + "(" + argumentList + ")" ); //$NON-NLS-1$
            switch ( generationKind ) {
                case GenerationKind.INTERFACE:
                    code.append( " throws javax.jmi.reflect.JmiException;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    break;
                case GenerationKind.CLASS:
                    code.append( " throws javax.jmi.reflect.JmiException {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "  " + GeneratorStructureType.getJavaClassNameQualified( structureType ) + " result = null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "  try {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "    javax.jmi.model.ModelElement metaObject = ((javax.jmi.model.GeneralizableElement)refMetaObject()).lookupElementExtended(\"" + structureType.getName( ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "    result = new " + GeneratorStructureType.getJavaClassNameQualified( structureType ) + "(get___ClientSpecificWorkspace(), metaObject);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    iter = fields.iterator( );
                    while ( iter.hasNext( ) ) {
                        StructureField field = (StructureField) iter.next( );
                        String internalMutatorName = getInternalMutatorNameForTypedElement( field );
                        code.append( "    result." + internalMutatorName + "(" + Generator.getJMIIdentifier( field ) + ");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    }
                    code.append( "    return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "  catch(javax.jmi.model.NameNotFoundException ex) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "    throw new javax.jmi.reflect.JmiException(ex);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    break;
                case GenerationKind.WRAPPER:
                    // TODO JMI WRAPPER
                    break;
                default:
                    throw new RuntimeException( );
            }
        }
    }

    public static GeneratorPackage getGeneratorPackage( ) {

        if ( generatorPackage == null ) {
            generatorPackage = new GeneratorPackage( );
        }
        return generatorPackage;
    }

    public static GeneratorClass getGeneratorClass( ) {

        if ( generatorClass == null ) {
            generatorClass = new GeneratorClass( );
        }
        return generatorClass;
    }

    public static GeneratorException getGeneratorException( ) {

        if ( generatorException == null ) {
            generatorException = new GeneratorException( );
        }
        return generatorException;
    }

    public static GeneratorInstance getGeneratorInstance( ) {

        if ( generatorInstance == null ) {
            generatorInstance = new GeneratorInstance( );
        }
        return generatorInstance;
    }

    public static GeneratorDataType getGeneratorDataType( ) {

        if ( generatorDataType == null ) {
            generatorDataType = new GeneratorDataType( );
        }
        return generatorDataType;
    }

    public static GeneratorEnumerationType getGeneratorEnumerationType( ) {

        if ( generatorEnumerationType == null ) {
            generatorEnumerationType = new GeneratorEnumerationType( );
        }
        return generatorEnumerationType;
    }

    public static GeneratorStructureType getGeneratorStructureType( ) {

        if ( generatorStructureType == null ) {
            generatorStructureType = new GeneratorStructureType( );
        }
        return generatorStructureType;
    }

    public static GeneratorAssociation getGeneratorAssociation( ) {

        if ( generatorAssociation == null ) {
            generatorAssociation = new GeneratorAssociation( );
        }
        return generatorAssociation;
    }

    public static GeneratorAttributeTemplate getGeneratorAttributeTemplate( ) {

        if ( generatorAttributeTemplate == null ) {
            generatorAttributeTemplate = new GeneratorAttributeTemplate( );
        }
        return generatorAttributeTemplate;
    }

    public static GeneratorReferenceTemplate getGeneratorReferenceTemplate( ) {

        if ( generatorReferenceTemplate == null ) {
            generatorReferenceTemplate = new GeneratorReferenceTemplate( );
        }
        return generatorReferenceTemplate;
    }

    public static GeneratorOperationTemplate getGeneratorOperationTemplate( ) {

        if ( generatorOperationTemplate == null ) {
            generatorOperationTemplate = new GeneratorOperationTemplate( );
        }
        return generatorOperationTemplate;
    }

    public static GeneratorConstantTemplate getGeneratorConstantTemplate( ) {

        if ( generatorConstantTemplate == null ) {
            generatorConstantTemplate = new GeneratorConstantTemplate( );
        }
        return generatorConstantTemplate;
    }

    public static GeneratorStructureFieldTemplate getGeneratorStructureFieldTemplate( ) {

        if ( generatorStructureFieldTemplate == null ) {
            generatorStructureFieldTemplate = new GeneratorStructureFieldTemplate( );
        }
        return generatorStructureFieldTemplate;
    }

    public static GeneratorMetamodelInformationProvider getGeneratorMetamodelInformationProvider( ) {

        if ( generatorMetamodelInformationProvider == null ) {
            generatorMetamodelInformationProvider = new GeneratorMetamodelInformationProvider( );
        }
        return generatorMetamodelInformationProvider;
    }

    public static GeneratorMetamodelDeploymentExtension getGeneratorMetamodelDeploymentExtension( ) {

        if ( generatorMetamodelDeploymentExtension == null ) {
            generatorMetamodelDeploymentExtension = new GeneratorMetamodelDeploymentExtension( );
        }
        return generatorMetamodelDeploymentExtension;
    }

    public static String convertFirstCharToUpper( String input ) {

        if ( input == null ) {
            return null;
        } else if ( input.length( ) < 1 ) {
            return ""; //$NON-NLS-1$
        }
        String output = input.substring( 0, 1 ).toUpperCase( Locale.ENGLISH ) + input.substring( 1 );
        return output;
    }

    public static String convertFirstCharToLower( String input ) {

        String output = input.substring( 0, 1 ).toLowerCase( Locale.ENGLISH ) + input.substring( 1 );
        return output;
    }

    private static String checkName( String name, boolean isVariable ) {

        return checkKeyword( name, isVariable );
    }

    private static String checkKeyword( String name, boolean isVariable ) {

        if ( name == null ) {
            return null;
        }
        initialize( );
        if ( isVariable ) {
            if ( keywordsJava.contains( name.toLowerCase( Locale.ENGLISH ) ) ) {
                return PREFIX_MOF + name; //$NON-NLS-1$
            } else {
                return name;
            }
        } else {
            if ( keywordsJavaForClass.contains( name.toLowerCase( Locale.ENGLISH ) ) ) {
                return PREFIX_MOF + name; //$NON-NLS-1$
            } else {
                return name;
            }
        }
    }

    public static String mapPrimitiveType( Classifier classifier ) {

//    String javaType = null;
//    Namespace container = classifier.getContainer();
//    if(classifier instanceof PrimitiveType && container != null && container.getName().compareTo(GeneratorConstants.NAME_PRIMITIVE_TYPES_PACKAGE) != 0) {
//      String qn = Utilities.getUtilities().encodeQualifiedName(classifier.getQualifiedName());
//      if(qn.indexOf("java.lang.") == 0) { //$NON-NLS-1$
//        javaType = qn;
//      }
//      else {
//        javaType = getJMIIdentifier(classifier);
//      }
//    }
//    else {
//      javaType = mapPrimitiveType(classifier.getName());
//    }
//    return javaType;
        return mapPrimitiveType( classifier.getName( ) );
    }

    public static String mapPrimitiveType( String dataTypeName ) {

        String javaType = dataTypeName;
        if ( isJavaType( dataTypeName.toLowerCase( Locale.ENGLISH ) ) && dataTypeMappings.containsKey( dataTypeName.toLowerCase( Locale.ENGLISH ) ) ) {
            javaType = (String) dataTypeMappings.get( dataTypeName.toLowerCase( Locale.ENGLISH ) );
        }
        return javaType;
    }

    /**
     * Checks if the given MOF datatype name has a mapping to a Java type.
     * 
     * @see #tableDataTypeMappings
     * @see #dataTypeMappings
     */
    public static boolean isJavaType( String dataTypeName ) {

        if ( dataTypeName == null ) {
            return false;
        }
        if ( dataTypeMappings == null ) {
            initialize( );
        }
        if ( dataTypeName.toLowerCase( Locale.ENGLISH ).compareTo( "int" ) == 0 ) { //$NON-NLS-1$
            return true;
        }
        return dataTypeMappings.containsKey( dataTypeName.toLowerCase( Locale.ENGLISH ) );
    }

    public static String getJavaTypeClass( String dataTypeName ) {

        String dtn = dataTypeName;
        if ( isJavaType( dtn ) ) {
            dtn = mapPrimitiveType( dtn );
            if ( dtn.compareTo( "int" ) == 0 ) { //$NON-NLS-1$
                dtn = "java.lang.Integer"; //$NON-NLS-1$
            }
            if ( dtn.indexOf( '.' ) >= 0 ) {
                return dtn;
            } else {
                return "java.lang." + dtn.substring( 0, 1 ).toUpperCase( Locale.ENGLISH ) + dtn.substring( 1 ).toLowerCase( Locale.ENGLISH );
            }
        } else {
            return dtn;
        }
    }

    public static String getJavaReturnInitialValueByType( String type ) {

        String str = "null"; //$NON-NLS-1$
        if ( type.compareToIgnoreCase( "boolean" ) == 0 ) { //$NON-NLS-1$
            str = "false"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "unlimitedinteger" ) == 0 ) { //$NON-NLS-1$
            str = "0"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "integer" ) == 0 ) { //$NON-NLS-1$
            str = "0"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "int" ) == 0 ) { //$NON-NLS-1$
            str = "0"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "long" ) == 0 ) { //$NON-NLS-1$
            str = "0l"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "float" ) == 0 ) { //$NON-NLS-1$
            str = "0f"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "double" ) == 0 ) { //$NON-NLS-1$
            str = "0d"; //$NON-NLS-1$
        }
        return str;
    }

    public static String getJavaTypeGetValue( String type ) {

        String str = null;
        if ( type.compareToIgnoreCase( "boolean" ) == 0 ) { //$NON-NLS-1$
            str = "booleanValue()"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "unlimitedinteger" ) == 0 ) { //$NON-NLS-1$
            str = "intValue()"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "integer" ) == 0 ) { //$NON-NLS-1$
            str = "intValue()"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "int" ) == 0 ) { //$NON-NLS-1$
            str = "intValue()"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "long" ) == 0 ) { //$NON-NLS-1$
            str = "longValue()"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "float" ) == 0 ) { //$NON-NLS-1$
            str = "floatValue()"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "double" ) == 0 ) { //$NON-NLS-1$
            str = "doubleValue()"; //$NON-NLS-1$
        }
        return str;
    }

    public static String getJavaTypeAsObject( String type, String variable ) {

        String str = variable;
        if ( type == null ) {
            str = variable;
        } else if ( type.compareToIgnoreCase( "boolean" ) == 0 ) { //$NON-NLS-1$
            str = "new java.lang.Boolean(" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "unlimitedinteger" ) == 0 ) { //$NON-NLS-1$
            str = "new java.lang.Integer(" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "int" ) == 0 ) { //$NON-NLS-1$
            str = "new java.lang.Integer(" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "integer" ) == 0 ) { //$NON-NLS-1$
            str = "new java.lang.Integer(" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "long" ) == 0 ) { //$NON-NLS-1$
            str = "new java.lang.Long(" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "float" ) == 0 ) { //$NON-NLS-1$
            str = "new java.lang.Float(" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "double" ) == 0 ) { //$NON-NLS-1$
            str = "new java.lang.Double(" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        }
        return str;
    }

    public static String getJavaTypeToString( String type, String variable ) {

        String str = variable + ".toString()";
        if ( type == null ) {
            str = variable;
        } else if ( type.compareToIgnoreCase( "boolean" ) == 0 || type.compareToIgnoreCase( "unlimitedinteger" ) == 0 || type.compareToIgnoreCase( "int" ) == 0 || type.compareToIgnoreCase( "integer" ) == 0 || type.compareToIgnoreCase( "long" ) == 0 || type.compareToIgnoreCase( "float" ) == 0
                    || type.compareToIgnoreCase( "double" ) == 0 ) { //$NON-NLS-1$
            str = getJavaTypeAsObject( type, variable ) + ".toString()"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "java.util.Collection" ) == 0 || type.compareToIgnoreCase( "java.util.List" ) == 0 ) {
            str = "java.util.Arrays.asList(" + variable + ").toString()"; //$NON-NLS-1$
        } else if ( type.endsWith( "[]" ) ) {
            str = "java.util.Arrays.toString(" + variable + ")"; //$NON-NLS-1$
        }
        return str;
    }

    public static String getJavaObjectFromString( String type, String variable ) {

        String str = variable;
        if ( type == null ) {
            str = variable;
        } else if ( type.compareToIgnoreCase( "boolean" ) == 0 ) { //$NON-NLS-1$
            str = "java.lang.Boolean.valueOf((java.lang.String)" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "unlimitedinteger" ) == 0 ) { //$NON-NLS-1$
            str = "java.lang.Integer.valueOf((java.lang.String)" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "int" ) == 0 ) { //$NON-NLS-1$
            str = "java.lang.Integer.valueOf((java.lang.String)" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "integer" ) == 0 ) { //$NON-NLS-1$
            str = "java.lang.Integer.valueOf((java.lang.String)" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "long" ) == 0 ) { //$NON-NLS-1$
            str = "java.lang.Long.valueOf((java.lang.String)" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "float" ) == 0 ) { //$NON-NLS-1$
            str = "java.lang.Float.valueOf((java.lang.String)" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "double" ) == 0 ) { //$NON-NLS-1$
            str = "java.lang.Double.valueOf((java.lang.String)" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else {
            str = type + ".valueOf(" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        }
        return str;
    }

    public static List getAllSupertypes( com.sap.tc.moin.repository.mmi.model.GeneralizableElement generalizableElement ) {

        return connection.getJmiHelper( ).getAllSupertypes( generalizableElement );
    }

    public static List getAllContent( ModelElement modelElement ) {

        SpiJmiHelper jmiHelper = getCoreConnection( ).getCoreJmiHelper( );
        List<ModelElement> allContent = jmiHelper.getAllContent( connection, (com.sap.tc.moin.repository.mmi.model.Namespace) modelElement );
        return (List) getCoreConnection( ).getSession( ).getWorkspaceSet( ).getWrapperManager( ).wrapObject( getCoreConnection( ), allContent );
    }

    public static Collection getAllEnumerationLabels( EnumerationType enumerationType ) {

        SpiJmiHelper jmiHelper = getCoreConnection( ).getCoreJmiHelper( );
        return jmiHelper.getAllEnumerationLabels( enumerationType );
    }

    public static CoreConnection getCoreConnection( ) {

        return ( (Wrapper<CoreConnection>) connection ).unwrap( );
    }

    public static String getAttributeType( Attribute attribute ) {

        String type = null;
        if ( attribute.getMultiplicity( ).getLower( ) == 0 && attribute.getMultiplicity( ).getUpper( ) == 1 ) {
            // optional, e.g. int has to become Integer to be able to initialize it with null
            type = getJavaTypeClass( getType( attribute.getType( ) ) );
        } else if ( attribute.getMultiplicity( ).getLower( ) == 1 && attribute.getMultiplicity( ).getUpper( ) == 1 ) {
            type = getType( attribute.getType( ) );
        } else {
            if ( !( attribute.getMultiplicity( ).isOrdered( ) ) ) {
                type = "java.util.Collection"; //$NON-NLS-1$
            } else {
                type = "java.util.List"; //$NON-NLS-1$
            }
        }
        return type;
    }

    public static String getReferenceType( Reference reference ) {

        String typeOfReference = null;
        String referenceType = getType( reference.getType( ) );
        if ( reference.getMultiplicity( ).getUpper( ) == 1 ) {
            typeOfReference = referenceType;
        } else { // if upper > 1 (or < 0 means infinity) and isOrdered = false
            if ( !( reference.getMultiplicity( ).isOrdered( ) ) ) {
                typeOfReference = "java.util.Collection"; //$NON-NLS-1$
                // if upper > 1 and isOrdered = true
            } else {
                typeOfReference = "java.util.List"; //$NON-NLS-1$
            }
        }
        return typeOfReference;
    }

    public static String getParameterType( Parameter parameter ) {

        String type = null;
        if ( parameter.getMultiplicity( ).getLower( ) == 0 && parameter.getMultiplicity( ).getUpper( ) == 1 ) {
            // optional
            type = getJavaTypeClass( getType( parameter.getType( ) ) );
        } else if ( parameter.getMultiplicity( ).getLower( ) == 1 && parameter.getMultiplicity( ).getUpper( ) == 1 ) {
            type = getType( parameter.getType( ) );
        } else {
            if ( !parameter.getMultiplicity( ).isOrdered( ) ) {
                type = "java.util.Collection"; //$NON-NLS-1$
            } else {
                type = "java.util.List"; //$NON-NLS-1$
            }
        }
        return type;
    }

    /**
     * Description of the Method
     * 
     * @param code Description of the Parameter
     */
    public static void generateDefaultIncludes( StringBuffer code, ModelElement modelElement, int generationKind ) {

        // includes
        code.append( "import java.util.ArrayList;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import java.util.Collection;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import java.util.HashMap;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import java.util.Iterator;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import java.util.List;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import java.util.Map;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import javax.jmi.reflect.ClosureViolationException;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import javax.jmi.reflect.InvalidCallException;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import javax.jmi.reflect.InvalidNameException;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import javax.jmi.reflect.JmiException;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import javax.jmi.reflect.RefAssociation;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import javax.jmi.reflect.RefBaseObject;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import javax.jmi.reflect.RefClass;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import javax.jmi.reflect.RefEnum;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import javax.jmi.reflect.RefFeatured;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import javax.jmi.reflect.RefObject;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import javax.jmi.reflect.RefPackage;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import javax.jmi.reflect.RefStruct;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "import javax.jmi.reflect.TypeMismatchException;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // MOIN specific includes
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
//                code.append( "import " + MOIN_PACKAGE + ".JmiInterfaceMetadata;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
//                code.append( "" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.CLASS:
            case Generator.GenerationKind.WRAPPER:
                // not for exceptions
                if ( modelElement instanceof MofException ) {
                    break;
                }
                // not for enumerations
                if ( modelElement instanceof EnumerationType ) {
                    break;
                } else {
                    code.append( "import " + MOIN_JMI_UTIL_PACKAGE + ".JmiHelper;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "import " + MOIN_EVENTS_PACKAGE + ".ElementCreateEvent;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "import " + MOIN_EVENTS_PACKAGE + ".AttributeValueChangeEvent;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "import " + MOIN_REPOSITORY_PACKAGE + ".Partitionable;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    break;
                }
        }
    }

    private static void addSetCaseStatement( boolean isGeneratingClassProxy, StringBuffer code, Iterator iter, Map mapConstants ) {

        while ( iter.hasNext( ) ) {
            StructuralFeature sf = (StructuralFeature) iter.next( );
            Integer featureId = (Integer) mapConstants.get( sf.getName( ) );
            if ( ( !isGeneratingClassProxy && ScopeKindEnum.INSTANCE_LEVEL.equals( sf.getScope( ) ) ) || ( isGeneratingClassProxy && ScopeKindEnum.CLASSIFIER_LEVEL.equals( sf.getScope( ) ) ) ) {
                code.append( "    case " + featureId + ":" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                if ( sf.getType( ) != null ) {
                    String variable = composeVariableName( getJMIIdentifier( sf ) );
                    if ( sf instanceof Attribute ) {
                        code.append( getDataSetStatement( variable, (Attribute) sf, getAttributeType( (Attribute) sf ) ) );
                    } else if ( sf instanceof Reference ) {
                        code.append( getDataSetStatement( variable, (Reference) sf ) );
                    }
                }
                code.append( "      break;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
        }
    }

    private static void addInternalSetCaseStatementForStructureField( StringBuffer code, Iterator iter, Map mapConstants ) {

        while ( iter.hasNext( ) ) {
            StructureField field = (StructureField) iter.next( );
            String internalMutatorName = getInternalMutatorNameForTypedElement( field );
            Integer featureId = (Integer) mapConstants.get( field.getName( ) );
            code.append( "    case " + featureId + ":" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            if ( field.getType( ) != null ) {
                String type = mapPrimitiveType( field.getType( ) );
                String typeQualified = getType( field.getType( ) );
                if ( isJavaType( type ) ) {
                    String getMethod = getJavaTypeGetValue( type );
                    code.append( "      " + internalMutatorName + "(((" + getJavaTypeClass( type ) + ")value)" + ( getMethod != null ? "." + getMethod : "" ) + ");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                } else {
                    code.append( "      " + internalMutatorName + "((" + typeQualified + ")value);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                }
            }
            code.append( "      break;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        }
    }

    private static void addInternalSetCaseStatementForStructuralFeature( boolean isGeneratingClassProxy, StringBuffer code, Iterator iter, Map mapConstants ) {

        while ( iter.hasNext( ) ) {
            StructuralFeature sf = (StructuralFeature) iter.next( );
            Integer featureId = (Integer) mapConstants.get( sf.getName( ) );
            if ( ( !isGeneratingClassProxy && ScopeKindEnum.INSTANCE_LEVEL.equals( sf.getScope( ) ) ) || ( isGeneratingClassProxy && ScopeKindEnum.CLASSIFIER_LEVEL.equals( sf.getScope( ) ) ) ) {
                code.append( "    case " + featureId + ":" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                String internalMutatorName = getInternalMutatorNameForTypedElement( sf );
                if ( sf.getType( ) != null ) {
                    String variable = composeVariableName( getJMIIdentifier( sf ) );
                    String typeQualified = null;
                    if ( sf instanceof Attribute ) {
                        Attribute attribute = (Attribute) sf;
                        if ( attribute.isDerived( ) ) {
                            if ( attribute.isChangeable( ) && attribute.getMultiplicity( ).getUpper( ) == 1 ) {
                                typeQualified = getAttributeType( attribute );
                                String type = mapPrimitiveType( attribute.getType( ) );
                                if ( isJavaType( type ) ) {
                                    if ( attribute.getMultiplicity( ).getLower( ) == 0 ) {
                                        // optional attribute
                                        code.append( "      " + internalMutatorName + "((" + typeQualified + ")value);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                                    } else {
                                        String getMethod = getJavaTypeGetValue( type );
                                        code.append( "      " + internalMutatorName + "(((" + getJavaTypeClass( type ) + ")value)" + ( getMethod != null ? "." + getMethod : "" ) + ");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                                    }
                                } else {
                                    code.append( "      " + internalMutatorName + "((" + typeQualified + ")value);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                                }
                            }
                        } else {
                            typeQualified = getAttributeType( attribute );
                            String type = mapPrimitiveType( attribute.getType( ) );
                            if ( sf.getMultiplicity( ).getUpper( ) != 1 ) {
                                code.append( "      " + internalMutatorName + "((" + typeQualified + ")value);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                            } else {
                                if ( isJavaType( type ) ) {
                                    if ( attribute.getMultiplicity( ).getLower( ) == 0 ) {
                                        // optional attribute
                                        code.append( "      " + internalMutatorName + "((" + typeQualified + ")value);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                                    } else {
                                        String getMethod = getJavaTypeGetValue( type );
                                        code.append( "      " + internalMutatorName + "(((" + getJavaTypeClass( type ) + ")value)" + ( getMethod != null ? "." + getMethod : "" ) + ");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                                    }
                                } else {
                                    code.append( "      " + internalMutatorName + "((" + typeQualified + ")value);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                                }
                            }
                        }
                    } else if ( sf instanceof Reference ) {
                        Reference reference = (Reference) sf;
                        AssociationEnd associationEnd = reference.getReferencedEnd( );
                        Association association = (Association) associationEnd.getContainer( );
                        // AssociationEnd must be navigable (see JMI 1.0 standard 4.8.6 NOTE)
                        if ( associationEnd.isNavigable( ) ) {
                            if ( association.isDerived( ) && reference.isChangeable( ) && reference.getMultiplicity( ).getUpper( ) == 1 ) {
                                typeQualified = getReferenceType( reference );
                                code.append( "      " + internalMutatorName + "((" + typeQualified + ")value);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                            }
                        }
                    }
                }
                code.append( "      break;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
        }
    }

    private static int addGetCaseStatementForExtents( StringBuffer code, Iterator iter, Map mapConstants ) {

        int caseStatementsAdded = 0;
        while ( iter.hasNext( ) ) {
            ModelElement element = (ModelElement) iter.next( );
            Integer elementId = (Integer) mapConstants.get( element.getName( ) );
            code.append( "      case " + elementId + ":" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            caseStatementsAdded++;
            if ( element instanceof MofClass ) {
                code.append( "        result = new " + GeneratorClass.getJavaClassNameQualified( (MofClass) element ) + "(workspace, mofId, immediatePackage, metaObject);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
            if ( element instanceof Association ) {
                code.append( "        result = new " + GeneratorAssociation.getJavaClassNameQualified( (Association) element ) + "(workspace, mofId, immediatePackage, metaObject);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
            if ( element instanceof MofPackage ) {
                code.append( "        result = new " + GeneratorPackage.getJavaClassNameQualified( (MofPackage) element ) + "(workspace, mofId, immediatePackage, metaObject);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
            if ( element instanceof Import ) {
                code.append( "        result = new " + GeneratorPackage.getJavaClassNameQualified( (MofPackage) ( (Import) element ).getImportedNamespace( ) ) + "(workspace, mofId, immediatePackage, metaObject);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
            code.append( "        break;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        }
        return caseStatementsAdded;
    }

    private static int addGetCaseStatementForStructureField( StringBuffer code, Iterator iter, Map mapConstants ) {

        int caseStatementsAdded = 0;
        while ( iter.hasNext( ) ) {
            StructureField field = (StructureField) iter.next( );
            String accessorName = getAccessorNameForTypedElement( field );
            Integer fieldId = (Integer) mapConstants.get( field.getName( ) );
            code.append( "    case " + fieldId + ":" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            caseStatementsAdded++;
            if ( field.getType( ) != null ) {
                String variable = composeVariableName( field.getName( ) );
                code.append( "      result = " + getDataReturnStatementForStructureField( variable, field ) + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
            code.append( "      break;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        }
        return caseStatementsAdded;
    }

    private static int addGetCaseStatementForStructuralFeature( boolean isGeneratingClassProxy, StringBuffer code, Iterator iter, Map mapConstants ) {

        int caseStatementsAdded = 0;
        while ( iter.hasNext( ) ) {
            StructuralFeature sf = (StructuralFeature) iter.next( );
            String accessorName = getAccessorNameForTypedElement( sf );
            if ( ( !isGeneratingClassProxy && ScopeKindEnum.INSTANCE_LEVEL.equals( sf.getScope( ) ) ) || ( isGeneratingClassProxy && ScopeKindEnum.CLASSIFIER_LEVEL.equals( sf.getScope( ) ) ) ) {
                Integer featureId = (Integer) mapConstants.get( sf.getName( ) );
                code.append( "    case " + featureId + ":" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                caseStatementsAdded++;
                if ( sf.getType( ) != null ) {
                    String variable = composeVariableName( getJMIIdentifier( sf ) );
                    code.append( "      result = " + getDataReturnStatementForStructuralFeature( variable, sf ) + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                }
                code.append( "      break;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
        }
        return caseStatementsAdded;
    }

    private static String getDataSetStatement( String variable, Attribute attribute, String typeQualified ) {

        StringBuffer buf = new StringBuffer( 100 );
        if ( attribute.isDerived( ) ) {
            buf.append( "      ___changeAttributeDerived(featureName, value);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        } else if ( attribute.getType( ) instanceof MofClass ) {
            buf.append( "      ___changeObjectAttribute(featureName, value);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        } else {
            buf.append( "      ___changeDataTypeAttribute(featureName, value);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        }
        return buf.toString( );
    }

    private static String getDataSetStatement( String variable, Reference reference ) {

        StringBuffer buf = new StringBuffer( 100 );
        if ( ( (Association) reference.getExposedEnd( ).getContainer( ) ).isDerived( ) ) {
            buf.append( "      ___changeReferenceDerived(featureName, value);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        } else {
            buf.append( "      ___changeReference(featureName, value);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        }
        return buf.toString( );
    }

    private static String getDataReturnStatementForStructureField( String variable, StructureField aStructureField ) {

        String type = mapPrimitiveType( aStructureField.getType( ) );
        StringBuffer buf = new StringBuffer( 100 );
        String accessorName = getAccessorNameForTypedElement( aStructureField );
        if ( isJavaType( type ) ) { //$NON-NLS-1$
            buf.append( "new " + getJavaTypeClass( type ) + "(" + accessorName + "());" ); //$NON-NLS-1$
        } else {
            buf.append( accessorName + "();" );
        }
        return buf.toString( );
    }

    private static String getDataReturnStatementForStructuralFeature( String variable, StructuralFeature sf ) {

        String type = mapPrimitiveType( sf.getType( ) );
        String mofTypeName = sf.getType( ).getName( );
        StringBuffer buf = new StringBuffer( 100 );
        String accessorName = getAccessorNameForTypedElement( sf );
        if ( sf instanceof Attribute && ( (Attribute) sf ).isDerived( ) ) {
            if ( sf.getMultiplicity( ).getUpper( ) == 1 && isJavaType( type ) && !mofTypeName.equalsIgnoreCase( "name" ) && !mofTypeName.equalsIgnoreCase( "string" ) && !mofTypeName.equalsIgnoreCase( "time" ) ) { //$NON-NLS-1$
                buf.append( getJavaTypeAsObject( getAttributeType( (Attribute) sf ), accessorName + "()" ) + ";" ); //$NON-NLS-1$
            } else {
                buf.append( accessorName + "();" );
            }
        } else if ( sf.getMultiplicity( ).getUpper( ) != 1 || ( sf.getMultiplicity( ).getLower( ) == 0 && sf.getMultiplicity( ).getUpper( ) == 1 ) ) {
            buf.append( accessorName + "();" );
        } else if ( type.compareToIgnoreCase( "any" ) == 0 ) { //$NON-NLS-1$
            buf.append( accessorName + "();" );
        } else if ( isJavaType( type ) && !mofTypeName.equalsIgnoreCase( "name" ) && !mofTypeName.equalsIgnoreCase( "string" ) && !mofTypeName.equalsIgnoreCase( "time" ) ) { //$NON-NLS-1$
            buf.append( "new " + getJavaTypeClass( type ) + "(" + accessorName + "());" ); //$NON-NLS-1$
        } else {
            buf.append( accessorName + "();" );
        }
        return buf.toString( );
    }

    public static String composeVariableName( String name ) {

        return VARIABLE_PREFIX + convertFirstCharToLower( checkKeyword( name, true ) );
    }

    private static void generateTemplateRefBaseObject( StringBuffer code, ModelElement modelElement, String javaClassName, String javaInterfaceNameQualified, boolean isGeneratingClassProxy, int generationKind ) {

        generateTemplatePartitionable( code, modelElement, javaClassName, javaInterfaceNameQualified, isGeneratingClassProxy, generationKind );
    }

    private static void generateTemplatePartitionable( StringBuffer code, ModelElement modelElement, String javaClassName, String javaInterfaceNameQualified, boolean isGeneratingClassProxy, int generationKind ) {

        code.append( "// Partitionable" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "public Class get___JmiInterface() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  return " + javaInterfaceNameQualified + ".class;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    public static void generateTemplateRefAssociationDecl( StringBuffer code, Association association, String javaClassName, int generationKind ) {

        generateTemplateDeclDefault( code, association, javaClassName );
        code.append( "// specific constructor" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "public " + javaClassName + "(Object workspace, String mofId, RefPackage immediatePackage, RefObject metaObject) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  super(workspace, mofId, immediatePackage, metaObject);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    public static void generateTemplateRefAssociation( StringBuffer code, Association association, String javaClassName, String javaInterfaceNameQualified, int generationKind ) {

        // RefBaseObject
        generateTemplateRefBaseObject( code, association, javaClassName, javaInterfaceNameQualified, false, generationKind );
        // RefAssociation
        generateAssociationDynamicTemplates( code, association );
    }

    private static void generateAssociationDynamicTemplates( StringBuffer code, Association association ) {

        AssociationEnd end0 = null;
        AssociationEnd end1 = null;
        Iterator iter = association.getContents( ).iterator( );
        while ( iter.hasNext( ) && ( end0 == null || end1 == null ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof AssociationEnd ) {
                if ( end0 == null ) {
                    end0 = (AssociationEnd) me;
                } else if ( end1 == null ) {
                    end1 = (AssociationEnd) me;
                }
            }
        }
        String end0NameU = Generator.convertFirstCharToUpper( Generator.getJMIIdentifier( end0 ) );
        String end1NameU = Generator.convertFirstCharToUpper( Generator.getJMIIdentifier( end1 ) );
        String end0Name = "_" + Generator.getJMIIdentifier( end0 );
        String end1Name = "_" + Generator.getJMIIdentifier( end1 );
        String accessor0Name = "get" + end0NameU;
        String accessor1Name = "get" + end1NameU;
        String ___addName = "___add";
        if ( association.isDerived( ) ) {
            String type0 = GeneratorInstance.getJavaInterfaceNameQualified( (MofClass) end0.getType( ) );
            String type1 = GeneratorInstance.getJavaInterfaceNameQualified( (MofClass) end1.getType( ) );
            code.append( "// RefAssociation methods are delegated to specific ones for derived associations" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            // ___exists
            code.append( "protected boolean ___exists(RefObject firstEnd, RefObject secondEnd) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            code.append( "  return exists((" + type0 + ")firstEnd, (" + type1 + ")secondEnd);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            if ( end0.isChangeable( ) && end1.isChangeable( ) ) {
                // add___AssociationEnds
                code.append( "public boolean add___AssociationEnds(RefObject firstEnd, RefObject secondEnd, javax.jmi.model.Reference addedViaReference) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "  return ___add((" + type0 + ")firstEnd, (" + type1 + ")secondEnd, addedViaReference);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                // ___add
                String argumentList = type0 + " " + end0Name + ", " + type1 + " " + end1Name + ", javax.jmi.model.Reference _AddedViaReference";
                code.append( "private boolean " + ___addName + "(" + argumentList + ") {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                Tag bodyTag = Generator.getTag( association, GeneratorConstants.TAG_OPERATION_CODE_ADD_JAVA );
                if ( bodyTag != null ) {
                    code.append( "  // begin of implementation provided in tag " + GeneratorConstants.TAG_OPERATION_CODE_ADD_JAVA + Utilities.SystemLineSeparator );
                    code.append( (String) bodyTag.getValues( ).get( 0 ) + Utilities.SystemLineSeparator );
                    code.append( "  // end of implementation provided in tag " + GeneratorConstants.TAG_OPERATION_CODE_ADD_JAVA + Utilities.SystemLineSeparator );
                } else {
                    code.append( "  // missing an implementation provided in tag " + GeneratorConstants.TAG_OPERATION_CODE_ADD_JAVA + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                    code.append( "  return false;" + Utilities.SystemLineSeparator ); //$NON-NLS-2$
                }
                code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                // ___remove
                code.append( "protected boolean ___remove(RefObject firstEnd, RefObject secondEnd) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "  return remove((" + type0 + ")firstEnd, (" + type1 + ")secondEnd);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
            // ___query
            code.append( "protected Collection ___query(String queryEndName, RefObject queryObject) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            if ( end0.isNavigable( ) || end1.isNavigable( ) ) {
                code.append( "  java.util.Collection result = new java.util.ArrayList();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                if ( end0.isNavigable( ) ) {
                    code.append( "  if(queryEndName.equals(\"" + end1.getName( ) + "\")) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    if ( end0.getMultiplicity( ).getUpper( ) != 1 ) {
                        code.append( "    result.addAll(" + accessor0Name + "((" + type1 + ")queryObject));" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    } else {
                        code.append( "    result.add(" + accessor0Name + "((" + type1 + ")queryObject));" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    }
                    code.append( "    return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                }
                if ( end1.isNavigable( ) ) {
                    code.append( "  if(queryEndName.equals(\"" + end0.getName( ) + "\")) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    if ( end1.getMultiplicity( ).getUpper( ) != 1 ) {
                        code.append( "    result.addAll(" + accessor1Name + "((" + type0 + ")queryObject));" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    } else {
                        code.append( "    result.add(" + accessor1Name + "((" + type0 + ")queryObject));" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    }
                    code.append( "    return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                }
                code.append( "  else {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    throw new InvalidCallException(queryEndName, null);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            } else {
                code.append( "  // no end is navigable" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "  throw new InvalidCallException(queryEndName, null);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
            code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        }
    }

    public static void generateTemplateRefClassDecl( StringBuffer code, ModelElement modelElement, String javaClassName, int generationKind ) {

        // RefFeatured
        generateTemplateRefFeaturedDecl( code, modelElement, javaClassName, generationKind );
    }

    public static void generateTemplateRefClass( StringBuffer code, MofClass mofClass, String javaClassName, String javaInterfaceNameQualified, int generationKind ) {

        // RefFeatured
        generateTemplateRefFeatured( code, mofClass, javaClassName, javaInterfaceNameQualified, true, generationKind );
        // RefClass
        generateCreateRefEnum( code, mofClass );
        generateCreateRefStruct( code, mofClass );
        // add specific methods
        generateRefClassMethods( code, mofClass, generationKind );
    }

    private static void generateRefClassMethods( StringBuffer code, MofClass mofClass, int generationKind ) {

        code.append( "// correct the null values in the constructor arguments list" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "protected java.util.List correctConstructorArgs(java.util.List args) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  if (args == null) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    return null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  List list = new ArrayList();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  Object o = null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  Iterator i = args.iterator();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        java.util.Iterator i = getAttributeList( mofClass, generationKind ).iterator( );
        while ( i.hasNext( ) ) {
            AttributeWithType awt = (AttributeWithType) i.next( );
            Attribute a = awt.getAttribute( );
            String initStatement = null;
            if ( a.getMultiplicity( ).getLower( ) == 1 && a.getMultiplicity( ).getUpper( ) == 1 ) {
                Classifier type = a.getType( );
                if ( type.getName( ).compareToIgnoreCase( "string" ) != 0 && isJavaType( type.getName( ) ) ) {
                    String var = getJavaReturnInitialValueByType( type.getName( ) );
                    initStatement = getJavaTypeAsObject( type.getName( ), var );
                }
            }
            if ( initStatement != null ) {
                code.append( "  if (i.hasNext()) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    o = i.next();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    if (o == null) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "      list.add(" + initStatement + ");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    else {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "      list.add(o);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            } else {
                code.append( "  if (i.hasNext()) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    list.add(i.next());" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
        }
        code.append( "  return list;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    private static void generateTemplateRefFeaturedDecl( StringBuffer code, ModelElement modelElement, String javaClassName, int generationKind ) {

        generateTemplateDeclDefault( code, modelElement, javaClassName );
        code.append( "// specific constructor" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "public " + javaClassName + "(Object workspace, String mofId, RefPackage immediatePackage, RefObject metaObject) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  super(workspace, mofId, immediatePackage, metaObject);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    public static void generateTemplateRefStruct( StringBuffer code, StructureType aStructureType, String javaClassName, int generationKind ) {

        Iterator iter = getAllContent( aStructureType ).iterator( );
        ArrayList fields = new ArrayList( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof StructureField ) {
                fields.add( me );
            }
        }
        // structure fields as constants
        Map mapConstants = new HashMap( );
        generateTemplateInnerClassForModelElements( code, fields, mapConstants );
        // set___Value
        code.append( "// set the value internally" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "public void set___Value(String featureName, Object value) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  switch (___FeatureId.featureIds.get(featureName)) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        addInternalSetCaseStatementForStructureField( code, fields.iterator( ), mapConstants );
        code.append( "    default:" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "      throw new InvalidCallException(featureName, null, \"set___Value()\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // refGetValue
        code.append( "// get a value" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "public Object refGetValue(String featureName) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  Object result = null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  java.lang.Integer featureId = ___FeatureId.featureIds.get(featureName);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  if (featureName == null) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    throw new InvalidNameException(featureName, \"Can not return the value of the feature with the given name. The name was null.\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  if (featureId == null) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code
            .append( "    throw new InvalidCallException(featureName, get___MetaObject(), \"Can not return the value of the feature with the given name. The class \" + ((javax.jmi.model.StructureType)get___MetaObject()).getName() + \" does not have a feature with the name \\\"\" + featureName + \"\\\".\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  switch (featureId) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        int caseStatementsAdded = addGetCaseStatementForStructureField( code, fields.iterator( ), mapConstants );
        code.append( "    default:" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "      throw new InvalidCallException(featureName, null, \"refGetValue()\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // if we wouldn't have case statements we would only throw an exception, the return statement would be unreachable,
        // so only generate a return statement if case statements exist
        if ( caseStatementsAdded > 0 ) {
            code.append( " return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        }
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        //    // get___FieldValues
        //    code.append("// get field values internally" + Utilities.SystemLineSeparator); //$NON-NLS-1$
        //    code.append("protected Map get___FieldValues() {" + Utilities.SystemLineSeparator); //$NON-NLS-1$
        //    code.append(" Map fieldValues = new HashMap();" + Utilities.SystemLineSeparator); //$NON-NLS-1$
        //    code.append(" return fieldValues;" + Utilities.SystemLineSeparator); //$NON-NLS-1$
        //    code.append("}" + Utilities.SystemLineSeparator); //$NON-NLS-1$
    }

    private static void generateTemplateInnerClassForModelElements( StringBuffer code, List modelElements, Map mapConstants ) {

        code.append( "// constants for all typed elements encapsulated in an inner class" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "private static final class ___FeatureId {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  private static java.util.Map<java.lang.String, java.lang.Integer> featureIds = new java.util.HashMap(" + modelElements.size( ) + ");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  static {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        Iterator iter = modelElements.iterator( );
        int counter = 0;
        while ( iter.hasNext( ) ) {
            ModelElement modelElement = (ModelElement) iter.next( );
            code.append( "    featureIds.put(\"" + modelElement.getName( ) + "\", Integer.valueOf(" + counter + "));" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            mapConstants.put( modelElement.getName( ), Integer.valueOf( counter ) );
            counter++;
        }
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    private static void generateTemplateRefFeatured( StringBuffer code, ModelElement modelElement, String javaClassName, String javaInterfaceNameQualified, boolean isGeneratingClassProxy, int generationKind ) {

        // RefBaseObject
        generateTemplateRefBaseObject( code, modelElement, javaClassName, javaInterfaceNameQualified, isGeneratingClassProxy, generationKind );
        // RefFeatured
        // MUST be ArrayList -> add to end
        ArrayList listAttrs = new ArrayList( );
        ArrayList listRefs = new ArrayList( );
        ArrayList listStructuralFeatures = new ArrayList( );
        MofClass mofClass = null;
        if ( modelElement instanceof MofClass ) {
            mofClass = (MofClass) modelElement;
        }
        if ( mofClass != null ) {
            Iterator iter = getAllContent( mofClass ).iterator( );
            while ( iter.hasNext( ) ) {
                ModelElement me = (ModelElement) iter.next( );
                if ( me instanceof Attribute ) {
                    if ( !isGeneratingClassProxy || ScopeKindEnum.CLASSIFIER_LEVEL.equals( ( (Attribute) me ).getScope( ) ) ) {
                        listAttrs.add( me );
                    }
                } else if ( me instanceof Reference ) {
                    if ( !isGeneratingClassProxy || ScopeKindEnum.CLASSIFIER_LEVEL.equals( ( (Reference) me ).getScope( ) ) ) {
                        // AssociationEnd must be navigable (see JMI 1.0 standard 4.8.6 NOTE)
                        if ( ( (Reference) me ).getReferencedEnd( ).isNavigable( ) ) {
                            listRefs.add( me );
                        }
                    }
                }
            }
        }
        // structural features as constants
        Map mapConstants = new HashMap( );
        listStructuralFeatures.addAll( listAttrs );
        listStructuralFeatures.addAll( listRefs );
        generateTemplateInnerClassForModelElements( code, listStructuralFeatures, mapConstants );
        // refSetValue
        code.append( "// set the value" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "public void refSetValue(String featureName, Object value) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  java.lang.Integer featureId = ___FeatureId.featureIds.get(featureName);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  if (featureName == null) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    throw new InvalidNameException(featureName, \"Can not set the value of the feature with the given name. The name was null.\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  if (featureId == null) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code
            .append( "    throw new InvalidCallException(featureName, refMetaObject(), \"Can not set the value of the feature with the given name. The class \" + ((javax.jmi.model.MofClass)refMetaObject()).getName() + \" does not have a feature with the name \\\"\" + featureName + \"\\\".\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  switch (featureId) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        addSetCaseStatement( isGeneratingClassProxy, code, listAttrs.iterator( ), mapConstants );
        addSetCaseStatement( isGeneratingClassProxy, code, listRefs.iterator( ), mapConstants );
        code.append( "    default:" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "      throw new InvalidCallException(featureName, null, \"refSetValue()\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // set___Value
        code.append( "// set the value internally" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "public void set___Value(String featureName, Object value) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  switch (___FeatureId.featureIds.get(featureName)) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        addInternalSetCaseStatementForStructuralFeature( isGeneratingClassProxy, code, listAttrs.iterator( ), mapConstants );
        addInternalSetCaseStatementForStructuralFeature( isGeneratingClassProxy, code, listRefs.iterator( ), mapConstants );
        code.append( "    default:" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code
            .append( "      throw new InvalidCallException(featureName, refMetaObject(), \"Can not set the value of the feature with the given name. The class \" + ((javax.jmi.model.MofClass)refMetaObject()).getName() + \" does not have a feature with the name \\\"\" + featureName + \"\\\".\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // refGetValue
        code.append( "// get a value" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "public Object refGetValue(String featureName) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  Object result = null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  java.lang.Integer featureId = ___FeatureId.featureIds.get(featureName);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  if (featureName == null) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    throw new InvalidNameException(featureName, \"Can not return the value of the feature with the given name. The name was null.\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  if (featureId == null) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code
            .append( "    throw new InvalidCallException(featureName, refMetaObject(), \"Can not return the value of the feature with the given name. The class \" + ((javax.jmi.model.MofClass)refMetaObject()).getName() + \" does not have a feature with the name \\\"\" + featureName + \"\\\".\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  switch (featureId) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        int caseStatementsAdded = addGetCaseStatementForStructuralFeature( isGeneratingClassProxy, code, listAttrs.iterator( ), mapConstants );
        caseStatementsAdded += addGetCaseStatementForStructuralFeature( isGeneratingClassProxy, code, listRefs.iterator( ), mapConstants );
        code.append( "    default:" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code
            .append( "      throw new InvalidCallException(featureName, refMetaObject(), \"Can not return the value of the feature with the given name. The class \" + ((javax.jmi.model.MofClass)refMetaObject()).getName() + \" does not have a feature with the name \\\"\" + featureName + \"\\\".\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // if we wouldn't have case statements we would only throw an exception, the return statement would be unreachable,
        // so only generate a return statement if case statements exist
        if ( caseStatementsAdded > 0 ) {
            code.append( "  return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        }
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    public static void generateTemplateRefObjectDecl( StringBuffer code, ModelElement modelElement, String javaClassName, int generationKind ) {

        generateTemplateDeclDefault( code, modelElement, javaClassName );
        code.append( "// specific constructor" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "public " + javaClassName + "(Object workspace, String mofId, RefPackage immediatePackage, RefObject metaObject, RefClass refClass) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  super(workspace, mofId, immediatePackage, metaObject, refClass);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    public static void generateTemplateRefObject( StringBuffer code, ModelElement modelElement, String javaClassName, String javaInterfaceNameQualified, Collection listAttributes, int generationKind ) {

        generateTemplateRefFeatured( code, modelElement, javaClassName, javaInterfaceNameQualified, false, generationKind );
    }

    public static void generateTemplateRefPackageDecl( StringBuffer code, MofPackage mofPackage, String javaClassName, int generationKind ) { // RefBaseObject

        generateTemplateDeclDefault( code, mofPackage, javaClassName );
        code.append( "// specific constructor" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "public " + javaClassName + "(Object workspace, String mofId, RefPackage immediatePackage, RefObject metaObject) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  super(workspace, mofId, immediatePackage, metaObject);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    public static void generateTemplateRefPackage( StringBuffer code, MofPackage mofPackage, String javaClassName, String javaInterfaceNameQualified, int generationKind ) {

        // RefBaseObject
        generateTemplateRefBaseObject( code, mofPackage, javaClassName, javaInterfaceNameQualified, false, generationKind ); // RefPackage
        // RefPackage
        generateCreateRefEnum( code, mofPackage );
        generateCreateRefStruct( code, mofPackage );
        // initialize
        code.append( "protected void initialize() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  if (___refPackages == null) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    ___refPackages = new ArrayList();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    ___refPackagesByName = new HashMap();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    String name = \"\";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    RefPackageAndName rpan = null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        List ls = new ArrayList( );
        ls.add( mofPackage ); // must use supertypes, too
        ls.addAll( mofPackage.allSupertypes( ) );
        Iterator i1 = ls.iterator( );
        while ( i1.hasNext( ) ) {
            ModelElement ns = (ModelElement) i1.next( );
            if ( ns instanceof Namespace ) {
                java.util.Iterator i2 = ( (Namespace) ns ).getContents( ).iterator( );
                while ( i2.hasNext( ) ) {
                    ModelElement me = (ModelElement) i2.next( );
                    if ( me instanceof MofPackage ) {
                        String jn = GeneratorPackage.getJavaInterfaceNameQualified( (MofPackage) me );
                        code.append( "    name = \"" + me.getName( ) + "\";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        code.append( "    rpan = new RefPackageAndName(name, \"" + jn + "\", false);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        code.append( "    ___refPackages.add(rpan);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        code.append( "    ___refPackagesByName.put(name, rpan);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    } else if ( me instanceof Import && ( (Import) me ).isClustered( ) ) {
                        Import im = (Import) me;
                        String jn = GeneratorPackage.getJavaInterfaceNameQualified( (MofPackage) im.getImportedNamespace( ) );
                        code.append( "    name = \"" + me.getName( ) + "\";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        code.append( "    rpan = new RefPackageAndName(name, \"" + jn + "\", true);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        code.append( "    ___refPackages.add(rpan);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                        code.append( "    ___refPackagesByName.put(name, rpan);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    }
                }
            }
        }
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // must use supertypes, too
        List contentAll = getAllContent( mofPackage );
        code.append( "  if (___refClasses == null) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    ___refClasses = new ArrayList();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    ___refClassesByName = new HashMap();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    String name = \"\";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    RefClassAndName rcan = null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        Iterator iter = contentAll.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof MofClass ) {
                String jn = GeneratorClass.getJavaInterfaceNameQualified( (MofClass) me );
                code.append( "    name = \"" + me.getName( ) + "\";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    rcan = new RefClassAndName(name, \"" + jn + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    ___refClasses.add(rcan);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    ___refClassesByName.put(name, rcan);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
        }
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  if (___refAssociations == null) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    ___refAssociations = new ArrayList();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    ___refAssociationsByName = new HashMap();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    String name = \"\";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    RefAssociationAndName raan = null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        iter = contentAll.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof Association ) {
                String jn = GeneratorAssociation.getJavaInterfaceNameQualified( (Association) me );
                code.append( "    name = \"" + me.getName( ) + "\";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    raan = new RefAssociationAndName(name, \"" + jn + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    ___refAssociations.add(raan);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    ___refAssociationsByName.put(name, raan);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
        }
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // collect extents
        ArrayList extents = new ArrayList( );
        iter = contentAll.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( ( me instanceof MofClass ) || ( me instanceof Association ) || ( me instanceof MofPackage ) || ( me instanceof Import && ( (Import) me ).isClustered( ) ) ) {
                extents.add( me );
            }
        }
        Map mapConstants = new HashMap( );
        // ___FeatureId
        generateTemplateInnerClassForModelElements( code, extents, mapConstants );
        // create___Extent
        code.append( "protected RefBaseObject create___Extent(Object workspace, String mofId, RefPackage immediatePackage, RefObject metaObject) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  RefBaseObject result = null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  String name = ((javax.jmi.model.ModelElement)metaObject).getName();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  try {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    switch (___FeatureId.featureIds.get(name)) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        int caseStatementsAdded = addGetCaseStatementForExtents( code, extents.iterator( ), mapConstants );
        code.append( "      default:" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "        throw new InvalidCallException(name, null, \"create___Extent()\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // if we wouldn't have case statements we would only throw an exception, the return statement would be unreachable,
        // so only generate a return statement if case statements exist
        if ( caseStatementsAdded > 0 ) {
            code.append( "    return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        }
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  catch(Exception ex) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    throw new javax.jmi.reflect.JmiException(ex);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    private static void generateCreateRefEnum( StringBuffer code, ModelElement modelElement ) {

        // Enumerations
        code.append( "// enumerations" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "public RefEnum create___RefEnum(javax.jmi.model.EnumerationType enumType, String name) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  RefEnum result = null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  String enumName = enumType.getName();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        boolean firstEnum = true;
        Iterator iter = getAllContent( modelElement ).iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof EnumerationType ) {
                EnumerationType et = (EnumerationType) me;
                String qName = GeneratorEnumerationType.getJavaClassNameQualified( et );
                String strIf = "";
                if ( firstEnum ) {
                    strIf += "  if"; //$NON-NLS-1$
                    firstEnum = false;
                } else {
                    strIf += "  else if"; //$NON-NLS-1$
                }
                strIf += " (enumName.equals(\"" + et.getName( ) + "\")) {"; //$NON-NLS-1$
                code.append( strIf + Utilities.SystemLineSeparator );
                code.append( "    result = " + qName + ".forName(name);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
        }
        code.append( "  return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    private static void generateCreateRefStruct( StringBuffer code, ModelElement modelElement ) {

        // Structures
        code.append( "// structures" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "public RefStruct create___RefStruct(Object workspace, javax.jmi.model.StructureType structType) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  RefStruct result = null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  String structName = structType.getName();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  try {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        boolean firstStruct = true;
        Iterator iter = getAllContent( modelElement ).iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof StructureType ) {
                StructureType st = (StructureType) me;
                String qName = GeneratorStructureType.getJavaClassNameQualified( st );
                String strIf = "";
                if ( firstStruct ) {
                    strIf += "    if"; //$NON-NLS-1$
                    firstStruct = false;
                } else {
                    strIf += "    else if"; //$NON-NLS-1$
                }
                strIf += " (structName.equals(\"" + st.getName( ) + "\")) {"; //$NON-NLS-1$
                code.append( strIf + Utilities.SystemLineSeparator );
                code.append( "      result = new " + qName + "(workspace, structType);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
        }
        code.append( "    return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  catch(Exception ex) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    throw new javax.jmi.reflect.JmiException(ex);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    private static void generateTemplateDeclDefault( StringBuffer code, ModelElement modelElement, String javaClassName ) {

        code.append( "// default constructor" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "public " + javaClassName + "() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  super();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    public static Tag getTagPrefix( Namespace ns ) {

        Tag tag = null;
        Iterator iter = ns.getContents( ).iterator( );
        while ( iter.hasNext( ) && tag == null ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof Tag ) {
                if ( ( (Tag) me ).getTagId( ).compareTo( GeneratorConstants.TAG_IDL_PREFIX ) == 0 ) {
                    tag = (Tag) me;
                }
            }
        }
        return tag;
    }

    public static String getJMIIdentifierQualified( Namespace namespace ) {

        String packageName = getJMIPackageIdentifierQualified( namespace );
        if ( ( packageName != null ) && ( packageName.length( ) != 0 ) ) {
            return packageName + GeneratorConstants.PACKAGE_DELIMITER + getJMIIdentifier( namespace );
        } else {
            return getJMIIdentifier( namespace );
        }
    }

    public static String getJMIPackageIdentifierQualified( Namespace namespace ) {

        if ( namespace == null ) {
            return "";
        }
        List list = new LinkedList( );
        // Use the Packages of the containers ONLY
        // example in JMI TCK: Structure or Enumeration defined in Classs
        // there may be a tag with a prefix
        ModelElement container = namespace.getContainer( );
        while ( container != null ) {
            Tag tagJmiPrefix = null;
            if ( container instanceof MofPackage ) {
                MofPackage mp = (MofPackage) container;
                list.add( 0, mp.getName( ) );
                tagJmiPrefix = getTag( mp, JMI_TAG_PACKAGE_PREFIX );
                if ( tagJmiPrefix != null ) {
                    list.addAll( 0, Utilities.getUtilities( ).decodeQualifiedName( (String) ( tagJmiPrefix.getValues( ).get( 0 ) ) ) );
                }
            }
            // The MOF 1.4 XMI file contains a MOF prefix AND a JMI prefix
            // If the JMI prefix is present, don't use the MOF prefix, too
            if ( tagJmiPrefix == null && container instanceof Namespace ) {
                // there may be a tag with a prefix
                Tag tag = getTagPrefix( (Namespace) container );
                if ( tag != null ) {
                    String value = null;
                    List values = tag.getValues( );
                    if ( values != null && values.size( ) > 0 ) {
                        value = (String) values.get( 0 );
                    }
                    if ( value != null ) {
                        List prefix = Utilities.getUtilities( ).decodeQualifiedName( value );
                        list.addAll( 0, prefix );
                    }
                }
            }
            container = container.getContainer( );
        }
        if ( namespace instanceof Namespace ) {
            Tag tagJmiPrefix = getTag( namespace, JMI_TAG_PACKAGE_PREFIX );
            if ( tagJmiPrefix != null ) {
                list.addAll( 0, Utilities.getUtilities( ).decodeQualifiedName( (String) ( tagJmiPrefix.getValues( ).get( 0 ) ) ) );
            } else {
                Tag tag = getTagPrefix( (Namespace) namespace );
                if ( tag != null ) {
                    String value = null;
                    List values = tag.getValues( );
                    if ( values != null && values.size( ) > 0 ) {
                        value = (String) values.get( 0 );
                    }
                    if ( value != null ) {
                        List prefix = Utilities.getUtilities( ).decodeQualifiedName( value );
                        list.addAll( 0, prefix );
                    }
                }
            }
        }
        //    Iterator iter = list.iterator();
        //    while(iter.hasNext()) {
        //      b.append(correctName((String)iter.next()).toLowerCase());
        //      b.append(GeneratorConstants.PACKAGE_DELIMITER);
        //    } // get the name of the last one
        //    b.append(getJMIIdentifier(namespace));
        //    return b.toString();
        StringBuilder b = null;
        Iterator iter = list.iterator( );
        while ( iter.hasNext( ) ) {
            if ( b == null ) {
                b = new StringBuilder( );
            }
            b.append( correctName( (String) iter.next( ) ).toLowerCase( Locale.ENGLISH ) );
            if ( iter.hasNext( ) ) {
                b.append( GeneratorConstants.PACKAGE_DELIMITER );
            }
        }
        if ( b != null ) {
            return b.toString( );
        } else {
            return "";
        }
    }

    private static String avoidNameConflict( String name, String reservedWord, String replacement ) {

        // change names ending with Package, Class, Enumeration, ...
        String str = name;
        int length = str.length( );
        if ( length >= reservedWord.length( ) ) {
            int n = str.indexOf( reservedWord );
            if ( ( n + reservedWord.length( ) ) == length && str.indexOf( PREFIX_MOF ) != 0 ) {
                str = str.substring( 0, n ) + replacement;
            }
        }
        return str;
    }

    public static String getJMIIdentifier( ModelElement modelElement ) {

        String identifier = modelElement.getName( );
        // Substitute Identifier of JMI spec
        String ident = getSubstituteIdentifier( modelElement );
        if ( ident != null ) {
            identifier = ident;
        } // type specific rules
        if ( modelElement instanceof MofPackage ) {
            identifier = correctName( identifier );
            identifier = convertFirstCharToUpper( identifier );
        } else if ( modelElement instanceof MofClass ) {
            identifier = correctName( identifier );
            identifier = convertFirstCharToUpper( identifier );
        } else if ( modelElement instanceof Operation ) {
            identifier = correctName( identifier );
            identifier = convertFirstCharToLower( identifier );
        } else if ( modelElement instanceof Attribute ) {
            identifier = correctName( identifier );
            identifier = convertFirstCharToLower( identifier );
        } else if ( modelElement instanceof Reference ) {
            identifier = correctName( identifier );
            identifier = convertFirstCharToLower( identifier );
        } else if ( modelElement instanceof StructureField ) {
            identifier = correctName( identifier );
            identifier = convertFirstCharToLower( identifier );
        } else if ( modelElement instanceof Constant ) {
            identifier = correctConstant( identifier );
            identifier = convertFirstCharToUpper( identifier );
        } else if ( modelElement instanceof EnumerationType ) {
            identifier = correctName( identifier );
            identifier = convertFirstCharToUpper( identifier );
        } else if ( modelElement instanceof MofException ) {
            identifier = correctName( identifier );
            identifier = convertFirstCharToUpper( identifier );
            // at the end?
            int n = identifier.indexOf( EXTENSION_EXCEPTION );
            if ( ( n + EXTENSION_EXCEPTION.length( ) ) != identifier.length( ) ) {
                identifier += EXTENSION_EXCEPTION;
            }
        } else {
            identifier = correctName( identifier );
            identifier = convertFirstCharToUpper( identifier );
        }
        return identifier;
    }

    public static String mapVisibilityToJava( Feature feature ) {

        String vis = "public";
        if ( VisibilityKindEnum.PUBLIC_VIS.equals( feature.getVisibility( ) ) ) {
            vis = "public";
        } else if ( VisibilityKindEnum.PROTECTED_VIS.equals( feature.getVisibility( ) ) ) {
            vis = "protected";
        } else if ( VisibilityKindEnum.PRIVATE_VIS.equals( feature.getVisibility( ) ) ) {
            vis = "private";
        }
        return vis;
    }

    public static boolean isPartOfMOFModel( ModelElement me ) {

        boolean res = false;
        if ( me != null ) {
            List qn = me.getQualifiedName( );
            if ( qn != null && qn.size( ) > 1 ) {
                String s = (String) qn.iterator( ).next( );
                res = s.equals( GeneratorConstants.NAME_MODEL_PACKAGE );
            }
        }
        return res;
    }

    public static boolean isPartOfOCLModel( ModelElement me ) {

        boolean res = false;
        if ( me != null ) {
            List qn = me.getQualifiedName( );
            if ( qn != null && qn.size( ) > 1 ) {
                String s = (String) qn.iterator( ).next( );
                res = s.equals( GeneratorConstants.NAME_OCL_PACKAGE );
            }
        }
        return res;
    }

    public static String getAccessorNameForModelElement( ModelElement aModelElement ) {

        if ( aModelElement instanceof TypedElement ) {
            return getAccessorNameForTypedElement( (TypedElement) aModelElement );
        }
        return "get" + convertFirstCharToUpper( getJMIIdentifier( aModelElement ) );
    }

    private static String getAccessorNameForTypedElement( TypedElement aTypedElement ) {

        String accessorName = "";
        String typedElementName = convertFirstCharToUpper( getJMIIdentifier( aTypedElement ) );
        if ( aTypedElement instanceof StructuralFeature ) {
            StructuralFeature structuralFeature = (StructuralFeature) aTypedElement;
            if ( structuralFeature.getMultiplicity( ).getUpper( ) == 1 ) {
                if ( structuralFeature.getType( ).getName( ).compareToIgnoreCase( BOOLEAN ) == 0 ) {
                    if ( typedElementName.substring( 0, 2 ).compareToIgnoreCase( "is" ) == 0 ) { //$NON-NLS-1$
                        typedElementName = convertFirstCharToUpper( typedElementName.substring( 2 ) );
                    }
                    accessorName = "is" + typedElementName; //$NON-NLS-1$
                } else {
                    accessorName = "get" + typedElementName; //$NON-NLS-1$
                }
            } else {
                accessorName = "get" + typedElementName; //$NON-NLS-1$
            }
        } else {
            if ( aTypedElement.getType( ).getName( ).compareToIgnoreCase( BOOLEAN ) == 0 ) {
                if ( typedElementName.substring( 0, 2 ).compareToIgnoreCase( "is" ) == 0 ) { //$NON-NLS-1$
                    typedElementName = convertFirstCharToUpper( typedElementName.substring( 2 ) );
                }
                accessorName = "is" + typedElementName; //$NON-NLS-1$
            } else {
                accessorName = "get" + typedElementName; //$NON-NLS-1$
            }
        }
        return accessorName;
    }

    public static String getMutatorNameForTypedElement( TypedElement aTypedElement ) {

        String mutatorName = "";
        String typedElementName = convertFirstCharToUpper( getJMIIdentifier( aTypedElement ) );
        if ( aTypedElement instanceof StructuralFeature ) {
            StructuralFeature structuralFeature = (StructuralFeature) aTypedElement;
            if ( structuralFeature.getMultiplicity( ).getUpper( ) == 1 ) {
                if ( structuralFeature.getType( ).getName( ).compareToIgnoreCase( BOOLEAN ) == 0 ) {
                    if ( typedElementName.substring( 0, 2 ).compareToIgnoreCase( "is" ) == 0 ) { //$NON-NLS-1$
                        typedElementName = convertFirstCharToUpper( typedElementName.substring( 2 ) );
                    }
                    mutatorName = "set" + typedElementName; //$NON-NLS-1$
                } else {
                    mutatorName = "set" + typedElementName; //$NON-NLS-1$
                }
            } else {
                mutatorName = "set" + typedElementName; //$NON-NLS-1$
            }
        } else if ( aTypedElement instanceof Parameter ) {
            Parameter parameter = (Parameter) aTypedElement;
            if ( parameter.getMultiplicity( ).getUpper( ) == 1 ) {
                if ( parameter.getType( ).getName( ).compareToIgnoreCase( BOOLEAN ) == 0 ) {
                    if ( typedElementName.substring( 0, 2 ).compareToIgnoreCase( "is" ) == 0 ) { //$NON-NLS-1$
                        typedElementName = convertFirstCharToUpper( typedElementName.substring( 2 ) );
                    }
                    mutatorName = "set" + typedElementName; //$NON-NLS-1$
                } else {
                    mutatorName = "set" + typedElementName; //$NON-NLS-1$
                }
            } else {
                mutatorName = "set" + typedElementName; //$NON-NLS-1$
            }
        } else {
            if ( aTypedElement.getType( ).getName( ).compareToIgnoreCase( BOOLEAN ) == 0 ) {
                if ( typedElementName.substring( 0, 2 ).compareToIgnoreCase( "is" ) == 0 ) { //$NON-NLS-1$
                    typedElementName = convertFirstCharToUpper( typedElementName.substring( 2 ) );
                }
                mutatorName = "set" + typedElementName; //$NON-NLS-1$
            } else {
                mutatorName = "set" + typedElementName; //$NON-NLS-1$
            }
        }
        return mutatorName;
    }

    public static String getInternalMutatorNameForTypedElement( TypedElement aTypedElement ) {

        String internalMutatorName = "";
        internalMutatorName = getMutatorNameForTypedElement( aTypedElement );
        internalMutatorName = "set__" + internalMutatorName.substring( 3, internalMutatorName.length( ) ); //$NON-NLS-1$
        return internalMutatorName;
    }

    public static String getOperationNameForOperation( Operation anOperation ) {

        return convertFirstCharToLower( Generator.getJMIIdentifier( anOperation ) );
    }

    public static String getCreatorNameForInstance( MofClass aMofClass ) {

        return "create" + convertFirstCharToUpper( getJMIIdentifier( aMofClass ) );
    }

    public static String getCreatorNameForStructure( StructureType aStructure ) {

        return "create" + getJMIIdentifier( aStructure );
    }

    static List getAttributeList( MofClass mofClass, int generationKind ) {

        List list = new ArrayList( );
        if ( generationKind == Generator.GenerationKind.CLASS || generationKind == Generator.GenerationKind.INTERFACE || !( mofClass.isAbstract( ) ) && ( mofClass.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) ) {
            HashSet set = new HashSet( );
            // JMI 1.0 page 60
            // superclasses first according to generalizes association
            //      mofClass.allSupertypes();
            // create the list
            Iterator iter = getAllContent( mofClass ).iterator( );
            while ( iter.hasNext( ) ) {
                ModelElement me = (ModelElement) iter.next( );
                if ( me instanceof Attribute ) {
                    Attribute atr = (Attribute) me;
                    if ( atr.getType( ) != null && !atr.isDerived( ) && atr.getScope( ).equals( ScopeKindEnum.INSTANCE_LEVEL ) ) {
                        AttributeWithType awt = new AttributeWithType( Generator.getJMIIdentifier( atr ), getAttributeType( atr ), atr );
                        if ( !( set.contains( awt ) ) ) {
                            set.add( awt );
                            list.add( awt );
                        }
                    }
                }
            }
        }
        return list;
    }

    static String getMetamodelId( String metamodelName ) {

        // converts the metamodel name into an ID
        // e.g. "sap.com/tc/moin/testcases_1.0_source/testcases" -> "BEA1A6C8D8AD9DAD84988C060AFF26939A97F4FB"
        // note that the hex sign "0x" has to be removed after he conversion from byte[] to String
        Utilities sha1Utilities = Utilities.getUtilities( );
        return sha1Utilities.byteArrayToString( sha1Utilities.calculateSHA1HashUtf8( metamodelName ) ).substring( 2 );
    }

    public static void main( String[] args ) {


    }
}