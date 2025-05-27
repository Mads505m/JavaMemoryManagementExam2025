public class gcCheck {
    public static void main(String[] args) {
        String s = new String("hello");
        System.out.println(s);
    } // Rust ville drop det fra heapen her, men GC gør det når den ligger mærke til det
}
