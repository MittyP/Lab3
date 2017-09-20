import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
/**
 *
 * @author Mitesh Patel
 *
 */
public class WebScraper {
/**
 * Will be used to read the String from urlToString.
 * Will count the number of words in the urlToString in the output.
 * @param args Some args.
 */
    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        String urlToPrint = "http://erdani.com/tdpl/hamlet.txt";
        System.out.println(urlToString(urlToPrint));
        String longText = urlToString(urlToPrint);
        int numWords = 0;
        for (int i = 0; i < longText.length(); i++) {
            if (longText.charAt(i) == ' ') {
                numWords++;
            }
        }
        System.out.println("Number of Words: " + numWords);
        specificWordCount("Prince", longText);
        specificWordCountNoCase("Prince", longText);
    }
   /**
    * Counts instances of a specific word to look for in a string.
    * @param wordToCheck The specific word to look for.
    * @param wholeText The entire text to search through.
    */
    public static void specificWordCount(final String wordToCheck, final String wholeText) {
        int numSpecificWord = 0;
        for (int i = 0; i < wholeText.length() - wordToCheck.length(); i++) {
            if (wholeText.substring(i, i + wordToCheck.length()).equals(wordToCheck)) {
                numSpecificWord++;
            }
        }
        System.out.println("Number of occurrences of " + wordToCheck + ": " + numSpecificWord);
    }
    /**
     * Counts instances of a specific word to look for in a string.
     * However, this version is case-insensitive.
     * @param wordToCheck The specific word to look for.
     * @param wholeText The entire text to search through.
     */
     public static void specificWordCountNoCase(final String wordToCheck, final String wholeText) {
         int numSpecificWord = 0;
         String wordToCheckUpper = wordToCheck.toUpperCase();
         String wholeTextUpper = wholeText.toUpperCase();
         for (int i = 0; i < wholeTextUpper.length() - wordToCheckUpper.length(); i++) {
             if (wholeTextUpper.substring(i, i + wordToCheckUpper.length()).equals(wordToCheckUpper)) {
                 numSpecificWord++;
             }
         }
         System.out.println("Number of occurrences of " + wordToCheck + ": "
         + numSpecificWord + ", case-insensitive.");
     }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}