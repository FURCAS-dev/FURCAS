package com.sap.tc.moin.xm.generation.core.metamodel.om;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import org.eclipse.xsd.XSDContentTypeCategory;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.XmGeneratorInput;
import com.sap.tc.moin.xm.generation.core.metamodel.util.XmMofNameBuilder;

public final class XmClass extends XmNamespace implements XmClassifier {

    private boolean isAbstract;

    private final XmPackage containerPackage;

    private final List<XmClass> superClasses = new Vector<XmClass>( );

    private final String xsdNamespace;

    private final XSDContentTypeCategory contentType;


    /**
     * Constructor.
     * 
     * @param input
     * @param xsdName
     * @param aXsdNamespace can be null;
     * @param containerPackage
     * @param isAbstract
     * @param aContentType content type of the complex type definition which
     * corresponds to this MOIN class instance
     * @throws NullPointerException if <tt>input</tt>, <tt>xsdName</tt>,
     * <tt>containerPackage</tt> or <tt>aContentType</tt> is <code>null</code>
     */
    public XmClass( final XmGeneratorInput input, final String xsdName, final String aXsdNamespace, final XmPackage containerPackage, final boolean isAbstract, final XmXsdComponentKind kind, final XSDContentTypeCategory aContentType ) {

        super( input, xsdName, XmMofNameBuilder.buildMetaModelElementName( xsdName ), containerPackage, kind );
        if ( aContentType == null ) {
            throw new MoinNullPointerException( "aContentType" ); //$NON-NLS-1$
        }
        if ( containerPackage == null ) {
            throw new MoinNullPointerException( "containerPackage" ); //$NON-NLS-1$
        }
        this.isAbstract = isAbstract;
        this.containerPackage = containerPackage;
        this.xsdNamespace = aXsdNamespace;
        this.contentType = aContentType;
    }

    /**
     * Returns the namespace of the component for which this class is created.
     * 
     * @return namespace, can be <code>null</code>
     */
    public String getXsdNamespace( ) {

        return this.xsdNamespace;
    }

    /**
     * @param isAbstract
     */
    public void setAbstract( final boolean isAbstract ) {

        this.isAbstract = isAbstract;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.imoin.mmimporter.elements.IMoinNamespace#createModelElement
     * (com.sap.tc.moin.repository.mmi.model.ModelPackage)
     */
    @Override
    public MofClass createModelElement( ) {

        if ( modelElement == null ) {
            final MofClass clazz = (MofClass) this.createClassInstance( MofClass.CLASS_DESCRIPTOR );
            clazz.setName( mofName );
            //TODO annotation
            clazz.setAnnotation( "" ); //$NON-NLS-1$
            clazz.setRoot( false );
            clazz.setLeaf( false );
            clazz.setAbstract( isAbstract );
            clazz.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            clazz.setSingleton( false );

            modelElement = clazz;
            super.createContainedModelElements( (Namespace) modelElement );

            for ( final XmClass superClass : superClasses ) {
                clazz.getSupertypes( ).add( superClass.createModelElement( ) );
            }
        }
        return (MofClass) modelElement;
    }

    public XmPackage getPackage( ) {

        return containerPackage;
    }

    /**
     * Returns the transitive hull of the MOF element names of this class and
     * its direct and indirect super classes.
     */
    @Override
    Set<String> getSetWithUniqueMofElements( ) {

        final Set<String> result = new TreeSet<String>( );
        result.addAll( this.elementMap.keySet( ) );
        for ( final XmClass superClass : superClasses ) {
            result.addAll( superClass.getSetWithUniqueMofElements( ) );
        }
        return Collections.unmodifiableSet( result );
    }

    /**
     * @param superClass
     */
    public void addSuperClass( final XmClass superClass ) {

        if ( superClass != null ) {
            superClasses.add( superClass );
        }
    }

    public List<XmClass> getSuperClasses( ) {

        return superClasses;
    }

    /**
     * Returns the content type of the complex type definition which corresponds
     * to this instance.
     * 
     * @return content type, cannot be <code>null</code>
     */
    public XSDContentTypeCategory getContentType( ) {

        return this.contentType;
    }
}
