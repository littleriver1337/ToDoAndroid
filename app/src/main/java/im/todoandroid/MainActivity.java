package im.todoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {//(ON CLICK)Step #1Listen for the button click
    ArrayAdapter<String> items;//(ARRAY LIST ADAPTER) this is what we are storing things in
    ListView listView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pulling Android Controls so you can use them
        listView = (ListView) findViewById(R.id.listView); //R = resource //Cast it as ListView
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);//(ON CLICK) Step #3 setting on click listener to listen for "this"^
        listView.setOnItemLongClickListener(this);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);//(ARRAY LIST ADAPTER) this is how we store it
        listView.setAdapter(items);//sets a list view into the LISTS with ITEMS
    }

    @Override
    public void onClick(View v) {//(ON CLICK)Step #2 implemented on click listener
        String text = editText.getText().toString();
        items.add(text);//adds todo item into todo item object
        editText.setText("");

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String itemToRemove = items.getItem(position);
        items.remove(itemToRemove);
        return true;
    }
}
