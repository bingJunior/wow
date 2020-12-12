package com.bingjunior.myapplication.Modal;

import android.widget.EditText;
import android.widget.Spinner;

public class Skel_MissingPersonForm {

    private static final Skel_MissingPersonForm MissingPersonFormInstance = new Skel_MissingPersonForm();
    public static Skel_MissingPersonForm getInstance() {
        return MissingPersonFormInstance;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private  Skel_MissingPersonForm() {
    }

    String name,fathername,relation,address,gender,DOB,age,heightfrom,heightto,weight,complexion,incidentdetails,
            incidenttime,incidentplace,incidentdate,state,district,policestation,photo,informantname,informantaddress,informantmobile,
            informantlandline,informantemail,informantrelation,anyotherinfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getHeightfrom() {
        return heightfrom;
    }

    public void setHeightfrom(String heightfrom) {
        this.heightfrom = heightfrom;
    }

    public String getHeightto() {
        return heightto;
    }

    public void setHeightto(String heightto) {
        this.heightto = heightto;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getComplexion() {
        return complexion;
    }

    public void setComplexion(String complexion) {
        this.complexion = complexion;
    }

    public String getIncidentdetails() {
        return incidentdetails;
    }

    public void setIncidentdetails(String incidentdetails) {
        this.incidentdetails = incidentdetails;
    }

    public String getIncidenttime() {
        return incidenttime;
    }

    public void setIncidenttime(String incidenttime) {
        this.incidenttime = incidenttime;
    }

    public String getIncidentplace() {
        return incidentplace;
    }

    public void setIncidentplace(String incidentplace) {
        this.incidentplace = incidentplace;
    }

    public String getIncidentdate() {
        return incidentdate;
    }

    public void setIncidentdate(String incidentdate) {
        this.incidentdate = incidentdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPolicestation() {
        return policestation;
    }

    public void setPolicestation(String policestation) {
        this.policestation = policestation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getInformantname() {
        return informantname;
    }

    public void setInformantname(String informantname) {
        this.informantname = informantname;
    }

    public String getInformantaddress() {
        return informantaddress;
    }

    public void setInformantaddress(String informantaddress) {
        this.informantaddress = informantaddress;
    }

    public String getInformantmobile() {
        return informantmobile;
    }

    public void setInformantmobile(String informantmobile) {
        this.informantmobile = informantmobile;
    }

    public String getInformantlandline() {
        return informantlandline;
    }

    public void setInformantlandline(String informantlandline) {
        this.informantlandline = informantlandline;
    }

    public String getInformantemail() {
        return informantemail;
    }

    public void setInformantemail(String informantemail) {
        this.informantemail = informantemail;
    }

    public String getInformantrelation() {
        return informantrelation;
    }

    public void setInformantrelation(String informantrelation) {
        this.informantrelation = informantrelation;
    }

    public String getAnyotherinfo() {
        return anyotherinfo;
    }

    public void setAnyotherinfo(String anyotherinfo) {
        this.anyotherinfo = anyotherinfo;
    }


}
