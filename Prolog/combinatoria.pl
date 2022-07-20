combinatoria(0,1).
combinatoria(1,1).
combinatoria(2,2).
combinatoria(X,Y):-
    X1 is X-1,
    X2 is X-2,
    X3 is X-3,
    combinatoria(X1,Y1),
    combinatoria(X2,Y2),
    combinatoria(X3,Y3),
    Y is Y1+Y2+Y3.