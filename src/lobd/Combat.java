package lobd;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Combat {
	
	private static HashMap<Integer, Enemy> enemys = new HashMap<Integer, Enemy>();
	
	Combat(ArrayList<Integer> enemyIds) {
		enemyIds.forEach(enemy->{
			try {
				Enemy temp = LobdApp.getDb().getEnemyDao().queryForId(String.valueOf(enemy));
				enemys.put((enemys.size() + 1), temp);
				System.out.println("Enemy Added");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}
	
	public void prepare() {
	}
	
	public void fight() {
		
		int i = 0;
		while (i < 100000) {
			ATB.doTick();
			i++;
		}
	}

	/**
	 * @return the enemys
	 */
	public static HashMap<Integer, Enemy> getEnemys() {
		return enemys;
	}

	/**
	 * @param enemys the enemys to set
	 */
	public static void setEnemys(HashMap<Integer, Enemy> enemys) {
		Combat.enemys = enemys;
	}
}
