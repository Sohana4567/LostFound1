void successfulMatch(String u, String u1, String item)
{
pst.setString(1,u);
pst.setString(2,u1);
pst.setString(3,in);
int i;
      i = pst.executeUpdate();
      if(i!=0){
        out.println("<br>Record has been inserted");
      }
        
      else{
        out.println("failed to insert the data");
         }
}
        Statement mystmt=con.createStatement();
        String sql="Select * from Successful";
            myStmt.execute(sql);
