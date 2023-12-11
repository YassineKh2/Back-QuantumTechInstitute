package tn.esprit.springproject.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.Etudiant;
import tn.esprit.springproject.Entity.Reclamation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PdfService {
    public byte[] generatePdf(Etudiant e, List<Reclamation> reclamations) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(new PDRectangle(500, 600));
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.newLineAtOffset(200, 520);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 14);
                contentStream.showText("Student Profile");
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(0, 460);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 14);
                contentStream.showText("---------------------------------------------------------------------------------------------------------------------------");
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(10, 430);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 14);
                contentStream.showText("Student Information :");
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(10, 400);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER_BOLD_OBLIQUE), 14);
                contentStream.showText("LastName: ");
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 400);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
                contentStream.showText(e.getNomEt());
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(200, 400);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER_BOLD_OBLIQUE), 14);
                contentStream.showText("FirstName: ");
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(290, 400);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
                contentStream.showText(e.getPrenomEt());
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(10, 370);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER_BOLD_OBLIQUE), 14);
                contentStream.showText("CIN: ");
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 370);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
                contentStream.showText(String.valueOf(e.getCin()));
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(200, 370);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER_BOLD_OBLIQUE), 14);
                contentStream.showText("Date Of Birth: ");
                contentStream.endText();
                contentStream.beginText();
                Date date = e.getDateNaissance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDate = dateFormat.format(date);
                contentStream.newLineAtOffset(330, 370);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
                contentStream.showText(formattedDate);
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(10, 340);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER_BOLD_OBLIQUE), 14);
                contentStream.showText("Email: ");
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 340);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
                contentStream.showText(e.getEmail());
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(200, 340);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER_BOLD_OBLIQUE), 14);
                contentStream.showText("Universite: ");
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(310, 340);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
                contentStream.showText(e.getEcole());
                contentStream.endText();
                contentStream.beginText();
                contentStream.newLineAtOffset(10, 310);
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 14);
                contentStream.showText("Your Reclamation :");
                contentStream.endText();
                int lineNumber = 1;
                for (Reclamation reclamation : reclamations) {
                    contentStream.beginText();
                    contentStream.newLineAtOffset(30, 280 - lineNumber * 30);
                    contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
                    contentStream.showText("Title: " + reclamation.getTitre());
                    contentStream.endText();

                    contentStream.beginText();
                    contentStream.newLineAtOffset(250, 280 - lineNumber * 30);
                    contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
                    contentStream.showText("Message: " + reclamation.getMessage());
                    contentStream.endText();

                    lineNumber++;
                }

            }

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            document.save(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
    }
}
