class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        Map<String, Integer> map = initRomanMap();

        for (int i = 0; i < s.length(); i++) {
            String substr = "";
            if (i + 1 < s.length()) {
                substr = s.substring(i, i+2);
                if (map.containsKey(substr)) {
                    answer += map.get(substr);
                    i++;
                    continue;
                }
            }

            substr = s.substring(i, i + 1);
            answer += map.get(s.substring(i, i + 1));
        }

        return answer;
    }
    
    private Map<String, Integer> initRomanMap() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        
        return map;
    }
}