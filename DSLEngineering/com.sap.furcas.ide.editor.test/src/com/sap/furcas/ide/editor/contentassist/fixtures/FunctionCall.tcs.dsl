syntax FunctionCall  {
-- no tabs to better read off char position in line offsets (eclipse shows tabs as several chars)
 template ->A::B main
  : $reference 
 ;
		

 function reference(->A::B)
  : [[ "b" | "a" $reference ]]
 ;

}