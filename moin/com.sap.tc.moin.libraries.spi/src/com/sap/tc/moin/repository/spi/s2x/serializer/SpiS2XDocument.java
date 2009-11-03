package com.sap.tc.moin.repository.spi.s2x.serializer;

/**
 * This class is used from MOIN to fill the {@link com.sap.s2x.S2XDocument S2X
 * document} in the serialization process.
 * <p>
 * The class is used to transport S2X document information, like the original
 * language of a DC, from the MOIN core to the S2X serializer.
 */
public final class SpiS2XDocument {

    private final String language;

    private final String develContact;

    public SpiS2XDocument( String language, String develContact ) {
        this.language = language;
        this.develContact = develContact;
    }

    public String getLanguage( ) {
        return language;
    }

    public String getDevelContact( ) {
        return develContact;
    }
}
