package src.main.java;
import java.util.ArrayList;

public class PracticeITArrayList {

    /**
     * Write a method swapPairs that switches the order of values in an ArrayList of Strings in a pairwise fashion.
     * Your method should switch the order of the first two values, then switch the order of the next two,
     * switch the order of the next two, and so on.
     * If there are an odd number of values in the list, the final element is not moved.
     * For example, if the list initially stores these values: 
     * {"four", "score", "and", "seven", "years", "ago"} your method should switch the pairs to yield:
     * {"score", "four", "seven", "and", "ago", "years"}
     */
    public static void swapPairs(ArrayList<String> stringList) {
        for (int lcv = 0; lcv < stringList.size() - 1; lcv += 2) {
            String temp = stringList.get(lcv);
            stringList.set(lcv, stringList.get(lcv + 1));
            stringList.set(lcv + 1, temp);
        }
    }

    /**
     * Write a method removeEvenLength that takes an ArrayList of Strings as a parameter and that removes
     * all of the strings of even length from the list.
     */
    public static void removeEvenLength(ArrayList<String> stringList) {
        for (int lcv = 0; lcv < stringList.size(); lcv++) {
            String currentString = stringList.get(lcv);
            if (currentString.length() % 2 == 0) {
                stringList.remove(lcv);
                lcv--; 
            }
        }
    }

    /**
     * Write a method doubleList that takes an ArrayList of Strings as a parameter and that replaces
     * every string with two of that string.
     */
    public static void doubleList(ArrayList<String> stringList) {
        for (int lcv = 0; lcv < stringList.size(); lcv++) {
            String currentString = stringList.get(lcv);
            stringList.add(lcv + 1, currentString);
            lcv++; 
        }
    }

    /**
     * Write a method minToFront that takes an ArrayList of integers as a parameter and that moves the 
     * minimum value in the list to the front , otherwise preserving the order of the elements.
     */ 
    public static void minToFront(ArrayList<Integer> intList) {
        if (intList.isEmpty()) {
            return; 
        }

        int minValue = intList.get(0);
        int minIndex = 0;
        for (int lcv = 1; lcv < intList.size(); lcv++) {
            if (intList.get(lcv) < minValue) {
                minValue = intList.get(lcv);
                minIndex = lcv;
            }
        }
        intList.remove(minIndex);
        intList.add(0, minValue);
    }



    /**
     * Write a method removeDuplicates that takes as a parameter a sorted ArrayList of Strings and that
     * eliminates any duplicates from the list.
     */
    public static void removeDuplicates(ArrayList<String> stringList) {
        for (int lcv = 0; lcv < stringList.size() - 1; lcv++) {
            if (stringList.get(lcv).equals(stringList.get(lcv + 1))) {
                stringList.remove(lcv + 1);
                lcv--; 
            }
        }
    }

    /**
     * Write a method called removeInRange that accepts four parameters: 
     * an ArrayList of integers, an element value, a starting index, and an ending index.
     * The method's behavior is to remove all occurrences of the given element that appear
     * in the list between the starting index (inclusive) and the ending index (exclusive).
     */
    public static void removeInRange(ArrayList<Integer> intList, int element, int start, int end) {
        for (int lcv = start; lcv < end && lcv < intList.size(); lcv++) {
            if (intList.get(lcv) == element) {
                intList.remove(lcv);
                lcv--; 
                end--; 
            }
        }
    }

    /**
     * Write a method stutter that takes an ArrayList of Strings and an integer k as parameters
     * and that replaces every string with k copies of that string.
     */
    public static void stutter(ArrayList<String> stringList, int k) {
        if (k <= 0) { 
            stringList.clear();
            return;
        }

        int originalSize = stringList.size();
        for (int lcv = 0; lcv < originalSize; ++lcv) {
            String item = stringList.get(lcv * k); 
            for (int j = 1; j < k; ++j) {
                stringList.add(lcv * k + j, item); 
            }
        }
        


    }

     /**
     * Write a method removeShorterStrings that takes an ArrayList of Strings as a parameter 
     * and that removes from each successive pair of values the shorter string in the pair.  
     * For example, suppose that an ArrayList called list contains the following values:
     * {"four", "score", "and", "seven", "years", "ago"} 
     * In the first pair, "four" and "score", the shorter string is "four".  
     * In the second pair, "and" and "seven", the shorter string is "and".  
     * In the third pair, "years" and "ago", the shorter string is "ago".  
     * Therefore, the call: removeShorterStrings(list); should remove these shorter strings, 
     * leaving the list as follows: "score", "seven", "years". 
     * If there is a tie (both strings have the same length), your method should remove the first string in the pair.
     * If there is an odd number of strings in the list, the final value should be kept in the list.
     */
    // fix this one later, failing 7 tests
    public static void removeShorterStrings(ArrayList<String> stringList) {
        for (int lcv = 0; lcv < stringList.size() - 1; lcv += 2) {
            String str1 = stringList.get(lcv);
            String str2 = stringList.get(lcv + 1);
            if (str1.length() <= str2.length()) {
                stringList.remove(lcv);
                lcv--; 
            } else {
                stringList.remove(lcv + 1);
                
            }


        }
    }



    /**
     * Write a method called interleave that accepts two ArrayLists of integers a1 and a2 as parameters and 
     * inserts the elements of a2 into a1 at alternating indexes.  
     * If the lists are of unequal length, the remaining elements of the longer list are left at the end of a1.  
     * For example, if a1 stores [10, 20, 30] and a2 stores [4, 5, 6, 7, 8], the call of interleave(a1, a2); 
     * should change a1 to store [10, 4, 20, 5, 30, 6, 7, 8]. 
     * If a1 had stored [10, 20, 30, 40, 50] and a2 had stored [6, 7, 8], the call of interleave(a1, a2); 
     * would change a1 to store [10, 6, 20, 7, 30, 8, 40, 50].
     */ 
    public static void interleave(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        int index1 = 1;  
        for (int lcv = 0; lcv < list2.size(); lcv++) {
             if (index1 <= list1.size()){
            list1.add(index1, list2.get(lcv));
             index1 += 2;
             } else{
                list1.add(list2.get(lcv));
                index1 +=1;
             }
        }
    }
}
