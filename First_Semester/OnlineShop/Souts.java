package OnlineShop;

public abstract class Souts {
    public static void welcomeMessage() {
        System.out.println("Добро пожаловать в *ShopName*.");
        System.out.println("В нашем магизне Вы найдете множество различных товаров.");
        System.out.println("Чтобы продолжить Вам необходимо авторизоваться или зарегистрироваться.");
        System.out.println("[1]Зарегистрироваться   [2]Авторизоваться   [3]Выход из системы");
    }
    public static void messageAboutFunctionsOfAdmin(){
        System.out.println("Доступные функции: ");
        System.out.println("[1]Полный список пользователей [2]Заблокировать пользователя");
        System.out.println("[3]Добавить новый товар        [4]Удалить товар   ");
        System.out.println("[X]Вывести историю продаж      [6]Вывести ассортимент");
        System.out.println("[7]Выйти из аккаунта администратора");
    }
    public static void messageAboutFunctionsOfUser(){
        System.out.println("Доступные функции: ");
        System.out.println("[1]Посмотреть ассортимент  [X]Перейти в корзину");
        System.out.println("[3]История моих покупок    [4]Изменить данные аккаунта");
        System.out.println("[5]Сделать заказ           [6]Выйти из аккаунта");
    }
}
