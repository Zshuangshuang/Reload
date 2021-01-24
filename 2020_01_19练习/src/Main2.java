/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-19 20:57
 */
public class Main {
    public static int getTotalCount(int monthCount){
        int firstMonth = 1;
        int secondMonth = 1;
        int totalRabbits = 1;
        while(monthCount > 2){
            totalRabbits = firstMonth+secondMonth;
            firstMonth = secondMonth;
            secondMonth = totalRabbits;
            monthCount--;
        }
        return totalRabbits;
    }

   /* public static void main(String[] args) {
        System.out.println(getTotalCount(9));
    }*/

}
