

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;


public class Bot {
    private HashMap<String, Method> commands;

    public Bot() {
        commands = new HashMap<>();

        Class botCommandsClass = new BotCommands().getClass();
        for (Method m : botCommandsClass.getDeclaredMethods()) {
            if (!m.isAnnotationPresent(Command.class))
                continue;

            Command cmd = m.getAnnotation(Command.class);

            if(cmd.inProgress())
                continue;

            for (String name : cmd.aliases())
                commands.put(name, m);
        }
    }


    public String processUserInput(String input) {
        if (input.isEmpty())
            return "Я вас не понимаю";

        String[] splitted = input.split(" ");
        String command = splitted[0].toLowerCase();
        String[] args = Arrays.copyOfRange(splitted, 1, splitted.length);

        Method m = commands.get(command);

        if (m == null)
            return "Я вас не понимаю";

        try {
            return (String) m.invoke(this, (Object) args);
        } catch (Exception e) {
            return "Что-то пошло не так, попробуйте ещё раз";
        }


    }




}
