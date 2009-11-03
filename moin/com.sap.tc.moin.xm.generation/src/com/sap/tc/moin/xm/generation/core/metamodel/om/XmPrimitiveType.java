package com.sap.tc.moin.xm.generation.core.metamodel.om;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.primitivetypes.PrimitiveTypesPackage;

import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.xm.generation.XmGeneratorInput;
import com.sap.tc.moin.xm.generation.core.XmGenerationMessages;



public final class XmPrimitiveType extends XmModelElementImpl implements XmClassifier {



    public XmPrimitiveType( final XmGeneratorInput input, final String primitiveTypeName ) {

        super( input, primitiveTypeName, primitiveTypeName, XmXsdComponentKind.GlobalSimpleType );
    }


    public PrimitiveType createModelElement( ) {

        return this.getMofPrimitiveType( );
    }

    private PrimitiveType primitiveType;

    private PrimitiveType getMofPrimitiveType( ) {

        if ( this.primitiveType == null ) {
            final PrimitiveTypesPackage p = (PrimitiveTypesPackage) this.getInput( ).getConnection( ).getPackage( PrimitiveTypesPackage.PACKAGE_DESCRIPTOR );
            final List<String> qName = new ArrayList<String>( );
            qName.addAll( Arrays.asList( PrimitiveTypesPackage.PACKAGE_DESCRIPTOR.getQualifiedName( ) ) );
            qName.add( this.getMofName( ) );
            this.primitiveType = (PrimitiveType) this.getInput( ).getConnection( ).getJmiHelper( ).findElementByQualifiedName( qName, p );
            if ( this.primitiveType == null ) {
                throw new MoinIllegalStateException( XmGenerationMessages.INVALIDPRIMITIVEMOFTYPE, this.getMofName( ) );
            }
        }
        return this.primitiveType;
    }
}
