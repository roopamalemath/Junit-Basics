package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assertions.assertAll;


@DisplayName("when running mathUtils")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
	
	MathUtils mathUtils;
	// junit providers
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	void beforeAllInit() {
		System.out.println("this needs to run before all");
	}
	
	@BeforeEach // runs this method before each method runs
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo=testInfo;
		this.testReporter=testReporter;
	mathUtils=new MathUtils();
	testReporter.publishEntry("Running "+testInfo.getDisplayName()+"with Tags "+testInfo.getTags());
	}
	
	@AfterEach
	void cleanUp() {
		System.out.println("Cleaning Up....");
	}
	
	@Nested
	@DisplayName("add method")
	@Tag("Math")
	class addTest{
		// tel to junit runs this test
		@Test
		@DisplayName("when adding two positive numbers")
		void testAddPostive() {
			assertEquals(1, mathUtils.add(0, 1),"should return the right sum");
		}
		
		@Test
		@DisplayName("when adding two negative numbers")
		void testAddNegative() {
			int expected=-2;
			int actual=mathUtils.add(-1, -1);
			// using supplier for assert messages
			assertEquals(expected, actual,()->"should return the right sum "+expected+ "but return "+actual);
		}
	}
	
	
	
	@Test
	@DisplayName("multiply method")
	@Tag("Math")
	void testMultiple() {
		//System.out.println("Running "+testInfo.getDisplayName()+"with Tags "+testInfo.getTags());
		assertAll(() -> assertEquals(4, mathUtils.mul(2, 2)), 
				  () -> assertEquals(0, mathUtils.mul(2, 0)),
				  () -> assertEquals(-2, mathUtils.mul(2, -1))
		);

	}
	
	@RepeatedTest(3)
	@Tag("Circle")
	void testComputeCircleRadius(RepetitionInfo repetationInfo) {
		//if(repetationInfo.getCurrentRepetition() | repetationInfo.getTotalRepetitions()) {}
		boolean isServerUp=false;
		assumeTrue(isServerUp);
		double actual=mathUtils.computeCircleArea(10);
		double expected=314.1592653589793;
		assertEquals(expected, actual, "should return right area");
		}
	
	
	// this method is throwing an exception
	@Test
	@EnabledOnOs(OS.LINUX)
	void testDivide() {
		MathUtils mathUtils=new MathUtils();
		assertThrows(ArithmeticException.class,
					()->mathUtils.div(1, 0),
					"divide by zero should throw");		
		
	}
	
	
	@Test
	@Disabled // it actually skip the test
	@DisplayName("TDD method should not run")
	void testDiabled() {
		fail("this test should be disabled");
	}

}
