hombre(alberto, cumbia, salsa).  

mujer(ana, salsa, merengue). 


%Se desea obtener el listado de posibles participantes, 
%indicando el nombre de ambos y el estilo en el que participan.

hombre_compatible(Hombre,Ritmo):- hombre(Hombre,Ritmo,_);hombre(Hombre,_,Ritmo).
mujer_compatible(Mujer,Ritmo):- mujer(Mujer,Ritmo,_);mujer(Mujer,_,Ritmo).

compatibles(Hombre,Mujer,Ritmo):- hombre_compatible(Hombre,Ritmo),
                                    mujer_compatible(Mujer,Ritmo).                            	
    								