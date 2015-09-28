package karan.temp;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

/**
 * Created by karan on 28/9/15.
 */
public class ListProvider implements RemoteViewsService.RemoteViewsFactory {
    private Context context;
    private int appWidgetId;
    String[] items={"#First hash tag","#second Tag","#RandomStuff","WTF","Whats up","HEllo World","WTF","#Testing","9th item","Final Item"};
    public ListProvider(Context context,Intent intent)
    {
        this.context=context;
        appWidgetId=intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,AppWidgetManager.INVALID_APPWIDGET_ID);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews row=new RemoteViews(context.getPackageName(), R.layout.trend);
        row.setTextViewText(android.R.id.text1,items[position]);
        System.out.println(items[position]);
        return row;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
