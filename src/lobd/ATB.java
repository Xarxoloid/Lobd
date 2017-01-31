package lobd;

public class ATB {
	private static int charCount[];
	
	
	/**
	 * Does one "tick" for each Player Character created
	 */
	public static void doTick() {
		
		lobd.getCharacters().forEach(character->{
			character.setTick(character.getTick() + 1);
			character.calculateSpeedMod();
			if (character.getTick() == (511 - Math.round((character.getDex() * character.getSpeedMod())))) {
				System.out.println(character.getName() + ": TICK ");
				character.setTick(0);
			}
			
		});
	}

}
