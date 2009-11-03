package com.sap.tc.moin.xm.kernel.impl.parser.util;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.xm.parser.PModelElementHandle;



/**
 * A retarded link is a link which could not be executed immediately when the
 * corresponding target node "link" was reached in the mapping tree. They are
 * executed at the end of a mapping.
 */
public final class RetardedLink<TElement, TMofClass, TMofAssociation> {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, RetardedLink.class );

    private final TElement endAInstance;

    private final String associationQName;

    private final TMofAssociation association;

    private final ParserHelperImpl<TElement, TMofClass, TMofAssociation> helper;

    private final String endBMofId;

    private final String endBName;

    private final PModelElementHandle endAModelElementHandle;

    /**
     * Constructor.
     * 
     * @param aEndAModelElement
     * @param aAssociationQName dot separated association qName
     * @param association
     * @param aPackageHelper
     * @param aEndBname
     * @param aEndBMofId
     * @throws NullPointerException if a parameter except <tt>aEndBname</tt> is
     * <code>null</code>
     */
    public RetardedLink( final PModelElementHandle aEndAModelElement, final TMofAssociation aAssociation, final String aAssociationQName, final ParserHelperImpl<TElement, TMofClass, TMofAssociation> aPackageHelper, final String aEndBname, final String aEndBMofId ) {

        if ( aEndAModelElement == null ) {
            throw new MoinNullPointerException( "aEndAModelElement" ); //$NON-NLS-1$
        }
        if ( aAssociationQName == null ) {
            throw new MoinNullPointerException( "aAssociationQName" ); //$NON-NLS-1$
        }
        if ( aAssociation == null ) {
            throw new MoinNullPointerException( "aAssociation" ); //$NON-NLS-1$
        }
        if ( aPackageHelper == null ) {
            throw new MoinNullPointerException( "aPackageHelper" ); //$NON-NLS-1$
        }
        if ( aEndBMofId == null ) {
            throw new MoinNullPointerException( "aEndBMofId" ); //$NON-NLS-1$
        }
        this.endAModelElementHandle = aEndAModelElement;
        this.associationQName = aAssociationQName;
        this.association = aAssociation;
        this.helper = aPackageHelper;
        this.endBName = aEndBname;
        this.endBMofId = aEndBMofId;
        this.endAInstance = this.helper.get( this.endAModelElementHandle.getMofid( ) );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Retarded link object created for association {0} and end B {1} with end A MOFID {2} and end B MOFID {3}", new Object[] { associationQName, endBName, this.endAModelElementHandle.getMofid( ), endBMofId } ); //$NON-NLS-1$
        }
    }

    /**
     * Creates the link.
     */
    public void execute( ) {

        final TElement endBinstance = this.helper.get( this.endBMofId );
        if ( endBinstance != null ) {
            // inner partition link
            this.helper.createLink( this.endAInstance, this.association, this.associationQName, endBinstance, this.endBName );
        } else {
            // inter partition link or dangling link        
            this.helper.createLink( this.endAInstance, this.association, this.associationQName, this.endBMofId, this.endBName );
        }
    }
}
