package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

import javax.management.openmbean.TabularData;

/**
 * The JMX instrumentation of the Custom Parser / Serializer functionality.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface CpsMBean {

    /**
     * The PARTITION_PARSING_START notification.
     */
    public static final String PARTITION_PARSING_START = "PARTITION_PARSING_START"; //$NON-NLS-1$

    /**
     * The PARTITION_PARSING_END notification.
     */
    public static final String PARTITION_PARSING_END = "PARTITION_PARSING_END"; //$NON-NLS-1$

    /**
     * The PARTITION_SERIALIZATION_START notification.
     */
    public static final String PARTITION_SERIALIZATION_START = "PARTITION_SERIALIZATION_START"; //$NON-NLS-1$

    /**
     * The PARTITION_SERIALIZATION_END notification.
     */
    public static final String PARTITION_SERIALIZATION_END = "PARTITION_SERIALIZATION_END"; //$NON-NLS-1$

    /**
     * The TEXTS_SERIALIZATION_START notification.
     */
    public static final String TEXTS_SERIALIZATION_START = "TEXTS_SERIALIZATION_START"; //$NON-NLS-1$

    /**
     * The TEXTS_SERIALIZATION_END notification.
     */
    public static final String TEXTS_SERIALIZATION_END = "TEXTS_SERIALIZATION_END"; //$NON-NLS-1$

    /**
     * The TEXTS_SERIALIZATION_EXCEPTION notification.
     */
    public static final String TEXTS_SERIALIZATION_EXCEPTION = "TEXTS_SERIALIZATION_EXCEPTION"; //$NON-NLS-1$

    /**
     * The TEXTS_SERIALIZATION_CALLBACK notification.
     */
    public static final String TEXTS_SERIALIZATION_CALLBACK = "TEXTS_SERIALIZATION_CALLBACK"; //$NON-NLS-1$

    /**
     * The TEXTS_SERIALIZATION_TRANSLATABLE_TEXT notification.
     */
    public static final String TEXTS_SERIALIZATION_TRANSLATABLE_TEXT = "TEXTS_SERIALIZATION_TRANSLATABLE_TEXT"; //$NON-NLS-1$

    /**
     * The ADD_ELEMENT notification.
     */
    public static final String ADD_ELEMENT = "ADD_ELEMENT"; //$NON-NLS-1$

    /**
     * The ADD_ELEMENT notification.
     */
    public static final String ADD_ELEMENT_OF_NONEXISTING_MOFCLASS = "ADD_ELEMENT_OF_NONEXISTING_MOFCLASS"; //$NON-NLS-1$

    /**
     * The ADD_LINK notification.
     */
    public static final String ADD_LINK = "ADD_LINK"; //$NON-NLS-1$

    /**
     * The ADD_ATTRIBUTE_VALUE notification.
     */
    public static final String ADD_ATTRIBUTE_VALUE = "ADD_ATTRIBUTE_VALUE"; //$NON-NLS-1$

    /**
     * The ERROR_HANDLER_START notification.
     */
    public static final String ERROR_HANDLER_START = "ERROR_HANDLER_START"; //$NON-NLS-1$

    /**
     * The ERROR_HANDLER_END notification.
     */
    public static final String ERROR_HANDLER_END = "ERROR_HANDLER_END"; //$NON-NLS-1$

    /**
     * All available notifications of this MBean.
     */
    public static final String[] ALL_NOTIFICATION_TYPES = new String[] { PARTITION_PARSING_START, //
        PARTITION_PARSING_END,
        PARTITION_SERIALIZATION_START,
        PARTITION_SERIALIZATION_END,
        TEXTS_SERIALIZATION_START,
        TEXTS_SERIALIZATION_END,
        TEXTS_SERIALIZATION_EXCEPTION,
        TEXTS_SERIALIZATION_CALLBACK,
        TEXTS_SERIALIZATION_TRANSLATABLE_TEXT,
        ADD_ELEMENT,
        ADD_ELEMENT_OF_NONEXISTING_MOFCLASS,
        ADD_LINK,
        ADD_ATTRIBUTE_VALUE,
        ERROR_HANDLER_START,
        ERROR_HANDLER_END };

    /**
     * Starts the CPS trace (custom parser / serializer).
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Starts the CPS trace (custom parser / serializer)." )
    public void startNotifications( ) throws IOException;

    /**
     * Returns whether the CPS trace (custom parser / serializer) is currently
     * started.
     * 
     * @return whether the CPS trace is currently started
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns whether the CPS trace (custom parser / serializer) is currently started." )
    public boolean notificationsStarted( ) throws IOException;

    /**
     * Stops the CPS trace (custom parser / serializer).
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Stops the CPS trace (custom parser / serializer)." )
    public void stopNotifications( ) throws IOException;

    /**
     * Returns all registered custom parser / serializer factories.
     * 
     * @return all registered custom parser / serializer factories
     * @throws IOException in case of network communication issues
     */
    @Description( "All registered custom parser / serializer factories." )
    public TabularData getCustomParserSerializerFactories( ) throws IOException;

    /**
     * Returns the mappings of {@link PRI} patterns to serialization IDs.
     * 
     * @return the mappings of PRI patterns to serialization IDs
     * @throws IOException in case of network communication issues
     */
    @Description( "The mapping of PRI patterns to serialization IDs." )
    public TabularData getPriPatternRegistry( ) throws IOException;

    /**
     * Returns the criteria specifying where relevant model content can be
     * found. These locations are given as collections of generic properties, to
     * be interpreted by the facility.
     * 
     * @return the model content selection criteria
     * @throws IOException in case of network communication issues
     */
    @Description( "The criteria specifying where relevant model content can be found. These locations are given as collections of generic properties, to be interpreted by the facility." )
    public TabularData getModelContentSelectionCriteria( ) throws IOException;

    /**
     * Returns all registered S2X serializer callbacks.
     * 
     * @return all registered S2X serializer callbacks
     * @throws IOException in case of network communication issues
     */
    @Description( "All registered S2X serializer callbacks." )
    public TabularData getS2XSerializerCustomCallbacks( ) throws IOException;

    /**
     * Returns all registered error handlers.
     * 
     * @return all registered error handlers
     * @throws IOException in case of network communication issues
     */
    @Description( "All registered error handlers." )
    public TabularData getErrorHandlers( ) throws IOException;

    /**
     * Returns the serialization id of the parser / serializer which is
     * responsible for handling the specified PRI.
     * 
     * @param priString the {@link PRI} String of the model partition in
     * question
     * @return the serialization id of the responsible parser / serializer
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns the serialization id of the parser / serializer which is responsible for handling the specified PRI." )
    public String findResponsibleParserSerializer( @ParameterName( "priString" ) String priString ) throws IOException;
}