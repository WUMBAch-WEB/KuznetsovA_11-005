import java.lang.reflect.Method;
import java.util.*;

public class BotCommands {

    Scanner in = new Scanner(System.in);
    ArrayList<Movie> moviesList = new ArrayList<>();
    ArrayList<Buyer> buyersList = new ArrayList<>();

    @Command(aliases = {"привет", "здаров"},
            args = "",
            description = "Будь культурным, поздоровайся.")
    public String hello(String[] args) { return "Привет!!"; }

    @Command(aliases = {"пока"},
            args = "",
            description = "")
    public String bye(String[] args) { return "Возвращайся!"; }

    @Command(aliases = {"добавить"},
            args = "Аргументы: 'Название фильма' 'Рейтинг фильма' 'Продюсер фильма'",
            description = "Команда для добавления фильма в прокат")
    public String addMovie(String[] args) {
        String name = args[0];
        String rating = args[1];
        String producer = args[2];
        moviesList.add(new Movie(name, rating, producer));
        return "";
    }
    @Command(aliases = {"фильмы"},
            args = "",
            description = "Команда для показа списка фильмов в прокате")
    public String showMoviesList(String[] args) {
        if (moviesList.size() == 0){
            return "Доступных фильмов нет, извините!";
        }
        else {
            for (int i = 0; i < moviesList.size(); i++){
                System.out.println("Фильм №" + (i + 1));
                System.out.println(moviesList.get(i));
            }
            System.out.println("Это список всех доступных фильмов.");
        }
        return "";
    }

    @Command(aliases = {"удалить"},
            args = "Аргументы это просто названия фильмов",
            description = "Команда для удаления фильма из проката")
    public String deleteMovie(String[] args){
        for (int i = 0; i < args.length; i++){
            for (int j = 0; j < moviesList.size(); j ++){
                if (moviesList.get(j).getName().equals(args[i])){
                    System.out.println("Фильм: " + args[i] + " успешно удален из проката");
                    moviesList.remove(j);
                    args[i] = "deleted";
                }
            }
        }
        for (int i = 0; i < args.length; i ++){
            if (!args[i].equals("deleted")){
                System.out.println("Фильма: " + args[i] + " итак нет в прокате!");
            }
        }
        return "";
    }
    @Command(aliases = {"найти"},
            args = "Аргументы это просто названия фильмов",
            description = "Команда для поиска фильмов в прокате")
    public String searchMovieInList(String[] args){
        int count = 0;
        for (int i = 0; i < args.length; i++){
            for (int j = 0; j < moviesList.size(); j ++){
                if (moviesList.get(j).getName().equals(args[i])){
                    System.out.println("Фильм: " + args[i] + " есть в прокате!");
                    count++;
                }
            }
        }
        if (count != 0){
            System.out.println("Кол-во найденных фильмов: " + count);
        }
        else{
            System.out.println("К сожалению, ни один фильм не найден");
        }
        return "";
    }

    @Command(aliases = {"купить"},
            args = "Аргументы: 'Название фильма' 'Кол-во билетов' 'Имя покупателя'",
            description = "Команда для покупки билетов")
    public String buy(String[] args){
        for (int i = 0; i < buyersList.size(); i++){
            if (args[2].equals(buyersList.get(i).getName())){
                buyersList.get(i).getTicketsMap().put(args[0],args[1]);
                System.out.println("Билеты успешно оформлены");
                return "";
            }
        }
        buyersList.add(new Buyer(args[2]));
        buy(args);
        return "";
    }

    @Command(aliases = {"билеты"},
            args = "Аргументов нет",
            description = "Команда для вывода списка покупателей")
    public String showBuyersList(String[] args){
        for (int i = 0; i < buyersList.size(); i++){
            System.out.println("Покупатель: " + buyersList.get(i).getName());
            System.out.println("Список фильмов, на которые куплены билеты: ");
            System.out.println(buyersList.get(i).getTicketsMap());
        }
        return "";
    }
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
