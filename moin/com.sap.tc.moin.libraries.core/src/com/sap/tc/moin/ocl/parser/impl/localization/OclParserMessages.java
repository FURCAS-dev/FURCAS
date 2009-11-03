package com.sap.tc.moin.ocl.parser.impl.localization;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>moin_ocl_parser_0302_XMSG: "@pre" is only allowed in post conditions</li>
 * <li>moin_ocl_parser_0301_XMSG: "@pre" not allowed after "->"</li>
 * <li>moin_ocl_parser_0303_XMSG: "oclIsNew"-operation only allowed in post conditions</li>
 * <li>moin_ocl_parser_0100_XMSG: "{0}" is ambiguous</li>
 * <li>moin_ocl_parser_0101_XMSG: "{0}" is ambiguous. Variable "{1}" is used. Please use "{2}" if you want to refer to the attribute or association end</li>
 * <li>ReturnTypeResult_XMSG: A return type evaluates to a classifier or path name</li>
 * <li>ExplicitAssignmentResult_XMSG: An explicit type assignment evaluates to a classifier or path name</li>
 * <li>moin_ocl_parser_1029_XMSG: Argument of library operation "{0}" has to be a type expression</li>
 * <li>moin_ocl_parser_1030_XMSG: Argument of operation "{0}" had type "{1}", but is expected to be compatible with the element type "{2}" of the source collection</li>
 * <li>moin_ocl_parser_0701_XMSG: Attribute, Reference or AssociationEnd "{0}" not found on type "{1}"</li>
 * <li>moin_ocl_parser_0510_XMSG: Cannot define "{0}" because there already is an Attribute or Reference with the same name</li>
 * <li>moin_ocl_parser_0511_XMSG: Cannot define "{0}" because there already is an Operation with the same name</li>
 * <li>moin_ocl_parser_1006_XMSG: Class "{0}" has more than one AssociationEnds with name "{1}"</li>
 * <li>moin_ocl_parser_0702_XMSG: Condition is not of type Boolean</li>
 * <li>moin_ocl_parser_0715_XMSG: Constant "{0}" has unsupported type "{1}"</li>
 * <li>moin_ocl_parser_0504_XMSG: Context "{0}" does not match default context "{1}"</li>
 * <li>moin_ocl_parser_0501_XMSG: Context "{0}" not found</li>
 * <li>moin_ocl_parser_1023_XMSG: Context declaration for Operation "{0}" requires fully qualified Classifier</li>
 * <li>moin_ocl_parser_1000_XMSG: Context is not an instance of Classifier</li>
 * <li>OnlyOneInvPerConstraint_XMSG: Currently MOIN only supports one invariant per constraint; due to this, there may be one package declaration at most</li>
 * <li>moin_ocl_parser_0103_XMSG: Enumeration "{0}" does not have a enumeration literal "{1}"</li>
 * <li>VarDecExpected_XMSG: Expected variable declarations</li>
 * <li>NoInput_XMSG: Expression could not be parsed since no input was provided</li>
 * <li>moin_ocl_parser_1022_XMSG: Feature "{0}" is currently not supported. Contact your OCL team.</li>
 * <li>moin_ocl_parser_0203_XMSG: Feature {0} of classifier {1} can not be used as it is of unknown type</li>
 * <li>moin_ocl_parser_1028_XMSG: Found a comparison between two expressions of type "{0}" and type "{1}" respectively, but these are not mutually compatible</li>
 * <li>moin_ocl_parser_1025_XMSG: Identifier "{0}" could not be resolved as a variable, feature, type, enumeration literal, or global constant </li>
 * <li>moin_ocl_parser_0502_XMSG: Invariants, pre or post conditions must have a Boolean type</li>
 * <li>moin_ocl_parser_0705_XMSG: Items in a range must conform to Integer</li>
 * <li>moin_ocl_parser_0607_XMSG: Iterator variable "{0}:{1}" must conform to the element type of the source collection "{2}"</li>
 * <li>moin_ocl_parser_0606_XMSG: Iterator variable "{0}:{1}" must conform to the type of the body "{2}"</li>
 * <li>moin_ocl_parser_1026_XMSG: MOF-modelled operation "{0}" overrides a library operation with the same signature</li>
 * <li>MultiArgNotListOrExpr_XMSG: MutipleArgument is not an instance of OclExpression or List</li>
 * <li>moin_ocl_parser_1021_XMSG: No "@pre" allowed here</li>
 * <li>moin_ocl_parser_1009_XMSG: No Association "{0}" found</li>
 * <li>moin_ocl_parser_1010_XMSG: No AssociationEnd "{0}" found in Association "{1}"</li>
 * <li>moin_ocl_parser_1020_XMSG: No association qualifier allowed here</li>
 * <li>moin_ocl_parser_0704_XMSG: No common supertype can be found for "{0}" and "{1}" in CollectionRange</li>
 * <li>moin_ocl_parser_0703_XMSG: No common supertype can be found for "{0}" and "{1}" in IfExpression</li>
 * <li>moin_ocl_parser_1007_XMSG: No feature "{0}" found on type "{1}"</li>
 * <li>moin_ocl_parser_1013_XMSG: No implicit attribute with name "{0}" was found</li>
 * <li>moin_ocl_parser_1011_XMSG: No implicit source for AssociationEnd "{0}" was found</li>
 * <li>moin_ocl_parser_1016_XMSG: No implicit source for OperationCall "{0}" was found</li>
 * <li>moin_ocl_parser_1018_XMSG: No return parameter was defined for operation {0}</li>
 * <li>moin_ocl_parser_1005_XMSG: No variable scope to leave</li>
 * <li>moin_ocl_parser_1024_XMSG: Non-qualified operation name expected for def instead of "{0}"</li>
 * <li>moin_ocl_parser_1100_XMSG: OCL Standard Library could not be found</li>
 * <li>moin_ocl_parser_1019_XMSG: Only Attributes and StructureFields allowed as context</li>
 * <li>moin_ocl_parser_0512_XMSG: Only Attributes or References allowed as context</li>
 * <li>moin_ocl_parser_0514_XMSG: Only Operations allowed as context</li>
 * <li>moin_ocl_parser_1017_XMSG: Operation "{0} ({1})" is not side-effect free</li>
 * <li>moin_ocl_parser_0402_XMSG: Operation "{0} ({2})" not found on type "{1}"</li>
 * <li>moin_ocl_parser_0403_XMSG: Operation "{0}" has wrong number of arguments</li>
 * <li>moin_ocl_parser_1031_XMSG: Operation "{0}" is provided with collections whose element types are "{1}" and "{2}", but these are mutually incompatible</li>
 * <li>moin_ocl_parser_1032_XMSG: Operation "{0}" on type "{1}" is not defined on an argument of type "{2}"</li>
 * <li>moin_ocl_parser_0507_XMSG: Package "{0}" not found</li>
 * <li>moin_ocl_parser_0505_XMSG: Parser has not been supplied with a context and the to-be-parsed expression does not contain one, either</li>
 * <li>moin_ocl_parser_0506_XMSG: Parser has not been supplied with a type package and the to-be-parsed expression does not contain one either</li>
 * <li>moin_ocl_parser_0900_XMSG: Parsing failed due to errors</li>
 * <li>ParseDuration_XMSG: Parsing took {0} milliseconds</li>
 * <li>moin_ocl_parser_0003_XMSG: Path name "{0}" does not identify an operation</li>
 * <li>moin_ocl_parser_0002_XMSG: Path name "{0}" is not allowed</li>
 * <li>moin_ocl_parser_0730_XMSG: Property "{0}" is not an Attribute, Reference, or AssociationEnd of type "{1}"</li>
 * <li>StdLibTypeNotFound_XMSG: Standard library type not found in standard library package</li>
 * <li>StartParseErrorTolerant_XMSG: Start error-tolerant parser with expression: "{0}"</li>
 * <li>StartParseExpr_XMSG: Start parser with expression: "{0}"</li>
 * <li>moin_ocl_parser_0508_XMSG: Supplied defaultPackage "{0}" does not match the package in the OclStatement "{1}"</li>
 * <li>moin_ocl_parser_1001_XMSG: Supplied list of packages contains "null"</li>
 * <li>moin_ocl_parser_1002_XMSG: Supplied list of packages contains duplicate package "{0}"</li>
 * <li>moin_ocl_parser_0707_XMSG: Tuple part "{0}" must be initialized</li>
 * <li>moin_ocl_parser_0708_XMSG: Tuple part definition "{0}" must not be initialized</li>
 * <li>moin_ocl_parser_0709_XMSG: Tuple parts must have unique names</li>
 * <li>moin_ocl_parser_1008_XMSG: Type "{0}" does not conform to Type of AssociationEnd "{1}"</li>
 * <li>moin_ocl_parser_0711_XMSG: Type "{0}" does not conform to type "{1}"</li>
 * <li>moin_ocl_parser_0710_XMSG: Type "{0}" not found</li>
 * <li>moin_ocl_parser_0712_XMSG: Type "{0}" of the init expression does not match the given Type "{1}"</li>
 * <li>TypeListMustBeClassifier_XMSG: Type literals have to Classifiers</li>
 * <li>moin_ocl_parser_0718_XMSG: Type of expression "{0}" does not conform to the return type of operation "{1}"</li>
 * <li>moin_ocl_parser_0720_XMSG: Type of the expression "{0}" does not conform to the type of the Attribute or AssociationEnd "{1}"</li>
 * <li>moin_ocl_parser_0717_XMSG: Typecast to "{0}" not allowed because "{0}" is not a sub or super type of "{1}"</li>
 * <li>UnexpectedPropsReturnedToArgs_XMSG: Unexcpected properties returned to Arguments</li>
 * <li>UnexpectedNodeInTuple_XMSG: Unexpected node in tuple</li>
 * <li>UnexpectedPrimTypeForConst_XMSG: Unexpected primitive type for model-defined constant</li>
 * <li>TypePathNameUnexpectedProperty_XMSG: Unexpected property for typePathName property</li>
 * <li>UnexpectedPropForArguments_XMSG: Unexpected property returned to arguments</li>
 * <li>moin_ocl_parser_0713_XMSG: Unknown CollectionType "{0}"</li>
 * <li>moin_ocl_parser_0800_XMSG: User defined parameter "{0}" does not match the parameter name "{1}" supplied by the model</li>
 * <li>moin_ocl_parser_1027_XMSG: User-defined operation "{0}" overrides a library or MOF operation with the same signature</li>
 * <li>moin_ocl_parser_0202_XMSG: Variable "{0}" is already defined in current scope</li>
 * <li>VarAssignmentReturnVarDecs_XMSG: Variable assignment should only return variable declarations or lists thereof</li>
 * <li>VarPathNameMustBeList_XMSG: Variable path name has to be a List</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from OclParserMessages.properties
 */
 
public enum OclParserMessages implements MoinLocalizedString {


    /**
     * Message: "An explicit type assignment evaluates to a classifier or path name"
     */
    EXPLICITASSIGNMENTRESULT("ExplicitAssignmentResult_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MutipleArgument is not an instance of OclExpression or List"
     */
    MULTIARGNOTLISTOREXPR("MultiArgNotListOrExpr_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Expression could not be parsed since no input was provided"
     */
    NOINPUT("NoInput_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Currently MOIN only supports one invariant per constraint; due to this, there may be one package declaration at most"
     */
    ONLYONEINVPERCONSTRAINT("OnlyOneInvPerConstraint_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Parsing took {0} milliseconds"
     */
    PARSEDURATION("ParseDuration_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A return type evaluates to a classifier or path name"
     */
    RETURNTYPERESULT("ReturnTypeResult_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Start error-tolerant parser with expression: "{0}""
     */
    STARTPARSEERRORTOLERANT("StartParseErrorTolerant_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Start parser with expression: "{0}""
     */
    STARTPARSEEXPR("StartParseExpr_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Standard library type not found in standard library package"
     */
    STDLIBTYPENOTFOUND("StdLibTypeNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type literals have to Classifiers"
     */
    TYPELISTMUSTBECLASSIFIER("TypeListMustBeClassifier_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected property for typePathName property"
     */
    TYPEPATHNAMEUNEXPECTEDPROPERTY("TypePathNameUnexpectedProperty_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected node in tuple"
     */
    UNEXPECTEDNODEINTUPLE("UnexpectedNodeInTuple_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected primitive type for model-defined constant"
     */
    UNEXPECTEDPRIMTYPEFORCONST("UnexpectedPrimTypeForConst_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected property returned to arguments"
     */
    UNEXPECTEDPROPFORARGUMENTS("UnexpectedPropForArguments_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected property returned to arguments"
     */
    UNEXPECTEDPROPERTYVISITARGUMENTS("UnexpectedPropertyVisitArguments_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexcpected properties returned to Arguments"
     */
    UNEXPECTEDPROPSRETURNEDTOARGS("UnexpectedPropsReturnedToArgs_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Variable assignment should only return variable declarations or lists thereof"
     */
    VARASSIGNMENTRETURNVARDECS("VarAssignmentReturnVarDecs_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Expected variable declarations"
     */
    VARDECEXPECTED("VarDecExpected_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Variable path name has to be a List"
     */
    VARPATHNAMEMUSTBELIST("VarPathNameMustBeList_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Path name "{0}" is not allowed"
     */
    MOIN_OCL_PARSER_0002("moin_ocl_parser_0002_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Path name "{0}" does not identify an operation"
     */
    MOIN_OCL_PARSER_0003("moin_ocl_parser_0003_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""{0}" is ambiguous"
     */
    MOIN_OCL_PARSER_0100("moin_ocl_parser_0100_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""{0}" is ambiguous. Variable "{1}" is used. Please use "{2}" if you want to refer to the attribute or association end"
     */
    MOIN_OCL_PARSER_0101("moin_ocl_parser_0101_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Enumeration "{0}" does not have a enumeration literal "{1}""
     */
    MOIN_OCL_PARSER_0103("moin_ocl_parser_0103_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Variable "{0}" is already defined in current scope"
     */
    MOIN_OCL_PARSER_0202("moin_ocl_parser_0202_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Feature {0} of classifier {1} can not be used as it is of unknown type"
     */
    MOIN_OCL_PARSER_0203("moin_ocl_parser_0203_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""@pre" not allowed after "->""
     */
    MOIN_OCL_PARSER_0301("moin_ocl_parser_0301_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""@pre" is only allowed in post conditions"
     */
    MOIN_OCL_PARSER_0302("moin_ocl_parser_0302_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""oclIsNew"-operation only allowed in post conditions"
     */
    MOIN_OCL_PARSER_0303("moin_ocl_parser_0303_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Operation "{0} ({2})" not found on type "{1}""
     */
    MOIN_OCL_PARSER_0402("moin_ocl_parser_0402_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Operation "{0}" has wrong number of arguments"
     */
    MOIN_OCL_PARSER_0403("moin_ocl_parser_0403_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Context "{0}" not found"
     */
    MOIN_OCL_PARSER_0501("moin_ocl_parser_0501_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Invariants, pre or post conditions must have a Boolean type"
     */
    MOIN_OCL_PARSER_0502("moin_ocl_parser_0502_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Context "{0}" does not match default context "{1}""
     */
    MOIN_OCL_PARSER_0504("moin_ocl_parser_0504_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Parser has not been supplied with a context and the to-be-parsed expression does not contain one, either"
     */
    MOIN_OCL_PARSER_0505("moin_ocl_parser_0505_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Parser has not been supplied with a type package and the to-be-parsed expression does not contain one either"
     */
    MOIN_OCL_PARSER_0506("moin_ocl_parser_0506_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Package "{0}" not found"
     */
    MOIN_OCL_PARSER_0507("moin_ocl_parser_0507_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Supplied defaultPackage "{0}" does not match the package in the OclStatement "{1}""
     */
    MOIN_OCL_PARSER_0508("moin_ocl_parser_0508_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot define "{0}" because there already is an Attribute or Reference with the same name"
     */
    MOIN_OCL_PARSER_0510("moin_ocl_parser_0510_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot define "{0}" because there already is an Operation with the same name"
     */
    MOIN_OCL_PARSER_0511("moin_ocl_parser_0511_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Only Attributes or References allowed as context"
     */
    MOIN_OCL_PARSER_0512("moin_ocl_parser_0512_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Only Operations allowed as context"
     */
    MOIN_OCL_PARSER_0514("moin_ocl_parser_0514_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Iterator variable "{0}:{1}" must conform to the type of the body "{2}""
     */
    MOIN_OCL_PARSER_0606("moin_ocl_parser_0606_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Iterator variable "{0}:{1}" must conform to the element type of the source collection "{2}""
     */
    MOIN_OCL_PARSER_0607("moin_ocl_parser_0607_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Attribute, Reference or AssociationEnd "{0}" not found on type "{1}""
     */
    MOIN_OCL_PARSER_0701("moin_ocl_parser_0701_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Condition is not of type Boolean"
     */
    MOIN_OCL_PARSER_0702("moin_ocl_parser_0702_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No common supertype can be found for "{0}" and "{1}" in IfExpression"
     */
    MOIN_OCL_PARSER_0703("moin_ocl_parser_0703_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No common supertype can be found for "{0}" and "{1}" in CollectionRange"
     */
    MOIN_OCL_PARSER_0704("moin_ocl_parser_0704_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Items in a range must conform to Integer"
     */
    MOIN_OCL_PARSER_0705("moin_ocl_parser_0705_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Tuple part "{0}" must be initialized"
     */
    MOIN_OCL_PARSER_0707("moin_ocl_parser_0707_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Tuple part definition "{0}" must not be initialized"
     */
    MOIN_OCL_PARSER_0708("moin_ocl_parser_0708_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Tuple parts must have unique names"
     */
    MOIN_OCL_PARSER_0709("moin_ocl_parser_0709_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type "{0}" not found"
     */
    MOIN_OCL_PARSER_0710("moin_ocl_parser_0710_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type "{0}" does not conform to type "{1}""
     */
    MOIN_OCL_PARSER_0711("moin_ocl_parser_0711_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type "{0}" of the init expression does not match the given Type "{1}""
     */
    MOIN_OCL_PARSER_0712("moin_ocl_parser_0712_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unknown CollectionType "{0}""
     */
    MOIN_OCL_PARSER_0713("moin_ocl_parser_0713_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Constant "{0}" has unsupported type "{1}""
     */
    MOIN_OCL_PARSER_0715("moin_ocl_parser_0715_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Typecast to "{0}" not allowed because "{0}" is not a sub or super type of "{1}""
     */
    MOIN_OCL_PARSER_0717("moin_ocl_parser_0717_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of expression "{0}" does not conform to the return type of operation "{1}""
     */
    MOIN_OCL_PARSER_0718("moin_ocl_parser_0718_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of the expression "{0}" does not conform to the type of the Attribute or AssociationEnd "{1}""
     */
    MOIN_OCL_PARSER_0720("moin_ocl_parser_0720_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Property "{0}" is not an Attribute, Reference, or AssociationEnd of type "{1}""
     */
    MOIN_OCL_PARSER_0730("moin_ocl_parser_0730_XMSG"), //$NON-NLS-1$

    /**
     * Message: "User defined parameter "{0}" does not match the parameter name "{1}" supplied by the model"
     */
    MOIN_OCL_PARSER_0800("moin_ocl_parser_0800_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Parsing failed due to errors"
     */
    MOIN_OCL_PARSER_0900("moin_ocl_parser_0900_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Context is not an instance of Classifier"
     */
    MOIN_OCL_PARSER_1000("moin_ocl_parser_1000_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Supplied list of packages contains "null""
     */
    MOIN_OCL_PARSER_1001("moin_ocl_parser_1001_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Supplied list of packages contains duplicate package "{0}""
     */
    MOIN_OCL_PARSER_1002("moin_ocl_parser_1002_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No variable scope to leave"
     */
    MOIN_OCL_PARSER_1005("moin_ocl_parser_1005_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Class "{0}" has more than one AssociationEnds with name "{1}""
     */
    MOIN_OCL_PARSER_1006("moin_ocl_parser_1006_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No feature "{0}" found on type "{1}""
     */
    MOIN_OCL_PARSER_1007("moin_ocl_parser_1007_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type "{0}" does not conform to Type of AssociationEnd "{1}""
     */
    MOIN_OCL_PARSER_1008("moin_ocl_parser_1008_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No Association "{0}" found"
     */
    MOIN_OCL_PARSER_1009("moin_ocl_parser_1009_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No AssociationEnd "{0}" found in Association "{1}""
     */
    MOIN_OCL_PARSER_1010("moin_ocl_parser_1010_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No implicit source for AssociationEnd "{0}" was found"
     */
    MOIN_OCL_PARSER_1011("moin_ocl_parser_1011_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No implicit attribute with name "{0}" was found"
     */
    MOIN_OCL_PARSER_1013("moin_ocl_parser_1013_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No implicit source for OperationCall "{0}" was found"
     */
    MOIN_OCL_PARSER_1016("moin_ocl_parser_1016_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Operation "{0} ({1})" is not side-effect free"
     */
    MOIN_OCL_PARSER_1017("moin_ocl_parser_1017_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No return parameter was defined for operation {0}"
     */
    MOIN_OCL_PARSER_1018("moin_ocl_parser_1018_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Only Attributes and StructureFields allowed as context"
     */
    MOIN_OCL_PARSER_1019("moin_ocl_parser_1019_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No association qualifier allowed here"
     */
    MOIN_OCL_PARSER_1020("moin_ocl_parser_1020_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No "@pre" allowed here"
     */
    MOIN_OCL_PARSER_1021("moin_ocl_parser_1021_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Feature "{0}" is currently not supported. Contact your OCL team."
     */
    MOIN_OCL_PARSER_1022("moin_ocl_parser_1022_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Context declaration for Operation "{0}" requires fully qualified Classifier"
     */
    MOIN_OCL_PARSER_1023("moin_ocl_parser_1023_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Non-qualified operation name expected for def instead of "{0}""
     */
    MOIN_OCL_PARSER_1024("moin_ocl_parser_1024_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Identifier "{0}" could not be resolved as a variable, feature, type, enumeration literal, or global constant "
     */
    MOIN_OCL_PARSER_1025("moin_ocl_parser_1025_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MOF-modelled operation "{0}" overrides a library operation with the same signature"
     */
    MOIN_OCL_PARSER_1026("moin_ocl_parser_1026_XMSG"), //$NON-NLS-1$

    /**
     * Message: "User-defined operation "{0}" overrides a library or MOF operation with the same signature"
     */
    MOIN_OCL_PARSER_1027("moin_ocl_parser_1027_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Found a comparison between two expressions of type "{0}" and type "{1}" respectively, but these are not mutually compatible"
     */
    MOIN_OCL_PARSER_1028("moin_ocl_parser_1028_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Argument of library operation "{0}" has to be a type expression"
     */
    MOIN_OCL_PARSER_1029("moin_ocl_parser_1029_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Argument of operation "{0}" had type "{1}", but is expected to be compatible with the element type "{2}" of the source collection"
     */
    MOIN_OCL_PARSER_1030("moin_ocl_parser_1030_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Operation "{0}" is provided with collections whose element types are "{1}" and "{2}", but these are mutually incompatible"
     */
    MOIN_OCL_PARSER_1031("moin_ocl_parser_1031_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Operation "{0}" on type "{1}" is not defined on an argument of type "{2}""
     */
    MOIN_OCL_PARSER_1032("moin_ocl_parser_1032_XMSG"), //$NON-NLS-1$

    /**
     * Message: "OCL Standard Library could not be found"
     */
    MOIN_OCL_PARSER_1100("moin_ocl_parser_1100_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( OclParserMessages.class );

    private final String myKey;

    private OclParserMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + OclParserMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  