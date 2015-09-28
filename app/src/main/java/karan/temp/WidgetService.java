package karan.temp;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by karan on 28/9/15.
 */
public class WidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        int appWidgetId=intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,AppWidgetManager.INVALID_APPWIDGET_ID);
        return (new ListProvider(this.getApplicationContext(),intent));
    }
}

