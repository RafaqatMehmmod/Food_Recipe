package com.example.recipiapi;

import java.util.List;

interface OnFetchDataListener {

    void didFetch(ApiResponse apiResponse,String message);
    void didError(String message);


}
