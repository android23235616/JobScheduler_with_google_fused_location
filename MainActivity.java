package com.example.pranshooverma.jobscheduler_with_google_fused_location;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button start,stop;

    private static final int jobid=101;
    private JobScheduler jobSche;
    private JobInfo jobinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialise();

        ComponentName compenName=new ComponentName(getApplicationContext() ,MJobScheduler.class);

        JobInfo.Builder builder=new JobInfo.Builder(jobid,compenName);

        builder.setPeriodic(8000).setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY).setPersisted(true);

        jobinfo=builder.build();

        jobSche= (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jobSche.schedule(jobinfo);
                Toast.makeText(MainActivity.this, "started", Toast.LENGTH_SHORT).show();

            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jobSche.cancel(jobid);
                Toast.makeText(MainActivity.this, "job cancelled", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initialise() {
        start=(Button)findViewById(R.id.start);
        stop=(Button)findViewById(R.id.stop);
    }
}
