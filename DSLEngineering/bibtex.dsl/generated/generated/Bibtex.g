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
       } else if (s.length() >= 4 && s.charAt(0) == '\\' && s.charAt(s.length()-delimLength) == '\"' && s.charAt(1) == '\"' && s.charAt(s.length()-delimLength-1) == '\\') {
             //also handle strings that are surrounded with an escaped string symbol \"value\"
             delimLength += 1;
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
   private static final String syntaxUUID = "_kLRsYGH1EeCG2-l6Kl85Rw";
   public String getSyntaxUUID() {
        return syntaxUUID;
   }
    public String unescapeString(String s) {
        // get rid of the starting and ending delimiters (e.g., '\'', '"')
       int delimLength = 1; // for delimLength > 0, the following code needs to change
       if (s.charAt(0) == '\'' && s.charAt(s.length()-delimLength) == '\'' || s.charAt(0) == '\"' && s.charAt(s.length()-delimLength) == '\"') {
                s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));
       }
       if(s.contains("\\\"")) {
                s = s.replaceAll("\\\\\"", "\"");
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
  ({_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/5");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/6");}'Entries:'{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/7");}'{'{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/9");}( temp=bibtex_entry {setProperty(ret, "entries", temp);
setParent(temp,ret,"entries");} ( temp=bibtex_entry {setProperty(ret, "entries", temp);
setParent(temp,ret,"entries");})* )? {_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/10");}'}'{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/11");}'Authors:'{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/12");}'{'{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/14");}( temp=bibtex_author {setProperty(ret, "author", temp);
setParent(temp,ret,"author");} ( temp=bibtex_author {setProperty(ret, "author", temp);
setParent(temp,ret,"author");})* )? {_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/15");}'}'{_afterSeqEl();})
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
  ({_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/19");}'@article'{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/20");}'{'{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/44");}(({_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/22");}( temp=identifier {setProperty(ret, "id", temp);
setParent(temp,ret,"id");}){_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/23");}','{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/24");}'title'{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/25");}'='{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/26");}'{'{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/28");}( temp=identifier {setProperty(ret, "title", temp);
setParent(temp,ret,"title");}){_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/29");}'}'{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/30");}','{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/31");}'author'{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/32");}'='{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/33");}'{'{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/41");}( temp=identifier {setOclRef(ret, "author", null, temp, "OCL:Bibtex::Author.allInstances()->select(name = ?)");} /* propURI: http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/41 */ ({_enterSepSeq();}({_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/36");}'and'{_afterSeqEl();}){_exitSepSeq();} temp=identifier {setOclRef(ret, "author", null, temp, "OCL:Bibtex::Author.allInstances()->select(name = ?)");} /* propURI: http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/41 */)* )? {_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/42");}'}'{_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/45");}'}'{_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/48");}{_enterInjectorAction();setOclRef(ret, "literaturedb", null, null, "OCL:#context", true); /* propInitURI: http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/47 */_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/53");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();}{_beforeSeqEl("http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/56");}{_enterInjectorAction();setOclRef(ret, "literaturedb", null, null, "OCL:#context", true); /* propInitURI: http://www.furcas.org/transientParsingResource_jnLg0WH1EeCG2-l6Kl85Rw#/55 */_exitInjectorAction();}{_afterSeqEl();})
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