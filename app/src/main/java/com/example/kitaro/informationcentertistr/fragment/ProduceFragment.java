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
import com.example.kitaro.informationcentertistr.utility.GetAllData;
import com.example.kitaro.informationcentertistr.utility.MyConstant;
import com.example.kitaro.informationcentertistr.utility.OnClickItem;
import com.example.kitaro.informationcentertistr.utility.ProductRecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProduceFragment extends Fragment{

    private int indexAnInt;
    private MyConstant myConstant;
    private String id_ec_String;
    private List<String> titleStringList, detailStringList;


    public static ProduceFragment produceInstance(int indexInt) {

        ProduceFragment produceFragment = new ProduceFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Index", indexInt);
        produceFragment.setArguments(bundle);
        return produceFragment;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        GetValue Argument
        getValueArgument();

//        Create RecyclerView
        createRecyclerView();

    }   // Main Method

    private void createRecyclerView() {

        RecyclerView recyclerView = getView().findViewById(R.id.recyclerViewProduce);
        titleStringList = new ArrayList<>();
        detailStringList = new ArrayList<>();

        try {

            GetAllData getAllData = new GetAllData(getActivity());
            getAllData.execute(myConstant.getUrlProduct());

            String jsonString = getAllData.get();
            Log.d("21JuneV1", "JSON ==> " + jsonString);

            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i=0; i<jsonArray.length(); i+=1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (id_ec_String.equals(jsonObject.getString("id_ec"))) {
                    titleStringList.add(jsonObject.getString("name_pro"));
                    detailStringList.add(jsonObject.getString("detail_pro"));
                }   //if

            }   // for

            ProductRecyclerViewAdapter productRecyclerViewAdapter = new ProductRecyclerViewAdapter(getActivity(),
                    titleStringList, detailStringList, new OnClickItem() {
                @Override
                public void onClickItem(View view, int position) {
                    Log.d("22JuneV1", "You Click ==> " + position);
                }
            });

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                    LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);

            recyclerView.setAdapter(productRecyclerViewAdapter);

        } catch (Exception e) {
            Log.d("21JuneV1", "e Class ==> " + e.toString());
        }



//        Test RecycleView
//        for (int i=0; i<10; i+=1) {
//            titleStringList.add("Title " + Integer.toString(i));
//            detailStringList.add("Detail " + Integer.toString(i));
//        }




    }

    private void getValueArgument() {
        indexAnInt = getArguments().getInt("Index");
        Log.d("21JuneV1", "Receive index ==> " + indexAnInt);
        myConstant = new MyConstant();
        String[] strings = myConstant.getId_ec_Strings();
        id_ec_String = strings[indexAnInt];
        Log.d("21JuneV1", "id_ec ==> " + id_ec_String);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        return view;
    }
}
