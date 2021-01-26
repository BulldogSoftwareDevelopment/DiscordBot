package com.github.bulldogsoftwaredevelopment.discordbot;

import com.github.bulldogsoftwaredevelopment.discordbot.discord.DiscordManager;
import com.github.bulldogsoftwaredevelopment.discordbot.task.TaskManager;
import com.github.bulldogsoftwaredevelopment.discordbot.util.Log;

public class EntryPoint {
    private DiscordManager discordManager;
    private TaskManager taskManager;

    public void start() {
        Log.info("Bot is booting up...");

        discordManager = new DiscordManager();
        discordManager.start();

        taskManager = new TaskManager(discordManager);
        taskManager.registerTasks();
        taskManager.start();

        Log.info("Boot finished!");
    }

    public void stop() {
        Log.info("Bot is shutting down...");

        discordManager.stop();
        taskManager.stop();

        Log.info("Bye!");
    }

    public DiscordManager getDiscordManager() {
        return discordManager;
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }
}
