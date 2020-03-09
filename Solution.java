import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class Solution {

  /**
   * Check if these strings are anagrams.
   */
  static boolean areAnagram(String sa, String sb) {

    // **** populate character arrays ****
    char[] aa = sa.toCharArray();
    char[] ab = sb.toCharArray();

    // **** sort character arrays ****
    Arrays.sort(aa);
    Arrays.sort(ab);

    // **** traverse arrays checking for mismatches ****
    for (int i = 0; i < aa.length; i++) {
      if (aa[i] != ab[i]) {
        return false;
      }
    }

    // **** strings are anagrams ****
    return true;
  }

  /**
   * Complete the sherlockAndAnagrams function below.
   */
 static int sherlockAndAnagrams(String s) {

    // **** initialize count of anagrams ****
    int count = 0;

    // **** loop once per grouping of characters [1 : s.length() - 1] ****
    for (int g = 1; g < s.length(); g++) {

      // **** generate the base sub string ****
      for (int i = 0; i < s.length() - g; i++) {

        // **** starting string ****
        String bs = s.substring(i, i + g);

        // **** generate sub strings ****
        for (int j = i + 1; j <= s.length() - g; j++) {

          // **** generate current sub string ****
          String cs = s.substring(j, j + g);

          // **** check if anagram ****
          if (areAnagram(bs, cs)) {
            count++;
          }
        }
      }
    }

    // **** count of anagrams ****
    return count;
  }

  // **** open scanner ****
  private static Scanner sc = new Scanner(System.in);
  
  /**
   * Test scaffolding.
   */
  public static void main(String[] args) {
    
    // **** read the number of tests ****
    int q = Integer.parseInt(sc.nextLine());

    // **** loop reading the strings ****
    for (int i = 0; i < q; i++) {

      // **** read the next string ****
      String s = sc.nextLine();

      // **** process the string ****
      int result = sherlockAndAnagrams(s);

      // **** display the result ****
      System.out.println(result);
    }

    // **** close scanner ****
    sc.close();
  }

}