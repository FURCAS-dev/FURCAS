package com.sap.ide.cts.editor.allsuites;

import org.junit.runner.RunWith;

import com.sap.furcas.test.util.ExtSuite;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorAbstractMainTemplateSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorAbstractTemplateSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorAfterIncompleteTokenSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorAlternativeIsMultiSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorAlternativeSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorAsPargSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorCommentSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorConditionalSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorCustomSeparatorSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorEndOfTokenProposalSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorEnumerationSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorForcedLowerPargSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorForcedUpperPargSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorFunctionCallSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorInjectorActionSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorLiteralSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorModesSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorOperatorMainTemplatelBracketSequence;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorOperatorMainTemplatelSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorOperatorTemplatelBracketSequence;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorOperatorTemplatelSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorPrimitivePropertySimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorQueryAndRefersToSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorRefersToSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorSeparatorSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorTemplateProposalsSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorUnlexedTokenPrefixFilterSimple;
import com.sap.ide.cts.editor.contentassist.processor.TestCtsContentAssistProcessorUnlexedTokenPrefixFilterStartOfFileSimple;

/**
 * Run only the editor.test.metamodel based content assist processor tests.
 * These are all included in the ContentAssist suite.
 * 
 * @author C5126871
 * 
 */
@RunWith(ExtSuite.class)
@ExtSuite.SuiteClasses( {
		TestCtsContentAssistProcessorEnumerationSimple.class,
		TestCtsContentAssistProcessorLiteralSimple.class,
		TestCtsContentAssistProcessorPrimitivePropertySimple.class,
		TestCtsContentAssistProcessorFunctionCallSimple.class,
		TestCtsContentAssistProcessorTemplateProposalsSimple.class,
		TestCtsContentAssistProcessorSeparatorSimple.class,
		TestCtsContentAssistProcessorAbstractTemplateSimple.class,
		TestCtsContentAssistProcessorRefersToSimple.class,
		TestCtsContentAssistProcessorQueryAndRefersToSimple.class,
		TestCtsContentAssistProcessorModesSimple.class,
		TestCtsContentAssistProcessorOperatorTemplatelSimple.class,
		TestCtsContentAssistProcessorOperatorTemplatelBracketSequence.class,
		TestCtsContentAssistProcessorOperatorMainTemplatelSimple.class,
		TestCtsContentAssistProcessorOperatorMainTemplatelBracketSequence.class,
		TestCtsContentAssistProcessorAbstractMainTemplateSimple.class,
		TestCtsContentAssistProcessorCustomSeparatorSimple.class,
		TestCtsContentAssistProcessorInjectorActionSimple.class,
		TestCtsContentAssistProcessorConditionalSimple.class,
		TestCtsContentAssistProcessorAsPargSimple.class,
		TestCtsContentAssistProcessorEndOfTokenProposalSimple.class,
		TestCtsContentAssistProcessorForcedUpperPargSimple.class,
		TestCtsContentAssistProcessorForcedLowerPargSimple.class,
		TestCtsContentAssistProcessorAlternativeSimple.class,
		TestCtsContentAssistProcessorAfterIncompleteTokenSimple.class,
		TestCtsContentAssistProcessorUnlexedTokenPrefixFilterSimple.class,
		TestCtsContentAssistProcessorUnlexedTokenPrefixFilterStartOfFileSimple.class,
		TestCtsContentAssistProcessorCommentSimple.class,
		TestCtsContentAssistProcessorAlternativeIsMultiSimple.class })
@ExtSuite.SuitePackages( {})
public class CtsContentAssistProcessorSuite {
	// need this to hold annotations
}
