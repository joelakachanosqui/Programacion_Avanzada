package MesadasGranito;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class MesadaTest {

	@Test
	public void testMesada01() {
		Archivo test1 = new Archivo("test1");
		List <Mesada>lista;
		lista = test1.readFile();
		Mesada resolver=new Mesada();	
		assertEquals(1, resolver.compararMesadas(lista));
	}
	
	@Test
	public void testMesada02() {
		Archivo test1 = new Archivo("test2");
		List <Mesada>lista;
		lista = test1.readFile();
		Mesada resolver=new Mesada();	
		assertEquals(2, resolver.compararMesadas(lista));
	}
	
	@Test
	public void testMesada03() {
		Archivo test1 = new Archivo("test3");
		List <Mesada>lista;
		lista = test1.readFile();
		Mesada resolver=new Mesada();	
		assertEquals(2, resolver.compararMesadas(lista));
	}
	
	@Test
	public void testMesada04() {
		Archivo test1 = new Archivo("test4");
		List <Mesada>lista;
		lista = test1.readFile();
		Mesada resolver=new Mesada();	
		assertEquals(3, resolver.compararMesadas(lista));
	}
	
	@Test
	public void testMesada05() {
		Archivo test1 = new Archivo("test5");
		List <Mesada>lista;
		lista = test1.readFile();
		Mesada resolver=new Mesada();	
		assertEquals(1, resolver.compararMesadas(lista));
	}
}
