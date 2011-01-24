package org.eclipse.ocl.examples.build.utilities;

import java.util.Map;

import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.codegen.merge.java.facade.ast.ASTFacadeHelper;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants;

public final class StandaloneASTFacadeHelper extends ASTFacadeHelper { // Workaround
																		// Bug
																		// 308069

	public Map<?, ?> getJavaCoreOptions() {
		if (javaCoreOptions == null) {
			javaCoreOptions = getDefaultJavaCoreOptions();
		}
		return javaCoreOptions;
	}

	protected void useCurrentOption(Map<Object, String> options, String option,
			String defaultValue) {
		String value = JavaCore.getOption(option);
		if (value != null) {
			options.put(option, value);
		} else if (!options.containsKey(option)) {
			options.put(option, defaultValue);
		}
	}

	/**
	 * Gets JavaCore options from JavaCore and updates tab and indentation
	 * settings from ControlModel.
	 * 
	 * @return map of options
	 * 
	 * @see #getJavaCoreOptions()
	 * @see JavaCore#getOptions()
	 * @see JControlModel#getLeadingTabReplacement()
	 */
	@SuppressWarnings("unchecked")
	private Map<?, ?> getDefaultJavaCoreOptions() {
		String compilerCompliance = JavaCore.VERSION_1_5;
		Map<Object, String> javaCoreOptions = JavaCore.getOptions();

		// Set of options that we want to copy from the current definition
		javaCoreOptions.put(JavaCore.COMPILER_COMPLIANCE, compilerCompliance);
		javaCoreOptions.put(JavaCore.COMPILER_SOURCE, compilerCompliance);
		javaCoreOptions.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM,
				compilerCompliance);
		useCurrentOption(javaCoreOptions,
				DefaultCodeFormatterConstants.FORMATTER_TAB_CHAR,
				JavaCore.SPACE);
		useCurrentOption(javaCoreOptions,
				DefaultCodeFormatterConstants.FORMATTER_TAB_SIZE, "2");
		useCurrentOption(javaCoreOptions,
				DefaultCodeFormatterConstants.FORMATTER_INDENTATION_SIZE, "2");

		if (getControlModel() != null) {
			String indent = getControlModel().getLeadingTabReplacement();
			if (indent != null && indent.length() > 0) {
				String size = Integer.toString(indent.length());
				if (indent.charAt(0) == '\t') {
					javaCoreOptions.put(
							DefaultCodeFormatterConstants.FORMATTER_TAB_CHAR,
							JavaCore.TAB);
					javaCoreOptions.put(
							DefaultCodeFormatterConstants.FORMATTER_TAB_SIZE,
							size);
					javaCoreOptions
							.put(DefaultCodeFormatterConstants.FORMATTER_INDENTATION_SIZE,
									size);
				} else if (indent.charAt(0) == ' ') {
					javaCoreOptions.put(
							DefaultCodeFormatterConstants.FORMATTER_TAB_CHAR,
							JavaCore.SPACE);
					javaCoreOptions.put(
							DefaultCodeFormatterConstants.FORMATTER_TAB_SIZE,
							size);
					javaCoreOptions
							.put(DefaultCodeFormatterConstants.FORMATTER_INDENTATION_SIZE,
									size);
				} else {
					if (DEBUG) {
						logInfo("Unable to recognize indent string, using java core options.");
					}
				}
			} else {
				if (DEBUG) {
					logInfo("Indent is not set, using java core options.");
				}
			}
		}

		if (DEBUG) {
			logInfo("Tab char: "
					+ javaCoreOptions
							.get(DefaultCodeFormatterConstants.FORMATTER_TAB_CHAR)
					+ ", Indent size: "
					+ javaCoreOptions
							.get(DefaultCodeFormatterConstants.FORMATTER_TAB_SIZE)
					+ ", Tab size: "
					+ javaCoreOptions
							.get(DefaultCodeFormatterConstants.FORMATTER_INDENTATION_SIZE));
		}

		// Set of options that we want to control
		javaCoreOptions.put("org.eclipse.jdt.core.incompleteClasspath",
				"warning");
		javaCoreOptions
				.put("org.eclipse.jdt.core.circularClasspath", "warning");
		//
		javaCoreOptions
				.put(DefaultCodeFormatterConstants.FORMATTER_BRACE_POSITION_FOR_ENUM_DECLARATION,
						DefaultCodeFormatterConstants.NEXT_LINE);
		javaCoreOptions
				.put(DefaultCodeFormatterConstants.FORMATTER_BRACE_POSITION_FOR_TYPE_DECLARATION,
						DefaultCodeFormatterConstants.NEXT_LINE);

		// separate fields with an empty line
		javaCoreOptions
				.put(DefaultCodeFormatterConstants.FORMATTER_BLANK_LINES_BEFORE_FIELD,
						"1");

		// make all enum constants to be on separate lines
		javaCoreOptions
				.put(DefaultCodeFormatterConstants.FORMATTER_ALIGNMENT_FOR_ENUM_CONSTANTS,
						DefaultCodeFormatterConstants
								.createAlignmentValue(
										true,
										DefaultCodeFormatterConstants.WRAP_ONE_PER_LINE,
										DefaultCodeFormatterConstants.INDENT_DEFAULT));

		return javaCoreOptions;
	}
}