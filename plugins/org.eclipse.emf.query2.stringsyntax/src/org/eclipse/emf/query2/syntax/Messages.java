package org.eclipse.emf.query2.syntax;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.emf.query2.syntax.messages"; //$NON-NLS-1$

	public static String Query2StringSyntax_QueryJavaValidator_EStringAttributesOrReferences;
	public static String Query2StringSyntax_QueryJavaValidator_IncompatibleAliasType;
	public static String Query2StringSyntax_QueryJavaValidator_IncompatibleResults;
	public static String Query2StringSyntax_QueryJavaValidator_IncompatibleTypeOnlyFloatOrDoubleAllowed;
	public static String Query2StringSyntax_QueryJavaValidator_IncompatibleTypeOnlyIntOrLong;
	public static String Query2StringSyntax_QueryJavaValidator_IncompatibleTypeOnlyStringAllowed;
	public static String Query2StringSyntax_QueryJavaValidator_NotLikeNotSupportedForStrings;
	public static String Query2StringSyntax_QueryJavaValidator_OnlyEClassesAllowedAsResults;
	public static String Query2StringSyntax_QueryJavaValidator_OnlyEqualsAllowed;
	public static String Query2StringSyntax_QueryJavaValidator_OnlyEqualsAndNotEqualsAllowedIfAliasOnRHS;
	public static String Query2StringSyntax_QueryJavaValidator_OnlyEqualsAndNotEqualsAllowedIfNullIsOnRHS;
	public static String Query2StringSyntax_QueryJavaValidator_OnlyInAndNotInAllowedForQueriesOnRHS;
	public static String Query2StringSyntax_QueryJavaValidator_OnlyOneSelectEntryIsAllowed;
	public static String Query2StringSyntax_QueryJavaValidator_QueryExecutionOnSameAlias;
	public static String Query2StringSyntax_QueryJavaValidator_ReferenceOnLHS;
	public static String Query2StringSyntax_QueryJavaValidator_UnknownType;
	public static String Query2StringSyntax_QueryJavaValidator_WrongComparisonOperator;
	public static String Query2StringSyntax_QueryJavaValidator_WrongComparisonOperatorOnlyComparisonAllowed;
	public static String Query2StringSyntax_QueryJavaValidator_WrongComparisonOperatorOnlyLikeAndNotLikeAllowed;
	public static String Query2StringSyntax_QueryTransformer_UnexpectedOperator;
	public static String Query2StringSyntax_QueryTransformer_UnknownValue;
	public static String Query2StringSyntax_QueryTypeConverter_CouldNotConvertStringToInt;
	public static String Query2StringSyntax_QueryTypeConverter_CouldNotConvertStringToNumber;

	static {
		// Initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

	public static String getString(String parameterizedString, String params[]) {
		return NLS.bind(parameterizedString, params);
	}
}
