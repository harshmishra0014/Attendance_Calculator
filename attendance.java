import java.util.*;

class attendance{
    static Scanner sc=new Scanner(System.in);
    static int total,absent;                    //store total and absent lectures
    static float presentPercent;                //use for present percentage of attendnce multiply it by 100
    public static void main(String[] args) {
        
        //System.out.println("ENTER YOUR NAME:");                             String name=sc.nextLine();
        System.out.println("ENTER TOTAL NUMBER OF CONDUCTED LECTURE:");     total=sc.nextInt();
        System.out.println("ENTER TOTAL NUMBER OF ABSENT LECTURE:");        absent=sc.nextInt();

        presentPercent=(total-absent)/(float)total;         //calculating present percentage

        System.out.println("PRESENT ATTENDANCE PERCENTAGE:"+presentPercent*100+"%");
        System.out.println("WHAT DO YOU WANT TO CALCULATE:");
        System.out.println("PRESS 1 FOR-> Attendance percentage after some days of absence:");
        System.out.println("PRESS 2 FOR->Number of days required to get 90% of attendance:");
        System.out.println("PRESS 3 FOR->Number of days required to reach your desired percentage of attendance:");
        System.out.println("ENTER CHOICE (1 or 2 or 3):");                                int ch=sc.nextInt();
        switch (ch) {
            case 1:
                futureAttendance();
                break;
            case 2:
                daysFor90();
                break;
            case 3:
                desiredPercent();
                break;        
            default:
                System.out.println("INVALID CHOICE");
                break;
        }
    }
    public static void futureAttendance(){
        System.out.println("ENTER NUMBER OF DAYS YOU WANT TO BE ABSENT:");
        int days=sc.nextInt();
        int lectures=days*8;
        total+=lectures;
        absent+=lectures;
        float futurePercent=(total-absent)/(float)total;
        System.out.println("PRESENT ATTENDANCE PERCENTAGE:"+presentPercent*100+"%");
        System.out.println("ATTENDANCE PERCENTAGE AFTER "+days+" OF ABSENCE:"+futurePercent+"%");
    }
    public static void daysFor90() {
        /*
         * (total-absent)/total     =       90/100
         * total    =   10*absent;
         */
        float futureLectures=absent*10;
        futureLectures-=total;
        if(futureLectures>0 &&  futureLectures<8)
            System.out.println("YOU NEED TO GO FOR "+Math.ceil(futureLectures)+" LECTURES ONLY TO ATTAIN 90% ATTENDANCE" );
        else if (futureLectures>8)
            System.out.println("YOU NEED TO GO FOR "+Math.ceil(futureLectures/8)+" DAYS TO GET 90% ATTENDANCE" );
        else
        System.out.println("YOUR ATTENDANCE IS ALREADY ABOVE 90%" );
    }
    public static void desiredPercent() {
        System.out.println("ENTER YOUR DESIRED PERCENTAGE WHICH YOU WANT TO ATTAIN");
        float dp=sc.nextFloat();
        dp/=100.0;
        float futureLectures=absent/(1-dp);
        futureLectures-=total;
        if(futureLectures>0)
            System.out.println("YOU NEED TO GO FOR "+Math.ceil(futureLectures/8)+" DAYS TO ATTAIN "+dp*100+"% ATTENDANCE" );
        else
            System.out.println("YOUR ATTENDANCE IS ALREADY GREATER THAN "+dp*100+"%");


    }
}