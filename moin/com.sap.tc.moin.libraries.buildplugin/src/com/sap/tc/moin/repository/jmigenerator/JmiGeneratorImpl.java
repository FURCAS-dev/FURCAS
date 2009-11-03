package com.sap.tc.moin.repository.jmigenerator;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import org.antlr.stringtemplate.CommonGroupLoader;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateErrorListener;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.StringTemplateGroupLoader;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Version;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorMetamodelExtensionTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorAssociationWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorAttributeWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorBaseWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorClassWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorEnumWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorExceptionWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorImportWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorPackageWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorReferenceWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorStructureFieldWrapper;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorStructureTypeWrapper;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * Generator implementation
 */
public class JmiGeneratorImpl {

    private static final String NAME_MODEL_PACKAGE = "Model"; //$NON-NLS-1$

    final static MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_BUILD_JMI_GENERATOR, JmiGeneratorImpl.class );

    private static final StringTemplateGroup deployextensiongroup;

    private final Map<ModelElement, JmiGeneratorBaseWrapper> modelElementToWrapper = new HashMap<ModelElement, JmiGeneratorBaseWrapper>( );

    private CoreConnection connection = null;

    static {

        StringTemplateErrorListener errorListener = new MoinStringTemplateErrorListener( );
        StringTemplateGroupLoader loader = new CommonClassLoaderGroupLoader( "com/sap/tc/moin/repository/jmigenerator/template", errorListener, JmiGeneratorImpl.class.getClassLoader( ) ); //$NON-NLS-1$
        StringTemplateGroup.registerGroupLoader( loader );

        deployextensiongroup = StringTemplateGroup.loadGroup( "deploymentext" ); //$NON-NLS-1$
    }

    /**
     * @param actConnection
     */
    public JmiGeneratorImpl( CoreConnection actConnection ) {

        this.connection = actConnection;
    }

    /**
     * Converts the model elements in the provided partitions into generator
     * wrappers
     * <p>
     * There is one wrapper for each type enumerated in
     * {@link JmiGeneratorMofType}. However, this method will only return
     * wrappers for objects that are relevant for JMI generation (i.e. not for
     * Attributes, References, StructureFields or Imports since the generated
     * artifacts for these objects only exist within other generated artifacts).
     * <p>
     * The wrappers are cached in the context of this Generator instance (see
     * {@link #getOrCreateWrapper(ModelElement)}).
     * 
     * @param metamodelName
     * @param partitions
     * @return the list of wrappers
     */
    public List<JmiGeneratorModelElementWrapper> createObjectList( String metamodelName, Set<ModelPartition> partitions ) {

        List<JmiGeneratorModelElementWrapper> result = new ArrayList<JmiGeneratorModelElementWrapper>( );

        for ( ModelPartition partition : partitions ) {
            for ( Partitionable me : partition.getElements( ) ) {
                if ( !( me instanceof ModelElement ) ) {
                    continue;
                }
                ModelElement modelElement = (ModelElement) me;
                MofPackage immediatePackage = modelElement.refImmediatePackage( ).refMetaObject( );
                if ( !immediatePackage.getQualifiedName( ).get( 0 ).equals( NAME_MODEL_PACKAGE ) ) {
                    // exclude instances that are not instances of the MOF, e.g.
                    // instances of OCL
                    continue;
                }

                if ( me instanceof MofClass || me instanceof MofPackage || me instanceof Association || me instanceof EnumerationType || me instanceof StructureType || me instanceof MofException ) {

                    try {
                        result.add( this.getOrCreateWrapper( metamodelName, (ModelElement) me ) );
                    } catch ( RuntimeException e ) {
                        throw new JmiGeneratorRuntimeException( e, JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORWRAPPER );
                    }
                }
            }
        }

        return result;
    }

    /**
     * Creates a list of root nodes for an object tree of wrappers
     * <p>
     * This is a tree view of the generated objects along the containment
     * hierarchy
     * 
     * @param metamodelName
     * @param packages
     * @return the list of root nodes
     */
    public List<JmiGeneratorModelElementWrapper> createObjectTree( String metamodelName, Set<MofPackage> packages ) {

        List<JmiGeneratorModelElementWrapper> result = new ArrayList<JmiGeneratorModelElementWrapper>( );

        for ( MofPackage mp : packages ) {
            if ( mp.getContainer( ) == null ) {
                try {
                    JmiGeneratorModelElementWrapper wrapper = new JmiGeneratorPackageWrapper( this.connection, metamodelName, mp, this );
                    result.add( wrapper );
                } catch ( RuntimeException e ) {
                    throw new JmiGeneratorRuntimeException( e, JmiGeneratorTraces.EXCEPTIONGETTINGGENERATORWRAPPER );
                }
            }

        }

        return result;

    }

    /**
     * Gets the deployment extensions
     * <p>
     * When generating a meta model archive (.jar), there are some additional
     * files required, mainly for indexing the contained classes. This method
     * must be called after a call to {@link #createObjectList(String, Set)}
     * since it needs information about the classes generated in this step.
     * 
     * @param metamodelName
     * @param partitions
     * @param generatedElements
     * @return the deployment extensions
     */
    public List<JmiGeneratorPathCodePair> getDeploymentExtensions( String metamodelName, Set<ModelPartition> partitions, List<JmiGeneratorModelElementWrapper> generatedElements ) {

        List<JmiGeneratorPathCodePair> result = new ArrayList<JmiGeneratorPathCodePair>( );
        result.add( generateDeploymentExtension( metamodelName, partitions, generatedElements ) );
        result.add( generateHelperProperties( metamodelName ) );
        return result;
    }

    /**
     * Get a wrapper from the cache or create it
     * <p>
     * There is one wrapper for each type enumerated in
     * {@link JmiGeneratorMofType}. The wrapper instances are cached in the
     * context of this Generator.
     * 
     * @param metamodelName the name of the metamodel (also known as container
     * name), e.g. sap.com/tc/moin/mof_1.4, can be null
     * @param modelElement the ModelElement to wrap
     * @param parent the parent (for creating the hierarchical view), can be
     * null
     * @return the wrapper the wrapper
     */
    public synchronized JmiGeneratorBaseWrapper getOrCreateWrapper( String metamodelName, ModelElement modelElement, JmiGeneratorBaseWrapper parent ) {

        ModelElement unwrappedModelElement;
        if ( modelElement instanceof Wrapper ) {
            unwrappedModelElement = ( (Wrapper<ModelElement>) modelElement ).unwrap( );
        } else {
            unwrappedModelElement = modelElement;
        }

        if ( this.modelElementToWrapper.containsKey( unwrappedModelElement ) ) {
            return this.modelElementToWrapper.get( unwrappedModelElement );
        }

        if ( unwrappedModelElement instanceof MofClass ) {
            JmiGeneratorClassWrapper wrapper = new JmiGeneratorClassWrapper( this.connection, metamodelName, (MofClass) unwrappedModelElement, this );
            this.modelElementToWrapper.put( unwrappedModelElement, wrapper );
            return wrapper;
        } else if ( unwrappedModelElement instanceof MofPackage ) {
            JmiGeneratorPackageWrapper wrapper = new JmiGeneratorPackageWrapper( this.connection, metamodelName, (MofPackage) unwrappedModelElement, this );
            this.modelElementToWrapper.put( unwrappedModelElement, wrapper );
            return wrapper;
        } else if ( unwrappedModelElement instanceof Association ) {
            JmiGeneratorAssociationWrapper wrapper = new JmiGeneratorAssociationWrapper( this.connection, metamodelName, (Association) unwrappedModelElement, this );
            this.modelElementToWrapper.put( unwrappedModelElement, wrapper );
            return wrapper;
        } else if ( unwrappedModelElement instanceof EnumerationType ) {
            JmiGeneratorEnumWrapper wrapper = new JmiGeneratorEnumWrapper( this.connection, metamodelName, (EnumerationType) unwrappedModelElement, this );
            this.modelElementToWrapper.put( unwrappedModelElement, wrapper );
            return wrapper;
        } else if ( unwrappedModelElement instanceof StructureType ) {
            JmiGeneratorStructureTypeWrapper wrapper = new JmiGeneratorStructureTypeWrapper( this.connection, metamodelName, (StructureType) unwrappedModelElement, this );
            this.modelElementToWrapper.put( unwrappedModelElement, wrapper );
            return wrapper;
        } else if ( unwrappedModelElement instanceof MofException ) {
            JmiGeneratorExceptionWrapper wrapper = new JmiGeneratorExceptionWrapper( this.connection, metamodelName, (MofException) unwrappedModelElement, this );
            this.modelElementToWrapper.put( unwrappedModelElement, wrapper );
            return wrapper;
        } else if ( unwrappedModelElement instanceof Attribute ) {
            JmiGeneratorAttributeWrapper wrapper = new JmiGeneratorAttributeWrapper( this.connection, metamodelName, (Attribute) unwrappedModelElement, parent, this );
            this.modelElementToWrapper.put( unwrappedModelElement, wrapper );
            return wrapper;
        } else if ( unwrappedModelElement instanceof Reference ) {
            JmiGeneratorReferenceWrapper wrapper = new JmiGeneratorReferenceWrapper( this.connection, metamodelName, (Reference) unwrappedModelElement, parent, this );
            this.modelElementToWrapper.put( unwrappedModelElement, wrapper );
            return wrapper;
        } else if ( unwrappedModelElement instanceof StructureField ) {
            JmiGeneratorStructureFieldWrapper wrapper = new JmiGeneratorStructureFieldWrapper( this.connection, metamodelName, (StructureField) unwrappedModelElement, parent, this );
            this.modelElementToWrapper.put( unwrappedModelElement, wrapper );
            return wrapper;
        } else if ( unwrappedModelElement instanceof Import ) {
            JmiGeneratorImportWrapper wrapper = new JmiGeneratorImportWrapper( this.connection, metamodelName, (Import) unwrappedModelElement, parent, this );
            this.modelElementToWrapper.put( unwrappedModelElement, wrapper );
            return wrapper;
        }
        throw new MoinLocalizedBaseRuntimeException( JmiGeneratorTraces.CANNOTCREATEWRAPPER, unwrappedModelElement.getName( ) );
    }

    /**
     * Get a wrapper from the cache or create it
     * <p>
     * There is one wrapper for each type enumerated in
     * {@link JmiGeneratorMofType}. The wrapper instances are cached in the
     * context of this Generator.
     * 
     * @param me the ModelElement to wrap
     * @return the wrapper
     */
    public JmiGeneratorBaseWrapper getOrCreateWrapper( ModelElement me ) {

        return getOrCreateWrapper( null, me );
    }

    /**
     * Get a wrapper from the cache or create it
     * <p>
     * There is one wrapper for each type enumerated in
     * {@link JmiGeneratorMofType}. The wrapper instances are cached in the
     * context of this Generator.
     * 
     * @param metamodelName the name of the metamodel (also known as container
     * name), e.g. sap.com/tc/moin/mof_1.4, can be null
     * @param me the ModelElement to wrap
     * @return the wrapper
     */
    public JmiGeneratorBaseWrapper getOrCreateWrapper( String metamodelName, ModelElement me ) {

        return getOrCreateWrapper( metamodelName, me, null );
    }

    private JmiGeneratorPathCodePair generateDeploymentExtension( String metamodelName, Set<ModelPartition> partitions, List<JmiGeneratorModelElementWrapper> generatedElements ) {

        Version coreRuntimeVersion = this.connection.getSession( ).getMoin( ).getCoreRuntimeVersion( );
        final String path = Utilities.getMMPackageQualified( metamodelName );
        Set<Partitionable> allModelElements = new HashSet<Partitionable>( );
        for ( ModelPartition partition : partitions ) {
            allModelElements.addAll( partition.getElements( ) );
        }
        final JmiGeneratorMetamodelExtensionTemplateImpl template = new JmiGeneratorMetamodelExtensionTemplateImpl( metamodelName, path, "com.sap.tc.moin.repository.metamodels.DeploymentExtension", generatedElements, coreRuntimeVersion, allModelElements ); //$NON-NLS-1$

        StringTemplate st = deployextensiongroup.getInstanceOf( "MetaModelExtensionClass" ); //$NON-NLS-1$
        st.setAttribute( "template", template ); //$NON-NLS-1$
        final String code = st.toString( );

        JmiGeneratorPathCodePair result = new JmiGeneratorPathCodePair( ) {

            public List<String> getRelativePath( ) {

                return Utilities.getUtilities( ).decodeQualifiedName( path );
            }

            public String getFileName( ) {

                return template.getJavaName( );
            }

            public String getCode( ) {

                return code;
            }

            public String getFileExtension( ) {

                return JmiGeneratorBaseWrapper.EXTENSION_JAVA;
            }

        };
        return result;
    }

    private JmiGeneratorPathCodePair generateHelperProperties( String metamodelName ) {

        final String path = Utilities.MOIN_PACKAGE;

        String pathToExtensions = Utilities.getMMPackageQualified( metamodelName );

        final String code = "MetamodelExtensionName = " + pathToExtensions; //$NON-NLS-1$

        JmiGeneratorPathCodePair result = new JmiGeneratorPathCodePair( ) {

            public List<String> getRelativePath( ) {

                return Utilities.getUtilities( ).decodeQualifiedName( path );
            }

            public String getFileName( ) {

                return "MetaModelExtension"; //$NON-NLS-1$
            }

            public String getCode( ) {

                return code;
            }

            public String getFileExtension( ) {

                return "properties"; //$NON-NLS-1$
            }

        };
        return result;
    }

    /**
     * Listener for StringTemplate errors, delegates to the logging
     * infrastructure
     */
    public static final class MoinStringTemplateErrorListener implements StringTemplateErrorListener {

        public void warning( String message ) {

            LOGGER.trace( MoinSeverity.WARNING, message );
        }

        public void error( String message, Throwable ex ) {

            //only use warning as otherwise this will lead to a lot of error markings, especially in eclipse use case
            LOGGER.trace( ex, MoinSeverity.WARNING, message );
        }

    }

    /**
     * Group loader implementation for StringTemplate
     */
    public static final class CommonClassLoaderGroupLoader extends CommonGroupLoader {

        private ClassLoader classLoader;

        /**
         * @param dirStr
         * @param errorListener
         * @param templateClassLoader
         */
        public CommonClassLoaderGroupLoader( String dirStr, StringTemplateErrorListener errorListener, ClassLoader templateClassLoader ) {

            super( dirStr, errorListener );
            this.classLoader = templateClassLoader;
        }

        @Override
        protected BufferedReader locate( String name ) throws IOException {

            for ( int i = 0; i < this.dirs.size( ); i++ ) {
                String dir = (String) this.dirs.get( i );
                String fileName = dir + "/" + name; //$NON-NLS-1$
                ClassLoader cl = this.classLoader;
                byte[] buffer = null;
                if ( buffer == null ) {
                    cl = this.getClass( ).getClassLoader( );
                    InputStream is = null;
                    try {
                        is = cl.getResourceAsStream( fileName );

                        int size = is.available( );
                        buffer = new byte[size];
                        is.read( buffer );
                    } finally {
                        if ( is != null ) {
                            is.close( );
                        }
                    }
                }
                if ( buffer != null ) {
                    ByteArrayInputStream is = new ByteArrayInputStream( buffer );
                    return new BufferedReader( getInputStreamReader( is ) );
                }
            }
            return null;
        }
    }

}
