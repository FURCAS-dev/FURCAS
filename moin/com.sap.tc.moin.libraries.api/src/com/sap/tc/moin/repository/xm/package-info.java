/**
 * MOIN XML Mapping API.
 * <p>
 * MOIN XML Mapping (XM) maps XML documents to MOIN models and vice versa. The
 * transformation is done by XM Parsers and XM Serializers. A XM Parser parses
 * an XML document and creates an in-memory MOIN model; a XM Serializer
 * serializes an in-memory MOIN model to an XML document. Typically a XM
 * Parser/Serializer class is generated from an XML schema. The sub-packages
 * "parser" and "serializer" contain the main part of the XM runtime framework,
 * especially the super-classes which an XM Parser/Serializer class must extend.
 * <p>
 * The XM Parser/Serializer can run in two different integration strategies.
 * <ul>
 * <li>In the "Import/Export" integration strategy, XM uses the MOIN reflective
 * JMI API to create (Import) or retrieve (Export) model elements. This does
 * mean,
 * <ul>
 * <li>that the MOIN event framework will throw change events whenever you
 * import an XML document, even if you import the same document a second time</li>
 * <li>it is possible to persist the created model elements in a MOIN specific
 * XMI like format (Then you have redundant persisted data in MOIN and XML
 * format.)</li>
 * </ul>
 * How to access a Model Importer/Exporter is described in the sub-package "ie".
 * </li>
 * <li>In the "CPS" integration strategy, XM uses the MOIN Custom
 * Parser/Serializer technology. XML documents represent persisted model
 * partitions. Change events are not triggered during the parsing and
 * serializing of XML documents. Consult the Eclipse help documentation for more
 * information about Custom Parser/Serializer.</li>
 * </ul>
 * <p>
 * This API is for SAP-internal use only and subject to change.
 */
package com.sap.tc.moin.repository.xm;