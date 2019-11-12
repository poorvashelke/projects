package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class squareTest {

	@Test
	void test() {
		JunitTsting test = new JunitTsting();
		int output = test.square(3);
		assertEquals(9, output);
	}

}
