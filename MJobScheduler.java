package com.example.pranshooverma.jobscheduler_with_google_fused_location;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

/**
 * Created by PRANSHOO VERMA on 27/09/2017.
 */

public class MJobScheduler extends JobService {
    MJobExecuter a;
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
         a=new MJobExecuter(getApplicationContext());
        a.execute();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
      a=new MJobExecuter(getApplicationContext());
        a.cancel(true);
        return false;
    }
}
