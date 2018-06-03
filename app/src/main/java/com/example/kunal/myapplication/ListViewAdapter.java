package com.example.kunal.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {
    Context mcontext;
    LayoutInflater inflater;
    private List<data> dlist=null;
    private ArrayList<data> arrayList;
    public ListViewAdapter(Context context,List<data> dlist)
    {
        mcontext=context;
        this.dlist=dlist;
        inflater=LayoutInflater.from(mcontext);
        this.arrayList=new ArrayList<data>();
        this.arrayList.addAll(dlist);
    }
    public class ViewHolder{
        TextView name;
        TextView desig;
        TextView contact;
    }
    @Override
    public int getCount()
    {
        return dlist.size();
    }
    @Override
    public data getItem(int position)
    {
        return dlist.get(position);
    }
    public long getItemId(int position)
    {
        return position;
    }
    public View getView(final int position, View view, ViewGroup parent)
    {
        final ViewHolder holder;
        if(view==null)
        {
            holder=new ViewHolder();
            view=inflater.inflate(R.layout.listview_item,null);
            holder.name=(TextView)view.findViewById(R.id.name);
            holder.desig=(TextView)view.findViewById(R.id.desig);
            holder.contact=(TextView)view.findViewById(R.id.contact);
            view.setTag(holder);
        }
        else
        {
            holder=(ViewHolder)view.getTag();
        }
        holder.name.setText(dlist.get(position).getName());
        holder.desig.setText(dlist.get(position).getDesig());
        holder.contact.setText(dlist.get(position).getContact());
        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(mcontext,SingleItemView.class);
                i.putExtra("name",dlist.get(position).getName());
                i.putExtra("designation",dlist.get(position).getDesig());
                i.putExtra("contact",dlist.get(position).getContact());
                mcontext.startActivity(i);
            }
        });
        return view;
    }

    public void filter(String charText)
    {
        charText=charText.toLowerCase(Locale.getDefault());
        dlist.clear();
        if(charText.length()==0)
        {
            dlist.addAll(arrayList);
        }
        else {
            for (data d : arrayList)
            {
                if(d.getName().toLowerCase(Locale.getDefault()).contains(charText))
                    dlist.add(d);
            }
        }
        notifyDataSetChanged();
    }

}
