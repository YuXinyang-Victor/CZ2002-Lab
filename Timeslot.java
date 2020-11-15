//import java.sql.Time;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Timeslot {
    private Date opening;
    private Date closing;
    public Timeslot(String timeslot){
        setTimeSlot(timeslot);
    }

    public Date getOpening (){
        return opening;
    }

    public Date getClosing(){
        return closing;
    }

    private void setTimeSlot(String timeslot){
        // "8:30-10:30" Time format
        String[] times = timeslot.split("-");
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
        // try catch block for ParseException


        try{
        this.opening = parser.parse(times[0]);
        this.closing = parser.parse(times[1]);
        }
        catch (ParseException e){
            System.out.println(e.getMessage());
        }


    }

    public boolean checkClash(Timeslot t){
        if (this.opening.compareTo(t.closing)<0 && this.closing.compareTo(t.opening)>0)
            return true;
        else
            return false;

    }

    public boolean isEqual(Timeslot t){
        if (this.opening.compareTo(t.opening)==0 && this.closing.compareTo(t.closing)==0)
            return true;
        else
            return false;
    }

    public String strTimeslot(){
        return opening.getHours()+":"+opening.getMinutes()+"-"+closing.getHours()+":"+closing.getMinutes();
    }
}
