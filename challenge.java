import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
/**
 * The Main class implements an application that reads lines from the standard
 * input
 * and prints them to the standard output.
 */
public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    ArrayList<Integer> numsUni = new ArrayList<Integer>();
    ArrayList<Integer> numsOrgList = new ArrayList<Integer>();
    while ((line = in.readLine()) != null) {
      String[] nums = line.split(" ");
      Arrays.sort(nums);
      int size = nums.length;
      int[] numsInt = new int[size];
      for (int i = 0; i < size; i++) {
        numsInt[i] = Integer.parseInt(nums[i]);
      }
      for (int j = 0; j < numsInt.length; j++) {
        int count1 = 0;
        for (int i = 0; i < numsInt.length; i++) {
          if (numsInt[i] == numsInt[j]) {
            count1++;
          }
        }
        if (count1 == 1) {
          numsUni.add(numsInt[j]);
        }
      }
      String[] numsIn = line.split(" ");
      for (int i = 0; i < size; i++) {
        numsOrgList.add(Integer.parseInt(numsIn[i]));
      }
      if (numsUni.isEmpty()) {
        System.out.println(0);
      } else {
        System.out.println(numsOrgList.indexOf(numsUni.get(0)) + 1);
      }
    }
  }
}