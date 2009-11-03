package com.sap.tc.moin.repository.core.generator.jmi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.core.generator.jmi.javamodel.JavaSource;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.shared.util.Utilities;

@SuppressWarnings( { "unchecked", "nls" } )
public class GeneratorException {

    // e.g. NameNotFoundException
    public static String getJavaClassName( MofException mofException ) {

        return Generator.getJMIIdentifier( mofException );
    }

    // e.g. javax.jmi.model.NameNotFoundException
    public static String getJavaClassNameQualified( MofException mofException ) {

        return getJavaPackageNameQualifiedForClass( mofException ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaClassName( mofException );
    }

    // e.g. javax.jmi.model
    public static String getJavaPackageNameQualifiedForClass( MofException mofException ) {

        return Generator.getJMIPackageIdentifierQualified( mofException );
    }

    public JavaSource generateTemplate( MofException mofException, boolean noJavaDocs, int generationKind ) {

        StringBuffer code = new StringBuffer( 1000 );
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                return null;
            case Generator.GenerationKind.CLASS:
            case Generator.GenerationKind.WRAPPER:
                break;
            default:
                throw new RuntimeException( );
        }
        // important names
        String javaClassName = getJavaClassName( mofException );
        String javaClassNameQualified = getJavaClassNameQualified( mofException );
        String javaPackageNameForClass = getJavaPackageNameQualifiedForClass( mofException );
        // preamble
        Generator.generatePreamble( code );
        // package statement
        switch ( generationKind ) {
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
        Generator.generateDefaultIncludes( code, mofException, generationKind );
        if ( !noJavaDocs ) {
            Generator.generateAnnotationTemplate( code, mofException );
        }
        // class header & generalization
        code.append( "public final class " + javaClassName + " extends javax.jmi.reflect.RefException {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // get a list of all paramters
        List params = new ArrayList( 10 );
        Iterator iter = Generator.getAllContent( mofException ).iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof Parameter ) {
                params.add( me );
            }
        }
        // for each parameter
        code.append( "// parameters" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        iter = params.iterator( );
        StringBuffer argumentList = new StringBuffer( );
        while ( iter.hasNext( ) ) {
            Parameter parameter = (Parameter) iter.next( );
            String variableName = Generator.getJMIIdentifier( parameter );
            argumentList.append( Generator.getParameterType( parameter ) + " " + variableName ); //$NON-NLS-1$
            code.append( "private " + Generator.getParameterType( parameter ) + " " + variableName + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            if ( iter.hasNext( ) ) {
                argumentList.append( ", " ); //$NON-NLS-1$
            }
        }
        // constructor
        String constructorName = javaClassName;
        code.append( "// constructor" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "public " + constructorName + "(" + argumentList + ") {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  super();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        iter = params.iterator( );
        while ( iter.hasNext( ) ) {
            Parameter parameter = (Parameter) iter.next( );
            String variableName = Generator.getJMIIdentifier( parameter );
            code.append( "  this." + variableName + " = " + variableName + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        }
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // accessor methods for all parameters
        code.append( "// accessor methods for all parameters" ); //$NON-NLS-1$
        code.append( Utilities.SystemLineSeparator );
        iter = params.iterator( );
        while ( iter.hasNext( ) ) {
            Parameter parameter = (Parameter) iter.next( );
            String variableName = Generator.getJMIIdentifier( parameter );
            String accessorName = Generator.getAccessorNameForModelElement( parameter );
            String parameterType = Generator.getParameterType( parameter );
            code.append( "public " + parameterType + " " + accessorName + "() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            code.append( "  return " + variableName + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        }
        // internal getter for parameters
        code.append( "public java.util.List get___Parameters() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  java.util.List parameters = new java.util.ArrayList(" + params.size( ) + ");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        iter = params.iterator( );
        while ( iter.hasNext( ) ) {
            Parameter parameter = (Parameter) iter.next( );
            String variableName = Generator.getJMIIdentifier( parameter );
            code.append( "  parameters.add(" + variableName + ");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        }
        code.append( "  return parameters;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // internal setter for parameters
        code.append( "public void set___Parameters(java.util.List parameters) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        iter = params.iterator( );
        int counter = 0;
        while ( iter.hasNext( ) ) {
            Parameter parameter = (Parameter) iter.next( );
            String variableName = Generator.getJMIIdentifier( parameter );
            String parameterType = Generator.getParameterType( parameter );
            code.append( "  " + variableName + " = (" + parameterType + ")parameters.get(" + counter + ");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            counter++;
        }
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // end of interface/class
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // create a source code instance
        JavaSource source = null;
        source = new JavaSource( javaClassNameQualified );
        source.setCode( code.toString( ) );
        return source;
    }
}