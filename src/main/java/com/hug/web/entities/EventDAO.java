package com.hug.web.entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import com.hug.web.database.Connector;

public class EventDAO {
    public static Event createNewEvent(String name, String description, Date eventDate, Time eventTime, String location, String eventType, String organizerEmail) {
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
            statement.setInt(7, UserDAO.getUserId(organizerEmail));
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
}
