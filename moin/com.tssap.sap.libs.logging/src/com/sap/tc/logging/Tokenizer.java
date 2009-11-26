package com.sap.tc.logging;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2003
 * Company:      SAP AG.
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * @version      $Id:$
 */

import java.util.*;
import java.text.*;
import java.io.*;

class Token {

  public Token(int    type,
               String val) {
    this.type = type;
    this.val  = val;
  }

  public int getType() {
    return type;
  }

  public String getValue() {
    return val;
  }

  private int    type;
  private String val;

}

class Tokenizer implements Iterator,
                           Cloneable {

  public Tokenizer(String content) {
    this.content = content;
    this.length  = content.length();
  }

  public Token nextToken() {
    if (aheadToken != null) {
      Token token = aheadToken;

      aheadToken = null;
      currIdx = aheadIdx;
      return token;
    } else {
      return nextTokenInt();
    }
  }

  public Token nextTokenInt() {
    final int INITIAL  = 0,
              UNPARSED = 1,
              IDENT    = 2;

    int state    = INITIAL,
        startIdx = currIdx;

    while (true) {
      char curr = (currIdx < length) ? content.charAt(currIdx)
                                     : '\0';

      switch (state) {
        case INITIAL: {
          if (   currIdx < length
              && Character.isWhitespace(curr)) {
            ++startIdx;
          } else if (   currIdx < length
                     && curr == '\'') {
            // Read over starting single quote.
            ++startIdx;

            state = UNPARSED;
          } else if (   currIdx < length
                     && Character.isJavaIdentifierStart(curr)) {
            state = IDENT;
          } else if (curr == '\0') {
            return new Token(TokenType.NONE,
                             "");
          } else {
            ++currIdx;
            return new Token(TokenType.UNKNOWN,
                             String.valueOf(curr));
          }
          break;
        }
        case UNPARSED: {
          if (   currIdx < length
              && curr != '\'') {
            // Nothing to be done.
          } else {
            // Read over terminating single quote using postfix ++.
            return new Token(TokenType.UNPARSED,
                             content.substring(startIdx,
                                               (currIdx < length) ? currIdx++
                                                                  : currIdx));
          }
          break;
        }
        case IDENT: {
          if (   currIdx < length
              && Character.isJavaIdentifierPart(curr)) {
            // Nothing to be done.
          } else {
            return new Token(TokenType.IDENT,
                             content.substring(startIdx,
                                               currIdx));
          }
          break;
        }
      }
      ++currIdx;
    }
  }

  public Token getLookahead() {
    if (aheadToken == null) {
      int prevIdx = currIdx;

      aheadToken = nextToken();
      aheadIdx = currIdx;
      currIdx = prevIdx;
    }
    return aheadToken;
  }

  public String getContent() {
    return content.substring(currIdx,
                             length);
  }

  public String getAcceptedContent() {
    return content.substring(0,
                             currIdx);
  }

  public String getFullContent() {
    return content;
  }

  public boolean hasNext() {
    return getLookahead().getType() != TokenType.NONE;
  }

  public Object next() {
    if (hasNext()) {
      return nextToken();
    } else {
      throw new NoSuchElementException();
    }
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }

  public Object clone() {
    try {
      return super.clone();
    }
    catch(CloneNotSupportedException e) {
      return null;
    }
  }

  protected String content;
  protected int    currIdx = 0,
                   length;

  private Token aheadToken = null;
  private int   aheadIdx   = 0;

}

class ReverseTokenizer extends Tokenizer {

  private static class State {

    public State(Token token,
                 int   currIdx) {
      this.token   = token;
      this.currIdx = currIdx;
    }

    public Token token;
    public int   currIdx;
  }

  public ReverseTokenizer(Tokenizer tokenizer) {
    super(tokenizer.getContent());

    // Tokenize from front and store results.
    Tokenizer gatherer   = (Tokenizer) tokenizer.clone();
    Token     token;
    int       correction = gatherer.currIdx;

    states.add(new State(new Token(TokenType.NONE,
                                   ""),
                         0));
    token = gatherer.nextToken();
    while (token.getType() != TokenType.NONE) {
      states.addFirst(new State(token,
                                  gatherer.currIdx
                                - correction));
      token = gatherer.nextToken();
    }

    iter = states.iterator();
    curr = (State) iter.next();
  }

  public Token nextTokenInt() {
    State prev = curr;

    if (iter.hasNext()) {
      curr = (State) iter.next();
    }
    return prev.token;
  }

  public String getContent() {
    return content.substring(0,
                             curr.currIdx);
  }

  public String getAcceptedContent() {
    return content.substring(curr.currIdx,
                             length);
  }

  private State curr;

  private LinkedList states = new LinkedList();
  private Iterator   iter;

}
