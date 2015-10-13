<?php
require('connect.php');
$Id='';
function ServiceName()
{
 $myData =mysql_query (  "SELECT * FROM Services");  
                    
while($record = mysql_fetch_array($myData))
    {
        echo("</option><option value = ".$record['Name']." ". $record['Service'].">".$record['Name']." ". $record['Service']."</option>");
     }
}
if(isset($_POST['submit1']))
    {
$Rating = $_POST['Rate'];
$Name = $_POST['Services'];
$Comment = $_POST['Message'];

   if(($Name=='Services')||($Rating=='Ratings'))
                             {
                              echo "<script type='text/javascript'>alert('Please select your choices');</script>";
                             
                             }
                             else
                             {
$myData =mysql_query (  "SELECT * FROM Services");  
                    
                    while($record = mysql_fetch_array($myData))
                    {
                        
                        if($Name == $record['Name'])
                            { 
                            $Id = $record['Id'];
                           
                             mysql_query("INSERT INTO ServiceRating(Id,Service,Rating)"
                            . "VALUES('$Id','$Name','$Rating')");
                          }
                       
                    }
                       

                        mysql_query("INSERT INTO ServiceComment(Id,ServiceComment)"."VALUES('$Id','$Comment')");
                        mysql_query("INSERT INTO ServiceAvgRating(Id,avgRating)"."VALUES('$Id','$Rating')");
                          echo "<script type='text/javascript'>alert('Service Rated Successfully');</script>";
                       // header("location:Ratings.php");
                             }
}
if(isset($_POST['submit2']))
{
    header('Location:Ratings.php');
}

?>
<html>
 <head >
        
        <center> <img src="\sabin\picture\header.jpg" alt= " Image not found" style="height:125px;width:906px;margin:0;padding:0"></center>
</head>

<style>


    #box2
    {
        height:400px;
        width:750px;
        background-color:#006666;
        margin:auto;
      
     
        
    }
    #box2a
    {
        height :366px;
        width:250px;
        float:left;
        background-color:#006666;
        font-size:20px;
        color:white;
        
    }
        #box2b
    {
        height :366px;
        width:250px;
        float:left;
        background-color:#006666;
    }
          #box2c
    {
        height :366px;
        width:250px;
        float:right;
        background-color:#006666;
    }

</style>
<body style="background-color:#cccccc"> <br><br>
           
        
             
               
            
             <div id='box2'>
                 <br>
                 <center> <label style="color:yellow;font-size:30px; ">Rate Service </label><br></center>
                  <form method="post">
                 <div id='box2a'>
                <br> <br> <label style="margin-left:125px">Service </label><br>
                   <br> <br> <label style="margin-left:125px">Ratings </label><br>
                 <br> <br> <label style="margin-left:125px">Comment </label><br><br>
                 </div>
                 
                  <div id='box2b'>
                      <br><br>
                <select style='height:30px; width:200px;' name ='Services'>
                        <option style='height:30px; width:200px;' value="Services">Services</option>
                        <?ServiceName()?> 
                            
                    </select><br>
                      <br><br>
      
                      
                 <select style='height:30px; width:200px;' name='Rate'>
                 <option value="Ratings">Ratings</option>  
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                 </select><br><br>
                <textarea name='Message' style="width:400px;height:150px;float:left"> </textarea>
                     
                  </div>
                   <div id="box2c">
                       <br>
                       <br>
                   <input style='width:150px;height:50px;background-color:blue;float:right;margin-right:30px;color:white;' name='submit1' type='submit' value="Submit">
                        
                 
                       <br>
                       <br>
                       <br>
                       
                    <input  style='width:150px;height:50px;background-color:blue;float:right;margin-right:30px;color:white;' name='submit2'type='submit' value='Back'>
                       
                     
                 </div>
                        </form>
             </div>
           
           
</html>

                       
       
                   
                      
                  

        
        
    





