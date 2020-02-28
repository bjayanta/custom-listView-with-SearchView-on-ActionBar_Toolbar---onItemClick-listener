package com.maxsop.customlistviewall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CustomAdapter extends BaseAdapter {
    // variables
    Context context;
    LayoutInflater inflater;
    List<Model> modelList;
    ArrayList<Model> arrayList;

    /**
     *
     * @param context
     * @param modelList
     */
    public CustomAdapter(Context context, List<Model> modelList) {
        this.context = context;
        this.modelList = modelList;

        this.inflater = LayoutInflater.from(this.context);

        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modelList);
    }

    public class ViewHolder {
        TextView title_textView, description_textView;
        ImageView icon_imageView;
    }

    @Override
    public int getCount() {
        return this.modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.row, null);

            holder.title_textView = convertView.findViewById(R.id.row_title);
            holder.description_textView = convertView.findViewById(R.id.row_details);
            holder.icon_imageView = convertView.findViewById(R.id.row_icon);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // set values
        holder.title_textView.setText(modelList.get(position).getTitle());
        holder.description_textView.setText(modelList.get(position).getDescription());
        holder.icon_imageView.setImageResource(modelList.get(position).getIcon());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, modelList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    /**
     *
     * @param txt
     */
    public void filter(String txt) {
        txt = txt.toLowerCase(Locale.getDefault());
        modelList.clear();

        if (txt.length() == 0) {
            modelList.addAll(arrayList);
        } else {
            for (Model model : arrayList) {
                if (model.getTitle().toLowerCase(Locale.getDefault()).contains(txt)) {
                    modelList.add(model);
                }
            }
        }

        notifyDataSetChanged();
    }
}
