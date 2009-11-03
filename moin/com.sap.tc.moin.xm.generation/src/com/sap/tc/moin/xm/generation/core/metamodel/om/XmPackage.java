package com.sap.tc.moin.xm.generation.core.metamodel.om;

import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import com.sap.tc.moin.xm.generation.XmGeneratorInput;

public class XmPackage extends XmNamespace {

    /**
     * Constructor.
     * 
     * @param input
     * @param xsdName
     * @param parentPackage parent package
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public XmPackage( final XmGeneratorInput input, final String xsdName, final XmPackage parentPackage ) {

        super( input, xsdName, xsdName, parentPackage, XmXsdComponentKind.Undefined );
    }

    /**
     * Constructor for the root package.
     * 
     * @param input
     * @param xsdName
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    XmPackage( final XmGeneratorInput input, final String xsdName ) {

        super( input, xsdName, xsdName, XmXsdComponentKind.Undefined );
    }

    @Override
    public MofPackage createModelElement( ) {

        if ( modelElement == null && this.getSetWithUniqueMofElements( ).size( ) > 0 ) {
            // there must be at least one child element in order to generate the package

            final MofPackage mofPackage = (MofPackage) this.createClassInstance( MofPackage.CLASS_DESCRIPTOR );
            mofPackage.setName( mofName );
            // TODO annotation
            mofPackage.setAnnotation( "" ); //$NON-NLS-1$
            mofPackage.setRoot( true );
            mofPackage.setLeaf( true );
            mofPackage.setAbstract( false );
            mofPackage.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            modelElement = mofPackage;
            super.createContainedModelElements( (Namespace) modelElement );

        }
        return (MofPackage) modelElement;
    }

    private String text;

    @Override
    public String toString( ) {

        if ( text == null ) {
            text = "Package \"" + this.getMofName( ) + "\""; //$NON-NLS-1$ //$NON-NLS-2$ 
        }
        return this.text;
    }
}
