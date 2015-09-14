package vickypatel.ca.materialdesignnavigationdrawer;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by VickyPatel on 2015-09-13.
 */
public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {

    String[] titles = {"Inbox", "Starred", "Important", "Settings"};
    String[] titles2 = {"Help", "Contact", "Feedback", "Logout"};
    int[] icons = {R.drawable.ic_mail, R.drawable.ic_fav, R.drawable.ic_imp, R.drawable.ic_settings};
    int profile = R.drawable.convo;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_navigation_drawer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(titles[position - 1]);
        holder.imageView.setImageResource(icons[position - 1]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.rowText);
            imageView = (ImageView) itemView.findViewById(R.id.rowIcon);

        }

    }

}
