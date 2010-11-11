syntax Enumeration  {
-- no tabs to better read off char position in line offsets (eclipse shows tabs as several chars)

template TCS::Operator addToContext
  : (isPostfix ? "postfix") name "="
   (isDefined(literal) ? [[
    literal{refersTo = name}
   |
    literal{refersTo = value, lookIn = #all, as = stringSymbol, autoCreate = ifmissing, createAs = Keyword}
   ]])
   "," arity ";"
  ;

}

	