package vishal.roborace;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView ,penalty_txt,touchtxt,skiptxt;
    Button start, reset, stop ,save,touchbtn,skipbtn;
    int penaltystrike=0,touchstrike=0,skipstrike=0;
    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;
    String sourcetimer;
    int TimeBuff1=0;
    Handler handler;

    int Seconds, Minutes, MilliSeconds ;

//    ListView listView ;
//
//    String[] ListElements = new String[] {  };
//    List<String> ListElementsArrayList ;
//    ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        penalty_txt=(TextView)findViewById(R.id.penalty_txt);
        textView = (TextView)findViewById(R.id.textView);

        skipbtn= (Button)findViewById(R.id.skipbtn);
        skiptxt=(TextView)findViewById(R.id.skiptxt);
        touchtxt = (TextView)findViewById(R.id.touchtxt);
        save = (Button)findViewById(R.id.save);
        start = (Button)findViewById(R.id.button);
        touchbtn = (Button)findViewById(R.id.touchbtn);
        reset = (Button)findViewById(R.id.button3);
        stop = (Button)findViewById(R.id.stop) ;
//        listView = (ListView)findViewById(R.id.listview1);

        handler = new Handler() ;
        touchbtn.setEnabled(false);
        skipbtn.setEnabled(false);
        save.setEnabled(false);
        stop.setEnabled(false);
//        ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));

//        adapter = new ArrayAdapter<String>(MainActivity.this,
//                android.R.layout.simple_list_item_1,
//                ListElementsArrayList
//        );
//
//        listView.setAdapter(adapter);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);
//                stop.setEnabled(false);
                touchbtn.setEnabled(true);
                skipbtn.setEnabled(true);
                reset.setEnabled(false);
                stop.setEnabled(true);

                Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_SHORT).show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myintent=new Intent(MainActivity.this, RoboParticipantss.class).putExtra("total_time", sourcetimer);
                startActivity(myintent);
            }
        });
        touchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                touchstrike = touchstrike + 1;
                Toast.makeText(getApplicationContext(),"Touch :"+touchstrike,Toast.LENGTH_SHORT).show();
                Log.d("Milliseconds", String.valueOf(MillisecondTime));
//                if(touchstrike>=4){
//                    skipstrike=skipstrike+1;
//                    touchstrike=0;
//                    touchtxt.setText("T : "+touchstrike);
//                    skiptxt.setText("S : "+skipstrike);
//                }
//                else
//                {
                    touchtxt.setText("T : "+touchstrike);
//                }
            }
        });

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skipstrike = skipstrike + 1;
                Log.d("Milliseconds", String.valueOf(MillisecondTime));
                if(skipstrike>=5)
                {
                    Toast.makeText(getApplicationContext(),"U R Disqualified !! Skip :"+skipstrike,Toast.LENGTH_LONG).show();


                    /*LOL*/

                    TimeBuff += MillisecondTime + (touchstrike * 10000) + (skipstrike * 60000);
                    Log.d("Total", String.valueOf(TimeBuff));

                    handler.removeCallbacks(runnable);
                    start.setEnabled(false);
                    reset.setEnabled(true);
                    save.setEnabled(true);
                    touchbtn.setEnabled(false);
                    skipbtn.setEnabled(false);
                    Toast.makeText(getApplicationContext(), "Stop", Toast.LENGTH_SHORT).show();
                    MilliSeconds = (int) (((TimeBuff) / 100) % 1000);
                    Seconds = (int) (((TimeBuff) / 1000) % 60);
                    Minutes = (int) ((((TimeBuff) / 1000) / 60) % 60);

                    Log.d("Sec", String.valueOf(Seconds));
                    Log.d("Millesec", String.valueOf(MilliSeconds));
                    Log.d("Min", String.valueOf(Minutes));

                    sourcetimer = String.valueOf(Minutes) + ':' + String.valueOf(Seconds) + ':' + String.valueOf(MilliSeconds);
                    // Toast.makeText(getApplicationContext(), sourcetimer, Toast.LENGTH_SHORT).show();
                    textView.setText("" + Minutes + ":" + Seconds + ":" + MilliSeconds);
                    stop.setEnabled(false);


                    /*END*/

                }
                else {
                    skiptxt.setText("S : " + skipstrike);
                    Toast.makeText(getApplicationContext(), "Skip :" + skipstrike, Toast.LENGTH_SHORT).show();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Millisecinds", String.valueOf(MillisecondTime));
                TimeBuff += MillisecondTime + (touchstrike * 10000) + (skipstrike * 60000);
                Log.d("Total", String.valueOf(TimeBuff));
                handler.removeCallbacks(runnable);
                start.setEnabled(false);
                reset.setEnabled(true);
                save.setEnabled(true);
                touchbtn.setEnabled(false);
                skipbtn.setEnabled(false);
                Toast.makeText(getApplicationContext(), "Stop", Toast.LENGTH_SHORT).show();
                MilliSeconds = (int) (((TimeBuff) / 100) % 1000);
                Seconds = (int) (((TimeBuff) / 1000) % 60);
                Minutes = (int) ((((TimeBuff) / 1000) / 60) % 60);

                Log.d("Sec", String.valueOf(Seconds));
                Log.d("Millesec", String.valueOf(MilliSeconds));
                Log.d("Min", String.valueOf(Minutes));

                sourcetimer = String.valueOf(Minutes) + ':' + String.valueOf(Seconds) + ':' + String.valueOf(MilliSeconds);
                // Toast.makeText(getApplicationContext(), sourcetimer, Toast.LENGTH_SHORT).show();
                textView.setText("" + Minutes + ":" + Seconds + ":" + MilliSeconds);
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MillisecondTime = 0L ;
                StartTime = 0L ;
                TimeBuff = 0L ;
                UpdateTime = 0L ;
                Seconds = 0 ;
                Minutes = 0 ;
                MilliSeconds = 0 ;
//                penalty_txt.setText("0");
                textView.setText("00:00:00");
                skiptxt.setText("S : 0");
                touchtxt.setText("T : 0");
                penaltystrike=0;
                skipstrike=0;
                touchstrike=0;
                touchbtn.setEnabled(false);
                skipbtn.setEnabled(false);
                start.setEnabled(true);
                stop.setEnabled(false);
                save.setEnabled(false);

//                ListElementsArrayList.clear();
//                adapter.notifyDataSetChanged();
            }
        });

//        lap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                ListElementsArrayList.add(textView.getText().toString());
//
//                adapter.notifyDataSetChanged();
//
//            }
//        });

    }

    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;

            UpdateTime = TimeBuff + MillisecondTime;

            Seconds = (int) (UpdateTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (UpdateTime % 1000);

            textView.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));

            handler.postDelayed(this, 0);
        }

    };

}