package shareholder.infinity.com.ladiesclub;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import android.widget.TextView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class DesignActivity extends AppCompatActivity {

    private RecyclerView mDesignList;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);

        mDesignList = findViewById(R.id.design_list);
        mDesignList.setHasFixedSize(true);
        mDesignList.setLayoutManager(new LinearLayoutManager(this));
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Designs");
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter <Design, DesignViewHolder> FirebaseAdapter = new FirebaseRecyclerAdapter<Design, DesignViewHolder>(
                Design.class,
                R.layout.design_row,
                DesignViewHolder.class,
                mDatabase

        ) {
            @Override
            protected void populateViewHolder(DesignViewHolder viewHolder, Design model, int position) {

                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDescription());
                viewHolder.setImage(getApplicationContext(), model.getImage());


            }
        };

        mDesignList.setAdapter(FirebaseAdapter);
    }

    public static class DesignViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public DesignViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

        }

        public void setTitle(String title) {

            TextView post_title = mView.findViewById(R.id.post_title);
            post_title.setText(title);
        }

        public void setDesc(String desc) {

            TextView post_desc = mView.findViewById(R.id.post_description);
            post_desc.setText(desc);
        }


        public void setImage(Context ctx, String image) {
            ImageView post_image = mView.findViewById(R.id.post_image);
            Picasso.with(ctx).load(image).into(post_image);

        }

    }
}
