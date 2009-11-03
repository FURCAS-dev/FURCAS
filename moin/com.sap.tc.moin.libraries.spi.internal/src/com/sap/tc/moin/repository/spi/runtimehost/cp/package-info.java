/**
 * Provides access to parser/serializer implementations;
 * rename package to <B>com.sap.tc.moin.repository.spi.runtimehost.ps</B>? .
 * <p>
 * The {@link SpiPartitionSerializationManager} manages the registrations of
 * custom parsers/serializers.
 * </p>
 * <p>
 * The {@link SpiPartitionNameVerifier} is used by the facility to check the
 * validity of PRIs. The partition name verifier checks if the
 * PRI fits to the PRI pattern of one of the registered custom
 * parsers/serializers.
 * </p> <br>
 * <br>
 * This API is for SAP-internal use only and subject to change
 */
package com.sap.tc.moin.repository.spi.runtimehost.cp;