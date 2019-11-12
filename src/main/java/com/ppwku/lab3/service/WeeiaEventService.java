package com.ppwku.lab3.service;

import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import com.ppwku.lab3.WeeiaEvent;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class WeeiaEventService {

    public Resource getResource(int year, int month) throws IOException {
        ICalendar calendar = new ICalendar();
        String url = "http://www.weeia.p.lodz.pl/pliki_strony_kontroler/kalendarz.php?rok=" + year +"&miesiac="+ month +"&lang=1";
        String websiteContent = getWebsiteHTML(url);

        List<WeeiaEvent> events = getWeeiaEvents(websiteContent);

        for(WeeiaEvent wEvent: events){
            VEvent event = new VEvent();
            event.setSummary(wEvent.getEventName());
            Date eventDate = new GregorianCalendar(year,month-1, Integer.valueOf(wEvent.getEventDay())).getTime();
            event.setDateStart(eventDate);
            event.setDateEnd(eventDate);
            calendar.addEvent(event);
        }
        File calendarFile = new File(month + ".ics");
        Biweekly.write(calendar).go(calendarFile);
        return new FileSystemResource(calendarFile);
    }

    public  List<WeeiaEvent> getWeeiaEvents(String websiteContent){
        String[] splitted = websiteContent.split("href=\"javascript:void\\(\\);\">");
        List<String> eventsCalendar = new ArrayList<String>();

        for (String s : splitted) {
            if (s.contains("<div class=\"calendar-text\"><div class=\"InnerBox\"><p>")) {
                eventsCalendar.add(s);
            }
        }

        List<WeeiaEvent> readyEvents = new ArrayList<WeeiaEvent>();
        for(String event: eventsCalendar){
            String[] splittedEvent = event.split("</a>|<p>|</p>");
            readyEvents.add(new WeeiaEvent(fixStringFormat(splittedEvent[2]),splittedEvent[0]));
        }
        return readyEvents;
    }

    public static String getWebsiteHTML(String website){
        try {
            URL url = new URL(website);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            String returnString = " ";

            while ((inputLine = in.readLine()) != null)
                returnString += inputLine;
            in.close();

            return returnString;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return " ";
    }

    public String fixStringFormat(String str) {
        str = str.replaceAll("&oacute;", "ó");
        str = str.replaceAll("&Oacute;", "Ó");
        return str;
    }

}
