package lobd;

public class ATB {
	
	/**
	 * Does one "tick" for each Player Character created
	 */
	public static void doTick() {
		
		lobd.getCharacters().forEach(character->{
			character.setTick(character.getTick() + 1);
			character.calculateSpeedMod();
			if (character.getTick() == (511 - Math.round((character.getDex() * character.getSpeedMod())))) {
				System.out.println(character.getName() + ": TICK " + ++character.tickCount);
				character.setTick(0);
			}
			
		});
		
		Combat.enemys.forEach(enemy->{
			enemy.setTick(enemy.getTick() + 1);
			enemy.calculateSpeedMod();
			if (enemy.getTick() == (511 - Math.round((enemy.getDex() * enemy.getSpeedMod())))) {
				System.out.println(enemy.getName() + ": TICK " + ++enemy.tickCount);
				enemy.setTick(0);
			}
		});
	}

}
