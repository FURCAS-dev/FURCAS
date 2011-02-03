/**
 * Contains classes related to the TestCase Create feature which allows
 * to generate a JUnit testmethod based on the most recent editor input.
 * 
 * <p>
 * <b>Approach</b>
 * <ol>
 * 	<li> Capture all potential causes of undesired behavior by recording each
 * 		keystroke leading to a modification of the virtual text document
 * 		{@ CtsHistoryDocument>.
 * 	</li>
 *	<li> Provide a fixture suitable for {@link CtsEditorTest} by preserving the
 *		domain and TextBlock model in the version as of the
 *		beginning of an editing session.
 *	</li>
 *	<li> Generate a JUnit testcase skeleton based on the fixture and the
 *		modification history and place it into the clipboard
 *	</li>
 *	<li> Let the user fill in his assertions, e.g., to assure that a
 *		rename operation was correctly propagated through the
 *		TextBlock model into the domain model.
 *	</li>
 * </ol>
 * </p>
 *
 * The generated tests are meant to be integration tests, testing the whole stack.
 * 
 * @see com.sap.ide.cts.editor.document.CtsHistoryDocument
 * @see com.sap.ide.cts.editor.document.CtsHistoryDocumentProvider
 * 
 * @author D049157
 */
package com.sap.furcas.ide.editor.junitcreate;