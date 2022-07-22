package Week2;
/*
    Write the method named twoOccurrences that has two String parameters named stringa and stringb. This method
    returns true if stringa appears at least twice in stringb, otherwise it returns false. For example, the call
    twoOccurrences(“by”, “A story by Abby Long”) returns true as there are two occurrences of “by”, the call
    twoOccurrences(“a”, “banana”) returns true as there are three occurrences of “a” so “a” occurs at least twice,
    and the call twoOccurrences(“atg”, “ctgtatgta”) returns false as there is only one occurence of “atg”.
 */


public class FindOccurrences {
    public Boolean twoOccurrences(String stringA, String stringB) {
        stringA = stringA.toLowerCase();
        stringB = stringB.toLowerCase();
        int occurrence1_index = stringB.indexOf(stringA);
        if (occurrence1_index == -1) {
            return false;
        }
        int occurrence2_index = stringB.indexOf(stringA, occurrence1_index+1);
        return occurrence2_index != -1;
    }
    public void testTwoOccurrences() {
        Boolean a = twoOccurrences("by", "A story by Abby Long");
        System.out.println(a); // True

        Boolean b = twoOccurrences("a", "banana");
        System.out.println(b); // True

        Boolean c = twoOccurrences("by", "Story of Abby");
        System.out.println(c); // False

        Boolean d = twoOccurrences("atg", "ctgtatgta");
        System.out.println(d);
    }
/*
    Write the method named lastPart that has two String parameters named stringa and stringb. This method finds the
    first occurrence of stringa in stringb, and returns the part of stringb that follows stringa.  If stringa does
    not occur in stringb, then return stringb. For example, the call lastPart(“an”, “banana”) returns the string “ana”,
     the part of the string after the first “an”. The call lastPart(“zoo”, “forest”) returns the string “forest” since
     “zoo” does not appear in that word.
 */

    public String lastPart(String stringA, String stringB) {
        stringA = stringA.toLowerCase();
        stringB = stringB.toLowerCase();

        int occurrence_index = stringB.indexOf(stringA);
        if (occurrence_index != -1) {
            return stringB.substring(occurrence_index + stringA.length());
        }
        return stringB;
    }
    public void testLastPart() {
        String a = "an";
        String b = "banana";
        String test1 = lastPart(a, b);
        System.out.println("The part of the string after " + a + " is " + test1);

        a = "zoo";
        b = "forest";
        String test2 = lastPart(a, b);
        System.out.println("The part of the string after " + a + " is " + test2);

    }
    public static void main(String[] args) {
        FindOccurrences f = new FindOccurrences();
        f.testTwoOccurrences();
        f.testLastPart();
    }
}
