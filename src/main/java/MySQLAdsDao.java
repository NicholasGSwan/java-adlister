import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    Connection connection = null;

    public MySQLAdsDao(){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUser(),
                    Config.getPassword()
            );
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public List<Ad> all(Long id){
        String query = "SELECT * FROM ads";
        if(id > 0){
            query+= " WHERE id = " + id;
        }

        List<Ad> ads = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                ads.add(new Ad(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("description")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ads;
    }
    public List<Ad> all(){
        return all(0L);
    }
    @Override
    public Long insert(Ad ad){
        Long id = 0L;
        String query = "INSERT INTO ads (user_id, title, description) VALUES ('"+ ad.getUserId() + "', '"+ ad.getTitle() +"', '" + ad.getDescription() + "')";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
                System.out.println("new id is: "+ id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return id;
    }

}


