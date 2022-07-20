hombre(alberto, pop, salsa). 
hombre(alan, jazz, reggeton).
hombre(alexis, pop, reggeton).
hombre(alain, cumbia, salsa).
mujer(ana, reggeton, merengue).
mujer(analia, salsa, reggeton).
mujer(anarosa, clasico, ballet).
mujer(anabel, rock, ballet).

%Reglas

hombre_compatible(Nombre,Estilo):- hombre(Nombre,Estilo,_);hombre(Nombre,_,Estilo).
mujer_compatible(Nombre,Estilo):- mujer(Nombre,Estilo,_);mujer(Nombre,_,Estilo).
compatibles(NombreHombre,NombreMujer,Estilo):- 
    				hombre_compatible(NombreHombre,Estilo), 
    				mujer_compatible(NombreMujer,Estilo).