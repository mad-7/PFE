package com.pfe.daricom.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.pfe.daricom.Model.UserModel;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATA_BASE_NAME ="ACCOUNTS";
    private static final int VERSOIN = 1;
    private static final String TABEL_NAME="account";
    private static final String USERID_COL="id";
    private static final String FULLNAME_COL="fullname";
    private static final String EMAIL_COL="email";
    private static final String PASSWORD_COL="password";

    public DataBaseHelper (@Nullable Context context){
        super(context, DATA_BASE_NAME,null,VERSOIN);
    }

    @Override
    public void onCreate (SQLiteDatabase sqLiteDatabase){
        String query = "CREATE TABLE "+ TABEL_NAME +" ("
                + USERID_COL+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FULLNAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + PASSWORD_COL + " TEXT)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade (SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABEL_NAME);
        onCreate(sqLiteDatabase);
    }

    public long InsertNewUser(UserModel user)
    {
        return 0;
    }

    public int ChackEmail(String email){
        return 0;
    }

    public int ChackPassWord( String email , String passWord){
        return 0;
    }
    public UserModel getUserById(int id)
    {

        return  new UserModel();
    }




}
