package lobd;

import java.sql.SQLException;
import java.util.ArrayList;

public class Combat {
	
	public static ArrayList<Enemy> enemys = new ArrayList<Enemy>();
	
	Combat(ArrayList<Integer> enemyIds) {
		enemyIds.forEach(enemy->{
			try {
				enemys.add(lobd.getDb().getEnemyDao().queryForId(String.valueOf(enemy)));
				System.out.println("Enemy Added");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}
	
	public void prepare() {
		System.out.println("List all Enemys:");
		enemys.forEach(enemy->{
			System.out.println("Name " + enemy.getName());
		});
	}
}
