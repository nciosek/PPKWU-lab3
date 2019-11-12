package com.ppwku.lab3;

public class EventWeeia {

    private String eventName;
    private String eventDay;

    EventWeeia(String eventName, String eventDay){
        this.eventDay = eventDay;
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "["+eventDay+" "+eventName+"]";
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDay() {
        return eventDay;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDay(String eventDay) {
        this.eventDay = eventDay;
    }

}
