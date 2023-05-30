import java.util.*;

class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> roman = initRomanMap();
        StringBuilder answer = new StringBuilder();

        for (int x : roman.keySet()) {
            while (num >= x) {
                answer.append(roman.get(x));
                num -= x;
            }
        }
        return answer.toString();
    }
    
    public Map<Integer, String> initRomanMap() {
        Comparator<Integer> comparator = Comparator.reverseOrder();
        Map<Integer, String> roman = new TreeMap<>(comparator);

        roman.put(1, "I");
        roman.put(4, "IV");
        roman.put(5, "V");
        roman.put(9, "IX");
        roman.put(10, "X");
        roman.put(40, "XL");
        roman.put(50, "L");
        roman.put(90, "XC");
        roman.put(100, "C");
        roman.put(400, "CD");
        roman.put(500, "D");
        roman.put(900, "CM");
        roman.put(1000, "M");

        return roman;
    }
}