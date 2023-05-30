class Solution {
   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int median = (m + n) / 2;
        int idx1 = 0, idx2 = 0;
        List<Integer> list = new ArrayList<>();

        while (idx1 + idx2 <= median) {
            if (idx1 >= m) {
                list.add(nums2[idx2++]);
            }
            else if (idx2 >= n) {
                list.add(nums1[idx1++]);
            }
            else {
                int a = nums1[idx1];
                int b = nums2[idx2];
                if (a < b) {
                    list.add(a);
                    idx1++;
                } else if (a > b) {
                    list.add(b);
                    idx2++;
                } else { // a==b
                    list.add(a);
                    list.add(b);
                    idx1++;
                    idx2++;
                }
            }
//            System.out.println("idx1 = " + idx1);
//            System.out.println("idx2 = " + idx2);
        }

        for (int x : list) {
//            System.out.println("x = " + x);
        }
        if ((m + n) % 2 == 0) {
//            System.out.println("median - 1 : " + list.get(median - 1));
//            System.out.println("median : " + list.get(median));
            return (list.get(median - 1) + list.get(median)) / (double) 2;
        }
        else {
            return list.get(median);
        }
    }
}