package com.example.myfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.myfirstapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private TextView textView;
    private Integer count = 0;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        textView = binding.textviewFirst;
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.toastButton.setOnClickListener(view1 -> {
            Toast myToast = Toast.makeText(getActivity(), getString(R.string.toast_text), Toast.LENGTH_SHORT);
            myToast.show();
        });
        binding.countButton.setOnClickListener(view1 -> {
            countMe(view1);
        });
        binding.randomButton.setOnClickListener(view1 -> {
            FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(count);
            NavHostFragment.findNavController(FirstFragment.this).navigate(action);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void countMe(View view) {
        String countString = textView.getText().toString();
        count++;
        textView.setText(Integer.toString(count));
    }

}