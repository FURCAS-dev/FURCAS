package com.sap.tc.moin.repository;

import java.util.List;
import java.util.Locale;

/**
 * A violation for metamodel names against the MOIN naming rules.
 * <p>
 * Name violations can occur in different situations. Metamodel element names
 * could have not allowed characters or could be non unique in the containing
 * namespace.
 * <p>
 * The MOIN naming rules are described in the MOIN specification. Valid
 * metamodel names can only contain the characters "a-z", "A-Z" and the
 * underscore "_".
 * <p>
 * This interface provides methods for retrieving a violation description text,
 * a violation error code and the objects that are in error.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface NameViolation {

    /**
     * Error code enumeration.
     * <p>
     * For every error code there is a dedicated number of objects in error.
     * 
     * @see getObjectsInError(), getErrorCode()
     */
    public enum NameViolationErrorCode {
        /**
         * is null
         * <p>
         * Objects in error: {@link java.lang.String name}
         */
        MODEL_ELEMENT_NAME_IS_NULL, ENUMERATION_LABEL_IS_NULL,

        /**
         * length is 0
         * <p>
         * Objects in error: {@link java.lang.String name}
         */
        MODEL_ELEMENT_NAME_LENGTH_IS_NULL, ENUMERATION_LABEL_LENGTH_IS_NULL,

        /**
         * first character is not a letter
         * <p>
         * Objects in error: {@link java.lang.String name},
         * {@link java.lang.Character first character}
         */
        MODEL_ELEMENT_NAME_FIRST_CHAR_IS_NOT_LETTER, ENUMERATION_LABEL_FIRST_CHAR_IS_NOT_LETTER,

        /**
         * a character is not a letter, a digit or an underscore
         * <p>
         * Objects in error: {@link java.lang.String name},
         * {@link java.lang.Integer position}, {@link java.lang.Character
         * character at this position}
         */
        MODEL_ELEMENT_NAME_CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE, ENUMERATION_LABEL_CHAR_IS_NOT_LETTER_DIGIT_UNDERSCORE,

        /**
         * a character is not an ascii character
         * <p>
         * Objects in error: {@link java.lang.String name},
         * {@link java.lang.Integer position}, {@link java.lang.Character
         * character}
         */
        MODEL_ELEMENT_NAME_CHAR_IS_NOT_ASCII, ENUMERATION_LABEL_CHAR_IS_NOT_ASCII,

        /**
         * is java keyword
         * <p>
         * Objects in error: {@link java.lang.String name}
         */
        MODEL_ELEMENT_NAME_IS_JAVA_KEYWORD, ENUMERATION_LABEL_IS_JAVA_KEYWORD,

        /**
         * already exists in its namespace
         * <p>
         * Objects in error: {@link java.lang.String name}
         */
        NAME_EXISTS_IN_NAMESPACE, PACKAGE_NAME_EXISTS_IN_NAMESPACE,

        /**
         * Java name already exists in its namespace
         * <p>
         * Objects in error: {@link java.lang.String Java qualified name}
         */
        JAVA_NAME_EXISTS_IN_NAMESPACE, PACKAGE_JAVA_NAME_EXISTS_IN_NAMESPACE,
    }

    /**
     * Returns a textual description of this violation.
     * 
     * @return a textual description of this violation
     */
    public String getDescription( );

    /**
     * Returns a locale dependent textual description of this violation.
     * 
     * @return a locale dependent textual description of this violation
     */
    public String getDescription( Locale locale );

    /**
     * Returns the {@link NameViolationErrorCode error code} of this violation.
     * <p>
     * For every error code there is a dedicated number of objects in error.
     * 
     * @return the error code of this violation.
     * @see NameViolationErrorCode, getObjectsInError
     */
    public NameViolationErrorCode getErrorCode( );

    /**
     * Returns an {@link java.util.List list} of {@link java.lang.Object objects
     * in error} of this violation.
     * <p>
     * The objects that are in error depend on the error code. For every error
     * code there is a dedicated number of objects in error.
     * 
     * @return a list of objects in error of this violation.
     * @see NameViolationErrorCode, getErrorCode()
     */
    public List<Object> getObjectsInError( );
}
