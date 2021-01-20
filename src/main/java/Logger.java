public class Logger {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static void LogWarning(String format, Object... args)
    {
        System.out.printf(ANSI_YELLOW + " [⚠️] " + format + ANSI_RESET + '\n', args);
    }

    public static void LogSuccess(String format, Object... args)
    {
        System.out.printf(ANSI_GREEN + " [✔️️] " + format + ANSI_RESET + '\n', args);
    }

    public static void LogError(String format, Object... args)
    {
        System.out.printf(ANSI_RED + " [❌] " + format + ANSI_RESET + '\n', args);
    }

}
