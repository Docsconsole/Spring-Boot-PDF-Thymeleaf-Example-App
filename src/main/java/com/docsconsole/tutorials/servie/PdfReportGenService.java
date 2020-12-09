package com.docsconsole.tutorials.servie;


import com.docsconsole.tutorials.model.Marks;
import com.docsconsole.tutorials.util.PdfReportGenUtil;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@ConfigurationProperties
public class PdfReportGenService {

    @Value("${thymeleaf.pdf.directory}")
    private String pdfDirectory;


    public void generatePDFReport() throws IOException, DocumentException {

        List markLists = new ArrayList();
        Marks marks = new Marks();
        marks.setFirstLang(87l);
        marks.setSecondLang(81l);
        marks.setMathematics(77l);
        marks.setGeneralScience(91l);
        marks.setSocialStudies(77l);
        markLists.add(marks);

        Map contentMap = new HashMap();
        contentMap.put("schoolName", "Docsconsole School Management");
        contentMap.put("studentName", "Amar Sivas");
        contentMap.put("className", "XII");
        contentMap.put("markLists", markLists);
        String htmlString = PdfReportGenUtil.parseThymeleafTemplate(contentMap);
        PdfReportGenUtil.generatePdfFromHtml(pdfDirectory,htmlString);
    }


}