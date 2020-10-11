//Дана строка из нескольких слов, разделённых пробелами. Отсортировать слова в ней по алфавиту, т.е. из “bca cba cab acb” получить “acb bca cab cba”. Оценить сложность полученного алгоритма по времени и по памяти. Не использовать встроенные методы сортировки.
import java.util.Scanner;
class q42 {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку:");
        String str  = in.nextLine();
        String[] words = str.split(" ");
        for (int i=0; i<words.length-1; i++)
            for (int j=i; j>=0; j--)
                if (words[j].compareTo(words[j+1])>0) {

                    str = words[j];
                    words[j] = words[j+1];
                    words[j+1] = str;
                }
        System.out.println("Результат сортировки: ");
        for (String word : words) {
            System.out.println(word);
        }


    }
}