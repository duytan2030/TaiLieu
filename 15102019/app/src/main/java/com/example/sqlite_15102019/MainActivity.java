package com.example.sqlite_15102019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private EditText ed_id,ed_name,ed_add,ed_mail;
    Button bt_save;
    ListView lv;
    private ArrayAdapter arrayAdapter;
    private ArrayList<Author> list;
    private DBHelper db ;
    private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

        db = new DBHelper(this);
        list = db.listAuthor();
        setAddapter();
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author = insertAuthor();
                if(author!=null){
                    db.insertAuthor(author);
                }
                list.clear();
                list.addAll(db.listAuthor());
                setAddapter();
            }
        });
    }
    public void anhxa(){
        ed_add=(EditText)findViewById(R.id.edit_Address);
        ed_mail=(EditText)findViewById(R.id.edit_Email);
        ed_id=(EditText)findViewById(R.id.edit_maAuthor);
        ed_name=(EditText)findViewById(R.id.edit_nameAuthor);
        bt_save=(Button)findViewById(R.id.button_save);
        lv=(ListView)findViewById(R.id.listview_lv);

    }
    public Author insertAuthor() {
        String name = ed_name.getText().toString();
        String add = ed_add.getText().toString();
        int id = Integer.parseInt(ed_id.getText().toString());
        String email = ed_mail.getText().toString();
        Author author = new Author(id,name,add,email);
        return author;
    }
    public void setAddapter() {
        if (customAdapter == null) {
            customAdapter = new CustomAdapter(this, R.layout.custom_listview, list);
            lv.setAdapter(customAdapter);
        }
        else {
            customAdapter.notifyDataSetChanged();
            lv.setSelection(customAdapter.getCount()-1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Inflater inflater = new Inflater();
        inflater.
        return super.onCreateOptionsMenu(menu);
    }
}
