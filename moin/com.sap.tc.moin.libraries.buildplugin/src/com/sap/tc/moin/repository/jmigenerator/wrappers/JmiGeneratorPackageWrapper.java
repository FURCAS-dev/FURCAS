package com.sap.tc.moin.repository.jmigenerator.wrappers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.EnumerationTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ImportInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofExceptionInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeInternal;
import javax.swing.tree.TreeNode;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorMofType;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorDescriptorConstant;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorPackageFeature;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorParameter;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorFeatureExtendedImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorPackageImplTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorPackageInterfaceInternalTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorPackageInterfaceTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorPackageWrapperTemplateImpl;
import com.sap.tc.moin.repository.jmigenerator.template.impl.JmiGeneratorParameterImpl;
import com.sap.tc.moin.repository.shared.util.Utilities;

/**
 * @author d022737
 */
public class JmiGeneratorPackageWrapper extends JmiGeneratorClassOrPackageWrapper {

    private final MofPackage wrappedPackage;

    /**
     * Constructs the wrapper in the context of the generator
     * 
     * @param mofPackage
     * @param parent
     * @param generator
     */
    public JmiGeneratorPackageWrapper( CoreConnection connection, String metamodelName, MofPackage mofPackage, TreeNode parent, JmiGeneratorImpl generator ) {

        super( connection, metamodelName, mofPackage, parent, generator );
        this.wrappedPackage = mofPackage;
    }

    /**
     * Constructs the wrapper in the context of the Generator
     * 
     * @param mofPackage
     * @param generator
     */
    public JmiGeneratorPackageWrapper( CoreConnection connection, String metamodelName, MofPackage mofPackage, JmiGeneratorImpl generator ) {

        this( connection, metamodelName, mofPackage, null, generator );
    }

    @Override
    protected synchronized void initChildren( ) {

        if ( !this.childrenInitialized ) {
            Iterator<ModelElement> myChildren = this.getAllContent( );
            for ( ; myChildren.hasNext( ); ) {
                ModelElementInternal me = (ModelElementInternal) myChildren.next( );
                if ( me instanceof ImportInternal ) {
                    ImportInternal imp = (ImportInternal) me;
                    if ( imp.isClustered( ) ) {
                        NamespaceInternal ns = (NamespaceInternal) ( (ImportInternal) me ).getImportedNamespace( connection );
                        JmiGeneratorPackageWrapper child = (JmiGeneratorPackageWrapper) getOrCreateWrapper( ns );
                        child.setParent( this );
                        this.children.add( child );
                    }
                }
                if ( me instanceof MofPackageInternal ) {
                    JmiGeneratorPackageWrapper child = (JmiGeneratorPackageWrapper) getOrCreateWrapper( me );
                    child.setParent( this );
                    this.children.add( child );
                }
                if ( me instanceof MofClassInternal ) {
                    JmiGeneratorClassWrapper child = (JmiGeneratorClassWrapper) getOrCreateWrapper( me );
                    child.setParent( this );
                    this.children.add( child );
                }
                if ( me instanceof AssociationInternal ) {
                    JmiGeneratorAssociationWrapper child = (JmiGeneratorAssociationWrapper) getOrCreateWrapper( me );
                    child.setParent( this );
                    this.children.add( child );
                }
                if ( me instanceof EnumerationTypeInternal ) {
                    JmiGeneratorEnumWrapper child = (JmiGeneratorEnumWrapper) getOrCreateWrapper( me );
                    child.setParent( this );
                    this.children.add( child );
                }
                if ( me instanceof StructureTypeInternal ) {
                    JmiGeneratorStructureTypeWrapper child = (JmiGeneratorStructureTypeWrapper) getOrCreateWrapper( me );
                    child.setParent( this );
                    this.children.add( child );
                }
                if ( me instanceof MofExceptionInternal ) {
                    JmiGeneratorExceptionWrapper child = (JmiGeneratorExceptionWrapper) getOrCreateWrapper( me );
                    child.setParent( this );
                    this.children.add( child );
                }
            }
            this.childrenInitialized = true;
        }
    }

    private String getJavaInterfaceName( ) {

        return getJMIIdentifier( ) + EXTENSION_PACKAGE;
    }

    private String getJavaInterfaceNameQualified( ) {

        return getJavaPackageNameQualified( JmiGenerationKind.INTERFACE ) + Utilities.JAVA_PACKAGE_DELIMITER + getJavaInterfaceName( );
    }

    @Override
    public String getJavaClassName( JmiGenerationKind genKind, boolean qualified ) {

        StringBuilder sb = new StringBuilder( );
        if ( qualified ) {
            sb.append( getJavaPackageNameQualified( genKind ) );
            sb.append( Utilities.JAVA_PACKAGE_DELIMITER );
        }
        switch ( genKind ) {
            case INTERFACE:
                sb.append( getJavaInterfaceName( ) );
                return sb.toString( );

            case CLASS:
                sb.append( getJavaInterfaceName( ) + EXTENSION_IMPLEMENTATION );
                return sb.toString( );

            case WRAPPER:
                sb.append( getJavaInterfaceName( ) + EXTENSION_WRAPPER );
                return sb.toString( );
            default:
                throw new MoinUnsupportedOperationException( "getJavaClassName" ); //$NON-NLS-1$

        }

    }

    @Override
    public List<String> getTemplateNames( JmiGenerationKind genKind ) {

        List<String> result = new ArrayList<String>( );
        switch ( genKind ) {
            case INTERFACE:
                result.add( "PackageInterface" ); //$NON-NLS-1$
                break;
            case CLASS:
                result.add( "PackageClass" ); //$NON-NLS-1$
                if ( isMofModelElement( ) ) {
                    result.add( "PackageInterfaceInternal" ); //$NON-NLS-1$
                }
                break;
            case WRAPPER:
                result.add( "PackageWrapper" ); //$NON-NLS-1$
                break;
            default:
                break;
        }

        return result;
    }

    @Override
    public JmiGeneratorMofType getMofType( ) {

        return JmiGeneratorMofType.PACKAGE;
    }

    @Override
    public List<String> getExtends( JmiGenerationKind genKind, boolean qualified ) {

        List<String> result = new ArrayList<String>( );
        if ( genKind == JmiGenerationKind.CLASS ) {
            if ( qualified ) {
                result.add( CLASS_REFPACKAGEIMPL );
            } else {
                result.add( CLASS_REFPACKAGEIMPL.substring( CLASS_REFPACKAGEIMPL.lastIndexOf( '.' ) + 1 ) );
            }
        } else if ( genKind == JmiGenerationKind.INTERFACE ) {
            List<String> qnames = new ArrayList<String>( );
            JmiList<ModelElement> stypes = (JmiList) ( (MofPackageInternal) this.wrappedPackage ).getSupertypes( connection );

            for ( Iterator<ModelElement> iterator = stypes.iteratorReadOnly( connection.getSession( ) ); iterator.hasNext( ); ) {
                ModelElementInternal st = (ModelElementInternal) iterator.next( );
                qnames.add( ( getOrCreateWrapper( st ) ).getJavaClassName( JmiGenerationKind.INTERFACE, true ) );
            }
            if ( qnames.isEmpty( ) ) {
                qnames.add( CLASS_REFPACKAGEAPI );
            }
            if ( qualified ) {
                result.addAll( qnames );
            } else {
                for ( String qname : qnames ) {
                    result.add( qname.substring( qname.lastIndexOf( '.' ) + 1 ) );
                }
            }
        } else {
            throw new MoinUnsupportedOperationException( "getExtends" ); //$NON-NLS-1$
        }
        return result;
    }

    @Override
    public List<String> getImplements( JmiGenerationKind genKind, boolean qualified ) {

        List<String> result = new ArrayList<String>( );
        if ( genKind == JmiGenerationKind.CLASS ) {
            if ( qualified ) {
                if ( isMofModelElement( ) ) {
                    result.add( getJavaInterfaceNameQualified( ) );
                    String nameOfInternalInterface = getJavaClassName( JmiGenerationKind.CLASS, qualified );
                    nameOfInternalInterface = nameOfInternalInterface.substring( 0, nameOfInternalInterface.lastIndexOf( "Impl" ) ) + "Internal"; //$NON-NLS-1$  //$NON-NLS-2$
                    result.add( nameOfInternalInterface );
                }
            } else {
                result.add( getJavaInterfaceName( ) );
            }
        } else if ( genKind == JmiGenerationKind.INTERFACE ) {
            // nothing
        } else {
            throw new MoinUnsupportedOperationException( "getImplements" ); //$NON-NLS-1$
        }
        return result;
    }

    @Override
    public JmiGeneratorBaseTemplate getJavaTemplate( JmiGenerationKind genKind, String templateName ) {

        switch ( genKind ) {
            case INTERFACE:
                return new JmiGeneratorPackageInterfaceTemplateImpl( this );
            case CLASS:
                if ( templateName.equals( "PackageClass" ) ) { //$NON-NLS-1$
                    return new JmiGeneratorPackageImplTemplateImpl( this );
                } else if ( templateName.equals( "PackageInterfaceInternal" ) ) { //$NON-NLS-1$
                    return new JmiGeneratorPackageInterfaceInternalTemplateImpl( this );
                }
                throw new MoinUnsupportedOperationException( "getJavaTemplate" ); //$NON-NLS-1$
            case WRAPPER:
                return new JmiGeneratorPackageWrapperTemplateImpl( this );
            default:
                throw new MoinUnsupportedOperationException( "getJavaTemplate" ); //$NON-NLS-1$
        }
    }

    /**
     * @param genKind
     * @return the RefClasses
     */
    public List<JmiGeneratorPackageFeature> getRefClasses( JmiGenerationKind genKind ) {

        List<JmiGeneratorPackageFeature> result = new ArrayList<JmiGeneratorPackageFeature>( );
        Iterator<ModelElement> myChildren = this.getAllContent( );
        List<String> featureIds = getFeatureIds( );

        for ( ; myChildren.hasNext( ); ) {
            ModelElementInternal me = (ModelElementInternal) myChildren.next( );
            if ( me instanceof MofClass ) {
                MofClassInternal mc = (MofClassInternal) me;
                if ( genKind == JmiGenerationKind.INTERFACE ) {
                    if ( mc.getVisibility( ) != VisibilityKindEnum.PUBLIC_VIS ) {
                        continue;
                    }
                }
                JmiGeneratorClassWrapper cw = (JmiGeneratorClassWrapper) getOrCreateWrapper( me );
                JmiGeneratorFeatureExtendedImpl feature = new JmiGeneratorFeatureExtendedImpl( cw );
                feature.setIndex( featureIds.indexOf( me.getName( ) ) );
                feature.setMofClass( true );
                feature.setMofClassAbstract( mc.isAbstract( ) );
                result.add( feature );
            }
        }
        return result;
    }

    /**
     * @return the RefPackages
     */
    public List<JmiGeneratorPackageFeature> getRefPackages( ) {

        List<JmiGeneratorPackageFeature> result = new ArrayList<JmiGeneratorPackageFeature>( );
        List<Namespace> packagesToCheck = new ArrayList<Namespace>( );
        List<String> featureIds = getFeatureIds( );

        packagesToCheck.add( this.wrappedPackage );
        for ( Object obj : ( (MofPackageInternal) this.wrappedPackage ).allSupertypes( connection ) ) {
            if ( obj instanceof Namespace ) {
                packagesToCheck.add( (Namespace) obj );
            }
        }

        for ( Namespace ns : packagesToCheck ) {
            JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (NamespaceInternal) ns ).getContents( connection );
            for ( Iterator<ModelElement> iterator = contents.iteratorReadOnly( connection.getSession( ) ); iterator.hasNext( ); ) {
                ModelElementInternal me = (ModelElementInternal) iterator.next( );
                if ( me instanceof MofPackageInternal ) {
                    JmiGeneratorPackageWrapper pw = (JmiGeneratorPackageWrapper) getOrCreateWrapper( me );
                    JmiGeneratorFeatureExtendedImpl feature = new JmiGeneratorFeatureExtendedImpl( pw, false );
                    feature.setIndex( featureIds.indexOf( me.getName( ) ) );
                    result.add( feature );
                } else if ( me instanceof ImportInternal && ( (ImportInternal) me ).isClustered( ) ) {
                    ImportInternal im = (ImportInternal) me;
                    JmiGeneratorImportWrapper pw = (JmiGeneratorImportWrapper) getOrCreateWrapper( im );
                    JmiGeneratorFeatureExtendedImpl feature = new JmiGeneratorFeatureExtendedImpl( pw, true );
                    feature.setIndex( featureIds.indexOf( me.getName( ) ) );
                    result.add( feature );
                }
            }
        }
        return result;
    }

    /**
     * @return the RefAssociations
     */
    public List<JmiGeneratorPackageFeature> getRefAssociations( ) {

        List<JmiGeneratorPackageFeature> result = new ArrayList<JmiGeneratorPackageFeature>( );
        Iterator<ModelElement> myChildren = this.getAllContent( );
        List<String> featureIds = getFeatureIds( );
        for ( ; myChildren.hasNext( ); ) {
            ModelElementInternal me = (ModelElementInternal) myChildren.next( );
            if ( me instanceof AssociationInternal ) {
                JmiGeneratorAssociationWrapper cw = (JmiGeneratorAssociationWrapper) getOrCreateWrapper( me );
                JmiGeneratorFeatureExtendedImpl feature = new JmiGeneratorFeatureExtendedImpl( cw );
                feature.setIndex( featureIds.indexOf( me.getName( ) ) );
                result.add( feature );
            }
        }
        return result;
    }

    private List<String> getFeatureIds( ) {

        List<String> featureIds = new ArrayList<String>( );

        List<Namespace> packagesToCheck = new ArrayList<Namespace>( );

        packagesToCheck.add( this.wrappedPackage );
        for ( Object obj : ( (MofPackageInternal) this.wrappedPackage ).allSupertypes( connection ) ) {
            if ( obj instanceof Namespace ) {
                packagesToCheck.add( (Namespace) obj );
            }
        }

        for ( Namespace ns : packagesToCheck ) {
            JmiList<ModelElement> contents = (JmiList) ( (NamespaceInternal) ns ).getContents( connection );
            Iterator<ModelElement> iterator = contents.iteratorReadOnly( connection.getSession( ) );
            for ( ; iterator.hasNext( ); ) {
                ModelElement me = iterator.next( );
                if ( me instanceof MofPackage ) {
                    featureIds.add( me.getName( ) );
                } else if ( me instanceof ImportInternal && ( (ImportInternal) me ).isClustered( ) ) {
                    ImportInternal im = (ImportInternal) me;
                    featureIds.add( im.getImportedNamespace( connection ).getName( ) );
                }
            }
        }

        Iterator<ModelElement> myChildren = this.getAllContent( );
        for ( ; myChildren.hasNext( ); ) {
            ModelElement me = myChildren.next( );
            if ( me instanceof MofClass ) {
                featureIds.add( me.getName( ) );
            }
            if ( me instanceof Association ) {
                featureIds.add( me.getName( ) );
            }
        }
        return featureIds;

    }

    /**
     * @param genKind
     * @return the features
     */
    public List<JmiGeneratorPackageFeature> getFeatures( JmiGenerationKind genKind ) {

        List<JmiGeneratorPackageFeature> result = new ArrayList<JmiGeneratorPackageFeature>( );
        result.addAll( this.getRefPackages( ) );
        result.addAll( this.getRefClasses( genKind ) );
        result.addAll( this.getRefAssociations( ) );
        return result;
    }

    /**
     * @param genKind
     * @return the Structures
     */
    public List<JmiGeneratorParameter> getStructs( JmiGenerationKind genKind ) {

        List<JmiGeneratorParameter> result = new ArrayList<JmiGeneratorParameter>( );
        switch ( genKind ) {
            case CLASS:
                Iterator<ModelElement> myChildren = this.getAllContent( );
                for ( ; myChildren.hasNext( ); ) {
                    ModelElementInternal me = (ModelElementInternal) myChildren.next( );
                    if ( me instanceof StructureTypeInternal ) {
                        final String type = getOrCreateWrapper( me ).getJavaClassName( JmiGenerationKind.CLASS, true );
                        final String name = me.getName( );
                        JmiGeneratorParameter p = new JmiGeneratorParameterImpl( name, type, null );
                        result.add( p );
                    }
                }
                break;

            default:
                break;
        }
        return result;
    }

    /**
     * @return the constant for the package extent descriptor
     */
    public JmiGeneratorDescriptorConstant getPackageExtentDescriptorConstant( ) {

        String type = "com.sap.tc.moin.repository.mmi.descriptors.PackageDescriptor<"; //$NON-NLS-1$
        type += this.getJavaClassName( JmiGenerationKind.INTERFACE, true );
        type += ">"; //$NON-NLS-1$

        return getExtentDescriptorConstant( "PACKAGE_DESCRIPTOR", type ); //$NON-NLS-1$
    }
}
