package com.sap.tc.moin.repository.core.generator.jmi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import com.sap.tc.moin.repository.core.generator.jmi.javamodel.JavaSource;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.shared.util.Utilities;

@SuppressWarnings( { "unchecked", "nls" } )
public class GeneratorPackage {

    // e.g. ModelPackage
    public static String getJavaInterfaceName( MofPackage mofPackage ) {

        return Generator.getJMIIdentifier( mofPackage ) + Generator.EXTENSION_PACKAGE;
    }

    // e.g. javax.jmi.model.ModelPackage
    public static String getJavaInterfaceNameQualified( MofPackage mofPackage ) {

        return getJavaPackageNameQualifiedForInterface( mofPackage ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaInterfaceName( mofPackage );
    }

    // e.g. ModelPackageImpl
    public static String getJavaClassName( MofPackage mofPackage ) {

        return getJavaInterfaceName( mofPackage ) + Generator.EXTENSION_IMPLEMENTATION;
    }

    // e.g. javax.jmi.model.___impl.ModelPackageImpl
    public static String getJavaClassNameQualified( MofPackage mofPackage ) {

        return getJavaPackageNameQualifiedForClass( mofPackage ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaClassName( mofPackage );
    }

    // e.g. javax.jmi.model
    public static String getJavaPackageNameQualifiedForInterface( MofPackage mofPackage ) {

        return Generator.getJMIIdentifierQualified( mofPackage ).toLowerCase( Locale.ENGLISH );
    }

    // e.g. javax.jmi.model.___impl
    public static String getJavaPackageNameQualifiedForClass( MofPackage mofPackage ) {

        return Generator.getJMIIdentifierQualified( mofPackage ).toLowerCase( Locale.ENGLISH ) + GeneratorConstants.PACKAGE_DELIMITER + Generator.PACKAGE_IMPLEMENTATION;
    }

    public JavaSource generateTemplate( MofPackage mofPackage, boolean noJavaDocs, int generationKind ) {

        StringBuffer code = new StringBuffer( 1000 );
        JavaSource source = null;
        // important names
        String javaInterfaceName = getJavaInterfaceName( mofPackage );
        String javaInterfaceNameQualified = getJavaInterfaceNameQualified( mofPackage );
        String javaPackageNameForInterface = getJavaPackageNameQualifiedForInterface( mofPackage );
        String javaClassName = getJavaClassName( mofPackage );
        String javaClassNameQualified = getJavaClassNameQualified( mofPackage );
        String javaPackageNameForClass = getJavaPackageNameQualifiedForClass( mofPackage );
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
        Generator.generateDefaultIncludes( code, mofPackage, generationKind );
        // annotation template
        if ( !noJavaDocs ) {
            Generator.generateAnnotationTemplate( code, mofPackage );
        }
        // interface/class header
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                // Java annotation template
                Generator.generateJavaAnnotationTemplatePackage( code, mofPackage );
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
                code.append( " extends " ); //$NON-NLS-1$
                List superTypes = mofPackage.getSupertypes( );
                if ( superTypes == null || superTypes.size( ) < 1 ) {
                    code.append( "RefPackage " ); //$NON-NLS-1$
                } else {
                    Iterator iter = superTypes.iterator( );
                    while ( iter.hasNext( ) ) {
                        MofPackage mp = (MofPackage) iter.next( );
                        code.append( getJavaInterfaceNameQualified( mp ) );
                        if ( iter.hasNext( ) ) {
                            code.append( ", " ); //$NON-NLS-1$
                        }
                    }
                }
                break;
            case Generator.GenerationKind.CLASS:
                code.append( " extends " + Generator.JMI_IMPL_PACKAGE_REFLECT + ".RefPackageImpl implements " + javaInterfaceNameQualified ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
            default:
                throw new RuntimeException( );
        }
        code.append( " {" ); //$NON-NLS-1$
        code.append( Utilities.SystemLineSeparator );
        List contents = Generator.getAllContent( mofPackage );
        // constructor & variables
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                break;
            case Generator.GenerationKind.CLASS:
            case Generator.GenerationKind.WRAPPER:
                Generator.generateTemplateRefPackageDecl( code, mofPackage, javaClassName, generationKind );
                break;
            default:
                throw new RuntimeException( );
        }
        // constant template
        code.append( "// constants" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        Iterator iter = contents.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof Constant ) {
                Generator.getGeneratorConstantTemplate( ).generateTemplate( code, (Constant) me, noJavaDocs, generationKind );
            }
        }
        // clustered packages (import)
        LinkedList listNames = new LinkedList( );
        code.append( "// each imported package where:" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "//   isClustered and" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "//   Import.visibility == public_vis and" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        code.append( "//   importedNamespace.visibility == public_vis" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        iter = contents.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof Import ) {
                Import mofImport = (Import) me;
                MofPackage importedNamespace = (MofPackage) mofImport.getImportedNamespace( );
                if ( mofImport.isClustered( ) && mofImport.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) && importedNamespace.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
                    listNames.add( Generator.getJMIIdentifierQualified( mofImport.getImportedNamespace( ) ) );
                    String packageNameQualified = getJavaInterfaceNameQualified( (MofPackage) mofImport.getImportedNamespace( ) );
                    String accessorName = Generator.getAccessorNameForModelElement( mofImport );
                    generatePackageTemplateClusteredPackage( code, (MofPackage) mofImport.getImportedNamespace( ), packageNameQualified, accessorName, generationKind );
                }
            }
        }
        // nested packages
        listNames.clear( );
        code.append( "// each contained package where visibility = public_vis" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        iter = contents.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof MofPackage ) {
                MofPackage mp = (MofPackage) me;
                if ( mp.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
                    listNames.add( mp.getName( ) );
                    String packageNameQualified = getJavaInterfaceNameQualified( (MofPackage) mp );
                    String accessorName = Generator.getAccessorNameForModelElement( mp );
                    generatePackageTemplate( code, mp, packageNameQualified, accessorName, generationKind );
                }
            }
        }
        // public visible classes
        listNames.clear( );
        code.append( "// each directly contained class with visibility = public_vis" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        iter = contents.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof MofClass ) {
                String classNameQualified = GeneratorClass.getJavaInterfaceNameQualified( (MofClass) me );
                String accessorName = Generator.getAccessorNameForModelElement( me );
                generateClassTemplate( code, (MofClass) me, classNameQualified, accessorName, generationKind );
                listNames.add( Generator.getJMIIdentifier( me ) );
            }
        }
        // public visible associations
        listNames.clear( );
        code.append( "// each directly contained association with visibility = public_vis" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        iter = contents.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof Association ) {
                String associationNameQualified = Generator.getJMIIdentifierQualified( (Association) me );
                String accessorName = Generator.getAccessorNameForModelElement( me );
                generateAssociationTemplate( code, (Association) me, associationNameQualified, accessorName, generationKind );
                listNames.add( Generator.getJMIIdentifier( me ) );
            }
        }
        // struture types
        code.append( "// each directly contained StructType with visibility = public_vis" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        iter = contents.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof StructureType ) {
                Generator.generateStructureTypeTemplate( code, (StructureType) me, generationKind );
            }
        }
        // RefPackage
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                break;
            case Generator.GenerationKind.CLASS:
            case Generator.GenerationKind.WRAPPER:
                Generator.generateTemplateRefPackage( code, mofPackage, javaClassName, javaInterfaceNameQualified, generationKind );
                break;
            default:
                throw new RuntimeException( );
        }
        // end of interface/class
        code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // create a source code instance
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

    /**
     * Gets the packageClassNameByPackageName attribute of the GeneratorPackage
     * class
     * 
     * @param packageName Description of the Parameter
     * @return The packageClassNameByPackageName value
     */
    public static String getPackageClassNameByPackageName( String packageName ) {

        String nameOK = packageName;
        int n = packageName.lastIndexOf( GeneratorConstants.PACKAGE_DELIMITER );
        if ( n > 0 ) {
            String name = packageName.substring( n + 1 );
            nameOK = packageName.substring( 0, n ) + GeneratorConstants.PACKAGE_DELIMITER + name + GeneratorConstants.PACKAGE_DELIMITER + name;
            nameOK = Generator.correctQualifiedName( nameOK );
        }
        return nameOK;
    }

    private void generatePackageTemplate( StringBuffer code, MofPackage mofPackage, String packageNameQualified, String accessorName, int generationKind ) {

        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                code.append( "public " + packageNameQualified + " " + accessorName + "();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.CLASS:
                // DON'T correct the name -> must be found!
                code.append( "public " + packageNameQualified + " " + accessorName + "() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "  return (" + packageNameQualified + ") refPackage(\"" + mofPackage.getName( ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
            default:
                throw new RuntimeException( );
        }
    }

    private void generatePackageTemplateClusteredPackage( StringBuffer code, MofPackage mofPackage, String packageNameQualified, String accessorName, int generationKind ) {

        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                code.append( "public " + packageNameQualified + " " + accessorName + "();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.CLASS:
                // DON'T correct the name -> must be found!
                code.append( "public " + packageNameQualified + " " + accessorName + "() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "  return (" + packageNameQualified + ") refPackage(\"" + mofPackage.getName( ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
            default:
                throw new RuntimeException( );
        }
    }

    private void generateClassTemplate( StringBuffer code, MofClass mofClass, String classNameQualified, String accessorName, int generationKind ) {

        if ( generationKind != Generator.GenerationKind.INTERFACE || mofClass.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
            switch ( generationKind ) {
                case Generator.GenerationKind.INTERFACE:
                    code.append( "public " + classNameQualified + " " + accessorName + "();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    break;
                case Generator.GenerationKind.CLASS:
                    // DON'T correct the name -> must be found!
                    code.append( "public " + classNameQualified + " " + accessorName + "() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "  return (" + classNameQualified + ") refClass(\"" + mofClass.getName( ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    break;
                case Generator.GenerationKind.WRAPPER:
                    // TODO JMI WRAPPER
                    break;
                default:
                    throw new RuntimeException( );
            }
        }
    }

    private void generateAssociationTemplate( StringBuffer code, Association association, String associationNameQualified, String accessorName, int generationKind ) {

        if ( generationKind != Generator.GenerationKind.INTERFACE || association.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
            switch ( generationKind ) {
                case Generator.GenerationKind.INTERFACE:
                    code.append( "public " + associationNameQualified + " " + accessorName + "();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    break;
                case Generator.GenerationKind.CLASS:
                    // DON'T correct the name -> must be found!
                    code.append( "public " + associationNameQualified + " " + accessorName + "() {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "  return (" + associationNameQualified + ") refAssociation(\"" + association.getName( ) + "\");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    break;
                case Generator.GenerationKind.WRAPPER:
                    // TODO JMI WRAPPER
                    break;
                default:
                    throw new RuntimeException( );
            }
        }
    }
}