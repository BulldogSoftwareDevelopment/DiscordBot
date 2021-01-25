package com.github.bulldogsoftwaredevelopment.discordbot.discord;

import com.github.bulldogsoftwaredevelopment.discordbot.util.EnumUtil;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.Channel;

public enum KnownChannel {
    GENERAL(687086140788178961L, ChannelType.TEXT),
    BOT_TESTING_CHANNEL(800871933263740998L, ChannelType.TEXT);

    private final long id;
    private final ChannelType type;

    KnownChannel(long id, ChannelType type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public ChannelType getType() {
        return type;
    }

    public String getName() {
        return EnumUtil.constantToName(this);
    }

    public Channel getChannel(DiscordApi api) {
        return api.getChannelById(this.getId()).orElse(null);
    }
}
