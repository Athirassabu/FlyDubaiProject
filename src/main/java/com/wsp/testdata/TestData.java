package com.wsp.testdata;

import com.creditdatamw.zerocell.annotation.Column;

public class TestData {

    @Column(name = "testcasename", index = 0)
    public String testCaseName;


    @Column(name="originCity",index=1)
    public String originCity;
    @Column(name="destinationCity",index=2)
    public String destinationCity;

    @Column(name="originMonth",index=3)
    public String originMonth;
    @Column(name="originYear",index=4)
    public String originYear;
    @Column(name="originDate",index=5)
    public String originDate;
    @Column(name="destMonth",index=6)
    public String destMonth;
    @Column(name="destYear",index=7)
    public String destYear;
    @Column(name="destDate",index=8)
    public String destDate;

    @Column(name="firstName",index=9)
    public String firstName;
    @Column(name="lastName",index=10)
    public String lastName;
    @Column(name="email",index=11)
    public String email;
    @Column(name="gender",index=12)
    public String gender;
    @Column(name="country",index=13)
    public String country;
    @Column(name="number",index=14)
    public String number;
    @Column(name="direction",index=15)
    public String direction;


}
