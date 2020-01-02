package com.example.chaatralay.Model;

public class StudentListModel {
    public StudentListModel() {
    }

    private String sn,rollno,name,dob,gender,language,mobile,email,father_name,address,parents_mobile,district,mother_name,doa,hostel,img_url;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParents_mobile() {
        return parents_mobile;
    }

    public void setParents_mobile(String parents_mobile) {
        this.parents_mobile = parents_mobile;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getDoa() {
        return doa;
    }

    public void setDoa(String doa) {
        this.doa = doa;
    }

    public String getHostel() {
        return hostel;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public StudentListModel(String sn, String rollno, String name, String dob, String gender, String language, String mobile, String email, String father_name, String address, String parents_mobile, String district, String mother_name, String doa, String hostel, String img_url) {
        this.sn = sn;
        this.rollno = rollno;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.language = language;
        this.mobile = mobile;
        this.email = email;
        this.father_name = father_name;
        this.address = address;
        this.parents_mobile = parents_mobile;
        this.district = district;
        this.mother_name = mother_name;
        this.doa = doa;
        this.hostel = hostel;
        this.img_url = img_url;
    }
}
