package Lab_2;

public class Notice {
    private String title;
    private String body;
    private String captainHandle;

    public Notice(String titleString, String bodyString, String captainHandleString){
        title = titleString;
        body = bodyString;
        captainHandle = captainHandleString;
    }

    public String getTitle(){
        return title;
    }

    public String getBody(){
        return body;
    }

    public  String getCaptainHandle(){
        return captainHandle;
    }
}
