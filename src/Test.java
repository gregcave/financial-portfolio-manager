import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class Test {

    private static final Object[][] rowData = {};
    private static final Object[] columnNames = {"Column 1", "Column 2","Column 3"};

    public void testCase() {
        DefaultTableModel listTableModel;
        listTableModel = new DefaultTableModel(rowData, columnNames);
        for (int i = 1; i < 25; i++) {
            String rowString = "Quiz #" + i;
            listTableModel.addRow(new Object[]{rowString, "ICON", "ICON"});
        }

        //listTableModel = new DefaultTableModel(50, 50);

        JTable listTable;
        listTable = new JTable(listTableModel);
        listTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        listTable.setCellEditor(null);
        listTable.setBounds(37, 143, 397, 183);
        ////
        JScrollPane pane = new JScrollPane(listTable);

        JFrame frame = new JFrame();
        //frame.add(listTable);
        /////
        frame.add(pane);
        frame.setVisible(true);
        frame.pack();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Test tester = new Test();
        //tester.testCase();
        Date today = new Date();
        System.out.println(today.toString());
        String todayString = today.toString();
        String[] todayArray = todayString.split(" ");
        System.out.println(todayArray[2] + "-" + todayArray[1] + "-" + todayArray[5] + " " + todayArray[3] + " " + todayArray[4]);

    }
}