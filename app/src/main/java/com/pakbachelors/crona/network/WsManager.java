package com.pakbachelors.crona.network;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


import java.io.File;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by jazib Shehraz on 11/4/2017.
 */

public class WsManager {
    StringRequest request;
    private Context context;

    public WsManager(Context context) {
        this.context = context;
    }



    public void post(String url, final WSResponse wsResponse) {
        //RequestQueue requestQueue = VolleySingleton.getsInstense().getmRequestQueue();
        // RequestQueue queue = VolleySingleton.getInstance(context).getRequestQueue();
        //showDialog("Please wait...");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("res", response.toString());
                        wsResponse.onSuccess(response);
                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                wsResponse.onError(error.getLocalizedMessage());
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    wsResponse.onError("Time out Error or No Connection");
                } else if (error instanceof AuthFailureError) {
                    wsResponse.onError("Auth Failure Error");
                } else if (error instanceof ServerError) {
                    wsResponse.onError("Server Error");
                } else if (error instanceof NetworkError) {
                    wsResponse.onError("Network Error");
                } else if (error instanceof ParseError) {
                    wsResponse.onError("Parser Error");
                }
            }
        });


//

        //  requestQueue.add(stringRequest);
        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }

    public void postAsMap(final Map<String, String> mMmap, String url, final WSResponse wsResponse) {
        // RequestQueue queue = VolleySingleton.getsInstense().getmRequestQueue();
        request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("res", response.toString());
                wsResponse.onSuccess(response);

            }
        },
                new Response.ErrorListener() { // the error listener
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            wsResponse.onError("Time out Error or No Connection");
                        } else if (error instanceof AuthFailureError) {
                            wsResponse.onError("Auth Failure Error");
                        } else if (error instanceof ServerError) {
                            wsResponse.onError("Server Error");
                        } else if (error instanceof NetworkError) {
                            wsResponse.onError("Network Error");
                        } else if (error instanceof ParseError) {
                            wsResponse.onError("Parser Error");
                        } else {
                            wsResponse.onError(error.getLocalizedMessage());
                        }
                    }


                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map = mMmap;
                return map;
            }
        };

//    loading.hide();
        // executing the quere to get the json information
        //  queue.add(request);
        VolleySingleton.getInstance(context).addToRequestQueue(request);
    }

    public void cancerlRequest() {
        if (request != null)
            request.cancel();
    }
}
