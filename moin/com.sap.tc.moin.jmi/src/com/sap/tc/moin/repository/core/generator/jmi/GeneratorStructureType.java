package com.sap.tc.moin.repository.core.generator.jmi;

import java.util.ArrayList;
import java.util.Iterator;

import com.sap.tc.moin.repository.core.generator.jmi.javamodel.JavaSource;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.shared.util.Utilities;

@SuppressWarnings( { "unchecked", "nls" } )
public class GeneratorStructureType {

    // e.g. MultiplicityType
    public static String getJavaInterfaceName( StructureType structureType ) {

        return Generator.getJMIIdentifier( structureType );
    }

    // e.g. javax.jmi.model.MultiplicityType
    public static String getJavaInterfaceNameQualified( StructureType structureType ) {

        return getJavaPackageNameQualifiedForInterface( structureType ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaInterfaceName( structureType );
    }

    // e.g. MultiplicityTypeImpl
    public static String getJavaClassName( StructureType structureType ) {

        return Generator.getJMIIdentifier( structureType ) + Generator.EXTENSION_IMPLEMENTATION;
    }

    // e.g. javax.jmi.model.MultiplicityTypeImpl
    public static String getJavaClassNameQualified( StructureType structureType ) {

        return getJavaPackageNameQualifiedForClass( structureType ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaClassName( structureType );
    }

    // e.g. javax.jmi.model
    public static String getJavaPackageNameQualifiedForInterface( StructureType structureType ) {

        return Generator.getJMIPackageIdentifierQualified( structureType );
    }

    // e.g. javax.jmi.model.___impl
    public static String getJavaPackageNameQualifiedForClass( StructureType structureType ) {

        return Generator.getJMIPackageIdentifierQualified( structureType ) + GeneratorConstants.PACKAGE_DELIMITER + Generator.PACKAGE_IMPLEMENTATION;
    }

    public JavaSource generateTemplate( StructureType structureType, boolean noJavaDocs, int generationKind ) {

        StringBuffer code = new StringBuffer( 1000 );
        // important names
        String javaInterfaceName = getJavaInterfaceName( structureType );
        String javaInterfaceNameQualified = getJavaInterfaceNameQualified( structureType );
        String javaPackageNameForInterface = getJavaPackageNameQualifiedForInterface( structureType );
        String javaClassName = getJavaClassName( structureType );
        String javaClassNameQualified = getJavaClassNameQualified( structureType );
        String javaPackageNameForClass = getJavaPackageNameQualifiedForClass( structureType );
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
        Generator.generateDefaultIncludes( code, structureType, generationKind );
        // annotation template
        if ( !noJavaDocs ) {
            Generator.generateAnnotationTemplate( code, structureType );
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
                code.append( " extends " + Generator.JMI_IMPL_PACKAGE_REFLECT + ".RefStructImpl implements " + javaInterfaceNameQualified ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
            default:
                throw new RuntimeException( );
        }
        code.append( " {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // constructors
        switch ( generationKind ) {
            case Generator.GenerationKind.CLASS:
                code.append( "// default constructor" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                // no arguments
                code.append( "public " + javaClassName + "() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "  super();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                // with fields
                code.append( "// specific constructor" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "public " + javaClassName + "(Object workspace, RefObject metaObject) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "  super(workspace, metaObject);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
        }
        // structure fields
        Iterator iter = Generator.getAllContent( structureType ).iterator( );
        ArrayList fields = new ArrayList( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof StructureField ) {
                fields.add( me );
            }
        }
        iter = fields.iterator( );
        while ( iter.hasNext( ) ) {
            StructureField field = (StructureField) iter.next( );
            Generator.getGeneratorStructureFieldTemplate( ).generateTemplate( code, field, generationKind );
        }
        // RefStruct
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                break;
            case Generator.GenerationKind.CLASS:
                Generator.generateTemplateRefStruct( code, structureType, null, 0 );
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
        }
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