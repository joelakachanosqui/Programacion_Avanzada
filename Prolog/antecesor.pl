padre(juan,pedro).
padre(juan,maria).
padre(pedro,ana).
padre(ana,nicolas).
padre(ana,joela).

antecesor(Padre,Hijo):- padre(Padre,Hijo).
antecesor(X,Y):- padre(X,Z), antecesor(Z,Y).

