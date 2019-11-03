package com.example.sqlite_15102019;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Author> {
    private Context context;
    private int layout;
    private ArrayList<Author> listAuthor;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Author> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.listAuthor = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_listview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv_id = (TextView) convertView.findViewById(R.id.textview_id);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.textview_name);
            viewHolder.tv_add = (TextView) convertView.findViewById(R.id.textview_add);
            viewHolder.tv_mail = (TextView) convertView.findViewById(R.id.textview_email);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Author student = listAuthor.get(position);
        viewHolder.tv_id.setText(student.getIdAuthor() + "");
        viewHolder.tv_name.setText(student.getName());
        viewHolder.tv_add.setText(student.getAddress());

        viewHolder.tv_mail.setText(student.getMail());

        return convertView;
    }

    public class ViewHolder {
        private TextView tv_id;
        private TextView tv_name;
        private TextView tv_add;
        private TextView tv_mail;

    }
}
