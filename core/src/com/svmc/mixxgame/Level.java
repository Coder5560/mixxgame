package com.svmc.mixxgame;

import com.badlogic.gdx.math.MathUtils;

public class Level {

	private static int			LEVEL				= 1;
	private static int			MAX_LEVEL			= 10;

	public static final String	DEFAULT_NAME		= "no name";
	public static final String	DEFAULT_TYPE		= "static";
	public static final float	DEFAULT_ANGLE		= 0;
	public static final boolean	DEFAULT_ACTIVE		= true;
	public static float			DEFAULT_DENSITY		= 3;
	public static float			DEFAULT_RESTITUTION	= 0.5f;
	public static float			DEFAULT_FRICTION	= 1;
	public static boolean		DEFAULT_SENSOR		= false;

	private static LevelNotify	levelNotify;

	public static int getLevel() {
		return LEVEL;
	}

	public static void setLevel(int level) {
		LEVEL = MathUtils.clamp(level, 1, MAX_LEVEL);
		if (levelNotify != null)
			levelNotify.notifyChange();
	}

	public static void setLevelNotify(LevelNotify levelNotify) {
		Level.levelNotify = levelNotify;
	}

	public static int getMaxLevel() {
		return MAX_LEVEL;
	}

	public interface LevelNotify {
		public void notifyChange();
	}

	public static int getAutocreateBall() {
		switch (getLevel()) {
			case 5:
			case 6:
			case 7:
				return 1;
			case 8:
			case 9:
			case 10:
				return 2;
			default:
				return 0;
		}
	}

}
