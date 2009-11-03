package com.sap.tc.moin.repository.core.xmi;

/**
 * @author d027299
 */
public interface XmiConstants {

    //General constants
    public static final String NS_SEPARATOR = ":"; //$NON-NLS-1$

    public static final String DOT_SEPARATOR = "."; //$NON-NLS-1$

    public static final String XMI_ATTRIBUTE_PREFIX = "xmi."; //$NON-NLS-1$

    //Basic elements
    public static final String XMI_ROOT = "XMI"; //$NON-NLS-1$

    public static final String XMI_HEADER = "XMI.header"; //$NON-NLS-1$

    public static final String XMI_CONTENT = "XMI.content"; //$NON-NLS-1$

    public static final String XMI_DIFFERENCE = "XMI.difference"; //$NON-NLS-1$

    public static final String XMI_DELETE = "XMI.delete"; //$NON-NLS-1$

    public static final String XMI_ADD = "XMI.add"; //$NON-NLS-1$

    public static final String XMI_REPLACE = "XMI.replace"; //$NON-NLS-1$

    public static final String XMI_EXTENSIONS = "XMI.extensions"; //$NON-NLS-1$

    public static final String XMI_EXTENSION = "XMI.extension"; //$NON-NLS-1$

    //Sub elements for XMI_HEADER
    public static final String XMI_DOCUMENTATION = "XMI.documentation"; //$NON-NLS-1$

    public static final String XMI_EXPORTER = "XMI.exporter"; //$NON-NLS-1$

    public static final String XMI_EXPORTER_VERSION = "XMI.exporterVersion"; //$NON-NLS-1$

    public static final String XMI_MODEL = "XMI.model"; //$NON-NLS-1$

    public static final String XMI_METAMODEL = "XMI.metamodel"; //$NON-NLS-1$

    public static final String XMI_METAMETAMODEL = "XMI.metametamodel"; //$NON-NLS-1$

    public static final String XMI_IMPORT = "XMI.import"; //$NON-NLS-1$

    //Attributes
    public static final String XMI_ID = "xmi.id"; //$NON-NLS-1$

    public static final String XMI_UUID = "xmi.uuid"; //$NON-NLS-1$

    public static final String XMI_LABEL = "xmi.label"; //$NON-NLS-1$

    public static final String XMI_IDREF = "xmi.idref"; //$NON-NLS-1$

    public static final String XMI_HREF = "href"; //$NON-NLS-1$

    public static final String XMI_HREF_DELIMITER_12 = "|"; //$NON-NLS-1$

    public static final String XMI_HREF_DELIMITER_20 = "#"; //$NON-NLS-1$

    public static final String XMI_POSITION = "xmi.position"; //$NON-NLS-1$

    public static final String XMI_NAME_ATT = "xmi.name"; //$NON-NLS-1$

    public static final String XMI_VERSION_ATT = "xmi.version"; //$NON-NLS-1$

    public static final String XMI_TIMESTAMP = "timestamp"; //$NON-NLS-1$

    public static final String XMI_VERIFIED = "verified"; //$NON-NLS-1$

    public static final String XMI_VALUE = "xmi.value"; //$NON-NLS-1$

    public static final String XMI_TYPE = "xmi.type"; //$NON-NLS-1$

    public static final String XMI_EXTENDER = "xmi.extender"; //$NON-NLS-1$

    public static final String XMI_EXTENDER_ID = "xmi.extenderID"; //$NON-NLS-1$

    public static final String XMLNS = "xmlns"; //$NON-NLS-1$

    //DataTypes
    public static final String XMI_CORBA_TYPE_CODE = "XMI.CorbaTypeCode"; //$NON-NLS-1$

    public static final String XMI_ANY_TYPE = "XMI.any"; //$NON-NLS-1$

    public static final String XMI_FIELD = "XMI.field"; //$NON-NLS-1$

    // MOF 1.4 primitive types
    public static final String BOOLEAN_TYPE = "Boolean"; //$NON-NLS-1$

    public static final String DOUBLE_TYPE = "Double"; //$NON-NLS-1$

    public static final String FLOAT_TYPE = "Float"; //$NON-NLS-1$

    public static final String INTEGER_TYPE = "Integer"; //$NON-NLS-1$

    public static final String LONG_TYPE = "Long"; //$NON-NLS-1$

    public static final String STRING_TYPE = "String"; //$NON-NLS-1$

    public static final String ANY_TYPE = "Any"; //$NON-NLS-1$

    //Corba types
    public static final String XMICorbaTcField = "XMI.CorbaTcField"; //$NON-NLS-1$

    public static final String XMI_TCNAME = "xmi.tcName"; //$NON-NLS-1$

    public static final String XMICorbaTcStruct = "XMI.CorbaTcStruct"; //$NON-NLS-1$

    public static final String XMICorbaTcEnum = "XMI.CorbaTcEnum"; //$NON-NLS-1$

    public static final String XMICorbaTcEnumLabel = "XMI.CorbaTcEnumLabel"; //$NON-NLS-1$

    public static final String XMICorbaTcUnion = "XMI.CorbaTcUnion"; //$NON-NLS-1$

    public static final String XMICorbaTcObjRef = "XMI.CorbaTcObjRef"; //$NON-NLS-1$

    public static final String XMICorbaTcArray = "XMI.CorbaTcArray"; //$NON-NLS-1$

    public static final String XMICorbaTcAlias = "XMI.CorbaTcAlias"; //$NON-NLS-1$

    public static final String XMICorbaTcSequence = "XMI.CorbaTcSequence"; //$NON-NLS-1$

    public static final String XMICorbaTcAny = "XMI.CorbaTcAny"; //$NON-NLS-1$

    public static final String XMICorbaTcExcept = "XMI.CorbaTcExcept"; //$NON-NLS-1$

    public static final String XMICorbaTcTypeCode = "XMI.CorbaTcTypeCode"; //$NON-NLS-1$

    public static final String XMICorbaTcPrincipal = "XMI.CorbaTcPrincipal"; //$NON-NLS-1$

    public static final String XMICorbaTcNull = "XMI.CorbaTcNull"; //$NON-NLS-1$

    public static final String XMICorbaTcVoid = "XMI.CorbaTcVoid"; //$NON-NLS-1$

    public static final String XMICorbaTcShort = "XMI.CorbaTcShort"; //$NON-NLS-1$

    public static final String XMICorbaTcLong = "XMI.CorbaTcLong"; //$NON-NLS-1$

    public static final String XMICorbaTcUShort = "XMI.CorbaTcUshort"; //$NON-NLS-1$

    public static final String XMICorbaTcULong = "XMI.CorbaTcUlong"; //$NON-NLS-1$

    public static final String XMICorbaTcFloat = "XMI.CorbaTcFloat"; //$NON-NLS-1$

    public static final String XMICorbaTcDouble = "XMI.CorbaTcDouble"; //$NON-NLS-1$

    public static final String XMICorbaTcBoolean = "XMI.CorbaTcBoolean"; //$NON-NLS-1$

    public static final String XMICorbaTcChar = "XMI.CorbaTcChar"; //$NON-NLS-1$

    public static final String XMICorbaTcWChar = "XMI.CorbaTcWchar"; //$NON-NLS-1$

    public static final String XMICorbaTcOctet = "XMI.CorbaTcOctet"; //$NON-NLS-1$

    public static final String XMICorbaTcString = "XMI.CorbaTcString"; //$NON-NLS-1$

    public static final String XMICorbaTcWString = "XMI.CorbaTcWstring"; //$NON-NLS-1$

    public static final String XMICorbaTcLongLong = "XMI.CorbaTcLongLong"; //$NON-NLS-1$

    public static final String XMICorbaTcULongLong = "XMI.CorbaTcUlongLong"; //$NON-NLS-1$

    public static final String XMICorbaTcLongDouble = "XMI.CorbaTcLongDouble"; //$NON-NLS-1$

    //Packages
    public static final String MODEL_PACKAGE = "Model"; //$NON-NLS-1$

    public static final String PRIMITIVE_TYPES_PACKAGE = "PrimitiveTypes"; //$NON-NLS-1$

    // Tag ids
    public static final String TAGID_XMI_NAMESPACE = "org.omg.xmi.namespace"; //$NON-NLS-1$

    public static final String TAGID_XMI_ENUMERATION_UNPREFIX = "org.omg.xmi.enumerationUnprefix"; //$NON-NLS-1$

    public static final String TAGID_XMI_IDL_PREFIX = "org.omg.mof.idl_prefix"; //$NON-NLS-1$

    // SAP extensions
    public static final String SAP_EXPORTER = "SAP XmiWriter"; //$NON-NLS-1$

    public static final String SAP_EXTENDER = "SAP"; //$NON-NLS-1$

    public static final String SAP_LINKS = "Links"; //$NON-NLS-1$

    public static final String SAP_LINK_ORDER = "order"; //$NON-NLS-1$

    public static final String SAP_NAMESPACE_PREFIX = "sap"; //$NON-NLS-1$

    public static final String SAP_NAMESPACE_URI = "http://xml.sap.com/pxmi"; //$NON-NLS-1$

    public static final String ORDERING_ATTRIBUTE = SAP_NAMESPACE_PREFIX + NS_SEPARATOR + SAP_LINK_ORDER;

    //***********************************************************************/
    //************************** XMI 2.0 ************************************/
    //***********************************************************************/

    public static final String TAG20_SERIALIZE = "org.omg.xmi.serialize"; //$NON-NLS-1$

    public static final String TAG20_ELEMENT = "org.omg.xmi.element"; //$NON-NLS-1$

    public static final String TAG20_REMOTE_ONLY = "org.omg.xmi.remoteOnly"; //$NON-NLS-1$

    public static final String TAG20_XMI_NAME = "org.omg.xmi.xmiName"; //$NON-NLS-1$

    public static final String TAG20_HREF = "org.omg.xmi.href"; //$NON-NLS-1$

    public static final String TAG20_NS_PREFIX = "org.omg.xmi.nsPrefix"; //$NON-NLS-1$

    public static final String TAG20_NS_URI = "org.omg.xmi.nsURI"; //$NON-NLS-1$

    // XMI 2.0 Schema
    public static String TAG20_ENFORCE_MAX_MULTIPLICITY = "org.omg.xmi.enforceMaximumMultiplicity"; //$NON-NLS-1$

    public static String TAG20_ENFORCE_MIN_MULTIPLICITY = "org.omg.xmi.enforceMinimumMultiplicity"; //$NON-NLS-1$

    public static String TAG20_USE_SCHEMA_EXTENSIONS = "org.omg.xmi.useSchemaExtensions"; //$NON-NLS-1$

    public static String TAG20_CONTENT_TYPE = "org.omg.xmi.contentType"; //$NON-NLS-1$

    public static String TAG20_PROCESS_CONTENTS = "org.omg.xmi.processContents"; //$NON-NLS-1$

    public static String TAG20_INCLUDE_NILS = "org.omg.xmi.includeNils"; //$NON-NLS-1$

    public static String TAG20_SCHEMA_TYPE = "org.omg.xmi.schemaType"; //$NON-NLS-1$

    public static String TAG20_ID_NAME = "org.omg.xmi.idName"; //$NON-NLS-1$

    public static String TAG20_DEFAULT_VALUE = "org.omg.xmi.defaultValue"; //$NON-NLS-1$

    public static String TAG20_FIXED_VALUE = "org.omg.xmi.fixedValue"; //$NON-NLS-1$

    public static String TAG20_FORM = "org.omg.xmi.form"; //$NON-NLS-1$

    // XMI 2.0 namespace prefix and uri
    public static final String XMI20_NS_PREFIX = "xmi"; //$NON-NLS-1$

    public static final String XMI20_NAMESPACE_URI = "http://www.omg.org/XMI"; //$NON-NLS-1$

    public static final String XMI20_PREFIX = "xmi:"; //$NON-NLS-1$

    public static final String XMI20_ID = "id"; //$NON-NLS-1$

    public static final String XMI20_IDREF = "idref"; //$NON-NLS-1$

    public static final String XMI20_VERSION = "version"; //$NON-NLS-1$

    public static final String XMI20_NIL = "nil"; //$NON-NLS-1$

    // XML Schema namespace uri
    public static final String XML_SCHEMA_NAMESPACE_URI = "http://www.w3.org/XMLSchema-instance"; //$NON-NLS-1$
}
