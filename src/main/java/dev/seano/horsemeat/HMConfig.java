package dev.seano.horsemeat;

import eu.midnightdust.lib.config.MidnightConfig;

public class HMConfig {

	@MidnightConfig.Entry(category = "horse")
	public static boolean horseButcherChests = true;

	@MidnightConfig.Entry(category = "horse")
	public static boolean horseButcherTrades = true;

	@MidnightConfig.Entry(category = "horse")
	public static boolean horseDrop = true;

	@MidnightConfig.Entry(category = "llama")
	public static boolean llamaButcherChests = true;

	@MidnightConfig.Entry(category = "llama")
	public static boolean llamaButcherTrades = true;

	@MidnightConfig.Entry(category = "llama")
	public static boolean llamaDrop = true;
}
