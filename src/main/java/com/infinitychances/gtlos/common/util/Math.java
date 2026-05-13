package com.infinitychances.gtlos.common.util;

import java.util.Random;

public class Math {
	public static int secondsToTicks(int seconds) {
		return seconds*20;
	}

	public static int randomAddSubHex(int hex, long seed) {
		Random random = new Random(seed << 3);
		int max_bound = new Random(seed << 3).nextInt(20);
		int mc = 256;
		int r = mc * mc * (random.nextInt(0, max_bound * 2 + 1) - max_bound);
		int g = mc * (random.nextInt(0, max_bound * 2 + 1) - max_bound);
		int b = (random.nextInt(0, max_bound * 2 + 1) - max_bound);
		int finale = hex + r + g + b;
		while (finale <= 0) {
			r = mc * mc * (random.nextInt(0, max_bound * 2 + 1) - max_bound);
			g = mc * (random.nextInt(0, max_bound * 2 + 1) - max_bound);
			b = (random.nextInt(0, max_bound * 2 + 1) - max_bound);
			finale = hex+r+g+b;
		}
		return finale;
	}
}
