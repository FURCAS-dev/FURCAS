%Terminals
    DollarSign ::= '$'
    Percent ::= '%'
    _
    a b c d e f g h i j k l m n o p q r s t u v w x y z
    A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
%End

%Headers
    /.
        final static int tokenKind[] = new int[128];
        static
        {
            tokenKind['$'] = $sym_type.$prefix$DollarSign$suffix$;
            tokenKind['%'] = $sym_type.$prefix$Percent$suffix$;
            tokenKind['_'] = $sym_type.$prefix$_$suffix$;

            tokenKind['a'] = $sym_type.$prefix$a$suffix$;
            tokenKind['b'] = $sym_type.$prefix$b$suffix$;
            tokenKind['c'] = $sym_type.$prefix$c$suffix$;
            tokenKind['d'] = $sym_type.$prefix$d$suffix$;
            tokenKind['e'] = $sym_type.$prefix$e$suffix$;
            tokenKind['f'] = $sym_type.$prefix$f$suffix$;
            tokenKind['g'] = $sym_type.$prefix$g$suffix$;
            tokenKind['h'] = $sym_type.$prefix$h$suffix$;
            tokenKind['i'] = $sym_type.$prefix$i$suffix$;
            tokenKind['j'] = $sym_type.$prefix$j$suffix$;
            tokenKind['k'] = $sym_type.$prefix$k$suffix$;
            tokenKind['l'] = $sym_type.$prefix$l$suffix$;
            tokenKind['m'] = $sym_type.$prefix$m$suffix$;
            tokenKind['n'] = $sym_type.$prefix$n$suffix$;
            tokenKind['o'] = $sym_type.$prefix$o$suffix$;
            tokenKind['p'] = $sym_type.$prefix$p$suffix$;
            tokenKind['q'] = $sym_type.$prefix$q$suffix$;
            tokenKind['r'] = $sym_type.$prefix$r$suffix$;
            tokenKind['s'] = $sym_type.$prefix$s$suffix$;
            tokenKind['t'] = $sym_type.$prefix$t$suffix$;
            tokenKind['u'] = $sym_type.$prefix$u$suffix$;
            tokenKind['v'] = $sym_type.$prefix$v$suffix$;
            tokenKind['w'] = $sym_type.$prefix$w$suffix$;
            tokenKind['x'] = $sym_type.$prefix$x$suffix$;
            tokenKind['y'] = $sym_type.$prefix$y$suffix$;
            tokenKind['z'] = $sym_type.$prefix$z$suffix$;

            tokenKind['A'] = $sym_type.$prefix$A$suffix$;
            tokenKind['B'] = $sym_type.$prefix$B$suffix$;
            tokenKind['C'] = $sym_type.$prefix$C$suffix$;
            tokenKind['D'] = $sym_type.$prefix$D$suffix$;
            tokenKind['E'] = $sym_type.$prefix$E$suffix$;
            tokenKind['F'] = $sym_type.$prefix$F$suffix$;
            tokenKind['G'] = $sym_type.$prefix$G$suffix$;
            tokenKind['H'] = $sym_type.$prefix$H$suffix$;
            tokenKind['I'] = $sym_type.$prefix$I$suffix$;
            tokenKind['J'] = $sym_type.$prefix$J$suffix$;
            tokenKind['K'] = $sym_type.$prefix$K$suffix$;
            tokenKind['L'] = $sym_type.$prefix$L$suffix$;
            tokenKind['M'] = $sym_type.$prefix$M$suffix$;
            tokenKind['N'] = $sym_type.$prefix$N$suffix$;
            tokenKind['O'] = $sym_type.$prefix$O$suffix$;
            tokenKind['P'] = $sym_type.$prefix$P$suffix$;
            tokenKind['Q'] = $sym_type.$prefix$Q$suffix$;
            tokenKind['R'] = $sym_type.$prefix$R$suffix$;
            tokenKind['S'] = $sym_type.$prefix$S$suffix$;
            tokenKind['T'] = $sym_type.$prefix$T$suffix$;
            tokenKind['U'] = $sym_type.$prefix$U$suffix$;
            tokenKind['V'] = $sym_type.$prefix$V$suffix$;
            tokenKind['W'] = $sym_type.$prefix$W$suffix$;
            tokenKind['X'] = $sym_type.$prefix$X$suffix$;
            tokenKind['Y'] = $sym_type.$prefix$Y$suffix$;
            tokenKind['Z'] = $sym_type.$prefix$Z$suffix$;
        };
    
        final int getKind(char c)
        {
            return (((c & 0xFFFFFF80) == 0) /* 0 <= c < 128? */ ? tokenKind[c] : 0);
        }
    ./
%End

