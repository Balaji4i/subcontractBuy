package backing;

import Utils.ADFUtils;

import Utils.JSFUtils;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.model.UploadedFile;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import java.sql.SQLException;

import javax.faces.context.FacesContext;

import oracle.jbo.domain.BlobDomain;

import org.apache.commons.io.IOUtils;

public class FileAttachment {
    public FileAttachment() {
        super();
    }

    public static String UploadFileToDB(UploadedFile file, ViewObject vo) {
        String filename = "Test";
        String ContentType = "image/jpeg";
        UploadedFile myfile = file;
        if (myfile != null) {
            filename = myfile.getFilename();
            ContentType = myfile.getContentType();
            System.err.println("attachment file name==" + filename);
            System.err.println("attachment file Content==" + ContentType);
            Row newRow = vo.createRow();
            newRow.setAttribute("FileName", filename);
            newRow.setAttribute("FileType", ContentType);
            newRow.setAttribute("Attachment", createBlobDomain(myfile));
            vo.insertRow(newRow);
        }
        return null;
    }


    public static String TableFileToDB(UploadedFile file, ViewObject vo) {
        String filename = "Test";
        String ContentType = "image/jpeg";
        UploadedFile myfile = file;
        if (myfile != null) {
            
            filename = myfile.getFilename();
            ContentType = myfile.getContentType();
            System.err.println("attachment file name==" + filename);
            System.err.println("attachment file Content==" + ContentType);
            vo.getCurrentRow().setAttribute("FileName", filename);
            vo.getCurrentRow().setAttribute("FileType", ContentType);
            vo.getCurrentRow().setAttribute("Attachment",
                                            createBlobDomain(myfile));
            vo.executeQuery();
        }
        return null;
    }

    private static BlobDomain createBlobDomain(UploadedFile file) {
        InputStream in = null;
        BlobDomain blobDomain = null;
        OutputStream out = null;
        try {
            in = file.getInputStream();
            blobDomain = new BlobDomain();
            out = blobDomain.getBinaryOutputStream();
            IOUtils.copy(in, out);
            //            byte[] buffer = new byte[8192];
            //            int bytesRead = 0;
            //            while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
            //                out.write(buffer, 0, bytesRead);
            //            }
            //
            //
            //            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
        return blobDomain;
    }


    public static void downloadFileListener(FacesContext facesContext,
                                            OutputStream outputStream,
                                            ViewObject vo) {
       
        BlobDomain blob =
            (BlobDomain)vo.getCurrentRow().getAttribute("Attachment");
        try {
            if (blob != null) {
                IOUtils.copy(blob.getInputStream(), outputStream);
                blob.closeInputStream();
                outputStream.flush();
            } else {
                JSFUtils.addFacesErrorMessage("There is no Attachment");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void download(FacesContext facesContext,
                                            OutputStream outputStream,
                                            ViewObject vo) {
      
        Row row = vo.getCurrentRow();
        BlobDomain blob =
            (BlobDomain) row.getAttribute("Attachment");
        try {
            if (blob != null) {
                IOUtils.copy(blob.getInputStream(), outputStream);
                blob.closeInputStream();
                outputStream.flush();
            } else {
                JSFUtils.addFacesErrorMessage("There is no Attachment");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
