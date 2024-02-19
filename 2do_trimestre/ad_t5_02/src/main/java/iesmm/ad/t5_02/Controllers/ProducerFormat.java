package iesmm.ad.t5_02.Controllers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Spring Controller para definir producciones resultado en diferentes tipos de contenido (content-type)
 */
@Controller
@RequestMapping("/producerformat")
public class ProducerFormat {

    @GetMapping("/excel")
    @ResponseBody
    public void crearHojaCalculo(HttpServletResponse response) throws IOException {
        String fileNameHojaCalculo = "stock.xls";

        // 1. Tipo MIME del mensaje de respuesta
        response.setContentType("application/xls");

        // 2. Cabecera (forzar descarga de fichero)
        response.setHeader("Content-Disposition", "filename=" + fileNameHojaCalculo);

        // 3. Contenido
        PrintWriter out = response.getWriter();
        out.println("Col1\tCol2\tCol3");
        out.println("Val11\tVal12\tVal13");
        out.println("Val21\tVal22\tVal23");
        out.close();
    }

    @GetMapping("/pdf")
    @ResponseBody
    public void crearPDF(HttpServletResponse response) throws IOException, DocumentException {
        String fileNameHojaCalculo = "stock.xls";

        // 1. Tipo MIME del mensaje de respuesta
        response.setContentType("application/pdf");

        // 2. Contenido de formato de página
        Document document = new Document(PageSize.A4);

        // 3. Volcado de datos a página
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        // Texto cabecera
        Paragraph title = new Paragraph("PRODUCTOS");
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);


        // Generación de tabla
        PdfPTable table = new PdfPTable(3); // Número de columnas principales
        table.addCell("Nombre");
        table.addCell("Precio");
        table.addCell("Cantidad");

        for (int i = 0; i < 9; i++) {
            PdfPCell celda = new PdfPCell(new Phrase("*"));
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(celda);
        }

        document.add(table);

        // Cierre documento
        document.close();
    }
}