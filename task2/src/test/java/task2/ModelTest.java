package task2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import junit.framework.Assert;

@RunWith(DataProviderRunner.class)
public class ModelTest {

	private Model model;

	@DataProvider
	public static Object[][] isInRangeInput() {
		return new Object[][] { { 5, 15, 56 }, { 6, 45, 99 }, { -10, 99, 0 }, { 0, 0, 13 }, { -15, -99, 55 } };
	}

	@DataProvider
	public static Object[][] randInput() {
		return new Object[][] { { 5, 15 }, { 6, 45 }, { -10, 99 }, { 0, 0 }, { -15, -99 } };
	}

	@Before
	public void setUp() throws Exception {
		this.model = new Model();
	}

	@Test
	@UseDataProvider("isInRangeInput")
	public void testIsInRange(int guess, int min, int max) {
		model.setMin(min);
		model.setMax(max);
		Assert.assertEquals(guess > min && guess < max, model.isInRange(guess));
	}

	@Test
	@UseDataProvider("randInput")
	public void testRand(int min, int max) {
		int i = model.rand(min, max);
		Assert.assertTrue(i > min && i < max);
	}

}
