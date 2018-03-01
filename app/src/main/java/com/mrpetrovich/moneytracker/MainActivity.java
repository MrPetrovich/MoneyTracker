package com.mrpetrovich.moneytracker;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
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
        items.setAdapter(new ItemsAdapter());
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Item(name.getText().toString(), Integer.valueOf(price.getText().toString()));
            }
        });
    }

    private class ItemsAdapter extends ArrayAdapter<Item> {
        public ItemsAdapter(@NonNull Context context, int resource) {
            super(context, R.layout.item);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            final View view = getLayoutInflater().inflate(R.layout.item, parent);
            ((TextView) view.findViewById(R.id.name)).setText(getItem().name);
            ((TextView) view.findViewById(R.id.price)).setText(getItem().price);
            return view;
        }
    }
}
