Bootstrap Howto:
	
	0) Make sure all known tests are green. Only then start editing the TCS.tcs
	   Once done with editing, continue with step 1).  
    
    1) Run the Phase1 launch script to generate a bootstrapped parser.
       Fix your TCS.tcs until all steps are green, then continue.
       
    2) Run the Phase2 launch scripts a) and b). They will run all TCS feature
       and scenario integration tests using the bootstrapped parser.
       Repeat steps 1) and 2) until all scenario tests are green, then continue.
       
       Important: You may need to manually refresh (F5) the "generationTemp" folder
                  before this phase can succeed!
    
    3) Run the Phase3 launch script. It will try to create a new TCS parser
       using the bootstrapped parser. Repeat steps 1), 2) and 3) until
       the test is green.
       
   	   Copy the TCSParser.java and  TCSLexer.java from "generationTemp/generated"
   	   to "src/com.sap.furcas.parser.tcs.stable". The bootstrapped parser will now
   	   be used per-default.

   	   Enjoy! You're done now.
   	   