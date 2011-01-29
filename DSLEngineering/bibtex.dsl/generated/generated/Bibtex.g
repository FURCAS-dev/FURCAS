grammar Bibtex;
options {superClass=ObservableInjectingParser;backtrack = true;}

@lexer::header {
package generated;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.antlr3.ITokenFactory;
import com.sap.furcas.runtime.parser.antlr3.DefaultANTLR3LocationTokenFactory;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;}

@lexer::members {  public com.sap.furcas.runtime.parser.IModelInjector ei = null;
public ITokenFactory<? extends ANTLR3LocationToken> tokenFactory;
  /*************** Code generated in class com.sap.furcas.parsergenerator.tcs.t2m.grammar.ANTLR3GrammarWriter  ********/
  private void newline() {}

  public final Token emit() {
	// override emit() to generate own token class
	ANTLR3LocationToken ret = null;
        ITokenFactory<? extends ANTLR3LocationToken> tokenFactory = getTokenFactory();
        ret = tokenFactory.createToken(input, state.type, state.channel, state.tokenStartCharIndex, getCharIndex()-1);
    	   ret.setLine(state.tokenStartLine);
        String newtext = input.substring(state.tokenStartCharIndex,getCharIndex()-1);
        ret.setText(newtext); // sets the text as exactly what has been read
        ret.setCharPositionInLine(state.tokenStartCharPositionInLine);
        ret.setEndLine(getLine());
        ret.setEndColumn(getCharPositionInLine());
        emit(ret);
        return ret;
      }
      
      private ITokenFactory<? extends ANTLR3LocationToken> getTokenFactory() {
          if (tokenFactory == null) {
              tokenFactory = new DefaultANTLR3LocationTokenFactory();
          }
          return tokenFactory;
      }
   /**
     * Removing starting/ending delimiters.
     * @deprecated
     */
    public String unescapeString(String s, int delimLength) {
        // get rid of the starting and ending delimiters (e.g., '\'', '"')
       if (s.charAt(0) == '\'' && s.charAt(s.length()-delimLength) == '\'' || s.charAt(0) == '\"' && s.charAt(s.length()-delimLength) == '\"') {
                s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));
        }
        return s;
    }

      public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
          if (ei != null) {
              ei.reportError(e);
          } else {
              super.displayRecognitionError(tokenNames, e);
          }
          
       }
  /*************** End of Code generated in class com.sap.furcas.parsergenerator.tcs.t2m.grammar.ANTLR3GrammarWriter  ********/
}

@header {
package generated;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.impl.PredicateSemantic;
import com.sap.furcas.runtime.parser.impl.SemanticDisambRuleData;
import com.sap.furcas.runtime.tcs.RuleNameFinder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;
}


@members {
   private static final String syntaxUUID = "_WnlEQCs2EeCRfuBiAX4StA";
   public String getSyntaxUUID() {
        return syntaxUUID;
   }
    public String unescapeString(String s) {
        // get rid of the starting and ending delimiters (e.g., '\'', '"')
       int delimLength = 1; // for delimLength > 0, the following code needs to change
       if (s.charAt(0) == '\'' && s.charAt(s.length()-delimLength) == '\'' || s.charAt(0) == '\"' && s.charAt(s.length()-delimLength) == '\"') {
                s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));
        }
        return s;
    }

}


identifier returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=NAME {ret =  ast.getText();
})
{
ret2=ret;
}
  ;


integerSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=INT {ret = Integer.valueOf( ast.getText());
})
{
ret2=ret;
}
  ;


main returns[Object ret2]
  :
  ((ret=bibtex_literaturedb) EOF) 
  {
ret2=ret;
}
  ;


bibtex_literaturedb returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("Bibtex","LiteratureDb");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.0");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.1");}'Entries:'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.2");}'{'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.3");}( temp=bibtex_entry {setProperty(ret, "entries", temp);
setParent(temp,ret,"entries");} ( temp=bibtex_entry {setProperty(ret, "entries", temp);
setParent(temp,ret,"entries");})* )? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.4");}'}'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.5");}'Authors:'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.6");}'{'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.7");}( temp=bibtex_author {setProperty(ret, "author", temp);
setParent(temp,ret,"author");} ( temp=bibtex_author {setProperty(ret, "author", temp);
setParent(temp,ret,"author");})* )? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.8");}'}'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

bibtex_entry returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("Bibtex","Entry");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.0");}'@article'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.1");}'{'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2");}(({_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.0");}( temp=identifier {setProperty(ret, "id", temp);
setParent(temp,ret,"id");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.1");}','{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.2");}'title'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.3");}'='{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.4");}'{'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.5");}( temp=identifier {setProperty(ret, "title", temp);
setParent(temp,ret,"title");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.6");}'}'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.7");}','{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.8");}'author'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.9");}'='{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.10");}'{'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.11");}( temp=identifier {setOclRef(ret, "author", null, temp, "OCL:Bibtex::Author.allInstances()->select(name = ?)");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.11/@propertyArgs.1/@separatorSequence/@elements.0");}'and'{_afterSeqEl();}){_exitSepSeq();} temp=identifier {setOclRef(ret, "author", null, temp, "OCL:Bibtex::Author.allInstances()->select(name = ?)");})* )? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.12");}'}'{_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.3");}'}'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.4");}{_enterInjectorAction();setOclRef(ret, "literaturedb", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

bibtex_author returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("Bibtex","Author");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.4/@templateSequence/@elements.0");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.4/@templateSequence/@elements.1");}{_enterInjectorAction();setOclRef(ret, "literaturedb", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

COMMENT
  :
     ((('--' (~('\r'| '\n'))*)))
  ;


NL
    :   (   '\r' '\n'
        |   '\n' '\r'   //Improbable
        |   '\r'
        |   '\n'
        )
    {newline();$channel=HIDDEN;}
    ;

WS
    :   (   ' '
        |   '\t'
        )
        {$channel=HIDDEN;}    ;

fragment
DIGIT
    :   '0'..'9'
    ;

fragment
ALPHA
    :   'a'..'z'
    |   'A'..'Z'
    |   '_'
    //For Unicode compatibility (from 0000 to 00ff)
    |   '\u00C0' .. '\u00D6'
    |   '\u00D8' .. '\u00F6'
    |   '\u00F8' .. '\u00FF'
    ;

fragment
SNAME
    :   (ALPHA) (ALPHA | DIGIT)*
;

NAME
    :   (
            SNAME
        |   '"'!
            (   ESC
            |   '\n' {newline();}
            |   ~('\\'|'\"'|'\n')
            )*
            '"'!
            
        )
    ;

INT
    :   (DIGIT)+
    ;

    FLOAT   :   DIGIT+ (('.' DIGIT)=>'.' DIGIT+)?   ;   // cannot accept DIGIT '.' because it would conflict with Navigation

fragment
ESC
    :   '\\'!
        (   'n' 
        |   'r' 
        |   't' 
        |   'b' 
        |   'f' 
        |   '"' 
        |   '\'' 
        |   '\\' 
        |   (
                ('0'..'3')
                (
                :   ('0'..'7')
                    (
                    :   '0'..'7'
                    )?
                )?
            |   ('4'..'7')
                (
                :   ('0'..'7')
                )?
            )
                {
                }
        )
    ;

STRING
    :   '\''!
        (   ESC
        |   '\n' {newline();}
        |   ~('\\'|'\''|'\n')
        )*
        '\''!
       
    ;