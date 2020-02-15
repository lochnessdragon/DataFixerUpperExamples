package DataFixerUpperExamples.schemas;

import java.util.Map;
import java.util.function.Supplier;

import com.google.common.collect.Maps;
import com.mojang.datafixers.DSL;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.templates.TypeTemplate;

import DataFixerUpperExamples.TypeReferences;

public class Version2 extends Schema {

	public Version2(int versionKey, Schema parent) {
		super(versionKey, parent);
	}
  
	public void registerTypes(final Schema schema, final Map<String, Supplier<TypeTemplate>> entityTypes, final Map<String, Supplier<TypeTemplate>> blockEntityTypes) {
		schema.registerType(false, TypeReferences.LEVEL, () -> {
			return DSL.constType(DSL.string());
		});
		schema.registerType(true, TypeReferences.RECURSIVE, () -> {
			return DSL.or(DSL.constType(DSL.intType()), DSL.constType(DSL.namespacedString()));
		});
		schema.registerType(false, TypeReferences.SCORE, () -> {
			return DSL.constType(DSL.intType());
		});
	}
	
	public Map<String, Supplier<TypeTemplate>> registerEntities(final Schema schema) {
        Map<String, Supplier<TypeTemplate>> map = Maps.newHashMap();
		return map;
    }

    public Map<String, Supplier<TypeTemplate>> registerBlockEntities(final Schema schema) {
    	Map<String, Supplier<TypeTemplate>> map = Maps.newHashMap();		
		return map;
    }
	
}