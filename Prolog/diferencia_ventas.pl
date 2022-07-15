venta(20210110091500, julio, 11, 1).
venta(20210111091500, lucas, 35, 1).
venta(20210112091500, fede, 22, 2).
venta(20210113091500, julio, 48, 2).
venta(20210110093000, fede, 33, 2).
venta(20210111093000, lucas, 74, 1).
venta(20210112093000, hernan, 97, 3).
venta(20210113100000, lucas, 72, 1).
venta(20210111110000, hernan, 65, 3).
venta(20210111114500, julio, 56, 3).
venta(20210111120000, julio, 54, 2).
venta(20210111131223, julio, 81, 1).

%Se pide generar la regla diferencia_sede(Diferencia, Sede) 
%que en Diferencia contenga
%la diferencia entre la venta más alta y la más baja, por Sede

producto_cartesiano_maximo(Valor,Sede):-
    			venta(_,_,Valor,Sede),venta(_,_,Valor2,Sede),
    			Valor<Valor2.

producto_cartesiano_minimo(Valor,Sede):-
    			venta(_,_,Valor,Sede),venta(_,_,Valor2,Sede),
    			Valor>Valor2.

maximo(Valor,Sede):- venta(_,_,Valor,Sede),
    				not(producto_cartesiano_maximo(Valor,Sede)).

minimo(Valor,Sede):- venta(_,_,Valor,Sede),
    				not(producto_cartesiano_minimo(Valor,Sede)).

diferencia_sede(Diferencia, Sede):- 
    maximo(Valor_Maximo,Sede),minimo(Valor_Minimo,Sede),
    Diferencia is Valor_Maximo-Valor_Minimo.
    
                        
                        
                        
    
    
    
    
    

    			