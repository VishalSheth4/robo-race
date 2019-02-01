package vishal.roborace;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class RoboParticipantss extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robo_participantss);
//
//        Button adddata = (Button)findViewById(R.id.add_data);

        final DatabaseHandler db = new DatabaseHandler(this);
//-----------------------------Time--------------------------
        TextView tv = ((TextView)findViewById(R.id.textView4));
        tv.setText(getIntent().getStringExtra("total_time"));
        final String s = tv.getText().toString();
//-----------------------NAME------------------------------------
//        EditText name1 = (EditText)findViewById(R.id.name);
//        final String roboparticipants = name1.getText().toString();



//        adddata.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("Insert: ", "Inserting ..");
//                db.addContact(new RoboParticipants(roboparticipants,s));
//
//            }
//        });

        // Inserting robopart......

//
//        db.addContact(new RoboParticipants("Ravi", "9100000000"));
//        db.addContact(new RoboParticipants("Srinivas", "9199999999"));
//        db.addContact(new RoboParticipants("Tommy", "9522222222"));
//        db.addContact(new RoboParticipants("Karthik", "9533333333"));

        // Reading all contacts
//        Log.d("Reading: ", "Reading all contacts..");
//        List<RoboParticipants> contacts = db.getAllContacts();
//
//        for (RoboParticipants cn : contacts) {
//            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
//            // Writing Contacts to log
//            Log.d("Name: ", log);
//        }
    }
}