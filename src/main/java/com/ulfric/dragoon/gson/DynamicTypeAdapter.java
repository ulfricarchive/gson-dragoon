package com.ulfric.dragoon.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import com.ulfric.commons.collection.Collectors2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class DynamicTypeAdapter extends TypeAdapter<Object> {

	private final List<TypeToken<?>> types;

	public DynamicTypeAdapter(TypeToken<?>... types) {
		this.types = Arrays.stream(types)
				.filter(Objects::nonNull)
				.collect(Collectors2.toUnmodifiableList());
	}

	public final List<TypeToken<?>> getTypes() {
		return types;
	}

}
