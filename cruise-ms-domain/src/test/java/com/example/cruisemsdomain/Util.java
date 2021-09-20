package com.example.cruisemsdomain;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.example.cruisemsdomain.model.Gender;

public class Util {
	private Util() {
	}

	public static Gender randomGender() {
		return randomInteger() % 2 == 0 ? Gender.FEMALE : Gender.MALE;
	}
	
	public static String randomString() {
		return UUID.randomUUID().toString();
	}

	public static Integer randomInteger() {
		return ThreadLocalRandom.current().nextInt();
	}

	public static Long randomLong() {
		return ThreadLocalRandom.current().nextLong();
	}
}
