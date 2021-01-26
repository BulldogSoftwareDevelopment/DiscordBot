package com.github.bulldogsoftwaredevelopment.discordbot.task.tasks;

import com.github.bulldogsoftwaredevelopment.discordbot.task.Task;
import org.javacord.api.entity.channel.TextChannel;

public final class OneHourMeetingReminder extends Task {
    public OneHourMeetingReminder(TextChannel channel) {
        super(
                "1 Hour Meeting Reminder",
                "00 14 * * Mon",
                () -> channel.sendMessage("Hey @everyone, our next meeting will be starting in 1 hour!")
        );
    }
}
