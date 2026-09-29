package Lab_1;
import java.util.Scanner;

public class TeamBoard {
    public static final int MAX_ARRAY_SIZE = 10;
    public static String []posts = new String[MAX_ARRAY_SIZE];
    public static Scanner inScanner = new Scanner(System.in);
    public static int post_items = 0;
    
    // new_post(): creates a new string in the array "posts"
    // Input: name(string), post(string)
    // will output an error when you have the MAX_ARRAY_SIZE 
    public static void new_post(){
        if(post_items == MAX_ARRAY_SIZE){
            System.err.println("Notice Board is full. Cannot add new notice.");
        } else {
            System.out.println("please enter your name");
            String name = inScanner.nextLine();
            System.out.println("please enter your notice");
            String notice = inScanner.nextLine();
            posts[post_items] = ( name.trim() + " posts: " + notice);
            post_items++;
        }
        return;
    }

    // print_posts(): Will print all of the posts in the array "posts".
    // Prints out an error if there is no items in the array
    public static void print_posts(){
        if (post_items <= 0){
            System.err.println("Error: no items in the array");
            return;
        }

        for(int i = 0; i<post_items; i++){
            System.out.println(posts[i]);
        }
        return;
    }

    // posts_reverse(): will print the all of the posts in the array "posts" in reverse.
    // Prints out an error if there is no items in the array.
    public static void print_posts_reverse(){
         if (post_items <= 0){
            System.err.println("Error: no items in the array");
            return;
        }

        for(int i = post_items - 1; i > -1; i--){
            System.out.println(posts[i]);
        }
        return;
    }

    // total_posts(): will print out the total number of posts
    public static void total_posts(){
        System.out.println("Total number of posts: " + post_items);
        return;
    }

    // print_captain_posts(): will search the array "posts" for the target name and prints out the posts starting with the target name
    // Input: name(string)
    // Will output an error if name is not found
    public static void print_captain_posts(){
        System.out.println("Please enter a name to search: ");
        String name = inScanner.nextLine();
        boolean found = false;
        
        for(int i = 0; i < post_items; i++){
            if (posts[i].toLowerCase().startsWith(name.toLowerCase())){
                System.out.println(posts[i]);
                found = true;
            }
        }

        if (found == false){
            System.err.println("Could not find target name.");
        }

        return;
    }

    // count_numerical_appearance(): Will count the amount of times a digit is in all the posts
    // Finds where "posts:" is located in the post and starts from there. This is to ensure it only checks the notice data.
    // Output: total_count(int)
    public static int count_numerical_appearance(){
        int total_count = 0;
        String startingWord = "posts:";

        for(int i = 0; i < post_items; i++){
            int start = posts[i].indexOf(startingWord);
            for( int j = start; j < posts[i].length(); j++){
                int post_char = posts[i].charAt(j);
                if (post_char >= '0' && post_char <= '9'){
                    total_count++;
                }
            }
        }
        

        return total_count;
    }

    // print_word_target_caseSensitive(): Will print out any posts that contain the target word using case sensitive search.
    // Will output an error if target word is not found.
    public static void print_word_target_caseSensitive(){
        System.out.println("Please enter a word to search: ");
        String target = inScanner.nextLine();
        boolean found = false;
        
        for(int i = 0; i < post_items; i++){
            if (posts[i].contains(target)){
                System.out.println(posts[i]);
                found = true;
            }
        }
        
        if (found == false){
            System.err.println("Could not find target word.");
        }

        return;
    }
    
    // print_word_target_caseInsensitive(): Will print out any posts that contain the target word using case insensitive search.
    // Will output an error if target word is not found.
    public static void print_word_target_caseInsensitive(){
        System.out.println("Please enter a word to search: ");
        String target = inScanner.nextLine();
        boolean found = false;

        for(int i = 0; i < post_items; i++){
            if (posts[i].toLowerCase().contains(target.toLowerCase())){
                System.out.println(posts[i]);
                found = true;
            }
        }

        if (found == false){
            System.err.println("Could not find target word2.");
        }

        return;
    }
   


    //Main Function: Prints out a menu that repeatedly shows up until exited. Navigation system for the program.
    public static void main(String[] args){
        boolean active = true;
        while(active == true){
            System.out.println("============================================================================\n" +
                "(1) Post new notice\n" + 
                "(2) Print all notices\n" +
                "(3) Print all notices in reverse order\n" +
                "(4) Print number of notices posted so far\n" +
                "(5) Print all notices from a captain\n" +
                "(6) Print the number of digits across all notices\n" +
                "(7) Perform a search of notices containing a given word (case sensitive)\n" +
                "(8) Perform a search of notices containing a given word (case insensitive)\n" +
                "(9) End Program\n" +
                "============================================================================\n" +
                "Input: "
            );
            String choice = inScanner.nextLine();

            switch (choice) {
                case "1":
                    new_post();
                    break;
                case "2":
                    print_posts();
                    break;
                case "3":
                    print_posts_reverse();
                    break;
                case "4":
                    total_posts();
                    break;
                case "5":
                    print_captain_posts();
                    break;
                case "6":
                    System.out.println("Total number of digits: " + count_numerical_appearance());
                    break;
                case "7":
                    print_word_target_caseSensitive();
                    break;
                case "8":
                    print_word_target_caseInsensitive();
                    break;
                case "9":
                    active = false;
                    break;

                default:
                    System.err.println("Not a valid input, please try again.");
                    break;
            }
        }
    }
}

