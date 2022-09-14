package DatabaseStuff;

import java.sql.Connection;

public class DatabaseAuthorsHandler {
    public static void createAuthorsTable(long serverId) {
        try {
            Connection conn = ServerDatabaseHandler.connect(serverId);
            conn.createStatement().execute("CREATE TABLE IF NOT EXISTS `authors` (\n" +
                    "    `discord_id` BIGINT  NOT NULL ,\n" +
                    "    `author_nickname` varchar(32)  NOT NULL ,\n" +
                    "    PRIMARY KEY (\n" +
                    "        `discord_id`\n" +
                    "    )\n" +
                    ")");
            conn.close();
        }
        catch (Exception e) {
            System.out.println("Error while creating authors table for server " + serverId);
            e.printStackTrace();
        }
    }
}
