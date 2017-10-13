package com.ulfric.dragoon.gson;

import java.util.function.BiPredicate;

import com.google.gson.reflect.TypeToken;

public interface ComparisonStrategy extends BiPredicate<TypeToken<?>, TypeToken<?>> {

}
