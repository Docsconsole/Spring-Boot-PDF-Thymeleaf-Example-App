package com.docsconsole.tutorials;

import com.docsconsole.tutorials.service.PdfReportGenService;
import com.lowagie.text.DocumentException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class PdfThymeleafExampleApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	PdfReportGenService reportGenService;
	@Test
	void Test_generatePDFReport() throws IOException, DocumentException {
		reportGenService.generatePDFReport();
	}

}
