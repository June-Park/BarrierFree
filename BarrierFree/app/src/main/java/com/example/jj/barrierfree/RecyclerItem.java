package com.example.jj.barrierfree;

/**
 * Created by JJ on 2017-03-04.
 */

public class RecyclerItem {

    int image;
    String title;

    int getImage(){
        return this.image;
    }
    String getTitle(){
        return this.title;
    }

    RecyclerItem(int image, String title){
        this.image=image;
        this.title=title;
    }

}
