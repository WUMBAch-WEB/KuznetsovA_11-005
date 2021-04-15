import java.lang.reflect.Method;
import java.util.Arrays;

public class BotCommands {
    @Command(aliases = {"привет", "здаров"},
            args = "",
            description = "Будь культурным, поздоровайся.")
    public String hello(String[] args) { return "Привет!!"; }

    @Command(aliases = {"пока"},
            args = "",
            description = "")
    public String bye(String[] args) { return "Возвращайся!"; }

    @Command(aliases = {"помощь", "помоги", "команды", "help"},
            args = "",
            description = "Выводит список команд")
    public String help(String[] args) {
        StringBuilder builder = new StringBuilder("Я умею в такие команды:\n");

        for (Method m : this.getClass().getDeclaredMethods()) {
            if (!m.isAnnotationPresent(Command.class))
                continue;

            Command cmd = m.getAnnotation(Command.class);
            builder.append(Arrays.toString(cmd.aliases())).append(": ").append(cmd.description()).append(" - ").append(cmd.args()).append("\n");
        }

        return builder.toString();
    }


}
