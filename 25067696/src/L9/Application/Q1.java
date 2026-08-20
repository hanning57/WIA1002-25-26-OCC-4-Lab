package L9.Application;

/*
 * 1. F(s, t) = F(s-1, t) + F(s, t-1)

        F(4, 10)
        F(12, 8)
        F(7, 12)
*/

public class Q1 {
    public static void main(String[] args) {
        System.out.println("F(4, 10) = " + F(4, 10));
        System.out.println("F(12, 8) = " + F(12, 8));
        System.out.println("F(7, 12) = " + F(7, 12));
    }

    public static long F(int s, int t) {
        if(t == 1) {
            return s;
        } else if(s == 1) {
            return 1;
        } else
            return F(s - 1, t) + F(s, t - 1);
        
    }
}
