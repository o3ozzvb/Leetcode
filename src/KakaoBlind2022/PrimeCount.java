package KakaoBlind2022;

public class PrimeCount {

    public static void main(String[] args) {
        System.out.println(solution(1000000, 9));
    }

    public static int solution(int n, int k) {
        int answer = 0;

        String number = Integer.toString(n, k); //n을 k진수로 변환
        System.out.println("nubmer = " + number);
        String[] split = number.split("0+"); //0이 한번이상 반복되는 문자열로 자르기..

        for (String s : split) {
            System.out.println("s = " + s);
            long x = Long.parseLong(s);
            if (isPrime(x)) {
                answer++;
            }
        }
        return answer;
    }

    public static boolean isPrime(long n) {

        if (n == 1) return false;
        for (long i = 2; i <= (long)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
