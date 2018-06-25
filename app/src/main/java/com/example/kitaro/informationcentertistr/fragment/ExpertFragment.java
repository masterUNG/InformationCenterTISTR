package com.example.kitaro.informationcentertistr.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kitaro.informationcentertistr.R;
import com.example.kitaro.informationcentertistr.utility.ExpertRecyclerViewAdapter;
import com.example.kitaro.informationcentertistr.utility.GetAllData;
import com.example.kitaro.informationcentertistr.utility.MyConstant;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ExpertFragment extends Fragment {

    int indexAInt;
    MyConstant myConstant;
    String id_ec_String;
    List<String> empNameStringList, emplNameStringList, specialStringList, picNameStringList;

    public static ExpertFragment expertInstance(int indexAInt) {
        ExpertFragment expertFragment = new ExpertFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Index", indexAInt);
        expertFragment.setArguments(bundle);
        return expertFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        GetValue
        getValue();

//        Create RecyclerView
        createRecyclerView();


    }   // Main Method

    private void createRecyclerView() {

        RecyclerView recyclerView = getView().findViewById(R.id.recyclerViewExpert);
        empNameStringList = new ArrayList<>();
        emplNameStringList = new ArrayList<>();
        specialStringList = new ArrayList<>();
        picNameStringList = new ArrayList<>();


        try {

            GetAllData getAllData = new GetAllData(getActivity());
            getAllData.execute(myConstant.getUrlExpert());
            String jsonString = getAllData.get();
            Log.d("22JuneV1", "JSON ==> " + jsonString);

            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i += 1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (id_ec_String.equals(jsonObject.getString("id_ec"))) {

                    empNameStringList.add(jsonObject.getString("EmpName"));
                    emplNameStringList.add(jsonObject.getString("EmpLName"));
                    specialStringList.add(jsonObject.getString("special"));
                    picNameStringList.add(myConstant.getUrlPicture() + jsonObject.getString("picname_per") + ".jpg");

                }   //if
            }   // for
            Log.d("22JuneV2", "Pic ==> " + picNameStringList.toString());

            ExpertRecyclerViewAdapter expertRecyclerViewAdapter = new ExpertRecyclerViewAdapter(getActivity(),
                    empNameStringList, emplNameStringList, specialStringList, picNameStringList);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);

            recyclerView.setAdapter(expertRecyclerViewAdapter);

        } catch (Exception e) {
            Log.d("22JuneV2", "e Class ==> " + e.toString());
        }


    }

    private void getValue() {
        indexAInt = getArguments().getInt("Index", 0);
        myConstant = new MyConstant();
        String[] strings = myConstant.getId_ec_Strings();
        id_ec_String = strings[indexAInt];
        Log.d("22JuneV1", "id_ec ==> " + id_ec_String);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expert, container, false);
        return view;
    }
}
