package droidwelt.ru.rectest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


@SuppressWarnings("Annotator")
class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    private MainActivity act;

    public void setMainActivity(MainActivity a) {
        act = a;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_item_flat, parent, false);
        return new ViewHolder(itemLayoutView);
    }


    @Override
    public int getItemCount() {
        return act.getListMain().size();
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        MainDataStructure myListItem = act.getListMain().get(position);
        viewHolder.MAIN_ID = myListItem.getMain_id();
        viewHolder.tv_mainitem_title.setText(myListItem.getMain_title());
        String text = myListItem.getMain_text();
        viewHolder.tv_mainitem_text.setText(Html.fromHtml(text));
        viewHolder.iv_mainitem_image.setImageDrawable(myListItem.getMain_img());
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_mainitem_title, tv_mainitem_text;
        ImageView iv_mainitem_image;
        String MAIN_ID;

        ViewHolder(final View itemLayoutView) {
            super(itemLayoutView);
            tv_mainitem_title = itemLayoutView.findViewById(R.id.tv_mainitem_title);
            tv_mainitem_text = itemLayoutView.findViewById(R.id.tv_mainitem_text);
            iv_mainitem_image = itemLayoutView.findViewById(R.id.iv_mainitem_image);

            itemLayoutView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            ;
        }
    }


}