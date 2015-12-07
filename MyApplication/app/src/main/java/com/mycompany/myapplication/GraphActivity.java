package com.mycompany.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BaseSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

import java.util.LinkedList;

public class GraphActivity extends AppCompatActivity {
    static final int REQUEST_DATA = 1;
    private final LinkedList memories = new LinkedList();
    private final BaseSeries series = new LineGraphSeries();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_graph);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void addMemory(View v)
    {
        Intent intent = new Intent(this, PlotActivity.class);
        startActivityForResult(intent, REQUEST_DATA);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("Request_Data", String.valueOf(REQUEST_DATA));
        Log.i("Request_Ok", String.valueOf(resultCode));
        if(requestCode == REQUEST_DATA && resultCode == RESULT_OK) {

            Bundle extras = data.getExtras();
            Log.i("Received", String.valueOf(extras.getString(PlotActivity.SCALE)));
/*
            int ageX = Integer.parseInt(extras.getString(PlotActivity.AGE_RANGE));
            int progressY = Integer.parseInt(extras.getString(PlotActivity.SCALE));
            String description = extras.getString(PlotActivity.DESCRIPTION);
            DataPoint dataPoint = new DataPoint(ageX, progressY);

            memories.add(ageX, description);
            //then place on graph via appendDataPoint
            series.appendData(dataPoint,false, memories.size());
*/
/*
            int ageX = anotherIntent.getIntExtra(PlotActivity.AGE_RANGE, 3);
            int progressY = anotherIntent.getIntExtra(PlotActivity.SCALE, 5);
            String description = anotherIntent.getStringExtra(PlotActivity.DESCRIPTION);
            DataPoint data = new DataPoint(ageX, progressY);

            //add to a Datapoint linked list which will use Datapoint as key for a class of info
            memories.add(ageX, description);
            //then place on graph via appendDataPoint
            series.appendData(data,false, memories.size());
*/
        }
    }

}
