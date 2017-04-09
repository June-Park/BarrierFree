package com.example.jj.barrierfree;

/**
 * Created by JJ on 2017-03-29.
 *카드뷰의 한 아이템 객체를 관리하는 자바 클래스
 */

public class ListItem {

    private String title;
    private String content;


    public ListItem(String title, String content) {
        this.title = title;
        this.content = content;
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}
