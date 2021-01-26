package com.github.bulldogsoftwaredevelopment.discordbot.discord;

import com.github.bulldogsoftwaredevelopment.discordbot.util.Log;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.Channel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.channel.VoiceChannel;
import org.javacord.api.entity.server.Server;

public class DiscordManager {
    private final DiscordApiBuilder builder;
    private DiscordApi api;
    private Server server;

    public DiscordManager() {
        this.builder = new DiscordApiBuilder().setToken(System.getenv("DISCORD_BOT_TOKEN"));
    }

    public void start() {
        try {
            Log.info("Logging into Discord...");

            api = builder.login().join();

            Log.info("Successfully logged into Discord!");
        } catch (Exception ex) {
            throw new RuntimeException("Failed to connect to Discord.", ex);
        }

        server = api.getServerById(687086140788178956L).orElse(null);
        if (server == null) {
            throw new RuntimeException("Could not find the Bulldog Software Development server!");
        }
    }

    public void stop() {
        api.disconnect();
    }

    public DiscordApi getApi() {
        return api;
    }

    public Channel getChannel(KnownChannel channel) {
        return channel.getChannel(api);
    }

    public TextChannel getTextChannel(KnownChannel channel) {
        if (channel.getType() != ChannelType.TEXT) {
            throw new IllegalArgumentException("Requested channel is not a text channel.");
        }

        return (TextChannel) getChannel(channel);
    }

    public VoiceChannel getVoiceChannel(KnownChannel channel) {
        if (channel.getType() != ChannelType.VOICE) {
            throw new IllegalArgumentException("Requested channel is not a voice channel.");
        }

        return (VoiceChannel) getChannel(channel);
    }


}
