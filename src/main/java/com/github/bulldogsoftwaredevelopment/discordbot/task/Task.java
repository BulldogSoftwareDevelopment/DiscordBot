package com.github.bulldogsoftwaredevelopment.discordbot.task;

import com.github.bulldogsoftwaredevelopment.discordbot.util.Log;

public class Task {
    private final String name;
    private final String pattern;
    private final Runnable task;

    public Task(String name, String pattern, Runnable task) {
        this.name = name;
        this.pattern = pattern;
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public final String getPattern() {
        return pattern;
    }

    public final Runnable getTask() {
        return () -> {
            Log.info("Running scheduled task for: %s.", getName());
            task.run();
        };
    }
}
