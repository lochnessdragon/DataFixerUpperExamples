package DataFixerUpperExamples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.datafixers.DataFixerBuilder;

public class Main {
	
	public static void main(String args[]) {
		Logger logger = LogManager.getLogger();
		
		logger.info("Main started!");
		
		
		DataFixerBuilder dataFixerBuilder = new DataFixerBuilder(1);
	}

}
