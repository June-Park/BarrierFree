package com.example.jj.barrierfree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*레이아웃 : activity_review, review_item
* 자바클래스 : ReviewActivity, ListItem, CardviewAdapter*/

public class ReviewActivity extends AppCompatActivity {

    /*private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapte;*/

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        GetXmlData getXmlData = new GetXmlData();
        getXmlData.setAllData();
        Vector<Dataset> data  = getXmlData.getData();


        listItems = new ArrayList<>();

        /*--------------------------------------------------------------가데이터*/
        for(int a = 0 ; a<data.size() ; a++)
        {
            ListItem listItem = new ListItem(
                    data.get(a).getNAME(),
                    data.get(a).getADDRESS()
            );
            listItems.add(listItem);
        }

        adapter = new CardviewAdapter(listItems, this);

        recyclerView.setAdapter(adapter);

        /*---------------------------------------------------------------------------------------------------------*/
        /*RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(ReviewActivity.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        List<RecyclerItem> items = new ArrayList<>();
        RecyclerItem[] item = new RecyclerItem[5];

        item[0] = new RecyclerItem(R.drawable.home_buildings, "aa");
        item[1] = new RecyclerItem(R.drawable.home_buildings, "bb");
        item[2] = new RecyclerItem(R.drawable.home_buildings, "cc");
        item[3] = new RecyclerItem(R.drawable.home_buildings, "dd");
        item[4] = new RecyclerItem(R.drawable.home_buildings, "ee");


        for (int i = 0; i < 5; i++)
        {
            items.add(item[i]);
        }

        recyclerView.setAdapter(new RecyclerAdapter(getApplicationContext(),items,R.layout.activity_review));*/

        /*----------------------------------------------------------------------------------------------------------------*/
    }
}
