package com.sap.tc.moin.repository.core.generator.jmi;

import com.sap.tc.moin.repository.core.generator.jmi.javamodel.JavaSource;
import com.sap.tc.moin.repository.core.generator.jmi.javamodel.PropertySource;
import com.sap.tc.moin.repository.shared.util.Utilities;

@SuppressWarnings( { "unchecked", "nls" } )
public class GeneratorMetamodelDeploymentExtension {

    public static String getJavaClassName( ) {

        return "MetamodelExtension";
    }

    public static String getJavaPackageNameQualified( String metamodelName ) {

        if ( metamodelName == null || metamodelName.length( ) == 0 ) {
            return Generator.MOIN_PACKAGE;
        } else {
            return Generator.MOIN_PACKAGE + GeneratorConstants.PACKAGE_DELIMITER + GeneratorConstants.PACKAGE_PREFIX_METAMODELID + Generator.getMetamodelId( metamodelName );
        }
    }

    public static String getJavaClassNameQualified( String metamodelName ) {

        return getJavaPackageNameQualified( metamodelName ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaClassName( );
    }

    private static String getPropertiesFileNameQualified( ) {

        return Generator.MOIN_PACKAGE + GeneratorConstants.PACKAGE_DELIMITER + getJavaClassName( );
    }

    public JavaSource generateTemplate( String metamodelName ) {

        StringBuffer code = new StringBuffer( 1000 );
        String packageName = getJavaPackageNameQualified( metamodelName );
        String className = getJavaClassName( );
        String classNameQualified = getJavaClassNameQualified( metamodelName );
        JavaSource source = new JavaSource( classNameQualified );
        // preamble
        Generator.generatePreamble( code );
        // package statement
        code.append( "package " + packageName + ";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // class header
        code.append( "public final class " + className + " implements com.sap.tc.moin.repository.metamodels.DeploymentExtension {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // class attributes
        code.append( "  private java.util.List<java.lang.String> jmiClasses = null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // default constructor, necessary for access via Java reflection
        code.append( "  public " + className + "() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // startup
        code.append( "  public void startup() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // shutdown
        code.append( "  public void shutdown() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // DeploymentExtension.getAvailableClassNames
        code.append( "  public java.util.List<java.lang.String> getAvailableClassNames() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    if(jmiClasses == null) {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "      MetamodelInformationProvider metamodelInformationProvider = new MetamodelInformationProvider();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "      jmiClasses = metamodelInformationProvider.getJmiInterfaceList();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "      jmiClasses.addAll(metamodelInformationProvider.getJmiImplementationList());" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    return jmiClasses;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // DeploymentExtension.getJmiClass
        code.append( "  public java.lang.Class getJmiClass(java.lang.String className) throws java.lang.ClassNotFoundException {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    return (java.lang.Class)java.lang.Class.forName(className);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // DeploymentExtension.getVersion
        code.append( "  public java.lang.String getVersion() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    return \"MetaModelExtension Version 1\";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // end of class
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        source.setCode( code.toString( ) );
        return source;
    }

    public JavaSource generatePropertiesHelperFile( String metamodelId ) {

        StringBuffer code = new StringBuffer( 1000 );
        JavaSource source = new PropertySource( getPropertiesFileNameQualified( ) );
        code.append( "MetamodelExtensionName = " + getJavaClassNameQualified( metamodelId ) + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        source.setCode( code.toString( ) );
        return source;
    }
}
