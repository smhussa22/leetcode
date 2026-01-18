package src;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        int needed;                                     // number that we need w/ our current value to add up to target.
        Map<Integer, Integer> seen = new HashMap<>();   // tracks numbers that we have seen before.

        for (int i = 0; i < nums.length; ++i) {

            needed = target - nums[i];                  // number that we need to add w/ current number to = target
            if (seen.containsKey(needed)) {             // if needed number is in hashmap..

                return new int[]{seen.get(needed), i};  // ..retrieve its mapped-to index from map and our loop index..

            }
            else {                                      // ..if not, just put our current value and map it to its index

                seen.put(nums[i], i);

            }

        }

        return new int[]{};                             // return empty int array if we don't find a solution
        // could also just throw new RuntimeException("N/A");

    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));

    }

}
