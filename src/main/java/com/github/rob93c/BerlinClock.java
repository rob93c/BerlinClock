package com.github.rob93c;

record BerlinClock(int hours, int minutes, int seconds) {
	BerlinClock(String time) {
		this(time.split(":"));
	}

	private BerlinClock(String[] time) {
		this(Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]));
	}

	String getSeconds() {
		return seconds % 2 == 0 ? "Y" : "O";
	}

	String getHours() {
		int lightsOnFirstRow = hours / 5;
		int lightsOnSecondRow = hours % 5;

		var firstRow = "R".repeat(lightsOnFirstRow) + "O".repeat(4 - lightsOnFirstRow);
		var secondRow = "R".repeat(lightsOnSecondRow) + "O".repeat(4 - lightsOnSecondRow);

		return firstRow + "\n" + secondRow;
	}

	String getMinutes() {
		int lightsOnFirstRow = minutes / 5;
		int lightsOnSecondRow = minutes % 5;

		var firstRow = new StringBuilder();
		for (int i = 1; i <= lightsOnFirstRow; i++) {
			if (i % 3 == 0) {
				firstRow.append("R");
				continue;
			}

			firstRow.append("Y");
		}

		firstRow.append("O".repeat(11 - lightsOnFirstRow));

		var secondRow = "Y".repeat(lightsOnSecondRow) + "O".repeat(4 - lightsOnSecondRow);

		return firstRow + "\n" + secondRow;
	}

	String getTime() {
		return getSeconds() + "\n" + getHours() + "\n" + getMinutes();
	}
}
