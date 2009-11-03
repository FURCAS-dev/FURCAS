package com.sap.tc.moin.repository.jmigenerator.wrappers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorMofType;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorRuntimeException;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorTraces;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorDescriptorConstant;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorParameter;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorAssociationImplTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorAssociationInterfaceInternalTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorAssociationInterfaceTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorAssociationWrapperTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorClassOperationImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorParameterImpl;
import com.sap.tc.moin.repository.shared.util.StringUtils;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * Wrapper for Associations
 */
public class JmiGeneratorAssociationWrapper extends JmiGeneratorBaseWrapper {

    private final AssociationInternal myAssociation;

    private final AssociationEndInternal end0;

    private final AssociationEndInternal end1;

    /**
     * @param actConnection
     * @param actMetamodelName
     * @param theAssociation
     * @param generator
     */
    public JmiGeneratorAssociationWrapper( CoreConnection actConnection, String actMetamodelName, Association theAssociation, JmiGeneratorImpl generator ) {

        super( actConnection, actMetamodelName, theAssociation, null, generator );
        this.myAssociation = (AssociationInternal) theAssociation;

        AssociationEndInternal e0 = null;
        AssociationEndInternal e1 = null;
        Iterator<ModelElement> iterator = ( (JmiList<ModelElement>) ( (AssociationInternal) this.myAssociation ).getContents( actConnection ) ).iteratorReadOnly( actConnection.getSession( ) );

        for ( ; iterator.hasNext( ); ) {
            Object o = iterator.next( );
            if ( o instanceof AssociationEndInternal ) {
                if ( e0 == null ) {
                    e0 = (AssociationEndInternal) o;
                } else if ( e1 == null ) {
                    e1 = (AssociationEndInternal) o;
                } else {
                    throw new MoinIllegalStateException( JmiGeneratorTraces.MORETHANONEASSOCENDINASSOC );
                }
            }
        }
        if ( e0 == null || e1 == null ) {
            throw new JmiGeneratorRuntimeException( JmiGeneratorTraces.NULLENDINASSOCATIONFOUND, this.myAssociation.getName( ) );
        }
        this.end0 = e0;
        this.end1 = e1;
    }

    /**
     * @return end0
     */
    public AssociationEnd getEnd0( ) {

        return (AssociationEnd) this.end0;
    }

    /**
     * @return end1
     */
    public AssociationEnd getEnd1( ) {

        return (AssociationEnd) this.end1;
    }

    /**
     * @return the fully qualified type of end0
     */
    public String getEnd0Type( ) {

        return getType( this.end0.getType( connection ) );
    }

    /**
     * @return the fully qualified type of end1
     */
    public String getEnd1Type( ) {

        return getType( this.end1.getType( connection ) );
    }

    @Override
    public List<String> getExtends( JmiGenerationKind genKind, boolean qualified ) {

        List<String> result = new ArrayList<String>( );
        switch ( genKind ) {
            case INTERFACE:
                result.add( CLASS_REFASSOCAPI );
                break;
            case CLASS:
                result.add( CLASS_REFASSOCIMPL );
                break;

            default:
                break;
        }
        return result;
    }

    @Override
    public List<String> getImplements( JmiGenerationKind genKind, boolean qualified ) {

        List<String> result = new ArrayList<String>( );
        switch ( genKind ) {
            case INTERFACE:
                break;
            case CLASS:
                if ( isMofModelElement( ) ) {
                    result.add( getJavaClassName( JmiGenerationKind.INTERFACE, true ) );
                    String nameOfInternalInterface = getJavaClassName( JmiGenerationKind.CLASS, qualified );
                    nameOfInternalInterface = nameOfInternalInterface.substring( 0, nameOfInternalInterface.lastIndexOf( "Impl" ) ) + "Internal"; //$NON-NLS-1$  //$NON-NLS-2$
                    result.add( nameOfInternalInterface );
                }
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
            sb.append( this.getJavaPackageNameQualified( genKind ) );
            sb.append( Utilities.JAVA_PACKAGE_DELIMITER );
        }

        switch ( genKind ) {
            case INTERFACE:
                sb.append( getJMIIdentifier( ) );
                return sb.toString( );

            case CLASS:
                sb.append( getJMIIdentifier( ) );
                sb.append( EXTENSION_IMPLEMENTATION );
                return sb.toString( );

            case WRAPPER:
                sb.append( getJMIIdentifier( ) );
                sb.append( EXTENSION_WRAPPER );
                return sb.toString( );

            default:
                throw new IllegalArgumentException( );
        }

    }

    @Override
    public JmiGeneratorBaseTemplate getJavaTemplate( JmiGenerationKind genKind, String templateName ) {

        switch ( genKind ) {
            case INTERFACE:
                return new JmiGeneratorAssociationInterfaceTemplateImpl( this );

            case CLASS:
                if ( templateName.equals( "AssociationImpl" ) ) { //$NON-NLS-1$
                    return new JmiGeneratorAssociationImplTemplateImpl( this );
                } else if ( templateName.equals( "AssociationInterfaceInternal" ) ) { //$NON-NLS-1$
                    return new JmiGeneratorAssociationInterfaceInternalTemplateImpl( this );
                }
                throw new MoinUnsupportedOperationException( "getJavaTemplate" ); //$NON-NLS-1$
            case WRAPPER:
                return new JmiGeneratorAssociationWrapperTemplateImpl( this );

            default:
                throw new MoinUnsupportedOperationException( "getJavaTemplate" ); //$NON-NLS-1$
        }
    }

    @Override
    public JmiGeneratorMofType getMofType( ) {

        return JmiGeneratorMofType.ASSOCIATION;
    }

    @Override
    public List<String> getTemplateNames( JmiGenerationKind genKind ) {

        List<String> result = new ArrayList<String>( );
        switch ( genKind ) {
            case INTERFACE:
                result.add( "AssociationInterface" ); //$NON-NLS-1$
                break;
            case CLASS:
                result.add( "AssociationImpl" ); //$NON-NLS-1$
                if ( isMofModelElement( ) ) {
                    result.add( "AssociationInterfaceInternal" ); //$NON-NLS-1$
                }
                break;
            case WRAPPER:
                result.add( "AssociationWrapper" ); //$NON-NLS-1$
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
     * @return the operations
     */
    public List<JmiGeneratorClassOperation> getOperations( JmiGenerationKind genKind ) {

        List<JmiGeneratorClassOperation> result = new ArrayList<JmiGeneratorClassOperation>( );

        String end0Type = getType( this.end0.getType( connection ) );
        if ( !isMofModelElement( ) && genKind == JmiGenerationKind.CLASS ) {
            end0Type = "com.sap.tc.moin.repository.mmi.reflect.RefBaseObject"; //$NON-NLS-1$
        }
        final String end0pName = "_" + getJMIIdentifier( this.end0 ); //$NON-NLS-1$
        String end1Type = getType( this.end1.getType( connection ) );
        if ( !isMofModelElement( ) && genKind == JmiGenerationKind.CLASS ) {
            end1Type = "com.sap.tc.moin.repository.mmi.reflect.RefBaseObject"; //$NON-NLS-1$
        }
        final String end1pName = "_" + getJMIIdentifier( this.end1 ); //$NON-NLS-1$

        String end0ReturnType;
        String end0ReturnTypeParameter;
        String end1ReturnType;
        String end1ReturnTypeParameter;

        if ( this.end0.getMultiplicity( ).getUpper( ) == 1 ) {
            end0ReturnType = end0Type;
            end0ReturnTypeParameter = null;
        } else {
            if ( this.end0.getMultiplicity( ).isOrdered( ) ) {
                // ordered
                end0ReturnType = "java.util.List"; //$NON-NLS-1$
            } else {
                // not ordered
                end0ReturnType = "java.util.Collection"; //$NON-NLS-1$
            }
            end0ReturnTypeParameter = end0Type;
        }


        if ( this.end1.getMultiplicity( ).getUpper( ) == 1 ) {
            end1ReturnType = end1Type;
            end1ReturnTypeParameter = null;
        } else {
            if ( this.end1.getMultiplicity( ).isOrdered( ) ) {
                // ordered
                end1ReturnType = "java.util.List"; //$NON-NLS-1$
            } else {
                // not ordered
                end1ReturnType = "java.util.Collection"; //$NON-NLS-1$
            }
            end1ReturnTypeParameter = end1Type;
        }

        String accessorNameForEnd0 = getAccessorNameForModelElement( this.end0 );
        String accessorNameForEnd1 = getAccessorNameForModelElement( this.end1 );

        JmiGeneratorParameter e0param = new JmiGeneratorParameterImpl( end0pName, end0Type, null );
        JmiGeneratorParameter e1param = new JmiGeneratorParameterImpl( end1pName, end1Type, null );

        switch ( genKind ) {
            case INTERFACE: {
                // exists
                JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( "exists", "boolean", null, null ); //$NON-NLS-1$  //$NON-NLS-2$
                op.getParameters( ).add( e0param );
                op.getParameters( ).add( e1param );
                op.setWrapResult( false );
                result.add( op );
                // getter for end0, regardless of its navigability
                op = new JmiGeneratorClassOperationImpl( accessorNameForEnd0, end0ReturnType, end0ReturnTypeParameter, null );
                op.getParameters( ).add( e1param );
                result.add( op );
                // getter for end1, regardless of its navigability
                op = new JmiGeneratorClassOperationImpl( accessorNameForEnd1, end1ReturnType, end1ReturnTypeParameter, null );
                op.getParameters( ).add( e0param );
                result.add( op );
                if ( this.end0.isChangeable( ) && this.end1.isChangeable( ) ) {
                    op = new JmiGeneratorClassOperationImpl( "add", "boolean", null, null ); //$NON-NLS-1$  //$NON-NLS-2$
                    op.getParameters( ).add( e0param );
                    op.getParameters( ).add( e1param );
                    op.setSetter( true );
                    op.setWrapResult( false );
                    result.add( op );

                    op = new JmiGeneratorClassOperationImpl( "remove", "boolean", null, null ); //$NON-NLS-1$  //$NON-NLS-2$
                    op.getParameters( ).add( e0param );
                    op.getParameters( ).add( e1param );
                    op.setSetter( true );
                    op.setWrapResult( false );
                    result.add( op );
                }

                break;
            }
            case WRAPPER: {
                // exists
                JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( "exists", "boolean", null, null ); //$NON-NLS-1$  //$NON-NLS-2$
                op.getParameters( ).add( e0param );
                op.getParameters( ).add( e1param );
                op.setWrapResult( false );
                result.add( op );
                // getter for end0, regardless of its navigability
                op = new JmiGeneratorClassOperationImpl( accessorNameForEnd0, end0ReturnType, isMofModelElement( ) ? end0ReturnTypeParameter : null, null );
                op.getParameters( ).add( e1param );
                result.add( op );
                // getter for end1, regardless of its navigability
                op = new JmiGeneratorClassOperationImpl( accessorNameForEnd1, end1ReturnType, isMofModelElement( ) ? end1ReturnTypeParameter : null, null );
                op.getParameters( ).add( e0param );
                result.add( op );
                if ( this.end0.isChangeable( ) && this.end1.isChangeable( ) ) {
                    op = new JmiGeneratorClassOperationImpl( "add", "boolean", null, null ); //$NON-NLS-1$  //$NON-NLS-2$
                    op.getParameters( ).add( e0param );
                    op.getParameters( ).add( e1param );
                    op.setSetter( true );
                    op.setWrapResult( false );
                    result.add( op );

                    op = new JmiGeneratorClassOperationImpl( "remove", "boolean", null, null ); //$NON-NLS-1$  //$NON-NLS-2$
                    op.getParameters( ).add( e0param );
                    op.getParameters( ).add( e1param );
                    op.setSetter( true );
                    op.setWrapResult( false );
                    result.add( op );
                }
                break;
            }
            case CLASS: {
                // TODO add non-nls to the exists code
                // exists
                JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( "exists", "boolean", null, null ); //$NON-NLS-1$  //$NON-NLS-2$
                op.getParameters( ).add( e0param );
                op.getParameters( ).add( e1param );
                if ( this.myAssociation.isDerived( ) ) {
                    op.setDerived( true );
                    List<String> body = op.getBody( );

                    Tag bodyTag = getTag( this.myAssociation, TAG_OPERATION_CODE_EXISTS_JAVA );
                    if ( bodyTag != null ) {
                        if ( isMofElement( this.myAssociation ) ) {
                            body.add( 0, GET_CURRENT_CONNECTION_STATEMENT );
                        }
                        body.add( "// begin of implementation provided in tag " + TAG_OPERATION_CODE_EXISTS_JAVA ); //$NON-NLS-1$
                        body.add( bodyTag.getValues( ).get( 0 ) );
                        body.add( "// end of implementation provided in tag " + TAG_OPERATION_CODE_EXISTS_JAVA ); //$NON-NLS-1$
                    } else {
                        body.add( "boolean result = false;" ); //$NON-NLS-1$
                        body.add( "// missing an implementation provided in tag " + TAG_OPERATION_CODE_EXISTS_JAVA ); //$NON-NLS-1$
                        body.add( "// calculate the existence based on the accessor for end 0: " + this.end0.getName( ) ); //$NON-NLS-1$
                        if ( this.end0.getMultiplicity( ).getUpper( ) == 1 ) {
                            body.add( "if(" + accessorNameForEnd0 + "(" + end1pName + ").equals(" + end0pName + ")) {" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                            body.add( "    result = true;" ); //$NON-NLS-1$
                            body.add( "}" ); //$NON-NLS-1$
                        } else {
                            body.add( "for(java.util.Iterator iter = " + accessorNameForEnd0 + "(" + end1pName + ").iterator(); iter.hasNext();) {" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                            body.add( "    if(iter.next().equals(" + end0pName + ")) {" ); //$NON-NLS-1$ //$NON-NLS-2$
                            body.add( "        result = true;" ); //$NON-NLS-1$
                            body.add( "        break;" ); //$NON-NLS-1$
                            body.add( "    }" ); //$NON-NLS-1$
                            body.add( "}" ); //$NON-NLS-1$
                        }
                        body.add( "return result;" ); //$NON-NLS-1$
                    }

                } else {
                    op.getBody( ).add( "return exists(get___CurrentConnection(), " + end0pName + ", " + end1pName + ");" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                }

                result.add( op );
                JmiGeneratorClassOperationImpl op2 = new JmiGeneratorClassOperationImpl( "exists", "boolean", null, null ); //$NON-NLS-1$ //$NON-NLS-2$
                op2.setDerived( op.isDerived( ) );
                if ( this.myAssociation.isDerived( ) ) {
                    List<String> body = op2.getBody( );
                    Tag bodyTag = getTag( this.myAssociation, TAG_OPERATION_CODE_EXISTS_JAVA );
                    if ( bodyTag != null ) {
                        body.add( "// begin of implementation provided in tag " + TAG_OPERATION_CODE_EXISTS_JAVA ); //$NON-NLS-1$
                        body.add( bodyTag.getValues( ).get( 0 ) );
                        body.add( "// end of implementation provided in tag " + TAG_OPERATION_CODE_EXISTS_JAVA ); //$NON-NLS-1$
                    } else {
                        body.add( "boolean result = false;" ); //$NON-NLS-1$
                        body.add( "// missing an implementation provided in tag " + TAG_OPERATION_CODE_EXISTS_JAVA ); //$NON-NLS-1$
                        body.add( "// calculate the existence based on the accessor for end 0: " + this.end0.getName( ) ); //$NON-NLS-1$
                        if ( this.end0.getMultiplicity( ).getUpper( ) == 1 ) {
                            body.add( "if(" + accessorNameForEnd0 + "(connection, " + end1pName + ").equals(" + end0pName + ")) {" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                            body.add( "    result = true;" ); //$NON-NLS-1$
                            body.add( "}" ); //$NON-NLS-1$
                        } else {
                            body.add( "for (java.util.Iterator it = ((com.sap.tc.moin.repository.core.JmiList) " + accessorNameForEnd0 + "(connection, " + end1pName + ")).iterator(connection); it.hasNext();) {" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                            body.add( "    if (it.next().equals(" + end0pName + ")) {" ); //$NON-NLS-1$ //$NON-NLS-2$
                            body.add( "        result = true;" ); //$NON-NLS-1$
                            body.add( "        break;" ); //$NON-NLS-1$
                            body.add( "    }" ); //$NON-NLS-1$
                            body.add( "}" ); //$NON-NLS-1$
                        }
                        body.add( "return result;" ); //$NON-NLS-1$
                    }
                } else {
                    SpiJmiHelper jmiHelper = getJmiHelper( );
                    List<AssociationEnd> ends = jmiHelper.getAssociationEnds( this.connection.getSession( ), (Association) this.myAssociation );
                    // Try to find a stored end where the otherEnd() is multiplicity-1 (performance!).
                    int storedEndIndex = -1;
                    for ( int i = 0; i < 2; i++ ) {
                        AssociationEnd end = ends.get( i );
                        AssociationEnd otherEnd = ends.get( 1 - i );
                        if ( jmiHelper.isEndStored( this.connection.getSession( ), end ) && otherEnd.getMultiplicity( ).getUpper( ) == 1 ) {
                            storedEndIndex = i;
                            break;
                        }
                    }
                    if ( storedEndIndex == -1 ) {
                        // Not found, simply take the first stored end.
                        for ( int i = 0; i < 2; i++ ) {
                            AssociationEnd end = ends.get( i );
                            if ( jmiHelper.isEndStored( this.connection.getSession( ), end ) ) {
                                storedEndIndex = i;
                                break;
                            }
                        }
                    }
                    assert storedEndIndex != -1 : "Encountered association without stored association end"; //$NON-NLS-1$
                    String pName = ( storedEndIndex == 0 ? end0pName : end1pName );
                    String otherName = ( storedEndIndex == 0 ? end1pName : end0pName );
                    AssociationEnd otherEnd = ends.get( 1 - storedEndIndex );
                    if ( otherEnd.getMultiplicity( ).getUpper( ) == 1 ) {
                        op2.getBody( ).add( "return ___existsMult1( connection, " + pName + ", " + otherName + ", \"" + otherEnd.refMofId( ) + "\"); //$NON-NLS-1$" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                    } else {
                        op2.getBody( ).add( "return ___existsMultN( connection, " + pName + ", " + otherName + ", \"" + otherEnd.refMofId( ) + "\"); //$NON-NLS-1$" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                    }
                }
                addCoreConnectionParameter( op2.getParameters( ) );
                op2.getParameters( ).addAll( op.getParameters( ) );
                op2.setHasCoreConnection( true );
                result.add( op2 );
                boolean derivedAndMofAndCodeFromTag = false;
                // getter for end0, regardless of its navigability
                op = new JmiGeneratorClassOperationImpl( accessorNameForEnd0, end0ReturnType, end0ReturnTypeParameter, null );
                op.getParameters( ).add( e1param );
                List<String> body = op.getBody( );
                if ( this.myAssociation.isDerived( ) ) {
                    Tag bodyTag = getTag( this.end0, TAG_DERIVATION_CODE );
                    if ( bodyTag != null ) {
                        if ( isMofElement( this.myAssociation ) ) {
                            body.add( 0, GET_CURRENT_CONNECTION_STATEMENT );
                            derivedAndMofAndCodeFromTag = true;
                        }
                        body.add( "// begin of implementation provided in tag " + TAG_DERIVATION_CODE ); //$NON-NLS-1$
                        body.add( bodyTag.getValues( ).get( 0 ) );
                        body.add( "// end of implementation provided in tag " + TAG_DERIVATION_CODE ); //$NON-NLS-1$
                    } else {
                        body.add( "// missing an implementation provided in tag " + TAG_DERIVATION_CODE ); //$NON-NLS-1$
                        body.add( "return null;" ); //$NON-NLS-1$
                    }
                } else {//not derived
                    body.add( "return " + accessorNameForEnd0 + "(get___CurrentConnection(), " + end1pName + ");" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                }
                result.add( op );
                op2 = new JmiGeneratorClassOperationImpl( accessorNameForEnd0, end0ReturnType, end0ReturnTypeParameter, null );
                if ( op.getBody( ).size( ) == 1 ) {
                    if ( this.end0.getMultiplicity( ).getUpper( ) == 1 ) {
                        if ( getJmiHelper( ).isEndStored( this.connection.getSession( ), (AssociationEnd) this.end1 ) ) {
                            op2.getBody( ).add( "return (" + end0Type + ") ___getElementAtOtherLinkEnd( connection, (com.sap.tc.moin.repository.core.CorePartitionable) " + end1pName + ", \"" + this.end0.refMofId( ) + "\"); //$NON-NLS-1$" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                        } else {
                            op2.getBody( ).add( "com.sap.tc.moin.repository.core.EndAndMetaObject endAndMetaObject = get___EndAndMetaObject( 1 );" ); //$NON-NLS-1$
                            if ( getJmiHelper( ).getAssociationEnds( this.connection.getSession( ), (Association) this.myAssociation ).get( 0 ).getAggregation( ) == AggregationKindEnum.COMPOSITE ) {
                                op2.getBody( ).add( "return (" + end0Type + ") get___CompositeParentForEndAndMetaObject( connection, " + end1pName + ", endAndMetaObject );" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                            } else {
                                op2.getBody( ).add( "return (" + end0Type + ") ___queryElementAtOtherLinkEnd( connection, (com.sap.tc.moin.repository.core.CorePartitionable) " + end1pName + ", endAndMetaObject );" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                            }
                        }
                    } else {
                        if ( getJmiHelper( ).isEndStored( this.connection.getSession( ), (AssociationEnd) this.end1 ) ) {
                            op2.getBody( ).add( "return (" + end0ReturnType + "<" + end0ReturnTypeParameter + ">) ___getElementsAtOtherLinkEnd( connection, (com.sap.tc.moin.repository.core.CorePartitionable) " + end1pName + ", get___EndAndMetaObject( 1 ) );" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                        } else {
                            op2.getBody( ).add( "return (" + end0ReturnType + "<" + end0ReturnTypeParameter + ">) ___queryElementsAtOtherLinkEnd( connection, (com.sap.tc.moin.repository.core.CorePartitionable) " + end1pName + ", get___EndAndMetaObject( 1 ) );" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                        }
                    }
                } else {
                    op2.getBody( ).addAll( op.getBody( ) );
                    if ( derivedAndMofAndCodeFromTag ) {
                        op2.getBody( ).remove( 0 );
                        derivedAndMofAndCodeFromTag = false;
                    }
                }
                addCoreConnectionParameter( op2.getParameters( ) );
                op2.getParameters( ).addAll( op.getParameters( ) );
                op2.setHasCoreConnection( true );
                result.add( op2 );
                // getter for end1, regardless of its navigability
                op = new JmiGeneratorClassOperationImpl( accessorNameForEnd1, end1ReturnType, end1ReturnTypeParameter, null );
                op.getParameters( ).add( e0param );
                body = op.getBody( );
                if ( this.myAssociation.isDerived( ) ) {
                    Tag bodyTag = getTag( this.end1, TAG_DERIVATION_CODE );
                    if ( bodyTag != null ) {
                        if ( isMofElement( this.myAssociation ) ) {
                            derivedAndMofAndCodeFromTag = true;
                            body.add( 0, GET_CURRENT_CONNECTION_STATEMENT );
                        }
                        body.add( "// begin of implementation provided in tag " + TAG_DERIVATION_CODE ); //$NON-NLS-1$
                        body.add( bodyTag.getValues( ).get( 0 ) );
                        body.add( "// end of implementation provided in tag " + TAG_DERIVATION_CODE ); //$NON-NLS-1$
                    } else {
                        body.add( "// missing an implementation provided in tag " + TAG_DERIVATION_CODE ); //$NON-NLS-1$
                        body.add( "return null;" ); //$NON-NLS-1$
                    }
                } else {//not derived
                    body.add( "return " + accessorNameForEnd1 + "(get___CurrentConnection(), " + end0pName + ");" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                }
                result.add( op );

                op2 = new JmiGeneratorClassOperationImpl( accessorNameForEnd1, end1ReturnType, end1ReturnTypeParameter, null );
                if ( op.getBody( ).size( ) == 1 ) {
                    if ( this.end1.getMultiplicity( ).getUpper( ) == 1 ) {
                        if ( getJmiHelper( ).isEndStored( this.connection.getSession( ), (AssociationEnd) this.end0 ) ) {
                            op2.getBody( ).add( "return (" + end1Type + ") ___getElementAtOtherLinkEnd( connection, (com.sap.tc.moin.repository.core.CorePartitionable) " + end0pName + ", \"" + this.end1.refMofId( ) + "\"); //$NON-NLS-1$" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                        } else {
                            op2.getBody( ).add( "com.sap.tc.moin.repository.core.EndAndMetaObject endAndMetaObject = get___EndAndMetaObject( 0 );" ); //$NON-NLS-1$
                            if ( getJmiHelper( ).getAssociationEnds( this.connection.getSession( ), (Association) this.myAssociation ).get( 1 ).getAggregation( ) == AggregationKindEnum.COMPOSITE ) {
                                op2.getBody( ).add( "return (" + end1Type + ") get___CompositeParentForEndAndMetaObject( connection, " + end0pName + ", endAndMetaObject );" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                            } else {
                                op2.getBody( ).add( "return (" + end1Type + ") ___queryElementAtOtherLinkEnd( connection, (com.sap.tc.moin.repository.core.CorePartitionable) " + end0pName + ", endAndMetaObject );" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                            }
                        }
                    } else {
                        if ( getJmiHelper( ).isEndStored( this.connection.getSession( ), (AssociationEnd) this.end0 ) ) {
                            op2.getBody( ).add( "return (" + end1ReturnType + "<" + end1ReturnTypeParameter + ">) ___getElementsAtOtherLinkEnd( connection, (com.sap.tc.moin.repository.core.CorePartitionable) " + end0pName + ", get___EndAndMetaObject( 0 ) );" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$  //$NON-NLS-4$
                        } else {
                            op2.getBody( ).add( "return (" + end1ReturnType + "<" + end1ReturnTypeParameter + ">) ___queryElementsAtOtherLinkEnd( connection, (com.sap.tc.moin.repository.core.CorePartitionable) " + end0pName + ", get___EndAndMetaObject( 0 ) );" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                        }
                    }
                } else {
                    op2.getBody( ).addAll( op.getBody( ) );
                    if ( derivedAndMofAndCodeFromTag ) {
                        op2.getBody( ).remove( 0 );
                        derivedAndMofAndCodeFromTag = false;
                    }
                }
                addCoreConnectionParameter( op2.getParameters( ) );
                op2.getParameters( ).addAll( op.getParameters( ) );
                op2.setHasCoreConnection( true );
                result.add( op2 );

                if ( this.end0.isChangeable( ) && this.end1.isChangeable( ) ) {

                    op = new JmiGeneratorClassOperationImpl( "add", "boolean", null, null ); //$NON-NLS-1$ //$NON-NLS-2$
                    op.setSetter( true );
                    op.getParameters( ).add( e0param );
                    op.getParameters( ).add( e1param );
                    body = op.getBody( );
                    if ( this.myAssociation.isDerived( ) ) {
                        body.add( "  return add___AssociationEnds((com.sap.tc.moin.repository.mmi.reflect.RefObject)" + end0pName + ", (com.sap.tc.moin.repository.mmi.reflect.RefObject)" + end1pName + ", null);" ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
                    } else {
                        body.add( "  return refAddLink((com.sap.tc.moin.repository.mmi.reflect.RefObject)" + end0pName + ", (com.sap.tc.moin.repository.mmi.reflect.RefObject)" + end1pName + ");" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    }
                    result.add( op );
                    op2 = new JmiGeneratorClassOperationImpl( "add", "boolean", null, null ); //$NON-NLS-1$ //$NON-NLS-2$
                    op2.setSetter( op.isSetter( ) );
                    if ( this.myAssociation.isDerived( ) ) {
                        op2.getBody( ).add( "  return add___AssociationEnds(connection, (com.sap.tc.moin.repository.mmi.reflect.RefObject)" + end0pName + ", (com.sap.tc.moin.repository.mmi.reflect.RefObject)" + end1pName + ", null);" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    } else {
                        op2.getBody( ).add( "  return refAddLink(connection, (com.sap.tc.moin.repository.mmi.reflect.RefObject)" + end0pName + ", (com.sap.tc.moin.repository.mmi.reflect.RefObject)" + end1pName + ");" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    }
                    addCoreConnectionParameter( op2.getParameters( ) );
                    op2.getParameters( ).addAll( op.getParameters( ) );
                    op2.setHasCoreConnection( true );
                    result.add( op2 );

                    op = new JmiGeneratorClassOperationImpl( "remove", "boolean", null, null ); //$NON-NLS-1$  //$NON-NLS-2$
                    op.setSetter( true );
                    op.getParameters( ).add( e0param );
                    op.getParameters( ).add( e1param );
                    body = op.getBody( );

                    if ( this.myAssociation.isDerived( ) ) {
                        Tag bodyTag = getTag( this.myAssociation, TAG_OPERATION_CODE_REMOVE_JAVA );
                        if ( bodyTag != null ) {
                            if ( isMofElement( this.myAssociation ) ) {
                                derivedAndMofAndCodeFromTag = true;
                                body.add( 0, GET_CURRENT_CONNECTION_STATEMENT );
                            }
                            body.add( "// begin of implementation provided in tag " + TAG_OPERATION_CODE_REMOVE_JAVA ); //$NON-NLS-1$
                            body.add( bodyTag.getValues( ).get( 0 ) );
                            body.add( "// end of implementation provided in tag " + TAG_OPERATION_CODE_REMOVE_JAVA ); //$NON-NLS-1$
                        } else {
                            body.add( "// missing an implementation provided in tag " + TAG_OPERATION_CODE_REMOVE_JAVA ); //$NON-NLS-1$
                            body.add( "return false;" ); //$NON-NLS-1$
                        }
                    } else {
                        body.add( "return refRemoveLink((com.sap.tc.moin.repository.mmi.reflect.RefObject)" + end0pName + ", (com.sap.tc.moin.repository.mmi.reflect.RefObject)" + end1pName + ");" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    }
                    result.add( op );

                    op2 = new JmiGeneratorClassOperationImpl( "remove", "boolean", null, null ); //$NON-NLS-1$ //$NON-NLS-2$
                    op2.setSetter( op.isSetter( ) );
                    if ( op.getBody( ).size( ) == 1 ) {
                        op2.getBody( ).add( "return refRemoveLink(connection, (com.sap.tc.moin.repository.mmi.reflect.RefObject)" + end0pName + ", (com.sap.tc.moin.repository.mmi.reflect.RefObject)" + end1pName + ");" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    } else {
                        op2.getBody( ).addAll( op.getBody( ) );
                        if ( derivedAndMofAndCodeFromTag ) {
                            op2.getBody( ).remove( 0 );
                            derivedAndMofAndCodeFromTag = false;
                        }
                    }
                    addCoreConnectionParameter( op2.getParameters( ) );
                    op2.getParameters( ).addAll( op.getParameters( ) );
                    op2.setHasCoreConnection( true );
                    result.add( op2 );
                }

                // refLinkExists

                addRefLinkExistsMethod( result, end0Type, end1Type );

                // internal methods

                if ( this.myAssociation.isDerived( ) ) {
                    // ___exists
                    op = new JmiGeneratorClassOperationImpl( "___exists", "boolean", null, null ); //$NON-NLS-1$ //$NON-NLS-2$
                    op.setVisibility( "protected" ); //$NON-NLS-1$
                    op.getParameters( ).add( new JmiGeneratorParameterImpl( "firstEnd", "com.sap.tc.moin.repository.mmi.reflect.RefObject", null ) ); //$NON-NLS-1$ //$NON-NLS-2$
                    op.getParameters( ).add( new JmiGeneratorParameterImpl( "secondEnd", "com.sap.tc.moin.repository.mmi.reflect.RefObject", null ) ); //$NON-NLS-1$ //$NON-NLS-2$
                    body = op.getBody( );
                    body.add( "// RefAssociation methods are delegated to specific ones for derived associations" ); //$NON-NLS-1$
                    body.add( "return exists((" + end0Type + ")firstEnd, (" + end1Type + ")secondEnd);" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
                    result.add( op );

                    op2 = new JmiGeneratorClassOperationImpl( "___exists", "boolean", null, null ); //$NON-NLS-1$ //$NON-NLS-2$
                    op2.setVisibility( op.getVisibility( ) );
                    List<String> body2 = op2.getBody( );
                    body2.add( "// RefAssociation methods are delegated to specific ones for derived associations" ); //$NON-NLS-1$
                    body2.add( "return exists(connection, (" + end0Type + ")firstEnd, (" + end1Type + ")secondEnd);" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    addCoreConnectionParameter( op2.getParameters( ) );
                    op2.getParameters( ).addAll( op.getParameters( ) );
                    op2.setHasCoreConnection( true );
                    result.add( op2 );

                    // add___AssociationEnds
                    if ( this.end0.isChangeable( ) && this.end1.isChangeable( ) ) {
                        // add___AssociationEnds
                        op = new JmiGeneratorClassOperationImpl( "add___AssociationEnds", "boolean", null, null ); //$NON-NLS-1$ //$NON-NLS-2$
                        op.setSetter( true );
                        op.getParameters( ).add( new JmiGeneratorParameterImpl( "firstEnd", "com.sap.tc.moin.repository.mmi.reflect.RefObject", null ) ); //$NON-NLS-1$ //$NON-NLS-2$
                        op.getParameters( ).add( new JmiGeneratorParameterImpl( "secondEnd", "com.sap.tc.moin.repository.mmi.reflect.RefObject", null ) ); //$NON-NLS-1$ //$NON-NLS-2$
                        op.getParameters( ).add( new JmiGeneratorParameterImpl( "addedViaReference", "com.sap.tc.moin.repository.mmi.model.Reference", null ) ); //$NON-NLS-1$ //$NON-NLS-2$
                        op.getBody( ).add( "return ___add((" + end0Type + ")firstEnd, (" + end1Type + ")secondEnd, addedViaReference);" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        result.add( op );

                        op2 = new JmiGeneratorClassOperationImpl( "add___AssociationEnds", "boolean", null, null ); //$NON-NLS-1$ //$NON-NLS-2$
                        op2.setSetter( op.isSetter( ) );
                        op2.getBody( ).add( "return ___add(connection, (" + end0Type + ")firstEnd, (" + end1Type + ")secondEnd, addedViaReference);" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        addCoreConnectionParameter( op2.getParameters( ) );
                        op2.getParameters( ).addAll( op.getParameters( ) );
                        op2.setHasCoreConnection( true );
                        result.add( op2 );

                        // ___add
                        op = new JmiGeneratorClassOperationImpl( "___add", "boolean", null, null ); //$NON-NLS-1$ //$NON-NLS-2$
                        op.setSetter( true );
                        op.setVisibility( "private" ); //$NON-NLS-1$
                        op.getParameters( ).add( new JmiGeneratorParameterImpl( end0pName, end0Type, null ) );
                        op.getParameters( ).add( new JmiGeneratorParameterImpl( end1pName, end1Type, null ) );
                        op.getParameters( ).add( new JmiGeneratorParameterImpl( "_AddedViaReference", "com.sap.tc.moin.repository.mmi.model.Reference", null ) ); //$NON-NLS-1$ //$NON-NLS-2$
                        body = op.getBody( );
                        Tag bodyTag = getTag( this.myAssociation, TAG_OPERATION_CODE_ADD_JAVA );
                        if ( bodyTag != null ) {
                            if ( isMofElement( this.myAssociation ) ) {
                                derivedAndMofAndCodeFromTag = true;
                                body.add( 0, GET_CURRENT_CONNECTION_STATEMENT );
                            }
                            body.add( "// begin of implementation provided in tag " + TAG_OPERATION_CODE_ADD_JAVA ); //$NON-NLS-1$
                            body.add( bodyTag.getValues( ).get( 0 ) );
                            body.add( "// end of implementation provided in tag " + TAG_OPERATION_CODE_ADD_JAVA ); //$NON-NLS-1$
                        } else {
                            body.add( "// missing an implementation provided in tag " + TAG_OPERATION_CODE_ADD_JAVA ); //$NON-NLS-1$
                            body.add( "return false;" ); //$NON-NLS-1$
                        }
                        result.add( op );

                        op2 = new JmiGeneratorClassOperationImpl( "___add", "boolean", null, null ); //$NON-NLS-1$ //$NON-NLS-2$
                        op2.setSetter( op.isSetter( ) );
                        op2.setVisibility( op.getVisibility( ) );
                        op2.getBody( ).addAll( op.getBody( ) );
                        if ( derivedAndMofAndCodeFromTag ) {
                            op2.getBody( ).remove( 0 );
                            derivedAndMofAndCodeFromTag = false;
                        }
                        addCoreConnectionParameter( op2.getParameters( ) );
                        op2.getParameters( ).addAll( op.getParameters( ) );
                        op2.setHasCoreConnection( true );
                        result.add( op2 );

                        // ___remove
                        op = new JmiGeneratorClassOperationImpl( "___remove", "boolean", null, null ); //$NON-NLS-1$ //$NON-NLS-2$
                        op.setSetter( true );
                        op.setVisibility( "protected" ); //$NON-NLS-1$
                        op.getParameters( ).add( new JmiGeneratorParameterImpl( "firstEnd", "com.sap.tc.moin.repository.mmi.reflect.RefObject", null ) ); //$NON-NLS-1$ //$NON-NLS-2$
                        op.getParameters( ).add( new JmiGeneratorParameterImpl( "secondEnd", "com.sap.tc.moin.repository.mmi.reflect.RefObject", null ) ); //$NON-NLS-1$ //$NON-NLS-2$
                        op.getBody( ).add( "return remove((" + end0Type + ")firstEnd, (" + end1Type + ")secondEnd);" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        result.add( op );

                        op2 = new JmiGeneratorClassOperationImpl( "___remove", "boolean", null, null ); //$NON-NLS-1$ //$NON-NLS-2$
                        op2.setSetter( op.isSetter( ) );
                        op2.setVisibility( op.getVisibility( ) );
                        op2.getBody( ).add( "return remove(connection, (" + end0Type + ")firstEnd, (" + end1Type + ")secondEnd);" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        addCoreConnectionParameter( op2.getParameters( ) );
                        op2.getParameters( ).addAll( op.getParameters( ) );
                        op2.setHasCoreConnection( true );
                        result.add( op2 );
                    }

                    // ___query
                    op = new JmiGeneratorClassOperationImpl( "___query", "java.util.Collection", null, null ); //$NON-NLS-1$ //$NON-NLS-2$
                    op.setVisibility( "protected" ); //$NON-NLS-1$
                    op.getParameters( ).add( new JmiGeneratorParameterImpl( "queryEndName", "java.lang.String", null ) ); //$NON-NLS-1$ //$NON-NLS-2$
                    op.getParameters( ).add( new JmiGeneratorParameterImpl( "queryObject", "com.sap.tc.moin.repository.mmi.reflect.RefObject", null ) ); //$NON-NLS-1$ //$NON-NLS-2$
                    body = op.getBody( );
                    String end0NameU = StringUtils.convertFirstCharToUpper( getJMIIdentifier( this.end0 ) );
                    String end1NameU = StringUtils.convertFirstCharToUpper( getJMIIdentifier( this.end1 ) );
                    String accessor0Name = "get" + end0NameU;//$NON-NLS-1$
                    String accessor1Name = "get" + end1NameU;//$NON-NLS-1$
                    body.add( "java.util.Collection result = new java.util.ArrayList();" ); //$NON-NLS-1$
                    body.add( "if(queryEndName.equals(\"" + this.end1.getName( ) + "\")) { //$NON-NLS-1$" ); //$NON-NLS-1$ //$NON-NLS-2$
                    if ( this.end0.getMultiplicity( ).getUpper( ) != 1 ) {
                        body.add( "    result.addAll(" + accessor0Name + "((" + end1Type + ")queryObject));" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    } else {
                        body.add( "    result.add(" + accessor0Name + "((" + end1Type + ")queryObject));" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    }
                    body.add( "    return result;" ); //$NON-NLS-1$
                    body.add( "}" ); //$NON-NLS-1$
                    body.add( "if(queryEndName.equals(\"" + this.end0.getName( ) + "\")) { //$NON-NLS-1$" ); //$NON-NLS-1$ //$NON-NLS-2$
                    if ( this.end1.getMultiplicity( ).getUpper( ) != 1 ) {
                        body.add( "    result.addAll(" + accessor1Name + "((" + end0Type + ")queryObject));" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    } else {
                        body.add( "    result.add(" + accessor1Name + "((" + end0Type + ")queryObject));" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    }
                    body.add( "    return result;" ); //$NON-NLS-1$
                    body.add( "}" ); //$NON-NLS-1$
                    body.add( "else {" ); //$NON-NLS-1$
                    body.add( "    throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(queryEndName, null);" ); //$NON-NLS-1$
                    body.add( "}" ); //$NON-NLS-1$
                    result.add( op );

                    op2 = new JmiGeneratorClassOperationImpl( "___query", "java.util.Collection", null, null ); //$NON-NLS-1$ //$NON-NLS-2$
                    op2.setVisibility( op.getVisibility( ) );
                    body2 = op2.getBody( );
                    body2.add( "java.util.Collection result = new java.util.ArrayList();" ); //$NON-NLS-1$
                    body2.add( "if(queryEndName.equals(\"" + this.end1.getName( ) + "\")) { //$NON-NLS-1$" ); //$NON-NLS-1$ //$NON-NLS-2$
                    if ( this.end0.getMultiplicity( ).getUpper( ) != 1 ) {
                        body2.add( "    result.addAll(" + accessor0Name + "(connection, (" + end1Type + ")queryObject));" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    } else {
                        body2.add( "    result.add(" + accessor0Name + "(connection, (" + end1Type + ")queryObject));" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    }
                    body2.add( "    return result;" ); //$NON-NLS-1$
                    body2.add( "}" ); //$NON-NLS-1$
                    body2.add( "if(queryEndName.equals(\"" + this.end0.getName( ) + "\")) { //$NON-NLS-1$" ); //$NON-NLS-1$ //$NON-NLS-2$
                    if ( this.end1.getMultiplicity( ).getUpper( ) != 1 ) {
                        body2.add( "    result.addAll(" + accessor1Name + "(connection, (" + end0Type + ")queryObject));" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    } else {
                        body2.add( "    result.add(" + accessor1Name + "(connection, (" + end0Type + ")queryObject));" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    }
                    body2.add( "    return result;" ); //$NON-NLS-1$
                    body2.add( "}" ); //$NON-NLS-1$
                    body2.add( "else {" ); //$NON-NLS-1$
                    body2.add( "    throw new com.sap.tc.moin.repository.mmi.reflect.InvalidCallException(queryEndName, null);" ); //$NON-NLS-1$ 
                    body2.add( "}" ); //$NON-NLS-1$
                    addCoreConnectionParameter( op2.getParameters( ) );
                    op2.getParameters( ).addAll( op.getParameters( ) );
                    op2.setHasCoreConnection( true );
                    result.add( op2 );
                }

                // end of internal

                break;
            }
            default:
                break;

        }
        return result;
    }

    private void addRefLinkExistsMethod( List<JmiGeneratorClassOperation> result, String end0Type, String end1Type ) {

        JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( "refLinkExists", "boolean", null, null ); //$NON-NLS-1$ //$NON-NLS-2$
        addCoreConnectionParameter( op.getParameters( ) );
        op.getParameters( ).add( new JmiGeneratorParameterImpl( "firstEnd", "com.sap.tc.moin.repository.mmi.reflect.RefObject", null ) ); //$NON-NLS-1$ //$NON-NLS-2$
        op.getParameters( ).add( new JmiGeneratorParameterImpl( "secondEnd", "com.sap.tc.moin.repository.mmi.reflect.RefObject", null ) ); //$NON-NLS-1$ //$NON-NLS-2$
        op.getBody( ).add( "if ( firstEnd == null || secondEnd == null ) { return false; }" ); //$NON-NLS-1$
        op.getBody( ).add( "checkTypesForRefLinkExists( connection, firstEnd, secondEnd );" ); //$NON-NLS-1$
        op.getBody( ).add( "return exists( connection, (" + end0Type + ") firstEnd, (" + end1Type + ") secondEnd );" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        result.add( op );
    }

    /**
     * @return the constant for the association extent descriptor
     */
    public JmiGeneratorDescriptorConstant getAssociationExtentDescriptorConstant( ) {

        String type = "com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor<"; //$NON-NLS-1$
        type += this.getJavaClassName( JmiGenerationKind.INTERFACE, true );
        type += ">"; //$NON-NLS-1$

        return getExtentDescriptorConstant( "ASSOCIATION_DESCRIPTOR", type ); //$NON-NLS-1$
    }
}
