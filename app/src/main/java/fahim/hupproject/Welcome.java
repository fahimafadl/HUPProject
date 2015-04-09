package fahim.hupproject;

/**
 * Created by Fahim on 3/25/15.
 */
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends Activity {

    // Declare Variable
//    Button logout;
    boolean checked;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.welcome);
        checked = false;

        // Retrieve current user from Parse.com
        ParseUser currentUser = ParseUser.getCurrentUser();

//        // Convert currentUser into String
//        String struser = currentUser.getUsername().toString();
//
//        // Locate TextView in welcome.xml
//        TextView txtuser = (TextView) findViewById(R.id.txtuser);
//
//        // Set the currentUser String into TextView
//        txtuser.setText("You are logged in as " + struser + "\n The medical information contained" +
//                " within this application is meant to aid in the care of Neurosurgical patients." +
//                " It should not take the place of interactions with your physician or nurse. " +
//                "Please call the Neurosurgery department with any concern and call 911 immediately" +
//                " for any life-threatening condition or issue. By agreeing to use this application," +
//                " you offer understanding of these statements.\n\n\n");

//        // Locate Button in welcome.xml
//        logout = (Button) findViewById(R.id.logout);
//
//        // Logout Button Click Listener
//        logout.setOnClickListener(new OnClickListener() {
//
//            public void onClick(View arg0) {
//                // Logout current user
//                ParseUser.logOut();
//                finish();
//            }
//        });
    }

    public void onCheckboxClicked(View view) {
        // Is terms and conditions checkbox checked?
        checked = ((CheckBox) view).isChecked();

    }

    public void onButtonClick(View view){

        if(checked){
            Intent intent = new Intent(this,MainMenuActivity.class);
            startActivity(intent);
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "Please confirm that you have read and understand " +
                    "the terms and conditions.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }

}