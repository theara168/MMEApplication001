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
import com.mobiledev.mmeapplication.activity.NewsDetailActivity;
import com.mobiledev.mmeapplication.adapter.CustomNewsAdapter;
import com.mobiledev.mmeapplication.configuration.AppConfig;
import com.mobiledev.mmeapplication.imageCatch.AppController;
import com.mobiledev.mmeapplication.model.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();


    public static final String TITLES_NEWS = "titles_news";
    public static final String IMAGE_URL = "image_news";
    public static final String DESCRIPTION_NEWS = "description_news";
    //    private static final String url = "http://10.0.3.2:8080/MME/Mobile/jsonRoom.php";
    private ProgressDialog pDialog;
    private List<News> newsList = new ArrayList<News>();
    private ListView lvNews;
    private CustomNewsAdapter adapter;
    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvNews = (ListView) getActivity().findViewById(R.id.list_news_main);
        adapter = new CustomNewsAdapter(getActivity(), newsList);
        lvNews.setAdapter(adapter);

        pDialog = new ProgressDialog(getActivity());
        // Showing progress dialog before making http request
        pDialog.setMessage("សូមមេត្តារងចាំបន្តិច");
        pDialog.show();

        JsonArrayRequest movieReq = new JsonArrayRequest(AppConfig.NEWS_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        Toast.makeText(getActivity(),response.toString(),Toast.LENGTH_SHORT).show();
                        hidePDialog();

                        //Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject jsonObject = response.getJSONObject(i);
                                News news = new News();
                                news.setNews_titles(jsonObject.getString("news_image"));
                                news.setNews_image(jsonObject.getString("news_image"));
                                news.setNews_description(jsonObject.getString("news_description"));
                                newsList.add(news);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();

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
        lvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                //add data to the Intent object
                intent.putExtra(TITLES_NEWS, newsList.get(position).getNews_titles());
                intent.putExtra(IMAGE_URL, newsList.get(position).getNews_image());
                intent.putExtra(DESCRIPTION_NEWS, newsList.get(position).getNews_description());
                //start the second activity
                startActivity(intent);
                Toast.makeText(getActivity(), newsList.get(position).getNews_titles() + "", Toast.LENGTH_SHORT).show();
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
