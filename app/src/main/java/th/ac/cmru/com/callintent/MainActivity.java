package th.ac.cmru.com.callintent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtPhoneNumber = (EditText) findViewById(R.id.phone_number);
    Button btnMakeCall = (Button) findViewById(R.id.make_call_button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPhoneNumber = (EditText) findViewById(R.id.phone_number);
        btnMakeCall = (Button) findViewById(R.id.make_call_button);

        btnMakeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TelephonyManager telephony = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                if(telephony.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE){
                    String msg = "Sorry, This device can't make phone calls!.";
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    return;
                }

                String uri = "tel:"+txtPhoneNumber.getText();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:12345"));
                startActivity(intent);
            }
        });
    }
}
