package gson;

import java.util.Date;

public class Data {
    private String aString; // a String 1
    private int aInt; // 1
    private Date aDate; // Feb 26, 2014 7:35:23 PM

    public Data(String aString, int aInt, Date aDate) {
        super();
        this.aString = aString;
        this.aInt = aInt;
        this.aDate = aDate;
    }


    @Override
    public String toString() {
        return "gson.Data [aString=" + aString + ", aInt=" + aInt + ", aDate=" + aDate + "]";
    }

}
