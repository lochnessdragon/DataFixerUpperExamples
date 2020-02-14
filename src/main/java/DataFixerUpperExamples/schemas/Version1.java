package DataFixerUpperExamples.schemas;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.datafixers.DSL;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.Type;
import com.mojang.datafixers.types.families.RecursiveTypeFamily;
import com.mojang.datafixers.types.families.TypeFamily;
import com.mojang.datafixers.types.templates.TypeTemplate;

import DataFixerUpperExamples.TypeReferences;
import it.unimi.dsi.fastutil.objects.Object2IntMap;

public class Version1 extends Schema {

	public Version1(int versionKey, Schema parent) {
		super(versionKey, parent);
	}
	
	public Version1() {
	  super(1, null);
	}
	
	public void registerTypes(final Schema schema, final Map<String, Supplier<TypeTemplate>> entityTypes, final Map<String, Supplier<TypeTemplate>> blockEntityTypes) {
		schema.registerType(false, TypeReferences.LEVEL, () -> {
			return DSL.constType(DSL.string());
		});
		schema.registerType(true, TypeReferences.RECURSIVE, () -> {
			return DSL.or(DSL.constType(DSL.intType()), DSL.constType(DSL.namespacedString()));
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
