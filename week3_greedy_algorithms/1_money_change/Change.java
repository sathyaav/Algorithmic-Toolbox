import java.util.Scanner;

public class Change {
	private static int getChange(int m) {
        int coins=0;
        while(m>0){
          if(m-10 >= 0){
            m = m-10;
            coins++;
          }else if(m-5 >= 0){
            m = m-5;
            coins++;
          }else if(m-1 >=0){
            m = m-1;
            coins++;
          }

        
        }
        

        return coins;
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

