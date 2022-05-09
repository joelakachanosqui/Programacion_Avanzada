package PonyExpress;


import org.junit.Assert;

import org.junit.jupiter.api.Test;

class ElPonyTest {
	
	Jinete jinete = new Jinete();
	
	@Test
	void testJinete1() {
		Assert.assertEquals(2, jinete.jinetes(new int[] {43, 23, 40, 13}));
		
	}
	
	@Test
	void testJinete2() {
		Assert.assertEquals(3, jinete.jinetes(new int[] {33, 8, 16, 47, 30, 30, 46}));
	}
	
	@Test
	void testJinete3() {
		Assert.assertEquals(3, jinete.jinetes(new int[] {51, 51, 51}));
	}
	
	@Test
	void testJinete4(){
		Assert.assertEquals(4, jinete.jinetes(new int[] {6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49}));
	}
	
	@Test
	void testJinete5(){
		Assert.assertEquals(4, jinete.jinetes(new int[] {99,99,99,5}));
	}
	
	@Test
	void testJinete6(){
		Assert.assertEquals(1, jinete.jinetes(new int[] { 18, 15 }));
	}
	

}
