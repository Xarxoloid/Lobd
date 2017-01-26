package lobd;

public class ATB {
	public static int char1Count;
	
	public static void doTick() {
		
		if (lobd.characters.get(0) instanceof PlayerCharacter) {
			lobd.characters.get(0).setTick(lobd.characters.get(0).getTick() + 1);
			if (lobd.characters.get(0).getTick() == (256 - lobd.characters.get(0).getDex())) {
				System.out.println(lobd.characters.get(0).getName() + ": TICK " + ++char1Count);
				lobd.characters.get(0).setTick(0);
			}
		}
	}

}
