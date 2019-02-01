package vishal.roborace;

/**
 * Created by Vishal on 3/3/2017.
 */

public class RoboParticipants {


    //private variables
    int _id;
    String _name;
    String _total_time;

    // Empty constructor
    public RoboParticipants(){

    }
    // constructor
    public RoboParticipants(int id, String name, String _total_time){
        this._id = id;
        this._name = name;
        this._total_time = _total_time;
    }

    // constructor
    public RoboParticipants(String name, String _total_time){
        this._name = name;
        this._total_time = _total_time;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getPhoneNumber(){
        return this._total_time;
    }

    // setting phone number
    public void setPhoneNumber(String phone_number){
        this._total_time = phone_number;
    }
}