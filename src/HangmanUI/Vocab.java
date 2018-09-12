package HangmanUI;

import java.util.ArrayList;
import java.util.Random;

public class Vocab {

    public int target;
    public ArrayList<String> data;

    public Vocab() {
        data = new ArrayList<>();

        data.add("comsci");
        data.add("economic");
        data.add("business");
        data.add("engineer");
        data.add("social");

    }

    public String random() {
        Random ran = new Random();
        target = ran.nextInt(data.size());
        return data.get(target).toString();
    }
    public ArrayList getData() {
        return data;
    }
}
