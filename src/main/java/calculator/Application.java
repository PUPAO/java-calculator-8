package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static StringBuilder separatorList = new StringBuilder(",|:|//|\\\\n");

    public static void main(String[] args) {
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");
        String inputStr = Console.readLine();

        // 구분자를 등록
        int lastLocation = -1;
        while (true) {
            int startLocation = inputStr.indexOf("//", lastLocation);
            int endLocation = inputStr.indexOf("\\n", startLocation);
            if (startLocation == -1) {
                break;
            }

            String separator = inputStr.substring(startLocation + 2, endLocation);

            if (".$|()[{^?*+\\".contains(separator)) {
                separator = "\\%s".formatted(separator); // 원래 코드: "\\"+dividedWord;
            }

            separatorList.append("|").append(separator);
            lastLocation = endLocation;
        }

        // 숫자와 구분자로 계산기 실행
        String[] elementList = inputStr.split(String.valueOf(separatorList));
        int sum = 0;
        for (String element : elementList) {
            if (element.isEmpty()) {
                continue;
            }

            int number;
            // 구분자가 아닌 문자 여부 판별
            try {
                number = Integer.parseInt(element);
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
            // 숫자 사이에 0 혹은 음수 판별
            if (number <= 0) {
                throw new IllegalArgumentException();
            }
            sum += number;
        }

        System.out.println("결과 : " + sum);
        Console.close();
    }
}