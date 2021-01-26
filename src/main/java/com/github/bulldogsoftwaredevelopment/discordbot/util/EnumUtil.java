package com.github.bulldogsoftwaredevelopment.discordbot.util;

import java.util.Locale;

public class EnumUtil {
    public static <T extends Enum<T>> String constantToName(T constant) {
        String temp = constant.name();
        return temp.charAt(0) + temp.substring(1).toLowerCase(Locale.ROOT);
    }
}
