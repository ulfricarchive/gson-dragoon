package com.ulfric.dragoon.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DynamicTypeAdapterFactory implements TypeAdapterFactory {

	private final List<DynamicTypeAdapter> typeAdapters = new ArrayList<>();

	public void register(DynamicTypeAdapter typeAdapter) {
		Objects.requireNonNull(typeAdapter, "typeAdapter");

		typeAdapters.add(typeAdapter);
	}

	public void unregister(DynamicTypeAdapter typeAdapter) {
		Objects.requireNonNull(typeAdapter, "typeAdapter");

		typeAdapters.remove(typeAdapter);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
		for (DynamicTypeAdapter typeAdapter : typeAdapters) {
			if (typeAdapter.matches(type)) {
				return (TypeAdapter<T>) typeAdapter;
			}
		}

		return null;
	}

}
