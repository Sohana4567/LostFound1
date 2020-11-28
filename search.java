int temp=0;
while (rs.next()) {
 String compareTo = request.getParameter("iname");
String category = request.getParameter("cat");
 Date dt = request.getParameter("dat");
 Date d = rs.getString("LOSTDATE");
        String e = rs.getString("Email");
      String u =rs.getString("USERNAME");
       String pn = request.getParameter("PHONE");
        String adds = rs.getString("ADDRESS");
         String st = rs.getString("STATE");
          String c = rs.getString("COUNTRY");
           String z = rs.getString("ZIPCODE");
           
          String ladd = rs.getString("LOSTADDRESS");
             String det = rs.getString("DETAILS");
out.println(e);
      out.println(u);
      out.println(pn);
      out.println(adds);
      out.println(st);
      out.println(c);
      out.println(z);
      out.println(in);
      out.println(catt);
      out.println(d);
      out.println(t);
      out.println(ladd);
      out.println(det);
      //for printing username concat. random number
SQL Code for the Successful Cases Databse:-
int i;
      i = pst.executeUpdate();
      if(i!=0){
        out.println("<br>Record has been inserted");
      }
      else{
        out.println("failed to insert the data");
        Statement mystmt=con.createStatement();
        String sql="Select * from Successful";
String in = rs.getString("ITEM");
 String catt = rs.getString("CATEGORY");
if(in.equals(compareTo ) && category.equals(catt)&& dat>dt){ 
out.println("Strings matched!!");
  
      out.println(res);
temp=1;
}
if(temp==0)
{
    out.println("No matches found");
}
