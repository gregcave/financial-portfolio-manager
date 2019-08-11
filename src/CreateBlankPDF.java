import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class CreateBlankPDF {

        public static void main(String[] args) throws IOException {

            PDDocument document = new PDDocument();

            PDPage my_page = new PDPage();

            document.addPage(my_page);

            PDPageContentStream contentStream = new PDPageContentStream(document, my_page);


            String pattern = "dd-MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            String date = simpleDateFormat.format(new Date());

            User user = User.getUser(User.logged_in_user);
            user.setStocksOwned();
            ArrayList<Stock> stocks = user.getStocksOwned();


            contentStream.beginText();





            contentStream.setFont(PDType1Font.HELVETICA_BOLD_OBLIQUE, 12);
            contentStream.moveTextPositionByAmount(20, 700);



            contentStream.newLineAtOffset(0, -15);

            contentStream.drawString(date);

            contentStream.newLineAtOffset(0, -15);
            contentStream.newLineAtOffset(0, -15);

            contentStream.drawString(user.getUsername()+"'s Stocks:");

            contentStream.newLineAtOffset(0, -15);

            contentStream.newLineAtOffset(0, -15);
            contentStream.newLineAtOffset(0, -15);



            ArrayList<Stock> stocksOwned = user.getStocksOwned();

            for (int i = 0; i < stocksOwned.size(); i++) {
                contentStream.drawString(" Name: ''"+stocksOwned.get(i).getName()+"'' ");
                contentStream.drawString(" Symbol: ''"+stocksOwned.get(i).getSymbol()+"'' ");
                contentStream.drawString(" Owned: ''"+String.valueOf(stocksOwned.get(i).getAmount())+"''  ");
                contentStream.drawString("$"+Stock.realPrice(stocksOwned.get(i).getSymbol()));

                contentStream.newLineAtOffset(0, -15);
                contentStream.newLineAtOffset(0, -15);

            }
            contentStream.newLineAtOffset(0, -15);

            contentStream.drawString("Money: $" + user.getMoney());



                contentStream.newLineAtOffset(10, 400);


                contentStream.endText();

                contentStream.close();





            document.save("src\\"+user.getUsername()+"'s Stocks.pdf");


            document.save("src\\"+user.getUsername()+"'s Stocks.pdf");

            System.out.println("Content added");


            document.close();
        }
    }
