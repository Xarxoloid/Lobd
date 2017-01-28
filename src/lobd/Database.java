package lobd;

import java.io.IOException;
import java.nio.file.*;

public class Database {
	

	public boolean saveToDisk() throws IOException {
		
		return true;
	}
	
	public void readFromDisk() throws IOException {
		
		String contents = new String(Files.readAllBytes(Paths.get("./save.txt")));
		System.out.println("Contents (Java 7) : " + contents);
	}

}
