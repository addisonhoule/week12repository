package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {

		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}

	}

	static Stream<Arguments> argumentsForAddPositive() {

		return Stream.of(Arguments.of(0, 4, 4, true), Arguments.of(2, 4, 6, false), Arguments.of(-1, 4, 3, true),
				Arguments.of(2, -4, -2, true), Arguments.of(-8, -9, -17, true), Arguments.of(-2, -4, -6, true),
				Arguments.of(1, 3, 4, false), Arguments.of(3, 5, 8, false), Arguments.of(6, 4, 10, false),
				Arguments.of(21, 14, 35, false));

	}

	@Test
	void assertThatPairsOfPositiveNumberAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(12, 24)).isEqualTo(36);
		assertThat(testDemo.addPositive(13, 5)).isEqualTo(18);
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForMultiplyOnlyOneNegative")
	void assertThatOnlyOneNegativeNumberisMultiplied(int a, int b, int expected, boolean expectException) {

		//here is the test to make sure only one negative number is being multiplied. It checks for exceptions otherwise.
		if (!expectException) {
			assertThat(testDemo.multiplyOnlyOneNegative(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.multiplyOnlyOneNegative(a, b))
					.isInstanceOf(IllegalArgumentException.class);
		}
	}

	static Stream<Arguments> argumentsForMultiplyOnlyOneNegative() {
		//oooh doggy, look at all these tests.
		return Stream.of(Arguments.of(0, -4, 0, false), Arguments.of(2, 4, 6, true), Arguments.of(-1, 4, -4, false),
				Arguments.of(-2, -4, 8, true), Arguments.of(-8, -9, -72, true), Arguments.of(-2, 4, -8, false),
				Arguments.of(-1, 3, -3, false), Arguments.of(3, 5, 15, true), Arguments.of(-6, 4, -24, false),
				Arguments.of(21, 14, 35, true));		
	}
	
	@Test
	//I'm just looking to make sure it knows how to math.
	void assertThatOnlyOneNegativeMultipliesLikeAChamp() {
		assertThat(testDemo.multiplyOnlyOneNegative(0, -5)).isEqualTo(0);
		assertThat(testDemo.multiplyOnlyOneNegative(1, -5)).isEqualTo(-5);
		assertThat(testDemo.multiplyOnlyOneNegative(-3, 3)).isEqualTo(-9);
		assertThat(testDemo.multiplyOnlyOneNegative(-5, 5)).isEqualTo(-25);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		 int fiveSquared = mockDemo.randomNumberSquared();
		 assertThat(fiveSquared).isEqualTo(25);
	}
	
	
	
	
	
	

//	@ParameterizedTest
//	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForDivisibleByNine")
//	void assertThatNumberIsDivisibleByNine(int a, int b, boolean isDivByNine) {
//		
//		if((a+b)%9 != 0) {
//			assertThatThrownBy(() -> testDemo.sumIsMultipleOfNine(a,b)).isInstanceOf(IllegalArgumentException.class);
//		} else {
//			assertThat((a+b)%9== 0== isDivByNine);
//		}
//		
//	}
//		static Stream<Arguments> argumentsForDivisibleByNine() {
//			return Stream.of(
//					Arguments.of(9, 0, true),
//					Arguments.of(45, 44, false),
//					Arguments.of(1881, -378, true),
//					Arguments.of(3, 5, false),
//					Arguments.of(956723454, 1404, true),
//					Arguments.of(354536, 456, false),
//					Arguments.of(0, -85, false),
//					Arguments.of(-9, -9, true)
//					);
//		}
//		

}
