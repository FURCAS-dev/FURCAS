package com.sap.tc.moin.repository.jmigenerator.wrappers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ParameterInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorMofType;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorClassOperationImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorExceptionInterfaceTemplateImpl;
import com.sap.tc.moin.repository.shared.util.Utilities;

/**
 * The Exception wrapper
 */
public class JmiGeneratorExceptionWrapper extends JmiGeneratorBaseWrapper {

    /**
     * @param theException
     * @param generator
     */
    public JmiGeneratorExceptionWrapper( CoreConnection connection, String metamodelName, MofException theException, JmiGeneratorImpl generator ) {

        super( connection, metamodelName, theException, null, generator );
    }

    @Override
    public List<String> getExtends( JmiGenerationKind genKind, boolean qualified ) {

        List<String> result = new ArrayList<String>( );
        switch ( genKind ) {
            case INTERFACE:
                result.add( CLASS_REFEXCEPTIONAPI );
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
                return new JmiGeneratorExceptionInterfaceTemplateImpl( this );

            default:
                throw new MoinUnsupportedOperationException( "getJavaTemplate" ); //$NON-NLS-1$
        }
    }

    @Override
    public JmiGeneratorMofType getMofType( ) {

        return JmiGeneratorMofType.EXCEPTION;
    }

    @Override
    public List<String> getTemplateNames( JmiGenerationKind genKind ) {

        List<String> result = new ArrayList<String>( );
        switch ( genKind ) {
            case INTERFACE:
                result.add( "ExceptionInterface" ); //$NON-NLS-1$
                break;
            default:
                return result;
        }
        return result;
    }

    @Override
    protected void initChildren( ) {

        // no children
    }

    /**
     * @param genKind
     * @return the exception parameters
     */
    public List<JmiGeneratorClassOperation> getParameters( JmiGenerationKind genKind ) {

        List<JmiGeneratorClassOperation> result = new ArrayList<JmiGeneratorClassOperation>( );
        switch ( genKind ) {
            case INTERFACE:
                for ( Iterator<ModelElement> iterator = getAllContent( ); iterator.hasNext( ); ) {
                    ModelElementInternal me = (ModelElementInternal) iterator.next( );
                    if ( me instanceof ParameterInternal ) {
                        ParameterInternal par = (ParameterInternal) me;
                        String accessorName = getAccessorNameForModelElement( me );
                        String type = getExceptionParameterType( par );
                        String typeParameter = getExceptionParameterTypeParameter( par );
                        JmiGeneratorClassOperationImpl op = new JmiGeneratorClassOperationImpl( accessorName, type, typeParameter, null );
                        if ( par.getMultiplicity( ).getUpper( ) != 1 ) {
                            op.setMultiple( true );
                        }
                        // TODO replace this with the lower case?
                        op.setVariableName( getJMIIdentifier( par ) );
                        result.add( op );
                    }
                }
                break;
            default:
        }
        return result;
    }

    /**
     * @param parameter
     * @return the type of the parameter
     */
    private String getExceptionParameterType( ParameterInternal parameter ) {

        String type = null;
        if ( parameter.getMultiplicity( ).getLower( ) == 0 && parameter.getMultiplicity( ).getUpper( ) == 1 ) {
            // optional
            type = getJavaTypeClass( getType( parameter.getType( connection ) ) );
        } else if ( parameter.getMultiplicity( ).getLower( ) == 1 && parameter.getMultiplicity( ).getUpper( ) == 1 ) {
            type = getType( parameter.getType( connection ) );
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
     * @param parameter
     * @return the Java generic type parameter (fully qualified) for a
     * multi-valued parameter and null for a single-valued one
     */
    private String getExceptionParameterTypeParameter( ParameterInternal parameter ) {

        if ( parameter.getMultiplicity( ).getUpper( ) != 1 ) {
            return getType( parameter.getType( connection ) );
        } else {
            return null;
        }
    }
}
