pais_superficie(argentina,62).
pais_superficie(uruguay,11).
pais_superficie(brasil,70).
pais_superficie(peru,42).
pais_superficie(venezuela,31).
pais_superficie(colombia,29).
pais_superficie(chile,22).


producto_cartesiano(Pais,Sup):-
    				pais_superficie(Pais,Sup),
    				pais_superficie(_,Sup2),
    				Sup<Sup2.

mayor_superficie(Pais,Sup):-
    				pais_superficie(Pais,Sup),
    				not(producto_cartesiano(Pais,Sup)),
    				writeln("Pais con mayor superficie: ").

