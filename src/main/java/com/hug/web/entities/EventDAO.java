package com.hug.web.entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.hug.web.database.Connector;

public class EventDAO {
    public static Event createNewEvent(String name, String description, Date eventDate, Time eventTime, String location, String eventType, Integer organizerId) {
        Event event = null;

        String query = "INSERT INTO Event (EventName, Description, EventDate, EventTime, Location, EventType, OrganizerId) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try (
            Connection connection = Connector.getConnection(); 
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setDate(3, eventDate);
            statement.setTime(4, eventTime);
            statement.setString(5, location);
            statement.setString(6, eventType);
            statement.setInt(7, organizerId);
            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();

            if (result.next()) {
                event = new Event(result.getInt(1), name, description, eventDate, eventTime, location, eventType);
            }

            result.close();

            return event;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Event> showAll() {
        String query = "SELECT * FROM Event;";
        List<Event>  events = new ArrayList<>();

        try (
            Connection connection = Connector.getConnection(); 
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
        ) {
            while (result.next()) {
                events.add(
                    new Event(result.getInt("Id"),
                    result.getString("EventName"), 
                    result.getString("Description"), 
                    result.getDate("EventDate"), 
                    result.getTime("EventTime"),
                    result.getString("Location"), 
                    result.getString("EventType"))
                );
            }
            result.close();

        } catch (Exception e) {
            e.printStackTrace();
            return events;
        }
        return events;
    }

    public static Integer getEventId(String name) {
        String query = "SELECT Id FROM Event WHERE EventName = ?;";
        try (
            Connection connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                return result.getInt("Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Integer getOrganizerId(String eventName) {
        String query = "SELECT OrganizerId FROM Event WHERE EventName = ?;";
        try (
            Connection connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, eventName);
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                return result.getInt("OrganizerId");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
