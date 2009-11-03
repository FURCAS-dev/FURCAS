package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

public class MicroTransactionablesLoggingAdapter {

    static MoinLogger logger = null;

    public MicroTransactionablesLoggingAdapter( AbstractMicroTransactionable microTransactionable ) {
        logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_MICROTRANSACTIONS, microTransactionable.getClass( ) );
    }

    public void preConstraintCheckException( Exception exception ) {
        if ( logger.isTraced( MoinSeverity.ERROR ) ) {
            logger.trace( exception, MoinSeverity.ERROR, "Exception during the check of preconditions: {0}", exception.getMessage( ) ); //$NON-NLS-1$
        }
    }

    public void postConstraintCheckException( Exception exception ) {
        if ( logger.isTraced( MoinSeverity.ERROR ) ) {
            logger.trace( exception, MoinSeverity.ERROR, "Exception during the check of postconditions: {0}", exception.getMessage( ) ); //$NON-NLS-1$
        }
    }
}
