package com.sap.tc.moin.repository.core.generator.jmi;

import java.util.Collection;
import java.util.Iterator;

import com.sap.tc.moin.repository.core.generator.jmi.javamodel.JavaSource;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.shared.util.Utilities;

@SuppressWarnings( { "unchecked", "nls" } )
public class GeneratorMetamodelInformationProvider {

    public static String getJavaClassName( ) {

        return "MetamodelInformationProvider";
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

    public JavaSource generateTemplate( String metamodelName, Collection modelElements ) {

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
        code.append( "public final class " + className + " {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // default constructor, necessary for access via Java reflection
        code.append( "  public " + className + "() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // generator version
        code.append( "  public java.lang.String getGeneratorVersion() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    return \"" + GeneratorConstants.GENERATOR_VERSION + "\";" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // JMI interface list
        generateJmiInterfaceListTemplate( code, modelElements );
        // JMI implementation list
        generateJmiImplementationListTemplate( code, modelElements );
        // end of class
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        source.setCode( code.toString( ) );
        return source;
    }

    private void generateJmiInterfaceListTemplate( StringBuffer code, Collection modelElements ) {

        code.append( "  public java.util.List<java.lang.String> getJmiInterfaceList() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    java.util.List<java.lang.String> jmiInterfaceList = new java.util.ArrayList<java.lang.String>();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        Iterator iter = modelElements.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement modelElement = (ModelElement) iter.next( );
            MofPackage immediatePackage = (MofPackage) modelElement.refImmediatePackage( ).refMetaObject( );
            if ( !immediatePackage.getQualifiedName( ).get( 0 ).equals( GeneratorConstants.NAME_MODEL_PACKAGE ) ) {
                // exclude instances that are not instances of the MOF meta-metamodel, e.g. instances of OCL
                continue;
            }
            if ( modelElement instanceof MofPackage ) {
                code.append( "    jmiInterfaceList.add(\"" + GeneratorPackage.getJavaInterfaceNameQualified( (MofPackage) modelElement ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
            if ( modelElement instanceof MofClass ) {
                code.append( "    jmiInterfaceList.add(\"" + GeneratorInstance.getJavaInterfaceNameQualified( (MofClass) modelElement ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    jmiInterfaceList.add(\"" + GeneratorClass.getJavaInterfaceNameQualified( (MofClass) modelElement ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
            if ( modelElement instanceof Association ) {
                code.append( "    jmiInterfaceList.add(\"" + GeneratorAssociation.getJavaInterfaceNameQualified( (Association) modelElement ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
            if ( modelElement instanceof DataType ) {
                if ( modelElement instanceof EnumerationType ) {
                    code.append( "    jmiInterfaceList.add(\"" + GeneratorEnumerationType.getJavaInterfaceNameQualified( (EnumerationType) modelElement ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                } else if ( modelElement instanceof StructureType ) {
                    code.append( "    jmiInterfaceList.add(\"" + GeneratorStructureType.getJavaInterfaceNameQualified( (StructureType) modelElement ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                } else {
                    if ( !( Generator.isJavaType( ( (DataType) modelElement ).getName( ) ) ) ) {
                        code.append( "    jmiInterfaceList.add(\"" + GeneratorDataType.getJavaInterfaceNameQualified( (DataType) modelElement ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    }
                }
            }
        }
        code.append( "    return jmiInterfaceList;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }

    private void generateJmiImplementationListTemplate( StringBuffer code, Collection modelElements ) {

        code.append( "  public java.util.List<java.lang.String> getJmiImplementationList() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "    java.util.List<java.lang.String> jmiImplementationList = new java.util.ArrayList<java.lang.String>();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        Iterator iter = modelElements.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement modelElement = (ModelElement) iter.next( );
            MofPackage immediatePackage = (MofPackage) modelElement.refImmediatePackage( ).refMetaObject( );
            if ( !immediatePackage.getQualifiedName( ).get( 0 ).equals( GeneratorConstants.NAME_MODEL_PACKAGE ) ) {
                // exclude instances that are not instances of the MOF meta-metamodel, e.g. instances of OCL
                continue;
            }
            if ( modelElement instanceof MofPackage ) {
                code.append( "    jmiImplementationList.add(\"" + GeneratorPackage.getJavaClassNameQualified( (MofPackage) modelElement ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
            if ( modelElement instanceof MofClass ) {
                code.append( "    jmiImplementationList.add(\"" + GeneratorInstance.getJavaClassNameQualified( (MofClass) modelElement ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "    jmiImplementationList.add(\"" + GeneratorClass.getJavaClassNameQualified( (MofClass) modelElement ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
            if ( modelElement instanceof Association ) {
                code.append( "    jmiImplementationList.add(\"" + GeneratorAssociation.getJavaClassNameQualified( (Association) modelElement ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
            if ( modelElement instanceof MofException ) {
                code.append( "    jmiImplementationList.add(\"" + GeneratorException.getJavaClassNameQualified( (MofException) modelElement ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
            }
            if ( modelElement instanceof DataType ) {
                if ( modelElement instanceof EnumerationType ) {
                    code.append( "    jmiImplementationList.add(\"" + GeneratorEnumerationType.getJavaClassNameQualified( (EnumerationType) modelElement ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                } else if ( modelElement instanceof StructureType ) {
                    code.append( "    jmiImplementationList.add(\"" + GeneratorStructureType.getJavaClassNameQualified( (StructureType) modelElement ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                } else {
                    if ( !( Generator.isJavaType( ( (DataType) modelElement ).getName( ) ) ) ) {
                        code.append( "    jmiImplementationList.add(\"" + GeneratorDataType.getJavaClassNameQualified( (DataType) modelElement ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    }
                }
            }
        }
        code.append( "    return jmiImplementationList;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "  }" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
    }
}
