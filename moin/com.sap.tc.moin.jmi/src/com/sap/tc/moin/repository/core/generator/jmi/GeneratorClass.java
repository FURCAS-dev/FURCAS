package com.sap.tc.moin.repository.core.generator.jmi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import com.sap.tc.moin.repository.core.generator.jmi.javamodel.JavaSource;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.shared.util.Utilities;

@SuppressWarnings( { "unchecked", "nls" } )
public class GeneratorClass {

    // e.g. TagClass
    public static String getJavaInterfaceName( MofClass mofClass ) {

        return Generator.getJMIIdentifier( mofClass ) + Generator.EXTENSION_CLASS;
    }

    // e.g. javax.jmi.model.TagClass
    public static String getJavaInterfaceNameQualified( MofClass mofClass ) {

        return getJavaPackageNameQualifiedForInterface( mofClass ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaInterfaceName( mofClass );
    }

    // e.g. TagClassImpl
    public static String getJavaClassName( MofClass mofClass ) {

        return Generator.getJMIIdentifier( mofClass ) + Generator.EXTENSION_CLASS + Generator.EXTENSION_IMPLEMENTATION;
    }

    // e.g. javax.jmi.model.___impl.TagClassImpl
    public static String getJavaClassNameQualified( MofClass mofClass ) {

        return getJavaPackageNameQualifiedForClass( mofClass ) + GeneratorConstants.PACKAGE_DELIMITER + getJavaClassName( mofClass );
    }

    // e.g. javax.jmi.model
    public static String getJavaPackageNameQualifiedForInterface( MofClass mofClass ) {

        return Generator.getJMIPackageIdentifierQualified( mofClass );
    }

    // e.g. javax.jmi.model.___impl
    public static String getJavaPackageNameQualifiedForClass( MofClass mofClass ) {

        return Generator.getJMIPackageIdentifierQualified( mofClass ) + GeneratorConstants.PACKAGE_DELIMITER + Generator.PACKAGE_IMPLEMENTATION;
    }

    public JavaSource generateTemplate( MofClass mofClass, boolean noJavaDocs, int generationKind ) {

        StringBuffer code = new StringBuffer( 1000 );
        // content etc.
        List contents = mofClass.getContents( );
        Collection superTypesAll = Generator.getAllSupertypes( mofClass );
        List contentsAll = new LinkedList( );
        Iterator iter = superTypesAll.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof Namespace ) {
                contentsAll.addAll( ( (Namespace) me ).getContents( ) );
            }
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
                Generator.generateJavaAnnotationTemplateClass( code, mofClass );
                code.append( "public interface " + javaInterfaceName ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.CLASS:
                code.append( "public final class " + javaClassName ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
        // generalization
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                code.append( " extends RefClass " ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.CLASS:
                code.append( " extends " + Generator.JMI_IMPL_PACKAGE_REFLECT + ".RefClassImpl implements " + javaInterfaceNameQualified ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
        code.append( " {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // constructor & variables
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                // nothing to do
                break;
            case Generator.GenerationKind.CLASS:
                Generator.generateTemplateRefClassDecl( code, mofClass, javaClassName, generationKind );
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
        // create methods
        if ( !mofClass.isAbstract( ) ) {
            generateCreateTemplate( code, mofClass, generationKind );
        }
        // structure types
        code.append( "// each directly contained StructType with visibility = public_vis" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        iter = contents.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof StructureType ) {
                Generator.generateStructureTypeTemplate( code, (StructureType) me, generationKind );
            }
        }
        // classifier level attributes
        code.append( "// classifier level attributes" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        iter = contentsAll.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof Attribute ) {
                Attribute atr = (Attribute) me;
                if ( ScopeKindEnum.CLASSIFIER_LEVEL.equals( atr.getScope( ) ) ) {
                    Generator.getGeneratorAttributeTemplate( ).generateTemplate( code, atr, noJavaDocs, generationKind );
                }
            }
        }
        // classifier level operations
        code.append( "// classifier level operations" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        // remember most derived element only for each operation signature, keeping depth-first order as in contentsAll:
        LinkedHashMap mostDerivedOnly = new LinkedHashMap( ); // name->element
        iter = contentsAll.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            if ( me instanceof Operation ) {
                Operation op = (Operation) me;
                if ( ScopeKindEnum.CLASSIFIER_LEVEL.equals( op.getScope( ) ) ) {
                    mostDerivedOnly.put( Mof2JavaConverter.convertOperation2Method( (Operation) me ).getSignature( ), me );
                }
            }
        }
        List contentsOperations = new ArrayList( mostDerivedOnly.values( ) );
        iter = contentsOperations.iterator( );
        while ( iter.hasNext( ) ) {
            ModelElement me = (ModelElement) iter.next( );
            Generator.getGeneratorOperationTemplate( ).generateTemplate( code, (Operation) me, noJavaDocs, generationKind );
        }
        // special methods
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                // nothing to do
                break;
            case Generator.GenerationKind.CLASS:
                generateIsSingletonMethod( code, mofClass, generationKind );
                generateIsAbstractMethod( code, mofClass, generationKind );
                generateCreateInstanceMethod( code, mofClass, generationKind );
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
        // RefClass
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                // nothing to do
                break;
            case Generator.GenerationKind.CLASS:
                Generator.generateTemplateRefClass( code, mofClass, javaClassName, javaInterfaceNameQualified, generationKind );
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
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
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
        source.setCode( code.toString( ) );
        return source;
    }

    private void generateIsSingletonMethod( StringBuffer code, MofClass mofClass, int generationKind ) {

        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                // nothing to do
                break;
            case Generator.GenerationKind.CLASS:
                code.append( "// meta object is singleton" );
                code.append( Utilities.SystemLineSeparator );
                code.append( "// for performance reasons overwrite method" );
                code.append( Utilities.SystemLineSeparator );
                code.append( "public boolean is___Singleton() {" );
                code.append( Utilities.SystemLineSeparator );
                if ( mofClass.isSingleton( ) ) {
                    code.append( "  return true;" );
                } else {
                    code.append( "  return false;" );
                }
                code.append( Utilities.SystemLineSeparator );
                code.append( "}" );
                code.append( Utilities.SystemLineSeparator );
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
    }

    private void generateIsAbstractMethod( StringBuffer code, MofClass mofClass, int generationKind ) {

        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                // nothing to do
                break;
            case Generator.GenerationKind.CLASS:
                code.append( "// meta object is abstract" );
                code.append( Utilities.SystemLineSeparator );
                code.append( "// for performance reasons overwrite method" );
                code.append( Utilities.SystemLineSeparator );
                code.append( "public boolean is___Abstract() {" );
                code.append( Utilities.SystemLineSeparator );
                if ( mofClass.isAbstract( ) ) {
                    code.append( "  return true;" );
                } else {
                    code.append( "  return false;" );
                }
                code.append( Utilities.SystemLineSeparator );
                code.append( "}" );
                code.append( Utilities.SystemLineSeparator );
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
    }

    private void generateCreateInstanceMethod( StringBuffer code, MofClass mofClass, int generationKind ) {

        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                // nothing to do
                break;
            case Generator.GenerationKind.CLASS:
                code.append( "public RefObject get___Instance() throws javax.jmi.reflect.JmiException {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                if ( mofClass.isAbstract( ) ) {
                    code.append( "  // class is abstract, return null then" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "  return null;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                } else {
                    code.append( "  return new " + GeneratorInstance.getJavaClassNameQualified( mofClass ) + "();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                }
                code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
    }

    private void generateCreateTemplate( StringBuffer code, MofClass mofClass, int generationKind ) {

        List list = Generator.getAttributeList( mofClass, generationKind );
        // default creator
        code.append( "// default creator" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        String creatorName = Generator.getCreatorNameForInstance( mofClass );
        code.append( "public " + Generator.getJMIIdentifierQualified( mofClass ) + " " + creatorName + "()" ); //$NON-NLS-1$
        switch ( generationKind ) {
            case Generator.GenerationKind.INTERFACE:
                code.append( " throws javax.jmi.reflect.JmiException;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.CLASS:
                code.append( " throws javax.jmi.reflect.JmiException {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "  return (" + GeneratorInstance.getJavaClassNameQualified( mofClass ) + ")refCreateInstance(null);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                break;
            case Generator.GenerationKind.WRAPPER:
                // TODO implement the wrapper generation
                break;
            default:
                // TODO proper exception here
                throw new RuntimeException( );
        }
        // creator with non-derived attributes
        code.append( "// specific creator" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
        if ( list.size( ) > 0 ) {
            code.append( "public " + Generator.getJMIIdentifierQualified( mofClass ) + " " + creatorName + "(" ); //$NON-NLS-1$
            StringBuffer argumentList = new StringBuffer( );
            Iterator iter = list.iterator( );
            while ( iter.hasNext( ) ) {
                AttributeWithType awt = (AttributeWithType) iter.next( );
                argumentList.append( Generator.getAttributeType( awt.getAttribute( ) ) + " " + awt.getName( ) ); //$NON-NLS-1$
                if ( iter.hasNext( ) ) {
                    argumentList.append( ", " ); //$NON-NLS-1$
                }
            }
            code.append( argumentList + ")" ); //$NON-NLS-1$
            switch ( generationKind ) {
                case Generator.GenerationKind.INTERFACE:
                    code.append( " throws javax.jmi.reflect.JmiException;" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    break;
                case Generator.GenerationKind.CLASS:
                    code.append( " throws javax.jmi.reflect.JmiException {" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "  List parameterList = new ArrayList();" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    iter = list.iterator( );
                    while ( iter.hasNext( ) ) {
                        AttributeWithType awt = (AttributeWithType) iter.next( );
                        code.append( "  parameterList.add(" + Generator.getJavaTypeAsObject( Generator.getAttributeType( awt.getAttribute( ) ), awt.getName( ) ) + ");" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    }
                    code.append( "  return (" + GeneratorInstance.getJavaClassNameQualified( mofClass ) + ")refCreateInstance(parameterList);" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    code.append( "}" + Utilities.SystemLineSeparator ); //$NON-NLS-1$
                    break;
                case Generator.GenerationKind.WRAPPER:
                    // TODO implement the wrapper generation
                    break;
                default:
                    // TODO proper exception here
                    throw new RuntimeException( );
            }
        }
    }

    public static String getAttributeType( Attribute a ) {

        String type = null;
        if ( Generator.isJavaType( a.getType( ).getName( ) ) ) {
            // MOF PrimitiveType
            if ( a.getMultiplicity( ).getLower( ) == 0 && a.getMultiplicity( ).getUpper( ) == 1 ) {
                type = Generator.getJavaTypeClass( Generator.getType( a.getType( ) ) );
            } else if ( a.getMultiplicity( ).getLower( ) == 1 && a.getMultiplicity( ).getUpper( ) == 1 ) {
                type = Generator.getType( a.getType( ) );
            } else {
                if ( a.getMultiplicity( ).isOrdered( ) ) {
                    type = "java.util.List"; //$NON-NLS-1$
                } else {
                    type = "java.util.Collection"; //$NON-NLS-1$
                }
            }
        } else {
            // NOT MOF PrimitiveType
            if ( a.getMultiplicity( ).getLower( ) == 0 && a.getMultiplicity( ).getUpper( ) == 1 ) {
                type = Generator.getType( a.getType( ) );
            } else if ( a.getMultiplicity( ).getLower( ) == 1 && a.getMultiplicity( ).getUpper( ) == 1 ) {
                type = Generator.getType( a.getType( ) );
            } else {
                if ( a.getMultiplicity( ).isOrdered( ) ) {
                    type = "java.util.List"; //$NON-NLS-1$
                } else {
                    type = "java.util.Collection"; //$NON-NLS-1$
                }
            }
        }
        return type;
    }
}