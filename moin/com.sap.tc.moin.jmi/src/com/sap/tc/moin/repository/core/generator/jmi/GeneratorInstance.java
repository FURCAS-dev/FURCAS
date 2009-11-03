package com.sap.tc.moin.repository.core.generator.jmi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import com.sap.tc.moin.repository.core.generator.jmi.javamodel.JavaSource;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.shared.util.Utilities;

@SuppressWarnings( { "unchecked", "nls" } )
public class GeneratorInstance {

    // e.g. Tag
    public static String getJavaInterfaceName( MofClass mofClass ) {

        return Generator.getJMIIdentifier( mofClass );
    }

    // e.g. javax.jmi.model.Tag
    public static String getJavaInterfaceNameQualified( MofClass mofClass ) {

        return getJavaPackageNameQualifiedForInterface( mofClass ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaInterfaceName( mofClass );
    }

    // e.g. TagImpl
    public static String getJavaClassName( MofClass mofClass ) {

        return Generator.getJMIIdentifier( mofClass ) + Generator.EXTENSION_IMPLEMENTATION;
    }

    // e.g. javax.jmi.model.___impl.TagImpl
    public static String getJavaClassNameQualified( MofClass mofClass ) {

        return getJavaPackageNameQualifiedForClass( mofClass ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaClassName( mofClass );
    }

    // e.g. javax.jmi.model
    public static String getJavaPackageNameQualifiedForInterface( MofClass mofClass ) {

        return GeneratorClass.getJavaPackageNameQualifiedForInterface( mofClass );
    }

    // e.g. javax.jmi.model.___impl
    public static String getJavaPackageNameQualifiedForClass( MofClass mofClass ) {

        return GeneratorClass.getJavaPackageNameQualifiedForClass( mofClass );
    }

    public JavaSource generateTemplate( MofClass mofClass, boolean noJavaDocs, int generationKind ) {

        StringBuffer code = new StringBuffer( 1000 );
        // Don't generated Java class for abstract classes
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                break;
            case Generator.GenerationKind.CLASS:
            case Generator.GenerationKind.WRAPPER:
                if ( mofClass.isAbstract( ) ) {
                    return null;
                }
                break;
            default:
                throw new RuntimeException( );
        }
        // content etc.
        List contents = mofClass.getContents( );
        List superTypesAll = mofClass.allSupertypes( );
        List contentsAll = new ArrayList( );
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                break;
            case Generator.GenerationKind.CLASS:
            case Generator.GenerationKind.WRAPPER:
                Iterator i = superTypesAll.iterator( );
                while ( i.hasNext( ) ) {
                    ModelElement me = (ModelElement) i.next( );
                    if ( me instanceof Namespace ) {
                        contentsAll.addAll( ( (Namespace) me ).getContents( ) );
                    }
                }
                break;
            default:
                throw new RuntimeException( );
        }
        contentsAll.addAll( contents );
        // important names
        String javaInterfaceName = getJavaInterfaceName( mofClass );
        String javaInterfaceNameQualified = getJavaInterfaceNameQualified( mofClass );
        String javaPackageNameForInterface = getJavaPackageNameQualifiedForInterface( mofClass );
        String javaClassName = getJavaClassName( mofClass );
        String javaClassNameQualified = getJavaClassNameQualified( mofClass );
        String javaPackageNameForClass = getJavaPackageNameQualifiedForClass( mofClass );
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
        Generator.generateDefaultIncludes( code, mofClass, generationKind );
        // Java doc template
        if ( !noJavaDocs ) {
            Generator.generateAnnotationTemplate( code, mofClass );
        }
        // interface/class header
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                // Java annotation template
                Generator.generateJavaAnnotationTemplateInstance( code, mofClass );
                code.append( "public interface " + javaInterfaceName ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.CLASS:
                // "final" not possible here because in the case of MOF the MOF ROM subclasses some generated classes
                code.append( "public class " + javaClassName ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
            default:
                throw new RuntimeException( );
        }
        Iterator iter = contentsAll.iterator( );
        // generalization
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                code.append( " extends " ); //$NON-NLS-1$
                List superTypes = mofClass.getSupertypes( );
                iter = superTypes.iterator( );
                if ( !( iter.hasNext( ) ) ) {
                    code.append( "RefObject" ); //$NON-NLS-1$
                } else {
                    while ( iter.hasNext( ) ) {
                        Classifier type = (Classifier) iter.next( );
                        code.append( Generator.getJMIIdentifierQualified( type ) );
                        if ( iter.hasNext( ) ) {
                            code.append( ", " ); //$NON-NLS-1$
                        }
                    }
                }
                break;
            case Generator.GenerationKind.CLASS:
                code.append( " extends " + Generator.JMI_IMPL_PACKAGE_REFLECT + ".RefObjectImpl implements " + javaInterfaceNameQualified ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
            default:
                throw new RuntimeException( );
        }
        code.append( " {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // constructor & variables
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                break;
            case Generator.GenerationKind.CLASS:
            case Generator.GenerationKind.WRAPPER:
                Generator.generateTemplateRefObjectDecl( code, mofClass, javaClassName, generationKind );
                break;
            default:
                throw new RuntimeException( );
        }
        // constant template
        code.append( "// constants" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        iter = contents.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof Constant ) {
                Generator.getGeneratorConstantTemplate( ).generateTemplate( code, (Constant) me, noJavaDocs, generationKind );
            }
        }
        // instance level attributes
        List listAttributes = new ArrayList( );
        code.append( "// instance level attributes" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                iter = contents.iterator( );
                break;
            case Generator.GenerationKind.CLASS:
                iter = contentsAll.iterator( );
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
            default:
                throw new RuntimeException( );
        }
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof Attribute ) {
                if ( ScopeKindEnum.INSTANCE_LEVEL.equals( ( (Attribute) me ).getScope( ) ) ) {
                    listAttributes.add( me );
                    Generator.getGeneratorAttributeTemplate( ).generateTemplate( code, (Attribute) me, noJavaDocs, generationKind );
                }
            }
        }
        // instance level references
        code.append( "// instance level references" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                iter = contents.iterator( );
                break;
            case Generator.GenerationKind.CLASS:
                iter = contentsAll.iterator( );
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
            default:
                throw new RuntimeException( );
        }
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof Reference ) {
                if ( ScopeKindEnum.INSTANCE_LEVEL.equals( ( (Reference) me ).getScope( ) ) ) {
                    Generator.getGeneratorReferenceTemplate( ).generateTemplate( code, (Reference) me, noJavaDocs, generationKind );
                }
            }
        }
        // instance level operations
        code.append( "// instance level operations" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        List contentsOperations = new ArrayList( );
        // remember most derived element only for each operation signature, keeping depth-first order as in contentsAll:
        LinkedHashMap mostDerivedOnly = new LinkedHashMap( ); // name->element
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                for ( Iterator i = contents.iterator( ); i.hasNext( ); ) {
                    ModelElement me = (ModelElement) i.next( );
                    if ( me instanceof Operation ) {
                        mostDerivedOnly.put( Mof2JavaConverter.convertOperation2Method( (Operation) me ).getSignature( ), me );
                    }
                }
                contentsOperations.addAll( mostDerivedOnly.values( ) );
                break;
            case Generator.GenerationKind.CLASS:
                for ( Iterator i = contentsAll.iterator( ); i.hasNext( ); ) {
                    ModelElement me = (ModelElement) i.next( );
                    if ( me instanceof Operation ) {
                        mostDerivedOnly.put( Mof2JavaConverter.convertOperation2Method( (Operation) me ).getSignature( ), me );
                    }
                }
                contentsOperations.addAll( mostDerivedOnly.values( ) );
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO JMI WRAPPER
                break;
            default:
                throw new RuntimeException( );
        }
        iter = contentsOperations.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( ScopeKindEnum.INSTANCE_LEVEL.equals( ( (Operation) me ).getScope( ) ) ) {
                Generator.getGeneratorOperationTemplate( ).generateTemplate( code, (Operation) me, noJavaDocs, generationKind );
            }
        }
        // RefObject
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                break;
            case Generator.GenerationKind.CLASS:
            case Generator.GenerationKind.WRAPPER:
                Generator.generateTemplateRefObject( code, mofClass, javaClassName, javaInterfaceNameQualified, listAttributes, generationKind );
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
}