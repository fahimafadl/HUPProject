package fahim.hupproject;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParsePush;
import com.parse.SaveCallback;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by Fahim on 3/25/15.
 *
 *  code for login/signup from http://www.androidbegin.com/tutorial/android-parse-com-simple-login-and-signup-tutorial/
 *  code for push notifications from https://parse.com/tutorials/android-push-notifications
 *  test push notifications from Parse.com
 */
public class GlobalState extends Application{
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "WoBVKObGHpV6KpR47OuFAC2E5GKNot3an0iVv0Ah", "H0Pn5zZJyqL8YH6L9L4cDBr0ZfzaDObXE4KibuP9");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        ParseACL.setDefaultACL(defaultACL, true);

        ParsePush.subscribeInBackground("", new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
                } else {
                    Log.e("com.parse.push", "failed to subscribe for push", e);
                }
            }
        });
    }

}
