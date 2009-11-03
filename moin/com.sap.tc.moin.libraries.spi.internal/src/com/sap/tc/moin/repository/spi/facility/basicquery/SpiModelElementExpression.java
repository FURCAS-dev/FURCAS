package com.sap.tc.moin.repository.spi.facility.basicquery;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityQueryServiceException;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlFromTypeCategory;

/**
 * Expression for selecting model elements
 */
@Deprecated
public final class SpiModelElementExpression {

    private MRI[] types;

    private Set<MRI> typesSet;

    private MRI[] elements;

    private Set<MRI> elementsSet;

    private SpiFqlFromTypeCategory modelElementCategory;

    private SpiPartitionExpression partitionExpression;

    private SpiAttributeExpression attributeExpression;

    private String alias;

    /**
     * Constructs ModelElementExpression from types and partition expression. If
     * the types array is empty then there is no type restriction
     * (Reflect::Element).
     * 
     * @param types types of the model element (if empty, then the type
     * constraint is not taken)
     * @param modelElementCategory model element category (CLASS or STRUCTURE)
     * @param partitionExpression partition expression, can be null
     */
    public SpiModelElementExpression( MRI[] types, SpiFqlFromTypeCategory modelElementCategory, SpiPartitionExpression partitionExpression ) {

        this.types = types;
        this.typesSet = null;
        if ( types != null ) {
            this.typesSet = new HashSet<MRI>( types.length );
            for ( int i = 0; i < types.length; i++ ) {
                this.typesSet.add( types[i] );
            }
        }

        this.elements = null;
        this.elementsSet = null;
        this.modelElementCategory = modelElementCategory;
        this.partitionExpression = partitionExpression;
    }

    /**
     * Constructs ModelElementExpression from elements. No partition scope can
     * be given and they have to be type CLASS model.
     * 
     * @param elements these are the elements of this model element expression.
     */
    public SpiModelElementExpression( MRI[] elements ) {

        this.types = null;
        this.typesSet = null;
        this.elements = elements;
        this.elementsSet = null;
        if ( elements != null ) {
            this.elementsSet = new HashSet<MRI>( elements.length );
            for ( int i = 0; i < elements.length; i++ ) {
                this.elementsSet.add( elements[i] );
            }
        }

        this.modelElementCategory = SpiFqlFromTypeCategory.CLASS;
        this.partitionExpression = null;
    }

    public void setElements( MRI[] elements ) {

        this.elements = elements;
        this.elementsSet = null;
        if ( elements != null ) {
            this.elementsSet = new HashSet<MRI>( elements.length );
            for ( int i = 0; i < elements.length; i++ ) {
                this.elementsSet.add( elements[i] );
            }
        }
    }

    public void setElements( Set<MRI> elementsSet ) {

        this.elementsSet = elementsSet;
        if ( elements != null ) {
            this.elements = new MRI[elementsSet.size( )];
            int i = 0;
            for ( Iterator<MRI> iterator = elementsSet.iterator( ); iterator.hasNext( ); i++ ) {
                this.elements[i] = iterator.next( );
            }

        } else {
            this.elements = new MRI[0];
        }
    }

    public SpiAttributeExpression getAttributeExpression( ) {

        return attributeExpression;
    }

    public void setAttributeExpression( SpiAttributeExpression attributeExpression ) {

        this.attributeExpression = attributeExpression;
    }

    public void setPartitionExpression( SpiPartitionExpression partitionExpression ) {

        this.partitionExpression = partitionExpression;
    }

    public boolean hasElements( ) {

        return this.elements != null && this.elements.length > 0;
    }

    /**
     *
     */
    @SuppressWarnings( "nls" )
    public void toString( StringBuffer sb, int ident, boolean newline ) {

        if ( newline ) {
            SpiUtils.toStringNewLine( sb, ident );
        }
        sb.append( SpiUtils.OPENING_PARENTHESES );
        sb.append( SpiUtils.MODEL_ELEMENT_EXPRESSION );
        sb.append( ": " );
        sb.append( SpiUtils.ALIAS );
        sb.append( " = " );
        sb.append( this.getAlias( ) );
        if ( this.types != null ) {
            SpiUtils.toStringNewLine( sb, ident + 1 );
            sb.append( SpiUtils.TYPES );
            sb.append( ": " );
            int numberOfTypes = this.types.length;
            for ( int i = 0; i < numberOfTypes; i++ ) {
                if ( i > 0 ) {
                    sb.append( ", " );
                }
                SpiUtils.toStringNewLine( sb, ident + 2 );
                sb.append( SpiUtils.mriIdForPrinting( this.types[i] ) );
            }
        }
        if ( this.elements != null ) {
            SpiUtils.toStringNewLine( sb, ident + 1 );
            sb.append( SpiUtils.ELEMENTS );
            sb.append( ": " );
            int numberOfElements = this.elements.length;
            for ( int i = 0; i < numberOfElements; i++ ) {
                if ( i > 0 ) {
                    sb.append( ", " );
                }
                SpiUtils.toStringNewLine( sb, ident + 2 );
                sb.append( SpiUtils.mriIdForPrinting( this.elements[i] ) );
            }
        }
        if ( partitionExpression != null ) {
            partitionExpression.toString( sb, ident + 1, true );
            sb.append( ',' );
        }
        if ( attributeExpression != null ) {
            attributeExpression.toString( sb, ident + 1, true );
        }
        sb.append( SpiUtils.CLOSING_PARENTHESES );
    }

    /**
     * @return Returns the partitionExpression.
     */
    public SpiPartitionExpression getPartitionExpression( ) {

        return partitionExpression;
    }

    public Set<PRI> getScope( ) {

        if ( partitionExpression == null ) {
            return new HashSet<PRI>( 0 );
        } else {
            return partitionExpression.getPartitionSet( );
        }
    }

    public boolean scopeIsIncluded( ) {

        if ( partitionExpression == null ) {
            return false;
        } else {
            return partitionExpression.isIncludeList( );
        }
    }

    /**
     * @return Returns the types.
     */
    public MRI[] getTypes( ) {

        return types;
    }

    /**
     * @return Returns the elements.
     */
    public MRI[] getElements( ) {

        return elements;
    }

    /**
     * @return Returns the types.
     */
    public Set<MRI> getTypesSet( ) {

        return typesSet;
    }

    /**
     * @return Returns the elements.
     */
    public Set<MRI> getElementsSet( ) {

        return elementsSet;
    }

    public String getAlias( ) {

        if ( this.alias == null ) {
            throw new SpiFacilityQueryServiceException( SpiFacilityQueryServiceException.ERROR_CODE_UNSPECIFIED, BQLBugMessages.ALIAS_OF_MODEL_ELEMENT_EXPRESSION_SHOULD_NEVER_BE_NULL );
        }
        return this.alias;
    }

    public void setAlias( String alias ) {

        this.alias = alias;
    }

    public SpiFqlFromTypeCategory getModelElementCategory( ) {

        return modelElementCategory;
    }

}
