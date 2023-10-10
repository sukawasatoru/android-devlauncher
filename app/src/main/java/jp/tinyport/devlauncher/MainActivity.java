package jp.tinyport.devlauncher;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final var intent = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
                .addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK |
                        Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
                );

        final var resolveInfo = getPackageManager()
                .resolveActivity(intent, PackageManager.MATCH_SYSTEM_ONLY);

        if (resolveInfo == null) {
            Toast.makeText(this, "Developer settings don't exist", Toast.LENGTH_LONG)
                    .show();
        } else {
            startActivity(intent);
        }

        finishAndRemoveTask();
    }
}
