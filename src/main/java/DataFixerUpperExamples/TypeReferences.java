package DataFixerUpperExamples;

import com.mojang.datafixers.DSL.TypeReference;

public class TypeReferences {
	public static final TypeReference LEVEL = () -> {
		return "level";
	};
	public static final TypeReference RECURSIVE = () -> {
		return "recursive";
	};
}
