package com.sap.tc.moin.repository.core.checks;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

import com.sap.tc.moin.repository.NameViolation;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

public class NameViolationImpl implements NameViolation {

    private MoinLocalizedString localizedDescription = null;

    private String originalDescription = null;

    private Object[] descriptionArgs = null;

    public NameViolationErrorCode errorCode = null;

    public List<Object> objectsInError = null;

    public NameViolationImpl( NameViolationErrorCode errorCode, List<Object> objectsInError, MoinLocalizedString description, Object... descriptionArgs ) {

        this.errorCode = errorCode;
        this.objectsInError = objectsInError;
        this.localizedDescription = description;
        this.descriptionArgs = descriptionArgs;
    }

    public String getDescription( ) {
        return getOriginalDescription( );
    }

    public String getDescription( Locale locale ) {

        MessageFormat format = new MessageFormat( localizedDescription.getLocalizedMessage( locale ), locale );
        return format.format( descriptionArgs );
    }

    private String getOriginalDescription( ) {
        if ( originalDescription == null ) {
            originalDescription = localizedDescription.format( descriptionArgs );
        }
        return originalDescription;
    }

    public NameViolationErrorCode getErrorCode( ) {

        return errorCode;
    }

    public List<Object> getObjectsInError( ) {

        return objectsInError;
    }

    @Override
    public String toString( ) {

        return getOriginalDescription( );
    }
}
