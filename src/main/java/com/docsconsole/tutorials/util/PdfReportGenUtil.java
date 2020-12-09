package com.docsconsole.tutorials.util;


import com.lowagie.text.DocumentException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;


public class PdfReportGenUtil {


    public static void generatePdfFromHtml(String pdfDirectory, String html) throws IOException, DocumentException {
        String outputFolder = pdfDirectory + File.separator + "Progress-Report.pdf";
        OutputStream outputStream = new FileOutputStream(outputFolder);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
    }

    public static String parseThymeleafTemplate(Map contentMap) {

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        Context context = new Context();
        context.setVariable("schoolName", contentMap.get("schoolName"));
        context.setVariable("studentName", contentMap.get("studentName"));
        context.setVariable("className", contentMap.get("className"));
        context.setVariable("markLists", contentMap.get("markLists"));

        return templateEngine.process("progress_report_template.html", context);
    }
}