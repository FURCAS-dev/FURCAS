package com.sap.tc.moin.repository.core.query.fql.engine;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.query.moinql.engine.CoreQueryClientScope;
import com.sap.tc.moin.repository.spi.facility.SpiFacilitySlimVariantIndexQueryService;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiAttributeExpression;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiClusterExternalLinkExpression;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiLike;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiModelElementClusterExpression;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiModelElementExpression;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiMultinaryExpression;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiOr;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiPartitionExpression;
import com.sap.tc.moin.repository.spi.facility.basicquery.SpiSimpleComparisonExpression;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlFromTypeCategory;


public class BasicQueryProcessorMemoryEstimationVariantImpl extends BasicQueryProcessorMemoryEstimationImpl {

    private SpiFacilitySlimVariantIndexQueryService variantSlimIndexQueryService;

    public BasicQueryProcessorMemoryEstimationVariantImpl( SpiFacilitySlimVariantIndexQueryService variantSlimIndexQueryService ) {

        super( variantSlimIndexQueryService );
        this.variantSlimIndexQueryService = variantSlimIndexQueryService;
    }

    @Override
    protected void estimate( CoreConnection conn, SpiModelElementClusterExpression meClusterExpression ) {

        super.estimate( conn, meClusterExpression );

        // we now refine the initial estimation by checking attribute value conditions using the capacity of the variant full index query service.
        // We remove invalid PRIs as we go further down in the recursion
        this.refineEstimate( conn, meClusterExpression );

    }

    /**
     * This method manipulates the estimation set by scanning the query for
     * attribute-like values and using iqlVariant to determine whether they
     * should be kept
     */
    private void refineEstimate( CoreConnection conn, SpiModelElementClusterExpression meClusterExpression ) {

        // handle the head model element expression
        SpiModelElementExpression mee = meClusterExpression.getHeaderModelElementExpression( );
        this.refineEstimateInMee( conn, mee );

        // handle the other mees
        List<SpiModelElementExpression> mees = meClusterExpression.getAdditionalModelElementExpressions( );
        for ( SpiModelElementExpression meeInList : mees ) {
            this.refineEstimateInMee( conn, meeInList );
        }

        // go into externally linked clusters
        List<SpiClusterExternalLinkExpression> externalLinkExpressions = meClusterExpression.getClusterExternalLinks( );
        for ( SpiClusterExternalLinkExpression clusterExternalLinkExpression : externalLinkExpressions ) {
            SpiModelElementClusterExpression nestedMeClusterExpression = clusterExternalLinkExpression.getLinkTarget( );
            // go recursively down
            this.refineEstimate( conn, nestedMeClusterExpression );
        }
    }

    /**
     * In the MEE, we check if we have local conditions and if so, we refine the
     * partition scope step-wise. We only do this for non-structure types
     */
    private void refineEstimateInMee( CoreConnection conn, SpiModelElementExpression mee ) {

        // obtain the category
        SpiFqlFromTypeCategory meeCategory = mee.getModelElementCategory( );

        // we only do something if we have no structure types and of course not reflect::element
        if ( meeCategory.equals( SpiFqlFromTypeCategory.CLASS ) && mee.getTypes( ) != null && mee.getTypes( ).length != 0 ) {

            SpiAttributeExpression attributeExpression = mee.getAttributeExpression( );

            if ( attributeExpression != null ) {
                Set<PRI> originalEstimatedScope = mee.getScope( );
                Set<PRI> newEstimatedScope = this.refineEstimateForAttributeExpression( conn, mee.getTypes( ), attributeExpression, originalEstimatedScope );

                // We only change the mee scope if the the scope has been narrowed, i.e. the new estimated scope is smaller in size than the original one 
                if ( newEstimatedScope.size( ) < originalEstimatedScope.size( ) ) {

                    // intersect the estimated scope with the already existent scope
                    Set<MRI> fixedElements = mee.getElementsSet( );
                    if ( fixedElements != null ) {
                        //different for fixed elements
                        for ( Iterator<MRI> elementIterator = fixedElements.iterator( ); elementIterator.hasNext( ); ) {
                            MRI mri = elementIterator.next( );

                            if ( !newEstimatedScope.contains( mri.getPri( ) ) ) {
                                elementIterator.remove( );
                            }
                        }
                        // set the new result
                        mee.setElements( fixedElements );
                    } else {
                        // intersect with the previous existing scope because we constrain in logical conjunctions 
                        for ( Iterator<PRI> priIterator = newEstimatedScope.iterator( ); priIterator.hasNext( ); ) {
                            PRI pri = priIterator.next( );
                            if ( !( originalEstimatedScope.contains( pri ) ) ) {
                                // remove 
                                priIterator.remove( );
                            }
                        }

                        // set the new scope when no fixed elements
                        SpiPartitionExpression newPartitionExp = new SpiPartitionExpression( newEstimatedScope.toArray( new PRI[newEstimatedScope.size( )] ), true );
                        mee.setPartitionExpression( newPartitionExp );
                    }
                }
            }
        }
    }

    @SuppressWarnings( "unchecked" )
    private Set<PRI> refineEstimateForAttributeExpression( CoreConnection conn, MRI[] type, SpiAttributeExpression attributeExpression, Set<PRI> meeScope ) {

        Set<PRI> newEstimatedScope = null;

        // recursively deeper for nested clauses
        if ( attributeExpression instanceof SpiMultinaryExpression ) {
            SpiMultinaryExpression multinaryExpression = (SpiMultinaryExpression) attributeExpression;
            boolean isOr = multinaryExpression instanceof SpiOr;

            Iterator iterator = multinaryExpression.getOperands( );
            SpiAttributeExpression subAttributeExpression = (SpiAttributeExpression) iterator.next( );
            newEstimatedScope = this.refineEstimateForAttributeExpression( conn, type, subAttributeExpression, meeScope );

            for ( ; iterator.hasNext( ); ) {
                Set<PRI> anotherEstimatedScope = this.refineEstimateForAttributeExpression( conn, type, (SpiAttributeExpression) iterator.next( ), meeScope );
                if ( isOr ) {
                    // union this new scope with newEstimatedScope
                    newEstimatedScope.addAll( anotherEstimatedScope );
                } else {
                    // intersect this new scope with the newEstimatedScope
                    for ( Iterator<PRI> priIterator = newEstimatedScope.iterator( ); priIterator.hasNext( ); ) {
                        PRI pri = priIterator.next( );
                        if ( !( anotherEstimatedScope.contains( pri ) ) ) {
                            // remove 
                            priIterator.remove( );
                        }
                    }
                }
            }
        } else {
            // base case

            // set the revised scope
            CoreQueryClientScope clientScope = new CoreQueryClientScope( conn, meeScope, true );

            if ( attributeExpression instanceof SpiLike ) {
                SpiLike spiLike = (SpiLike) attributeExpression;
                newEstimatedScope = this.variantSlimIndexQueryService.prisForMatchingStringPattern( clientScope, type, spiLike.getAttributeId( ), spiLike.isNegated( ), spiLike.getPattern( ) );
            } else if ( attributeExpression instanceof SpiSimpleComparisonExpression ) {
                SpiSimpleComparisonExpression simpleComparisonExpression = (SpiSimpleComparisonExpression) attributeExpression;
                newEstimatedScope = this.variantSlimIndexQueryService.prisForAttributeCondition( clientScope, type, simpleComparisonExpression.getAttributeId( ), simpleComparisonExpression.getAttributeValueType( ), simpleComparisonExpression.getOperator( ), simpleComparisonExpression.getValue( ) );
            } else { // SpiAttributeToAttributeComparison
                newEstimatedScope = meeScope;
            }
        }

        return newEstimatedScope;
    }
}
