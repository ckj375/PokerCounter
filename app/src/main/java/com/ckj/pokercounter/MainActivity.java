package com.ckj.pokercounter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int[] cards;
    /**
     * 按键列表
     */
    private String[] keys = {"D", "X", "2", "A", "K", "Q", "J", "S", "9", "8", "7", "6", "5", "4", "3"};
    private StringBuilder cacheStr = new StringBuilder();
    private ArrayList historyList = new ArrayList();

    private ImageView imgView;
    private RecyclerView leftCardsRecyclerView;
    private LeftCardsAdapter leftCardsAdapter;
    private RecyclerView historyRecyclerView;
    private HistoryAdapter historyAdapter;
    private TextView cacheTV;
    private GridView gridView;
    private GridAdapter gridAdapter;
    private TextView backBtn;
    private TextView discardBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.ckj.pokercounter.R.layout.activity_main);

        init();

        leftCardsAdapter = new LeftCardsAdapter(this, cards);
        leftCardsRecyclerView = findViewById(com.ckj.pokercounter.R.id.left_cards_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        leftCardsRecyclerView.setLayoutManager(layoutManager);
        leftCardsRecyclerView.setAdapter(leftCardsAdapter);

        imgView = findViewById(com.ckj.pokercounter.R.id.test);
        historyAdapter = new HistoryAdapter(this, historyList);
        historyRecyclerView = findViewById(com.ckj.pokercounter.R.id.history_recyclerview);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        historyRecyclerView.setLayoutManager(layoutManager2);
        historyRecyclerView.setAdapter(historyAdapter);

        cacheTV = findViewById(com.ckj.pokercounter.R.id.cache_tv);
        gridView = findViewById(com.ckj.pokercounter.R.id.gridview);
        gridAdapter = new GridAdapter(this, keys);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new GridItemClickListener());

        backBtn = findViewById(com.ckj.pokercounter.R.id.key_back);
        backBtn.setOnClickListener(new BackListener());
        discardBtn = findViewById(com.ckj.pokercounter.R.id.key_discard);
        discardBtn.setOnClickListener(new DiscardListener());
    }

    private void init() {
        cards = new int[15];
        for (int i = 0; i < 15; i++) {
            if (i <= 1) {
                cards[i] = 2;
            } else {
                cards[i] = 8;
            }
        }

    }

    class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            cacheStr.append(keys[position]);
            cacheTV.setText(cacheStr);
        }
    }

    class BackListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (cacheStr.length() > 0) {
                cacheStr.deleteCharAt(cacheStr.length() - 1);
                cacheTV.setText(cacheStr);
            }
        }
    }

    class DiscardListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int length = cacheStr.length();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    switch (String.valueOf(cacheStr.charAt(i))) {
                        case "D":
                            cards[0]--;
                            break;
                        case "X":
                            cards[1]--;
                            break;
                        case "2":
                            cards[2]--;
                            break;
                        case "A":
                            cards[3]--;
                            break;
                        case "K":
                            cards[4]--;
                            break;
                        case "Q":
                            cards[5]--;
                            break;
                        case "J":
                            cards[6]--;
                            break;
                        case "S":
                            cards[7]--;
                            break;
                        case "9":
                            cards[8]--;
                            break;
                        case "8":
                            cards[9]--;
                            break;
                        case "7":
                            cards[10]--;
                            break;
                        case "6":
                            cards[11]--;
                            break;
                        case "5":
                            cards[12]--;
                            break;
                        case "4":
                            cards[13]--;
                            break;
                        case "3":
                            cards[14]--;
                            break;
                    }
                }
                historyList.add(cacheStr.toString().trim());
                cacheStr.delete(0, cacheStr.length());
                cacheTV.setText(cacheStr);
                leftCardsAdapter.notifyDataSetChanged();
                historyAdapter.notifyDataSetChanged();
            }
        }
    }

}
