/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-10-14 14:21:35 +0200 (Mi, 14 Okt 2009) $
 * @version $Revision: 8347 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import static com.sap.furcas.parsergenerator.util.StringConcatUtil.concat;

import java.util.ArrayList;
import java.util.List;

import com.sap.furcas.parsergenerator.GrammarGenerationException;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.AbstractAntlr3Rule;
import com.sap.furcas.parsergenerator.util.VarStringBuffer;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.IModelInjector;
import com.sap.furcas.runtime.parser.antlr3.DefaultANTLR3LocationTokenFactory;
import com.sap.furcas.runtime.parser.antlr3.ITokenFactory;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;

/**
 * wraps functionality to write an ANTLR3 compatible grammar.
 * 
 * @author C5107456
 */
public class ANTLR3GrammarWriter {

	private Class<? extends ObservableInjectingParser> parserSuperClass = ObservableInjectingParser.class;

	/** The Constant NEWLINES. */
	private static final String NEWLINES = "\n\n";

	/** The grammar options. */
	private String grammarOptions = null;

	private String targetPackage = "generated";

	/** The lexer header. */
	private String grammarName, lexerHeader = "@lexer::header {\n" + "package %package%;\n"
		+ "import " + ANTLR3LocationToken.class.getCanonicalName() + ";\n" + "import "
		+ ITokenFactory.class.getCanonicalName() + ";\n" + "import "
		+ DefaultANTLR3LocationTokenFactory.class.getCanonicalName() + ";\n"
		+ "import java.text.CharacterIterator;\n"
		+ "import java.text.StringCharacterIterator;\n"
		+ "import org.antlr.runtime.BitSet;\r\n"
		+ "import org.antlr.runtime.IntStream;\r\n"
		+ "import org.antlr.runtime.RecognitionException;"
		// + "import org.antlr.runtime.Token"
		+ "}";

	/** The lexer members. */
	private String lexerMembers = "  public "
		+ IModelInjector.class.getCanonicalName()
		+ " ei = null;\n"
		+ "public ITokenFactory<? extends ANTLR3LocationToken> tokenFactory;\n"
		+ "  /*************** Code generated in "
		+ this.getClass()
		+ "  ********/\n"
		+ "  private void newline() {}\n"
		+ "\n"
		+ "  public final Token emit() {\n"
		+ "	// override emit() to generate own token class\n"
		+ "	ANTLR3LocationToken ret = null;\n"
		+ "        ITokenFactory<? extends ANTLR3LocationToken> tokenFactory = getTokenFactory();\r\n"
		+ "        ret = tokenFactory.createToken(input, state.type, state.channel, state.tokenStartCharIndex, getCharIndex()-1);\r\n"
		+ "    	   ret.setLine(state.tokenStartLine);\r\n"
		+ "        String newtext = input.substring(state.tokenStartCharIndex,getCharIndex()-1);\r\n"
		+ "        ret.setText(newtext); // sets the text as exactly what has been read\r\n"
		+ "        ret.setCharPositionInLine(state.tokenStartCharPositionInLine);\r\n"
		+ "        ret.setEndLine(getLine());\r\n"
		+ "        ret.setEndColumn(getCharPositionInLine());\r\n"
		+ "        emit(ret);\r\n"
		+ "        return ret;\r\n"
		+ "      }\r\n"
		+ "      \r\n"
		+ "      private ITokenFactory<? extends ANTLR3LocationToken> getTokenFactory() {\r\n"
		+ "          if (tokenFactory == null) {\r\n"
		+ "              tokenFactory = new DefaultANTLR3LocationTokenFactory();\r\n"
		+ "          }\r\n"
		+ "          return tokenFactory;\r\n"
		+ "      }"
		+ "\r\n"
		+ "   /**\r\n"
		+ "     * Unescape string.\r\n"
		+ "     * \r\n"
		+ "     * @param s the s\r\n"
		+ "     * @param delimLength the delim length\r\n"
		+ "     * \r\n"
		+ "     * @return the string\r\n"
		+ "     * @deprecated\n"
		+ "     */\r\n"
		+ "    public String unescapeString(String s, int delimLength) {\r\n"
		+ "        StringBuilder ret = new StringBuilder();\r\n"
		+ "        // get rid of the starting and ending delimiters (e.g., \'\\\'\', \'\"\')\r\n"
		+ "       if (s.charAt(0) == \'\\\'\' && s.charAt(s.length()-delimLength) == \'\\\'\' || s.charAt(0) == \'\\\"\' && s.charAt(s.length()-delimLength) == \'\\\"\') {\n"
		+ "                s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));\r\n"
		+ "        }\n"
		+ "        \r\n"
		+ "        CharacterIterator ci = new StringCharacterIterator(s);\r\n"
		+ "        char c = ci.first();\r\n"
		+ "        while(c != CharacterIterator.DONE) {\r\n"
		+ "            char tc = 0;\r\n"
		+ "            switch(c) {\r\n"
		+ "            case \'\\\\\':\r\n"
		+ "                c = ci.next();\r\n"
		+ "                switch(c) {\r\n"
		+ "                case \'n\':\r\n"
		+ "                    tc = \'\\n\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'r\':\r\n"
		+ "                    tc = \'\\r\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'t\':\r\n"
		+ "                    tc = \'\\t\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'b\':\r\n"
		+ "                    tc = \'\\b\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'f\':\r\n"
		+ "                    tc = \'\\f\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'\"\':\r\n"
		+ "                    tc = \'\"\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'\\\'\':\r\n"
		+ "                    tc = \'\\\'\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'\\\\\':\r\n"
		+ "                    tc = \'\\\\\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'0\':\r\n"
		+ "                case \'1\':\r\n"
		+ "                case \'2\':\r\n"
		+ "                case \'3\':\r\n"
		+ "                    throw new RuntimeException(\"octal escape sequences not supported yet\");\r\n"
		+ "                default:\r\n"
		+ "                    throw new RuntimeException(\"unknown escape sequence: \'\\\\\" + c + \"\'\");\r\n"
		+ "                }\r\n"
		+ "                break;\r\n"
		+ "            default:\r\n"
		+ "                tc = c;\r\n"
		+ "                break;\r\n"
		+ "            }\r\n"
		+ "            ret.append(tc);\r\n"
		+ "            c = ci.next();\r\n"
		+ "        }\r\n"
		+ "        return ret.toString();\r\n"
		+ "    }\n"
		+ "\n"

		+ "      public void displayRecognitionError(String[] tokenNames, RecognitionException e) {\r\n"
		+ "          if (ei != null) {\r\n" + "              ei.reportError(e);\r\n"
		+ "          } else {\r\n"
		+ "              super.displayRecognitionError(tokenNames, e);\r\n"
		+ "          }\r\n" + "          \r\n" + "       }\r\n"
		+ "  /*************** End of Code generated in " + this.getClass()
		+ "  ********/\r\n";

	private String additionalLexerMembers = "";

	/** The parser header. */
	private final String parserHeader = "@header {\n" + "package %package%;\n" + "import "
		+ ANTLR3LocationToken.class.getCanonicalName() + ";\n" + "import "
		+ IModelElementProxy.class.getCanonicalName() + ";\n"
		+ "import com.sap.furcas.runtime.parser.impl.PredicateSemantic;\n"
		+ "import com.sap.furcas.parsergenerator.emf.lookup.RuleNameFinder;\n"
		+ "import java.text.CharacterIterator;\n"
		+ "import java.text.StringCharacterIterator;\n" + "import %superclass%;\n"
		+ "import org.antlr.runtime.Token;\n" + "}\n";

	/** The parser members template. */
	private final String parserMembersTemplate = "@members {\n"
		+ "   private static final String syntaxUUID = \"%syntaxUUID%\";\r\n"
		+ "   public String getSyntaxUUID() {\r\n"
		+ "        return syntaxUUID;\r\n"
		+ "   }\r\n"
		+ "   /**\r\n"
		+ "     * Unescape string.\r\n"
		+ "     * \r\n"
		+ "     * @param s the s\r\n"
		+ "     * @param delimLength the delim length\r\n"
		+ "     * \r\n"
		+ "     * @return the string\r\n"
		+ "     */\r\n"
		+ "    public String unescapeString(String s) {\r\n"
		+ "        StringBuilder ret = new StringBuilder();\r\n"
		+ "        // get rid of the starting and ending delimiters (e.g., \'\\\'\', \'\"\')\r\n"
		+ "       int delimLength = 1; // for delimLength > 0, the following code needs to change\n"
		+ "       if (s.charAt(0) == \'\\\'\' && s.charAt(s.length()-delimLength) == \'\\\'\' || s.charAt(0) == \'\\\"\' && s.charAt(s.length()-delimLength) == \'\\\"\') {\n"
		+ "                s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));\r\n"
		+ "        }\n"
		+ "        \r\n"
		+ "        CharacterIterator ci = new StringCharacterIterator(s);\r\n"
		+ "        char c = ci.first();\r\n"
		+ "        while(c != CharacterIterator.DONE) {\r\n"
		+ "            char tc = 0;\r\n"
		+ "            switch(c) {\r\n"
		+ "            case \'\\\\\':\r\n"
		+ "                c = ci.next();\r\n"
		+ "                switch(c) {\r\n"
		+ "                case \'n\':\r\n"
		+ "                    tc = \'\\n\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'r\':\r\n"
		+ "                    tc = \'\\r\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'t\':\r\n"
		+ "                    tc = \'\\t\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'b\':\r\n"
		+ "                    tc = \'\\b\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'f\':\r\n"
		+ "                    tc = \'\\f\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'\"\':\r\n"
		+ "                    tc = \'\"\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'\\\'\':\r\n"
		+ "                    tc = \'\\\'\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'\\\\\':\r\n"
		+ "                    tc = \'\\\\\';\r\n"
		+ "                    break;\r\n"
		+ "                case \'0\':\r\n"
		+ "                case \'1\':\r\n"
		+ "                case \'2\':\r\n"
		+ "                case \'3\':\r\n"
		+ "                    throw new RuntimeException(\"octal escape sequences not supported yet\");\r\n"
		+ "                default:\r\n"
		+ "                    throw new RuntimeException(\"unknown escape sequence: \'\\\\\" + c + \"\'\");\r\n"
		+ "                }\r\n" + "                break;\r\n"
		+ "            default:\r\n" + "                tc = c;\r\n"
		+ "                break;\r\n" + "            }\r\n"
		+ "            ret.append(tc);\r\n" + "            c = ci.next();\r\n"
		+ "        }\r\n" + "        return ret.toString();\r\n" + "    }\n" + "\n" + "}\n";

	/** The rules of the grammar. */
	private final List<AbstractAntlr3Rule> rules = new ArrayList<AbstractAntlr3Rule>();

	/** The fixed string for lexer rules. */
	private String lexerString = "";

	private String syntaxUUID;

	/**
	 * Sets the grammar name.
	 * 
	 * @param grammarName
	 *                the new grammar name
	 */
	public void setGrammarName(final String grammarName) {
		this.grammarName = grammarName;
	}
	
	/**
	 * Set the name of the java package that the parser class shall be later be placed in.
	 */
	public void setTargetPackage(String targetPackage) {
		this.targetPackage = targetPackage;
	}

	/**
	 * Gets the grammar header.
	 * 
	 * @return the grammar header
	 */
	public String getGrammarHeader() {
		return concat("grammar ", grammarName, ';');
	}

	/**
	 * Sets the lexer header.
	 * 
	 * @param lexerHeader
	 *                the new lexer header
	 */
	public void setLexerHeader(final String lexerHeader) {
		this.lexerHeader = concat("@lexer::header {", lexerHeader, '}');
	}

	/**
	 * Sets the lexer members.
	 * 
	 * @param lexerMembers
	 *                the new lexer members
	 */
	public void setLexerMembers(final String lexerMembers) {
		this.lexerMembers = lexerMembers;
	}

	// /**
	// * Sets the parser header.
	// *
	// * @param parserHeader the new parser header
	// */
	// public void setParserHeader(String parserHeader) {
	// this.parserHeader = concat("@header {", parserHeader , '}');
	// }

	// public void setParserMembers(String parserMembers) {
	// this.parserMembersTemplate = "@members {"+parserMembers +'}';
	// }

	/**
	 * Gets the output.
	 * 
	 * @return the output
	 * 
	 * @throws GrammarGenerationException
	 *                 the grammar generation exception
	 */
	public String getOutput() throws GrammarGenerationException {
		if (grammarName == null) {
			throw new GrammarGenerationException("Grammar name not set");
		}
		String parserMembers = parserMembersTemplate.replace("%Lexer%",
			grammarName + "Lexer").replace("%Parser%", grammarName + "Parser");

		parserMembers = parserMembers.replace("%syntaxUUID%", syntaxUUID);
		
		int newLinesLength = NEWLINES.length();

		int grammarLength = getGrammarHeader().length() + lexerHeader.length()
			+ lexerMembers.length() + 20 + additionalLexerMembers.length()
			+ parserHeader.length() + parserMembers.length() + lexerString.length()
			+ (newLinesLength * 5) + 10; // Slack for if I miscalculated

		if (grammarOptions != null) {
			grammarLength += grammarOptions.length() + 12;
		}

		for (AbstractAntlr3Rule rule : rules) {
			grammarLength += rule.getLength() + newLinesLength;
		}

		VarStringBuffer buf = new VarStringBuffer(grammarLength);
		buf.append(getGrammarHeader());
		buf.append("\r\noptions {", "superClass=", parserSuperClass.getSimpleName(), ";");
		if (grammarOptions != null && !grammarOptions.trim().equals("")) {
			buf.append(grammarOptions);
		}
		buf.append("}");

		buf.append(NEWLINES, lexerHeader.replace("%package%", targetPackage), NEWLINES,
			"@lexer::members {", lexerMembers, additionalLexerMembers, '}', NEWLINES,
			parserHeader.replace("%package%", targetPackage).replaceAll("%superclass%",
				parserSuperClass.getCanonicalName()), NEWLINES, parserMembers,
			NEWLINES);

		for (AbstractAntlr3Rule rule : rules) {
			rule.addToSerializationBuffer(buf);
			buf.append(NEWLINES);
		}
		buf.append(lexerString);

		return buf.toString();
	}

	/**
	 * Sets the fixed string.
	 * 
	 * @param fixedString
	 *                the new fixed string
	 */
	public void setFixedString(final String fixedString) {
		this.lexerString = fixedString;
	}

	/**
	 * Adds the rule.
	 * 
	 * @param rule
	 */
	public void addRule(AbstractAntlr3Rule rule) {
		rules.add(rule);
	}

	/**
	 * Sets the grammar options, superClass is already set and cannot be set, options must be
	 * passed in the format "name=value;".
	 * 
	 * @param grammarOptions
	 *                the new grammar options
	 */
	public void setGrammarOptions(final String grammarOptions) {
		// TODO allow adding of options rather than setting
		this.grammarOptions = grammarOptions;
	}

	/**
	 * @param memberParts
	 */
	public void addLexerMembers(List<String> memberParts) {
		for (String string : memberParts) {
			additionalLexerMembers += "\n" + string;
		}
	}

	public void setParserSuperClass(Class<? extends ObservableInjectingParser> parserSuperClass) {
		this.parserSuperClass = parserSuperClass;
	}

	public void setSyntaxUUID(String refMofId) {
		this.syntaxUUID = refMofId;
	}

}
