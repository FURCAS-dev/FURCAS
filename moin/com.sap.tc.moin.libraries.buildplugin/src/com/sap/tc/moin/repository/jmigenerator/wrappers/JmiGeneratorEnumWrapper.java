package com.sap.tc.moin.repository.jmigenerator.wrappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorMofType;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorEnumLabel;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorEnumImplTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorEnumInterfaceTemplateImpl;
import com.sap.tc.moin.repository.shared.util.Utilities;

/**
 * The EnumerationType wrapper
 */
public class JmiGeneratorEnumWrapper extends JmiGeneratorBaseWrapper {

    private final static String EXTENSION_ENUM = "Enum"; //$NON-NLS-1$

    private final EnumerationType wrappedEnum;

    /**
     * @param underlyingModelElement
     * @param generator
     */
    public JmiGeneratorEnumWrapper( CoreConnection connection, String metamodelName, EnumerationType underlyingModelElement, JmiGeneratorImpl generator ) {

        super( connection, metamodelName, underlyingModelElement, null, generator );
        this.wrappedEnum = underlyingModelElement;
    }

    /**
     * @return the labels
     */
    public List<JmiGeneratorEnumLabel> getEnumLabels( ) {

        List<JmiGeneratorEnumLabel> result = new ArrayList<JmiGeneratorEnumLabel>( );
        Collection<String> labels = getAllEnumerationLabels( );
        for ( final String label : labels ) {
            JmiGeneratorEnumLabel elab = new JmiGeneratorEnumLabel( ) {

                public String getName( ) {

                    return label;
                }

                public String getJavaName( ) {

                    return correctName( label, true );
                }

            };
            result.add( elab );
        }
        return result;
    }

    private Collection<String> getAllEnumerationLabels( ) {

        return getJmiHelper( ).getAllEnumerationLabels( this.wrappedEnum );
    }

    @Override
    public List<String> getExtends( JmiGenerationKind genKind, boolean qualified ) {

        List<String> result = new ArrayList<String>( );

        switch ( genKind ) {
            case CLASS:
                // nothing
                break;

            case INTERFACE:
                if ( qualified ) {
                    result.add( CLASS_REFENUMAPI );
                } else {
                    result.add( CLASS_REFENUMAPI.substring( CLASS_REFENUMAPI.lastIndexOf( '.' ) + 1 ) );
                }
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
            case CLASS:
                result.add( this.getJavaClassName( JmiGenerationKind.INTERFACE, qualified ) );
                break;

            case INTERFACE:
                // nothing
                break;

            default:
                throw new MoinUnsupportedOperationException( "getImplements" ); //$NON-NLS-1$
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
                sb.append( EXTENSION_ENUM );
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

        if ( genKind == JmiGenerationKind.INTERFACE ) {
            if ( templateName.equals( "EnumClass" ) ) { //$NON-NLS-1$
                return new JmiGeneratorEnumImplTemplateImpl( this );
            }
            return new JmiGeneratorEnumInterfaceTemplateImpl( this );
        }
        throw new MoinUnsupportedOperationException( "getJavaTemplate" ); //$NON-NLS-1$
    }

    @Override
    public JmiGeneratorMofType getMofType( ) {

        return JmiGeneratorMofType.ENUM;
    }

    @Override
    public List<String> getTemplateNames( JmiGenerationKind genKind ) {

        List<String> result = new ArrayList<String>( );
        if ( genKind == JmiGenerationKind.INTERFACE ) {
            result.add( "EnumInterface" ); //$NON-NLS-1$
            result.add( "EnumClass" ); //$NON-NLS-1$
        }
        return result;
    }

    @Override
    protected void initChildren( ) {

        // no children
    }

    /**
     * @return the type
     */
    @SuppressWarnings( "unchecked" )
    public List<String> getType( ) {

        return this.wrappedEnum.getQualifiedName( );
    }

    @Override
    public String getJavaPackageNameQualified( JmiGenerationKind genKind ) {

        if ( genKind == JmiGenerationKind.CLASS ) {
            return super.getJavaPackageNameQualified( JmiGenerationKind.INTERFACE );
        }
        return super.getJavaPackageNameQualified( genKind );
    }

    public List<String> getQualifiedName( ) {

        List<String> result = new ArrayList<String>( );
        String dotsep = this.getQualifiedNameDotSeparated( );
        StringTokenizer tok = new StringTokenizer( dotsep, "." ); //$NON-NLS-1$
        while ( tok.hasMoreTokens( ) ) {
            result.add( tok.nextToken( ) );
        }
        return result;
    }

}
