package task2;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import javax.swing.text.View;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junit.framework.Assert;

@RunWith(Parameterized.class)
public class ControllerTest {

	@Parameters(name = "input: {0}")
	public static Collection<Object[]> inputs() {
		return Arrays.asList(new Object[][] { { "13 " }, { "-14 99 " }, { "100 io +5 045 " }, { "pl - .; 25" },
				{ "-- 9" }, { "53 --" } });
	}

	private Controller controller;
	private Scanner scanner;

	public ControllerTest(String input) {
		this.controller = new Controller(new Model(), new View());
		this.scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
	}

	@After
	public void tearDown() throws Exception {
		this.scanner.close();
	}

	@Test
	public void testInput() {
		int i = this.controller.inputIntWithScanner(this.scanner);
		Assert.assertTrue(i > 0 && i < 100);
	}

}
