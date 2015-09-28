package karan.temp;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        final int N = appWidgetIds.length;
        for (int i = 0; i < N; i++) {
            updateAppWidget(context, appWidgetManager, appWidgetIds[i]);
        }
        super.onUpdate(context,appWidgetManager,appWidgetIds);
    }


    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        Intent svcIntent=new Intent(context,WidgetService.class);
        svcIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,appWidgetId);
        svcIntent.setData(Uri.parse(svcIntent.toUri(Intent.URI_INTENT_SCHEME)));
        RemoteViews widget=new RemoteViews(context.getPackageName(),R.layout.new_app_widget);
        widget.setRemoteAdapter( R.id.listView, svcIntent);

       // views.setTextViewText(R.id.appwidget_text, widgetText);
            System.out.println("hi");
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, widget);
    }
}

