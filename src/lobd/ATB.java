package lobd;

import java.util.Map;

public class ATB {
	
	/**
	 * Does one "tick" for each Player Character created
	 */
	public static void doTick() {
		
		for(Map.Entry<Integer, PlayerCharacter> entry : LobdApp.getCharacters().entrySet()) {
			entry.getValue().setTick(entry.getValue().getTick() + 1);
			entry.getValue().calculateSpeedMod();
			if (entry.getValue().getTick() == (511 - Math.round((entry.getValue().getTempo() * entry.getValue().getSpeedMod())))) {
				System.out.println(entry.getValue().getName() + ": TICK " + ++entry.getValue().tickCount);
				entry.getValue().setTick(0);
			}
		}
		
		for(Map.Entry<Integer, Enemy> entry : Combat.getEnemys().entrySet()) {
			entry.getValue().setTick(entry.getValue().getTick() + 1);
			entry.getValue().calculateSpeedMod();
			if (entry.getValue().getTick() == (511 - Math.round((entry.getValue().getDex() * entry.getValue().getSpeedMod())))) {
				System.out.println(entry.getValue().getName() + ": TICK " + ++entry.getValue().tickCount);
				entry.getValue().setTick(0);
			}
		}
	}
}
