package com.sap.tc.moin.repository.jmigenerator.wrappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.__impl.ConstraintInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureFieldInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeInternal;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorMofType;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorAttributeDeclaration;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorFeature;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorTypedElementInitialization;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorClassOperationImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorFeatureImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorStructureTypeImplTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorStructureTypeInterfaceTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorTypedElementInitializationImpl;
import com.sap.tc.moin.repository.shared.util.StringUtils;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * The StructureType wrapper
 */
public class JmiGeneratorStructureTypeWrapper extends JmiGeneratorBaseWrapper {

    private final StructureTypeInternal wrappedStruct;

    /**
     * @param connection
     * @param metamodelName
     * @param underlyingModelElement
     * @param generator
     */
    public JmiGeneratorStructureTypeWrapper( CoreConnection connection, String metamodelName, StructureType underlyingModelElement, JmiGeneratorImpl generator ) {

        super( connection, metamodelName, underlyingModelElement, null, generator );
        this.wrappedStruct = (StructureTypeInternal) underlyingModelElement;
    }

    @Override
    public List<String> getExtends( JmiGenerationKind genKind, boolean qualified ) {

        List<String> result = new ArrayList<String>( );

        switch ( genKind ) {
            case INTERFACE:
                List<String> qnames = new ArrayList<String>( );
                JmiList<ModelElement> stypes = (JmiList) ( (StructureTypeInternal) this.wrappedStruct ).getSupertypes( this.connection );
                for ( Iterator<ModelElement> iterator = stypes.iteratorReadOnly( this.connection.getSession( ) ); iterator.hasNext( ); ) {
                    ModelElementInternal st = (ModelElementInternal) iterator.next( );
                    qnames.add( ( (JmiGeneratorStructureTypeWrapper) getOrCreateWrapper( st ) ).getJavaClassName( JmiGenerationKind.INTERFACE, true ) );
                }
                if ( qnames.isEmpty( ) ) {
                    qnames.add( CLASS_REFSTRUCTAPI );
                }
                result.addAll( qnames );
                break;

            case CLASS:
                result.add( CLASS_REFSTRUCTIMPL );
                break;

            default:
                throw new MoinUnsupportedOperationException( "getExtends" ); //$NON-NLS-1$
        }
        return result;
    }

    @Override
    public List<String> getImplements( JmiGenerationKind genKind, boolean qualified ) {

        List<String> result = new ArrayList<String>( );
        switch ( genKind ) {
            case INTERFACE:
                // nothing
                break;
            case CLASS:
                result.add( getJavaClassName( JmiGenerationKind.INTERFACE, qualified ) );
                break;
            default:
                break;
        }
        return result;
    }

    @Override
    public String getJavaClassName( JmiGenerationKind genKind, boolean qualified ) {

        StringBuilder sb = new StringBuilder( );
        if ( qualified ) {
            sb.append( getJavaPackageNameQualified( genKind ) );
            sb.append( Utilities.JAVA_PACKAGE_DELIMITER );
        }
        switch ( genKind ) {
            case CLASS:
                sb.append( getJMIIdentifier( ) );
                sb.append( EXTENSION_IMPLEMENTATION );
                return sb.toString( );

            case INTERFACE:
                sb.append( getJMIIdentifier( ) );
                return sb.toString( );

            default:
                throw new MoinUnsupportedOperationException( "getJavaClassName" ); //$NON-NLS-1$
        }
    }

    @Override
    public JmiGeneratorBaseTemplate getJavaTemplate( JmiGenerationKind genKind, String templateName ) {

        switch ( genKind ) {
            case INTERFACE:
                return new JmiGeneratorStructureTypeInterfaceTemplateImpl( this );

            case CLASS:
                return new JmiGeneratorStructureTypeImplTemplateImpl( this );

            default:
                throw new MoinUnsupportedOperationException( "getJavaTemplate" ); //$NON-NLS-1$
        }
    }

    @Override
    public JmiGeneratorMofType getMofType( ) {

        return JmiGeneratorMofType.STRUCTURETYPE;
    }

    @Override
    public List<String> getTemplateNames( JmiGenerationKind genKind ) {

        List<String> result = new ArrayList<String>( );
        switch ( genKind ) {
            case CLASS:
                result.add( "StructureTypeImpl" ); //$NON-NLS-1$
                break;
            case INTERFACE:
                result.add( "StructureTypeInterface" ); //$NON-NLS-1$
                break;
            default:
                break;
        }

        return result;
    }

    @Override
    protected void initChildren( ) {

        // no children
    }

    /**
     * @param genKind
     * @return the fields
     */
    public List<JmiGeneratorClassOperation> getFields( JmiGenerationKind genKind ) {

        List<JmiGeneratorClassOperation> result = new ArrayList<JmiGeneratorClassOperation>( );

        Iterator<ModelElement> myChildren = getAllContent( );

        for ( ; myChildren.hasNext( ); ) {
            ModelElementInternal me = (ModelElementInternal) myChildren.next( );
            if ( me instanceof StructureFieldInternal ) {
                StructureFieldInternal field = (StructureFieldInternal) me;

                String accessor = getAccessorNameForTypedElement( field );
                String type = getType( field.getType( connection ) );
                JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( accessor, type, null, null );
                op.setFeatureName( getJMIIdentifier( field ) );
                op.setVariableName( composeVariableName( getJMIIdentifier( field ) ) );
                result.add( op );
            }
        }

        return result;
    }

    /**
     * @return the field names
     */
    public String getFieldNamesForStringArrayInitializer( ) {

        List<String> names = new ArrayList<String>( );
        Iterator<ModelElement> myChildren = getAllContent( );
        for ( ; myChildren.hasNext( ); ) {
            ModelElement me = myChildren.next( );
            if ( me instanceof StructureField ) {
                StructureField field = (StructureField) me;
                names.add( field.getName( ) );
            }
        }
        String result = "\"" + names.get( 0 ) + "\""; //$NON-NLS-1$ //$NON-NLS-2$
        for ( int i = 1; i < names.size( ); i++ ) {
            result += ", \"" + names.get( i ) + "\""; //$NON-NLS-1$ //$NON-NLS-2$
        }
        return result;
    }

    /**
     * @param genKind
     * @return the feature IDs
     */
    public List<String> getFeatureIds( JmiGenerationKind genKind ) {

        List<String> result = new ArrayList<String>( );

        if ( genKind == JmiGenerationKind.CLASS ) {
            Iterator<ModelElement> myChildren = getAllContent( );
            for ( ; myChildren.hasNext( ); ) {
                ModelElement me = myChildren.next( );
                if ( me instanceof StructureField ) {
                    result.add( me.getName( ) );
                }
            }
        }
        return result;
    }

    /**
     * @param genKind
     * @return the features
     */
    public List<JmiGeneratorFeature> getFeatures( JmiGenerationKind genKind ) {

        List<JmiGeneratorFeature> result = new ArrayList<JmiGeneratorFeature>( );
        List<String> featureIds = getFeatureIds( genKind );

        Iterator<ModelElement> myChildren = getAllContent( );

        for ( ; myChildren.hasNext( ); ) {
            ModelElement me = myChildren.next( );
            if ( me instanceof StructureFieldInternal ) {
                StructureFieldInternal field = (StructureFieldInternal) me;
                JmiGeneratorStructureFieldWrapper wrapper = (JmiGeneratorStructureFieldWrapper) getOrCreateWrapper( field );
                result.add( new JmiGeneratorFeatureImpl( wrapper ) );
            }
        }

        for ( JmiGeneratorFeature feature : result ) {
            ( (JmiGeneratorFeatureImpl) feature ).setIndex( featureIds.indexOf( feature.getName( ) ) );
        }

        return result;
    }

    /**
     * @param genKind
     * @return the attribute declarations
     */
    public List<JmiGeneratorAttributeDeclaration> getAttributeDeclarations( JmiGenerationKind genKind ) {

        List<JmiGeneratorAttributeDeclaration> result = new ArrayList<JmiGeneratorAttributeDeclaration>( );

        Iterator<ModelElement> myChildren;
        switch ( genKind ) {
            case INTERFACE:
                myChildren = this.getContent( );
                break;

            case CLASS:
                myChildren = this.getAllContent( );
                break;

            default:
                throw new MoinUnsupportedOperationException( "getAttributeDeclarations" ); //$NON-NLS-1$
        }

        switch ( genKind ) {
            case INTERFACE:

                break;

            case CLASS:
                for ( ; myChildren.hasNext( ); ) {
                    ModelElement me = myChildren.next( );
                    if ( me instanceof StructureFieldInternal ) {
                        StructureFieldInternal field = (StructureFieldInternal) me;

                        final String type = getType( field.getType( connection ) );
                        final String variableName = composeVariableName( StringUtils.convertFirstCharToLower( getJMIIdentifier( field ) ) );

                        result.add( new JmiGeneratorAttributeDeclaration( ) {

                            public String getType( ) {

                                return type;
                            }

                            public String getTypeParameter( ) {

                                return null;
                            }

                            public String getName( ) {

                                return variableName;
                            }

                            public String getValue( ) {

                                return null;
                            }

                            public boolean isArray( ) {

                                return false;
                            }

                            public String getJavaType( ) {

                                return type;
                            }

                            public boolean isNeedsToBeUnwrapped( ) {

                                return false;
                            }

                            public JmiGeneratorClassOperation getOperation( ) {

                                return null;
                            }

                            public void setNeedsToBeUnwrapped( boolean needsUnwrapping ) {

                            }

                            public boolean isPartitionParameter( ) {

                                return false;
                            }

                            public boolean isMultiple( ) {

                                // Not relevant for variable declarations
                                return false;
                            }

                            public boolean isObjectTyped( ) {

                                // Not relevant for variable declarations
                                return false;
                            }
                        } );

                    }
                }

                break;

            default:
                break;
        }
        return result;
    }

    public List<JmiGeneratorTypedElementInitialization> getFieldInitializations( JmiGenerationKind genKind ) {

        List<JmiGeneratorTypedElementInitialization> result = new ArrayList<JmiGeneratorTypedElementInitialization>( );
        switch ( genKind ) {
            case INTERFACE:
                return result;
            case CLASS:
                // extract the initializer constraints for attributes, also consider the inherited ones
                Map<String, String> initConstraintValuesForFields = new HashMap<String, String>( );
                Iterator<ModelElement> allContent = getAllContent( );
                for ( ; allContent.hasNext( ); ) {
                    ModelElement me = allContent.next( );
                    if ( me instanceof Constraint && ( (Constraint) me ).getLanguage( ).equals( "OCLInit" ) ) { //$NON-NLS-1$
                        OclStatement fieldInitialStatement = getInitializerStatementFromConstraint( (ConstraintInternal) me, this.wrappedStruct );
                        if ( fieldInitialStatement != null ) {
                            String value = evaluateConstantValueFromInitializerStatement( fieldInitialStatement.getExpression( ) );
                            if ( value != null ) {
                                initConstraintValuesForFields.put( ( (StructureField) fieldInitialStatement.getContext( ) ).getName( ), value );
                            }
                        }
                    }
                }
                allContent = getAllContent( );
                for ( ; allContent.hasNext( ); ) {
                    ModelElement me = allContent.next( );
                    if ( me instanceof StructureFieldInternal ) {
                        StructureFieldInternal field = (StructureFieldInternal) me;
                        if ( field.getType( connection ) instanceof MofClass ) {
                            continue;
                        }
                        String value = initConstraintValuesForFields.get( field.getName( ) );
                        if ( value != null ) {
                            if ( isJavaStringType( getType( field.getType( connection ) ) ) ) {
                                // surround with two "
                                value = "\"" + value + "\""; //$NON-NLS-1$ //$NON-NLS-2$
                            }
                            JmiGeneratorTypedElementInitializationImpl init = new JmiGeneratorTypedElementInitializationImpl( );
                            String internalMutator = null;
                            String accessorNameFragment = StringUtils.convertFirstCharToUpper( getJMIIdentifier( field ) );
                            if ( accessorNameFragment.toLowerCase( Locale.ENGLISH ).startsWith( "is" ) ) { //$NON-NLS-1$
                                internalMutator = INTERNAL_SETTER_PREFIX + accessorNameFragment.substring( 2 );
                            } else {
                                internalMutator = INTERNAL_SETTER_PREFIX + accessorNameFragment;
                            }
                            init.setInitializationCode( internalMutator + "(" + value + ")" ); //$NON-NLS-1$ //$NON-NLS-2$
                            result.add( init );
                        }
                    }
                }
                break;
            default:
                throw new MoinUnsupportedOperationException( "getFieldInitializations" ); //$NON-NLS-1$
        }
        return result;
    }

    public String getDescriptorsBody( ) {

        StringBuilder sb = new StringBuilder( );
        SpiJmiHelper jmiHelper = getJmiHelper( );
        List<StructureField> structureFields = jmiHelper.getStructureFields( this.connection.getSession( ), (StructureType) this.wrappedStruct, true /* includeSupertypes */);
        for ( int i = 0, n = structureFields.size( ); i < n; i++ ) {
            StructureFieldInternal field = (StructureFieldInternal) structureFields.get( i );
            NamespaceInternal container = (NamespaceInternal) ( (ModelElementInternal) field ).getContainer( this.connection );
            String identifier = jmiHelper.getJMIIdentifier( this.connection, (StructureField) field );
            String upperCaseIdentifier = StringUtils.unCamelize( identifier, "_" ).toUpperCase( Locale.ENGLISH ); //$NON-NLS-1$
            boolean isOwnStructureField = container.equals( this.wrappedStruct );
            String descriptorClass = "com.sap.tc.moin.repository.mmi.descriptors.StructureFieldDescriptor<com.sap.tc.moin.repository.mmi.model.StructureField,"; //$NON-NLS-1$
            if ( isOwnStructureField ) {
                descriptorClass += getJMIIdentifierQualified( this.wrappedStruct ) + "," + getFieldTypeString( field ) + ">"; //$NON-NLS-1$ //$NON-NLS-2$
            } else {
                descriptorClass += getJMIIdentifierQualified( container ) + "," + getFieldTypeString( field ) + ">"; //$NON-NLS-1$ //$NON-NLS-2$
            }
            if ( isOwnStructureField ) {
                // Only generate __-variables for my own features, not those of my supertypes.
                sb.append( "private " ).append( descriptorClass ).append( " __" ); //$NON-NLS-1$ //$NON-NLS-2$
                sb.append( identifier ).append( ";\n" ); //$NON-NLS-1$
            }
            sb.append( "/**\n" ); //$NON-NLS-1$
            sb.append( " * Returns the descriptor for the <code>" ).append( identifier ).append( "</code> StructureField.\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append( " * @return  the descriptor for the <code>" ).append( identifier ).append( "</code> StructureField\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append( " */\n" ); //$NON-NLS-1$
            if ( isOwnStructureField ) {
                sb.append( "public synchronized " ); //$NON-NLS-1$
            } else {
                sb.append( "public " ); //$NON-NLS-1$
            }
            sb.append( descriptorClass ).append( " " ).append( upperCaseIdentifier ).append( "( ) {\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            if ( !isOwnStructureField ) {
                String jmiInterfaceName = jmiHelper.getJmiInterfaceName( this.connection, (Namespace) container );
                sb.append( "    return " ).append( jmiInterfaceName ).append( ".DESCRIPTORS." ).append( upperCaseIdentifier ).append( "( );\n" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            } else {
                sb.append( "    if ( __" ).append( identifier ).append( " == null ) {\n" ); //$NON-NLS-1$ //$NON-NLS-2$
                sb.append( "        __" ).append( identifier ).append( " = new " ).append( descriptorClass ).append( "( " ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                sb.append( "\"" ).append( field.refMofId( ) ).append( "\", \"" ).append( getMetamodelName( ) ).append( "\", " ).append( getQualifiedNameAsStringArrayInitializer( field ) ).append( " ); " ).append( getNonNls( field.getQualifiedName( connection ).size( ) + 2 ) ).append( "\n" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                sb.append( "    }\n" ); //$NON-NLS-1$
                sb.append( "    return __" ).append( identifier ).append( ";\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            sb.append( "}" ); //$NON-NLS-1$
            if ( i < n - 1 ) {
                sb.append( "\n" ); //$NON-NLS-1$
            }
        }
        return sb.toString( );
    }

    public boolean isTranslatableText( ) {

        return getJmiHelper( ).isTranslatableText( this.connection.getSession( ), (StructureType) this.wrappedStruct ) || getJmiHelper( ).isTranslatableTextFragment( this.connection.getSession( ), (StructureType) this.wrappedStruct );
    }

    private String getFieldTypeString( StructureFieldInternal field ) {

        Classifier type = field.getType( connection );
        if ( type instanceof PrimitiveType ) {
            return getJavaTypeClass( getType( type ) );
        }
        return getType( type );
    }

}