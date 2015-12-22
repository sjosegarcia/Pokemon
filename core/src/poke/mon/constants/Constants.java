package poke.mon.constants;

public class Constants {

	/*
	 * This is where the screen width is set
	 * */
	public static int width = 512;
	
	/*
	 * This is where the screen height is set
	 * */
	public static int height = 384;
	
	/*
	 * This is where you set if the game should be resizeable
	 * DESKTOP ONLY
	 * */
	public static final boolean resizable = true;
		
	/*
	 * This is where you set if the game should be fullscreen
	 * DESKTOP ONLY
	 * */
	public static final boolean fullscreen = false;
	
	/*
	 * This is where you set the title of the window
	 * */
	public static final String gameName = "PokemonGDX";
	
	/*
	 * This is the number of units the game is based on
	 * */
	public static final int units = 32;
	
	/*
	 * This is where you set the max party size of the trainer
	 * */
	public static final int partySize = 6;
	
	/*
	 * This is where you set the default level of a pokemon 
	 * */
	public static final byte defaultLevel = 5;
	
	/*
	 * This is where you set the chance for a pokemon to become 
	 * shiny, by default it is set at 16 out of 65536
	 * */
	public static final short shinyChance = 16;
	
	/*
	 * This is where you set the chance for a pokemon to obtain
	 * the pokerus status, by default it is set at 3 out of 65536
	 * */
	public static final byte pokerusChance = 3;
	
	/*
	 * This boolean is if you want to use the scaled formula 
	 * which was introduced in Pokemon X& Y or the older exp formula
	 * */
	public static final boolean scaledFormula = true;
}
