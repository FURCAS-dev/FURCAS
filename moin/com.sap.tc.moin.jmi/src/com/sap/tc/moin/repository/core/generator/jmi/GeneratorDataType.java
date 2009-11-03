package com.sap.tc.moin.repository.core.generator.jmi;

import com.sap.tc.moin.repository.core.generator.jmi.javamodel.JavaSource;
import com.sap.tc.moin.repository.mmi.model.AliasType;
import com.sap.tc.moin.repository.mmi.model.CollectionType;
import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.shared.util.Utilities;

@SuppressWarnings( { "unchecked", "nls" } )
public class GeneratorDataType {

    public static String getJavaInterfaceName( DataType dataType ) {

        return Generator.convertFirstCharToUpper( Generator.getJMIIdentifier( dataType ) );
    }

    public static String getJavaInterfaceNameQualified( DataType dataType ) {

        return getJavaPackageNameQualifiedForInterface( dataType ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaInterfaceName( dataType );
    }

    public static String getJavaClassName( DataType dataType ) {

        return getJavaInterfaceName( dataType ) + Generator.EXTENSION_IMPLEMENTATION;
    }

    public static String getJavaClassNameQualified( DataType dataType ) {

        return getJavaPackageNameQualifiedForClass( dataType ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaClassName( dataType );
    }

    public static String getJavaPackageNameQualifiedForInterface( DataType dataType ) {

        return Generator.getJMIPackageIdentifierQualified( dataType );
    }

    public static String getJavaPackageNameQualifiedForClass( DataType dataType ) {

        return Generator.getJMIPackageIdentifierQualified( dataType ) + GeneratorConstants.PACKAGE_DELIMITER + Generator.PACKAGE_IMPLEMENTATION;
    }

    public JavaSource generateTemplate( DataType dataType, boolean noJavaDocs, int generationKind ) {

        // don't generate for Java primitive types, CollectionType, AliasType
        if ( dataType instanceof PrimitiveType || dataType instanceof CollectionType || dataType instanceof AliasType ) {
            return null;
        }
        StringBuffer code = new StringBuffer( 1000 );
        // important names
        String javaInterfaceName = getJavaInterfaceName( dataType );
        String javaInterfaceNameQualified = getJavaInterfaceNameQualified( dataType );
        String javaPackageNameForInterface = getJavaPackageNameQualifiedForInterface( dataType );
        String javaClassName = getJavaClassName( dataType );
        String javaClassNameQualified = getJavaClassNameQualified( dataType );
        String javaPackageNameForClass = getJavaPackageNameQualifiedForClass( dataType );
        // preamble
        Generator.generatePreamble( code );
        // package statement
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                code.append( "package " + javaPackageNameForInterface + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( Utilities.SystemLineSeparator );
                break;
            case Generator.GenerationKind.CLASS:
                code.append( "package " + javaPackageNameForClass + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( Utilities.SystemLineSeparator );
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
            default:
                throw new RuntimeException( );
        }
        // includes
        Generator.generateDefaultIncludes( code, dataType, generationKind );
        // annotation template
        if ( !noJavaDocs ) {
            Generator.generateAnnotationTemplate( code, dataType );
        }
        // interface/class header
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                code.append( "public interface " + javaInterfaceName ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.CLASS:
                code.append( "public final class " + javaClassName ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
            default:
                throw new RuntimeException( );
        }
        // generalization
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                code.append( " extends RefStruct " ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.CLASS:
                code.append( " implements " + javaInterfaceNameQualified ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
            default:
                throw new RuntimeException( );
        }
        code.append( " {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // end of interface/class
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // create a source code instance
        JavaSource source = null;
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                source = new JavaSource( javaInterfaceNameQualified );
                break;
            case Generator.GenerationKind.CLASS:
                source = new JavaSource( javaClassNameQualified );
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
            default:
                throw new RuntimeException( );
        }
        if ( source != null ) {
            source.setCode( code.toString( ) );
        }
        return source;
    }
}