package com.maxsop.customlistviewall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CustomAdapter adapter;
    ArrayList<Model> arrayList = new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create fruit object
        Model mango = new Model("mango", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.mango);
        Model apricot = new Model("apricot", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.apricot);
        Model banana = new Model("banana", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.banana);
        Model berries = new Model("berries", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.berries);
        Model carambola = new Model("carambola", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.carambola);
        Model cherries = new Model("cherries", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.cherries);
        Model apple = new Model("apple", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.apple);
        Model guava = new Model("guava", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.guava);
        Model orange = new Model("orange", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.orange);
        Model pineapple = new Model("pineapple", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", R.drawable.pineapple);

        // add the fruit object to an ArrayList
        arrayList = new ArrayList<>();
        arrayList.add(mango);
        arrayList.add(apricot);
        arrayList.add(banana);
        arrayList.add(berries);
        arrayList.add(carambola);
        arrayList.add(cherries);
        arrayList.add(apple);
        arrayList.add(guava);
        arrayList.add(orange);
        arrayList.add(pineapple);

        listView = findViewById(R.id.listView);

        adapter = new CustomAdapter(this, arrayList);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem actionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) actionMenuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(TextUtils.isEmpty(newText)) {
                    adapter.filter("");
                    listView.clearTextFilter();
                } else {
                    adapter.filter(newText);
                }

                return true;
            }
        });

        // return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_settings) {
            // settings code gose to here

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
