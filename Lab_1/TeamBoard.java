package Lab_1;
import java.util.Scanner;

public class TeamBoard {
    public static int MAX_ARRAY_SIZE = 10;
    public static String []posts = new String[MAX_ARRAY_SIZE];
    public static Scanner inScanner = new Scanner(System.in);
    public static int post_items = 0;
    
    public static void new_post(){
        if(post_items == MAX_ARRAY_SIZE){
            System.out.println("Notice Board is full. Cannot add new notice.");
        } else {
            System.out.println("please enter your name");
            String name = inScanner.nextLine();
            System.out.println("please enter your notice");
            String notice = inScanner.nextLine();
            posts[post_items] = ( name + " post: " + notice);
        }
        return;
    }

    public static void main(String[] args){
        
    }
}

