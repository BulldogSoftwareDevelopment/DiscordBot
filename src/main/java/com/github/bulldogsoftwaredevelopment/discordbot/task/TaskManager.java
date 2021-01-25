package com.github.bulldogsoftwaredevelopment.discordbot.task;

import com.github.bulldogsoftwaredevelopment.discordbot.discord.DiscordManager;
import com.github.bulldogsoftwaredevelopment.discordbot.discord.KnownChannel;
import com.github.bulldogsoftwaredevelopment.discordbot.task.tasks.FifteenMinuteMeetingReminder;
import com.github.bulldogsoftwaredevelopment.discordbot.task.tasks.OneHourMeetingReminder;
import it.sauronsoftware.cron4j.Scheduler;
import org.javacord.api.entity.channel.TextChannel;

import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

public final class TaskManager {
    private final DiscordManager discordManager;
    private final Scheduler scheduler;

    public TaskManager(DiscordManager discordManager) {
        this.discordManager = discordManager;

        Scheduler scheduler = new Scheduler();
        scheduler.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        this.scheduler = scheduler;
    }

    public final void registerTasks() {
        TextChannel general = discordManager.getTextChannel(KnownChannel.GENERAL);

        // We use a list as I expect we will have multiple scheduled tasks.
        List<Task> tasks = Arrays.asList(
                new OneHourMeetingReminder(general),
                new FifteenMinuteMeetingReminder(general)
        );

        tasks.forEach(task -> scheduler.schedule(task.getPattern(), task.getTask()));
    }

    public final void start() {
        scheduler.start();
    }

    public final void stop() {
        scheduler.stop();
    }
}
