package com.catalift.android.Model;

public class Explore {
    private int pic;
    private String rating,department,name,years,position,review,description,compatability;

    public Explore(int pic, String rating, String department, String name, String years, String position, String review, String description, String compatability) {
        this.pic = pic;
        this.rating = rating;
        this.department = department;
        this.name = name;
        this.years = years;
        this.position = position;
        this.review = review;
        this.description = description;
        this.compatability = compatability;
    }

    public int getPic() {
        return pic;
    }

    public String getRating() {
        return rating;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public String getYears() {
        return years;
    }

    public String getPosition() {
        return position;
    }

    public String getReview() {
        return review;
    }

    public String getDescription() {
        return description;
    }

    public String getCompatability() {
        return compatability;
    }
}
