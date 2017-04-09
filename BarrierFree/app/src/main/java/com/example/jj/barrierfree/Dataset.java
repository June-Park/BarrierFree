package com.example.jj.barrierfree;

/**
 * Created by JJ on 2017-03-27.
 * 공공데이터에서 가져온 객체 하나의 정보를 담는 데이터셋. 벡터에 담아 사용.
 */

public class Dataset {

    private String NUM = ""; // 순번
    private String NAME = ""; //업소명
    private String TEL = ""; //전화번호
    private String FAX = ""; //팩스
    private String ADDRESS = ""; //주소
    private String BIZHOUR = ""; //영업시간
    private String REST = ""; //휴무일
    private String INFORMATION = ""; //기본정보
    private String BOARD_LIST = ""; //메뉴명

    private String INFORMATI_1 = ""; //장애인 편의시설
    private String INFO_BLE_1 = ""; //주출입구
    private String INFO_BLE_2 = ""; //장애인 전용 주차구역
    private String INFO_BLE_3 = ""; // 출입문 문쪽
    private String INFO_BLE_4 = ""; //복도/통로
    private String INFO_BLE_5 = ""; //장애인용 엘리베이터
    private String INFO_BLE_6 = ""; //장애인용 화장실
    private String INFO_BLE_7 = ""; //음식점 좌석/테이블
    private String INFO_BLE_8 = ""; //장애인용 관람석
    private String INFO_BLE_9 = ""; //접수대 작업대

    private double DAUM_XX = 0.0; //다음지도 경도
    private double DAUM_YY = 0.0; //다음지도 위도

    public String getNUM() {
        return NUM;
    }

    public void setNUM(String NUM) {
        this.NUM = NUM;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }

    public String getFAX() {
        return FAX;
    }

    public void setFAX(String FAX) {
        this.FAX = FAX;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getBIZHOUR() {
        return BIZHOUR;
    }

    public void setBIZHOUR(String BIZHOUR) {
        this.BIZHOUR = BIZHOUR;
    }

    public String getREST() {
        return REST;
    }

    public void setREST(String REST) {
        this.REST = REST;
    }

    public String getINFORMATION() {
        return INFORMATION;
    }

    public void setINFORMATION(String INFORMATION) {
        this.INFORMATION = INFORMATION;
    }

    public String getBOARD_LIST() {
        return BOARD_LIST;
    }

    public void setBOARD_LIST(String BOARD_LIST) {
        this.BOARD_LIST = BOARD_LIST;
    }

    public String getINFORMATI_1() {
        return INFORMATI_1;
    }

    public void setINFORMATI_1(String INFORMATI_1) {
        this.INFORMATI_1 = INFORMATI_1;
    }

    public String getINFO_BLE_1() {
        return INFO_BLE_1;
    }

    public void setINFO_BLE_1(String INFO_BLE_1) {
        this.INFO_BLE_1 = INFO_BLE_1;
    }

    public String getINFO_BLE_2() {
        return INFO_BLE_2;
    }

    public void setINFO_BLE_2(String INFO_BLE_2) {
        this.INFO_BLE_2 = INFO_BLE_2;
    }

    public String getINFO_BLE_3() {
        return INFO_BLE_3;
    }

    public void setINFO_BLE_3(String INFO_BLE_3) {
        this.INFO_BLE_3 = INFO_BLE_3;
    }

    public String getINFO_BLE_4() {
        return INFO_BLE_4;
    }

    public void setINFO_BLE_4(String INFO_BLE_4) {
        this.INFO_BLE_4 = INFO_BLE_4;
    }

    public String getINFO_BLE_5() {
        return INFO_BLE_5;
    }

    public void setINFO_BLE_5(String INFO_BLE_5) {
        this.INFO_BLE_5 = INFO_BLE_5;
    }

    public String getINFO_BLE_6() {
        return INFO_BLE_6;
    }

    public void setINFO_BLE_6(String INFO_BLE_6) {
        this.INFO_BLE_6 = INFO_BLE_6;
    }

    public String getINFO_BLE_7() {
        return INFO_BLE_7;
    }

    public void setINFO_BLE_7(String INFO_BLE_7) {
        this.INFO_BLE_7 = INFO_BLE_7;
    }

    public String getINFO_BLE_8() {
        return INFO_BLE_8;
    }

    public void setINFO_BLE_8(String INFO_BLE_8) {
        this.INFO_BLE_8 = INFO_BLE_8;
    }

    public String getINFO_BLE_9() {
        return INFO_BLE_9;
    }

    public void setINFO_BLE_9(String INFO_BLE_9) {
        this.INFO_BLE_9 = INFO_BLE_9;
    }

    public double getDAUM_XX() {
        return DAUM_XX;
    }

    public void setDAUM_XX(double DAUM_XX) {
        this.DAUM_XX = DAUM_XX;
    }

    public double getDAUM_YY() {
        return DAUM_YY;
    }

    public void setDAUM_YY(double DAUM_YY) {
        this.DAUM_YY = DAUM_YY;
    }

}
