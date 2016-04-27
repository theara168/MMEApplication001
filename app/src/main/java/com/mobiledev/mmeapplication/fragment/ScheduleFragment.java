package com.mobiledev.mmeapplication.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.mobiledev.mmeapplication.R;
import com.mobiledev.mmeapplication.activity.MainActivity;
import com.mobiledev.mmeapplication.activity.ScheduleDetailActivity;
import com.mobiledev.mmeapplication.adapter.CustomNewsAdapter;
import com.mobiledev.mmeapplication.adapter.CustomScheduleAdapter;
import com.mobiledev.mmeapplication.configuration.AppConfig;
import com.mobiledev.mmeapplication.imageCatch.AppController;
import com.mobiledev.mmeapplication.model.News;
import com.mobiledev.mmeapplication.model.Schedule;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {


    private static final String TAG = MainActivity.class.getSimpleName();;
    private ProgressDialog pDialog;
    private List<Schedule> scheduleList = new ArrayList<Schedule>();
    private ListView lvSchedule;
    private CustomScheduleAdapter adapter;
    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meeting_room, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvSchedule = (ListView) getActivity().findViewById(R.id.lvSchedule);
        adapter = new CustomScheduleAdapter(getActivity(), scheduleList);

        lvSchedule.setAdapter(adapter);
        pDialog = new ProgressDialog(getActivity());
        // Showing progress dialog before making http request
        pDialog.setMessage("សូមមេត្តារងចាំបន្តិច");
        pDialog.show();

//Creating volley request obj
        JsonArrayRequest movieReq = new JsonArrayRequest(AppConfig.URL_ROOM,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        Toast.makeText(getActivity(), response.toString() + "", Toast.LENGTH_SHORT).show();
                        hidePDialog();

                        //Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject jsonObject = response.getJSONObject(i);
                                Schedule sch = new Schedule();
                                sch.setSchedule_titles(jsonObject.getString("sch_titles"));
                                sch.setSchedule_description(jsonObject.getString("sch_description"));
                                sch.setSchedule_image(jsonObject.getString("sch_image"));
                                sch.setSchedule_floor(jsonObject.getString("sch_floor"));
                                sch.setSchedule_time(jsonObject.getString("sch_time"));

                                scheduleList.add(sch);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                        //
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();
            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(movieReq);

        //Event
        lvSchedule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ScheduleDetailActivity.class);
                //add data to the Intent object
                intent.putExtra("", scheduleList.get(position).getSchedule_titles());
                intent.putExtra("", scheduleList.get(position).getSchedule_image());
                intent.putExtra("", scheduleList.get(position).getSchedule_description());

                //start the second activity
                startActivity(intent);
                Toast.makeText(getActivity(), scheduleList.get(position).getSchedule_titles() + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_schedule,menu);
    }
}
