package com.sap.tc.moin.repository.jmigenerator.wrappers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.sap.tc.moin.repository.mmi.model.AliasType;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ConstraintInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.FeatureInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.GeneralizableElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ParameterInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructuralFeatureInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.TypedElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import javax.swing.tree.TreeNode;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateErrorListener;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.StringTemplateGroupLoader;
import org.omg.ocl.attaching.__impl.OclConstraintInternal;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.__impl.BooleanLiteralExpInternal;
import org.omg.ocl.expressions.__impl.EnumLiteralExpInternal;
import org.omg.ocl.expressions.__impl.IntegerLiteralExpInternal;
import org.omg.ocl.expressions.__impl.RealLiteralExpInternal;
import org.omg.ocl.expressions.__impl.StringLiteralExpInternal;

import com.sap.tc.moin.ocl.parser.IOclParser;
import com.sap.tc.moin.ocl.parser.OclParserFactory;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorModelElementWrapper;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorMofType;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorPathCodePair;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorRuntimeException;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorTraces;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorDescriptorConstant;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorJavadoc;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorParameter;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorDescriptorConstantImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorJavadocImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorParameterImpl;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.shared.util.StringUtils;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * The abstract base class for all wrappers
 * <p>
 * The central method for JMI generation is
 * {@link #createCode(JmiGenerationKind[])} which is accessed through the
 * implemented interface. This method is implemented here but it relies on two
 * other methods that are declared abstract here and must be implemented
 * properly in a concrete subclass. The first one is
 * {@link #getTemplateNames(JmiGenerationKind)} which returns the the names of
 * the templates declared in the respective String template file (file extension
 * .stg). The mapping from MOF type to template file name is currently
 * hard-coded but could of course be replaced by something similar.
 * <p>
 * With the list of template names, the second method to be implemented by
 * subclasses is {@link #getJavaTemplate(JmiGenerationKind, String)} which takes
 * as argument the JmiGenerationKind plus the template name obtained in the
 * first method. The method is expected to return an implementation of
 * {@link JmiGeneratorBaseTemplate} which is the "Model" for the StringTemplate.
 * <p>
 * Potentially, there is one interface per combination of
 * {@link JmiGenerationKind} and template name. For example, for MofClasses,
 * there are four different interface templates (note that the interface
 * template is re-used for wrapper generation:
 * <p>
 * <table border=1>
 * <tr>
 * <th>GenerationKind</th>
 * <th>Template Name</th>
 * <th>Interface</th>
 * </tr>
 * <tr>
 * <td>JmiGenerationKind.INTERFACE</td>
 * <td>ClassInterface</td>
 * <td>JmiGeneratorClassInterfaceTemplate</td>
 * </tr>
 * <tr>
 * <td>JmiGenerationKind.INTERFACE</td>
 * <td>ClassProxyInterface</td>
 * <td>JmiGeneratorClassProxyInterfaceTemplate</td>
 * </tr>
 * <tr>
 * <td>JmiGenerationKind.INTERFACE</td>
 * <td>ClassWrapper</td>
 * <td>JmiGeneratorClassInterfaceTemplate</td>
 * </tr>
 * <tr>
 * <td>JmiGenerationKind.IMPL</td>
 * <td>ClassImpl</td>
 * <td>JmiGeneratorClassImplTemplate</td>
 * </tr>
 * <tr>
 * <td>JmiGenerationKind.IMPL</td>
 * <td>ClassProxyImpl</td>
 * <td>JmiGeneratorClassProxyImplTemplate</td>
 * </tr>
 * </table>
 * <p>
 * For StructureTypes, the picture is less complicated, since there are not
 * wrappers and no proxies:
 * <p>
 * <table border=1>
 * <tr>
 * <th>GenerationKind</th>
 * <th>Template Name</th>
 * <th>Interface</th>
 * </tr>
 * <tr>
 * <td>JmiGenerationKind.INTERFACE</td>
 * <td>StructureTypeInterface</td>
 * <td>JmiGeneratorStructureTypeInterfaceTemplate</td>
 * </tr>
 * <tr>
 * <td>JmiGenerationKind.IMPL</td>
 * <td>StructureTypeImple</td>
 * <td>JmiGeneratorStructureTypeImplTemplate</td>
 * </tr>
 * </table>
 */
public abstract class JmiGeneratorBaseWrapper implements JmiGeneratorModelElementWrapper {

    private static final String MOF_1_4_CONTAINER_NAME = "sap.com/tc/moin/mof_1.4"; //$NON-NLS-1$

    protected static final String CONNECTION_VARIABLE_NAME = "connection"; //$NON-NLS-1$

    protected static final String CONNECTION_TYPE_NAME = "com.sap.tc.moin.repository.core.CoreConnection"; //$NON-NLS-1$

    protected static final String GET_CURRENT_CONNECTION_STATEMENT = CONNECTION_TYPE_NAME + " " + CONNECTION_VARIABLE_NAME + " = get___CurrentConnection();"; //$NON-NLS-1$  //$NON-NLS-2$

    /**
     * The Generator version
     */
    public final static String GENERATOR_VERSION = "3.0"; //$NON-NLS-1$

    /**
     * JMI names of meta model elements that should not be generated - Class
     * Element (JMI Name is com.sap.tc.moin.repository.mmi.reflect.RefObject) in package Reflect (JMI
     * name is com.sap.tc.moin.repository.mmi.Reflect) is used as most abstract super class of all
     * model elements. It maps to com.sap.tc.moin.repository.mmi.reflect.RefObject and due to that
     * should not be generated. This class should only be used to create
     * "typeless" references/attributes - Classes OclAny and OclTypeClass are
     * artifacts that are used when importing meta models which contain OCL
     * constraints in order to handle these constraints
     */
    public static final List<String> JMI_IDENTIFIER_OF_CLASSES_TO_EXCLUDE_FROM_GENERATION = Arrays.asList( new String[] { "com.sap.tc.moin.repository.mmi.reflect.RefObject", "OclAny", "OclTypeClass" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    /**
     * Class name
     */
    public final static String CLASS_REFPACKAGEAPI = "com.sap.tc.moin.repository.mmi.reflect.RefPackage"; //$NON-NLS-1$

    /**
     * Class name
     */
    public final static String CLASS_REFOBJAPI = "com.sap.tc.moin.repository.mmi.reflect.RefObject"; //$NON-NLS-1$

    /**
     * Class name
     */
    public final static String CLASS_REFOBJIMPL = "com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl"; //$NON-NLS-1$

    /**
     * Class name
     */
    public final static String CLASS_REFENUMAPI = "com.sap.tc.moin.repository.mmi.reflect.RefEnum"; //$NON-NLS-1$

    /**
     * Class name
     */
    public final static String CLASS_REFCLASSAPI = "com.sap.tc.moin.repository.mmi.reflect.RefClass"; //$NON-NLS-1$

    /**
     * Class name
     */
    public final static String CLASS_REFSTRUCTAPI = "com.sap.tc.moin.repository.mmi.reflect.RefStruct"; //$NON-NLS-1$

    /**
     * Class name
     */
    public final static String CLASS_REFASSOCAPI = "com.sap.tc.moin.repository.mmi.reflect.RefAssociation"; //$NON-NLS-1$

    /**
     * Class name
     */
    public final static String CLASS_REFASSOCIMPL = "com.sap.tc.moin.repository.core.jmi.reflect.RefAssociationImpl"; //$NON-NLS-1$

    /**
     * Class name
     */
    public final static String CLASS_REFEXCEPTIONAPI = "com.sap.tc.moin.repository.mmi.reflect.RefException"; //$NON-NLS-1$

    /**
     * Class name
     */
    public final static String CLASS_REFSTRUCTIMPL = "com.sap.tc.moin.repository.core.jmi.reflect.RefStructImpl"; //$NON-NLS-1$

    /**
     * Class name
     */
    public final static String CLASS_REFCLASSIMPL = "com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl"; //$NON-NLS-1$

    /**
     * Class name
     */
    public final static String CLASS_REFPACKAGEIMPL = "com.sap.tc.moin.repository.core.jmi.reflect.RefPackageImpl"; //$NON-NLS-1$

    /** com.sap.tc.moin.noclassproxy */
    private final static String SYS_PARAM_NOCLASSPROXY = "com.sap.tc.moin.noclassproxy"; //$NON-NLS-1$

    /**
     * Empty String
     */
    public final static String EMPTY = ""; //$NON-NLS-1$

    /** __ */
    public final static String VARIABLE_PREFIX = "__"; //$NON-NLS-1$

    /** set */
    public final static String INTERNAL_SETTER_PREFIX = "set" + VARIABLE_PREFIX; //$NON-NLS-1$

    /** get */
    public final static String INTERNAL_GETTER_PREFIX = "get" + VARIABLE_PREFIX; //$NON-NLS-1$

    /** invoke */
    public final static String INTERNAL_CALLER_PREFIX = "invoke" + VARIABLE_PREFIX; //$NON-NLS-1$

    /**
     * The "Mof" prefix
     */
    public final static String PREFIX_MOF = "Mof"; //$NON-NLS-1$

    /**
     * "Package"
     */
    public final static String EXTENSION_PACKAGE = "Package"; //$NON-NLS-1$

    /**
     * "Impl"
     */
    public final static String EXTENSION_IMPLEMENTATION = "Impl"; //$NON-NLS-1$

    /**
     * "Wrapper"
     */
    public final static String EXTENSION_WRAPPER = "Wrapper"; //$NON-NLS-1$

    /**
     * "java"
     */
    public final static String EXTENSION_JAVA = "java"; //$NON-NLS-1$

    private final static String PACKAGE_IMPLEMENTATION = "__impl"; //$NON-NLS-1$

    private static final List<String> JMI_IDENTIFIER_OF_PACKAGES_TO_EXCLUDE_FROM_GENERATION = Arrays.asList( new String[] { "com.sap.tc.moin.repository.mmi.Reflect" } ); //$NON-NLS-1$

    /**
     * Name of the tag containing code for the accessor of a derived attribute
     * and for the accessor of an association end of a derived association. The
     * tag is mandatory for an association end of a derived association if the
     * end is navigable. Otherwise it is ignored.
     */
    public static final String TAG_DERIVATION_CODE = "org.omg.sap2mof.DerivationCodeJava"; //$NON-NLS-1$

    /**
     * Name of the tag containing code for the mutator of a derived attribute.
     * The tag is mandatory if the attribute is changeable. Otherwise it is
     * ignored.
     */
    public static final String TAG_PRODUCTION_CODE = "org.omg.sap2mof.ProductionCodeJava"; //$NON-NLS-1$

    /**
     * Name of tags containing Java code for modeled operations
     */
    public static final String TAG_OPERATION_CODE_JAVA = "org.omg.sap2mof.OperationCodeJava"; //$NON-NLS-1$

    /**
     * Name of tags containing OCL code for modeled operations
     */
    public static final String TAG_OPERATION_CODE_OCL = "org.omg.sap2mof.OperationCodeOcl"; //$NON-NLS-1$

    /**
     * Name of the tag containing code for the add method of a derived
     * association The tag is mandatory if both association ends are changeable.
     * If this is not the case, no add method is generated according to the JMI
     * specification and no tag is needed (or a given tag is ignored).
     */
    public static final String TAG_OPERATION_CODE_ADD_JAVA = "org.omg.sap2mof.OperationCodeAddJava"; //$NON-NLS-1$

    /**
     * Name of the tag containing code for the remove method of a derived
     * association The tag is mandatory if both association ends are changeable.
     * If this is not the case, no remove method is generated according to the
     * JMI specification and no tag is needed (or a given tag is ignored).
     */
    public static final String TAG_OPERATION_CODE_REMOVE_JAVA = "org.omg.sap2mof.OperationCodeRemoveJava"; //$NON-NLS-1$

    /**
     * Name of the tag containing code for the exists method of a derived
     * association If the tag is not empty its content is taken as
     * implementation of the exists method. If it is empty, the exists method is
     * going to be calculated from one of the accessors. That implies that the
     * tag is mandatory if none of the association ends is navigable, because
     * then we do not have any accessor.
     */
    public static final String TAG_OPERATION_CODE_EXISTS_JAVA = "org.omg.sap2mof.OperationCodeExistsJava"; //$NON-NLS-1$

    /**
     * The system-dependent line separator
     */
    public static final String SYSTEM_LINE_SEPARATOR = Utilities.SystemLineSeparator;

    /**
     * The "preamble" (leading java doc)
     */
    public static final String PREAMBLE = "/**" + SYSTEM_LINE_SEPARATOR //$NON-NLS-1$
                                          + " * Generated by the MOIN Generator Version " //$NON-NLS-1$
                                          + GENERATOR_VERSION + SYSTEM_LINE_SEPARATOR + " **/" + SYSTEM_LINE_SEPARATOR; //$NON-NLS-1$

    /**
     * Java abstract modifier
     */
    public static final String MODIFIER_ABSTRACT = "abstract"; //$NON-NLS-1$

    /**
     * Java private modifier
     */
    public static final String MODIFIER_PRIVATE = "private"; //$NON-NLS-1$

    /**
     * Java protected modifier
     */
    public static final String MODIFIER_PROTECTED = "protected"; //$NON-NLS-1$

    /**
     * Java public modifier
     */
    public static final String MODIFIER_PUBLIC = "public"; //$NON-NLS-1$

    /**
     * Java static modifier
     */
    public static final String MODIFIER_STATIC = "static"; //$NON-NLS-1$

    /**
     * Java void type
     */
    public static final String VOID = "void"; //$NON-NLS-1$

    private static boolean getSystemFlagDefaultFalse( String flag ) {

        boolean result = false;
        // Check VM parameter
        if ( Boolean.getBoolean( flag ) ) {
            result = true;
        }
        // Check environment variable
        if ( "true".equals( System.getenv( flag ) ) ) { //$NON-NLS-1$
            result = true;
        }
        return result;
    }

    private static boolean getSystemFlagDefaultTrue( String flag ) {

        boolean result = true;
        // Check VM parameter
        if ( "false".equals( System.getProperty( flag ) ) ) { //$NON-NLS-1$
            result = false;
        }
        // Check environment variable
        if ( "false".equals( System.getenv( flag ) ) ) { //$NON-NLS-1$
            result = false;
        }
        return result;
    }

    public static boolean noClassProxy( ) {

        return getSystemFlagDefaultTrue( SYS_PARAM_NOCLASSPROXY );
    }

    private static final Set<String> keywordsJava = new HashSet<String>( );

    private static final Set<String> keywordsJavaForClass = new HashSet<String>( );

    private static final String tableKeywordsJavaForClass[] = { "package", //$NON-NLS-1$
        "class", "exception", "interface" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    };

    private static final String tableKeywordsJava[] = { "abstract", //$NON-NLS-1$
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

    private static final String tableDataTypeMappings[] = { "any", //$NON-NLS-1$
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

    private static final Map<String, String> dataTypeMappings = new HashMap<String, String>( );

    private static final StringTemplateGroup pkggroup;

    private static final StringTemplateGroup classgroup;

    private static final StringTemplateGroup enumgroup;

    private static final StringTemplateGroup stgroup;

    private static final StringTemplateGroup assocgroup;

    private static final StringTemplateGroup exceptiongroup;

    protected static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_BUILD_JMI_GENERATOR, JmiGeneratorBaseWrapper.class );

    static {
        for ( int i = 0; i < tableKeywordsJava.length; i++ ) {
            keywordsJava.add( tableKeywordsJava[i] );
        }
        for ( int i = 0; i < tableKeywordsJavaForClass.length; i++ ) {
            keywordsJavaForClass.add( tableKeywordsJavaForClass[i] );
        }
        for ( int i = 0; i < tableDataTypeMappings.length; i += 2 ) {
            dataTypeMappings.put( tableDataTypeMappings[i], tableDataTypeMappings[i + 1] );
        }

        // instantiate StringTemplateGroupLoader and and register it

        StringTemplateErrorListener errorListener = new JmiGeneratorImpl.MoinStringTemplateErrorListener( );

        StringTemplateGroupLoader loader = new JmiGeneratorImpl.CommonClassLoaderGroupLoader( "com/sap/tc/moin/repository/jmigenerator/template", errorListener, JmiGeneratorBaseWrapper.class.getClassLoader( ) ); //$NON-NLS-1$
        StringTemplateGroup.registerGroupLoader( loader );

        pkggroup = StringTemplateGroup.loadGroup( "package" ); //$NON-NLS-1$
        classgroup = StringTemplateGroup.loadGroup( "class" ); //$NON-NLS-1$
        enumgroup = StringTemplateGroup.loadGroup( "enum" ); //$NON-NLS-1$
        stgroup = StringTemplateGroup.loadGroup( "structype" ); //$NON-NLS-1$
        assocgroup = StringTemplateGroup.loadGroup( "assoc" ); //$NON-NLS-1$
        exceptiongroup = StringTemplateGroup.loadGroup( "exception" ); //$NON-NLS-1$
    }

    protected CoreConnection connection = null;

    protected String metamodelName = EMPTY;

    private final ModelElement underlyingModelElement;

    private final JmiGeneratorImpl myGenerator;

    // TreeNode stuff
    protected final Vector<JmiGeneratorBaseWrapper> children = new Vector<JmiGeneratorBaseWrapper>( );

    protected boolean childrenInitialized = false;

    private TreeNode parent;

    private boolean mofModelElement = false;

    private IOclParser oclParser = null;

    /**
     * Constructs a wrapper in the context of a Generator instance
     * 
     * @param actConnection
     * @param actMetamodelName
     * @param modelElement
     * @param treeParent
     * @param generator
     */
    public JmiGeneratorBaseWrapper( CoreConnection actConnection, String actMetamodelName, ModelElement modelElement, TreeNode treeParent, JmiGeneratorImpl generator ) {

        this.connection = actConnection;
        if ( actMetamodelName != null ) {
            this.metamodelName = actMetamodelName;
        }
        this.underlyingModelElement = modelElement;
        this.mofModelElement = isMofElement( this.underlyingModelElement );
        this.parent = treeParent;
        this.myGenerator = generator;
        try {
            // TODO clarify with Mathias whether the JMI Creator is necessary here
            this.oclParser = OclParserFactory.create( new JmiCreator( actConnection ) );
        } catch ( OclManagerException oclManagerEx ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.OCLPARSERNOTAVAILABLE, oclManagerEx );
        }
    }

    public boolean isMofModelElement( ) {

        return this.mofModelElement;
    }

    /**
     * @return the meta model name
     */
    public String getMetamodelName( ) {

        return this.metamodelName;
    }

    public String getModelElementName( ) {

        return this.underlyingModelElement.getName( );
    }

    /**
     * @return the dot-separated model element qualified name
     */
    public String getModelElementQualifiedName( ) {

        return QualifiedName.toDotSeparatedString( ( (ModelElementInternal) this.underlyingModelElement ).getQualifiedName( connection ) );
    }

    /**
     * @return the MOF ID
     */
    public String getModelElementMofId( ) {

        return this.underlyingModelElement.refMofId( );
    }

    /**
     * @return the qualified name of the underlying ModelElement in
     * dot-separated notation
     */
    public String getQualifiedNameDotSeparated( ) {

        return QualifiedName.toDotSeparatedString( ( (ModelElementInternal) this.underlyingModelElement ).getQualifiedName( connection ) );
    }

    /**
     * @return the qualified name of the underlying ModelElement
     */
    public String getQualifiedNameForStringArrayInitializer( ) {

        List<String> qName = ( (ModelElementInternal) this.underlyingModelElement ).getQualifiedName( connection );
        String result = "\"" + qName.get( 0 ) + "\""; //$NON-NLS-1$  //$NON-NLS-2$
        for ( int i = 1; i < qName.size( ); i++ ) {
            result += ", \"" + qName.get( i ) + "\""; //$NON-NLS-1$  //$NON-NLS-2$
        }
        return result;
    }

    /**
     * @return the name components
     */
    public List<String> getQualifiedName( ) {

        return ( (ModelElementInternal) this.underlyingModelElement ).getQualifiedName( connection );
    }

    /**
     * Actually generates the code.
     * <p>
     * Uses the information provided in
     * {@link #getTemplateNames(JmiGenerationKind)} and
     * {@link #getJavaTemplate(JmiGenerationKind, String)} to generate the code.
     */
    public List<JmiGeneratorPathCodePair> createCode( JmiGenerationKind[] genKindFilter ) {

        List<JmiGeneratorPathCodePair> result = new ArrayList<JmiGeneratorPathCodePair>( );

        if ( ( this.underlyingModelElement instanceof MofPackage ) && ( JMI_IDENTIFIER_OF_PACKAGES_TO_EXCLUDE_FROM_GENERATION.contains( getJMIIdentifierQualified( (NamespaceInternal) this.underlyingModelElement ) ) ) ) {
            return result;
        } else if ( ( this.underlyingModelElement instanceof MofClass ) && ( JMI_IDENTIFIER_OF_CLASSES_TO_EXCLUDE_FROM_GENERATION.contains( getJMIIdentifierQualified( (NamespaceInternal) this.underlyingModelElement ) ) ) ) {
            return result;
        }

        JmiGenerationKind[] kinds;
        if ( genKindFilter == null || genKindFilter.length == 0 ) {
            kinds = JmiGenerationKind.values( );
        } else {
            kinds = genKindFilter;
        }
        for ( int i = 0; i < kinds.length; i++ ) {
            final JmiGenerationKind generationKind = kinds[i];
            List<String> tnames = this.getTemplateNames( generationKind );

            for ( final String tname : tnames ) {

                final String javaname = JmiGeneratorBaseWrapper.this.getJavaTemplate( generationKind, tname ).getJavaName( );

                result.add( new JmiGeneratorPathCodePair( ) {

                    public String getCode( ) {

                        return JmiGeneratorBaseWrapper.this.createCodeInternal( generationKind, tname );
                    }

                    public List<String> getRelativePath( ) {

                        return JmiGeneratorBaseWrapper.this.getRelativePath( generationKind );
                    }

                    public String getFileName( ) {

                        return javaname;
                    }

                    @Override
                    public String toString( ) {

                        StringBuilder sb = new StringBuilder( );
                        for ( String comp : getRelativePath( ) ) {
                            sb.append( comp );
                            sb.append( '.' );
                        }
                        sb.append( getFileName( ) );
                        return sb.toString( );
                    }

                    public String getFileExtension( ) {

                        return EXTENSION_JAVA;
                    }

                } );
            }
        }
        return result;
    }

    @Override
    public String toString( ) {

        // make this a bit more readable
        return this.getMofType( ) + ": " + ( (ModelElementInternal) this.underlyingModelElement ).getQualifiedName( connection ).toString( ); //$NON-NLS-1$
    }

    /**
     * Delegates to the JMI Helper
     * 
     * @return all content of the model element
     */
    public Iterator<ModelElement> getAllContent( ) {

        return this.getAllContent( (ModelElementInternal) this.underlyingModelElement );
    }

    /**
     * Checks if the element is a NameSpace
     * 
     * @return the content or an empty List
     */
    public Iterator<ModelElement> getContent( ) {

        if ( this.underlyingModelElement instanceof Namespace ) {
            return ( (JmiList<ModelElement>) ( (NamespaceInternal) this.underlyingModelElement ).getContents( this.connection ) ).iteratorReadOnly( this.connection.getSession( ) );
        }
        List<ModelElement> emptyList = Collections.emptyList( );
        return emptyList.iterator( );
    }

    /**
     * @return the JMI identifier for this model element
     */
    public String getJMIIdentifier( ) {

        return this.getJMIIdentifier( (ModelElementInternal) this.underlyingModelElement );
    }

    protected String getJMIIdentifier( ModelElementInternal modelElement ) {

        return getJmiHelper( ).getJMIIdentifier( this.connection, (ModelElement) modelElement );
    }

    public String getSubstituteIdentifier( ) {

        return getSubstituteIdentifier( (ModelElementInternal) this.underlyingModelElement );
    }

    public String getSubstituteIdentifier( ModelElementInternal modelElement ) {

        return getJmiHelper( ).getSubstituteName( this.connection, (ModelElement) modelElement );
    }

    protected String correctName( String constantName, boolean forConstant ) {

        return getJmiHelper( ).correctName( constantName, forConstant );
    }

    /**
     * @return the accessor name for this model element (like "getxxx")
     */
    public String getAccessorName( ) {

        if ( this.underlyingModelElement instanceof TypedElementInternal ) {
            return getAccessorNameForTypedElement( (TypedElementInternal) this.underlyingModelElement );
        }
        return getAccessorNameForModelElement( (ModelElementInternal) this.underlyingModelElement );
    }

    /**
     * @return the internal accessor name (like "get__xxx")
     */
    public String getAccessorNameInternal( ) {

        String accessor = getAccessorName( );
        return INTERNAL_GETTER_PREFIX + accessor.substring( 3 );
    }

    /**
     * @param genKind
     * @return the Java package name for this model element
     */
    public String getJavaPackageNameQualified( JmiGenerationKind genKind ) {

        if ( this.underlyingModelElement instanceof Namespace ) {

            switch ( genKind ) {
                case INTERFACE:
                    return getJavaPackageNameQualifiedForInterface( (NamespaceInternal) this.underlyingModelElement );
                case WRAPPER:
                    return getJavaPackageNameQualifiedForClass( (NamespaceInternal) this.underlyingModelElement );
                case CLASS:
                    return getJavaPackageNameQualifiedForClass( (NamespaceInternal) this.underlyingModelElement );

                default:
                    break;
            }
        }
        throw new MoinUnsupportedOperationException( "getJavaPackageNameQualified" ); //$NON-NLS-1$
    }

    /**
     * @return the mutator name for this model element (like "setxxx")
     */
    public String getMutatorName( ) {

        if ( this.underlyingModelElement instanceof TypedElementInternal ) {
            return getMutatorNameForTypedElement( (TypedElementInternal) this.underlyingModelElement );
        }
        return null;
    }

    /**
     * @return the internal mutator name for this model element (like
     * "set__xxx")
     */
    public String getMutatorNameInternal( ) {

        String mutator = getMutatorName( );
        if ( mutator != null ) {
            if ( mutator.startsWith( "is" ) ) { //$NON-NLS-1$
                return INTERNAL_SETTER_PREFIX + mutator.substring( 2 );
            }
            return INTERNAL_SETTER_PREFIX + mutator.substring( 3 );
        }
        return mutator;
    }

    public abstract String getJavaClassName( JmiGenerationKind genKind, boolean qualified );

    /**
     * @param attribute
     * @return the Java type (fully qualified) for the attribute
     */
    public String getAttributeType( AttributeInternal attribute ) {

        String type;
        if ( attribute.getMultiplicity( ).getLower( ) == 0 && attribute.getMultiplicity( ).getUpper( ) == 1 ) {
            // optional, e.g. int has to become Integer to be able to initialize
            // it with null
            type = getJavaTypeClass( getType( (ClassifierInternal) attribute.getType( connection ) ) );
        } else if ( attribute.getMultiplicity( ).getLower( ) == 1 && attribute.getMultiplicity( ).getUpper( ) == 1 ) {
            type = getType( (ClassifierInternal) attribute.getType( connection ) );
        } else {
            if ( !( attribute.getMultiplicity( ).isOrdered( ) ) ) {
                type = Collection.class.getName( );
            } else {
                type = List.class.getName( );
            }
        }
        return type;
    }

    public String getAttributeTypeGenerified( AttributeInternal attribute ) {

        String type;
        if ( attribute.getMultiplicity( ).getUpper( ) == 1 ) {
            type = getJavaTypeClass( getType( (ClassifierInternal) attribute.getType( connection ) ) );
        } else {
            if ( !( attribute.getMultiplicity( ).isOrdered( ) ) ) {
                type = Collection.class.getName( );
            } else {
                type = List.class.getName( );
            }
            type += "<" + getStructuralFeatureTypeParameter( attribute ) + ">"; //$NON-NLS-1$  //$NON-NLS-2$
        }
        return type;
    }

    /**
     * @param structuralFeature
     * @return the Java generic type parameter (fully qualified) for a
     * multi-valued structural feature and null for a single-valued one
     */
    public String getStructuralFeatureTypeParameter( StructuralFeatureInternal structuralFeature ) {

        if ( structuralFeature.getMultiplicity( ).getUpper( ) != 1 ) {
            return getJavaTypeClass( getType( (ClassifierInternal) structuralFeature.getType( connection ) ) );
        }
        return null;
    }

    protected Iterator<ModelElement> getAllContent( ModelElementInternal modelElement ) {

        return getJmiHelper( ).getAllContent( this.connection, (ModelElement) modelElement ).iterator( );
    }

    public SpiJmiHelper getJmiHelper( ) {

        return this.connection.getCoreJmiHelper( );
    }

    protected String getJMIIdentifierQualified( NamespaceInternal namespace ) {

        String packageName = getJmiHelper( ).getJMIPackageIdentifierQualified( this.connection, (Namespace) namespace );
        if ( ( packageName != null ) && ( packageName.length( ) != 0 ) ) {
            return packageName + Utilities.JAVA_PACKAGE_DELIMITER + getJMIIdentifier( namespace );
        }
        return getJMIIdentifier( namespace );
    }

    protected Tag getTag( ModelElementInternal tagged, String tagId ) {

        return getTag( (ModelElement) tagged, tagId );
    }

    protected Tag getTag( ModelElement tagged, String tagId ) {

        return getJmiHelper( ).getTag( this.connection.getSession( ), tagged, tagId );
    }

    /*
     * protected to avoid synthetic access
     */
    protected List<String> getRelativePath( JmiGenerationKind genKind ) {

        return Utilities.getUtilities( ).decodeQualifiedName( getJavaPackageNameQualified( genKind ) );
    }

    private String getJavaPackageNameQualifiedForClass( NamespaceInternal mp ) {

        return getJavaPackageNameQualifiedForInterface( mp ) + Utilities.JAVA_PACKAGE_DELIMITER + PACKAGE_IMPLEMENTATION;
    }

    private String getJavaPackageNameQualifiedForInterface( NamespaceInternal namespace ) {

        if ( namespace instanceof MofPackage ) {
            return getJMIIdentifierQualified( namespace ).toLowerCase( Locale.ENGLISH );
        }
        return getJmiHelper( ).getJMIPackageIdentifierQualified( this.connection, (Namespace) namespace ).toLowerCase( Locale.ENGLISH );
    }

    protected JmiGeneratorBaseWrapper getOrCreateWrapper( ModelElementInternal modelElement ) {

        return this.myGenerator.getOrCreateWrapper( this.metamodelName, (ModelElement) modelElement, null );
    }

    public abstract JmiGeneratorMofType getMofType( );

    /**
     * @param genKind
     * @param templateName
     * @return the java template for the generation kind
     */
    public abstract JmiGeneratorBaseTemplate getJavaTemplate( JmiGenerationKind genKind, String templateName );

    /**
     * @param genKind
     * @return the String template names for the generation kind
     */
    public abstract List<String> getTemplateNames( JmiGenerationKind genKind );

    /**
     * @param genKind
     * @param qualified
     * @return the Java types (fully qualified) from which this extends
     */
    public abstract List<String> getExtends( JmiGenerationKind genKind, boolean qualified );

    /**
     * @param genKind
     * @param qualified
     * @return the Java interfaces (fully qualified) that this implements
     */
    public abstract List<String> getImplements( JmiGenerationKind genKind, boolean qualified );

    protected abstract void initChildren( );

    protected String composeVariableName( String name ) {

        return VARIABLE_PREFIX + StringUtils.convertFirstCharToLower( checkKeyword( name, true ) );
    }

    protected OperationSignature convertOperation2Signature( OperationInternal anOperation ) {

        String operationName = getJMIIdentifier( anOperation );
        OperationSignature sig = new OperationSignature( operationName );
        for ( Iterator<ModelElement> iterator = getAllContent( anOperation ); iterator.hasNext( ); ) {
            ModelElement me = iterator.next( );
            if ( me instanceof ParameterInternal ) {
                ParameterInternal operationParameter = (ParameterInternal) me;
                if ( operationParameter.getDirection( ).equals( DirectionKindEnum.RETURN_DIR ) ) {
                    // not relevant for signature
                } else {
                    sig.getParameterTypes( ).add( operationParameter.getType( connection ).getName( ) );
                }
            }
        }
        return sig;
    }

    protected String getAccessorNameForTypedElement( TypedElementInternal aTypedElement ) {

        String accessorName = EMPTY;
        String typedElementName = StringUtils.convertFirstCharToUpper( getJMIIdentifier( aTypedElement ) );
        if ( aTypedElement instanceof StructuralFeature ) {
            StructuralFeature structuralFeature = (StructuralFeature) aTypedElement;
            if ( structuralFeature.getMultiplicity( ).getUpper( ) == 1 ) {
                if ( ( (StructuralFeatureInternal) structuralFeature ).getType( connection ).getName( ).compareToIgnoreCase( "BOOLEAN" ) == 0 ) { //$NON-NLS-1$
                    if ( typedElementName.substring( 0, 2 ).compareToIgnoreCase( "is" ) == 0 ) { //$NON-NLS-1$
                        typedElementName = StringUtils.convertFirstCharToUpper( typedElementName.substring( 2 ) );
                    }
                    accessorName = "is" + typedElementName; //$NON-NLS-1$
                } else {
                    accessorName = "get" + typedElementName; //$NON-NLS-1$
                }
            } else {
                accessorName = "get" + typedElementName; //$NON-NLS-1$
            }
        } else {
            if ( aTypedElement.getType( connection ).getName( ).compareToIgnoreCase( "BOOLEAN" ) == 0 ) { //$NON-NLS-1$
                if ( typedElementName.substring( 0, 2 ).compareToIgnoreCase( "is" ) == 0 ) { //$NON-NLS-1$
                    typedElementName = StringUtils.convertFirstCharToUpper( typedElementName.substring( 2 ) );
                }
                accessorName = "is" + typedElementName; //$NON-NLS-1$
            } else {
                accessorName = "get" + typedElementName; //$NON-NLS-1$
            }
        }
        return accessorName;
    }

    /*
     * protected to avoid synthetic access
     */
    protected String createCodeInternal( JmiGenerationKind generationKind, String templateName ) {

        StringTemplate st;

        switch ( getMofType( ) ) {
            case ASSOCIATION:
                st = assocgroup.getInstanceOf( templateName );
                break;
            case CLASS:
                st = classgroup.getInstanceOf( templateName );
                break;
            case ENUM:
                st = enumgroup.getInstanceOf( templateName );
                break;
            case EXCEPTION:
                st = exceptiongroup.getInstanceOf( templateName );
                break;
            case STRUCTURETYPE:
                st = stgroup.getInstanceOf( templateName );
                break;
            case PACKAGE:
                st = pkggroup.getInstanceOf( templateName );
                break;
            default:
                throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.UNSUPPORTEDMOFTYPE, getMofType( ).toString( ) );
        }

        JmiGeneratorBaseTemplate bt = JmiGeneratorBaseWrapper.this.getJavaTemplate( generationKind, st.getName( ) );
        st.setAttribute( "template", bt ); //$NON-NLS-1$
        return st.toString( );
    }

    protected String getAccessorNameForModelElement( ModelElementInternal aModelElement ) {

        if ( aModelElement instanceof TypedElementInternal ) {
            return getAccessorNameForTypedElement( (TypedElementInternal) aModelElement );
        }
        return "get" + StringUtils.convertFirstCharToUpper( getJMIIdentifier( aModelElement ) ); //$NON-NLS-1$
    }

    protected String getMutatorNameForTypedElement( TypedElementInternal aTypedElement ) {

        String mutatorName = EMPTY;
        String typedElementName = StringUtils.convertFirstCharToUpper( getJMIIdentifier( aTypedElement ) );
        if ( aTypedElement instanceof StructuralFeature ) {
            StructuralFeature structuralFeature = (StructuralFeature) aTypedElement;
            if ( structuralFeature.getMultiplicity( ).getUpper( ) == 1 ) {
                if ( ( (StructuralFeatureInternal) structuralFeature ).getType( connection ).getName( ).compareToIgnoreCase( "BOOLEAN" ) == 0 ) { //$NON-NLS-1$
                    if ( typedElementName.substring( 0, 2 ).compareToIgnoreCase( "is" ) == 0 ) { //$NON-NLS-1$
                        typedElementName = StringUtils.convertFirstCharToUpper( typedElementName.substring( 2 ) );
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
                if ( parameter.getType( ).getName( ).compareToIgnoreCase( "BOOLEAN" ) == 0 ) { //$NON-NLS-1$
                    if ( typedElementName.substring( 0, 2 ).compareToIgnoreCase( "is" ) == 0 ) { //$NON-NLS-1$
                        typedElementName = StringUtils.convertFirstCharToUpper( typedElementName.substring( 2 ) );
                    }
                    mutatorName = "set" + typedElementName; //$NON-NLS-1$
                } else {
                    mutatorName = "set" + typedElementName; //$NON-NLS-1$
                }
            } else {
                mutatorName = "set" + typedElementName; //$NON-NLS-1$
            }
        } else {
            if ( aTypedElement.getType( connection ).getName( ).compareToIgnoreCase( "BOOLEAN" ) == 0 ) { //$NON-NLS-1$
                if ( typedElementName.substring( 0, 2 ).compareToIgnoreCase( "is" ) == 0 ) { //$NON-NLS-1$
                    typedElementName = StringUtils.convertFirstCharToUpper( typedElementName.substring( 2 ) );
                }
                mutatorName = "set" + typedElementName; //$NON-NLS-1$
            } else {
                mutatorName = "set" + typedElementName; //$NON-NLS-1$
            }
        }
        return mutatorName;
    }

    protected String getType( Classifier classifier ) {

        return getType( (ClassifierInternal) classifier );
    }

    protected String getType( ClassifierInternal classifier ) {

        String type = String.class.getName( );
        if ( classifier instanceof PrimitiveType ) {
            type = mapPrimitiveType( classifier );
        } else if ( classifier instanceof AliasType ) {
            Connection conn = ( (Partitionable) classifier ).get___Connection( );
            ClassifierInternal c = (ClassifierInternal) ( (SpiJmiHelper) conn.getJmiHelper( ) ).getNonAliasType( conn.getSession( ), (Classifier) classifier );
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
            JmiGeneratorEnumWrapper wrapper = (JmiGeneratorEnumWrapper) getOrCreateWrapper( classifier );
            return wrapper.getJavaClassName( JmiGenerationKind.INTERFACE, true );
            // type =
            // GeneratorEnumerationType.getJavaInterfaceNameQualified((EnumerationType)
            // classifier);
        } else {
            type = getJMIIdentifierQualified( classifier );
        }
        return type;
    }

    protected String getJavaTypeClass( String dataTypeName ) {

        String dtn = dataTypeName;
        if ( isJavaType( dtn ) ) {
            dtn = mapPrimitiveType( dtn );
            if ( dtn.compareTo( "int" ) == 0 ) { //$NON-NLS-1$
                dtn = "java.lang.Integer"; //$NON-NLS-1$
            }
            if ( dtn.indexOf( '.' ) >= 0 ) {
                return dtn;
            }
            return "java.lang." + dtn.substring( 0, 1 ).toUpperCase( Locale.ENGLISH ) + dtn.substring( 1 ).toLowerCase( Locale.ENGLISH ); //$NON-NLS-1$

        }
        return dtn;
    }

    protected String getReferenceType( ReferenceInternal reference ) {

        String typeOfReference = null;
        String referenceType = getType( (ClassifierInternal) reference.getType( connection ) );
        if ( reference.getMultiplicity( ).getUpper( ) == 1 ) {
            typeOfReference = referenceType;
        } else { // if upper > 1 (or < 0 means infinity) and isOrdered =
            // false
            if ( !( reference.getMultiplicity( ).isOrdered( ) ) ) {
                typeOfReference = Collection.class.getName( );
                // if upper > 1 and isOrdered = true
            } else {
                typeOfReference = List.class.getName( );
            }
        }
        return typeOfReference;
    }

    protected String getReferenceTypeGenerified( ReferenceInternal reference ) {

        String typeOfReference = null;
        String referenceType = getType( (ClassifierInternal) reference.getType( connection ) );
        if ( reference.getMultiplicity( ).getUpper( ) == 1 ) {
            typeOfReference = referenceType;
        } else { // if upper > 1 (or < 0 means infinity) and isOrdered =
            // false
            if ( !( reference.getMultiplicity( ).isOrdered( ) ) ) {
                typeOfReference = Collection.class.getName( );
                // if upper > 1 and isOrdered = true
            } else {
                typeOfReference = List.class.getName( );
            }
            typeOfReference += "<" + getStructuralFeatureTypeParameter( reference ) + ">"; //$NON-NLS-1$ //$NON-NLS-2$
        }
        return typeOfReference;
    }

    protected String getOperationNameForOperation( OperationInternal anOperation ) {

        return StringUtils.convertFirstCharToLower( getJMIIdentifier( anOperation ) );
    }

    protected String getInternalOperationNameForOperation( OperationInternal anOperation ) {

        return INTERNAL_CALLER_PREFIX + getOperationNameForOperation( anOperation );
    }

    protected String getJavaReturnInitialValueByType( String type ) {

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

    protected String getJavaTypeAsObject( String type, String variable ) {

        String str;
        if ( type == null ) {
            str = variable;
        } else if ( type.compareToIgnoreCase( "boolean" ) == 0 ) { //$NON-NLS-1$
            str = "java.lang.Boolean.valueOf(" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "unlimitedinteger" ) == 0 ) { //$NON-NLS-1$
            str = "java.lang.Integer.valueOf(" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "int" ) == 0 ) { //$NON-NLS-1$
            str = "java.lang.Integer.valueOf(" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "integer" ) == 0 ) { //$NON-NLS-1$
            str = "java.lang.Integer.valueOf(" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "long" ) == 0 ) { //$NON-NLS-1$
            str = "java.lang.Long.valueOf(" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "float" ) == 0 ) { //$NON-NLS-1$
            str = "java.lang.Float.valueOf(" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( type.compareToIgnoreCase( "double" ) == 0 ) { //$NON-NLS-1$
            str = "java.lang.Double.valueOf(" + variable + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else {
            str = variable;
        }
        return str;
    }

    protected String getJavaTypeGetValue( String type ) {

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

    protected boolean isJavaType( String dataTypeName ) {

        if ( dataTypeName == null ) {
            return false;
        }
        if ( dataTypeName.toLowerCase( Locale.ENGLISH ).compareTo( "int" ) == 0 ) { //$NON-NLS-1$
            return true;
        }
        return dataTypeMappings.containsKey( dataTypeName.toLowerCase( Locale.ENGLISH ) );
    }

    protected boolean isJavaStringType( String dataTypeName ) {

        if ( dataTypeName == null ) {
            return false;
        }
        return "java.lang.String".equalsIgnoreCase( dataTypeName ); //$NON-NLS-1$
    }

    protected String mapVisibilityToJava( FeatureInternal feature ) {

        if ( VisibilityKindEnum.PUBLIC_VIS.equals( feature.getVisibility( ) ) ) {
            return MODIFIER_PUBLIC;
        } else if ( VisibilityKindEnum.PROTECTED_VIS.equals( feature.getVisibility( ) ) ) {
            return MODIFIER_PROTECTED;
        } else if ( VisibilityKindEnum.PRIVATE_VIS.equals( feature.getVisibility( ) ) ) {
            return MODIFIER_PRIVATE;
        } else {
            LOGGER.trace( MoinSeverity.WARNING, JmiGeneratorTraces.VISIBILITYDEFAULTED, feature.getName( ) );
            return MODIFIER_PUBLIC;
        }
    }

    protected void setParent( TreeNode actParent ) {

        this.parent = actParent;
    }

    private String mapPrimitiveType( ClassifierInternal classifier ) {

        return mapPrimitiveType( classifier.getName( ) );
    }

    private String mapPrimitiveType( String dataTypeName ) {

        String javaType = dataTypeName;
        if ( isJavaType( dataTypeName.toLowerCase( Locale.ENGLISH ) ) && dataTypeMappings.containsKey( dataTypeName.toLowerCase( Locale.ENGLISH ) ) ) {
            javaType = dataTypeMappings.get( dataTypeName.toLowerCase( Locale.ENGLISH ) );
        }
        return javaType;
    }

    private String checkKeyword( String name, boolean isVariable ) {

        if ( name == null ) {
            return null;
        }
        if ( isVariable ) {
            if ( keywordsJava.contains( name.toLowerCase( Locale.ENGLISH ) ) ) {
                return PREFIX_MOF + name;
            }
            return name;

        }
        if ( keywordsJavaForClass.contains( name.toLowerCase( Locale.ENGLISH ) ) ) {
            return PREFIX_MOF + name;
        }
        return name;
    }

    // TreeNode stuff
    public Enumeration<JmiGeneratorBaseWrapper> children( ) {

        this.initChildren( );
        return this.children.elements( );
    }

    public boolean getAllowsChildren( ) {

        return true;
    }

    public TreeNode getChildAt( int childIndex ) {

        this.initChildren( );
        return this.children.get( childIndex );
    }

    public int getChildCount( ) {

        this.initChildren( );
        return this.children.size( );
    }

    public int getIndex( TreeNode node ) {

        this.initChildren( );
        return this.children.indexOf( node );
    }

    public TreeNode getParent( ) {

        return this.parent;
    }

    public boolean isLeaf( ) {

        return false;
    }

    private final static class OperationSignature {

        private final String name;

        private final List<String> parameterTypes = new ArrayList<String>( );

        /**
         * @param opName
         */
        public OperationSignature( String opName ) {

            this.name = opName;
        }

        /**
         * @return the parameter types
         */
        public List<String> getParameterTypes( ) {

            return this.parameterTypes;
        }

        @Override
        public boolean equals( Object o ) {

            if ( o instanceof OperationSignature ) {
                OperationSignature s = (OperationSignature) o;
                return this.name.equals( s.name ) && this.parameterTypes.equals( s.parameterTypes );
            }
            return false;
        }

        @Override
        public int hashCode( ) {

            return 41 * ( this.name.hashCode( ) + this.parameterTypes.hashCode( ) );
        }

        @Override
        public String toString( ) {

            StringBuffer sb = new StringBuffer( );
            sb.append( this.name + "(" ); //$NON-NLS-1$
            Iterator<String> it = this.parameterTypes.iterator( );
            while ( it.hasNext( ) ) {
                sb.append( it.next( ) );
                if ( it.hasNext( ) ) {
                    sb.append( ", " ); //$NON-NLS-1$
                }
            }
            sb.append( ")" ); //$NON-NLS-1$
            return sb.toString( );
        }
    }

    protected void addCoreConnectionParameter( List<JmiGeneratorParameter> parameters ) {

        parameters.add( new JmiGeneratorParameterImpl( CONNECTION_VARIABLE_NAME, CONNECTION_TYPE_NAME, null ) );
    }

    protected boolean isMofElement( ModelElementInternal element ) {

        return isMofElement( (ModelElement) element );
    }

    protected boolean isMofElement( ModelElement element ) {

        return ( (Partitionable) element ).get___Partition( ).getPri( ).getContainerName( ).equals( MOF_1_4_CONTAINER_NAME );
    }

    public boolean belongsToMof( ) {

        if ( this.metamodelName.equals( MOF_1_4_CONTAINER_NAME ) ) {
            return true;
        }
        return false;
    }

    public static boolean belongsToMof( String metamodelName ) {

        if ( metamodelName.equals( MOF_1_4_CONTAINER_NAME ) ) {
            return true;
        }
        return false;
    }

    /**
     * @return the constant for the extent descriptor
     */
    protected JmiGeneratorDescriptorConstant getExtentDescriptorConstant( final String name, final String type ) {

        List<String> qualifiedNameOfUnderlyingModelElement = ( (ModelElementInternal) this.underlyingModelElement ).getQualifiedName( this.connection );
        String qualifiedNameCommaSeparated = EMPTY;
        for ( Iterator<String> iterator = qualifiedNameOfUnderlyingModelElement.iterator( ); iterator.hasNext( ); ) {
            qualifiedNameCommaSeparated += iterator.next( );
            if ( iterator.hasNext( ) ) {
                qualifiedNameCommaSeparated += "\", \""; //$NON-NLS-1$
            }
        }
        List<String> components = new ArrayList<String>( qualifiedNameOfUnderlyingModelElement.size( ) + 2 );
        components.addAll( qualifiedNameOfUnderlyingModelElement );
        components.add( 0, getModelElementMofId( ) );
        components.add( 0, getMetamodelName( ) );
        String constantValue = "new " + type + "(\"" + getModelElementMofId( ) + "\", \"" + getMetamodelName( ) + "\", " + "\"" + qualifiedNameCommaSeparated + "\"" + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
        JmiGeneratorDescriptorConstantImpl extentDescriptorConstant = new JmiGeneratorDescriptorConstantImpl( "public", type, name, constantValue, components ); //$NON-NLS-1$
        extentDescriptorConstant.setAnnotation( "Extent descriptor" ); //$NON-NLS-1$
        return extentDescriptorConstant;
    }

    public JmiGeneratorJavadoc getJavadocForAnnotation( ) {

        JmiGeneratorJavadoc javadoc = null;
        String annotation = this.underlyingModelElement.getAnnotation( );
        if ( annotation != null && annotation.length( ) != 0 ) {
            javadoc = new JmiGeneratorJavadocImpl( annotation );
        }
        return javadoc;
    }

    public String getImmediateCompositeMofId( ) {

        RefFeatured composite = this.underlyingModelElement.refImmediateComposite( );
        if ( composite != null ) {
            return composite.refMofId( );
        }
        return null;
    }

    protected OclStatement getInitializerStatementFromConstraint( ConstraintInternal constraint, GeneralizableElementInternal generalizableElement ) {

        OclStatement initialStatement = null;
        try {
            // build the working structures for the OCL parser
            MofPackage constraintPackage = null;
            RefFeatured parent = ( (RefObjectImpl) constraint ).refImmediateComposite( connection.getSession( ) );
            while ( constraintPackage == null ) {
                if ( parent == null ) {
                    break;
                }
                if ( parent instanceof MofPackage ) {
                    constraintPackage = (MofPackage) parent;
                }
                if ( parent instanceof RefObject ) {
                    parent = ( (RefObjectImpl) parent ).refImmediateComposite( connection.getSession( ) );
                } else {
                    parent = null;
                }
            }

            Map<String, List<ModelElement>> name2Elements = new HashMap<String, List<ModelElement>>( );
            Map<String, ModelElement> qName2Element = new HashMap<String, ModelElement>( );
            // for overwritten initializers we need the supertypes for the type resolution
            List<GeneralizableElement> allSupertypes = new ArrayList<GeneralizableElement>( );
            allSupertypes.addAll( getJmiHelper( ).getAllSupertypes( this.connection.getSession( ), (GeneralizableElement) generalizableElement ) );
            allSupertypes.add( (GeneralizableElement) generalizableElement );
            for ( GeneralizableElement element : allSupertypes ) {
                List<ModelElement> elements = new ArrayList<ModelElement>( );
                elements.add( element );
                name2Elements.put( element.getName( ), elements );
                qName2Element.put( QualifiedName.toDotSeparatedString( ( (GeneralizableElementInternal) element ).getQualifiedName( connection ) ), element );
            }

            if ( constraint instanceof OclConstraintInternal ) {
                final OclConstraintInternal oc = (OclConstraintInternal) constraint;
                // TODO remove this
                // the initialized attribute association should be remvoed
                // once all metamodels were re-converted and replaced by the
                // initialized element assoctiaion (code below)
                final Attribute att = oc.getInitializedAttribute( connection );
                if ( att != null ) {
                    return new OclStatement( ) {

                        public String getName( ) {

                            return "dummy"; //$NON-NLS-1$
                        }

                        public int getKind( ) {

                            return OclStatement.INIT_EXPRESSION;
                        }

                        public OclExpression getExpression( ) {

                            return oc.getOclExpression( connection );
                        }

                        public RefObject getContext( ) {

                            return att;
                        }

                    };
                }

                final TypedElement typedElement = oc.getInitializedElement( connection );
                if ( typedElement != null ) {
                    return new OclStatement( ) {

                        public String getName( ) {

                            return "dummy"; //$NON-NLS-1$
                        }

                        public int getKind( ) {

                            return OclStatement.INIT_EXPRESSION;
                        }

                        public OclExpression getExpression( ) {

                            return oc.getOclExpression( connection );
                        }

                        public RefObject getContext( ) {

                            return typedElement;
                        }

                    };

                }
            }
            // backward compatibility code:
            // parse the OCL expression and find the initializer statement
            // TODO remove this
            Set<OclStatement> statements = this.oclParser.parseString( constraint.getExpression( ), constraintPackage, name2Elements, qName2Element, null );
            if ( statements != null && statements.size( ) > 0 ) {
                OclStatement firstStatement = statements.iterator( ).next( );
                // consider OCL initializers for attributes
                if ( firstStatement != null && firstStatement.getKind( ) == OclStatement.INIT_EXPRESSION && firstStatement.getContext( ) instanceof Attribute ) {
                    initialStatement = firstStatement;
                }
            }
        } catch ( Exception ex ) {
            LOGGER.trace( ex, MoinSeverity.WARNING, JmiGeneratorTraces.COULDNOTPARSEOCL, constraint.getExpression( ) );
        }
        return initialStatement;
    }

    protected String evaluateConstantValueFromInitializerStatement( OclExpression expression ) {

        // evaluate the constant value of an expression
        // examples for expressions:
        //   context myClass::myAttribute:String
        //   init: '42String'
        //   context myClass::myAttribute:Integer
        //   init: 42
        //   context myClass::myAttribute:Boolean
        //   init: true
        //   context myClass::myAttribute:Double
        //   init: 42.0
        //   context myClass::myAttribute:Double
        //   init: 0.42e2
        //   context myClass::myAttribute:MyEnumeration
        //   init: MyEnumeration::myEnumerationField1
        //   context myStructure::myField:Integer
        //   init: 42
        String constantValue = null;
        if ( expression instanceof StringLiteralExpInternal ) {
            constantValue = ( (StringLiteralExpInternal) expression ).getStringSymbol( );
        } else if ( expression instanceof IntegerLiteralExpInternal ) {
            constantValue = Integer.toString( ( (IntegerLiteralExpInternal) expression ).getIntegerSymbol( ) );
        } else if ( expression instanceof BooleanLiteralExpInternal ) {
            constantValue = Boolean.toString( ( (BooleanLiteralExpInternal) expression ).isBooleanSymbol( ) );
        } else if ( expression instanceof RealLiteralExpInternal ) {
            constantValue = Double.toString( ( (RealLiteralExpInternal) expression ).getRealSymbol( ) );
        } else if ( expression instanceof EnumLiteralExpInternal ) {
            String literal = ( (EnumLiteralExpInternal) expression ).getLiteral( );
            String enumJmiInterfaceName = getJmiHelper( ).getJmiInterfaceName( connection, ( (EnumLiteralExpInternal) expression ).getReferredEnum( connection ) );
            constantValue = enumJmiInterfaceName + "Enum" + ".forName(\"" + literal + "\")"; //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
        }
        return constantValue;
    }

    protected String getQualifiedNameAsStringArrayInitializer( ModelElementInternal me ) {

        List<String> qualifiedName = me.getQualifiedName( this.connection );
        StringBuilder sb = new StringBuilder( "new java.lang.String[] { " ); //$NON-NLS-1$
        for ( int i = 0, n = qualifiedName.size( ); i < n; i++ ) {
            sb.append( "\"" ).append( qualifiedName.get( i ) ).append( "\"" ); //$NON-NLS-1$ //$NON-NLS-2$
            if ( i < n - 1 ) {
                sb.append( ", " ); //$NON-NLS-1$
            }
        }
        sb.append( " }" ); //$NON-NLS-1$
        return sb.toString( );
    }

    protected String getNonNls( int numStrings ) {

        StringBuilder sb = new StringBuilder( );
        for ( int i = 0; i < numStrings; i++ ) {
            sb.append( "//$NON-NLS-" + ( i + 1 ) + "$ " ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        return sb.toString( );
    }

    public CoreConnection getConnection( ) {

        return connection;
    }
}
