package com.sap.tc.moin.repository.jmigenerator.wrappers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.mmi.model.__impl.ConstantInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.EnumerationTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureFieldInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeInternal;
import javax.swing.tree.TreeNode;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorConstant;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorParameter;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorClassOperationImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorConstantImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorParameterImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorStructureTypeImplTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorStructureTypeInterfaceTemplateImpl;

/**
 * Common abstract wrapper for classes and packages
 */
public abstract class JmiGeneratorClassOrPackageWrapper extends JmiGeneratorBaseWrapper {

    /**
     * @param underlyingModelElement
     * @param parent
     * @param generator
     */
    public JmiGeneratorClassOrPackageWrapper( CoreConnection connection, String metamodelName, ModelElement underlyingModelElement, TreeNode parent, JmiGeneratorImpl generator ) {

        super( connection, metamodelName, underlyingModelElement, parent, generator );
    }

    /**
     * @param genKind
     * @return the constants in this class or package
     */
    public List<JmiGeneratorConstant> getConstants( JmiGenerationKind genKind ) {

        List<JmiGeneratorConstant> result = new ArrayList<JmiGeneratorConstant>( );

        Iterator<ModelElement> myChildren;
        switch ( genKind ) {
            case INTERFACE:
                myChildren = getContent( );
                break;

            case CLASS:
                myChildren = getAllContent( );
                break;

            default:
                throw new MoinUnsupportedOperationException( "getConstants" ); //$NON-NLS-1$
        }

        for ( ; myChildren.hasNext( ); ) {
            ModelElementInternal me = (ModelElementInternal) myChildren.next( );
            if ( me instanceof ConstantInternal ) {
                ConstantInternal constant = (ConstantInternal) me;
                String jmiGenConstantType = getType( constant.getType( connection ) );
                String jmiGenConstantName = correctName( getJMIIdentifier( constant ), true );
                String jmiGenConstantValue = constant.getValue( );
                if ( "java.lang.String".equals( jmiGenConstantType ) ) { //$NON-NLS-1$
                    jmiGenConstantValue = "\"" + jmiGenConstantValue + "\"";//$NON-NLS-1$ //$NON-NLS-2$
                }
                JmiGeneratorConstantImpl jmiGenConstant = new JmiGeneratorConstantImpl( "public", jmiGenConstantType, jmiGenConstantName, jmiGenConstantValue );//$NON-NLS-1$
                jmiGenConstant.setAnnotation( constant.getAnnotation( ) );
                result.add( jmiGenConstant );
            }
        }

        return result;
    }

    /**
     * @param genKind
     * @return the Enums in this class or package
     */
    public List<JmiGeneratorParameter> getEnums( JmiGenerationKind genKind ) {

        List<JmiGeneratorParameter> result = null;
        switch ( genKind ) {
            case CLASS:
                Iterator<ModelElement> myChildren = this.getAllContent( );
                for ( ; myChildren.hasNext( ); ) {
                    ModelElementInternal me = (ModelElementInternal) myChildren.next( );
                    if ( me instanceof EnumerationTypeInternal ) {
                        if ( result == null ) {
                            result = new ArrayList<JmiGeneratorParameter>( );
                        }
                        final String type = getOrCreateWrapper( me ).getJavaClassName( JmiGenerationKind.CLASS, true );
                        final String name = me.getName( );
                        JmiGeneratorParameter p = new JmiGeneratorParameterImpl( name, type, null );
                        result.add( p );
                    }
                }
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * @param genKind
     * @return the StructureTypes in this class or package
     */
    public List<JmiGeneratorClassOperation> getStructureTypes( JmiGenerationKind genKind ) {

        List<JmiGeneratorClassOperation> result = new ArrayList<JmiGeneratorClassOperation>( );

        Iterator<ModelElement> myChildren = this.getAllContent( );
        for ( ; myChildren.hasNext( ); ) {
            ModelElementInternal me = (ModelElementInternal) myChildren.next( );
            if ( me instanceof StructureTypeInternal ) {
                StructureTypeInternal structureType = (StructureTypeInternal) me;
                if ( structureType.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) || genKind != JmiGenerationKind.INTERFACE ) {
                    // structure fields
                    String creatorName = getCreatorNameForStructure( structureType );
                    // code.append("public " +
                    // getJMIIdentifierQualified(structureType) + " " +
                    // creatorName + "(" + argumentList + ")"); //$NON-NLS-1$
                    switch ( genKind ) {
                        case INTERFACE:
                            JmiGeneratorStructureTypeWrapper typeWrapper = (JmiGeneratorStructureTypeWrapper) getOrCreateWrapper( structureType );
                            String type = typeWrapper.getJavaClassName( JmiGenerationKind.INTERFACE, true );
                            JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( creatorName, type, null, null );
                            for ( Iterator iterator = getAllContent( structureType ); iterator.hasNext( ); ) {
                                Object o = iterator.next( );
                                if ( o instanceof StructureFieldInternal ) {
                                    StructureFieldInternal f = (StructureFieldInternal) o;
                                    final String ftype = getType( f.getType( connection ) );
                                    final String name = getJMIIdentifier( f );
                                    JmiGeneratorParameter p = new JmiGeneratorParameterImpl( name, ftype, null );
                                    p.setNeedsToBeUnwrapped( false );
                                    op.getParameters( ).add( p );
                                }
                            }
                            op.setWrapResult( false );
                            op.setTypeTemplate( new JmiGeneratorStructureTypeInterfaceTemplateImpl( typeWrapper ) );
                            result.add( op );
                            break;
                        case CLASS:
                            typeWrapper = (JmiGeneratorStructureTypeWrapper) getOrCreateWrapper( structureType );
                            // the operation type is the interface
                            type = typeWrapper.getJavaClassName( JmiGenerationKind.INTERFACE, true );
                            op = new JmiGeneratorClassOperationImpl( creatorName, type, null, "StructureType" ); //$NON-NLS-1$
                            op.setFeatureName( structureType.getName( ) );
                            op.setWrapResult( false );

                            for ( Iterator iterator = getAllContent( structureType ); iterator.hasNext( ); ) {
                                Object o = iterator.next( );
                                if ( o instanceof StructureFieldInternal ) {
                                    StructureFieldInternal f = (StructureFieldInternal) o;
                                    final String ftype = getType( f.getType( connection ) );
                                    final String name = getJMIIdentifier( f );
                                    JmiGeneratorParameter p = new JmiGeneratorParameterImpl( name, ftype, null );
                                    p.setNeedsToBeUnwrapped( false );
                                    op.getParameters( ).add( p );
                                }
                            }
                            op.setTypeTemplate( new JmiGeneratorStructureTypeImplTemplateImpl( typeWrapper ) );
                            op.setStructureTypeMofId( structureType.refMofId( ) );
                            result.add( op );
                            JmiGeneratorClassOperationImpl op2 = new JmiGeneratorClassOperationImpl( creatorName, type, null, "StructureType" ); //$NON-NLS-1$
                            op2.setFeatureName( op.getFeatureName( ) );
                            addCoreConnectionParameter( op2.getParameters( ) );
                            op2.getParameters( ).addAll( op.getParameters( ) );
                            op2.setHasCoreConnection( true );
                            op2.setTypeTemplate( new JmiGeneratorStructureTypeImplTemplateImpl( typeWrapper ) );
                            op2.setStructureTypeMofId( op.getStructureTypeMofId( ) );
                            op2.setWrapResult( op.isWrapResult( ) );
                            result.add( op2 );
                            break;
                        default:
                            throw new RuntimeException( );
                    }
                }
            }
        }
        return result;
    }

    protected String getCreatorNameForStructure( StructureTypeInternal aStructure ) {

        return "create" + getJMIIdentifier( aStructure ); //$NON-NLS-1$
    }

}
