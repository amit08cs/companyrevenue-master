package spientFeesCalculator_master;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class MainFeeCalculatorTest {


	@Test
	public void readDataTest() throws FileNotFoundException {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File(classLoader.getResource("file/testcsv.csv").getFile());
		 System.out.println(file);
	}
}
