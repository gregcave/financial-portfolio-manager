/*import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MainJsonToObjectDemo {

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                String jsonUser1 = "{ \"firstName\": \"Stack\", \"lastName\": \"Overflow\"}";
                String jsonUser2 = "{ \"firstName\": \"Pee\", \"lastName\": \"Skillet\"}";
                ObjectMapper mapper = new ObjectMapper();
                User user1 = null;
                User user2 = null;
                try {
                    user1 = mapper.readValue(jsonUser1, User.class);
                    user2 = mapper.readValue(jsonUser2, User.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                List<User> users = new ArrayList<User>();
                users.add(user1);
                users.add(user2);
                UserTableModel model = new UserTableModel(users);
                JTable table = new JTable(model) {
                    @Override
                    public Dimension getPreferredScrollableViewportSize() {
                        return new Dimension(300, 100);
                    }
                };
                JOptionPane.showMessageDialog(null, new JScrollPane(table));
            }
        });
    }
}
*/