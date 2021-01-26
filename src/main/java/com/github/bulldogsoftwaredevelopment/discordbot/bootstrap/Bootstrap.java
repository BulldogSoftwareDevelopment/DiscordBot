package com.github.bulldogsoftwaredevelopment.discordbot.bootstrap;

import com.github.bulldogsoftwaredevelopment.discordbot.EntryPoint;

public class Bootstrap {
    public static void main(String[] args) {
        EntryPoint entryPoint = new EntryPoint();

        Runtime.getRuntime().addShutdownHook(new Thread(entryPoint::stop));

        entryPoint.start();
    }
}
