//import java.util.Scanner;

public class Football {
//        // 유저가 입력하는 등번호를 받는 메서드
//        public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//            System.out.print("등번호를 입력하세요: ");
//            int shirtNum = in.nextInt();
//
//            System.out.println(onField(shirtNum));
//        };

    public static String onField(int shirtNum) {
        String position = switch (shirtNum) {
            case 1 -> position = "goalie"; // switch-case 를 줄여서 작성
                /* 해당 코드는 다음과 같음:
                case 1:
                    position = "goalie";
                    break; // break 문을 사용하지 않으면 조건을 만족하는 case 문 이후의 코드가 모두 작동함
                * */
            case 2 -> position = "left back";
            case 3, 4 -> position = "center back";
            case 5 -> position = "right back";
            case 6, 7, 8 -> position = "midfielder";
                /*
                해당코드는 다음과 같음:
                case 6:
                case 7:
                case 8:
                    position = "midfielder";
                    break;
                 */
            case 9 -> position = "left wing";
            case 10 -> position = "striker";
            case 11 -> position = "right wing";
            default -> "unknown"; //사용자가 등번호 1~11이외의 값을 입력할 경우엔 unknown 을 출력하는 문제 조건
        };
        return position;
    }

    public static void main(String[] args) {
        System.out.println(onField(10));
        System.out.println(onField(13));
    }
}
