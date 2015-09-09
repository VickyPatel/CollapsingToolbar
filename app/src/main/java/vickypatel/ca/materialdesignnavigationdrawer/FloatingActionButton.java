package vickypatel.ca.materialdesignnavigationdrawer;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FloatingActionButton extends ActionBarActivity {

    public Toolbar toolbar;
    RecyclerView mRecycleView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle("FAB");
        toolbar.showOverflowMenu();

        mRecycleView = (RecyclerView) findViewById(R.id.fabContent);
        mRecycleView.setHasFixedSize(true);

        mAdapter = new FabAdapter(this);
        mRecycleView.setAdapter(mAdapter);

        mLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLayoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_floating_action_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public class FabAdapter extends RecyclerView.Adapter<FabAdapter.ViewHolder> {
        String[] titles = {"Inbox", "Starred", "Important", "Settings","Inbox", "Starred", "Important", "Settings","Inbox", "Starred", "Important", "Settings","Inbox", "Starred", "Important", "Settings"};
        int[] icons = {R.drawable.ic_mail, R.drawable.ic_fav, R.drawable.ic_imp, R.drawable.ic_settings,R.drawable.ic_mail, R.drawable.ic_fav, R.drawable.ic_imp, R.drawable.ic_settings, R.drawable.ic_mail, R.drawable.ic_fav, R.drawable.ic_imp, R.drawable.ic_settings , R.drawable.ic_mail, R.drawable.ic_fav, R.drawable.ic_imp, R.drawable.ic_settings};

        public FabAdapter(Context context) {
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_navigation_drawer, parent, false);
            return  new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(titles[position]);
            holder.imageView.setImageResource(icons[position]);
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
}
