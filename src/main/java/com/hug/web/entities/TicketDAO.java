package com.hug.web.entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.hug.web.database.Connector;

public class TicketDAO {
    public static Ticket createNewTicket(String name, Date ticketDate, Time ticketTime, String location, String type, Integer userId, Integer eventId, Integer organizerId) {
        Ticket ticket = null;

        String query = "INSERT INTO Ticket (Id, TicketName, TicketDate, TicketTime, Location, TicketType, UserId, EventId, EventOrganizerId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (
            Connection connection = Connector.getConnection(); 
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, UUID.randomUUID().toString());
            statement.setString(2, name);
            statement.setDate(3, ticketDate);
            statement.setTime(4, ticketTime);
            statement.setString(5, location);
            statement.setString(6, type);
            statement.setInt(7, userId);
            statement.setInt(8, eventId);
            statement.setInt(9, organizerId);
            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();

            if (result.next()) {
                ticket = new Ticket(result.getString(1), name, ticketDate, ticketTime, location, type);
            }

            result.close();
            
            return ticket;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Ticket> getTicketsByUserId(Integer id) {
        List<Ticket> tickets = new ArrayList<>();
        
        String query = "SELECT * FROM Ticket WHERE UserId = ?;";
        try (
            Connection connection = Connector.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                tickets.add(
                    new Ticket(
                        result.getString("Id"),
                        result.getString("TicketName"), 
                        result.getDate("TicketDate"), 
                        result.getTime("TicketTime"), 
                        result.getString("Location"), 
                        result.getString("TicketType")
                    )
                );
            }
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return tickets;
    }
}
