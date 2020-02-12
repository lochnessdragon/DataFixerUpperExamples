package DataFixerUpperExamples;

import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.datafixers.DSL;
import com.mojang.datafixers.DataFix;
import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.DataFixerBuilder;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.DynamicOps;

public class Main {
	
	public static void main(String args[]) {
		Logger logger = LogManager.getLogger();
		
		logger.info("Main started!");
		
		
		
		DataFixerBuilder dataFixerBuilder = new DataFixerBuilder(DataFixUtils.getVersion(DataFixUtils.makeKey(2)));


		
		
		logger.info("Adding Schemas");
		
		
		logger.info("Adding data fixes");
		
		
		logger.info("Building Fixer");
		DataFixer fixer = dataFixerBuilder.build(Executors.newSingleThreadExecutor());
		
		
	}

}
