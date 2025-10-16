package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");
        String[] basicStr = Console.readLine().split("[,:]");

        int sum = 0;
        for (String s : basicStr) {
            sum += Integer.parseInt(s);
        }

        System.out.println("결과 : " + sum);
    }
}