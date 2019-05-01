package br.com.alessanderleite.sqlitemvpapp.views.imp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.alessanderleite.sqlitemvpapp.R;
import br.com.alessanderleite.sqlitemvpapp.infrastructure.adapter.MemberListAdapter;

public class MemberFragment extends Fragment {

    private RecyclerView listMember;
    private LinearLayoutManager linearLayoutManager;
    private MemberListAdapter memberListAdapter;


    public MemberFragment() {
        // Required empty public constructor
    }

    public static MemberFragment newInstance() {
        return new MemberFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_member, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
