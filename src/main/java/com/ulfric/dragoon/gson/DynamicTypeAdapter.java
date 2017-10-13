package com.ulfric.dragoon.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import com.ulfric.commons.collection.Collectors2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class DynamicTypeAdapter extends TypeAdapter<Object> {

	private final ComparisonStrategy comparisonStrategy;
	private final List<TypeToken<?>> types;

	public DynamicTypeAdapter(ComparisonStrategy comparisonStrategy, TypeToken<?>... types) {
		Objects.requireNonNull(comparisonStrategy, "comparisonStrategy");

		this.comparisonStrategy = comparisonStrategy;
		this.types = Arrays.stream(types)
				.filter(Objects::nonNull)
				.collect(Collectors2.toUnmodifiableList());
	}

	public final boolean matches(TypeToken<?> type) {
		for (TypeToken<?> convertable : types) {
			if (comparisonStrategy.test(convertable, type)) {
				return true;
			}
		}

		return false;
	}

}
