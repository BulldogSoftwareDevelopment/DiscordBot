# DiscordBot

Bulldog Software Development's Discord bot project.

# Prerequisites

- [Java - Version 8 >](https://www.java.com/en/download/)
- [Maven](https://maven.apache.org/download.cgi)

# Setup: Four Easy Steps.

1. Clone the repository by opening your terminal of choice and then run `git clone https://github.com/BulldogSoftwareDevelopment/DiscordBot`.

2. Simply open the folder in your IDE of choice! IntelliJ is preferred. IntelliJ will automatically download dependencies using Maven, our dependency management tool.

3. Once all is said and done, you will need a token. To find out how to create a bot account and access its token, please follow the instructions listed [here](https://discordpy.readthedocs.io/en/latest/discord.html).

4. In IntelliJ, there is a button titled `Add Configuration...`. Click that. Then press the `+` in the top left and choose Maven. In `command line`, enter `clean install`. Press `apply` and `ok`, and then press the green `Play` button to build the project for the first time. It should build successfully. Expand the dropdown for configurations and press `Edit Configurations...`. Then, press the `+` in the top left again and choose `JAR Application`. For `path to jar`, use the folder button in the right of the input and navigate to this project's folder on your local machine. Enter the `target` directory, and choose the jar file that is **NOT** prefixed with `original-`. Now press the `$` in the `Environment Variables` section. Press the `+` button, and create a new `Environment Variable` with the title `DISCORD_BOT_TOKEN` (capitalization matters). For the value, enter the token you got in the previous step. Press `apply` and `ok`. The `JAR Application` configuration should be automatically selected. If it is not, select it. Then, press the `Play` button to now build and run the bot at the same time. You should now see it in Discord.

If you have any questions regarding this process or need any help, feel free to ping one of us in the Discord server!

# Dependencies
- [Javacord - Version 3.1.2](https://javacord.org/)
- [Cron4J - Version 2.2.5](https://www.sauronsoftware.it/projects/cron4j/)
- [Log4J - Version 2.14.0](https://logging.apache.org/log4j/2.x/)
- [SLF4J - Version 2.0.0-alpha1](http://www.slf4j.org/)