package DataFixerUpperExamples;

import java.util.Objects;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.DataFixerBuilder;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.JsonOps;

import DataFixerUpperExamples.fixes.ChangeLevelName;
import DataFixerUpperExamples.schemas.Version1;
import DataFixerUpperExamples.schemas.Version2;

public class Main {
	
	public static void main(String args[]) {
		Logger logger = LogManager.getLogger();
		
		logger.info("Main started!");
		
		
		
		DataFixerBuilder dataFixerBuilder = new DataFixerBuilder(DataFixUtils.getVersion(DataFixUtils.makeKey(2)));


		
		
		logger.info("Adding Schemas");
		Schema schema1 = dataFixerBuilder.addSchema(1, Version1::new);
		Schema schema2 = dataFixerBuilder.addSchema(2, Version2::new);
		
		logger.info("Adding data fixes");
		dataFixerBuilder.addFixer(ChangeLevelName.create(schema2, "Rename level", (something) -> {
			return "hello";
		}));
		
		logger.info("Building fixer.");
		DataFixer fixer = dataFixerBuilder.build(Executors.newSingleThreadExecutor());
		
		Dynamic<JsonElement> input = new Dynamic<JsonElement>(JsonOps.INSTANCE, JsonOps.INSTANCE.createString("test1"));
		logger.info("Input: " + input.getValue().toString());
		Dynamic<JsonElement> output = fixer.update(TypeReferences.LEVEL, input, 1, 2);
		logger.info("Output: " + output.getValue().toString());
		
	}

}
