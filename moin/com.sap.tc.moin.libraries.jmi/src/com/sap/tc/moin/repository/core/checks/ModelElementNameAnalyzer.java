package com.sap.tc.moin.repository.core.checks;

import static com.sap.tc.moin.repository.shared.util.Utilities.JAVA_PACKAGE_DELIMITER;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.NameViolation;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.NameViolation.NameViolationErrorCode;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.checks.ModelElementNameChecker.ErrorCode;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.spi.core.Wrapper;

public class ModelElementNameAnalyzer {

    public static final NameViolation analyzeModelElementNameCorrectness( Connection connection, ModelElement modelElement ) {

        if ( modelElement == null || ModelElementNameChecker.isEmptyMofModelElementName( modelElement.getName( ) ) || ModelElementNameChecker.isModelElementSpecialCase( modelElement ) ) {
            return null;
        }
        // unwrap
        ModelElement modelElementUnwrapped = unwrapObject( modelElement );
        CoreConnection connectionUnwrapped = (CoreConnection) unwrapObject( connection );
        // check the model element name
        String modelElementName = modelElementUnwrapped.getName( );
        List<Object> objectsInError = new ArrayList<Object>( );
        ErrorCode errorCode = ModelElementNameChecker.analyzeMoinModelElementName( modelElementName, false, objectsInError );
        if ( errorCode != null ) {
            switch ( errorCode ) {
                case IS_NULL:
                    return new NameViolationImpl( NameViolationErrorCode.MODEL_ELEMENT_NAME_IS_NULL, objectsInError, CoreChecks.NAMEOFXISNULL, modelElementToString( connectionUnwrapped, modelElementUnwrapped ) );
                case LENGTH_IS_NULL:
                    return new NameViolationImpl( NameViolationErrorCode.MODEL_ELEMENT_NAME_LENGTH_IS_NULL, objectsInError, CoreChecks.NAMELENGTHOFXISNULL, modelElementToString( connectionUnwrapped, modelElementUnwrapped ) );
                case FIRST_CHAR_IS_NOT_LETTER:
                    return new NameViolationImpl( NameViolationErrorCode.MODEL_ELEMENT_NAME_FIRST_CHAR_IS_NOT_LETTER, objectsInError, CoreChecks.FIRSTCHAROFNAMEXOFXISNOTLETTER, modelElementName, modelElementToString( connectionUnwrapped, modelElementUnwrapped ) );
                case CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE:
                    return new NameViolationImpl( NameViolationErrorCode.MODEL_ELEMENT_NAME_CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE, objectsInError, CoreChecks.CHARXOFNAMEXOFXISNOTLETTERDIGITUNDERSCORE, objectsInError.get( 2 ), modelElementName, modelElementToString( connectionUnwrapped,
                                                                                                                                                                                                                                                                        modelElementUnwrapped ) );
                case CHAR_IS_NOT_ASCII:
                    return new NameViolationImpl( NameViolationErrorCode.MODEL_ELEMENT_NAME_CHAR_IS_NOT_ASCII, objectsInError, CoreChecks.CHARXOFNAMEXOFXISNOTASCII, objectsInError.get( 2 ), modelElementName, modelElementToString( connectionUnwrapped, modelElementUnwrapped ) );
                case IS_JAVA_KEYWORD:
                    return new NameViolationImpl( NameViolationErrorCode.MODEL_ELEMENT_NAME_IS_JAVA_KEYWORD, objectsInError, CoreChecks.NAMEXOFXISJAVAKEYWORD, modelElementName, modelElementToString( connectionUnwrapped, modelElementUnwrapped ) );
            }
        }
        return null;
    }

    public static final NameViolation analyzeEnumerationLabelNameCorrectness( Connection connection, EnumerationType enumeration ) {

        if ( enumeration == null || ModelElementNameChecker.isEmptyMofModelElementName( enumeration.getName( ) ) || ModelElementNameChecker.isModelElementSpecialCase( enumeration ) ) {
            return null;
        }
        // unwrap
        EnumerationType enumerationUnwrapped = unwrapObject( enumeration );
        CoreConnection connectionUnwrapped = (CoreConnection) unwrapObject( connection );
        // check the enumeration label names
        List<String> labels = enumerationUnwrapped.getLabels( );
        if ( labels != null ) {
            List<Object> objectsInError = new ArrayList<Object>( );
            for ( int i = 0; i < labels.size( ); i++ ) {
                String label = labels.get( i );
                // enable white space check when all customer metamodels are adapted, MM
                ErrorCode errorCode = ModelElementNameChecker.analyzeMoinModelElementName( label, true, objectsInError );
                if ( errorCode != null ) {
                    switch ( errorCode ) {
                        case IS_NULL:
                            return new NameViolationImpl( NameViolationErrorCode.ENUMERATION_LABEL_IS_NULL, objectsInError, CoreChecks.LABELOFXISNULL, modelElementToString( connectionUnwrapped, enumeration ) );
                        case LENGTH_IS_NULL:
                            return new NameViolationImpl( NameViolationErrorCode.ENUMERATION_LABEL_LENGTH_IS_NULL, objectsInError, CoreChecks.LABELLENGTHOFXISNULL, modelElementToString( connectionUnwrapped, enumeration ) );
                        case FIRST_CHAR_IS_NOT_LETTER:
                            return new NameViolationImpl( NameViolationErrorCode.ENUMERATION_LABEL_FIRST_CHAR_IS_NOT_LETTER, objectsInError, CoreChecks.FIRSTCHAROFLABELXOFXISNOTLETTER, label, modelElementToString( connectionUnwrapped, enumeration ) );
                        case CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE:
                            return new NameViolationImpl( NameViolationErrorCode.ENUMERATION_LABEL_CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE, objectsInError, CoreChecks.CHARXOFLABELXOFXISNOTLETTERDIGITUNDERSCORE, objectsInError.get( 2 ), label, modelElementToString( connectionUnwrapped, enumeration ) );
                        case CHAR_IS_NOT_ASCII:
                            return new NameViolationImpl( NameViolationErrorCode.ENUMERATION_LABEL_CHAR_IS_NOT_ASCII, objectsInError, CoreChecks.CHARXOFLABELXOFXISNOTASCII, objectsInError.get( 2 ), label, modelElementToString( connectionUnwrapped, enumeration ) );
                        case IS_JAVA_KEYWORD:
                            // enable Java keyword check when all customer metamodels are adapted, MM
//                            return new NameViolationImpl( NameViolationErrorCode.ENUMERATION_LABEL_IS_JAVA_KEYWORD, objectsInError, CoreChecks.LABELXOFXISJAVAKEYWORD, label, modelElementToString( enumeration ) );
                            return null;
                    }
                }
            }
        }
        return null;
    }

    public static final NameViolation analyzeModelElementNameCorrectness( String modelElementName ) {

        // check the model element name
        List<Object> objectsInError = new ArrayList<Object>( );
        ErrorCode errorCode = ModelElementNameChecker.analyzeMoinModelElementName( modelElementName, false, objectsInError );
        if ( errorCode != null ) {
            switch ( errorCode ) {
                case IS_NULL:
                    return new NameViolationImpl( NameViolationErrorCode.MODEL_ELEMENT_NAME_IS_NULL, objectsInError, CoreChecks.NAMEISNULL );
                case LENGTH_IS_NULL:
                    return new NameViolationImpl( NameViolationErrorCode.MODEL_ELEMENT_NAME_LENGTH_IS_NULL, objectsInError, CoreChecks.NAMELENGTHISNULL );
                case FIRST_CHAR_IS_NOT_LETTER:
                    return new NameViolationImpl( NameViolationErrorCode.MODEL_ELEMENT_NAME_FIRST_CHAR_IS_NOT_LETTER, objectsInError, CoreChecks.FIRSTCHAROFNAMEXISNOTLETTER, modelElementName );
                case CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE:
                    return new NameViolationImpl( NameViolationErrorCode.MODEL_ELEMENT_NAME_CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE, objectsInError, CoreChecks.CHARXOFNAMEXISNOTLETTERDIGITUNDERSCORE, objectsInError.get( 2 ), modelElementName );
                case CHAR_IS_NOT_ASCII:
                    return new NameViolationImpl( NameViolationErrorCode.MODEL_ELEMENT_NAME_CHAR_IS_NOT_ASCII, objectsInError, CoreChecks.CHARXOFNAMEXISNOTASCII, objectsInError.get( 2 ), modelElementName );
                case IS_JAVA_KEYWORD:
                    return new NameViolationImpl( NameViolationErrorCode.MODEL_ELEMENT_NAME_IS_JAVA_KEYWORD, objectsInError, CoreChecks.NAMEXISJAVAKEYWORD, modelElementName );
            }
        }
        return null;
    }

    public static final NameViolation analyzeEnumerationLabelNameCorrectness( String label ) {

        // check the enumeration label names
        List<Object> objectsInError = new ArrayList<Object>( );
        ErrorCode errorCode = ModelElementNameChecker.analyzeMoinModelElementName( label, true, objectsInError );
        if ( errorCode != null ) {
            switch ( errorCode ) {
                case IS_NULL:
                    return new NameViolationImpl( NameViolationErrorCode.ENUMERATION_LABEL_IS_NULL, objectsInError, CoreChecks.LABELISNULL );
                case LENGTH_IS_NULL:
                    return new NameViolationImpl( NameViolationErrorCode.ENUMERATION_LABEL_LENGTH_IS_NULL, objectsInError, CoreChecks.LABELLENGTHISNULL );
                case FIRST_CHAR_IS_NOT_LETTER:
                    return new NameViolationImpl( NameViolationErrorCode.ENUMERATION_LABEL_FIRST_CHAR_IS_NOT_LETTER, objectsInError, CoreChecks.FIRSTCHAROFLABELXISNOTLETTER, label );
                case CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE:
                    return new NameViolationImpl( NameViolationErrorCode.ENUMERATION_LABEL_CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE, objectsInError, CoreChecks.CHARXOFLABELXISNOTLETTERDIGITUNDERSCORE, objectsInError.get( 2 ), label );
                case CHAR_IS_NOT_ASCII:
                    return new NameViolationImpl( NameViolationErrorCode.ENUMERATION_LABEL_CHAR_IS_NOT_ASCII, objectsInError, CoreChecks.CHARXOFLABELXISNOTASCII, objectsInError.get( 2 ), label );
                case IS_JAVA_KEYWORD:
                    // enable Java keyword check when all customer metamodels are adapted, MM
//                    return new NameViolationImpl( NameViolationErrorCode.ENUMERATION_LABEL_IS_JAVA_KEYWORD, objectsInError, CoreChecks.LABELXISJAVAKEYWORD, label );
                    return null;
            }
        }
        return null;
    }

    private static final NameViolation analyzeModelElementNameUniquenessInNamespace( CoreConnection connection, Namespace namespace, ModelElement modelElement, String modelElementName ) {

        if ( namespace == null || ModelElementNameChecker.isEmptyMofModelElementName( namespace.getName( ) ) || ModelElementNameChecker.isModelElementSpecialCase( namespace ) ) {
            return null;
        }
        if ( modelElement == null ) {
            if ( ModelElementNameChecker.isEmptyMofModelElementName( modelElementName ) ) {
                return null;
            }
        } else {
            if ( ModelElementNameChecker.isEmptyMofModelElementName( modelElement.getName( ) ) || ModelElementNameChecker.isModelElementSpecialCase( modelElement ) ) {
                return null;
            }
        }
        if ( modelElement != null && modelElement instanceof MofPackage ) {
            NameViolation nameViolation = analyzePackageNameUniquenessInPriList( connection, connection.getSession( ).getInnerPartitions( ( (Partitionable) modelElement ).get___Mri( ).getCri( ) ), (MofPackage) modelElement, null, null );
            if ( nameViolation != null ) {
                return nameViolation;
            }
        }
        // unwrap
        ModelElement modelElementUnwrapped = unwrapObject( modelElement );
        Namespace namespaceUnwrapped = unwrapObject( namespace );
        // names etc.
        String mName = modelElementName;
        String mJavaName = mName;
        if ( modelElementUnwrapped != null ) {
            mName = modelElementUnwrapped.getName( );
            mJavaName = connection.getCoreJmiHelper( ).getJMIIdentifier( connection, modelElementUnwrapped );
        }
        if ( ModelElementNameChecker.isEmptyMofModelElementName( mName ) ) {
            return null;
        }
        // for a GeneralizableElement take also the supertypes into account.
        // Note that for packages this content is not equals to the content of its extended namespace because the extended namespace
        // of a package also contains the imported namespaces.
        // For the JMI generation the imported namespace (an instance of Namespace) is not relevant (for the names of the getters for example).
        // The relevant model element for an import of a package or a class is the import itself (an instance of Import), which is already
        // part of the content of the package.
        ArrayList<ModelElement> namespaceContent = new ArrayList<ModelElement>( connection.getCoreJmiHelper( ).getAllContent( connection, namespaceUnwrapped ) );
        ArrayList<ModelElement> modelElementsInNamespace = new ArrayList<ModelElement>( namespaceContent.size( ) );
        for ( int i = 0; i < namespaceContent.size( ); i++ ) {
            ModelElement contentElement = namespaceContent.get( i );
            if ( contentElement != null && !ModelElementNameChecker.isEmptyMofModelElementName( contentElement.getName( ) ) ) {
                if ( !modelElementsInNamespace.contains( contentElement ) ) {
                    modelElementsInNamespace.add( contentElement );
                }
            }
        }
        if ( modelElementUnwrapped != null ) {
            modelElementsInNamespace.remove( modelElementUnwrapped );
        }
        modelElementsInNamespace.trimToSize( );
        // check model element name uniqueness
        List<Object> objectsInError = new ArrayList<Object>( );
        for ( int i = 0; i < modelElementsInNamespace.size( ); i++ ) {
            ModelElement modelElementInNamespace = modelElementsInNamespace.get( i );
            if ( mName.equals( modelElementInNamespace.getName( ) ) ) {
                // qualified name uniqueness of all model elements in the namespace
                // ensures unambiguous model element selection via the MOIN connection
                objectsInError.add( mName );
                if ( modelElementUnwrapped != null ) {
                    return new NameViolationImpl( NameViolationErrorCode.NAME_EXISTS_IN_NAMESPACE, objectsInError, CoreChecks.NAMEXOFXEXISTSFORXINNAMESPACEX, mName, modelElementToString( connection, modelElementUnwrapped ), modelElementToString( connection, modelElementInNamespace ),
                                                  modelElementToString( connection, namespace ) );
                } else {
                    return new NameViolationImpl( NameViolationErrorCode.NAME_EXISTS_IN_NAMESPACE, objectsInError, CoreChecks.NAMEXEXISTSFORXINNAMESPACEX, mName, modelElementToString( connection, modelElementInNamespace ), modelElementToString( connection, namespace ) );
                }
            } else {
                // Java name uniqueness of all model elements in the namespace
                String modelElementInNamespaceJavaName = connection.getCoreJmiHelper( ).getJMIIdentifier( connection, modelElementInNamespace );
                objectsInError.add( mJavaName );
                if ( mJavaName.equalsIgnoreCase( modelElementInNamespaceJavaName ) ) {
                    if ( modelElementUnwrapped != null ) {
                        return new NameViolationImpl( NameViolationErrorCode.JAVA_NAME_EXISTS_IN_NAMESPACE, objectsInError, CoreChecks.JAVANAMEXOFXEXISTSFORXINNAMESPACEX, mJavaName, modelElementToString( connection, modelElementUnwrapped ),
                                                      modelElementToString( connection, modelElementInNamespace ), modelElementToString( connection, namespace ) );
                    } else {
                        return new NameViolationImpl( NameViolationErrorCode.JAVA_NAME_EXISTS_IN_NAMESPACE, objectsInError, CoreChecks.JAVANAMEXEXISTSFORXINNAMESPACEX, mJavaName, modelElementToString( connection, modelElementInNamespace ), modelElementToString( connection, namespace ) );
                    }
                }
            }
        }
        return null;
    }

    public static final NameViolation analyzePackageNameUniquenessInPriList( CoreConnection connection, Collection<PRI> pris, MofPackage mofPackage, String packageName, String prefix ) {

        if ( mofPackage == null ) {
            if ( ModelElementNameChecker.isEmptyMofModelElementName( packageName ) ) {
                return null;
            }
        } else {
            if ( ModelElementNameChecker.isEmptyMofModelElementName( mofPackage.getName( ) ) || ModelElementNameChecker.isModelElementSpecialCase( mofPackage ) ) {
                return null;
            }
        }
        // unwrap
        MofPackage mofPackageUnwrapped = unwrapObject( mofPackage );
        // names etc.
        String pName = packageName;
        String qName = ( prefix != null ? prefix + "." : "" ) + pName; //$NON-NLS-1$ //$NON-NLS-2$
        String qJavaName = computeQualifiedJavaName( connection, pName, prefix );
        if ( mofPackageUnwrapped != null ) {
            pName = mofPackageUnwrapped.getName( );
            qName = QualifiedName.toDotSeparatedString( ( (MofPackageInternal) mofPackageUnwrapped ).getQualifiedName( connection ) );
            qJavaName = computeQualifiedJavaName( connection, mofPackageUnwrapped );
        }
        MQLProcessor mql = connection.getMQLProcessor( );
//        String query = "select p from Model::Package as p where for p(name = '" + packageName + "') where p.container not in (select p2 from Model::Package as p2)";
//        String query = "select p from Model::Package as p where p.container not in (select p2 from Model::Package as p2)";
        String query = "select p from Model::Package as p"; //$NON-NLS-1$
        // note that the container as query scope is not possible because the metamodel build works in an internal (transient) container
        // which contains all deployed metamodels and would therefore be too wide here
//        MQLResultSet resultSet = mql.execute( query, mql.getInclusiveCriScopeProvider( containerCri ) );
        MQLResultSet resultSet = mql.execute( query, mql.getInclusivePartitionScopeProvider( pris.toArray( new PRI[pris.size( )] ) ) );
        RefObject[] resultPackages = resultSet.getRefObjects( "p" ); //$NON-NLS-1$
        ArrayList<MofPackage> packages = new ArrayList<MofPackage>( resultPackages.length );
        for ( int i = 0; i < resultPackages.length; i++ ) {
            MofPackage resultPackage = (MofPackage) resultPackages[i];
            if ( resultPackage != null && !ModelElementNameChecker.isEmptyMofModelElementName( resultPackage.getName( ) ) ) {
                MofPackage packUnwrapped = unwrapObject( resultPackage );
                if ( !packages.contains( packUnwrapped ) ) {
                    packages.add( packUnwrapped );
                }
            }
        }
        if ( mofPackageUnwrapped != null ) {
            packages.remove( mofPackageUnwrapped );
        }
        packages.trimToSize( );
        // check package name uniqueness
        List<Object> objectsInError = new ArrayList<Object>( );
        for ( int i = 0; i < packages.size( ); i++ ) {
            MofPackage pkg = packages.get( i );
            String packageQualifiedName = QualifiedName.toDotSeparatedString( ( (MofPackageInternal) pkg ).getQualifiedName( connection ) );
            String containerName = ( (Partitionable) pkg ).get___Partition( ).getPri( ).getContainerName( );
            if ( qName.equals( packageQualifiedName ) ) {
                // qualified name uniqueness of all packages in a container
                // ensures unambiguous package selection via the MOIN connection
                objectsInError.add( pName );
                if ( mofPackageUnwrapped != null ) {
                    return new NameViolationImpl( NameViolationErrorCode.PACKAGE_NAME_EXISTS_IN_NAMESPACE, objectsInError, CoreChecks.PACKAGENAMEXOFXEXISTSFORXINCONTAINERX, pName, modelElementToString( connection, mofPackageUnwrapped ), modelElementToString( connection, pkg ), containerName );
                } else {
                    return new NameViolationImpl( NameViolationErrorCode.PACKAGE_NAME_EXISTS_IN_NAMESPACE, objectsInError, CoreChecks.PACKAGENAMEXEXISTSFORXINCONTAINERX, pName, modelElementToString( connection, pkg ), containerName );
                }
            } else {
                // Java name uniqueness of all packages in a container
                // e.g. package "com/sap.Mypackage" (subpackage of "com" with prefix "sap") would collide with "com.sap.MyPackage" (toplevel package with prefix "com.sap")
                String packageQualifiedJavaName = computeQualifiedJavaName( connection, pkg );
                objectsInError.add( qJavaName );
                if ( qJavaName.equalsIgnoreCase( packageQualifiedJavaName ) ) {
                    if ( mofPackageUnwrapped != null ) {
                        return new NameViolationImpl( NameViolationErrorCode.PACKAGE_JAVA_NAME_EXISTS_IN_NAMESPACE, objectsInError, CoreChecks.PACKAGEJAVANAMEXOFXEXISTSFORXINCONTAINERX, qJavaName, modelElementToString( connection, mofPackageUnwrapped ), modelElementToString( connection, pkg ),
                                                      containerName );
                    } else {
                        return new NameViolationImpl( NameViolationErrorCode.PACKAGE_JAVA_NAME_EXISTS_IN_NAMESPACE, objectsInError, CoreChecks.PACKAGEJAVANAMEXEXISTSFORXINCONTAINERX, qJavaName, modelElementToString( connection, pkg ), containerName );
                    }
                }
            }
        }
        return null;
    }

    public static final NameViolation analyzeModelElementNameUniquenessInNamespace( Connection connection, Namespace namespace, ModelElement modelElement, String modelElementName ) {

        return analyzeModelElementNameUniquenessInNamespace( (CoreConnection) unwrapObject( connection ), namespace, modelElement, modelElementName );
    }

    public static final NameViolation analyzeToplevelPackageNameUniquenessInContainer( Connection connection, CRI containerCri, String packageName, String prefix ) {

        return analyzePackageNameUniquenessInPriList( (CoreConnection) unwrapObject( connection ), connection.getSession( ).getInnerPartitions( containerCri ), null, packageName, prefix );
    }

    public static final NameViolation analyzeToplevelPackageNameUniquenessInContainer( Connection connection, CRI containerCri, MofPackage mofPackage ) {

        return analyzePackageNameUniquenessInPriList( (CoreConnection) unwrapObject( connection ), connection.getSession( ).getInnerPartitions( containerCri ), mofPackage, null, null );
    }

    public static final NameViolation analyzeToplevelPackageNameUniqueness( Connection connection, Collection<PRI> pris, MofPackage mofPackage ) {

        return analyzePackageNameUniquenessInPriList( (CoreConnection) unwrapObject( connection ), pris, mofPackage, null, null );
    }

    public static final boolean isValidModelElementName( Connection connection, ModelElement modelElement ) {

        return analyzeModelElementNameCorrectness( connection, modelElement ) == null;
    }

    private static final String computeQualifiedJavaName( CoreConnection connection, MofPackage mofPackage ) {

        String packageIdentifier = connection.getCoreJmiHelper( ).getJMIPackageIdentifierQualified( connection, mofPackage );
        return ( packageIdentifier.length( ) != 0 ? packageIdentifier + JAVA_PACKAGE_DELIMITER : "" ) + connection.getCoreJmiHelper( ).getJMIIdentifier( connection, mofPackage ); //$NON-NLS-1$
    }

    private static final String computeQualifiedJavaName( CoreConnection connection, String packageName, String prefix ) {

        String packageIdentifier = ( prefix != null && prefix.length( ) != 0 ) ? prefix.toLowerCase( Locale.ENGLISH ) : ""; //$NON-NLS-1$
        String qJavaName = ""; //$NON-NLS-1$
        qJavaName = connection.getCoreJmiHelper( ).correctName( packageName, false );
        qJavaName = ( packageIdentifier.length( ) != 0 ? packageIdentifier + JAVA_PACKAGE_DELIMITER : "" ) + qJavaName; //$NON-NLS-1$
        return qJavaName;
    }

    private static String modelElementToString( CoreConnection connection, ModelElement modelElement ) {

        ModelElementInternal unwrappedElement = (ModelElementInternal) unwrapObject( modelElement );

        return ( unwrappedElement ).getQualifiedName( connection ) + " (" + ( (ModelElement) unwrappedElement.refMetaObject( ) ).getName( ) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
    }

    @SuppressWarnings( "unchecked" )
    private static <T extends Object> T unwrapObject( T objectToUnwrap ) {

        if ( objectToUnwrap == null ) {
            return null;
        }
        if ( objectToUnwrap instanceof Wrapper ) {
            return ( (Wrapper<T>) objectToUnwrap ).unwrap( );
        } else {
            return objectToUnwrap;
        }
    }
}
