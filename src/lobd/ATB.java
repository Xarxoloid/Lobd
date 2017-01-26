package lobd;

public class ATB {
	private static int charCount[];
	
	public static void doTick() {
		
		lobd.characters.forEach(character->{
			character.setTick(character.getTick() + 1);
			if (character.getTick() == (256 - character.getDex())) {
				System.out.println(character.getName() + ": TICK " + ++character.tickCount);
				character.setTick(0);
			}
			
		});
	}

}
