package sg.edu.np.mad.madpractical3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

import sg.edu.np.mad.mad_prac2.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        User user = new User("John Doe", "MAD Developer",1,false);

        TextView tvName = findViewById(R.id.textView); 
        TextView tvDescription = findViewById(R.id.textView1); 
        Button btnFollow = findViewById(R.id.button1);

        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("FOLLOW");

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonText = btnFollow.getText().toString();

                if (buttonText.equals("FOLLOW")) {
                    btnFollow.setText("Unfollow");
                    Toast t = Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_LONG);
                    t.show();

                } else {
                    btnFollow.setText("FOLLOW");
                    Toast t = Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_LONG);
                    t.show();

                }
            }
        });
    }
    private String generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000; // Generates a random 6-digit number
        return String.valueOf(randomNumber);
    }
}