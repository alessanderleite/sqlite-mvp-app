package br.com.alessanderleite.sqlitemvpapp.views.imp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.alessanderleite.sqlitemvpapp.R;
import br.com.alessanderleite.sqlitemvpapp.infrastructure.adapter.MemberListAdapter;
import br.com.alessanderleite.sqlitemvpapp.models.Member;

public class MemberFragment extends Fragment {

    private RecyclerView listMember;
    private LinearLayoutManager linearLayoutManager;
    private MemberListAdapter memberListAdapter;

    protected Context context;

    public static MemberFragment newInstance() {
        return new MemberFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_member, container, false);

        listMember = (RecyclerView) rootView.findViewById(R.id.listMember);

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        linearLayoutManager = new LinearLayoutManager(context);
        memberListAdapter = new MemberListAdapter();

        listMember.setLayoutManager(linearLayoutManager);
        listMember.setAdapter(memberListAdapter);

        loadData();
    }

    private void loadData() {
        List<Member> memberList = new ArrayList<>();
        Member member;

        int thumb[] = {
                R.drawable.test01,R.drawable.test02,R.drawable.test03,
                R.drawable.test04,R.drawable.test05,R.drawable.test06,
                R.drawable.test07,R.drawable.test08,R.drawable.test09,
                R.drawable.test10,R.drawable.test11,R.drawable.test12,
                R.drawable.test13,R.drawable.test13,R.drawable.test14,
                R.drawable.test15,R.drawable.test16,R.drawable.test17,
                R.drawable.test18,R.drawable.test19,R.drawable.test20};

        String name[] = {
                "test01","test02","test03","test04",
                "test05","test06","test07","test08",
                "test09","test10","test11","test12",
                "test13","test14","test15","test16",
                "test17","test18","test19","test20"};

        String team = "Team J";

        for (int i = 0; i < thumb.length; i++) {
            member = new Member();

            member.setId(i + 1);
            member.setName(name[i]);
            member.setTeam(team);
            member.setThumb(thumb[i]);

            memberList.add(member);
        }

        memberListAdapter.addAll(memberList);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
