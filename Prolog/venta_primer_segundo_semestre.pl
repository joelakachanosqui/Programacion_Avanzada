ventas1erSem(juan, 20000).
ventas1erSem(maria, 1000).
ventas1erSem(agata, 5000).
ventas1erSem(martin, 100000).
ventas1erSem(mora, 10000).

ventas2doSem(juan, 40000).
ventas2doSem(agata, 6000).
ventas2doSem(sebastian, 5000).
ventas2doSem(mora, 35000).
ventas2doSem(matias, 200000).


no_esta(Vendedor,Comision):- 
    				(ventas1erSem(Vendedor,_),not(ventas2doSem(Vendedor,_)),Comision is 5);
    				(ventas2doSem(Vendedor,_),not(ventas1erSem(Vendedor,_)),Comision is 5).

prod_cartesiano_ventas(Valor1,Valor2,Comision):-
    				(Valor1>=20000,Valor2>=20000,Comision is 20);
    				((Valor1<20000;Valor2<20000),Comision is 10).

dos_semestres(Vendedor,Comision):-
    				ventas1erSem(Vendedor,Valor1),
    				ventas2doSem(Vendedor,Valor2),
    				prod_cartesiano_ventas(Valor1,Valor2,Comision).
    				
comision(Vendedor,Comision):-
    				dos_semestres(Vendedor,Comision);
    				no_esta(Vendedor,Comision).
    	