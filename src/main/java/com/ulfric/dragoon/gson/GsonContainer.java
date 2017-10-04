package com.ulfric.dragoon.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.ulfric.dragoon.ObjectFactory;
import com.ulfric.dragoon.application.Container;
import com.ulfric.dragoon.extension.inject.Inject;

public class GsonContainer extends Container {

	@Inject
	private ObjectFactory factory;

	public GsonContainer() {
		addBootHook(this::bind);
		addShutdownHook(this::unbind);
	}

	private void bind() {
		factory.bind(DynamicTypeAdapterFactory.class).toSingleton();

		Gson gson = new GsonBuilder()
			.serializeSpecialFloatingPointValues()
			.registerTypeAdapterFactory(factory.request(DynamicTypeAdapterFactory.class))
			.create();
		factory.bind(Gson.class).toValue(gson);
	}

	private void unbind() {
		factory.bind(Gson.class).toNothing();
	}

}
