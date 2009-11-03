package com.sap.tc.moin.repository.exception;

import java.util.HashSet;
import java.util.Set;


/**
 * Base exception for all MOIN exceptions.
 */
public abstract class MoinBaseException extends Exception {

    private final static String ASSERT_NUMPARS = "Number of message parameters doesn't match number of arguments"; //$NON-NLS-1$

    private final static String ASSERT_NOEX = "Exceptions can not be used as message parameter"; //$NON-NLS-1$

    /**
     * @param rootCause see {@link Exception#getCause()}
     */
    public MoinBaseException( MoinLocalizedBaseException rootCause ) {

        super( rootCause );
    }

    /**
     * @param message see {@link Exception#getMessage()}
     * @param rootCause see {@link Exception#getCause()}
     */
    public MoinBaseException( String message, Throwable rootCause ) {

        super( message, rootCause );
    }

    /**
     * @param message see {@link Exception#getMessage()}
     */
    public MoinBaseException( String message ) {

        super( message );
    }

    /**
     * @param message see {@link Exception#getMessage()}
     * @param args the arguments for message parameter replacement
     */
    public MoinBaseException( MoinExternalizedString message, Object... args ) {

        super( message.format( args ) );

        assert ( parameterCountOk( message, args ) ) : ASSERT_NUMPARS;

        assert ( parameterNoExceptions( args ) ) : ASSERT_NOEX;
    }

    /**
     * @param cause see {@link Exception#getCause()}
     * @param message see {@link Exception#getMessage()}
     * @param args the arguments for message parameter replacement
     */
    public MoinBaseException( Throwable cause, MoinExternalizedString message, Object... args ) {

        super( message.format( args ), cause );

        assert ( parameterCountOk( message, args ) ) : ASSERT_NUMPARS;

        assert ( parameterNoExceptions( args ) ) : ASSERT_NOEX;
    }

    private boolean parameterCountOk( MoinExternalizedString message, Object... args ) {

        String pattern = message.format( new Object[0] );
        int count = 0;
        int lastLeftIndex = 0;
        int index = pattern.indexOf( '{', lastLeftIndex );

        Set<Integer> intSet = new HashSet<Integer>( );
        // there might be {} that are not intended for parameter replacement (do not have an Integer in between)

        while ( index >= 0 ) {
            int rightIndex = pattern.indexOf( '}', index );
            String inbetween;
            try {
                inbetween = pattern.substring( index + 1, rightIndex );
                Integer parIndex = new Integer( inbetween );
                if ( intSet.add( parIndex ) ) {
                    count++;
                }
            } catch ( Exception e ) {
                // $JL-EXC$ we just want to check the inbetween
            }
            lastLeftIndex = index + 1;
            index = pattern.indexOf( '{', lastLeftIndex );
        }

        return count == args.length;
    }

    private boolean parameterNoExceptions( Object... args ) {

        for ( Object arg : args ) {
            if ( arg instanceof Throwable ) {
                return false;
            }
        }
        return true;
    }

    static final long serialVersionUID = -3387516993124669948L;
}