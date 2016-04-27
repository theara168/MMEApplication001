package com.mobiledev.mmeapplication.fragment;

/**
 * Created by ouentheara on 4/25/16.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.mobiledev.mmeapplication.R;
import com.mobiledev.mmeapplication.adapter.CustomAdapter;
import com.mobiledev.mmeapplication.model.ItemObject;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoomFragment extends Fragment {

    public MeetingRoomFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meeting_room, container, false);
        GridView gridview = (GridView)view.findViewById(R.id.gridview_meeting_room);

        List<ItemObject> allItems = getAllItemObject();
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), allItems);
        gridview.setAdapter(customAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Position: " + position, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private List<ItemObject> getAllItemObject(){
        List<ItemObject> items = new ArrayList<>();
        items.add(new ItemObject(R.drawable.r1,"ត្បូងទទឹម","សាលប្រជុំុ ថ្មគជ់ (ជាន់ទី៦)"));
        items.add(new ItemObject(R.drawable.r2,"ថ្មគជ់", "សាលប្រជុំុ ថ្មគជ់ (ជាន់ទី៦)"));
        items.add(new ItemObject(R.drawable.r3,"ត្បូងកណ្តៀង", "សាលប្រជុំ ត្បូងកណ្តៀង (ជាន់ទិ៦)"));
        items.add(new ItemObject(R.drawable.r4,"មរកត", "សាលប្រជុំ ត្បូងកណ្តៀង (ជាន់ទិ៦)"));
        items.add(new ItemObject(R.drawable.r5,"សំរឹទ្ធ", "សាលប្រជុំ ត្បូងកណ្តៀង (ជាន់ទិ៦)"));
        return items;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_schedule,menu);
    }
}
