package OnlineShop;

public abstract class Souts {
    public static void welcomeMessage() {
        System.out.println("Добро пожаловать в *ShopName*.");
        System.out.println("В нашем магизне Вы найдете множество различных товаров.");
        System.out.println("Чтобы продолжить Вам необходимо авторизоваться или зарегестрироваться.");
        System.out.println("[1]Зарегестрироваться   [2]Авторизоваться");
    }
    public static void messageAboutFunctionsOfAdmin(){
        System.out.println("Доступные функции: ");
        System.out.println("[1]Полный список пользователей [2]Заблокировать пользователя");
        System.out.println("[3]Добавить новый товар        [4]Удалить товар   ");
        System.out.println("[5]Вывести историю продаж      [6]Вывести ассортимент");
        System.out.println("[7]Выйти из аккаунта администратора");
    }
}
