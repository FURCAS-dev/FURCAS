/**
 * MOIN XML Mapping API for the Import/Export integration strategy.
 * <p>
 * A Model Importer maps a XML document to a MOIN model in a model partition
 * which can be saved in MOIN format. A Model Exporter serializes a MOIN model
 * of a model partition to an XML document.
 * <p>
 * You create a Model Importer/Exporter via a connection:
 * {@link com.sap.tc.moin.repository.Connection#createModelImporter(com.sap.tc.moin.repository.xm.parser.XmParserConfiguration)}
 * or
 * {@link com.sap.tc.moin.repository.Connection#createModelExporter(com.sap.tc.moin.repository.xm.serializer.XmSerializerConfiguration)}.
 * <p>
 * This API is for SAP-internal use only and subject to change.
 */
package com.sap.tc.moin.repository.xm.ie;