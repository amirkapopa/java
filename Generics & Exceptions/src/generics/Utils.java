package generics;

public class Utils {
    public static  <T extends Comparable<T>> T max(T first, T second) {
       return( first.compareTo(second) > 0) ? first : second;
    }
    public static <K , V > void print (K key , V value  ) {
        System.out.print(key + " ");

    }
    public static void printUser(User user) {
        System.out.println(user);
    }
    public static void printUser
            (GenericList<? extends User > users) {
        User  x = users.get(0);

    }
}
