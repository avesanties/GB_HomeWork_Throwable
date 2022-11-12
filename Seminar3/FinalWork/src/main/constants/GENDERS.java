package main.constants;

public enum GENDERS {
    MALE("M"), FEMALE("F");

    private String shortName;
     GENDERS(String shortName){
        this.shortName = shortName;
    }

    public String getShortName(){
        return shortName;
    }
}
