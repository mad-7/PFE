package com.pfe.daricom.Database;



import com.pfe.daricom.Model.UserModel;
import java.util.ArrayList;
import java.util.List;
import com.pfe.daricom.R;



public class Users{
        private ArrayList<UserModel> Users = new ArrayList<>();

        public void setUsers(){
            Users.add(new UserModel(1,"FirstName 1","LastName 1","Mahdikahoul@gmail.com",R.drawable.p5 ));
            Users.add(new UserModel(2,"FirstName 2","LastName 2","Mohamedkahoul@gmail.com",R.drawable.p7));
            Users.add(new UserModel(3,"FirstName 3","LastName 3","Aziiz@gmail.com",R.drawable.p5));
            Users.add(new UserModel(4,"FirstName 4","LastName 4","Atef@gmail.com",R.drawable.p4));
            Users.add(new UserModel(5,"FirstName 5","LastName 5","Ala@gmail.com",R.drawable.p5));
            Users.add(new UserModel(6,"FirstName 6","LastName 6","Salah@gmail.com",R.drawable.p6));
            Users.add(new UserModel(7,"FirstName 7","LastName 7","Zinou@gmail.com",R.drawable.p7));
        }

        public ArrayList<UserModel> getUsers() { return  Users;}

    public UserModel getUserById(int id)
    {
        UserModel target = null;
        for (UserModel user :
                Users)
            if(user.getId() == id)
                target = user;
            return  target ;

    }
}
