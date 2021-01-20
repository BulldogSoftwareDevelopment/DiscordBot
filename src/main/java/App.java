import it.sauronsoftware.cron4j.Scheduler;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class App {

    public static void main(String[] args) {
        Logger.LogWarning("%s", args);
        DiscordApi Client = new DiscordApiBuilder()
                .setToken(System.getenv("DISCORD_BOT_TOKEN"))
                .login()
                .join();

        Logger.LogSuccess("Successfully logged in as %s!", Client.getYourself().getDiscriminatedName());

        meetingAnnouncement();

        Client.addMessageCreateListener((message) -> {

            /*

                A simple ping/pong command. Whenever a user types in '>ping', we get the current time and then have the bot
                create a message containing "Pong!". After the message sends, we run a callback and get the current time after
                the message creation, and edit our message to contain the time it took for the bot to send the message after
                we invoke the command.

             */

            if(message.getMessageContent().startsWith(">ping"))
            {
                long InvokeTime = System.currentTimeMillis();
                message.getChannel().sendMessage("Pong!")
                        .thenAccept((m) -> {
                            long SentTime = System.currentTimeMillis();
                            double diff = (double)(SentTime - InvokeTime) / 1000;
                            m.edit("Pong! Took " + diff + " second(s)");
                        });
            }
        });
    }

    public static void meetingAnnouncement() {
        Scheduler s = new Scheduler();

        // At 2:45 each Monday, print a meeting warning message
        s.schedule("45 14 * * Mon", () -> System.out.println("Meeting will be starting soon!"));
        s.start();
    }



}
