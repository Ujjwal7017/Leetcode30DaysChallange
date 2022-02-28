// Time Complexity = O(n)
// Space Complexity = O(n)

class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        List<String> ranges = new ArrayList<>();
        int start = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                ranges.add(encodeRange(start, nums[i]));

                if (i != nums.length - 1) start = nums[i + 1];
            }
        }

        return ranges;
    }

    private String encodeRange(int start, int end) {
        StringBuilder range = new StringBuilder();

        if (start == end) {
            range.append(start);
        } else {
            range.append(start)
                .append("->")
                .append(end);
        }

        return range.toString();
    }
}


// Another Approach -----......

class Solution {
        public List<String> summaryRanges(int[] nums) {
            int n = nums.length;
            List<String> list = new ArrayList();
            for (int i = 0; i < n; i++) {
                int start = nums[i];
                while (i + 1 < n && nums[i + 1] - nums[i] == 1) // check if we have more element nums[i + 1] = nums[i] + 1
                    i++;
                if (start != nums[i])  // more than one element for range add range "->" separated
                    list.add("" + start + "->" + nums[i]); // single element in range just add it
                else
                    list.add("" + start);
            }

            return list;
        }
    }
