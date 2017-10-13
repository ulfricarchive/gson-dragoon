package com.ulfric.dragoon.gson;

import com.google.gson.reflect.TypeToken;

public enum ComparisonStrategies implements ComparisonStrategy {

	POLYMORPHIC {
		@SuppressWarnings("deprecation")
		@Override
		public boolean test(TypeToken<?> t, TypeToken<?> u) {
			return t.isAssignableFrom(u); // TODO deprecated
		}
	},

	SAME_RAW {
		@Override
		public boolean test(TypeToken<?> t, TypeToken<?> u) {
			return t.getRawType() == u.getRawType();
		}
	};

}
