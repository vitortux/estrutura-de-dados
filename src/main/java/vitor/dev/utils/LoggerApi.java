package vitor.dev.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerApi {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggerApi.class);

	public static void info(String info) {
		LOGGER.info(info);
	}

	public static void error(String error) {
		LOGGER.error(error);
	}
}
