package Lab_2;

public class Captain {
    private String fullName;
    private String handle;

    public Captain(String nameString, String handleString){
        fullName = nameString;
        handle = handleString;
    }

    public String getFullName(){
        return  fullName;
    }

    public String getHandle(){
        return handle;
    }
}
