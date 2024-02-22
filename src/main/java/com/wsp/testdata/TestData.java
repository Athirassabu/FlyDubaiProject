package com.wsp.testdata;

import com.creditdatamw.zerocell.annotation.Column;

public class TestData {

    @Column(name = "testcasename", index = 0)
    public String testCaseName;


    @Column(name="expectedtitle",index=1)
    public String expectedTitle;
    @Column(name="month",index=2)
    public String month;
    @Column(name="year",index=3)
    public String year;
    @Column(name="date",index=4)
    public String date;
    @Column(name="salary",index=5)
    public String salary;
    @Column(name="title",index=6)
    public String title;
    @Column(name="name",index=7)
    public String name;
    @Column(name="nation",index=8)
    public String nation;
    @Column(name="email",index=9)
    public String email;
    @Column(name="phone",index=10)
    public String phone;
    @Column(name="emiratesId",index=11)
    public String emiratesId;
    @Column(name="emiratesIdMonth",index=12)
    public String emiratesIdMonth;
    @Column(name="emiratesIdYear",index=13)
    public String emiratesIdYear;
    @Column(name="emiratesIdDate",index=14)
    public String emiratesIdDate;

}
