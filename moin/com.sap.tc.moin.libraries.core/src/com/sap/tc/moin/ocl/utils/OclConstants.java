package com.sap.tc.moin.ocl.utils;


/**
 * String constants
 */
public interface OclConstants {

    /** Alias: / */
    public final static String A_DIV = "/"; //$NON-NLS-1$

    /** Alias: = */
    public final static String A_EQ = "="; //$NON-NLS-1$

    /** Alias:> */
    public final static String A_GT = ">"; //$NON-NLS-1$

    /** Alias: >= */
    public final static String A_GTEQ = ">="; //$NON-NLS-1$

    /** Alias: < */
    public final static String A_LT = "<"; //$NON-NLS-1$

    /** Alias: <= */
    public final static String A_LTEQ = "<="; //$NON-NLS-1$

    /** Alias: - */
    public final static String A_MINUS = "-"; //$NON-NLS-1$

    /** Alias: * */
    public final static String A_MULT = "*"; //$NON-NLS-1$

    /** Alias: ~n */
    public final static String A_N = "~n"; //$NON-NLS-1$

    /** Alias: <> */
    public final static String A_NEQ = "<>"; //$NON-NLS-1$

    /** Alias: +> */
    public final static String A_PLUS = "+"; //$NON-NLS-1$

    /** @pre */
    public final static String ATPRE = "@pre"; //$NON-NLS-1$

    /** Left bracket ( */
    public final static String BRACKETLEFT = "("; //$NON-NLS-1$

    /** Right bracket ) */
    public final static String BRACKETRIGHT = ")"; //$NON-NLS-1$

    /** OclSerializer: Can not serialize null */
    public final static String CANNOT_SERIALIZE_NULL_EXCEPTION = "OclSerializer: Can not serialize null"; //$NON-NLS-1$

    /** CollectionKind: Bag */
    public final static String COLLKINDBAG = "Bag"; //$NON-NLS-1$

    /** CollectionKind: OrderedSet */
    public final static String COLLKINDORDEREDSET = "OrderedSet"; //$NON-NLS-1$

    /** CollectionKind: Sequence */
    public final static String COLLKINDSEQUENCE = "Sequence"; //$NON-NLS-1$

    /** CollectionKind: Set */
    public final static String COLLKINDSET = "Set"; //$NON-NLS-1$

    /** Iteration */
    public final static String DEBUGER_ITERATION_TEXT = "Iteration"; //$NON-NLS-1$

    /** Iterator */
    public final static String DEBUGER_ITERATOR_TEXT = "Iterator"; //$NON-NLS-1$

    /** Dot (.) */
    public final static String DOT = "."; //$NON-NLS-1$

    /** Empty ("") */
    public final static String EMPTY = ""; //$NON-NLS-1$

    /** Exception serializing the expression */
    public final static String EXPR_SERIALIZATION_ERROR_TEXT = "Exception serializing the expression"; //$NON-NLS-1$

    /** JMI Feature ID: annotation */
    public final static String F_ANNOTATION = "annotation"; //$NON-NLS-1$

    /** JMI Feature ID: evaluationPolicy */
    public final static String F_EVALUATIONPOLICY = "evaluationPolicy"; //$NON-NLS-1$

    /** JMI Feature ID: annotation */
    public final static String F_EXPRESSION = "expression"; //$NON-NLS-1$

    /** JMI Feature ID: language */
    public final static String F_LANGUAGE = "language"; //$NON-NLS-1$

    /** JMI Feature ID: name */
    public final static String F_NAME = "name"; //$NON-NLS-1$

    /** JMI Feature ID: visibility */
    public final static String F_VISIBILITY = "visibility"; //$NON-NLS-1$

    /** false */
    public final static String FALSE = "false"; //$NON-NLS-1$

    /** Language: OCL */
    public final static String L_OCL = "OCL"; //$NON-NLS-1$

    /** Language: OCLInit */
    public final static String L_OCLINIT = "OCLInit"; //$NON-NLS-1$

    /** Node: Bag */
    public static final Object N_BAG = "Bag"; //$NON-NLS-1$

    /** Node: Collection */
    public static final String N_COLLECTION = "Collection"; //$NON-NLS-1$

    /** Node: containerName */
    public static final String N_CONTAINERNAME = "containerName"; //$NON-NLS-1$

    /** Node: OrderedSet */
    public static final String N_ORDEREDSET = "OrderedSet"; //$NON-NLS-1$

    /** Node: Sequence */
    public static final String N_SEQUENCE = "Sequence"; //$NON-NLS-1$

    /** Node: Set */
    public static final String N_SET = "Set"; //$NON-NLS-1$

    /** Node: withAtPre */
    public static final String N_WITHAPRE = "withAtPre"; //$NON-NLS-1$

    /** The OclDefinition annotation value */
    public final static String OCLDEFINITION = "OclDefinition"; //$NON-NLS-1$

    /** Used as prefix for the generated package: OclGenerated */
    public static final String OCLGENERATED = "OclGenerated"; //$NON-NLS-1$

    /** Operation: abs */
    public final static String OP_ABS = "abs"; //$NON-NLS-1$

    /** Operation: allInstances */
    public final static String OP_ALLINSTANCES = "allInstances"; //$NON-NLS-1$

    /** Operation: and */
    public final static String OP_AND = "and"; //$NON-NLS-1$

    /** Operation: any */
    public final static String OP_ANY = "any"; //$NON-NLS-1$

    /** Operation: append */
    public final static String OP_APPEND = "append"; //$NON-NLS-1$

    /** Operation: asBag */
    public final static String OP_ASBAG = "asBag"; //$NON-NLS-1$

    /** Operation: asOrderedSet */
    public final static String OP_ASORDEREDSET = "asOrderedSet"; //$NON-NLS-1$

    /** Operation: asSequence */
    public final static String OP_ASSEQUENCE = "asSequence"; //$NON-NLS-1$

    /** Operation: asSet */
    public final static String OP_ASSET = "asSet"; //$NON-NLS-1$

    /** Operation: asType */
    public final static String OP_ASTYPE = "asType"; //$NON-NLS-1$

    /** Operation: at */
    public final static String OP_AT = "at"; //$NON-NLS-1$

    /** Operation: atPre */
    public final static String OP_ATRPRE = "atPre"; //$NON-NLS-1$

    /** Operation: collect */
    public final static String OP_COLLECT = "collect"; //$NON-NLS-1$

    /** Operation: collectNested */
    public final static String OP_COLLECTNESTED = "collectNested"; //$NON-NLS-1$

    /** Operation: concat */
    public final static String OP_CONCAT = "concat"; //$NON-NLS-1$

    /** Operation: count */
    public final static String OP_COUNT = "count"; //$NON-NLS-1$

    /** Operation: div */
    public final static String OP_DIV = "div"; //$NON-NLS-1$

    /** Operation: divStdLib */
    public final static String OP_DIVSTDLIB = "divStdLib"; //$NON-NLS-1$

    /** Operation: equalsStdLib */
    public final static String OP_EQSTDLIB = "equalsStdLib"; //$NON-NLS-1$

    /** Operation: excludes */
    public final static String OP_EXCLUDES = "excludes"; //$NON-NLS-1$

    /** Operation: excludesAll */
    public final static String OP_EXCLUDESALL = "excludesAll"; //$NON-NLS-1$

    /** Operation: excluding */
    public final static String OP_EXCLUDING = "excluding"; //$NON-NLS-1$

    /** Operation: exists */
    public final static String OP_EXISTS = "exists"; //$NON-NLS-1$

    /** Operation: first */
    public final static String OP_FIRST = "first"; //$NON-NLS-1$

    /** Operation: flatten */
    public final static String OP_FLATTEN = "flatten"; //$NON-NLS-1$

    /** Operation: floor */
    public final static String OP_FLOOR = "floor"; //$NON-NLS-1$

    /** Operation: forAll */
    public final static String OP_FORALL = "forAll"; //$NON-NLS-1$

    /** Operation: gt */
    public final static String OP_GT = "gt"; //$NON-NLS-1$

    /** Operation: gteq */
    public final static String OP_GTEQ = "gteq"; //$NON-NLS-1$

    /** Operation: gteqStdLib */
    public final static String OP_GTEQSTDLIB = "gteqStdLib"; //$NON-NLS-1$

    /** Operation: gtStdLib */
    public final static String OP_GTSTDLIB = "gtStdLib"; //$NON-NLS-1$

    /** Operation: implies */
    public final static String OP_IMPLIES = "implies"; //$NON-NLS-1$

    /** Operation: includes */
    public final static String OP_INCLUDES = "includes"; //$NON-NLS-1$

    /** Operation: includesAll */
    public final static String OP_INCLUDESALL = "includesAll"; //$NON-NLS-1$

    /** Operation: including */
    public final static String OP_INCLUDING = "including"; //$NON-NLS-1$

    /** Operation: indexOf */
    public final static String OP_INDEXOF = "indexOf"; //$NON-NLS-1$

    /** Operation: insertAt */
    public final static String OP_INSERTAT = "insertAt"; //$NON-NLS-1$

    /** Operation: intDivStdLib */
    public final static String OP_INTDIVSTDLIB = "intDivStdLib"; //$NON-NLS-1$

    /** Operation: intersection */
    public final static String OP_INTERSECTION = "intersection"; //$NON-NLS-1$

    /** Operation: isEmpty */
    public final static String OP_ISEMPTY = "isEmpty"; //$NON-NLS-1$

    /** Operation: isUnique */
    public final static String OP_ISUNIQUE = "isUnique"; //$NON-NLS-1$

    /** Operation: iterate */
    public final static String OP_ITERATE = "iterate"; //$NON-NLS-1$

    /** Operation: last */
    public final static String OP_LAST = "last"; //$NON-NLS-1$

    /** Operation: longDiv */
    public final static String OP_LONGDIV = "longDiv"; //$NON-NLS-1$

    /** Operation: longDivStdLib */
    public final static String OP_LONGDIVSTDLIB = "longDivStdLib"; //$NON-NLS-1$

    /** Operation: lt */
    public final static String OP_LT = "lt"; //$NON-NLS-1$

    /** Operation: lteq */
    public final static String OP_LTEQ = "lteq"; //$NON-NLS-1$

    /** Operation: lteqStdLib */
    public final static String OP_LTEQSTDLIB = "lteqStdLib"; //$NON-NLS-1$

    /** Operation: ltStdLib */
    public final static String OP_LTSTDLIB = "ltStdLib"; //$NON-NLS-1$

    /** Operation: matches */
    public final static String OP_MATCHES = "matches"; //$NON-NLS-1$

    /** Operation: max */
    public final static String OP_MAX = "max"; //$NON-NLS-1$

    /** Operation: min */
    public final static String OP_MIN = "min"; //$NON-NLS-1$

    /** Operation: - */
    public final static String OP_MINUS = "-"; //$NON-NLS-1$

    /** Operation: minusStdLib */
    public final static String OP_MINUSSTDLIB = "minusStdLib"; //$NON-NLS-1$

    /** Operation: mod */
    public final static String OP_MOD = "mod"; //$NON-NLS-1$

    /** Operation: mult */
    public final static String OP_MULT = "mult"; //$NON-NLS-1$

    /** Operation: multStdLib */
    public final static String OP_MULTSTDLIB = "multStdLib"; //$NON-NLS-1$

    /** Operation: n */
    public final static String OP_N = "n"; //$NON-NLS-1$

    /** Operation: neg */
    public final static String OP_NEG = "neg"; //$NON-NLS-1$

    /** Operation: negStdLib */
    public final static String OP_NEGSTDLIB = "negStdLib"; //$NON-NLS-1$

    /** Operation: not */
    public final static String OP_NOT = "not"; //$NON-NLS-1$

    /** Operation: notEmpty */
    public final static String OP_NOTEMPTY = "notEmpty"; //$NON-NLS-1$

    /** Operation: notEqualsStdLib */
    public final static String OP_NOTEQSTDLIB = "notEqualsStdLib"; //$NON-NLS-1$

    /** Operation: oclAsType */
    public final static String OP_OCLASTYPE = "oclAsType"; //$NON-NLS-1$

    /** Operation: oclIsInvalid */
    public final static String OP_OCLISINVALID = "oclIsInvalid"; //$NON-NLS-1$

    /** Operation: oclIsKindOf */
    public final static String OP_OCLISKINDOF = "oclIsKindOf"; //$NON-NLS-1$

    /** Operation: oclIsNew */
    public final static String OP_OCLISNEW = "oclIsNew"; //$NON-NLS-1$

    /** Operation: oclIsTypeOf */
    public final static String OP_OCLISTYPEOF = "oclIsTypeOf"; //$NON-NLS-1$

    /** Operation: oclIsUndefined */
    public final static String OP_OCLISUNDEFINED = "oclIsUndefined"; //$NON-NLS-1$


    /** Operation: one */
    public final static String OP_ONE = "one"; //$NON-NLS-1$


    /** Operation: or */
    public final static String OP_OR = "or"; //$NON-NLS-1$

    /** Operation: plus */
    public final static String OP_PLUS = "plus"; //$NON-NLS-1$

    /** Operation: plusStdLib */
    public final static String OP_PLUSSTDLIB = "plusStdLib"; //$NON-NLS-1$

    /** Operation: prepend */
    public final static String OP_PREPEND = "prepend"; //$NON-NLS-1$

    /** Operation: product */
    public final static String OP_PRODUCT = "product"; //$NON-NLS-1$

    /** Operation: reject */
    public final static String OP_REJECT = "reject"; //$NON-NLS-1$

    /** Operation: round */
    public final static String OP_ROUND = "round"; //$NON-NLS-1$

    /** Operation: select */
    public final static String OP_SELECT = "select"; //$NON-NLS-1$

    /** Operation: size */
    public final static String OP_SIZE = "size"; //$NON-NLS-1$

    /** Operation: sortedBy */
    public final static String OP_SORTEDBY = "sortedBy"; //$NON-NLS-1$

    /** Operation: subOrderedSet */
    public final static String OP_SUBORDEREDSET = "subOrderedSet"; //$NON-NLS-1$

    /** Operation: subSequence */
    public final static String OP_SUBSEQUENCE = "subSequence"; //$NON-NLS-1$

    /** Operation: subString */
    public final static String OP_SUBSTRING = "subString"; //$NON-NLS-1$

    /** Operation: sum */
    public final static String OP_SUM = "sum"; //$NON-NLS-1$

    /** Operation: symmetricDifference */
    public final static String OP_SYMMDIF = "symmetricDifference"; //$NON-NLS-1$

    /** Operation: toDouble */
    public final static String OP_TODOUBLE = "toDouble"; //$NON-NLS-1$

    /** Operation: toFloat */
    public final static String OP_TOFLOAT = "toFloat"; //$NON-NLS-1$

    /** Operation: toInteger */
    public final static String OP_TOINTEGER = "toInteger"; //$NON-NLS-1$

    /** Operation: toLong */
    public final static String OP_TOLONG = "toLong"; //$NON-NLS-1$

    /** Operation: toLowerCase */
    public final static String OP_TOLOWER = "toLowerCase"; //$NON-NLS-1$

    /** Operation: toString */
    public final static String OP_TOSTRING = "toString"; //$NON-NLS-1$

    /** Operation: toUpperCase */
    public final static String OP_TOUPPER = "toUpperCase"; //$NON-NLS-1$

    /** Operation: union */
    public final static String OP_UNION = "union"; //$NON-NLS-1$

    /** Operation: xor */
    public final static String OP_XOR = "xor"; //$NON-NLS-1$

    /** Package: Model */
    public final static String P_MODEL = "Model"; //$NON-NLS-1$

    /** Package: OCL */
    public final static String P_OCL = "OCL"; //$NON-NLS-1$

    /** Package: StdLibrary */
    public final static String P_STDLIBRARY = "StdLibrary"; //$NON-NLS-1$

    /** Parameter: result */
    public final static String PAR_RESULT = "result"; //$NON-NLS-1$

    /** Parameter: return */
    public final static String PAR_RETURN = "return"; //$NON-NLS-1$

    /** PathSeparaator (::) */
    public final static String PATHSEP = "::"; //$NON-NLS-1$

    /** Package: PrimitiveTypes */
    public final static String PKG_PRTP = "PrimitiveTypes"; //$NON-NLS-1$

    /** Space (" ") */
    public final static String SPACE = " "; //$NON-NLS-1$

    /** Used to determine if a type is a standard library type: StdLib */
    public final static String STDLIBSUBTRING = "StdLib"; //$NON-NLS-1$

    /** Suffix: StdLib */
    public final static String STDLIBSUFFIX = "StdLib"; //$NON-NLS-1$

    /** Type: AssociationEnd */
    public final static String T_ASSOCIATIONEND = "AssociationEnd"; //$NON-NLS-1$

    /** Type: Attribute */
    public final static String T_ATTRIBUTE = "Attribute"; //$NON-NLS-1$

    /** Type: Bag */
    public final static String T_BAG = "Bag"; //$NON-NLS-1$

    /** Type: BagTypeStdLib */
    public final static String T_BAGTYPESTDLIB = "BagTypeStdLib"; //$NON-NLS-1$

    /** Type: Boolean */
    public final static String T_BOOLEAN = "Boolean"; //$NON-NLS-1$

    /** Type: BooleanStdLib */
    public final static String T_BOOLEANSTDLIB = "BooleanStdLib"; //$NON-NLS-1$

    /** Type: Classifier */
    public final static String T_CLASSIFIER = "Classifier"; //$NON-NLS-1$

    /** Type: Collection */
    public final static String T_COLLECTION = "Collection"; //$NON-NLS-1$

    /** Type: CollectionTypeStdLib */
    public final static String T_COLLTYPESTDLIB = "CollectionTypeStdLib"; //$NON-NLS-1$

    /** Type: Double */
    public final static String T_DOUBLE = "Double"; //$NON-NLS-1$

    /** Type: DoubleStdLib */
    public final static String T_DOUBLESTDLIB = "DoubleStdLib"; //$NON-NLS-1$

    /** Type: Element */
    public final static String T_ELEMENT = "Element"; //$NON-NLS-1$

    /** Type: Float */
    public final static String T_FLOAT = "Float"; //$NON-NLS-1$

    /** Type: FloatStdLib */
    public final static String T_FLOATSTDLIB = "FloatStdLib"; //$NON-NLS-1$

    /** Type: Integer */
    public final static String T_INTEGER = "Integer"; //$NON-NLS-1$

    /** Type: IntegerStdLib */
    public final static String T_INTEGERSTDLIB = "IntegerStdLib"; //$NON-NLS-1$

    /** Type: Long */
    public final static String T_LONG = "Long"; //$NON-NLS-1$

    /** Type: LongStdLib */
    public final static String T_LONGSTDLIB = "LongStdLib"; //$NON-NLS-1$

    /** Type: MultiplicityType */
    public final static String T_MULTIPLICITYTYPE = "MultiplicityType"; //$NON-NLS-1$

    /** Type: OclAny */
    public final static String T_OCLANY = "OclAny"; //$NON-NLS-1$

    /** Type: OclAnyStdLib */
    public final static String T_OCLANYSTDLIB = "OclAnyStdLib"; //$NON-NLS-1$

    /** Type: OclInvalid */
    public final static String T_OCLINVALID = "OclInvalid"; //$NON-NLS-1$

    /** Type: OclInvalidStdLib */
    public final static String T_OCLINVALIDSTDLIB = "OclInvalidStdLib"; //$NON-NLS-1$

    /** Type: OclType */
    public final static String T_OCLTYPE = "OclType"; //$NON-NLS-1$

    /** Type: OclTypeStdLib */
    public final static String T_OCLTYPESTDLIB = "OclTypeStdLib"; //$NON-NLS-1$

    /** Type: OclUndefined */
    public final static String T_OCLUNDEFINED = "OclUndefined"; //$NON-NLS-1$

    /** Type: OclVoid */
    public final static String T_OCLVOID = "OclVoid"; //$NON-NLS-1$

    /** Type: OclVoidStdLib */
    public final static String T_OCLVOIDSTDLIB = "OclVoidStdLib"; //$NON-NLS-1$

    /** Type: OrderedSet */
    public final static String T_ORDEREDSET = "OrderedSet"; //$NON-NLS-1$

    /** Type: OrderedSetTypeStdLib */
    public final static String T_ORDEREDSETTYPESTDLIB = "OrderedSetTypeStdLib"; //$NON-NLS-1$

    /** Type: Parameter */
    public final static String T_PARAMETER = "Parameter"; //$NON-NLS-1$

    /** Type: Real */
    public final static String T_REAL = "Real"; //$NON-NLS-1$

    /** Type: Reference */
    public final static String T_REFERENCE = "Reference"; //$NON-NLS-1$

    /** Type: Reflect */
    public final static String T_REFLECT = "Reflect"; //$NON-NLS-1$

    /** Type: Sequence */
    public final static String T_SEQUENCE = "Sequence"; //$NON-NLS-1$


    /** Type: SequenceTypeStdLib */
    public final static String T_SEQUENCETYPESTDLIB = "SequenceTypeStdLib"; //$NON-NLS-1$

    /** Type: Set */
    public final static String T_SET = "Set"; //$NON-NLS-1$

    /** Type: SetTypeStdLib */
    public final static String T_SETTYPESTDLIB = "SetTypeStdLib"; //$NON-NLS-1$

    /** Type: String */
    public final static String T_STRING = "String"; //$NON-NLS-1$

    /** Type: StringStdLib */
    public final static String T_STRINGSTDLIB = "StringStdLib"; //$NON-NLS-1$

    /** Type: StructuralFeature */
    public final static String T_STRUCTURALFEATURE = "StructuralFeature"; //$NON-NLS-1$

    /** Tag for attaching the operation body */
    public final static String TAG_OPBODY = "org.omg.sap2mof.OperationCodeOcl"; //$NON-NLS-1$

    /** Tag: sap2mof.violationMessageExpression */
    public final static String TAG_VIOLATIONMESSAGE = "sap2mof.violationMessageExpression"; //$NON-NLS-1$

    /** true */
    public final static String TRUE = "true"; //$NON-NLS-1$

    /** <undefined> */
    public final static String UNDEFINED = "<undefined>"; //$NON-NLS-1$

    /** Variable: invalid */
    public final static String VAR_INVALID = "invalid"; //$NON-NLS-1$

    /** Variable: null */
    public final static String VAR_NULL = "null"; //$NON-NLS-1$

    /** Variable: result */
    public final static String VAR_RESULT = "result"; //$NON-NLS-1$

    /** Variable: self */
    public final static String VAR_SELF = "self"; //$NON-NLS-1$

    /** Used to split the tag into violation messages: // */
    public final static String VIOLATIONMESSAGEEXPSPLITTER = "//"; //$NON-NLS-1$


}
