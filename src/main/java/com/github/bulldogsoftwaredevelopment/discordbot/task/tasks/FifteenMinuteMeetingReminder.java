package com.github.bulldogsoftwaredevelopment.discordbot.task.tasks;

import com.github.bulldogsoftwaredevelopment.discordbot.task.Task;
import org.javacord.api.entity.channel.TextChannel;

public final class FifteenMinuteMeetingReminder extends Task {
    public FifteenMinuteMeetingReminder(TextChannel channel) {
        super(
                "15 Minute Meeting Reminder",
                "45 14 * * Mon",
                () -> channel.sendMessage("Hey @everyone, our next meeting will be starting in 15 minutes!")
        );
    }
}
