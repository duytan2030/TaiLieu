package com.example.sqlite_15102019;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String database_name ="book_manager";
    private static final String table_name1 ="book";
    private static final String table_name2 ="author";
    private static final String id_book= "id";
    private static final String id_author= "id";
    private static final String name ="name";
    private static final String address ="address";
    private static final String email= "email";
    private static final String tittle= "tittle";

    private Context context;

    public String SQLQueryAuthor = "CREATE TABLE "+table_name2+" ("+
            id_author +" integer primary key, "+
            name + " TEXT, "+
            address + " TEXT, "+
            email + " TEXT)";

    public String SQLQueryBook ="Create table " +table_name1+" ("+
            id_book +" interger, "+
            tittle +" TEXT, "+
            id_author + " integer "+
            "CONSTRAINT " + id_author + " references " +table_name2 + " (" + id_author + " ))";



    public DBHelper(@Nullable Context context) {
        super(context, database_name, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //sqLiteDatabase.execSQL(SQLQueryBook);
        sqLiteDatabase.execSQL(SQLQueryAuthor);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertAuthor(Author author){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(id_author,author.getIdAuthor());
        values.put(name,author.getName());
        values.put(address,author.getAddress());
        values.put(email,author.getMail());
        db.insert(table_name2,null,values);
        db.close();
        Log.d("databasemanager","insert");
    }
    public ArrayList<Author> listAuthor(){
        ArrayList<Author> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String sqliteQuery ="Select * from " + table_name2;
        Cursor cursor = db.rawQuery(sqliteQuery,null);
        if (cursor.moveToFirst()){
            do {
                Author author  = new Author();
                author.setIdAuthor(cursor.getInt(0));
                author.setName(cursor.getString(1));
                author.setAddress(cursor.getString(2));
                author.setMail(cursor.getString(3));
                list.add(author);
            }while (cursor.moveToNext());
        }
        db.close();
        return list;
    }
    public void insertBook(Book book){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(id_book,book.getIdAuthor());
        values.put(tittle,book.getTitle());
        values.put(id_author,book.getIdAuthor());

        db.insert(table_name1,null,values);
        db.close();
        Log.d("databasemanager","insert");
    }
    public ArrayList<Book> listBook(){
        ArrayList<Book> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String sqliteQuery ="Select * from " +table_name1;
        Cursor cursor = db.rawQuery(sqliteQuery,null);
        if (cursor.moveToFirst()){
            do {
                Book book  = new Book();
                book.setId(cursor.getInt(0));
                book.setTitle(cursor.getString(1));
                book.setIdAuthor(cursor.getInt(2));
                list.add(book);
            }while (cursor.moveToNext());
        }
        db.close();
        return list;
    }

}
