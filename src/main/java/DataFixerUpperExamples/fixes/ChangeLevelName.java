package DataFixerUpperExamples.fixes;

import java.util.function.Function;

import com.mojang.datafixers.DSL;
import com.mojang.datafixers.DataFix;
import com.mojang.datafixers.TypeRewriteRule;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.Type;
import com.mojang.datafixers.util.Pair;

import DataFixerUpperExamples.TypeReferences;

public abstract class ChangeLevelName extends DataFix {

	private final String name;
	
	public ChangeLevelName(Schema outputSchema, String name) {
		super(outputSchema, false);
		this.name = name;
	}

	@Override
	public TypeRewriteRule makeRule() {
		//Type<?> type = this.getOutputSchema().getType(TypeReferences.LEVEL);
		
		Type<Pair<String, String>> type1 = DSL.named(TypeReferences.LEVEL.typeName(), DSL.string());
		
		TypeRewriteRule rule = this.fixTypeEverywhere(this.name, type1, (function) -> {
			return (pair) -> {
	           return pair.mapSecond(this::fixName);
	        };
		});
		
		return rule;
	}
	
	protected abstract String fixName(String something);
	
	public static DataFix create(Schema outputSchema, String string, final Function<String, String> function) {
	      return new ChangeLevelName(outputSchema, string) {
	         protected String fixName(String p_206309_1_) {
	            return function.apply(p_206309_1_);
	         }
	      };
	   }

}
