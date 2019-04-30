package br.com.alessanderleite.sqlitemvpapp.infrastructure.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alessanderleite.sqlitemvpapp.R;
import br.com.alessanderleite.sqlitemvpapp.models.Member;

public class MemberListAdapter extends RecyclerView.Adapter<MemberListAdapter.MemberViewHolder> {

    private List<Member> memberList;

    public MemberListAdapter() {
        memberList = new ArrayList<>();
    }

    private void add(Member item) {
        memberList.add(item);
        notifyItemInserted(memberList.size() - 1);
    }

    public void addAll(List<Member> memberList) {
        for (Member member : memberList) {
            add(member);
        }
    }

    public void remove(Member item) {
        int position = memberList.indexOf(item);
        if (position > -1) {
            memberList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while(getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public Member getItem (int position) {
        return memberList.get(position);
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_member, parent, false);
        MemberViewHolder memberVielHolder = new MemberViewHolder(view);

        return memberVielHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, int position) {
        final Member member = memberList.get(position);

        holder.memberThumb.setImageResource(member.getThumb());
        holder.memberName.setText(member.getName());
        holder.memberTeam.setText(member.getTeam());
    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {

        ImageView memberThumb;
        TextView memberName;
        TextView memberTeam;

        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);

            memberThumb = (ImageView) itemView.findViewById(R.id.thumb);
            memberName = (TextView) itemView.findViewById(R.id.name);
            memberTeam = (TextView) itemView.findViewById(R.id.team);
        }
    }
}
