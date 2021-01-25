package com.github.bulldogsoftwaredevelopment.discordbot.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class Log {
    private static final Logger LOGGER;

    static {
        Configurator.setRootLevel(Level.INFO);
        LOGGER = LogManager.getLogger("DiscordBotLogger");
    }

    public static void info(String message, Object... args) {
        LOGGER.info(String.format(message, args));
    }

    public static void warn(String message, Object... args) {
        LOGGER.warn(String.format(message, args));
    }

    public static void error(String message, Object... args) {
        LOGGER.error(String.format(message, args));
    }
}
