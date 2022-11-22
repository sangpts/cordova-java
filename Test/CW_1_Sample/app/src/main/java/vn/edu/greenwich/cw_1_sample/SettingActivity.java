package vn.edu.greenwich.cw_1_sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import vn.edu.greenwich.cw_1_sample.database.BackupEntry;
import vn.edu.greenwich.cw_1_sample.database.ResimaDAO;
import vn.edu.greenwich.cw_1_sample.models.Backup;
import vn.edu.greenwich.cw_1_sample.models.Request;
import vn.edu.greenwich.cw_1_sample.models.Resident;

public class SettingActivity extends AppCompatActivity {
    protected ResimaDAO _db;
    protected Button settingBackup, settingResetDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setTitle(R.string.label_setting);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        _db = new ResimaDAO(this);

        settingBackup = findViewById(R.id.settingBackup);
        settingResetDatabase = findViewById(R.id.settingResetDatabase);

        settingBackup.setOnClickListener(v -> backup());
        settingResetDatabase.setOnClickListener(v -> resetDatabase());
    }

    protected void backup() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Test", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Test", "Error adding document", e);
                    }
                });
    }

    protected void resetDatabase() {
        _db.reset();

        Toast.makeText(this, R.string.label_reset_database, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}