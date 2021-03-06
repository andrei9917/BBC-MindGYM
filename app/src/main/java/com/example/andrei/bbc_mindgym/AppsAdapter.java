package com.example.andrei.bbc_mindgym;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.ViewHolder> {

    Context context1;
    List<String> stringList;

    public AppsAdapter(Context context, List<String> list) {

        context1 = context;

        stringList = list;
    }

    @Override
    public AppsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view2 = LayoutInflater.from(context1).inflate(R.layout.cardview_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(view2);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        ApkInfoExtractor apkInfoExtractor = new ApkInfoExtractor(context1);

        final String ApplicationPackageName = stringList.get(position);
        String ApplicationLabelName = apkInfoExtractor.GetAppName(ApplicationPackageName);
        Drawable drawable = apkInfoExtractor.getAppIconByPackageName(ApplicationPackageName);

        viewHolder.textView_App_Name.setText(ApplicationLabelName);

        viewHolder.textView_App_Package_Name.setText(ApplicationPackageName);

        viewHolder.imageView.setImageDrawable(drawable);

        //Adding click listener on CardView to open clicked application directly from here .
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = context1.getPackageManager().getLaunchIntentForPackage(ApplicationPackageName);
                if (intent != null) {

                    context1.startActivity(intent);

                } else {

                    Toast.makeText(context1, ApplicationPackageName + " Error, Please Try Again.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {

        return stringList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public CardView cardView;
        public ImageView imageView;
        public TextView textView_App_Name;
        public TextView textView_App_Package_Name;

        public ViewHolder(View view) {

            super(view);

            cardView = view.findViewById(R.id.card_view);
            imageView = view.findViewById(R.id.imageview);
            textView_App_Name = view.findViewById(R.id.Apk_Name);
            textView_App_Package_Name = view.findViewById(R.id.Apk_Package_Name);
        }
    }

}