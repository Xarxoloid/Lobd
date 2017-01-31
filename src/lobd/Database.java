package lobd;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Database {

	private Dao<PlayerCharacter, String> playerCharacterDao = null;
	private Dao<Enemy, String> enemyDao = null;
	
	Database() throws SQLException {
		// Database Setup Block
		// create a connection source to our database
        String databaseUrl = "jdbc:sqlite:save/test.db";
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
        // Setting up Data Access Objects (Dao's)
        this.setPlayerCharacterDao(DaoManager.createDao(connectionSource, PlayerCharacter.class));
        this.setEnemyDao(DaoManager.createDao(connectionSource, Enemy.class));
        // Creating Tables if not present
        TableUtils.createTableIfNotExists(connectionSource, PlayerCharacter.class);
        TableUtils.createTableIfNotExists(connectionSource, Enemy.class);
        // End of Database Setup Block
	}

	/**
	 * @return the playerCharacterDao
	 */
	public Dao<PlayerCharacter, String> getPlayerCharacterDao() {
		return playerCharacterDao;
	}

	/**
	 * @param playerCharacterDao the playerCharacterDao to set
	 */
	public void setPlayerCharacterDao(Dao<PlayerCharacter, String> playerCharacterDao) {
		this.playerCharacterDao = playerCharacterDao;
	}

	/**
	 * @return the enemyDao
	 */
	public Dao<Enemy, String> getEnemyDao() {
		return enemyDao;
	}

	/**
	 * @param enemyDao the enemyDao to set
	 */
	public void setEnemyDao(Dao<Enemy, String> enemyDao) {
		this.enemyDao = enemyDao;
	}
			
}
