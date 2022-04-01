package cse12pa1student;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BasketTest {

	public static Collection<Object[]> BAGNUMS =
			Arrays.asList(new Object[][] { {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12} });
	private int bagType;

	public BasketTest(int bagType) {
		super();
		this.bagType = bagType;
	}

	@Parameterized.Parameters(name = "Basket{index}")
	public static Collection<Object[]> bags() {
		return BAGNUMS;
	}
	
	private Basket makeBasket() {
		switch(this.bagType) {
			case 0: return new Basket0();
			case 1: return new Basket1();
			case 2: return new Basket2();
			case 3: return new Basket3();
			case 4: return new Basket4();
			case 5: return new Basket5();
			case 6: return new Basket6();
			case 7: return new Basket7();
			case 8: return new Basket8();
			case 9: return new Basket9();
			case 10: return new Basket10();
			case 11: return new Basket11();
			case 12: return new Basket12();
		}
		return null;
	}
	
	@Test
	public void addedHasCount1() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		assertEquals(1, basketToTest.count());
	}
	
	/* These are some case points you should test:
	 * ATLEAST 13
	 * Focusing on potential off-by-one errors with 
	 * the first and last items in a basket
	 */
	
	
	// this test checks if it works when duplicate items are added to the baskets
	
	@Test
	public void addDuplicate() {
		Basket basketToTest = makeBasket();
		
		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		Item j = new Item("Shampoo", 5);
		basketToTest.addToBasket(j);
		assertEquals(2, basketToTest.countItem(i));
	}
	
	// this test checks if it works for the null case

	@Test
	public void checkNull() {
		Basket basketToTest = makeBasket();
		
		basketToTest.addToBasket(null);
	
		assertEquals(0, basketToTest.count());		
	}
	
	// this test checks if it works when basket is empty
	
	@Test
	public void checkEmpty() {
		Basket basketToTest = makeBasket();
		
		Item a = new Item("comforter", 1);
		basketToTest.addToBasket(a);
		basketToTest.empty();	
	
		assertEquals(0, basketToTest.count());		
	}
	
	// this test checks if it works when a lot of (1000) items are added to the baskets
	
	@Test
	public void addedHas1000() {
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo", 5);
		for(int x = 0; x < 200; x++) {
			basketToTest.addToBasket(i);
		}
		Item j = new Item("Conditioner", 1);
		for(int x = 0; x < 400; x++) {
			basketToTest.addToBasket(j);
		}
		Item k = new Item("BodyWash", 10);
		for(int x = 0; x < 300; x++) {
			basketToTest.addToBasket(k);
		}
		Item l = new Item("FaceWash", 3);
		for(int x = 0; x < 10; x++) {
			basketToTest.addToBasket(l);
		}
		Item m = new Item("Toothbrush", 12);
		for(int x = 0; x < 20; x++) {
			basketToTest.addToBasket(m);
		}
		Item n = new Item("Toothpaste", 4);
		for(int x = 0; x < 40; x++) {
			basketToTest.addToBasket(n);
		}
		Item o = new Item("Loofah", 6);
		for(int x = 0; x < 10; x++) {
			basketToTest.addToBasket(o);
		}
		Item p = new Item("Mouthguard", 2);
		for(int x = 0; x < 10; x++) {
			basketToTest.addToBasket(p);
		}
		Item q = new Item("Comb", 1);
		for(int x = 0; x < 5; x++) {
			basketToTest.addToBasket(q);
		}
		Item r = new Item("Shampoo", 5);
		for(int x = 0; x < 5; x++) {
			basketToTest.addToBasket(r);
		}
		assertEquals(1000, basketToTest.count());
	}
	
	// this test checks if it works when an item is removed from the basket.
	
	@Test
	public void checkRemoveItems() {
		Basket basketToTest = makeBasket();

		Item a = new Item("Muffin", 3);
		basketToTest.addToBasket(a);
		Item b = new Item("Bagel", 2);
		basketToTest.addToBasket(b);
		Item c = new Item("Long-John", 4);
		basketToTest.addToBasket(c);
		Item d = new Item("Doughnut", 3);
		basketToTest.addToBasket(d);
		
		basketToTest.removeFromBasket(d);
		basketToTest.removeFromBasket(c);
		
		assertEquals(0, basketToTest.countItem(d));
	}

	// this test checks if it works when all items of  
	// a specific article are removed from the basket.
	
//	@Test
//	public void checkRemoveAll() {
//		Basket basketToTest = makeBasket();
//
//		Item a = new Item("Muffin", 3);
//		basketToTest.addToBasket(a);
//		Item b = new Item("Bagel", 2);
//		basketToTest.addToBasket(b);
//		Item c = new Item("Long-John", 4);
//		basketToTest.addToBasket(c);
//		Item d = new Item("Doughnut", 3);
//		basketToTest.addToBasket(d);
//		Item e = new Item("Muffin", 3);
//		basketToTest.addToBasket(e);
//		Item f = new Item("Muffin", 3);
//		basketToTest.addToBasket(f);
//		
//		basketToTest.removeAllFromBasket(f);
//		
//		assertEquals(false, basketToTest.removeAllFromBasket(f));
//	}
	
	
	@Test
	public void checkRemoveAll() {
		Basket basketToTest = makeBasket();

		Item a = new Item("Muffin", 3);
		basketToTest.addToBasket(a);
		
//		basketToTest.removeAllFromBasket(a);
		
		assertEquals(true, basketToTest.removeAllFromBasket(a));
	}
	
	// this test checks if it works to calculate total cost of items in the basket
	
	@Test
	public void checkTotalCost() {
		Basket basketToTest = makeBasket();

		Item a = new Item("Muffin", 3);
		basketToTest.addToBasket(a);
		Item b = new Item("Bagel", 2);
		basketToTest.addToBasket(b);
		Item c = new Item("Long-John", 4);
		basketToTest.addToBasket(c);
		Item d = new Item("Doughnut", 3);
		basketToTest.addToBasket(d);
		Item e = new Item("Muffin", 3);
		basketToTest.addToBasket(e);
		Item f = new Item("Muffin", 3);
		basketToTest.addToBasket(f);
		
		assertEquals(18, basketToTest.totalCost());
	}
	
	//	this test checks if it works when a duplicate item is added and removed
	//WORKS FOR ALL
	@Test
	public void checkAddRemove() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		Item j = new Item("Shampoo", 5);
		basketToTest.addToBasket(j);
		basketToTest.removeFromBasket(i);
		
		assertEquals(1, basketToTest.countItem(j));
	}
	
	// this test checks if it works to count number if items of a single article
	
	@Test
	public void checkCountItem() {
		Basket basketToTest = makeBasket();

		Item a = new Item("Muffin", 3);
		basketToTest.addToBasket(a);
		Item b = new Item("Bagel", 2);
		basketToTest.addToBasket(b);
		Item c = new Item("Long-John", 4);
		basketToTest.addToBasket(c);
		Item d = new Item("Doughnut", 3);
		basketToTest.addToBasket(d);
		Item e = new Item("Muffin", 3);
		basketToTest.addToBasket(e);
		Item f = new Item("Muffin", 3);
		basketToTest.addToBasket(f);
		
		assertEquals(3, basketToTest.countItem(a));
	}
	
	// this test checks if remove works for an empty basket
	
	@Test
	public void checkBooleanEmpty() {
		Basket basketToTest = makeBasket();

		Item a = new Item("Muffin", 3);
		basketToTest.addToBasket(a);
		
		basketToTest.removeFromBasket(a);
	
		assertEquals(false, basketToTest.removeFromBasket(a));
	}
	
	// this test checks if it works for removeFromBasket in case of null
	
	@Test
	public void checkRemoveNull() {
		Basket basketToTest = makeBasket();
		
		basketToTest.addToBasket(null);
	
		assertEquals(false, basketToTest.removeFromBasket(null));
	}
	
	
	
}
