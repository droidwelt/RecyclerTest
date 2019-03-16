package droidwelt.ru.rectest;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    List<MainDataStructure> list_main;
    RecyclerView mRecyclerView;
    MainRecyclerAdapter mAdapter;
    LinearLayoutManager mLayoutManager;
    Date dtStart, dtFinist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_main = new ArrayList<>();
        mRecyclerView = findViewById(R.id.rv_main);
        mRecyclerView.setHapticFeedbackEnabled(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MainRecyclerAdapter();
        mAdapter.setMainActivity(this);
        mRecyclerView.setAdapter(mAdapter);
    }


    public List<MainDataStructure> getListMain() {
        return list_main;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_main_new:
                list_main.clear();
                dtStart = new Date();
                addList(20000);
                dtFinist = new Date();
                displayTime();
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.menu_main_add:
                int i = mAdapter.getItemCount();
                dtStart = new Date();
                addList(200);
                dtFinist = new Date();
                displayTime();
                mAdapter.notifyDataSetChanged();
                mRecyclerView.scrollToPosition(i-1);
                return true;

            case R.id.menu_main_sort:
                dtStart = new Date();
                mysort();
                dtFinist = new Date();
                displayTime();
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.menu_main_view:
                dtStart = new Date();
                mAdapter.notifyDataSetChanged();
                dtFinist = new Date();
                displayTime();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void displayTime() {
        long diff = (dtFinist.getTime() - dtStart.getTime());
        setTitle(String.valueOf(diff) + " msec");
    }


    protected void addList(int n) {

        for (int i = 0; i < n; i = i + 1) {
            MainDataStructure mes = new MainDataStructure();
            mes.setMain_id("6");
            mes.setMain_title(String.valueOf(i));
            String s = UUID.randomUUID().toString();
            mes.setMain_text(s);

            /* не очень красиво, зато пишется быстро, картинки... какие были 80x80, веселые :-) */
            switch (s.substring(0,1)) {

                case "0":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.x0));
                    break;
                case "1":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.x1));
                    break;
                case "2":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.x2));
                    break;
                case "3":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.x3));
                    break;
                case "4":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.x4));
                    break;
                case "5":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.x5));
                    break;
                case "6":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.x6));
                    break;
                case "7":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.x7));
                    break;
                case "8":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.x8));
                    break;
                case "9":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.x9));
                    break;
                case "a":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.xa));
                    break;
                case "b":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.xb));
                    break;
                case "c":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.xc));
                    break;
                case "d":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.xd));
                    break;
                case "e":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.xe));
                    break;
                case "f":
                    mes.setMain_img(getApplicationContext().getResources().getDrawable(R.mipmap.xf));
                    break;
            }

            list_main.add(mes);
        }
    }

    protected void mysort() {
        Collections.sort(list_main, new Comparator<MainDataStructure>() {
            public int compare(MainDataStructure o1, MainDataStructure o2) {
                return o1.getMain_text().compareTo(o2.getMain_text());
            }
        });
    }

}
