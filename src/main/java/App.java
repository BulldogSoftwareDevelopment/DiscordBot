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
    }

    public static void meetingAnnouncement() {
        Scheduler s = new Scheduler();

        // At 2:45 each Monday, print a meeting warning message
        s.schedule("45 14 * * Mon", () -> System.out.println("Meeting will be starting soon!"));
        s.start();
    }



}
