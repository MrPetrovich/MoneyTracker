package com.mrpetrovich.moneytracker;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by MrPetrovich on 21.02.2018.
 */

public class MainActivity extends Activity {
    class Item {
        String name;
        int price;
        Item(String name, int price){
            this.name = name;
            this.price = price;
        }
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final EditText name = findViewById(R.id.name);
        final EditText price = findViewById(R.id.price);
        final Button add = findViewById(R.id.add);
        final ListView items = findViewById(R.id.items);
        final ItemsAdapter adapter = new ItemsAdapter();
        items.setAdapter(adapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(new Item(name.getText().toString(), Integer.valueOf(price.getText().toString())));

            }
        });
    }

    private class ItemsAdapter extends ArrayAdapter<Item> {
        public ItemsAdapter() {
            super(MainActivity.this, R.layout.item);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            final View view = getLayoutInflater().inflate(R.layout.item, null);
            final Item item = getItem(position);
            ((TextView) view.findViewById(R.id.name)).setText(item.name);
            ((TextView) view.findViewById(R.id.price)).setText(String.valueOf(item.price));
            return view;
        }
    }
}
