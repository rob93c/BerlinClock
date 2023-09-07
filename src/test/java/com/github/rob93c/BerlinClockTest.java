package com.github.rob93c;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BerlinClockTest {

	@Test
	void checkSeconds() {
		assertAll(
				() -> assertEquals("O", new BerlinClock("00:00:01").getSeconds()),
				() -> assertEquals("Y", new BerlinClock("23:23:54").getSeconds())
		);
	}

	@Test
	void checkHours() {
		assertAll(
				() -> assertEquals("OOOO\nOOOO", new BerlinClock("00:00:01").getHours()),
				() -> assertEquals("RRRR\nRRRO", new BerlinClock("23:23:54").getHours())
		);
	}

	@Test
	void checkMinutes() {
		assertAll(
				() -> assertEquals("OOOOOOOOOOO\nOOOO", new BerlinClock("00:00:01").getMinutes()),
				() -> assertEquals("YYRYOOOOOOO\nYYYO", new BerlinClock("23:23:54").getMinutes())
		);
	}

	@Test
	void checkBerlinClock() {
		var expectedLights = """
				O
				RROO
				RROO
				YYRYYRYYRYY
				YOOO""";

		assertEquals(expectedLights, new BerlinClock("12:56:01").getTime());
	}
}
