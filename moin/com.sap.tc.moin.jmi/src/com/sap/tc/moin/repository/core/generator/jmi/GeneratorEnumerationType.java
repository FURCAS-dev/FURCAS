package com.sap.tc.moin.repository.core.generator.jmi;

import java.util.Collection;
import java.util.Iterator;

import com.sap.tc.moin.repository.core.generator.jmi.javamodel.JavaSource;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.shared.util.Utilities;

@SuppressWarnings( { "unchecked", "nls" } )
public class GeneratorEnumerationType {

    // e.g. VisibilityKind
    public static String getJavaInterfaceName( EnumerationType enumerationType ) {

        return Generator.getJMIIdentifier( enumerationType );
    }

    // e.g. javax.jmi.model.VisibilityKind
    public static String getJavaInterfaceNameQualified( EnumerationType enumerationType ) {

        return getJavaPackageNameQualifiedForInterface( enumerationType ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaInterfaceName( enumerationType );
    }

    // e.g. VisibilityKindEnum
    public static String getJavaClassName( EnumerationType enumerationType ) {

        return Generator.getJMIIdentifier( enumerationType ) + Generator.EXTENSION_ENUM;
    }

    // e.g. javax.jmi.model.VisibilityKindEnum
    public static String getJavaClassNameQualified( EnumerationType enumerationType ) {

        return getJavaPackageNameQualifiedForClass( enumerationType ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaClassName( enumerationType );
    }

    // e.g. javax.jmi.model
    public static String getJavaPackageNameQualifiedForInterface( EnumerationType enumerationType ) {

        return Generator.getJMIPackageIdentifierQualified( enumerationType );
    }

    // e.g. javax.jmi.model
    public static String getJavaPackageNameQualifiedForClass( EnumerationType enumerationType ) {

        return getJavaPackageNameQualifiedForInterface( enumerationType );
    }

    public JavaSource generateTemplate( EnumerationType enumerationType, boolean noJavaDocs, int generationKind ) {

        StringBuffer code = new StringBuffer( 1000 );
        // important names
        String javaInterfaceName = getJavaInterfaceName( enumerationType );
        String javaInterfaceNameQualified = getJavaInterfaceNameQualified( enumerationType );
        String javaPackageNameForInterface = getJavaPackageNameQualifiedForInterface( enumerationType );
        String javaClassName = getJavaClassName( enumerationType );
        String javaClassNameQualified = getJavaClassNameQualified( enumerationType );
        String javaPackageNameForClass = getJavaPackageNameQualifiedForClass( enumerationType );
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
        Generator.generateDefaultIncludes( code, enumerationType, generationKind );
        if ( !noJavaDocs ) {
            Generator.generateAnnotationTemplate( code, enumerationType );
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
                code.append( " extends javax.jmi.reflect.RefEnum " ); //$NON-NLS-1$
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
        // class coding
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                break;
            case Generator.GenerationKind.CLASS:
            case Generator.GenerationKind.WRAPPER:
                generateTemplateEnumClass( enumerationType, code, javaClassName, javaClassNameQualified, javaInterfaceNameQualified, generationKind );
                break;
            default:
                throw new RuntimeException( );
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

    private void generateTemplateEnumClass( EnumerationType enumerationType, StringBuffer code, String javaClassName, String javaClassNameQualified, String javaInterfaceNameQualified, int generationKind ) {

        // logging
        code.append( "// logging" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "private static final com.sap.tc.logging.Location __loc = com.sap.tc.logging.Location.getLocation(" + javaClassNameQualified + ".class);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // literals
        code.append( "// enumeration literals" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        Collection labels = Generator.getAllEnumerationLabels( enumerationType );
        Iterator iter = labels.iterator( );
        while ( iter.hasNext( ) ) {
            String label = (String) iter.next( );
            code.append( "public static final " + javaClassNameQualified + " " + Generator.correctConstant( label ) + " = new " + javaClassNameQualified + "(\"" + label + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        }
        // variables
        code.append( "// variables" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "private static Map __labelIds = new HashMap();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "private static List __typeName = new ArrayList();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "private String __literalName = \"\";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // static
        code.append( "static {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        iter = enumerationType.getQualifiedName( ).iterator( );
        while ( iter.hasNext( ) ) {
            String name = (String) iter.next( );
            code.append( "  __typeName.add(\"" + name + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        }
        code.append( "  __typeName = java.util.Collections.unmodifiableList(__typeName);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        iter = labels.iterator( );
        while ( iter.hasNext( ) ) {
            String label = (String) iter.next( );
            code.append( "  __labelIds.put(\"" + label + "\", " + Generator.correctConstant( label ) + ");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        }
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // constructor
        code.append( "private " + javaClassName + "(java.lang.String literalName) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  __literalName = literalName;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // forName
        code.append( "public static " + javaInterfaceNameQualified + " forName(java.lang.String value) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  " + javaInterfaceNameQualified + " result = null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  try {" + Utilities.SystemLineSeparator );
        code.append( "    __loc.entering(\"forName(java.lang.String value)\", new Object[]{value});" + Utilities.SystemLineSeparator );
        code.append( "    result = (" + javaInterfaceNameQualified + ")__labelIds.get(value);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    if(result != null) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "      return result;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    else {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "      throw new IllegalArgumentException(\"enumeration label is not defined: \" + value);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator );
        code.append( "  finally {" + Utilities.SystemLineSeparator );
        code.append( "    __loc.exiting(\"forName(java.lang.String value)\", result);" + Utilities.SystemLineSeparator );
        code.append( "  }" + Utilities.SystemLineSeparator );
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // refTypeName
        code.append( "public java.util.List refTypeName() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  return java.util.Arrays.asList(__typeName.toArray());" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // equals
        code.append( "public boolean equals(java.lang.Object o) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  if(o instanceof " + javaClassNameQualified + ") {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    return (o == this);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  else if(o instanceof " + javaInterfaceNameQualified + ") {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    return ((" + javaInterfaceNameQualified + ")o).toString().equals(toString());" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  else if(o instanceof javax.jmi.reflect.RefEnum) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    return super.equals(o);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  else {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    return false;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // hashCode
        code.append( "public int hashCode() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  return __literalName.hashCode();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // readResovle
        code.append( "protected java.lang.Object readResolve() throws java.io.ObjectStreamException {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  try {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    return forName(__literalName);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  catch(IllegalArgumentException iae) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    java.io.InvalidObjectException ioe = new java.io.InvalidObjectException(iae.getMessage());" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    ioe.initCause(iae);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    throw ioe;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // toString
        code.append( "public String toString() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  return __literalName;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }
}