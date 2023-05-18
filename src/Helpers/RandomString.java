package Helpers;

public class RandomString {
    private static final String alNumString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";

    /**
     * Generates a random String consisting of alphanumeric characters of given size
     * @param size
     * @return The random String
     */
    public static String getRandomAlNumString(short size){
        char[] out = new char[size];

        for (short i=0; i<size; i++){
            out[i] = alNumString.charAt( (int) Math.floor( Math.random()*alNumString.length() ) );

        }
        return new String(out);
    }
}
