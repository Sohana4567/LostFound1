package jdbc;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.nio.charset.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import java.lang.*;
/*import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/
/**
*
* @author KIIT
*/
public class Found extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();  
        //try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LastTry</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LastTry at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>"); */
            
            
    
                int n=5;
        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);
        String randomString
            = new String(array, Charset.forName("UTF-8"));
        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();
        // remove all spacial char
        String AlphaNumericString
            = randomString
                .replaceAll("[^A-Za-z0-9]", "");
        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < AlphaNumericString.length(); k++) {
            if (Character.isLetter(AlphaNumericString.charAt(k))
                    && (n > 0)
                || Character.isDigit(AlphaNumericString.charAt(k))
                    && (n > 0)) {
                r.append(AlphaNumericString.charAt(k));
                n--;
            }
        }
        // return the resultant string
        String s1=r.toString();
                //out.println(s1);
            
            
            try{
      String e = request.getParameter("email");// request.getParameter() is used to get the parameter from the website
      String u = request.getParameter("uname");
       String pn = request.getParameter("contact");
        String adds = request.getParameter("foundaddress");
         String st = request.getParameter("state");
          //String c = request.getParameter("city");
           String z = request.getParameter("zip");
            String in = request.getParameter("iname");
             String d = request.getParameter("dat");
             String t = request.getParameter("found-time");
             //String ladd = request.getParameter("laddress");
             String det = request.getParameter("subject");
              String catt = request.getParameter("cat");
              String res= u+s1;
      
      out.println(e);
      out.println(u);
      out.println(pn);
      out.println(adds);
      out.println(st);
     // out.println(c);
      out.println(z);
      out.println(in);
      out.println(catt);
      out.println(d);
      out.println(t);
      //out.println(ladd);
     out.println(det);
      //for printing username concat. random number
      out.println(res);
          
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/derbyDb","derbySystem","System");
      //PreparedStatement pstmt = con.prepareStatement("insert into testcase(id)", Statement.RETURN_GENERATED_KEYS);  
      PreparedStatement pst = con.prepareStatement("insert into
FOUNDBOARD(username,states,address,zipcode,email,founddate,tim,item,category,details,phone,referid)values(?,?,?,?,?,?,?,?,?,?,?,?,)");
       //PreparedStatement pstm = con.prepareStatement("insert into reference(referid)values(?)");
      //con.prepareStatement("CREATE SEQUENCE idseq MINVALUE 1 START WITH 1 INCREMENT BY 1");
      //con.prepareStatement("INSERT INTO lost (id) VALUES (idseq.nextval)");
      /*
      //pstmt.executeUpdate();  
      pstmt.executeUpdate();
      ResultSet keys = pstmt.getGeneratedKeys();  
      int id=0;
     //keys.next();
     try{
      while(keys.next())
      {
      id = keys.getInt(1);
      }
     }
      finally {
        if (keys != null) {
            keys.close();
        }
              }
       out.println(id);*/
       /*try
      {
     ResultSet rs;
             rs = pst.executeQuery("Select id from testcase ");
             request.setAttribute(id,rs);
            // String id = request.getAttribute("id");
                
            
      catch(Exception ex)
      {
                e.printStackTrace();
      }
      }*/
      //pst.setInt(1,id);
      pst.setString(1,u);// setString()-To update the database
      pst.setString(2,adds);
      pst.setString(3,st);
      //pst.setString(4,c);
      pst.setString(4,z);
      pst.setString(5,e);
      pst.setString(6,d);
      pst.setString(7,t);
      pst.setString(8,in);
      pst.setString(9,catt);
      pst.setString(10,det);
      //pst.setString(11,ladd);
      pst.setString(11,pn);
      pst.setString(12, res);
      int i;
      i = pst.executeUpdate();
      if(i!=0){
        out.println("<br>Record has been inserted");
      }
      else{
        out.println("failed to insert the data");
      }
      /*int j;
      j = pst.executeUpdate();
      if(j!=0){
        out.println("<br>Record has been inserted");
      }
      else{
        out.println("failed to insert the data");
      }*/
      
      
      
    }
    catch (Exception e){
      out.println(e);
    }
            
        }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        
        
        
        processRequest(request, response);
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
  /*  @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
} */
}
