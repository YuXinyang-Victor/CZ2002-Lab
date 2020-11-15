import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/*We can add printTimeTable function as an extra feature */


class Timetable{
    private Map<String, List<Timeslot>> schedule = new HashMap <String, List<Timeslot>>();

    public Timetable(){
        initSchedule();
    }

    public void initSchedule(){

        for(DayOfWeek dw : DayOfWeek.values()){
            List<Timeslot> entries = new ArrayList <Timeslot> ();
            this.schedule.put(dw.toString().toLowerCase(),entries);
            }


    }
//-------------time table clash------------------------------------
    public boolean checkClash(Timetable t1){
        boolean flag = false;

        for (Map.Entry<String, List<Timeslot>> entry : (t1.schedule).entrySet()) {
            String t1key = entry.getKey();
            List<Timeslot> t1slots = entry.getValue();
            List<Timeslot> slots = this.schedule.get(t1key);
            for (Timeslot t1slot: t1slots){
                for (Timeslot tslot: slots){
                    if (tslot.checkClash(t1slot)){
                        System.out.println(t1key+": "+tslot.strTimeslot()+" clashes with "+t1slot.strTimeslot());
                        flag = true;
                    }
                }
            }
        }
        return flag;

    }
//------------updating student timetable (only for student class)--------------------------
    public void addTimetable(Timetable t1){
        for (Map.Entry<String, List<Timeslot>> entry : (t1.schedule).entrySet()) {
            String t1key = entry.getKey();
            List<Timeslot> t1slots = entry.getValue();
            for (Timeslot t1slot: t1slots){
                (this.schedule.get(t1key)).add(t1slot);
            }
        }
    }

    public void delTimetable(Timetable t1){
        for (Map.Entry<String, List<Timeslot>> entry : (t1.schedule).entrySet()) {
            String t1key = entry.getKey();
            List<Timeslot> t1slots = entry.getValue();
            List<Timeslot> slots = this.schedule.get(t1key);
            for (Timeslot t1slot: t1slots){
                for (int i = 0; i<slots.size();i++){
                    if (t1slot.equals(slots.get(i)))
                        this.schedule.get(t1key).remove(i);
                }
            }
        }
    }


//-------------adding slots to timetable-----------------------------
    public void addSlots(String[] slots){
        for (String slot: slots){
            this.addSlot(slot);
        }
    }

    private void addSlot(String slot){


        // format : "Mon;8:30-10:30;SEM"
        String[] arr = slot.split(";");
        String day = arr[0];
        String time = arr[1];
        Timeslot slt = new Timeslot(time);
        //System.out.println(day.toLowerCase());
        (this.schedule.get(day.toLowerCase())).add(slt);


    }

//-------------print Timetable----------------------------------------
    public void printTimeTable(){
        for (String day : this.schedule.keySet()) {
            System.out.print(day+": ");
            for (Timeslot tt: this.schedule.get(day)){
                System.out.print("["+tt.strTimeslot()+"] ");
            }
            System.out.println();
          }
    }


}