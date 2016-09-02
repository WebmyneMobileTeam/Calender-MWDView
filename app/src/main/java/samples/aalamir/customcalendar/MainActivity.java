package samples.aalamir.customcalendar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import samples.aalamir.customcalendar.widget.CalendarView;


public class MainActivity extends ActionBarActivity {

    CalendarView cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashSet<Date> events = new HashSet<>();

        // add events
        Calendar calendar = Calendar.getInstance();
        events.add(calendar.getTime());
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        events.add(calendar.getTime());

        cv = ((CalendarView) findViewById(R.id.calendar_view));
        cv.setMode(CalendarView.MODE.MONTH);
        cv.updateCalendar(events);

        // assign event handler
        cv.setEventHandler(new CalendarView.EventHandler() {
            @Override
            public void onDayLongPress(Date date) {

                DateFormat df = SimpleDateFormat.getDateInstance();
                Toast.makeText(MainActivity.this, df.format(date), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void dayClicked(View view) {
        cv.setMode(CalendarView.MODE.DAY);
    }

    public void weekClicked(View view) {
        cv.setMode(CalendarView.MODE.WEEK);
    }

    public void monthClicked(View view) {
        cv.setMode(CalendarView.MODE.MONTH);
    }
}
