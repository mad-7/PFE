package com.pfe.daricom.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pfe.daricom.R;
import com.pfe.daricom.databinding.FragmentDashboardBinding;
import com.pfe.daricom.ui.notifications.NotificationsFragment;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private TextView myAccount;
    private TextView myAds;
    private TextView myRequsts;
    private TextView myMesseges;
    private TextView logOut;
    public View onCreateView (@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        NotificationsFragment notificationsFragment = new NotificationsFragment();

        myAds = binding.myAds;
        myAds.setOnClickListener(view ->
                getActivity().getSupportFragmentManager().
                        beginTransaction().replace(R.id.container, notificationsFragment).
                        addToBackStack(null).commit()

        );

        return root;
    }

    @Override
    public void onDestroyView (){
        super.onDestroyView();
        binding = null;
    }
}