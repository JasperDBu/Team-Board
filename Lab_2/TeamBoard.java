package Lab_2;
import java.util.ArrayList;
import java.util.Scanner;

/*
Name: Jasper Bungay
Student ID: 1384647
Run Command:
java Lab_2.TeamBoard
*/

public class TeamBoard {
    public static ArrayList<Captain> Captains = new ArrayList<>();
    public static ArrayList<Notice> Notices = new ArrayList<>();

    public static Scanner inScanner = new Scanner(System.in);
    
    // 
    public static void new_captain(){
        
        System.out.println("please enter your full name");
        String fullName = inScanner.nextLine().trim();
        if (fullName.isEmpty()){
            System.err.println("Invalid Name.");
            return;
        }
        System.out.println("please enter a handle (Leave blank default creation)");
        String handle = inScanner.nextLine().trim();

        if (handle.isEmpty()){
            String Words[] = fullName.split("[ ]+");
            handle = Words[0].toLowerCase();
        } else {
            String Words[] = handle.split("[ ]+");
            if (Words.length > 1){
                System.err.println("Handle must be one word");
            }
        }

        for( Captain cap : Captains){
            if (cap.getHandle().equalsIgnoreCase(handle)){
                System.err.println("Error: Handle already exists\n");
                return;
            }
        }

        Captains.add(new Captain(fullName, handle));
        System.out.println("Captain " + fullName + " @" + handle + " created\n");
    }

    public static void new_notice(){
        System.out.println("Please enter your handle:");
        String handle = inScanner.nextLine().trim();
        boolean found = false;
        for (Captain cap : Captains){
            if(cap.getHandle().equalsIgnoreCase(handle)){
                found = true;
                break;
            }
        }

        if (found){
            System.out.println("Captain Found.\nPlease enter the notice title: ");
            String title = inScanner.nextLine().trim();
            System.out.println("Please enter the notice body:");
            String body = inScanner.nextLine().trim();

            Notices.add(new Notice( title, body, handle));
        
        } else {
            System.err.println("Captain not registered. Permission denied.\n");
            return;
        }
    }

    public static Boolean print_notice(Notice notice){
        String captainName = "";

        for (Captain cap: Captains){
            if(cap.getHandle().equalsIgnoreCase(notice.getCaptainHandle())){
                captainName = cap.getFullName();
                break;
            }
        }

        if(captainName.isEmpty()){
            return false;
        }

        System.out.println("Posted By: " + captainName + " @" + notice.getCaptainHandle());
        System.out.println("Title: " + notice.getTitle());
        System.out.println(notice.getBody() + "\n");
        return true;
    }

    public static void print_all_posts(){
        for(Notice notice: Notices){
            if(!print_notice(notice)){
                System.err.println("Cannot find name of Captain for post: " + notice.getTitle());
                return;
            }
        }
    }

    public static void print_captain_posts(){
        System.out.println("Please enter a captain handle to search: ");
        String targetHandle = inScanner.nextLine();
        boolean found = false;
        
        for(Captain cap: Captains){
            if (cap.getHandle().equalsIgnoreCase(targetHandle)){
                System.out.println("All posts by @" + targetHandle + ":\n");
                for(Notice notice: Notices){
                    if (cap.getHandle().equalsIgnoreCase(notice.getCaptainHandle())){
                        System.out.println("Posted By: " + cap.getFullName() + " @" + cap.getHandle());
                        System.out.println("Title: " + notice.getTitle());
                        System.out.println(notice.getBody() + "\n");
                    }
                }
                found = true;
                break;
            }
        }

        if (found == false){
            System.err.println("Could not find target handle.");
        }

        return;
    }

    public static void print_word_target(){
        System.out.println("Please enter a word to search: ");
        String target = inScanner.nextLine().trim();
        boolean found = false;
        
        for(Notice notice: Notices){
            String noticeString = notice.getTitle() + " " + notice.getBody();
            String Words[] = noticeString.split("[ ]+");
            for (String word: Words){
                if ( word.equalsIgnoreCase(target)){
                    print_notice(notice);
                    found = true;
                    break;
                }
            }
        }
        
        if (found == false){
            System.err.println("Error: could not find target word.");
        }

        return;
    }


    //Main Function: Prints out a menu that repeatedly shows up until exited. Navigation system for the program.
    public static void main(String[] args){
        boolean active = true;
        while(active == true){
            System.out.println("============================================================================\n" +
                "(1) Create new captain\n" + 
                "(2) Create new notice\n" +
                "(3) View all notices\n" +
                "(4) View all notices with a given handle\n" +
                "(5) View all notices with a given keyword\n" +
                "(6) End Program\n" +
                "============================================================================\n" +
                "Input: "
            );
            String choice = inScanner.nextLine();

            switch (choice) {
                case "1":
                    new_captain();
                    break;
                case "2":
                    new_notice();
                    break;
                case "3":
                    print_all_posts();;
                    break;
                case "4":
                    print_captain_posts();;
                    break;
                case "5":
                    print_word_target();
                    break;
                case "6":
                    active = false;
                    break;

                default:
                    System.err.println("Not a valid input, please try again.");
                    break;
            }
        }
    }
}

